package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * GITB-aligned wrapper around {@link ValidationEngine#validate} and the IG loader.
 * <p>
 * Path prefix {@code /itb/fhir}. Operations: {@code validate}, {@code loadIG}.
 * Inputs are flat strings (see ITB review feedback in §2.4 of {@code ITB_REST_SPEC.md});
 * {@code contentType} selects the wire format. The {@code validate} response carries
 * a full TAR with the OperationOutcome (always) and the validated content (when
 * {@code includeContentInReport=true}, the default) in {@code report.context}.
 */
@Slf4j
class GitbFhirHandler extends GitbServiceHandler {

  GitbFhirHandler(FhirValidatorHttpService service) {
    super(service, "/itb/fhir");
  }

  @Override
  protected ServiceDefinition buildDefinition() {
    return new ServiceDefinition(
      "FHIRValidator",
      new String[]{"validate", "loadIG"},
      new InputDef[]{
        new InputDef("content", "string", false),
        new InputDef("contentType", "string", false),
        new InputDef("profiles", "string", false),
        new InputDef("bpWarnings", "string", false),
        new InputDef("resourceIdRule", "string", false),
        new InputDef("displayWarnings", "string", false),
        new InputDef("failOn", "string", false),
        new InputDef("includeContentInReport", "string", false),
        new InputDef("ig", "string", false)
      },
      new OutputDef[]{
        new OutputDef("outcome", "string"),
        new OutputDef("severity", "string"),
        new OutputDef("errors", "string"),
        new OutputDef("warnings", "string"),
        new OutputDef("loaded", "string")
      });
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    switch (operation) {
      case "validate":
        return doValidate(inputs);
      case "loadIG":
        return doLoadIg(inputs);
      default:
        throw new UnknownOperationException(operation, "validate, loadIG");
    }
  }

  private JsonObject doValidate(JsonObject inputs) {
    String content = requireInput(inputs, "content");
    String contentType = optionalInput(inputs, "contentType", "application/fhir+json");
    String profilesStr = optionalInput(inputs, "profiles", null);
    String bpWarnings = optionalInput(inputs, "bpWarnings", null);
    String resourceIdRule = optionalInput(inputs, "resourceIdRule", null);
    String failOn = optionalInput(inputs, "failOn", "error");
    boolean includeContentInReport = optionalBooleanInput(inputs, "includeContentInReport", true);

    InstanceValidatorParameters params = new InstanceValidatorParameters();
    if (profilesStr != null) {
      for (String p : profilesStr.split(",")) {
        String trimmed = p.trim();
        if (!trimmed.isEmpty()) params.addProfile(trimmed);
      }
    }
    if (bpWarnings != null) {
      try {
        params.setBestPracticeLevel(BestPracticeWarningLevel.valueOf(bpWarnings));
      } catch (IllegalArgumentException ignored) {
        // leave at default
      }
    }
    if (resourceIdRule != null) {
      try {
        params.setResourceIdRule(IdStatus.fromCode(resourceIdRule));
      } catch (Exception ignored) {
        // leave at default
      }
    }

    FhirFormat format = formatFor(contentType);
    byte[] sourceBytes = content.getBytes(StandardCharsets.UTF_8);
    ValidationEngine engine = service.getValidationEngine();

    OperationOutcome outcome;
    try {
      outcome = engine.validate("gitb-validate", ByteProvider.forBytes(sourceBytes), format, params, new ArrayList<>());
    } catch (Throwable t) {
      log.warn("GITB validate failed", t);
      return GitbTarBuilder.undefinedResponse(t.getClass().getSimpleName() + ": " + t.getMessage(), null, validatorVersion(engine));
    }

    String outcomeJson;
    try {
      outcomeJson = serializeOutcome(outcome);
    } catch (Throwable t) {
      return GitbTarBuilder.undefinedResponse("Could not serialise OperationOutcome: " + t.getMessage(), null, validatorVersion(engine));
    }

    String contentForReport = includeContentInReport ? content : null;
    return GitbTarBuilder.validationResponse(outcome, outcomeJson, contentForReport, contentType, failOn, null, validatorVersion(engine));
  }

  private JsonObject doLoadIg(JsonObject inputs) throws Exception {
    String ig = requireInput(inputs, "ig");
    ValidationEngine engine = service.getValidationEngine();
    log.info("GITB loadIG: " + ig);
    engine.getIgLoader().loadIg(engine.getIgs(), engine.getBinaries(), ig, false);
    log.info("GITB loadIG complete: " + ig);
    JsonObject output = new JsonObject();
    output.add("loaded", ig);
    return gitbSuccess(output);
  }

  private static FhirFormat formatFor(String contentType) {
    if (contentType == null) return FhirFormat.JSON;
    String ct = contentType.toLowerCase();
    if (ct.contains("xml")) return FhirFormat.XML;
    if (ct.contains("turtle")) return FhirFormat.TURTLE;
    return FhirFormat.JSON;
  }

  private static String serializeOutcome(OperationOutcome outcome) throws java.io.IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new JsonParser().compose(baos, outcome);
    return baos.toString(StandardCharsets.UTF_8.name());
  }

  private static String validatorVersion(ValidationEngine engine) {
    String mavenVersion = GitbFhirHandler.class.getPackage().getImplementationVersion();
    if (mavenVersion != null && !mavenVersion.isEmpty()) return mavenVersion;
    String fhirVersion = engine != null ? engine.getVersion() : null;
    return fhirVersion != null ? "fhir-" + fhirVersion : "dev";
  }
}
