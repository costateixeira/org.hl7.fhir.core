package org.hl7.fhir.r5.openehr;


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
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Abstract concept of a proxy description of a party, including an optional link to data for this party in a demographic or other identity management system. Sub- typed into PARTY_IDENTIFIED and PARTY_SELF.
 */
@DatatypeDef(name="PARTY_PROXY")
public abstract class PARTY_PROXY extends LogicalBase implements ICompositeType {

    /**
     * Optional reference to more detailed demographic or identification information for this party, in an external system.
     */
    @Child(name = "external_ref", type = {PARTY_REF.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to more detailed demographic or identification information for this party", formalDefinition="Optional reference to more detailed demographic or identification information for this party, in an external system." )
    protected PARTY_REF external_ref;

    private static final long serialVersionUID = 1726641665L;

  /**
   * Constructor
   */
    public PARTY_PROXY() {
      super();
    }

    /**
     * @return {@link #external_ref} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public PARTY_REF getExternal_ref() { 
      if (this.external_ref == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTY_PROXY.external_ref");
        else if (Configuration.doAutoCreate())
          this.external_ref = new PARTY_REF(); // cc
      return this.external_ref;
    }

    public boolean hasExternal_ref() { 
      return this.external_ref != null && !this.external_ref.isEmpty();
    }

    /**
     * @param value {@link #external_ref} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public PARTY_PROXY setExternal_ref(PARTY_REF value) { 
      this.external_ref = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("external_ref", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, external_ref));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1385599457: /*external_ref*/  return new Property("external_ref", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, external_ref);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1385599457: /*external_ref*/ return this.external_ref == null ? new Base[0] : new Base[] {this.external_ref}; // PARTY_REF
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1385599457: // external_ref
          this.external_ref = (PARTY_REF) value; // PARTY_REF
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("external_ref")) {
          this.external_ref = (PARTY_REF) value; // PARTY_REF
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1385599457:  return getExternal_ref();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1385599457: /*external_ref*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-REF"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("external_ref")) {
          this.external_ref = new PARTY_REF();
          return this.external_ref;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PARTY_PROXY";

  }

      public abstract PARTY_PROXY copy();

      public void copyValues(PARTY_PROXY dst) {
        super.copyValues(dst);
        dst.external_ref = external_ref == null ? null : external_ref.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PARTY_PROXY))
          return false;
        PARTY_PROXY o = (PARTY_PROXY) other_;
        return compareDeep(external_ref, o.external_ref, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PARTY_PROXY))
          return false;
        PARTY_PROXY o = (PARTY_PROXY) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(external_ref);
      }


}

