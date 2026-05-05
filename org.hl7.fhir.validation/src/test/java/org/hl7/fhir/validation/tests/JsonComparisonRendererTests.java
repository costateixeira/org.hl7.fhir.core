package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.hl7.fhir.r5.comparison.ComparisonSession;
import org.hl7.fhir.r5.comparison.JsonComparisonRenderer;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Exercises the new {@link JsonComparisonRenderer} via a real
 * {@link ComparisonSession} that compares two FHIR R4 base StructureDefinitions.
 * Confirms the per-comparison and index JSON files are written and have the
 * expected top-level shape — a regression guard for the JSON output that the
 * test-workbench / external tooling will consume.
 */
class JsonComparisonRendererTests {

  private static ValidationEngine engine;
  private static IWorkerContext context;

  @BeforeAll
  static void setup() throws Exception {
    engine = TestUtilities.getValidationEngine(
      "hl7.fhir.r4.core#4.0.1",
      FhirSettings.getTxFhirDevelopment(),
      FhirPublication.R4, "4.0.1");
    context = engine.getContext();
  }

  /**
   * The comparer rejects base SDs ({@code derivation=specialization}). Build a
   * minimal constraint-derived profile by cloning the Patient base SD and
   * flipping derivation so the test stays self-contained.
   */
  private static StructureDefinition derivePatient(String url, String name) {
    StructureDefinition base = context.fetchResource(StructureDefinition.class,
      "http://hl7.org/fhir/StructureDefinition/Patient");
    assertNotNull(base, "Patient base SD must be loaded");
    StructureDefinition sd = base.copy();
    sd.setUrl(url);
    sd.setName(name);
    sd.setTitle(name);
    sd.setId(name);
    sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Patient");
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    return sd;
  }

  @Test
  @DisplayName("Comparing two profiles emits index.json + per-comparison json + viewer.html")
  void rendersProfileComparisonJson(@TempDir Path tempDir) throws Exception {
    StructureDefinition left  = derivePatient("http://example.org/fhir/PatientLeft",  "PatientLeft");
    StructureDefinition right = derivePatient("http://example.org/fhir/PatientRight", "PatientRight");

    ComparisonSession session = new ComparisonSession(
      new RenderingI18nContext(), context, context, "Patient vs Patient (renamed)", null, null);
    session.compare(left, right);

    String dest = tempDir.toFile().getAbsolutePath();
    String indexPath = new JsonComparisonRenderer(session, dest).render();

    File indexFile = new File(indexPath);
    assertTrue(indexFile.exists(), "index.json must exist at " + indexPath);

    JsonObject index = JsonParser.parseObject(Files.readString(indexFile.toPath()));
    assertEquals("Patient vs Patient (renamed)", index.asString("title"));
    JsonArray comparisons = index.getJsonArray("comparisons");
    assertEquals(1, comparisons.size(), "exactly one comparison expected");

    JsonObject entry = comparisons.get(0).asJsonObject();
    assertEquals("ProfileComparison", entry.asString("type"));
    assertEquals("StructureDefinition", entry.asString("fhirType"));
    String compFile = entry.asString("file");
    assertNotNull(compFile, "index entry must reference a per-comparison file");

    JsonObject body = JsonParser.parseObject(Files.readString(new File(dest, compFile).toPath()));
    assertEquals(entry.asString("id"), body.asString("id"));
    assertEquals("ProfileComparison", body.asString("type"));
    assertNotNull(body.get("left"),  "body must include left summary");
    assertNotNull(body.get("right"), "body must include right summary");
    assertNotNull(body.get("summary"), "body must include summary counts");
    assertNotNull(body.get("metadata"), "body must include metadata array");
    JsonArray meta = body.getJsonArray("metadata");
    assertTrue(meta.size() > 0, "metadata array must be populated");
    assertNotNull(body.get("elements"), "body must include the structural elements tree");
    assertNotNull(body.get("links"), "body must include links to html/union/intersection");
  }

  @Test
  @DisplayName("Index entry for a comparison includes summary counts and a reference file")
  void indexEntryIncludesSummary(@TempDir Path tempDir) throws Exception {
    StructureDefinition left  = derivePatient("http://example.org/fhir/PA", "PA");
    StructureDefinition right = derivePatient("http://example.org/fhir/PB", "PB");

    ComparisonSession session = new ComparisonSession(
      new RenderingI18nContext(), context, context, "PA vs PB", null, null);
    session.compare(left, right);

    String dest = tempDir.toFile().getAbsolutePath();
    new JsonComparisonRenderer(session, dest).render();

    JsonObject index = JsonParser.parseObject(Files.readString(new File(dest, "index.json").toPath()));
    JsonObject entry = index.getJsonArray("comparisons").get(0).asJsonObject();
    JsonObject summary = entry.getJsonObject("summary");
    assertNotNull(summary.asInteger("errors"),      "summary.errors must be present");
    assertNotNull(summary.asInteger("warnings"),    "summary.warnings must be present");
    assertNotNull(summary.asInteger("information"), "summary.information must be present");
    String compFile = entry.asString("file");
    assertTrue(new File(dest, compFile).exists(), "per-comparison file referenced from index must exist");
  }

  @Test
  @DisplayName("Per-comparison body has elements tree, metadata, summary and links")
  void perComparisonBodyShape(@TempDir Path tempDir) throws Exception {
    StructureDefinition left  = derivePatient("http://example.org/fhir/V1", "V1");
    StructureDefinition right = derivePatient("http://example.org/fhir/V2", "V2");
    ComparisonSession session = new ComparisonSession(
      new RenderingI18nContext(), context, context, "Body shape", null, null);
    session.compare(left, right);

    String dest = tempDir.toFile().getAbsolutePath();
    new JsonComparisonRenderer(session, dest).render();

    JsonObject index = JsonParser.parseObject(Files.readString(new File(dest, "index.json").toPath()));
    String compFile = index.getJsonArray("comparisons").get(0).asJsonObject().asString("file");

    JsonObject body = JsonParser.parseObject(Files.readString(new File(dest, compFile).toPath()));
    assertNotNull(body.get("elements"), "body must include the elements tree");
    assertNotNull(body.getJsonObject("links").asString("html"), "links.html must be set");
    assertNotNull(body.getJsonObject("links").asString("union"), "links.union must be set");
    assertNotNull(body.getJsonObject("links").asString("intersection"), "links.intersection must be set");
  }
}
