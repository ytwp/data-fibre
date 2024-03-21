/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TDictionaryGetExpr implements org.apache.thrift.TBase<TDictionaryGetExpr, TDictionaryGetExpr._Fields>, java.io.Serializable, Cloneable, Comparable<TDictionaryGetExpr> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDictionaryGetExpr");

  private static final org.apache.thrift.protocol.TField DICT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("dict_id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TXN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("txn_id", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField KEY_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("key_size", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TDictionaryGetExprStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TDictionaryGetExprTupleSchemeFactory();

  public long dict_id; // optional
  public long txn_id; // optional
  public int key_size; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DICT_ID((short)1, "dict_id"),
    TXN_ID((short)2, "txn_id"),
    KEY_SIZE((short)3, "key_size");

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
        case 1: // DICT_ID
          return DICT_ID;
        case 2: // TXN_ID
          return TXN_ID;
        case 3: // KEY_SIZE
          return KEY_SIZE;
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
  private static final int __DICT_ID_ISSET_ID = 0;
  private static final int __TXN_ID_ISSET_ID = 1;
  private static final int __KEY_SIZE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DICT_ID,_Fields.TXN_ID,_Fields.KEY_SIZE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DICT_ID, new org.apache.thrift.meta_data.FieldMetaData("dict_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TXN_ID, new org.apache.thrift.meta_data.FieldMetaData("txn_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.KEY_SIZE, new org.apache.thrift.meta_data.FieldMetaData("key_size", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDictionaryGetExpr.class, metaDataMap);
  }

  public TDictionaryGetExpr() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDictionaryGetExpr(TDictionaryGetExpr other) {
    __isset_bitfield = other.__isset_bitfield;
    this.dict_id = other.dict_id;
    this.txn_id = other.txn_id;
    this.key_size = other.key_size;
  }

  @Override
  public TDictionaryGetExpr deepCopy() {
    return new TDictionaryGetExpr(this);
  }

  @Override
  public void clear() {
    setDict_idIsSet(false);
    this.dict_id = 0;
    setTxn_idIsSet(false);
    this.txn_id = 0;
    setKey_sizeIsSet(false);
    this.key_size = 0;
  }

  public long getDict_id() {
    return this.dict_id;
  }

  public TDictionaryGetExpr setDict_id(long dict_id) {
    this.dict_id = dict_id;
    setDict_idIsSet(true);
    return this;
  }

  public void unsetDict_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DICT_ID_ISSET_ID);
  }

  /** Returns true if field dict_id is set (has been assigned a value) and false otherwise */
  public boolean isSetDict_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DICT_ID_ISSET_ID);
  }

  public void setDict_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DICT_ID_ISSET_ID, value);
  }

  public long getTxn_id() {
    return this.txn_id;
  }

  public TDictionaryGetExpr setTxn_id(long txn_id) {
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

  public int getKey_size() {
    return this.key_size;
  }

  public TDictionaryGetExpr setKey_size(int key_size) {
    this.key_size = key_size;
    setKey_sizeIsSet(true);
    return this;
  }

  public void unsetKey_size() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __KEY_SIZE_ISSET_ID);
  }

  /** Returns true if field key_size is set (has been assigned a value) and false otherwise */
  public boolean isSetKey_size() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __KEY_SIZE_ISSET_ID);
  }

  public void setKey_sizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __KEY_SIZE_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DICT_ID:
      if (value == null) {
        unsetDict_id();
      } else {
        setDict_id((java.lang.Long)value);
      }
      break;

    case TXN_ID:
      if (value == null) {
        unsetTxn_id();
      } else {
        setTxn_id((java.lang.Long)value);
      }
      break;

    case KEY_SIZE:
      if (value == null) {
        unsetKey_size();
      } else {
        setKey_size((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DICT_ID:
      return getDict_id();

    case TXN_ID:
      return getTxn_id();

    case KEY_SIZE:
      return getKey_size();

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
    case DICT_ID:
      return isSetDict_id();
    case TXN_ID:
      return isSetTxn_id();
    case KEY_SIZE:
      return isSetKey_size();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TDictionaryGetExpr)
      return this.equals((TDictionaryGetExpr)that);
    return false;
  }

  public boolean equals(TDictionaryGetExpr that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_dict_id = true && this.isSetDict_id();
    boolean that_present_dict_id = true && that.isSetDict_id();
    if (this_present_dict_id || that_present_dict_id) {
      if (!(this_present_dict_id && that_present_dict_id))
        return false;
      if (this.dict_id != that.dict_id)
        return false;
    }

    boolean this_present_txn_id = true && this.isSetTxn_id();
    boolean that_present_txn_id = true && that.isSetTxn_id();
    if (this_present_txn_id || that_present_txn_id) {
      if (!(this_present_txn_id && that_present_txn_id))
        return false;
      if (this.txn_id != that.txn_id)
        return false;
    }

    boolean this_present_key_size = true && this.isSetKey_size();
    boolean that_present_key_size = true && that.isSetKey_size();
    if (this_present_key_size || that_present_key_size) {
      if (!(this_present_key_size && that_present_key_size))
        return false;
      if (this.key_size != that.key_size)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDict_id()) ? 131071 : 524287);
    if (isSetDict_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(dict_id);

    hashCode = hashCode * 8191 + ((isSetTxn_id()) ? 131071 : 524287);
    if (isSetTxn_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(txn_id);

    hashCode = hashCode * 8191 + ((isSetKey_size()) ? 131071 : 524287);
    if (isSetKey_size())
      hashCode = hashCode * 8191 + key_size;

    return hashCode;
  }

  @Override
  public int compareTo(TDictionaryGetExpr other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDict_id(), other.isSetDict_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDict_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dict_id, other.dict_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = java.lang.Boolean.compare(isSetKey_size(), other.isSetKey_size());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKey_size()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.key_size, other.key_size);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TDictionaryGetExpr(");
    boolean first = true;

    if (isSetDict_id()) {
      sb.append("dict_id:");
      sb.append(this.dict_id);
      first = false;
    }
    if (isSetTxn_id()) {
      if (!first) sb.append(", ");
      sb.append("txn_id:");
      sb.append(this.txn_id);
      first = false;
    }
    if (isSetKey_size()) {
      if (!first) sb.append(", ");
      sb.append("key_size:");
      sb.append(this.key_size);
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

  private static class TDictionaryGetExprStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TDictionaryGetExprStandardScheme getScheme() {
      return new TDictionaryGetExprStandardScheme();
    }
  }

  private static class TDictionaryGetExprStandardScheme extends org.apache.thrift.scheme.StandardScheme<TDictionaryGetExpr> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TDictionaryGetExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DICT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.dict_id = iprot.readI64();
              struct.setDict_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TXN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.txn_id = iprot.readI64();
              struct.setTxn_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // KEY_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.key_size = iprot.readI32();
              struct.setKey_sizeIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TDictionaryGetExpr struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetDict_id()) {
        oprot.writeFieldBegin(DICT_ID_FIELD_DESC);
        oprot.writeI64(struct.dict_id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTxn_id()) {
        oprot.writeFieldBegin(TXN_ID_FIELD_DESC);
        oprot.writeI64(struct.txn_id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetKey_size()) {
        oprot.writeFieldBegin(KEY_SIZE_FIELD_DESC);
        oprot.writeI32(struct.key_size);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDictionaryGetExprTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TDictionaryGetExprTupleScheme getScheme() {
      return new TDictionaryGetExprTupleScheme();
    }
  }

  private static class TDictionaryGetExprTupleScheme extends org.apache.thrift.scheme.TupleScheme<TDictionaryGetExpr> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDictionaryGetExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDict_id()) {
        optionals.set(0);
      }
      if (struct.isSetTxn_id()) {
        optionals.set(1);
      }
      if (struct.isSetKey_size()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDict_id()) {
        oprot.writeI64(struct.dict_id);
      }
      if (struct.isSetTxn_id()) {
        oprot.writeI64(struct.txn_id);
      }
      if (struct.isSetKey_size()) {
        oprot.writeI32(struct.key_size);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDictionaryGetExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.dict_id = iprot.readI64();
        struct.setDict_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.txn_id = iprot.readI64();
        struct.setTxn_idIsSet(true);
      }
      if (incoming.get(2)) {
        struct.key_size = iprot.readI32();
        struct.setKey_sizeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
