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

import org.hl7.fhir.instance.model.api.IBaseConformance;
/**
 * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
 */
@ResourceDef(name="CapabilityStatement", profile="http://hl7.org/fhir/StructureDefinition/CapabilityStatement")
public class CapabilityStatement extends CanonicalResource implements IBaseConformance {

    public enum ConditionalDeleteStatus {
        /**
         * No support for conditional deletes.
         */
        NOTSUPPORTED, 
        /**
         * Conditional deletes are supported, but only single resources at a time.
         */
        SINGLE, 
        /**
         * Conditional deletes are supported, and multiple resources can be deleted in a single interaction.
         */
        MULTIPLE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConditionalDeleteStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("not-supported".equals(codeString))
          return NOTSUPPORTED;
        if ("single".equals(codeString))
          return SINGLE;
        if ("multiple".equals(codeString))
          return MULTIPLE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConditionalDeleteStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case NOTSUPPORTED: return "not-supported";
            case SINGLE: return "single";
            case MULTIPLE: return "multiple";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case NOTSUPPORTED: return "http://hl7.org/fhir/conditional-delete-status";
            case SINGLE: return "http://hl7.org/fhir/conditional-delete-status";
            case MULTIPLE: return "http://hl7.org/fhir/conditional-delete-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case NOTSUPPORTED: return "No support for conditional deletes.";
            case SINGLE: return "Conditional deletes are supported, but only single resources at a time.";
            case MULTIPLE: return "Conditional deletes are supported, and multiple resources can be deleted in a single interaction.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case NOTSUPPORTED: return "Not Supported";
            case SINGLE: return "Single Deletes Supported";
            case MULTIPLE: return "Multiple Deletes Supported";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConditionalDeleteStatusEnumFactory implements EnumFactory<ConditionalDeleteStatus> {
    public ConditionalDeleteStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("not-supported".equals(codeString))
          return ConditionalDeleteStatus.NOTSUPPORTED;
        if ("single".equals(codeString))
          return ConditionalDeleteStatus.SINGLE;
        if ("multiple".equals(codeString))
          return ConditionalDeleteStatus.MULTIPLE;
        throw new IllegalArgumentException("Unknown ConditionalDeleteStatus code '"+codeString+"'");
        }
        public Enumeration<ConditionalDeleteStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConditionalDeleteStatus>(this, ConditionalDeleteStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ConditionalDeleteStatus>(this, ConditionalDeleteStatus.NULL, code);
        if ("not-supported".equals(codeString))
          return new Enumeration<ConditionalDeleteStatus>(this, ConditionalDeleteStatus.NOTSUPPORTED, code);
        if ("single".equals(codeString))
          return new Enumeration<ConditionalDeleteStatus>(this, ConditionalDeleteStatus.SINGLE, code);
        if ("multiple".equals(codeString))
          return new Enumeration<ConditionalDeleteStatus>(this, ConditionalDeleteStatus.MULTIPLE, code);
        throw new FHIRException("Unknown ConditionalDeleteStatus code '"+codeString+"'");
        }
    public String toCode(ConditionalDeleteStatus code) {
       if (code == ConditionalDeleteStatus.NULL)
           return null;
       if (code == ConditionalDeleteStatus.NOTSUPPORTED)
        return "not-supported";
      if (code == ConditionalDeleteStatus.SINGLE)
        return "single";
      if (code == ConditionalDeleteStatus.MULTIPLE)
        return "multiple";
      return "?";
   }
    public String toSystem(ConditionalDeleteStatus code) {
      return code.getSystem();
      }
    }

    public enum ConditionalReadStatus {
        /**
         * No support for conditional reads.
         */
        NOTSUPPORTED, 
        /**
         * Conditional reads are supported, but only with the If-Modified-Since HTTP Header.
         */
        MODIFIEDSINCE, 
        /**
         * Conditional reads are supported, but only with the If-None-Match HTTP Header.
         */
        NOTMATCH, 
        /**
         * Conditional reads are supported, with both If-Modified-Since and If-None-Match HTTP Headers.
         */
        FULLSUPPORT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConditionalReadStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("not-supported".equals(codeString))
          return NOTSUPPORTED;
        if ("modified-since".equals(codeString))
          return MODIFIEDSINCE;
        if ("not-match".equals(codeString))
          return NOTMATCH;
        if ("full-support".equals(codeString))
          return FULLSUPPORT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConditionalReadStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case NOTSUPPORTED: return "not-supported";
            case MODIFIEDSINCE: return "modified-since";
            case NOTMATCH: return "not-match";
            case FULLSUPPORT: return "full-support";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case NOTSUPPORTED: return "http://hl7.org/fhir/conditional-read-status";
            case MODIFIEDSINCE: return "http://hl7.org/fhir/conditional-read-status";
            case NOTMATCH: return "http://hl7.org/fhir/conditional-read-status";
            case FULLSUPPORT: return "http://hl7.org/fhir/conditional-read-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case NOTSUPPORTED: return "No support for conditional reads.";
            case MODIFIEDSINCE: return "Conditional reads are supported, but only with the If-Modified-Since HTTP Header.";
            case NOTMATCH: return "Conditional reads are supported, but only with the If-None-Match HTTP Header.";
            case FULLSUPPORT: return "Conditional reads are supported, with both If-Modified-Since and If-None-Match HTTP Headers.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case NOTSUPPORTED: return "Not Supported";
            case MODIFIEDSINCE: return "If-Modified-Since";
            case NOTMATCH: return "If-None-Match";
            case FULLSUPPORT: return "Full Support";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConditionalReadStatusEnumFactory implements EnumFactory<ConditionalReadStatus> {
    public ConditionalReadStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("not-supported".equals(codeString))
          return ConditionalReadStatus.NOTSUPPORTED;
        if ("modified-since".equals(codeString))
          return ConditionalReadStatus.MODIFIEDSINCE;
        if ("not-match".equals(codeString))
          return ConditionalReadStatus.NOTMATCH;
        if ("full-support".equals(codeString))
          return ConditionalReadStatus.FULLSUPPORT;
        throw new IllegalArgumentException("Unknown ConditionalReadStatus code '"+codeString+"'");
        }
        public Enumeration<ConditionalReadStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConditionalReadStatus>(this, ConditionalReadStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ConditionalReadStatus>(this, ConditionalReadStatus.NULL, code);
        if ("not-supported".equals(codeString))
          return new Enumeration<ConditionalReadStatus>(this, ConditionalReadStatus.NOTSUPPORTED, code);
        if ("modified-since".equals(codeString))
          return new Enumeration<ConditionalReadStatus>(this, ConditionalReadStatus.MODIFIEDSINCE, code);
        if ("not-match".equals(codeString))
          return new Enumeration<ConditionalReadStatus>(this, ConditionalReadStatus.NOTMATCH, code);
        if ("full-support".equals(codeString))
          return new Enumeration<ConditionalReadStatus>(this, ConditionalReadStatus.FULLSUPPORT, code);
        throw new FHIRException("Unknown ConditionalReadStatus code '"+codeString+"'");
        }
    public String toCode(ConditionalReadStatus code) {
       if (code == ConditionalReadStatus.NULL)
           return null;
       if (code == ConditionalReadStatus.NOTSUPPORTED)
        return "not-supported";
      if (code == ConditionalReadStatus.MODIFIEDSINCE)
        return "modified-since";
      if (code == ConditionalReadStatus.NOTMATCH)
        return "not-match";
      if (code == ConditionalReadStatus.FULLSUPPORT)
        return "full-support";
      return "?";
   }
    public String toSystem(ConditionalReadStatus code) {
      return code.getSystem();
      }
    }

    public enum DocumentMode {
        /**
         * The application produces documents of the specified type.
         */
        PRODUCER, 
        /**
         * The application consumes documents of the specified type.
         */
        CONSUMER, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DocumentMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("producer".equals(codeString))
          return PRODUCER;
        if ("consumer".equals(codeString))
          return CONSUMER;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DocumentMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PRODUCER: return "producer";
            case CONSUMER: return "consumer";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PRODUCER: return "http://hl7.org/fhir/document-mode";
            case CONSUMER: return "http://hl7.org/fhir/document-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PRODUCER: return "The application produces documents of the specified type.";
            case CONSUMER: return "The application consumes documents of the specified type.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PRODUCER: return "Producer";
            case CONSUMER: return "Consumer";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DocumentModeEnumFactory implements EnumFactory<DocumentMode> {
    public DocumentMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("producer".equals(codeString))
          return DocumentMode.PRODUCER;
        if ("consumer".equals(codeString))
          return DocumentMode.CONSUMER;
        throw new IllegalArgumentException("Unknown DocumentMode code '"+codeString+"'");
        }
        public Enumeration<DocumentMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DocumentMode>(this, DocumentMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<DocumentMode>(this, DocumentMode.NULL, code);
        if ("producer".equals(codeString))
          return new Enumeration<DocumentMode>(this, DocumentMode.PRODUCER, code);
        if ("consumer".equals(codeString))
          return new Enumeration<DocumentMode>(this, DocumentMode.CONSUMER, code);
        throw new FHIRException("Unknown DocumentMode code '"+codeString+"'");
        }
    public String toCode(DocumentMode code) {
       if (code == DocumentMode.NULL)
           return null;
       if (code == DocumentMode.PRODUCER)
        return "producer";
      if (code == DocumentMode.CONSUMER)
        return "consumer";
      return "?";
   }
    public String toSystem(DocumentMode code) {
      return code.getSystem();
      }
    }

    public enum EventCapabilityMode {
        /**
         * The application sends requests and receives responses.
         */
        SENDER, 
        /**
         * The application receives requests and sends responses.
         */
        RECEIVER, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EventCapabilityMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sender".equals(codeString))
          return SENDER;
        if ("receiver".equals(codeString))
          return RECEIVER;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EventCapabilityMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SENDER: return "sender";
            case RECEIVER: return "receiver";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SENDER: return "http://hl7.org/fhir/event-capability-mode";
            case RECEIVER: return "http://hl7.org/fhir/event-capability-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SENDER: return "The application sends requests and receives responses.";
            case RECEIVER: return "The application receives requests and sends responses.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SENDER: return "Sender";
            case RECEIVER: return "Receiver";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EventCapabilityModeEnumFactory implements EnumFactory<EventCapabilityMode> {
    public EventCapabilityMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sender".equals(codeString))
          return EventCapabilityMode.SENDER;
        if ("receiver".equals(codeString))
          return EventCapabilityMode.RECEIVER;
        throw new IllegalArgumentException("Unknown EventCapabilityMode code '"+codeString+"'");
        }
        public Enumeration<EventCapabilityMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EventCapabilityMode>(this, EventCapabilityMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<EventCapabilityMode>(this, EventCapabilityMode.NULL, code);
        if ("sender".equals(codeString))
          return new Enumeration<EventCapabilityMode>(this, EventCapabilityMode.SENDER, code);
        if ("receiver".equals(codeString))
          return new Enumeration<EventCapabilityMode>(this, EventCapabilityMode.RECEIVER, code);
        throw new FHIRException("Unknown EventCapabilityMode code '"+codeString+"'");
        }
    public String toCode(EventCapabilityMode code) {
       if (code == EventCapabilityMode.NULL)
           return null;
       if (code == EventCapabilityMode.SENDER)
        return "sender";
      if (code == EventCapabilityMode.RECEIVER)
        return "receiver";
      return "?";
   }
    public String toSystem(EventCapabilityMode code) {
      return code.getSystem();
      }
    }

    public enum ReferenceHandlingPolicy {
        /**
         * The server supports and populates Literal references (i.e. using Reference.reference) where they are known (this code does not guarantee that all references are literal; see 'enforced').
         */
        LITERAL, 
        /**
         * The server allows logical references (i.e. using Reference.identifier).
         */
        LOGICAL, 
        /**
         * The server will attempt to resolve logical references to literal references - i.e. converting Reference.identifier to Reference.reference (if resolution fails, the server may still accept resources; see logical).
         */
        RESOLVES, 
        /**
         * The server enforces that references have integrity - e.g. it ensures that references can always be resolved. This is typically the case for clinical record systems, but often not the case for middleware/proxy systems.
         */
        ENFORCED, 
        /**
         * The server does not support references that point to other servers.
         */
        LOCAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ReferenceHandlingPolicy fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("literal".equals(codeString))
          return LITERAL;
        if ("logical".equals(codeString))
          return LOGICAL;
        if ("resolves".equals(codeString))
          return RESOLVES;
        if ("enforced".equals(codeString))
          return ENFORCED;
        if ("local".equals(codeString))
          return LOCAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ReferenceHandlingPolicy code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case LITERAL: return "literal";
            case LOGICAL: return "logical";
            case RESOLVES: return "resolves";
            case ENFORCED: return "enforced";
            case LOCAL: return "local";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case LITERAL: return "http://hl7.org/fhir/reference-handling-policy";
            case LOGICAL: return "http://hl7.org/fhir/reference-handling-policy";
            case RESOLVES: return "http://hl7.org/fhir/reference-handling-policy";
            case ENFORCED: return "http://hl7.org/fhir/reference-handling-policy";
            case LOCAL: return "http://hl7.org/fhir/reference-handling-policy";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case LITERAL: return "The server supports and populates Literal references (i.e. using Reference.reference) where they are known (this code does not guarantee that all references are literal; see 'enforced').";
            case LOGICAL: return "The server allows logical references (i.e. using Reference.identifier).";
            case RESOLVES: return "The server will attempt to resolve logical references to literal references - i.e. converting Reference.identifier to Reference.reference (if resolution fails, the server may still accept resources; see logical).";
            case ENFORCED: return "The server enforces that references have integrity - e.g. it ensures that references can always be resolved. This is typically the case for clinical record systems, but often not the case for middleware/proxy systems.";
            case LOCAL: return "The server does not support references that point to other servers.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case LITERAL: return "Literal References";
            case LOGICAL: return "Logical References";
            case RESOLVES: return "Resolves References";
            case ENFORCED: return "Reference Integrity Enforced";
            case LOCAL: return "Local References Only";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ReferenceHandlingPolicyEnumFactory implements EnumFactory<ReferenceHandlingPolicy> {
    public ReferenceHandlingPolicy fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("literal".equals(codeString))
          return ReferenceHandlingPolicy.LITERAL;
        if ("logical".equals(codeString))
          return ReferenceHandlingPolicy.LOGICAL;
        if ("resolves".equals(codeString))
          return ReferenceHandlingPolicy.RESOLVES;
        if ("enforced".equals(codeString))
          return ReferenceHandlingPolicy.ENFORCED;
        if ("local".equals(codeString))
          return ReferenceHandlingPolicy.LOCAL;
        throw new IllegalArgumentException("Unknown ReferenceHandlingPolicy code '"+codeString+"'");
        }
        public Enumeration<ReferenceHandlingPolicy> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ReferenceHandlingPolicy>(this, ReferenceHandlingPolicy.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ReferenceHandlingPolicy>(this, ReferenceHandlingPolicy.NULL, code);
        if ("literal".equals(codeString))
          return new Enumeration<ReferenceHandlingPolicy>(this, ReferenceHandlingPolicy.LITERAL, code);
        if ("logical".equals(codeString))
          return new Enumeration<ReferenceHandlingPolicy>(this, ReferenceHandlingPolicy.LOGICAL, code);
        if ("resolves".equals(codeString))
          return new Enumeration<ReferenceHandlingPolicy>(this, ReferenceHandlingPolicy.RESOLVES, code);
        if ("enforced".equals(codeString))
          return new Enumeration<ReferenceHandlingPolicy>(this, ReferenceHandlingPolicy.ENFORCED, code);
        if ("local".equals(codeString))
          return new Enumeration<ReferenceHandlingPolicy>(this, ReferenceHandlingPolicy.LOCAL, code);
        throw new FHIRException("Unknown ReferenceHandlingPolicy code '"+codeString+"'");
        }
    public String toCode(ReferenceHandlingPolicy code) {
       if (code == ReferenceHandlingPolicy.NULL)
           return null;
       if (code == ReferenceHandlingPolicy.LITERAL)
        return "literal";
      if (code == ReferenceHandlingPolicy.LOGICAL)
        return "logical";
      if (code == ReferenceHandlingPolicy.RESOLVES)
        return "resolves";
      if (code == ReferenceHandlingPolicy.ENFORCED)
        return "enforced";
      if (code == ReferenceHandlingPolicy.LOCAL)
        return "local";
      return "?";
   }
    public String toSystem(ReferenceHandlingPolicy code) {
      return code.getSystem();
      }
    }

    public enum ResourceVersionPolicy {
        /**
         * VersionId meta-property is not supported (server) or used (client).
         */
        NOVERSION, 
        /**
         * VersionId meta-property is supported (server) or used (client).
         */
        VERSIONED, 
        /**
         * Supports version-aware updates (server) or will be specified (If-match header) for updates (client).
         */
        VERSIONEDUPDATE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ResourceVersionPolicy fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("no-version".equals(codeString))
          return NOVERSION;
        if ("versioned".equals(codeString))
          return VERSIONED;
        if ("versioned-update".equals(codeString))
          return VERSIONEDUPDATE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ResourceVersionPolicy code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case NOVERSION: return "no-version";
            case VERSIONED: return "versioned";
            case VERSIONEDUPDATE: return "versioned-update";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case NOVERSION: return "http://hl7.org/fhir/versioning-policy";
            case VERSIONED: return "http://hl7.org/fhir/versioning-policy";
            case VERSIONEDUPDATE: return "http://hl7.org/fhir/versioning-policy";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case NOVERSION: return "VersionId meta-property is not supported (server) or used (client).";
            case VERSIONED: return "VersionId meta-property is supported (server) or used (client).";
            case VERSIONEDUPDATE: return "Supports version-aware updates (server) or will be specified (If-match header) for updates (client).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case NOVERSION: return "No VersionId Support";
            case VERSIONED: return "Versioned";
            case VERSIONEDUPDATE: return "VersionId tracked fully";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ResourceVersionPolicyEnumFactory implements EnumFactory<ResourceVersionPolicy> {
    public ResourceVersionPolicy fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("no-version".equals(codeString))
          return ResourceVersionPolicy.NOVERSION;
        if ("versioned".equals(codeString))
          return ResourceVersionPolicy.VERSIONED;
        if ("versioned-update".equals(codeString))
          return ResourceVersionPolicy.VERSIONEDUPDATE;
        throw new IllegalArgumentException("Unknown ResourceVersionPolicy code '"+codeString+"'");
        }
        public Enumeration<ResourceVersionPolicy> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ResourceVersionPolicy>(this, ResourceVersionPolicy.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ResourceVersionPolicy>(this, ResourceVersionPolicy.NULL, code);
        if ("no-version".equals(codeString))
          return new Enumeration<ResourceVersionPolicy>(this, ResourceVersionPolicy.NOVERSION, code);
        if ("versioned".equals(codeString))
          return new Enumeration<ResourceVersionPolicy>(this, ResourceVersionPolicy.VERSIONED, code);
        if ("versioned-update".equals(codeString))
          return new Enumeration<ResourceVersionPolicy>(this, ResourceVersionPolicy.VERSIONEDUPDATE, code);
        throw new FHIRException("Unknown ResourceVersionPolicy code '"+codeString+"'");
        }
    public String toCode(ResourceVersionPolicy code) {
       if (code == ResourceVersionPolicy.NULL)
           return null;
       if (code == ResourceVersionPolicy.NOVERSION)
        return "no-version";
      if (code == ResourceVersionPolicy.VERSIONED)
        return "versioned";
      if (code == ResourceVersionPolicy.VERSIONEDUPDATE)
        return "versioned-update";
      return "?";
   }
    public String toSystem(ResourceVersionPolicy code) {
      return code.getSystem();
      }
    }

    public enum RestfulCapabilityMode {
        /**
         * The application acts as a client for this resource.
         */
        CLIENT, 
        /**
         * The application acts as a server for this resource.
         */
        SERVER, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static RestfulCapabilityMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("client".equals(codeString))
          return CLIENT;
        if ("server".equals(codeString))
          return SERVER;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RestfulCapabilityMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CLIENT: return "client";
            case SERVER: return "server";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CLIENT: return "http://hl7.org/fhir/restful-capability-mode";
            case SERVER: return "http://hl7.org/fhir/restful-capability-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CLIENT: return "The application acts as a client for this resource.";
            case SERVER: return "The application acts as a server for this resource.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CLIENT: return "Client";
            case SERVER: return "Server";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class RestfulCapabilityModeEnumFactory implements EnumFactory<RestfulCapabilityMode> {
    public RestfulCapabilityMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("client".equals(codeString))
          return RestfulCapabilityMode.CLIENT;
        if ("server".equals(codeString))
          return RestfulCapabilityMode.SERVER;
        throw new IllegalArgumentException("Unknown RestfulCapabilityMode code '"+codeString+"'");
        }
        public Enumeration<RestfulCapabilityMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RestfulCapabilityMode>(this, RestfulCapabilityMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<RestfulCapabilityMode>(this, RestfulCapabilityMode.NULL, code);
        if ("client".equals(codeString))
          return new Enumeration<RestfulCapabilityMode>(this, RestfulCapabilityMode.CLIENT, code);
        if ("server".equals(codeString))
          return new Enumeration<RestfulCapabilityMode>(this, RestfulCapabilityMode.SERVER, code);
        throw new FHIRException("Unknown RestfulCapabilityMode code '"+codeString+"'");
        }
    public String toCode(RestfulCapabilityMode code) {
       if (code == RestfulCapabilityMode.NULL)
           return null;
       if (code == RestfulCapabilityMode.CLIENT)
        return "client";
      if (code == RestfulCapabilityMode.SERVER)
        return "server";
      return "?";
   }
    public String toSystem(RestfulCapabilityMode code) {
      return code.getSystem();
      }
    }

