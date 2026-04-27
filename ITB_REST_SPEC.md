# FHIR Validator — GITB REST Services Specification

**Status**: Draft, revised post-review (2026-04-27).
**Target contract**: [gitb-types](https://github.com/ISAITB/gitb-types) `development` branch
 — `rest/gitb_vs.json` (validation service) and `rest/gitb_ps.json` (processing service).
**Scope**: Add a new set of GITB-aligned REST handlers in
`org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/http/`,
exposing five services under a unified `/<svc>/{definition,process}`
endpoint shape. The existing flat native HTTP handlers
(`/fhirpath`, `/validateResource`, …) remain.
**Companion**: [gitb-openapi.json](org.hl7.fhir.validation/src/main/resources/org/hl7/fhir/validation/http/gitb-openapi.json)
is the authoritative machine-readable spec; this document is the
narrative/rationale companion. When they disagree, the OpenAPI is the
implementation contract.

---

## 1. TL;DR

The FHIR Validator exposes **five GITB-compliant REST services** at a single
HTTP endpoint, split across the two GITB REST contracts. One operator
deploys the validator as a long-running HTTP server; IGs loaded into the
process memory persist for the life of the server.

| Service | Contract | Path prefix | Operations | Purpose |
|---|---|---|---|---|
| `FHIRValidator` | validation | `/fhir` | `validate`, `loadIG` | Validate a FHIR resource against profiles/IGs; load an IG package |
| `MatchetypeProcessor` | processing | `/matchetype` | `compare` | Compare a resource against an expected pattern |
| `FHIRPathProcessor` | processing | `/fhirpath` | `evaluate`, `assert` | Evaluate any FHIRPath expression, return result; or assert a Boolean invariant |
| `TestDataGenerator` | processing | `/testdata` | `generate`, `generateBundle` | Synthesise resources from a profile |
| `ValidationResultsProcessor` | processing | `/validationResults` | `summarize`, `filterBySeverity`, `filterByText` | Filter / summarise a prior `OperationOutcome` |

Plus one non-GITB affordance:

| Path | Purpose |
|---|---|
| `GET /openapi.json` | Unified OpenAPI overlay describing all five services with FHIR-specific input names and examples |

> **Note on naming.** The path prefix for the FHIR validation service is
> `/fhir` (not `/validator`) — symmetric with `/matchetype`, `/fhirpath`,
> `/testdata`, `/validationResults`. All path segments use lower-camelCase
> for multi-word names (e.g. `validationResults`), matching the convention
> used by ITB built-in service operations (`getModuleDefinition`).

---

## 2. Common conventions

### 2.1 Base URL and endpoint shape

All services are hosted under a single origin, e.g.
`http://localhost:8080/itb`. Each service exposes two endpoints:

| Method | Path | Purpose |
|---|---|---|
| `GET` | `/<service>/definition` | Returns the GITB `ServiceDefinition` (operations, inputs, outputs). |
| `POST` | `/<service>/process` | Executes one operation. Body: `{ "operation": "<name>", "inputs": { … } }`. |

This collapses the contract-specific endpoint shapes (`validate`,
`process`, `beginTransaction`, …) into a single `process` endpoint per
service, with the operation selected by the request body. The
`getModuleDefinition` shape from the upstream GITB REST contracts is
served as `GET /<service>/definition`.

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

### 2.4 Input shape and `AnyContent`

**Inputs** are a flat string-keyed JSON object — no `AnyContent` wrapper:

```json
{
  "operation": "validate",
  "inputs": {
    "content": "<FHIR resource as a string>",
    "contentType": "application/fhir+json",
    "profiles": "http://hl7.org/fhir/StructureDefinition/Patient"
  }
}
```

This is a deliberate simplification of the GITB on-the-wire shape, which
uses `AnyContent` (with `embeddingMethod`, `mimeType`, `encoding`, …) for
both inputs and outputs. The simplification is driven by ITB review
feedback: properties like `mimeType` are ambiguous on inputs (they're
really output-rendering hints), so on the REST surface the validator
takes plain string inputs and any format choice that mattered is exposed
as a separate input (e.g. `contentType` on `FHIRValidator.validate`).
Where format affects how the server interprets the input, the input is
named explicitly, and is optional with a sensible default.

**Outputs** keep the full `AnyContent` shape, but only inside the TAR
report context. See §2.8.

For inputs that need to carry binary content or be fetched from a URL,
the server accepts a `data:` URL or HTTP(S) URL inside the string value
(behavior is opt-in per service); fetched URLs are subject to the
SSRF-hardened policy in §2.4.1.

### 2.4.1 SSRF-hardened URL fetch (when enabled)

When a service accepts a URL as an input value, the server fetches it
with the following sanitization rules:

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
  URL fetching entirely. Hardened deployments require inline content
  only.

The resolution result (final URL, HTTP status, content length, elapsed
time) is recorded in the TAR `context` under a `fetchInfo` AnyContent
item.

### 2.5 `inputs` only — no `configs`

The GITB TDL distinguishes inputs and configs (configs were originally
constants, inputs runtime-supplied). In practice the ITB built-in
service handlers use inputs for everything because inputs are a strict
superset — they can be both runtime-supplied and constant, and callers
don't have to remember the split.

Following ITB review feedback, this validator uses **inputs for
everything**. There is no `configs` block on any service. Multi-valued
parameters (e.g. multiple profile URLs, multiple IGs) are passed as a
single comma-separated string, matching the existing native HTTP
endpoints.

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

### 2.7 `GET /<service>/definition`

Every service exposes `GET /<path-prefix>/definition`. The response is a
GITB `ServiceDefinition`: `{ id, operations[], inputs[], outputs[] }`,
where each input/output is `{ name, type, required }`. The shape is
flatter than the upstream GITB `ValidationModule` / `ProcessingModule`
because the validator unifies validation and processing services behind
a single endpoint shape (§2.1). It is used both for human documentation
and for ITB auto-discovery.

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
threshold (see `failOn` in §3.2). With the default threshold
(`failOn = error`):

```
errors   > 0                           → FAILURE
errors  == 0 AND warnings  > 0         → WARNING
errors  == 0 AND warnings == 0         → SUCCESS
engine threw before producing outcome  → UNDEFINED
```

With `failOn = warning` the threshold shifts: any warning flips the
result to `FAILURE` (no intermediate `WARNING`). With
`failOn = information` any issue at all fails the step. See §3.2 for the
full table.

The TAR `context` is an array of `AnyContent` items. By default it
contains:

```json
"context": [
  {
    "name": "operationOutcome",
    "value": "<OperationOutcome JSON>",
    "embeddingMethod": "STRING",
    "type": "string",
    "mimeType": "application/fhir+json",
    "forContext": true,
    "forReport": true
  },
  {
    "name": "content",
    "value": "<the validated payload, as sent>",
    "embeddingMethod": "STRING",
    "type": "string",
    "mimeType": "application/fhir+json",
    "forContext": true,
    "forReport": true
  }
]
```

The `content` AnyContent is included by default (input
`includeContentInReport`, default `true`). It enables two ITB
behaviours: (1) the original payload is shown next to findings in the
report viewer, and (2) report items can use `location` of the form
`content:<line>:<col>` to anchor to a line of the original payload,
which the ITB inline editor consumes to jump to the exact line. The
plain JSON-path form (e.g. `Patient.name[0].family`) remains valid; the
line-anchored form is used when the validator can resolve a finding to
a line number in the source.

`mimeType`, `forContext` and `forReport` are AnyContent properties used
by the ITB to decide rendering — they are populated by the server
(output direction). When `inputs.includeContentInReport` is `false`,
the `content` AnyContent is omitted from `context`.

TAR `overview` carries service name + version + the session id received
in headers. TAR `date` is the server UTC timestamp. TAR `id` is a fresh
UUID per call (distinct from `sessionId`).

---

## 3. `FHIRValidator`

**Path prefix**: `/fhir`
**Endpoints**: `GET /fhir/definition`, `POST /fhir/process`
**Operations**: `validate`, `loadIG`

> **Why `/fhir` and not `/validator`?** Symmetric with the other path
> prefixes (`/matchetype`, `/fhirpath`, …). Suggested in ITB review.

> **Why is `loadIG` here and not on a separate `IGManager` service?**
> Earlier drafts of this spec carved out an `IGManager`. After review,
> `loadIG` was folded into FHIRValidator since (a) IG load is part of
> setting up validation, (b) it keeps the surface smaller, and (c) the
> openapi overlay already groups them under one service. A future
> revision can add `listIGs` either here or as a separate service if it
> proves useful.

### 3.1 `validate` — inputs

| Name | Required | Description |
|---|---|---|
| `content` | yes | The FHIR resource to validate, as a string in the format declared by `contentType`. |
| `contentType` | no | `application/fhir+json` *(default)*, `application/fhir+xml`, `text/turtle`. Selects the wire format of `content`. |
| `profiles` | no | Comma-separated profile URLs. Multiple profiles are allowed. |
| `bpWarnings` | no | `Ignore`, `Hint`, `Warning`, `Error`. Best-practice warning level. |
| `resourceIdRule` | no | `OPTIONAL`, `REQUIRED`, `PROHIBITED`. How to treat the resource `id`. |
| `displayWarnings` | no | `true`/`false`. Whether to emit display-mismatch warnings for codings. |
| `failOn` | no | `error` *(default)*, `warning`, `information`. Severity threshold for the TAR `result`. |
| `includeContentInReport` | no | `true` *(default)*, `false`. Whether to echo `content` in the TAR `context`. See §2.8. |

> **Why a separate `contentType` instead of an AnyContent `mimeType`?**
> ITB review pointed out that `mimeType` on the GITB AnyContent input is
> ambiguous (it's really an output rendering hint). A separate optional
> `contentType` input removes the ambiguity, defaults to the common case
> (`application/fhir+json`), and keeps the input shape flat (§2.4).

### 3.2 `failOn` behaviour

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
post-process the TAR with `ValidationResultsProcessor` or with a
`FHIRPathProcessor.assert` call over the context.

### 3.3 `validate` — example request

```json
POST /itb/fhir/process
{
  "operation": "validate",
  "inputs": {
    "content":   "{\"resourceType\":\"Patient\",\"id\":\"ex1\",\"name\":[{\"family\":\"Smith\"}]}",
    "contentType": "application/fhir+json",
    "profiles": "http://hl7.fhir.be.core/StructureDefinition/be-patient",
    "bpWarnings": "Warning"
  }
}
```

### 3.4 `validate` — example response (one warning, content echoed)

```json
200 OK
{
  "result": "WARNING",
  "output": {
    "outcome":  "{\"resourceType\":\"OperationOutcome\",\"issue\":[…]}",
    "severity": "warning",
    "errors":   "0",
    "warnings": "1"
  },
  "report": {
    "id": "8c3e2a…",
    "date": "2026-04-27T12:00:00Z",
    "result": "WARNING",
    "counters": { "nrOfAssertions": 0, "nrOfErrors": 0, "nrOfWarnings": 1 },
    "overview": {
      "name": "HL7 FHIR Validator",
      "version": "6.9.8-SNAPSHOT",
      "note": "session=abc-123"
    },
    "items": [
      {
        "level": "WARNING",
        "type": "code-invalid",
        "description": "Code 'foo' is not in the value set",
        "location": "Patient.identifier.system",
        "assertionID": "ips-pat-1"
      }
    ],
    "context": [
      {
        "name": "operationOutcome",
        "value": "{\"resourceType\":\"OperationOutcome\",\"issue\":[…]}",
        "embeddingMethod": "STRING", "type": "string",
        "mimeType": "application/fhir+json",
        "forContext": true, "forReport": true
      },
      {
        "name": "content",
        "value": "{\"resourceType\":\"Patient\",\"id\":\"ex1\",\"name\":[{\"family\":\"Smith\"}]}",
        "embeddingMethod": "STRING", "type": "string",
        "mimeType": "application/fhir+json",
        "forContext": true, "forReport": true
      }
    ]
  }
}
```

The flat `output` echoes summary counts for callers that just want a
quick read; `report` carries the full TAR.

### 3.5 `loadIG`

Pre-loads an IG package so subsequent `validate` calls can resolve its
profiles, value sets, etc. Idempotent — no-op if already loaded.

| Name | Required | Description |
|---|---|---|
| `ig` | yes | `package#version`, e.g. `hl7.fhir.be.core#2.1.2`. `#current` resolves to the latest build. |

Returns a plain `ProcessResponse` (no TAR):

```json
200 OK
{ "result": "SUCCESS", "output": { "loaded": "hl7.fhir.be.core#2.1.2" } }
```

---

## 4. Processing services

All processing services share the same endpoint shape (§2.1):
`GET /<service>/definition`, `POST /<service>/process`.

The `process` body is `{ "operation": "<name>", "inputs": { … } }`.
There is no `beginTransaction` / `endTransaction` — the validator is
stateless beyond loaded IGs, which persist at the server level.

### 4.1 `FHIRPathProcessor`

**Path prefix**: `/fhirpath`
**Operations**: `evaluate`, `assert`

A processor (utility) over FHIRPath. The two operations share the same
inputs — `assert` is a special case of `evaluate` where the expression
is expected to evaluate to a Boolean and the operation reports
`SUCCESS` only when the value is `true`.

> **Why one service, two operations, and not a separate
> `FHIRPathAssertion`?** A previous draft of this spec carved out a
> `FHIRPathAssertion` validation service. Review made the case that
> "assert if true" is a thin wrapper over `evaluate`, and forcing the
> caller to choose between two services adds friction. Folding it into
> `FHIRPathProcessor` as an `assert` operation keeps the surface
> smaller while giving callers exactly the same capability.

#### Inputs (both operations)

| Name | Required | Description |
|---|---|---|
| `content` | yes | FHIR resource (or other FHIRPath context) as stringified JSON. *Renamed from `contentToValidate` per ITB review — this is a processor, not a validator.* |
| `expression` | yes | FHIRPath expression. |

#### `evaluate` — semantics

| FHIRPath result | `result` | `output.result` |
|---|---|---|
| Singleton value | `SUCCESS` | the value as a string (`true`/`false` for Booleans, `"42"` for integers, etc.) |
| Collection | `SUCCESS` | the values, JSON-array-encoded |
| Empty | `SUCCESS` | `""` |
| Parse / engine error | `FAILURE` | (no `result`; `error` carries the message) |

#### `assert` — semantics

| FHIRPath result | `result` | `output.result` |
|---|---|---|
| Singleton `true` | `SUCCESS` | `"true"` |
| Singleton `false` | `FAILURE` | `"false"` |
| Empty collection | `FAILURE` | `"false"` *(per FHIRPath conditional semantics)* |
| Non-Boolean singleton | `FAILURE` | `"<value>"`; `error` notes the type mismatch |
| Parse / engine error | `FAILURE` | (no `result`; `error` carries the message) |

#### Examples

```json
POST /itb/fhirpath/process
{
  "operation": "evaluate",
  "inputs": {
    "content":    "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Smith\"}]}",
    "expression": "Patient.name.family"
  }
}
→ 200 OK
{ "result": "SUCCESS", "output": { "result": "Smith" } }
```

```json
POST /itb/fhirpath/process
{
  "operation": "assert",
  "inputs": {
    "content":    "{\"resourceType\":\"Patient\",\"name\":[{\"given\":[\"Ann\"]}]}",
    "expression": "Patient.name.given.count() > 0"
  }
}
→ 200 OK
{ "result": "SUCCESS", "output": { "result": "true" } }
```

### 4.2 `MatchetypeProcessor`

**Path prefix**: `/matchetype`
**Operations**: `compare`

#### `compare` — inputs

| Name | Required | Description |
|---|---|---|
| `resource` | yes | Actual resource (stringified FHIR JSON). |
| `matchetype` | yes | Expected pattern (stringified FHIR JSON). |
| `mode` | no | `complete` *(default)* or `partial`. `partial` allows extra fields in the actual resource. |

#### Result semantics

- Exact match (subject to `mode`) → `result: SUCCESS`, no items.
- Mismatch → `result: FAILURE`, one item per mismatching path with `location` pointing at the FHIRPath into the actual resource.

#### Example

```json
POST /itb/matchetype/process
{
  "operation": "compare",
  "inputs": {
    "resource":   "{\"resourceType\":\"Patient\",\"active\":true,\"name\":[{\"family\":\"Smith\",\"given\":[\"Ann\"]}]}",
    "matchetype": "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Smith\"}]}",
    "mode":       "partial"
  }
}
```

### 4.3 `TestDataGenerator`

**Path prefix**: `/testdata`
**Operations**: `generate`, `generateBundle`

#### `generate` — inputs/outputs

| Direction | Name | Type | Description |
|---|---|---|---|
| input | `profile` | string | Canonical URL of the `StructureDefinition` to generate against. |
| input | `mappings` | string | Optional JSON array of mapping objects. |
| input | `data` | string | Optional JSON array of data rows. |
| output | `resource` | string | Generated FHIR resource as stringified JSON. |

#### `generateBundle`

Same inputs; wraps the generated resource in a `Bundle`.

### 4.4 `ValidationResultsProcessor`

**Path prefix**: `/validationResults` *(camelCase, per ITB review)*
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

---

## 5. A typical test case

End-to-end flow demonstrating how the services compose through the ITB
test engine. All handlers use `handlerApiType="REST"`.

```xml
<!-- 1. Ensure the needed IGs are loaded on the target validator -->
<process handler="$DOMAIN{fhirValidator}" handlerApiType="REST" operation="loadIG">
  <input name="ig">'hl7.fhir.be.core#1.0.0'</input>
</process>
<process handler="$DOMAIN{fhirValidator}" handlerApiType="REST" operation="loadIG">
  <input name="ig">'hl7.fhir.uv.ips#2.0.0'</input>
</process>

<!-- 2. Generate a resource against a profile -->
<process handler="$DOMAIN{testDataGenerator}" handlerApiType="REST" operation="generate">
  <input name="profile">'http://hl7.fhir.be.core/StructureDefinition/be-patient'</input>
  <output name="resource">$generated</output>
</process>

<!-- 3a. Invariant assertion via FHIRPath assert -->
<process handler="$DOMAIN{fhirpathProcessor}" handlerApiType="REST" operation="assert">
  <input name="content">$generated</input>
  <input name="expression">'Patient.name.given.count() > 0'</input>
</process>

<!-- 3b. Full structural validation against a different profile -->
<verify handler="$DOMAIN{fhirValidator}" handlerApiType="REST" operation="validate">
  <input name="content">$generated</input>
  <input name="profiles">'http://hl7.org/fhir/uv/ips/StructureDefinition/Patient-uv-ips'</input>
</verify>

<!-- 3c. Strict variant: any warning fails the step -->
<verify handler="$DOMAIN{fhirValidator}" handlerApiType="REST" operation="validate" output="$report">
  <input name="content">$generated</input>
  <input name="profiles">'http://hl7.org/fhir/uv/ips/StructureDefinition/Patient-uv-ips'</input>
  <input name="failOn">'warning'</input>
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

<!-- 3f. Reach into the report context for the validated payload or raw OperationOutcome -->
<assign to="$payload">$report/context[name='content']/value</assign>
<assign to="$outcomeJson">$report/context[name='operationOutcome']/value</assign>

<!-- 3g. Or post-process the OperationOutcome via the dedicated service -->
<process handler="$DOMAIN{validationResultsProcessor}" handlerApiType="REST" operation="filterByText">
  <input name="outcome">$outcomeJson</input>
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
| Each issue's location | `$report/items[n]/location` (JSON path or `content:<line>:<col>`) |
| Each issue's type (FHIR issue code) | `$report/items[n]/type` |
| Each issue's rule id | `$report/items[n]/assertionID` |
| The validated payload | `$report/context[name='content']/value` |
| The original OperationOutcome | `$report/context[name='operationOutcome']/value` |

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

Test authors SHOULD still emit `FHIRValidator.loadIG` calls in their
test cases — doing so makes the test portable across validator
instances and costs ~1 ms per IG once preloaded.

### 6.2 Memory

Loaded IGs stay in memory for the lifetime of the JVM. `unloadIG` is
intentionally not offered in v1; monitor memory footprint in
long-running deployments and restart if needed. If unload becomes
necessary, it can be added as a new operation on `FHIRValidator`
without a breaking change.

### 6.3 Concurrency

The validator engine is safe for concurrent reads. Package loads are
serialized per-package via `synchronized(packageId)`. All `process`
endpoints are fully concurrent.

### 6.4 Headers

The five GITB headers are parsed and attached to the SLF4J MDC for the
duration of the request, giving structured logs a `testSessionId`,
`testCaseId`, `testStepId` field. Nothing else depends on them.

### 6.5 OpenAPI overlay

A single `GET /openapi.json` serves the OpenAPI document for these
services. The companion file
[gitb-openapi.json](org.hl7.fhir.validation/src/main/resources/org/hl7/fhir/validation/http/gitb-openapi.json)
is the authoritative machine-readable spec — this markdown is the
narrative companion. When they disagree, the OpenAPI is the
implementation contract.

---

## 7. Implementation plan

All changes land on a single feature branch off `upstream/master`, as a
sequence of reviewable commits:

1. **Add GITB type builders and TAR mapper** — `gitb/` sub-package with
   `AnyContent`, `TAR`, `ReportItem`, `ValidationCounters`,
   `ValidationOverview`, `ServiceDefinition`, `ProcessResponse`,
   `ValidationResponse` as plain `JsonObject` builders, plus
   `OperationOutcomeToTarMapper`. No dependency on `gitb-types-jakarta`.
2. **Add the unified base handler** — `GitbServiceHandler` with the
   `GET /<svc>/definition` and `POST /<svc>/process` shape. Each
   concrete handler declares its `ServiceDefinition` and a dispatch map
   from operation name to a Java method.
3. **Port `FHIRValidator`** — new handler for the `/fhir` prefix
   serving `validate` and `loadIG`. Wires through to the existing
   `ValidationEngine` calls. Maps `OperationOutcome` → TAR with
   `operationOutcome` always in `context`, and `content` in `context`
   when `includeContentInReport` is true (default).
4. **Port `FHIRPathProcessor`** to `/fhirpath` serving both `evaluate`
   and `assert`.
5. **Port `MatchetypeProcessor`, `TestDataGenerator`,
   `ValidationResultsProcessor`** to the new base.
6. **Wire all routes** in `FhirValidatorHttpService.startServer()`.
   Existing flat handlers (`/fhirpath`, `/validateResource`, …) remain
   for backward compatibility.
7. **Add tests** — one integration test per service exercising
   `/<svc>/definition` + at least one successful and one failing
   `process` call. `OperationOutcome → TAR` mapper gets unit tests for
   every severity branch.
8. **(Optional, deferred)** Resolve report-item `location` to
   `content:<line>:<col>` form using a JSON-path → line-number lookup
   over the original payload, so the ITB inline editor can jump to the
   exact line.

Estimated size: ~2000 LOC added, ~800 LOC removed / modified.

---

## 8. Resolved decisions

| # | Decision | Rationale |
|---|---|---|
| 1 | Path prefix `/fhir` for the FHIR validator (not `/validator`). | ITB review — symmetric with `/matchetype`, `/fhirpath`, `/testdata`, `/validationResults`. |
| 2 | `validationResults` (camelCase, not kebab). | ITB review — operations and paths use lower-camelCase, matching ITB built-in service operation names like `getModuleDefinition`. |
| 3 | Inputs only — no `configs`. | ITB review — built-in service handlers use inputs for everything; inputs are a strict superset of configs. |
| 4 | Separate `contentType` input on `FHIRValidator.validate`, optional, defaulting to `application/fhir+json`. | ITB review — `mimeType` on AnyContent inputs is ambiguous (it's an output rendering hint). A separate `contentType` input is unambiguous and self-documenting. |
| 5 | `includeContentInReport` input, default `true`. | ITB review — including the validated payload in TAR `context` makes the ITB report viewer much more useful. Optional so callers can opt out for very-large payloads. |
| 6 | Report item `location` accepts both JSON path and `content:<line>:<col>`. | ITB review — JSON path is fine for display; the line-anchored form unlocks the ITB inline editor's "jump to line" feature. The validator emits whichever form it can resolve. |
| 7 | FHIRPath `evaluate` and `assert` are operations on a single `FHIRPathProcessor` service (not separate `FHIRPathProcessor` + `FHIRPathAssertion` services). | `assert` is a thin wrapper over `evaluate` (run, check Boolean true). One service, two operations is a smaller surface. |
| 8 | `loadIG` is an operation on `FHIRValidator` (not a separate `IGManager` service). | Loading IGs is part of setting up validation. Smaller surface; `listIGs` and `unloadIG` can be added later as new operations on `FHIRValidator` without breaking changes. |
| 9 | `FHIRPathProcessor.assert`: empty collection → `FAILURE`. | Matches the expectation of invariant-style expressions (`where(...).exists()`). |
| 10 | `FHIRPathProcessor.evaluate` serialises collections as JSON arrays. | Machine-parseable, preserves element types and values with commas; lossless. |
| 11 | URL fetch (when enabled) is SSRF-hardened — see §2.4.1 for the full policy (scheme allowlist, RFC1918 denylist, no redirects to private IPs, no credential forwarding, 30 MB cap, timeouts, `-disable-uri-fetch` kill-switch). | SSRF is the standard risk for server-side URL fetchers. Full mitigation by default; operators can disable the feature entirely. |
| 12 | `overview.version` = validator Maven version. | Simple, accurate, one source of truth. Contract version is expressed by the OpenAPI spec's `info.version`. |

---

## 9. References

- Companion machine-readable spec: [gitb-openapi.json](org.hl7.fhir.validation/src/main/resources/org/hl7/fhir/validation/http/gitb-openapi.json)
- GITB validation service REST contract: `gitb-types-development/gitb-types-specs/src/main/resources/rest/gitb_vs.json`
- GITB processing service REST contract: `gitb-types-development/gitb-types-specs/src/main/resources/rest/gitb_ps.json`
- Existing native HTTP handlers: `org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/http/`
- ITB REST API (unrelated — admin surface of the ITB itself): `itb-openapi.json`
