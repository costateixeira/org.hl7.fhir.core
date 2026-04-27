package org.hl7.fhir.validation.http;

import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.time.Instant;
import java.util.UUID;

/**
 * Builds GITB Test Assertion Report (TAR) JSON for the FHIRValidator service.
 * <p>
 * Maps FHIR {@link OperationOutcome} into the TAR shape defined in
 * {@code gitb-openapi.json} ({@code components.schemas.TAR}), and assembles
 * the surrounding {@code ValidationResponse} ({@code result}, {@code output},
 * {@code report}, {@code error}).
 * <p>
 * The mapping is documented in §2.8 of {@code ITB_REST_SPEC.md}.
 */
final class GitbTarBuilder {

  private static final String VALIDATOR_NAME = "HL7 FHIR Validator";

  private GitbTarBuilder() {}

  /**
   * Build a {@code ValidationResponse} for a successful validation run.
   *
   * @param outcome  the FHIR OperationOutcome produced by the engine
   * @param outcomeJson the OperationOutcome serialised to FHIR+JSON (echoed in output and TAR context)
   * @param content  the validated payload, as the caller sent it; non-null only when includeContentInReport=true
   * @param contentMime the MIME type of {@code content} (matches inputs.contentType)
   * @param failOn   severity threshold: {@code error}|{@code warning}|{@code information}
   * @param sessionId optional Gitb-Test-Session-Identifier; copied to overview.note
   * @param engineVersion the validator version, copied to overview.version
   */
  static JsonObject validationResponse(OperationOutcome outcome,
                                       String outcomeJson,
                                       String content,
                                       String contentMime,
                                       String failOn,
                                       String sessionId,
                                       String engineVersion) {
    int errors = 0;
    int warnings = 0;
    int infos = 0;
    IssueSeverity highest = null;
    JsonArray items = new JsonArray();

    for (OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      IssueSeverity sev = issue.getSeverity();
      if (sev == IssueSeverity.FATAL || sev == IssueSeverity.ERROR) errors++;
      else if (sev == IssueSeverity.WARNING) warnings++;
      else if (sev == IssueSeverity.INFORMATION) infos++;
      if (sev != null && (highest == null || severityRank(sev) > severityRank(highest))) {
        highest = sev;
      }
      items.add(reportItem(issue));
    }

    String tarResult = deriveResult(errors, warnings, infos, failOn);

    JsonObject report = new JsonObject();
    report.add("id", UUID.randomUUID().toString());
    report.add("date", Instant.now().toString());
    report.add("result", tarResult);

    JsonObject counters = new JsonObject();
    counters.add("nrOfErrors", errors);
    counters.add("nrOfWarnings", warnings);
    counters.add("nrOfAssertions", infos);
    report.add("counters", counters);

    JsonObject overview = new JsonObject();
    overview.add("name", VALIDATOR_NAME);
    if (engineVersion != null) overview.add("version", engineVersion);
    if (sessionId != null && !sessionId.isEmpty()) overview.add("note", "session=" + sessionId);
    report.add("overview", overview);

    report.add("items", items);

    JsonArray context = new JsonArray();
    context.add(anyContent("operationOutcome", outcomeJson, "application/fhir+json"));
    if (content != null) {
      context.add(anyContent("content", content, contentMime != null ? contentMime : "application/fhir+json"));
    }
    report.add("context", context);

    JsonObject output = new JsonObject();
    output.add("outcome", outcomeJson);
    output.add("severity", severityCode(highest));
    output.add("errors", String.valueOf(errors));
    output.add("warnings", String.valueOf(warnings));

    JsonObject response = new JsonObject();
    response.add("result", tarResult);
    response.add("output", output);
    response.add("report", report);
    return response;
  }

