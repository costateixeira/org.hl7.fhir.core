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
 * GITB-aligned test data generator at {@code /itb/testdata}.
 * Operations: {@code generate} (single resource), {@code generateBundle} (wrapped in a Bundle).
 * Inputs: {@code profile} (canonical URL), and optional {@code mappings} / {@code data}
 * as stringified JSON arrays.
 */
@Slf4j
class GitbTestDataHandler extends GitbServiceHandler {

  GitbTestDataHandler(FhirValidatorHttpService service) {
    super(service, "/itb/testdata");
  }

  @Override
  protected ServiceDefinition buildDefinition() {
    return new ServiceDefinition(
      "TestDataGenerator",
      new String[]{"generate", "generateBundle"},
      new InputDef[]{
        new InputDef("profile", "string", true),
        new InputDef("mappings", "string", false),
        new InputDef("data", "string", false)
      },
      new OutputDef[]{
        new OutputDef("resource", "string")
      });
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    boolean asBundle;
    switch (operation) {
      case "generate":
        asBundle = false;
        break;
      case "generateBundle":
        asBundle = true;
        break;
      default:
        throw new UnknownOperationException(operation, "generate, generateBundle");
    }

    String profileUrl = requireInput(inputs, "profile");
    String mappingsStr = optionalInput(inputs, "mappings", null);
    String dataStr = optionalInput(inputs, "data", null);

    JsonArray data = parseArrayOrEmpty(dataStr);
    JsonArray mappings = parseArrayOrEmpty(mappingsStr);
    if (data.size() == 0) {
      data.add(new JsonObject());
    }

    ValidationEngine engine = service.getValidationEngine();
    byte[] result;
    try {
      result = engine.generateTestData(profileUrl, data, mappings.size() == 0 ? null : mappings, FhirFormat.JSON, asBundle);
    } catch (Throwable t) {
      log.warn("GITB test-data generate failed", t);
      return gitbFailure("Test data generation failed: " + t.getMessage());
    }

    JsonObject output = new JsonObject();
    output.add("resource", new String(result, StandardCharsets.UTF_8));
    return gitbSuccess(output);
  }

  private static JsonArray parseArrayOrEmpty(String json) {
    if (json == null || json.trim().isEmpty()) return new JsonArray();
    try {
      JsonElement parsed = JsonParser.parse(json);
      if (!parsed.isJsonArray()) {
        throw new IllegalArgumentException("Expected JSON array");
      }
      return parsed.asJsonArray();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid JSON array: " + e.getMessage());
    }
  }
}
