package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import java.util.Collections;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Decimal14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.UnsignedInt14_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Timing;

public class Timing14_50 {
  public static org.hl7.fhir.r5.model.Timing convertTiming(org.hl7.fhir.dstu2016may.model.Timing src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Timing tgt = new org.hl7.fhir.r5.model.Timing();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
    if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode()) tgt.setCode(CodeableConcept14_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Timing convertTiming(org.hl7.fhir.r5.model.Timing src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Timing tgt = new org.hl7.fhir.dstu2016may.model.Timing();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
    if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode()) tgt.setCode(CodeableConcept14_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r5.model.Timing.TimingRepeatComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getBounds()));
    if (src.hasCount()) tgt.setCount(src.getCount());
    if (src.hasCountMax()) tgt.setCountMax(src.getCountMax());
    if (src.hasDuration()) tgt.setDurationElement(Decimal14_50.convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal14_50.convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
    if (src.hasFrequency()) tgt.setFrequency(src.getFrequency());
    if (src.hasFrequencyMax()) tgt.setFrequencyMax(src.getFrequencyMax());
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal14_50.convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal14_50.convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
    if (src.hasWhen()) tgt.setWhen(Collections.singletonList(convertEventTiming(src.getWhenElement())));
    if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt14_50.convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getBounds()));
    if (src.hasCount()) tgt.setCount(src.getCount());
    if (src.hasCountMax()) tgt.setCountMax(src.getCountMax());
    if (src.hasDuration()) tgt.setDurationElement(Decimal14_50.convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal14_50.convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
    if (src.hasFrequency()) tgt.setFrequency(src.getFrequency());
    if (src.hasFrequencyMax()) tgt.setFrequencyMax(src.getFrequencyMax());
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal14_50.convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal14_50.convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
    if (src.hasWhen()) tgt.setWhenElement(convertEventTiming(src.getWhen().get(0)));
    if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt14_50.convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.UnitsOfTimeEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case S:
            tgt.setValue(Timing.UnitsOfTime.S);
            break;
          case MIN:
            tgt.setValue(Timing.UnitsOfTime.MIN);
            break;
          case H:
            tgt.setValue(Timing.UnitsOfTime.H);
            break;
          case D:
            tgt.setValue(Timing.UnitsOfTime.D);
            break;
          case WK:
            tgt.setValue(Timing.UnitsOfTime.WK);
            break;
          case MO:
            tgt.setValue(Timing.UnitsOfTime.MO);
            break;
          case A:
            tgt.setValue(Timing.UnitsOfTime.A);
            break;
          default:
            tgt.setValue(Timing.UnitsOfTime.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTimeEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case S:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.S);
            break;
          case MIN:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.MIN);
            break;
          case H:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.H);
            break;
          case D:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.D);
            break;
          case WK:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.WK);
            break;
          case MO:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.MO);
            break;
          case A:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.A);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.EventTimingEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case HS:
            tgt.setValue(Timing.EventTiming.HS);
            break;
          case WAKE:
            tgt.setValue(Timing.EventTiming.WAKE);
            break;
          case C:
            tgt.setValue(Timing.EventTiming.C);
            break;
          case CM:
            tgt.setValue(Timing.EventTiming.CM);
            break;
          case CD:
            tgt.setValue(Timing.EventTiming.CD);
            break;
          case CV:
            tgt.setValue(Timing.EventTiming.CV);
            break;
          case AC:
            tgt.setValue(Timing.EventTiming.AC);
            break;
          case ACM:
            tgt.setValue(Timing.EventTiming.ACM);
            break;
          case ACD:
            tgt.setValue(Timing.EventTiming.ACD);
            break;
          case ACV:
            tgt.setValue(Timing.EventTiming.ACV);
            break;
          case PC:
            tgt.setValue(Timing.EventTiming.PC);
            break;
          case PCM:
            tgt.setValue(Timing.EventTiming.PCM);
            break;
          case PCD:
            tgt.setValue(Timing.EventTiming.PCD);
            break;
          case PCV:
            tgt.setValue(Timing.EventTiming.PCV);
            break;
          default:
            tgt.setValue(Timing.EventTiming.NULL);
            break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.EventTiming> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Timing.EventTimingEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case HS:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.HS);
            break;
          case WAKE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.WAKE);
            break;
          case C:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.C);
            break;
          case CM:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CM);
            break;
          case CD:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CD);
            break;
          case CV:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CV);
            break;
          case AC:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.AC);
            break;
          case ACM:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACM);
            break;
          case ACD:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACD);
            break;
          case ACV:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACV);
            break;
          case PC:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PC);
            break;
          case PCM:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCM);
            break;
          case PCD:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCD);
            break;
          case PCV:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCV);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.NULL);
            break;
       }
}
    return tgt;
  }
}
