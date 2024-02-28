/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TGetFileSchemaRequest implements org.apache.thrift.TBase<TGetFileSchemaRequest, TGetFileSchemaRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TGetFileSchemaRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TGetFileSchemaRequest");

  private static final org.apache.thrift.protocol.TField SCAN_RANGE_FIELD_DESC = new org.apache.thrift.protocol.TField("scan_range", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField VOLUME_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("volume_id", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TGetFileSchemaRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TGetFileSchemaRequestTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TScanRange scan_range; // required
  public int volume_id; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SCAN_RANGE((short)1, "scan_range"),
    VOLUME_ID((short)2, "volume_id");

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
        case 1: // SCAN_RANGE
          return SCAN_RANGE;
        case 2: // VOLUME_ID
          return VOLUME_ID;
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
  private static final int __VOLUME_ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.VOLUME_ID};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SCAN_RANGE, new org.apache.thrift.meta_data.FieldMetaData("scan_range", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TScanRange.class)));
    tmpMap.put(_Fields.VOLUME_ID, new org.apache.thrift.meta_data.FieldMetaData("volume_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TGetFileSchemaRequest.class, metaDataMap);
  }

  public TGetFileSchemaRequest() {
    this.volume_id = -1;

  }

  public TGetFileSchemaRequest(
    io.datafibre.fibre.thrift.TScanRange scan_range)
  {
    this();
    this.scan_range = scan_range;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TGetFileSchemaRequest(TGetFileSchemaRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetScan_range()) {
      this.scan_range = new io.datafibre.fibre.thrift.TScanRange(other.scan_range);
    }
    this.volume_id = other.volume_id;
  }

  @Override
  public TGetFileSchemaRequest deepCopy() {
    return new TGetFileSchemaRequest(this);
  }

  @Override
  public void clear() {
    this.scan_range = null;
    this.volume_id = -1;

  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TScanRange getScan_range() {
    return this.scan_range;
  }

  public TGetFileSchemaRequest setScan_range(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TScanRange scan_range) {
    this.scan_range = scan_range;
    return this;
  }

  public void unsetScan_range() {
    this.scan_range = null;
  }

  /** Returns true if field scan_range is set (has been assigned a value) and false otherwise */
  public boolean isSetScan_range() {
    return this.scan_range != null;
  }

  public void setScan_rangeIsSet(boolean value) {
    if (!value) {
      this.scan_range = null;
    }
  }

  public int getVolume_id() {
    return this.volume_id;
  }

  public TGetFileSchemaRequest setVolume_id(int volume_id) {
    this.volume_id = volume_id;
    setVolume_idIsSet(true);
    return this;
  }

  public void unsetVolume_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VOLUME_ID_ISSET_ID);
  }

  /** Returns true if field volume_id is set (has been assigned a value) and false otherwise */
  public boolean isSetVolume_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VOLUME_ID_ISSET_ID);
  }

  public void setVolume_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VOLUME_ID_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case SCAN_RANGE:
      if (value == null) {
        unsetScan_range();
      } else {
        setScan_range((io.datafibre.fibre.thrift.TScanRange)value);
      }
      break;

    case VOLUME_ID:
      if (value == null) {
        unsetVolume_id();
      } else {
        setVolume_id((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SCAN_RANGE:
      return getScan_range();

    case VOLUME_ID:
      return getVolume_id();

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
    case SCAN_RANGE:
      return isSetScan_range();
    case VOLUME_ID:
      return isSetVolume_id();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TGetFileSchemaRequest)
      return this.equals((TGetFileSchemaRequest)that);
    return false;
  }

  public boolean equals(TGetFileSchemaRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_scan_range = true && this.isSetScan_range();
    boolean that_present_scan_range = true && that.isSetScan_range();
    if (this_present_scan_range || that_present_scan_range) {
      if (!(this_present_scan_range && that_present_scan_range))
        return false;
      if (!this.scan_range.equals(that.scan_range))
        return false;
    }

    boolean this_present_volume_id = true && this.isSetVolume_id();
    boolean that_present_volume_id = true && that.isSetVolume_id();
    if (this_present_volume_id || that_present_volume_id) {
      if (!(this_present_volume_id && that_present_volume_id))
        return false;
      if (this.volume_id != that.volume_id)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetScan_range()) ? 131071 : 524287);
    if (isSetScan_range())
      hashCode = hashCode * 8191 + scan_range.hashCode();

    hashCode = hashCode * 8191 + ((isSetVolume_id()) ? 131071 : 524287);
    if (isSetVolume_id())
      hashCode = hashCode * 8191 + volume_id;

    return hashCode;
  }

  @Override
  public int compareTo(TGetFileSchemaRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetScan_range(), other.isSetScan_range());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetScan_range()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.scan_range, other.scan_range);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetVolume_id(), other.isSetVolume_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVolume_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.volume_id, other.volume_id);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TGetFileSchemaRequest(");
    boolean first = true;

    sb.append("scan_range:");
    if (this.scan_range == null) {
      sb.append("null");
    } else {
      sb.append(this.scan_range);
    }
    first = false;
    if (isSetVolume_id()) {
      if (!first) sb.append(", ");
      sb.append("volume_id:");
      sb.append(this.volume_id);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (scan_range == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'scan_range' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (scan_range != null) {
      scan_range.validate();
    }
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

  private static class TGetFileSchemaRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetFileSchemaRequestStandardScheme getScheme() {
      return new TGetFileSchemaRequestStandardScheme();
    }
  }

  private static class TGetFileSchemaRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<TGetFileSchemaRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TGetFileSchemaRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SCAN_RANGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.scan_range = new io.datafibre.fibre.thrift.TScanRange();
              struct.scan_range.read(iprot);
              struct.setScan_rangeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VOLUME_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.volume_id = iprot.readI32();
              struct.setVolume_idIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TGetFileSchemaRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.scan_range != null) {
        oprot.writeFieldBegin(SCAN_RANGE_FIELD_DESC);
        struct.scan_range.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.isSetVolume_id()) {
        oprot.writeFieldBegin(VOLUME_ID_FIELD_DESC);
        oprot.writeI32(struct.volume_id);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TGetFileSchemaRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetFileSchemaRequestTupleScheme getScheme() {
      return new TGetFileSchemaRequestTupleScheme();
    }
  }

  private static class TGetFileSchemaRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<TGetFileSchemaRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TGetFileSchemaRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.scan_range.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetVolume_id()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetVolume_id()) {
        oprot.writeI32(struct.volume_id);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TGetFileSchemaRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.scan_range = new io.datafibre.fibre.thrift.TScanRange();
      struct.scan_range.read(iprot);
      struct.setScan_rangeIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.volume_id = iprot.readI32();
        struct.setVolume_idIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

