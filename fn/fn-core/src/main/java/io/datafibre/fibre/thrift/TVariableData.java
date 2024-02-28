/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TVariableData implements org.apache.thrift.TBase<TVariableData, TVariableData._Fields>, java.io.Serializable, Cloneable, Comparable<TVariableData> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TVariableData");

  private static final org.apache.thrift.protocol.TField IS_NULL_FIELD_DESC = new org.apache.thrift.protocol.TField("isNull", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TVariableDataStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TVariableDataTupleSchemeFactory();

  public boolean isNull; // optional
  public @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer result; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    IS_NULL((short)1, "isNull"),
    RESULT((short)2, "result");

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
        case 1: // IS_NULL
          return IS_NULL;
        case 2: // RESULT
          return RESULT;
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
  private static final int __ISNULL_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.IS_NULL,_Fields.RESULT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.IS_NULL, new org.apache.thrift.meta_data.FieldMetaData("isNull", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TVariableData.class, metaDataMap);
  }

  public TVariableData() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TVariableData(TVariableData other) {
    __isset_bitfield = other.__isset_bitfield;
    this.isNull = other.isNull;
    if (other.isSetResult()) {
      this.result = org.apache.thrift.TBaseHelper.copyBinary(other.result);
    }
  }

  @Override
  public TVariableData deepCopy() {
    return new TVariableData(this);
  }

  @Override
  public void clear() {
    setIsNullIsSet(false);
    this.isNull = false;
    this.result = null;
  }

  public boolean isIsNull() {
    return this.isNull;
  }

  public TVariableData setIsNull(boolean isNull) {
    this.isNull = isNull;
    setIsNullIsSet(true);
    return this;
  }

  public void unsetIsNull() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ISNULL_ISSET_ID);
  }

  /** Returns true if field isNull is set (has been assigned a value) and false otherwise */
  public boolean isSetIsNull() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ISNULL_ISSET_ID);
  }

  public void setIsNullIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ISNULL_ISSET_ID, value);
  }

  public byte[] getResult() {
    setResult(org.apache.thrift.TBaseHelper.rightSize(result));
    return result == null ? null : result.array();
  }

  public java.nio.ByteBuffer bufferForResult() {
    return org.apache.thrift.TBaseHelper.copyBinary(result);
  }

  public TVariableData setResult(byte[] result) {
    this.result = result == null ? (java.nio.ByteBuffer)null   : java.nio.ByteBuffer.wrap(result.clone());
    return this;
  }

  public TVariableData setResult(@org.apache.thrift.annotation.Nullable java.nio.ByteBuffer result) {
    this.result = org.apache.thrift.TBaseHelper.copyBinary(result);
    return this;
  }

  public void unsetResult() {
    this.result = null;
  }

  /** Returns true if field result is set (has been assigned a value) and false otherwise */
  public boolean isSetResult() {
    return this.result != null;
  }

  public void setResultIsSet(boolean value) {
    if (!value) {
      this.result = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case IS_NULL:
      if (value == null) {
        unsetIsNull();
      } else {
        setIsNull((java.lang.Boolean)value);
      }
      break;

    case RESULT:
      if (value == null) {
        unsetResult();
      } else {
        if (value instanceof byte[]) {
          setResult((byte[])value);
        } else {
          setResult((java.nio.ByteBuffer)value);
        }
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case IS_NULL:
      return isIsNull();

    case RESULT:
      return getResult();

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
    case IS_NULL:
      return isSetIsNull();
    case RESULT:
      return isSetResult();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TVariableData)
      return this.equals((TVariableData)that);
    return false;
  }

  public boolean equals(TVariableData that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_isNull = true && this.isSetIsNull();
    boolean that_present_isNull = true && that.isSetIsNull();
    if (this_present_isNull || that_present_isNull) {
      if (!(this_present_isNull && that_present_isNull))
        return false;
      if (this.isNull != that.isNull)
        return false;
    }

    boolean this_present_result = true && this.isSetResult();
    boolean that_present_result = true && that.isSetResult();
    if (this_present_result || that_present_result) {
      if (!(this_present_result && that_present_result))
        return false;
      if (!this.result.equals(that.result))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetIsNull()) ? 131071 : 524287);
    if (isSetIsNull())
      hashCode = hashCode * 8191 + ((isNull) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((isSetResult()) ? 131071 : 524287);
    if (isSetResult())
      hashCode = hashCode * 8191 + result.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TVariableData other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetIsNull(), other.isSetIsNull());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsNull()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isNull, other.isNull);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetResult(), other.isSetResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result, other.result);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TVariableData(");
    boolean first = true;

    if (isSetIsNull()) {
      sb.append("isNull:");
      sb.append(this.isNull);
      first = false;
    }
    if (isSetResult()) {
      if (!first) sb.append(", ");
      sb.append("result:");
      if (this.result == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.result, sb);
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

  private static class TVariableDataStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TVariableDataStandardScheme getScheme() {
      return new TVariableDataStandardScheme();
    }
  }

  private static class TVariableDataStandardScheme extends org.apache.thrift.scheme.StandardScheme<TVariableData> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TVariableData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // IS_NULL
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isNull = iprot.readBool();
              struct.setIsNullIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.result = iprot.readBinary();
              struct.setResultIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TVariableData struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetIsNull()) {
        oprot.writeFieldBegin(IS_NULL_FIELD_DESC);
        oprot.writeBool(struct.isNull);
        oprot.writeFieldEnd();
      }
      if (struct.result != null) {
        if (struct.isSetResult()) {
          oprot.writeFieldBegin(RESULT_FIELD_DESC);
          oprot.writeBinary(struct.result);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TVariableDataTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TVariableDataTupleScheme getScheme() {
      return new TVariableDataTupleScheme();
    }
  }

  private static class TVariableDataTupleScheme extends org.apache.thrift.scheme.TupleScheme<TVariableData> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TVariableData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetIsNull()) {
        optionals.set(0);
      }
      if (struct.isSetResult()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetIsNull()) {
        oprot.writeBool(struct.isNull);
      }
      if (struct.isSetResult()) {
        oprot.writeBinary(struct.result);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TVariableData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.isNull = iprot.readBool();
        struct.setIsNullIsSet(true);
      }
      if (incoming.get(1)) {
        struct.result = iprot.readBinary();
        struct.setResultIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