  /** Build a TAR-shaped response indicating the engine could not produce an outcome (UNDEFINED). */
  static JsonObject undefinedResponse(String engineErrorMessage, String sessionId, String engineVersion) {
    JsonObject report = new JsonObject();
    report.add("id", UUID.randomUUID().toString());
    report.add("date", Instant.now().toString());
    report.add("result", "UNDEFINED");

    JsonObject counters = new JsonObject();
    counters.add("nrOfErrors", 0);
    counters.add("nrOfWarnings", 0);
    counters.add("nrOfAssertions", 0);
    report.add("counters", counters);

    JsonObject overview = new JsonObject();
    overview.add("name", VALIDATOR_NAME);
    if (engineVersion != null) overview.add("version", engineVersion);
    if (sessionId != null && !sessionId.isEmpty()) overview.add("note", "session=" + sessionId);
    report.add("overview", overview);

    JsonArray items = new JsonArray();
    JsonObject errItem = new JsonObject();
    errItem.add("level", "ERROR");
    errItem.add("description", engineErrorMessage);
    errItem.add("type", "exception");
    items.add(errItem);
    report.add("items", items);

    report.add("context", new JsonArray());

    JsonObject output = new JsonObject();
    output.add("severity", "error");
    output.add("errors", "0");
    output.add("warnings", "0");

    JsonObject response = new JsonObject();
    response.add("result", "UNDEFINED");
    response.add("output", output);
    response.add("report", report);
    response.add("error", engineErrorMessage);
    return response;
  }

  /** Build a single GITB AnyContent JSON object. */
  static JsonObject anyContent(String name, String value, String mimeType) {
    JsonObject a = new JsonObject();
    a.add("name", name);
    a.add("value", value == null ? "" : value);
    a.add("embeddingMethod", "STRING");
    a.add("type", "string");
    if (mimeType != null) a.add("mimeType", mimeType);
    a.add("encoding", "UTF-8");
    a.add("forContext", true);
    a.add("forReport", true);
    return a;
  }

  private static JsonObject reportItem(OperationOutcomeIssueComponent issue) {
    JsonObject item = new JsonObject();
    item.add("level", levelFor(issue.getSeverity()));
    String description = issue.getDetails() != null && issue.getDetails().hasText()
      ? issue.getDetails().getText()
      : (issue.hasDiagnostics() ? issue.getDiagnostics() : "");
    item.add("description", description);
    String location = locationFor(issue);
    if (location != null && !location.isEmpty()) item.add("location", location);
    if (issue.hasCode()) item.add("type", issue.getCode().toCode());
    if (issue.hasDiagnostics() && issue.getDiagnostics() != null && !issue.getDiagnostics().isEmpty()) {
      item.add("value", issue.getDiagnostics());
    }
    return item;
  }

  private static String locationFor(OperationOutcomeIssueComponent issue) {
    if (issue.hasExpression()) {
      return joinSemicolon(issue.getExpression().stream().map(s -> s.getValue()).toArray(String[]::new));
    }
    if (issue.hasLocation()) {
      return joinSemicolon(issue.getLocation().stream().map(s -> s.getValue()).toArray(String[]::new));
    }
    return null;
  }

  private static String joinSemicolon(String[] parts) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < parts.length; i++) {
      if (i > 0) sb.append("; ");
      if (parts[i] != null) sb.append(parts[i]);
    }
    return sb.toString();
  }

  private static String levelFor(IssueSeverity severity) {
    if (severity == null) return "INFO";
    switch (severity) {
      case FATAL:
      case ERROR:
        return "ERROR";
      case WARNING:
        return "WARNING";
      case INFORMATION:
      default:
        return "INFO";
    }
  }

  private static int severityRank(IssueSeverity sev) {
    switch (sev) {
      case FATAL: return 4;
      case ERROR: return 3;
      case WARNING: return 2;
      case INFORMATION: return 1;
      default: return 0;
    }
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

  /**
   * Compute the TAR {@code result} from issue counts and the caller's {@code failOn} threshold.
   * Mirrors the table in §3.2 of ITB_REST_SPEC.md.
   */
  static String deriveResult(int errors, int warnings, int infos, String failOn) {
    String threshold = failOn == null || failOn.isEmpty() ? "error" : failOn.toLowerCase();
    switch (threshold) {
      case "warning":
        if (errors > 0 || warnings > 0) return "FAILURE";
        return "SUCCESS";
      case "information":
        if (errors > 0 || warnings > 0 || infos > 0) return "FAILURE";
        return "SUCCESS";
      case "error":
      default:
        if (errors > 0) return "FAILURE";
        if (warnings > 0) return "WARNING";
        return "SUCCESS";
    }
  }
}
