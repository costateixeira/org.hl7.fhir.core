<#
.SYNOPSIS
  Builds the FHIR Validator CLI, starts it as an HTTP server, and runs
  smoke checks against the GITB-faithful /itb/* endpoints.

.DESCRIPTION
  Steps:
    1. mvn package -DskipTests --projects org.hl7.fhir.validation.cli --also-make
    2. Copy the built jar to ./validator_cli.jar
    3. Start "java -jar validator_cli.jar http-api -port <port> -version <ver>" in the background
    4. Poll until the server answers
    5. Hit each /itb/* endpoint and print PASS/FAIL
    6. Stop the server

.PARAMETER Port
  Port the validator listens on. Default 8080.

.PARAMETER FhirVersion
  FHIR version flag for the validator (4.0, 4.3, 5.0, ...). Default 4.0.

.PARAMETER SkipBuild
  Reuse the existing ./validator_cli.jar instead of rebuilding.

.PARAMETER SkipServer
  Assume the server is already running on -Port; skip start/stop.

.PARAMETER LoadIG
  Run the loadIG smoke check. Off by default because it pulls a 50+MB package
  on first call.

.EXAMPLE
  .\smoke-test-itb.ps1
  # full build + smoke

.EXAMPLE
  .\smoke-test-itb.ps1 -SkipBuild -LoadIG
  # reuse existing jar, also exercise IGManager.loadIG (Belgian Core)
#>
param(
  [int]    $Port = 8080,
  [string] $FhirVersion = "4.0",
  [switch] $SkipBuild,
  [switch] $SkipServer,
  [switch] $LoadIG
)

$ErrorActionPreference = "Stop"
Set-Location -Path $PSScriptRoot

$BaseUrl = "http://localhost:$Port"
$Jar     = "validator_cli.jar"

# -- helpers ---------------------------------------------------------------

$pass = 0; $fail = 0
function Step($desc, [scriptblock]$check) {
  Write-Host -NoNewline ("  {0,-50} " -f $desc)
  try {
    & $check | Out-Null
    Write-Host "PASS" -ForegroundColor Green
    $script:pass++
  } catch {
    Write-Host "FAIL" -ForegroundColor Red
    Write-Host ("    " + $_.Exception.Message) -ForegroundColor DarkGray
    $script:fail++
  }
}

function Assert($cond, $msg) {
  if (-not $cond) { throw $msg }
}

function PostJson($path, $body) {
  $uri = $BaseUrl + $path
  return Invoke-RestMethod -Method Post -Uri $uri -ContentType "application/json" -Body $body
}

function GetJson($path) {
  $uri = $BaseUrl + $path
  return Invoke-RestMethod -Method Get -Uri $uri
}

# -- 1. build -------------------------------------------------------------

if (-not $SkipBuild) {
  Write-Host "Building validator_cli ..." -ForegroundColor Cyan
  & mvn package -DskipTests --projects org.hl7.fhir.validation.cli --also-make --no-transfer-progress -q
  if ($LASTEXITCODE -ne 0) { throw "mvn build failed (exit $LASTEXITCODE)" }
  $built = Get-ChildItem "org.hl7.fhir.validation.cli\target\org.hl7.fhir.validation.cli-*-SNAPSHOT.jar" |
    Where-Object { $_.Name -notlike "*tests*" } |
    Sort-Object LastWriteTime -Descending | Select-Object -First 1
  if (-not $built) { throw "No CLI snapshot jar found in org.hl7.fhir.validation.cli\target\" }
  Copy-Item $built.FullName -Destination $Jar -Force
  Write-Host ("  Copied {0} -> {1}" -f $built.Name, $Jar)
} else {
  Write-Host "Skipping build (-SkipBuild). Using existing $Jar." -ForegroundColor Yellow
  if (-not (Test-Path $Jar)) { throw "$Jar not found and -SkipBuild was set." }
}

# -- 2. start server ------------------------------------------------------

$proc = $null
if (-not $SkipServer) {
  Write-Host "Starting validator server on port $Port (FHIR $FhirVersion) ..." -ForegroundColor Cyan
  $proc = Start-Process -FilePath "java" `
    -ArgumentList @("-jar", $Jar, "http-api", "-port", $Port, "-version", $FhirVersion) `
    -PassThru -WindowStyle Hidden -RedirectStandardOutput "smoke-validator.log" -RedirectStandardError "smoke-validator.err.log"
  Write-Host ("  PID {0}, logs: smoke-validator.log / .err.log" -f $proc.Id)

  Write-Host "Waiting for server to answer ..." -NoNewline
  $deadline = (Get-Date).AddSeconds(120)
  $ready = $false
  while ((Get-Date) -lt $deadline) {
    try {
      $r = Invoke-WebRequest -Uri "$BaseUrl/itb/fhir/getModuleDefinition" -Method Get -UseBasicParsing -TimeoutSec 2
      if ($r.StatusCode -eq 200) { $ready = $true; break }
    } catch { Start-Sleep -Milliseconds 500 }
  }
  if (-not $ready) {
    Write-Host " TIMED OUT" -ForegroundColor Red
    if ($proc -and -not $proc.HasExited) { Stop-Process -Id $proc.Id -Force }
    throw "Server did not become ready within 120s"
  }
  Write-Host " OK" -ForegroundColor Green
} else {
  Write-Host "Skipping server start (-SkipServer). Assuming server at $BaseUrl." -ForegroundColor Yellow
}

# -- 3. smoke checks ------------------------------------------------------

try {
  Write-Host ""
  Write-Host "Service definitions" -ForegroundColor Cyan

  foreach ($svc in @("fhir","matchetype","fhirpathAssertion","fhirpath","testdata","validationResults","igmanager")) {
    Step "$svc /getModuleDefinition" {
      $r = GetJson "/itb/$svc/getModuleDefinition"
      Assert ($null -ne $r.module) "no module in response"
      Assert ($null -ne $r.module.id) "no module.id"
    }
  }

  Write-Host ""
  Write-Host "Validation services" -ForegroundColor Cyan

  $patient = '{"resourceType":"Patient","name":[{"family":"Smith"}]}'

  Step "FHIRValidator validate (clean Patient)" {
    $body = @{
      input = @(
        @{ name = "contentToValidate"; value = $patient; embeddingMethod = "STRING" }
      )
    } | ConvertTo-Json -Depth 10 -Compress
    $r = PostJson "/itb/fhir/validate" $body
    Assert ($null -ne $r.report) "no report in response"
    Assert ($r.report.result -in @("SUCCESS","WARNING","FAILURE","UNDEFINED")) ("unexpected result: " + $r.report.result)
  }

  Step "FHIRPathAssertion validate (true expression)" {
    $body = @{
      input = @(
        @{ name = "contentToValidate"; value = $patient; embeddingMethod = "STRING" },
        @{ name = "expression";        value = "Patient.name.family.exists()"; embeddingMethod = "STRING" }
      )
    } | ConvertTo-Json -Depth 10 -Compress
    $r = PostJson "/itb/fhirpathAssertion/validate" $body
    Assert ($r.report.result -eq "SUCCESS") ("expected SUCCESS, got " + $r.report.result)
  }

  Step "FHIRPathAssertion validate (false expression -> FAILURE)" {
    $body = @{
      input = @(
        @{ name = "contentToValidate"; value = $patient; embeddingMethod = "STRING" },
        @{ name = "expression";        value = "Patient.id = 'definitely-not-there'"; embeddingMethod = "STRING" }
      )
    } | ConvertTo-Json -Depth 10 -Compress
    $r = PostJson "/itb/fhirpathAssertion/validate" $body
    Assert ($r.report.result -eq "FAILURE") ("expected FAILURE, got " + $r.report.result)
  }

  Write-Host ""
  Write-Host "Processing services" -ForegroundColor Cyan

  Step "FHIRPathProcessor evaluate (extract family)" {
    $body = @{
      operation = "evaluate"
      input = @(
        @{ name = "content";    value = $patient; embeddingMethod = "STRING" },
        @{ name = "expression"; value = "Patient.name.family"; embeddingMethod = "STRING" }
      )
    } | ConvertTo-Json -Depth 10 -Compress
    $r = PostJson "/itb/fhirpath/process" $body
    Assert ($r.output -and $r.output.Count -gt 0) "no output"
    $resultEntry = $r.output | Where-Object { $_.name -eq "result" } | Select-Object -First 1
    Assert ($null -ne $resultEntry) "no 'result' AnyContent in output"
    Assert ($resultEntry.value -eq "Smith") ("expected 'Smith', got '" + $resultEntry.value + "'")
  }

  Step "ValidationResultsProcessor summarize" {
    $outcome = '{"resourceType":"OperationOutcome","issue":[{"severity":"error","code":"invalid"},{"severity":"warning","code":"informational"}]}'
    $body = @{
      operation = "summarize"
      input = @( @{ name = "outcome"; value = $outcome; embeddingMethod = "STRING" } )
    } | ConvertTo-Json -Depth 10 -Compress
    $r = PostJson "/itb/validationResults/process" $body
    $errors = ($r.output | Where-Object { $_.name -eq "errors" }).value
    $warns  = ($r.output | Where-Object { $_.name -eq "warnings" }).value
    Assert ($errors -eq "1") ("errors: expected 1, got " + $errors)
    Assert ($warns  -eq "1") ("warnings: expected 1, got " + $warns)
  }

  Step "TestDataGenerator getModuleDefinition (smoke only — generate needs a profile)" {
    $r = GetJson "/itb/testdata/getModuleDefinition"
    Assert ($r.module.id -eq "TestDataGenerator") "wrong module id"
  }

  Write-Host ""
  Write-Host "Lifecycle" -ForegroundColor Cyan

  Step "FHIRPathProcessor beginTransaction" {
    $r = Invoke-RestMethod -Method Post -Uri "$BaseUrl/itb/fhirpath/beginTransaction" -ContentType "application/json" -Body "{}"
    Assert ($r.sessionId) "no sessionId"
  }

  Step "FHIRPathProcessor endTransaction (204)" {
    $r = Invoke-WebRequest -Method Post -Uri "$BaseUrl/itb/fhirpath/endTransaction" -ContentType "application/json" -Body "{}" -UseBasicParsing
    Assert ($r.StatusCode -eq 204) ("expected 204, got " + $r.StatusCode)
  }

  if ($LoadIG) {
    Write-Host ""
    Write-Host "IGManager (-LoadIG)" -ForegroundColor Cyan
    Step "IGManager loadIG hl7.fhir.be.core#2.1.2 (slow on first run)" {
      $body = @{
        operation = "loadIG"
        input = @( @{ name = "ig"; value = "hl7.fhir.be.core#2.1.2"; embeddingMethod = "STRING" } )
      } | ConvertTo-Json -Depth 10 -Compress
      $r = PostJson "/itb/igmanager/process" $body
      $loaded = ($r.output | Where-Object { $_.name -eq "loaded" }).value
      Assert ($loaded -like "hl7.fhir.be.core*") ("loaded: " + $loaded)
    }
  } else {
    Write-Host ""
    Write-Host "(skipping IGManager loadIG; pass -LoadIG to include it)" -ForegroundColor DarkGray
  }

  Write-Host ""
  Write-Host ("Result: PASS={0}  FAIL={1}" -f $pass, $fail) -ForegroundColor (@{0=$true;1=$false}[($fail -eq 0)] | ForEach-Object { if ($_) { "Green" } else { "Red" } })

} finally {
  if (-not $SkipServer -and $proc -and -not $proc.HasExited) {
    Write-Host ""
    Write-Host "Stopping server (PID $($proc.Id)) ..."
    try { Stop-Process -Id $proc.Id -Force } catch {}
  }
}

if ($fail -gt 0) { exit 1 } else { exit 0 }
