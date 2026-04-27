package org.hl7.fhir.validation.tests;

import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.http.FhirValidatorHttpService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Integration tests for the GITB-aligned handlers exposed under {@code /itb/...}.
 * <p>
 * Each test starts a real {@link FhirValidatorHttpService} bound to loopback. Engine-free
 * paths (definitions, ValidationResultsProcessor, error handling) use a mocked ValidationEngine;
 * paths that exercise the engine are covered by the broader integration test suite in
 * FhirValidatorHttpServiceTests.
 */
class GitbHttpHandlersTest {

  private static final int TEST_PORT = 18091;
  private static final String BASE_URL = "http://localhost:" + TEST_PORT;

  private FhirValidatorHttpService service;
  private HttpClient client;

  @BeforeEach
  void setUp() throws IOException {
    ValidationEngine engine = mock(ValidationEngine.class);
    service = new FhirValidatorHttpService(engine, true, TEST_PORT);
    service.startServer();
    client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
  }

  @AfterEach
  void tearDown() {
    if (service != null) service.stop();
  }

  // ------------------------------------------------------------------
  // GET /itb/<svc>/definition for every service
  // ------------------------------------------------------------------

  @ParameterizedTest
  @ValueSource(strings = {"fhir", "fhirpath", "matchetype", "testdata", "validationResults"})
  void definitionEndpointReturnsServiceDefinition(String svc) throws Exception {
    HttpResponse<String> response = get("/itb/" + svc + "/definition");
    assertEquals(200, response.statusCode());
    JsonObject body = JsonParser.parseObject(response.body());
    assertTrue(body.has("id"), "definition must include id");
    assertTrue(body.has("operations"), "definition must include operations");
    assertTrue(body.has("inputs"), "definition must include inputs");
    assertTrue(body.has("outputs"), "definition must include outputs");
  }

