package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Serves the OpenAPI 3.0 specification as JSON at /openapi.json.
 */
class OpenApiHTTPHandler implements HttpHandler {

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    byte[] responseBytes = OPENAPI_SPEC.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", "application/json");
    exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
    exchange.sendResponseHeaders(200, responseBytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(responseBytes);
    }
  }

  private static final String GITB_PATHS =
    // /api/fhirpath
    "    \"/api/fhirpath/{action}\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"GITB - FHIRPath\"],\n" +
    "        \"summary\": \"FHIRPathProcessor — service definition\",\n" +
    "        \"operationId\": \"gitbFhirpathDefinition\",\n" +
    "        \"description\": \"Returns GITB service metadata. Service id: FHIRPathProcessor. Operation: evaluate.\\n\\n**Inputs:**\\n- `resource` (string, required) — FHIR resource as stringified JSON\\n- `expression` (string, required) — FHIRPath expression\\n\\n**Outputs:**\\n- `result` — the evaluation result as a string (booleans as 'true'/'false', multiple values returns the first)\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"definition\"] } }],\n" +
    "        \"responses\": { \"200\": { \"description\": \"Service definition\", \"content\": { \"application/json\": { \"schema\": { \"$ref\": \"#/components/schemas/GitbDefinition\" } } } } }\n" +
    "      },\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"GITB - FHIRPath\"],\n" +
    "        \"summary\": \"FHIRPathProcessor — evaluate expression\",\n" +
    "        \"operationId\": \"gitbFhirpathProcess\",\n" +
    "        \"description\": \"Evaluates a FHIRPath expression against a FHIR resource.\\n\\nThe resource is passed as stringified JSON in `inputs.resource`. The expression is in `inputs.expression`. Returns the first result as a string.\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"process\"] } }],\n" +
    "        \"requestBody\": { \"required\": true, \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"required\": [\"operation\", \"inputs\"],\n" +
    "          \"properties\": {\n" +
    "            \"operation\": { \"type\": \"string\", \"enum\": [\"evaluate\"] },\n" +
    "            \"inputs\": { \"type\": \"object\", \"required\": [\"resource\", \"expression\"], \"properties\": {\n" +
    "              \"resource\": { \"type\": \"string\", \"description\": \"FHIR resource as stringified JSON\" },\n" +
    "              \"expression\": { \"type\": \"string\", \"description\": \"FHIRPath expression to evaluate\" }\n" +
    "            } }\n" +
    "          }\n" +
    "        }, \"example\": { \"operation\": \"evaluate\", \"inputs\": { \"resource\": \"{\\\"resourceType\\\":\\\"Patient\\\",\\\"name\\\":[{\\\"family\\\":\\\"Smith\\\"}]}\", \"expression\": \"Patient.name.family\" } } } } },\n" +
    "        \"responses\": { \"200\": { \"description\": \"Evaluation result\", \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"properties\": {\n" +
    "            \"result\": { \"type\": \"string\", \"enum\": [\"SUCCESS\", \"FAILURE\"] },\n" +
    "            \"output\": { \"type\": \"object\", \"properties\": { \"result\": { \"type\": \"string\", \"description\": \"Evaluation result (e.g. 'Smith', 'true', '3')\" } } },\n" +
    "            \"error\": { \"type\": \"string\" }\n" +
    "          }\n" +
    "        }, \"example\": { \"result\": \"SUCCESS\", \"output\": { \"result\": \"Smith\" } } } } } }\n" +
    "      }\n" +
    "    },\n" +

    // /api/validator
    "    \"/api/validator/{action}\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"GITB - Validator\"],\n" +
    "        \"summary\": \"FHIRValidator — service definition\",\n" +
    "        \"operationId\": \"gitbValidatorDefinition\",\n" +
    "        \"description\": \"Returns GITB service metadata. Service id: FHIRValidator. Operations: validate, loadIG.\\n\\n**Inputs:**\\n- `resource` (string) — FHIR resource as stringified JSON (for validate)\\n- `profiles` (string) — comma-separated profile canonical URLs (for validate)\\n- `ig` (string) — IG package reference e.g. hl7.fhir.be.core#2.1.2 (for loadIG)\\n- `bpWarnings` (string) — Ignore|Hint|Warning|Error\\n- `resourceIdRule` (string) — OPTIONAL|REQUIRED|PROHIBITED\\n\\n**Outputs:**\\n- `outcome` — OperationOutcome as stringified JSON\\n- `severity` — highest severity across issues (error, warning, information)\\n- `errors` — count of error-level issues as string\\n- `warnings` — count of warning-level issues as string\\n\\nValidation issues are always returned as SUCCESS with counts in the output. FAILURE only for infrastructure errors.\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"definition\"] } }],\n" +
    "        \"responses\": { \"200\": { \"description\": \"Service definition\", \"content\": { \"application/json\": { \"schema\": { \"$ref\": \"#/components/schemas/GitbDefinition\" } } } } }\n" +
    "      },\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"GITB - Validator\"],\n" +
    "        \"summary\": \"FHIRValidator — validate or loadIG\",\n" +
    "        \"operationId\": \"gitbValidatorProcess\",\n" +
    "        \"description\": \"**validate:** Validates `inputs.resource` (stringified FHIR JSON) against `inputs.profiles` (comma-separated canonical URLs). Optional `inputs.bpWarnings` and `inputs.resourceIdRule`.\\n\\n**loadIG:** Loads the IG identified by `inputs.ig` (e.g. `hl7.fhir.be.medication#1.1.0`). Returns FAILURE only if the IG could not be loaded at all.\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"process\"] } }],\n" +
    "        \"requestBody\": { \"required\": true, \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"required\": [\"operation\", \"inputs\"],\n" +
    "          \"properties\": {\n" +
    "            \"operation\": { \"type\": \"string\", \"enum\": [\"validate\", \"loadIG\"] },\n" +
    "            \"inputs\": { \"type\": \"object\", \"properties\": {\n" +
    "              \"resource\": { \"type\": \"string\", \"description\": \"FHIR resource as stringified JSON (for validate)\" },\n" +
    "              \"profiles\": { \"type\": \"string\", \"description\": \"Comma-separated profile canonical URLs (for validate)\" },\n" +
    "              \"ig\": { \"type\": \"string\", \"description\": \"IG package e.g. hl7.fhir.be.core#2.1.2 (for loadIG)\" },\n" +
    "              \"bpWarnings\": { \"type\": \"string\", \"enum\": [\"Ignore\", \"Hint\", \"Warning\", \"Error\"], \"description\": \"Best practice warning level\" },\n" +
    "              \"resourceIdRule\": { \"type\": \"string\", \"enum\": [\"OPTIONAL\", \"REQUIRED\", \"PROHIBITED\"], \"description\": \"Resource ID handling\" }\n" +
    "            } }\n" +
    "          }\n" +
    "        }, \"examples\": {\n" +
    "          \"validate\": { \"summary\": \"Validate a Patient\", \"value\": { \"operation\": \"validate\", \"inputs\": { \"resource\": \"{\\\"resourceType\\\":\\\"Patient\\\",\\\"name\\\":[{\\\"family\\\":\\\"Smith\\\"}]}\", \"profiles\": \"http://hl7.org/fhir/StructureDefinition/Patient\" } } },\n" +
    "          \"loadIG\": { \"summary\": \"Load Belgian core IG\", \"value\": { \"operation\": \"loadIG\", \"inputs\": { \"ig\": \"hl7.fhir.be.core#2.1.2\" } } }\n" +
    "        } } } },\n" +
    "        \"responses\": { \"200\": { \"description\": \"Result\", \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"properties\": {\n" +
    "            \"result\": { \"type\": \"string\", \"enum\": [\"SUCCESS\", \"FAILURE\"] },\n" +
    "            \"output\": { \"type\": \"object\", \"properties\": {\n" +
    "              \"outcome\": { \"type\": \"string\", \"description\": \"OperationOutcome as stringified JSON\" },\n" +
    "              \"severity\": { \"type\": \"string\", \"enum\": [\"error\", \"warning\", \"information\"], \"description\": \"Highest severity\" },\n" +
    "              \"errors\": { \"type\": \"string\", \"description\": \"Error count\" },\n" +
    "              \"warnings\": { \"type\": \"string\", \"description\": \"Warning count\" }\n" +
    "            } },\n" +
    "            \"error\": { \"type\": \"string\" }\n" +
    "          }\n" +
    "        }, \"example\": { \"result\": \"SUCCESS\", \"output\": { \"outcome\": \"{\\\"resourceType\\\":\\\"OperationOutcome\\\",...}\", \"severity\": \"information\", \"errors\": \"0\", \"warnings\": \"0\" } } } } } }\n" +
    "      }\n" +
    "    },\n" +

    // /api/matchetype
    "    \"/api/matchetype/{action}\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"GITB - Matchetype\"],\n" +
    "        \"summary\": \"MatchetypeProcessor — service definition\",\n" +
    "        \"operationId\": \"gitbMatchetypeDefinition\",\n" +
    "        \"description\": \"Returns GITB service metadata. Service id: MatchetypeProcessor. Operation: compare.\\n\\n**Inputs:**\\n- `resource` (string, required) — FHIR resource as stringified JSON\\n- `matchetype` (string, required) — expected pattern as stringified JSON\\n- `mode` (string) — 'complete' (default) or 'partial'\\n\\n**Outputs:**\\n- `outcome` — OperationOutcome as stringified JSON\\n- `severity` — 'information' (match) or 'error' (mismatch)\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"definition\"] } }],\n" +
    "        \"responses\": { \"200\": { \"description\": \"Service definition\", \"content\": { \"application/json\": { \"schema\": { \"$ref\": \"#/components/schemas/GitbDefinition\" } } } } }\n" +
    "      },\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"GITB - Matchetype\"],\n" +
    "        \"summary\": \"MatchetypeProcessor — compare resource against pattern\",\n" +
    "        \"operationId\": \"gitbMatchetypeProcess\",\n" +
    "        \"description\": \"Compares `inputs.resource` against `inputs.matchetype` pattern. Both are stringified FHIR JSON. Returns severity 'information' on match, 'error' on mismatch.\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"process\"] } }],\n" +
    "        \"requestBody\": { \"required\": true, \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"required\": [\"operation\", \"inputs\"],\n" +
    "          \"properties\": {\n" +
    "            \"operation\": { \"type\": \"string\", \"enum\": [\"compare\"] },\n" +
    "            \"inputs\": { \"type\": \"object\", \"required\": [\"resource\", \"matchetype\"], \"properties\": {\n" +
    "              \"resource\": { \"type\": \"string\", \"description\": \"Actual FHIR resource as stringified JSON\" },\n" +
    "              \"matchetype\": { \"type\": \"string\", \"description\": \"Expected pattern as stringified JSON\" },\n" +
    "              \"mode\": { \"type\": \"string\", \"enum\": [\"complete\", \"partial\"], \"default\": \"complete\" }\n" +
    "            } }\n" +
    "          }\n" +
    "        }, \"example\": { \"operation\": \"compare\", \"inputs\": { \"resource\": \"{\\\"resourceType\\\":\\\"Patient\\\",\\\"name\\\":[{\\\"family\\\":\\\"Smith\\\"}]}\", \"matchetype\": \"{\\\"resourceType\\\":\\\"Patient\\\",\\\"name\\\":[{\\\"family\\\":\\\"Smith\\\"}]}\" } } } } },\n" +
    "        \"responses\": { \"200\": { \"description\": \"Comparison result\", \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"properties\": {\n" +
    "            \"result\": { \"type\": \"string\", \"enum\": [\"SUCCESS\", \"FAILURE\"] },\n" +
    "            \"output\": { \"type\": \"object\", \"properties\": {\n" +
    "              \"outcome\": { \"type\": \"string\", \"description\": \"OperationOutcome as stringified JSON\" },\n" +
    "              \"severity\": { \"type\": \"string\", \"enum\": [\"information\", \"warning\", \"error\"] }\n" +
    "            } },\n" +
    "            \"error\": { \"type\": \"string\" }\n" +
    "          }\n" +
    "        } } } } }\n" +
    "      }\n" +
    "    },\n" +

    // /api/testdata
    "    \"/api/testdata/{action}\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"GITB - Test Data\"],\n" +
    "        \"summary\": \"TestDataGenerator — service definition\",\n" +
    "        \"operationId\": \"gitbTestdataDefinition\",\n" +
    "        \"description\": \"Returns GITB service metadata. Service id: TestDataGenerator. Operations: generate, generateBundle.\\n\\n**Inputs:**\\n- `profile` (string, required) — canonical URL of the StructureDefinition\\n- `mappings` (string) — stringified JSON array of path/expression mapping objects\\n- `data` (string) — stringified JSON array of data row objects\\n\\n**Outputs:**\\n- `resource` — generated FHIR resource as stringified JSON\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"definition\"] } }],\n" +
    "        \"responses\": { \"200\": { \"description\": \"Service definition\", \"content\": { \"application/json\": { \"schema\": { \"$ref\": \"#/components/schemas/GitbDefinition\" } } } } }\n" +
    "      },\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"GITB - Test Data\"],\n" +
    "        \"summary\": \"TestDataGenerator — generate resource(s) from profile\",\n" +
    "        \"operationId\": \"gitbTestdataProcess\",\n" +
    "        \"description\": \"**generate:** Generates a single FHIR resource conforming to `inputs.profile`. Optional `inputs.mappings` and `inputs.data` (both stringified JSON arrays).\\n\\n**generateBundle:** Same as generate but wraps the output in a Bundle.\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"process\"] } }],\n" +
    "        \"requestBody\": { \"required\": true, \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"required\": [\"operation\", \"inputs\"],\n" +
    "          \"properties\": {\n" +
    "            \"operation\": { \"type\": \"string\", \"enum\": [\"generate\", \"generateBundle\"] },\n" +
    "            \"inputs\": { \"type\": \"object\", \"required\": [\"profile\"], \"properties\": {\n" +
    "              \"profile\": { \"type\": \"string\", \"description\": \"Canonical URL of the StructureDefinition\" },\n" +
    "              \"mappings\": { \"type\": \"string\", \"description\": \"Stringified JSON array of mapping objects [{path,expression,parts}]\" },\n" +
    "              \"data\": { \"type\": \"string\", \"description\": \"Stringified JSON array of data row objects\" }\n" +
    "            } }\n" +
    "          }\n" +
    "        }, \"example\": { \"operation\": \"generate\", \"inputs\": { \"profile\": \"http://hl7.org/fhir/StructureDefinition/Patient\" } } } } },\n" +
    "        \"responses\": { \"200\": { \"description\": \"Generated resource\", \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"properties\": {\n" +
    "            \"result\": { \"type\": \"string\", \"enum\": [\"SUCCESS\", \"FAILURE\"] },\n" +
    "            \"output\": { \"type\": \"object\", \"properties\": {\n" +
    "              \"resource\": { \"type\": \"string\", \"description\": \"Generated FHIR resource as stringified JSON\" }\n" +
    "            } },\n" +
    "            \"error\": { \"type\": \"string\" }\n" +
    "          }\n" +
    "        } } } } }\n" +
    "      }\n" +
    "    },\n" +

    // /api/validation-results
    "    \"/api/validation-results/{action}\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"GITB - Validation Results\"],\n" +
    "        \"summary\": \"ValidationResultsProcessor — service definition\",\n" +
    "        \"operationId\": \"gitbValidationResultsDefinition\",\n" +
    "        \"description\": \"Returns GITB service metadata. Service id: ValidationResultsProcessor. Operations: summarize, filterBySeverity, filterByText.\\n\\nPure JSON utility — no FHIR engine needed. Parses an OperationOutcome and extracts counts.\\n\\n**Inputs:**\\n- `outcome` (string, required) — OperationOutcome as stringified JSON\\n- `severity` (string) — for filterBySeverity: error, warning, information, fatal\\n- `text` (string) — for filterByText: substring to search in issue details\\n\\n**Outputs:**\\n- `errors` — error count as string (for summarize)\\n- `warnings` — warning count as string (for summarize)\\n- `count` — matching issue count as string (for filter operations)\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"definition\"] } }],\n" +
    "        \"responses\": { \"200\": { \"description\": \"Service definition\", \"content\": { \"application/json\": { \"schema\": { \"$ref\": \"#/components/schemas/GitbDefinition\" } } } } }\n" +
    "      },\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"GITB - Validation Results\"],\n" +
    "        \"summary\": \"ValidationResultsProcessor — summarize or filter\",\n" +
    "        \"operationId\": \"gitbValidationResultsProcess\",\n" +
    "        \"description\": \"**summarize:** Counts error and warning issues in `inputs.outcome`. Returns `output.errors` and `output.warnings`.\\n\\n**filterBySeverity:** Counts issues matching `inputs.severity` (error, warning, information, fatal). Returns `output.count`.\\n\\n**filterByText:** Counts issues where details.text contains `inputs.text`. Returns `output.count`.\",\n" +
    "        \"parameters\": [{ \"name\": \"action\", \"in\": \"path\", \"required\": true, \"schema\": { \"type\": \"string\", \"enum\": [\"process\"] } }],\n" +
    "        \"requestBody\": { \"required\": true, \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"required\": [\"operation\", \"inputs\"],\n" +
    "          \"properties\": {\n" +
    "            \"operation\": { \"type\": \"string\", \"enum\": [\"summarize\", \"filterBySeverity\", \"filterByText\"] },\n" +
    "            \"inputs\": { \"type\": \"object\", \"required\": [\"outcome\"], \"properties\": {\n" +
    "              \"outcome\": { \"type\": \"string\", \"description\": \"OperationOutcome as stringified JSON\" },\n" +
    "              \"severity\": { \"type\": \"string\", \"enum\": [\"fatal\", \"error\", \"warning\", \"information\"], \"description\": \"For filterBySeverity\" },\n" +
    "              \"text\": { \"type\": \"string\", \"description\": \"For filterByText: substring to match\" }\n" +
    "            } }\n" +
    "          }\n" +
    "        }, \"examples\": {\n" +
    "          \"summarize\": { \"summary\": \"Count errors and warnings\", \"value\": { \"operation\": \"summarize\", \"inputs\": { \"outcome\": \"{\\\"resourceType\\\":\\\"OperationOutcome\\\",\\\"issue\\\":[{\\\"severity\\\":\\\"error\\\",\\\"code\\\":\\\"invalid\\\",\\\"details\\\":{\\\"text\\\":\\\"Bad\\\"}}]}\" } } },\n" +
    "          \"filterBySeverity\": { \"summary\": \"Count error-level issues\", \"value\": { \"operation\": \"filterBySeverity\", \"inputs\": { \"outcome\": \"{\\\"resourceType\\\":\\\"OperationOutcome\\\",\\\"issue\\\":[...]}\", \"severity\": \"error\" } } },\n" +
    "          \"filterByText\": { \"summary\": \"Count issues mentioning 'identifier'\", \"value\": { \"operation\": \"filterByText\", \"inputs\": { \"outcome\": \"{\\\"resourceType\\\":\\\"OperationOutcome\\\",\\\"issue\\\":[...]}\", \"text\": \"identifier\" } } }\n" +
    "        } } } },\n" +
    "        \"responses\": { \"200\": { \"description\": \"Result\", \"content\": { \"application/json\": { \"schema\": {\n" +
    "          \"type\": \"object\", \"properties\": {\n" +
    "            \"result\": { \"type\": \"string\", \"enum\": [\"SUCCESS\", \"FAILURE\"] },\n" +
    "            \"output\": { \"type\": \"object\", \"properties\": {\n" +
    "              \"errors\": { \"type\": \"string\", \"description\": \"Error count (for summarize)\" },\n" +
    "              \"warnings\": { \"type\": \"string\", \"description\": \"Warning count (for summarize)\" },\n" +
    "              \"count\": { \"type\": \"string\", \"description\": \"Matching issue count (for filter operations)\" }\n" +
    "            } },\n" +
    "            \"error\": { \"type\": \"string\" }\n" +
    "          }\n" +
    "        }, \"example\": { \"result\": \"SUCCESS\", \"output\": { \"errors\": \"1\", \"warnings\": \"0\" } } } } } }\n" +
    "      }\n" +
    "    }\n";

  private static final String OPENAPI_SPEC = "{\n" +
    "  \"openapi\": \"3.0.3\",\n" +
    "  \"info\": {\n" +
    "    \"title\": \"FHIR Validator HTTP Service\",\n" +
    "    \"description\": \"REST API for the HL7 FHIR Validator engine. Provides validation, format conversion, FHIRPath evaluation, test data generation, StructureMap operations, version conversion, and more.\",\n" +
    "    \"version\": \"1.0.0\",\n" +
    "    \"contact\": {\n" +
    "      \"name\": \"HL7 FHIR Core Team\",\n" +
    "      \"url\": \"https://github.com/hapifhir/org.hl7.fhir.core\"\n" +
    "    }\n" +
    "  },\n" +
    "  \"servers\": [\n" +
    "    { \"url\": \"http://localhost:8080\", \"description\": \"Local development server\" }\n" +
    "  ],\n" +
    "  \"paths\": {\n" +

    // /validateResource
    "    \"/validateResource\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Validation\"],\n" +
    "        \"summary\": \"Validate a FHIR resource\",\n" +
    "        \"description\": \"Validates a FHIR resource (JSON or XML) against base FHIR specification and optionally against one or more profiles.\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"profiles\", \"in\": \"query\", \"description\": \"Comma-separated list of profile canonical URLs to validate against\", \"schema\": { \"type\": \"string\" } },\n" +
    "          { \"name\": \"resourceIdRule\", \"in\": \"query\", \"description\": \"How to handle resource IDs\", \"schema\": { \"type\": \"string\", \"enum\": [\"OPTIONAL\", \"REQUIRED\", \"PROHIBITED\"], \"default\": \"OPTIONAL\" } },\n" +
    "          { \"name\": \"anyExtensionsAllowed\", \"in\": \"query\", \"description\": \"Whether unknown extensions are allowed\", \"schema\": { \"type\": \"boolean\", \"default\": true } },\n" +
    "          { \"name\": \"bpWarnings\", \"in\": \"query\", \"description\": \"Best practice warning level\", \"schema\": { \"type\": \"string\", \"enum\": [\"Ignore\", \"Hint\", \"Warning\", \"Error\"], \"default\": \"Ignore\" } },\n" +
    "          { \"name\": \"displayOption\", \"in\": \"query\", \"description\": \"How to check display values\", \"schema\": { \"type\": \"string\", \"enum\": [\"Ignore\", \"Check\", \"CheckCaseAndSpace\", \"CheckCase\", \"CheckSpace\"], \"default\": \"Ignore\" } }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to validate\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Validation result\", \"content\": { \"application/fhir+json\": { \"schema\": { \"$ref\": \"#/components/schemas/OperationOutcome\" } }, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Invalid parameters\" },\n" +
    "          \"500\": { \"description\": \"Validation engine error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /fhirpath
    "    \"/fhirpath\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"FHIRPath\"],\n" +
    "        \"summary\": \"Evaluate a FHIRPath expression\",\n" +
    "        \"description\": \"Evaluates a FHIRPath expression against a FHIR resource and returns the result as a Parameters resource. The expression can be passed either as a query parameter or inside the JSON request body (as a wrapper object with 'expression' and 'resource' fields).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"expression\", \"in\": \"query\", \"required\": false, \"description\": \"The FHIRPath expression to evaluate. Can also be provided in the JSON request body.\", \"schema\": { \"type\": \"string\" }, \"example\": \"Patient.name.family\" }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"Either a raw FHIR resource (expression in query param) or a JSON wrapper with 'resource' and 'expression' fields.\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\", \"description\": \"Raw FHIR resource (use query param for expression)\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\", \"description\": \"Raw FHIR resource in XML (use query param for expression)\" } },\n" +
    "            \"application/json\": { \"schema\": { \"type\": \"object\", \"properties\": { \"resource\": { \"description\": \"FHIR resource as JSON object or stringified JSON\" }, \"expression\": { \"type\": \"string\", \"description\": \"FHIRPath expression\" } }, \"required\": [\"expression\"] }, \"example\": { \"resource\": { \"resourceType\": \"Patient\", \"name\": [{ \"family\": \"Smith\" }] }, \"expression\": \"Patient.name.family\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Evaluation result as a Parameters resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing expression (neither in query nor body)\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"FHIRPath evaluation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /matchetype
    "    \"/matchetype\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Testing\"],\n" +
    "        \"summary\": \"Compare a resource against a matchetype pattern\",\n" +
    "        \"description\": \"Compares an actual FHIR resource against an expected matchetype pattern. The pattern can use wildcards like $string$, $date$, $uuid$ for flexible matching.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"JSON wrapper with 'resource' (actual) and 'matchetype' (expected pattern)\",\n" +
    "          \"content\": {\n" +
    "            \"application/json\": {\n" +
    "              \"schema\": {\n" +
    "                \"type\": \"object\",\n" +
    "                \"required\": [\"resource\", \"matchetype\"],\n" +
    "                \"properties\": {\n" +
    "                  \"resource\": { \"type\": \"object\", \"description\": \"The actual FHIR resource\" },\n" +
    "                  \"matchetype\": { \"type\": \"object\", \"description\": \"The expected pattern with optional wildcards\" }\n" +
    "                }\n" +
    "              },\n" +
    "              \"example\": {\n" +
    "                \"resource\": { \"resourceType\": \"Patient\", \"name\": [{ \"family\": \"Doe\" }] },\n" +
    "                \"matchetype\": { \"resourceType\": \"Patient\", \"name\": [{ \"family\": \"$string$\" }] }\n" +
    "              }\n" +
    "            }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Comparison result (OperationOutcome with 'All OK' or error issues)\", \"content\": { \"application/fhir+json\": { \"schema\": { \"$ref\": \"#/components/schemas/OperationOutcome\" } } } },\n" +
    "          \"400\": { \"description\": \"Missing resource or matchetype field\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Comparison engine error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /testdata
    "    \"/testdata\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Testing\"],\n" +
    "        \"summary\": \"Generate test data from a FHIR profile\",\n" +
    "        \"description\": \"Generates conformant test data for a given FHIR profile. Supports custom data mappings and can return single resources or Bundles.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"JSON object specifying the profile and optional data/mappings\",\n" +
    "          \"content\": {\n" +
    "            \"application/json\": {\n" +
    "              \"schema\": {\n" +
    "                \"type\": \"object\",\n" +
    "                \"required\": [\"profile\"],\n" +
    "                \"properties\": {\n" +
    "                  \"profile\": { \"type\": \"string\", \"description\": \"Canonical URL of the profile\" },\n" +
    "                  \"data\": { \"type\": \"array\", \"description\": \"Array of data rows (column name -> value)\", \"items\": { \"type\": \"object\" } },\n" +
    "                  \"mappings\": { \"type\": \"array\", \"description\": \"Array of path-to-expression mappings\", \"items\": { \"type\": \"object\", \"properties\": { \"path\": { \"type\": \"string\" }, \"expression\": { \"type\": \"string\" }, \"parts\": { \"type\": \"array\" } } } },\n" +
    "                  \"bundle\": { \"type\": \"string\", \"description\": \"Set to 'true' to return a Bundle\", \"enum\": [\"true\", \"false\"] },\n" +
    "                  \"format\": { \"type\": \"string\", \"description\": \"Output format\", \"enum\": [\"json\", \"xml\"], \"default\": \"json\" }\n" +
    "                }\n" +
    "              },\n" +
    "              \"example\": {\n" +
    "                \"profile\": \"http://hl7.org/fhir/StructureDefinition/Patient\",\n" +
    "                \"data\": [{ \"familyName\": \"Doe\", \"givenName\": \"John\" }],\n" +
    "                \"mappings\": [\n" +
    "                  { \"path\": \"Patient.name.family\", \"expression\": \"column('familyName')\" },\n" +
    "                  { \"path\": \"Patient.name.given\", \"expression\": \"column('givenName')\" }\n" +
    "                ]\n" +
    "              }\n" +
    "            }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Generated FHIR resource(s)\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing profile field\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Generation error (e.g. profile not found)\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /loadIG
    "    \"/loadIG\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Configuration\"],\n" +
    "        \"summary\": \"Load an Implementation Guide\",\n" +
    "        \"description\": \"Dynamically loads an IG package into the validation engine. Supports package registry references (id#version), URLs to .tgz packages, and local file paths.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"content\": {\n" +
    "            \"application/json\": {\n" +
    "              \"schema\": {\n" +
    "                \"type\": \"object\",\n" +
    "                \"required\": [\"ig\"],\n" +
    "                \"properties\": {\n" +
    "                  \"ig\": { \"type\": \"string\", \"description\": \"IG source: package#version, URL, or file path\" }\n" +
    "                }\n" +
    "              },\n" +
    "              \"example\": { \"ig\": \"hl7.fhir.us.core#5.0.1\" }\n" +
    "            }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"IG loaded successfully\", \"content\": { \"application/fhir+json\": { \"schema\": { \"$ref\": \"#/components/schemas/OperationOutcome\" } } } },\n" +
    "          \"400\": { \"description\": \"Missing ig field\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Failed to load IG\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /convert
    "    \"/convert\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Conversion\"],\n" +
    "        \"summary\": \"Convert a FHIR resource between JSON and XML\",\n" +
    "        \"description\": \"Converts a FHIR resource from one format to another. The input format is determined by Content-Type and the output format by the Accept header.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to convert\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Converted resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Conversion error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /snapshot
    "    \"/snapshot\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Profile Operations\"],\n" +
    "        \"summary\": \"Generate a snapshot for a StructureDefinition\",\n" +
    "        \"description\": \"Takes a StructureDefinition with a differential and generates the full snapshot. The input must be a StructureDefinition resource.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"A StructureDefinition resource (with differential)\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"StructureDefinition with snapshot populated\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Snapshot generation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /questionnaire
    "    \"/questionnaire\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"Profile Operations\"],\n" +
    "        \"summary\": \"Generate a Questionnaire from a profile\",\n" +
    "        \"description\": \"Generates a FHIR Questionnaire resource from a StructureDefinition profile. Coded elements will have their ValueSets expanded and included as contained resources with answer options. The profile must already be loaded (e.g. via /loadIG or at startup).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"profile\", \"in\": \"query\", \"required\": true, \"description\": \"Canonical URL of the StructureDefinition profile\", \"schema\": { \"type\": \"string\" }, \"example\": \"http://hl7.org/fhir/StructureDefinition/Patient\" },\n" +
    "          { \"name\": \"format\", \"in\": \"query\", \"description\": \"Output format\", \"schema\": { \"type\": \"string\", \"enum\": [\"json\", \"xml\"], \"default\": \"json\" } }\n" +
    "        ],\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Generated Questionnaire resource with expanded ValueSets\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing profile parameter\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only GET)\" },\n" +
    "          \"500\": { \"description\": \"Generation error (e.g. profile not found)\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /narrative
    "    \"/narrative\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Resource Operations\"],\n" +
    "        \"summary\": \"Generate a narrative for a FHIR resource\",\n" +
    "        \"description\": \"Generates a human-readable narrative (text.div) for a FHIR resource and returns the resource with the narrative populated.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to generate a narrative for\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Resource with narrative populated in text.div\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Narrative generation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /transform
    "    \"/transform\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"StructureMap\"],\n" +
    "        \"summary\": \"Apply a StructureMap transformation\",\n" +
    "        \"description\": \"Applies a StructureMap transformation to a FHIR resource. The map must already be loaded (e.g. via /loadIG or part of base spec).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"map\", \"in\": \"query\", \"required\": true, \"description\": \"Canonical URL of the StructureMap to apply\", \"schema\": { \"type\": \"string\" } }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to transform\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Transformed resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing map parameter\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Transformation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /version
    "    \"/version\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Conversion\"],\n" +
    "        \"summary\": \"Convert a resource between FHIR versions\",\n" +
    "        \"description\": \"Converts a FHIR resource from one FHIR version to another (e.g. R4 to R5). The resource must have a 'url' element for native conversion. Supported target versions: 1.0 (DSTU2), 3.0 (STU3), 4.0 (R4), 4.3 (R4B), 5.0 (R5).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"targetVersion\", \"in\": \"query\", \"required\": true, \"description\": \"Target FHIR version\", \"schema\": { \"type\": \"string\", \"enum\": [\"1.0\", \"3.0\", \"4.0\", \"4.3\", \"5.0\"] } }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to convert\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Converted resource in target version\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing targetVersion parameter\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Version conversion error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /compile
    "    \"/compile\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"StructureMap\"],\n" +
    "        \"summary\": \"Fetch and compile a StructureMap\",\n" +
    "        \"description\": \"Fetches a StructureMap by its canonical URL and returns the compiled resource. The map must be loaded in the engine (e.g. via /loadIG).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"url\", \"in\": \"query\", \"required\": true, \"description\": \"Canonical URL of the StructureMap\", \"schema\": { \"type\": \"string\" } }\n" +
    "        ],\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"The compiled StructureMap resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing url parameter\" },\n" +
    "          \"500\": { \"description\": \"Compilation error or map not found\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /stop
    "    \"/stop\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"Configuration\"],\n" +
    "        \"summary\": \"Stop the HTTP server\",\n" +
    "        \"description\": \"Gracefully shuts down the FHIR Validator HTTP Service.\",\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Server stopping\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // GITB-compatible REST processing services
    GITB_PATHS +

    "  },\n" +
    "  \"components\": {\n" +
    "    \"schemas\": {\n" +
    "      \"OperationOutcome\": {\n" +
    "        \"type\": \"object\",\n" +
    "        \"description\": \"FHIR OperationOutcome resource containing validation results or error details\",\n" +
    "        \"properties\": {\n" +
    "          \"resourceType\": { \"type\": \"string\", \"enum\": [\"OperationOutcome\"] },\n" +
    "          \"issue\": {\n" +
    "            \"type\": \"array\",\n" +
    "            \"items\": {\n" +
    "              \"type\": \"object\",\n" +
    "              \"properties\": {\n" +
    "                \"severity\": { \"type\": \"string\", \"enum\": [\"fatal\", \"error\", \"warning\", \"information\"] },\n" +
    "                \"code\": { \"type\": \"string\" },\n" +
    "                \"details\": { \"type\": \"object\", \"properties\": { \"text\": { \"type\": \"string\" } } },\n" +
    "                \"expression\": { \"type\": \"array\", \"items\": { \"type\": \"string\" } }\n" +
    "              }\n" +
    "            }\n" +
    "          }\n" +
    "        }\n" +
    "      },\n" +
    "      \"GitbDefinition\": {\n" +
    "        \"type\": \"object\",\n" +
    "        \"description\": \"GITB service definition describing available operations, inputs, and outputs\",\n" +
    "        \"properties\": {\n" +
    "          \"id\": { \"type\": \"string\", \"description\": \"Service identifier\" },\n" +
    "          \"operations\": { \"type\": \"array\", \"items\": { \"type\": \"string\" }, \"description\": \"List of supported operations\" },\n" +
    "          \"inputs\": { \"type\": \"array\", \"items\": { \"type\": \"object\", \"properties\": { \"name\": { \"type\": \"string\" }, \"type\": { \"type\": \"string\" }, \"required\": { \"type\": \"boolean\" } } }, \"description\": \"Input parameters\" },\n" +
    "          \"outputs\": { \"type\": \"array\", \"items\": { \"type\": \"object\", \"properties\": { \"name\": { \"type\": \"string\" }, \"type\": { \"type\": \"string\" } } }, \"description\": \"Output parameters\" }\n" +
    "        }\n" +
    "      },\n" +
    "      \"GitbProcessRequest\": {\n" +
    "        \"type\": \"object\",\n" +
    "        \"description\": \"GITB processing request with operation name and string-valued inputs\",\n" +
    "        \"required\": [\"operation\", \"inputs\"],\n" +
    "        \"properties\": {\n" +
    "          \"operation\": { \"type\": \"string\", \"description\": \"The operation to execute\" },\n" +
    "          \"inputs\": { \"type\": \"object\", \"additionalProperties\": { \"type\": \"string\" }, \"description\": \"Input parameters as key-value string pairs. JSON objects (e.g. FHIR resources) must be stringified.\" }\n" +
    "        }\n" +
    "      },\n" +
    "      \"GitbProcessResponse\": {\n" +
    "        \"type\": \"object\",\n" +
    "        \"description\": \"GITB processing response with result status and string-valued outputs\",\n" +
    "        \"properties\": {\n" +
    "          \"result\": { \"type\": \"string\", \"enum\": [\"SUCCESS\", \"FAILURE\"], \"description\": \"Whether the operation succeeded\" },\n" +
    "          \"output\": { \"type\": \"object\", \"additionalProperties\": { \"type\": \"string\" }, \"description\": \"Output parameters as key-value string pairs\" },\n" +
    "          \"error\": { \"type\": \"string\", \"description\": \"Error message (only present when result is FAILURE)\" }\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "  }\n" +
    "}\n";
}
