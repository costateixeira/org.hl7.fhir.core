package org.hl7.fhir.r5.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.hl7.fhir.r5.comparison.CapabilityStatementComparer.CapabilityStatementComparison;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.comparison.ResourceComparer.MessageCounts;
import org.hl7.fhir.r5.comparison.ResourceComparer.ResourceComparison;
import org.hl7.fhir.r5.comparison.StructureDefinitionComparer.ElementDefinitionNode;
import org.hl7.fhir.r5.comparison.StructureDefinitionComparer.ProfileComparison;
import org.hl7.fhir.r5.comparison.ValueSetComparer.ValueSetComparison;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.validation.ValidationMessage;

/**
 * Companion to {@link ComparisonRenderer}: emits a machine-readable JSON view
 * of a {@link ComparisonSession}'s results, in addition to (not instead of) the
 * HTML view. Run both: HTML is for humans, JSON is for tooling.
 *
 * <h3>Output</h3>
 * <ul>
 *   <li>{@code &lt;folder&gt;/index.json} — list of all comparisons in the session, with a
 *       per-entry summary (errors / warnings / information counts) and a pointer to
 *       the per-comparison file.</li>
 *   <li>{@code &lt;folder&gt;/&lt;id&gt;.json} — one file per comparison containing the full
 *       comparison report: left/right canonical info, top-level messages, the metadata
 *       diff map, and the type-specific structural diff tree.</li>
 * </ul>
 *
 * <p>The {@code &lt;id&gt;-union.json} and {@code &lt;id&gt;-intersection.json} files
 * (the synthesised StructureDefinition / ValueSet / CodeSystem) continue to be
 * produced by {@link ComparisonRenderer}; this renderer references them via
 * {@code links} but does not duplicate their contents.</p>
 *
 * <h3>Shape</h3>
 * Each {@code StructuralMatch&lt;T&gt;} node serialises to:
 * <pre>
 *   {
 *     "name":     "...",        // optional, when set on the match
 *     "left":     ...,          // T-specific JSON, present iff hasLeft()
 *     "right":    ...,          // T-specific JSON, present iff hasRight()
 *     "messages": [{ "severity":"error|warning|information", ... }],
 *     "children": [ &lt;same shape&gt;, ... ]
 *   }
 * </pre>
 */
@MarkedToMoveToAdjunctPackage
public class JsonComparisonRenderer {

  private final ComparisonSession session;
  private final String folder;

  public JsonComparisonRenderer(ComparisonSession session, String folder) {
    this.session = session;
    this.folder = folder;
  }

  // ------------------------------------------------------------------
  // Top-level
  // ------------------------------------------------------------------

  /**
   * Walk every comparison in the session, emit one {@code &lt;id&gt;.json} per
   * comparison plus an aggregate {@code index.json}. Returns the index file path.
   */
  public String render() throws IOException {
    JsonObject index = new JsonObject();
    if (session.getTitle() != null) index.add("title", session.getTitle());

    JsonArray entries = new JsonArray();
    for (String id : sorted(session.getCompares().keySet())) {
      ResourceComparison comp = session.getCompares().get(id);
      JsonObject body;
      try {
        body = renderComparison(comp);
      } catch (Throwable t) {
        // One bad comparison must not kill the whole index — record a stub.
        body = errorStub(comp, t);
      }
      if (body == null) continue;
      String filename = comp.getId() + ".json";
      try {
        writeJson(filename, body);
      } catch (IOException e) {
        body = errorStub(comp, e);
      }

      JsonObject entry = new JsonObject();
      entry.add("id", comp.getId());
      entry.add("type", body.asString("type"));
      entry.add("fhirType", comp.fhirType());
      if (body.has("left"))  entry.add("left",  body.get("left"));
      if (body.has("right")) entry.add("right", body.get("right"));
      entry.add("summary", summaryFor(comp));
      entry.add("file", filename);
      entries.add(entry);
    }
    index.add("comparisons", entries);

    String indexPath = Utilities.path(folder, "index.json");
    try (java.io.OutputStream out = ManagedFileAccess.outStream(indexPath)) {
      JsonParser.compose(index, out, true);
    }
    return indexPath;
  }

  // ------------------------------------------------------------------
  // Per-type rendering
  // ------------------------------------------------------------------

