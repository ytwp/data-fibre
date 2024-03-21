/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TBinlogScanRange implements org.apache.thrift.TBase<TBinlogScanRange, TBinlogScanRange._Fields>, java.io.Serializable, Cloneable, Comparable<TBinlogScanRange> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TBinlogScanRange");

  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("db_name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TABLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("table_id", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField PARTITION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("partition_id", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField TABLET_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tablet_id", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField OFFSET_FIELD_DESC = new org.apache.thrift.protocol.TField("offset", org.apache.thrift.protocol.TType.STRUCT, (short)11);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TBinlogScanRangeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TBinlogScanRangeTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String db_name; // optional
  public long table_id; // optional
  public long partition_id; // optional
  public long tablet_id; // optional
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TBinlogOffset offset; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DB_NAME((short)1, "db_name"),
    TABLE_ID((short)2, "table_id"),
    PARTITION_ID((short)3, "partition_id"),
    TABLET_ID((short)4, "tablet_id"),
    OFFSET((short)11, "offset");

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
        case 1: // DB_NAME
          return DB_NAME;
        case 2: // TABLE_ID
          return TABLE_ID;
        case 3: // PARTITION_ID
          return PARTITION_ID;
        case 4: // TABLET_ID
          return TABLET_ID;
        case 11: // OFFSET
          return OFFSET;
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
  private static final int __TABLE_ID_ISSET_ID = 0;
  private static final int __PARTITION_ID_ISSET_ID = 1;
  private static final int __TABLET_ID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DB_NAME,_Fields.TABLE_ID,_Fields.PARTITION_ID,_Fields.TABLET_ID,_Fields.OFFSET};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("db_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLE_ID, new org.apache.thrift.meta_data.FieldMetaData("table_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "TTableId")));
    tmpMap.put(_Fields.PARTITION_ID, new org.apache.thrift.meta_data.FieldMetaData("partition_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "TPartitionId")));
    tmpMap.put(_Fields.TABLET_ID, new org.apache.thrift.meta_data.FieldMetaData("tablet_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "TTabletId")));
    tmpMap.put(_Fields.OFFSET, new org.apache.thrift.meta_data.FieldMetaData("offset", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TBinlogOffset.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TBinlogScanRange.class, metaDataMap);
  }

  public TBinlogScanRange() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TBinlogScanRange(TBinlogScanRange other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetDb_name()) {
      this.db_name = other.db_name;
    }
    this.table_id = other.table_id;
    this.partition_id = other.partition_id;
    this.tablet_id = other.tablet_id;
    if (other.isSetOffset()) {
      this.offset = new io.datafibre.fibre.thrift.TBinlogOffset(other.offset);
    }
  }

  @Override
  public TBinlogScanRange deepCopy() {
    return new TBinlogScanRange(this);
  }

  @Override
  public void clear() {
    this.db_name = null;
    setTable_idIsSet(false);
    this.table_id = 0;
    setPartition_idIsSet(false);
    this.partition_id = 0;
    setTablet_idIsSet(false);
    this.tablet_id = 0;
    this.offset = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDb_name() {
    return this.db_name;
  }

  public TBinlogScanRange setDb_name(@org.apache.thrift.annotation.Nullable java.lang.String db_name) {
    this.db_name = db_name;
    return this;
  }

  public void unsetDb_name() {
    this.db_name = null;
  }

  /** Returns true if field db_name is set (has been assigned a value) and false otherwise */
  public boolean isSetDb_name() {
    return this.db_name != null;
  }

  public void setDb_nameIsSet(boolean value) {
    if (!value) {
      this.db_name = null;
    }
  }

  public long getTable_id() {
    return this.table_id;
  }

  public TBinlogScanRange setTable_id(long table_id) {
    this.table_id = table_id;
    setTable_idIsSet(true);
    return this;
  }

  public void unsetTable_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TABLE_ID_ISSET_ID);
  }

  /** Returns true if field table_id is set (has been assigned a value) and false otherwise */
  public boolean isSetTable_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TABLE_ID_ISSET_ID);
  }

  public void setTable_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TABLE_ID_ISSET_ID, value);
  }

  public long getPartition_id() {
    return this.partition_id;
  }

  public TBinlogScanRange setPartition_id(long partition_id) {
    this.partition_id = partition_id;
    setPartition_idIsSet(true);
    return this;
  }

  public void unsetPartition_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PARTITION_ID_ISSET_ID);
  }

  /** Returns true if field partition_id is set (has been assigned a value) and false otherwise */
  public boolean isSetPartition_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PARTITION_ID_ISSET_ID);
  }

  public void setPartition_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PARTITION_ID_ISSET_ID, value);
  }

  public long getTablet_id() {
    return this.tablet_id;
  }

  public TBinlogScanRange setTablet_id(long tablet_id) {
    this.tablet_id = tablet_id;
    setTablet_idIsSet(true);
    return this;
  }

  public void unsetTablet_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TABLET_ID_ISSET_ID);
  }

  /** Returns true if field tablet_id is set (has been assigned a value) and false otherwise */
  public boolean isSetTablet_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TABLET_ID_ISSET_ID);
  }

  public void setTablet_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TABLET_ID_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TBinlogOffset getOffset() {
    return this.offset;
  }

  public TBinlogScanRange setOffset(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TBinlogOffset offset) {
    this.offset = offset;
    return this;
  }

  public void unsetOffset() {
    this.offset = null;
  }

  /** Returns true if field offset is set (has been assigned a value) and false otherwise */
  public boolean isSetOffset() {
    return this.offset != null;
  }

  public void setOffsetIsSet(boolean value) {
    if (!value) {
      this.offset = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DB_NAME:
      if (value == null) {
        unsetDb_name();
      } else {
        setDb_name((java.lang.String)value);
      }
      break;

    case TABLE_ID:
      if (value == null) {
        unsetTable_id();
      } else {
        setTable_id((java.lang.Long)value);
      }
      break;

    case PARTITION_ID:
      if (value == null) {
        unsetPartition_id();
      } else {
        setPartition_id((java.lang.Long)value);
      }
      break;

    case TABLET_ID:
      if (value == null) {
        unsetTablet_id();
      } else {
        setTablet_id((java.lang.Long)value);
      }
      break;

    case OFFSET:
      if (value == null) {
        unsetOffset();
      } else {
        setOffset((io.datafibre.fibre.thrift.TBinlogOffset)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DB_NAME:
      return getDb_name();

    case TABLE_ID:
      return getTable_id();

    case PARTITION_ID:
      return getPartition_id();

    case TABLET_ID:
      return getTablet_id();

    case OFFSET:
      return getOffset();

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
    case DB_NAME:
      return isSetDb_name();
    case TABLE_ID:
      return isSetTable_id();
    case PARTITION_ID:
      return isSetPartition_id();
    case TABLET_ID:
      return isSetTablet_id();
    case OFFSET:
      return isSetOffset();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TBinlogScanRange)
      return this.equals((TBinlogScanRange)that);
    return false;
  }

  public boolean equals(TBinlogScanRange that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_db_name = true && this.isSetDb_name();
    boolean that_present_db_name = true && that.isSetDb_name();
    if (this_present_db_name || that_present_db_name) {
      if (!(this_present_db_name && that_present_db_name))
        return false;
      if (!this.db_name.equals(that.db_name))
        return false;
    }

    boolean this_present_table_id = true && this.isSetTable_id();
    boolean that_present_table_id = true && that.isSetTable_id();
    if (this_present_table_id || that_present_table_id) {
      if (!(this_present_table_id && that_present_table_id))
        return false;
      if (this.table_id != that.table_id)
        return false;
    }

    boolean this_present_partition_id = true && this.isSetPartition_id();
    boolean that_present_partition_id = true && that.isSetPartition_id();
    if (this_present_partition_id || that_present_partition_id) {
      if (!(this_present_partition_id && that_present_partition_id))
        return false;
      if (this.partition_id != that.partition_id)
        return false;
    }

    boolean this_present_tablet_id = true && this.isSetTablet_id();
    boolean that_present_tablet_id = true && that.isSetTablet_id();
    if (this_present_tablet_id || that_present_tablet_id) {
      if (!(this_present_tablet_id && that_present_tablet_id))
        return false;
      if (this.tablet_id != that.tablet_id)
        return false;
    }

    boolean this_present_offset = true && this.isSetOffset();
    boolean that_present_offset = true && that.isSetOffset();
    if (this_present_offset || that_present_offset) {
      if (!(this_present_offset && that_present_offset))
        return false;
      if (!this.offset.equals(that.offset))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDb_name()) ? 131071 : 524287);
    if (isSetDb_name())
      hashCode = hashCode * 8191 + db_name.hashCode();

    hashCode = hashCode * 8191 + ((isSetTable_id()) ? 131071 : 524287);
    if (isSetTable_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(table_id);

    hashCode = hashCode * 8191 + ((isSetPartition_id()) ? 131071 : 524287);
    if (isSetPartition_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(partition_id);

    hashCode = hashCode * 8191 + ((isSetTablet_id()) ? 131071 : 524287);
    if (isSetTablet_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(tablet_id);

    hashCode = hashCode * 8191 + ((isSetOffset()) ? 131071 : 524287);
    if (isSetOffset())
      hashCode = hashCode * 8191 + offset.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TBinlogScanRange other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDb_name(), other.isSetDb_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDb_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_name, other.db_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTable_id(), other.isSetTable_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table_id, other.table_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPartition_id(), other.isSetPartition_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartition_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partition_id, other.partition_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTablet_id(), other.isSetTablet_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTablet_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablet_id, other.tablet_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetOffset(), other.isSetOffset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOffset()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.offset, other.offset);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TBinlogScanRange(");
    boolean first = true;

    if (isSetDb_name()) {
      sb.append("db_name:");
      if (this.db_name == null) {
        sb.append("null");
      } else {
        sb.append(this.db_name);
      }
      first = false;
    }
    if (isSetTable_id()) {
      if (!first) sb.append(", ");
      sb.append("table_id:");
      sb.append(this.table_id);
      first = false;
    }
    if (isSetPartition_id()) {
      if (!first) sb.append(", ");
      sb.append("partition_id:");
      sb.append(this.partition_id);
      first = false;
    }
    if (isSetTablet_id()) {
      if (!first) sb.append(", ");
      sb.append("tablet_id:");
      sb.append(this.tablet_id);
      first = false;
    }
    if (isSetOffset()) {
      if (!first) sb.append(", ");
      sb.append("offset:");
      if (this.offset == null) {
        sb.append("null");
      } else {
        sb.append(this.offset);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (offset != null) {
      offset.validate();
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

  private static class TBinlogScanRangeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TBinlogScanRangeStandardScheme getScheme() {
      return new TBinlogScanRangeStandardScheme();
    }
  }

  private static class TBinlogScanRangeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TBinlogScanRange> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TBinlogScanRange struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.db_name = iprot.readString();
              struct.setDb_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TABLE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.table_id = iprot.readI64();
              struct.setTable_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PARTITION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.partition_id = iprot.readI64();
              struct.setPartition_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TABLET_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.tablet_id = iprot.readI64();
              struct.setTablet_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 11: // OFFSET
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.offset = new io.datafibre.fibre.thrift.TBinlogOffset();
              struct.offset.read(iprot);
              struct.setOffsetIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TBinlogScanRange struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.db_name != null) {
        if (struct.isSetDb_name()) {
          oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
          oprot.writeString(struct.db_name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetTable_id()) {
        oprot.writeFieldBegin(TABLE_ID_FIELD_DESC);
        oprot.writeI64(struct.table_id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPartition_id()) {
        oprot.writeFieldBegin(PARTITION_ID_FIELD_DESC);
        oprot.writeI64(struct.partition_id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTablet_id()) {
        oprot.writeFieldBegin(TABLET_ID_FIELD_DESC);
        oprot.writeI64(struct.tablet_id);
        oprot.writeFieldEnd();
      }
      if (struct.offset != null) {
        if (struct.isSetOffset()) {
          oprot.writeFieldBegin(OFFSET_FIELD_DESC);
          struct.offset.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TBinlogScanRangeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TBinlogScanRangeTupleScheme getScheme() {
      return new TBinlogScanRangeTupleScheme();
    }
  }

  private static class TBinlogScanRangeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TBinlogScanRange> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TBinlogScanRange struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDb_name()) {
        optionals.set(0);
      }
      if (struct.isSetTable_id()) {
        optionals.set(1);
      }
      if (struct.isSetPartition_id()) {
        optionals.set(2);
      }
      if (struct.isSetTablet_id()) {
        optionals.set(3);
      }
      if (struct.isSetOffset()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetDb_name()) {
        oprot.writeString(struct.db_name);
      }
      if (struct.isSetTable_id()) {
        oprot.writeI64(struct.table_id);
      }
      if (struct.isSetPartition_id()) {
        oprot.writeI64(struct.partition_id);
      }
      if (struct.isSetTablet_id()) {
        oprot.writeI64(struct.tablet_id);
      }
      if (struct.isSetOffset()) {
        struct.offset.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TBinlogScanRange struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.db_name = iprot.readString();
        struct.setDb_nameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.table_id = iprot.readI64();
        struct.setTable_idIsSet(true);
      }
      if (incoming.get(2)) {
        struct.partition_id = iprot.readI64();
        struct.setPartition_idIsSet(true);
      }
      if (incoming.get(3)) {
        struct.tablet_id = iprot.readI64();
        struct.setTablet_idIsSet(true);
      }
      if (incoming.get(4)) {
        struct.offset = new io.datafibre.fibre.thrift.TBinlogOffset();
        struct.offset.read(iprot);
        struct.setOffsetIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
