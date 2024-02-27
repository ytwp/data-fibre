/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TFeMemoryItem implements org.apache.thrift.TBase<TFeMemoryItem, TFeMemoryItem._Fields>, java.io.Serializable, Cloneable, Comparable<TFeMemoryItem> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TFeMemoryItem");

  private static final org.apache.thrift.protocol.TField MODULE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("module_name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CLASS_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("class_name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CURRENT_CONSUMPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("current_consumption", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField PEAK_CONSUMPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("peak_consumption", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField COUNTER_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("counter_info", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TFeMemoryItemStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TFeMemoryItemTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String module_name; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String class_name; // optional
  public long current_consumption; // optional
  public long peak_consumption; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String counter_info; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MODULE_NAME((short)1, "module_name"),
    CLASS_NAME((short)2, "class_name"),
    CURRENT_CONSUMPTION((short)3, "current_consumption"),
    PEAK_CONSUMPTION((short)4, "peak_consumption"),
    COUNTER_INFO((short)5, "counter_info");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MODULE_NAME
          return MODULE_NAME;
        case 2: // CLASS_NAME
          return CLASS_NAME;
        case 3: // CURRENT_CONSUMPTION
          return CURRENT_CONSUMPTION;
        case 4: // PEAK_CONSUMPTION
          return PEAK_CONSUMPTION;
        case 5: // COUNTER_INFO
          return COUNTER_INFO;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CURRENT_CONSUMPTION_ISSET_ID = 0;
  private static final int __PEAK_CONSUMPTION_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.MODULE_NAME,_Fields.CLASS_NAME,_Fields.CURRENT_CONSUMPTION,_Fields.PEAK_CONSUMPTION,_Fields.COUNTER_INFO};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MODULE_NAME, new org.apache.thrift.meta_data.FieldMetaData("module_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CLASS_NAME, new org.apache.thrift.meta_data.FieldMetaData("class_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CURRENT_CONSUMPTION, new org.apache.thrift.meta_data.FieldMetaData("current_consumption", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.PEAK_CONSUMPTION, new org.apache.thrift.meta_data.FieldMetaData("peak_consumption", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.COUNTER_INFO, new org.apache.thrift.meta_data.FieldMetaData("counter_info", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TFeMemoryItem.class, metaDataMap);
  }

  public TFeMemoryItem() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TFeMemoryItem(TFeMemoryItem other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetModule_name()) {
      this.module_name = other.module_name;
    }
    if (other.isSetClass_name()) {
      this.class_name = other.class_name;
    }
    this.current_consumption = other.current_consumption;
    this.peak_consumption = other.peak_consumption;
    if (other.isSetCounter_info()) {
      this.counter_info = other.counter_info;
    }
  }

  @Override
  public TFeMemoryItem deepCopy() {
    return new TFeMemoryItem(this);
  }

  @Override
  public void clear() {
    this.module_name = null;
    this.class_name = null;
    setCurrent_consumptionIsSet(false);
    this.current_consumption = 0;
    setPeak_consumptionIsSet(false);
    this.peak_consumption = 0;
    this.counter_info = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getModule_name() {
    return this.module_name;
  }

  public TFeMemoryItem setModule_name(@org.apache.thrift.annotation.Nullable java.lang.String module_name) {
    this.module_name = module_name;
    return this;
  }

  public void unsetModule_name() {
    this.module_name = null;
  }

  /** Returns true if field module_name is set (has been assigned a value) and false otherwise */
  public boolean isSetModule_name() {
    return this.module_name != null;
  }

  public void setModule_nameIsSet(boolean value) {
    if (!value) {
      this.module_name = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getClass_name() {
    return this.class_name;
  }

  public TFeMemoryItem setClass_name(@org.apache.thrift.annotation.Nullable java.lang.String class_name) {
    this.class_name = class_name;
    return this;
  }

  public void unsetClass_name() {
    this.class_name = null;
  }

  /** Returns true if field class_name is set (has been assigned a value) and false otherwise */
  public boolean isSetClass_name() {
    return this.class_name != null;
  }

  public void setClass_nameIsSet(boolean value) {
    if (!value) {
      this.class_name = null;
    }
  }

  public long getCurrent_consumption() {
    return this.current_consumption;
  }

  public TFeMemoryItem setCurrent_consumption(long current_consumption) {
    this.current_consumption = current_consumption;
    setCurrent_consumptionIsSet(true);
    return this;
  }

  public void unsetCurrent_consumption() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CURRENT_CONSUMPTION_ISSET_ID);
  }

  /** Returns true if field current_consumption is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrent_consumption() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CURRENT_CONSUMPTION_ISSET_ID);
  }

  public void setCurrent_consumptionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CURRENT_CONSUMPTION_ISSET_ID, value);
  }

  public long getPeak_consumption() {
    return this.peak_consumption;
  }

  public TFeMemoryItem setPeak_consumption(long peak_consumption) {
    this.peak_consumption = peak_consumption;
    setPeak_consumptionIsSet(true);
    return this;
  }

  public void unsetPeak_consumption() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PEAK_CONSUMPTION_ISSET_ID);
  }

  /** Returns true if field peak_consumption is set (has been assigned a value) and false otherwise */
  public boolean isSetPeak_consumption() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PEAK_CONSUMPTION_ISSET_ID);
  }

  public void setPeak_consumptionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PEAK_CONSUMPTION_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCounter_info() {
    return this.counter_info;
  }

  public TFeMemoryItem setCounter_info(@org.apache.thrift.annotation.Nullable java.lang.String counter_info) {
    this.counter_info = counter_info;
    return this;
  }

  public void unsetCounter_info() {
    this.counter_info = null;
  }

  /** Returns true if field counter_info is set (has been assigned a value) and false otherwise */
  public boolean isSetCounter_info() {
    return this.counter_info != null;
  }

  public void setCounter_infoIsSet(boolean value) {
    if (!value) {
      this.counter_info = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case MODULE_NAME:
      if (value == null) {
        unsetModule_name();
      } else {
        setModule_name((java.lang.String)value);
      }
      break;

    case CLASS_NAME:
      if (value == null) {
        unsetClass_name();
      } else {
        setClass_name((java.lang.String)value);
      }
      break;

    case CURRENT_CONSUMPTION:
      if (value == null) {
        unsetCurrent_consumption();
      } else {
        setCurrent_consumption((java.lang.Long)value);
      }
      break;

    case PEAK_CONSUMPTION:
      if (value == null) {
        unsetPeak_consumption();
      } else {
        setPeak_consumption((java.lang.Long)value);
      }
      break;

    case COUNTER_INFO:
      if (value == null) {
        unsetCounter_info();
      } else {
        setCounter_info((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MODULE_NAME:
      return getModule_name();

    case CLASS_NAME:
      return getClass_name();

    case CURRENT_CONSUMPTION:
      return getCurrent_consumption();

    case PEAK_CONSUMPTION:
      return getPeak_consumption();

    case COUNTER_INFO:
      return getCounter_info();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MODULE_NAME:
      return isSetModule_name();
    case CLASS_NAME:
      return isSetClass_name();
    case CURRENT_CONSUMPTION:
      return isSetCurrent_consumption();
    case PEAK_CONSUMPTION:
      return isSetPeak_consumption();
    case COUNTER_INFO:
      return isSetCounter_info();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TFeMemoryItem)
      return this.equals((TFeMemoryItem)that);
    return false;
  }

  public boolean equals(TFeMemoryItem that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_module_name = true && this.isSetModule_name();
    boolean that_present_module_name = true && that.isSetModule_name();
    if (this_present_module_name || that_present_module_name) {
      if (!(this_present_module_name && that_present_module_name))
        return false;
      if (!this.module_name.equals(that.module_name))
        return false;
    }

    boolean this_present_class_name = true && this.isSetClass_name();
    boolean that_present_class_name = true && that.isSetClass_name();
    if (this_present_class_name || that_present_class_name) {
      if (!(this_present_class_name && that_present_class_name))
        return false;
      if (!this.class_name.equals(that.class_name))
        return false;
    }

    boolean this_present_current_consumption = true && this.isSetCurrent_consumption();
    boolean that_present_current_consumption = true && that.isSetCurrent_consumption();
    if (this_present_current_consumption || that_present_current_consumption) {
      if (!(this_present_current_consumption && that_present_current_consumption))
        return false;
      if (this.current_consumption != that.current_consumption)
        return false;
    }

    boolean this_present_peak_consumption = true && this.isSetPeak_consumption();
    boolean that_present_peak_consumption = true && that.isSetPeak_consumption();
    if (this_present_peak_consumption || that_present_peak_consumption) {
      if (!(this_present_peak_consumption && that_present_peak_consumption))
        return false;
      if (this.peak_consumption != that.peak_consumption)
        return false;
    }

    boolean this_present_counter_info = true && this.isSetCounter_info();
    boolean that_present_counter_info = true && that.isSetCounter_info();
    if (this_present_counter_info || that_present_counter_info) {
      if (!(this_present_counter_info && that_present_counter_info))
        return false;
      if (!this.counter_info.equals(that.counter_info))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetModule_name()) ? 131071 : 524287);
    if (isSetModule_name())
      hashCode = hashCode * 8191 + module_name.hashCode();

    hashCode = hashCode * 8191 + ((isSetClass_name()) ? 131071 : 524287);
    if (isSetClass_name())
      hashCode = hashCode * 8191 + class_name.hashCode();

    hashCode = hashCode * 8191 + ((isSetCurrent_consumption()) ? 131071 : 524287);
    if (isSetCurrent_consumption())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(current_consumption);

    hashCode = hashCode * 8191 + ((isSetPeak_consumption()) ? 131071 : 524287);
    if (isSetPeak_consumption())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(peak_consumption);

    hashCode = hashCode * 8191 + ((isSetCounter_info()) ? 131071 : 524287);
    if (isSetCounter_info())
      hashCode = hashCode * 8191 + counter_info.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TFeMemoryItem other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetModule_name(), other.isSetModule_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetModule_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.module_name, other.module_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetClass_name(), other.isSetClass_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClass_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.class_name, other.class_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCurrent_consumption(), other.isSetCurrent_consumption());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrent_consumption()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.current_consumption, other.current_consumption);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPeak_consumption(), other.isSetPeak_consumption());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPeak_consumption()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.peak_consumption, other.peak_consumption);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCounter_info(), other.isSetCounter_info());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCounter_info()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.counter_info, other.counter_info);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TFeMemoryItem(");
    boolean first = true;

    if (isSetModule_name()) {
      sb.append("module_name:");
      if (this.module_name == null) {
        sb.append("null");
      } else {
        sb.append(this.module_name);
      }
      first = false;
    }
    if (isSetClass_name()) {
      if (!first) sb.append(", ");
      sb.append("class_name:");
      if (this.class_name == null) {
        sb.append("null");
      } else {
        sb.append(this.class_name);
      }
      first = false;
    }
    if (isSetCurrent_consumption()) {
      if (!first) sb.append(", ");
      sb.append("current_consumption:");
      sb.append(this.current_consumption);
      first = false;
    }
    if (isSetPeak_consumption()) {
      if (!first) sb.append(", ");
      sb.append("peak_consumption:");
      sb.append(this.peak_consumption);
      first = false;
    }
    if (isSetCounter_info()) {
      if (!first) sb.append(", ");
      sb.append("counter_info:");
      if (this.counter_info == null) {
        sb.append("null");
      } else {
        sb.append(this.counter_info);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TFeMemoryItemStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFeMemoryItemStandardScheme getScheme() {
      return new TFeMemoryItemStandardScheme();
    }
  }

  private static class TFeMemoryItemStandardScheme extends org.apache.thrift.scheme.StandardScheme<TFeMemoryItem> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TFeMemoryItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MODULE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.module_name = iprot.readString();
              struct.setModule_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CLASS_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.class_name = iprot.readString();
              struct.setClass_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CURRENT_CONSUMPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.current_consumption = iprot.readI64();
              struct.setCurrent_consumptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PEAK_CONSUMPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.peak_consumption = iprot.readI64();
              struct.setPeak_consumptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // COUNTER_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.counter_info = iprot.readString();
              struct.setCounter_infoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TFeMemoryItem struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.module_name != null) {
        if (struct.isSetModule_name()) {
          oprot.writeFieldBegin(MODULE_NAME_FIELD_DESC);
          oprot.writeString(struct.module_name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.class_name != null) {
        if (struct.isSetClass_name()) {
          oprot.writeFieldBegin(CLASS_NAME_FIELD_DESC);
          oprot.writeString(struct.class_name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetCurrent_consumption()) {
        oprot.writeFieldBegin(CURRENT_CONSUMPTION_FIELD_DESC);
        oprot.writeI64(struct.current_consumption);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPeak_consumption()) {
        oprot.writeFieldBegin(PEAK_CONSUMPTION_FIELD_DESC);
        oprot.writeI64(struct.peak_consumption);
        oprot.writeFieldEnd();
      }
      if (struct.counter_info != null) {
        if (struct.isSetCounter_info()) {
          oprot.writeFieldBegin(COUNTER_INFO_FIELD_DESC);
          oprot.writeString(struct.counter_info);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TFeMemoryItemTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFeMemoryItemTupleScheme getScheme() {
      return new TFeMemoryItemTupleScheme();
    }
  }

  private static class TFeMemoryItemTupleScheme extends org.apache.thrift.scheme.TupleScheme<TFeMemoryItem> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TFeMemoryItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetModule_name()) {
        optionals.set(0);
      }
      if (struct.isSetClass_name()) {
        optionals.set(1);
      }
      if (struct.isSetCurrent_consumption()) {
        optionals.set(2);
      }
      if (struct.isSetPeak_consumption()) {
        optionals.set(3);
      }
      if (struct.isSetCounter_info()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetModule_name()) {
        oprot.writeString(struct.module_name);
      }
      if (struct.isSetClass_name()) {
        oprot.writeString(struct.class_name);
      }
      if (struct.isSetCurrent_consumption()) {
        oprot.writeI64(struct.current_consumption);
      }
      if (struct.isSetPeak_consumption()) {
        oprot.writeI64(struct.peak_consumption);
      }
      if (struct.isSetCounter_info()) {
        oprot.writeString(struct.counter_info);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TFeMemoryItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.module_name = iprot.readString();
        struct.setModule_nameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.class_name = iprot.readString();
        struct.setClass_nameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.current_consumption = iprot.readI64();
        struct.setCurrent_consumptionIsSet(true);
      }
      if (incoming.get(3)) {
        struct.peak_consumption = iprot.readI64();
        struct.setPeak_consumptionIsSet(true);
      }
      if (incoming.get(4)) {
        struct.counter_info = iprot.readString();
        struct.setCounter_infoIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