  private JsonObject renderComparison(ResourceComparison comp) {
    if (comp instanceof ProfileComparison)            return renderProfile((ProfileComparison) comp);
    if (comp instanceof ValueSetComparison)           return renderValueSet((ValueSetComparison) comp);
    if (comp instanceof CodeSystemComparison)         return renderCodeSystem((CodeSystemComparison) comp);
    if (comp instanceof CapabilityStatementComparison) return renderCapabilityStatement((CapabilityStatementComparison) comp);
    return null;
  }

  /** Stub body recorded when rendering throws — keeps the index well-formed. */
  private JsonObject errorStub(ResourceComparison comp, Throwable t) {
    JsonObject o = new JsonObject();
    o.add("id", comp.getId());
    o.add("type", comp.fhirType() + "Comparison");
    o.add("fhirType", comp.fhirType());
    o.add("summary", summaryFor(comp));
    o.add("error", t.getClass().getSimpleName() + ": " + (t.getMessage() == null ? "" : t.getMessage()));
    return o;
  }

  private JsonObject renderProfile(ProfileComparison comp) {
    JsonObject o = baseFor(comp, "ProfileComparison");
    o.add("elements", structuralMatchToJson(comp.getCombined(), JsonComparisonRenderer::elementNodeToJson));
    return o;
  }

  private JsonObject renderValueSet(ValueSetComparison comp) {
    JsonObject o = baseFor(comp, "ValueSetComparison");
    o.add("includes", structuralMatchToJson(comp.getIncludes(), JsonComparisonRenderer::fhirElementToJson));
    o.add("excludes", structuralMatchToJson(comp.getExcludes(), JsonComparisonRenderer::fhirElementToJson));
    if (comp.getExpansion() != null) {
      o.add("expansion", structuralMatchToJson(comp.getExpansion(), JsonComparisonRenderer::expansionContainsToJson));
    }
    return o;
  }

  private JsonObject renderCodeSystem(CodeSystemComparison comp) {
    JsonObject o = baseFor(comp, "CodeSystemComparison");
    o.add("properties", structuralMatchToJson(comp.getProperties(), JsonComparisonRenderer::fhirElementToJson));
    o.add("filters",    structuralMatchToJson(comp.getFilters(),    JsonComparisonRenderer::fhirElementToJson));
    o.add("concepts",   structuralMatchToJson(comp.getCombined(),   JsonComparisonRenderer::conceptToJson));
    return o;
  }

  private JsonObject renderCapabilityStatement(CapabilityStatementComparison comp) {
    JsonObject o = baseFor(comp, "CapabilityStatementComparison");
    o.add("rests", structuralMatchToJson(comp.getCombined(), JsonComparisonRenderer::fhirElementToJson));
    return o;
  }

  // ------------------------------------------------------------------
  // Common parts (id, left/right, messages, metadata, summary, links)
  // ------------------------------------------------------------------

  private <T extends CanonicalResource> JsonObject baseFor(
      CanonicalResourceComparer.CanonicalResourceComparison<T> comp, String typeLabel) {
    JsonObject o = new JsonObject();
    o.add("id", comp.getId());
    o.add("type", typeLabel);
    o.add("fhirType", comp.fhirType());
    o.add("left",  canonicalSummary(comp.getLeft()));
    o.add("right", canonicalSummary(comp.getRight()));
    o.add("summary", summaryFor(comp));
    o.add("messages", messagesArray(comp.getMessages()));
    o.add("metadata", metadataArray(comp.getMetadata()));
    o.add("links", linksFor(comp));
    return o;
  }

  private static JsonObject canonicalSummary(CanonicalResource r) {
    JsonObject o = new JsonObject();
    if (r == null) return o;
    if (r.hasId())       o.add("id", r.getId());
    if (r.hasUrl())      o.add("url", r.getUrl());
    if (r.hasVersion())  o.add("version", r.getVersion());
    if (r.hasName())     o.add("name", r.getName());
    if (r.hasTitle())    o.add("title", r.getTitle());
    if (r.hasStatus())   o.add("status", r.getStatus().toCode());
    return o;
  }

  private static JsonObject summaryFor(ResourceComparison comp) {
    MessageCounts c = comp.getCounts();
    JsonObject o = new JsonObject();
    o.add("errors", c.getErrors());
    o.add("warnings", c.getWarnings());
    o.add("information", c.getHints());
    return o;
  }

