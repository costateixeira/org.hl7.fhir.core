package org.hl7.fhir.r5.model;


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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
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
 * Representation of a molecular sequence.
 */
@ResourceDef(name="MolecularSequence", profile="http://hl7.org/fhir/StructureDefinition/MolecularSequence")
public class MolecularSequence extends DomainResource {

    public enum OrientationType {
        /**
         * Sense orientation of reference sequence.
         */
        SENSE, 
        /**
         * Antisense orientation of reference sequence.
         */
        ANTISENSE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static OrientationType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sense".equals(codeString))
          return SENSE;
        if ("antisense".equals(codeString))
          return ANTISENSE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown OrientationType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SENSE: return "sense";
            case ANTISENSE: return "antisense";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SENSE: return "http://hl7.org/fhir/orientation-type";
            case ANTISENSE: return "http://hl7.org/fhir/orientation-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SENSE: return "Sense orientation of reference sequence.";
            case ANTISENSE: return "Antisense orientation of reference sequence.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SENSE: return "Sense orientation of referenceSeq";
            case ANTISENSE: return "Antisense orientation of referenceSeq";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class OrientationTypeEnumFactory implements EnumFactory<OrientationType> {
    public OrientationType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sense".equals(codeString))
          return OrientationType.SENSE;
        if ("antisense".equals(codeString))
          return OrientationType.ANTISENSE;
        throw new IllegalArgumentException("Unknown OrientationType code '"+codeString+"'");
        }
        public Enumeration<OrientationType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<OrientationType>(this, OrientationType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<OrientationType>(this, OrientationType.NULL, code);
        if ("sense".equals(codeString))
          return new Enumeration<OrientationType>(this, OrientationType.SENSE, code);
        if ("antisense".equals(codeString))
          return new Enumeration<OrientationType>(this, OrientationType.ANTISENSE, code);
        throw new FHIRException("Unknown OrientationType code '"+codeString+"'");
        }
    public String toCode(OrientationType code) {
       if (code == OrientationType.NULL)
           return null;
       if (code == OrientationType.SENSE)
        return "sense";
      if (code == OrientationType.ANTISENSE)
        return "antisense";
      return "?";
   }
    public String toSystem(OrientationType code) {
      return code.getSystem();
      }
    }

    public enum SequenceType {
        /**
         * Amino acid sequence.
         */
        AA, 
        /**
         * DNA Sequence.
         */
        DNA, 
        /**
         * RNA Sequence.
         */
        RNA, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SequenceType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("aa".equals(codeString))
          return AA;
        if ("dna".equals(codeString))
          return DNA;
        if ("rna".equals(codeString))
          return RNA;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SequenceType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AA: return "aa";
            case DNA: return "dna";
            case RNA: return "rna";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AA: return "http://hl7.org/fhir/sequence-type";
            case DNA: return "http://hl7.org/fhir/sequence-type";
            case RNA: return "http://hl7.org/fhir/sequence-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AA: return "Amino acid sequence.";
            case DNA: return "DNA Sequence.";
            case RNA: return "RNA Sequence.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AA: return "AA Sequence";
            case DNA: return "DNA Sequence";
            case RNA: return "RNA Sequence";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SequenceTypeEnumFactory implements EnumFactory<SequenceType> {
    public SequenceType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("aa".equals(codeString))
          return SequenceType.AA;
        if ("dna".equals(codeString))
          return SequenceType.DNA;
        if ("rna".equals(codeString))
          return SequenceType.RNA;
        throw new IllegalArgumentException("Unknown SequenceType code '"+codeString+"'");
        }
        public Enumeration<SequenceType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SequenceType>(this, SequenceType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<SequenceType>(this, SequenceType.NULL, code);
        if ("aa".equals(codeString))
          return new Enumeration<SequenceType>(this, SequenceType.AA, code);
        if ("dna".equals(codeString))
          return new Enumeration<SequenceType>(this, SequenceType.DNA, code);
        if ("rna".equals(codeString))
          return new Enumeration<SequenceType>(this, SequenceType.RNA, code);
        throw new FHIRException("Unknown SequenceType code '"+codeString+"'");
        }
    public String toCode(SequenceType code) {
       if (code == SequenceType.NULL)
           return null;
       if (code == SequenceType.AA)
        return "aa";
      if (code == SequenceType.DNA)
        return "dna";
      if (code == SequenceType.RNA)
        return "rna";
      return "?";
   }
    public String toSystem(SequenceType code) {
      return code.getSystem();
      }
    }