  @Test
  void fhirDefinitionListsValidateAndLoadIg() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/fhir/definition").body());
    assertEquals("FHIRValidator", body.asString("id"));
    assertOperations(body, "validate", "loadIG");
  }

  @Test
  void fhirpathDefinitionListsEvaluateAndAssert() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/fhirpath/definition").body());
    assertEquals("FHIRPathProcessor", body.asString("id"));
    assertOperations(body, "evaluate", "assert");
  }

  @Test
  void validationResultsDefinitionListsAllThreeOperations() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/validationResults/definition").body());
    assertEquals("ValidationResultsProcessor", body.asString("id"));
    assertOperations(body, "summarize", "filterBySeverity", "filterByText");
  }

  // ------------------------------------------------------------------
  // ValidationResultsProcessor — pure JSON, no engine needed
  // ------------------------------------------------------------------

  @Test
  void validationResultsSummarizeCountsBySeverity() throws Exception {
    String outcome = "{\"resourceType\":\"OperationOutcome\",\"issue\":["
      + "{\"severity\":\"error\",\"code\":\"invalid\"},"
      + "{\"severity\":\"error\",\"code\":\"required\"},"
      + "{\"severity\":\"warning\",\"code\":\"informational\"},"
      + "{\"severity\":\"information\",\"code\":\"informational\"}"
      + "]}";
    JsonObject inputs = new JsonObject();
    inputs.add("outcome", outcome);
    JsonObject response = postOperation("/itb/validationResults/process", "summarize", inputs);
    assertEquals("SUCCESS", response.asString("result"));
    JsonObject output = response.getJsonObject("output");
    assertEquals("2", output.asString("errors"));
    assertEquals("1", output.asString("warnings"));
    assertEquals("1", output.asString("information"));
  }

  @Test
  void validationResultsFilterBySeverityCountsAndReturnsFilteredOutcome() throws Exception {
    String outcome = "{\"resourceType\":\"OperationOutcome\",\"issue\":["
      + "{\"severity\":\"error\",\"code\":\"invalid\",\"details\":{\"text\":\"a\"}},"
      + "{\"severity\":\"warning\",\"code\":\"informational\",\"details\":{\"text\":\"b\"}}"
      + "]}";
    JsonObject inputs = new JsonObject();
    inputs.add("outcome", outcome);
    inputs.add("severity", "error");
    JsonObject response = postOperation("/itb/validationResults/process", "filterBySeverity", inputs);
    assertEquals("SUCCESS", response.asString("result"));
    JsonObject output = response.getJsonObject("output");
    assertEquals("1", output.asString("count"));
    JsonObject filtered = JsonParser.parseObject(output.asString("outcome"));
    assertEquals(1, filtered.getJsonArray("issue").size());
  }

  @Test
  void validationResultsFilterByTextMatchesSubstring() throws Exception {
    String outcome = "{\"resourceType\":\"OperationOutcome\",\"issue\":["
      + "{\"severity\":\"error\",\"details\":{\"text\":\"identifier system missing\"}},"
      + "{\"severity\":\"error\",\"details\":{\"text\":\"name required\"}}"
      + "]}";
    JsonObject inputs = new JsonObject();
    inputs.add("outcome", outcome);
    inputs.add("text", "identifier");
    JsonObject response = postOperation("/itb/validationResults/process", "filterByText", inputs);
    JsonObject output = response.getJsonObject("output");
    assertEquals("1", output.asString("count"));
  }

  // ------------------------------------------------------------------
  // Error handling
  // ------------------------------------------------------------------

  @Test
  void processReturns400WhenOperationFieldIsMissing() throws Exception {
    HttpResponse<String> response = post("/itb/validationResults/process", "{\"inputs\":{}}");
    assertEquals(400, response.statusCode());
    JsonObject body = JsonParser.parseObject(response.body());
    assertEquals("FAILURE", body.asString("result"));
    assertThat(body.asString("error")).contains("operation");
  }

  @Test
  void processReturns400WhenRequiredInputIsMissing() throws Exception {
    JsonObject inputs = new JsonObject();
    // outcome is required for summarize but is missing
    HttpResponse<String> response = post("/itb/validationResults/process",
      JsonParser.compose(processBody("summarize", inputs)));
    assertEquals(400, response.statusCode());
    JsonObject body = JsonParser.parseObject(response.body());
    assertEquals("FAILURE", body.asString("result"));
    assertThat(body.asString("error")).contains("Missing required input");
  }

  @Test
  void processReturns400ForUnknownOperation() throws Exception {
    JsonObject inputs = new JsonObject();
    HttpResponse<String> response = post("/itb/validationResults/process",
      JsonParser.compose(processBody("totallyMadeUpOperation", inputs)));
    assertEquals(400, response.statusCode());
    JsonObject body = JsonParser.parseObject(response.body());
    assertEquals("FAILURE", body.asString("result"));
    assertThat(body.asString("error")).contains("Unknown operation");
  }

  @Test
  void processReturns400OnMalformedJson() throws Exception {
    HttpResponse<String> response = post("/itb/validationResults/process", "{not valid json");
    assertEquals(400, response.statusCode());
    JsonObject body = JsonParser.parseObject(response.body());
    assertEquals("FAILURE", body.asString("result"));
    assertThat(body.asString("error")).contains("Malformed JSON");
  }

  @Test
  void unknownPathUnderServicePrefixReturns404() throws Exception {
    HttpResponse<String> response = get("/itb/fhir/somethingElse");
    assertEquals(404, response.statusCode());
  }

  // ------------------------------------------------------------------
  // Helpers
  // ------------------------------------------------------------------

  private static void assertOperations(JsonObject definition, String... expected) {
    JsonObject ops = new JsonObject();
    for (String op : expected) ops.add(op, true);
    for (JsonElement el : definition.getJsonArray("operations")) {
      String name = el.asString();
      ops.remove(name);
    }
    assertTrue(ops.getProperties().isEmpty(), "Expected operations missing: " + ops);
  }

  private HttpResponse<String> get(String path) throws IOException, InterruptedException {
    return client.send(
      HttpRequest.newBuilder().uri(URI.create(BASE_URL + path)).GET().build(),
      HttpResponse.BodyHandlers.ofString());
  }

  private HttpResponse<String> post(String path, String body) throws IOException, InterruptedException {
    return client.send(
      HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + path))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .build(),
      HttpResponse.BodyHandlers.ofString());
  }

  private JsonObject postOperation(String path, String operation, JsonObject inputs) throws IOException, InterruptedException {
    JsonObject body = processBody(operation, inputs);
    HttpResponse<String> response = post(path, JsonParser.compose(body));
    assertEquals(200, response.statusCode(), "Expected 200 OK, got " + response.statusCode() + ": " + response.body());
    return JsonParser.parseObject(response.body());
  }

  private static JsonObject processBody(String operation, JsonObject inputs) {
    JsonObject body = new JsonObject();
    body.add("operation", operation);
    body.add("inputs", inputs);
    return body;
  }

}
