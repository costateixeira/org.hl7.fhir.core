package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * Pure JSON utility — no validation engine needed.
 * <p>
 * GITB-aligned processor at {@code /itb/validationResults}. Operates on a raw
 * FHIR {@code OperationOutcome} provided by the caller.
 * Operations: {@code summarize}, {@code filterBySeverity}, {@code filterByText}.
 */
@Slf4j
class GitbValidationResultsHandler extends GitbServiceHandler {

  GitbValidationResultsHandler(FhirValidatorHttpService service) {
    super(service, "/itb/validationResults");
  }

  @Override
  protected ServiceDefinition buildDefinition() {
    return new ServiceDefinition(
      "ValidationResultsProcessor",
      new String[]{"summarize", "filterBySeverity", "filterByText"},
      new InputDef[]{
        new InputDef("outcome", "string", true),
        new InputDef("severity", "string", false),
        new InputDef("text", "string", false)
      },
      new OutputDef[]{
        new OutputDef("errors", "string"),
        new OutputDef("warnings", "string"),
        new OutputDef("information", "string"),
        new OutputDef("count", "string"),
        new OutputDef("outcome", "string")
      });
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    // Validate the operation before reading inputs so an unknown operation gets a clear error
    // even if the caller also omitted the required inputs.
    switch (operation) {
      case "summarize":
      case "filterBySeverity":
      case "filterByText":
        break;
      default:
        throw new UnknownOperationException(operation, "summarize, filterBySeverity, filterByText");
    }

    String outcomeStr = requireInput(inputs, "outcome");
    JsonObject outcome = parseOutcome(outcomeStr);
    JsonArray issues = outcome.has("issue") && outcome.get("issue").isJsonArray()
      ? outcome.getJsonArray("issue")
      : new JsonArray();

    switch (operation) {
      case "summarize":
        return doSummarize(issues);
      case "filterBySeverity":
        return doFilterBySeverity(outcome, issues, requireInput(inputs, "severity"));
      case "filterByText":
        return doFilterByText(outcome, issues, requireInput(inputs, "text"));
      default:
        throw new UnknownOperationException(operation, "summarize, filterBySeverity, filterByText");
    }
  }

  private JsonObject doSummarize(JsonArray issues) {
    int errors = 0, warnings = 0, infos = 0;
    for (JsonElement el : issues) {
      if (!el.isJsonObject()) continue;
      String sev = el.asJsonObject().asString("severity");
      if (sev == null) continue;
      switch (sev.toLowerCase()) {
        case "fatal":
        case "error":
          errors++;
          break;
        case "warning":
          warnings++;
          break;
        case "information":
          infos++;
          break;
      }
    }
    JsonObject output = new JsonObject();
    output.add("errors", String.valueOf(errors));
    output.add("warnings", String.valueOf(warnings));
    output.add("information", String.valueOf(infos));
    return gitbSuccess(output);
  }

  private JsonObject doFilterBySeverity(JsonObject sourceOutcome, JsonArray issues, String severity) {
    String target = severity.toLowerCase();
    JsonArray filtered = new JsonArray();
    int count = 0;
    for (JsonElement el : issues) {
      if (!el.isJsonObject()) continue;
      String sev = el.asJsonObject().asString("severity");
      if (sev != null && sev.equalsIgnoreCase(target)) {
        filtered.add(el);
        count++;
      }
    }
    return filteredResponse(sourceOutcome, filtered, count);
  }

  private JsonObject doFilterByText(JsonObject sourceOutcome, JsonArray issues, String text) {
    JsonArray filtered = new JsonArray();
    int count = 0;
    for (JsonElement el : issues) {
      if (!el.isJsonObject()) continue;
      JsonObject issue = el.asJsonObject();
      String detailsText = null;
      if (issue.has("details") && issue.get("details").isJsonObject()) {
        detailsText = issue.getJsonObject("details").asString("text");
      }
      if (detailsText != null && detailsText.contains(text)) {
        filtered.add(el);
        count++;
      }
    }
    return filteredResponse(sourceOutcome, filtered, count);
  }

  private JsonObject filteredResponse(JsonObject sourceOutcome, JsonArray filteredIssues, int count) {
    JsonObject filteredOutcome = new JsonObject();
    filteredOutcome.add("resourceType", "OperationOutcome");
    filteredOutcome.add("issue", filteredIssues);

    JsonObject output = new JsonObject();
    output.add("count", String.valueOf(count));
    output.add("outcome", JsonParser.compose(filteredOutcome));
    return gitbSuccess(output);
  }

  private static JsonObject parseOutcome(String s) {
    try {
      return JsonParser.parseObject(s);
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid OperationOutcome JSON: " + e.getMessage());
    }
  }
}
