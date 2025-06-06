package org.hl7.fhir.r4b.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Mon, Jun 13, 2022 17:19+0300 for FHIR v4.3.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r4b.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * The Measure resource provides the definition of a quality measure.
 */
@ResourceDef(name = "Measure", profile = "http://hl7.org/fhir/StructureDefinition/Measure")
public class Measure extends CanonicalResource {

  @Block()
  public static class MeasureGroupComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Indicates a meaning for the group. This can be as simple as a unique
     * identifier, or it can establish meaning in a broader context by drawing from
     * a terminology, allowing groups to be correlated across measures.
     */
    @Child(name = "code", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Meaning of the group", formalDefinition = "Indicates a meaning for the group. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing groups to be correlated across measures.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-group-example")
    protected CodeableConcept code;

    /**
     * The human readable description of this population group.
     */
    @Child(name = "description", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Summary description", formalDefinition = "The human readable description of this population group.")
    protected StringType description;

    /**
     * A population criteria for the measure.
     */
    @Child(name = "population", type = {}, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Population criteria", formalDefinition = "A population criteria for the measure.")
    protected List<MeasureGroupPopulationComponent> population;

    /**
     * The stratifier criteria for the measure report, specified as either the name
     * of a valid CQL expression defined within a referenced library or a valid FHIR
     * Resource Path.
     */
    @Child(name = "stratifier", type = {}, order = 4, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Stratifier criteria for the measure", formalDefinition = "The stratifier criteria for the measure report, specified as either the name of a valid CQL expression defined within a referenced library or a valid FHIR Resource Path.")
    protected List<MeasureGroupStratifierComponent> stratifier;

    private static final long serialVersionUID = -1797567579L;

    /**
     * Constructor
     */
    public MeasureGroupComponent() {
      super();
    }

    /**
     * @return {@link #code} (Indicates a meaning for the group. This can be as
     *         simple as a unique identifier, or it can establish meaning in a
     *         broader context by drawing from a terminology, allowing groups to be
     *         correlated across measures.)
     */
    public CodeableConcept getCode() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Indicates a meaning for the group. This can be as
     *              simple as a unique identifier, or it can establish meaning in a
     *              broader context by drawing from a terminology, allowing groups
     *              to be correlated across measures.)
     */
    public MeasureGroupComponent setCode(CodeableConcept value) {
      this.code = value;
      return this;
    }

    /**
     * @return {@link #description} (The human readable description of this
     *         population group.). This is the underlying object with id, value and
     *         extensions. The accessor "getDescription" gives direct access to the
     *         value
     */
    public StringType getDescriptionElement() {
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupComponent.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() {
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() {
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The human readable description of this
     *              population group.). This is the underlying object with id, value
     *              and extensions. The accessor "getDescription" gives direct
     *              access to the value
     */
    public MeasureGroupComponent setDescriptionElement(StringType value) {
      this.description = value;
      return this;
    }

    /**
     * @return The human readable description of this population group.
     */
    public String getDescription() {
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The human readable description of this population group.
     */
    public MeasureGroupComponent setDescription(String value) {
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #population} (A population criteria for the measure.)
     */
    public List<MeasureGroupPopulationComponent> getPopulation() {
      if (this.population == null)
        this.population = new ArrayList<MeasureGroupPopulationComponent>();
      return this.population;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureGroupComponent setPopulation(List<MeasureGroupPopulationComponent> thePopulation) {
      this.population = thePopulation;
      return this;
    }

    public boolean hasPopulation() {
      if (this.population == null)
        return false;
      for (MeasureGroupPopulationComponent item : this.population)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MeasureGroupPopulationComponent addPopulation() { // 3
      MeasureGroupPopulationComponent t = new MeasureGroupPopulationComponent();
      if (this.population == null)
        this.population = new ArrayList<MeasureGroupPopulationComponent>();
      this.population.add(t);
      return t;
    }

    public MeasureGroupComponent addPopulation(MeasureGroupPopulationComponent t) { // 3
      if (t == null)
        return this;
      if (this.population == null)
        this.population = new ArrayList<MeasureGroupPopulationComponent>();
      this.population.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #population}, creating
     *         it if it does not already exist {3}
     */
    public MeasureGroupPopulationComponent getPopulationFirstRep() {
      if (getPopulation().isEmpty()) {
        addPopulation();
      }
      return getPopulation().get(0);
    }

    /**
     * @return {@link #stratifier} (The stratifier criteria for the measure report,
     *         specified as either the name of a valid CQL expression defined within
     *         a referenced library or a valid FHIR Resource Path.)
     */
    public List<MeasureGroupStratifierComponent> getStratifier() {
      if (this.stratifier == null)
        this.stratifier = new ArrayList<MeasureGroupStratifierComponent>();
      return this.stratifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureGroupComponent setStratifier(List<MeasureGroupStratifierComponent> theStratifier) {
      this.stratifier = theStratifier;
      return this;
    }

    public boolean hasStratifier() {
      if (this.stratifier == null)
        return false;
      for (MeasureGroupStratifierComponent item : this.stratifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MeasureGroupStratifierComponent addStratifier() { // 3
      MeasureGroupStratifierComponent t = new MeasureGroupStratifierComponent();
      if (this.stratifier == null)
        this.stratifier = new ArrayList<MeasureGroupStratifierComponent>();
      this.stratifier.add(t);
      return t;
    }

    public MeasureGroupComponent addStratifier(MeasureGroupStratifierComponent t) { // 3
      if (t == null)
        return this;
      if (this.stratifier == null)
        this.stratifier = new ArrayList<MeasureGroupStratifierComponent>();
      this.stratifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #stratifier}, creating
     *         it if it does not already exist {3}
     */
    public MeasureGroupStratifierComponent getStratifierFirstRep() {
      if (getStratifier().isEmpty()) {
        addStratifier();
      }
      return getStratifier().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "CodeableConcept",
          "Indicates a meaning for the group. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing groups to be correlated across measures.",
          0, 1, code));
      children.add(new Property("description", "string", "The human readable description of this population group.", 0,
          1, description));
      children.add(new Property("population", "", "A population criteria for the measure.", 0,
          java.lang.Integer.MAX_VALUE, population));
      children.add(new Property("stratifier", "",
          "The stratifier criteria for the measure report, specified as either the name of a valid CQL expression defined within a referenced library or a valid FHIR Resource Path.",
          0, java.lang.Integer.MAX_VALUE, stratifier));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "CodeableConcept",
            "Indicates a meaning for the group. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing groups to be correlated across measures.",
            0, 1, code);
      case -1724546052:
        /* description */ return new Property("description", "string",
            "The human readable description of this population group.", 0, 1, description);
      case -2023558323:
        /* population */ return new Property("population", "", "A population criteria for the measure.", 0,
            java.lang.Integer.MAX_VALUE, population);
      case 90983669:
        /* stratifier */ return new Property("stratifier", "",
            "The stratifier criteria for the measure report, specified as either the name of a valid CQL expression defined within a referenced library or a valid FHIR Resource Path.",
            0, java.lang.Integer.MAX_VALUE, stratifier);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case -2023558323:
        /* population */ return this.population == null ? new Base[0]
            : this.population.toArray(new Base[this.population.size()]); // MeasureGroupPopulationComponent
      case 90983669:
        /* stratifier */ return this.stratifier == null ? new Base[0]
            : this.stratifier.toArray(new Base[this.stratifier.size()]); // MeasureGroupStratifierComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1724546052: // description
        this.description = TypeConvertor.castToString(value); // StringType
        return value;
      case -2023558323: // population
        this.getPopulation().add((MeasureGroupPopulationComponent) value); // MeasureGroupPopulationComponent
        return value;
      case 90983669: // stratifier
        this.getStratifier().add((MeasureGroupStratifierComponent) value); // MeasureGroupStratifierComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("description")) {
        this.description = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("population")) {
        this.getPopulation().add((MeasureGroupPopulationComponent) value);
      } else if (name.equals("stratifier")) {
        this.getStratifier().add((MeasureGroupStratifierComponent) value);
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("description")) {
        this.description = null;
      } else if (name.equals("population")) {
        this.getPopulation().remove((MeasureGroupPopulationComponent) value);
      } else if (name.equals("stratifier")) {
        this.getStratifier().remove((MeasureGroupStratifierComponent) value);
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCode();
      case -1724546052:
        return getDescriptionElement();
      case -2023558323:
        return addPopulation();
      case 90983669:
        return addStratifier();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "CodeableConcept" };
      case -1724546052:
        /* description */ return new String[] { "string" };
      case -2023558323:
        /* population */ return new String[] {};
      case 90983669:
        /* stratifier */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        this.code = new CodeableConcept();
        return this.code;
      } else if (name.equals("description")) {
        throw new FHIRException("Cannot call addChild on a singleton property Measure.group.description");
      } else if (name.equals("population")) {
        return addPopulation();
      } else if (name.equals("stratifier")) {
        return addStratifier();
      } else
        return super.addChild(name);
    }

    public MeasureGroupComponent copy() {
      MeasureGroupComponent dst = new MeasureGroupComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(MeasureGroupComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.description = description == null ? null : description.copy();
      if (population != null) {
        dst.population = new ArrayList<MeasureGroupPopulationComponent>();
        for (MeasureGroupPopulationComponent i : population)
          dst.population.add(i.copy());
      }
      ;
      if (stratifier != null) {
        dst.stratifier = new ArrayList<MeasureGroupStratifierComponent>();
        for (MeasureGroupStratifierComponent i : stratifier)
          dst.stratifier.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof MeasureGroupComponent))
        return false;
      MeasureGroupComponent o = (MeasureGroupComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(description, o.description, true)
          && compareDeep(population, o.population, true) && compareDeep(stratifier, o.stratifier, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof MeasureGroupComponent))
        return false;
      MeasureGroupComponent o = (MeasureGroupComponent) other_;
      return compareValues(description, o.description, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, description, population, stratifier);
    }

    public String fhirType() {
      return "Measure.group";

    }

  }

  @Block()
  public static class MeasureGroupPopulationComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * The type of population criteria.
     */
    @Child(name = "code", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "initial-population | numerator | numerator-exclusion | denominator | denominator-exclusion | denominator-exception | measure-population | measure-population-exclusion | measure-observation", formalDefinition = "The type of population criteria.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-population")
    protected CodeableConcept code;

    /**
     * The human readable description of this population criteria.
     */
    @Child(name = "description", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The human readable description of this population criteria", formalDefinition = "The human readable description of this population criteria.")
    protected StringType description;

    /**
     * An expression that specifies the criteria for the population, typically the
     * name of an expression in a library.
     */
    @Child(name = "criteria", type = {
        Expression.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The criteria that defines this population", formalDefinition = "An expression that specifies the criteria for the population, typically the name of an expression in a library.")
    protected Expression criteria;

    private static final long serialVersionUID = 2107514056L;

    /**
     * Constructor
     */
    public MeasureGroupPopulationComponent() {
      super();
    }

    /**
     * Constructor
     */
    public MeasureGroupPopulationComponent(Expression criteria) {
      super();
      this.setCriteria(criteria);
    }

    /**
     * @return {@link #code} (The type of population criteria.)
     */
    public CodeableConcept getCode() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupPopulationComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (The type of population criteria.)
     */
    public MeasureGroupPopulationComponent setCode(CodeableConcept value) {
      this.code = value;
      return this;
    }

    /**
     * @return {@link #description} (The human readable description of this
     *         population criteria.). This is the underlying object with id, value
     *         and extensions. The accessor "getDescription" gives direct access to
     *         the value
     */
    public StringType getDescriptionElement() {
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupPopulationComponent.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() {
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() {
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The human readable description of this
     *              population criteria.). This is the underlying object with id,
     *              value and extensions. The accessor "getDescription" gives direct
     *              access to the value
     */
    public MeasureGroupPopulationComponent setDescriptionElement(StringType value) {
      this.description = value;
      return this;
    }

    /**
     * @return The human readable description of this population criteria.
     */
    public String getDescription() {
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The human readable description of this population criteria.
     */
    public MeasureGroupPopulationComponent setDescription(String value) {
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #criteria} (An expression that specifies the criteria for the
     *         population, typically the name of an expression in a library.)
     */
    public Expression getCriteria() {
      if (this.criteria == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupPopulationComponent.criteria");
        else if (Configuration.doAutoCreate())
          this.criteria = new Expression(); // cc
      return this.criteria;
    }

    public boolean hasCriteria() {
      return this.criteria != null && !this.criteria.isEmpty();
    }

    /**
     * @param value {@link #criteria} (An expression that specifies the criteria for
     *              the population, typically the name of an expression in a
     *              library.)
     */
    public MeasureGroupPopulationComponent setCriteria(Expression value) {
      this.criteria = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "CodeableConcept", "The type of population criteria.", 0, 1, code));
      children.add(new Property("description", "string", "The human readable description of this population criteria.",
          0, 1, description));
      children.add(new Property("criteria", "Expression",
          "An expression that specifies the criteria for the population, typically the name of an expression in a library.",
          0, 1, criteria));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "CodeableConcept", "The type of population criteria.", 0, 1, code);
      case -1724546052:
        /* description */ return new Property("description", "string",
            "The human readable description of this population criteria.", 0, 1, description);
      case 1952046943:
        /* criteria */ return new Property("criteria", "Expression",
            "An expression that specifies the criteria for the population, typically the name of an expression in a library.",
            0, 1, criteria);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case 1952046943:
        /* criteria */ return this.criteria == null ? new Base[0] : new Base[] { this.criteria }; // Expression
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1724546052: // description
        this.description = TypeConvertor.castToString(value); // StringType
        return value;
      case 1952046943: // criteria
        this.criteria = TypeConvertor.castToExpression(value); // Expression
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("description")) {
        this.description = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("criteria")) {
        this.criteria = TypeConvertor.castToExpression(value); // Expression
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("description")) {
        this.description = null;
      } else if (name.equals("criteria")) {
        this.criteria = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCode();
      case -1724546052:
        return getDescriptionElement();
      case 1952046943:
        return getCriteria();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "CodeableConcept" };
      case -1724546052:
        /* description */ return new String[] { "string" };
      case 1952046943:
        /* criteria */ return new String[] { "Expression" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        this.code = new CodeableConcept();
        return this.code;
      } else if (name.equals("description")) {
        throw new FHIRException("Cannot call addChild on a singleton property Measure.group.population.description");
      } else if (name.equals("criteria")) {
        this.criteria = new Expression();
        return this.criteria;
      } else
        return super.addChild(name);
    }

    public MeasureGroupPopulationComponent copy() {
      MeasureGroupPopulationComponent dst = new MeasureGroupPopulationComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(MeasureGroupPopulationComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.description = description == null ? null : description.copy();
      dst.criteria = criteria == null ? null : criteria.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof MeasureGroupPopulationComponent))
        return false;
      MeasureGroupPopulationComponent o = (MeasureGroupPopulationComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(description, o.description, true)
          && compareDeep(criteria, o.criteria, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof MeasureGroupPopulationComponent))
        return false;
      MeasureGroupPopulationComponent o = (MeasureGroupPopulationComponent) other_;
      return compareValues(description, o.description, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, description, criteria);
    }

    public String fhirType() {
      return "Measure.group.population";

    }

  }

  @Block()
  public static class MeasureGroupStratifierComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Indicates a meaning for the stratifier. This can be as simple as a unique
     * identifier, or it can establish meaning in a broader context by drawing from
     * a terminology, allowing stratifiers to be correlated across measures.
     */
    @Child(name = "code", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Meaning of the stratifier", formalDefinition = "Indicates a meaning for the stratifier. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing stratifiers to be correlated across measures.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-stratifier-example")
    protected CodeableConcept code;

    /**
     * The human readable description of this stratifier criteria.
     */
    @Child(name = "description", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The human readable description of this stratifier", formalDefinition = "The human readable description of this stratifier criteria.")
    protected StringType description;

    /**
     * An expression that specifies the criteria for the stratifier. This is
     * typically the name of an expression defined within a referenced library, but
     * it may also be a path to a stratifier element.
     */
    @Child(name = "criteria", type = {
        Expression.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "How the measure should be stratified", formalDefinition = "An expression that specifies the criteria for the stratifier. This is typically the name of an expression defined within a referenced library, but it may also be a path to a stratifier element.")
    protected Expression criteria;

    /**
     * A component of the stratifier criteria for the measure report, specified as
     * either the name of a valid CQL expression defined within a referenced library
     * or a valid FHIR Resource Path.
     */
    @Child(name = "component", type = {}, order = 4, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Stratifier criteria component for the measure", formalDefinition = "A component of the stratifier criteria for the measure report, specified as either the name of a valid CQL expression defined within a referenced library or a valid FHIR Resource Path.")
    protected List<MeasureGroupStratifierComponentComponent> component;

    private static final long serialVersionUID = -1706793609L;

    /**
     * Constructor
     */
    public MeasureGroupStratifierComponent() {
      super();
    }

    /**
     * @return {@link #code} (Indicates a meaning for the stratifier. This can be as
     *         simple as a unique identifier, or it can establish meaning in a
     *         broader context by drawing from a terminology, allowing stratifiers
     *         to be correlated across measures.)
     */
    public CodeableConcept getCode() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupStratifierComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Indicates a meaning for the stratifier. This can
     *              be as simple as a unique identifier, or it can establish meaning
     *              in a broader context by drawing from a terminology, allowing
     *              stratifiers to be correlated across measures.)
     */
    public MeasureGroupStratifierComponent setCode(CodeableConcept value) {
      this.code = value;
      return this;
    }

    /**
     * @return {@link #description} (The human readable description of this
     *         stratifier criteria.). This is the underlying object with id, value
     *         and extensions. The accessor "getDescription" gives direct access to
     *         the value
     */
    public StringType getDescriptionElement() {
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupStratifierComponent.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() {
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() {
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The human readable description of this
     *              stratifier criteria.). This is the underlying object with id,
     *              value and extensions. The accessor "getDescription" gives direct
     *              access to the value
     */
    public MeasureGroupStratifierComponent setDescriptionElement(StringType value) {
      this.description = value;
      return this;
    }

    /**
     * @return The human readable description of this stratifier criteria.
     */
    public String getDescription() {
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The human readable description of this stratifier criteria.
     */
    public MeasureGroupStratifierComponent setDescription(String value) {
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #criteria} (An expression that specifies the criteria for the
     *         stratifier. This is typically the name of an expression defined
     *         within a referenced library, but it may also be a path to a
     *         stratifier element.)
     */
    public Expression getCriteria() {
      if (this.criteria == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupStratifierComponent.criteria");
        else if (Configuration.doAutoCreate())
          this.criteria = new Expression(); // cc
      return this.criteria;
    }

    public boolean hasCriteria() {
      return this.criteria != null && !this.criteria.isEmpty();
    }

    /**
     * @param value {@link #criteria} (An expression that specifies the criteria for
     *              the stratifier. This is typically the name of an expression
     *              defined within a referenced library, but it may also be a path
     *              to a stratifier element.)
     */
    public MeasureGroupStratifierComponent setCriteria(Expression value) {
      this.criteria = value;
      return this;
    }

    /**
     * @return {@link #component} (A component of the stratifier criteria for the
     *         measure report, specified as either the name of a valid CQL
     *         expression defined within a referenced library or a valid FHIR
     *         Resource Path.)
     */
    public List<MeasureGroupStratifierComponentComponent> getComponent() {
      if (this.component == null)
        this.component = new ArrayList<MeasureGroupStratifierComponentComponent>();
      return this.component;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureGroupStratifierComponent setComponent(List<MeasureGroupStratifierComponentComponent> theComponent) {
      this.component = theComponent;
      return this;
    }

    public boolean hasComponent() {
      if (this.component == null)
        return false;
      for (MeasureGroupStratifierComponentComponent item : this.component)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MeasureGroupStratifierComponentComponent addComponent() { // 3
      MeasureGroupStratifierComponentComponent t = new MeasureGroupStratifierComponentComponent();
      if (this.component == null)
        this.component = new ArrayList<MeasureGroupStratifierComponentComponent>();
      this.component.add(t);
      return t;
    }

    public MeasureGroupStratifierComponent addComponent(MeasureGroupStratifierComponentComponent t) { // 3
      if (t == null)
        return this;
      if (this.component == null)
        this.component = new ArrayList<MeasureGroupStratifierComponentComponent>();
      this.component.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #component}, creating
     *         it if it does not already exist {3}
     */
    public MeasureGroupStratifierComponentComponent getComponentFirstRep() {
      if (getComponent().isEmpty()) {
        addComponent();
      }
      return getComponent().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "CodeableConcept",
          "Indicates a meaning for the stratifier. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing stratifiers to be correlated across measures.",
          0, 1, code));
      children.add(new Property("description", "string", "The human readable description of this stratifier criteria.",
          0, 1, description));
      children.add(new Property("criteria", "Expression",
          "An expression that specifies the criteria for the stratifier. This is typically the name of an expression defined within a referenced library, but it may also be a path to a stratifier element.",
          0, 1, criteria));
      children.add(new Property("component", "",
          "A component of the stratifier criteria for the measure report, specified as either the name of a valid CQL expression defined within a referenced library or a valid FHIR Resource Path.",
          0, java.lang.Integer.MAX_VALUE, component));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "CodeableConcept",
            "Indicates a meaning for the stratifier. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing stratifiers to be correlated across measures.",
            0, 1, code);
      case -1724546052:
        /* description */ return new Property("description", "string",
            "The human readable description of this stratifier criteria.", 0, 1, description);
      case 1952046943:
        /* criteria */ return new Property("criteria", "Expression",
            "An expression that specifies the criteria for the stratifier. This is typically the name of an expression defined within a referenced library, but it may also be a path to a stratifier element.",
            0, 1, criteria);
      case -1399907075:
        /* component */ return new Property("component", "",
            "A component of the stratifier criteria for the measure report, specified as either the name of a valid CQL expression defined within a referenced library or a valid FHIR Resource Path.",
            0, java.lang.Integer.MAX_VALUE, component);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case 1952046943:
        /* criteria */ return this.criteria == null ? new Base[0] : new Base[] { this.criteria }; // Expression
      case -1399907075:
        /* component */ return this.component == null ? new Base[0]
            : this.component.toArray(new Base[this.component.size()]); // MeasureGroupStratifierComponentComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1724546052: // description
        this.description = TypeConvertor.castToString(value); // StringType
        return value;
      case 1952046943: // criteria
        this.criteria = TypeConvertor.castToExpression(value); // Expression
        return value;
      case -1399907075: // component
        this.getComponent().add((MeasureGroupStratifierComponentComponent) value); // MeasureGroupStratifierComponentComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("description")) {
        this.description = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("criteria")) {
        this.criteria = TypeConvertor.castToExpression(value); // Expression
      } else if (name.equals("component")) {
        this.getComponent().add((MeasureGroupStratifierComponentComponent) value);
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("description")) {
        this.description = null;
      } else if (name.equals("criteria")) {
        this.criteria = null;
      } else if (name.equals("component")) {
        this.getComponent().remove((MeasureGroupStratifierComponentComponent) value);
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCode();
      case -1724546052:
        return getDescriptionElement();
      case 1952046943:
        return getCriteria();
      case -1399907075:
        return addComponent();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "CodeableConcept" };
      case -1724546052:
        /* description */ return new String[] { "string" };
      case 1952046943:
        /* criteria */ return new String[] { "Expression" };
      case -1399907075:
        /* component */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        this.code = new CodeableConcept();
        return this.code;
      } else if (name.equals("description")) {
        throw new FHIRException("Cannot call addChild on a singleton property Measure.group.stratifier.description");
      } else if (name.equals("criteria")) {
        this.criteria = new Expression();
        return this.criteria;
      } else if (name.equals("component")) {
        return addComponent();
      } else
        return super.addChild(name);
    }

    public MeasureGroupStratifierComponent copy() {
      MeasureGroupStratifierComponent dst = new MeasureGroupStratifierComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(MeasureGroupStratifierComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.description = description == null ? null : description.copy();
      dst.criteria = criteria == null ? null : criteria.copy();
      if (component != null) {
        dst.component = new ArrayList<MeasureGroupStratifierComponentComponent>();
        for (MeasureGroupStratifierComponentComponent i : component)
          dst.component.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof MeasureGroupStratifierComponent))
        return false;
      MeasureGroupStratifierComponent o = (MeasureGroupStratifierComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(description, o.description, true)
          && compareDeep(criteria, o.criteria, true) && compareDeep(component, o.component, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof MeasureGroupStratifierComponent))
        return false;
      MeasureGroupStratifierComponent o = (MeasureGroupStratifierComponent) other_;
      return compareValues(description, o.description, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, description, criteria, component);
    }

    public String fhirType() {
      return "Measure.group.stratifier";

    }

  }

  @Block()
  public static class MeasureGroupStratifierComponentComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Indicates a meaning for the stratifier component. This can be as simple as a
     * unique identifier, or it can establish meaning in a broader context by
     * drawing from a terminology, allowing stratifiers to be correlated across
     * measures.
     */
    @Child(name = "code", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Meaning of the stratifier component", formalDefinition = "Indicates a meaning for the stratifier component. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing stratifiers to be correlated across measures.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-stratifier-example")
    protected CodeableConcept code;

    /**
     * The human readable description of this stratifier criteria component.
     */
    @Child(name = "description", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The human readable description of this stratifier component", formalDefinition = "The human readable description of this stratifier criteria component.")
    protected StringType description;

    /**
     * An expression that specifies the criteria for this component of the
     * stratifier. This is typically the name of an expression defined within a
     * referenced library, but it may also be a path to a stratifier element.
     */
    @Child(name = "criteria", type = {
        Expression.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Component of how the measure should be stratified", formalDefinition = "An expression that specifies the criteria for this component of the stratifier. This is typically the name of an expression defined within a referenced library, but it may also be a path to a stratifier element.")
    protected Expression criteria;

    private static final long serialVersionUID = 2107514056L;

    /**
     * Constructor
     */
    public MeasureGroupStratifierComponentComponent() {
      super();
    }

    /**
     * Constructor
     */
    public MeasureGroupStratifierComponentComponent(Expression criteria) {
      super();
      this.setCriteria(criteria);
    }

    /**
     * @return {@link #code} (Indicates a meaning for the stratifier component. This
     *         can be as simple as a unique identifier, or it can establish meaning
     *         in a broader context by drawing from a terminology, allowing
     *         stratifiers to be correlated across measures.)
     */
    public CodeableConcept getCode() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupStratifierComponentComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Indicates a meaning for the stratifier component.
     *              This can be as simple as a unique identifier, or it can
     *              establish meaning in a broader context by drawing from a
     *              terminology, allowing stratifiers to be correlated across
     *              measures.)
     */
    public MeasureGroupStratifierComponentComponent setCode(CodeableConcept value) {
      this.code = value;
      return this;
    }

    /**
     * @return {@link #description} (The human readable description of this
     *         stratifier criteria component.). This is the underlying object with
     *         id, value and extensions. The accessor "getDescription" gives direct
     *         access to the value
     */
    public StringType getDescriptionElement() {
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupStratifierComponentComponent.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() {
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() {
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The human readable description of this
     *              stratifier criteria component.). This is the underlying object
     *              with id, value and extensions. The accessor "getDescription"
     *              gives direct access to the value
     */
    public MeasureGroupStratifierComponentComponent setDescriptionElement(StringType value) {
      this.description = value;
      return this;
    }

    /**
     * @return The human readable description of this stratifier criteria component.
     */
    public String getDescription() {
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The human readable description of this stratifier criteria
     *              component.
     */
    public MeasureGroupStratifierComponentComponent setDescription(String value) {
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #criteria} (An expression that specifies the criteria for this
     *         component of the stratifier. This is typically the name of an
     *         expression defined within a referenced library, but it may also be a
     *         path to a stratifier element.)
     */
    public Expression getCriteria() {
      if (this.criteria == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureGroupStratifierComponentComponent.criteria");
        else if (Configuration.doAutoCreate())
          this.criteria = new Expression(); // cc
      return this.criteria;
    }

    public boolean hasCriteria() {
      return this.criteria != null && !this.criteria.isEmpty();
    }

    /**
     * @param value {@link #criteria} (An expression that specifies the criteria for
     *              this component of the stratifier. This is typically the name of
     *              an expression defined within a referenced library, but it may
     *              also be a path to a stratifier element.)
     */
    public MeasureGroupStratifierComponentComponent setCriteria(Expression value) {
      this.criteria = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "CodeableConcept",
          "Indicates a meaning for the stratifier component. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing stratifiers to be correlated across measures.",
          0, 1, code));
      children.add(new Property("description", "string",
          "The human readable description of this stratifier criteria component.", 0, 1, description));
      children.add(new Property("criteria", "Expression",
          "An expression that specifies the criteria for this component of the stratifier. This is typically the name of an expression defined within a referenced library, but it may also be a path to a stratifier element.",
          0, 1, criteria));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "CodeableConcept",
            "Indicates a meaning for the stratifier component. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing stratifiers to be correlated across measures.",
            0, 1, code);
      case -1724546052:
        /* description */ return new Property("description", "string",
            "The human readable description of this stratifier criteria component.", 0, 1, description);
      case 1952046943:
        /* criteria */ return new Property("criteria", "Expression",
            "An expression that specifies the criteria for this component of the stratifier. This is typically the name of an expression defined within a referenced library, but it may also be a path to a stratifier element.",
            0, 1, criteria);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case 1952046943:
        /* criteria */ return this.criteria == null ? new Base[0] : new Base[] { this.criteria }; // Expression
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1724546052: // description
        this.description = TypeConvertor.castToString(value); // StringType
        return value;
      case 1952046943: // criteria
        this.criteria = TypeConvertor.castToExpression(value); // Expression
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("description")) {
        this.description = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("criteria")) {
        this.criteria = TypeConvertor.castToExpression(value); // Expression
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("description")) {
        this.description = null;
      } else if (name.equals("criteria")) {
        this.criteria = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCode();
      case -1724546052:
        return getDescriptionElement();
      case 1952046943:
        return getCriteria();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "CodeableConcept" };
      case -1724546052:
        /* description */ return new String[] { "string" };
      case 1952046943:
        /* criteria */ return new String[] { "Expression" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        this.code = new CodeableConcept();
        return this.code;
      } else if (name.equals("description")) {
        throw new FHIRException(
            "Cannot call addChild on a singleton property Measure.group.stratifier.component.description");
      } else if (name.equals("criteria")) {
        this.criteria = new Expression();
        return this.criteria;
      } else
        return super.addChild(name);
    }

    public MeasureGroupStratifierComponentComponent copy() {
      MeasureGroupStratifierComponentComponent dst = new MeasureGroupStratifierComponentComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(MeasureGroupStratifierComponentComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.description = description == null ? null : description.copy();
      dst.criteria = criteria == null ? null : criteria.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof MeasureGroupStratifierComponentComponent))
        return false;
      MeasureGroupStratifierComponentComponent o = (MeasureGroupStratifierComponentComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(description, o.description, true)
          && compareDeep(criteria, o.criteria, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof MeasureGroupStratifierComponentComponent))
        return false;
      MeasureGroupStratifierComponentComponent o = (MeasureGroupStratifierComponentComponent) other_;
      return compareValues(description, o.description, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, description, criteria);
    }

    public String fhirType() {
      return "Measure.group.stratifier.component";

    }

  }

  @Block()
  public static class MeasureSupplementalDataComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Indicates a meaning for the supplemental data. This can be as simple as a
     * unique identifier, or it can establish meaning in a broader context by
     * drawing from a terminology, allowing supplemental data to be correlated
     * across measures.
     */
    @Child(name = "code", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Meaning of the supplemental data", formalDefinition = "Indicates a meaning for the supplemental data. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing supplemental data to be correlated across measures.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-supplemental-data-example")
    protected CodeableConcept code;

    /**
     * An indicator of the intended usage for the supplemental data element.
     * Supplemental data indicates the data is additional information requested to
     * augment the measure information. Risk adjustment factor indicates the data is
     * additional information used to calculate risk adjustment factors when
     * applying a risk model to the measure calculation.
     */
    @Child(name = "usage", type = {
        CodeableConcept.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "supplemental-data | risk-adjustment-factor", formalDefinition = "An indicator of the intended usage for the supplemental data element. Supplemental data indicates the data is additional information requested to augment the measure information. Risk adjustment factor indicates the data is additional information used to calculate risk adjustment factors when applying a risk model to the measure calculation.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-data-usage")
    protected List<CodeableConcept> usage;

    /**
     * The human readable description of this supplemental data.
     */
    @Child(name = "description", type = {
        StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The human readable description of this supplemental data", formalDefinition = "The human readable description of this supplemental data.")
    protected StringType description;

    /**
     * The criteria for the supplemental data. This is typically the name of a valid
     * expression defined within a referenced library, but it may also be a path to
     * a specific data element. The criteria defines the data to be returned for
     * this element.
     */
    @Child(name = "criteria", type = {
        Expression.class }, order = 4, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Expression describing additional data to be reported", formalDefinition = "The criteria for the supplemental data. This is typically the name of a valid expression defined within a referenced library, but it may also be a path to a specific data element. The criteria defines the data to be returned for this element.")
    protected Expression criteria;

    private static final long serialVersionUID = -1897021670L;

    /**
     * Constructor
     */
    public MeasureSupplementalDataComponent() {
      super();
    }

    /**
     * Constructor
     */
    public MeasureSupplementalDataComponent(Expression criteria) {
      super();
      this.setCriteria(criteria);
    }

    /**
     * @return {@link #code} (Indicates a meaning for the supplemental data. This
     *         can be as simple as a unique identifier, or it can establish meaning
     *         in a broader context by drawing from a terminology, allowing
     *         supplemental data to be correlated across measures.)
     */
    public CodeableConcept getCode() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureSupplementalDataComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Indicates a meaning for the supplemental data.
     *              This can be as simple as a unique identifier, or it can
     *              establish meaning in a broader context by drawing from a
     *              terminology, allowing supplemental data to be correlated across
     *              measures.)
     */
    public MeasureSupplementalDataComponent setCode(CodeableConcept value) {
      this.code = value;
      return this;
    }

    /**
     * @return {@link #usage} (An indicator of the intended usage for the
     *         supplemental data element. Supplemental data indicates the data is
     *         additional information requested to augment the measure information.
     *         Risk adjustment factor indicates the data is additional information
     *         used to calculate risk adjustment factors when applying a risk model
     *         to the measure calculation.)
     */
    public List<CodeableConcept> getUsage() {
      if (this.usage == null)
        this.usage = new ArrayList<CodeableConcept>();
      return this.usage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureSupplementalDataComponent setUsage(List<CodeableConcept> theUsage) {
      this.usage = theUsage;
      return this;
    }

    public boolean hasUsage() {
      if (this.usage == null)
        return false;
      for (CodeableConcept item : this.usage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addUsage() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.usage == null)
        this.usage = new ArrayList<CodeableConcept>();
      this.usage.add(t);
      return t;
    }

    public MeasureSupplementalDataComponent addUsage(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.usage == null)
        this.usage = new ArrayList<CodeableConcept>();
      this.usage.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #usage}, creating it
     *         if it does not already exist {3}
     */
    public CodeableConcept getUsageFirstRep() {
      if (getUsage().isEmpty()) {
        addUsage();
      }
      return getUsage().get(0);
    }

    /**
     * @return {@link #description} (The human readable description of this
     *         supplemental data.). This is the underlying object with id, value and
     *         extensions. The accessor "getDescription" gives direct access to the
     *         value
     */
    public StringType getDescriptionElement() {
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureSupplementalDataComponent.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() {
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() {
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The human readable description of this
     *              supplemental data.). This is the underlying object with id,
     *              value and extensions. The accessor "getDescription" gives direct
     *              access to the value
     */
    public MeasureSupplementalDataComponent setDescriptionElement(StringType value) {
      this.description = value;
      return this;
    }

    /**
     * @return The human readable description of this supplemental data.
     */
    public String getDescription() {
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The human readable description of this supplemental data.
     */
    public MeasureSupplementalDataComponent setDescription(String value) {
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #criteria} (The criteria for the supplemental data. This is
     *         typically the name of a valid expression defined within a referenced
     *         library, but it may also be a path to a specific data element. The
     *         criteria defines the data to be returned for this element.)
     */
    public Expression getCriteria() {
      if (this.criteria == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureSupplementalDataComponent.criteria");
        else if (Configuration.doAutoCreate())
          this.criteria = new Expression(); // cc
      return this.criteria;
    }

    public boolean hasCriteria() {
      return this.criteria != null && !this.criteria.isEmpty();
    }

    /**
     * @param value {@link #criteria} (The criteria for the supplemental data. This
     *              is typically the name of a valid expression defined within a
     *              referenced library, but it may also be a path to a specific data
     *              element. The criteria defines the data to be returned for this
     *              element.)
     */
    public MeasureSupplementalDataComponent setCriteria(Expression value) {
      this.criteria = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "CodeableConcept",
          "Indicates a meaning for the supplemental data. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing supplemental data to be correlated across measures.",
          0, 1, code));
      children.add(new Property("usage", "CodeableConcept",
          "An indicator of the intended usage for the supplemental data element. Supplemental data indicates the data is additional information requested to augment the measure information. Risk adjustment factor indicates the data is additional information used to calculate risk adjustment factors when applying a risk model to the measure calculation.",
          0, java.lang.Integer.MAX_VALUE, usage));
      children.add(new Property("description", "string", "The human readable description of this supplemental data.", 0,
          1, description));
      children.add(new Property("criteria", "Expression",
          "The criteria for the supplemental data. This is typically the name of a valid expression defined within a referenced library, but it may also be a path to a specific data element. The criteria defines the data to be returned for this element.",
          0, 1, criteria));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "CodeableConcept",
            "Indicates a meaning for the supplemental data. This can be as simple as a unique identifier, or it can establish meaning in a broader context by drawing from a terminology, allowing supplemental data to be correlated across measures.",
            0, 1, code);
      case 111574433:
        /* usage */ return new Property("usage", "CodeableConcept",
            "An indicator of the intended usage for the supplemental data element. Supplemental data indicates the data is additional information requested to augment the measure information. Risk adjustment factor indicates the data is additional information used to calculate risk adjustment factors when applying a risk model to the measure calculation.",
            0, java.lang.Integer.MAX_VALUE, usage);
      case -1724546052:
        /* description */ return new Property("description", "string",
            "The human readable description of this supplemental data.", 0, 1, description);
      case 1952046943:
        /* criteria */ return new Property("criteria", "Expression",
            "The criteria for the supplemental data. This is typically the name of a valid expression defined within a referenced library, but it may also be a path to a specific data element. The criteria defines the data to be returned for this element.",
            0, 1, criteria);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
      case 111574433:
        /* usage */ return this.usage == null ? new Base[0] : this.usage.toArray(new Base[this.usage.size()]); // CodeableConcept
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case 1952046943:
        /* criteria */ return this.criteria == null ? new Base[0] : new Base[] { this.criteria }; // Expression
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 111574433: // usage
        this.getUsage().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case -1724546052: // description
        this.description = TypeConvertor.castToString(value); // StringType
        return value;
      case 1952046943: // criteria
        this.criteria = TypeConvertor.castToExpression(value); // Expression
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("usage")) {
        this.getUsage().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("description")) {
        this.description = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("criteria")) {
        this.criteria = TypeConvertor.castToExpression(value); // Expression
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("usage")) {
        this.getUsage().remove(value);
      } else if (name.equals("description")) {
        this.description = null;
      } else if (name.equals("criteria")) {
        this.criteria = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCode();
      case 111574433:
        return addUsage();
      case -1724546052:
        return getDescriptionElement();
      case 1952046943:
        return getCriteria();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "CodeableConcept" };
      case 111574433:
        /* usage */ return new String[] { "CodeableConcept" };
      case -1724546052:
        /* description */ return new String[] { "string" };
      case 1952046943:
        /* criteria */ return new String[] { "Expression" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        this.code = new CodeableConcept();
        return this.code;
      } else if (name.equals("usage")) {
        return addUsage();
      } else if (name.equals("description")) {
        throw new FHIRException("Cannot call addChild on a singleton property Measure.supplementalData.description");
      } else if (name.equals("criteria")) {
        this.criteria = new Expression();
        return this.criteria;
      } else
        return super.addChild(name);
    }

    public MeasureSupplementalDataComponent copy() {
      MeasureSupplementalDataComponent dst = new MeasureSupplementalDataComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(MeasureSupplementalDataComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      if (usage != null) {
        dst.usage = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : usage)
          dst.usage.add(i.copy());
      }
      ;
      dst.description = description == null ? null : description.copy();
      dst.criteria = criteria == null ? null : criteria.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof MeasureSupplementalDataComponent))
        return false;
      MeasureSupplementalDataComponent o = (MeasureSupplementalDataComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(usage, o.usage, true)
          && compareDeep(description, o.description, true) && compareDeep(criteria, o.criteria, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof MeasureSupplementalDataComponent))
        return false;
      MeasureSupplementalDataComponent o = (MeasureSupplementalDataComponent) other_;
      return compareValues(description, o.description, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, usage, description, criteria);
    }

    public String fhirType() {
      return "Measure.supplementalData";

    }

  }

  /**
   * An absolute URI that is used to identify this measure when it is referenced
   * in a specification, model, design or an instance; also called its canonical
   * identifier. This SHOULD be globally unique and SHOULD be a literal address at
   * which at which an authoritative instance of this measure is (or will be)
   * published. This URL can be the target of a canonical reference. It SHALL
   * remain the same when the measure is stored on different servers.
   */
  @Child(name = "url", type = { UriType.class }, order = 0, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Canonical identifier for this measure, represented as a URI (globally unique)", formalDefinition = "An absolute URI that is used to identify this measure when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this measure is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the measure is stored on different servers.")
  protected UriType url;

  /**
   * A formal identifier that is used to identify this measure when it is
   * represented in other formats, or referenced in a specification, model, design
   * or an instance.
   */
  @Child(name = "identifier", type = {
      Identifier.class }, order = 1, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Additional identifier for the measure", formalDefinition = "A formal identifier that is used to identify this measure when it is represented in other formats, or referenced in a specification, model, design or an instance.")
  protected List<Identifier> identifier;

  /**
   * The identifier that is used to identify this version of the measure when it
   * is referenced in a specification, model, design or instance. This is an
   * arbitrary value managed by the measure author and is not expected to be
   * globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a
   * managed version is not available. There is also no expectation that versions
   * can be placed in a lexicographical sequence. To provide a version consistent
   * with the Decision Support Service specification, use the format
   * Major.Minor.Revision (e.g. 1.0.0). For more information on versioning
   * knowledge assets, refer to the Decision Support Service specification. Note
   * that a version is required for non-experimental active artifacts.
   */
  @Child(name = "version", type = { StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Business version of the measure", formalDefinition = "The identifier that is used to identify this version of the measure when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the measure author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.")
  protected StringType version;

  /**
   * A natural language name identifying the measure. This name should be usable
   * as an identifier for the module by machine processing applications such as
   * code generation.
   */
  @Child(name = "name", type = { StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Name for this measure (computer friendly)", formalDefinition = "A natural language name identifying the measure. This name should be usable as an identifier for the module by machine processing applications such as code generation.")
  protected StringType name;

  /**
   * A short, descriptive, user-friendly title for the measure.
   */
  @Child(name = "title", type = { StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Name for this measure (human friendly)", formalDefinition = "A short, descriptive, user-friendly title for the measure.")
  protected StringType title;

  /**
   * An explanatory or alternate title for the measure giving additional
   * information about its content.
   */
  @Child(name = "subtitle", type = { StringType.class }, order = 5, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Subordinate title of the measure", formalDefinition = "An explanatory or alternate title for the measure giving additional information about its content.")
  protected StringType subtitle;

  /**
   * The status of this measure. Enables tracking the life-cycle of the content.
   */
  @Child(name = "status", type = { CodeType.class }, order = 6, min = 1, max = 1, modifier = true, summary = true)
  @Description(shortDefinition = "draft | active | retired | unknown", formalDefinition = "The status of this measure. Enables tracking the life-cycle of the content.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/publication-status")
  protected Enumeration<PublicationStatus> status;

  /**
   * A Boolean value to indicate that this measure is authored for testing
   * purposes (or education/evaluation/marketing) and is not intended to be used
   * for genuine usage.
   */
  @Child(name = "experimental", type = {
      BooleanType.class }, order = 7, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "For testing purposes, not real usage", formalDefinition = "A Boolean value to indicate that this measure is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.")
  protected BooleanType experimental;

  /**
   * The intended subjects for the measure. If this element is not provided, a
   * Patient subject is assumed, but the subject of the measure can be anything.
   */
  @Child(name = "subject", type = { CodeableConcept.class,
      Group.class }, order = 8, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "E.g. Patient, Practitioner, RelatedPerson, Organization, Location, Device", formalDefinition = "The intended subjects for the measure. If this element is not provided, a Patient subject is assumed, but the subject of the measure can be anything.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/subject-type")
  protected DataType subject;

  /**
   * The date (and optionally time) when the measure was published. The date must
   * change when the business version changes and it must change if the status
   * code changes. In addition, it should change when the substantive content of
   * the measure changes.
   */
  @Child(name = "date", type = { DateTimeType.class }, order = 9, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Date last changed", formalDefinition = "The date  (and optionally time) when the measure was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the measure changes.")
  protected DateTimeType date;

  /**
   * The name of the organization or individual that published the measure.
   */
  @Child(name = "publisher", type = {
      StringType.class }, order = 10, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Name of the publisher (organization or individual)", formalDefinition = "The name of the organization or individual that published the measure.")
  protected StringType publisher;

  /**
   * Contact details to assist a user in finding and communicating with the
   * publisher.
   */
  @Child(name = "contact", type = {
      ContactDetail.class }, order = 11, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Contact details for the publisher", formalDefinition = "Contact details to assist a user in finding and communicating with the publisher.")
  protected List<ContactDetail> contact;

  /**
   * A free text natural language description of the measure from a consumer's
   * perspective.
   */
  @Child(name = "description", type = {
      MarkdownType.class }, order = 12, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Natural language description of the measure", formalDefinition = "A free text natural language description of the measure from a consumer's perspective.")
  protected MarkdownType description;

  /**
   * The content was developed with a focus and intent of supporting the contexts
   * that are listed. These contexts may be general categories (gender, age, ...)
   * or may be references to specific programs (insurance plans, studies, ...) and
   * may be used to assist with indexing and searching for appropriate measure
   * instances.
   */
  @Child(name = "useContext", type = {
      UsageContext.class }, order = 13, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "The context that the content is intended to support", formalDefinition = "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate measure instances.")
  protected List<UsageContext> useContext;

  /**
   * A legal or geographic region in which the measure is intended to be used.
   */
  @Child(name = "jurisdiction", type = {
      CodeableConcept.class }, order = 14, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Intended jurisdiction for measure (if applicable)", formalDefinition = "A legal or geographic region in which the measure is intended to be used.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/jurisdiction")
  protected List<CodeableConcept> jurisdiction;

  /**
   * Explanation of why this measure is needed and why it has been designed as it
   * has.
   */
  @Child(name = "purpose", type = {
      MarkdownType.class }, order = 15, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Why this measure is defined", formalDefinition = "Explanation of why this measure is needed and why it has been designed as it has.")
  protected MarkdownType purpose;

  /**
   * A detailed description, from a clinical perspective, of how the measure is
   * used.
   */
  @Child(name = "usage", type = { StringType.class }, order = 16, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Describes the clinical usage of the measure", formalDefinition = "A detailed description, from a clinical perspective, of how the measure is used.")
  protected StringType usage;

  /**
   * A copyright statement relating to the measure and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the
   * measure.
   */
  @Child(name = "copyright", type = {
      MarkdownType.class }, order = 17, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Use and/or publishing restrictions", formalDefinition = "A copyright statement relating to the measure and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the measure.")
  protected MarkdownType copyright;

  /**
   * The date on which the resource content was approved by the publisher.
   * Approval happens once when the content is officially approved for usage.
   */
  @Child(name = "approvalDate", type = {
      DateType.class }, order = 18, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "When the measure was approved by publisher", formalDefinition = "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.")
  protected DateType approvalDate;

  /**
   * The date on which the resource content was last reviewed. Review happens
   * periodically after approval but does not change the original approval date.
   */
  @Child(name = "lastReviewDate", type = {
      DateType.class }, order = 19, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "When the measure was last reviewed", formalDefinition = "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.")
  protected DateType lastReviewDate;

  /**
   * The period during which the measure content was or is planned to be in active
   * use.
   */
  @Child(name = "effectivePeriod", type = {
      Period.class }, order = 20, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "When the measure is expected to be used", formalDefinition = "The period during which the measure content was or is planned to be in active use.")
  protected Period effectivePeriod;

  /**
   * Descriptive topics related to the content of the measure. Topics provide a
   * high-level categorization grouping types of measures that can be useful for
   * filtering and searching.
   */
  @Child(name = "topic", type = {
      CodeableConcept.class }, order = 21, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "The category of the measure, such as Education, Treatment, Assessment, etc.", formalDefinition = "Descriptive topics related to the content of the measure. Topics provide a high-level categorization grouping types of measures that can be useful for filtering and searching.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/definition-topic")
  protected List<CodeableConcept> topic;

  /**
   * An individiual or organization primarily involved in the creation and
   * maintenance of the content.
   */
  @Child(name = "author", type = {
      ContactDetail.class }, order = 22, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who authored the content", formalDefinition = "An individiual or organization primarily involved in the creation and maintenance of the content.")
  protected List<ContactDetail> author;

  /**
   * An individual or organization primarily responsible for internal coherence of
   * the content.
   */
  @Child(name = "editor", type = {
      ContactDetail.class }, order = 23, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who edited the content", formalDefinition = "An individual or organization primarily responsible for internal coherence of the content.")
  protected List<ContactDetail> editor;

  /**
   * An individual or organization primarily responsible for review of some aspect
   * of the content.
   */
  @Child(name = "reviewer", type = {
      ContactDetail.class }, order = 24, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who reviewed the content", formalDefinition = "An individual or organization primarily responsible for review of some aspect of the content.")
  protected List<ContactDetail> reviewer;

  /**
   * An individual or organization responsible for officially endorsing the
   * content for use in some setting.
   */
  @Child(name = "endorser", type = {
      ContactDetail.class }, order = 25, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who endorsed the content", formalDefinition = "An individual or organization responsible for officially endorsing the content for use in some setting.")
  protected List<ContactDetail> endorser;

  /**
   * Related artifacts such as additional documentation, justification, or
   * bibliographic references.
   */
  @Child(name = "relatedArtifact", type = {
      RelatedArtifact.class }, order = 26, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Additional documentation, citations, etc.", formalDefinition = "Related artifacts such as additional documentation, justification, or bibliographic references.")
  protected List<RelatedArtifact> relatedArtifact;

  /**
   * A reference to a Library resource containing the formal logic used by the
   * measure.
   */
  @Child(name = "library", type = {
      CanonicalType.class }, order = 27, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Logic used by the measure", formalDefinition = "A reference to a Library resource containing the formal logic used by the measure.")
  protected List<CanonicalType> library;

  /**
   * Notices and disclaimers regarding the use of the measure or related to
   * intellectual property (such as code systems) referenced by the measure.
   */
  @Child(name = "disclaimer", type = {
      MarkdownType.class }, order = 28, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Disclaimer for use of the measure or its referenced content", formalDefinition = "Notices and disclaimers regarding the use of the measure or related to intellectual property (such as code systems) referenced by the measure.")
  protected MarkdownType disclaimer;

  /**
   * Indicates how the calculation is performed for the measure, including
   * proportion, ratio, continuous-variable, and cohort. The value set is
   * extensible, allowing additional measure scoring types to be represented.
   */
  @Child(name = "scoring", type = {
      CodeableConcept.class }, order = 29, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "proportion | ratio | continuous-variable | cohort", formalDefinition = "Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-scoring")
  protected CodeableConcept scoring;

  /**
   * If this is a composite measure, the scoring method used to combine the
   * component measures to determine the composite score.
   */
  @Child(name = "compositeScoring", type = {
      CodeableConcept.class }, order = 30, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "opportunity | all-or-nothing | linear | weighted", formalDefinition = "If this is a composite measure, the scoring method used to combine the component measures to determine the composite score.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/composite-measure-scoring")
  protected CodeableConcept compositeScoring;

  /**
   * Indicates whether the measure is used to examine a process, an outcome over
   * time, a patient-reported outcome, or a structure measure such as utilization.
   */
  @Child(name = "type", type = {
      CodeableConcept.class }, order = 31, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "process | outcome | structure | patient-reported-outcome | composite", formalDefinition = "Indicates whether the measure is used to examine a process, an outcome over time, a patient-reported outcome, or a structure measure such as utilization.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-type")
  protected List<CodeableConcept> type;

  /**
   * A description of the risk adjustment factors that may impact the resulting
   * score for the measure and how they may be accounted for when computing and
   * reporting measure results.
   */
  @Child(name = "riskAdjustment", type = {
      StringType.class }, order = 32, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "How risk adjustment is applied for this measure", formalDefinition = "A description of the risk adjustment factors that may impact the resulting score for the measure and how they may be accounted for when computing and reporting measure results.")
  protected StringType riskAdjustment;

  /**
   * Describes how to combine the information calculated, based on logic in each
   * of several populations, into one summarized result.
   */
  @Child(name = "rateAggregation", type = {
      StringType.class }, order = 33, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "How is rate aggregation performed for this measure", formalDefinition = "Describes how to combine the information calculated, based on logic in each of several populations, into one summarized result.")
  protected StringType rateAggregation;

  /**
   * Provides a succinct statement of the need for the measure. Usually includes
   * statements pertaining to importance criterion: impact, gap in care, and
   * evidence.
   */
  @Child(name = "rationale", type = {
      MarkdownType.class }, order = 34, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Detailed description of why the measure exists", formalDefinition = "Provides a succinct statement of the need for the measure. Usually includes statements pertaining to importance criterion: impact, gap in care, and evidence.")
  protected MarkdownType rationale;

  /**
   * Provides a summary of relevant clinical guidelines or other clinical
   * recommendations supporting the measure.
   */
  @Child(name = "clinicalRecommendationStatement", type = {
      MarkdownType.class }, order = 35, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Summary of clinical guidelines", formalDefinition = "Provides a summary of relevant clinical guidelines or other clinical recommendations supporting the measure.")
  protected MarkdownType clinicalRecommendationStatement;

  /**
   * Information on whether an increase or decrease in score is the preferred
   * result (e.g., a higher score indicates better quality OR a lower score
   * indicates better quality OR quality is within a range).
   */
  @Child(name = "improvementNotation", type = {
      CodeableConcept.class }, order = 36, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "increase | decrease", formalDefinition = "Information on whether an increase or decrease in score is the preferred result (e.g., a higher score indicates better quality OR a lower score indicates better quality OR quality is within a range).")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/measure-improvement-notation")
  protected CodeableConcept improvementNotation;

  /**
   * Provides a description of an individual term used within the measure.
   */
  @Child(name = "definition", type = {
      MarkdownType.class }, order = 37, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Defined terms used in the measure documentation", formalDefinition = "Provides a description of an individual term used within the measure.")
  protected List<MarkdownType> definition;

  /**
   * Additional guidance for the measure including how it can be used in a
   * clinical context, and the intent of the measure.
   */
  @Child(name = "guidance", type = {
      MarkdownType.class }, order = 38, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Additional guidance for implementers", formalDefinition = "Additional guidance for the measure including how it can be used in a clinical context, and the intent of the measure.")
  protected MarkdownType guidance;

  /**
   * A group of population criteria for the measure.
   */
  @Child(name = "group", type = {}, order = 39, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Population criteria group", formalDefinition = "A group of population criteria for the measure.")
  protected List<MeasureGroupComponent> group;

  /**
   * The supplemental data criteria for the measure report, specified as either
   * the name of a valid CQL expression within a referenced library, or a valid
   * FHIR Resource Path.
   */
  @Child(name = "supplementalData", type = {}, order = 40, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "What other data should be reported with the measure", formalDefinition = "The supplemental data criteria for the measure report, specified as either the name of a valid CQL expression within a referenced library, or a valid FHIR Resource Path.")
  protected List<MeasureSupplementalDataComponent> supplementalData;

  private static final long serialVersionUID = -994119782L;

  /**
   * Constructor
   */
  public Measure() {
    super();
  }

  /**
   * Constructor
   */
  public Measure(PublicationStatus status) {
    super();
    this.setStatus(status);
  }

  /**
   * @return {@link #url} (An absolute URI that is used to identify this measure
   *         when it is referenced in a specification, model, design or an
   *         instance; also called its canonical identifier. This SHOULD be
   *         globally unique and SHOULD be a literal address at which at which an
   *         authoritative instance of this measure is (or will be) published.
   *         This URL can be the target of a canonical reference. It SHALL remain
   *         the same when the measure is stored on different servers.). This is
   *         the underlying object with id, value and extensions. The accessor
   *         "getUrl" gives direct access to the value
   */
  public UriType getUrlElement() {
    if (this.url == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.url");
      else if (Configuration.doAutoCreate())
        this.url = new UriType(); // bb
    return this.url;
  }

  public boolean hasUrlElement() {
    return this.url != null && !this.url.isEmpty();
  }

  public boolean hasUrl() {
    return this.url != null && !this.url.isEmpty();
  }

  /**
   * @param value {@link #url} (An absolute URI that is used to identify this
   *              measure when it is referenced in a specification, model, design
   *              or an instance; also called its canonical identifier. This
   *              SHOULD be globally unique and SHOULD be a literal address at
   *              which at which an authoritative instance of this measure is (or
   *              will be) published. This URL can be the target of a canonical
   *              reference. It SHALL remain the same when the measure is stored
   *              on different servers.). This is the underlying object with id,
   *              value and extensions. The accessor "getUrl" gives direct access
   *              to the value
   */
  public Measure setUrlElement(UriType value) {
    this.url = value;
    return this;
  }

  /**
   * @return An absolute URI that is used to identify this measure when it is
   *         referenced in a specification, model, design or an instance; also
   *         called its canonical identifier. This SHOULD be globally unique and
   *         SHOULD be a literal address at which at which an authoritative
   *         instance of this measure is (or will be) published. This URL can be
   *         the target of a canonical reference. It SHALL remain the same when
   *         the measure is stored on different servers.
   */
  public String getUrl() {
    return this.url == null ? null : this.url.getValue();
  }

  /**
   * @param value An absolute URI that is used to identify this measure when it is
   *              referenced in a specification, model, design or an instance;
   *              also called its canonical identifier. This SHOULD be globally
   *              unique and SHOULD be a literal address at which at which an
   *              authoritative instance of this measure is (or will be)
   *              published. This URL can be the target of a canonical reference.
   *              It SHALL remain the same when the measure is stored on different
   *              servers.
   */
  public Measure setUrl(String value) {
    if (Utilities.noString(value))
      this.url = null;
    else {
      if (this.url == null)
        this.url = new UriType();
      this.url.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #identifier} (A formal identifier that is used to identify
   *         this measure when it is represented in other formats, or referenced
   *         in a specification, model, design or an instance.)
   */
  public List<Identifier> getIdentifier() {
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    return this.identifier;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setIdentifier(List<Identifier> theIdentifier) {
    this.identifier = theIdentifier;
    return this;
  }

  public boolean hasIdentifier() {
    if (this.identifier == null)
      return false;
    for (Identifier item : this.identifier)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Identifier addIdentifier() { // 3
    Identifier t = new Identifier();
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return t;
  }

  public Measure addIdentifier(Identifier t) { // 3
    if (t == null)
      return this;
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #identifier}, creating
   *         it if it does not already exist {3}
   */
  public Identifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return getIdentifier().get(0);
  }

  /**
   * @return {@link #version} (The identifier that is used to identify this
   *         version of the measure when it is referenced in a specification,
   *         model, design or instance. This is an arbitrary value managed by the
   *         measure author and is not expected to be globally unique. For
   *         example, it might be a timestamp (e.g. yyyymmdd) if a managed version
   *         is not available. There is also no expectation that versions can be
   *         placed in a lexicographical sequence. To provide a version consistent
   *         with the Decision Support Service specification, use the format
   *         Major.Minor.Revision (e.g. 1.0.0). For more information on versioning
   *         knowledge assets, refer to the Decision Support Service
   *         specification. Note that a version is required for non-experimental
   *         active artifacts.). This is the underlying object with id, value and
   *         extensions. The accessor "getVersion" gives direct access to the
   *         value
   */
  public StringType getVersionElement() {
    if (this.version == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.version");
      else if (Configuration.doAutoCreate())
        this.version = new StringType(); // bb
    return this.version;
  }

  public boolean hasVersionElement() {
    return this.version != null && !this.version.isEmpty();
  }

  public boolean hasVersion() {
    return this.version != null && !this.version.isEmpty();
  }

  /**
   * @param value {@link #version} (The identifier that is used to identify this
   *              version of the measure when it is referenced in a specification,
   *              model, design or instance. This is an arbitrary value managed by
   *              the measure author and is not expected to be globally unique.
   *              For example, it might be a timestamp (e.g. yyyymmdd) if a
   *              managed version is not available. There is also no expectation
   *              that versions can be placed in a lexicographical sequence. To
   *              provide a version consistent with the Decision Support Service
   *              specification, use the format Major.Minor.Revision (e.g. 1.0.0).
   *              For more information on versioning knowledge assets, refer to
   *              the Decision Support Service specification. Note that a version
   *              is required for non-experimental active artifacts.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getVersion" gives direct access to the value
   */
  public Measure setVersionElement(StringType value) {
    this.version = value;
    return this;
  }

  /**
   * @return The identifier that is used to identify this version of the measure
   *         when it is referenced in a specification, model, design or instance.
   *         This is an arbitrary value managed by the measure author and is not
   *         expected to be globally unique. For example, it might be a timestamp
   *         (e.g. yyyymmdd) if a managed version is not available. There is also
   *         no expectation that versions can be placed in a lexicographical
   *         sequence. To provide a version consistent with the Decision Support
   *         Service specification, use the format Major.Minor.Revision (e.g.
   *         1.0.0). For more information on versioning knowledge assets, refer to
   *         the Decision Support Service specification. Note that a version is
   *         required for non-experimental active artifacts.
   */
  public String getVersion() {
    return this.version == null ? null : this.version.getValue();
  }

  /**
   * @param value The identifier that is used to identify this version of the
   *              measure when it is referenced in a specification, model, design
   *              or instance. This is an arbitrary value managed by the measure
   *              author and is not expected to be globally unique. For example,
   *              it might be a timestamp (e.g. yyyymmdd) if a managed version is
   *              not available. There is also no expectation that versions can be
   *              placed in a lexicographical sequence. To provide a version
   *              consistent with the Decision Support Service specification, use
   *              the format Major.Minor.Revision (e.g. 1.0.0). For more
   *              information on versioning knowledge assets, refer to the
   *              Decision Support Service specification. Note that a version is
   *              required for non-experimental active artifacts.
   */
  public Measure setVersion(String value) {
    if (Utilities.noString(value))
      this.version = null;
    else {
      if (this.version == null)
        this.version = new StringType();
      this.version.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #name} (A natural language name identifying the measure. This
   *         name should be usable as an identifier for the module by machine
   *         processing applications such as code generation.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getName" gives direct access to the value
   */
  public StringType getNameElement() {
    if (this.name == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.name");
      else if (Configuration.doAutoCreate())
        this.name = new StringType(); // bb
    return this.name;
  }

  public boolean hasNameElement() {
    return this.name != null && !this.name.isEmpty();
  }

  public boolean hasName() {
    return this.name != null && !this.name.isEmpty();
  }

  /**
   * @param value {@link #name} (A natural language name identifying the measure.
   *              This name should be usable as an identifier for the module by
   *              machine processing applications such as code generation.). This
   *              is the underlying object with id, value and extensions. The
   *              accessor "getName" gives direct access to the value
   */
  public Measure setNameElement(StringType value) {
    this.name = value;
    return this;
  }

  /**
   * @return A natural language name identifying the measure. This name should be
   *         usable as an identifier for the module by machine processing
   *         applications such as code generation.
   */
  public String getName() {
    return this.name == null ? null : this.name.getValue();
  }

  /**
   * @param value A natural language name identifying the measure. This name
   *              should be usable as an identifier for the module by machine
   *              processing applications such as code generation.
   */
  public Measure setName(String value) {
    if (Utilities.noString(value))
      this.name = null;
    else {
      if (this.name == null)
        this.name = new StringType();
      this.name.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #title} (A short, descriptive, user-friendly title for the
   *         measure.). This is the underlying object with id, value and
   *         extensions. The accessor "getTitle" gives direct access to the value
   */
  public StringType getTitleElement() {
    if (this.title == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.title");
      else if (Configuration.doAutoCreate())
        this.title = new StringType(); // bb
    return this.title;
  }

  public boolean hasTitleElement() {
    return this.title != null && !this.title.isEmpty();
  }

  public boolean hasTitle() {
    return this.title != null && !this.title.isEmpty();
  }

  /**
   * @param value {@link #title} (A short, descriptive, user-friendly title for
   *              the measure.). This is the underlying object with id, value and
   *              extensions. The accessor "getTitle" gives direct access to the
   *              value
   */
  public Measure setTitleElement(StringType value) {
    this.title = value;
    return this;
  }

  /**
   * @return A short, descriptive, user-friendly title for the measure.
   */
  public String getTitle() {
    return this.title == null ? null : this.title.getValue();
  }

  /**
   * @param value A short, descriptive, user-friendly title for the measure.
   */
  public Measure setTitle(String value) {
    if (Utilities.noString(value))
      this.title = null;
    else {
      if (this.title == null)
        this.title = new StringType();
      this.title.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #subtitle} (An explanatory or alternate title for the measure
   *         giving additional information about its content.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getSubtitle" gives direct access to the value
   */
  public StringType getSubtitleElement() {
    if (this.subtitle == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.subtitle");
      else if (Configuration.doAutoCreate())
        this.subtitle = new StringType(); // bb
    return this.subtitle;
  }

  public boolean hasSubtitleElement() {
    return this.subtitle != null && !this.subtitle.isEmpty();
  }

  public boolean hasSubtitle() {
    return this.subtitle != null && !this.subtitle.isEmpty();
  }

  /**
   * @param value {@link #subtitle} (An explanatory or alternate title for the
   *              measure giving additional information about its content.). This
   *              is the underlying object with id, value and extensions. The
   *              accessor "getSubtitle" gives direct access to the value
   */
  public Measure setSubtitleElement(StringType value) {
    this.subtitle = value;
    return this;
  }

  /**
   * @return An explanatory or alternate title for the measure giving additional
   *         information about its content.
   */
  public String getSubtitle() {
    return this.subtitle == null ? null : this.subtitle.getValue();
  }

  /**
   * @param value An explanatory or alternate title for the measure giving
   *              additional information about its content.
   */
  public Measure setSubtitle(String value) {
    if (Utilities.noString(value))
      this.subtitle = null;
    else {
      if (this.subtitle == null)
        this.subtitle = new StringType();
      this.subtitle.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #status} (The status of this measure. Enables tracking the
   *         life-cycle of the content.). This is the underlying object with id,
   *         value and extensions. The accessor "getStatus" gives direct access to
   *         the value
   */
  public Enumeration<PublicationStatus> getStatusElement() {
    if (this.status == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.status");
      else if (Configuration.doAutoCreate())
        this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
    return this.status;
  }

  public boolean hasStatusElement() {
    return this.status != null && !this.status.isEmpty();
  }

  public boolean hasStatus() {
    return this.status != null && !this.status.isEmpty();
  }

  /**
   * @param value {@link #status} (The status of this measure. Enables tracking
   *              the life-cycle of the content.). This is the underlying object
   *              with id, value and extensions. The accessor "getStatus" gives
   *              direct access to the value
   */
  public Measure setStatusElement(Enumeration<PublicationStatus> value) {
    this.status = value;
    return this;
  }

  /**
   * @return The status of this measure. Enables tracking the life-cycle of the
   *         content.
   */
  public PublicationStatus getStatus() {
    return this.status == null ? null : this.status.getValue();
  }

  /**
   * @param value The status of this measure. Enables tracking the life-cycle of
   *              the content.
   */
  public Measure setStatus(PublicationStatus value) {
    if (this.status == null)
      this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
    this.status.setValue(value);
    return this;
  }

  /**
   * @return {@link #experimental} (A Boolean value to indicate that this measure
   *         is authored for testing purposes (or education/evaluation/marketing)
   *         and is not intended to be used for genuine usage.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getExperimental" gives direct access to the value
   */
  public BooleanType getExperimentalElement() {
    if (this.experimental == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.experimental");
      else if (Configuration.doAutoCreate())
        this.experimental = new BooleanType(); // bb
    return this.experimental;
  }

  public boolean hasExperimentalElement() {
    return this.experimental != null && !this.experimental.isEmpty();
  }

  public boolean hasExperimental() {
    return this.experimental != null && !this.experimental.isEmpty();
  }

  /**
   * @param value {@link #experimental} (A Boolean value to indicate that this
   *              measure is authored for testing purposes (or
   *              education/evaluation/marketing) and is not intended to be used
   *              for genuine usage.). This is the underlying object with id,
   *              value and extensions. The accessor "getExperimental" gives
   *              direct access to the value
   */
  public Measure setExperimentalElement(BooleanType value) {
    this.experimental = value;
    return this;
  }

  /**
   * @return A Boolean value to indicate that this measure is authored for testing
   *         purposes (or education/evaluation/marketing) and is not intended to
   *         be used for genuine usage.
   */
  public boolean getExperimental() {
    return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
  }

  /**
   * @param value A Boolean value to indicate that this measure is authored for
   *              testing purposes (or education/evaluation/marketing) and is not
   *              intended to be used for genuine usage.
   */
  public Measure setExperimental(boolean value) {
    if (this.experimental == null)
      this.experimental = new BooleanType();
    this.experimental.setValue(value);
    return this;
  }

  /**
   * @return {@link #subject} (The intended subjects for the measure. If this
   *         element is not provided, a Patient subject is assumed, but the
   *         subject of the measure can be anything.)
   */
  public DataType getSubject() {
    return this.subject;
  }

  /**
   * @return {@link #subject} (The intended subjects for the measure. If this
   *         element is not provided, a Patient subject is assumed, but the
   *         subject of the measure can be anything.)
   */
  public CodeableConcept getSubjectCodeableConcept() throws FHIRException {
    if (this.subject == null)
      this.subject = new CodeableConcept();
    if (!(this.subject instanceof CodeableConcept))
      throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "
          + this.subject.getClass().getName() + " was encountered");
    return (CodeableConcept) this.subject;
  }

  public boolean hasSubjectCodeableConcept() {
      return this.subject instanceof CodeableConcept;
  }

  /**
   * @return {@link #subject} (The intended subjects for the measure. If this
   *         element is not provided, a Patient subject is assumed, but the
   *         subject of the measure can be anything.)
   */
  public Reference getSubjectReference() throws FHIRException {
    if (this.subject == null)
      this.subject = new Reference();
    if (!(this.subject instanceof Reference))
      throw new FHIRException("Type mismatch: the type Reference was expected, but " + this.subject.getClass().getName()
          + " was encountered");
    return (Reference) this.subject;
  }

  public boolean hasSubjectReference() {
      return this.subject instanceof Reference;
  }

  public boolean hasSubject() {
    return this.subject != null && !this.subject.isEmpty();
  }

  /**
   * @param value {@link #subject} (The intended subjects for the measure. If this
   *              element is not provided, a Patient subject is assumed, but the
   *              subject of the measure can be anything.)
   */
  public Measure setSubject(DataType value) {
    if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
      throw new Error("Not the right type for Measure.subject[x]: " + value.fhirType());
    this.subject = value;
    return this;
  }

  /**
   * @return {@link #date} (The date (and optionally time) when the measure was
   *         published. The date must change when the business version changes and
   *         it must change if the status code changes. In addition, it should
   *         change when the substantive content of the measure changes.). This is
   *         the underlying object with id, value and extensions. The accessor
   *         "getDate" gives direct access to the value
   */
  public DateTimeType getDateElement() {
    if (this.date == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.date");
      else if (Configuration.doAutoCreate())
        this.date = new DateTimeType(); // bb
    return this.date;
  }

  public boolean hasDateElement() {
    return this.date != null && !this.date.isEmpty();
  }

  public boolean hasDate() {
    return this.date != null && !this.date.isEmpty();
  }

  /**
   * @param value {@link #date} (The date (and optionally time) when the measure
   *              was published. The date must change when the business version
   *              changes and it must change if the status code changes. In
   *              addition, it should change when the substantive content of the
   *              measure changes.). This is the underlying object with id, value
   *              and extensions. The accessor "getDate" gives direct access to
   *              the value
   */
  public Measure setDateElement(DateTimeType value) {
    this.date = value;
    return this;
  }

  /**
   * @return The date (and optionally time) when the measure was published. The
   *         date must change when the business version changes and it must change
   *         if the status code changes. In addition, it should change when the
   *         substantive content of the measure changes.
   */
  public Date getDate() {
    return this.date == null ? null : this.date.getValue();
  }

  /**
   * @param value The date (and optionally time) when the measure was published.
   *              The date must change when the business version changes and it
   *              must change if the status code changes. In addition, it should
   *              change when the substantive content of the measure changes.
   */
  public Measure setDate(Date value) {
    if (value == null)
      this.date = null;
    else {
      if (this.date == null)
        this.date = new DateTimeType();
      this.date.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #publisher} (The name of the organization or individual that
   *         published the measure.). This is the underlying object with id, value
   *         and extensions. The accessor "getPublisher" gives direct access to
   *         the value
   */
  public StringType getPublisherElement() {
    if (this.publisher == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.publisher");
      else if (Configuration.doAutoCreate())
        this.publisher = new StringType(); // bb
    return this.publisher;
  }

  public boolean hasPublisherElement() {
    return this.publisher != null && !this.publisher.isEmpty();
  }

  public boolean hasPublisher() {
    return this.publisher != null && !this.publisher.isEmpty();
  }

  /**
   * @param value {@link #publisher} (The name of the organization or individual
   *              that published the measure.). This is the underlying object with
   *              id, value and extensions. The accessor "getPublisher" gives
   *              direct access to the value
   */
  public Measure setPublisherElement(StringType value) {
    this.publisher = value;
    return this;
  }

  /**
   * @return The name of the organization or individual that published the
   *         measure.
   */
  public String getPublisher() {
    return this.publisher == null ? null : this.publisher.getValue();
  }

  /**
   * @param value The name of the organization or individual that published the
   *              measure.
   */
  public Measure setPublisher(String value) {
    if (Utilities.noString(value))
      this.publisher = null;
    else {
      if (this.publisher == null)
        this.publisher = new StringType();
      this.publisher.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #contact} (Contact details to assist a user in finding and
   *         communicating with the publisher.)
   */
  public List<ContactDetail> getContact() {
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    return this.contact;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setContact(List<ContactDetail> theContact) {
    this.contact = theContact;
    return this;
  }

  public boolean hasContact() {
    if (this.contact == null)
      return false;
    for (ContactDetail item : this.contact)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addContact() { // 3
    ContactDetail t = new ContactDetail();
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    this.contact.add(t);
    return t;
  }

  public Measure addContact(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    this.contact.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #contact}, creating it
   *         if it does not already exist {3}
   */
  public ContactDetail getContactFirstRep() {
    if (getContact().isEmpty()) {
      addContact();
    }
    return getContact().get(0);
  }

  /**
   * @return {@link #description} (A free text natural language description of the
   *         measure from a consumer's perspective.). This is the underlying
   *         object with id, value and extensions. The accessor "getDescription"
   *         gives direct access to the value
   */
  public MarkdownType getDescriptionElement() {
    if (this.description == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.description");
      else if (Configuration.doAutoCreate())
        this.description = new MarkdownType(); // bb
    return this.description;
  }

  public boolean hasDescriptionElement() {
    return this.description != null && !this.description.isEmpty();
  }

  public boolean hasDescription() {
    return this.description != null && !this.description.isEmpty();
  }

  /**
   * @param value {@link #description} (A free text natural language description
   *              of the measure from a consumer's perspective.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getDescription" gives direct access to the value
   */
  public Measure setDescriptionElement(MarkdownType value) {
    this.description = value;
    return this;
  }

  /**
   * @return A free text natural language description of the measure from a
   *         consumer's perspective.
   */
  public String getDescription() {
    return this.description == null ? null : this.description.getValue();
  }

  /**
   * @param value A free text natural language description of the measure from a
   *              consumer's perspective.
   */
  public Measure setDescription(String value) {
    if (value == null)
      this.description = null;
    else {
      if (this.description == null)
        this.description = new MarkdownType();
      this.description.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #useContext} (The content was developed with a focus and
   *         intent of supporting the contexts that are listed. These contexts may
   *         be general categories (gender, age, ...) or may be references to
   *         specific programs (insurance plans, studies, ...) and may be used to
   *         assist with indexing and searching for appropriate measure
   *         instances.)
   */
  public List<UsageContext> getUseContext() {
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    return this.useContext;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setUseContext(List<UsageContext> theUseContext) {
    this.useContext = theUseContext;
    return this;
  }

  public boolean hasUseContext() {
    if (this.useContext == null)
      return false;
    for (UsageContext item : this.useContext)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public UsageContext addUseContext() { // 3
    UsageContext t = new UsageContext();
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    this.useContext.add(t);
    return t;
  }

  public Measure addUseContext(UsageContext t) { // 3
    if (t == null)
      return this;
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    this.useContext.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #useContext}, creating
   *         it if it does not already exist {3}
   */
  public UsageContext getUseContextFirstRep() {
    if (getUseContext().isEmpty()) {
      addUseContext();
    }
    return getUseContext().get(0);
  }

  /**
   * @return {@link #jurisdiction} (A legal or geographic region in which the
   *         measure is intended to be used.)
   */
  public List<CodeableConcept> getJurisdiction() {
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    return this.jurisdiction;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setJurisdiction(List<CodeableConcept> theJurisdiction) {
    this.jurisdiction = theJurisdiction;
    return this;
  }

  public boolean hasJurisdiction() {
    if (this.jurisdiction == null)
      return false;
    for (CodeableConcept item : this.jurisdiction)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addJurisdiction() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    this.jurisdiction.add(t);
    return t;
  }

  public Measure addJurisdiction(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    this.jurisdiction.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #jurisdiction},
   *         creating it if it does not already exist {3}
   */
  public CodeableConcept getJurisdictionFirstRep() {
    if (getJurisdiction().isEmpty()) {
      addJurisdiction();
    }
    return getJurisdiction().get(0);
  }

  /**
   * @return {@link #purpose} (Explanation of why this measure is needed and why
   *         it has been designed as it has.). This is the underlying object with
   *         id, value and extensions. The accessor "getPurpose" gives direct
   *         access to the value
   */
  public MarkdownType getPurposeElement() {
    if (this.purpose == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.purpose");
      else if (Configuration.doAutoCreate())
        this.purpose = new MarkdownType(); // bb
    return this.purpose;
  }

  public boolean hasPurposeElement() {
    return this.purpose != null && !this.purpose.isEmpty();
  }

  public boolean hasPurpose() {
    return this.purpose != null && !this.purpose.isEmpty();
  }

  /**
   * @param value {@link #purpose} (Explanation of why this measure is needed and
   *              why it has been designed as it has.). This is the underlying
   *              object with id, value and extensions. The accessor "getPurpose"
   *              gives direct access to the value
   */
  public Measure setPurposeElement(MarkdownType value) {
    this.purpose = value;
    return this;
  }

  /**
   * @return Explanation of why this measure is needed and why it has been
   *         designed as it has.
   */
  public String getPurpose() {
    return this.purpose == null ? null : this.purpose.getValue();
  }

  /**
   * @param value Explanation of why this measure is needed and why it has been
   *              designed as it has.
   */
  public Measure setPurpose(String value) {
    if (value == null)
      this.purpose = null;
    else {
      if (this.purpose == null)
        this.purpose = new MarkdownType();
      this.purpose.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #usage} (A detailed description, from a clinical perspective,
   *         of how the measure is used.). This is the underlying object with id,
   *         value and extensions. The accessor "getUsage" gives direct access to
   *         the value
   */
  public StringType getUsageElement() {
    if (this.usage == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.usage");
      else if (Configuration.doAutoCreate())
        this.usage = new StringType(); // bb
    return this.usage;
  }

  public boolean hasUsageElement() {
    return this.usage != null && !this.usage.isEmpty();
  }

  public boolean hasUsage() {
    return this.usage != null && !this.usage.isEmpty();
  }

  /**
   * @param value {@link #usage} (A detailed description, from a clinical
   *              perspective, of how the measure is used.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getUsage" gives direct access to the value
   */
  public Measure setUsageElement(StringType value) {
    this.usage = value;
    return this;
  }

  /**
   * @return A detailed description, from a clinical perspective, of how the
   *         measure is used.
   */
  public String getUsage() {
    return this.usage == null ? null : this.usage.getValue();
  }

  /**
   * @param value A detailed description, from a clinical perspective, of how the
   *              measure is used.
   */
  public Measure setUsage(String value) {
    if (Utilities.noString(value))
      this.usage = null;
    else {
      if (this.usage == null)
        this.usage = new StringType();
      this.usage.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #copyright} (A copyright statement relating to the measure
   *         and/or its contents. Copyright statements are generally legal
   *         restrictions on the use and publishing of the measure.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getCopyright" gives direct access to the value
   */
  public MarkdownType getCopyrightElement() {
    if (this.copyright == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.copyright");
      else if (Configuration.doAutoCreate())
        this.copyright = new MarkdownType(); // bb
    return this.copyright;
  }

  public boolean hasCopyrightElement() {
    return this.copyright != null && !this.copyright.isEmpty();
  }

  public boolean hasCopyright() {
    return this.copyright != null && !this.copyright.isEmpty();
  }

  /**
   * @param value {@link #copyright} (A copyright statement relating to the
   *              measure and/or its contents. Copyright statements are generally
   *              legal restrictions on the use and publishing of the measure.).
   *              This is the underlying object with id, value and extensions. The
   *              accessor "getCopyright" gives direct access to the value
   */
  public Measure setCopyrightElement(MarkdownType value) {
    this.copyright = value;
    return this;
  }

  /**
   * @return A copyright statement relating to the measure and/or its contents.
   *         Copyright statements are generally legal restrictions on the use and
   *         publishing of the measure.
   */
  public String getCopyright() {
    return this.copyright == null ? null : this.copyright.getValue();
  }

  /**
   * @param value A copyright statement relating to the measure and/or its
   *              contents. Copyright statements are generally legal restrictions
   *              on the use and publishing of the measure.
   */
  public Measure setCopyright(String value) {
    if (value == null)
      this.copyright = null;
    else {
      if (this.copyright == null)
        this.copyright = new MarkdownType();
      this.copyright.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #approvalDate} (The date on which the resource content was
   *         approved by the publisher. Approval happens once when the content is
   *         officially approved for usage.). This is the underlying object with
   *         id, value and extensions. The accessor "getApprovalDate" gives direct
   *         access to the value
   */
  public DateType getApprovalDateElement() {
    if (this.approvalDate == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.approvalDate");
      else if (Configuration.doAutoCreate())
        this.approvalDate = new DateType(); // bb
    return this.approvalDate;
  }

  public boolean hasApprovalDateElement() {
    return this.approvalDate != null && !this.approvalDate.isEmpty();
  }

  public boolean hasApprovalDate() {
    return this.approvalDate != null && !this.approvalDate.isEmpty();
  }

  /**
   * @param value {@link #approvalDate} (The date on which the resource content
   *              was approved by the publisher. Approval happens once when the
   *              content is officially approved for usage.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getApprovalDate" gives direct access to the value
   */
  public Measure setApprovalDateElement(DateType value) {
    this.approvalDate = value;
    return this;
  }

  /**
   * @return The date on which the resource content was approved by the publisher.
   *         Approval happens once when the content is officially approved for
   *         usage.
   */
  public Date getApprovalDate() {
    return this.approvalDate == null ? null : this.approvalDate.getValue();
  }

  /**
   * @param value The date on which the resource content was approved by the
   *              publisher. Approval happens once when the content is officially
   *              approved for usage.
   */
  public Measure setApprovalDate(Date value) {
    if (value == null)
      this.approvalDate = null;
    else {
      if (this.approvalDate == null)
        this.approvalDate = new DateType();
      this.approvalDate.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #lastReviewDate} (The date on which the resource content was
   *         last reviewed. Review happens periodically after approval but does
   *         not change the original approval date.). This is the underlying
   *         object with id, value and extensions. The accessor
   *         "getLastReviewDate" gives direct access to the value
   */
  public DateType getLastReviewDateElement() {
    if (this.lastReviewDate == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.lastReviewDate");
      else if (Configuration.doAutoCreate())
        this.lastReviewDate = new DateType(); // bb
    return this.lastReviewDate;
  }

  public boolean hasLastReviewDateElement() {
    return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
  }

  public boolean hasLastReviewDate() {
    return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
  }

  /**
   * @param value {@link #lastReviewDate} (The date on which the resource content
   *              was last reviewed. Review happens periodically after approval
   *              but does not change the original approval date.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getLastReviewDate" gives direct access to the value
   */
  public Measure setLastReviewDateElement(DateType value) {
    this.lastReviewDate = value;
    return this;
  }

  /**
   * @return The date on which the resource content was last reviewed. Review
   *         happens periodically after approval but does not change the original
   *         approval date.
   */
  public Date getLastReviewDate() {
    return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
  }

  /**
   * @param value The date on which the resource content was last reviewed. Review
   *              happens periodically after approval but does not change the
   *              original approval date.
   */
  public Measure setLastReviewDate(Date value) {
    if (value == null)
      this.lastReviewDate = null;
    else {
      if (this.lastReviewDate == null)
        this.lastReviewDate = new DateType();
      this.lastReviewDate.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #effectivePeriod} (The period during which the measure content
   *         was or is planned to be in active use.)
   */
  public Period getEffectivePeriod() {
    if (this.effectivePeriod == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.effectivePeriod");
      else if (Configuration.doAutoCreate())
        this.effectivePeriod = new Period(); // cc
    return this.effectivePeriod;
  }

  public boolean hasEffectivePeriod() {
    return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
  }

  /**
   * @param value {@link #effectivePeriod} (The period during which the measure
   *              content was or is planned to be in active use.)
   */
  public Measure setEffectivePeriod(Period value) {
    this.effectivePeriod = value;
    return this;
  }

  /**
   * @return {@link #topic} (Descriptive topics related to the content of the
   *         measure. Topics provide a high-level categorization grouping types of
   *         measures that can be useful for filtering and searching.)
   */
  public List<CodeableConcept> getTopic() {
    if (this.topic == null)
      this.topic = new ArrayList<CodeableConcept>();
    return this.topic;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setTopic(List<CodeableConcept> theTopic) {
    this.topic = theTopic;
    return this;
  }

  public boolean hasTopic() {
    if (this.topic == null)
      return false;
    for (CodeableConcept item : this.topic)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addTopic() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.topic == null)
      this.topic = new ArrayList<CodeableConcept>();
    this.topic.add(t);
    return t;
  }

  public Measure addTopic(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.topic == null)
      this.topic = new ArrayList<CodeableConcept>();
    this.topic.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #topic}, creating it
   *         if it does not already exist {3}
   */
  public CodeableConcept getTopicFirstRep() {
    if (getTopic().isEmpty()) {
      addTopic();
    }
    return getTopic().get(0);
  }

  /**
   * @return {@link #author} (An individiual or organization primarily involved in
   *         the creation and maintenance of the content.)
   */
  public List<ContactDetail> getAuthor() {
    if (this.author == null)
      this.author = new ArrayList<ContactDetail>();
    return this.author;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setAuthor(List<ContactDetail> theAuthor) {
    this.author = theAuthor;
    return this;
  }

  public boolean hasAuthor() {
    if (this.author == null)
      return false;
    for (ContactDetail item : this.author)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addAuthor() { // 3
    ContactDetail t = new ContactDetail();
    if (this.author == null)
      this.author = new ArrayList<ContactDetail>();
    this.author.add(t);
    return t;
  }

  public Measure addAuthor(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.author == null)
      this.author = new ArrayList<ContactDetail>();
    this.author.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #author}, creating it
   *         if it does not already exist {3}
   */
  public ContactDetail getAuthorFirstRep() {
    if (getAuthor().isEmpty()) {
      addAuthor();
    }
    return getAuthor().get(0);
  }

  /**
   * @return {@link #editor} (An individual or organization primarily responsible
   *         for internal coherence of the content.)
   */
  public List<ContactDetail> getEditor() {
    if (this.editor == null)
      this.editor = new ArrayList<ContactDetail>();
    return this.editor;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setEditor(List<ContactDetail> theEditor) {
    this.editor = theEditor;
    return this;
  }

  public boolean hasEditor() {
    if (this.editor == null)
      return false;
    for (ContactDetail item : this.editor)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addEditor() { // 3
    ContactDetail t = new ContactDetail();
    if (this.editor == null)
      this.editor = new ArrayList<ContactDetail>();
    this.editor.add(t);
    return t;
  }

  public Measure addEditor(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.editor == null)
      this.editor = new ArrayList<ContactDetail>();
    this.editor.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #editor}, creating it
   *         if it does not already exist {3}
   */
  public ContactDetail getEditorFirstRep() {
    if (getEditor().isEmpty()) {
      addEditor();
    }
    return getEditor().get(0);
  }

  /**
   * @return {@link #reviewer} (An individual or organization primarily
   *         responsible for review of some aspect of the content.)
   */
  public List<ContactDetail> getReviewer() {
    if (this.reviewer == null)
      this.reviewer = new ArrayList<ContactDetail>();
    return this.reviewer;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setReviewer(List<ContactDetail> theReviewer) {
    this.reviewer = theReviewer;
    return this;
  }

  public boolean hasReviewer() {
    if (this.reviewer == null)
      return false;
    for (ContactDetail item : this.reviewer)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addReviewer() { // 3
    ContactDetail t = new ContactDetail();
    if (this.reviewer == null)
      this.reviewer = new ArrayList<ContactDetail>();
    this.reviewer.add(t);
    return t;
  }

  public Measure addReviewer(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.reviewer == null)
      this.reviewer = new ArrayList<ContactDetail>();
    this.reviewer.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #reviewer}, creating
   *         it if it does not already exist {3}
   */
  public ContactDetail getReviewerFirstRep() {
    if (getReviewer().isEmpty()) {
      addReviewer();
    }
    return getReviewer().get(0);
  }

  /**
   * @return {@link #endorser} (An individual or organization responsible for
   *         officially endorsing the content for use in some setting.)
   */
  public List<ContactDetail> getEndorser() {
    if (this.endorser == null)
      this.endorser = new ArrayList<ContactDetail>();
    return this.endorser;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setEndorser(List<ContactDetail> theEndorser) {
    this.endorser = theEndorser;
    return this;
  }

  public boolean hasEndorser() {
    if (this.endorser == null)
      return false;
    for (ContactDetail item : this.endorser)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addEndorser() { // 3
    ContactDetail t = new ContactDetail();
    if (this.endorser == null)
      this.endorser = new ArrayList<ContactDetail>();
    this.endorser.add(t);
    return t;
  }

  public Measure addEndorser(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.endorser == null)
      this.endorser = new ArrayList<ContactDetail>();
    this.endorser.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #endorser}, creating
   *         it if it does not already exist {3}
   */
  public ContactDetail getEndorserFirstRep() {
    if (getEndorser().isEmpty()) {
      addEndorser();
    }
    return getEndorser().get(0);
  }

  /**
   * @return {@link #relatedArtifact} (Related artifacts such as additional
   *         documentation, justification, or bibliographic references.)
   */
  public List<RelatedArtifact> getRelatedArtifact() {
    if (this.relatedArtifact == null)
      this.relatedArtifact = new ArrayList<RelatedArtifact>();
    return this.relatedArtifact;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) {
    this.relatedArtifact = theRelatedArtifact;
    return this;
  }

  public boolean hasRelatedArtifact() {
    if (this.relatedArtifact == null)
      return false;
    for (RelatedArtifact item : this.relatedArtifact)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public RelatedArtifact addRelatedArtifact() { // 3
    RelatedArtifact t = new RelatedArtifact();
    if (this.relatedArtifact == null)
      this.relatedArtifact = new ArrayList<RelatedArtifact>();
    this.relatedArtifact.add(t);
    return t;
  }

  public Measure addRelatedArtifact(RelatedArtifact t) { // 3
    if (t == null)
      return this;
    if (this.relatedArtifact == null)
      this.relatedArtifact = new ArrayList<RelatedArtifact>();
    this.relatedArtifact.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #relatedArtifact},
   *         creating it if it does not already exist {3}
   */
  public RelatedArtifact getRelatedArtifactFirstRep() {
    if (getRelatedArtifact().isEmpty()) {
      addRelatedArtifact();
    }
    return getRelatedArtifact().get(0);
  }

  /**
   * @return {@link #library} (A reference to a Library resource containing the
   *         formal logic used by the measure.)
   */
  public List<CanonicalType> getLibrary() {
    if (this.library == null)
      this.library = new ArrayList<CanonicalType>();
    return this.library;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setLibrary(List<CanonicalType> theLibrary) {
    this.library = theLibrary;
    return this;
  }

  public boolean hasLibrary() {
    if (this.library == null)
      return false;
    for (CanonicalType item : this.library)
      if (!item.isEmpty())
        return true;
    return false;
  }

  /**
   * @return {@link #library} (A reference to a Library resource containing the
   *         formal logic used by the measure.)
   */
  public CanonicalType addLibraryElement() {// 2
    CanonicalType t = new CanonicalType();
    if (this.library == null)
      this.library = new ArrayList<CanonicalType>();
    this.library.add(t);
    return t;
  }

  /**
   * @param value {@link #library} (A reference to a Library resource containing
   *              the formal logic used by the measure.)
   */
  public Measure addLibrary(String value) { // 1
    CanonicalType t = new CanonicalType();
    t.setValue(value);
    if (this.library == null)
      this.library = new ArrayList<CanonicalType>();
    this.library.add(t);
    return this;
  }

  /**
   * @param value {@link #library} (A reference to a Library resource containing
   *              the formal logic used by the measure.)
   */
  public boolean hasLibrary(String value) {
    if (this.library == null)
      return false;
    for (CanonicalType v : this.library)
      if (v.getValue().equals(value)) // canonical
        return true;
    return false;
  }

  /**
   * @return {@link #disclaimer} (Notices and disclaimers regarding the use of the
   *         measure or related to intellectual property (such as code systems)
   *         referenced by the measure.). This is the underlying object with id,
   *         value and extensions. The accessor "getDisclaimer" gives direct
   *         access to the value
   */
  public MarkdownType getDisclaimerElement() {
    if (this.disclaimer == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.disclaimer");
      else if (Configuration.doAutoCreate())
        this.disclaimer = new MarkdownType(); // bb
    return this.disclaimer;
  }

  public boolean hasDisclaimerElement() {
    return this.disclaimer != null && !this.disclaimer.isEmpty();
  }

  public boolean hasDisclaimer() {
    return this.disclaimer != null && !this.disclaimer.isEmpty();
  }

  /**
   * @param value {@link #disclaimer} (Notices and disclaimers regarding the use
   *              of the measure or related to intellectual property (such as code
   *              systems) referenced by the measure.). This is the underlying
   *              object with id, value and extensions. The accessor
   *              "getDisclaimer" gives direct access to the value
   */
  public Measure setDisclaimerElement(MarkdownType value) {
    this.disclaimer = value;
    return this;
  }

  /**
   * @return Notices and disclaimers regarding the use of the measure or related
   *         to intellectual property (such as code systems) referenced by the
   *         measure.
   */
  public String getDisclaimer() {
    return this.disclaimer == null ? null : this.disclaimer.getValue();
  }

  /**
   * @param value Notices and disclaimers regarding the use of the measure or
   *              related to intellectual property (such as code systems)
   *              referenced by the measure.
   */
  public Measure setDisclaimer(String value) {
    if (value == null)
      this.disclaimer = null;
    else {
      if (this.disclaimer == null)
        this.disclaimer = new MarkdownType();
      this.disclaimer.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #scoring} (Indicates how the calculation is performed for the
   *         measure, including proportion, ratio, continuous-variable, and
   *         cohort. The value set is extensible, allowing additional measure
   *         scoring types to be represented.)
   */
  public CodeableConcept getScoring() {
    if (this.scoring == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.scoring");
      else if (Configuration.doAutoCreate())
        this.scoring = new CodeableConcept(); // cc
    return this.scoring;
  }

  public boolean hasScoring() {
    return this.scoring != null && !this.scoring.isEmpty();
  }

  /**
   * @param value {@link #scoring} (Indicates how the calculation is performed for
   *              the measure, including proportion, ratio, continuous-variable,
   *              and cohort. The value set is extensible, allowing additional
   *              measure scoring types to be represented.)
   */
  public Measure setScoring(CodeableConcept value) {
    this.scoring = value;
    return this;
  }

  /**
   * @return {@link #compositeScoring} (If this is a composite measure, the
   *         scoring method used to combine the component measures to determine
   *         the composite score.)
   */
  public CodeableConcept getCompositeScoring() {
    if (this.compositeScoring == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.compositeScoring");
      else if (Configuration.doAutoCreate())
        this.compositeScoring = new CodeableConcept(); // cc
    return this.compositeScoring;
  }

  public boolean hasCompositeScoring() {
    return this.compositeScoring != null && !this.compositeScoring.isEmpty();
  }

  /**
   * @param value {@link #compositeScoring} (If this is a composite measure, the
   *              scoring method used to combine the component measures to
   *              determine the composite score.)
   */
  public Measure setCompositeScoring(CodeableConcept value) {
    this.compositeScoring = value;
    return this;
  }

  /**
   * @return {@link #type} (Indicates whether the measure is used to examine a
   *         process, an outcome over time, a patient-reported outcome, or a
   *         structure measure such as utilization.)
   */
  public List<CodeableConcept> getType() {
    if (this.type == null)
      this.type = new ArrayList<CodeableConcept>();
    return this.type;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setType(List<CodeableConcept> theType) {
    this.type = theType;
    return this;
  }

  public boolean hasType() {
    if (this.type == null)
      return false;
    for (CodeableConcept item : this.type)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addType() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.type == null)
      this.type = new ArrayList<CodeableConcept>();
    this.type.add(t);
    return t;
  }

  public Measure addType(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.type == null)
      this.type = new ArrayList<CodeableConcept>();
    this.type.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #type}, creating it if
   *         it does not already exist {3}
   */
  public CodeableConcept getTypeFirstRep() {
    if (getType().isEmpty()) {
      addType();
    }
    return getType().get(0);
  }

  /**
   * @return {@link #riskAdjustment} (A description of the risk adjustment factors
   *         that may impact the resulting score for the measure and how they may
   *         be accounted for when computing and reporting measure results.). This
   *         is the underlying object with id, value and extensions. The accessor
   *         "getRiskAdjustment" gives direct access to the value
   */
  public StringType getRiskAdjustmentElement() {
    if (this.riskAdjustment == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.riskAdjustment");
      else if (Configuration.doAutoCreate())
        this.riskAdjustment = new StringType(); // bb
    return this.riskAdjustment;
  }

  public boolean hasRiskAdjustmentElement() {
    return this.riskAdjustment != null && !this.riskAdjustment.isEmpty();
  }

  public boolean hasRiskAdjustment() {
    return this.riskAdjustment != null && !this.riskAdjustment.isEmpty();
  }

  /**
   * @param value {@link #riskAdjustment} (A description of the risk adjustment
   *              factors that may impact the resulting score for the measure and
   *              how they may be accounted for when computing and reporting
   *              measure results.). This is the underlying object with id, value
   *              and extensions. The accessor "getRiskAdjustment" gives direct
   *              access to the value
   */
  public Measure setRiskAdjustmentElement(StringType value) {
    this.riskAdjustment = value;
    return this;
  }

  /**
   * @return A description of the risk adjustment factors that may impact the
   *         resulting score for the measure and how they may be accounted for
   *         when computing and reporting measure results.
   */
  public String getRiskAdjustment() {
    return this.riskAdjustment == null ? null : this.riskAdjustment.getValue();
  }

  /**
   * @param value A description of the risk adjustment factors that may impact the
   *              resulting score for the measure and how they may be accounted
   *              for when computing and reporting measure results.
   */
  public Measure setRiskAdjustment(String value) {
    if (Utilities.noString(value))
      this.riskAdjustment = null;
    else {
      if (this.riskAdjustment == null)
        this.riskAdjustment = new StringType();
      this.riskAdjustment.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #rateAggregation} (Describes how to combine the information
   *         calculated, based on logic in each of several populations, into one
   *         summarized result.). This is the underlying object with id, value and
   *         extensions. The accessor "getRateAggregation" gives direct access to
   *         the value
   */
  public StringType getRateAggregationElement() {
    if (this.rateAggregation == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.rateAggregation");
      else if (Configuration.doAutoCreate())
        this.rateAggregation = new StringType(); // bb
    return this.rateAggregation;
  }

  public boolean hasRateAggregationElement() {
    return this.rateAggregation != null && !this.rateAggregation.isEmpty();
  }

  public boolean hasRateAggregation() {
    return this.rateAggregation != null && !this.rateAggregation.isEmpty();
  }

  /**
   * @param value {@link #rateAggregation} (Describes how to combine the
   *              information calculated, based on logic in each of several
   *              populations, into one summarized result.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getRateAggregation" gives direct access to the value
   */
  public Measure setRateAggregationElement(StringType value) {
    this.rateAggregation = value;
    return this;
  }

  /**
   * @return Describes how to combine the information calculated, based on logic
   *         in each of several populations, into one summarized result.
   */
  public String getRateAggregation() {
    return this.rateAggregation == null ? null : this.rateAggregation.getValue();
  }

  /**
   * @param value Describes how to combine the information calculated, based on
   *              logic in each of several populations, into one summarized
   *              result.
   */
  public Measure setRateAggregation(String value) {
    if (Utilities.noString(value))
      this.rateAggregation = null;
    else {
      if (this.rateAggregation == null)
        this.rateAggregation = new StringType();
      this.rateAggregation.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #rationale} (Provides a succinct statement of the need for the
   *         measure. Usually includes statements pertaining to importance
   *         criterion: impact, gap in care, and evidence.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getRationale" gives direct access to the value
   */
  public MarkdownType getRationaleElement() {
    if (this.rationale == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.rationale");
      else if (Configuration.doAutoCreate())
        this.rationale = new MarkdownType(); // bb
    return this.rationale;
  }

  public boolean hasRationaleElement() {
    return this.rationale != null && !this.rationale.isEmpty();
  }

  public boolean hasRationale() {
    return this.rationale != null && !this.rationale.isEmpty();
  }

  /**
   * @param value {@link #rationale} (Provides a succinct statement of the need
   *              for the measure. Usually includes statements pertaining to
   *              importance criterion: impact, gap in care, and evidence.). This
   *              is the underlying object with id, value and extensions. The
   *              accessor "getRationale" gives direct access to the value
   */
  public Measure setRationaleElement(MarkdownType value) {
    this.rationale = value;
    return this;
  }

  /**
   * @return Provides a succinct statement of the need for the measure. Usually
   *         includes statements pertaining to importance criterion: impact, gap
   *         in care, and evidence.
   */
  public String getRationale() {
    return this.rationale == null ? null : this.rationale.getValue();
  }

  /**
   * @param value Provides a succinct statement of the need for the measure.
   *              Usually includes statements pertaining to importance criterion:
   *              impact, gap in care, and evidence.
   */
  public Measure setRationale(String value) {
    if (value == null)
      this.rationale = null;
    else {
      if (this.rationale == null)
        this.rationale = new MarkdownType();
      this.rationale.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #clinicalRecommendationStatement} (Provides a summary of
   *         relevant clinical guidelines or other clinical recommendations
   *         supporting the measure.). This is the underlying object with id,
   *         value and extensions. The accessor
   *         "getClinicalRecommendationStatement" gives direct access to the value
   */
  public MarkdownType getClinicalRecommendationStatementElement() {
    if (this.clinicalRecommendationStatement == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.clinicalRecommendationStatement");
      else if (Configuration.doAutoCreate())
        this.clinicalRecommendationStatement = new MarkdownType(); // bb
    return this.clinicalRecommendationStatement;
  }

  public boolean hasClinicalRecommendationStatementElement() {
    return this.clinicalRecommendationStatement != null && !this.clinicalRecommendationStatement.isEmpty();
  }

  public boolean hasClinicalRecommendationStatement() {
    return this.clinicalRecommendationStatement != null && !this.clinicalRecommendationStatement.isEmpty();
  }

  /**
   * @param value {@link #clinicalRecommendationStatement} (Provides a summary of
   *              relevant clinical guidelines or other clinical recommendations
   *              supporting the measure.). This is the underlying object with id,
   *              value and extensions. The accessor
   *              "getClinicalRecommendationStatement" gives direct access to the
   *              value
   */
  public Measure setClinicalRecommendationStatementElement(MarkdownType value) {
    this.clinicalRecommendationStatement = value;
    return this;
  }

  /**
   * @return Provides a summary of relevant clinical guidelines or other clinical
   *         recommendations supporting the measure.
   */
  public String getClinicalRecommendationStatement() {
    return this.clinicalRecommendationStatement == null ? null : this.clinicalRecommendationStatement.getValue();
  }

  /**
   * @param value Provides a summary of relevant clinical guidelines or other
   *              clinical recommendations supporting the measure.
   */
  public Measure setClinicalRecommendationStatement(String value) {
    if (value == null)
      this.clinicalRecommendationStatement = null;
    else {
      if (this.clinicalRecommendationStatement == null)
        this.clinicalRecommendationStatement = new MarkdownType();
      this.clinicalRecommendationStatement.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #improvementNotation} (Information on whether an increase or
   *         decrease in score is the preferred result (e.g., a higher score
   *         indicates better quality OR a lower score indicates better quality OR
   *         quality is within a range).)
   */
  public CodeableConcept getImprovementNotation() {
    if (this.improvementNotation == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.improvementNotation");
      else if (Configuration.doAutoCreate())
        this.improvementNotation = new CodeableConcept(); // cc
    return this.improvementNotation;
  }

  public boolean hasImprovementNotation() {
    return this.improvementNotation != null && !this.improvementNotation.isEmpty();
  }

  /**
   * @param value {@link #improvementNotation} (Information on whether an increase
   *              or decrease in score is the preferred result (e.g., a higher
   *              score indicates better quality OR a lower score indicates better
   *              quality OR quality is within a range).)
   */
  public Measure setImprovementNotation(CodeableConcept value) {
    this.improvementNotation = value;
    return this;
  }

  /**
   * @return {@link #definition} (Provides a description of an individual term
   *         used within the measure.)
   */
  public List<MarkdownType> getDefinition() {
    if (this.definition == null)
      this.definition = new ArrayList<MarkdownType>();
    return this.definition;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setDefinition(List<MarkdownType> theDefinition) {
    this.definition = theDefinition;
    return this;
  }

  public boolean hasDefinition() {
    if (this.definition == null)
      return false;
    for (MarkdownType item : this.definition)
      if (!item.isEmpty())
        return true;
    return false;
  }

  /**
   * @return {@link #definition} (Provides a description of an individual term
   *         used within the measure.)
   */
  public MarkdownType addDefinitionElement() {// 2
    MarkdownType t = new MarkdownType();
    if (this.definition == null)
      this.definition = new ArrayList<MarkdownType>();
    this.definition.add(t);
    return t;
  }

  /**
   * @param value {@link #definition} (Provides a description of an individual
   *              term used within the measure.)
   */
  public Measure addDefinition(String value) { // 1
    MarkdownType t = new MarkdownType();
    t.setValue(value);
    if (this.definition == null)
      this.definition = new ArrayList<MarkdownType>();
    this.definition.add(t);
    return this;
  }

  /**
   * @param value {@link #definition} (Provides a description of an individual
   *              term used within the measure.)
   */
  public boolean hasDefinition(String value) {
    if (this.definition == null)
      return false;
    for (MarkdownType v : this.definition)
      if (v.getValue().equals(value)) // markdown
        return true;
    return false;
  }

  /**
   * @return {@link #guidance} (Additional guidance for the measure including how
   *         it can be used in a clinical context, and the intent of the
   *         measure.). This is the underlying object with id, value and
   *         extensions. The accessor "getGuidance" gives direct access to the
   *         value
   */
  public MarkdownType getGuidanceElement() {
    if (this.guidance == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Measure.guidance");
      else if (Configuration.doAutoCreate())
        this.guidance = new MarkdownType(); // bb
    return this.guidance;
  }

  public boolean hasGuidanceElement() {
    return this.guidance != null && !this.guidance.isEmpty();
  }

  public boolean hasGuidance() {
    return this.guidance != null && !this.guidance.isEmpty();
  }

  /**
   * @param value {@link #guidance} (Additional guidance for the measure including
   *              how it can be used in a clinical context, and the intent of the
   *              measure.). This is the underlying object with id, value and
   *              extensions. The accessor "getGuidance" gives direct access to
   *              the value
   */
  public Measure setGuidanceElement(MarkdownType value) {
    this.guidance = value;
    return this;
  }

  /**
   * @return Additional guidance for the measure including how it can be used in a
   *         clinical context, and the intent of the measure.
   */
  public String getGuidance() {
    return this.guidance == null ? null : this.guidance.getValue();
  }

  /**
   * @param value Additional guidance for the measure including how it can be used
   *              in a clinical context, and the intent of the measure.
   */
  public Measure setGuidance(String value) {
    if (value == null)
      this.guidance = null;
    else {
      if (this.guidance == null)
        this.guidance = new MarkdownType();
      this.guidance.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #group} (A group of population criteria for the measure.)
   */
  public List<MeasureGroupComponent> getGroup() {
    if (this.group == null)
      this.group = new ArrayList<MeasureGroupComponent>();
    return this.group;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setGroup(List<MeasureGroupComponent> theGroup) {
    this.group = theGroup;
    return this;
  }

  public boolean hasGroup() {
    if (this.group == null)
      return false;
    for (MeasureGroupComponent item : this.group)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public MeasureGroupComponent addGroup() { // 3
    MeasureGroupComponent t = new MeasureGroupComponent();
    if (this.group == null)
      this.group = new ArrayList<MeasureGroupComponent>();
    this.group.add(t);
    return t;
  }

  public Measure addGroup(MeasureGroupComponent t) { // 3
    if (t == null)
      return this;
    if (this.group == null)
      this.group = new ArrayList<MeasureGroupComponent>();
    this.group.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #group}, creating it
   *         if it does not already exist {3}
   */
  public MeasureGroupComponent getGroupFirstRep() {
    if (getGroup().isEmpty()) {
      addGroup();
    }
    return getGroup().get(0);
  }

  /**
   * @return {@link #supplementalData} (The supplemental data criteria for the
   *         measure report, specified as either the name of a valid CQL
   *         expression within a referenced library, or a valid FHIR Resource
   *         Path.)
   */
  public List<MeasureSupplementalDataComponent> getSupplementalData() {
    if (this.supplementalData == null)
      this.supplementalData = new ArrayList<MeasureSupplementalDataComponent>();
    return this.supplementalData;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Measure setSupplementalData(List<MeasureSupplementalDataComponent> theSupplementalData) {
    this.supplementalData = theSupplementalData;
    return this;
  }

  public boolean hasSupplementalData() {
    if (this.supplementalData == null)
      return false;
    for (MeasureSupplementalDataComponent item : this.supplementalData)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public MeasureSupplementalDataComponent addSupplementalData() { // 3
    MeasureSupplementalDataComponent t = new MeasureSupplementalDataComponent();
    if (this.supplementalData == null)
      this.supplementalData = new ArrayList<MeasureSupplementalDataComponent>();
    this.supplementalData.add(t);
    return t;
  }

  public Measure addSupplementalData(MeasureSupplementalDataComponent t) { // 3
    if (t == null)
      return this;
    if (this.supplementalData == null)
      this.supplementalData = new ArrayList<MeasureSupplementalDataComponent>();
    this.supplementalData.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #supplementalData},
   *         creating it if it does not already exist {3}
   */
  public MeasureSupplementalDataComponent getSupplementalDataFirstRep() {
    if (getSupplementalData().isEmpty()) {
      addSupplementalData();
    }
    return getSupplementalData().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("url", "uri",
        "An absolute URI that is used to identify this measure when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this measure is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the measure is stored on different servers.",
        0, 1, url));
    children.add(new Property("identifier", "Identifier",
        "A formal identifier that is used to identify this measure when it is represented in other formats, or referenced in a specification, model, design or an instance.",
        0, java.lang.Integer.MAX_VALUE, identifier));
    children.add(new Property("version", "string",
        "The identifier that is used to identify this version of the measure when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the measure author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.",
        0, 1, version));
    children.add(new Property("name", "string",
        "A natural language name identifying the measure. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
        0, 1, name));
    children.add(
        new Property("title", "string", "A short, descriptive, user-friendly title for the measure.", 0, 1, title));
    children.add(new Property("subtitle", "string",
        "An explanatory or alternate title for the measure giving additional information about its content.", 0, 1,
        subtitle));
    children.add(new Property("status", "code",
        "The status of this measure. Enables tracking the life-cycle of the content.", 0, 1, status));
    children.add(new Property("experimental", "boolean",
        "A Boolean value to indicate that this measure is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
        0, 1, experimental));
    children.add(new Property("subject[x]", "CodeableConcept|Reference(Group)",
        "The intended subjects for the measure. If this element is not provided, a Patient subject is assumed, but the subject of the measure can be anything.",
        0, 1, subject));
    children.add(new Property("date", "dateTime",
        "The date  (and optionally time) when the measure was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the measure changes.",
        0, 1, date));
    children.add(new Property("publisher", "string",
        "The name of the organization or individual that published the measure.", 0, 1, publisher));
    children.add(new Property("contact", "ContactDetail",
        "Contact details to assist a user in finding and communicating with the publisher.", 0,
        java.lang.Integer.MAX_VALUE, contact));
    children.add(new Property("description", "markdown",
        "A free text natural language description of the measure from a consumer's perspective.", 0, 1, description));
    children.add(new Property("useContext", "UsageContext",
        "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate measure instances.",
        0, java.lang.Integer.MAX_VALUE, useContext));
    children.add(new Property("jurisdiction", "CodeableConcept",
        "A legal or geographic region in which the measure is intended to be used.", 0, java.lang.Integer.MAX_VALUE,
        jurisdiction));
    children.add(new Property("purpose", "markdown",
        "Explanation of why this measure is needed and why it has been designed as it has.", 0, 1, purpose));
    children.add(new Property("usage", "string",
        "A detailed description, from a clinical perspective, of how the measure is used.", 0, 1, usage));
    children.add(new Property("copyright", "markdown",
        "A copyright statement relating to the measure and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the measure.",
        0, 1, copyright));
    children.add(new Property("approvalDate", "date",
        "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.",
        0, 1, approvalDate));
    children.add(new Property("lastReviewDate", "date",
        "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.",
        0, 1, lastReviewDate));
    children.add(new Property("effectivePeriod", "Period",
        "The period during which the measure content was or is planned to be in active use.", 0, 1, effectivePeriod));
    children.add(new Property("topic", "CodeableConcept",
        "Descriptive topics related to the content of the measure. Topics provide a high-level categorization grouping types of measures that can be useful for filtering and searching.",
        0, java.lang.Integer.MAX_VALUE, topic));
    children.add(new Property("author", "ContactDetail",
        "An individiual or organization primarily involved in the creation and maintenance of the content.", 0,
        java.lang.Integer.MAX_VALUE, author));
    children.add(new Property("editor", "ContactDetail",
        "An individual or organization primarily responsible for internal coherence of the content.", 0,
        java.lang.Integer.MAX_VALUE, editor));
    children.add(new Property("reviewer", "ContactDetail",
        "An individual or organization primarily responsible for review of some aspect of the content.", 0,
        java.lang.Integer.MAX_VALUE, reviewer));
    children.add(new Property("endorser", "ContactDetail",
        "An individual or organization responsible for officially endorsing the content for use in some setting.", 0,
        java.lang.Integer.MAX_VALUE, endorser));
    children.add(new Property("relatedArtifact", "RelatedArtifact",
        "Related artifacts such as additional documentation, justification, or bibliographic references.", 0,
        java.lang.Integer.MAX_VALUE, relatedArtifact));
    children.add(new Property("library", "canonical(Library)",
        "A reference to a Library resource containing the formal logic used by the measure.", 0,
        java.lang.Integer.MAX_VALUE, library));
    children.add(new Property("disclaimer", "markdown",
        "Notices and disclaimers regarding the use of the measure or related to intellectual property (such as code systems) referenced by the measure.",
        0, 1, disclaimer));
    children.add(new Property("scoring", "CodeableConcept",
        "Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented.",
        0, 1, scoring));
    children.add(new Property("compositeScoring", "CodeableConcept",
        "If this is a composite measure, the scoring method used to combine the component measures to determine the composite score.",
        0, 1, compositeScoring));
    children.add(new Property("type", "CodeableConcept",
        "Indicates whether the measure is used to examine a process, an outcome over time, a patient-reported outcome, or a structure measure such as utilization.",
        0, java.lang.Integer.MAX_VALUE, type));
    children.add(new Property("riskAdjustment", "string",
        "A description of the risk adjustment factors that may impact the resulting score for the measure and how they may be accounted for when computing and reporting measure results.",
        0, 1, riskAdjustment));
    children.add(new Property("rateAggregation", "string",
        "Describes how to combine the information calculated, based on logic in each of several populations, into one summarized result.",
        0, 1, rateAggregation));
    children.add(new Property("rationale", "markdown",
        "Provides a succinct statement of the need for the measure. Usually includes statements pertaining to importance criterion: impact, gap in care, and evidence.",
        0, 1, rationale));
    children.add(new Property("clinicalRecommendationStatement", "markdown",
        "Provides a summary of relevant clinical guidelines or other clinical recommendations supporting the measure.",
        0, 1, clinicalRecommendationStatement));
    children.add(new Property("improvementNotation", "CodeableConcept",
        "Information on whether an increase or decrease in score is the preferred result (e.g., a higher score indicates better quality OR a lower score indicates better quality OR quality is within a range).",
        0, 1, improvementNotation));
    children.add(
        new Property("definition", "markdown", "Provides a description of an individual term used within the measure.",
            0, java.lang.Integer.MAX_VALUE, definition));
    children.add(new Property("guidance", "markdown",
        "Additional guidance for the measure including how it can be used in a clinical context, and the intent of the measure.",
        0, 1, guidance));
    children.add(new Property("group", "", "A group of population criteria for the measure.", 0,
        java.lang.Integer.MAX_VALUE, group));
    children.add(new Property("supplementalData", "",
        "The supplemental data criteria for the measure report, specified as either the name of a valid CQL expression within a referenced library, or a valid FHIR Resource Path.",
        0, java.lang.Integer.MAX_VALUE, supplementalData));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case 116079:
      /* url */ return new Property("url", "uri",
          "An absolute URI that is used to identify this measure when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this measure is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the measure is stored on different servers.",
          0, 1, url);
    case -1618432855:
      /* identifier */ return new Property("identifier", "Identifier",
          "A formal identifier that is used to identify this measure when it is represented in other formats, or referenced in a specification, model, design or an instance.",
          0, java.lang.Integer.MAX_VALUE, identifier);
    case 351608024:
      /* version */ return new Property("version", "string",
          "The identifier that is used to identify this version of the measure when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the measure author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.",
          0, 1, version);
    case 3373707:
      /* name */ return new Property("name", "string",
          "A natural language name identifying the measure. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
          0, 1, name);
    case 110371416:
      /* title */ return new Property("title", "string", "A short, descriptive, user-friendly title for the measure.",
          0, 1, title);
    case -2060497896:
      /* subtitle */ return new Property("subtitle", "string",
          "An explanatory or alternate title for the measure giving additional information about its content.", 0, 1,
          subtitle);
    case -892481550:
      /* status */ return new Property("status", "code",
          "The status of this measure. Enables tracking the life-cycle of the content.", 0, 1, status);
    case -404562712:
      /* experimental */ return new Property("experimental", "boolean",
          "A Boolean value to indicate that this measure is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
          0, 1, experimental);
    case -573640748:
      /* subject[x] */ return new Property("subject[x]", "CodeableConcept|Reference(Group)",
          "The intended subjects for the measure. If this element is not provided, a Patient subject is assumed, but the subject of the measure can be anything.",
          0, 1, subject);
    case -1867885268:
      /* subject */ return new Property("subject[x]", "CodeableConcept|Reference(Group)",
          "The intended subjects for the measure. If this element is not provided, a Patient subject is assumed, but the subject of the measure can be anything.",
          0, 1, subject);
    case -1257122603:
      /* subjectCodeableConcept */ return new Property("subject[x]", "CodeableConcept",
          "The intended subjects for the measure. If this element is not provided, a Patient subject is assumed, but the subject of the measure can be anything.",
          0, 1, subject);
    case 772938623:
      /* subjectReference */ return new Property("subject[x]", "Reference(Group)",
          "The intended subjects for the measure. If this element is not provided, a Patient subject is assumed, but the subject of the measure can be anything.",
          0, 1, subject);
    case 3076014:
      /* date */ return new Property("date", "dateTime",
          "The date  (and optionally time) when the measure was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the measure changes.",
          0, 1, date);
    case 1447404028:
      /* publisher */ return new Property("publisher", "string",
          "The name of the organization or individual that published the measure.", 0, 1, publisher);
    case 951526432:
      /* contact */ return new Property("contact", "ContactDetail",
          "Contact details to assist a user in finding and communicating with the publisher.", 0,
          java.lang.Integer.MAX_VALUE, contact);
    case -1724546052:
      /* description */ return new Property("description", "markdown",
          "A free text natural language description of the measure from a consumer's perspective.", 0, 1, description);
    case -669707736:
      /* useContext */ return new Property("useContext", "UsageContext",
          "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate measure instances.",
          0, java.lang.Integer.MAX_VALUE, useContext);
    case -507075711:
      /* jurisdiction */ return new Property("jurisdiction", "CodeableConcept",
          "A legal or geographic region in which the measure is intended to be used.", 0, java.lang.Integer.MAX_VALUE,
          jurisdiction);
    case -220463842:
      /* purpose */ return new Property("purpose", "markdown",
          "Explanation of why this measure is needed and why it has been designed as it has.", 0, 1, purpose);
    case 111574433:
      /* usage */ return new Property("usage", "string",
          "A detailed description, from a clinical perspective, of how the measure is used.", 0, 1, usage);
    case 1522889671:
      /* copyright */ return new Property("copyright", "markdown",
          "A copyright statement relating to the measure and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the measure.",
          0, 1, copyright);
    case 223539345:
      /* approvalDate */ return new Property("approvalDate", "date",
          "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.",
          0, 1, approvalDate);
    case -1687512484:
      /* lastReviewDate */ return new Property("lastReviewDate", "date",
          "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.",
          0, 1, lastReviewDate);
    case -403934648:
      /* effectivePeriod */ return new Property("effectivePeriod", "Period",
          "The period during which the measure content was or is planned to be in active use.", 0, 1, effectivePeriod);
    case 110546223:
      /* topic */ return new Property("topic", "CodeableConcept",
          "Descriptive topics related to the content of the measure. Topics provide a high-level categorization grouping types of measures that can be useful for filtering and searching.",
          0, java.lang.Integer.MAX_VALUE, topic);
    case -1406328437:
      /* author */ return new Property("author", "ContactDetail",
          "An individiual or organization primarily involved in the creation and maintenance of the content.", 0,
          java.lang.Integer.MAX_VALUE, author);
    case -1307827859:
      /* editor */ return new Property("editor", "ContactDetail",
          "An individual or organization primarily responsible for internal coherence of the content.", 0,
          java.lang.Integer.MAX_VALUE, editor);
    case -261190139:
      /* reviewer */ return new Property("reviewer", "ContactDetail",
          "An individual or organization primarily responsible for review of some aspect of the content.", 0,
          java.lang.Integer.MAX_VALUE, reviewer);
    case 1740277666:
      /* endorser */ return new Property("endorser", "ContactDetail",
          "An individual or organization responsible for officially endorsing the content for use in some setting.", 0,
          java.lang.Integer.MAX_VALUE, endorser);
    case 666807069:
      /* relatedArtifact */ return new Property("relatedArtifact", "RelatedArtifact",
          "Related artifacts such as additional documentation, justification, or bibliographic references.", 0,
          java.lang.Integer.MAX_VALUE, relatedArtifact);
    case 166208699:
      /* library */ return new Property("library", "canonical(Library)",
          "A reference to a Library resource containing the formal logic used by the measure.", 0,
          java.lang.Integer.MAX_VALUE, library);
    case 432371099:
      /* disclaimer */ return new Property("disclaimer", "markdown",
          "Notices and disclaimers regarding the use of the measure or related to intellectual property (such as code systems) referenced by the measure.",
          0, 1, disclaimer);
    case 1924005583:
      /* scoring */ return new Property("scoring", "CodeableConcept",
          "Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented.",
          0, 1, scoring);
    case 569347656:
      /* compositeScoring */ return new Property("compositeScoring", "CodeableConcept",
          "If this is a composite measure, the scoring method used to combine the component measures to determine the composite score.",
          0, 1, compositeScoring);
    case 3575610:
      /* type */ return new Property("type", "CodeableConcept",
          "Indicates whether the measure is used to examine a process, an outcome over time, a patient-reported outcome, or a structure measure such as utilization.",
          0, java.lang.Integer.MAX_VALUE, type);
    case 93273500:
      /* riskAdjustment */ return new Property("riskAdjustment", "string",
          "A description of the risk adjustment factors that may impact the resulting score for the measure and how they may be accounted for when computing and reporting measure results.",
          0, 1, riskAdjustment);
    case 1254503906:
      /* rateAggregation */ return new Property("rateAggregation", "string",
          "Describes how to combine the information calculated, based on logic in each of several populations, into one summarized result.",
          0, 1, rateAggregation);
    case 345689335:
      /* rationale */ return new Property("rationale", "markdown",
          "Provides a succinct statement of the need for the measure. Usually includes statements pertaining to importance criterion: impact, gap in care, and evidence.",
          0, 1, rationale);
    case -18631389:
      /* clinicalRecommendationStatement */ return new Property("clinicalRecommendationStatement", "markdown",
          "Provides a summary of relevant clinical guidelines or other clinical recommendations supporting the measure.",
          0, 1, clinicalRecommendationStatement);
    case -2085456136:
      /* improvementNotation */ return new Property("improvementNotation", "CodeableConcept",
          "Information on whether an increase or decrease in score is the preferred result (e.g., a higher score indicates better quality OR a lower score indicates better quality OR quality is within a range).",
          0, 1, improvementNotation);
    case -1014418093:
      /* definition */ return new Property("definition", "markdown",
          "Provides a description of an individual term used within the measure.", 0, java.lang.Integer.MAX_VALUE,
          definition);
    case -1314002088:
      /* guidance */ return new Property("guidance", "markdown",
          "Additional guidance for the measure including how it can be used in a clinical context, and the intent of the measure.",
          0, 1, guidance);
    case 98629247:
      /* group */ return new Property("group", "", "A group of population criteria for the measure.", 0,
          java.lang.Integer.MAX_VALUE, group);
    case 1447496814:
      /* supplementalData */ return new Property("supplementalData", "",
          "The supplemental data criteria for the measure report, specified as either the name of a valid CQL expression within a referenced library, or a valid FHIR Resource Path.",
          0, java.lang.Integer.MAX_VALUE, supplementalData);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case 116079:
      /* url */ return this.url == null ? new Base[0] : new Base[] { this.url }; // UriType
    case -1618432855:
      /* identifier */ return this.identifier == null ? new Base[0]
          : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
    case 351608024:
      /* version */ return this.version == null ? new Base[0] : new Base[] { this.version }; // StringType
    case 3373707:
      /* name */ return this.name == null ? new Base[0] : new Base[] { this.name }; // StringType
    case 110371416:
      /* title */ return this.title == null ? new Base[0] : new Base[] { this.title }; // StringType
    case -2060497896:
      /* subtitle */ return this.subtitle == null ? new Base[0] : new Base[] { this.subtitle }; // StringType
    case -892481550:
      /* status */ return this.status == null ? new Base[0] : new Base[] { this.status }; // Enumeration<PublicationStatus>
    case -404562712:
      /* experimental */ return this.experimental == null ? new Base[0] : new Base[] { this.experimental }; // BooleanType
    case -1867885268:
      /* subject */ return this.subject == null ? new Base[0] : new Base[] { this.subject }; // DataType
    case 3076014:
      /* date */ return this.date == null ? new Base[0] : new Base[] { this.date }; // DateTimeType
    case 1447404028:
      /* publisher */ return this.publisher == null ? new Base[0] : new Base[] { this.publisher }; // StringType
    case 951526432:
      /* contact */ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
    case -1724546052:
      /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // MarkdownType
    case -669707736:
      /* useContext */ return this.useContext == null ? new Base[0]
          : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
    case -507075711:
      /* jurisdiction */ return this.jurisdiction == null ? new Base[0]
          : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
    case -220463842:
      /* purpose */ return this.purpose == null ? new Base[0] : new Base[] { this.purpose }; // MarkdownType
    case 111574433:
      /* usage */ return this.usage == null ? new Base[0] : new Base[] { this.usage }; // StringType
    case 1522889671:
      /* copyright */ return this.copyright == null ? new Base[0] : new Base[] { this.copyright }; // MarkdownType
    case 223539345:
      /* approvalDate */ return this.approvalDate == null ? new Base[0] : new Base[] { this.approvalDate }; // DateType
    case -1687512484:
      /* lastReviewDate */ return this.lastReviewDate == null ? new Base[0] : new Base[] { this.lastReviewDate }; // DateType
    case -403934648:
      /* effectivePeriod */ return this.effectivePeriod == null ? new Base[0] : new Base[] { this.effectivePeriod }; // Period
    case 110546223:
      /* topic */ return this.topic == null ? new Base[0] : this.topic.toArray(new Base[this.topic.size()]); // CodeableConcept
    case -1406328437:
      /* author */ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
    case -1307827859:
      /* editor */ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
    case -261190139:
      /* reviewer */ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
    case 1740277666:
      /* endorser */ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
    case 666807069:
      /* relatedArtifact */ return this.relatedArtifact == null ? new Base[0]
          : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
    case 166208699:
      /* library */ return this.library == null ? new Base[0] : this.library.toArray(new Base[this.library.size()]); // CanonicalType
    case 432371099:
      /* disclaimer */ return this.disclaimer == null ? new Base[0] : new Base[] { this.disclaimer }; // MarkdownType
    case 1924005583:
      /* scoring */ return this.scoring == null ? new Base[0] : new Base[] { this.scoring }; // CodeableConcept
    case 569347656:
      /* compositeScoring */ return this.compositeScoring == null ? new Base[0] : new Base[] { this.compositeScoring }; // CodeableConcept
    case 3575610:
      /* type */ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
    case 93273500:
      /* riskAdjustment */ return this.riskAdjustment == null ? new Base[0] : new Base[] { this.riskAdjustment }; // StringType
    case 1254503906:
      /* rateAggregation */ return this.rateAggregation == null ? new Base[0] : new Base[] { this.rateAggregation }; // StringType
    case 345689335:
      /* rationale */ return this.rationale == null ? new Base[0] : new Base[] { this.rationale }; // MarkdownType
    case -18631389:
      /* clinicalRecommendationStatement */ return this.clinicalRecommendationStatement == null ? new Base[0]
          : new Base[] { this.clinicalRecommendationStatement }; // MarkdownType
    case -2085456136:
      /* improvementNotation */ return this.improvementNotation == null ? new Base[0]
          : new Base[] { this.improvementNotation }; // CodeableConcept
    case -1014418093:
      /* definition */ return this.definition == null ? new Base[0]
          : this.definition.toArray(new Base[this.definition.size()]); // MarkdownType
    case -1314002088:
      /* guidance */ return this.guidance == null ? new Base[0] : new Base[] { this.guidance }; // MarkdownType
    case 98629247:
      /* group */ return this.group == null ? new Base[0] : this.group.toArray(new Base[this.group.size()]); // MeasureGroupComponent
    case 1447496814:
      /* supplementalData */ return this.supplementalData == null ? new Base[0]
          : this.supplementalData.toArray(new Base[this.supplementalData.size()]); // MeasureSupplementalDataComponent
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case 116079: // url
      this.url = TypeConvertor.castToUri(value); // UriType
      return value;
    case -1618432855: // identifier
      this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
      return value;
    case 351608024: // version
      this.version = TypeConvertor.castToString(value); // StringType
      return value;
    case 3373707: // name
      this.name = TypeConvertor.castToString(value); // StringType
      return value;
    case 110371416: // title
      this.title = TypeConvertor.castToString(value); // StringType
      return value;
    case -2060497896: // subtitle
      this.subtitle = TypeConvertor.castToString(value); // StringType
      return value;
    case -892481550: // status
      value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
      return value;
    case -404562712: // experimental
      this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
      return value;
    case -1867885268: // subject
      this.subject = TypeConvertor.castToType(value); // DataType
      return value;
    case 3076014: // date
      this.date = TypeConvertor.castToDateTime(value); // DateTimeType
      return value;
    case 1447404028: // publisher
      this.publisher = TypeConvertor.castToString(value); // StringType
      return value;
    case 951526432: // contact
      this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case -1724546052: // description
      this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case -669707736: // useContext
      this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
      return value;
    case -507075711: // jurisdiction
      this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -220463842: // purpose
      this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case 111574433: // usage
      this.usage = TypeConvertor.castToString(value); // StringType
      return value;
    case 1522889671: // copyright
      this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case 223539345: // approvalDate
      this.approvalDate = TypeConvertor.castToDate(value); // DateType
      return value;
    case -1687512484: // lastReviewDate
      this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
      return value;
    case -403934648: // effectivePeriod
      this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
      return value;
    case 110546223: // topic
      this.getTopic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -1406328437: // author
      this.getAuthor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case -1307827859: // editor
      this.getEditor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case -261190139: // reviewer
      this.getReviewer().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case 1740277666: // endorser
      this.getEndorser().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case 666807069: // relatedArtifact
      this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
      return value;
    case 166208699: // library
      this.getLibrary().add(TypeConvertor.castToCanonical(value)); // CanonicalType
      return value;
    case 432371099: // disclaimer
      this.disclaimer = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case 1924005583: // scoring
      this.scoring = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      return value;
    case 569347656: // compositeScoring
      this.compositeScoring = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      return value;
    case 3575610: // type
      this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
      return value;
    case 93273500: // riskAdjustment
      this.riskAdjustment = TypeConvertor.castToString(value); // StringType
      return value;
    case 1254503906: // rateAggregation
      this.rateAggregation = TypeConvertor.castToString(value); // StringType
      return value;
    case 345689335: // rationale
      this.rationale = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case -18631389: // clinicalRecommendationStatement
      this.clinicalRecommendationStatement = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case -2085456136: // improvementNotation
      this.improvementNotation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      return value;
    case -1014418093: // definition
      this.getDefinition().add(TypeConvertor.castToMarkdown(value)); // MarkdownType
      return value;
    case -1314002088: // guidance
      this.guidance = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case 98629247: // group
      this.getGroup().add((MeasureGroupComponent) value); // MeasureGroupComponent
      return value;
    case 1447496814: // supplementalData
      this.getSupplementalData().add((MeasureSupplementalDataComponent) value); // MeasureSupplementalDataComponent
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("url")) {
      this.url = TypeConvertor.castToUri(value); // UriType
    } else if (name.equals("identifier")) {
      this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
    } else if (name.equals("version")) {
      this.version = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("name")) {
      this.name = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("title")) {
      this.title = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("subtitle")) {
      this.subtitle = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("status")) {
      value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
    } else if (name.equals("experimental")) {
      this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
    } else if (name.equals("subject[x]")) {
      this.subject = TypeConvertor.castToType(value); // DataType
    } else if (name.equals("date")) {
      this.date = TypeConvertor.castToDateTime(value); // DateTimeType
    } else if (name.equals("publisher")) {
      this.publisher = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("contact")) {
      this.getContact().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("description")) {
      this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("useContext")) {
      this.getUseContext().add(TypeConvertor.castToUsageContext(value));
    } else if (name.equals("jurisdiction")) {
      this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
    } else if (name.equals("purpose")) {
      this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("usage")) {
      this.usage = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("copyright")) {
      this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("approvalDate")) {
      this.approvalDate = TypeConvertor.castToDate(value); // DateType
    } else if (name.equals("lastReviewDate")) {
      this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
    } else if (name.equals("effectivePeriod")) {
      this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
    } else if (name.equals("topic")) {
      this.getTopic().add(TypeConvertor.castToCodeableConcept(value));
    } else if (name.equals("author")) {
      this.getAuthor().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("editor")) {
      this.getEditor().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("reviewer")) {
      this.getReviewer().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("endorser")) {
      this.getEndorser().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("relatedArtifact")) {
      this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
    } else if (name.equals("library")) {
      this.getLibrary().add(TypeConvertor.castToCanonical(value));
    } else if (name.equals("disclaimer")) {
      this.disclaimer = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("scoring")) {
      this.scoring = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("compositeScoring")) {
      this.compositeScoring = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("type")) {
      this.getType().add(TypeConvertor.castToCodeableConcept(value));
    } else if (name.equals("riskAdjustment")) {
      this.riskAdjustment = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("rateAggregation")) {
      this.rateAggregation = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("rationale")) {
      this.rationale = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("clinicalRecommendationStatement")) {
      this.clinicalRecommendationStatement = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("improvementNotation")) {
      this.improvementNotation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("definition")) {
      this.getDefinition().add(TypeConvertor.castToMarkdown(value));
    } else if (name.equals("guidance")) {
      this.guidance = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("group")) {
      this.getGroup().add((MeasureGroupComponent) value);
    } else if (name.equals("supplementalData")) {
      this.getSupplementalData().add((MeasureSupplementalDataComponent) value);
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    if (name.equals("url")) {
      this.url = null;
    } else if (name.equals("identifier")) {
      this.getIdentifier().remove(value);
    } else if (name.equals("version")) {
      this.version = null;
    } else if (name.equals("name")) {
      this.name = null;
    } else if (name.equals("title")) {
      this.title = null;
    } else if (name.equals("subtitle")) {
      this.subtitle = null;
    } else if (name.equals("status")) {
      this.status = null;
    } else if (name.equals("experimental")) {
      this.experimental = null;
    } else if (name.equals("subject[x]")) {
      this.subject = null;
    } else if (name.equals("date")) {
      this.date = null;
    } else if (name.equals("publisher")) {
      this.publisher = null;
    } else if (name.equals("contact")) {
      this.getContact().remove(value);
    } else if (name.equals("description")) {
      this.description = null;
    } else if (name.equals("useContext")) {
      this.getUseContext().remove(value);
    } else if (name.equals("jurisdiction")) {
      this.getJurisdiction().remove(value);
    } else if (name.equals("purpose")) {
      this.purpose = null;
    } else if (name.equals("usage")) {
      this.usage = null;
    } else if (name.equals("copyright")) {
      this.copyright = null;
    } else if (name.equals("approvalDate")) {
      this.approvalDate = null;
    } else if (name.equals("lastReviewDate")) {
      this.lastReviewDate = null;
    } else if (name.equals("effectivePeriod")) {
      this.effectivePeriod = null;
    } else if (name.equals("topic")) {
      this.getTopic().remove(value);
    } else if (name.equals("author")) {
      this.getAuthor().remove(value);
    } else if (name.equals("editor")) {
      this.getEditor().remove(value);
    } else if (name.equals("reviewer")) {
      this.getReviewer().remove(value);
    } else if (name.equals("endorser")) {
      this.getEndorser().remove(value);
    } else if (name.equals("relatedArtifact")) {
      this.getRelatedArtifact().remove(value);
    } else if (name.equals("library")) {
      this.getLibrary().remove(value);
    } else if (name.equals("disclaimer")) {
      this.disclaimer = null;
    } else if (name.equals("scoring")) {
      this.scoring = null;
    } else if (name.equals("compositeScoring")) {
      this.compositeScoring = null;
    } else if (name.equals("type")) {
      this.getType().remove(value);
    } else if (name.equals("riskAdjustment")) {
      this.riskAdjustment = null;
    } else if (name.equals("rateAggregation")) {
      this.rateAggregation = null;
    } else if (name.equals("rationale")) {
      this.rationale = null;
    } else if (name.equals("clinicalRecommendationStatement")) {
      this.clinicalRecommendationStatement = null;
    } else if (name.equals("improvementNotation")) {
      this.improvementNotation = null;
    } else if (name.equals("definition")) {
      this.getDefinition().remove(value);
    } else if (name.equals("guidance")) {
      this.guidance = null;
    } else if (name.equals("group")) {
      this.getGroup().remove((MeasureGroupComponent) value);
    } else if (name.equals("supplementalData")) {
      this.getSupplementalData().remove((MeasureSupplementalDataComponent) value);
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 116079:
      return getUrlElement();
    case -1618432855:
      return addIdentifier();
    case 351608024:
      return getVersionElement();
    case 3373707:
      return getNameElement();
    case 110371416:
      return getTitleElement();
    case -2060497896:
      return getSubtitleElement();
    case -892481550:
      return getStatusElement();
    case -404562712:
      return getExperimentalElement();
    case -573640748:
      return getSubject();
    case -1867885268:
      return getSubject();
    case 3076014:
      return getDateElement();
    case 1447404028:
      return getPublisherElement();
    case 951526432:
      return addContact();
    case -1724546052:
      return getDescriptionElement();
    case -669707736:
      return addUseContext();
    case -507075711:
      return addJurisdiction();
    case -220463842:
      return getPurposeElement();
    case 111574433:
      return getUsageElement();
    case 1522889671:
      return getCopyrightElement();
    case 223539345:
      return getApprovalDateElement();
    case -1687512484:
      return getLastReviewDateElement();
    case -403934648:
      return getEffectivePeriod();
    case 110546223:
      return addTopic();
    case -1406328437:
      return addAuthor();
    case -1307827859:
      return addEditor();
    case -261190139:
      return addReviewer();
    case 1740277666:
      return addEndorser();
    case 666807069:
      return addRelatedArtifact();
    case 166208699:
      return addLibraryElement();
    case 432371099:
      return getDisclaimerElement();
    case 1924005583:
      return getScoring();
    case 569347656:
      return getCompositeScoring();
    case 3575610:
      return addType();
    case 93273500:
      return getRiskAdjustmentElement();
    case 1254503906:
      return getRateAggregationElement();
    case 345689335:
      return getRationaleElement();
    case -18631389:
      return getClinicalRecommendationStatementElement();
    case -2085456136:
      return getImprovementNotation();
    case -1014418093:
      return addDefinitionElement();
    case -1314002088:
      return getGuidanceElement();
    case 98629247:
      return addGroup();
    case 1447496814:
      return addSupplementalData();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 116079:
      /* url */ return new String[] { "uri" };
    case -1618432855:
      /* identifier */ return new String[] { "Identifier" };
    case 351608024:
      /* version */ return new String[] { "string" };
    case 3373707:
      /* name */ return new String[] { "string" };
    case 110371416:
      /* title */ return new String[] { "string" };
    case -2060497896:
      /* subtitle */ return new String[] { "string" };
    case -892481550:
      /* status */ return new String[] { "code" };
    case -404562712:
      /* experimental */ return new String[] { "boolean" };
    case -1867885268:
      /* subject */ return new String[] { "CodeableConcept", "Reference" };
    case 3076014:
      /* date */ return new String[] { "dateTime" };
    case 1447404028:
      /* publisher */ return new String[] { "string" };
    case 951526432:
      /* contact */ return new String[] { "ContactDetail" };
    case -1724546052:
      /* description */ return new String[] { "markdown" };
    case -669707736:
      /* useContext */ return new String[] { "UsageContext" };
    case -507075711:
      /* jurisdiction */ return new String[] { "CodeableConcept" };
    case -220463842:
      /* purpose */ return new String[] { "markdown" };
    case 111574433:
      /* usage */ return new String[] { "string" };
    case 1522889671:
      /* copyright */ return new String[] { "markdown" };
    case 223539345:
      /* approvalDate */ return new String[] { "date" };
    case -1687512484:
      /* lastReviewDate */ return new String[] { "date" };
    case -403934648:
      /* effectivePeriod */ return new String[] { "Period" };
    case 110546223:
      /* topic */ return new String[] { "CodeableConcept" };
    case -1406328437:
      /* author */ return new String[] { "ContactDetail" };
    case -1307827859:
      /* editor */ return new String[] { "ContactDetail" };
    case -261190139:
      /* reviewer */ return new String[] { "ContactDetail" };
    case 1740277666:
      /* endorser */ return new String[] { "ContactDetail" };
    case 666807069:
      /* relatedArtifact */ return new String[] { "RelatedArtifact" };
    case 166208699:
      /* library */ return new String[] { "canonical" };
    case 432371099:
      /* disclaimer */ return new String[] { "markdown" };
    case 1924005583:
      /* scoring */ return new String[] { "CodeableConcept" };
    case 569347656:
      /* compositeScoring */ return new String[] { "CodeableConcept" };
    case 3575610:
      /* type */ return new String[] { "CodeableConcept" };
    case 93273500:
      /* riskAdjustment */ return new String[] { "string" };
    case 1254503906:
      /* rateAggregation */ return new String[] { "string" };
    case 345689335:
      /* rationale */ return new String[] { "markdown" };
    case -18631389:
      /* clinicalRecommendationStatement */ return new String[] { "markdown" };
    case -2085456136:
      /* improvementNotation */ return new String[] { "CodeableConcept" };
    case -1014418093:
      /* definition */ return new String[] { "markdown" };
    case -1314002088:
      /* guidance */ return new String[] { "markdown" };
    case 98629247:
      /* group */ return new String[] {};
    case 1447496814:
      /* supplementalData */ return new String[] {};
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("url")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.url");
    } else if (name.equals("identifier")) {
      return addIdentifier();
    } else if (name.equals("version")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.version");
    } else if (name.equals("name")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.name");
    } else if (name.equals("title")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.title");
    } else if (name.equals("subtitle")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.subtitle");
    } else if (name.equals("status")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.status");
    } else if (name.equals("experimental")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.experimental");
    } else if (name.equals("subjectCodeableConcept")) {
      this.subject = new CodeableConcept();
      return this.subject;
    } else if (name.equals("subjectReference")) {
      this.subject = new Reference();
      return this.subject;
    } else if (name.equals("date")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.date");
    } else if (name.equals("publisher")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.publisher");
    } else if (name.equals("contact")) {
      return addContact();
    } else if (name.equals("description")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.description");
    } else if (name.equals("useContext")) {
      return addUseContext();
    } else if (name.equals("jurisdiction")) {
      return addJurisdiction();
    } else if (name.equals("purpose")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.purpose");
    } else if (name.equals("usage")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.usage");
    } else if (name.equals("copyright")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.copyright");
    } else if (name.equals("approvalDate")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.approvalDate");
    } else if (name.equals("lastReviewDate")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.lastReviewDate");
    } else if (name.equals("effectivePeriod")) {
      this.effectivePeriod = new Period();
      return this.effectivePeriod;
    } else if (name.equals("topic")) {
      return addTopic();
    } else if (name.equals("author")) {
      return addAuthor();
    } else if (name.equals("editor")) {
      return addEditor();
    } else if (name.equals("reviewer")) {
      return addReviewer();
    } else if (name.equals("endorser")) {
      return addEndorser();
    } else if (name.equals("relatedArtifact")) {
      return addRelatedArtifact();
    } else if (name.equals("library")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.library");
    } else if (name.equals("disclaimer")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.disclaimer");
    } else if (name.equals("scoring")) {
      this.scoring = new CodeableConcept();
      return this.scoring;
    } else if (name.equals("compositeScoring")) {
      this.compositeScoring = new CodeableConcept();
      return this.compositeScoring;
    } else if (name.equals("type")) {
      return addType();
    } else if (name.equals("riskAdjustment")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.riskAdjustment");
    } else if (name.equals("rateAggregation")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.rateAggregation");
    } else if (name.equals("rationale")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.rationale");
    } else if (name.equals("clinicalRecommendationStatement")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.clinicalRecommendationStatement");
    } else if (name.equals("improvementNotation")) {
      this.improvementNotation = new CodeableConcept();
      return this.improvementNotation;
    } else if (name.equals("definition")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.definition");
    } else if (name.equals("guidance")) {
      throw new FHIRException("Cannot call addChild on a singleton property Measure.guidance");
    } else if (name.equals("group")) {
      return addGroup();
    } else if (name.equals("supplementalData")) {
      return addSupplementalData();
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "Measure";

  }

  public Measure copy() {
    Measure dst = new Measure();
    copyValues(dst);
    return dst;
  }

  public void copyValues(Measure dst) {
    super.copyValues(dst);
    dst.url = url == null ? null : url.copy();
    if (identifier != null) {
      dst.identifier = new ArrayList<Identifier>();
      for (Identifier i : identifier)
        dst.identifier.add(i.copy());
    }
    ;
    dst.version = version == null ? null : version.copy();
    dst.name = name == null ? null : name.copy();
    dst.title = title == null ? null : title.copy();
    dst.subtitle = subtitle == null ? null : subtitle.copy();
    dst.status = status == null ? null : status.copy();
    dst.experimental = experimental == null ? null : experimental.copy();
    dst.subject = subject == null ? null : subject.copy();
    dst.date = date == null ? null : date.copy();
    dst.publisher = publisher == null ? null : publisher.copy();
    if (contact != null) {
      dst.contact = new ArrayList<ContactDetail>();
      for (ContactDetail i : contact)
        dst.contact.add(i.copy());
    }
    ;
    dst.description = description == null ? null : description.copy();
    if (useContext != null) {
      dst.useContext = new ArrayList<UsageContext>();
      for (UsageContext i : useContext)
        dst.useContext.add(i.copy());
    }
    ;
    if (jurisdiction != null) {
      dst.jurisdiction = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : jurisdiction)
        dst.jurisdiction.add(i.copy());
    }
    ;
    dst.purpose = purpose == null ? null : purpose.copy();
    dst.usage = usage == null ? null : usage.copy();
    dst.copyright = copyright == null ? null : copyright.copy();
    dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
    dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
    dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
    if (topic != null) {
      dst.topic = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : topic)
        dst.topic.add(i.copy());
    }
    ;
    if (author != null) {
      dst.author = new ArrayList<ContactDetail>();
      for (ContactDetail i : author)
        dst.author.add(i.copy());
    }
    ;
    if (editor != null) {
      dst.editor = new ArrayList<ContactDetail>();
      for (ContactDetail i : editor)
        dst.editor.add(i.copy());
    }
    ;
    if (reviewer != null) {
      dst.reviewer = new ArrayList<ContactDetail>();
      for (ContactDetail i : reviewer)
        dst.reviewer.add(i.copy());
    }
    ;
    if (endorser != null) {
      dst.endorser = new ArrayList<ContactDetail>();
      for (ContactDetail i : endorser)
        dst.endorser.add(i.copy());
    }
    ;
    if (relatedArtifact != null) {
      dst.relatedArtifact = new ArrayList<RelatedArtifact>();
      for (RelatedArtifact i : relatedArtifact)
        dst.relatedArtifact.add(i.copy());
    }
    ;
    if (library != null) {
      dst.library = new ArrayList<CanonicalType>();
      for (CanonicalType i : library)
        dst.library.add(i.copy());
    }
    ;
    dst.disclaimer = disclaimer == null ? null : disclaimer.copy();
    dst.scoring = scoring == null ? null : scoring.copy();
    dst.compositeScoring = compositeScoring == null ? null : compositeScoring.copy();
    if (type != null) {
      dst.type = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : type)
        dst.type.add(i.copy());
    }
    ;
    dst.riskAdjustment = riskAdjustment == null ? null : riskAdjustment.copy();
    dst.rateAggregation = rateAggregation == null ? null : rateAggregation.copy();
    dst.rationale = rationale == null ? null : rationale.copy();
    dst.clinicalRecommendationStatement = clinicalRecommendationStatement == null ? null
        : clinicalRecommendationStatement.copy();
    dst.improvementNotation = improvementNotation == null ? null : improvementNotation.copy();
    if (definition != null) {
      dst.definition = new ArrayList<MarkdownType>();
      for (MarkdownType i : definition)
        dst.definition.add(i.copy());
    }
    ;
    dst.guidance = guidance == null ? null : guidance.copy();
    if (group != null) {
      dst.group = new ArrayList<MeasureGroupComponent>();
      for (MeasureGroupComponent i : group)
        dst.group.add(i.copy());
    }
    ;
    if (supplementalData != null) {
      dst.supplementalData = new ArrayList<MeasureSupplementalDataComponent>();
      for (MeasureSupplementalDataComponent i : supplementalData)
        dst.supplementalData.add(i.copy());
    }
    ;
  }

  protected Measure typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof Measure))
      return false;
    Measure o = (Measure) other_;
    return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true)
        && compareDeep(version, o.version, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
        && compareDeep(subtitle, o.subtitle, true) && compareDeep(status, o.status, true)
        && compareDeep(experimental, o.experimental, true) && compareDeep(subject, o.subject, true)
        && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
        && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
        && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
        && compareDeep(purpose, o.purpose, true) && compareDeep(usage, o.usage, true)
        && compareDeep(copyright, o.copyright, true) && compareDeep(approvalDate, o.approvalDate, true)
        && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(effectivePeriod, o.effectivePeriod, true)
        && compareDeep(topic, o.topic, true) && compareDeep(author, o.author, true)
        && compareDeep(editor, o.editor, true) && compareDeep(reviewer, o.reviewer, true)
        && compareDeep(endorser, o.endorser, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
        && compareDeep(library, o.library, true) && compareDeep(disclaimer, o.disclaimer, true)
        && compareDeep(scoring, o.scoring, true) && compareDeep(compositeScoring, o.compositeScoring, true)
        && compareDeep(type, o.type, true) && compareDeep(riskAdjustment, o.riskAdjustment, true)
        && compareDeep(rateAggregation, o.rateAggregation, true) && compareDeep(rationale, o.rationale, true)
        && compareDeep(clinicalRecommendationStatement, o.clinicalRecommendationStatement, true)
        && compareDeep(improvementNotation, o.improvementNotation, true) && compareDeep(definition, o.definition, true)
        && compareDeep(guidance, o.guidance, true) && compareDeep(group, o.group, true)
        && compareDeep(supplementalData, o.supplementalData, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof Measure))
      return false;
    Measure o = (Measure) other_;
    return compareValues(url, o.url, true) && compareValues(version, o.version, true)
        && compareValues(name, o.name, true) && compareValues(title, o.title, true)
        && compareValues(subtitle, o.subtitle, true) && compareValues(status, o.status, true)
        && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true)
        && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
        && compareValues(purpose, o.purpose, true) && compareValues(usage, o.usage, true)
        && compareValues(copyright, o.copyright, true) && compareValues(approvalDate, o.approvalDate, true)
        && compareValues(lastReviewDate, o.lastReviewDate, true) && compareValues(library, o.library, true)
        && compareValues(disclaimer, o.disclaimer, true) && compareValues(riskAdjustment, o.riskAdjustment, true)
        && compareValues(rateAggregation, o.rateAggregation, true) && compareValues(rationale, o.rationale, true)
        && compareValues(clinicalRecommendationStatement, o.clinicalRecommendationStatement, true)
        && compareValues(definition, o.definition, true) && compareValues(guidance, o.guidance, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version, name, title, subtitle,
        status, experimental, subject, date, publisher, contact, description, useContext, jurisdiction, purpose, usage,
        copyright, approvalDate, lastReviewDate, effectivePeriod, topic, author, editor, reviewer, endorser,
        relatedArtifact, library, disclaimer, scoring, compositeScoring, type, riskAdjustment, rateAggregation,
        rationale, clinicalRecommendationStatement, improvementNotation, definition, guidance, group, supplementalData);
  }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Measure;
  }

  /**
   * Search parameter: <b>composed-of</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "composed-of", path = "Measure.relatedArtifact.where(type='composed-of').resource", description = "What resource is being referenced", type = "reference", target = {
      Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class,
      AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class,
      Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class,
      CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class,
      Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class,
      Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class,
      Condition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class,
      CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class,
      DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class,
      DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class,
      EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class,
      ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class,
      GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class,
      Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class,
      Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class,
      Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Media.class,
      Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class,
      MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class,
      MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionOrder.class, NutritionProduct.class,
      Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class,
      Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class,
      PaymentNotice.class, PaymentReconciliation.class, Person.class, PlanDefinition.class, Practitioner.class,
      PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class,
      RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchDefinition.class,
      ResearchElementDefinition.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class,
      SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class,
      StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class,
      SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SupplyDelivery.class, SupplyRequest.class,
      Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class,
      VerificationResult.class, VisionPrescription.class })
  public static final String SP_COMPOSED_OF = "composed-of";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>composed-of</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam COMPOSED_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_COMPOSED_OF);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Measure:composed-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_COMPOSED_OF = new ca.uhn.fhir.model.api.Include(
      "Measure:composed-of").toLocked();

  /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * measure</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Measure.useContext.value as Quantity) | (Measure.useContext.value
   * as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-quantity", path = "(Measure.useContext.value as Quantity) | (Measure.useContext.value as Range)", description = "A quantity- or range-valued use context assigned to the measure", type = "quantity")
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * measure</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Measure.useContext.value as Quantity) | (Measure.useContext.value
   * as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(
      SP_CONTEXT_QUANTITY);

  /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the measure</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Measure.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-quantity", path = "Measure.useContext", description = "A use context type and quantity- or range-based value assigned to the measure", type = "composite", compositeOf = {
      "context-type", "context-quantity" })
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for
   * <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the measure</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Measure.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(
      SP_CONTEXT_TYPE_QUANTITY);

  /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the measure</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Measure.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-value", path = "Measure.useContext", description = "A use context type and value assigned to the measure", type = "composite", compositeOf = {
      "context-type", "context" })
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the measure</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Measure.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(
      SP_CONTEXT_TYPE_VALUE);

  /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type", path = "Measure.useContext.code", description = "A type of use context assigned to the measure", type = "token")
  public static final String SP_CONTEXT_TYPE = "context-type";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT_TYPE);

  /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Measure.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context", path = "(Measure.useContext.value as CodeableConcept)", description = "A use context assigned to the measure", type = "token")
  public static final String SP_CONTEXT = "context";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Measure.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT);

  /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The measure publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Measure.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "date", path = "Measure.date", description = "The measure publication date", type = "date")
  public static final String SP_DATE = "date";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The measure publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Measure.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_DATE);

  /**
   * Search parameter: <b>depends-on</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='depends-on').resource |
   * Measure.library</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "depends-on", path = "Measure.relatedArtifact.where(type='depends-on').resource | Measure.library", description = "What resource is being referenced", type = "reference", target = {
      Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class,
      AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class,
      Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class,
      CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class,
      Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class,
      Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class,
      Condition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class,
      CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class,
      DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class,
      DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class,
      EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class,
      ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class,
      GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class,
      Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class,
      Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class,
      Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Media.class,
      Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class,
      MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class,
      MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionOrder.class, NutritionProduct.class,
      Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class,
      Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class,
      PaymentNotice.class, PaymentReconciliation.class, Person.class, PlanDefinition.class, Practitioner.class,
      PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class,
      RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchDefinition.class,
      ResearchElementDefinition.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class,
      SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class,
      StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class,
      SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SupplyDelivery.class, SupplyRequest.class,
      Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class,
      VerificationResult.class, VisionPrescription.class })
  public static final String SP_DEPENDS_ON = "depends-on";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>depends-on</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='depends-on').resource |
   * Measure.library</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEPENDS_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_DEPENDS_ON);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Measure:depends-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEPENDS_ON = new ca.uhn.fhir.model.api.Include(
      "Measure:depends-on").toLocked();

  /**
   * Search parameter: <b>derived-from</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "derived-from", path = "Measure.relatedArtifact.where(type='derived-from').resource", description = "What resource is being referenced", type = "reference", target = {
      Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class,
      AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class,
      Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class,
      CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class,
      Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class,
      Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class,
      Condition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class,
      CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class,
      DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class,
      DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class,
      EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class,
      ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class,
      GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class,
      Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class,
      Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class,
      Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Media.class,
      Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class,
      MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class,
      MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionOrder.class, NutritionProduct.class,
      Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class,
      Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class,
      PaymentNotice.class, PaymentReconciliation.class, Person.class, PlanDefinition.class, Practitioner.class,
      PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class,
      RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchDefinition.class,
      ResearchElementDefinition.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class,
      SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class,
      StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class,
      SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SupplyDelivery.class, SupplyRequest.class,
      Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class,
      VerificationResult.class, VisionPrescription.class })
  public static final String SP_DERIVED_FROM = "derived-from";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>derived-from</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DERIVED_FROM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_DERIVED_FROM);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Measure:derived-from</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DERIVED_FROM = new ca.uhn.fhir.model.api.Include(
      "Measure:derived-from").toLocked();

  /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "description", path = "Measure.description", description = "The description of the measure", type = "string")
  public static final String SP_DESCRIPTION = "description";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_DESCRIPTION);

  /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>The time during which the measure is intended to be in
   * use</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Measure.effectivePeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "effective", path = "Measure.effectivePeriod", description = "The time during which the measure is intended to be in use", type = "date")
  public static final String SP_EFFECTIVE = "effective";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>The time during which the measure is intended to be in
   * use</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Measure.effectivePeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_EFFECTIVE);

  /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "identifier", path = "Measure.identifier", description = "External identifier for the measure", type = "token")
  public static final String SP_IDENTIFIER = "identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_IDENTIFIER);

  /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "jurisdiction", path = "Measure.jurisdiction", description = "Intended jurisdiction for the measure", type = "token")
  public static final String SP_JURISDICTION = "jurisdiction";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_JURISDICTION);

  /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "name", path = "Measure.name", description = "Computationally friendly name of the measure", type = "string")
  public static final String SP_NAME = "name";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_NAME);

  /**
   * Search parameter: <b>predecessor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "predecessor", path = "Measure.relatedArtifact.where(type='predecessor').resource", description = "What resource is being referenced", type = "reference", target = {
      Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class,
      AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class,
      Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class,
      CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class,
      Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class,
      Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class,
      Condition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class,
      CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class,
      DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class,
      DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class,
      EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class,
      ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class,
      GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class,
      Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class,
      Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class,
      Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Media.class,
      Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class,
      MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class,
      MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionOrder.class, NutritionProduct.class,
      Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class,
      Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class,
      PaymentNotice.class, PaymentReconciliation.class, Person.class, PlanDefinition.class, Practitioner.class,
      PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class,
      RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchDefinition.class,
      ResearchElementDefinition.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class,
      SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class,
      StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class,
      SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SupplyDelivery.class, SupplyRequest.class,
      Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class,
      VerificationResult.class, VisionPrescription.class })
  public static final String SP_PREDECESSOR = "predecessor";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>predecessor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PREDECESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_PREDECESSOR);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Measure:predecessor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PREDECESSOR = new ca.uhn.fhir.model.api.Include(
      "Measure:predecessor").toLocked();

  /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "publisher", path = "Measure.publisher", description = "Name of the publisher of the measure", type = "string")
  public static final String SP_PUBLISHER = "publisher";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_PUBLISHER);

  /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "status", path = "Measure.status", description = "The current status of the measure", type = "token")
  public static final String SP_STATUS = "status";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_STATUS);

  /**
   * Search parameter: <b>successor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "successor", path = "Measure.relatedArtifact.where(type='successor').resource", description = "What resource is being referenced", type = "reference", target = {
      Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class,
      AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class,
      Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class,
      CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class,
      Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class,
      Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class,
      Condition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class,
      CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class,
      DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class,
      DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class,
      EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class,
      ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class,
      GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class,
      Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class,
      Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class,
      Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Media.class,
      Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class,
      MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class,
      MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionOrder.class, NutritionProduct.class,
      Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class,
      Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class,
      PaymentNotice.class, PaymentReconciliation.class, Person.class, PlanDefinition.class, Practitioner.class,
      PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class,
      RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchDefinition.class,
      ResearchElementDefinition.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class,
      SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class,
      StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class,
      SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SupplyDelivery.class, SupplyRequest.class,
      Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class,
      VerificationResult.class, VisionPrescription.class })
  public static final String SP_SUCCESSOR = "successor";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>successor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Measure.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUCCESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_SUCCESSOR);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Measure:successor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUCCESSOR = new ca.uhn.fhir.model.api.Include(
      "Measure:successor").toLocked();

  /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "title", path = "Measure.title", description = "The human-friendly name of the measure", type = "string")
  public static final String SP_TITLE = "title";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the measure</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Measure.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_TITLE);

  /**
   * Search parameter: <b>topic</b>
   * <p>
   * Description: <b>Topics associated with the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.topic</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "topic", path = "Measure.topic", description = "Topics associated with the measure", type = "token")
  public static final String SP_TOPIC = "topic";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>topic</b>
   * <p>
   * Description: <b>Topics associated with the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.topic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TOPIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_TOPIC);

  /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the measure</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Measure.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "url", path = "Measure.url", description = "The uri that identifies the measure", type = "uri")
  public static final String SP_URL = "url";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the measure</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Measure.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

  /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "version", path = "Measure.version", description = "The business version of the measure", type = "token")
  public static final String SP_VERSION = "version";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the measure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Measure.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_VERSION);

}
