/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TKeyLiteralExpr implements org.apache.thrift.TBase<TKeyLiteralExpr, TKeyLiteralExpr._Fields>, java.io.Serializable, Cloneable, Comparable<TKeyLiteralExpr> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TKeyLiteralExpr");

  private static final org.apache.thrift.protocol.TField LITERAL_EXPRS_FIELD_DESC = new org.apache.thrift.protocol.TField("literal_exprs", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TKeyLiteralExprStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TKeyLiteralExprTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> literal_exprs; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LITERAL_EXPRS((short)1, "literal_exprs");

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
        case 1: // LITERAL_EXPRS
          return LITERAL_EXPRS;
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
  private static final _Fields optionals[] = {_Fields.LITERAL_EXPRS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LITERAL_EXPRS, new org.apache.thrift.meta_data.FieldMetaData("literal_exprs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TExpr.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TKeyLiteralExpr.class, metaDataMap);
  }

  public TKeyLiteralExpr() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TKeyLiteralExpr(TKeyLiteralExpr other) {
    if (other.isSetLiteral_exprs()) {
      java.util.List<com.starrocks.thrift.TExpr> __this__literal_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(other.literal_exprs.size());
      for (com.starrocks.thrift.TExpr other_element : other.literal_exprs) {
        __this__literal_exprs.add(new com.starrocks.thrift.TExpr(other_element));
      }
      this.literal_exprs = __this__literal_exprs;
    }
  }

  @Override
  public TKeyLiteralExpr deepCopy() {
    return new TKeyLiteralExpr(this);
  }

  @Override
  public void clear() {
    this.literal_exprs = null;
  }

  public int getLiteral_exprsSize() {
    return (this.literal_exprs == null) ? 0 : this.literal_exprs.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<com.starrocks.thrift.TExpr> getLiteral_exprsIterator() {
    return (this.literal_exprs == null) ? null : this.literal_exprs.iterator();
  }

  public void addToLiteral_exprs(com.starrocks.thrift.TExpr elem) {
    if (this.literal_exprs == null) {
      this.literal_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>();
    }
    this.literal_exprs.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<com.starrocks.thrift.TExpr> getLiteral_exprs() {
    return this.literal_exprs;
  }

  public TKeyLiteralExpr setLiteral_exprs(@org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> literal_exprs) {
    this.literal_exprs = literal_exprs;
    return this;
  }

  public void unsetLiteral_exprs() {
    this.literal_exprs = null;
  }

  /** Returns true if field literal_exprs is set (has been assigned a value) and false otherwise */
  public boolean isSetLiteral_exprs() {
    return this.literal_exprs != null;
  }

  public void setLiteral_exprsIsSet(boolean value) {
    if (!value) {
      this.literal_exprs = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case LITERAL_EXPRS:
      if (value == null) {
        unsetLiteral_exprs();
      } else {
        setLiteral_exprs((java.util.List<com.starrocks.thrift.TExpr>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case LITERAL_EXPRS:
      return getLiteral_exprs();

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
    case LITERAL_EXPRS:
      return isSetLiteral_exprs();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TKeyLiteralExpr)
      return this.equals((TKeyLiteralExpr)that);
    return false;
  }

  public boolean equals(TKeyLiteralExpr that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_literal_exprs = true && this.isSetLiteral_exprs();
    boolean that_present_literal_exprs = true && that.isSetLiteral_exprs();
    if (this_present_literal_exprs || that_present_literal_exprs) {
      if (!(this_present_literal_exprs && that_present_literal_exprs))
        return false;
      if (!this.literal_exprs.equals(that.literal_exprs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetLiteral_exprs()) ? 131071 : 524287);
    if (isSetLiteral_exprs())
      hashCode = hashCode * 8191 + literal_exprs.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TKeyLiteralExpr other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetLiteral_exprs(), other.isSetLiteral_exprs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLiteral_exprs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.literal_exprs, other.literal_exprs);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TKeyLiteralExpr(");
    boolean first = true;

    if (isSetLiteral_exprs()) {
      sb.append("literal_exprs:");
      if (this.literal_exprs == null) {
        sb.append("null");
      } else {
        sb.append(this.literal_exprs);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TKeyLiteralExprStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TKeyLiteralExprStandardScheme getScheme() {
      return new TKeyLiteralExprStandardScheme();
    }
  }

  private static class TKeyLiteralExprStandardScheme extends org.apache.thrift.scheme.StandardScheme<TKeyLiteralExpr> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TKeyLiteralExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LITERAL_EXPRS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.literal_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list0.size);
                @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new com.starrocks.thrift.TExpr();
                  _elem1.read(iprot);
                  struct.literal_exprs.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setLiteral_exprsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TKeyLiteralExpr struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.literal_exprs != null) {
        if (struct.isSetLiteral_exprs()) {
          oprot.writeFieldBegin(LITERAL_EXPRS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.literal_exprs.size()));
            for (com.starrocks.thrift.TExpr _iter3 : struct.literal_exprs)
            {
              _iter3.write(oprot);
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

  private static class TKeyLiteralExprTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TKeyLiteralExprTupleScheme getScheme() {
      return new TKeyLiteralExprTupleScheme();
    }
  }

  private static class TKeyLiteralExprTupleScheme extends org.apache.thrift.scheme.TupleScheme<TKeyLiteralExpr> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TKeyLiteralExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetLiteral_exprs()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetLiteral_exprs()) {
        {
          oprot.writeI32(struct.literal_exprs.size());
          for (com.starrocks.thrift.TExpr _iter4 : struct.literal_exprs)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TKeyLiteralExpr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.literal_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list5.size);
          @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new com.starrocks.thrift.TExpr();
            _elem6.read(iprot);
            struct.literal_exprs.add(_elem6);
          }
        }
        struct.setLiteral_exprsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

