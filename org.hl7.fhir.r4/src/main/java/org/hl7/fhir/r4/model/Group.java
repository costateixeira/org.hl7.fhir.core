package org.hl7.fhir.r4.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Tue, May 12, 2020 07:26+1000 for FHIR v4.0.1
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;

/**
 * Represents a defined collection of entities that may be discussed or acted
 * upon collectively but which are not expected to act collectively, and are not
 * formally or legally recognized; i.e. a collection of entities that isn't an
 * Organization.
 */
@ResourceDef(name = "Group", profile = "http://hl7.org/fhir/StructureDefinition/Group")
public class Group extends DomainResource {

  public enum GroupType {
    /**
     * Group contains "person" Patient resources.
     */
    PERSON,
    /**
     * Group contains "animal" Patient resources.
     */
    ANIMAL,
    /**
     * Group contains healthcare practitioner resources (Practitioner or
     * PractitionerRole).
     */
    PRACTITIONER,
    /**
     * Group contains Device resources.
     */
    DEVICE,
    /**
     * Group contains Medication resources.
     */
    MEDICATION,
    /**
     * Group contains Substance resources.
     */
    SUBSTANCE,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static GroupType fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("person".equals(codeString))
        return PERSON;
      if ("animal".equals(codeString))
        return ANIMAL;
      if ("practitioner".equals(codeString))
        return PRACTITIONER;
      if ("device".equals(codeString))
        return DEVICE;
      if ("medication".equals(codeString))
        return MEDICATION;
      if ("substance".equals(codeString))
        return SUBSTANCE;
      if (Configuration.isAcceptInvalidEnums())
        return null;
      else
        throw new FHIRException("Unknown GroupType code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case PERSON:
        return "person";
      case ANIMAL:
        return "animal";
      case PRACTITIONER:
        return "practitioner";
      case DEVICE:
        return "device";
      case MEDICATION:
        return "medication";
      case SUBSTANCE:
        return "substance";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case PERSON:
        return "http://hl7.org/fhir/group-type";
      case ANIMAL:
        return "http://hl7.org/fhir/group-type";
      case PRACTITIONER:
        return "http://hl7.org/fhir/group-type";
      case DEVICE:
        return "http://hl7.org/fhir/group-type";
      case MEDICATION:
        return "http://hl7.org/fhir/group-type";
      case SUBSTANCE:
        return "http://hl7.org/fhir/group-type";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case PERSON:
        return "Group contains \"person\" Patient resources.";
      case ANIMAL:
        return "Group contains \"animal\" Patient resources.";
      case PRACTITIONER:
        return "Group contains healthcare practitioner resources (Practitioner or PractitionerRole).";
      case DEVICE:
        return "Group contains Device resources.";
      case MEDICATION:
        return "Group contains Medication resources.";
      case SUBSTANCE:
        return "Group contains Substance resources.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case PERSON:
        return "Person";
      case ANIMAL:
        return "Animal";
      case PRACTITIONER:
        return "Practitioner";
      case DEVICE:
        return "Device";
      case MEDICATION:
        return "Medication";
      case SUBSTANCE:
        return "Substance";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class GroupTypeEnumFactory implements EnumFactory<GroupType> {
    public GroupType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("person".equals(codeString))
        return GroupType.PERSON;
      if ("animal".equals(codeString))
        return GroupType.ANIMAL;
      if ("practitioner".equals(codeString))
        return GroupType.PRACTITIONER;
      if ("device".equals(codeString))
        return GroupType.DEVICE;
      if ("medication".equals(codeString))
        return GroupType.MEDICATION;
      if ("substance".equals(codeString))
        return GroupType.SUBSTANCE;
      throw new IllegalArgumentException("Unknown GroupType code '" + codeString + "'");
    }

    public Enumeration<GroupType> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<GroupType>(this, GroupType.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<GroupType>(this, GroupType.NULL, code);
      if ("person".equals(codeString))
        return new Enumeration<GroupType>(this, GroupType.PERSON, code);
      if ("animal".equals(codeString))
        return new Enumeration<GroupType>(this, GroupType.ANIMAL, code);
      if ("practitioner".equals(codeString))
        return new Enumeration<GroupType>(this, GroupType.PRACTITIONER, code);
      if ("device".equals(codeString))
        return new Enumeration<GroupType>(this, GroupType.DEVICE, code);
      if ("medication".equals(codeString))
        return new Enumeration<GroupType>(this, GroupType.MEDICATION, code);
      if ("substance".equals(codeString))
        return new Enumeration<GroupType>(this, GroupType.SUBSTANCE, code);
      throw new FHIRException("Unknown GroupType code '" + codeString + "'");
    }

    public String toCode(GroupType code) {
       if (code == GroupType.NULL)
           return null;
       if (code == GroupType.PERSON)
        return "person";
      if (code == GroupType.ANIMAL)
        return "animal";
      if (code == GroupType.PRACTITIONER)
        return "practitioner";
      if (code == GroupType.DEVICE)
        return "device";
      if (code == GroupType.MEDICATION)
        return "medication";
      if (code == GroupType.SUBSTANCE)
        return "substance";
      return "?";
   }

    public String toSystem(GroupType code) {
      return code.getSystem();
    }
  }