    public enum SystemRestfulInteraction {
        /**
         * Update, create or delete a set of resources as a single transaction.
         */
        TRANSACTION, 
        /**
         * perform a set of a separate interactions in a single http operation
         */
        BATCH, 
        /**
         * Search all resources based on some filter criteria.
         */
        SEARCHSYSTEM, 
        /**
         * Retrieve the change history for all resources on a system.
         */
        HISTORYSYSTEM, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SystemRestfulInteraction fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("transaction".equals(codeString))
          return TRANSACTION;
        if ("batch".equals(codeString))
          return BATCH;
        if ("search-system".equals(codeString))
          return SEARCHSYSTEM;
        if ("history-system".equals(codeString))
          return HISTORYSYSTEM;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SystemRestfulInteraction code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case TRANSACTION: return "transaction";
            case BATCH: return "batch";
            case SEARCHSYSTEM: return "search-system";
            case HISTORYSYSTEM: return "history-system";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case TRANSACTION: return "http://hl7.org/fhir/restful-interaction";
            case BATCH: return "http://hl7.org/fhir/restful-interaction";
            case SEARCHSYSTEM: return "http://hl7.org/fhir/restful-interaction";
            case HISTORYSYSTEM: return "http://hl7.org/fhir/restful-interaction";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case TRANSACTION: return "Update, create or delete a set of resources as a single transaction.";
            case BATCH: return "perform a set of a separate interactions in a single http operation";
            case SEARCHSYSTEM: return "Search all resources based on some filter criteria.";
            case HISTORYSYSTEM: return "Retrieve the change history for all resources on a system.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case TRANSACTION: return "transaction";
            case BATCH: return "batch";
            case SEARCHSYSTEM: return "search-system";
            case HISTORYSYSTEM: return "history-system";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SystemRestfulInteractionEnumFactory implements EnumFactory<SystemRestfulInteraction> {
    public SystemRestfulInteraction fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("transaction".equals(codeString))
          return SystemRestfulInteraction.TRANSACTION;
        if ("batch".equals(codeString))
          return SystemRestfulInteraction.BATCH;
        if ("search-system".equals(codeString))
          return SystemRestfulInteraction.SEARCHSYSTEM;
        if ("history-system".equals(codeString))
          return SystemRestfulInteraction.HISTORYSYSTEM;
        throw new IllegalArgumentException("Unknown SystemRestfulInteraction code '"+codeString+"'");
        }
        public Enumeration<SystemRestfulInteraction> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.NULL, code);
        if ("transaction".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.TRANSACTION, code);
        if ("batch".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.BATCH, code);
        if ("search-system".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.SEARCHSYSTEM, code);
        if ("history-system".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.HISTORYSYSTEM, code);
        throw new FHIRException("Unknown SystemRestfulInteraction code '"+codeString+"'");
        }
    public String toCode(SystemRestfulInteraction code) {
       if (code == SystemRestfulInteraction.NULL)
           return null;
       if (code == SystemRestfulInteraction.TRANSACTION)
        return "transaction";
      if (code == SystemRestfulInteraction.BATCH)
        return "batch";
      if (code == SystemRestfulInteraction.SEARCHSYSTEM)
        return "search-system";
      if (code == SystemRestfulInteraction.HISTORYSYSTEM)
        return "history-system";
      return "?";
   }
    public String toSystem(SystemRestfulInteraction code) {
      return code.getSystem();
      }
    }

    public enum TypeRestfulInteraction {
        /**
         * Read the current state of the resource.
         */
        READ, 
        /**
         * Read the state of a specific version of the resource.
         */
        VREAD, 
        /**
         * Update an existing resource by its id (or create it if it is new).
         */
        UPDATE, 
        /**
         * Update an existing resource by posting a set of changes to it.
         */
        PATCH, 
        /**
         * Delete a resource.
         */
        DELETE, 
        /**
         * Retrieve the change history for a particular resource.
         */
        HISTORYINSTANCE, 
        /**
         * Retrieve the change history for all resources of a particular type.
         */
        HISTORYTYPE, 
        /**
         * Create a new resource with a server assigned id.
         */
        CREATE, 
        /**
         * Search all resources of the specified type based on some filter criteria.
         */
        SEARCHTYPE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TypeRestfulInteraction fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("read".equals(codeString))
          return READ;
        if ("vread".equals(codeString))
          return VREAD;
        if ("update".equals(codeString))
          return UPDATE;
        if ("patch".equals(codeString))
          return PATCH;
        if ("delete".equals(codeString))
          return DELETE;
        if ("history-instance".equals(codeString))
          return HISTORYINSTANCE;
        if ("history-type".equals(codeString))
          return HISTORYTYPE;
        if ("create".equals(codeString))
          return CREATE;
        if ("search-type".equals(codeString))
          return SEARCHTYPE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown TypeRestfulInteraction code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case READ: return "read";
            case VREAD: return "vread";
            case UPDATE: return "update";
            case PATCH: return "patch";
            case DELETE: return "delete";
            case HISTORYINSTANCE: return "history-instance";
            case HISTORYTYPE: return "history-type";
            case CREATE: return "create";
            case SEARCHTYPE: return "search-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case READ: return "http://hl7.org/fhir/restful-interaction";
            case VREAD: return "http://hl7.org/fhir/restful-interaction";
            case UPDATE: return "http://hl7.org/fhir/restful-interaction";
            case PATCH: return "http://hl7.org/fhir/restful-interaction";
            case DELETE: return "http://hl7.org/fhir/restful-interaction";
            case HISTORYINSTANCE: return "http://hl7.org/fhir/restful-interaction";
            case HISTORYTYPE: return "http://hl7.org/fhir/restful-interaction";
            case CREATE: return "http://hl7.org/fhir/restful-interaction";
            case SEARCHTYPE: return "http://hl7.org/fhir/restful-interaction";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case READ: return "Read the current state of the resource.";
            case VREAD: return "Read the state of a specific version of the resource.";
            case UPDATE: return "Update an existing resource by its id (or create it if it is new).";
            case PATCH: return "Update an existing resource by posting a set of changes to it.";
            case DELETE: return "Delete a resource.";
            case HISTORYINSTANCE: return "Retrieve the change history for a particular resource.";
            case HISTORYTYPE: return "Retrieve the change history for all resources of a particular type.";
            case CREATE: return "Create a new resource with a server assigned id.";
            case SEARCHTYPE: return "Search all resources of the specified type based on some filter criteria.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case READ: return "read";
            case VREAD: return "vread";
            case UPDATE: return "update";
            case PATCH: return "patch";
            case DELETE: return "delete";
            case HISTORYINSTANCE: return "history-instance";
            case HISTORYTYPE: return "history-type";
            case CREATE: return "create";
            case SEARCHTYPE: return "search-type";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class TypeRestfulInteractionEnumFactory implements EnumFactory<TypeRestfulInteraction> {
    public TypeRestfulInteraction fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("read".equals(codeString))
          return TypeRestfulInteraction.READ;
        if ("vread".equals(codeString))
          return TypeRestfulInteraction.VREAD;
        if ("update".equals(codeString))
          return TypeRestfulInteraction.UPDATE;
        if ("patch".equals(codeString))
          return TypeRestfulInteraction.PATCH;
        if ("delete".equals(codeString))
          return TypeRestfulInteraction.DELETE;
        if ("history-instance".equals(codeString))
          return TypeRestfulInteraction.HISTORYINSTANCE;
        if ("history-type".equals(codeString))
          return TypeRestfulInteraction.HISTORYTYPE;
        if ("create".equals(codeString))
          return TypeRestfulInteraction.CREATE;
        if ("search-type".equals(codeString))
          return TypeRestfulInteraction.SEARCHTYPE;
        throw new IllegalArgumentException("Unknown TypeRestfulInteraction code '"+codeString+"'");
        }
        public Enumeration<TypeRestfulInteraction> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.NULL, code);
        if ("read".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.READ, code);
        if ("vread".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.VREAD, code);
        if ("update".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.UPDATE, code);
        if ("patch".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.PATCH, code);
        if ("delete".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.DELETE, code);
        if ("history-instance".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.HISTORYINSTANCE, code);
        if ("history-type".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.HISTORYTYPE, code);
        if ("create".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.CREATE, code);
        if ("search-type".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.SEARCHTYPE, code);
        throw new FHIRException("Unknown TypeRestfulInteraction code '"+codeString+"'");
        }
    public String toCode(TypeRestfulInteraction code) {
       if (code == TypeRestfulInteraction.NULL)
           return null;
       if (code == TypeRestfulInteraction.READ)
        return "read";
      if (code == TypeRestfulInteraction.VREAD)
        return "vread";
      if (code == TypeRestfulInteraction.UPDATE)
        return "update";
      if (code == TypeRestfulInteraction.PATCH)
        return "patch";
      if (code == TypeRestfulInteraction.DELETE)
        return "delete";
      if (code == TypeRestfulInteraction.HISTORYINSTANCE)
        return "history-instance";
      if (code == TypeRestfulInteraction.HISTORYTYPE)
        return "history-type";
      if (code == TypeRestfulInteraction.CREATE)
        return "create";
      if (code == TypeRestfulInteraction.SEARCHTYPE)
        return "search-type";
      return "?";
   }
    public String toSystem(TypeRestfulInteraction code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CapabilityStatementSoftwareComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name the software is known by.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A name the software is known by", formalDefinition="Name the software is known by." )
        protected StringType name;

        /**
         * The version identifier for the software covered by this statement.
         */
        @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Version covered by this statement", formalDefinition="The version identifier for the software covered by this statement." )
        protected StringType version;

        /**
         * Date this version of the software was released.
         */
        @Child(name = "releaseDate", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Date this version was released", formalDefinition="Date this version of the software was released." )
        protected DateTimeType releaseDate;

        private static final long serialVersionUID = 1819769027L;

    /**
     * Constructor
     */
      public CapabilityStatementSoftwareComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementSoftwareComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (Name the software is known by.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementSoftwareComponent.name");
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
         * @param value {@link #name} (Name the software is known by.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CapabilityStatementSoftwareComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name the software is known by.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name the software is known by.
         */
        public CapabilityStatementSoftwareComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #version} (The version identifier for the software covered by this statement.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public StringType getVersionElement() { 
          if (this.version == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementSoftwareComponent.version");
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
         * @param value {@link #version} (The version identifier for the software covered by this statement.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public CapabilityStatementSoftwareComponent setVersionElement(StringType value) { 
          this.version = value;
          return this;
        }

        /**
         * @return The version identifier for the software covered by this statement.
         */
        public String getVersion() { 
          return this.version == null ? null : this.version.getValue();
        }

        /**
         * @param value The version identifier for the software covered by this statement.
         */
        public CapabilityStatementSoftwareComponent setVersion(String value) { 
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
         * @return {@link #releaseDate} (Date this version of the software was released.). This is the underlying object with id, value and extensions. The accessor "getReleaseDate" gives direct access to the value
         */
        public DateTimeType getReleaseDateElement() { 
          if (this.releaseDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementSoftwareComponent.releaseDate");
            else if (Configuration.doAutoCreate())
              this.releaseDate = new DateTimeType(); // bb
          return this.releaseDate;
        }

        public boolean hasReleaseDateElement() { 
          return this.releaseDate != null && !this.releaseDate.isEmpty();
        }

        public boolean hasReleaseDate() { 
          return this.releaseDate != null && !this.releaseDate.isEmpty();
        }

        /**
         * @param value {@link #releaseDate} (Date this version of the software was released.). This is the underlying object with id, value and extensions. The accessor "getReleaseDate" gives direct access to the value
         */
        public CapabilityStatementSoftwareComponent setReleaseDateElement(DateTimeType value) { 
          this.releaseDate = value;
          return this;
        }

        /**
         * @return Date this version of the software was released.
         */
        public Date getReleaseDate() { 
          return this.releaseDate == null ? null : this.releaseDate.getValue();
        }

        /**
         * @param value Date this version of the software was released.
         */
        public CapabilityStatementSoftwareComponent setReleaseDate(Date value) { 
          if (value == null)
            this.releaseDate = null;
          else {
            if (this.releaseDate == null)
              this.releaseDate = new DateTimeType();
            this.releaseDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Name the software is known by.", 0, 1, name));
          children.add(new Property("version", "string", "The version identifier for the software covered by this statement.", 0, 1, version));
          children.add(new Property("releaseDate", "dateTime", "Date this version of the software was released.", 0, 1, releaseDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Name the software is known by.", 0, 1, name);
          case 351608024: /*version*/  return new Property("version", "string", "The version identifier for the software covered by this statement.", 0, 1, version);
          case 212873301: /*releaseDate*/  return new Property("releaseDate", "dateTime", "Date this version of the software was released.", 0, 1, releaseDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 212873301: /*releaseDate*/ return this.releaseDate == null ? new Base[0] : new Base[] {this.releaseDate}; // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 212873301: // releaseDate
          this.releaseDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("releaseDate")) {
          this.releaseDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("version")) {
          this.version = null;
        } else if (name.equals("releaseDate")) {
          this.releaseDate = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 351608024:  return getVersionElement();
        case 212873301:  return getReleaseDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 212873301: /*releaseDate*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.software.name");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.software.version");
        }
        else if (name.equals("releaseDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.software.releaseDate");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementSoftwareComponent copy() {
        CapabilityStatementSoftwareComponent dst = new CapabilityStatementSoftwareComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementSoftwareComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.version = version == null ? null : version.copy();
        dst.releaseDate = releaseDate == null ? null : releaseDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementSoftwareComponent))
          return false;
        CapabilityStatementSoftwareComponent o = (CapabilityStatementSoftwareComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(version, o.version, true) && compareDeep(releaseDate, o.releaseDate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementSoftwareComponent))
          return false;
        CapabilityStatementSoftwareComponent o = (CapabilityStatementSoftwareComponent) other_;
        return compareValues(name, o.name, true) && compareValues(version, o.version, true) && compareValues(releaseDate, o.releaseDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, version, releaseDate
          );
      }

  public String fhirType() {
    return "CapabilityStatement.software";

  }

  }

    @Block()
    public static class CapabilityStatementImplementationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Information about the specific installation that this capability statement relates to.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Describes this specific instance", formalDefinition="Information about the specific installation that this capability statement relates to." )
        protected MarkdownType description;

        /**
         * An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        @Child(name = "url", type = {UrlType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Base URL for the installation", formalDefinition="An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces." )
        protected UrlType url;

        /**
         * The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.
         */
        @Child(name = "custodian", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Organization that manages the data", formalDefinition="The organization responsible for the management of the instance and oversight of the data on the server at the specified URL." )
        protected Reference custodian;

        private static final long serialVersionUID = -1848514556L;

    /**
     * Constructor
     */
      public CapabilityStatementImplementationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementImplementationComponent(String description) {
        super();
        this.setDescription(description);
      }

        /**
         * @return {@link #description} (Information about the specific installation that this capability statement relates to.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementImplementationComponent.description");
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
         * @param value {@link #description} (Information about the specific installation that this capability statement relates to.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public CapabilityStatementImplementationComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Information about the specific installation that this capability statement relates to.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Information about the specific installation that this capability statement relates to.
         */
        public CapabilityStatementImplementationComponent setDescription(String value) { 
            if (this.description == null)
              this.description = new MarkdownType();
            this.description.setValue(value);
          return this;
        }

        /**
         * @return {@link #url} (An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementImplementationComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UrlType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public CapabilityStatementImplementationComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        public CapabilityStatementImplementationComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #custodian} (The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.)
         */
        public Reference getCustodian() { 
          if (this.custodian == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementImplementationComponent.custodian");
            else if (Configuration.doAutoCreate())
              this.custodian = new Reference(); // cc
          return this.custodian;
        }

        public boolean hasCustodian() { 
          return this.custodian != null && !this.custodian.isEmpty();
        }

        /**
         * @param value {@link #custodian} (The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.)
         */
        public CapabilityStatementImplementationComponent setCustodian(Reference value) { 
          this.custodian = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "Information about the specific installation that this capability statement relates to.", 0, 1, description));
          children.add(new Property("url", "url", "An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.", 0, 1, url));
          children.add(new Property("custodian", "Reference(Organization)", "The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.", 0, 1, custodian));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "Information about the specific installation that this capability statement relates to.", 0, 1, description);
          case 116079: /*url*/  return new Property("url", "url", "An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.", 0, 1, url);
          case 1611297262: /*custodian*/  return new Property("custodian", "Reference(Organization)", "The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.", 0, 1, custodian);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        case 1611297262: /*custodian*/ return this.custodian == null ? new Base[0] : new Base[] {this.custodian}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 1611297262: // custodian
          this.custodian = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("custodian")) {
          this.custodian = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("url")) {
          this.url = null;
        } else if (name.equals("custodian")) {
          this.custodian = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 116079:  return getUrlElement();
        case 1611297262:  return getCustodian();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 116079: /*url*/ return new String[] {"url"};
        case 1611297262: /*custodian*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.implementation.description");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.implementation.url");
        }
        else if (name.equals("custodian")) {
          this.custodian = new Reference();
          return this.custodian;
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementImplementationComponent copy() {
        CapabilityStatementImplementationComponent dst = new CapabilityStatementImplementationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementImplementationComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.url = url == null ? null : url.copy();
        dst.custodian = custodian == null ? null : custodian.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementImplementationComponent))
          return false;
        CapabilityStatementImplementationComponent o = (CapabilityStatementImplementationComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(url, o.url, true) && compareDeep(custodian, o.custodian, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementImplementationComponent))
          return false;
        CapabilityStatementImplementationComponent o = (CapabilityStatementImplementationComponent) other_;
        return compareValues(description, o.description, true) && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, url, custodian
          );
      }

  public String fhirType() {
    return "CapabilityStatement.implementation";

  }

  }

    @Block()
    public static class CapabilityStatementRestComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.
         */
        @Child(name = "mode", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="client | server", formalDefinition="Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/restful-capability-mode")
        protected Enumeration<RestfulCapabilityMode> mode;

        /**
         * Information about the system's restful capabilities that apply across all applications, such as security.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="General description of implementation", formalDefinition="Information about the system's restful capabilities that apply across all applications, such as security." )
        protected MarkdownType documentation;

        /**
         * Information about security implementation from an interface perspective - what a client needs to know.
         */
        @Child(name = "security", type = {}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Information about security of implementation", formalDefinition="Information about security implementation from an interface perspective - what a client needs to know." )
        protected CapabilityStatementRestSecurityComponent security;

        /**
         * A specification of the restful capabilities of the solution for a specific resource type.
         */
        @Child(name = "resource", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Resource served on the REST interface", formalDefinition="A specification of the restful capabilities of the solution for a specific resource type." )
        protected List<CapabilityStatementRestResourceComponent> resource;

        /**
         * A specification of restful operations supported by the system.
         */
        @Child(name = "interaction", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What operations are supported?", formalDefinition="A specification of restful operations supported by the system." )
        protected List<SystemInteractionComponent> interaction;

        /**
         * Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation. This is only for searches executed against the system-level endpoint.
         */
        @Child(name = "searchParam", type = {CapabilityStatementRestResourceSearchParamComponent.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Search parameters for searching all resources", formalDefinition="Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation. This is only for searches executed against the system-level endpoint." )
        protected List<CapabilityStatementRestResourceSearchParamComponent> searchParam;

        /**
         * Definition of an operation or a named query together with its parameters and their meaning and type.
         */
        @Child(name = "operation", type = {CapabilityStatementRestResourceOperationComponent.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Definition of a system level operation", formalDefinition="Definition of an operation or a named query together with its parameters and their meaning and type." )
        protected List<CapabilityStatementRestResourceOperationComponent> operation;

        /**
         * An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .
         */
        @Child(name = "compartment", type = {CanonicalType.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Compartments served/used by system", formalDefinition="An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL ." )
        protected List<CanonicalType> compartment;

        private static final long serialVersionUID = -1442029817L;

    /**
     * Constructor
     */
      public CapabilityStatementRestComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementRestComponent(RestfulCapabilityMode mode) {
        super();
        this.setMode(mode);
      }

        /**
         * @return {@link #mode} (Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public Enumeration<RestfulCapabilityMode> getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new Enumeration<RestfulCapabilityMode>(new RestfulCapabilityModeEnumFactory()); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public CapabilityStatementRestComponent setModeElement(Enumeration<RestfulCapabilityMode> value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.
         */
        public RestfulCapabilityMode getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.
         */
        public CapabilityStatementRestComponent setMode(RestfulCapabilityMode value) { 
            if (this.mode == null)
              this.mode = new Enumeration<RestfulCapabilityMode>(new RestfulCapabilityModeEnumFactory());
            this.mode.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Information about the system's restful capabilities that apply across all applications, such as security.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Information about the system's restful capabilities that apply across all applications, such as security.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatementRestComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Information about the system's restful capabilities that apply across all applications, such as security.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Information about the system's restful capabilities that apply across all applications, such as security.
         */
        public CapabilityStatementRestComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #security} (Information about security implementation from an interface perspective - what a client needs to know.)
         */
        public CapabilityStatementRestSecurityComponent getSecurity() { 
          if (this.security == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestComponent.security");
            else if (Configuration.doAutoCreate())
              this.security = new CapabilityStatementRestSecurityComponent(); // cc
          return this.security;
        }

        public boolean hasSecurity() { 
          return this.security != null && !this.security.isEmpty();
        }

        /**
         * @param value {@link #security} (Information about security implementation from an interface perspective - what a client needs to know.)
         */
        public CapabilityStatementRestComponent setSecurity(CapabilityStatementRestSecurityComponent value) { 
          this.security = value;
          return this;
        }

        /**
         * @return {@link #resource} (A specification of the restful capabilities of the solution for a specific resource type.)
         */
        public List<CapabilityStatementRestResourceComponent> getResource() { 
          if (this.resource == null)
            this.resource = new ArrayList<CapabilityStatementRestResourceComponent>();
          return this.resource;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestComponent setResource(List<CapabilityStatementRestResourceComponent> theResource) { 
          this.resource = theResource;
          return this;
        }

        public boolean hasResource() { 
          if (this.resource == null)
            return false;
          for (CapabilityStatementRestResourceComponent item : this.resource)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatementRestResourceComponent addResource() { //3
          CapabilityStatementRestResourceComponent t = new CapabilityStatementRestResourceComponent();
          if (this.resource == null)
            this.resource = new ArrayList<CapabilityStatementRestResourceComponent>();
          this.resource.add(t);
          return t;
        }

        public CapabilityStatementRestComponent addResource(CapabilityStatementRestResourceComponent t) { //3
          if (t == null)
            return this;
          if (this.resource == null)
            this.resource = new ArrayList<CapabilityStatementRestResourceComponent>();
          this.resource.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #resource}, creating it if it does not already exist {3}
         */
        public CapabilityStatementRestResourceComponent getResourceFirstRep() { 
          if (getResource().isEmpty()) {
            addResource();
          }
          return getResource().get(0);
        }

        /**
         * @return {@link #interaction} (A specification of restful operations supported by the system.)
         */
        public List<SystemInteractionComponent> getInteraction() { 
          if (this.interaction == null)
            this.interaction = new ArrayList<SystemInteractionComponent>();
          return this.interaction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestComponent setInteraction(List<SystemInteractionComponent> theInteraction) { 
          this.interaction = theInteraction;
          return this;
        }

        public boolean hasInteraction() { 
          if (this.interaction == null)
            return false;
          for (SystemInteractionComponent item : this.interaction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SystemInteractionComponent addInteraction() { //3
          SystemInteractionComponent t = new SystemInteractionComponent();
          if (this.interaction == null)
            this.interaction = new ArrayList<SystemInteractionComponent>();
          this.interaction.add(t);
          return t;
        }

        public CapabilityStatementRestComponent addInteraction(SystemInteractionComponent t) { //3
          if (t == null)
            return this;
          if (this.interaction == null)
            this.interaction = new ArrayList<SystemInteractionComponent>();
          this.interaction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #interaction}, creating it if it does not already exist {3}
         */
        public SystemInteractionComponent getInteractionFirstRep() { 
          if (getInteraction().isEmpty()) {
            addInteraction();
          }
          return getInteraction().get(0);
        }

        /**
         * @return {@link #searchParam} (Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation. This is only for searches executed against the system-level endpoint.)
         */
        public List<CapabilityStatementRestResourceSearchParamComponent> getSearchParam() { 
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          return this.searchParam;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestComponent setSearchParam(List<CapabilityStatementRestResourceSearchParamComponent> theSearchParam) { 
          this.searchParam = theSearchParam;
          return this;
        }

        public boolean hasSearchParam() { 
          if (this.searchParam == null)
            return false;
          for (CapabilityStatementRestResourceSearchParamComponent item : this.searchParam)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatementRestResourceSearchParamComponent addSearchParam() { //3
          CapabilityStatementRestResourceSearchParamComponent t = new CapabilityStatementRestResourceSearchParamComponent();
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return t;
        }

        public CapabilityStatementRestComponent addSearchParam(CapabilityStatementRestResourceSearchParamComponent t) { //3
          if (t == null)
            return this;
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #searchParam}, creating it if it does not already exist {3}
         */
        public CapabilityStatementRestResourceSearchParamComponent getSearchParamFirstRep() { 
          if (getSearchParam().isEmpty()) {
            addSearchParam();
          }
          return getSearchParam().get(0);
        }

        /**
         * @return {@link #operation} (Definition of an operation or a named query together with its parameters and their meaning and type.)
         */
        public List<CapabilityStatementRestResourceOperationComponent> getOperation() { 
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          return this.operation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestComponent setOperation(List<CapabilityStatementRestResourceOperationComponent> theOperation) { 
          this.operation = theOperation;
          return this;
        }

        public boolean hasOperation() { 
          if (this.operation == null)
            return false;
          for (CapabilityStatementRestResourceOperationComponent item : this.operation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatementRestResourceOperationComponent addOperation() { //3
          CapabilityStatementRestResourceOperationComponent t = new CapabilityStatementRestResourceOperationComponent();
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          this.operation.add(t);
          return t;
        }

        public CapabilityStatementRestComponent addOperation(CapabilityStatementRestResourceOperationComponent t) { //3
          if (t == null)
            return this;
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          this.operation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #operation}, creating it if it does not already exist {3}
         */
        public CapabilityStatementRestResourceOperationComponent getOperationFirstRep() { 
          if (getOperation().isEmpty()) {
            addOperation();
          }
          return getOperation().get(0);
        }

        /**
         * @return {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public List<CanonicalType> getCompartment() { 
          if (this.compartment == null)
            this.compartment = new ArrayList<CanonicalType>();
          return this.compartment;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestComponent setCompartment(List<CanonicalType> theCompartment) { 
          this.compartment = theCompartment;
          return this;
        }

        public boolean hasCompartment() { 
          if (this.compartment == null)
            return false;
          for (CanonicalType item : this.compartment)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public CanonicalType addCompartmentElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.compartment == null)
            this.compartment = new ArrayList<CanonicalType>();
          this.compartment.add(t);
          return t;
        }

        /**
         * @param value {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public CapabilityStatementRestComponent addCompartment(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.compartment == null)
            this.compartment = new ArrayList<CanonicalType>();
          this.compartment.add(t);
          return this;
        }

        /**
         * @param value {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public boolean hasCompartment(String value) { 
          if (this.compartment == null)
            return false;
          for (CanonicalType v : this.compartment)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("mode", "code", "Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.", 0, 1, mode));
          children.add(new Property("documentation", "markdown", "Information about the system's restful capabilities that apply across all applications, such as security.", 0, 1, documentation));
          children.add(new Property("security", "", "Information about security implementation from an interface perspective - what a client needs to know.", 0, 1, security));
          children.add(new Property("resource", "", "A specification of the restful capabilities of the solution for a specific resource type.", 0, java.lang.Integer.MAX_VALUE, resource));
          children.add(new Property("interaction", "", "A specification of restful operations supported by the system.", 0, java.lang.Integer.MAX_VALUE, interaction));
          children.add(new Property("searchParam", "@CapabilityStatement.rest.resource.searchParam", "Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation. This is only for searches executed against the system-level endpoint.", 0, java.lang.Integer.MAX_VALUE, searchParam));
          children.add(new Property("operation", "@CapabilityStatement.rest.resource.operation", "Definition of an operation or a named query together with its parameters and their meaning and type.", 0, java.lang.Integer.MAX_VALUE, operation));
          children.add(new Property("compartment", "canonical(CompartmentDefinition)", "An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .", 0, java.lang.Integer.MAX_VALUE, compartment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3357091: /*mode*/  return new Property("mode", "code", "Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.", 0, 1, mode);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Information about the system's restful capabilities that apply across all applications, such as security.", 0, 1, documentation);
          case 949122880: /*security*/  return new Property("security", "", "Information about security implementation from an interface perspective - what a client needs to know.", 0, 1, security);
          case -341064690: /*resource*/  return new Property("resource", "", "A specification of the restful capabilities of the solution for a specific resource type.", 0, java.lang.Integer.MAX_VALUE, resource);
          case 1844104722: /*interaction*/  return new Property("interaction", "", "A specification of restful operations supported by the system.", 0, java.lang.Integer.MAX_VALUE, interaction);
          case -553645115: /*searchParam*/  return new Property("searchParam", "@CapabilityStatement.rest.resource.searchParam", "Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation. This is only for searches executed against the system-level endpoint.", 0, java.lang.Integer.MAX_VALUE, searchParam);
          case 1662702951: /*operation*/  return new Property("operation", "@CapabilityStatement.rest.resource.operation", "Definition of an operation or a named query together with its parameters and their meaning and type.", 0, java.lang.Integer.MAX_VALUE, operation);
          case -397756334: /*compartment*/  return new Property("compartment", "canonical(CompartmentDefinition)", "An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .", 0, java.lang.Integer.MAX_VALUE, compartment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<RestfulCapabilityMode>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        case 949122880: /*security*/ return this.security == null ? new Base[0] : new Base[] {this.security}; // CapabilityStatementRestSecurityComponent
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : this.resource.toArray(new Base[this.resource.size()]); // CapabilityStatementRestResourceComponent
        case 1844104722: /*interaction*/ return this.interaction == null ? new Base[0] : this.interaction.toArray(new Base[this.interaction.size()]); // SystemInteractionComponent
        case -553645115: /*searchParam*/ return this.searchParam == null ? new Base[0] : this.searchParam.toArray(new Base[this.searchParam.size()]); // CapabilityStatementRestResourceSearchParamComponent
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : this.operation.toArray(new Base[this.operation.size()]); // CapabilityStatementRestResourceOperationComponent
        case -397756334: /*compartment*/ return this.compartment == null ? new Base[0] : this.compartment.toArray(new Base[this.compartment.size()]); // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3357091: // mode
          value = new RestfulCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<RestfulCapabilityMode>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 949122880: // security
          this.security = (CapabilityStatementRestSecurityComponent) value; // CapabilityStatementRestSecurityComponent
          return value;
        case -341064690: // resource
          this.getResource().add((CapabilityStatementRestResourceComponent) value); // CapabilityStatementRestResourceComponent
          return value;
        case 1844104722: // interaction
          this.getInteraction().add((SystemInteractionComponent) value); // SystemInteractionComponent
          return value;
        case -553645115: // searchParam
          this.getSearchParam().add((CapabilityStatementRestResourceSearchParamComponent) value); // CapabilityStatementRestResourceSearchParamComponent
          return value;
        case 1662702951: // operation
          this.getOperation().add((CapabilityStatementRestResourceOperationComponent) value); // CapabilityStatementRestResourceOperationComponent
          return value;
        case -397756334: // compartment
          this.getCompartment().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new RestfulCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<RestfulCapabilityMode>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("security")) {
          this.security = (CapabilityStatementRestSecurityComponent) value; // CapabilityStatementRestSecurityComponent
        } else if (name.equals("resource")) {
          this.getResource().add((CapabilityStatementRestResourceComponent) value);
        } else if (name.equals("interaction")) {
          this.getInteraction().add((SystemInteractionComponent) value);
        } else if (name.equals("searchParam")) {
          this.getSearchParam().add((CapabilityStatementRestResourceSearchParamComponent) value);
        } else if (name.equals("operation")) {
          this.getOperation().add((CapabilityStatementRestResourceOperationComponent) value);
        } else if (name.equals("compartment")) {
          this.getCompartment().add(TypeConvertor.castToCanonical(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new RestfulCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<RestfulCapabilityMode>
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else if (name.equals("security")) {
          this.security = (CapabilityStatementRestSecurityComponent) value; // CapabilityStatementRestSecurityComponent
        } else if (name.equals("resource")) {
          this.getResource().remove((CapabilityStatementRestResourceComponent) value);
        } else if (name.equals("interaction")) {
          this.getInteraction().remove((SystemInteractionComponent) value);
        } else if (name.equals("searchParam")) {
          this.getSearchParam().remove((CapabilityStatementRestResourceSearchParamComponent) value);
        } else if (name.equals("operation")) {
          this.getOperation().remove((CapabilityStatementRestResourceOperationComponent) value);
        } else if (name.equals("compartment")) {
          this.getCompartment().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091:  return getModeElement();
        case 1587405498:  return getDocumentationElement();
        case 949122880:  return getSecurity();
        case -341064690:  return addResource(); 
        case 1844104722:  return addInteraction(); 
        case -553645115:  return addSearchParam(); 
        case 1662702951:  return addOperation(); 
        case -397756334:  return addCompartmentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        case 949122880: /*security*/ return new String[] {};
        case -341064690: /*resource*/ return new String[] {};
        case 1844104722: /*interaction*/ return new String[] {};
        case -553645115: /*searchParam*/ return new String[] {"@CapabilityStatement.rest.resource.searchParam"};
        case 1662702951: /*operation*/ return new String[] {"@CapabilityStatement.rest.resource.operation"};
        case -397756334: /*compartment*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.mode");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.documentation");
        }
        else if (name.equals("security")) {
          this.security = new CapabilityStatementRestSecurityComponent();
          return this.security;
        }
        else if (name.equals("resource")) {
          return addResource();
        }
        else if (name.equals("interaction")) {
          return addInteraction();
        }
        else if (name.equals("searchParam")) {
          return addSearchParam();
        }
        else if (name.equals("operation")) {
          return addOperation();
        }
        else if (name.equals("compartment")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.compartment");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementRestComponent copy() {
        CapabilityStatementRestComponent dst = new CapabilityStatementRestComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementRestComponent dst) {
        super.copyValues(dst);
        dst.mode = mode == null ? null : mode.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
        dst.security = security == null ? null : security.copy();
        if (resource != null) {
          dst.resource = new ArrayList<CapabilityStatementRestResourceComponent>();
          for (CapabilityStatementRestResourceComponent i : resource)
            dst.resource.add(i.copy());
        };
        if (interaction != null) {
          dst.interaction = new ArrayList<SystemInteractionComponent>();
          for (SystemInteractionComponent i : interaction)
            dst.interaction.add(i.copy());
        };
        if (searchParam != null) {
          dst.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          for (CapabilityStatementRestResourceSearchParamComponent i : searchParam)
            dst.searchParam.add(i.copy());
        };
        if (operation != null) {
          dst.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          for (CapabilityStatementRestResourceOperationComponent i : operation)
            dst.operation.add(i.copy());
        };
        if (compartment != null) {
          dst.compartment = new ArrayList<CanonicalType>();
          for (CanonicalType i : compartment)
            dst.compartment.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestComponent))
          return false;
        CapabilityStatementRestComponent o = (CapabilityStatementRestComponent) other_;
        return compareDeep(mode, o.mode, true) && compareDeep(documentation, o.documentation, true) && compareDeep(security, o.security, true)
           && compareDeep(resource, o.resource, true) && compareDeep(interaction, o.interaction, true) && compareDeep(searchParam, o.searchParam, true)
           && compareDeep(operation, o.operation, true) && compareDeep(compartment, o.compartment, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestComponent))
          return false;
        CapabilityStatementRestComponent o = (CapabilityStatementRestComponent) other_;
        return compareValues(mode, o.mode, true) && compareValues(documentation, o.documentation, true) && compareValues(compartment, o.compartment, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(mode, documentation, security
          , resource, interaction, searchParam, operation, compartment);
      }

  public String fhirType() {
    return "CapabilityStatement.rest";

  }

  }

    @Block()
    public static class CapabilityStatementRestSecurityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Server adds CORS headers when responding to requests - this enables Javascript applications to use the server.
         */
        @Child(name = "cors", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Adds CORS Headers (http://enable-cors.org/)", formalDefinition="Server adds CORS headers when responding to requests - this enables Javascript applications to use the server." )
        protected BooleanType cors;

        /**
         * Types of security services that are supported/required by the system.
         */
        @Child(name = "service", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="OAuth | SMART-on-FHIR | NTLM | Basic | Kerberos | Certificates", formalDefinition="Types of security services that are supported/required by the system." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/restful-security-service")
        protected List<CodeableConcept> service;

        /**
         * General description of how security works.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="General description of how security works", formalDefinition="General description of how security works." )
        protected MarkdownType description;

        private static final long serialVersionUID = -1348900500L;

    /**
     * Constructor
     */
      public CapabilityStatementRestSecurityComponent() {
        super();
      }

        /**
         * @return {@link #cors} (Server adds CORS headers when responding to requests - this enables Javascript applications to use the server.). This is the underlying object with id, value and extensions. The accessor "getCors" gives direct access to the value
         */
        public BooleanType getCorsElement() { 
          if (this.cors == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestSecurityComponent.cors");
            else if (Configuration.doAutoCreate())
              this.cors = new BooleanType(); // bb
          return this.cors;
        }

        public boolean hasCorsElement() { 
          return this.cors != null && !this.cors.isEmpty();
        }

        public boolean hasCors() { 
          return this.cors != null && !this.cors.isEmpty();
        }

        /**
         * @param value {@link #cors} (Server adds CORS headers when responding to requests - this enables Javascript applications to use the server.). This is the underlying object with id, value and extensions. The accessor "getCors" gives direct access to the value
         */
        public CapabilityStatementRestSecurityComponent setCorsElement(BooleanType value) { 
          this.cors = value;
          return this;
        }

        /**
         * @return Server adds CORS headers when responding to requests - this enables Javascript applications to use the server.
         */
        public boolean getCors() { 
          return this.cors == null || this.cors.isEmpty() ? false : this.cors.getValue();
        }

        /**
         * @param value Server adds CORS headers when responding to requests - this enables Javascript applications to use the server.
         */
        public CapabilityStatementRestSecurityComponent setCors(boolean value) { 
            if (this.cors == null)
              this.cors = new BooleanType();
            this.cors.setValue(value);
          return this;
        }

        /**
         * @return {@link #service} (Types of security services that are supported/required by the system.)
         */
        public List<CodeableConcept> getService() { 
          if (this.service == null)
            this.service = new ArrayList<CodeableConcept>();
          return this.service;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestSecurityComponent setService(List<CodeableConcept> theService) { 
          this.service = theService;
          return this;
        }

        public boolean hasService() { 
          if (this.service == null)
            return false;
          for (CodeableConcept item : this.service)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addService() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.service == null)
            this.service = new ArrayList<CodeableConcept>();
          this.service.add(t);
          return t;
        }

        public CapabilityStatementRestSecurityComponent addService(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.service == null)
            this.service = new ArrayList<CodeableConcept>();
          this.service.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #service}, creating it if it does not already exist {3}
         */
        public CodeableConcept getServiceFirstRep() { 
          if (getService().isEmpty()) {
            addService();
          }
          return getService().get(0);
        }

        /**
         * @return {@link #description} (General description of how security works.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestSecurityComponent.description");
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
         * @param value {@link #description} (General description of how security works.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public CapabilityStatementRestSecurityComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return General description of how security works.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value General description of how security works.
         */
        public CapabilityStatementRestSecurityComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new MarkdownType();
            this.description.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("cors", "boolean", "Server adds CORS headers when responding to requests - this enables Javascript applications to use the server.", 0, 1, cors));
          children.add(new Property("service", "CodeableConcept", "Types of security services that are supported/required by the system.", 0, java.lang.Integer.MAX_VALUE, service));
          children.add(new Property("description", "markdown", "General description of how security works.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059629: /*cors*/  return new Property("cors", "boolean", "Server adds CORS headers when responding to requests - this enables Javascript applications to use the server.", 0, 1, cors);
          case 1984153269: /*service*/  return new Property("service", "CodeableConcept", "Types of security services that are supported/required by the system.", 0, java.lang.Integer.MAX_VALUE, service);
          case -1724546052: /*description*/  return new Property("description", "markdown", "General description of how security works.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059629: /*cors*/ return this.cors == null ? new Base[0] : new Base[] {this.cors}; // BooleanType
        case 1984153269: /*service*/ return this.service == null ? new Base[0] : this.service.toArray(new Base[this.service.size()]); // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059629: // cors
          this.cors = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1984153269: // service
          this.getService().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("cors")) {
          this.cors = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("service")) {
          this.getService().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("cors")) {
          this.cors = null;
        } else if (name.equals("service")) {
          this.getService().remove(value);
        } else if (name.equals("description")) {
          this.description = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059629:  return getCorsElement();
        case 1984153269:  return addService(); 
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059629: /*cors*/ return new String[] {"boolean"};
        case 1984153269: /*service*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("cors")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.security.cors");
        }
        else if (name.equals("service")) {
          return addService();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.security.description");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementRestSecurityComponent copy() {
        CapabilityStatementRestSecurityComponent dst = new CapabilityStatementRestSecurityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementRestSecurityComponent dst) {
        super.copyValues(dst);
        dst.cors = cors == null ? null : cors.copy();
        if (service != null) {
          dst.service = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : service)
            dst.service.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestSecurityComponent))
          return false;
        CapabilityStatementRestSecurityComponent o = (CapabilityStatementRestSecurityComponent) other_;
        return compareDeep(cors, o.cors, true) && compareDeep(service, o.service, true) && compareDeep(description, o.description, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestSecurityComponent))
          return false;
        CapabilityStatementRestSecurityComponent o = (CapabilityStatementRestSecurityComponent) other_;
        return compareValues(cors, o.cors, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(cors, service, description
          );
      }

  public String fhirType() {
    return "CapabilityStatement.rest.security";

  }

  }

    @Block()
    public static class CapabilityStatementRestResourceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A type of resource exposed via the restful interface.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A resource type that is supported", formalDefinition="A type of resource exposed via the restful interface." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
        protected CodeType type;

        /**
         * A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the "superset" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        @Child(name = "profile", type = {CanonicalType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="System-wide profile", formalDefinition="A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the \"superset\" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses)." )
        protected CanonicalType profile;

        /**
         * A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        @Child(name = "supportedProfile", type = {CanonicalType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Use-case specific profiles", formalDefinition="A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses)." )
        protected List<CanonicalType> supportedProfile;

        /**
         * Additional information about the resource type used by the system.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Additional information about the use of the resource type", formalDefinition="Additional information about the resource type used by the system." )
        protected MarkdownType documentation;

        /**
         * Identifies a restful operation supported by the solution.
         */
        @Child(name = "interaction", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What operations are supported?", formalDefinition="Identifies a restful operation supported by the solution." )
        protected List<ResourceInteractionComponent> interaction;

        /**
         * This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API.
         */
        @Child(name = "versioning", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="no-version | versioned | versioned-update", formalDefinition="This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/versioning-policy")
        protected Enumeration<ResourceVersionPolicy> versioning;

        /**
         * A flag for whether the server is able to return past versions as part of the vRead operation.
         */
        @Child(name = "readHistory", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether vRead can return past versions", formalDefinition="A flag for whether the server is able to return past versions as part of the vRead operation." )
        protected BooleanType readHistory;

        /**
         * A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server.
         */
        @Child(name = "updateCreate", type = {BooleanType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If update can commit to a new identity", formalDefinition="A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server." )
        protected BooleanType updateCreate;

        /**
         * A flag that indicates that the server supports conditional create.
         */
        @Child(name = "conditionalCreate", type = {BooleanType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If allows/uses conditional create", formalDefinition="A flag that indicates that the server supports conditional create." )
        protected BooleanType conditionalCreate;

        /**
         * A code that indicates how the server supports conditional read.
         */
        @Child(name = "conditionalRead", type = {CodeType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="not-supported | modified-since | not-match | full-support", formalDefinition="A code that indicates how the server supports conditional read." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/conditional-read-status")
        protected Enumeration<ConditionalReadStatus> conditionalRead;

        /**
         * A flag that indicates that the server supports conditional update.
         */
        @Child(name = "conditionalUpdate", type = {BooleanType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If allows/uses conditional update", formalDefinition="A flag that indicates that the server supports conditional update." )
        protected BooleanType conditionalUpdate;

        /**
         * A flag that indicates that the server supports conditional patch.
         */
        @Child(name = "conditionalPatch", type = {BooleanType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If allows/uses conditional patch", formalDefinition="A flag that indicates that the server supports conditional patch." )
        protected BooleanType conditionalPatch;

        /**
         * A code that indicates how the server supports conditional delete.
         */
        @Child(name = "conditionalDelete", type = {CodeType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="not-supported | single | multiple - how conditional delete is supported", formalDefinition="A code that indicates how the server supports conditional delete." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/conditional-delete-status")
        protected Enumeration<ConditionalDeleteStatus> conditionalDelete;

        /**
         * A set of flags that defines how references are supported.
         */
        @Child(name = "referencePolicy", type = {CodeType.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="literal | logical | resolves | enforced | local", formalDefinition="A set of flags that defines how references are supported." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/reference-handling-policy")
        protected List<Enumeration<ReferenceHandlingPolicy>> referencePolicy;

        /**
         * A list of _include values supported by the server.
         */
        @Child(name = "searchInclude", type = {StringType.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="_include values supported by the server", formalDefinition="A list of _include values supported by the server." )
        protected List<StringType> searchInclude;

        /**
         * A list of _revinclude (reverse include) values supported by the server.
         */
        @Child(name = "searchRevInclude", type = {StringType.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="_revinclude values supported by the server", formalDefinition="A list of _revinclude (reverse include) values supported by the server." )
        protected List<StringType> searchRevInclude;

        /**
         * Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.
         */
        @Child(name = "searchParam", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Search parameters supported by implementation", formalDefinition="Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation." )
        protected List<CapabilityStatementRestResourceSearchParamComponent> searchParam;

        /**
         * Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.
         */
        @Child(name = "operation", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Definition of a resource operation", formalDefinition="Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters." )
        protected List<CapabilityStatementRestResourceOperationComponent> operation;

        private static final long serialVersionUID = -1565226425L;

    /**
     * Constructor
     */
      public CapabilityStatementRestResourceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementRestResourceComponent(String type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (A type of resource exposed via the restful interface.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CodeType getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeType(); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A type of resource exposed via the restful interface.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setTypeElement(CodeType value) { 
          this.type = value;
          return this;
        }

        /**
         * @return A type of resource exposed via the restful interface.
         */
        public String getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value A type of resource exposed via the restful interface.
         */
        public CapabilityStatementRestResourceComponent setType(String value) { 
            if (this.type == null)
              this.type = new CodeType();
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #profile} (A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the "superset" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses).). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
         */
        public CanonicalType getProfileElement() { 
          if (this.profile == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.profile");
            else if (Configuration.doAutoCreate())
              this.profile = new CanonicalType(); // bb
          return this.profile;
        }

        public boolean hasProfileElement() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        public boolean hasProfile() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        /**
         * @param value {@link #profile} (A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the "superset" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses).). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setProfileElement(CanonicalType value) { 
          this.profile = value;
          return this;
        }

        /**
         * @return A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the "superset" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        public String getProfile() { 
          return this.profile == null ? null : this.profile.getValue();
        }

        /**
         * @param value A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the "superset" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        public CapabilityStatementRestResourceComponent setProfile(String value) { 
          if (Utilities.noString(value))
            this.profile = null;
          else {
            if (this.profile == null)
              this.profile = new CanonicalType();
            this.profile.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #supportedProfile} (A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public List<CanonicalType> getSupportedProfile() { 
          if (this.supportedProfile == null)
            this.supportedProfile = new ArrayList<CanonicalType>();
          return this.supportedProfile;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestResourceComponent setSupportedProfile(List<CanonicalType> theSupportedProfile) { 
          this.supportedProfile = theSupportedProfile;
          return this;
        }

        public boolean hasSupportedProfile() { 
          if (this.supportedProfile == null)
            return false;
          for (CanonicalType item : this.supportedProfile)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #supportedProfile} (A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public CanonicalType addSupportedProfileElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.supportedProfile == null)
            this.supportedProfile = new ArrayList<CanonicalType>();
          this.supportedProfile.add(t);
          return t;
        }

        /**
         * @param value {@link #supportedProfile} (A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public CapabilityStatementRestResourceComponent addSupportedProfile(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.supportedProfile == null)
            this.supportedProfile = new ArrayList<CanonicalType>();
          this.supportedProfile.add(t);
          return this;
        }

        /**
         * @param value {@link #supportedProfile} (A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public boolean hasSupportedProfile(String value) { 
          if (this.supportedProfile == null)
            return false;
          for (CanonicalType v : this.supportedProfile)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        /**
         * @return {@link #documentation} (Additional information about the resource type used by the system.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Additional information about the resource type used by the system.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Additional information about the resource type used by the system.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Additional information about the resource type used by the system.
         */
        public CapabilityStatementRestResourceComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #interaction} (Identifies a restful operation supported by the solution.)
         */
        public List<ResourceInteractionComponent> getInteraction() { 
          if (this.interaction == null)
            this.interaction = new ArrayList<ResourceInteractionComponent>();
          return this.interaction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestResourceComponent setInteraction(List<ResourceInteractionComponent> theInteraction) { 
          this.interaction = theInteraction;
          return this;
        }

        public boolean hasInteraction() { 
          if (this.interaction == null)
            return false;
          for (ResourceInteractionComponent item : this.interaction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ResourceInteractionComponent addInteraction() { //3
          ResourceInteractionComponent t = new ResourceInteractionComponent();
          if (this.interaction == null)
            this.interaction = new ArrayList<ResourceInteractionComponent>();
          this.interaction.add(t);
          return t;
        }

        public CapabilityStatementRestResourceComponent addInteraction(ResourceInteractionComponent t) { //3
          if (t == null)
            return this;
          if (this.interaction == null)
            this.interaction = new ArrayList<ResourceInteractionComponent>();
          this.interaction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #interaction}, creating it if it does not already exist {3}
         */
        public ResourceInteractionComponent getInteractionFirstRep() { 
          if (getInteraction().isEmpty()) {
            addInteraction();
          }
          return getInteraction().get(0);
        }

        /**
         * @return {@link #versioning} (This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API.). This is the underlying object with id, value and extensions. The accessor "getVersioning" gives direct access to the value
         */
        public Enumeration<ResourceVersionPolicy> getVersioningElement() { 
          if (this.versioning == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.versioning");
            else if (Configuration.doAutoCreate())
              this.versioning = new Enumeration<ResourceVersionPolicy>(new ResourceVersionPolicyEnumFactory()); // bb
          return this.versioning;
        }

        public boolean hasVersioningElement() { 
          return this.versioning != null && !this.versioning.isEmpty();
        }

        public boolean hasVersioning() { 
          return this.versioning != null && !this.versioning.isEmpty();
        }

        /**
         * @param value {@link #versioning} (This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API.). This is the underlying object with id, value and extensions. The accessor "getVersioning" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setVersioningElement(Enumeration<ResourceVersionPolicy> value) { 
          this.versioning = value;
          return this;
        }

        /**
         * @return This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API.
         */
        public ResourceVersionPolicy getVersioning() { 
          return this.versioning == null ? null : this.versioning.getValue();
        }

        /**
         * @param value This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API.
         */
        public CapabilityStatementRestResourceComponent setVersioning(ResourceVersionPolicy value) { 
          if (value == null)
            this.versioning = null;
          else {
            if (this.versioning == null)
              this.versioning = new Enumeration<ResourceVersionPolicy>(new ResourceVersionPolicyEnumFactory());
            this.versioning.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #readHistory} (A flag for whether the server is able to return past versions as part of the vRead operation.). This is the underlying object with id, value and extensions. The accessor "getReadHistory" gives direct access to the value
         */
        public BooleanType getReadHistoryElement() { 
          if (this.readHistory == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.readHistory");
            else if (Configuration.doAutoCreate())
              this.readHistory = new BooleanType(); // bb
          return this.readHistory;
        }

        public boolean hasReadHistoryElement() { 
          return this.readHistory != null && !this.readHistory.isEmpty();
        }

        public boolean hasReadHistory() { 
          return this.readHistory != null && !this.readHistory.isEmpty();
        }

        /**
         * @param value {@link #readHistory} (A flag for whether the server is able to return past versions as part of the vRead operation.). This is the underlying object with id, value and extensions. The accessor "getReadHistory" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setReadHistoryElement(BooleanType value) { 
          this.readHistory = value;
          return this;
        }

        /**
         * @return A flag for whether the server is able to return past versions as part of the vRead operation.
         */
        public boolean getReadHistory() { 
          return this.readHistory == null || this.readHistory.isEmpty() ? false : this.readHistory.getValue();
        }

        /**
         * @param value A flag for whether the server is able to return past versions as part of the vRead operation.
         */
        public CapabilityStatementRestResourceComponent setReadHistory(boolean value) { 
            if (this.readHistory == null)
              this.readHistory = new BooleanType();
            this.readHistory.setValue(value);
          return this;
        }

        /**
         * @return {@link #updateCreate} (A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server.). This is the underlying object with id, value and extensions. The accessor "getUpdateCreate" gives direct access to the value
         */
        public BooleanType getUpdateCreateElement() { 
          if (this.updateCreate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.updateCreate");
            else if (Configuration.doAutoCreate())
              this.updateCreate = new BooleanType(); // bb
          return this.updateCreate;
        }

        public boolean hasUpdateCreateElement() { 
          return this.updateCreate != null && !this.updateCreate.isEmpty();
        }

        public boolean hasUpdateCreate() { 
          return this.updateCreate != null && !this.updateCreate.isEmpty();
        }

        /**
         * @param value {@link #updateCreate} (A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server.). This is the underlying object with id, value and extensions. The accessor "getUpdateCreate" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setUpdateCreateElement(BooleanType value) { 
          this.updateCreate = value;
          return this;
        }

        /**
         * @return A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server.
         */
        public boolean getUpdateCreate() { 
          return this.updateCreate == null || this.updateCreate.isEmpty() ? false : this.updateCreate.getValue();
        }

        /**
         * @param value A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server.
         */
        public CapabilityStatementRestResourceComponent setUpdateCreate(boolean value) { 
            if (this.updateCreate == null)
              this.updateCreate = new BooleanType();
            this.updateCreate.setValue(value);
          return this;
        }

        /**
         * @return {@link #conditionalCreate} (A flag that indicates that the server supports conditional create.). This is the underlying object with id, value and extensions. The accessor "getConditionalCreate" gives direct access to the value
         */
        public BooleanType getConditionalCreateElement() { 
          if (this.conditionalCreate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.conditionalCreate");
            else if (Configuration.doAutoCreate())
              this.conditionalCreate = new BooleanType(); // bb
          return this.conditionalCreate;
        }

        public boolean hasConditionalCreateElement() { 
          return this.conditionalCreate != null && !this.conditionalCreate.isEmpty();
        }

        public boolean hasConditionalCreate() { 
          return this.conditionalCreate != null && !this.conditionalCreate.isEmpty();
        }

        /**
         * @param value {@link #conditionalCreate} (A flag that indicates that the server supports conditional create.). This is the underlying object with id, value and extensions. The accessor "getConditionalCreate" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setConditionalCreateElement(BooleanType value) { 
          this.conditionalCreate = value;
          return this;
        }

        /**
         * @return A flag that indicates that the server supports conditional create.
         */
        public boolean getConditionalCreate() { 
          return this.conditionalCreate == null || this.conditionalCreate.isEmpty() ? false : this.conditionalCreate.getValue();
        }

        /**
         * @param value A flag that indicates that the server supports conditional create.
         */
        public CapabilityStatementRestResourceComponent setConditionalCreate(boolean value) { 
            if (this.conditionalCreate == null)
              this.conditionalCreate = new BooleanType();
            this.conditionalCreate.setValue(value);
          return this;
        }

        /**
         * @return {@link #conditionalRead} (A code that indicates how the server supports conditional read.). This is the underlying object with id, value and extensions. The accessor "getConditionalRead" gives direct access to the value
         */
        public Enumeration<ConditionalReadStatus> getConditionalReadElement() { 
          if (this.conditionalRead == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.conditionalRead");
            else if (Configuration.doAutoCreate())
              this.conditionalRead = new Enumeration<ConditionalReadStatus>(new ConditionalReadStatusEnumFactory()); // bb
          return this.conditionalRead;
        }

        public boolean hasConditionalReadElement() { 
          return this.conditionalRead != null && !this.conditionalRead.isEmpty();
        }

        public boolean hasConditionalRead() { 
          return this.conditionalRead != null && !this.conditionalRead.isEmpty();
        }

        /**
         * @param value {@link #conditionalRead} (A code that indicates how the server supports conditional read.). This is the underlying object with id, value and extensions. The accessor "getConditionalRead" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setConditionalReadElement(Enumeration<ConditionalReadStatus> value) { 
          this.conditionalRead = value;
          return this;
        }

        /**
         * @return A code that indicates how the server supports conditional read.
         */
        public ConditionalReadStatus getConditionalRead() { 
          return this.conditionalRead == null ? null : this.conditionalRead.getValue();
        }

        /**
         * @param value A code that indicates how the server supports conditional read.
         */
        public CapabilityStatementRestResourceComponent setConditionalRead(ConditionalReadStatus value) { 
          if (value == null)
            this.conditionalRead = null;
          else {
            if (this.conditionalRead == null)
              this.conditionalRead = new Enumeration<ConditionalReadStatus>(new ConditionalReadStatusEnumFactory());
            this.conditionalRead.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #conditionalUpdate} (A flag that indicates that the server supports conditional update.). This is the underlying object with id, value and extensions. The accessor "getConditionalUpdate" gives direct access to the value
         */
        public BooleanType getConditionalUpdateElement() { 
          if (this.conditionalUpdate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.conditionalUpdate");
            else if (Configuration.doAutoCreate())
              this.conditionalUpdate = new BooleanType(); // bb
          return this.conditionalUpdate;
        }

        public boolean hasConditionalUpdateElement() { 
          return this.conditionalUpdate != null && !this.conditionalUpdate.isEmpty();
        }

        public boolean hasConditionalUpdate() { 
          return this.conditionalUpdate != null && !this.conditionalUpdate.isEmpty();
        }

        /**
         * @param value {@link #conditionalUpdate} (A flag that indicates that the server supports conditional update.). This is the underlying object with id, value and extensions. The accessor "getConditionalUpdate" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setConditionalUpdateElement(BooleanType value) { 
          this.conditionalUpdate = value;
          return this;
        }

        /**
         * @return A flag that indicates that the server supports conditional update.
         */
        public boolean getConditionalUpdate() { 
          return this.conditionalUpdate == null || this.conditionalUpdate.isEmpty() ? false : this.conditionalUpdate.getValue();
        }

        /**
         * @param value A flag that indicates that the server supports conditional update.
         */
        public CapabilityStatementRestResourceComponent setConditionalUpdate(boolean value) { 
            if (this.conditionalUpdate == null)
              this.conditionalUpdate = new BooleanType();
            this.conditionalUpdate.setValue(value);
          return this;
        }

        /**
         * @return {@link #conditionalPatch} (A flag that indicates that the server supports conditional patch.). This is the underlying object with id, value and extensions. The accessor "getConditionalPatch" gives direct access to the value
         */
        public BooleanType getConditionalPatchElement() { 
          if (this.conditionalPatch == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.conditionalPatch");
            else if (Configuration.doAutoCreate())
              this.conditionalPatch = new BooleanType(); // bb
          return this.conditionalPatch;
        }

        public boolean hasConditionalPatchElement() { 
          return this.conditionalPatch != null && !this.conditionalPatch.isEmpty();
        }

        public boolean hasConditionalPatch() { 
          return this.conditionalPatch != null && !this.conditionalPatch.isEmpty();
        }

        /**
         * @param value {@link #conditionalPatch} (A flag that indicates that the server supports conditional patch.). This is the underlying object with id, value and extensions. The accessor "getConditionalPatch" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setConditionalPatchElement(BooleanType value) { 
          this.conditionalPatch = value;
          return this;
        }

        /**
         * @return A flag that indicates that the server supports conditional patch.
         */
        public boolean getConditionalPatch() { 
          return this.conditionalPatch == null || this.conditionalPatch.isEmpty() ? false : this.conditionalPatch.getValue();
        }

        /**
         * @param value A flag that indicates that the server supports conditional patch.
         */
        public CapabilityStatementRestResourceComponent setConditionalPatch(boolean value) { 
            if (this.conditionalPatch == null)
              this.conditionalPatch = new BooleanType();
            this.conditionalPatch.setValue(value);
          return this;
        }

        /**
         * @return {@link #conditionalDelete} (A code that indicates how the server supports conditional delete.). This is the underlying object with id, value and extensions. The accessor "getConditionalDelete" gives direct access to the value
         */
        public Enumeration<ConditionalDeleteStatus> getConditionalDeleteElement() { 
          if (this.conditionalDelete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceComponent.conditionalDelete");
            else if (Configuration.doAutoCreate())
              this.conditionalDelete = new Enumeration<ConditionalDeleteStatus>(new ConditionalDeleteStatusEnumFactory()); // bb
          return this.conditionalDelete;
        }

        public boolean hasConditionalDeleteElement() { 
          return this.conditionalDelete != null && !this.conditionalDelete.isEmpty();
        }

        public boolean hasConditionalDelete() { 
          return this.conditionalDelete != null && !this.conditionalDelete.isEmpty();
        }

        /**
         * @param value {@link #conditionalDelete} (A code that indicates how the server supports conditional delete.). This is the underlying object with id, value and extensions. The accessor "getConditionalDelete" gives direct access to the value
         */
        public CapabilityStatementRestResourceComponent setConditionalDeleteElement(Enumeration<ConditionalDeleteStatus> value) { 
          this.conditionalDelete = value;
          return this;
        }

        /**
         * @return A code that indicates how the server supports conditional delete.
         */
        public ConditionalDeleteStatus getConditionalDelete() { 
          return this.conditionalDelete == null ? null : this.conditionalDelete.getValue();
        }

        /**
         * @param value A code that indicates how the server supports conditional delete.
         */
        public CapabilityStatementRestResourceComponent setConditionalDelete(ConditionalDeleteStatus value) { 
          if (value == null)
            this.conditionalDelete = null;
          else {
            if (this.conditionalDelete == null)
              this.conditionalDelete = new Enumeration<ConditionalDeleteStatus>(new ConditionalDeleteStatusEnumFactory());
            this.conditionalDelete.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #referencePolicy} (A set of flags that defines how references are supported.)
         */
        public List<Enumeration<ReferenceHandlingPolicy>> getReferencePolicy() { 
          if (this.referencePolicy == null)
            this.referencePolicy = new ArrayList<Enumeration<ReferenceHandlingPolicy>>();
          return this.referencePolicy;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestResourceComponent setReferencePolicy(List<Enumeration<ReferenceHandlingPolicy>> theReferencePolicy) { 
          this.referencePolicy = theReferencePolicy;
          return this;
        }

        public boolean hasReferencePolicy() { 
          if (this.referencePolicy == null)
            return false;
          for (Enumeration<ReferenceHandlingPolicy> item : this.referencePolicy)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #referencePolicy} (A set of flags that defines how references are supported.)
         */
        public Enumeration<ReferenceHandlingPolicy> addReferencePolicyElement() {//2 
          Enumeration<ReferenceHandlingPolicy> t = new Enumeration<ReferenceHandlingPolicy>(new ReferenceHandlingPolicyEnumFactory());
          if (this.referencePolicy == null)
            this.referencePolicy = new ArrayList<Enumeration<ReferenceHandlingPolicy>>();
          this.referencePolicy.add(t);
          return t;
        }

        /**
         * @param value {@link #referencePolicy} (A set of flags that defines how references are supported.)
         */
        public CapabilityStatementRestResourceComponent addReferencePolicy(ReferenceHandlingPolicy value) { //1
          Enumeration<ReferenceHandlingPolicy> t = new Enumeration<ReferenceHandlingPolicy>(new ReferenceHandlingPolicyEnumFactory());
          t.setValue(value);
          if (this.referencePolicy == null)
            this.referencePolicy = new ArrayList<Enumeration<ReferenceHandlingPolicy>>();
          this.referencePolicy.add(t);
          return this;
        }

        /**
         * @param value {@link #referencePolicy} (A set of flags that defines how references are supported.)
         */
        public boolean hasReferencePolicy(ReferenceHandlingPolicy value) { 
          if (this.referencePolicy == null)
            return false;
          for (Enumeration<ReferenceHandlingPolicy> v : this.referencePolicy)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #searchInclude} (A list of _include values supported by the server.)
         */
        public List<StringType> getSearchInclude() { 
          if (this.searchInclude == null)
            this.searchInclude = new ArrayList<StringType>();
          return this.searchInclude;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestResourceComponent setSearchInclude(List<StringType> theSearchInclude) { 
          this.searchInclude = theSearchInclude;
          return this;
        }

        public boolean hasSearchInclude() { 
          if (this.searchInclude == null)
            return false;
          for (StringType item : this.searchInclude)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #searchInclude} (A list of _include values supported by the server.)
         */
        public StringType addSearchIncludeElement() {//2 
          StringType t = new StringType();
          if (this.searchInclude == null)
            this.searchInclude = new ArrayList<StringType>();
          this.searchInclude.add(t);
          return t;
        }

        /**
         * @param value {@link #searchInclude} (A list of _include values supported by the server.)
         */
        public CapabilityStatementRestResourceComponent addSearchInclude(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.searchInclude == null)
            this.searchInclude = new ArrayList<StringType>();
          this.searchInclude.add(t);
          return this;
        }

        /**
         * @param value {@link #searchInclude} (A list of _include values supported by the server.)
         */
        public boolean hasSearchInclude(String value) { 
          if (this.searchInclude == null)
            return false;
          for (StringType v : this.searchInclude)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #searchRevInclude} (A list of _revinclude (reverse include) values supported by the server.)
         */
        public List<StringType> getSearchRevInclude() { 
          if (this.searchRevInclude == null)
            this.searchRevInclude = new ArrayList<StringType>();
          return this.searchRevInclude;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestResourceComponent setSearchRevInclude(List<StringType> theSearchRevInclude) { 
          this.searchRevInclude = theSearchRevInclude;
          return this;
        }

        public boolean hasSearchRevInclude() { 
          if (this.searchRevInclude == null)
            return false;
          for (StringType item : this.searchRevInclude)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #searchRevInclude} (A list of _revinclude (reverse include) values supported by the server.)
         */
        public StringType addSearchRevIncludeElement() {//2 
          StringType t = new StringType();
          if (this.searchRevInclude == null)
            this.searchRevInclude = new ArrayList<StringType>();
          this.searchRevInclude.add(t);
          return t;
        }

        /**
         * @param value {@link #searchRevInclude} (A list of _revinclude (reverse include) values supported by the server.)
         */
        public CapabilityStatementRestResourceComponent addSearchRevInclude(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.searchRevInclude == null)
            this.searchRevInclude = new ArrayList<StringType>();
          this.searchRevInclude.add(t);
          return this;
        }

        /**
         * @param value {@link #searchRevInclude} (A list of _revinclude (reverse include) values supported by the server.)
         */
        public boolean hasSearchRevInclude(String value) { 
          if (this.searchRevInclude == null)
            return false;
          for (StringType v : this.searchRevInclude)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #searchParam} (Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.)
         */
        public List<CapabilityStatementRestResourceSearchParamComponent> getSearchParam() { 
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          return this.searchParam;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestResourceComponent setSearchParam(List<CapabilityStatementRestResourceSearchParamComponent> theSearchParam) { 
          this.searchParam = theSearchParam;
          return this;
        }

        public boolean hasSearchParam() { 
          if (this.searchParam == null)
            return false;
          for (CapabilityStatementRestResourceSearchParamComponent item : this.searchParam)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatementRestResourceSearchParamComponent addSearchParam() { //3
          CapabilityStatementRestResourceSearchParamComponent t = new CapabilityStatementRestResourceSearchParamComponent();
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return t;
        }

        public CapabilityStatementRestResourceComponent addSearchParam(CapabilityStatementRestResourceSearchParamComponent t) { //3
          if (t == null)
            return this;
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #searchParam}, creating it if it does not already exist {3}
         */
        public CapabilityStatementRestResourceSearchParamComponent getSearchParamFirstRep() { 
          if (getSearchParam().isEmpty()) {
            addSearchParam();
          }
          return getSearchParam().get(0);
        }

        /**
         * @return {@link #operation} (Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.)
         */
        public List<CapabilityStatementRestResourceOperationComponent> getOperation() { 
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          return this.operation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementRestResourceComponent setOperation(List<CapabilityStatementRestResourceOperationComponent> theOperation) { 
          this.operation = theOperation;
          return this;
        }

        public boolean hasOperation() { 
          if (this.operation == null)
            return false;
          for (CapabilityStatementRestResourceOperationComponent item : this.operation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatementRestResourceOperationComponent addOperation() { //3
          CapabilityStatementRestResourceOperationComponent t = new CapabilityStatementRestResourceOperationComponent();
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          this.operation.add(t);
          return t;
        }

        public CapabilityStatementRestResourceComponent addOperation(CapabilityStatementRestResourceOperationComponent t) { //3
          if (t == null)
            return this;
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          this.operation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #operation}, creating it if it does not already exist {3}
         */
        public CapabilityStatementRestResourceOperationComponent getOperationFirstRep() { 
          if (getOperation().isEmpty()) {
            addOperation();
          }
          return getOperation().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "A type of resource exposed via the restful interface.", 0, 1, type));
          children.add(new Property("profile", "canonical(StructureDefinition)", "A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the \"superset\" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, 1, profile));
          children.add(new Property("supportedProfile", "canonical(StructureDefinition)", "A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, java.lang.Integer.MAX_VALUE, supportedProfile));
          children.add(new Property("documentation", "markdown", "Additional information about the resource type used by the system.", 0, 1, documentation));
          children.add(new Property("interaction", "", "Identifies a restful operation supported by the solution.", 0, java.lang.Integer.MAX_VALUE, interaction));
          children.add(new Property("versioning", "code", "This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API.", 0, 1, versioning));
          children.add(new Property("readHistory", "boolean", "A flag for whether the server is able to return past versions as part of the vRead operation.", 0, 1, readHistory));
          children.add(new Property("updateCreate", "boolean", "A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server.", 0, 1, updateCreate));
          children.add(new Property("conditionalCreate", "boolean", "A flag that indicates that the server supports conditional create.", 0, 1, conditionalCreate));
          children.add(new Property("conditionalRead", "code", "A code that indicates how the server supports conditional read.", 0, 1, conditionalRead));
          children.add(new Property("conditionalUpdate", "boolean", "A flag that indicates that the server supports conditional update.", 0, 1, conditionalUpdate));
          children.add(new Property("conditionalPatch", "boolean", "A flag that indicates that the server supports conditional patch.", 0, 1, conditionalPatch));
          children.add(new Property("conditionalDelete", "code", "A code that indicates how the server supports conditional delete.", 0, 1, conditionalDelete));
          children.add(new Property("referencePolicy", "code", "A set of flags that defines how references are supported.", 0, java.lang.Integer.MAX_VALUE, referencePolicy));
          children.add(new Property("searchInclude", "string", "A list of _include values supported by the server.", 0, java.lang.Integer.MAX_VALUE, searchInclude));
          children.add(new Property("searchRevInclude", "string", "A list of _revinclude (reverse include) values supported by the server.", 0, java.lang.Integer.MAX_VALUE, searchRevInclude));
          children.add(new Property("searchParam", "", "Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.", 0, java.lang.Integer.MAX_VALUE, searchParam));
          children.add(new Property("operation", "", "Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.", 0, java.lang.Integer.MAX_VALUE, operation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "A type of resource exposed via the restful interface.", 0, 1, type);
          case -309425751: /*profile*/  return new Property("profile", "canonical(StructureDefinition)", "A system-wide profile that is applied across *all* instances of the resource supported by the system. For example, if declared on Observation, this profile is the \"superset\" of capabilities for laboratory *and* vitals *and* other domains. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, 1, profile);
          case 1225477403: /*supportedProfile*/  return new Property("supportedProfile", "canonical(StructureDefinition)", "A list of profiles representing different use cases the system hosts/produces. A supported profile is a statement about the functionality of the data and services provided by the server (or the client) for supported use cases. For example, a system can define and declare multiple Observation profiles for laboratory observations, vital sign observations, etc. By declaring supported profiles, systems provide a way to determine whether individual resources are conformant. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, java.lang.Integer.MAX_VALUE, supportedProfile);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Additional information about the resource type used by the system.", 0, 1, documentation);
          case 1844104722: /*interaction*/  return new Property("interaction", "", "Identifies a restful operation supported by the solution.", 0, java.lang.Integer.MAX_VALUE, interaction);
          case -670487542: /*versioning*/  return new Property("versioning", "code", "This field is set to no-version to specify that the system does not support (server) or use (client) versioning for this resource type. If this has some other value, the server must at least correctly track and populate the versionId meta-property on resources. If the value is 'versioned-update', then the server supports all the versioning features, including using e-tags for version integrity in the API.", 0, 1, versioning);
          case 187518494: /*readHistory*/  return new Property("readHistory", "boolean", "A flag for whether the server is able to return past versions as part of the vRead operation.", 0, 1, readHistory);
          case -1400550619: /*updateCreate*/  return new Property("updateCreate", "boolean", "A flag to indicate that the server allows or needs to allow the client to create new identities on the server (that is, the client PUTs to a location where there is no existing resource). Allowing this operation means that the server allows the client to create new identities on the server.", 0, 1, updateCreate);
          case 6401826: /*conditionalCreate*/  return new Property("conditionalCreate", "boolean", "A flag that indicates that the server supports conditional create.", 0, 1, conditionalCreate);
          case 822786364: /*conditionalRead*/  return new Property("conditionalRead", "code", "A code that indicates how the server supports conditional read.", 0, 1, conditionalRead);
          case 519849711: /*conditionalUpdate*/  return new Property("conditionalUpdate", "boolean", "A flag that indicates that the server supports conditional update.", 0, 1, conditionalUpdate);
          case -265374366: /*conditionalPatch*/  return new Property("conditionalPatch", "boolean", "A flag that indicates that the server supports conditional patch.", 0, 1, conditionalPatch);
          case 23237585: /*conditionalDelete*/  return new Property("conditionalDelete", "code", "A code that indicates how the server supports conditional delete.", 0, 1, conditionalDelete);
          case 796257373: /*referencePolicy*/  return new Property("referencePolicy", "code", "A set of flags that defines how references are supported.", 0, java.lang.Integer.MAX_VALUE, referencePolicy);
          case -1035904544: /*searchInclude*/  return new Property("searchInclude", "string", "A list of _include values supported by the server.", 0, java.lang.Integer.MAX_VALUE, searchInclude);
          case -2123884979: /*searchRevInclude*/  return new Property("searchRevInclude", "string", "A list of _revinclude (reverse include) values supported by the server.", 0, java.lang.Integer.MAX_VALUE, searchRevInclude);
          case -553645115: /*searchParam*/  return new Property("searchParam", "", "Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.", 0, java.lang.Integer.MAX_VALUE, searchParam);
          case 1662702951: /*operation*/  return new Property("operation", "", "Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.", 0, java.lang.Integer.MAX_VALUE, operation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // CanonicalType
        case 1225477403: /*supportedProfile*/ return this.supportedProfile == null ? new Base[0] : this.supportedProfile.toArray(new Base[this.supportedProfile.size()]); // CanonicalType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        case 1844104722: /*interaction*/ return this.interaction == null ? new Base[0] : this.interaction.toArray(new Base[this.interaction.size()]); // ResourceInteractionComponent
        case -670487542: /*versioning*/ return this.versioning == null ? new Base[0] : new Base[] {this.versioning}; // Enumeration<ResourceVersionPolicy>
        case 187518494: /*readHistory*/ return this.readHistory == null ? new Base[0] : new Base[] {this.readHistory}; // BooleanType
        case -1400550619: /*updateCreate*/ return this.updateCreate == null ? new Base[0] : new Base[] {this.updateCreate}; // BooleanType
        case 6401826: /*conditionalCreate*/ return this.conditionalCreate == null ? new Base[0] : new Base[] {this.conditionalCreate}; // BooleanType
        case 822786364: /*conditionalRead*/ return this.conditionalRead == null ? new Base[0] : new Base[] {this.conditionalRead}; // Enumeration<ConditionalReadStatus>
        case 519849711: /*conditionalUpdate*/ return this.conditionalUpdate == null ? new Base[0] : new Base[] {this.conditionalUpdate}; // BooleanType
        case -265374366: /*conditionalPatch*/ return this.conditionalPatch == null ? new Base[0] : new Base[] {this.conditionalPatch}; // BooleanType
        case 23237585: /*conditionalDelete*/ return this.conditionalDelete == null ? new Base[0] : new Base[] {this.conditionalDelete}; // Enumeration<ConditionalDeleteStatus>
        case 796257373: /*referencePolicy*/ return this.referencePolicy == null ? new Base[0] : this.referencePolicy.toArray(new Base[this.referencePolicy.size()]); // Enumeration<ReferenceHandlingPolicy>
        case -1035904544: /*searchInclude*/ return this.searchInclude == null ? new Base[0] : this.searchInclude.toArray(new Base[this.searchInclude.size()]); // StringType
        case -2123884979: /*searchRevInclude*/ return this.searchRevInclude == null ? new Base[0] : this.searchRevInclude.toArray(new Base[this.searchRevInclude.size()]); // StringType
        case -553645115: /*searchParam*/ return this.searchParam == null ? new Base[0] : this.searchParam.toArray(new Base[this.searchParam.size()]); // CapabilityStatementRestResourceSearchParamComponent
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : this.operation.toArray(new Base[this.operation.size()]); // CapabilityStatementRestResourceOperationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -309425751: // profile
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1225477403: // supportedProfile
          this.getSupportedProfile().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1844104722: // interaction
          this.getInteraction().add((ResourceInteractionComponent) value); // ResourceInteractionComponent
          return value;
        case -670487542: // versioning
          value = new ResourceVersionPolicyEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.versioning = (Enumeration) value; // Enumeration<ResourceVersionPolicy>
          return value;
        case 187518494: // readHistory
          this.readHistory = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1400550619: // updateCreate
          this.updateCreate = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 6401826: // conditionalCreate
          this.conditionalCreate = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 822786364: // conditionalRead
          value = new ConditionalReadStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.conditionalRead = (Enumeration) value; // Enumeration<ConditionalReadStatus>
          return value;
        case 519849711: // conditionalUpdate
          this.conditionalUpdate = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -265374366: // conditionalPatch
          this.conditionalPatch = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 23237585: // conditionalDelete
          value = new ConditionalDeleteStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.conditionalDelete = (Enumeration) value; // Enumeration<ConditionalDeleteStatus>
          return value;
        case 796257373: // referencePolicy
          value = new ReferenceHandlingPolicyEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getReferencePolicy().add((Enumeration) value); // Enumeration<ReferenceHandlingPolicy>
          return value;
        case -1035904544: // searchInclude
          this.getSearchInclude().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -2123884979: // searchRevInclude
          this.getSearchRevInclude().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -553645115: // searchParam
          this.getSearchParam().add((CapabilityStatementRestResourceSearchParamComponent) value); // CapabilityStatementRestResourceSearchParamComponent
          return value;
        case 1662702951: // operation
          this.getOperation().add((CapabilityStatementRestResourceOperationComponent) value); // CapabilityStatementRestResourceOperationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("profile")) {
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("supportedProfile")) {
          this.getSupportedProfile().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("interaction")) {
          this.getInteraction().add((ResourceInteractionComponent) value);
        } else if (name.equals("versioning")) {
          value = new ResourceVersionPolicyEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.versioning = (Enumeration) value; // Enumeration<ResourceVersionPolicy>
        } else if (name.equals("readHistory")) {
          this.readHistory = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("updateCreate")) {
          this.updateCreate = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("conditionalCreate")) {
          this.conditionalCreate = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("conditionalRead")) {
          value = new ConditionalReadStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.conditionalRead = (Enumeration) value; // Enumeration<ConditionalReadStatus>
        } else if (name.equals("conditionalUpdate")) {
          this.conditionalUpdate = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("conditionalPatch")) {
          this.conditionalPatch = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("conditionalDelete")) {
          value = new ConditionalDeleteStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.conditionalDelete = (Enumeration) value; // Enumeration<ConditionalDeleteStatus>
        } else if (name.equals("referencePolicy")) {
          value = new ReferenceHandlingPolicyEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getReferencePolicy().add((Enumeration) value);
        } else if (name.equals("searchInclude")) {
          this.getSearchInclude().add(TypeConvertor.castToString(value));
        } else if (name.equals("searchRevInclude")) {
          this.getSearchRevInclude().add(TypeConvertor.castToString(value));
        } else if (name.equals("searchParam")) {
          this.getSearchParam().add((CapabilityStatementRestResourceSearchParamComponent) value);
        } else if (name.equals("operation")) {
          this.getOperation().add((CapabilityStatementRestResourceOperationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("profile")) {
          this.profile = null;
        } else if (name.equals("supportedProfile")) {
          this.getSupportedProfile().remove(value);
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else if (name.equals("interaction")) {
          this.getInteraction().remove((ResourceInteractionComponent) value);
        } else if (name.equals("versioning")) {
          value = new ResourceVersionPolicyEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.versioning = (Enumeration) value; // Enumeration<ResourceVersionPolicy>
        } else if (name.equals("readHistory")) {
          this.readHistory = null;
        } else if (name.equals("updateCreate")) {
          this.updateCreate = null;
        } else if (name.equals("conditionalCreate")) {
          this.conditionalCreate = null;
        } else if (name.equals("conditionalRead")) {
          value = new ConditionalReadStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.conditionalRead = (Enumeration) value; // Enumeration<ConditionalReadStatus>
        } else if (name.equals("conditionalUpdate")) {
          this.conditionalUpdate = null;
        } else if (name.equals("conditionalPatch")) {
          this.conditionalPatch = null;
        } else if (name.equals("conditionalDelete")) {
          value = new ConditionalDeleteStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.conditionalDelete = (Enumeration) value; // Enumeration<ConditionalDeleteStatus>
        } else if (name.equals("referencePolicy")) {
          value = new ReferenceHandlingPolicyEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getReferencePolicy().remove((Enumeration) value);
        } else if (name.equals("searchInclude")) {
          this.getSearchInclude().remove(value);
        } else if (name.equals("searchRevInclude")) {
          this.getSearchRevInclude().remove(value);
        } else if (name.equals("searchParam")) {
          this.getSearchParam().remove((CapabilityStatementRestResourceSearchParamComponent) value);
        } else if (name.equals("operation")) {
          this.getOperation().remove((CapabilityStatementRestResourceOperationComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case -309425751:  return getProfileElement();
        case 1225477403:  return addSupportedProfileElement();
        case 1587405498:  return getDocumentationElement();
        case 1844104722:  return addInteraction(); 
        case -670487542:  return getVersioningElement();
        case 187518494:  return getReadHistoryElement();
        case -1400550619:  return getUpdateCreateElement();
        case 6401826:  return getConditionalCreateElement();
        case 822786364:  return getConditionalReadElement();
        case 519849711:  return getConditionalUpdateElement();
        case -265374366:  return getConditionalPatchElement();
        case 23237585:  return getConditionalDeleteElement();
        case 796257373:  return addReferencePolicyElement();
        case -1035904544:  return addSearchIncludeElement();
        case -2123884979:  return addSearchRevIncludeElement();
        case -553645115:  return addSearchParam(); 
        case 1662702951:  return addOperation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case -309425751: /*profile*/ return new String[] {"canonical"};
        case 1225477403: /*supportedProfile*/ return new String[] {"canonical"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        case 1844104722: /*interaction*/ return new String[] {};
        case -670487542: /*versioning*/ return new String[] {"code"};
        case 187518494: /*readHistory*/ return new String[] {"boolean"};
        case -1400550619: /*updateCreate*/ return new String[] {"boolean"};
        case 6401826: /*conditionalCreate*/ return new String[] {"boolean"};
        case 822786364: /*conditionalRead*/ return new String[] {"code"};
        case 519849711: /*conditionalUpdate*/ return new String[] {"boolean"};
        case -265374366: /*conditionalPatch*/ return new String[] {"boolean"};
        case 23237585: /*conditionalDelete*/ return new String[] {"code"};
        case 796257373: /*referencePolicy*/ return new String[] {"code"};
        case -1035904544: /*searchInclude*/ return new String[] {"string"};
        case -2123884979: /*searchRevInclude*/ return new String[] {"string"};
        case -553645115: /*searchParam*/ return new String[] {};
        case 1662702951: /*operation*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.type");
        }
        else if (name.equals("profile")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.profile");
        }
        else if (name.equals("supportedProfile")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.supportedProfile");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.documentation");
        }
        else if (name.equals("interaction")) {
          return addInteraction();
        }
        else if (name.equals("versioning")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.versioning");
        }
        else if (name.equals("readHistory")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.readHistory");
        }
        else if (name.equals("updateCreate")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.updateCreate");
        }
        else if (name.equals("conditionalCreate")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.conditionalCreate");
        }
        else if (name.equals("conditionalRead")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.conditionalRead");
        }
        else if (name.equals("conditionalUpdate")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.conditionalUpdate");
        }
        else if (name.equals("conditionalPatch")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.conditionalPatch");
        }
        else if (name.equals("conditionalDelete")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.conditionalDelete");
        }
        else if (name.equals("referencePolicy")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.referencePolicy");
        }
        else if (name.equals("searchInclude")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.searchInclude");
        }
        else if (name.equals("searchRevInclude")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.searchRevInclude");
        }
        else if (name.equals("searchParam")) {
          return addSearchParam();
        }
        else if (name.equals("operation")) {
          return addOperation();
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementRestResourceComponent copy() {
        CapabilityStatementRestResourceComponent dst = new CapabilityStatementRestResourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementRestResourceComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.profile = profile == null ? null : profile.copy();
        if (supportedProfile != null) {
          dst.supportedProfile = new ArrayList<CanonicalType>();
          for (CanonicalType i : supportedProfile)
            dst.supportedProfile.add(i.copy());
        };
        dst.documentation = documentation == null ? null : documentation.copy();
        if (interaction != null) {
          dst.interaction = new ArrayList<ResourceInteractionComponent>();
          for (ResourceInteractionComponent i : interaction)
            dst.interaction.add(i.copy());
        };
        dst.versioning = versioning == null ? null : versioning.copy();
        dst.readHistory = readHistory == null ? null : readHistory.copy();
        dst.updateCreate = updateCreate == null ? null : updateCreate.copy();
        dst.conditionalCreate = conditionalCreate == null ? null : conditionalCreate.copy();
        dst.conditionalRead = conditionalRead == null ? null : conditionalRead.copy();
        dst.conditionalUpdate = conditionalUpdate == null ? null : conditionalUpdate.copy();
        dst.conditionalPatch = conditionalPatch == null ? null : conditionalPatch.copy();
        dst.conditionalDelete = conditionalDelete == null ? null : conditionalDelete.copy();
        if (referencePolicy != null) {
          dst.referencePolicy = new ArrayList<Enumeration<ReferenceHandlingPolicy>>();
          for (Enumeration<ReferenceHandlingPolicy> i : referencePolicy)
            dst.referencePolicy.add(i.copy());
        };
        if (searchInclude != null) {
          dst.searchInclude = new ArrayList<StringType>();
          for (StringType i : searchInclude)
            dst.searchInclude.add(i.copy());
        };
        if (searchRevInclude != null) {
          dst.searchRevInclude = new ArrayList<StringType>();
          for (StringType i : searchRevInclude)
            dst.searchRevInclude.add(i.copy());
        };
        if (searchParam != null) {
          dst.searchParam = new ArrayList<CapabilityStatementRestResourceSearchParamComponent>();
          for (CapabilityStatementRestResourceSearchParamComponent i : searchParam)
            dst.searchParam.add(i.copy());
        };
        if (operation != null) {
          dst.operation = new ArrayList<CapabilityStatementRestResourceOperationComponent>();
          for (CapabilityStatementRestResourceOperationComponent i : operation)
            dst.operation.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestResourceComponent))
          return false;
        CapabilityStatementRestResourceComponent o = (CapabilityStatementRestResourceComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(profile, o.profile, true) && compareDeep(supportedProfile, o.supportedProfile, true)
           && compareDeep(documentation, o.documentation, true) && compareDeep(interaction, o.interaction, true)
           && compareDeep(versioning, o.versioning, true) && compareDeep(readHistory, o.readHistory, true)
           && compareDeep(updateCreate, o.updateCreate, true) && compareDeep(conditionalCreate, o.conditionalCreate, true)
           && compareDeep(conditionalRead, o.conditionalRead, true) && compareDeep(conditionalUpdate, o.conditionalUpdate, true)
           && compareDeep(conditionalPatch, o.conditionalPatch, true) && compareDeep(conditionalDelete, o.conditionalDelete, true)
           && compareDeep(referencePolicy, o.referencePolicy, true) && compareDeep(searchInclude, o.searchInclude, true)
           && compareDeep(searchRevInclude, o.searchRevInclude, true) && compareDeep(searchParam, o.searchParam, true)
           && compareDeep(operation, o.operation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestResourceComponent))
          return false;
        CapabilityStatementRestResourceComponent o = (CapabilityStatementRestResourceComponent) other_;
        return compareValues(type, o.type, true) && compareValues(profile, o.profile, true) && compareValues(supportedProfile, o.supportedProfile, true)
           && compareValues(documentation, o.documentation, true) && compareValues(versioning, o.versioning, true)
           && compareValues(readHistory, o.readHistory, true) && compareValues(updateCreate, o.updateCreate, true)
           && compareValues(conditionalCreate, o.conditionalCreate, true) && compareValues(conditionalRead, o.conditionalRead, true)
           && compareValues(conditionalUpdate, o.conditionalUpdate, true) && compareValues(conditionalPatch, o.conditionalPatch, true)
           && compareValues(conditionalDelete, o.conditionalDelete, true) && compareValues(referencePolicy, o.referencePolicy, true)
           && compareValues(searchInclude, o.searchInclude, true) && compareValues(searchRevInclude, o.searchRevInclude, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, profile, supportedProfile
          , documentation, interaction, versioning, readHistory, updateCreate, conditionalCreate
          , conditionalRead, conditionalUpdate, conditionalPatch, conditionalDelete, referencePolicy
          , searchInclude, searchRevInclude, searchParam, operation);
      }

  public String fhirType() {
    return "CapabilityStatement.rest.resource";

  }

  }

    @Block()
    public static class ResourceInteractionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Coded identifier of the operation, supported by the system resource.
         */
        @Child(name = "code", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="read | vread | update | patch | delete | history-instance | history-type | create | search-type", formalDefinition="Coded identifier of the operation, supported by the system resource." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/type-restful-interaction")
        protected Enumeration<TypeRestfulInteraction> code;

        /**
         * Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Anything special about operation behavior", formalDefinition="Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = 2128937796L;

    /**
     * Constructor
     */
      public ResourceInteractionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ResourceInteractionComponent(TypeRestfulInteraction code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Coded identifier of the operation, supported by the system resource.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public Enumeration<TypeRestfulInteraction> getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResourceInteractionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Enumeration<TypeRestfulInteraction>(new TypeRestfulInteractionEnumFactory()); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Coded identifier of the operation, supported by the system resource.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public ResourceInteractionComponent setCodeElement(Enumeration<TypeRestfulInteraction> value) { 
          this.code = value;
          return this;
        }

        /**
         * @return Coded identifier of the operation, supported by the system resource.
         */
        public TypeRestfulInteraction getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value Coded identifier of the operation, supported by the system resource.
         */
        public ResourceInteractionComponent setCode(TypeRestfulInteraction value) { 
            if (this.code == null)
              this.code = new Enumeration<TypeRestfulInteraction>(new TypeRestfulInteractionEnumFactory());
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResourceInteractionComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public ResourceInteractionComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.
         */
        public ResourceInteractionComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "Coded identifier of the operation, supported by the system resource.", 0, 1, code));
          children.add(new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "Coded identifier of the operation, supported by the system resource.", 0, 1, code);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Enumeration<TypeRestfulInteraction>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          value = new TypeRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<TypeRestfulInteraction>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new TypeRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<TypeRestfulInteraction>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new TypeRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<TypeRestfulInteraction>
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.interaction.code");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.interaction.documentation");
        }
        else
          return super.addChild(name);
      }

      public ResourceInteractionComponent copy() {
        ResourceInteractionComponent dst = new ResourceInteractionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResourceInteractionComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResourceInteractionComponent))
          return false;
        ResourceInteractionComponent o = (ResourceInteractionComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResourceInteractionComponent))
          return false;
        ResourceInteractionComponent o = (ResourceInteractionComponent) other_;
        return compareValues(code, o.code, true) && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, documentation);
      }

  public String fhirType() {
    return "CapabilityStatement.rest.resource.interaction";

  }

  }

    @Block()
    public static class CapabilityStatementRestResourceSearchParamComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name for parameter in search url", formalDefinition="The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code." )
        protected StringType name;

        /**
         * An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.
         */
        @Child(name = "definition", type = {CanonicalType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Source of definition for parameter", formalDefinition="An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs." )
        protected CanonicalType definition;

        /**
         * The type of value a search parameter refers to, and how the content is interpreted.
         */
        @Child(name = "type", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="number | date | string | token | reference | composite | quantity | uri | special", formalDefinition="The type of value a search parameter refers to, and how the content is interpreted." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/search-param-type")
        protected Enumeration<SearchParamType> type;

        /**
         * This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Server-specific usage", formalDefinition="This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -171123928L;

    /**
     * Constructor
     */
      public CapabilityStatementRestResourceSearchParamComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementRestResourceSearchParamComponent(String name, SearchParamType type) {
        super();
        this.setName(name);
        this.setType(type);
      }

        /**
         * @return {@link #name} (The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceSearchParamComponent.name");
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
         * @param value {@link #name} (The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CapabilityStatementRestResourceSearchParamComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code.
         */
        public CapabilityStatementRestResourceSearchParamComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #definition} (An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CanonicalType getDefinitionElement() { 
          if (this.definition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceSearchParamComponent.definition");
            else if (Configuration.doAutoCreate())
              this.definition = new CanonicalType(); // bb
          return this.definition;
        }

        public boolean hasDefinitionElement() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        public boolean hasDefinition() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        /**
         * @param value {@link #definition} (An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CapabilityStatementRestResourceSearchParamComponent setDefinitionElement(CanonicalType value) { 
          this.definition = value;
          return this;
        }

        /**
         * @return An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.
         */
        public String getDefinition() { 
          return this.definition == null ? null : this.definition.getValue();
        }

        /**
         * @param value An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.
         */
        public CapabilityStatementRestResourceSearchParamComponent setDefinition(String value) { 
          if (Utilities.noString(value))
            this.definition = null;
          else {
            if (this.definition == null)
              this.definition = new CanonicalType();
            this.definition.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #type} (The type of value a search parameter refers to, and how the content is interpreted.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<SearchParamType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceSearchParamComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<SearchParamType>(new SearchParamTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of value a search parameter refers to, and how the content is interpreted.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CapabilityStatementRestResourceSearchParamComponent setTypeElement(Enumeration<SearchParamType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of value a search parameter refers to, and how the content is interpreted.
         */
        public SearchParamType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of value a search parameter refers to, and how the content is interpreted.
         */
        public CapabilityStatementRestResourceSearchParamComponent setType(SearchParamType value) { 
            if (this.type == null)
              this.type = new Enumeration<SearchParamType>(new SearchParamTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceSearchParamComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatementRestResourceSearchParamComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.
         */
        public CapabilityStatementRestResourceSearchParamComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code.", 0, 1, name));
          children.add(new Property("definition", "canonical(SearchParameter)", "An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.", 0, 1, definition));
          children.add(new Property("type", "code", "The type of value a search parameter refers to, and how the content is interpreted.", 0, 1, type));
          children.add(new Property("documentation", "markdown", "This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The label used for the search parameter in this particular system's API - i.e. the 'name' portion of the name-value pair that will appear as part of the search URL.  This SHOULD be the same as the SearchParameter.code of the defining SearchParameter.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple SearchParameters that happen to share the same code.", 0, 1, name);
          case -1014418093: /*definition*/  return new Property("definition", "canonical(SearchParameter)", "An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.", 0, 1, definition);
          case 3575610: /*type*/  return new Property("type", "code", "The type of value a search parameter refers to, and how the content is interpreted.", 0, 1, type);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // CanonicalType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<SearchParamType>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 3575610: // type
          value = new SearchParamTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SearchParamType>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("type")) {
          value = new SearchParamTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SearchParamType>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("definition")) {
          this.definition = null;
        } else if (name.equals("type")) {
          value = new SearchParamTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SearchParamType>
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1014418093:  return getDefinitionElement();
        case 3575610:  return getTypeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"canonical"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.searchParam.name");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.searchParam.definition");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.searchParam.type");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.searchParam.documentation");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementRestResourceSearchParamComponent copy() {
        CapabilityStatementRestResourceSearchParamComponent dst = new CapabilityStatementRestResourceSearchParamComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementRestResourceSearchParamComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.type = type == null ? null : type.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestResourceSearchParamComponent))
          return false;
        CapabilityStatementRestResourceSearchParamComponent o = (CapabilityStatementRestResourceSearchParamComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(definition, o.definition, true) && compareDeep(type, o.type, true)
           && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestResourceSearchParamComponent))
          return false;
        CapabilityStatementRestResourceSearchParamComponent o = (CapabilityStatementRestResourceSearchParamComponent) other_;
        return compareValues(name, o.name, true) && compareValues(definition, o.definition, true) && compareValues(type, o.type, true)
           && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, definition, type, documentation
          );
      }

  public String fhirType() {
    return "CapabilityStatement.rest.resource.searchParam";

  }

  }

    @Block()
    public static class CapabilityStatementRestResourceOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name by which the operation/query is invoked", formalDefinition="The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code." )
        protected StringType name;

        /**
         * Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.
         */
        @Child(name = "definition", type = {CanonicalType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The defined operation/query", formalDefinition="Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported." )
        protected CanonicalType definition;

        /**
         * Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specific details about operation behavior", formalDefinition="Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -388608084L;

    /**
     * Constructor
     */
      public CapabilityStatementRestResourceOperationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementRestResourceOperationComponent(String name, String definition) {
        super();
        this.setName(name);
        this.setDefinition(definition);
      }

        /**
         * @return {@link #name} (The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceOperationComponent.name");
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
         * @param value {@link #name} (The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CapabilityStatementRestResourceOperationComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code.
         */
        public CapabilityStatementRestResourceOperationComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #definition} (Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CanonicalType getDefinitionElement() { 
          if (this.definition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceOperationComponent.definition");
            else if (Configuration.doAutoCreate())
              this.definition = new CanonicalType(); // bb
          return this.definition;
        }

        public boolean hasDefinitionElement() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        public boolean hasDefinition() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        /**
         * @param value {@link #definition} (Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CapabilityStatementRestResourceOperationComponent setDefinitionElement(CanonicalType value) { 
          this.definition = value;
          return this;
        }

        /**
         * @return Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.
         */
        public String getDefinition() { 
          return this.definition == null ? null : this.definition.getValue();
        }

        /**
         * @param value Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.
         */
        public CapabilityStatementRestResourceOperationComponent setDefinition(String value) { 
            if (this.definition == null)
              this.definition = new CanonicalType();
            this.definition.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementRestResourceOperationComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatementRestResourceOperationComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.
         */
        public CapabilityStatementRestResourceOperationComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code.", 0, 1, name));
          children.add(new Property("definition", "canonical(OperationDefinition)", "Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.", 0, 1, definition));
          children.add(new Property("documentation", "markdown", "Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The name of the operation or query. For an operation, this name is prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called. This SHOULD be the same as the OperationDefinition.code of the defining OperationDefinition.  However, it can sometimes differ if necessary to disambiguate when a server supports multiple OperationDefinition that happen to share the same code.", 0, 1, name);
          case -1014418093: /*definition*/  return new Property("definition", "canonical(OperationDefinition)", "Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.", 0, 1, definition);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // CanonicalType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("definition")) {
          this.definition = null;
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1014418093:  return getDefinitionElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"canonical"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.operation.name");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.operation.definition");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.resource.operation.documentation");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementRestResourceOperationComponent copy() {
        CapabilityStatementRestResourceOperationComponent dst = new CapabilityStatementRestResourceOperationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementRestResourceOperationComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestResourceOperationComponent))
          return false;
        CapabilityStatementRestResourceOperationComponent o = (CapabilityStatementRestResourceOperationComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(definition, o.definition, true) && compareDeep(documentation, o.documentation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementRestResourceOperationComponent))
          return false;
        CapabilityStatementRestResourceOperationComponent o = (CapabilityStatementRestResourceOperationComponent) other_;
        return compareValues(name, o.name, true) && compareValues(definition, o.definition, true) && compareValues(documentation, o.documentation, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, definition, documentation
          );
      }

  public String fhirType() {
    return "CapabilityStatement.rest.resource.operation";

  }

  }

    @Block()
    public static class SystemInteractionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A coded identifier of the operation, supported by the system.
         */
        @Child(name = "code", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="transaction | batch | search-system | history-system", formalDefinition="A coded identifier of the operation, supported by the system." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/system-restful-interaction")
        protected Enumeration<SystemRestfulInteraction> code;

        /**
         * Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Anything special about operation behavior", formalDefinition="Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -1495143879L;

    /**
     * Constructor
     */
      public SystemInteractionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SystemInteractionComponent(SystemRestfulInteraction code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (A coded identifier of the operation, supported by the system.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public Enumeration<SystemRestfulInteraction> getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SystemInteractionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Enumeration<SystemRestfulInteraction>(new SystemRestfulInteractionEnumFactory()); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A coded identifier of the operation, supported by the system.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public SystemInteractionComponent setCodeElement(Enumeration<SystemRestfulInteraction> value) { 
          this.code = value;
          return this;
        }

        /**
         * @return A coded identifier of the operation, supported by the system.
         */
        public SystemRestfulInteraction getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value A coded identifier of the operation, supported by the system.
         */
        public SystemInteractionComponent setCode(SystemRestfulInteraction value) { 
            if (this.code == null)
              this.code = new Enumeration<SystemRestfulInteraction>(new SystemRestfulInteractionEnumFactory());
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SystemInteractionComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public SystemInteractionComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.
         */
        public SystemInteractionComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "A coded identifier of the operation, supported by the system.", 0, 1, code));
          children.add(new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "A coded identifier of the operation, supported by the system.", 0, 1, code);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Enumeration<SystemRestfulInteraction>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          value = new SystemRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<SystemRestfulInteraction>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new SystemRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<SystemRestfulInteraction>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new SystemRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<SystemRestfulInteraction>
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.interaction.code");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.rest.interaction.documentation");
        }
        else
          return super.addChild(name);
      }

      public SystemInteractionComponent copy() {
        SystemInteractionComponent dst = new SystemInteractionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SystemInteractionComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SystemInteractionComponent))
          return false;
        SystemInteractionComponent o = (SystemInteractionComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SystemInteractionComponent))
          return false;
        SystemInteractionComponent o = (SystemInteractionComponent) other_;
        return compareValues(code, o.code, true) && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, documentation);
      }

  public String fhirType() {
    return "CapabilityStatement.rest.interaction";

  }

  }

    @Block()
    public static class CapabilityStatementMessagingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An endpoint (network accessible address) to which messages and/or replies are to be sent.
         */
        @Child(name = "endpoint", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Where messages should be sent", formalDefinition="An endpoint (network accessible address) to which messages and/or replies are to be sent." )
        protected List<CapabilityStatementMessagingEndpointComponent> endpoint;

        /**
         * Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender).
         */
        @Child(name = "reliableCache", type = {UnsignedIntType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reliable Message Cache Length (min)", formalDefinition="Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender)." )
        protected UnsignedIntType reliableCache;

        /**
         * Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Messaging interface behavior details", formalDefinition="Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner." )
        protected MarkdownType documentation;

        /**
         * References to message definitions for messages this system can send or receive.
         */
        @Child(name = "supportedMessage", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Messages supported by this system", formalDefinition="References to message definitions for messages this system can send or receive." )
        protected List<CapabilityStatementMessagingSupportedMessageComponent> supportedMessage;

        private static final long serialVersionUID = 300411231L;

    /**
     * Constructor
     */
      public CapabilityStatementMessagingComponent() {
        super();
      }

        /**
         * @return {@link #endpoint} (An endpoint (network accessible address) to which messages and/or replies are to be sent.)
         */
        public List<CapabilityStatementMessagingEndpointComponent> getEndpoint() { 
          if (this.endpoint == null)
            this.endpoint = new ArrayList<CapabilityStatementMessagingEndpointComponent>();
          return this.endpoint;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementMessagingComponent setEndpoint(List<CapabilityStatementMessagingEndpointComponent> theEndpoint) { 
          this.endpoint = theEndpoint;
          return this;
        }

        public boolean hasEndpoint() { 
          if (this.endpoint == null)
            return false;
          for (CapabilityStatementMessagingEndpointComponent item : this.endpoint)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatementMessagingEndpointComponent addEndpoint() { //3
          CapabilityStatementMessagingEndpointComponent t = new CapabilityStatementMessagingEndpointComponent();
          if (this.endpoint == null)
            this.endpoint = new ArrayList<CapabilityStatementMessagingEndpointComponent>();
          this.endpoint.add(t);
          return t;
        }

        public CapabilityStatementMessagingComponent addEndpoint(CapabilityStatementMessagingEndpointComponent t) { //3
          if (t == null)
            return this;
          if (this.endpoint == null)
            this.endpoint = new ArrayList<CapabilityStatementMessagingEndpointComponent>();
          this.endpoint.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist {3}
         */
        public CapabilityStatementMessagingEndpointComponent getEndpointFirstRep() { 
          if (getEndpoint().isEmpty()) {
            addEndpoint();
          }
          return getEndpoint().get(0);
        }

        /**
         * @return {@link #reliableCache} (Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender).). This is the underlying object with id, value and extensions. The accessor "getReliableCache" gives direct access to the value
         */
        public UnsignedIntType getReliableCacheElement() { 
          if (this.reliableCache == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementMessagingComponent.reliableCache");
            else if (Configuration.doAutoCreate())
              this.reliableCache = new UnsignedIntType(); // bb
          return this.reliableCache;
        }

        public boolean hasReliableCacheElement() { 
          return this.reliableCache != null && !this.reliableCache.isEmpty();
        }

        public boolean hasReliableCache() { 
          return this.reliableCache != null && !this.reliableCache.isEmpty();
        }

        /**
         * @param value {@link #reliableCache} (Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender).). This is the underlying object with id, value and extensions. The accessor "getReliableCache" gives direct access to the value
         */
        public CapabilityStatementMessagingComponent setReliableCacheElement(UnsignedIntType value) { 
          this.reliableCache = value;
          return this;
        }

        /**
         * @return Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender).
         */
        public int getReliableCache() { 
          return this.reliableCache == null || this.reliableCache.isEmpty() ? 0 : this.reliableCache.getValue();
        }

        /**
         * @param value Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender).
         */
        public CapabilityStatementMessagingComponent setReliableCache(int value) { 
            if (this.reliableCache == null)
              this.reliableCache = new UnsignedIntType();
            this.reliableCache.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementMessagingComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatementMessagingComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner.
         */
        public CapabilityStatementMessagingComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #supportedMessage} (References to message definitions for messages this system can send or receive.)
         */
        public List<CapabilityStatementMessagingSupportedMessageComponent> getSupportedMessage() { 
          if (this.supportedMessage == null)
            this.supportedMessage = new ArrayList<CapabilityStatementMessagingSupportedMessageComponent>();
          return this.supportedMessage;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatementMessagingComponent setSupportedMessage(List<CapabilityStatementMessagingSupportedMessageComponent> theSupportedMessage) { 
          this.supportedMessage = theSupportedMessage;
          return this;
        }

        public boolean hasSupportedMessage() { 
          if (this.supportedMessage == null)
            return false;
          for (CapabilityStatementMessagingSupportedMessageComponent item : this.supportedMessage)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatementMessagingSupportedMessageComponent addSupportedMessage() { //3
          CapabilityStatementMessagingSupportedMessageComponent t = new CapabilityStatementMessagingSupportedMessageComponent();
          if (this.supportedMessage == null)
            this.supportedMessage = new ArrayList<CapabilityStatementMessagingSupportedMessageComponent>();
          this.supportedMessage.add(t);
          return t;
        }

        public CapabilityStatementMessagingComponent addSupportedMessage(CapabilityStatementMessagingSupportedMessageComponent t) { //3
          if (t == null)
            return this;
          if (this.supportedMessage == null)
            this.supportedMessage = new ArrayList<CapabilityStatementMessagingSupportedMessageComponent>();
          this.supportedMessage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #supportedMessage}, creating it if it does not already exist {3}
         */
        public CapabilityStatementMessagingSupportedMessageComponent getSupportedMessageFirstRep() { 
          if (getSupportedMessage().isEmpty()) {
            addSupportedMessage();
          }
          return getSupportedMessage().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("endpoint", "", "An endpoint (network accessible address) to which messages and/or replies are to be sent.", 0, java.lang.Integer.MAX_VALUE, endpoint));
          children.add(new Property("reliableCache", "unsignedInt", "Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender).", 0, 1, reliableCache));
          children.add(new Property("documentation", "markdown", "Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner.", 0, 1, documentation));
          children.add(new Property("supportedMessage", "", "References to message definitions for messages this system can send or receive.", 0, java.lang.Integer.MAX_VALUE, supportedMessage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1741102485: /*endpoint*/  return new Property("endpoint", "", "An endpoint (network accessible address) to which messages and/or replies are to be sent.", 0, java.lang.Integer.MAX_VALUE, endpoint);
          case 897803608: /*reliableCache*/  return new Property("reliableCache", "unsignedInt", "Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the cache length on the receiver should be (if a sender).", 0, 1, reliableCache);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Documentation about the system's messaging capabilities for this endpoint not otherwise documented by the capability statement.  For example, the process for becoming an authorized messaging exchange partner.", 0, 1, documentation);
          case -1805139079: /*supportedMessage*/  return new Property("supportedMessage", "", "References to message definitions for messages this system can send or receive.", 0, java.lang.Integer.MAX_VALUE, supportedMessage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // CapabilityStatementMessagingEndpointComponent
        case 897803608: /*reliableCache*/ return this.reliableCache == null ? new Base[0] : new Base[] {this.reliableCache}; // UnsignedIntType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        case -1805139079: /*supportedMessage*/ return this.supportedMessage == null ? new Base[0] : this.supportedMessage.toArray(new Base[this.supportedMessage.size()]); // CapabilityStatementMessagingSupportedMessageComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1741102485: // endpoint
          this.getEndpoint().add((CapabilityStatementMessagingEndpointComponent) value); // CapabilityStatementMessagingEndpointComponent
          return value;
        case 897803608: // reliableCache
          this.reliableCache = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1805139079: // supportedMessage
          this.getSupportedMessage().add((CapabilityStatementMessagingSupportedMessageComponent) value); // CapabilityStatementMessagingSupportedMessageComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("endpoint")) {
          this.getEndpoint().add((CapabilityStatementMessagingEndpointComponent) value);
        } else if (name.equals("reliableCache")) {
          this.reliableCache = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("supportedMessage")) {
          this.getSupportedMessage().add((CapabilityStatementMessagingSupportedMessageComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("endpoint")) {
          this.getEndpoint().remove((CapabilityStatementMessagingEndpointComponent) value);
        } else if (name.equals("reliableCache")) {
          this.reliableCache = null;
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else if (name.equals("supportedMessage")) {
          this.getSupportedMessage().remove((CapabilityStatementMessagingSupportedMessageComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1741102485:  return addEndpoint(); 
        case 897803608:  return getReliableCacheElement();
        case 1587405498:  return getDocumentationElement();
        case -1805139079:  return addSupportedMessage(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1741102485: /*endpoint*/ return new String[] {};
        case 897803608: /*reliableCache*/ return new String[] {"unsignedInt"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        case -1805139079: /*supportedMessage*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else if (name.equals("reliableCache")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.messaging.reliableCache");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.messaging.documentation");
        }
        else if (name.equals("supportedMessage")) {
          return addSupportedMessage();
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementMessagingComponent copy() {
        CapabilityStatementMessagingComponent dst = new CapabilityStatementMessagingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementMessagingComponent dst) {
        super.copyValues(dst);
        if (endpoint != null) {
          dst.endpoint = new ArrayList<CapabilityStatementMessagingEndpointComponent>();
          for (CapabilityStatementMessagingEndpointComponent i : endpoint)
            dst.endpoint.add(i.copy());
        };
        dst.reliableCache = reliableCache == null ? null : reliableCache.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
        if (supportedMessage != null) {
          dst.supportedMessage = new ArrayList<CapabilityStatementMessagingSupportedMessageComponent>();
          for (CapabilityStatementMessagingSupportedMessageComponent i : supportedMessage)
            dst.supportedMessage.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementMessagingComponent))
          return false;
        CapabilityStatementMessagingComponent o = (CapabilityStatementMessagingComponent) other_;
        return compareDeep(endpoint, o.endpoint, true) && compareDeep(reliableCache, o.reliableCache, true)
           && compareDeep(documentation, o.documentation, true) && compareDeep(supportedMessage, o.supportedMessage, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementMessagingComponent))
          return false;
        CapabilityStatementMessagingComponent o = (CapabilityStatementMessagingComponent) other_;
        return compareValues(reliableCache, o.reliableCache, true) && compareValues(documentation, o.documentation, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(endpoint, reliableCache, documentation
          , supportedMessage);
      }

  public String fhirType() {
    return "CapabilityStatement.messaging";

  }

  }

    @Block()
    public static class CapabilityStatementMessagingEndpointComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A list of the messaging transport protocol(s) identifiers, supported by this endpoint.
         */
        @Child(name = "protocol", type = {Coding.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="http | ftp | mllp +", formalDefinition="A list of the messaging transport protocol(s) identifiers, supported by this endpoint." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/message-transport")
        protected Coding protocol;

        /**
         * The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier.
         */
        @Child(name = "address", type = {UrlType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Network address or identifier of the end-point", formalDefinition="The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier." )
        protected UrlType address;

        private static final long serialVersionUID = -236946103L;

    /**
     * Constructor
     */
      public CapabilityStatementMessagingEndpointComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementMessagingEndpointComponent(Coding protocol, String address) {
        super();
        this.setProtocol(protocol);
        this.setAddress(address);
      }

        /**
         * @return {@link #protocol} (A list of the messaging transport protocol(s) identifiers, supported by this endpoint.)
         */
        public Coding getProtocol() { 
          if (this.protocol == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementMessagingEndpointComponent.protocol");
            else if (Configuration.doAutoCreate())
              this.protocol = new Coding(); // cc
          return this.protocol;
        }

        public boolean hasProtocol() { 
          return this.protocol != null && !this.protocol.isEmpty();
        }

        /**
         * @param value {@link #protocol} (A list of the messaging transport protocol(s) identifiers, supported by this endpoint.)
         */
        public CapabilityStatementMessagingEndpointComponent setProtocol(Coding value) { 
          this.protocol = value;
          return this;
        }

        /**
         * @return {@link #address} (The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier.). This is the underlying object with id, value and extensions. The accessor "getAddress" gives direct access to the value
         */
        public UrlType getAddressElement() { 
          if (this.address == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementMessagingEndpointComponent.address");
            else if (Configuration.doAutoCreate())
              this.address = new UrlType(); // bb
          return this.address;
        }

        public boolean hasAddressElement() { 
          return this.address != null && !this.address.isEmpty();
        }

        public boolean hasAddress() { 
          return this.address != null && !this.address.isEmpty();
        }

        /**
         * @param value {@link #address} (The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier.). This is the underlying object with id, value and extensions. The accessor "getAddress" gives direct access to the value
         */
        public CapabilityStatementMessagingEndpointComponent setAddressElement(UrlType value) { 
          this.address = value;
          return this;
        }

        /**
         * @return The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier.
         */
        public String getAddress() { 
          return this.address == null ? null : this.address.getValue();
        }

        /**
         * @param value The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier.
         */
        public CapabilityStatementMessagingEndpointComponent setAddress(String value) { 
            if (this.address == null)
              this.address = new UrlType();
            this.address.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("protocol", "Coding", "A list of the messaging transport protocol(s) identifiers, supported by this endpoint.", 0, 1, protocol));
          children.add(new Property("address", "url", "The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier.", 0, 1, address));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -989163880: /*protocol*/  return new Property("protocol", "Coding", "A list of the messaging transport protocol(s) identifiers, supported by this endpoint.", 0, 1, protocol);
          case -1147692044: /*address*/  return new Property("address", "url", "The network address of the endpoint. For solutions that do not use network addresses for routing, it can be just an identifier.", 0, 1, address);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -989163880: /*protocol*/ return this.protocol == null ? new Base[0] : new Base[] {this.protocol}; // Coding
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : new Base[] {this.address}; // UrlType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -989163880: // protocol
          this.protocol = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -1147692044: // address
          this.address = TypeConvertor.castToUrl(value); // UrlType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("protocol")) {
          this.protocol = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("address")) {
          this.address = TypeConvertor.castToUrl(value); // UrlType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("protocol")) {
          this.protocol = null;
        } else if (name.equals("address")) {
          this.address = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -989163880:  return getProtocol();
        case -1147692044:  return getAddressElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -989163880: /*protocol*/ return new String[] {"Coding"};
        case -1147692044: /*address*/ return new String[] {"url"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("protocol")) {
          this.protocol = new Coding();
          return this.protocol;
        }
        else if (name.equals("address")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.messaging.endpoint.address");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementMessagingEndpointComponent copy() {
        CapabilityStatementMessagingEndpointComponent dst = new CapabilityStatementMessagingEndpointComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementMessagingEndpointComponent dst) {
        super.copyValues(dst);
        dst.protocol = protocol == null ? null : protocol.copy();
        dst.address = address == null ? null : address.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementMessagingEndpointComponent))
          return false;
        CapabilityStatementMessagingEndpointComponent o = (CapabilityStatementMessagingEndpointComponent) other_;
        return compareDeep(protocol, o.protocol, true) && compareDeep(address, o.address, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementMessagingEndpointComponent))
          return false;
        CapabilityStatementMessagingEndpointComponent o = (CapabilityStatementMessagingEndpointComponent) other_;
        return compareValues(address, o.address, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(protocol, address);
      }

  public String fhirType() {
    return "CapabilityStatement.messaging.endpoint";

  }

  }

    @Block()
    public static class CapabilityStatementMessagingSupportedMessageComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The mode of this event declaration - whether application is sender or receiver.
         */
        @Child(name = "mode", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="sender | receiver", formalDefinition="The mode of this event declaration - whether application is sender or receiver." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/event-capability-mode")
        protected Enumeration<EventCapabilityMode> mode;

        /**
         * Points to a message definition that identifies the messaging event, message structure, allowed responses, etc.
         */
        @Child(name = "definition", type = {CanonicalType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Message supported by this system", formalDefinition="Points to a message definition that identifies the messaging event, message structure, allowed responses, etc." )
        protected CanonicalType definition;

        private static final long serialVersionUID = -1172840676L;

    /**
     * Constructor
     */
      public CapabilityStatementMessagingSupportedMessageComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementMessagingSupportedMessageComponent(EventCapabilityMode mode, String definition) {
        super();
        this.setMode(mode);
        this.setDefinition(definition);
      }

        /**
         * @return {@link #mode} (The mode of this event declaration - whether application is sender or receiver.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public Enumeration<EventCapabilityMode> getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementMessagingSupportedMessageComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new Enumeration<EventCapabilityMode>(new EventCapabilityModeEnumFactory()); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (The mode of this event declaration - whether application is sender or receiver.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public CapabilityStatementMessagingSupportedMessageComponent setModeElement(Enumeration<EventCapabilityMode> value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return The mode of this event declaration - whether application is sender or receiver.
         */
        public EventCapabilityMode getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value The mode of this event declaration - whether application is sender or receiver.
         */
        public CapabilityStatementMessagingSupportedMessageComponent setMode(EventCapabilityMode value) { 
            if (this.mode == null)
              this.mode = new Enumeration<EventCapabilityMode>(new EventCapabilityModeEnumFactory());
            this.mode.setValue(value);
          return this;
        }

        /**
         * @return {@link #definition} (Points to a message definition that identifies the messaging event, message structure, allowed responses, etc.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CanonicalType getDefinitionElement() { 
          if (this.definition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementMessagingSupportedMessageComponent.definition");
            else if (Configuration.doAutoCreate())
              this.definition = new CanonicalType(); // bb
          return this.definition;
        }

        public boolean hasDefinitionElement() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        public boolean hasDefinition() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        /**
         * @param value {@link #definition} (Points to a message definition that identifies the messaging event, message structure, allowed responses, etc.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CapabilityStatementMessagingSupportedMessageComponent setDefinitionElement(CanonicalType value) { 
          this.definition = value;
          return this;
        }

        /**
         * @return Points to a message definition that identifies the messaging event, message structure, allowed responses, etc.
         */
        public String getDefinition() { 
          return this.definition == null ? null : this.definition.getValue();
        }

        /**
         * @param value Points to a message definition that identifies the messaging event, message structure, allowed responses, etc.
         */
        public CapabilityStatementMessagingSupportedMessageComponent setDefinition(String value) { 
            if (this.definition == null)
              this.definition = new CanonicalType();
            this.definition.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("mode", "code", "The mode of this event declaration - whether application is sender or receiver.", 0, 1, mode));
          children.add(new Property("definition", "canonical(MessageDefinition)", "Points to a message definition that identifies the messaging event, message structure, allowed responses, etc.", 0, 1, definition));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3357091: /*mode*/  return new Property("mode", "code", "The mode of this event declaration - whether application is sender or receiver.", 0, 1, mode);
          case -1014418093: /*definition*/  return new Property("definition", "canonical(MessageDefinition)", "Points to a message definition that identifies the messaging event, message structure, allowed responses, etc.", 0, 1, definition);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<EventCapabilityMode>
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3357091: // mode
          value = new EventCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<EventCapabilityMode>
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new EventCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<EventCapabilityMode>
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new EventCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<EventCapabilityMode>
        } else if (name.equals("definition")) {
          this.definition = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091:  return getModeElement();
        case -1014418093:  return getDefinitionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return new String[] {"code"};
        case -1014418093: /*definition*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.messaging.supportedMessage.mode");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.messaging.supportedMessage.definition");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementMessagingSupportedMessageComponent copy() {
        CapabilityStatementMessagingSupportedMessageComponent dst = new CapabilityStatementMessagingSupportedMessageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementMessagingSupportedMessageComponent dst) {
        super.copyValues(dst);
        dst.mode = mode == null ? null : mode.copy();
        dst.definition = definition == null ? null : definition.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementMessagingSupportedMessageComponent))
          return false;
        CapabilityStatementMessagingSupportedMessageComponent o = (CapabilityStatementMessagingSupportedMessageComponent) other_;
        return compareDeep(mode, o.mode, true) && compareDeep(definition, o.definition, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementMessagingSupportedMessageComponent))
          return false;
        CapabilityStatementMessagingSupportedMessageComponent o = (CapabilityStatementMessagingSupportedMessageComponent) other_;
        return compareValues(mode, o.mode, true) && compareValues(definition, o.definition, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(mode, definition);
      }

  public String fhirType() {
    return "CapabilityStatement.messaging.supportedMessage";

  }

  }

    @Block()
    public static class CapabilityStatementDocumentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Mode of this document declaration - whether an application is a producer or consumer.
         */
        @Child(name = "mode", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="producer | consumer", formalDefinition="Mode of this document declaration - whether an application is a producer or consumer." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/document-mode")
        protected Enumeration<DocumentMode> mode;

        /**
         * A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of document support", formalDefinition="A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc." )
        protected MarkdownType documentation;

        /**
         * A profile on the document Bundle that constrains which resources are present, and their contents.
         */
        @Child(name = "profile", type = {CanonicalType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Constraint on the resources used in the document", formalDefinition="A profile on the document Bundle that constrains which resources are present, and their contents." )
        protected CanonicalType profile;

        private static final long serialVersionUID = 18026632L;

    /**
     * Constructor
     */
      public CapabilityStatementDocumentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatementDocumentComponent(DocumentMode mode, String profile) {
        super();
        this.setMode(mode);
        this.setProfile(profile);
      }

        /**
         * @return {@link #mode} (Mode of this document declaration - whether an application is a producer or consumer.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public Enumeration<DocumentMode> getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementDocumentComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new Enumeration<DocumentMode>(new DocumentModeEnumFactory()); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (Mode of this document declaration - whether an application is a producer or consumer.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public CapabilityStatementDocumentComponent setModeElement(Enumeration<DocumentMode> value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return Mode of this document declaration - whether an application is a producer or consumer.
         */
        public DocumentMode getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value Mode of this document declaration - whether an application is a producer or consumer.
         */
        public CapabilityStatementDocumentComponent setMode(DocumentMode value) { 
            if (this.mode == null)
              this.mode = new Enumeration<DocumentMode>(new DocumentModeEnumFactory());
            this.mode.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementDocumentComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatementDocumentComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc.
         */
        public CapabilityStatementDocumentComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #profile} (A profile on the document Bundle that constrains which resources are present, and their contents.). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
         */
        public CanonicalType getProfileElement() { 
          if (this.profile == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatementDocumentComponent.profile");
            else if (Configuration.doAutoCreate())
              this.profile = new CanonicalType(); // bb
          return this.profile;
        }

        public boolean hasProfileElement() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        public boolean hasProfile() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        /**
         * @param value {@link #profile} (A profile on the document Bundle that constrains which resources are present, and their contents.). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
         */
        public CapabilityStatementDocumentComponent setProfileElement(CanonicalType value) { 
          this.profile = value;
          return this;
        }

        /**
         * @return A profile on the document Bundle that constrains which resources are present, and their contents.
         */
        public String getProfile() { 
          return this.profile == null ? null : this.profile.getValue();
        }

        /**
         * @param value A profile on the document Bundle that constrains which resources are present, and their contents.
         */
        public CapabilityStatementDocumentComponent setProfile(String value) { 
            if (this.profile == null)
              this.profile = new CanonicalType();
            this.profile.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("mode", "code", "Mode of this document declaration - whether an application is a producer or consumer.", 0, 1, mode));
          children.add(new Property("documentation", "markdown", "A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc.", 0, 1, documentation));
          children.add(new Property("profile", "canonical(StructureDefinition)", "A profile on the document Bundle that constrains which resources are present, and their contents.", 0, 1, profile));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3357091: /*mode*/  return new Property("mode", "code", "Mode of this document declaration - whether an application is a producer or consumer.", 0, 1, mode);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "A description of how the application supports or uses the specified document profile.  For example, when documents are created, what action is taken with consumed documents, etc.", 0, 1, documentation);
          case -309425751: /*profile*/  return new Property("profile", "canonical(StructureDefinition)", "A profile on the document Bundle that constrains which resources are present, and their contents.", 0, 1, profile);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<DocumentMode>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3357091: // mode
          value = new DocumentModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<DocumentMode>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -309425751: // profile
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new DocumentModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<DocumentMode>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("profile")) {
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new DocumentModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<DocumentMode>
        } else if (name.equals("documentation")) {
          this.documentation = null;
        } else if (name.equals("profile")) {
          this.profile = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091:  return getModeElement();
        case 1587405498:  return getDocumentationElement();
        case -309425751:  return getProfileElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        case -309425751: /*profile*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.document.mode");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.document.documentation");
        }
        else if (name.equals("profile")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.document.profile");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatementDocumentComponent copy() {
        CapabilityStatementDocumentComponent dst = new CapabilityStatementDocumentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatementDocumentComponent dst) {
        super.copyValues(dst);
        dst.mode = mode == null ? null : mode.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
        dst.profile = profile == null ? null : profile.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementDocumentComponent))
          return false;
        CapabilityStatementDocumentComponent o = (CapabilityStatementDocumentComponent) other_;
        return compareDeep(mode, o.mode, true) && compareDeep(documentation, o.documentation, true) && compareDeep(profile, o.profile, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatementDocumentComponent))
          return false;
        CapabilityStatementDocumentComponent o = (CapabilityStatementDocumentComponent) other_;
        return compareValues(mode, o.mode, true) && compareValues(documentation, o.documentation, true) && compareValues(profile, o.profile, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(mode, documentation, profile
          );
      }

  public String fhirType() {
    return "CapabilityStatement.document";

  }

  }

    /**
     * An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this capability statement, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this CapabilityStatement when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the CapabilityStatement (business identifier)", formalDefinition="A formal identifier that is used to identify this CapabilityStatement when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the capability statement", formalDefinition="The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this capability statement (computer friendly)", formalDefinition="A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the capability statement.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this capability statement (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the capability statement." )
    protected StringType title;

    /**
     * The status of this capability statement. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this capability statement. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement.
     */
    @Child(name = "publisher", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the capability statement", formalDefinition="A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the capability statement is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for capability statement (if applicable)", formalDefinition="A legal or geographic region in which the capability statement is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this capability statement is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this capability statement is defined", formalDefinition="Explanation of why this capability statement is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    @Child(name = "kind", type = {CodeType.class}, order=17, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="instance | capability | requirements", formalDefinition="The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/capability-statement-kind")
    protected Enumeration<CapabilityStatementKind> kind;

    /**
     * Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.
     */
    @Child(name = "instantiates", type = {CanonicalType.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Canonical URL of another capability statement this implements", formalDefinition="Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details." )
    protected List<CanonicalType> instantiates;

    /**
     * Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.
     */
    @Child(name = "imports", type = {CanonicalType.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Canonical URL of another capability statement this adds to", formalDefinition="Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them." )
    protected List<CanonicalType> imports;

    /**
     * Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.
     */
    @Child(name = "software", type = {}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Software that is covered by this capability statement", formalDefinition="Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation." )
    protected CapabilityStatementSoftwareComponent software;

    /**
     * Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.
     */
    @Child(name = "implementation", type = {}, order=21, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this describes a specific instance", formalDefinition="Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program." )
    protected CapabilityStatementImplementationComponent implementation;

    /**
     * The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value.
     */
    @Child(name = "fhirVersion", type = {CodeType.class}, order=22, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="FHIR Version the system supports", formalDefinition="The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/FHIR-version")
    protected Enumeration<FHIRVersion> fhirVersion;

    /**
     * A list of the formats supported by this implementation using their content types.
     */
    @Child(name = "format", type = {CodeType.class}, order=23, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="formats supported (xml | json | ttl | mime type)", formalDefinition="A list of the formats supported by this implementation using their content types." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
    protected List<CodeType> format;

    /**
     * A list of the patch formats supported by this implementation using their content types.
     */
    @Child(name = "patchFormat", type = {CodeType.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Patch formats supported", formalDefinition="A list of the patch formats supported by this implementation using their content types." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
    protected List<CodeType> patchFormat;

    /**
     * A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header.
     */
    @Child(name = "acceptLanguage", type = {CodeType.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Languages supported", formalDefinition="A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
    protected List<CodeType> acceptLanguage;

    /**
     * A list of implementation guides that the server does (or should) support in their entirety.
     */
    @Child(name = "implementationGuide", type = {CanonicalType.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Implementation guides supported", formalDefinition="A list of implementation guides that the server does (or should) support in their entirety." )
    protected List<CanonicalType> implementationGuide;

    /**
     * A definition of the restful capabilities of the solution, if any.
     */
    @Child(name = "rest", type = {}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="If the endpoint is a RESTful one", formalDefinition="A definition of the restful capabilities of the solution, if any." )
    protected List<CapabilityStatementRestComponent> rest;

    /**
     * A description of the messaging capabilities of the solution.
     */
    @Child(name = "messaging", type = {}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="If messaging is supported", formalDefinition="A description of the messaging capabilities of the solution." )
    protected List<CapabilityStatementMessagingComponent> messaging;

    /**
     * A document definition.
     */
    @Child(name = "document", type = {}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Document definition", formalDefinition="A document definition." )
    protected List<CapabilityStatementDocumentComponent> document;

    private static final long serialVersionUID = -1432396321L;

  /**
   * Constructor
   */
    public CapabilityStatement() {
      super();
    }

  /**
   * Constructor
   */
    public CapabilityStatement(PublicationStatus status, Date date, CapabilityStatementKind kind, FHIRVersion fhirVersion, String format) {
      super();
      this.setStatus(status);
      this.setDate(date);
      this.setKind(kind);
      this.setFhirVersion(fhirVersion);
      this.addFormat(format);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public CapabilityStatement setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers.
     */
    public CapabilityStatement setUrl(String value) { 
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
     * @return {@link #identifier} (A formal identifier that is used to identify this CapabilityStatement when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setIdentifier(List<Identifier> theIdentifier) { 
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

    public CapabilityStatement addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public CapabilityStatement setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public CapabilityStatement setVersion(String value) { 
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
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      return this.versionAlgorithm;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new StringType();
      if (!(this.versionAlgorithm instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (StringType) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmStringType() {
        return this.versionAlgorithm instanceof StringType;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new Coding();
      if (!(this.versionAlgorithm instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (Coding) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmCoding() {
        return this.versionAlgorithm instanceof Coding;
    }

    public boolean hasVersionAlgorithm() { 
      return this.versionAlgorithm != null && !this.versionAlgorithm.isEmpty();
    }

    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public CapabilityStatement setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for CapabilityStatement.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.name");
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
     * @param value {@link #name} (A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public CapabilityStatement setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public CapabilityStatement setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the capability statement.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the capability statement.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public CapabilityStatement setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the capability statement.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the capability statement.
     */
    public CapabilityStatement setTitle(String value) { 
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
     * @return {@link #status} (The status of this capability statement. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.status");
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
     * @param value {@link #status} (The status of this capability statement. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public CapabilityStatement setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this capability statement. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this capability statement. Enables tracking the life-cycle of the content.
     */
    public CapabilityStatement setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public CapabilityStatement setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public CapabilityStatement setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public CapabilityStatement setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes.
     */
    public CapabilityStatement setDate(Date value) { 
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public CapabilityStatement setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement.
     */
    public CapabilityStatement setPublisher(String value) { 
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
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setContact(List<ContactDetail> theContact) { 
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

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public CapabilityStatement addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.description");
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
     * @param value {@link #description} (A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public CapabilityStatement setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    public CapabilityStatement setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setUseContext(List<UsageContext> theUseContext) { 
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

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public CapabilityStatement addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the capability statement is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public CodeableConcept addJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return t;
    }

    public CapabilityStatement addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explanation of why this capability statement is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.purpose");
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
     * @param value {@link #purpose} (Explanation of why this capability statement is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public CapabilityStatement setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this capability statement is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this capability statement is needed and why it has been designed as it has.
     */
    public CapabilityStatement setPurpose(String value) { 
      if (Utilities.noString(value))
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public CapabilityStatement setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement.
     */
    public CapabilityStatement setCopyright(String value) { 
      if (Utilities.noString(value))
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      if (this.copyrightLabel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.copyrightLabel");
        else if (Configuration.doAutoCreate())
          this.copyrightLabel = new StringType(); // bb
      return this.copyrightLabel;
    }

    public boolean hasCopyrightLabelElement() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    public boolean hasCopyrightLabel() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public CapabilityStatement setCopyrightLabelElement(StringType value) { 
      this.copyrightLabel = value;
      return this;
    }

    /**
     * @return A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public String getCopyrightLabel() { 
      return this.copyrightLabel == null ? null : this.copyrightLabel.getValue();
    }

    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public CapabilityStatement setCopyrightLabel(String value) { 
      if (Utilities.noString(value))
        this.copyrightLabel = null;
      else {
        if (this.copyrightLabel == null)
          this.copyrightLabel = new StringType();
        this.copyrightLabel.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #kind} (The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public Enumeration<CapabilityStatementKind> getKindElement() { 
      if (this.kind == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.kind");
        else if (Configuration.doAutoCreate())
          this.kind = new Enumeration<CapabilityStatementKind>(new CapabilityStatementKindEnumFactory()); // bb
      return this.kind;
    }

    public boolean hasKindElement() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    public boolean hasKind() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    /**
     * @param value {@link #kind} (The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public CapabilityStatement setKindElement(Enumeration<CapabilityStatementKind> value) { 
      this.kind = value;
      return this;
    }

    /**
     * @return The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    public CapabilityStatementKind getKind() { 
      return this.kind == null ? null : this.kind.getValue();
    }

    /**
     * @param value The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    public CapabilityStatement setKind(CapabilityStatementKind value) { 
        if (this.kind == null)
          this.kind = new Enumeration<CapabilityStatementKind>(new CapabilityStatementKindEnumFactory());
        this.kind.setValue(value);
      return this;
    }

    /**
     * @return {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public List<CanonicalType> getInstantiates() { 
      if (this.instantiates == null)
        this.instantiates = new ArrayList<CanonicalType>();
      return this.instantiates;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setInstantiates(List<CanonicalType> theInstantiates) { 
      this.instantiates = theInstantiates;
      return this;
    }

    public boolean hasInstantiates() { 
      if (this.instantiates == null)
        return false;
      for (CanonicalType item : this.instantiates)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public CanonicalType addInstantiatesElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiates == null)
        this.instantiates = new ArrayList<CanonicalType>();
      this.instantiates.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public CapabilityStatement addInstantiates(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiates == null)
        this.instantiates = new ArrayList<CanonicalType>();
      this.instantiates.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public boolean hasInstantiates(String value) { 
      if (this.instantiates == null)
        return false;
      for (CanonicalType v : this.instantiates)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #imports} (Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public List<CanonicalType> getImports() { 
      if (this.imports == null)
        this.imports = new ArrayList<CanonicalType>();
      return this.imports;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setImports(List<CanonicalType> theImports) { 
      this.imports = theImports;
      return this;
    }

    public boolean hasImports() { 
      if (this.imports == null)
        return false;
      for (CanonicalType item : this.imports)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #imports} (Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public CanonicalType addImportsElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.imports == null)
        this.imports = new ArrayList<CanonicalType>();
      this.imports.add(t);
      return t;
    }

    /**
     * @param value {@link #imports} (Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public CapabilityStatement addImports(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.imports == null)
        this.imports = new ArrayList<CanonicalType>();
      this.imports.add(t);
      return this;
    }

    /**
     * @param value {@link #imports} (Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public boolean hasImports(String value) { 
      if (this.imports == null)
        return false;
      for (CanonicalType v : this.imports)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #software} (Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.)
     */
    public CapabilityStatementSoftwareComponent getSoftware() { 
      if (this.software == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.software");
        else if (Configuration.doAutoCreate())
          this.software = new CapabilityStatementSoftwareComponent(); // cc
      return this.software;
    }

    public boolean hasSoftware() { 
      return this.software != null && !this.software.isEmpty();
    }

    /**
     * @param value {@link #software} (Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.)
     */
    public CapabilityStatement setSoftware(CapabilityStatementSoftwareComponent value) { 
      this.software = value;
      return this;
    }

    /**
     * @return {@link #implementation} (Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.)
     */
    public CapabilityStatementImplementationComponent getImplementation() { 
      if (this.implementation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.implementation");
        else if (Configuration.doAutoCreate())
          this.implementation = new CapabilityStatementImplementationComponent(); // cc
      return this.implementation;
    }

    public boolean hasImplementation() { 
      return this.implementation != null && !this.implementation.isEmpty();
    }

    /**
     * @param value {@link #implementation} (Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.)
     */
    public CapabilityStatement setImplementation(CapabilityStatementImplementationComponent value) { 
      this.implementation = value;
      return this;
    }

    /**
     * @return {@link #fhirVersion} (The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value.). This is the underlying object with id, value and extensions. The accessor "getFhirVersion" gives direct access to the value
     */
    public Enumeration<FHIRVersion> getFhirVersionElement() { 
      if (this.fhirVersion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement.fhirVersion");
        else if (Configuration.doAutoCreate())
          this.fhirVersion = new Enumeration<FHIRVersion>(new FHIRVersionEnumFactory()); // bb
      return this.fhirVersion;
    }

    public boolean hasFhirVersionElement() { 
      return this.fhirVersion != null && !this.fhirVersion.isEmpty();
    }

    public boolean hasFhirVersion() { 
      return this.fhirVersion != null && !this.fhirVersion.isEmpty();
    }

    /**
     * @param value {@link #fhirVersion} (The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value.). This is the underlying object with id, value and extensions. The accessor "getFhirVersion" gives direct access to the value
     */
    public CapabilityStatement setFhirVersionElement(Enumeration<FHIRVersion> value) { 
      this.fhirVersion = value;
      return this;
    }

    /**
     * @return The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value.
     */
    public FHIRVersion getFhirVersion() { 
      return this.fhirVersion == null ? null : this.fhirVersion.getValue();
    }

    /**
     * @param value The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value.
     */
    public CapabilityStatement setFhirVersion(FHIRVersion value) { 
        if (this.fhirVersion == null)
          this.fhirVersion = new Enumeration<FHIRVersion>(new FHIRVersionEnumFactory());
        this.fhirVersion.setValue(value);
      return this;
    }

    /**
     * @return {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public List<CodeType> getFormat() { 
      if (this.format == null)
        this.format = new ArrayList<CodeType>();
      return this.format;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setFormat(List<CodeType> theFormat) { 
      this.format = theFormat;
      return this;
    }

    public boolean hasFormat() { 
      if (this.format == null)
        return false;
      for (CodeType item : this.format)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public CodeType addFormatElement() {//2 
      CodeType t = new CodeType();
      if (this.format == null)
        this.format = new ArrayList<CodeType>();
      this.format.add(t);
      return t;
    }

    /**
     * @param value {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public CapabilityStatement addFormat(String value) { //1
      CodeType t = new CodeType();
      t.setValue(value);
      if (this.format == null)
        this.format = new ArrayList<CodeType>();
      this.format.add(t);
      return this;
    }

    /**
     * @param value {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public boolean hasFormat(String value) { 
      if (this.format == null)
        return false;
      for (CodeType v : this.format)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public List<CodeType> getPatchFormat() { 
      if (this.patchFormat == null)
        this.patchFormat = new ArrayList<CodeType>();
      return this.patchFormat;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setPatchFormat(List<CodeType> thePatchFormat) { 
      this.patchFormat = thePatchFormat;
      return this;
    }

    public boolean hasPatchFormat() { 
      if (this.patchFormat == null)
        return false;
      for (CodeType item : this.patchFormat)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public CodeType addPatchFormatElement() {//2 
      CodeType t = new CodeType();
      if (this.patchFormat == null)
        this.patchFormat = new ArrayList<CodeType>();
      this.patchFormat.add(t);
      return t;
    }

    /**
     * @param value {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public CapabilityStatement addPatchFormat(String value) { //1
      CodeType t = new CodeType();
      t.setValue(value);
      if (this.patchFormat == null)
        this.patchFormat = new ArrayList<CodeType>();
      this.patchFormat.add(t);
      return this;
    }

    /**
     * @param value {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public boolean hasPatchFormat(String value) { 
      if (this.patchFormat == null)
        return false;
      for (CodeType v : this.patchFormat)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #acceptLanguage} (A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header.)
     */
    public List<CodeType> getAcceptLanguage() { 
      if (this.acceptLanguage == null)
        this.acceptLanguage = new ArrayList<CodeType>();
      return this.acceptLanguage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setAcceptLanguage(List<CodeType> theAcceptLanguage) { 
      this.acceptLanguage = theAcceptLanguage;
      return this;
    }

    public boolean hasAcceptLanguage() { 
      if (this.acceptLanguage == null)
        return false;
      for (CodeType item : this.acceptLanguage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #acceptLanguage} (A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header.)
     */
    public CodeType addAcceptLanguageElement() {//2 
      CodeType t = new CodeType();
      if (this.acceptLanguage == null)
        this.acceptLanguage = new ArrayList<CodeType>();
      this.acceptLanguage.add(t);
      return t;
    }

    /**
     * @param value {@link #acceptLanguage} (A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header.)
     */
    public CapabilityStatement addAcceptLanguage(String value) { //1
      CodeType t = new CodeType();
      t.setValue(value);
      if (this.acceptLanguage == null)
        this.acceptLanguage = new ArrayList<CodeType>();
      this.acceptLanguage.add(t);
      return this;
    }

    /**
     * @param value {@link #acceptLanguage} (A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header.)
     */
    public boolean hasAcceptLanguage(String value) { 
      if (this.acceptLanguage == null)
        return false;
      for (CodeType v : this.acceptLanguage)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public List<CanonicalType> getImplementationGuide() { 
      if (this.implementationGuide == null)
        this.implementationGuide = new ArrayList<CanonicalType>();
      return this.implementationGuide;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setImplementationGuide(List<CanonicalType> theImplementationGuide) { 
      this.implementationGuide = theImplementationGuide;
      return this;
    }

    public boolean hasImplementationGuide() { 
      if (this.implementationGuide == null)
        return false;
      for (CanonicalType item : this.implementationGuide)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public CanonicalType addImplementationGuideElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.implementationGuide == null)
        this.implementationGuide = new ArrayList<CanonicalType>();
      this.implementationGuide.add(t);
      return t;
    }

    /**
     * @param value {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public CapabilityStatement addImplementationGuide(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.implementationGuide == null)
        this.implementationGuide = new ArrayList<CanonicalType>();
      this.implementationGuide.add(t);
      return this;
    }

    /**
     * @param value {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public boolean hasImplementationGuide(String value) { 
      if (this.implementationGuide == null)
        return false;
      for (CanonicalType v : this.implementationGuide)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #rest} (A definition of the restful capabilities of the solution, if any.)
     */
    public List<CapabilityStatementRestComponent> getRest() { 
      if (this.rest == null)
        this.rest = new ArrayList<CapabilityStatementRestComponent>();
      return this.rest;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setRest(List<CapabilityStatementRestComponent> theRest) { 
      this.rest = theRest;
      return this;
    }

    public boolean hasRest() { 
      if (this.rest == null)
        return false;
      for (CapabilityStatementRestComponent item : this.rest)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CapabilityStatementRestComponent addRest() { //3
      CapabilityStatementRestComponent t = new CapabilityStatementRestComponent();
      if (this.rest == null)
        this.rest = new ArrayList<CapabilityStatementRestComponent>();
      this.rest.add(t);
      return t;
    }

    public CapabilityStatement addRest(CapabilityStatementRestComponent t) { //3
      if (t == null)
        return this;
      if (this.rest == null)
        this.rest = new ArrayList<CapabilityStatementRestComponent>();
      this.rest.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #rest}, creating it if it does not already exist {3}
     */
    public CapabilityStatementRestComponent getRestFirstRep() { 
      if (getRest().isEmpty()) {
        addRest();
      }
      return getRest().get(0);
    }

    /**
     * @return {@link #messaging} (A description of the messaging capabilities of the solution.)
     */
    public List<CapabilityStatementMessagingComponent> getMessaging() { 
      if (this.messaging == null)
        this.messaging = new ArrayList<CapabilityStatementMessagingComponent>();
      return this.messaging;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setMessaging(List<CapabilityStatementMessagingComponent> theMessaging) { 
      this.messaging = theMessaging;
      return this;
    }

    public boolean hasMessaging() { 
      if (this.messaging == null)
        return false;
      for (CapabilityStatementMessagingComponent item : this.messaging)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CapabilityStatementMessagingComponent addMessaging() { //3
      CapabilityStatementMessagingComponent t = new CapabilityStatementMessagingComponent();
      if (this.messaging == null)
        this.messaging = new ArrayList<CapabilityStatementMessagingComponent>();
      this.messaging.add(t);
      return t;
    }

    public CapabilityStatement addMessaging(CapabilityStatementMessagingComponent t) { //3
      if (t == null)
        return this;
      if (this.messaging == null)
        this.messaging = new ArrayList<CapabilityStatementMessagingComponent>();
      this.messaging.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #messaging}, creating it if it does not already exist {3}
     */
    public CapabilityStatementMessagingComponent getMessagingFirstRep() { 
      if (getMessaging().isEmpty()) {
        addMessaging();
      }
      return getMessaging().get(0);
    }

    /**
     * @return {@link #document} (A document definition.)
     */
    public List<CapabilityStatementDocumentComponent> getDocument() { 
      if (this.document == null)
        this.document = new ArrayList<CapabilityStatementDocumentComponent>();
      return this.document;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement setDocument(List<CapabilityStatementDocumentComponent> theDocument) { 
      this.document = theDocument;
      return this;
    }

    public boolean hasDocument() { 
      if (this.document == null)
        return false;
      for (CapabilityStatementDocumentComponent item : this.document)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CapabilityStatementDocumentComponent addDocument() { //3
      CapabilityStatementDocumentComponent t = new CapabilityStatementDocumentComponent();
      if (this.document == null)
        this.document = new ArrayList<CapabilityStatementDocumentComponent>();
      this.document.add(t);
      return t;
    }

    public CapabilityStatement addDocument(CapabilityStatementDocumentComponent t) { //3
      if (t == null)
        return this;
      if (this.document == null)
        this.document = new ArrayList<CapabilityStatementDocumentComponent>();
      this.document.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #document}, creating it if it does not already exist {3}
     */
    public CapabilityStatementDocumentComponent getDocumentFirstRep() { 
      if (getDocument().isEmpty()) {
        addDocument();
      }
      return getDocument().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this CapabilityStatement when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the capability statement.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this capability statement. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the capability statement is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this capability statement is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("kind", "code", "The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).", 0, 1, kind));
        children.add(new Property("instantiates", "canonical(CapabilityStatement)", "Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.", 0, java.lang.Integer.MAX_VALUE, instantiates));
        children.add(new Property("imports", "canonical(CapabilityStatement)", "Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.", 0, java.lang.Integer.MAX_VALUE, imports));
        children.add(new Property("software", "", "Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.", 0, 1, software));
        children.add(new Property("implementation", "", "Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.", 0, 1, implementation));
        children.add(new Property("fhirVersion", "code", "The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value.", 0, 1, fhirVersion));
        children.add(new Property("format", "code", "A list of the formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, format));
        children.add(new Property("patchFormat", "code", "A list of the patch formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, patchFormat));
        children.add(new Property("acceptLanguage", "code", "A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header.", 0, java.lang.Integer.MAX_VALUE, acceptLanguage));
        children.add(new Property("implementationGuide", "canonical(ImplementationGuide)", "A list of implementation guides that the server does (or should) support in their entirety.", 0, java.lang.Integer.MAX_VALUE, implementationGuide));
        children.add(new Property("rest", "", "A definition of the restful capabilities of the solution, if any.", 0, java.lang.Integer.MAX_VALUE, rest));
        children.add(new Property("messaging", "", "A description of the messaging capabilities of the solution.", 0, java.lang.Integer.MAX_VALUE, messaging));
        children.add(new Property("document", "", "A document definition.", 0, java.lang.Integer.MAX_VALUE, document));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this capability statement when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this capability statement is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this CapabilityStatement when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the capability statement when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the capability statement. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the capability statement.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this capability statement. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this capability statement is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the capability statement was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the capability statement.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the capability statement from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the capability statement is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this capability statement is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the capability statement and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 3292052: /*kind*/  return new Property("kind", "code", "The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).", 0, 1, kind);
        case -246883639: /*instantiates*/  return new Property("instantiates", "canonical(CapabilityStatement)", "Reference to a canonical URL of another CapabilityStatement that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.", 0, java.lang.Integer.MAX_VALUE, instantiates);
        case 1926037870: /*imports*/  return new Property("imports", "canonical(CapabilityStatement)", "Reference to a canonical URL of another CapabilityStatement that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.", 0, java.lang.Integer.MAX_VALUE, imports);
        case 1319330215: /*software*/  return new Property("software", "", "Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.", 0, 1, software);
        case 1683336114: /*implementation*/  return new Property("implementation", "", "Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.", 0, 1, implementation);
        case 461006061: /*fhirVersion*/  return new Property("fhirVersion", "code", "The version of the FHIR specification that this CapabilityStatement describes (which SHALL be the same as the FHIR version of the CapabilityStatement itself). There is no default value.", 0, 1, fhirVersion);
        case -1268779017: /*format*/  return new Property("format", "code", "A list of the formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, format);
        case 172338783: /*patchFormat*/  return new Property("patchFormat", "code", "A list of the patch formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, patchFormat);
        case 1014178944: /*acceptLanguage*/  return new Property("acceptLanguage", "code", "A list of the languages supported by this implementation that are usefully supported in the ```Accept-Language``` header.", 0, java.lang.Integer.MAX_VALUE, acceptLanguage);
        case 156966506: /*implementationGuide*/  return new Property("implementationGuide", "canonical(ImplementationGuide)", "A list of implementation guides that the server does (or should) support in their entirety.", 0, java.lang.Integer.MAX_VALUE, implementationGuide);
        case 3496916: /*rest*/  return new Property("rest", "", "A definition of the restful capabilities of the solution, if any.", 0, java.lang.Integer.MAX_VALUE, rest);
        case -1440008444: /*messaging*/  return new Property("messaging", "", "A description of the messaging capabilities of the solution.", 0, java.lang.Integer.MAX_VALUE, messaging);
        case 861720859: /*document*/  return new Property("document", "", "A document definition.", 0, java.lang.Integer.MAX_VALUE, document);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 1508158071: /*versionAlgorithm*/ return this.versionAlgorithm == null ? new Base[0] : new Base[] {this.versionAlgorithm}; // DataType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<CapabilityStatementKind>
        case -246883639: /*instantiates*/ return this.instantiates == null ? new Base[0] : this.instantiates.toArray(new Base[this.instantiates.size()]); // CanonicalType
        case 1926037870: /*imports*/ return this.imports == null ? new Base[0] : this.imports.toArray(new Base[this.imports.size()]); // CanonicalType
        case 1319330215: /*software*/ return this.software == null ? new Base[0] : new Base[] {this.software}; // CapabilityStatementSoftwareComponent
        case 1683336114: /*implementation*/ return this.implementation == null ? new Base[0] : new Base[] {this.implementation}; // CapabilityStatementImplementationComponent
        case 461006061: /*fhirVersion*/ return this.fhirVersion == null ? new Base[0] : new Base[] {this.fhirVersion}; // Enumeration<FHIRVersion>
        case -1268779017: /*format*/ return this.format == null ? new Base[0] : this.format.toArray(new Base[this.format.size()]); // CodeType
        case 172338783: /*patchFormat*/ return this.patchFormat == null ? new Base[0] : this.patchFormat.toArray(new Base[this.patchFormat.size()]); // CodeType
        case 1014178944: /*acceptLanguage*/ return this.acceptLanguage == null ? new Base[0] : this.acceptLanguage.toArray(new Base[this.acceptLanguage.size()]); // CodeType
        case 156966506: /*implementationGuide*/ return this.implementationGuide == null ? new Base[0] : this.implementationGuide.toArray(new Base[this.implementationGuide.size()]); // CanonicalType
        case 3496916: /*rest*/ return this.rest == null ? new Base[0] : this.rest.toArray(new Base[this.rest.size()]); // CapabilityStatementRestComponent
        case -1440008444: /*messaging*/ return this.messaging == null ? new Base[0] : this.messaging.toArray(new Base[this.messaging.size()]); // CapabilityStatementMessagingComponent
        case 861720859: /*document*/ return this.document == null ? new Base[0] : this.document.toArray(new Base[this.document.size()]); // CapabilityStatementDocumentComponent
        default: return super.getProperty(hash, name, checkValid);
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
        case 1508158071: // versionAlgorithm
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
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
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 765157229: // copyrightLabel
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
          return value;
        case 3292052: // kind
          value = new CapabilityStatementKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CapabilityStatementKind>
          return value;
        case -246883639: // instantiates
          this.getInstantiates().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 1926037870: // imports
          this.getImports().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 1319330215: // software
          this.software = (CapabilityStatementSoftwareComponent) value; // CapabilityStatementSoftwareComponent
          return value;
        case 1683336114: // implementation
          this.implementation = (CapabilityStatementImplementationComponent) value; // CapabilityStatementImplementationComponent
          return value;
        case 461006061: // fhirVersion
          value = new FHIRVersionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.fhirVersion = (Enumeration) value; // Enumeration<FHIRVersion>
          return value;
        case -1268779017: // format
          this.getFormat().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        case 172338783: // patchFormat
          this.getPatchFormat().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        case 1014178944: // acceptLanguage
          this.getAcceptLanguage().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        case 156966506: // implementationGuide
          this.getImplementationGuide().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 3496916: // rest
          this.getRest().add((CapabilityStatementRestComponent) value); // CapabilityStatementRestComponent
          return value;
        case -1440008444: // messaging
          this.getMessaging().add((CapabilityStatementMessagingComponent) value); // CapabilityStatementMessagingComponent
          return value;
        case 861720859: // document
          this.getDocument().add((CapabilityStatementDocumentComponent) value); // CapabilityStatementDocumentComponent
          return value;
        default: return super.setProperty(hash, name, value);
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
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
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
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("kind")) {
          value = new CapabilityStatementKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CapabilityStatementKind>
        } else if (name.equals("instantiates")) {
          this.getInstantiates().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("imports")) {
          this.getImports().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("software")) {
          this.software = (CapabilityStatementSoftwareComponent) value; // CapabilityStatementSoftwareComponent
        } else if (name.equals("implementation")) {
          this.implementation = (CapabilityStatementImplementationComponent) value; // CapabilityStatementImplementationComponent
        } else if (name.equals("fhirVersion")) {
          value = new FHIRVersionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.fhirVersion = (Enumeration) value; // Enumeration<FHIRVersion>
        } else if (name.equals("format")) {
          this.getFormat().add(TypeConvertor.castToCode(value));
        } else if (name.equals("patchFormat")) {
          this.getPatchFormat().add(TypeConvertor.castToCode(value));
        } else if (name.equals("acceptLanguage")) {
          this.getAcceptLanguage().add(TypeConvertor.castToCode(value));
        } else if (name.equals("implementationGuide")) {
          this.getImplementationGuide().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("rest")) {
          this.getRest().add((CapabilityStatementRestComponent) value);
        } else if (name.equals("messaging")) {
          this.getMessaging().add((CapabilityStatementMessagingComponent) value);
        } else if (name.equals("document")) {
          this.getDocument().add((CapabilityStatementDocumentComponent) value);
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
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = null;
        } else if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = null;
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
        } else if (name.equals("copyright")) {
          this.copyright = null;
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = null;
        } else if (name.equals("kind")) {
          value = new CapabilityStatementKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CapabilityStatementKind>
        } else if (name.equals("instantiates")) {
          this.getInstantiates().remove(value);
        } else if (name.equals("imports")) {
          this.getImports().remove(value);
        } else if (name.equals("software")) {
          this.software = (CapabilityStatementSoftwareComponent) value; // CapabilityStatementSoftwareComponent
        } else if (name.equals("implementation")) {
          this.implementation = (CapabilityStatementImplementationComponent) value; // CapabilityStatementImplementationComponent
        } else if (name.equals("fhirVersion")) {
          value = new FHIRVersionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.fhirVersion = (Enumeration) value; // Enumeration<FHIRVersion>
        } else if (name.equals("format")) {
          this.getFormat().remove(value);
        } else if (name.equals("patchFormat")) {
          this.getPatchFormat().remove(value);
        } else if (name.equals("acceptLanguage")) {
          this.getAcceptLanguage().remove(value);
        } else if (name.equals("implementationGuide")) {
          this.getImplementationGuide().remove(value);
        } else if (name.equals("rest")) {
          this.getRest().remove((CapabilityStatementRestComponent) value);
        } else if (name.equals("messaging")) {
          this.getMessaging().remove((CapabilityStatementMessagingComponent) value);
        } else if (name.equals("document")) {
          this.getDocument().remove((CapabilityStatementDocumentComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case -115699031:  return getVersionAlgorithm();
        case 1508158071:  return getVersionAlgorithm();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 765157229:  return getCopyrightLabelElement();
        case 3292052:  return getKindElement();
        case -246883639:  return addInstantiatesElement();
        case 1926037870:  return addImportsElement();
        case 1319330215:  return getSoftware();
        case 1683336114:  return getImplementation();
        case 461006061:  return getFhirVersionElement();
        case -1268779017:  return addFormatElement();
        case 172338783:  return addPatchFormatElement();
        case 1014178944:  return addAcceptLanguageElement();
        case 156966506:  return addImplementationGuideElement();
        case 3496916:  return addRest(); 
        case -1440008444:  return addMessaging(); 
        case 861720859:  return addDocument(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 1508158071: /*versionAlgorithm*/ return new String[] {"string", "Coding"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 3292052: /*kind*/ return new String[] {"code"};
        case -246883639: /*instantiates*/ return new String[] {"canonical"};
        case 1926037870: /*imports*/ return new String[] {"canonical"};
        case 1319330215: /*software*/ return new String[] {};
        case 1683336114: /*implementation*/ return new String[] {};
        case 461006061: /*fhirVersion*/ return new String[] {"code"};
        case -1268779017: /*format*/ return new String[] {"code"};
        case 172338783: /*patchFormat*/ return new String[] {"code"};
        case 1014178944: /*acceptLanguage*/ return new String[] {"code"};
        case 156966506: /*implementationGuide*/ return new String[] {"canonical"};
        case 3496916: /*rest*/ return new String[] {};
        case -1440008444: /*messaging*/ return new String[] {};
        case 861720859: /*document*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.version");
        }
        else if (name.equals("versionAlgorithmString")) {
          this.versionAlgorithm = new StringType();
          return this.versionAlgorithm;
        }
        else if (name.equals("versionAlgorithmCoding")) {
          this.versionAlgorithm = new Coding();
          return this.versionAlgorithm;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.copyrightLabel");
        }
        else if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.kind");
        }
        else if (name.equals("instantiates")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.instantiates");
        }
        else if (name.equals("imports")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.imports");
        }
        else if (name.equals("software")) {
          this.software = new CapabilityStatementSoftwareComponent();
          return this.software;
        }
        else if (name.equals("implementation")) {
          this.implementation = new CapabilityStatementImplementationComponent();
          return this.implementation;
        }
        else if (name.equals("fhirVersion")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.fhirVersion");
        }
        else if (name.equals("format")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.format");
        }
        else if (name.equals("patchFormat")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.patchFormat");
        }
        else if (name.equals("acceptLanguage")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.acceptLanguage");
        }
        else if (name.equals("implementationGuide")) {
          throw new FHIRException("Cannot call addChild on a singleton property CapabilityStatement.implementationGuide");
        }
        else if (name.equals("rest")) {
          return addRest();
        }
        else if (name.equals("messaging")) {
          return addMessaging();
        }
        else if (name.equals("document")) {
          return addDocument();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CapabilityStatement";

  }

      public CapabilityStatement copy() {
        CapabilityStatement dst = new CapabilityStatement();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.versionAlgorithm = versionAlgorithm == null ? null : versionAlgorithm.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.copyrightLabel = copyrightLabel == null ? null : copyrightLabel.copy();
        dst.kind = kind == null ? null : kind.copy();
        if (instantiates != null) {
          dst.instantiates = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiates)
            dst.instantiates.add(i.copy());
        };
        if (imports != null) {
          dst.imports = new ArrayList<CanonicalType>();
          for (CanonicalType i : imports)
            dst.imports.add(i.copy());
        };
        dst.software = software == null ? null : software.copy();
        dst.implementation = implementation == null ? null : implementation.copy();
        dst.fhirVersion = fhirVersion == null ? null : fhirVersion.copy();
        if (format != null) {
          dst.format = new ArrayList<CodeType>();
          for (CodeType i : format)
            dst.format.add(i.copy());
        };
        if (patchFormat != null) {
          dst.patchFormat = new ArrayList<CodeType>();
          for (CodeType i : patchFormat)
            dst.patchFormat.add(i.copy());
        };
        if (acceptLanguage != null) {
          dst.acceptLanguage = new ArrayList<CodeType>();
          for (CodeType i : acceptLanguage)
            dst.acceptLanguage.add(i.copy());
        };
        if (implementationGuide != null) {
          dst.implementationGuide = new ArrayList<CanonicalType>();
          for (CanonicalType i : implementationGuide)
            dst.implementationGuide.add(i.copy());
        };
        if (rest != null) {
          dst.rest = new ArrayList<CapabilityStatementRestComponent>();
          for (CapabilityStatementRestComponent i : rest)
            dst.rest.add(i.copy());
        };
        if (messaging != null) {
          dst.messaging = new ArrayList<CapabilityStatementMessagingComponent>();
          for (CapabilityStatementMessagingComponent i : messaging)
            dst.messaging.add(i.copy());
        };
        if (document != null) {
          dst.document = new ArrayList<CapabilityStatementDocumentComponent>();
          for (CapabilityStatementDocumentComponent i : document)
            dst.document.add(i.copy());
        };
      }

      protected CapabilityStatement typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement))
          return false;
        CapabilityStatement o = (CapabilityStatement) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(copyrightLabel, o.copyrightLabel, true)
           && compareDeep(kind, o.kind, true) && compareDeep(instantiates, o.instantiates, true) && compareDeep(imports, o.imports, true)
           && compareDeep(software, o.software, true) && compareDeep(implementation, o.implementation, true)
           && compareDeep(fhirVersion, o.fhirVersion, true) && compareDeep(format, o.format, true) && compareDeep(patchFormat, o.patchFormat, true)
           && compareDeep(acceptLanguage, o.acceptLanguage, true) && compareDeep(implementationGuide, o.implementationGuide, true)
           && compareDeep(rest, o.rest, true) && compareDeep(messaging, o.messaging, true) && compareDeep(document, o.document, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement))
          return false;
        CapabilityStatement o = (CapabilityStatement) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(kind, o.kind, true) && compareValues(instantiates, o.instantiates, true) && compareValues(imports, o.imports, true)
           && compareValues(fhirVersion, o.fhirVersion, true) && compareValues(format, o.format, true) && compareValues(patchFormat, o.patchFormat, true)
           && compareValues(acceptLanguage, o.acceptLanguage, true) && compareValues(implementationGuide, o.implementationGuide, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, status, experimental, date, publisher, contact
          , description, useContext, jurisdiction, purpose, copyright, copyrightLabel, kind
          , instantiates, imports, software, implementation, fhirVersion, format, patchFormat
          , acceptLanguage, implementationGuide, rest, messaging, document);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CapabilityStatement;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition\r\n* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition\r\n* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [Library](library.html): A quantity- or range-valued use context assigned to the library\r\n* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide\r\n* [Library](library.html): A use context type and quantity- or range-based value assigned to the library\r\n* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide\r\n* [Library](library.html): A use context type and value assigned to the library\r\n* [Measure](measure.html): A use context type and value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition\r\n* [Citation](citation.html): A type of use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A type of use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition\r\n* [Evidence](evidence.html): A type of use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide\r\n* [Library](library.html): A type of use context assigned to the library\r\n* [Measure](measure.html): A type of use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A type of use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A type of use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A type of use context assigned to the test script\r\n* [ValueSet](valueset.html): A type of use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition\r\n* [Citation](citation.html): A use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context assigned to the event definition\r\n* [Evidence](evidence.html): A use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [Library](library.html): A use context assigned to the library\r\n* [Measure](measure.html): A use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context assigned to the test script\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The activity definition publication date\r\n* [ActorDefinition](actordefinition.html): The Actor Definition publication date\r\n* [CapabilityStatement](capabilitystatement.html): The capability statement publication date\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date\r\n* [Citation](citation.html): The citation publication date\r\n* [CodeSystem](codesystem.html): The code system publication date\r\n* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date\r\n* [ConceptMap](conceptmap.html): The concept map publication date\r\n* [ConditionDefinition](conditiondefinition.html): The condition definition publication date\r\n* [EventDefinition](eventdefinition.html): The event definition publication date\r\n* [Evidence](evidence.html): The evidence publication date\r\n* [EvidenceVariable](evidencevariable.html): The evidence variable publication date\r\n* [ExampleScenario](examplescenario.html): The example scenario publication date\r\n* [GraphDefinition](graphdefinition.html): The graph definition publication date\r\n* [ImplementationGuide](implementationguide.html): The implementation guide publication date\r\n* [Library](library.html): The library publication date\r\n* [Measure](measure.html): The measure publication date\r\n* [MessageDefinition](messagedefinition.html): The message definition publication date\r\n* [NamingSystem](namingsystem.html): The naming system publication date\r\n* [OperationDefinition](operationdefinition.html): The operation definition publication date\r\n* [PlanDefinition](plandefinition.html): The plan definition publication date\r\n* [Questionnaire](questionnaire.html): The questionnaire publication date\r\n* [Requirements](requirements.html): The requirements publication date\r\n* [SearchParameter](searchparameter.html): The search parameter publication date\r\n* [StructureDefinition](structuredefinition.html): The structure definition publication date\r\n* [StructureMap](structuremap.html): The structure map publication date\r\n* [SubscriptionTopic](subscriptiontopic.html): Date status first applied\r\n* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date\r\n* [TestScript](testscript.html): The test script publication date\r\n* [ValueSet](valueset.html): The value set publication date\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The description of the activity definition\r\n* [ActorDefinition](actordefinition.html): The description of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The description of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition\r\n* [Citation](citation.html): The description of the citation\r\n* [CodeSystem](codesystem.html): The description of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition\r\n* [ConceptMap](conceptmap.html): The description of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The description of the condition definition\r\n* [EventDefinition](eventdefinition.html): The description of the event definition\r\n* [Evidence](evidence.html): The description of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The description of the evidence variable\r\n* [GraphDefinition](graphdefinition.html): The description of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The description of the implementation guide\r\n* [Library](library.html): The description of the library\r\n* [Measure](measure.html): The description of the measure\r\n* [MessageDefinition](messagedefinition.html): The description of the message definition\r\n* [NamingSystem](namingsystem.html): The description of the naming system\r\n* [OperationDefinition](operationdefinition.html): The description of the operation definition\r\n* [PlanDefinition](plandefinition.html): The description of the plan definition\r\n* [Questionnaire](questionnaire.html): The description of the questionnaire\r\n* [Requirements](requirements.html): The description of the requirements\r\n* [SearchParameter](searchparameter.html): The description of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The description of the structure definition\r\n* [StructureMap](structuremap.html): The description of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities\r\n* [TestScript](testscript.html): The description of the test script\r\n* [ValueSet](valueset.html): The description of the value set\r\n", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [GraphDefinition](graphdefinition.html): External identifier for the graph definition\r\n* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [OperationDefinition](operationdefinition.html): External identifier for the search parameter\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SearchParameter](searchparameter.html): External identifier for the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestPlan](testplan.html): An identifier for the test plan\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition\r\n* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition\r\n* [Citation](citation.html): Intended jurisdiction for the citation\r\n* [CodeSystem](codesystem.html): Intended jurisdiction for the code system\r\n* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition\r\n* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition\r\n* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario\r\n* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition\r\n* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide\r\n* [Library](library.html): Intended jurisdiction for the library\r\n* [Measure](measure.html): Intended jurisdiction for the measure\r\n* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition\r\n* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system\r\n* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition\r\n* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition\r\n* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire\r\n* [Requirements](requirements.html): Intended jurisdiction for the requirements\r\n* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter\r\n* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition\r\n* [StructureMap](structuremap.html): Intended jurisdiction for the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities\r\n* [TestScript](testscript.html): Intended jurisdiction for the test script\r\n* [ValueSet](valueset.html): Intended jurisdiction for the value set\r\n", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition\r\n* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement\r\n* [Citation](citation.html): Computationally friendly name of the citation\r\n* [CodeSystem](codesystem.html): Computationally friendly name of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition\r\n* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition\r\n* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide\r\n* [Library](library.html): Computationally friendly name of the library\r\n* [Measure](measure.html): Computationally friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition\r\n* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system\r\n* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire\r\n* [Requirements](requirements.html): Computationally friendly name of the requirements\r\n* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition\r\n* [StructureMap](structuremap.html): Computationally friendly name of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): Computationally friendly name of the test script\r\n* [ValueSet](valueset.html): Computationally friendly name of the value set\r\n", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition\r\n* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition\r\n* [Citation](citation.html): Name of the publisher of the citation\r\n* [CodeSystem](codesystem.html): Name of the publisher of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition\r\n* [ConceptMap](conceptmap.html): Name of the publisher of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition\r\n* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition\r\n* [Evidence](evidence.html): Name of the publisher of the evidence\r\n* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide\r\n* [Library](library.html): Name of the publisher of the library\r\n* [Measure](measure.html): Name of the publisher of the measure\r\n* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition\r\n* [NamingSystem](namingsystem.html): Name of the publisher of the naming system\r\n* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition\r\n* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition\r\n* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire\r\n* [Requirements](requirements.html): Name of the publisher of the requirements\r\n* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition\r\n* [StructureMap](structuremap.html): Name of the publisher of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities\r\n* [TestScript](testscript.html): Name of the publisher of the test script\r\n* [ValueSet](valueset.html): Name of the publisher of the value set\r\n", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestPlan](testplan.html): The current status of the test plan\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition\r\n* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition\r\n* [Citation](citation.html): The human-friendly name of the citation\r\n* [CodeSystem](codesystem.html): The human-friendly name of the code system\r\n* [ConceptMap](conceptmap.html): The human-friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition\r\n* [Evidence](evidence.html): The human-friendly name of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable\r\n* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide\r\n* [Library](library.html): The human-friendly name of the library\r\n* [Measure](measure.html): The human-friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition\r\n* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition\r\n* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire\r\n* [Requirements](requirements.html): The human-friendly name of the requirements\r\n* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition\r\n* [StructureMap](structuremap.html): The human-friendly name of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): The human-friendly name of the test script\r\n* [ValueSet](valueset.html): The human-friendly name of the value set\r\n", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestPlan](testplan.html): The uri that identifies the test plan\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The business version of the activity definition\r\n* [ActorDefinition](actordefinition.html): The business version of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition\r\n* [Citation](citation.html): The business version of the citation\r\n* [CodeSystem](codesystem.html): The business version of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition\r\n* [ConceptMap](conceptmap.html): The business version of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition\r\n* [EventDefinition](eventdefinition.html): The business version of the event definition\r\n* [Evidence](evidence.html): The business version of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The business version of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The business version of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The business version of the implementation guide\r\n* [Library](library.html): The business version of the library\r\n* [Measure](measure.html): The business version of the measure\r\n* [MessageDefinition](messagedefinition.html): The business version of the message definition\r\n* [NamingSystem](namingsystem.html): The business version of the naming system\r\n* [OperationDefinition](operationdefinition.html): The business version of the operation definition\r\n* [PlanDefinition](plandefinition.html): The business version of the plan definition\r\n* [Questionnaire](questionnaire.html): The business version of the questionnaire\r\n* [Requirements](requirements.html): The business version of the requirements\r\n* [SearchParameter](searchparameter.html): The business version of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The business version of the structure definition\r\n* [StructureMap](structuremap.html): The business version of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities\r\n* [TestScript](testscript.html): The business version of the test script\r\n* [ValueSet](valueset.html): The business version of the value set\r\n", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);

 /**
   * Search parameter: <b>fhirversion</b>
   * <p>
   * Description: <b>The version of FHIR</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.fhirVersion</b><br>
   * </p>
   */
  @SearchParamDefinition(name="fhirversion", path="CapabilityStatement.fhirVersion", description="The version of FHIR", type="token" )
  public static final String SP_FHIRVERSION = "fhirversion";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>fhirversion</b>
   * <p>
   * Description: <b>The version of FHIR</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.fhirVersion</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FHIRVERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FHIRVERSION);

 /**
   * Search parameter: <b>format</b>
   * <p>
   * Description: <b>formats supported (xml | json | ttl | mime type)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.format</b><br>
   * </p>
   */
  @SearchParamDefinition(name="format", path="CapabilityStatement.format", description="formats supported (xml | json | ttl | mime type)", type="token" )
  public static final String SP_FORMAT = "format";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>format</b>
   * <p>
   * Description: <b>formats supported (xml | json | ttl | mime type)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.format</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FORMAT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FORMAT);

 /**
   * Search parameter: <b>guide</b>
   * <p>
   * Description: <b>Implementation guides supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement.implementationGuide</b><br>
   * </p>
   */
  @SearchParamDefinition(name="guide", path="CapabilityStatement.implementationGuide", description="Implementation guides supported", type="reference", target={ImplementationGuide.class } )
  public static final String SP_GUIDE = "guide";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>guide</b>
   * <p>
   * Description: <b>Implementation guides supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement.implementationGuide</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam GUIDE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_GUIDE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CapabilityStatement:guide</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_GUIDE = new ca.uhn.fhir.model.api.Include("CapabilityStatement:guide").toLocked();

 /**
   * Search parameter: <b>mode</b>
   * <p>
   * Description: <b>Mode - restful (server/client) or messaging (sender/receiver)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.rest.mode</b><br>
   * </p>
   */
  @SearchParamDefinition(name="mode", path="CapabilityStatement.rest.mode", description="Mode - restful (server/client) or messaging (sender/receiver)", type="token" )
  public static final String SP_MODE = "mode";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>mode</b>
   * <p>
   * Description: <b>Mode - restful (server/client) or messaging (sender/receiver)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.rest.mode</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MODE);

 /**
   * Search parameter: <b>resource-profile</b>
   * <p>
   * Description: <b>A profile id invoked in a capability statement</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement.rest.resource.profile</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resource-profile", path="CapabilityStatement.rest.resource.profile", description="A profile id invoked in a capability statement", type="reference", target={StructureDefinition.class } )
  public static final String SP_RESOURCE_PROFILE = "resource-profile";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resource-profile</b>
   * <p>
   * Description: <b>A profile id invoked in a capability statement</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement.rest.resource.profile</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RESOURCE_PROFILE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RESOURCE_PROFILE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CapabilityStatement:resource-profile</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RESOURCE_PROFILE = new ca.uhn.fhir.model.api.Include("CapabilityStatement:resource-profile").toLocked();

 /**
   * Search parameter: <b>resource</b>
   * <p>
   * Description: <b>Name of a resource mentioned in a capability statement</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.rest.resource.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resource", path="CapabilityStatement.rest.resource.type", description="Name of a resource mentioned in a capability statement", type="token" )
  public static final String SP_RESOURCE = "resource";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resource</b>
   * <p>
   * Description: <b>Name of a resource mentioned in a capability statement</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.rest.resource.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RESOURCE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RESOURCE);

 /**
   * Search parameter: <b>security-service</b>
   * <p>
   * Description: <b>OAuth | SMART-on-FHIR | NTLM | Basic | Kerberos | Certificates</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.rest.security.service</b><br>
   * </p>
   */
  @SearchParamDefinition(name="security-service", path="CapabilityStatement.rest.security.service", description="OAuth | SMART-on-FHIR | NTLM | Basic | Kerberos | Certificates", type="token" )
  public static final String SP_SECURITY_SERVICE = "security-service";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>security-service</b>
   * <p>
   * Description: <b>OAuth | SMART-on-FHIR | NTLM | Basic | Kerberos | Certificates</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.rest.security.service</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SECURITY_SERVICE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SECURITY_SERVICE);

 /**
   * Search parameter: <b>software</b>
   * <p>
   * Description: <b>Part of the name of a software application</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.software.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="software", path="CapabilityStatement.software.name", description="Part of the name of a software application", type="string" )
  public static final String SP_SOFTWARE = "software";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>software</b>
   * <p>
   * Description: <b>Part of the name of a software application</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.software.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam SOFTWARE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_SOFTWARE);

 /**
   * Search parameter: <b>supported-profile</b>
   * <p>
   * Description: <b>Profiles for use cases supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement.rest.resource.supportedProfile</b><br>
   * </p>
   */
  @SearchParamDefinition(name="supported-profile", path="CapabilityStatement.rest.resource.supportedProfile", description="Profiles for use cases supported", type="reference", target={StructureDefinition.class } )
  public static final String SP_SUPPORTED_PROFILE = "supported-profile";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>supported-profile</b>
   * <p>
   * Description: <b>Profiles for use cases supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement.rest.resource.supportedProfile</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUPPORTED_PROFILE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUPPORTED_PROFILE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CapabilityStatement:supported-profile</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUPPORTED_PROFILE = new ca.uhn.fhir.model.api.Include("CapabilityStatement:supported-profile").toLocked();

// Manual code (from Configuration.txt):

// end addition

}

