/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TTupleDescriptor implements org.apache.thrift.TBase<TTupleDescriptor, TTupleDescriptor._Fields>, java.io.Serializable, Cloneable, Comparable<TTupleDescriptor> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTupleDescriptor");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField BYTE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("byteSize", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField NUM_NULL_BYTES_FIELD_DESC = new org.apache.thrift.protocol.TField("numNullBytes", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TABLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tableId", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField NUM_NULL_SLOTS_FIELD_DESC = new org.apache.thrift.protocol.TField("numNullSlots", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTupleDescriptorStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTupleDescriptorTupleSchemeFactory();

  public int id; // optional
  public int byteSize; // optional
  public int numNullBytes; // optional
  public long tableId; // optional
  public int numNullSlots; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    BYTE_SIZE((short)2, "byteSize"),
    NUM_NULL_BYTES((short)3, "numNullBytes"),
    TABLE_ID((short)4, "tableId"),
    NUM_NULL_SLOTS((short)5, "numNullSlots");

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
        case 1: // ID
          return ID;
        case 2: // BYTE_SIZE
          return BYTE_SIZE;
        case 3: // NUM_NULL_BYTES
          return NUM_NULL_BYTES;
        case 4: // TABLE_ID
          return TABLE_ID;
        case 5: // NUM_NULL_SLOTS
          return NUM_NULL_SLOTS;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __BYTESIZE_ISSET_ID = 1;
  private static final int __NUMNULLBYTES_ISSET_ID = 2;
  private static final int __TABLEID_ISSET_ID = 3;
  private static final int __NUMNULLSLOTS_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.ID,_Fields.BYTE_SIZE,_Fields.NUM_NULL_BYTES,_Fields.TABLE_ID,_Fields.NUM_NULL_SLOTS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "TTupleId")));
    tmpMap.put(_Fields.BYTE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("byteSize", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NUM_NULL_BYTES, new org.apache.thrift.meta_data.FieldMetaData("numNullBytes", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TABLE_ID, new org.apache.thrift.meta_data.FieldMetaData("tableId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "TTableId")));
    tmpMap.put(_Fields.NUM_NULL_SLOTS, new org.apache.thrift.meta_data.FieldMetaData("numNullSlots", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTupleDescriptor.class, metaDataMap);
  }

  public TTupleDescriptor() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTupleDescriptor(TTupleDescriptor other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.byteSize = other.byteSize;
    this.numNullBytes = other.numNullBytes;
    this.tableId = other.tableId;
    this.numNullSlots = other.numNullSlots;
  }

  @Override
  public TTupleDescriptor deepCopy() {
    return new TTupleDescriptor(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setByteSizeIsSet(false);
    this.byteSize = 0;
    setNumNullBytesIsSet(false);
    this.numNullBytes = 0;
    setTableIdIsSet(false);
    this.tableId = 0;
    setNumNullSlotsIsSet(false);
    this.numNullSlots = 0;
  }

  public int getId() {
    return this.id;
  }

  public TTupleDescriptor setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getByteSize() {
    return this.byteSize;
  }

  public TTupleDescriptor setByteSize(int byteSize) {
    this.byteSize = byteSize;
    setByteSizeIsSet(true);
    return this;
  }

  public void unsetByteSize() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BYTESIZE_ISSET_ID);
  }

  /** Returns true if field byteSize is set (has been assigned a value) and false otherwise */
  public boolean isSetByteSize() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BYTESIZE_ISSET_ID);
  }

  public void setByteSizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BYTESIZE_ISSET_ID, value);
  }

  public int getNumNullBytes() {
    return this.numNullBytes;
  }

  public TTupleDescriptor setNumNullBytes(int numNullBytes) {
    this.numNullBytes = numNullBytes;
    setNumNullBytesIsSet(true);
    return this;
  }

  public void unsetNumNullBytes() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NUMNULLBYTES_ISSET_ID);
  }

  /** Returns true if field numNullBytes is set (has been assigned a value) and false otherwise */
  public boolean isSetNumNullBytes() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NUMNULLBYTES_ISSET_ID);
  }

  public void setNumNullBytesIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NUMNULLBYTES_ISSET_ID, value);
  }

  public long getTableId() {
    return this.tableId;
  }

  public TTupleDescriptor setTableId(long tableId) {
    this.tableId = tableId;
    setTableIdIsSet(true);
    return this;
  }

  public void unsetTableId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TABLEID_ISSET_ID);
  }

  /** Returns true if field tableId is set (has been assigned a value) and false otherwise */
  public boolean isSetTableId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TABLEID_ISSET_ID);
  }

  public void setTableIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TABLEID_ISSET_ID, value);
  }

  public int getNumNullSlots() {
    return this.numNullSlots;
  }

  public TTupleDescriptor setNumNullSlots(int numNullSlots) {
    this.numNullSlots = numNullSlots;
    setNumNullSlotsIsSet(true);
    return this;
  }

  public void unsetNumNullSlots() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NUMNULLSLOTS_ISSET_ID);
  }

  /** Returns true if field numNullSlots is set (has been assigned a value) and false otherwise */
  public boolean isSetNumNullSlots() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NUMNULLSLOTS_ISSET_ID);
  }

  public void setNumNullSlotsIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NUMNULLSLOTS_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.Integer)value);
      }
      break;

    case BYTE_SIZE:
      if (value == null) {
        unsetByteSize();
      } else {
        setByteSize((java.lang.Integer)value);
      }
      break;

    case NUM_NULL_BYTES:
      if (value == null) {
        unsetNumNullBytes();
      } else {
        setNumNullBytes((java.lang.Integer)value);
      }
      break;

    case TABLE_ID:
      if (value == null) {
        unsetTableId();
      } else {
        setTableId((java.lang.Long)value);
      }
      break;

    case NUM_NULL_SLOTS:
      if (value == null) {
        unsetNumNullSlots();
      } else {
        setNumNullSlots((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case BYTE_SIZE:
      return getByteSize();

    case NUM_NULL_BYTES:
      return getNumNullBytes();

    case TABLE_ID:
      return getTableId();

    case NUM_NULL_SLOTS:
      return getNumNullSlots();

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
    case ID:
      return isSetId();
    case BYTE_SIZE:
      return isSetByteSize();
    case NUM_NULL_BYTES:
      return isSetNumNullBytes();
    case TABLE_ID:
      return isSetTableId();
    case NUM_NULL_SLOTS:
      return isSetNumNullSlots();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TTupleDescriptor)
      return this.equals((TTupleDescriptor)that);
    return false;
  }

  public boolean equals(TTupleDescriptor that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_byteSize = true && this.isSetByteSize();
    boolean that_present_byteSize = true && that.isSetByteSize();
    if (this_present_byteSize || that_present_byteSize) {
      if (!(this_present_byteSize && that_present_byteSize))
        return false;
      if (this.byteSize != that.byteSize)
        return false;
    }

    boolean this_present_numNullBytes = true && this.isSetNumNullBytes();
    boolean that_present_numNullBytes = true && that.isSetNumNullBytes();
    if (this_present_numNullBytes || that_present_numNullBytes) {
      if (!(this_present_numNullBytes && that_present_numNullBytes))
        return false;
      if (this.numNullBytes != that.numNullBytes)
        return false;
    }

    boolean this_present_tableId = true && this.isSetTableId();
    boolean that_present_tableId = true && that.isSetTableId();
    if (this_present_tableId || that_present_tableId) {
      if (!(this_present_tableId && that_present_tableId))
        return false;
      if (this.tableId != that.tableId)
        return false;
    }

    boolean this_present_numNullSlots = true && this.isSetNumNullSlots();
    boolean that_present_numNullSlots = true && that.isSetNumNullSlots();
    if (this_present_numNullSlots || that_present_numNullSlots) {
      if (!(this_present_numNullSlots && that_present_numNullSlots))
        return false;
      if (this.numNullSlots != that.numNullSlots)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetId()) ? 131071 : 524287);
    if (isSetId())
      hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + ((isSetByteSize()) ? 131071 : 524287);
    if (isSetByteSize())
      hashCode = hashCode * 8191 + byteSize;

    hashCode = hashCode * 8191 + ((isSetNumNullBytes()) ? 131071 : 524287);
    if (isSetNumNullBytes())
      hashCode = hashCode * 8191 + numNullBytes;

    hashCode = hashCode * 8191 + ((isSetTableId()) ? 131071 : 524287);
    if (isSetTableId())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(tableId);

    hashCode = hashCode * 8191 + ((isSetNumNullSlots()) ? 131071 : 524287);
    if (isSetNumNullSlots())
      hashCode = hashCode * 8191 + numNullSlots;

    return hashCode;
  }

  @Override
  public int compareTo(TTupleDescriptor other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetId(), other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetByteSize(), other.isSetByteSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetByteSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.byteSize, other.byteSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetNumNullBytes(), other.isSetNumNullBytes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumNullBytes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numNullBytes, other.numNullBytes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTableId(), other.isSetTableId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTableId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableId, other.tableId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetNumNullSlots(), other.isSetNumNullSlots());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumNullSlots()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numNullSlots, other.numNullSlots);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTupleDescriptor(");
    boolean first = true;

    if (isSetId()) {
      sb.append("id:");
      sb.append(this.id);
      first = false;
    }
    if (isSetByteSize()) {
      if (!first) sb.append(", ");
      sb.append("byteSize:");
      sb.append(this.byteSize);
      first = false;
    }
    if (isSetNumNullBytes()) {
      if (!first) sb.append(", ");
      sb.append("numNullBytes:");
      sb.append(this.numNullBytes);
      first = false;
    }
    if (isSetTableId()) {
      if (!first) sb.append(", ");
      sb.append("tableId:");
      sb.append(this.tableId);
      first = false;
    }
    if (isSetNumNullSlots()) {
      if (!first) sb.append(", ");
      sb.append("numNullSlots:");
      sb.append(this.numNullSlots);
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

  private static class TTupleDescriptorStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTupleDescriptorStandardScheme getScheme() {
      return new TTupleDescriptorStandardScheme();
    }
  }

  private static class TTupleDescriptorStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTupleDescriptor> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TTupleDescriptor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BYTE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.byteSize = iprot.readI32();
              struct.setByteSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NUM_NULL_BYTES
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.numNullBytes = iprot.readI32();
              struct.setNumNullBytesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TABLE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.tableId = iprot.readI64();
              struct.setTableIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // NUM_NULL_SLOTS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.numNullSlots = iprot.readI32();
              struct.setNumNullSlotsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TTupleDescriptor struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetId()) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeI32(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetByteSize()) {
        oprot.writeFieldBegin(BYTE_SIZE_FIELD_DESC);
        oprot.writeI32(struct.byteSize);
        oprot.writeFieldEnd();
      }
      if (struct.isSetNumNullBytes()) {
        oprot.writeFieldBegin(NUM_NULL_BYTES_FIELD_DESC);
        oprot.writeI32(struct.numNullBytes);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTableId()) {
        oprot.writeFieldBegin(TABLE_ID_FIELD_DESC);
        oprot.writeI64(struct.tableId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetNumNullSlots()) {
        oprot.writeFieldBegin(NUM_NULL_SLOTS_FIELD_DESC);
        oprot.writeI32(struct.numNullSlots);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTupleDescriptorTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTupleDescriptorTupleScheme getScheme() {
      return new TTupleDescriptorTupleScheme();
    }
  }

  private static class TTupleDescriptorTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTupleDescriptor> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTupleDescriptor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetByteSize()) {
        optionals.set(1);
      }
      if (struct.isSetNumNullBytes()) {
        optionals.set(2);
      }
      if (struct.isSetTableId()) {
        optionals.set(3);
      }
      if (struct.isSetNumNullSlots()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetByteSize()) {
        oprot.writeI32(struct.byteSize);
      }
      if (struct.isSetNumNullBytes()) {
        oprot.writeI32(struct.numNullBytes);
      }
      if (struct.isSetTableId()) {
        oprot.writeI64(struct.tableId);
      }
      if (struct.isSetNumNullSlots()) {
        oprot.writeI32(struct.numNullSlots);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTupleDescriptor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.byteSize = iprot.readI32();
        struct.setByteSizeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.numNullBytes = iprot.readI32();
        struct.setNumNullBytesIsSet(true);
      }
      if (incoming.get(3)) {
        struct.tableId = iprot.readI64();
        struct.setTableIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.numNullSlots = iprot.readI32();
        struct.setNumNullSlotsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