  @Block()
  public static class GroupCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * A code that identifies the kind of trait being asserted.
     */
    @Child(name = "code", type = {
        CodeableConcept.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Kind of characteristic", formalDefinition = "A code that identifies the kind of trait being asserted.")
    protected CodeableConcept code;

    /**
     * The value of the trait that holds (or does not hold - see 'exclude') for
     * members of the group.
     */
    @Child(name = "value", type = { CodeableConcept.class, BooleanType.class, Quantity.class, Range.class,
        Reference.class }, order = 2, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Value held by characteristic", formalDefinition = "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.")
    protected Type value;

    /**
     * If true, indicates the characteristic is one that is NOT held by members of
     * the group.
     */
    @Child(name = "exclude", type = {
        BooleanType.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Group includes or excludes", formalDefinition = "If true, indicates the characteristic is one that is NOT held by members of the group.")
    protected BooleanType exclude;

    /**
     * The period over which the characteristic is tested; e.g. the patient had an
     * operation during the month of June.
     */
    @Child(name = "period", type = { Period.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Period over which characteristic is tested", formalDefinition = "The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.")
    protected Period period;

    private static final long serialVersionUID = -1000688967L;

    /**
     * Constructor
     */
    public GroupCharacteristicComponent() {
      super();
    }

    /**
     * Constructor
     */
    public GroupCharacteristicComponent(CodeableConcept code, Type value, BooleanType exclude) {
      super();
      this.code = code;
      this.value = value;
      this.exclude = exclude;
    }

    /**
     * @return {@link #code} (A code that identifies the kind of trait being
     *         asserted.)
     */
    public CodeableConcept getCode() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GroupCharacteristicComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code that identifies the kind of trait being
     *              asserted.)
     */
    public GroupCharacteristicComponent setCode(CodeableConcept value) {
      this.code = value;
      return this;
    }

    /**
     * @return {@link #value} (The value of the trait that holds (or does not hold -
     *         see 'exclude') for members of the group.)
     */
    public Type getValue() {
      return this.value;
    }

    /**
     * @return {@link #value} (The value of the trait that holds (or does not hold -
     *         see 'exclude') for members of the group.)
     */
    public CodeableConcept getValueCodeableConcept() throws FHIRException {
      if (this.value == null)
        this.value = new CodeableConcept();
      if (!(this.value instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "
            + this.value.getClass().getName() + " was encountered");
      return (CodeableConcept) this.value;
    }

    public boolean hasValueCodeableConcept() {
        return this.value instanceof CodeableConcept;
    }

    /**
     * @return {@link #value} (The value of the trait that holds (or does not hold -
     *         see 'exclude') for members of the group.)
     */
    public BooleanType getValueBooleanType() throws FHIRException {
      if (this.value == null)
        this.value = new BooleanType();
      if (!(this.value instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "
            + this.value.getClass().getName() + " was encountered");
      return (BooleanType) this.value;
    }

    public boolean hasValueBooleanType() {
        return this.value instanceof BooleanType;
    }

    /**
     * @return {@link #value} (The value of the trait that holds (or does not hold -
     *         see 'exclude') for members of the group.)
     */
    public Quantity getValueQuantity() throws FHIRException {
      if (this.value == null)
        this.value = new Quantity();
      if (!(this.value instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but " + this.value.getClass().getName()
            + " was encountered");
      return (Quantity) this.value;
    }

    public boolean hasValueQuantity() {
        return this.value instanceof Quantity;
    }

    /**
     * @return {@link #value} (The value of the trait that holds (or does not hold -
     *         see 'exclude') for members of the group.)
     */
    public Range getValueRange() throws FHIRException {
      if (this.value == null)
        this.value = new Range();
      if (!(this.value instanceof Range))
        throw new FHIRException(
            "Type mismatch: the type Range was expected, but " + this.value.getClass().getName() + " was encountered");
      return (Range) this.value;
    }

    public boolean hasValueRange() {
        return this.value instanceof Range;
    }

    /**
     * @return {@link #value} (The value of the trait that holds (or does not hold -
     *         see 'exclude') for members of the group.)
     */
    public Reference getValueReference() throws FHIRException {
      if (this.value == null)
        this.value = new Reference();
      if (!(this.value instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but " + this.value.getClass().getName()
            + " was encountered");
      return (Reference) this.value;
    }

    public boolean hasValueReference() {
        return this.value instanceof Reference;
    }

    public boolean hasValue() {
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (The value of the trait that holds (or does not
     *              hold - see 'exclude') for members of the group.)
     */
    public GroupCharacteristicComponent setValue(Type value) {
      if (value != null && !(value instanceof CodeableConcept || value instanceof BooleanType
          || value instanceof Quantity || value instanceof Range || value instanceof Reference))
        throw new Error("Not the right type for Group.characteristic.value[x]: " + value.fhirType());
      this.value = value;
      return this;
    }

    /**
     * @return {@link #exclude} (If true, indicates the characteristic is one that
     *         is NOT held by members of the group.). This is the underlying object
     *         with id, value and extensions. The accessor "getExclude" gives direct
     *         access to the value
     */
    public BooleanType getExcludeElement() {
      if (this.exclude == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GroupCharacteristicComponent.exclude");
        else if (Configuration.doAutoCreate())
          this.exclude = new BooleanType(); // bb
      return this.exclude;
    }

    public boolean hasExcludeElement() {
      return this.exclude != null && !this.exclude.isEmpty();
    }

    public boolean hasExclude() {
      return this.exclude != null && !this.exclude.isEmpty();
    }

    /**
     * @param value {@link #exclude} (If true, indicates the characteristic is one
     *              that is NOT held by members of the group.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getExclude" gives direct access to the value
     */
    public GroupCharacteristicComponent setExcludeElement(BooleanType value) {
      this.exclude = value;
      return this;
    }

    /**
     * @return If true, indicates the characteristic is one that is NOT held by
     *         members of the group.
     */
    public boolean getExclude() {
      return this.exclude == null || this.exclude.isEmpty() ? false : this.exclude.getValue();
    }

    /**
     * @param value If true, indicates the characteristic is one that is NOT held by
     *              members of the group.
     */
    public GroupCharacteristicComponent setExclude(boolean value) {
      if (this.exclude == null)
        this.exclude = new BooleanType();
      this.exclude.setValue(value);
      return this;
    }

    /**
     * @return {@link #period} (The period over which the characteristic is tested;
     *         e.g. the patient had an operation during the month of June.)
     */
    public Period getPeriod() {
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GroupCharacteristicComponent.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() {
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The period over which the characteristic is
     *              tested; e.g. the patient had an operation during the month of
     *              June.)
     */
    public GroupCharacteristicComponent setPeriod(Period value) {
      this.period = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "CodeableConcept", "A code that identifies the kind of trait being asserted.",
          0, 1, code));
      children.add(new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
          "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
          value));
      children.add(new Property("exclude", "boolean",
          "If true, indicates the characteristic is one that is NOT held by members of the group.", 0, 1, exclude));
      children.add(new Property("period", "Period",
          "The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.",
          0, 1, period));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "CodeableConcept",
            "A code that identifies the kind of trait being asserted.", 0, 1, code);
      case -1410166417:
        /* value[x] */ return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
            "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
            value);
      case 111972721:
        /* value */ return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
            "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
            value);
      case 924902896:
        /* valueCodeableConcept */ return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
            "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
            value);
      case 733421943:
        /* valueBoolean */ return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
            "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
            value);
      case -2029823716:
        /* valueQuantity */ return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
            "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
            value);
      case 2030761548:
        /* valueRange */ return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
            "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
            value);
      case 1755241690:
        /* valueReference */ return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference",
            "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1,
            value);
      case -1321148966:
        /* exclude */ return new Property("exclude", "boolean",
            "If true, indicates the characteristic is one that is NOT held by members of the group.", 0, 1, exclude);
      case -991726143:
        /* period */ return new Property("period", "Period",
            "The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.",
            0, 1, period);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
      case 111972721:
        /* value */ return this.value == null ? new Base[0] : new Base[] { this.value }; // Type
      case -1321148966:
        /* exclude */ return this.exclude == null ? new Base[0] : new Base[] { this.exclude }; // BooleanType
      case -991726143:
        /* period */ return this.period == null ? new Base[0] : new Base[] { this.period }; // Period
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = castToCodeableConcept(value); // CodeableConcept
        return value;
      case 111972721: // value
        this.value = castToType(value); // Type
        return value;
      case -1321148966: // exclude
        this.exclude = castToBoolean(value); // BooleanType
        return value;
      case -991726143: // period
        this.period = castToPeriod(value); // Period
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("value[x]")) {
        this.value = castToType(value); // Type
      } else if (name.equals("exclude")) {
        this.exclude = castToBoolean(value); // BooleanType
      } else if (name.equals("period")) {
        this.period = castToPeriod(value); // Period
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("value[x]")) {
        this.value = null;
      } else if (name.equals("exclude")) {
        this.exclude = null;
      } else if (name.equals("period")) {
        this.period = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCode();
      case -1410166417:
        return getValue();
      case 111972721:
        return getValue();
      case -1321148966:
        return getExcludeElement();
      case -991726143:
        return getPeriod();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "CodeableConcept" };
      case 111972721:
        /* value */ return new String[] { "CodeableConcept", "boolean", "Quantity", "Range", "Reference" };
      case -1321148966:
        /* exclude */ return new String[] { "boolean" };
      case -991726143:
        /* period */ return new String[] { "Period" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        this.code = new CodeableConcept();
        return this.code;
      } else if (name.equals("valueCodeableConcept")) {
        this.value = new CodeableConcept();
        return this.value;
      } else if (name.equals("valueBoolean")) {
        this.value = new BooleanType();
        return this.value;
      } else if (name.equals("valueQuantity")) {
        this.value = new Quantity();
        return this.value;
      } else if (name.equals("valueRange")) {
        this.value = new Range();
        return this.value;
      } else if (name.equals("valueReference")) {
        this.value = new Reference();
        return this.value;
      } else if (name.equals("exclude")) {
        throw new FHIRException("Cannot call addChild on a singleton property Group.exclude");
      } else if (name.equals("period")) {
        this.period = new Period();
        return this.period;
      } else
        return super.addChild(name);
    }

    public GroupCharacteristicComponent copy() {
      GroupCharacteristicComponent dst = new GroupCharacteristicComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(GroupCharacteristicComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.value = value == null ? null : value.copy();
      dst.exclude = exclude == null ? null : exclude.copy();
      dst.period = period == null ? null : period.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof GroupCharacteristicComponent))
        return false;
      GroupCharacteristicComponent o = (GroupCharacteristicComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(value, o.value, true)
          && compareDeep(exclude, o.exclude, true) && compareDeep(period, o.period, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof GroupCharacteristicComponent))
        return false;
      GroupCharacteristicComponent o = (GroupCharacteristicComponent) other_;
      return compareValues(exclude, o.exclude, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value, exclude, period);
    }

