package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Processing Service for test-data generation at {@code /itb/testdata}.
 * Operations: {@code generate} (single resource), {@code generateBundle}
 * (resource wrapped in a Bundle).
 */
@Slf4j
class GitbTestDataHandler extends GitbProcessingServiceHandler {

  GitbTestDataHandler(FhirValidatorHttpService service) {
    super(service, "/itb/testdata");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("profile",      "string",  true,  "Canonical URL of the StructureDefinition to generate against."),
      new TypedParam("mappings",     "string",  false, "Optional stringified JSON array of mapping objects."),
      new TypedParam("data",         "string",  false, "Optional stringified JSON array of data rows."),
      new TypedParam("requiredOnly", "boolean", false, "When true, only populate required elements (min > 0). Default false.")
    );
    JsonObject outputs = typedParameters(
      new TypedParam("resource", "binary", true, "Generated FHIR resource as stringified JSON.")
    );
    return processingModule(
      "TestDataGenerator",
      metadata("FHIR Test Data Generator", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Synthesises FHIR resources from a profile, optional mappings, and optional row data."),
      new ProcessingOperation("generate",       inputs, outputs),
      new ProcessingOperation("generateBundle", inputs, outputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    boolean asBundle;
    if (operation == null || operation.isEmpty() || "generate".equals(operation)) {
      asBundle = false;
    } else if ("generateBundle".equals(operation)) {
      asBundle = true;
    } else {
      throw new UnknownOperationException(operation, "generate, generateBundle");
    }

    String profileUrl = requireInput(input, "profile");
    String mappingsStr = optionalInput(input, "mappings", null);
    String dataStr = optionalInput(input, "data", null);
    boolean requiredOnly = "true".equalsIgnoreCase(optionalInput(input, "requiredOnly", "false"));

    JsonArray data = parseArrayOrEmpty(dataStr);
    JsonArray mappings = parseArrayOrEmpty(mappingsStr);
    if (data.size() == 0) data.add(new JsonObject());

    ValidationEngine engine = service.getValidationEngine();
    byte[] result;
    try {
      result = engine.generateTestData(profileUrl, data,
        mappings.size() == 0 ? null : mappings, FhirFormat.JSON, asBundle, requiredOnly);
    } catch (Throwable t) {
      log.warn("GITB test-data generate failed", t);
      throw new RuntimeException("Test data generation failed: " + t.getMessage(), t);
    }

    JsonArray output = new JsonArray();
    output.add(anyContent("resource", new String(result, StandardCharsets.UTF_8), "application/fhir+json"));
    return ProcessResult.ofOutput(output);
  }

  private static JsonArray parseArrayOrEmpty(String json) {
    if (json == null || json.trim().isEmpty()) return new JsonArray();
    try {
      JsonElement parsed = JsonParser.parse(json);
      if (!parsed.isJsonArray()) {
        throw new InvalidInputException("Expected JSON array");
      }
      return parsed.asJsonArray();
    } catch (InvalidInputException e) {
      throw e;
    } catch (Exception e) {
      throw new InvalidInputException("Invalid JSON array: " + e.getMessage());
    }
  }
}
