package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB-aligned matchetype comparator at {@code /itb/matchetype}.
 * Operation: {@code compare}. Inputs: {@code resource}, {@code matchetype} (both stringified
 * FHIR JSON), and an optional {@code mode} ({@code complete}|{@code partial}).
 */
@Slf4j
class GitbMatchetypeHandler extends GitbServiceHandler {

  GitbMatchetypeHandler(FhirValidatorHttpService service) {
    super(service, "/itb/matchetype");
  }

  @Override
  protected ServiceDefinition buildDefinition() {
    return new ServiceDefinition(
      "MatchetypeProcessor",
      new String[]{"compare"},
      new InputDef[]{
        new InputDef("resource", "string", true),
        new InputDef("matchetype", "string", true),
        new InputDef("mode", "string", false)
      },
      new OutputDef[]{
        new OutputDef("outcome", "string"),
        new OutputDef("severity", "string"),
        new OutputDef("mismatches", "string")
      });
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    if (!"compare".equals(operation)) {
      throw new UnknownOperationException(operation, "compare");
    }
    String resource = requireInput(inputs, "resource");
    String matchetype = requireInput(inputs, "matchetype");
    // mode is currently advisory: the engine's compareMatchetype does a complete comparison.
    // partial-mode behaviour is not yet wired through; record the requested mode but do not
    // alter the call. See ITB_REST_SPEC.md §4.2.
    optionalInput(inputs, "mode", "complete");

    ValidationEngine engine = service.getValidationEngine();
    OperationOutcome outcome;
    try {
      outcome = engine.compareMatchetype(
        resource.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON,
        matchetype.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON);
    } catch (Throwable t) {
      log.warn("GITB matchetype compare failed", t);
      return gitbFailure("Matchetype comparison failed: " + t.getMessage());
    }

    int mismatches = 0;
    IssueSeverity highest = null;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      IssueSeverity sev = issue.getSeverity();
      if (sev == IssueSeverity.ERROR || sev == IssueSeverity.FATAL) mismatches++;
      if (sev != null && (highest == null || sev.ordinal() < highest.ordinal())) {
        // IssueSeverity.ordinal: FATAL=0, ERROR=1, WARNING=2, INFORMATION=3 — lower = more severe
        highest = sev;
      }
    }

    String outcomeJson;
    try {
      java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
      new org.hl7.fhir.r5.formats.JsonParser().compose(baos, outcome);
      outcomeJson = baos.toString(StandardCharsets.UTF_8.name());
    } catch (Throwable t) {
      return gitbFailure("Could not serialise OperationOutcome: " + t.getMessage());
    }

    JsonObject output = new JsonObject();
    output.add("outcome", outcomeJson);
    output.add("mismatches", String.valueOf(mismatches));
    output.add("severity", severityCode(highest));

    JsonObject response = new JsonObject();
    response.add("result", mismatches == 0 ? "SUCCESS" : "FAILURE");
    response.add("output", output);
    return response;
  }

  private static String severityCode(IssueSeverity sev) {
    if (sev == null) return "information";
    switch (sev) {
      case FATAL: return "fatal";
      case ERROR: return "error";
      case WARNING: return "warning";
      case INFORMATION: return "information";
      default: return "information";
    }
  }
}