    public enum StrandType {
        /**
         * Watson strand of starting sequence.
         */
        WATSON, 
        /**
         * Crick strand of starting sequence.
         */
        CRICK, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StrandType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("watson".equals(codeString))
          return WATSON;
        if ("crick".equals(codeString))
          return CRICK;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StrandType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case WATSON: return "watson";
            case CRICK: return "crick";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case WATSON: return "http://hl7.org/fhir/strand-type";
            case CRICK: return "http://hl7.org/fhir/strand-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case WATSON: return "Watson strand of starting sequence.";
            case CRICK: return "Crick strand of starting sequence.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case WATSON: return "Watson strand of starting sequence";
            case CRICK: return "Crick strand of starting sequence";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StrandTypeEnumFactory implements EnumFactory<StrandType> {
    public StrandType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("watson".equals(codeString))
          return StrandType.WATSON;
        if ("crick".equals(codeString))
          return StrandType.CRICK;
        throw new IllegalArgumentException("Unknown StrandType code '"+codeString+"'");
        }
        public Enumeration<StrandType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StrandType>(this, StrandType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<StrandType>(this, StrandType.NULL, code);
        if ("watson".equals(codeString))
          return new Enumeration<StrandType>(this, StrandType.WATSON, code);
        if ("crick".equals(codeString))
          return new Enumeration<StrandType>(this, StrandType.CRICK, code);
        throw new FHIRException("Unknown StrandType code '"+codeString+"'");
        }
    public String toCode(StrandType code) {
       if (code == StrandType.NULL)
           return null;
       if (code == StrandType.WATSON)
        return "watson";
      if (code == StrandType.CRICK)
        return "crick";
      return "?";
   }
    public String toSystem(StrandType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MolecularSequenceRelativeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.
         */
        @Child(name = "coordinateSystem", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Ways of identifying nucleotides or amino acids within a sequence", formalDefinition="These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/LL5323-2/")
        protected CodeableConcept coordinateSystem;

        /**
         * Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.
         */
        @Child(name = "ordinalPosition", type = {IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together", formalDefinition="Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together." )
        protected IntegerType ordinalPosition;

        /**
         * Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.
         */
        @Child(name = "sequenceRange", type = {Range.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together", formalDefinition="Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together." )
        protected Range sequenceRange;

        /**
         * A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.
         */
        @Child(name = "startingSequence", type = {}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A sequence used as starting sequence", formalDefinition="A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed." )
        protected MolecularSequenceRelativeStartingSequenceComponent startingSequence;

        /**
         * Changes in sequence from the starting sequence.
         */
        @Child(name = "edit", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Changes in sequence from the starting sequence", formalDefinition="Changes in sequence from the starting sequence." )
        protected List<MolecularSequenceRelativeEditComponent> edit;

        private static final long serialVersionUID = -1455983973L;

    /**
     * Constructor
     */
      public MolecularSequenceRelativeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MolecularSequenceRelativeComponent(CodeableConcept coordinateSystem) {
        super();
        this.setCoordinateSystem(coordinateSystem);
      }

        /**
         * @return {@link #coordinateSystem} (These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.)
         */
        public CodeableConcept getCoordinateSystem() { 
          if (this.coordinateSystem == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.coordinateSystem");
            else if (Configuration.doAutoCreate())
              this.coordinateSystem = new CodeableConcept(); // cc
          return this.coordinateSystem;
        }

        public boolean hasCoordinateSystem() { 
          return this.coordinateSystem != null && !this.coordinateSystem.isEmpty();
        }

        /**
         * @param value {@link #coordinateSystem} (These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.)
         */
        public MolecularSequenceRelativeComponent setCoordinateSystem(CodeableConcept value) { 
          this.coordinateSystem = value;
          return this;
        }

        /**
         * @return {@link #ordinalPosition} (Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.). This is the underlying object with id, value and extensions. The accessor "getOrdinalPosition" gives direct access to the value
         */
        public IntegerType getOrdinalPositionElement() { 
          if (this.ordinalPosition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.ordinalPosition");
            else if (Configuration.doAutoCreate())
              this.ordinalPosition = new IntegerType(); // bb
          return this.ordinalPosition;
        }

        public boolean hasOrdinalPositionElement() { 
          return this.ordinalPosition != null && !this.ordinalPosition.isEmpty();
        }

        public boolean hasOrdinalPosition() { 
          return this.ordinalPosition != null && !this.ordinalPosition.isEmpty();
        }

        /**
         * @param value {@link #ordinalPosition} (Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.). This is the underlying object with id, value and extensions. The accessor "getOrdinalPosition" gives direct access to the value
         */
        public MolecularSequenceRelativeComponent setOrdinalPositionElement(IntegerType value) { 
          this.ordinalPosition = value;
          return this;
        }

        /**
         * @return Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.
         */
        public int getOrdinalPosition() { 
          return this.ordinalPosition == null || this.ordinalPosition.isEmpty() ? 0 : this.ordinalPosition.getValue();
        }

        /**
         * @param value Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.
         */
        public MolecularSequenceRelativeComponent setOrdinalPosition(int value) { 
            if (this.ordinalPosition == null)
              this.ordinalPosition = new IntegerType();
            this.ordinalPosition.setValue(value);
          return this;
        }

        /**
         * @return {@link #sequenceRange} (Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.)
         */
        public Range getSequenceRange() { 
          if (this.sequenceRange == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.sequenceRange");
            else if (Configuration.doAutoCreate())
              this.sequenceRange = new Range(); // cc
          return this.sequenceRange;
        }

        public boolean hasSequenceRange() { 
          return this.sequenceRange != null && !this.sequenceRange.isEmpty();
        }

        /**
         * @param value {@link #sequenceRange} (Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.)
         */
        public MolecularSequenceRelativeComponent setSequenceRange(Range value) { 
          this.sequenceRange = value;
          return this;
        }

        /**
         * @return {@link #startingSequence} (A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.)
         */
        public MolecularSequenceRelativeStartingSequenceComponent getStartingSequence() { 
          if (this.startingSequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.startingSequence");
            else if (Configuration.doAutoCreate())
              this.startingSequence = new MolecularSequenceRelativeStartingSequenceComponent(); // cc
          return this.startingSequence;
        }

        public boolean hasStartingSequence() { 
          return this.startingSequence != null && !this.startingSequence.isEmpty();
        }

        /**
         * @param value {@link #startingSequence} (A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.)
         */
        public MolecularSequenceRelativeComponent setStartingSequence(MolecularSequenceRelativeStartingSequenceComponent value) { 
          this.startingSequence = value;
          return this;
        }

        /**
         * @return {@link #edit} (Changes in sequence from the starting sequence.)
         */
        public List<MolecularSequenceRelativeEditComponent> getEdit() { 
          if (this.edit == null)
            this.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          return this.edit;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MolecularSequenceRelativeComponent setEdit(List<MolecularSequenceRelativeEditComponent> theEdit) { 
          this.edit = theEdit;
          return this;
        }

        public boolean hasEdit() { 
          if (this.edit == null)
            return false;
          for (MolecularSequenceRelativeEditComponent item : this.edit)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MolecularSequenceRelativeEditComponent addEdit() { //3
          MolecularSequenceRelativeEditComponent t = new MolecularSequenceRelativeEditComponent();
          if (this.edit == null)
            this.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          this.edit.add(t);
          return t;
        }

        public MolecularSequenceRelativeComponent addEdit(MolecularSequenceRelativeEditComponent t) { //3
          if (t == null)
            return this;
          if (this.edit == null)
            this.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          this.edit.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #edit}, creating it if it does not already exist {3}
         */
        public MolecularSequenceRelativeEditComponent getEditFirstRep() { 
          if (getEdit().isEmpty()) {
            addEdit();
          }
          return getEdit().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("coordinateSystem", "CodeableConcept", "These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.", 0, 1, coordinateSystem));
          children.add(new Property("ordinalPosition", "integer", "Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.", 0, 1, ordinalPosition));
          children.add(new Property("sequenceRange", "Range", "Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.", 0, 1, sequenceRange));
          children.add(new Property("startingSequence", "", "A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.", 0, 1, startingSequence));
          children.add(new Property("edit", "", "Changes in sequence from the starting sequence.", 0, java.lang.Integer.MAX_VALUE, edit));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 354212295: /*coordinateSystem*/  return new Property("coordinateSystem", "CodeableConcept", "These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.", 0, 1, coordinateSystem);
          case 626439866: /*ordinalPosition*/  return new Property("ordinalPosition", "integer", "Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.", 0, 1, ordinalPosition);
          case -733314564: /*sequenceRange*/  return new Property("sequenceRange", "Range", "Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.", 0, 1, sequenceRange);
          case 1493400609: /*startingSequence*/  return new Property("startingSequence", "", "A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.", 0, 1, startingSequence);
          case 3108362: /*edit*/  return new Property("edit", "", "Changes in sequence from the starting sequence.", 0, java.lang.Integer.MAX_VALUE, edit);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 354212295: /*coordinateSystem*/ return this.coordinateSystem == null ? new Base[0] : new Base[] {this.coordinateSystem}; // CodeableConcept
        case 626439866: /*ordinalPosition*/ return this.ordinalPosition == null ? new Base[0] : new Base[] {this.ordinalPosition}; // IntegerType
        case -733314564: /*sequenceRange*/ return this.sequenceRange == null ? new Base[0] : new Base[] {this.sequenceRange}; // Range
        case 1493400609: /*startingSequence*/ return this.startingSequence == null ? new Base[0] : new Base[] {this.startingSequence}; // MolecularSequenceRelativeStartingSequenceComponent
        case 3108362: /*edit*/ return this.edit == null ? new Base[0] : this.edit.toArray(new Base[this.edit.size()]); // MolecularSequenceRelativeEditComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 354212295: // coordinateSystem
          this.coordinateSystem = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 626439866: // ordinalPosition
          this.ordinalPosition = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -733314564: // sequenceRange
          this.sequenceRange = TypeConvertor.castToRange(value); // Range
          return value;
        case 1493400609: // startingSequence
          this.startingSequence = (MolecularSequenceRelativeStartingSequenceComponent) value; // MolecularSequenceRelativeStartingSequenceComponent
          return value;
        case 3108362: // edit
          this.getEdit().add((MolecularSequenceRelativeEditComponent) value); // MolecularSequenceRelativeEditComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("coordinateSystem")) {
          this.coordinateSystem = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("ordinalPosition")) {
          this.ordinalPosition = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("sequenceRange")) {
          this.sequenceRange = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("startingSequence")) {
          this.startingSequence = (MolecularSequenceRelativeStartingSequenceComponent) value; // MolecularSequenceRelativeStartingSequenceComponent
        } else if (name.equals("edit")) {
          this.getEdit().add((MolecularSequenceRelativeEditComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("coordinateSystem")) {
          this.coordinateSystem = null;
        } else if (name.equals("ordinalPosition")) {
          this.ordinalPosition = null;
        } else if (name.equals("sequenceRange")) {
          this.sequenceRange = null;
        } else if (name.equals("startingSequence")) {
          this.startingSequence = (MolecularSequenceRelativeStartingSequenceComponent) value; // MolecularSequenceRelativeStartingSequenceComponent
        } else if (name.equals("edit")) {
          this.getEdit().remove((MolecularSequenceRelativeEditComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 354212295:  return getCoordinateSystem();
        case 626439866:  return getOrdinalPositionElement();
        case -733314564:  return getSequenceRange();
        case 1493400609:  return getStartingSequence();
        case 3108362:  return addEdit(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 354212295: /*coordinateSystem*/ return new String[] {"CodeableConcept"};
        case 626439866: /*ordinalPosition*/ return new String[] {"integer"};
        case -733314564: /*sequenceRange*/ return new String[] {"Range"};
        case 1493400609: /*startingSequence*/ return new String[] {};
        case 3108362: /*edit*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("coordinateSystem")) {
          this.coordinateSystem = new CodeableConcept();
          return this.coordinateSystem;
        }
        else if (name.equals("ordinalPosition")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.ordinalPosition");
        }
        else if (name.equals("sequenceRange")) {
          this.sequenceRange = new Range();
          return this.sequenceRange;
        }
        else if (name.equals("startingSequence")) {
          this.startingSequence = new MolecularSequenceRelativeStartingSequenceComponent();
          return this.startingSequence;
        }
        else if (name.equals("edit")) {
          return addEdit();
        }
        else
          return super.addChild(name);
      }

      public MolecularSequenceRelativeComponent copy() {
        MolecularSequenceRelativeComponent dst = new MolecularSequenceRelativeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequenceRelativeComponent dst) {
        super.copyValues(dst);
        dst.coordinateSystem = coordinateSystem == null ? null : coordinateSystem.copy();
        dst.ordinalPosition = ordinalPosition == null ? null : ordinalPosition.copy();
        dst.sequenceRange = sequenceRange == null ? null : sequenceRange.copy();
        dst.startingSequence = startingSequence == null ? null : startingSequence.copy();
        if (edit != null) {
          dst.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          for (MolecularSequenceRelativeEditComponent i : edit)
            dst.edit.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeComponent))
          return false;
        MolecularSequenceRelativeComponent o = (MolecularSequenceRelativeComponent) other_;
        return compareDeep(coordinateSystem, o.coordinateSystem, true) && compareDeep(ordinalPosition, o.ordinalPosition, true)
           && compareDeep(sequenceRange, o.sequenceRange, true) && compareDeep(startingSequence, o.startingSequence, true)
           && compareDeep(edit, o.edit, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeComponent))
          return false;
        MolecularSequenceRelativeComponent o = (MolecularSequenceRelativeComponent) other_;
        return compareValues(ordinalPosition, o.ordinalPosition, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(coordinateSystem, ordinalPosition
          , sequenceRange, startingSequence, edit);
      }

  public String fhirType() {
    return "MolecularSequence.relative";

  }

  }

    @Block()
    public static class MolecularSequenceRelativeStartingSequenceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The genome assembly used for starting sequence, e.g. GRCh38.
         */
        @Child(name = "genomeAssembly", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The genome assembly used for starting sequence, e.g. GRCh38", formalDefinition="The genome assembly used for starting sequence, e.g. GRCh38." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/LL1040-6/")
        protected CodeableConcept genomeAssembly;

        /**
         * Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).
         */
        @Child(name = "chromosome", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Chromosome Identifier", formalDefinition="Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340))." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/LL2938-0/")
        protected CodeableConcept chromosome;

        /**
         * The reference sequence that represents the starting sequence.
         */
        @Child(name = "sequence", type = {CodeableConcept.class, StringType.class, MolecularSequence.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The reference sequence that represents the starting sequence", formalDefinition="The reference sequence that represents the starting sequence." )
        protected DataType sequence;

        /**
         * Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.
         */
        @Child(name = "windowStart", type = {IntegerType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Start position of the window on the starting sequence", formalDefinition="Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem." )
        protected IntegerType windowStart;

        /**
         * End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.
         */
        @Child(name = "windowEnd", type = {IntegerType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="End position of the window on the starting sequence", formalDefinition="End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem." )
        protected IntegerType windowEnd;

        /**
         * A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.
         */
        @Child(name = "orientation", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="sense | antisense", formalDefinition="A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the \"sense\" strand, and the opposite complementary strand is the \"antisense\" strand." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/orientation-type")
        protected Enumeration<OrientationType> orientation;

        /**
         * An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.
         */
        @Child(name = "strand", type = {CodeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="watson | crick", formalDefinition="An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/strand-type")
        protected Enumeration<StrandType> strand;

        private static final long serialVersionUID = 502438613L;

    /**
     * Constructor
     */
      public MolecularSequenceRelativeStartingSequenceComponent() {
        super();
      }

        /**
         * @return {@link #genomeAssembly} (The genome assembly used for starting sequence, e.g. GRCh38.)
         */
        public CodeableConcept getGenomeAssembly() { 
          if (this.genomeAssembly == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.genomeAssembly");
            else if (Configuration.doAutoCreate())
              this.genomeAssembly = new CodeableConcept(); // cc
          return this.genomeAssembly;
        }

        public boolean hasGenomeAssembly() { 
          return this.genomeAssembly != null && !this.genomeAssembly.isEmpty();
        }

        /**
         * @param value {@link #genomeAssembly} (The genome assembly used for starting sequence, e.g. GRCh38.)
         */
        public MolecularSequenceRelativeStartingSequenceComponent setGenomeAssembly(CodeableConcept value) { 
          this.genomeAssembly = value;
          return this;
        }

        /**
         * @return {@link #chromosome} (Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).)
         */
        public CodeableConcept getChromosome() { 
          if (this.chromosome == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.chromosome");
            else if (Configuration.doAutoCreate())
              this.chromosome = new CodeableConcept(); // cc
          return this.chromosome;
        }

        public boolean hasChromosome() { 
          return this.chromosome != null && !this.chromosome.isEmpty();
        }

        /**
         * @param value {@link #chromosome} (Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).)
         */
        public MolecularSequenceRelativeStartingSequenceComponent setChromosome(CodeableConcept value) { 
          this.chromosome = value;
          return this;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public DataType getSequence() { 
          return this.sequence;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public CodeableConcept getSequenceCodeableConcept() throws FHIRException { 
          if (this.sequence == null)
            this.sequence = new CodeableConcept();
          if (!(this.sequence instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.sequence.getClass().getName()+" was encountered");
          return (CodeableConcept) this.sequence;
        }

        public boolean hasSequenceCodeableConcept() {
            return this.sequence instanceof CodeableConcept;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public StringType getSequenceStringType() throws FHIRException { 
          if (this.sequence == null)
            this.sequence = new StringType();
          if (!(this.sequence instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.sequence.getClass().getName()+" was encountered");
          return (StringType) this.sequence;
        }

        public boolean hasSequenceStringType() {
            return this.sequence instanceof StringType;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public Reference getSequenceReference() throws FHIRException { 
          if (this.sequence == null)
            this.sequence = new Reference();
          if (!(this.sequence instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.sequence.getClass().getName()+" was encountered");
          return (Reference) this.sequence;
        }

        public boolean hasSequenceReference() {
            return this.sequence instanceof Reference;
        }

        public boolean hasSequence() { 
          return this.sequence != null && !this.sequence.isEmpty();
        }

        /**
         * @param value {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public MolecularSequenceRelativeStartingSequenceComponent setSequence(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof StringType || value instanceof Reference))
            throw new FHIRException("Not the right type for MolecularSequence.relative.startingSequence.sequence[x]: "+value.fhirType());
          this.sequence = value;
          return this;
        }

        /**
         * @return {@link #windowStart} (Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowStart" gives direct access to the value
         */
        public IntegerType getWindowStartElement() { 
          if (this.windowStart == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.windowStart");
            else if (Configuration.doAutoCreate())
              this.windowStart = new IntegerType(); // bb
          return this.windowStart;
        }

        public boolean hasWindowStartElement() { 
          return this.windowStart != null && !this.windowStart.isEmpty();
        }

        public boolean hasWindowStart() { 
          return this.windowStart != null && !this.windowStart.isEmpty();
        }

        /**
         * @param value {@link #windowStart} (Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowStart" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowStartElement(IntegerType value) { 
          this.windowStart = value;
          return this;
        }

        /**
         * @return Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.
         */
        public int getWindowStart() { 
          return this.windowStart == null || this.windowStart.isEmpty() ? 0 : this.windowStart.getValue();
        }

        /**
         * @param value Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowStart(int value) { 
            if (this.windowStart == null)
              this.windowStart = new IntegerType();
            this.windowStart.setValue(value);
          return this;
        }

        /**
         * @return {@link #windowEnd} (End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowEnd" gives direct access to the value
         */
        public IntegerType getWindowEndElement() { 
          if (this.windowEnd == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.windowEnd");
            else if (Configuration.doAutoCreate())
              this.windowEnd = new IntegerType(); // bb
          return this.windowEnd;
        }

        public boolean hasWindowEndElement() { 
          return this.windowEnd != null && !this.windowEnd.isEmpty();
        }

        public boolean hasWindowEnd() { 
          return this.windowEnd != null && !this.windowEnd.isEmpty();
        }

        /**
         * @param value {@link #windowEnd} (End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowEnd" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowEndElement(IntegerType value) { 
          this.windowEnd = value;
          return this;
        }

        /**
         * @return End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.
         */
        public int getWindowEnd() { 
          return this.windowEnd == null || this.windowEnd.isEmpty() ? 0 : this.windowEnd.getValue();
        }

        /**
         * @param value End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowEnd(int value) { 
            if (this.windowEnd == null)
              this.windowEnd = new IntegerType();
            this.windowEnd.setValue(value);
          return this;
        }

        /**
         * @return {@link #orientation} (A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.). This is the underlying object with id, value and extensions. The accessor "getOrientation" gives direct access to the value
         */
        public Enumeration<OrientationType> getOrientationElement() { 
          if (this.orientation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.orientation");
            else if (Configuration.doAutoCreate())
              this.orientation = new Enumeration<OrientationType>(new OrientationTypeEnumFactory()); // bb
          return this.orientation;
        }

        public boolean hasOrientationElement() { 
          return this.orientation != null && !this.orientation.isEmpty();
        }

        public boolean hasOrientation() { 
          return this.orientation != null && !this.orientation.isEmpty();
        }

        /**
         * @param value {@link #orientation} (A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.). This is the underlying object with id, value and extensions. The accessor "getOrientation" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setOrientationElement(Enumeration<OrientationType> value) { 
          this.orientation = value;
          return this;
        }

        /**
         * @return A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.
         */
        public OrientationType getOrientation() { 
          return this.orientation == null ? null : this.orientation.getValue();
        }

        /**
         * @param value A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setOrientation(OrientationType value) { 
          if (value == null)
            this.orientation = null;
          else {
            if (this.orientation == null)
              this.orientation = new Enumeration<OrientationType>(new OrientationTypeEnumFactory());
            this.orientation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #strand} (An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.). This is the underlying object with id, value and extensions. The accessor "getStrand" gives direct access to the value
         */
        public Enumeration<StrandType> getStrandElement() { 
          if (this.strand == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.strand");
            else if (Configuration.doAutoCreate())
              this.strand = new Enumeration<StrandType>(new StrandTypeEnumFactory()); // bb
          return this.strand;
        }

        public boolean hasStrandElement() { 
          return this.strand != null && !this.strand.isEmpty();
        }

        public boolean hasStrand() { 
          return this.strand != null && !this.strand.isEmpty();
        }

        /**
         * @param value {@link #strand} (An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.). This is the underlying object with id, value and extensions. The accessor "getStrand" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setStrandElement(Enumeration<StrandType> value) { 
          this.strand = value;
          return this;
        }

        /**
         * @return An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.
         */
        public StrandType getStrand() { 
          return this.strand == null ? null : this.strand.getValue();
        }

        /**
         * @param value An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setStrand(StrandType value) { 
          if (value == null)
            this.strand = null;
          else {
            if (this.strand == null)
              this.strand = new Enumeration<StrandType>(new StrandTypeEnumFactory());
            this.strand.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("genomeAssembly", "CodeableConcept", "The genome assembly used for starting sequence, e.g. GRCh38.", 0, 1, genomeAssembly));
          children.add(new Property("chromosome", "CodeableConcept", "Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).", 0, 1, chromosome));
          children.add(new Property("sequence[x]", "CodeableConcept|string|Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence));
          children.add(new Property("windowStart", "integer", "Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.", 0, 1, windowStart));
          children.add(new Property("windowEnd", "integer", "End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.", 0, 1, windowEnd));
          children.add(new Property("orientation", "code", "A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the \"sense\" strand, and the opposite complementary strand is the \"antisense\" strand.", 0, 1, orientation));
          children.add(new Property("strand", "code", "An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.", 0, 1, strand));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1196021757: /*genomeAssembly*/  return new Property("genomeAssembly", "CodeableConcept", "The genome assembly used for starting sequence, e.g. GRCh38.", 0, 1, genomeAssembly);
          case -1499470472: /*chromosome*/  return new Property("chromosome", "CodeableConcept", "Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).", 0, 1, chromosome);
          case -805222113: /*sequence[x]*/  return new Property("sequence[x]", "CodeableConcept|string|Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case 1349547969: /*sequence*/  return new Property("sequence[x]", "CodeableConcept|string|Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case 1508480416: /*sequenceCodeableConcept*/  return new Property("sequence[x]", "CodeableConcept", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case -1211617486: /*sequenceString*/  return new Property("sequence[x]", "string", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case -1127149430: /*sequenceReference*/  return new Property("sequence[x]", "Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case 1903685202: /*windowStart*/  return new Property("windowStart", "integer", "Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.", 0, 1, windowStart);
          case -217026869: /*windowEnd*/  return new Property("windowEnd", "integer", "End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.", 0, 1, windowEnd);
          case -1439500848: /*orientation*/  return new Property("orientation", "code", "A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the \"sense\" strand, and the opposite complementary strand is the \"antisense\" strand.", 0, 1, orientation);
          case -891993594: /*strand*/  return new Property("strand", "code", "An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.", 0, 1, strand);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1196021757: /*genomeAssembly*/ return this.genomeAssembly == null ? new Base[0] : new Base[] {this.genomeAssembly}; // CodeableConcept
        case -1499470472: /*chromosome*/ return this.chromosome == null ? new Base[0] : new Base[] {this.chromosome}; // CodeableConcept
        case 1349547969: /*sequence*/ return this.sequence == null ? new Base[0] : new Base[] {this.sequence}; // DataType
        case 1903685202: /*windowStart*/ return this.windowStart == null ? new Base[0] : new Base[] {this.windowStart}; // IntegerType
        case -217026869: /*windowEnd*/ return this.windowEnd == null ? new Base[0] : new Base[] {this.windowEnd}; // IntegerType
        case -1439500848: /*orientation*/ return this.orientation == null ? new Base[0] : new Base[] {this.orientation}; // Enumeration<OrientationType>
        case -891993594: /*strand*/ return this.strand == null ? new Base[0] : new Base[] {this.strand}; // Enumeration<StrandType>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1196021757: // genomeAssembly
          this.genomeAssembly = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1499470472: // chromosome
          this.chromosome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1349547969: // sequence
          this.sequence = TypeConvertor.castToType(value); // DataType
          return value;
        case 1903685202: // windowStart
          this.windowStart = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -217026869: // windowEnd
          this.windowEnd = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -1439500848: // orientation
          value = new OrientationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.orientation = (Enumeration) value; // Enumeration<OrientationType>
          return value;
        case -891993594: // strand
          value = new StrandTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strand = (Enumeration) value; // Enumeration<StrandType>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("genomeAssembly")) {
          this.genomeAssembly = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("chromosome")) {
          this.chromosome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("sequence[x]")) {
          this.sequence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("windowStart")) {
          this.windowStart = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("windowEnd")) {
          this.windowEnd = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("orientation")) {
          value = new OrientationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.orientation = (Enumeration) value; // Enumeration<OrientationType>
        } else if (name.equals("strand")) {
          value = new StrandTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strand = (Enumeration) value; // Enumeration<StrandType>
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("genomeAssembly")) {
          this.genomeAssembly = null;
        } else if (name.equals("chromosome")) {
          this.chromosome = null;
        } else if (name.equals("sequence[x]")) {
          this.sequence = null;
        } else if (name.equals("windowStart")) {
          this.windowStart = null;
        } else if (name.equals("windowEnd")) {
          this.windowEnd = null;
        } else if (name.equals("orientation")) {
          value = new OrientationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.orientation = (Enumeration) value; // Enumeration<OrientationType>
        } else if (name.equals("strand")) {
          value = new StrandTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strand = (Enumeration) value; // Enumeration<StrandType>
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1196021757:  return getGenomeAssembly();
        case -1499470472:  return getChromosome();
        case -805222113:  return getSequence();
        case 1349547969:  return getSequence();
        case 1903685202:  return getWindowStartElement();
        case -217026869:  return getWindowEndElement();
        case -1439500848:  return getOrientationElement();
        case -891993594:  return getStrandElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1196021757: /*genomeAssembly*/ return new String[] {"CodeableConcept"};
        case -1499470472: /*chromosome*/ return new String[] {"CodeableConcept"};
        case 1349547969: /*sequence*/ return new String[] {"CodeableConcept", "string", "Reference"};
        case 1903685202: /*windowStart*/ return new String[] {"integer"};
        case -217026869: /*windowEnd*/ return new String[] {"integer"};
        case -1439500848: /*orientation*/ return new String[] {"code"};
        case -891993594: /*strand*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("genomeAssembly")) {
          this.genomeAssembly = new CodeableConcept();
          return this.genomeAssembly;
        }
        else if (name.equals("chromosome")) {
          this.chromosome = new CodeableConcept();
          return this.chromosome;
        }
        else if (name.equals("sequenceCodeableConcept")) {
          this.sequence = new CodeableConcept();
          return this.sequence;
        }
        else if (name.equals("sequenceString")) {
          this.sequence = new StringType();
          return this.sequence;
        }
        else if (name.equals("sequenceReference")) {
          this.sequence = new Reference();
          return this.sequence;
        }
        else if (name.equals("windowStart")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.startingSequence.windowStart");
        }
        else if (name.equals("windowEnd")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.startingSequence.windowEnd");
        }
        else if (name.equals("orientation")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.startingSequence.orientation");
        }
        else if (name.equals("strand")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.startingSequence.strand");
        }
        else
          return super.addChild(name);
      }

      public MolecularSequenceRelativeStartingSequenceComponent copy() {
        MolecularSequenceRelativeStartingSequenceComponent dst = new MolecularSequenceRelativeStartingSequenceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequenceRelativeStartingSequenceComponent dst) {
        super.copyValues(dst);
        dst.genomeAssembly = genomeAssembly == null ? null : genomeAssembly.copy();
        dst.chromosome = chromosome == null ? null : chromosome.copy();
        dst.sequence = sequence == null ? null : sequence.copy();
        dst.windowStart = windowStart == null ? null : windowStart.copy();
        dst.windowEnd = windowEnd == null ? null : windowEnd.copy();
        dst.orientation = orientation == null ? null : orientation.copy();
        dst.strand = strand == null ? null : strand.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeStartingSequenceComponent))
          return false;
        MolecularSequenceRelativeStartingSequenceComponent o = (MolecularSequenceRelativeStartingSequenceComponent) other_;
        return compareDeep(genomeAssembly, o.genomeAssembly, true) && compareDeep(chromosome, o.chromosome, true)
           && compareDeep(sequence, o.sequence, true) && compareDeep(windowStart, o.windowStart, true) && compareDeep(windowEnd, o.windowEnd, true)
           && compareDeep(orientation, o.orientation, true) && compareDeep(strand, o.strand, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeStartingSequenceComponent))
          return false;
        MolecularSequenceRelativeStartingSequenceComponent o = (MolecularSequenceRelativeStartingSequenceComponent) other_;
        return compareValues(windowStart, o.windowStart, true) && compareValues(windowEnd, o.windowEnd, true)
           && compareValues(orientation, o.orientation, true) && compareValues(strand, o.strand, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(genomeAssembly, chromosome
          , sequence, windowStart, windowEnd, orientation, strand);
      }

  public String fhirType() {
    return "MolecularSequence.relative.startingSequence";

  }

  }

    @Block()
    public static class MolecularSequenceRelativeEditComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.
         */
        @Child(name = "start", type = {IntegerType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Start position of the edit on the starting sequence", formalDefinition="Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive." )
        protected IntegerType start;

        /**
         * End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.
         */
        @Child(name = "end", type = {IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="End position of the edit on the starting sequence", formalDefinition="End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position." )
        protected IntegerType end;

        /**
         * Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        @Child(name = "replacementSequence", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Allele that was observed", formalDefinition="Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end." )
        protected StringType replacementSequence;

        /**
         * Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        @Child(name = "replacedSequence", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Allele in the starting sequence", formalDefinition="Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end." )
        protected StringType replacedSequence;

        private static final long serialVersionUID = 550127909L;

    /**
     * Constructor
     */
      public MolecularSequenceRelativeEditComponent() {
        super();
      }

        /**
         * @return {@link #start} (Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
         */
        public IntegerType getStartElement() { 
          if (this.start == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.start");
            else if (Configuration.doAutoCreate())
              this.start = new IntegerType(); // bb
          return this.start;
        }

        public boolean hasStartElement() { 
          return this.start != null && !this.start.isEmpty();
        }

        public boolean hasStart() { 
          return this.start != null && !this.start.isEmpty();
        }

        /**
         * @param value {@link #start} (Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setStartElement(IntegerType value) { 
          this.start = value;
          return this;
        }

        /**
         * @return Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.
         */
        public int getStart() { 
          return this.start == null || this.start.isEmpty() ? 0 : this.start.getValue();
        }

        /**
         * @param value Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.
         */
        public MolecularSequenceRelativeEditComponent setStart(int value) { 
            if (this.start == null)
              this.start = new IntegerType();
            this.start.setValue(value);
          return this;
        }

        /**
         * @return {@link #end} (End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
         */
        public IntegerType getEndElement() { 
          if (this.end == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.end");
            else if (Configuration.doAutoCreate())
              this.end = new IntegerType(); // bb
          return this.end;
        }

        public boolean hasEndElement() { 
          return this.end != null && !this.end.isEmpty();
        }

        public boolean hasEnd() { 
          return this.end != null && !this.end.isEmpty();
        }

        /**
         * @param value {@link #end} (End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setEndElement(IntegerType value) { 
          this.end = value;
          return this;
        }

        /**
         * @return End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.
         */
        public int getEnd() { 
          return this.end == null || this.end.isEmpty() ? 0 : this.end.getValue();
        }

        /**
         * @param value End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.
         */
        public MolecularSequenceRelativeEditComponent setEnd(int value) { 
            if (this.end == null)
              this.end = new IntegerType();
            this.end.setValue(value);
          return this;
        }

        /**
         * @return {@link #replacementSequence} (Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacementSequence" gives direct access to the value
         */
        public StringType getReplacementSequenceElement() { 
          if (this.replacementSequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.replacementSequence");
            else if (Configuration.doAutoCreate())
              this.replacementSequence = new StringType(); // bb
          return this.replacementSequence;
        }

        public boolean hasReplacementSequenceElement() { 
          return this.replacementSequence != null && !this.replacementSequence.isEmpty();
        }

        public boolean hasReplacementSequence() { 
          return this.replacementSequence != null && !this.replacementSequence.isEmpty();
        }

        /**
         * @param value {@link #replacementSequence} (Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacementSequence" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setReplacementSequenceElement(StringType value) { 
          this.replacementSequence = value;
          return this;
        }

        /**
         * @return Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public String getReplacementSequence() { 
          return this.replacementSequence == null ? null : this.replacementSequence.getValue();
        }

        /**
         * @param value Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public MolecularSequenceRelativeEditComponent setReplacementSequence(String value) { 
          if (Utilities.noString(value))
            this.replacementSequence = null;
          else {
            if (this.replacementSequence == null)
              this.replacementSequence = new StringType();
            this.replacementSequence.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #replacedSequence} (Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacedSequence" gives direct access to the value
         */
        public StringType getReplacedSequenceElement() { 
          if (this.replacedSequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.replacedSequence");
            else if (Configuration.doAutoCreate())
              this.replacedSequence = new StringType(); // bb
          return this.replacedSequence;
        }

        public boolean hasReplacedSequenceElement() { 
          return this.replacedSequence != null && !this.replacedSequence.isEmpty();
        }

        public boolean hasReplacedSequence() { 
          return this.replacedSequence != null && !this.replacedSequence.isEmpty();
        }

        /**
         * @param value {@link #replacedSequence} (Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacedSequence" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setReplacedSequenceElement(StringType value) { 
          this.replacedSequence = value;
          return this;
        }

        /**
         * @return Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public String getReplacedSequence() { 
          return this.replacedSequence == null ? null : this.replacedSequence.getValue();
        }

        /**
         * @param value Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public MolecularSequenceRelativeEditComponent setReplacedSequence(String value) { 
          if (Utilities.noString(value))
            this.replacedSequence = null;
          else {
            if (this.replacedSequence == null)
              this.replacedSequence = new StringType();
            this.replacedSequence.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("start", "integer", "Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.", 0, 1, start));
          children.add(new Property("end", "integer", "End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.", 0, 1, end));
          children.add(new Property("replacementSequence", "string", "Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacementSequence));
          children.add(new Property("replacedSequence", "string", "Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacedSequence));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 109757538: /*start*/  return new Property("start", "integer", "Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.", 0, 1, start);
          case 100571: /*end*/  return new Property("end", "integer", "End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.", 0, 1, end);
          case -1784940557: /*replacementSequence*/  return new Property("replacementSequence", "string", "Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacementSequence);
          case 1972719633: /*replacedSequence*/  return new Property("replacedSequence", "string", "Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacedSequence);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 109757538: /*start*/ return this.start == null ? new Base[0] : new Base[] {this.start}; // IntegerType
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // IntegerType
        case -1784940557: /*replacementSequence*/ return this.replacementSequence == null ? new Base[0] : new Base[] {this.replacementSequence}; // StringType
        case 1972719633: /*replacedSequence*/ return this.replacedSequence == null ? new Base[0] : new Base[] {this.replacedSequence}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 109757538: // start
          this.start = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 100571: // end
          this.end = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -1784940557: // replacementSequence
          this.replacementSequence = TypeConvertor.castToString(value); // StringType
          return value;
        case 1972719633: // replacedSequence
          this.replacedSequence = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("start")) {
          this.start = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("replacementSequence")) {
          this.replacementSequence = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("replacedSequence")) {
          this.replacedSequence = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("start")) {
          this.start = null;
        } else if (name.equals("end")) {
          this.end = null;
        } else if (name.equals("replacementSequence")) {
          this.replacementSequence = null;
        } else if (name.equals("replacedSequence")) {
          this.replacedSequence = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109757538:  return getStartElement();
        case 100571:  return getEndElement();
        case -1784940557:  return getReplacementSequenceElement();
        case 1972719633:  return getReplacedSequenceElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109757538: /*start*/ return new String[] {"integer"};
        case 100571: /*end*/ return new String[] {"integer"};
        case -1784940557: /*replacementSequence*/ return new String[] {"string"};
        case 1972719633: /*replacedSequence*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("start")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.edit.start");
        }
        else if (name.equals("end")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.edit.end");
        }
        else if (name.equals("replacementSequence")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.edit.replacementSequence");
        }
        else if (name.equals("replacedSequence")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.relative.edit.replacedSequence");
        }
        else
          return super.addChild(name);
      }

      public MolecularSequenceRelativeEditComponent copy() {
        MolecularSequenceRelativeEditComponent dst = new MolecularSequenceRelativeEditComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequenceRelativeEditComponent dst) {
        super.copyValues(dst);
        dst.start = start == null ? null : start.copy();
        dst.end = end == null ? null : end.copy();
        dst.replacementSequence = replacementSequence == null ? null : replacementSequence.copy();
        dst.replacedSequence = replacedSequence == null ? null : replacedSequence.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeEditComponent))
          return false;
        MolecularSequenceRelativeEditComponent o = (MolecularSequenceRelativeEditComponent) other_;
        return compareDeep(start, o.start, true) && compareDeep(end, o.end, true) && compareDeep(replacementSequence, o.replacementSequence, true)
           && compareDeep(replacedSequence, o.replacedSequence, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeEditComponent))
          return false;
        MolecularSequenceRelativeEditComponent o = (MolecularSequenceRelativeEditComponent) other_;
        return compareValues(start, o.start, true) && compareValues(end, o.end, true) && compareValues(replacementSequence, o.replacementSequence, true)
           && compareValues(replacedSequence, o.replacedSequence, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(start, end, replacementSequence
          , replacedSequence);
      }

  public String fhirType() {
    return "MolecularSequence.relative.edit";

  }

  }

    /**
     * A unique identifier for this particular sequence instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique ID for this particular sequence", formalDefinition="A unique identifier for this particular sequence instance." )
    protected List<Identifier> identifier;

    /**
     * Amino Acid Sequence/ DNA Sequence / RNA Sequence.
     */
    @Child(name = "type", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="aa | dna | rna", formalDefinition="Amino Acid Sequence/ DNA Sequence / RNA Sequence." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/sequence-type")
    protected Enumeration<SequenceType> type;

    /**
     * Indicates the subject this sequence is associated too.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Substance.class, BiologicallyDerivedProduct.class, NutritionProduct.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Subject this sequence is associated too", formalDefinition="Indicates the subject this sequence is associated too." )
    protected Reference subject;

    /**
     * The actual focus of a molecular sequence when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, child, or sibling. For example, in trio testing, the subject would be the child (proband) and the focus would be the parent.
     */
    @Child(name = "focus", type = {Reference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What the molecular sequence is about, when it is not about the subject of record", formalDefinition="The actual focus of a molecular sequence when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, child, or sibling. For example, in trio testing, the subject would be the child (proband) and the focus would be the parent." )
    protected List<Reference> focus;

    /**
     * Specimen used for sequencing.
     */
    @Child(name = "specimen", type = {Specimen.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specimen used for sequencing", formalDefinition="Specimen used for sequencing." )
    protected Reference specimen;

    /**
     * The method for sequencing, for example, chip information.
     */
    @Child(name = "device", type = {Device.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The method for sequencing", formalDefinition="The method for sequencing, for example, chip information." )
    protected Reference device;

    /**
     * The organization or lab that should be responsible for this result.
     */
    @Child(name = "performer", type = {Organization.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who should be responsible for test result", formalDefinition="The organization or lab that should be responsible for this result." )
    protected Reference performer;

    /**
     * Sequence that was observed.
     */
    @Child(name = "literal", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Sequence that was observed", formalDefinition="Sequence that was observed." )
    protected StringType literal;

    /**
     * Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.
     */
    @Child(name = "formatted", type = {Attachment.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Embedded file or a link (URL) which contains content to represent the sequence", formalDefinition="Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system." )
    protected List<Attachment> formatted;

    /**
     * A sequence defined relative to another sequence.
     */
    @Child(name = "relative", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A sequence defined relative to another sequence", formalDefinition="A sequence defined relative to another sequence." )
    protected List<MolecularSequenceRelativeComponent> relative;

    private static final long serialVersionUID = 611205496L;

  /**
   * Constructor
   */
    public MolecularSequence() {
      super();
    }

    /**
     * @return {@link #identifier} (A unique identifier for this particular sequence instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MolecularSequence setIdentifier(List<Identifier> theIdentifier) { 
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

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public MolecularSequence addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #type} (Amino Acid Sequence/ DNA Sequence / RNA Sequence.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<SequenceType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<SequenceType>(new SequenceTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Amino Acid Sequence/ DNA Sequence / RNA Sequence.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public MolecularSequence setTypeElement(Enumeration<SequenceType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return Amino Acid Sequence/ DNA Sequence / RNA Sequence.
     */
    public SequenceType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value Amino Acid Sequence/ DNA Sequence / RNA Sequence.
     */
    public MolecularSequence setType(SequenceType value) { 
      if (value == null)
        this.type = null;
      else {
        if (this.type == null)
          this.type = new Enumeration<SequenceType>(new SequenceTypeEnumFactory());
        this.type.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subject} (Indicates the subject this sequence is associated too.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Indicates the subject this sequence is associated too.)
     */
    public MolecularSequence setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #focus} (The actual focus of a molecular sequence when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, child, or sibling. For example, in trio testing, the subject would be the child (proband) and the focus would be the parent.)
     */
    public List<Reference> getFocus() { 
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      return this.focus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MolecularSequence setFocus(List<Reference> theFocus) { 
      this.focus = theFocus;
      return this;
    }

    public boolean hasFocus() { 
      if (this.focus == null)
        return false;
      for (Reference item : this.focus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addFocus() { //3
      Reference t = new Reference();
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      this.focus.add(t);
      return t;
    }

    public MolecularSequence addFocus(Reference t) { //3
      if (t == null)
        return this;
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      this.focus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #focus}, creating it if it does not already exist {3}
     */
    public Reference getFocusFirstRep() { 
      if (getFocus().isEmpty()) {
        addFocus();
      }
      return getFocus().get(0);
    }

    /**
     * @return {@link #specimen} (Specimen used for sequencing.)
     */
    public Reference getSpecimen() { 
      if (this.specimen == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.specimen");
        else if (Configuration.doAutoCreate())
          this.specimen = new Reference(); // cc
      return this.specimen;
    }

    public boolean hasSpecimen() { 
      return this.specimen != null && !this.specimen.isEmpty();
    }

    /**
     * @param value {@link #specimen} (Specimen used for sequencing.)
     */
    public MolecularSequence setSpecimen(Reference value) { 
      this.specimen = value;
      return this;
    }

    /**
     * @return {@link #device} (The method for sequencing, for example, chip information.)
     */
    public Reference getDevice() { 
      if (this.device == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.device");
        else if (Configuration.doAutoCreate())
          this.device = new Reference(); // cc
      return this.device;
    }

    public boolean hasDevice() { 
      return this.device != null && !this.device.isEmpty();
    }

    /**
     * @param value {@link #device} (The method for sequencing, for example, chip information.)
     */
    public MolecularSequence setDevice(Reference value) { 
      this.device = value;
      return this;
    }

    /**
     * @return {@link #performer} (The organization or lab that should be responsible for this result.)
     */
    public Reference getPerformer() { 
      if (this.performer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.performer");
        else if (Configuration.doAutoCreate())
          this.performer = new Reference(); // cc
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (The organization or lab that should be responsible for this result.)
     */
    public MolecularSequence setPerformer(Reference value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #literal} (Sequence that was observed.). This is the underlying object with id, value and extensions. The accessor "getLiteral" gives direct access to the value
     */
    public StringType getLiteralElement() { 
      if (this.literal == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.literal");
        else if (Configuration.doAutoCreate())
          this.literal = new StringType(); // bb
      return this.literal;
    }

    public boolean hasLiteralElement() { 
      return this.literal != null && !this.literal.isEmpty();
    }

    public boolean hasLiteral() { 
      return this.literal != null && !this.literal.isEmpty();
    }

    /**
     * @param value {@link #literal} (Sequence that was observed.). This is the underlying object with id, value and extensions. The accessor "getLiteral" gives direct access to the value
     */
    public MolecularSequence setLiteralElement(StringType value) { 
      this.literal = value;
      return this;
    }

    /**
     * @return Sequence that was observed.
     */
    public String getLiteral() { 
      return this.literal == null ? null : this.literal.getValue();
    }

    /**
     * @param value Sequence that was observed.
     */
    public MolecularSequence setLiteral(String value) { 
      if (Utilities.noString(value))
        this.literal = null;
      else {
        if (this.literal == null)
          this.literal = new StringType();
        this.literal.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #formatted} (Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.)
     */
    public List<Attachment> getFormatted() { 
      if (this.formatted == null)
        this.formatted = new ArrayList<Attachment>();
      return this.formatted;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MolecularSequence setFormatted(List<Attachment> theFormatted) { 
      this.formatted = theFormatted;
      return this;
    }

    public boolean hasFormatted() { 
      if (this.formatted == null)
        return false;
      for (Attachment item : this.formatted)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Attachment addFormatted() { //3
      Attachment t = new Attachment();
      if (this.formatted == null)
        this.formatted = new ArrayList<Attachment>();
      this.formatted.add(t);
      return t;
    }

    public MolecularSequence addFormatted(Attachment t) { //3
      if (t == null)
        return this;
      if (this.formatted == null)
        this.formatted = new ArrayList<Attachment>();
      this.formatted.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #formatted}, creating it if it does not already exist {3}
     */
    public Attachment getFormattedFirstRep() { 
      if (getFormatted().isEmpty()) {
        addFormatted();
      }
      return getFormatted().get(0);
    }

    /**
     * @return {@link #relative} (A sequence defined relative to another sequence.)
     */
    public List<MolecularSequenceRelativeComponent> getRelative() { 
      if (this.relative == null)
        this.relative = new ArrayList<MolecularSequenceRelativeComponent>();
      return this.relative;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MolecularSequence setRelative(List<MolecularSequenceRelativeComponent> theRelative) { 
      this.relative = theRelative;
      return this;
    }

    public boolean hasRelative() { 
      if (this.relative == null)
        return false;
      for (MolecularSequenceRelativeComponent item : this.relative)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MolecularSequenceRelativeComponent addRelative() { //3
      MolecularSequenceRelativeComponent t = new MolecularSequenceRelativeComponent();
      if (this.relative == null)
        this.relative = new ArrayList<MolecularSequenceRelativeComponent>();
      this.relative.add(t);
      return t;
    }

    public MolecularSequence addRelative(MolecularSequenceRelativeComponent t) { //3
      if (t == null)
        return this;
      if (this.relative == null)
        this.relative = new ArrayList<MolecularSequenceRelativeComponent>();
      this.relative.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relative}, creating it if it does not already exist {3}
     */
    public MolecularSequenceRelativeComponent getRelativeFirstRep() { 
      if (getRelative().isEmpty()) {
        addRelative();
      }
      return getRelative().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier for this particular sequence instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("type", "code", "Amino Acid Sequence/ DNA Sequence / RNA Sequence.", 0, 1, type));
        children.add(new Property("subject", "Reference(Patient|Group|Substance|BiologicallyDerivedProduct|NutritionProduct)", "Indicates the subject this sequence is associated too.", 0, 1, subject));
        children.add(new Property("focus", "Reference(Any)", "The actual focus of a molecular sequence when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, child, or sibling. For example, in trio testing, the subject would be the child (proband) and the focus would be the parent.", 0, java.lang.Integer.MAX_VALUE, focus));
        children.add(new Property("specimen", "Reference(Specimen)", "Specimen used for sequencing.", 0, 1, specimen));
        children.add(new Property("device", "Reference(Device)", "The method for sequencing, for example, chip information.", 0, 1, device));
        children.add(new Property("performer", "Reference(Organization)", "The organization or lab that should be responsible for this result.", 0, 1, performer));
        children.add(new Property("literal", "string", "Sequence that was observed.", 0, 1, literal));
        children.add(new Property("formatted", "Attachment", "Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.", 0, java.lang.Integer.MAX_VALUE, formatted));
        children.add(new Property("relative", "", "A sequence defined relative to another sequence.", 0, java.lang.Integer.MAX_VALUE, relative));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier for this particular sequence instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3575610: /*type*/  return new Property("type", "code", "Amino Acid Sequence/ DNA Sequence / RNA Sequence.", 0, 1, type);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Substance|BiologicallyDerivedProduct|NutritionProduct)", "Indicates the subject this sequence is associated too.", 0, 1, subject);
        case 97604824: /*focus*/  return new Property("focus", "Reference(Any)", "The actual focus of a molecular sequence when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, child, or sibling. For example, in trio testing, the subject would be the child (proband) and the focus would be the parent.", 0, java.lang.Integer.MAX_VALUE, focus);
        case -2132868344: /*specimen*/  return new Property("specimen", "Reference(Specimen)", "Specimen used for sequencing.", 0, 1, specimen);
        case -1335157162: /*device*/  return new Property("device", "Reference(Device)", "The method for sequencing, for example, chip information.", 0, 1, device);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Organization)", "The organization or lab that should be responsible for this result.", 0, 1, performer);
        case 182460591: /*literal*/  return new Property("literal", "string", "Sequence that was observed.", 0, 1, literal);
        case 1811591356: /*formatted*/  return new Property("formatted", "Attachment", "Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.", 0, java.lang.Integer.MAX_VALUE, formatted);
        case -554435892: /*relative*/  return new Property("relative", "", "A sequence defined relative to another sequence.", 0, java.lang.Integer.MAX_VALUE, relative);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<SequenceType>
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 97604824: /*focus*/ return this.focus == null ? new Base[0] : this.focus.toArray(new Base[this.focus.size()]); // Reference
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : new Base[] {this.specimen}; // Reference
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // Reference
        case 182460591: /*literal*/ return this.literal == null ? new Base[0] : new Base[] {this.literal}; // StringType
        case 1811591356: /*formatted*/ return this.formatted == null ? new Base[0] : this.formatted.toArray(new Base[this.formatted.size()]); // Attachment
        case -554435892: /*relative*/ return this.relative == null ? new Base[0] : this.relative.toArray(new Base[this.relative.size()]); // MolecularSequenceRelativeComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3575610: // type
          value = new SequenceTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SequenceType>
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 97604824: // focus
          this.getFocus().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -2132868344: // specimen
          this.specimen = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case 481140686: // performer
          this.performer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 182460591: // literal
          this.literal = TypeConvertor.castToString(value); // StringType
          return value;
        case 1811591356: // formatted
          this.getFormatted().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        case -554435892: // relative
          this.getRelative().add((MolecularSequenceRelativeComponent) value); // MolecularSequenceRelativeComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("type")) {
          value = new SequenceTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SequenceType>
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("focus")) {
          this.getFocus().add(TypeConvertor.castToReference(value));
        } else if (name.equals("specimen")) {
          this.specimen = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("performer")) {
          this.performer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("literal")) {
          this.literal = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("formatted")) {
          this.getFormatted().add(TypeConvertor.castToAttachment(value));
        } else if (name.equals("relative")) {
          this.getRelative().add((MolecularSequenceRelativeComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("type")) {
          value = new SequenceTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SequenceType>
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("focus")) {
          this.getFocus().remove(value);
        } else if (name.equals("specimen")) {
          this.specimen = null;
        } else if (name.equals("device")) {
          this.device = null;
        } else if (name.equals("performer")) {
          this.performer = null;
        } else if (name.equals("literal")) {
          this.literal = null;
        } else if (name.equals("formatted")) {
          this.getFormatted().remove(value);
        } else if (name.equals("relative")) {
          this.getRelative().remove((MolecularSequenceRelativeComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getTypeElement();
        case -1867885268:  return getSubject();
        case 97604824:  return addFocus(); 
        case -2132868344:  return getSpecimen();
        case -1335157162:  return getDevice();
        case 481140686:  return getPerformer();
        case 182460591:  return getLiteralElement();
        case 1811591356:  return addFormatted(); 
        case -554435892:  return addRelative(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 97604824: /*focus*/ return new String[] {"Reference"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case 182460591: /*literal*/ return new String[] {"string"};
        case 1811591356: /*formatted*/ return new String[] {"Attachment"};
        case -554435892: /*relative*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.type");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("focus")) {
          return addFocus();
        }
        else if (name.equals("specimen")) {
          this.specimen = new Reference();
          return this.specimen;
        }
        else if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("performer")) {
          this.performer = new Reference();
          return this.performer;
        }
        else if (name.equals("literal")) {
          throw new FHIRException("Cannot call addChild on a singleton property MolecularSequence.literal");
        }
        else if (name.equals("formatted")) {
          return addFormatted();
        }
        else if (name.equals("relative")) {
          return addRelative();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MolecularSequence";

  }

      public MolecularSequence copy() {
        MolecularSequence dst = new MolecularSequence();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequence dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.subject = subject == null ? null : subject.copy();
        if (focus != null) {
          dst.focus = new ArrayList<Reference>();
          for (Reference i : focus)
            dst.focus.add(i.copy());
        };
        dst.specimen = specimen == null ? null : specimen.copy();
        dst.device = device == null ? null : device.copy();
        dst.performer = performer == null ? null : performer.copy();
        dst.literal = literal == null ? null : literal.copy();
        if (formatted != null) {
          dst.formatted = new ArrayList<Attachment>();
          for (Attachment i : formatted)
            dst.formatted.add(i.copy());
        };
        if (relative != null) {
          dst.relative = new ArrayList<MolecularSequenceRelativeComponent>();
          for (MolecularSequenceRelativeComponent i : relative)
            dst.relative.add(i.copy());
        };
      }

      protected MolecularSequence typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequence))
          return false;
        MolecularSequence o = (MolecularSequence) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(subject, o.subject, true)
           && compareDeep(focus, o.focus, true) && compareDeep(specimen, o.specimen, true) && compareDeep(device, o.device, true)
           && compareDeep(performer, o.performer, true) && compareDeep(literal, o.literal, true) && compareDeep(formatted, o.formatted, true)
           && compareDeep(relative, o.relative, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequence))
          return false;
        MolecularSequence o = (MolecularSequence) other_;
        return compareValues(type, o.type, true) && compareValues(literal, o.literal, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, subject
          , focus, specimen, device, performer, literal, formatted, relative);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MolecularSequence;
   }

 /**
   * Search parameter: <b>focus</b>
   * <p>
   * Description: <b>What the molecular sequence is about, when it is not about the subject of record</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.focus</b><br>
   * </p>
   */
  @SearchParamDefinition(name="focus", path="MolecularSequence.focus", description="What the molecular sequence is about, when it is not about the subject of record", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_FOCUS = "focus";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>focus</b>
   * <p>
   * Description: <b>What the molecular sequence is about, when it is not about the subject of record</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.focus</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam FOCUS = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_FOCUS);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MolecularSequence:focus</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_FOCUS = new ca.uhn.fhir.model.api.Include("MolecularSequence:focus").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The subject that the sequence is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="MolecularSequence.subject", description="The subject that the sequence is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Group.class, NutritionProduct.class, Patient.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The subject that the sequence is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MolecularSequence:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("MolecularSequence:subject").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MolecularSequence:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("MolecularSequence:patient").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type", description="Multiple Resources: \r\n\r\n* [Account](account.html): E.g. patient, expense, depreciation\r\n* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)\r\n* [Composition](composition.html): Kind of composition (LOINC if possible)\r\n* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)\r\n* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)\r\n* [Encounter](encounter.html): Specific type of encounter\r\n* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management\r\n* [Invoice](invoice.html): Type of Invoice\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type\r\n* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence\r\n* [Specimen](specimen.html): The specimen type\r\n", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

