package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB-aligned FHIRPath processor at {@code /itb/fhirpath}.
 * Operations: {@code evaluate}, {@code assert}.
 * <p>
 * {@code evaluate} returns the FHIRPath result as a string. {@code assert} is a
 * thin wrapper that succeeds only when the expression evaluates to a singleton
 * {@code true}; any other value (false, empty, non-Boolean) yields FAILURE.
 */
@Slf4j
class GitbFhirPathHandler extends GitbServiceHandler {

  GitbFhirPathHandler(FhirValidatorHttpService service) {
    super(service, "/itb/fhirpath");
  }

  @Override
  protected ServiceDefinition buildDefinition() {
    return new ServiceDefinition(
      "FHIRPathProcessor",
      new String[]{"evaluate", "assert"},
      new InputDef[]{
        new InputDef("content", "string", true),
        new InputDef("expression", "string", true)
      },
      new OutputDef[]{
        new OutputDef("result", "string")
      });
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    switch (operation) {
      case "evaluate":
        return doEvaluate(inputs);
      case "assert":
        return doAssert(inputs);
      default:
        throw new UnknownOperationException(operation, "evaluate, assert");
    }
  }

  private JsonObject doEvaluate(JsonObject inputs) {
    String content = requireInput(inputs, "content");
    String expression = requireInput(inputs, "expression");
    String result;
    try {
      ValidationEngine engine = service.getValidationEngine();
      result = engine.evaluateFhirPath(content.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON, expression);
    } catch (Throwable t) {
      return gitbFailure("FHIRPath evaluation failed: " + t.getMessage());
    }
    JsonObject output = new JsonObject();
    output.add("result", result == null ? "" : result);
    return gitbSuccess(output);
  }

  private JsonObject doAssert(JsonObject inputs) {
    String content = requireInput(inputs, "content");
    String expression = requireInput(inputs, "expression");
    String result;
    try {
      ValidationEngine engine = service.getValidationEngine();
      result = engine.evaluateFhirPath(content.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON, expression);
    } catch (Throwable t) {
      return gitbFailure("FHIRPath evaluation failed: " + t.getMessage());
    }

    JsonObject output = new JsonObject();
    output.add("result", result == null ? "" : result);

    if ("true".equalsIgnoreCase(result)) {
      return gitbSuccess(output);
    }
    JsonObject response = new JsonObject();
    response.add("result", "FAILURE");
    response.add("output", output);
    String reason = (result == null || result.isEmpty())
      ? "Expression returned empty result"
      : ("false".equalsIgnoreCase(result) ? "Expression evaluated to false" : "Expression did not evaluate to a Boolean: " + result);
    response.add("error", reason);
    return response;
  }
}
