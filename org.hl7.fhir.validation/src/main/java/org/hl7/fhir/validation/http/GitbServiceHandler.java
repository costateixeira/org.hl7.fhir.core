package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

import java.io.IOException;

/**
 * Base class for the GITB-aligned REST handlers exposed under {@code /itb/<service>/...}.
 * <p>
 * Each concrete handler declares a {@link ServiceDefinition} and implements
 * {@link #doProcess(String, JsonObject)}. The base class wires up the two
 * GITB endpoint shapes:
 * <ul>
 *   <li>{@code GET  /itb/<svc>/definition} → emits the service definition</li>
 *   <li>{@code POST /itb/<svc>/process}    → parses {@code {operation, inputs}} and dispatches</li>
 * </ul>
 * Inputs are a flat string-keyed JSON object (no AnyContent wrapper).
 * Responses follow the shapes in {@code gitb-openapi.json}: the simple
 * {@code ProcessResponse} or, where applicable, {@code ValidationResponse}.
 */
abstract class GitbServiceHandler extends BaseHTTPHandler implements HttpHandler {

  protected final FhirValidatorHttpService service;
  private final String pathPrefix;

  protected GitbServiceHandler(FhirValidatorHttpService service, String pathPrefix) {
    this.service = service;
    this.pathPrefix = pathPrefix;
  }

  @Override
  public final void handle(HttpExchange exchange) throws IOException {
    String path = exchange.getRequestURI().getPath();
    String suffix = path.startsWith(pathPrefix) ? path.substring(pathPrefix.length()) : path;
    if (suffix.endsWith("/")) {
      suffix = suffix.substring(0, suffix.length() - 1);
    }
    String method = exchange.getRequestMethod();

    try {
      if ("GET".equalsIgnoreCase(method) && "/definition".equals(suffix)) {
        sendJson(exchange, 200, buildDefinition().toJson());
        return;
      }
      if ("POST".equalsIgnoreCase(method) && "/process".equals(suffix)) {
        handleProcess(exchange);
        return;
      }
      sendResponse(exchange, 404, "Not found", "text/plain");
    } catch (Throwable t) {
      sendResponse(exchange, 500, "Internal error: " + t.getMessage(), "text/plain");
    }
  }

  private void handleProcess(HttpExchange exchange) throws IOException {
    byte[] body = readRequestBody(exchange);
    JsonObject req;
    try {
      req = body.length == 0 ? new JsonObject() : JsonParser.parseObject(body);
    } catch (Exception e) {
      sendJson(exchange, 400, gitbFailure("Malformed JSON: " + e.getMessage()));
      return;
    }
    String operation = req.has("operation") ? req.asString("operation") : null;
    if (operation == null || operation.isEmpty()) {
      sendJson(exchange, 400, gitbFailure("Missing required field: operation"));
      return;
    }
    JsonObject inputs = req.has("inputs") && req.get("inputs").isJsonObject()
      ? req.getJsonObject("inputs")
      : new JsonObject();
    try {
      JsonObject result = doProcess(operation, inputs);
      sendJson(exchange, 200, result);
    } catch (MissingInputException e) {
      sendJson(exchange, 400, gitbFailure(e.getMessage()));
    } catch (UnknownOperationException e) {
      sendJson(exchange, 400, gitbFailure(e.getMessage()));
    } catch (Throwable t) {
      sendJson(exchange, 500, gitbFailure(t.getClass().getSimpleName() + ": " + t.getMessage()));
    }
  }

  /** Build the GITB ServiceDefinition for this service. */
  protected abstract ServiceDefinition buildDefinition();

  /** Execute one operation and return the GITB response body. */
  protected abstract JsonObject doProcess(String operation, JsonObject inputs) throws Exception;

  // ------- input helpers -------

  protected static String requireInput(JsonObject inputs, String name) {
    String v = inputs.has(name) ? inputs.asString(name) : null;
    if (v == null || v.isEmpty()) {
      throw new MissingInputException("Missing required input: " + name);
    }
    return v;
  }

  protected static String optionalInput(JsonObject inputs, String name, String defaultValue) {
    if (!inputs.has(name)) return defaultValue;
    String v = inputs.asString(name);
    return v == null ? defaultValue : v;
  }

  protected static boolean optionalBooleanInput(JsonObject inputs, String name, boolean defaultValue) {
    if (!inputs.has(name)) return defaultValue;
    String v = inputs.asString(name);
    if (v == null) return defaultValue;
    return Boolean.parseBoolean(v);
  }

  // ------- response builders -------

  /** Build a {@code ProcessResponse} with {@code result: SUCCESS} and the given flat output. */
  protected static JsonObject gitbSuccess(JsonObject output) {
    JsonObject o = new JsonObject();
    o.add("result", "SUCCESS");
    o.add("output", output);
    return o;
  }

  protected static JsonObject gitbSuccess() {
    return gitbSuccess(new JsonObject());
  }

  /** Build a {@code ProcessResponse} with {@code result: FAILURE} and an error message. */
  protected static JsonObject gitbFailure(String error) {
    JsonObject o = new JsonObject();
    o.add("result", "FAILURE");
    o.add("error", error);
    return o;
  }

  // ------- transport -------

  protected void sendJson(HttpExchange exchange, int statusCode, JsonObject body) throws IOException {
    String text = JsonParser.compose(body, true);
    sendResponse(exchange, statusCode, text, "application/json");
  }

  // ------- definition descriptors -------

  /** Definition descriptor mirroring {@code components.schemas.ServiceDefinition} in gitb-openapi.json. */
  protected static final class ServiceDefinition {
    private final String id;
    private final String[] operations;
    private final InputDef[] inputs;
    private final OutputDef[] outputs;

    ServiceDefinition(String id, String[] operations, InputDef[] inputs, OutputDef[] outputs) {
      this.id = id;
      this.operations = operations;
      this.inputs = inputs;
      this.outputs = outputs;
    }

    JsonObject toJson() {
      JsonObject d = new JsonObject();
      d.add("id", id);
      JsonArray ops = new JsonArray();
      for (String op : operations) ops.add(op);
      d.add("operations", ops);
      JsonArray ins = new JsonArray();
      for (InputDef i : inputs) {
        JsonObject io = new JsonObject();
        io.add("name", i.name);
        io.add("type", i.type);
        io.add("required", i.required);
        ins.add(io);
      }
      d.add("inputs", ins);
      JsonArray outs = new JsonArray();
      for (OutputDef o : outputs) {
        JsonObject oo = new JsonObject();
        oo.add("name", o.name);
        oo.add("type", o.type);
        outs.add(oo);
      }
      d.add("outputs", outs);
      return d;
    }
  }

  protected static final class InputDef {
    final String name;
    final String type;
    final boolean required;
    InputDef(String name, String type, boolean required) {
      this.name = name;
      this.type = type;
      this.required = required;
    }
  }

  protected static final class OutputDef {
    final String name;
    final String type;
    OutputDef(String name, String type) {
      this.name = name;
      this.type = type;
    }
  }

  /** Thrown by {@link #requireInput} when an input is absent or empty. Mapped to HTTP 400. */
  protected static final class MissingInputException extends RuntimeException {
    MissingInputException(String message) { super(message); }
  }

  /** Thrown by handlers when the {@code operation} is not in the service's catalogue. Mapped to HTTP 400. */
  protected static final class UnknownOperationException extends RuntimeException {
    UnknownOperationException(String operation, String supported) {
      super("Unknown operation: " + operation + ". Supported: " + supported);
    }
  }
}
