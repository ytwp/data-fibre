/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TKafkaRLTaskProgress implements org.apache.thrift.TBase<TKafkaRLTaskProgress, TKafkaRLTaskProgress._Fields>, java.io.Serializable, Cloneable, Comparable<TKafkaRLTaskProgress> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TKafkaRLTaskProgress");

  private static final org.apache.thrift.protocol.TField PARTITION_CMT_OFFSET_FIELD_DESC = new org.apache.thrift.protocol.TField("partitionCmtOffset", org.apache.thrift.protocol.TType.MAP, (short)1);
  private static final org.apache.thrift.protocol.TField PARTITION_CMT_OFFSET_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("partitionCmtOffsetTimestamp", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TKafkaRLTaskProgressStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TKafkaRLTaskProgressTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,java.lang.Long> partitionCmtOffset; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,java.lang.Long> partitionCmtOffsetTimestamp; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PARTITION_CMT_OFFSET((short)1, "partitionCmtOffset"),
    PARTITION_CMT_OFFSET_TIMESTAMP((short)2, "partitionCmtOffsetTimestamp");

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
        case 1: // PARTITION_CMT_OFFSET
          return PARTITION_CMT_OFFSET;
        case 2: // PARTITION_CMT_OFFSET_TIMESTAMP
          return PARTITION_CMT_OFFSET_TIMESTAMP;
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
  private static final _Fields optionals[] = {_Fields.PARTITION_CMT_OFFSET_TIMESTAMP};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PARTITION_CMT_OFFSET, new org.apache.thrift.meta_data.FieldMetaData("partitionCmtOffset", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.PARTITION_CMT_OFFSET_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("partitionCmtOffsetTimestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TKafkaRLTaskProgress.class, metaDataMap);
  }

  public TKafkaRLTaskProgress() {
  }

  public TKafkaRLTaskProgress(
    java.util.Map<java.lang.Integer,java.lang.Long> partitionCmtOffset)
  {
    this();
    this.partitionCmtOffset = partitionCmtOffset;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TKafkaRLTaskProgress(TKafkaRLTaskProgress other) {
    if (other.isSetPartitionCmtOffset()) {
      java.util.Map<java.lang.Integer,java.lang.Long> __this__partitionCmtOffset = new java.util.HashMap<java.lang.Integer,java.lang.Long>(other.partitionCmtOffset);
      this.partitionCmtOffset = __this__partitionCmtOffset;
    }
    if (other.isSetPartitionCmtOffsetTimestamp()) {
      java.util.Map<java.lang.Integer,java.lang.Long> __this__partitionCmtOffsetTimestamp = new java.util.HashMap<java.lang.Integer,java.lang.Long>(other.partitionCmtOffsetTimestamp);
      this.partitionCmtOffsetTimestamp = __this__partitionCmtOffsetTimestamp;
    }
  }

  @Override
  public TKafkaRLTaskProgress deepCopy() {
    return new TKafkaRLTaskProgress(this);
  }

  @Override
  public void clear() {
    this.partitionCmtOffset = null;
    this.partitionCmtOffsetTimestamp = null;
  }

  public int getPartitionCmtOffsetSize() {
    return (this.partitionCmtOffset == null) ? 0 : this.partitionCmtOffset.size();
  }

  public void putToPartitionCmtOffset(int key, long val) {
    if (this.partitionCmtOffset == null) {
      this.partitionCmtOffset = new java.util.HashMap<java.lang.Integer,java.lang.Long>();
    }
    this.partitionCmtOffset.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.Integer,java.lang.Long> getPartitionCmtOffset() {
    return this.partitionCmtOffset;
  }

  public TKafkaRLTaskProgress setPartitionCmtOffset(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,java.lang.Long> partitionCmtOffset) {
    this.partitionCmtOffset = partitionCmtOffset;
    return this;
  }

  public void unsetPartitionCmtOffset() {
    this.partitionCmtOffset = null;
  }

  /** Returns true if field partitionCmtOffset is set (has been assigned a value) and false otherwise */
  public boolean isSetPartitionCmtOffset() {
    return this.partitionCmtOffset != null;
  }

  public void setPartitionCmtOffsetIsSet(boolean value) {
    if (!value) {
      this.partitionCmtOffset = null;
    }
  }

  public int getPartitionCmtOffsetTimestampSize() {
    return (this.partitionCmtOffsetTimestamp == null) ? 0 : this.partitionCmtOffsetTimestamp.size();
  }

  public void putToPartitionCmtOffsetTimestamp(int key, long val) {
    if (this.partitionCmtOffsetTimestamp == null) {
      this.partitionCmtOffsetTimestamp = new java.util.HashMap<java.lang.Integer,java.lang.Long>();
    }
    this.partitionCmtOffsetTimestamp.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.Integer,java.lang.Long> getPartitionCmtOffsetTimestamp() {
    return this.partitionCmtOffsetTimestamp;
  }

  public TKafkaRLTaskProgress setPartitionCmtOffsetTimestamp(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,java.lang.Long> partitionCmtOffsetTimestamp) {
    this.partitionCmtOffsetTimestamp = partitionCmtOffsetTimestamp;
    return this;
  }

  public void unsetPartitionCmtOffsetTimestamp() {
    this.partitionCmtOffsetTimestamp = null;
  }

  /** Returns true if field partitionCmtOffsetTimestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetPartitionCmtOffsetTimestamp() {
    return this.partitionCmtOffsetTimestamp != null;
  }

  public void setPartitionCmtOffsetTimestampIsSet(boolean value) {
    if (!value) {
      this.partitionCmtOffsetTimestamp = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PARTITION_CMT_OFFSET:
      if (value == null) {
        unsetPartitionCmtOffset();
      } else {
        setPartitionCmtOffset((java.util.Map<java.lang.Integer,java.lang.Long>)value);
      }
      break;

    case PARTITION_CMT_OFFSET_TIMESTAMP:
      if (value == null) {
        unsetPartitionCmtOffsetTimestamp();
      } else {
        setPartitionCmtOffsetTimestamp((java.util.Map<java.lang.Integer,java.lang.Long>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PARTITION_CMT_OFFSET:
      return getPartitionCmtOffset();

    case PARTITION_CMT_OFFSET_TIMESTAMP:
      return getPartitionCmtOffsetTimestamp();

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
    case PARTITION_CMT_OFFSET:
      return isSetPartitionCmtOffset();
    case PARTITION_CMT_OFFSET_TIMESTAMP:
      return isSetPartitionCmtOffsetTimestamp();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TKafkaRLTaskProgress)
      return this.equals((TKafkaRLTaskProgress)that);
    return false;
  }

  public boolean equals(TKafkaRLTaskProgress that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_partitionCmtOffset = true && this.isSetPartitionCmtOffset();
    boolean that_present_partitionCmtOffset = true && that.isSetPartitionCmtOffset();
    if (this_present_partitionCmtOffset || that_present_partitionCmtOffset) {
      if (!(this_present_partitionCmtOffset && that_present_partitionCmtOffset))
        return false;
      if (!this.partitionCmtOffset.equals(that.partitionCmtOffset))
        return false;
    }

    boolean this_present_partitionCmtOffsetTimestamp = true && this.isSetPartitionCmtOffsetTimestamp();
    boolean that_present_partitionCmtOffsetTimestamp = true && that.isSetPartitionCmtOffsetTimestamp();
    if (this_present_partitionCmtOffsetTimestamp || that_present_partitionCmtOffsetTimestamp) {
      if (!(this_present_partitionCmtOffsetTimestamp && that_present_partitionCmtOffsetTimestamp))
        return false;
      if (!this.partitionCmtOffsetTimestamp.equals(that.partitionCmtOffsetTimestamp))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetPartitionCmtOffset()) ? 131071 : 524287);
    if (isSetPartitionCmtOffset())
      hashCode = hashCode * 8191 + partitionCmtOffset.hashCode();

    hashCode = hashCode * 8191 + ((isSetPartitionCmtOffsetTimestamp()) ? 131071 : 524287);
    if (isSetPartitionCmtOffsetTimestamp())
      hashCode = hashCode * 8191 + partitionCmtOffsetTimestamp.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TKafkaRLTaskProgress other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetPartitionCmtOffset(), other.isSetPartitionCmtOffset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartitionCmtOffset()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partitionCmtOffset, other.partitionCmtOffset);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPartitionCmtOffsetTimestamp(), other.isSetPartitionCmtOffsetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartitionCmtOffsetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partitionCmtOffsetTimestamp, other.partitionCmtOffsetTimestamp);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TKafkaRLTaskProgress(");
    boolean first = true;

    sb.append("partitionCmtOffset:");
    if (this.partitionCmtOffset == null) {
      sb.append("null");
    } else {
      sb.append(this.partitionCmtOffset);
    }
    first = false;
    if (isSetPartitionCmtOffsetTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("partitionCmtOffsetTimestamp:");
      if (this.partitionCmtOffsetTimestamp == null) {
        sb.append("null");
      } else {
        sb.append(this.partitionCmtOffsetTimestamp);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (partitionCmtOffset == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'partitionCmtOffset' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TKafkaRLTaskProgressStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TKafkaRLTaskProgressStandardScheme getScheme() {
      return new TKafkaRLTaskProgressStandardScheme();
    }
  }

  private static class TKafkaRLTaskProgressStandardScheme extends org.apache.thrift.scheme.StandardScheme<TKafkaRLTaskProgress> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TKafkaRLTaskProgress struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PARTITION_CMT_OFFSET
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map310 = iprot.readMapBegin();
                struct.partitionCmtOffset = new java.util.HashMap<java.lang.Integer,java.lang.Long>(2*_map310.size);
                int _key311;
                long _val312;
                for (int _i313 = 0; _i313 < _map310.size; ++_i313)
                {
                  _key311 = iprot.readI32();
                  _val312 = iprot.readI64();
                  struct.partitionCmtOffset.put(_key311, _val312);
                }
                iprot.readMapEnd();
              }
              struct.setPartitionCmtOffsetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARTITION_CMT_OFFSET_TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map314 = iprot.readMapBegin();
                struct.partitionCmtOffsetTimestamp = new java.util.HashMap<java.lang.Integer,java.lang.Long>(2*_map314.size);
                int _key315;
                long _val316;
                for (int _i317 = 0; _i317 < _map314.size; ++_i317)
                {
                  _key315 = iprot.readI32();
                  _val316 = iprot.readI64();
                  struct.partitionCmtOffsetTimestamp.put(_key315, _val316);
                }
                iprot.readMapEnd();
              }
              struct.setPartitionCmtOffsetTimestampIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TKafkaRLTaskProgress struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.partitionCmtOffset != null) {
        oprot.writeFieldBegin(PARTITION_CMT_OFFSET_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I64, struct.partitionCmtOffset.size()));
          for (java.util.Map.Entry<java.lang.Integer, java.lang.Long> _iter318 : struct.partitionCmtOffset.entrySet())
          {
            oprot.writeI32(_iter318.getKey());
            oprot.writeI64(_iter318.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.partitionCmtOffsetTimestamp != null) {
        if (struct.isSetPartitionCmtOffsetTimestamp()) {
          oprot.writeFieldBegin(PARTITION_CMT_OFFSET_TIMESTAMP_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I64, struct.partitionCmtOffsetTimestamp.size()));
            for (java.util.Map.Entry<java.lang.Integer, java.lang.Long> _iter319 : struct.partitionCmtOffsetTimestamp.entrySet())
            {
              oprot.writeI32(_iter319.getKey());
              oprot.writeI64(_iter319.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TKafkaRLTaskProgressTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TKafkaRLTaskProgressTupleScheme getScheme() {
      return new TKafkaRLTaskProgressTupleScheme();
    }
  }

  private static class TKafkaRLTaskProgressTupleScheme extends org.apache.thrift.scheme.TupleScheme<TKafkaRLTaskProgress> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TKafkaRLTaskProgress struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.partitionCmtOffset.size());
        for (java.util.Map.Entry<java.lang.Integer, java.lang.Long> _iter320 : struct.partitionCmtOffset.entrySet())
        {
          oprot.writeI32(_iter320.getKey());
          oprot.writeI64(_iter320.getValue());
        }
      }
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetPartitionCmtOffsetTimestamp()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetPartitionCmtOffsetTimestamp()) {
        {
          oprot.writeI32(struct.partitionCmtOffsetTimestamp.size());
          for (java.util.Map.Entry<java.lang.Integer, java.lang.Long> _iter321 : struct.partitionCmtOffsetTimestamp.entrySet())
          {
            oprot.writeI32(_iter321.getKey());
            oprot.writeI64(_iter321.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TKafkaRLTaskProgress struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TMap _map322 = iprot.readMapBegin(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I64); 
        struct.partitionCmtOffset = new java.util.HashMap<java.lang.Integer,java.lang.Long>(2*_map322.size);
        int _key323;
        long _val324;
        for (int _i325 = 0; _i325 < _map322.size; ++_i325)
        {
          _key323 = iprot.readI32();
          _val324 = iprot.readI64();
          struct.partitionCmtOffset.put(_key323, _val324);
        }
      }
      struct.setPartitionCmtOffsetIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map326 = iprot.readMapBegin(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I64); 
          struct.partitionCmtOffsetTimestamp = new java.util.HashMap<java.lang.Integer,java.lang.Long>(2*_map326.size);
          int _key327;
          long _val328;
          for (int _i329 = 0; _i329 < _map326.size; ++_i329)
          {
            _key327 = iprot.readI32();
            _val328 = iprot.readI64();
            struct.partitionCmtOffsetTimestamp.put(_key327, _val328);
          }
        }
        struct.setPartitionCmtOffsetTimestampIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

