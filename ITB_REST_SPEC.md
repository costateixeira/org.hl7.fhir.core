# FHIR Validator — GITB REST Services Specification

**Status**: Draft for review
**Target contract**: [gitb-types](https://github.com/ISAITB/gitb-types) `development` branch
 — `rest/gitb_vs.json` (validation service) and `rest/gitb_ps.json` (processing service).
**Scope**: Complete refactor of the existing `Gitb*Handler` classes in
`org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/http/` to be
spec-compliant with the GITB REST contracts.

---

## 1. TL;DR

The FHIR Validator exposes **seven GITB-compliant REST services** at a single
HTTP endpoint, split across the two GITB REST contracts. One operator
deploys the validator as a long-running HTTP server; IGs loaded into the
process memory persist for the life of the server.

| Service | Contract | Path prefix | Purpose |
|---|---|---|---|
| `FHIRValidator` | validation | `/validator` | Validate a FHIR resource against profiles/IGs |
| `MatchetypeValidator` | validation | `/matchetype` | Compare a resource against an expected pattern |
| `FHIRPathAssertion` | validation | `/fhirpath-assert` | Evaluate a boolean FHIRPath invariant |
| `FHIRPathProcessor` | processing | `/fhirpath` | Evaluate any FHIRPath expression, return result |
| `TestDataGenerator` | processing | `/testdata` | Synthesise resources from a profile |
| `ValidationResultsProcessor` | processing | `/validation-results` | Filter / summarise a prior `OperationOutcome` |
| `IGManager` | processing | `/igmanager` | Load and list IG packages at runtime |

Plus one non-GITB affordance:

| Path | Purpose |
|---|---|
| `GET /openapi.json` | Unified OpenAPI overlay describing all seven services with FHIR-specific input/config names and examples |

---

## 2. Common conventions

### 2.1 Base URL

All services are hosted under a single origin, e.g.
`http://localhost:8080/api`. Each service's operations are mounted at
`<origin>/<path-prefix>/<operation>` per its contract.

### 2.2 Wire format

All requests and responses are `application/json`. Nothing SOAP.

### 2.3 GITB headers

Every call (validation or processing) MAY include the five optional GITB
headers. The FHIR validator reads them for logging and context; it does
not invoke callbacks, so `Gitb-Reply-To` is recorded but never used.

| Header | Purpose |
|---|---|
| `Gitb-Reply-To` | Test engine callback root (not used, logged only) |
| `Gitb-Test-Session-Identifier` | Test session id — logged, echoed into TAR `overview.note` |
| `Gitb-Test-Case-Identifier` | Test case id — logged |
| `Gitb-Test-Step-Identifier` | Test step id — logged |
| `Gitb-Test-Engine-Version` | Test engine version — logged |

### 2.4 `AnyContent` usage

Every named input and output uses the `AnyContent` wrapper:

```json
{
  "name": "contentToValidate",
  "value": "<payload>",
  "embeddingMethod": "STRING" | "BASE_64" | "URI",
  "type": "string",
  "mimeType": "application/fhir+json",
  "encoding": "UTF-8"
}
```

- `STRING` — `value` is the raw content (JSON / XML / FHIRPath expression / URL / IG id, etc.).
- `BASE_64` — `value` is base64 of the bytes (use for binary or very-large content).
- `URI` — `value` is a URL the server SHALL fetch.

When a caller sends `embeddingMethod: URI`, the server fetches the URL
with the following sanitization rules (SSRF-hardened):

- **Scheme allowlist**: only `http` and `https`. All others (`file`,
  `ftp`, `gopher`, `ssh`, `jar`, `data`, …) are rejected with a 400.
- **Private-address denylist**: the hostname is DNS-resolved before
  fetch, and the resulting IP is checked against:
  - Loopback: `127.0.0.0/8`, `::1`
  - Link-local: `169.254.0.0/16`, `fe80::/10`
  - Private ranges: `10.0.0.0/8`, `172.16.0.0/12`, `192.168.0.0/16`,
    `fc00::/7`
  - Multicast / unspecified: `0.0.0.0/8`, `224.0.0.0/4`, `::/128`

  Any match is rejected with a 400. The resolved IP is also used for
  the actual connection (no re-resolution), preventing DNS rebinding.
- **Redirects**: followed up to 5 hops. Each hop is re-validated by the
  same allowlist/denylist rules; a redirect to a private address aborts
  the fetch.
- **No credential forwarding**: cookies, `Authorization`, and caller
  headers are never forwarded.
- **Size cap**: 30 MB. Response is truncated and the fetch fails if the
  server declares a larger `Content-Length` or streams past the cap.
- **Timeouts**: 10 s connect, 60 s total read.
- **Deployment kill-switch**: the `-disable-uri-fetch` CLI flag disables
  `embeddingMethod: URI` entirely. Hardened deployments can require
  `STRING` or `BASE_64` only.

The resolution result (final URL, HTTP status, content length, elapsed
time) is recorded in the TAR `context` under a `fetchInfo` sub-item.

### 2.5 `Configuration` usage

`Configuration` is `{ name, value }` — string-valued only. Multiple entries
with the same `name` MAY appear (repeated values, e.g. multiple profile
URLs, multiple IG references). Order is preserved and meaningful where
noted.

### 2.6 Errors

| Situation | HTTP | Body |
|---|---|---|
| Malformed JSON request | 400 | `{ "error": "…" }` |
| Missing required input/config | 400 | `{ "error": "Missing required input: <name>" }` |
| Unknown operation (processing) | 400 | `{ "error": "Unknown operation: <op>. Supported: <list>" }` |
| Unsupported `embeddingMethod` content (e.g. bad base64) | 400 | `{ "error": "…" }` |
| Validation engine failure (IG load failure, parse error) | 200 with TAR `result: FAILURE` and a `ReportItem` carrying the error — **not** a 5xx |
| Unrecoverable server error | 500 | `{ "error": "Internal server error" }` |

HTTP 5xx is reserved for genuine server bugs. Domain-level failures (IG
not found, resource unparseable) return 200 with a TAR that explains what
happened — consistent with GITB semantics and with how test engines
process results.

### 2.7 `GET /getModuleDefinition`

Every service exposes `GET /<path-prefix>/getModuleDefinition`. The
response shape follows the GITB schemas (`ValidationModule` or
`ProcessingModule`) and is used both for human documentation and for
ITB auto-discovery when a test service is registered with an API root.

### 2.8 OperationOutcome → TAR mapping

Validation services produce a TAR. Mapping from FHIR `OperationOutcome`
to `TAR`:

| OperationOutcome field | TAR field |
|---|---|
| `issue[*].severity = fatal \| error` | `items[].level = ERROR`, increments `counters.nrOfErrors` |
| `issue[*].severity = warning` | `items[].level = WARNING`, increments `counters.nrOfWarnings` |
| `issue[*].severity = information` | `items[].level = INFO`, increments `counters.nrOfAssertions` |
| `issue[*].details.text` | `items[].description` |
| `issue[*].expression[*]` joined with `; ` (fallback: `issue[*].location[*]` joined with `; `) | `items[].location` |
| `issue[*].code` | `items[].type` |
| `issue[*].diagnostics` | `items[].value` (when non-null) |
| Rule/invariant id (from extension) | `items[].assertionID` |

TAR `result` is derived from counters and the caller's severity
threshold (see `failOn` in §3.1). With the default threshold
(`failOn = error`):

```
errors   > 0                           → FAILURE
errors  == 0 AND warnings  > 0         → WARNING
errors  == 0 AND warnings == 0         → SUCCESS
engine threw before producing outcome  → UNDEFINED
```

With `failOn = warning` the threshold shifts: any warning flips the
result to `FAILURE` (no intermediate `WARNING`). With
`failOn = information` any issue at all fails the step. See §3.1 for the
full table.

The raw `OperationOutcome` JSON is attached as the TAR `context`:

```json
"context": {
  "name": "operationOutcome",
  "value": "<OperationOutcome JSON>",
  "embeddingMethod": "STRING",
  "mimeType": "application/fhir+json"
}
```

TAR `overview` carries service name + version + the session id received
in headers. TAR `date` is the server UTC timestamp. TAR `id` is a fresh
UUID per call (distinct from `sessionId`).

---

## 3. Validation services

### 3.1 `FHIRValidator`

**Path prefix**: `/validator`
**Endpoints**: `GET /validator/getModuleDefinition`, `POST /validator/validate`

#### Inputs

| Name | Required | Description |
|---|---|---|
| `contentToValidate` | yes | The FHIR resource to validate. `mimeType` MUST be `application/fhir+json` or `application/fhir+xml`. |

#### Configs

| Name | Cardinality | Allowed values | Description |
|---|---|---|---|
| `version` | 0..1 | `4.0`, `4.3`, `5.0`, … | FHIR version; defaults to the engine's configured default. |
| `ig` | 0..n | `package#version` | IG package to ensure is loaded before validation. Idempotent — no-op if already loaded. |
| `profile` | 0..n | canonical URL | Profile(s) to validate the resource against. |
| `bpWarnings` | 0..1 | `Ignore`, `Hint`, `Warning`, `Error` | Best-practice warning level. |
| `resourceIdRule` | 0..1 | `OPTIONAL`, `REQUIRED`, `PROHIBITED` | How to treat the resource `id`. |
| `displayWarnings` | 0..1 | `true`, `false` | Whether to emit display-mismatch warnings for codings. |
| `failOn` | 0..1 | `error`, `warning`, `information` | Severity threshold for TAR `result`. Default `error`. |

#### `failOn` behaviour

`failOn` selects the level at which issues flip the TAR `result` from a
pass to a fail. It is applied **after** `bpWarnings` (which controls the
severity of best-practice rules themselves) — so you can first promote /
demote specific rule classes, then decide what severity fails the step.

| `failOn` | FAILURE when | WARNING when | SUCCESS when |
|---|---|---|---|
| `error` *(default)* | `errors > 0` | `errors == 0 AND warnings > 0` | `errors == 0 AND warnings == 0` |
| `warning` | `errors > 0 OR warnings > 0` | *(never)* | `errors == 0 AND warnings == 0` |
| `information` | any issue at all | *(never)* | no issues at all |

Regardless of `failOn`, the TAR always carries the full `counters`
(`nrOfErrors`, `nrOfWarnings`, `nrOfAssertions`), the full `items[]`,
and the raw `OperationOutcome` in `context`. Callers that want finer
assertions (e.g. "exactly one error mentioning `identifier`") can still
post-process the TAR with `ValidationResultsProcessor` or a
`FHIRPathAssertion` over the context.

#### Example request

```json
POST /api/validator/validate
{
  "sessionId": "abc-123",
  "input": [
    {
      "name": "contentToValidate",
      "value": "{\"resourceType\":\"Patient\",\"id\":\"ex1\",\"name\":[{\"family\":\"Smith\"}]}",
      "embeddingMethod": "STRING",
      "mimeType": "application/fhir+json"
    }
  ],
  "config": [
    { "name": "version",        "value": "4.0" },
    { "name": "ig",             "value": "hl7.fhir.be.core#1.0.0" },
    { "name": "ig",             "value": "hl7.fhir.uv.ips#2.0.0" },
    { "name": "profile",        "value": "http://hl7.fhir.be.core/StructureDefinition/be-patient" },
    { "name": "bpWarnings",     "value": "Warning" }
  ]
}
```

#### Example response (valid resource, one warning)

```json
200 OK
{
  "report": {
    "id": "8c3e2a…",
    "date": "2026-04-23T14:21:09.331Z",
    "result": "WARNING",
    "name": "FHIR validation report",
    "overview": {
      "validationServiceName": "HL7 FHIR Validator",
      "validationServiceVersion": "6.9.6-SNAPSHOT",
      "note": "session=abc-123"
    },
    "counters": { "nrOfAssertions": 0, "nrOfErrors": 0, "nrOfWarnings": 1 },
    "items": [
      {
        "level": "WARNING",
        "type": "code-invalid",
        "description": "Code 'foo' is not in the value set",
        "location": "Patient.identifier.system",
        "assertionID": "ips-pat-1"
      }
    ],
    "context": {
      "name": "operationOutcome",
      "value": "{\"resourceType\":\"OperationOutcome\",\"issue\":[…]}",
      "embeddingMethod": "STRING",
      "mimeType": "application/fhir+json"
    }
  }
}
```

### 3.2 `MatchetypeValidator`

**Path prefix**: `/matchetype`
**Endpoints**: `GET /matchetype/getModuleDefinition`, `POST /matchetype/validate`

#### Inputs

| Name | Required | Description |
|---|---|---|
| `contentToValidate` | yes | Actual resource (stringified FHIR JSON). |
| `matchetype` | yes | Expected pattern (stringified FHIR JSON). |

#### Configs

| Name | Cardinality | Allowed values | Description |
|---|---|---|---|
| `mode` | 0..1 | `complete`, `partial` | Default `complete`. `partial` allows extra fields in the actual resource. |

#### Example request

```json
POST /api/matchetype/validate
{
  "input": [
    { "name": "contentToValidate", "value": "{\"resourceType\":\"Patient\",\"active\":true,\"name\":[{\"family\":\"Smith\",\"given\":[\"Ann\"]}]}", "embeddingMethod": "STRING" },
    { "name": "matchetype",        "value": "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Smith\"}]}", "embeddingMethod": "STRING" }
  ],
  "config": [
    { "name": "mode", "value": "partial" }
  ]
}
```

#### Result semantics

- Exact match (subject to `mode`) → `result: SUCCESS`, no items.
- Mismatch → `result: FAILURE`, one `ReportItem` per mismatching path with `location` pointing at the FHIRPath.

### 3.3 `FHIRPathAssertion`

**Path prefix**: `/fhirpath-assert`
**Endpoints**: `GET /fhirpath-assert/getModuleDefinition`, `POST /fhirpath-assert/validate`

Evaluates a FHIRPath expression that is expected to produce a Boolean
(or a Boolean-equivalent collection per FHIRPath §6.5). The TAR reports
whether the invariant held.

#### Inputs

| Name | Required | Description |
|---|---|---|
| `contentToValidate` | yes | The FHIR resource to evaluate the expression against. |

#### Configs

| Name | Cardinality | Description |
|---|---|---|
| `expression` | 1..1 | The FHIRPath expression. MUST evaluate to a singleton Boolean or an empty collection. |
| `description` | 0..1 | Human-readable description of the invariant being checked. Copied to the TAR's single `ReportItem.description` on failure. |

#### Result semantics

| FHIRPath result | TAR `result` |
|---|---|
| Singleton `true` | `SUCCESS` |
| Singleton `false` | `FAILURE` with one `ReportItem` (`level: ERROR`) |
| Empty collection | `FAILURE` (interpreted as `false` per FHIRPath conditional semantics) |
| Non-boolean singleton | `UNDEFINED` with one `ReportItem` explaining "expression did not evaluate to a Boolean" |
| Parse / engine error | `UNDEFINED` with one `ReportItem` carrying the error message |

#### Example request

```json
POST /api/fhirpath-assert/validate
{
  "input": [
    { "name": "contentToValidate", "value": "{\"resourceType\":\"Patient\",\"name\":[{\"given\":[\"Ann\"]}]}", "embeddingMethod": "STRING" }
  ],
  "config": [
    { "name": "expression",  "value": "Patient.name.given.count() > 0" },
    { "name": "description", "value": "Patient must have at least one given name" }
  ]
}
```

---

## 4. Processing services

All processing services share the four processing endpoints. For the
FHIR validator, `beginTransaction` / `endTransaction` are implemented as
near-no-ops — the validator is stateless beyond loaded IGs, which persist
at the server level.

| Endpoint | Behavior |
|---|---|
| `GET <prefix>/getModuleDefinition` | Returns the service's `ProcessingModule`. |
| `POST <prefix>/beginTransaction` | Returns a fresh UUID as `sessionId`. Config items are recorded for the session but have no effect on stateless services. |
| `POST <prefix>/endTransaction` | Drops any in-memory session state. Returns `204 No Content`. |
| `POST <prefix>/process` | Executes one operation from the module. |

### 4.1 `FHIRPathProcessor`

**Path prefix**: `/fhirpath`
**Operations**: `evaluate`

#### `evaluate`

| Direction | Name | Type | Description |
|---|---|---|---|
| input | `contentToValidate` | string | FHIR resource. |
| input | `expression` | string | FHIRPath expression. |
| output | `result` | string | Single value. For collections: JSON array. For Booleans: `"true"` / `"false"`. |
| output | `resultType` | string | FHIRPath type of the result (`Boolean`, `integer`, `string`, `Quantity`, `collection`, …). |

#### Example

```json
POST /api/fhirpath/process
{
  "operation": "evaluate",
  "input": [
    { "name": "contentToValidate", "value": "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Smith\"}]}", "embeddingMethod": "STRING" },
    { "name": "expression",        "value": "Patient.name.family", "embeddingMethod": "STRING" }
  ]
}
```

```json
200 OK
{
  "report": { "result": "SUCCESS", "counters": { "nrOfAssertions": 1, "nrOfErrors": 0, "nrOfWarnings": 0 }, … },
  "output": [
    { "name": "result",     "value": "Smith",  "embeddingMethod": "STRING" },
    { "name": "resultType", "value": "string", "embeddingMethod": "STRING" }
  ]
}
```

### 4.2 `TestDataGenerator`

**Path prefix**: `/testdata`
**Operations**: `generate`, `generateBundle`

#### `generate`

| Direction | Name | Type | Description |
|---|---|---|---|
| input | `profile` | string | Canonical URL of the `StructureDefinition` to generate against. |
| input | `mappings` | string | Optional JSON array of mapping objects. |
| input | `data` | string | Optional JSON array of data rows. |
| output | `resource` | string | Generated FHIR resource as stringified JSON. |

#### `generateBundle`

Same inputs; wraps the generated resource in a `Bundle`.

### 4.3 `ValidationResultsProcessor`

**Path prefix**: `/validation-results`
**Operations**: `summarize`, `filterBySeverity`, `filterByText`

Operates on a raw `OperationOutcome` passed in by the caller (from any
source — not tied to `FHIRValidator`). The `FHIRValidator.validate`
response already includes counters in the TAR and the raw
`OperationOutcome` in its context, so this service is most useful for
callers that have an `OperationOutcome` from an upstream FHIR server or
a previous test step and want a quick filter/count without parsing it
themselves.

> **Scope note**: the operation catalogue here is the current minimum
> (`summarize`, `filterBySeverity`, `filterByText`). Richer
> OperationOutcome parsing (e.g. grouping by `location`, extracting by
> `assertionID`, re-serialising a filtered outcome) is left for a
> future iteration. The raw `OperationOutcome` is always available in
> `FHIRValidator`'s TAR context, so callers who need capabilities
> beyond this catalogue can parse it themselves while the service
> evolves.

#### `summarize`

| Direction | Name | Type | Description |
|---|---|---|---|
| input | `outcome` | string | `OperationOutcome` as stringified JSON. |
| output | `errors` | string | Error count. |
| output | `warnings` | string | Warning count. |
| output | `information` | string | Information count. |

#### `filterBySeverity`

| Direction | Name | Type | Description |
|---|---|---|---|
| input | `outcome` | string | `OperationOutcome`. |
| input | `severity` | string | `fatal`, `error`, `warning`, `information`. |
| output | `count` | string | Count of issues at that severity. |
| output | `outcome` | string | Filtered `OperationOutcome` containing only matching issues. |

#### `filterByText`

| Direction | Name | Type | Description |
|---|---|---|---|
| input | `outcome` | string | `OperationOutcome`. |
| input | `text` | string | Substring to match against each issue's `details.text`. |
| output | `count` | string | Count of matching issues. |
| output | `outcome` | string | Filtered `OperationOutcome`. |

### 4.4 `IGManager`

**Path prefix**: `/igmanager`
**Operations**: `loadIG`, `listIGs`

#### `loadIG`

Idempotent. If the requested `package#version` is already loaded, the
operation returns quickly with `alreadyLoaded: "true"` and no reload.
Concurrent calls for the same package serialize behind a per-package
lock.

| Direction | Name | Type | Description |
|---|---|---|---|
| input | `ig` | string | `package#version`. `#current` is resolved to the latest build. |
| input | `version` | string | Optional FHIR version override. |
| output | `resolved` | string | Resolved `package#version` (specific version, never `#current`). |
| output | `alreadyLoaded` | string | `"true"` / `"false"`. |
| output | `loadTimeMs` | string | Wall-clock milliseconds the load took (`"0"` when `alreadyLoaded`). |
| output | `resources` | string | Number of `CanonicalResource`s contributed by the package. |

#### `listIGs`

| Direction | Name | Type | Description |
|---|---|---|---|
| output | `igs` | list of nested `AnyContent` | One sub-item per loaded IG, each carrying `{ package, version, resources, loadedAt }`. |

```json
200 OK
{
  "report": { "result": "SUCCESS", … },
  "output": [
    {
      "name": "igs",
      "item": [
        { "name": "ig", "item": [
          { "name": "package",   "value": "hl7.fhir.be.core" },
          { "name": "version",   "value": "1.0.0" },
          { "name": "resources", "value": "47" },
          { "name": "loadedAt",  "value": "2026-04-23T14:12:00Z" }
        ]},
        { "name": "ig", "item": [
          { "name": "package",   "value": "hl7.fhir.uv.ips" },
          { "name": "version",   "value": "2.0.0" },
          { "name": "resources", "value": "186" },
          { "name": "loadedAt",  "value": "2026-04-23T14:12:04Z" }
        ]}
      ]
    }
  ]
}
```

---

## 5. A typical test case

End-to-end flow demonstrating how the services compose through the ITB
test engine. All handlers use `handlerApiType="REST"`.

```xml
<!-- 1. Ensure the needed IGs are loaded on the target validator -->
<process handler="$DOMAIN{igManager}" handlerApiType="REST" operation="loadIG">
  <input name="ig">'hl7.fhir.be.core#1.0.0'</input>
</process>
<process handler="$DOMAIN{igManager}" handlerApiType="REST" operation="loadIG">
  <input name="ig">'hl7.fhir.uv.ips#2.0.0'</input>
</process>

<!-- 2. Generate a resource against a profile -->
<process handler="$DOMAIN{testDataGenerator}" handlerApiType="REST" operation="generate">
  <input name="profile">'http://hl7.fhir.be.core/StructureDefinition/be-patient'</input>
  <output name="resource">$generated</output>
</process>

<!-- 3a. Invariant assertion -->
<verify handler="$DOMAIN{fhirpathAssertion}" handlerApiType="REST">
  <input name="contentToValidate">$generated</input>
  <config name="expression">'Patient.name.given.count() > 0'</config>
</verify>

<!-- 3b. Full structural validation against a different profile -->
<verify handler="$DOMAIN{validator}" handlerApiType="REST">
  <input name="contentToValidate">$generated</input>
  <config name="profile">'http://hl7.org/fhir/uv/ips/StructureDefinition/Patient-uv-ips'</config>
</verify>

<!-- 3c. Strict variant: any warning fails the step -->
<verify handler="$DOMAIN{validator}" handlerApiType="REST" output="$report">
  <input name="contentToValidate">$generated</input>
  <config name="profile">'http://hl7.org/fhir/uv/ips/StructureDefinition/Patient-uv-ips'</config>
  <config name="failOn">'warning'</config>
</verify>

<!-- 3d. Pull the counters and individual item fields out of the TAR -->
<assign to="$errorCount">$report/counters/nrOfErrors</assign>
<assign to="$warnCount">$report/counters/nrOfWarnings</assign>
<assign to="$infoCount">$report/counters/nrOfAssertions</assign>

<!-- 3e. Iterate every issue — each item has level, description, location, type, assertionID -->
<foreach counter="$i" start="0" end="$report/items/size() - 1">
  <log>
    [$report/items[$i]/level] $report/items[$i]/description
    at $report/items[$i]/location
  </log>
</foreach>

<!-- 3f. Or post-process the raw OperationOutcome from the TAR context -->
<process handler="$DOMAIN{validationResultsProcessor}" handlerApiType="REST" operation="filterByText">
  <input name="outcome">$report/context/value</input>
  <input name="text">'identifier'</input>
  <output name="count">$identifierIssueCount</output>
</process>
```

Each validation step produces a TAR. The ITB test engine inspects
`report.result` to mark the step pass/fail and renders `report.items` in
the session log.

Everything needed for downstream parsing is preserved on every call
regardless of `failOn`:

| What you want | Where it is |
|---|---|
| Count of errors | `$report/counters/nrOfErrors` |
| Count of warnings | `$report/counters/nrOfWarnings` |
| Count of informational issues | `$report/counters/nrOfAssertions` |
| Each issue's severity | `$report/items[n]/level` (`ERROR` / `WARNING` / `INFO`) |
| Each issue's message | `$report/items[n]/description` |
| Each issue's location | `$report/items[n]/location` (FHIRPath expression into the resource, semicolon-joined if FHIR reports multiple) |
| Each issue's type (FHIR issue code) | `$report/items[n]/type` |
| Each issue's rule id | `$report/items[n]/assertionID` |
| The original OperationOutcome | `$report/context/value` (FHIR JSON, stringified) |

---

## 6. Operational concerns

### 6.1 Preloading IGs at startup

The existing `-ig` CLI flag on the HTTP mode pre-populates the engine
before any request arrives:

```
java -jar validator_cli.jar http-api -port 8080 -version 4.0 \
  -ig hl7.fhir.be.core#1.0.0 \
  -ig hl7.fhir.uv.ips#2.0.0 \
  -ig hl7.fhir.us.core#6.1.0
```

Test authors SHOULD still emit `IGManager.loadIG` calls in their test
cases — doing so makes the test portable across validator instances and
costs ~1 ms per IG once preloaded.

### 6.2 Memory

Loaded IGs stay in memory for the lifetime of the JVM. `unloadIG` is
intentionally not offered in v1; monitor memory footprint in long-running
deployments and restart if needed. If unload becomes necessary, it can
be added to `IGManager` without a breaking change.

### 6.3 Concurrency

The validator engine is safe for concurrent reads. Package loads are
serialized per-package via `synchronized(packageId)`. `/validate`,
`/process`, and the assertion endpoints are fully concurrent.

### 6.4 Headers

The five GITB headers are parsed and attached to the SLF4J MDC for the
duration of the request, giving structured logs a `testSessionId`,
`testCaseId`, `testStepId` field. Nothing else depends on them.

### 6.5 OpenAPI overlay

A single `GET /openapi.json` serves a combined OpenAPI document derived
from `gitb_vs.json` + `gitb_ps.json`, with paths prefixed per this spec
and with the FHIR-specific input/config catalogue filled in from each
service's `ValidationModule` / `ProcessingModule`.

The upstream contracts stay authoritative — if they change, we
regenerate.

---

## 7. Implementation plan

All changes land on a single branch `itb-rest-alignment` off
`upstream/master`, as a sequence of reviewable commits:

1. **Add GITB type builders and TAR mapper** — `gitb/` sub-package with
   `AnyContent`, `TAR`, `ReportItem`, `Configuration`, `Parameter`,
   `TypedParameter`, `Metadata`, `ValidationModule`, `ProcessingModule`,
   `ProcessingOperation` as plain `JsonObject` builders, plus
   `OperationOutcomeToTarMapper`. No dependency on `gitb-types-jakarta`.
2. **Add the two base handlers** — `GitbValidationServiceHandler`,
   `GitbProcessingServiceHandler`. Each parses the appropriate
   request shape, dispatches to abstract methods, wraps the response.
3. **Port `GitbValidatorHandler`** to the validation contract; move the
   `loadIG` branch out.
4. **Port `GitbFhirPathHandler`, `GitbMatchetypeHandler`,
   `GitbTestDataHandler`, `GitbValidationResultsHandler`** to the new
   processing base.
5. **Add `GitbFhirPathAssertionHandler` and `GitbIgManagerHandler`** —
   new handlers for the two services that don't exist today.
6. **Rewrite `FhirValidatorHttpService` route table** to the new paths.
7. **Rewrite `gitb-openapi.json`** as an overlay of `gitb_vs.json` +
   `gitb_ps.json` with FHIR input/config names and examples.
8. **Delete `GitbServiceHandler`** and any remaining legacy routes.
9. **Add tests** — one integration test per service exercising
   `/getModuleDefinition` + at least one successful and one failing
   call. `OperationOutcome → TAR` mapper gets unit tests for every
   severity branch.

Estimated size: ~2000 LOC added, ~800 LOC removed / modified.

---

## 8. Resolved decisions

| # | Decision | Rationale |
|---|---|---|
| 1 | Keep `ValidationResultsProcessor`. | Useful for callers holding a raw `OperationOutcome` from elsewhere. |
| 2 | Drop `/admin/loadIG`. | Fully covered by `IGManager.loadIG` — no need for a parallel admin path. |
| 3 | `FHIRPathAssertion` empty collection → `FAILURE`. | Matches the expectation of invariant-style expressions (`where(...).exists()`). |
| 4 | `FHIRPathProcessor.evaluate` serialises collections as JSON arrays. | Machine-parseable, preserves element types and values with commas; lossless. |
| 5 | `AnyContent: URI` fetch is SSRF-hardened — see §2.4 for the full policy (scheme allowlist, RFC1918 denylist, no redirects to private IPs, no credential forwarding, 30 MB cap, timeouts, `-disable-uri-fetch` kill-switch). | SSRF is the standard risk for server-side URL fetchers. Full mitigation by default; operators can disable the feature entirely. |
| 6 | Module metadata `version` = validator Maven version (`6.9.6-SNAPSHOT`). | Simple, accurate, one source of truth. Contract version is expressed by the GITB OpenAPI spec's `info.version`. Can be changed later without breaking callers. |

---

## 9. References

- GITB validation service REST contract: `gitb-types-development/gitb-types-specs/src/main/resources/rest/gitb_vs.json`
- GITB processing service REST contract: `gitb-types-development/gitb-types-specs/src/main/resources/rest/gitb_ps.json`
- Current handlers (to be refactored): `org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/http/Gitb*Handler.java`
- ITB REST API (unrelated — admin surface of the ITB itself): `itb-openapi.json`