  private static JsonObject linksFor(ResourceComparison comp) {
    JsonObject o = new JsonObject();
    o.add("html", comp.getId() + ".html");
    o.add("union", comp.getId() + "-union.json");
    o.add("intersection", comp.getId() + "-intersection.json");
    return o;
  }

  private static JsonArray metadataArray(Map<String, StructuralMatch<String>> meta) {
    JsonArray arr = new JsonArray();
    if (meta == null) return arr;
    for (String key : sorted(meta.keySet())) {
      JsonObject e = structuralMatchToJson(meta.get(key), JsonComparisonRenderer::stringToJson);
      e.add("field", key);
      arr.add(e);
    }
    return arr;
  }

  private static JsonArray messagesArray(List<ValidationMessage> msgs) {
    JsonArray arr = new JsonArray();
    if (msgs == null) return arr;
    for (ValidationMessage m : msgs) arr.add(messageToJson(m));
    return arr;
  }

  private static JsonObject messageToJson(ValidationMessage m) {
    JsonObject o = new JsonObject();
    if (m.getLevel() != null)    o.add("severity", m.getLevel().toCode());
    if (m.getType() != null)     o.add("type", m.getType().toCode());
    if (m.getLocation() != null) o.add("location", m.getLocation());
    if (m.getMessage() != null)  o.add("text", m.getMessage());
    return o;
  }

  // ------------------------------------------------------------------
  // Generic StructuralMatch<T> walker
  // ------------------------------------------------------------------

  private static <T> JsonObject structuralMatchToJson(StructuralMatch<T> sm, Function<T, ?> conv) {
    JsonObject o = new JsonObject();
    if (sm == null) return o;
    if (sm.getName() != null) o.add("name", sm.getName());
    if (sm.hasLeft())  addAny(o, "left",  conv.apply(sm.getLeft()));
    if (sm.hasRight()) addAny(o, "right", conv.apply(sm.getRight()));
    o.add("messages", messagesArray(sm.getMessages()));
    if (!sm.getChildren().isEmpty()) {
      JsonArray children = new JsonArray();
      for (StructuralMatch<T> c : sm.getChildren()) children.add(structuralMatchToJson(c, conv));
      o.add("children", children);
    }
    return o;
  }

  private static void addAny(JsonObject parent, String name, Object value) {
    if (value == null) return;
    if (value instanceof JsonObject)         parent.add(name, (JsonObject) value);
    else if (value instanceof JsonArray)     parent.add(name, (JsonArray) value);
    else if (value instanceof Number)        parent.add(name, ((Number) value).intValue());
    else if (value instanceof Boolean)       parent.add(name, (Boolean) value);
    else                                     parent.add(name, value.toString());
  }

  // ------------------------------------------------------------------
  // Type-specific T → JSON converters
  // ------------------------------------------------------------------

  private static String stringToJson(String s) { return s; }

