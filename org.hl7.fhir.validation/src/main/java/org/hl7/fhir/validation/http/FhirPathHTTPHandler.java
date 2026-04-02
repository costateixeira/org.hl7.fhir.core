package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.util.Map;

/**
 * Handler for evaluating FHIRPath expressions against a resource.
 */
class FhirPathHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public FhirPathHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
      String expression = params.get("expression");

      byte[] resourceBytes = readRequestBody(exchange);
      String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
      FhirFormat format = determineFormat(contentType);

      // If expression not in query string, try to read from JSON body wrapper
      if ((expression == null || expression.trim().isEmpty()) && contentType != null && contentType.contains("json")) {
        try {
          org.hl7.fhir.utilities.json.model.JsonObject wrapper = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(resourceBytes);
          if (wrapper.has("expression")) {
            expression = wrapper.asString("expression");
            // Re-extract the resource from the wrapper
            if (wrapper.has("resource")) {
              if (wrapper.hasObject("resource")) {
                resourceBytes = org.hl7.fhir.utilities.json.parser.JsonParser.composeBytes(wrapper.getJsonObject("resource"));
              } else {
                resourceBytes = wrapper.asString("resource").getBytes(java.nio.charset.StandardCharsets.UTF_8);
              }
            }
          }
        } catch (Exception e) {
          // Not a wrapper object — treat body as the FHIR resource itself (original behavior)
        }
      }

      if (expression == null || expression.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required parameter: expression (provide as query parameter or in JSON body)"), getAcceptHeader(exchange));
        return;
      }

      String result = fhirValidatorHttpService.getValidationEngine().evaluateFhirPath(resourceBytes, format, expression);

      Parameters parameters = new Parameters();
      parameters.addParameter("expression", expression);
      parameters.addParameter("result", result);
      sendResource(exchange, 200, parameters, getAcceptHeader(exchange));

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("FHIRPath evaluation failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
