package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Enumerations;

public class Enumerations14_50 {
  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case REQUIRED:
            tgt.setValue(Enumerations.BindingStrength.REQUIRED);
            break;
          case EXTENSIBLE:
            tgt.setValue(Enumerations.BindingStrength.EXTENSIBLE);
            break;
          case PREFERRED:
            tgt.setValue(Enumerations.BindingStrength.PREFERRED);
            break;
          case EXAMPLE:
            tgt.setValue(Enumerations.BindingStrength.EXAMPLE);
            break;
          default:
            tgt.setValue(Enumerations.BindingStrength.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case REQUIRED:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.REQUIRED);
            break;
          case EXTENSIBLE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXTENSIBLE);
            break;
          case PREFERRED:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.PREFERRED);
            break;
          case EXAMPLE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXAMPLE);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case DRAFT:
            tgt.setValue(Enumerations.PublicationStatus.DRAFT);
            break;
          case ACTIVE:
            tgt.setValue(Enumerations.PublicationStatus.ACTIVE);
            break;
          case RETIRED:
            tgt.setValue(Enumerations.PublicationStatus.RETIRED);
            break;
          default:
            tgt.setValue(Enumerations.PublicationStatus.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatusEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case DRAFT:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.DRAFT);
            break;
          case ACTIVE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.ACTIVE);
            break;
          case RETIRED:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.RETIRED);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case NUMBER:
            tgt.setValue(Enumerations.SearchParamType.NUMBER);
            break;
          case DATE:
            tgt.setValue(Enumerations.SearchParamType.DATE);
            break;
          case STRING:
            tgt.setValue(Enumerations.SearchParamType.STRING);
            break;
          case TOKEN:
            tgt.setValue(Enumerations.SearchParamType.TOKEN);
            break;
          case REFERENCE:
            tgt.setValue(Enumerations.SearchParamType.REFERENCE);
            break;
          case COMPOSITE:
            tgt.setValue(Enumerations.SearchParamType.COMPOSITE);
            break;
          case QUANTITY:
            tgt.setValue(Enumerations.SearchParamType.QUANTITY);
            break;
          case URI:
            tgt.setValue(Enumerations.SearchParamType.URI);
            break;
          default:
            tgt.setValue(Enumerations.SearchParamType.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case NUMBER:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NUMBER);
            break;
          case DATE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.DATE);
            break;
          case STRING:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.STRING);
            break;
          case TOKEN:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.TOKEN);
            break;
          case REFERENCE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.REFERENCE);
            break;
          case COMPOSITE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.COMPOSITE);
            break;
          case QUANTITY:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.QUANTITY);
            break;
          case URI:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.URI);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NULL);
            break;
       }
}
    return tgt;
  }
}