    public String fhirType() {
      return "Group.characteristic";

    }

  }

  @Block()
  public static class GroupMemberComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * A reference to the entity that is a member of the group. Must be consistent
     * with Group.type. If the entity is another group, then the type must be the
     * same.
     */
    @Child(name = "entity", type = { Patient.class, Practitioner.class, PractitionerRole.class, Device.class,
        Medication.class, Substance.class,
        Group.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Reference to the group member", formalDefinition = "A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.")
    protected Reference entity;

    /**
     * The actual object that is the target of the reference (A reference to the
     * entity that is a member of the group. Must be consistent with Group.type. If
     * the entity is another group, then the type must be the same.)
     */
    protected Resource entityTarget;

    /**
     * The period that the member was in the group, if known.
     */
    @Child(name = "period", type = { Period.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Period member belonged to the group", formalDefinition = "The period that the member was in the group, if known.")
    protected Period period;

    /**
     * A flag to indicate that the member is no longer in the group, but previously
     * may have been a member.
     */
    @Child(name = "inactive", type = {
        BooleanType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "If member is no longer in group", formalDefinition = "A flag to indicate that the member is no longer in the group, but previously may have been a member.")
    protected BooleanType inactive;

    private static final long serialVersionUID = -333869055L;

    /**
     * Constructor
     */
    public GroupMemberComponent() {
      super();
    }

    /**
     * Constructor
     */
    public GroupMemberComponent(Reference entity) {
      super();
      this.entity = entity;
    }

    /**
     * @return {@link #entity} (A reference to the entity that is a member of the
     *         group. Must be consistent with Group.type. If the entity is another
     *         group, then the type must be the same.)
     */
    public Reference getEntity() {
      if (this.entity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GroupMemberComponent.entity");
        else if (Configuration.doAutoCreate())
          this.entity = new Reference(); // cc
      return this.entity;
    }

    public boolean hasEntity() {
      return this.entity != null && !this.entity.isEmpty();
    }

    /**
     * @param value {@link #entity} (A reference to the entity that is a member of
     *              the group. Must be consistent with Group.type. If the entity is
     *              another group, then the type must be the same.)
     */
    public GroupMemberComponent setEntity(Reference value) {
      this.entity = value;
      return this;
    }

    /**
     * @return {@link #entity} The actual object that is the target of the
     *         reference. The reference library doesn't populate this, but you can
     *         use it to hold the resource if you resolve it. (A reference to the
     *         entity that is a member of the group. Must be consistent with
     *         Group.type. If the entity is another group, then the type must be the
     *         same.)
     */
    public Resource getEntityTarget() {
      return this.entityTarget;
    }

    /**
     * @param value {@link #entity} The actual object that is the target of the
     *              reference. The reference library doesn't use these, but you can
     *              use it to hold the resource if you resolve it. (A reference to
     *              the entity that is a member of the group. Must be consistent
     *              with Group.type. If the entity is another group, then the type
     *              must be the same.)
     */
    public GroupMemberComponent setEntityTarget(Resource value) {
      this.entityTarget = value;
      return this;
    }

    /**
     * @return {@link #period} (The period that the member was in the group, if
     *         known.)
     */
    public Period getPeriod() {
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GroupMemberComponent.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() {
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The period that the member was in the group, if
     *              known.)
     */
    public GroupMemberComponent setPeriod(Period value) {
      this.period = value;
      return this;
    }

    /**
     * @return {@link #inactive} (A flag to indicate that the member is no longer in
     *         the group, but previously may have been a member.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getInactive" gives direct access to the value
     */
    public BooleanType getInactiveElement() {
      if (this.inactive == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GroupMemberComponent.inactive");
        else if (Configuration.doAutoCreate())
          this.inactive = new BooleanType(); // bb
      return this.inactive;
    }

    public boolean hasInactiveElement() {
      return this.inactive != null && !this.inactive.isEmpty();
    }

    public boolean hasInactive() {
      return this.inactive != null && !this.inactive.isEmpty();
    }

    /**
     * @param value {@link #inactive} (A flag to indicate that the member is no
     *              longer in the group, but previously may have been a member.).
     *              This is the underlying object with id, value and extensions. The
     *              accessor "getInactive" gives direct access to the value
     */
    public GroupMemberComponent setInactiveElement(BooleanType value) {
      this.inactive = value;
      return this;
    }

    /**
     * @return A flag to indicate that the member is no longer in the group, but
     *         previously may have been a member.
     */
    public boolean getInactive() {
      return this.inactive == null || this.inactive.isEmpty() ? false : this.inactive.getValue();
    }

    /**
     * @param value A flag to indicate that the member is no longer in the group,
     *              but previously may have been a member.
     */
    public GroupMemberComponent setInactive(boolean value) {
      if (this.inactive == null)
        this.inactive = new BooleanType();
      this.inactive.setValue(value);
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("entity",
          "Reference(Patient|Practitioner|PractitionerRole|Device|Medication|Substance|Group)",
          "A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.",
          0, 1, entity));
      children.add(
          new Property("period", "Period", "The period that the member was in the group, if known.", 0, 1, period));
      children.add(new Property("inactive", "boolean",
          "A flag to indicate that the member is no longer in the group, but previously may have been a member.", 0, 1,
          inactive));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1298275357:
        /* entity */ return new Property("entity",
            "Reference(Patient|Practitioner|PractitionerRole|Device|Medication|Substance|Group)",
            "A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.",
            0, 1, entity);
      case -991726143:
        /* period */ return new Property("period", "Period", "The period that the member was in the group, if known.",
            0, 1, period);
      case 24665195:
        /* inactive */ return new Property("inactive", "boolean",
            "A flag to indicate that the member is no longer in the group, but previously may have been a member.", 0,
            1, inactive);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1298275357:
        /* entity */ return this.entity == null ? new Base[0] : new Base[] { this.entity }; // Reference
      case -991726143:
        /* period */ return this.period == null ? new Base[0] : new Base[] { this.period }; // Period
      case 24665195:
        /* inactive */ return this.inactive == null ? new Base[0] : new Base[] { this.inactive }; // BooleanType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1298275357: // entity
        this.entity = castToReference(value); // Reference
        return value;
      case -991726143: // period
        this.period = castToPeriod(value); // Period
        return value;
      case 24665195: // inactive
        this.inactive = castToBoolean(value); // BooleanType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("entity")) {
        this.entity = castToReference(value); // Reference
      } else if (name.equals("period")) {
        this.period = castToPeriod(value); // Period
      } else if (name.equals("inactive")) {
        this.inactive = castToBoolean(value); // BooleanType
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("entity")) {
        this.entity = null;
      } else if (name.equals("period")) {
        this.period = null;
      } else if (name.equals("inactive")) {
        this.inactive = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1298275357:
        return getEntity();
      case -991726143:
        return getPeriod();
      case 24665195:
        return getInactiveElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1298275357:
        /* entity */ return new String[] { "Reference" };
      case -991726143:
        /* period */ return new String[] { "Period" };
      case 24665195:
        /* inactive */ return new String[] { "boolean" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("entity")) {
        this.entity = new Reference();
        return this.entity;
      } else if (name.equals("period")) {
        this.period = new Period();
        return this.period;
      } else if (name.equals("inactive")) {
        throw new FHIRException("Cannot call addChild on a singleton property Group.inactive");
      } else
        return super.addChild(name);
    }

    public GroupMemberComponent copy() {
      GroupMemberComponent dst = new GroupMemberComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(GroupMemberComponent dst) {
      super.copyValues(dst);
      dst.entity = entity == null ? null : entity.copy();
      dst.period = period == null ? null : period.copy();
      dst.inactive = inactive == null ? null : inactive.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof GroupMemberComponent))
        return false;
      GroupMemberComponent o = (GroupMemberComponent) other_;
      return compareDeep(entity, o.entity, true) && compareDeep(period, o.period, true)
          && compareDeep(inactive, o.inactive, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof GroupMemberComponent))
        return false;
      GroupMemberComponent o = (GroupMemberComponent) other_;
      return compareValues(inactive, o.inactive, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(entity, period, inactive);
    }

    public String fhirType() {
      return "Group.member";

    }

  }

  /**
   * A unique business identifier for this group.
   */
  @Child(name = "identifier", type = {
      Identifier.class }, order = 0, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Unique id", formalDefinition = "A unique business identifier for this group.")
  protected List<Identifier> identifier;

  /**
   * Indicates whether the record for the group is available for use or is merely
   * being retained for historical purposes.
   */
  @Child(name = "active", type = { BooleanType.class }, order = 1, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Whether this group's record is in active use", formalDefinition = "Indicates whether the record for the group is available for use or is merely being retained for historical purposes.")
  protected BooleanType active;

  /**
   * Identifies the broad classification of the kind of resources the group
   * includes.
   */
  @Child(name = "type", type = { CodeType.class }, order = 2, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "person | animal | practitioner | device | medication | substance", formalDefinition = "Identifies the broad classification of the kind of resources the group includes.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/group-type")
  protected Enumeration<GroupType> type;

  /**
   * If true, indicates that the resource refers to a specific group of real
   * individuals. If false, the group defines a set of intended individuals.
   */
  @Child(name = "actual", type = { BooleanType.class }, order = 3, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Descriptive or actual", formalDefinition = "If true, indicates that the resource refers to a specific group of real individuals.  If false, the group defines a set of intended individuals.")
  protected BooleanType actual;

  /**
   * Provides a specific type of resource the group includes; e.g. "cow",
   * "syringe", etc.
   */
  @Child(name = "code", type = { CodeableConcept.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Kind of Group members", formalDefinition = "Provides a specific type of resource the group includes; e.g. \"cow\", \"syringe\", etc.")
  protected CodeableConcept code;

  /**
   * A label assigned to the group for human identification and communication.
   */
  @Child(name = "name", type = { StringType.class }, order = 5, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Label for Group", formalDefinition = "A label assigned to the group for human identification and communication.")
  protected StringType name;

  /**
   * A count of the number of resource instances that are part of the group.
   */
  @Child(name = "quantity", type = {
      UnsignedIntType.class }, order = 6, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Number of members", formalDefinition = "A count of the number of resource instances that are part of the group.")
  protected UnsignedIntType quantity;

  /**
   * Entity responsible for defining and maintaining Group characteristics and/or
   * registered members.
   */
  @Child(name = "managingEntity", type = { Organization.class, RelatedPerson.class, Practitioner.class,
      PractitionerRole.class }, order = 7, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Entity that is the custodian of the Group's definition", formalDefinition = "Entity responsible for defining and maintaining Group characteristics and/or registered members.")
  protected Reference managingEntity;

  /**
   * The actual object that is the target of the reference (Entity responsible for
   * defining and maintaining Group characteristics and/or registered members.)
   */
  protected Resource managingEntityTarget;

  /**
   * Identifies traits whose presence r absence is shared by members of the group.
   */
  @Child(name = "characteristic", type = {}, order = 8, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Include / Exclude group members by Trait", formalDefinition = "Identifies traits whose presence r absence is shared by members of the group.")
  protected List<GroupCharacteristicComponent> characteristic;

  /**
   * Identifies the resource instances that are members of the group.
   */
  @Child(name = "member", type = {}, order = 9, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who or what is in group", formalDefinition = "Identifies the resource instances that are members of the group.")
  protected List<GroupMemberComponent> member;

  private static final long serialVersionUID = -550945963L;

  /**
   * Constructor
   */
  public Group() {
    super();
  }

  /**
   * Constructor
   */
  public Group(Enumeration<GroupType> type, BooleanType actual) {
    super();
    this.type = type;
    this.actual = actual;
  }

  /**
   * @return {@link #identifier} (A unique business identifier for this group.)
   */
  public List<Identifier> getIdentifier() {
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    return this.identifier;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Group setIdentifier(List<Identifier> theIdentifier) {
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

  public Group addIdentifier(Identifier t) { // 3
    if (t == null)
      return this;
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #identifier}, creating
   *         it if it does not already exist
   */
  public Identifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return getIdentifier().get(0);
  }

  /**
   * @return {@link #active} (Indicates whether the record for the group is
   *         available for use or is merely being retained for historical
   *         purposes.). This is the underlying object with id, value and
   *         extensions. The accessor "getActive" gives direct access to the value
   */
  public BooleanType getActiveElement() {
    if (this.active == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Group.active");
      else if (Configuration.doAutoCreate())
        this.active = new BooleanType(); // bb
    return this.active;
  }

  public boolean hasActiveElement() {
    return this.active != null && !this.active.isEmpty();
  }

  public boolean hasActive() {
    return this.active != null && !this.active.isEmpty();
  }

  /**
   * @param value {@link #active} (Indicates whether the record for the group is
   *              available for use or is merely being retained for historical
   *              purposes.). This is the underlying object with id, value and
   *              extensions. The accessor "getActive" gives direct access to the
   *              value
   */
  public Group setActiveElement(BooleanType value) {
    this.active = value;
    return this;
  }

  /**
   * @return Indicates whether the record for the group is available for use or is
   *         merely being retained for historical purposes.
   */
  public boolean getActive() {
    return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
  }

  /**
   * @param value Indicates whether the record for the group is available for use
   *              or is merely being retained for historical purposes.
   */
  public Group setActive(boolean value) {
    if (this.active == null)
      this.active = new BooleanType();
    this.active.setValue(value);
    return this;
  }

  /**
   * @return {@link #type} (Identifies the broad classification of the kind of
   *         resources the group includes.). This is the underlying object with
   *         id, value and extensions. The accessor "getType" gives direct access
   *         to the value
   */
  public Enumeration<GroupType> getTypeElement() {
    if (this.type == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Group.type");
      else if (Configuration.doAutoCreate())
        this.type = new Enumeration<GroupType>(new GroupTypeEnumFactory()); // bb
    return this.type;
  }

  public boolean hasTypeElement() {
    return this.type != null && !this.type.isEmpty();
  }

  public boolean hasType() {
    return this.type != null && !this.type.isEmpty();
  }

  /**
   * @param value {@link #type} (Identifies the broad classification of the kind
   *              of resources the group includes.). This is the underlying object
   *              with id, value and extensions. The accessor "getType" gives
   *              direct access to the value
   */
  public Group setTypeElement(Enumeration<GroupType> value) {
    this.type = value;
    return this;
  }

  /**
   * @return Identifies the broad classification of the kind of resources the
   *         group includes.
   */
  public GroupType getType() {
    return this.type == null ? null : this.type.getValue();
  }

  /**
   * @param value Identifies the broad classification of the kind of resources the
   *              group includes.
   */
  public Group setType(GroupType value) {
    if (this.type == null)
      this.type = new Enumeration<GroupType>(new GroupTypeEnumFactory());
    this.type.setValue(value);
    return this;
  }

  /**
   * @return {@link #actual} (If true, indicates that the resource refers to a
   *         specific group of real individuals. If false, the group defines a set
   *         of intended individuals.). This is the underlying object with id,
   *         value and extensions. The accessor "getActual" gives direct access to
   *         the value
   */
  public BooleanType getActualElement() {
    if (this.actual == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Group.actual");
      else if (Configuration.doAutoCreate())
        this.actual = new BooleanType(); // bb
    return this.actual;
  }

  public boolean hasActualElement() {
    return this.actual != null && !this.actual.isEmpty();
  }

  public boolean hasActual() {
    return this.actual != null && !this.actual.isEmpty();
  }

  /**
   * @param value {@link #actual} (If true, indicates that the resource refers to
   *              a specific group of real individuals. If false, the group
   *              defines a set of intended individuals.). This is the underlying
   *              object with id, value and extensions. The accessor "getActual"
   *              gives direct access to the value
   */
  public Group setActualElement(BooleanType value) {
    this.actual = value;
    return this;
  }

  /**
   * @return If true, indicates that the resource refers to a specific group of
   *         real individuals. If false, the group defines a set of intended
   *         individuals.
   */
  public boolean getActual() {
    return this.actual == null || this.actual.isEmpty() ? false : this.actual.getValue();
  }

  /**
   * @param value If true, indicates that the resource refers to a specific group
   *              of real individuals. If false, the group defines a set of
   *              intended individuals.
   */
  public Group setActual(boolean value) {
    if (this.actual == null)
      this.actual = new BooleanType();
    this.actual.setValue(value);
    return this;
  }

  /**
   * @return {@link #code} (Provides a specific type of resource the group
   *         includes; e.g. "cow", "syringe", etc.)
   */
  public CodeableConcept getCode() {
    if (this.code == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Group.code");
      else if (Configuration.doAutoCreate())
        this.code = new CodeableConcept(); // cc
    return this.code;
  }

  public boolean hasCode() {
    return this.code != null && !this.code.isEmpty();
  }

  /**
   * @param value {@link #code} (Provides a specific type of resource the group
   *              includes; e.g. "cow", "syringe", etc.)
   */
  public Group setCode(CodeableConcept value) {
    this.code = value;
    return this;
  }

  /**
   * @return {@link #name} (A label assigned to the group for human identification
   *         and communication.). This is the underlying object with id, value and
   *         extensions. The accessor "getName" gives direct access to the value
   */
  public StringType getNameElement() {
    if (this.name == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Group.name");
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
   * @param value {@link #name} (A label assigned to the group for human
   *              identification and communication.). This is the underlying
   *              object with id, value and extensions. The accessor "getName"
   *              gives direct access to the value
   */
  public Group setNameElement(StringType value) {
    this.name = value;
    return this;
  }

  /**
   * @return A label assigned to the group for human identification and
   *         communication.
   */
  public String getName() {
    return this.name == null ? null : this.name.getValue();
  }

  /**
   * @param value A label assigned to the group for human identification and
   *              communication.
   */
  public Group setName(String value) {
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
   * @return {@link #quantity} (A count of the number of resource instances that
   *         are part of the group.). This is the underlying object with id, value
   *         and extensions. The accessor "getQuantity" gives direct access to the
   *         value
   */
  public UnsignedIntType getQuantityElement() {
    if (this.quantity == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Group.quantity");
      else if (Configuration.doAutoCreate())
        this.quantity = new UnsignedIntType(); // bb
    return this.quantity;
  }

  public boolean hasQuantityElement() {
    return this.quantity != null && !this.quantity.isEmpty();
  }

  public boolean hasQuantity() {
    return this.quantity != null && !this.quantity.isEmpty();
  }

  /**
   * @param value {@link #quantity} (A count of the number of resource instances
   *              that are part of the group.). This is the underlying object with
   *              id, value and extensions. The accessor "getQuantity" gives
   *              direct access to the value
   */
  public Group setQuantityElement(UnsignedIntType value) {
    this.quantity = value;
    return this;
  }

  /**
   * @return A count of the number of resource instances that are part of the
   *         group.
   */
  public int getQuantity() {
    return this.quantity == null || this.quantity.isEmpty() ? 0 : this.quantity.getValue();
  }

  /**
   * @param value A count of the number of resource instances that are part of the
   *              group.
   */
  public Group setQuantity(int value) {
    if (this.quantity == null)
      this.quantity = new UnsignedIntType();
    this.quantity.setValue(value);
    return this;
  }

  /**
   * @return {@link #managingEntity} (Entity responsible for defining and
   *         maintaining Group characteristics and/or registered members.)
   */
  public Reference getManagingEntity() {
    if (this.managingEntity == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Group.managingEntity");
      else if (Configuration.doAutoCreate())
        this.managingEntity = new Reference(); // cc
    return this.managingEntity;
  }

  public boolean hasManagingEntity() {
    return this.managingEntity != null && !this.managingEntity.isEmpty();
  }

  /**
   * @param value {@link #managingEntity} (Entity responsible for defining and
   *              maintaining Group characteristics and/or registered members.)
   */
  public Group setManagingEntity(Reference value) {
    this.managingEntity = value;
    return this;
  }

  /**
   * @return {@link #managingEntity} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (Entity responsible
   *         for defining and maintaining Group characteristics and/or registered
   *         members.)
   */
  public Resource getManagingEntityTarget() {
    return this.managingEntityTarget;
  }

  /**
   * @param value {@link #managingEntity} The actual object that is the target of
   *              the reference. The reference library doesn't use these, but you
   *              can use it to hold the resource if you resolve it. (Entity
   *              responsible for defining and maintaining Group characteristics
   *              and/or registered members.)
   */
  public Group setManagingEntityTarget(Resource value) {
    this.managingEntityTarget = value;
    return this;
  }

  /**
   * @return {@link #characteristic} (Identifies traits whose presence r absence
   *         is shared by members of the group.)
   */
  public List<GroupCharacteristicComponent> getCharacteristic() {
    if (this.characteristic == null)
      this.characteristic = new ArrayList<GroupCharacteristicComponent>();
    return this.characteristic;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Group setCharacteristic(List<GroupCharacteristicComponent> theCharacteristic) {
    this.characteristic = theCharacteristic;
    return this;
  }

  public boolean hasCharacteristic() {
    if (this.characteristic == null)
      return false;
    for (GroupCharacteristicComponent item : this.characteristic)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public GroupCharacteristicComponent addCharacteristic() { // 3
    GroupCharacteristicComponent t = new GroupCharacteristicComponent();
    if (this.characteristic == null)
      this.characteristic = new ArrayList<GroupCharacteristicComponent>();
    this.characteristic.add(t);
    return t;
  }

  public Group addCharacteristic(GroupCharacteristicComponent t) { // 3
    if (t == null)
      return this;
    if (this.characteristic == null)
      this.characteristic = new ArrayList<GroupCharacteristicComponent>();
    this.characteristic.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #characteristic},
   *         creating it if it does not already exist
   */
  public GroupCharacteristicComponent getCharacteristicFirstRep() {
    if (getCharacteristic().isEmpty()) {
      addCharacteristic();
    }
    return getCharacteristic().get(0);
  }

  /**
   * @return {@link #member} (Identifies the resource instances that are members
   *         of the group.)
   */
  public List<GroupMemberComponent> getMember() {
    if (this.member == null)
      this.member = new ArrayList<GroupMemberComponent>();
    return this.member;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Group setMember(List<GroupMemberComponent> theMember) {
    this.member = theMember;
    return this;
  }

  public boolean hasMember() {
    if (this.member == null)
      return false;
    for (GroupMemberComponent item : this.member)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public GroupMemberComponent addMember() { // 3
    GroupMemberComponent t = new GroupMemberComponent();
    if (this.member == null)
      this.member = new ArrayList<GroupMemberComponent>();
    this.member.add(t);
    return t;
  }

  public Group addMember(GroupMemberComponent t) { // 3
    if (t == null)
      return this;
    if (this.member == null)
      this.member = new ArrayList<GroupMemberComponent>();
    this.member.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #member}, creating it
   *         if it does not already exist
   */
  public GroupMemberComponent getMemberFirstRep() {
    if (getMember().isEmpty()) {
      addMember();
    }
    return getMember().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("identifier", "Identifier", "A unique business identifier for this group.", 0,
        java.lang.Integer.MAX_VALUE, identifier));
    children.add(new Property("active", "boolean",
        "Indicates whether the record for the group is available for use or is merely being retained for historical purposes.",
        0, 1, active));
    children.add(new Property("type", "code",
        "Identifies the broad classification of the kind of resources the group includes.", 0, 1, type));
    children.add(new Property("actual", "boolean",
        "If true, indicates that the resource refers to a specific group of real individuals.  If false, the group defines a set of intended individuals.",
        0, 1, actual));
    children.add(new Property("code", "CodeableConcept",
        "Provides a specific type of resource the group includes; e.g. \"cow\", \"syringe\", etc.", 0, 1, code));
    children.add(new Property("name", "string",
        "A label assigned to the group for human identification and communication.", 0, 1, name));
    children.add(new Property("quantity", "unsignedInt",
        "A count of the number of resource instances that are part of the group.", 0, 1, quantity));
    children.add(new Property("managingEntity", "Reference(Organization|RelatedPerson|Practitioner|PractitionerRole)",
        "Entity responsible for defining and maintaining Group characteristics and/or registered members.", 0, 1,
        managingEntity));
    children.add(new Property("characteristic", "",
        "Identifies traits whose presence r absence is shared by members of the group.", 0, java.lang.Integer.MAX_VALUE,
        characteristic));
    children.add(new Property("member", "", "Identifies the resource instances that are members of the group.", 0,
        java.lang.Integer.MAX_VALUE, member));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case -1618432855:
      /* identifier */ return new Property("identifier", "Identifier", "A unique business identifier for this group.",
          0, java.lang.Integer.MAX_VALUE, identifier);
    case -1422950650:
      /* active */ return new Property("active", "boolean",
          "Indicates whether the record for the group is available for use or is merely being retained for historical purposes.",
          0, 1, active);
    case 3575610:
      /* type */ return new Property("type", "code",
          "Identifies the broad classification of the kind of resources the group includes.", 0, 1, type);
    case -1422939762:
      /* actual */ return new Property("actual", "boolean",
          "If true, indicates that the resource refers to a specific group of real individuals.  If false, the group defines a set of intended individuals.",
          0, 1, actual);
    case 3059181:
      /* code */ return new Property("code", "CodeableConcept",
          "Provides a specific type of resource the group includes; e.g. \"cow\", \"syringe\", etc.", 0, 1, code);
    case 3373707:
      /* name */ return new Property("name", "string",
          "A label assigned to the group for human identification and communication.", 0, 1, name);
    case -1285004149:
      /* quantity */ return new Property("quantity", "unsignedInt",
          "A count of the number of resource instances that are part of the group.", 0, 1, quantity);
    case -988474523:
      /* managingEntity */ return new Property("managingEntity",
          "Reference(Organization|RelatedPerson|Practitioner|PractitionerRole)",
          "Entity responsible for defining and maintaining Group characteristics and/or registered members.", 0, 1,
          managingEntity);
    case 366313883:
      /* characteristic */ return new Property("characteristic", "",
          "Identifies traits whose presence r absence is shared by members of the group.", 0,
          java.lang.Integer.MAX_VALUE, characteristic);
    case -1077769574:
      /* member */ return new Property("member", "", "Identifies the resource instances that are members of the group.",
          0, java.lang.Integer.MAX_VALUE, member);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case -1618432855:
      /* identifier */ return this.identifier == null ? new Base[0]
          : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
    case -1422950650:
      /* active */ return this.active == null ? new Base[0] : new Base[] { this.active }; // BooleanType
    case 3575610:
      /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // Enumeration<GroupType>
    case -1422939762:
      /* actual */ return this.actual == null ? new Base[0] : new Base[] { this.actual }; // BooleanType
    case 3059181:
      /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
    case 3373707:
      /* name */ return this.name == null ? new Base[0] : new Base[] { this.name }; // StringType
    case -1285004149:
      /* quantity */ return this.quantity == null ? new Base[0] : new Base[] { this.quantity }; // UnsignedIntType
    case -988474523:
      /* managingEntity */ return this.managingEntity == null ? new Base[0] : new Base[] { this.managingEntity }; // Reference
    case 366313883:
      /* characteristic */ return this.characteristic == null ? new Base[0]
          : this.characteristic.toArray(new Base[this.characteristic.size()]); // GroupCharacteristicComponent
    case -1077769574:
      /* member */ return this.member == null ? new Base[0] : this.member.toArray(new Base[this.member.size()]); // GroupMemberComponent
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case -1618432855: // identifier
      this.getIdentifier().add(castToIdentifier(value)); // Identifier
      return value;
    case -1422950650: // active
      this.active = castToBoolean(value); // BooleanType
      return value;
    case 3575610: // type
      value = new GroupTypeEnumFactory().fromType(castToCode(value));
      this.type = (Enumeration) value; // Enumeration<GroupType>
      return value;
    case -1422939762: // actual
      this.actual = castToBoolean(value); // BooleanType
      return value;
    case 3059181: // code
      this.code = castToCodeableConcept(value); // CodeableConcept
      return value;
    case 3373707: // name
      this.name = castToString(value); // StringType
      return value;
    case -1285004149: // quantity
      this.quantity = castToUnsignedInt(value); // UnsignedIntType
      return value;
    case -988474523: // managingEntity
      this.managingEntity = castToReference(value); // Reference
      return value;
    case 366313883: // characteristic
      this.getCharacteristic().add((GroupCharacteristicComponent) value); // GroupCharacteristicComponent
      return value;
    case -1077769574: // member
      this.getMember().add((GroupMemberComponent) value); // GroupMemberComponent
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("identifier")) {
      this.getIdentifier().add(castToIdentifier(value));
    } else if (name.equals("active")) {
      this.active = castToBoolean(value); // BooleanType
    } else if (name.equals("type")) {
      value = new GroupTypeEnumFactory().fromType(castToCode(value));
      this.type = (Enumeration) value; // Enumeration<GroupType>
    } else if (name.equals("actual")) {
      this.actual = castToBoolean(value); // BooleanType
    } else if (name.equals("code")) {
      this.code = castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("name")) {
      this.name = castToString(value); // StringType
    } else if (name.equals("quantity")) {
      this.quantity = castToUnsignedInt(value); // UnsignedIntType
    } else if (name.equals("managingEntity")) {
      this.managingEntity = castToReference(value); // Reference
    } else if (name.equals("characteristic")) {
      this.getCharacteristic().add((GroupCharacteristicComponent) value);
    } else if (name.equals("member")) {
      this.getMember().add((GroupMemberComponent) value);
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    if (name.equals("identifier")) {
      this.getIdentifier().remove(castToIdentifier(value));
    } else if (name.equals("active")) {
      this.active = null;
    } else if (name.equals("type")) {
      this.type = null;
    } else if (name.equals("actual")) {
      this.actual = null;
    } else if (name.equals("code")) {
      this.code = null;
    } else if (name.equals("name")) {
      this.name = null;
    } else if (name.equals("quantity")) {
      this.quantity = null;
    } else if (name.equals("managingEntity")) {
      this.managingEntity = null;
    } else if (name.equals("characteristic")) {
      this.getCharacteristic().remove((GroupCharacteristicComponent) value);
    } else if (name.equals("member")) {
      this.getMember().remove((GroupMemberComponent) value);
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1618432855:
      return addIdentifier();
    case -1422950650:
      return getActiveElement();
    case 3575610:
      return getTypeElement();
    case -1422939762:
      return getActualElement();
    case 3059181:
      return getCode();
    case 3373707:
      return getNameElement();
    case -1285004149:
      return getQuantityElement();
    case -988474523:
      return getManagingEntity();
    case 366313883:
      return addCharacteristic();
    case -1077769574:
      return addMember();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1618432855:
      /* identifier */ return new String[] { "Identifier" };
    case -1422950650:
      /* active */ return new String[] { "boolean" };
    case 3575610:
      /* type */ return new String[] { "code" };
    case -1422939762:
      /* actual */ return new String[] { "boolean" };
    case 3059181:
      /* code */ return new String[] { "CodeableConcept" };
    case 3373707:
      /* name */ return new String[] { "string" };
    case -1285004149:
      /* quantity */ return new String[] { "unsignedInt" };
    case -988474523:
      /* managingEntity */ return new String[] { "Reference" };
    case 366313883:
      /* characteristic */ return new String[] {};
    case -1077769574:
      /* member */ return new String[] {};
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("identifier")) {
      return addIdentifier();
    } else if (name.equals("active")) {
      throw new FHIRException("Cannot call addChild on a singleton property Group.active");
    } else if (name.equals("type")) {
      throw new FHIRException("Cannot call addChild on a singleton property Group.type");
    } else if (name.equals("actual")) {
      throw new FHIRException("Cannot call addChild on a singleton property Group.actual");
    } else if (name.equals("code")) {
      this.code = new CodeableConcept();
      return this.code;
    } else if (name.equals("name")) {
      throw new FHIRException("Cannot call addChild on a singleton property Group.name");
    } else if (name.equals("quantity")) {
      throw new FHIRException("Cannot call addChild on a singleton property Group.quantity");
    } else if (name.equals("managingEntity")) {
      this.managingEntity = new Reference();
      return this.managingEntity;
    } else if (name.equals("characteristic")) {
      return addCharacteristic();
    } else if (name.equals("member")) {
      return addMember();
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "Group";

  }

  public Group copy() {
    Group dst = new Group();
    copyValues(dst);
    return dst;
  }

  public void copyValues(Group dst) {
    super.copyValues(dst);
    if (identifier != null) {
      dst.identifier = new ArrayList<Identifier>();
      for (Identifier i : identifier)
        dst.identifier.add(i.copy());
    }
    ;
    dst.active = active == null ? null : active.copy();
    dst.type = type == null ? null : type.copy();
    dst.actual = actual == null ? null : actual.copy();
    dst.code = code == null ? null : code.copy();
    dst.name = name == null ? null : name.copy();
    dst.quantity = quantity == null ? null : quantity.copy();
    dst.managingEntity = managingEntity == null ? null : managingEntity.copy();
    if (characteristic != null) {
      dst.characteristic = new ArrayList<GroupCharacteristicComponent>();
      for (GroupCharacteristicComponent i : characteristic)
        dst.characteristic.add(i.copy());
    }
    ;
    if (member != null) {
      dst.member = new ArrayList<GroupMemberComponent>();
      for (GroupMemberComponent i : member)
        dst.member.add(i.copy());
    }
    ;
  }

  protected Group typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof Group))
      return false;
    Group o = (Group) other_;
    return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true)
        && compareDeep(type, o.type, true) && compareDeep(actual, o.actual, true) && compareDeep(code, o.code, true)
        && compareDeep(name, o.name, true) && compareDeep(quantity, o.quantity, true)
        && compareDeep(managingEntity, o.managingEntity, true) && compareDeep(characteristic, o.characteristic, true)
        && compareDeep(member, o.member, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof Group))
      return false;
    Group o = (Group) other_;
    return compareValues(active, o.active, true) && compareValues(type, o.type, true)
        && compareValues(actual, o.actual, true) && compareValues(name, o.name, true)
        && compareValues(quantity, o.quantity, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, type, actual, code, name,
        quantity, managingEntity, characteristic, member);
  }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Group;
  }

  /**
   * Search parameter: <b>actual</b>
   * <p>
   * Description: <b>Descriptive or actual</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.actual</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "actual", path = "Group.actual", description = "Descriptive or actual", type = "token")
  public static final String SP_ACTUAL = "actual";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>actual</b>
   * <p>
   * Description: <b>Descriptive or actual</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.actual</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTUAL = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_ACTUAL);

  /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Unique id</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "identifier", path = "Group.identifier", description = "Unique id", type = "token")
  public static final String SP_IDENTIFIER = "identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Unique id</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_IDENTIFIER);

  /**
   * Search parameter: <b>characteristic-value</b>
   * <p>
   * Description: <b>A composite of both characteristic and value</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  @SearchParamDefinition(name = "characteristic-value", path = "Group.characteristic", description = "A composite of both characteristic and value", type = "composite", compositeOf = {
      "characteristic", "value" })
  public static final String SP_CHARACTERISTIC_VALUE = "characteristic-value";
  /**
   * <b>Fluent Client</b> search parameter constant for
   * <b>characteristic-value</b>
   * <p>
   * Description: <b>A composite of both characteristic and value</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CHARACTERISTIC_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(
      SP_CHARACTERISTIC_VALUE);

  /**
   * Search parameter: <b>managing-entity</b>
   * <p>
   * Description: <b>Entity that is the custodian of the Group's
   * definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.managingEntity</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "managing-entity", path = "Group.managingEntity", description = "Entity that is the custodian of the Group's definition", type = "reference", target = {
      Organization.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class })
  public static final String SP_MANAGING_ENTITY = "managing-entity";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>managing-entity</b>
   * <p>
   * Description: <b>Entity that is the custodian of the Group's
   * definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.managingEntity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANAGING_ENTITY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_MANAGING_ENTITY);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Group:managing-entity</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANAGING_ENTITY = new ca.uhn.fhir.model.api.Include(
      "Group:managing-entity").toLocked();

  /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>The kind of resources contained</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "code", path = "Group.code", description = "The kind of resources contained", type = "token")
  public static final String SP_CODE = "code";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>The kind of resources contained</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CODE);

  /**
   * Search parameter: <b>member</b>
   * <p>
   * Description: <b>Reference to the group member</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.member.entity</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "member", path = "Group.member.entity", description = "Reference to the group member", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Device"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Practitioner") }, target = { Device.class, Group.class,
          Medication.class, Patient.class, Practitioner.class, PractitionerRole.class, Substance.class })
  public static final String SP_MEMBER = "member";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>member</b>
   * <p>
   * Description: <b>Reference to the group member</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.member.entity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MEMBER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_MEMBER);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Group:member</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MEMBER = new ca.uhn.fhir.model.api.Include("Group:member")
      .toLocked();

  /**
   * Search parameter: <b>exclude</b>
   * <p>
   * Description: <b>Group includes or excludes</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.exclude</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "exclude", path = "Group.characteristic.exclude", description = "Group includes or excludes", type = "token")
  public static final String SP_EXCLUDE = "exclude";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>exclude</b>
   * <p>
   * Description: <b>Group includes or excludes</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.exclude</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EXCLUDE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_EXCLUDE);

  /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>The type of resources the group contains</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "type", path = "Group.type", description = "The type of resources the group contains", type = "token")
  public static final String SP_TYPE = "type";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>The type of resources the group contains</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_TYPE);

  /**
   * Search parameter: <b>value</b>
   * <p>
   * Description: <b>Value held by characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.value[x]</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "value", path = "(Group.characteristic.value as CodeableConcept) | (Group.characteristic.value as boolean)", description = "Value held by characteristic", type = "token")
  public static final String SP_VALUE = "value";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>value</b>
   * <p>
   * Description: <b>Value held by characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.value[x]</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VALUE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_VALUE);

  /**
   * Search parameter: <b>characteristic</b>
   * <p>
   * Description: <b>Kind of characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "characteristic", path = "Group.characteristic.code", description = "Kind of characteristic", type = "token")
  public static final String SP_CHARACTERISTIC = "characteristic";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic</b>
   * <p>
   * Description: <b>Kind of characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CHARACTERISTIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CHARACTERISTIC);

}