  /**
   * Generic FHIR Base / DataType / Element serialization for the
   * {@code structuralMatchToJson} walker. Returns either:
   * <ul>
   *   <li>a {@link String} for primitives (FHIR {@code code} / {@code uri} / {@code string} / ...),</li>
   *   <li>a {@link JsonObject} for complex types (composed by the FHIR JSON parser),</li>
   *   <li>a small {@code {"fhirType": "..."}} stub when the value can't be serialised.</li>
   * </ul>
   * Resilient to every FHIR type the comparer can stash into a
   * {@code StructuralMatch} — the renderer must never throw on weird data.
   */
  private static Object fhirElementToJson(org.hl7.fhir.r5.model.Base b) {
    if (b == null) return null;
    if (b.isPrimitive()) {
      // FHIR primitives don't compose as bare values; just return the raw string
      // representation (handled by addAny).
      return ((org.hl7.fhir.r5.model.PrimitiveType<?>) b).primitiveValue();
    }
    if (!(b instanceof org.hl7.fhir.r5.model.DataType)) {
      // BackboneElement etc. — the FHIR JSON composer's value-form doesn't accept
      // these; emit a type stub rather than failing the whole render.
      JsonObject o = new JsonObject();
      o.add("fhirType", b.fhirType());
      return o;
    }
    try {
      java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
      new org.hl7.fhir.r5.formats.JsonParser()
        .setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.NORMAL)
        .compose(baos, (org.hl7.fhir.r5.model.DataType) b, "value");
      JsonObject wrapped = JsonParser.parseObject(baos.toString("UTF-8"));
      if (wrapped.has("value") && wrapped.get("value").isJsonObject()) {
        return wrapped.getJsonObject("value");
      }
      return wrapped;
    } catch (Exception e) {
      JsonObject o = new JsonObject();
      o.add("fhirType", b.fhirType());
      return o;
    }
  }

  /** Compact JSON view of an ElementDefinition node (path, cardinality, types). */
  private static JsonObject elementNodeToJson(ElementDefinitionNode n) {
    JsonObject o = new JsonObject();
    if (n == null) return o;
    ElementDefinition ed = n.getDef();
    if (ed != null) {
      if (ed.hasPath())      o.add("path", ed.getPath());
      if (ed.hasSliceName()) o.add("sliceName", ed.getSliceName());
      if (ed.hasMin())       o.add("min", ed.getMin());
      if (ed.hasMax())       o.add("max", ed.getMax());
      if (ed.hasMustSupport() && ed.getMustSupport()) o.add("mustSupport", true);
      if (ed.hasIsModifier() && ed.getIsModifier()) o.add("isModifier", true);
      if (ed.hasIsSummary() && ed.getIsSummary()) o.add("isSummary", true);
      if (ed.hasShort())     o.add("short", ed.getShort());
      if (ed.hasFixed())     o.add("fixed", ed.getFixed().fhirType());
      if (ed.hasPattern())   o.add("pattern", ed.getPattern().fhirType());
      if (ed.hasType()) {
        JsonArray types = new JsonArray();
        for (TypeRefComponent t : ed.getType()) {
          JsonObject tj = new JsonObject();
          if (t.hasCode()) tj.add("code", t.getCode());
          if (t.hasTargetProfile()) {
            JsonArray targets = new JsonArray();
            t.getTargetProfile().forEach(c -> targets.add(c.getValue()));
            tj.add("targetProfile", targets);
          }
          if (t.hasProfile()) {
            JsonArray profiles = new JsonArray();
            t.getProfile().forEach(c -> profiles.add(c.getValue()));
            tj.add("profile", profiles);
          }
          types.add(tj);
        }
        o.add("types", types);
      }
      if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
        JsonObject b = new JsonObject();
        b.add("strength", ed.getBinding().getStrength().toCode());
        b.add("valueSet", ed.getBinding().getValueSet());
        o.add("binding", b);
      }
    }
    if (n.getSrc() != null && n.getSrc().hasUrl()) {
      o.add("source", n.getSrc().getUrl());
    }
    return o;
  }

  /** Compact JSON view of a CodeSystem concept (code + display only — children come from the tree). */
  private static JsonObject conceptToJson(ConceptDefinitionComponent c) {
    if (c == null) return null;
    JsonObject o = new JsonObject();
    if (c.hasCode())       o.add("code", c.getCode());
    if (c.hasDisplay())    o.add("display", c.getDisplay());
    if (c.hasDefinition()) o.add("definition", c.getDefinition());
    return o;
  }

  /** Compact JSON view of an expansion ContainsComponent (system, code, display). */
  private static JsonObject expansionContainsToJson(ValueSetExpansionContainsComponent c) {
    if (c == null) return null;
    JsonObject o = new JsonObject();
    if (c.hasSystem())  o.add("system", c.getSystem());
    if (c.hasVersion()) o.add("version", c.getVersion());
    if (c.hasCode())    o.add("code", c.getCode());
    if (c.hasDisplay()) o.add("display", c.getDisplay());
    return o;
  }

  // ------------------------------------------------------------------
  // Plumbing
  // ------------------------------------------------------------------

  private void writeJson(String filename, JsonObject body) throws IOException {
    try (java.io.OutputStream out = ManagedFileAccess.outStream(Utilities.path(folder, filename))) {
      JsonParser.compose(body, out, true);
    }
  }

  private static List<String> sorted(java.util.Set<String> keys) {
    List<String> list = new ArrayList<>(keys);
    Collections.sort(list);
    return list;
  }
}
