/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TImmutablePartitionRequest implements org.apache.thrift.TBase<TImmutablePartitionRequest, TImmutablePartitionRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TImmutablePartitionRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TImmutablePartitionRequest");

  private static final org.apache.thrift.protocol.TField TXN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("txn_id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField DB_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("db_id", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField TABLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("table_id", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField PARTITION_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("partition_ids", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TImmutablePartitionRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TImmutablePartitionRequestTupleSchemeFactory();

  public long txn_id; // optional
  public long db_id; // optional
  public long table_id; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Long> partition_ids; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TXN_ID((short)1, "txn_id"),
    DB_ID((short)2, "db_id"),
    TABLE_ID((short)3, "table_id"),
    PARTITION_IDS((short)4, "partition_ids");

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
        case 1: // TXN_ID
          return TXN_ID;
        case 2: // DB_ID
          return DB_ID;
        case 3: // TABLE_ID
          return TABLE_ID;
        case 4: // PARTITION_IDS
          return PARTITION_IDS;
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
  private static final int __TXN_ID_ISSET_ID = 0;
  private static final int __DB_ID_ISSET_ID = 1;
  private static final int __TABLE_ID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TXN_ID,_Fields.DB_ID,_Fields.TABLE_ID,_Fields.PARTITION_IDS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TXN_ID, new org.apache.thrift.meta_data.FieldMetaData("txn_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DB_ID, new org.apache.thrift.meta_data.FieldMetaData("db_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TABLE_ID, new org.apache.thrift.meta_data.FieldMetaData("table_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.PARTITION_IDS, new org.apache.thrift.meta_data.FieldMetaData("partition_ids", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TImmutablePartitionRequest.class, metaDataMap);
  }

  public TImmutablePartitionRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TImmutablePartitionRequest(TImmutablePartitionRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.txn_id = other.txn_id;
    this.db_id = other.db_id;
    this.table_id = other.table_id;
    if (other.isSetPartition_ids()) {
      java.util.List<java.lang.Long> __this__partition_ids = new java.util.ArrayList<java.lang.Long>(other.partition_ids);
      this.partition_ids = __this__partition_ids;
    }
  }

  @Override
  public TImmutablePartitionRequest deepCopy() {
    return new TImmutablePartitionRequest(this);
  }

  @Override
  public void clear() {
    setTxn_idIsSet(false);
    this.txn_id = 0;
    setDb_idIsSet(false);
    this.db_id = 0;
    setTable_idIsSet(false);
    this.table_id = 0;
    this.partition_ids = null;
  }

  public long getTxn_id() {
    return this.txn_id;
  }

  public TImmutablePartitionRequest setTxn_id(long txn_id) {
    this.txn_id = txn_id;
    setTxn_idIsSet(true);
    return this;
  }

  public void unsetTxn_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TXN_ID_ISSET_ID);
  }

  /** Returns true if field txn_id is set (has been assigned a value) and false otherwise */
  public boolean isSetTxn_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TXN_ID_ISSET_ID);
  }

  public void setTxn_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TXN_ID_ISSET_ID, value);
  }

  public long getDb_id() {
    return this.db_id;
  }

  public TImmutablePartitionRequest setDb_id(long db_id) {
    this.db_id = db_id;
    setDb_idIsSet(true);
    return this;
  }

  public void unsetDb_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DB_ID_ISSET_ID);
  }

  /** Returns true if field db_id is set (has been assigned a value) and false otherwise */
  public boolean isSetDb_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DB_ID_ISSET_ID);
  }

  public void setDb_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DB_ID_ISSET_ID, value);
  }

  public long getTable_id() {
    return this.table_id;
  }

  public TImmutablePartitionRequest setTable_id(long table_id) {
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

  public int getPartition_idsSize() {
    return (this.partition_ids == null) ? 0 : this.partition_ids.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Long> getPartition_idsIterator() {
    return (this.partition_ids == null) ? null : this.partition_ids.iterator();
  }

  public void addToPartition_ids(long elem) {
    if (this.partition_ids == null) {
      this.partition_ids = new java.util.ArrayList<java.lang.Long>();
    }
    this.partition_ids.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Long> getPartition_ids() {
    return this.partition_ids;
  }

  public TImmutablePartitionRequest setPartition_ids(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Long> partition_ids) {
    this.partition_ids = partition_ids;
    return this;
  }

  public void unsetPartition_ids() {
    this.partition_ids = null;
  }

  /** Returns true if field partition_ids is set (has been assigned a value) and false otherwise */
  public boolean isSetPartition_ids() {
    return this.partition_ids != null;
  }

  public void setPartition_idsIsSet(boolean value) {
    if (!value) {
      this.partition_ids = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TXN_ID:
      if (value == null) {
        unsetTxn_id();
      } else {
        setTxn_id((java.lang.Long)value);
      }
      break;

    case DB_ID:
      if (value == null) {
        unsetDb_id();
      } else {
        setDb_id((java.lang.Long)value);
      }
      break;

    case TABLE_ID:
      if (value == null) {
        unsetTable_id();
      } else {
        setTable_id((java.lang.Long)value);
      }
      break;

    case PARTITION_IDS:
      if (value == null) {
        unsetPartition_ids();
      } else {
        setPartition_ids((java.util.List<java.lang.Long>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TXN_ID:
      return getTxn_id();

    case DB_ID:
      return getDb_id();

    case TABLE_ID:
      return getTable_id();

    case PARTITION_IDS:
      return getPartition_ids();

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
    case TXN_ID:
      return isSetTxn_id();
    case DB_ID:
      return isSetDb_id();
    case TABLE_ID:
      return isSetTable_id();
    case PARTITION_IDS:
      return isSetPartition_ids();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TImmutablePartitionRequest)
      return this.equals((TImmutablePartitionRequest)that);
    return false;
  }

  public boolean equals(TImmutablePartitionRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_txn_id = true && this.isSetTxn_id();
    boolean that_present_txn_id = true && that.isSetTxn_id();
    if (this_present_txn_id || that_present_txn_id) {
      if (!(this_present_txn_id && that_present_txn_id))
        return false;
      if (this.txn_id != that.txn_id)
        return false;
    }

    boolean this_present_db_id = true && this.isSetDb_id();
    boolean that_present_db_id = true && that.isSetDb_id();
    if (this_present_db_id || that_present_db_id) {
      if (!(this_present_db_id && that_present_db_id))
        return false;
      if (this.db_id != that.db_id)
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

    boolean this_present_partition_ids = true && this.isSetPartition_ids();
    boolean that_present_partition_ids = true && that.isSetPartition_ids();
    if (this_present_partition_ids || that_present_partition_ids) {
      if (!(this_present_partition_ids && that_present_partition_ids))
        return false;
      if (!this.partition_ids.equals(that.partition_ids))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTxn_id()) ? 131071 : 524287);
    if (isSetTxn_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(txn_id);

    hashCode = hashCode * 8191 + ((isSetDb_id()) ? 131071 : 524287);
    if (isSetDb_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(db_id);

    hashCode = hashCode * 8191 + ((isSetTable_id()) ? 131071 : 524287);
    if (isSetTable_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(table_id);

    hashCode = hashCode * 8191 + ((isSetPartition_ids()) ? 131071 : 524287);
    if (isSetPartition_ids())
      hashCode = hashCode * 8191 + partition_ids.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TImmutablePartitionRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTxn_id(), other.isSetTxn_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTxn_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.txn_id, other.txn_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDb_id(), other.isSetDb_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDb_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_id, other.db_id);
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
    lastComparison = java.lang.Boolean.compare(isSetPartition_ids(), other.isSetPartition_ids());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartition_ids()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partition_ids, other.partition_ids);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TImmutablePartitionRequest(");
    boolean first = true;

    if (isSetTxn_id()) {
      sb.append("txn_id:");
      sb.append(this.txn_id);
      first = false;
    }
    if (isSetDb_id()) {
      if (!first) sb.append(", ");
      sb.append("db_id:");
      sb.append(this.db_id);
      first = false;
    }
    if (isSetTable_id()) {
      if (!first) sb.append(", ");
      sb.append("table_id:");
      sb.append(this.table_id);
      first = false;
    }
    if (isSetPartition_ids()) {
      if (!first) sb.append(", ");
      sb.append("partition_ids:");
      if (this.partition_ids == null) {
        sb.append("null");
      } else {
        sb.append(this.partition_ids);
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

  private static class TImmutablePartitionRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TImmutablePartitionRequestStandardScheme getScheme() {
      return new TImmutablePartitionRequestStandardScheme();
    }
  }

  private static class TImmutablePartitionRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<TImmutablePartitionRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TImmutablePartitionRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TXN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.txn_id = iprot.readI64();
              struct.setTxn_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DB_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.db_id = iprot.readI64();
              struct.setDb_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TABLE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.table_id = iprot.readI64();
              struct.setTable_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PARTITION_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list638 = iprot.readListBegin();
                struct.partition_ids = new java.util.ArrayList<java.lang.Long>(_list638.size);
                long _elem639;
                for (int _i640 = 0; _i640 < _list638.size; ++_i640)
                {
                  _elem639 = iprot.readI64();
                  struct.partition_ids.add(_elem639);
                }
                iprot.readListEnd();
              }
              struct.setPartition_idsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TImmutablePartitionRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetTxn_id()) {
        oprot.writeFieldBegin(TXN_ID_FIELD_DESC);
        oprot.writeI64(struct.txn_id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetDb_id()) {
        oprot.writeFieldBegin(DB_ID_FIELD_DESC);
        oprot.writeI64(struct.db_id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTable_id()) {
        oprot.writeFieldBegin(TABLE_ID_FIELD_DESC);
        oprot.writeI64(struct.table_id);
        oprot.writeFieldEnd();
      }
      if (struct.partition_ids != null) {
        if (struct.isSetPartition_ids()) {
          oprot.writeFieldBegin(PARTITION_IDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.partition_ids.size()));
            for (long _iter641 : struct.partition_ids)
            {
              oprot.writeI64(_iter641);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TImmutablePartitionRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TImmutablePartitionRequestTupleScheme getScheme() {
      return new TImmutablePartitionRequestTupleScheme();
    }
  }

  private static class TImmutablePartitionRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<TImmutablePartitionRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TImmutablePartitionRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTxn_id()) {
        optionals.set(0);
      }
      if (struct.isSetDb_id()) {
        optionals.set(1);
      }
      if (struct.isSetTable_id()) {
        optionals.set(2);
      }
      if (struct.isSetPartition_ids()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTxn_id()) {
        oprot.writeI64(struct.txn_id);
      }
      if (struct.isSetDb_id()) {
        oprot.writeI64(struct.db_id);
      }
      if (struct.isSetTable_id()) {
        oprot.writeI64(struct.table_id);
      }
      if (struct.isSetPartition_ids()) {
        {
          oprot.writeI32(struct.partition_ids.size());
          for (long _iter642 : struct.partition_ids)
          {
            oprot.writeI64(_iter642);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TImmutablePartitionRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.txn_id = iprot.readI64();
        struct.setTxn_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.db_id = iprot.readI64();
        struct.setDb_idIsSet(true);
      }
      if (incoming.get(2)) {
        struct.table_id = iprot.readI64();
        struct.setTable_idIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list643 = iprot.readListBegin(org.apache.thrift.protocol.TType.I64);
          struct.partition_ids = new java.util.ArrayList<java.lang.Long>(_list643.size);
          long _elem644;
          for (int _i645 = 0; _i645 < _list643.size; ++_i645)
          {
            _elem644 = iprot.readI64();
            struct.partition_ids.add(_elem644);
          }
        }
        struct.setPartition_idsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
