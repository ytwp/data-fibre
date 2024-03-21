/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TPartitionInfo implements org.apache.thrift.TBase<TPartitionInfo, TPartitionInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TPartitionInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TPartitionInfo");

  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SINGLE_PARTITION_DESC_FIELD_DESC = new org.apache.thrift.protocol.TField("single_partition_desc", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField RANGE_PARTITION_DESC_FIELD_DESC = new org.apache.thrift.protocol.TField("range_partition_desc", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TPartitionInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TPartitionInfoTupleSchemeFactory();

  /**
   * 
   * @see io.datafibre.fibre.thrift.TPartitionType
   */
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TPartitionType type; // optional
  public @org.apache.thrift.annotation.Nullable TSinglePartitionDesc single_partition_desc; // optional
  public @org.apache.thrift.annotation.Nullable TRangePartitionDesc range_partition_desc; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see io.datafibre.fibre.thrift.TPartitionType
     */
    TYPE((short)1, "type"),
    SINGLE_PARTITION_DESC((short)2, "single_partition_desc"),
    RANGE_PARTITION_DESC((short)3, "range_partition_desc");

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
        case 1: // TYPE
          return TYPE;
        case 2: // SINGLE_PARTITION_DESC
          return SINGLE_PARTITION_DESC;
        case 3: // RANGE_PARTITION_DESC
          return RANGE_PARTITION_DESC;
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
  private static final _Fields optionals[] = {_Fields.TYPE,_Fields.SINGLE_PARTITION_DESC,_Fields.RANGE_PARTITION_DESC};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, io.datafibre.fibre.thrift.TPartitionType.class)));
    tmpMap.put(_Fields.SINGLE_PARTITION_DESC, new org.apache.thrift.meta_data.FieldMetaData("single_partition_desc", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSinglePartitionDesc.class)));
    tmpMap.put(_Fields.RANGE_PARTITION_DESC, new org.apache.thrift.meta_data.FieldMetaData("range_partition_desc", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TRangePartitionDesc.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TPartitionInfo.class, metaDataMap);
  }

  public TPartitionInfo() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TPartitionInfo(TPartitionInfo other) {
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetSingle_partition_desc()) {
      this.single_partition_desc = new TSinglePartitionDesc(other.single_partition_desc);
    }
    if (other.isSetRange_partition_desc()) {
      this.range_partition_desc = new TRangePartitionDesc(other.range_partition_desc);
    }
  }

  @Override
  public TPartitionInfo deepCopy() {
    return new TPartitionInfo(this);
  }

  @Override
  public void clear() {
    this.type = null;
    this.single_partition_desc = null;
    this.range_partition_desc = null;
  }

  /**
   * 
   * @see io.datafibre.fibre.thrift.TPartitionType
   */
  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TPartitionType getType() {
    return this.type;
  }

  /**
   * 
   * @see io.datafibre.fibre.thrift.TPartitionType
   */
  public TPartitionInfo setType(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TPartitionType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TSinglePartitionDesc getSingle_partition_desc() {
    return this.single_partition_desc;
  }

  public TPartitionInfo setSingle_partition_desc(@org.apache.thrift.annotation.Nullable TSinglePartitionDesc single_partition_desc) {
    this.single_partition_desc = single_partition_desc;
    return this;
  }

  public void unsetSingle_partition_desc() {
    this.single_partition_desc = null;
  }

  /** Returns true if field single_partition_desc is set (has been assigned a value) and false otherwise */
  public boolean isSetSingle_partition_desc() {
    return this.single_partition_desc != null;
  }

  public void setSingle_partition_descIsSet(boolean value) {
    if (!value) {
      this.single_partition_desc = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TRangePartitionDesc getRange_partition_desc() {
    return this.range_partition_desc;
  }

  public TPartitionInfo setRange_partition_desc(@org.apache.thrift.annotation.Nullable TRangePartitionDesc range_partition_desc) {
    this.range_partition_desc = range_partition_desc;
    return this;
  }

  public void unsetRange_partition_desc() {
    this.range_partition_desc = null;
  }

  /** Returns true if field range_partition_desc is set (has been assigned a value) and false otherwise */
  public boolean isSetRange_partition_desc() {
    return this.range_partition_desc != null;
  }

  public void setRange_partition_descIsSet(boolean value) {
    if (!value) {
      this.range_partition_desc = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((io.datafibre.fibre.thrift.TPartitionType)value);
      }
      break;

    case SINGLE_PARTITION_DESC:
      if (value == null) {
        unsetSingle_partition_desc();
      } else {
        setSingle_partition_desc((TSinglePartitionDesc)value);
      }
      break;

    case RANGE_PARTITION_DESC:
      if (value == null) {
        unsetRange_partition_desc();
      } else {
        setRange_partition_desc((TRangePartitionDesc)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE:
      return getType();

    case SINGLE_PARTITION_DESC:
      return getSingle_partition_desc();

    case RANGE_PARTITION_DESC:
      return getRange_partition_desc();

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
    case TYPE:
      return isSetType();
    case SINGLE_PARTITION_DESC:
      return isSetSingle_partition_desc();
    case RANGE_PARTITION_DESC:
      return isSetRange_partition_desc();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TPartitionInfo)
      return this.equals((TPartitionInfo)that);
    return false;
  }

  public boolean equals(TPartitionInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_single_partition_desc = true && this.isSetSingle_partition_desc();
    boolean that_present_single_partition_desc = true && that.isSetSingle_partition_desc();
    if (this_present_single_partition_desc || that_present_single_partition_desc) {
      if (!(this_present_single_partition_desc && that_present_single_partition_desc))
        return false;
      if (!this.single_partition_desc.equals(that.single_partition_desc))
        return false;
    }

    boolean this_present_range_partition_desc = true && this.isSetRange_partition_desc();
    boolean that_present_range_partition_desc = true && that.isSetRange_partition_desc();
    if (this_present_range_partition_desc || that_present_range_partition_desc) {
      if (!(this_present_range_partition_desc && that_present_range_partition_desc))
        return false;
      if (!this.range_partition_desc.equals(that.range_partition_desc))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.getValue();

    hashCode = hashCode * 8191 + ((isSetSingle_partition_desc()) ? 131071 : 524287);
    if (isSetSingle_partition_desc())
      hashCode = hashCode * 8191 + single_partition_desc.hashCode();

    hashCode = hashCode * 8191 + ((isSetRange_partition_desc()) ? 131071 : 524287);
    if (isSetRange_partition_desc())
      hashCode = hashCode * 8191 + range_partition_desc.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TPartitionInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetType(), other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetSingle_partition_desc(), other.isSetSingle_partition_desc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSingle_partition_desc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.single_partition_desc, other.single_partition_desc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetRange_partition_desc(), other.isSetRange_partition_desc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRange_partition_desc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.range_partition_desc, other.range_partition_desc);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TPartitionInfo(");
    boolean first = true;

    if (isSetType()) {
      sb.append("type:");
      if (this.type == null) {
        sb.append("null");
      } else {
        sb.append(this.type);
      }
      first = false;
    }
    if (isSetSingle_partition_desc()) {
      if (!first) sb.append(", ");
      sb.append("single_partition_desc:");
      if (this.single_partition_desc == null) {
        sb.append("null");
      } else {
        sb.append(this.single_partition_desc);
      }
      first = false;
    }
    if (isSetRange_partition_desc()) {
      if (!first) sb.append(", ");
      sb.append("range_partition_desc:");
      if (this.range_partition_desc == null) {
        sb.append("null");
      } else {
        sb.append(this.range_partition_desc);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (single_partition_desc != null) {
      single_partition_desc.validate();
    }
    if (range_partition_desc != null) {
      range_partition_desc.validate();
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TPartitionInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TPartitionInfoStandardScheme getScheme() {
      return new TPartitionInfoStandardScheme();
    }
  }

  private static class TPartitionInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<TPartitionInfo> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TPartitionInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = io.datafibre.fibre.thrift.TPartitionType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SINGLE_PARTITION_DESC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.single_partition_desc = new TSinglePartitionDesc();
              struct.single_partition_desc.read(iprot);
              struct.setSingle_partition_descIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // RANGE_PARTITION_DESC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.range_partition_desc = new TRangePartitionDesc();
              struct.range_partition_desc.read(iprot);
              struct.setRange_partition_descIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TPartitionInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.type != null) {
        if (struct.isSetType()) {
          oprot.writeFieldBegin(TYPE_FIELD_DESC);
          oprot.writeI32(struct.type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.single_partition_desc != null) {
        if (struct.isSetSingle_partition_desc()) {
          oprot.writeFieldBegin(SINGLE_PARTITION_DESC_FIELD_DESC);
          struct.single_partition_desc.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.range_partition_desc != null) {
        if (struct.isSetRange_partition_desc()) {
          oprot.writeFieldBegin(RANGE_PARTITION_DESC_FIELD_DESC);
          struct.range_partition_desc.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TPartitionInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TPartitionInfoTupleScheme getScheme() {
      return new TPartitionInfoTupleScheme();
    }
  }

  private static class TPartitionInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<TPartitionInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TPartitionInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetType()) {
        optionals.set(0);
      }
      if (struct.isSetSingle_partition_desc()) {
        optionals.set(1);
      }
      if (struct.isSetRange_partition_desc()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetSingle_partition_desc()) {
        struct.single_partition_desc.write(oprot);
      }
      if (struct.isSetRange_partition_desc()) {
        struct.range_partition_desc.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TPartitionInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.type = io.datafibre.fibre.thrift.TPartitionType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.single_partition_desc = new TSinglePartitionDesc();
        struct.single_partition_desc.read(iprot);
        struct.setSingle_partition_descIsSet(true);
      }
      if (incoming.get(2)) {
        struct.range_partition_desc = new TRangePartitionDesc();
        struct.range_partition_desc.read(iprot);
        struct.setRange_partition_descIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
