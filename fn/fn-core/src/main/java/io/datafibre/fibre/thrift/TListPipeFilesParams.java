/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TListPipeFilesParams implements org.apache.thrift.TBase<TListPipeFilesParams, TListPipeFilesParams._Fields>, java.io.Serializable, Cloneable, Comparable<TListPipeFilesParams> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TListPipeFilesParams");

  private static final org.apache.thrift.protocol.TField USER_IDENT_FIELD_DESC = new org.apache.thrift.protocol.TField("user_ident", org.apache.thrift.protocol.TType.STRUCT, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TListPipeFilesParamsStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TListPipeFilesParamsTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TUserIdentity user_ident; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_IDENT((short)1, "user_ident");

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
        case 1: // USER_IDENT
          return USER_IDENT;
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
  private static final _Fields optionals[] = {_Fields.USER_IDENT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_IDENT, new org.apache.thrift.meta_data.FieldMetaData("user_ident", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TUserIdentity.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TListPipeFilesParams.class, metaDataMap);
  }

  public TListPipeFilesParams() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TListPipeFilesParams(TListPipeFilesParams other) {
    if (other.isSetUser_ident()) {
      this.user_ident = new com.starrocks.thrift.TUserIdentity(other.user_ident);
    }
  }

  @Override
  public TListPipeFilesParams deepCopy() {
    return new TListPipeFilesParams(this);
  }

  @Override
  public void clear() {
    this.user_ident = null;
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TUserIdentity getUser_ident() {
    return this.user_ident;
  }

  public TListPipeFilesParams setUser_ident(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TUserIdentity user_ident) {
    this.user_ident = user_ident;
    return this;
  }

  public void unsetUser_ident() {
    this.user_ident = null;
  }

  /** Returns true if field user_ident is set (has been assigned a value) and false otherwise */
  public boolean isSetUser_ident() {
    return this.user_ident != null;
  }

  public void setUser_identIsSet(boolean value) {
    if (!value) {
      this.user_ident = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case USER_IDENT:
      if (value == null) {
        unsetUser_ident();
      } else {
        setUser_ident((com.starrocks.thrift.TUserIdentity)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_IDENT:
      return getUser_ident();

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
    case USER_IDENT:
      return isSetUser_ident();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TListPipeFilesParams)
      return this.equals((TListPipeFilesParams)that);
    return false;
  }

  public boolean equals(TListPipeFilesParams that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_user_ident = true && this.isSetUser_ident();
    boolean that_present_user_ident = true && that.isSetUser_ident();
    if (this_present_user_ident || that_present_user_ident) {
      if (!(this_present_user_ident && that_present_user_ident))
        return false;
      if (!this.user_ident.equals(that.user_ident))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetUser_ident()) ? 131071 : 524287);
    if (isSetUser_ident())
      hashCode = hashCode * 8191 + user_ident.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TListPipeFilesParams other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetUser_ident(), other.isSetUser_ident());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser_ident()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user_ident, other.user_ident);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TListPipeFilesParams(");
    boolean first = true;

    if (isSetUser_ident()) {
      sb.append("user_ident:");
      if (this.user_ident == null) {
        sb.append("null");
      } else {
        sb.append(this.user_ident);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (user_ident != null) {
      user_ident.validate();
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

  private static class TListPipeFilesParamsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TListPipeFilesParamsStandardScheme getScheme() {
      return new TListPipeFilesParamsStandardScheme();
    }
  }

  private static class TListPipeFilesParamsStandardScheme extends org.apache.thrift.scheme.StandardScheme<TListPipeFilesParams> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TListPipeFilesParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_IDENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.user_ident = new com.starrocks.thrift.TUserIdentity();
              struct.user_ident.read(iprot);
              struct.setUser_identIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TListPipeFilesParams struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.user_ident != null) {
        if (struct.isSetUser_ident()) {
          oprot.writeFieldBegin(USER_IDENT_FIELD_DESC);
          struct.user_ident.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TListPipeFilesParamsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TListPipeFilesParamsTupleScheme getScheme() {
      return new TListPipeFilesParamsTupleScheme();
    }
  }

  private static class TListPipeFilesParamsTupleScheme extends org.apache.thrift.scheme.TupleScheme<TListPipeFilesParams> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TListPipeFilesParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetUser_ident()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetUser_ident()) {
        struct.user_ident.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TListPipeFilesParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.user_ident = new com.starrocks.thrift.TUserIdentity();
        struct.user_ident.read(iprot);
        struct.setUser_identIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

