/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TFunctionCallExpr implements org.apache.thrift.TBase<TFunctionCallExpr, TFunctionCallExpr._Fields>, java.io.Serializable, Cloneable, Comparable<TFunctionCallExpr> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TFunctionCallExpr");

  private static final org.apache.thrift.protocol.TField FN_FIELD_DESC = new org.apache.thrift.protocol.TField("fn", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField VARARG_START_IDX_FIELD_DESC = new org.apache.thrift.protocol.TField("vararg_start_idx", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TFunctionCallExprStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TFunctionCallExprTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TFunction fn; // required
  public int vararg_start_idx; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FN((short)1, "fn"),
    VARARG_START_IDX((short)2, "vararg_start_idx");

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
        case 1: // FN
          return FN;
        case 2: // VARARG_START_IDX
          return VARARG_START_IDX;
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
  private static final int __VARARG_START_IDX_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.VARARG_START_IDX};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FN, new org.apache.thrift.meta_data.FieldMetaData("fn", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TFunction.class)));
    tmpMap.put(_Fields.VARARG_START_IDX, new org.apache.thrift.meta_data.FieldMetaData("vararg_start_idx", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TFunctionCallExpr.class, metaDataMap);
  }

  public TFunctionCallExpr() {
  }

  public TFunctionCallExpr(
    com.starrocks.thrift.TFunction fn)
  {
    this();
    this.fn = fn;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TFunctionCallExpr(TFunctionCallExpr other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFn()) {
      this.fn = new com.starrocks.thrift.TFunction(other.fn);
    }
    this.vararg_start_idx = other.vararg_start_idx;
  }

  @Override
  public TFunctionCallExpr deepCopy() {
    return new TFunctionCallExpr(this);
  }

  @Override
  public void clear() {
    this.fn = null;
    setVararg_start_idxIsSet(false);
    this.vararg_start_idx = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TFunction getFn() {
    return this.fn;
  }

  public TFunctionCallExpr setFn(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TFunction fn) {
    this.fn = fn;
    return this;
  }

  public void unsetFn() {
    this.fn = null;
  }

  /** Returns true if field fn is set (has been assigned a value) and false otherwise */
  public boolean isSetFn() {
    return this.fn != null;
  }

  public void setFnIsSet(boolean value) {
    if (!value) {
      this.fn = null;
    }
  }

  public int getVararg_start_idx() {
    return this.vararg_start_idx;
  }

  public TFunctionCallExpr setVararg_start_idx(int vararg_start_idx) {
    this.vararg_start_idx = vararg_start_idx;
    setVararg_start_idxIsSet(true);
    return this;
  }

  public void unsetVararg_start_idx() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VARARG_START_IDX_ISSET_ID);
  }

  /** Returns true if field vararg_start_idx is set (has been assigned a value) and false otherwise */
  public boolean isSetVararg_start_idx() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VARARG_START_IDX_ISSET_ID);
  }

  public void setVararg_start_idxIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VARARG_START_IDX_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case FN:
      if (value == null) {
        unsetFn();
      } else {
        setFn((com.starrocks.thrift.TFunction)value);
      }
      break;

    case VARARG_START_IDX:
      if (value == null) {
        unsetVararg_start_idx();
      } else {
        setVararg_start_idx((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FN:
      return getFn();

    case VARARG_START_IDX:
      return getVararg_start_idx();

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
    case FN:
      return isSetFn();
    case VARARG_START_IDX:
      return isSetVararg_start_idx();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TFunctionCallExpr)
      return this.equals((TFunctionCallExpr)that);
    return false;
  }

  public boolean equals(TFunctionCallExpr that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_fn = true && this.isSetFn();
    boolean that_present_fn = true && that.isSetFn();
    if (this_present_fn || that_present_fn) {
      if (!(this_present_fn && that_present_fn))
        return false;
      if (!this.fn.equals(that.fn))
        return false;
    }

    boolean this_present_vararg_start_idx = true && this.isSetVararg_start_idx();
    boolean that_present_vararg_start_idx = true && that.isSetVararg_start_idx();
    if (this_present_vararg_start_idx || that_present_vararg_start_idx) {
      if (!(this_present_vararg_start_idx && that_present_vararg_start_idx))
        return false;
      if (this.vararg_start_idx != that.vararg_start_idx)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetFn()) ? 131071 : 524287);
    if (isSetFn())
      hashCode = hashCode * 8191 + fn.hashCode();

    hashCode = hashCode * 8191 + ((isSetVararg_start_idx()) ? 131071 : 524287);
    if (isSetVararg_start_idx())
      hashCode = hashCode * 8191 + vararg_start_idx;

    return hashCode;
  }

  @Override
  public int compareTo(TFunctionCallExpr other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetFn(), other.isSetFn());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFn()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fn, other.fn);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetVararg_start_idx(), other.isSetVararg_start_idx());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVararg_start_idx()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.vararg_start_idx, other.vararg_start_idx);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TFunctionCallExpr(");
    boolean first = true;

    sb.append("fn:");
    if (this.fn == null) {
      sb.append("null");
    } else {
      sb.append(this.fn);
    }
    first = false;
    if (isSetVararg_start_idx()) {
      if (!first) sb.append(", ");
      sb.append("vararg_start_idx:");
      sb.append(this.vararg_start_idx);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (fn == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'fn' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (fn != null) {
      fn.validate();
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

  private static class TFunctionCallExprStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFunctionCallExprStandardScheme getScheme() {
      return new TFunctionCallExprStandardScheme();
    }
  }

  private static class TFunctionCallExprStandardScheme extends org.apache.thrift.scheme.StandardScheme<TFunctionCallExpr> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TFunctionCallExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.fn = new com.starrocks.thrift.TFunction();
              struct.fn.read(iprot);
              struct.setFnIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VARARG_START_IDX
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.vararg_start_idx = iprot.readI32();
              struct.setVararg_start_idxIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TFunctionCallExpr struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.fn != null) {
        oprot.writeFieldBegin(FN_FIELD_DESC);
        struct.fn.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.isSetVararg_start_idx()) {
        oprot.writeFieldBegin(VARARG_START_IDX_FIELD_DESC);
        oprot.writeI32(struct.vararg_start_idx);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TFunctionCallExprTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFunctionCallExprTupleScheme getScheme() {
      return new TFunctionCallExprTupleScheme();
    }
  }

  private static class TFunctionCallExprTupleScheme extends org.apache.thrift.scheme.TupleScheme<TFunctionCallExpr> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TFunctionCallExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.fn.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetVararg_start_idx()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetVararg_start_idx()) {
        oprot.writeI32(struct.vararg_start_idx);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TFunctionCallExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.fn = new com.starrocks.thrift.TFunction();
      struct.fn.read(iprot);
      struct.setFnIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.vararg_start_idx = iprot.readI32();
        struct.setVararg_start_idxIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

