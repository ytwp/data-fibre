/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TDataProperty implements org.apache.thrift.TBase<TDataProperty, TDataProperty._Fields>, java.io.Serializable, Cloneable, Comparable<TDataProperty> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDataProperty");

  private static final org.apache.thrift.protocol.TField STORAGE_MEDIUM_FIELD_DESC = new org.apache.thrift.protocol.TField("storage_medium", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COLD_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("cold_time", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TDataPropertyStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TDataPropertyTupleSchemeFactory();

  /**
   * 
   * @see com.starrocks.thrift.TStorageMedium
   */
  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStorageMedium storage_medium; // optional
  public long cold_time; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see com.starrocks.thrift.TStorageMedium
     */
    STORAGE_MEDIUM((short)1, "storage_medium"),
    COLD_TIME((short)2, "cold_time");

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
        case 1: // STORAGE_MEDIUM
          return STORAGE_MEDIUM;
        case 2: // COLD_TIME
          return COLD_TIME;
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
  private static final int __COLD_TIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.STORAGE_MEDIUM,_Fields.COLD_TIME};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STORAGE_MEDIUM, new org.apache.thrift.meta_data.FieldMetaData("storage_medium", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.starrocks.thrift.TStorageMedium.class)));
    tmpMap.put(_Fields.COLD_TIME, new org.apache.thrift.meta_data.FieldMetaData("cold_time", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDataProperty.class, metaDataMap);
  }

  public TDataProperty() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDataProperty(TDataProperty other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStorage_medium()) {
      this.storage_medium = other.storage_medium;
    }
    this.cold_time = other.cold_time;
  }

  @Override
  public TDataProperty deepCopy() {
    return new TDataProperty(this);
  }

  @Override
  public void clear() {
    this.storage_medium = null;
    setCold_timeIsSet(false);
    this.cold_time = 0;
  }

  /**
   * 
   * @see com.starrocks.thrift.TStorageMedium
   */
  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TStorageMedium getStorage_medium() {
    return this.storage_medium;
  }

  /**
   * 
   * @see com.starrocks.thrift.TStorageMedium
   */
  public TDataProperty setStorage_medium(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStorageMedium storage_medium) {
    this.storage_medium = storage_medium;
    return this;
  }

  public void unsetStorage_medium() {
    this.storage_medium = null;
  }

  /** Returns true if field storage_medium is set (has been assigned a value) and false otherwise */
  public boolean isSetStorage_medium() {
    return this.storage_medium != null;
  }

  public void setStorage_mediumIsSet(boolean value) {
    if (!value) {
      this.storage_medium = null;
    }
  }

  public long getCold_time() {
    return this.cold_time;
  }

  public TDataProperty setCold_time(long cold_time) {
    this.cold_time = cold_time;
    setCold_timeIsSet(true);
    return this;
  }

  public void unsetCold_time() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __COLD_TIME_ISSET_ID);
  }

  /** Returns true if field cold_time is set (has been assigned a value) and false otherwise */
  public boolean isSetCold_time() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __COLD_TIME_ISSET_ID);
  }

  public void setCold_timeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __COLD_TIME_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case STORAGE_MEDIUM:
      if (value == null) {
        unsetStorage_medium();
      } else {
        setStorage_medium((com.starrocks.thrift.TStorageMedium)value);
      }
      break;

    case COLD_TIME:
      if (value == null) {
        unsetCold_time();
      } else {
        setCold_time((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STORAGE_MEDIUM:
      return getStorage_medium();

    case COLD_TIME:
      return getCold_time();

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
    case STORAGE_MEDIUM:
      return isSetStorage_medium();
    case COLD_TIME:
      return isSetCold_time();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TDataProperty)
      return this.equals((TDataProperty)that);
    return false;
  }

  public boolean equals(TDataProperty that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_storage_medium = true && this.isSetStorage_medium();
    boolean that_present_storage_medium = true && that.isSetStorage_medium();
    if (this_present_storage_medium || that_present_storage_medium) {
      if (!(this_present_storage_medium && that_present_storage_medium))
        return false;
      if (!this.storage_medium.equals(that.storage_medium))
        return false;
    }

    boolean this_present_cold_time = true && this.isSetCold_time();
    boolean that_present_cold_time = true && that.isSetCold_time();
    if (this_present_cold_time || that_present_cold_time) {
      if (!(this_present_cold_time && that_present_cold_time))
        return false;
      if (this.cold_time != that.cold_time)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStorage_medium()) ? 131071 : 524287);
    if (isSetStorage_medium())
      hashCode = hashCode * 8191 + storage_medium.getValue();

    hashCode = hashCode * 8191 + ((isSetCold_time()) ? 131071 : 524287);
    if (isSetCold_time())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(cold_time);

    return hashCode;
  }

  @Override
  public int compareTo(TDataProperty other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetStorage_medium(), other.isSetStorage_medium());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStorage_medium()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.storage_medium, other.storage_medium);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCold_time(), other.isSetCold_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCold_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cold_time, other.cold_time);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TDataProperty(");
    boolean first = true;

    if (isSetStorage_medium()) {
      sb.append("storage_medium:");
      if (this.storage_medium == null) {
        sb.append("null");
      } else {
        sb.append(this.storage_medium);
      }
      first = false;
    }
    if (isSetCold_time()) {
      if (!first) sb.append(", ");
      sb.append("cold_time:");
      sb.append(this.cold_time);
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

  private static class TDataPropertyStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TDataPropertyStandardScheme getScheme() {
      return new TDataPropertyStandardScheme();
    }
  }

  private static class TDataPropertyStandardScheme extends org.apache.thrift.scheme.StandardScheme<TDataProperty> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TDataProperty struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STORAGE_MEDIUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.storage_medium = com.starrocks.thrift.TStorageMedium.findByValue(iprot.readI32());
              struct.setStorage_mediumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COLD_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.cold_time = iprot.readI64();
              struct.setCold_timeIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TDataProperty struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.storage_medium != null) {
        if (struct.isSetStorage_medium()) {
          oprot.writeFieldBegin(STORAGE_MEDIUM_FIELD_DESC);
          oprot.writeI32(struct.storage_medium.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetCold_time()) {
        oprot.writeFieldBegin(COLD_TIME_FIELD_DESC);
        oprot.writeI64(struct.cold_time);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDataPropertyTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TDataPropertyTupleScheme getScheme() {
      return new TDataPropertyTupleScheme();
    }
  }

  private static class TDataPropertyTupleScheme extends org.apache.thrift.scheme.TupleScheme<TDataProperty> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDataProperty struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStorage_medium()) {
        optionals.set(0);
      }
      if (struct.isSetCold_time()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetStorage_medium()) {
        oprot.writeI32(struct.storage_medium.getValue());
      }
      if (struct.isSetCold_time()) {
        oprot.writeI64(struct.cold_time);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDataProperty struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.storage_medium = com.starrocks.thrift.TStorageMedium.findByValue(iprot.readI32());
        struct.setStorage_mediumIsSet(true);
      }
      if (incoming.get(1)) {
        struct.cold_time = iprot.readI64();
        struct.setCold_timeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

