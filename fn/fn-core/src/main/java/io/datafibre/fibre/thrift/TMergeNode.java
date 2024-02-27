/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TMergeNode implements org.apache.thrift.TBase<TMergeNode, TMergeNode._Fields>, java.io.Serializable, Cloneable, Comparable<TMergeNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TMergeNode");

  private static final org.apache.thrift.protocol.TField TUPLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tuple_id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField RESULT_EXPR_LISTS_FIELD_DESC = new org.apache.thrift.protocol.TField("result_expr_lists", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField CONST_EXPR_LISTS_FIELD_DESC = new org.apache.thrift.protocol.TField("const_expr_lists", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TMergeNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TMergeNodeTupleSchemeFactory();

  public int tuple_id; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.util.List<com.starrocks.thrift.TExpr>> result_expr_lists; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.util.List<com.starrocks.thrift.TExpr>> const_expr_lists; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TUPLE_ID((short)1, "tuple_id"),
    RESULT_EXPR_LISTS((short)2, "result_expr_lists"),
    CONST_EXPR_LISTS((short)3, "const_expr_lists");

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
        case 1: // TUPLE_ID
          return TUPLE_ID;
        case 2: // RESULT_EXPR_LISTS
          return RESULT_EXPR_LISTS;
        case 3: // CONST_EXPR_LISTS
          return CONST_EXPR_LISTS;
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
  private static final int __TUPLE_ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TUPLE_ID, new org.apache.thrift.meta_data.FieldMetaData("tuple_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "TTupleId")));
    tmpMap.put(_Fields.RESULT_EXPR_LISTS, new org.apache.thrift.meta_data.FieldMetaData("result_expr_lists", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TExpr.class)))));
    tmpMap.put(_Fields.CONST_EXPR_LISTS, new org.apache.thrift.meta_data.FieldMetaData("const_expr_lists", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TExpr.class)))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TMergeNode.class, metaDataMap);
  }

  public TMergeNode() {
  }

  public TMergeNode(
    int tuple_id,
    java.util.List<java.util.List<com.starrocks.thrift.TExpr>> result_expr_lists,
    java.util.List<java.util.List<com.starrocks.thrift.TExpr>> const_expr_lists)
  {
    this();
    this.tuple_id = tuple_id;
    setTuple_idIsSet(true);
    this.result_expr_lists = result_expr_lists;
    this.const_expr_lists = const_expr_lists;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TMergeNode(TMergeNode other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tuple_id = other.tuple_id;
    if (other.isSetResult_expr_lists()) {
      java.util.List<java.util.List<com.starrocks.thrift.TExpr>> __this__result_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>(other.result_expr_lists.size());
      for (java.util.List<com.starrocks.thrift.TExpr> other_element : other.result_expr_lists) {
        java.util.List<com.starrocks.thrift.TExpr> __this__result_expr_lists_copy = new java.util.ArrayList<com.starrocks.thrift.TExpr>(other_element.size());
        for (com.starrocks.thrift.TExpr other_element_element : other_element) {
          __this__result_expr_lists_copy.add(new com.starrocks.thrift.TExpr(other_element_element));
        }
        __this__result_expr_lists.add(__this__result_expr_lists_copy);
      }
      this.result_expr_lists = __this__result_expr_lists;
    }
    if (other.isSetConst_expr_lists()) {
      java.util.List<java.util.List<com.starrocks.thrift.TExpr>> __this__const_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>(other.const_expr_lists.size());
      for (java.util.List<com.starrocks.thrift.TExpr> other_element : other.const_expr_lists) {
        java.util.List<com.starrocks.thrift.TExpr> __this__const_expr_lists_copy = new java.util.ArrayList<com.starrocks.thrift.TExpr>(other_element.size());
        for (com.starrocks.thrift.TExpr other_element_element : other_element) {
          __this__const_expr_lists_copy.add(new com.starrocks.thrift.TExpr(other_element_element));
        }
        __this__const_expr_lists.add(__this__const_expr_lists_copy);
      }
      this.const_expr_lists = __this__const_expr_lists;
    }
  }

  @Override
  public TMergeNode deepCopy() {
    return new TMergeNode(this);
  }

  @Override
  public void clear() {
    setTuple_idIsSet(false);
    this.tuple_id = 0;
    this.result_expr_lists = null;
    this.const_expr_lists = null;
  }

  public int getTuple_id() {
    return this.tuple_id;
  }

  public TMergeNode setTuple_id(int tuple_id) {
    this.tuple_id = tuple_id;
    setTuple_idIsSet(true);
    return this;
  }

  public void unsetTuple_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TUPLE_ID_ISSET_ID);
  }

  /** Returns true if field tuple_id is set (has been assigned a value) and false otherwise */
  public boolean isSetTuple_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TUPLE_ID_ISSET_ID);
  }

  public void setTuple_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TUPLE_ID_ISSET_ID, value);
  }

  public int getResult_expr_listsSize() {
    return (this.result_expr_lists == null) ? 0 : this.result_expr_lists.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.util.List<com.starrocks.thrift.TExpr>> getResult_expr_listsIterator() {
    return (this.result_expr_lists == null) ? null : this.result_expr_lists.iterator();
  }

  public void addToResult_expr_lists(java.util.List<com.starrocks.thrift.TExpr> elem) {
    if (this.result_expr_lists == null) {
      this.result_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>();
    }
    this.result_expr_lists.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.util.List<com.starrocks.thrift.TExpr>> getResult_expr_lists() {
    return this.result_expr_lists;
  }

  public TMergeNode setResult_expr_lists(@org.apache.thrift.annotation.Nullable java.util.List<java.util.List<com.starrocks.thrift.TExpr>> result_expr_lists) {
    this.result_expr_lists = result_expr_lists;
    return this;
  }

  public void unsetResult_expr_lists() {
    this.result_expr_lists = null;
  }

  /** Returns true if field result_expr_lists is set (has been assigned a value) and false otherwise */
  public boolean isSetResult_expr_lists() {
    return this.result_expr_lists != null;
  }

  public void setResult_expr_listsIsSet(boolean value) {
    if (!value) {
      this.result_expr_lists = null;
    }
  }

  public int getConst_expr_listsSize() {
    return (this.const_expr_lists == null) ? 0 : this.const_expr_lists.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.util.List<com.starrocks.thrift.TExpr>> getConst_expr_listsIterator() {
    return (this.const_expr_lists == null) ? null : this.const_expr_lists.iterator();
  }

  public void addToConst_expr_lists(java.util.List<com.starrocks.thrift.TExpr> elem) {
    if (this.const_expr_lists == null) {
      this.const_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>();
    }
    this.const_expr_lists.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.util.List<com.starrocks.thrift.TExpr>> getConst_expr_lists() {
    return this.const_expr_lists;
  }

  public TMergeNode setConst_expr_lists(@org.apache.thrift.annotation.Nullable java.util.List<java.util.List<com.starrocks.thrift.TExpr>> const_expr_lists) {
    this.const_expr_lists = const_expr_lists;
    return this;
  }

  public void unsetConst_expr_lists() {
    this.const_expr_lists = null;
  }

  /** Returns true if field const_expr_lists is set (has been assigned a value) and false otherwise */
  public boolean isSetConst_expr_lists() {
    return this.const_expr_lists != null;
  }

  public void setConst_expr_listsIsSet(boolean value) {
    if (!value) {
      this.const_expr_lists = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TUPLE_ID:
      if (value == null) {
        unsetTuple_id();
      } else {
        setTuple_id((java.lang.Integer)value);
      }
      break;

    case RESULT_EXPR_LISTS:
      if (value == null) {
        unsetResult_expr_lists();
      } else {
        setResult_expr_lists((java.util.List<java.util.List<com.starrocks.thrift.TExpr>>)value);
      }
      break;

    case CONST_EXPR_LISTS:
      if (value == null) {
        unsetConst_expr_lists();
      } else {
        setConst_expr_lists((java.util.List<java.util.List<com.starrocks.thrift.TExpr>>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TUPLE_ID:
      return getTuple_id();

    case RESULT_EXPR_LISTS:
      return getResult_expr_lists();

    case CONST_EXPR_LISTS:
      return getConst_expr_lists();

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
    case TUPLE_ID:
      return isSetTuple_id();
    case RESULT_EXPR_LISTS:
      return isSetResult_expr_lists();
    case CONST_EXPR_LISTS:
      return isSetConst_expr_lists();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TMergeNode)
      return this.equals((TMergeNode)that);
    return false;
  }

  public boolean equals(TMergeNode that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tuple_id = true;
    boolean that_present_tuple_id = true;
    if (this_present_tuple_id || that_present_tuple_id) {
      if (!(this_present_tuple_id && that_present_tuple_id))
        return false;
      if (this.tuple_id != that.tuple_id)
        return false;
    }

    boolean this_present_result_expr_lists = true && this.isSetResult_expr_lists();
    boolean that_present_result_expr_lists = true && that.isSetResult_expr_lists();
    if (this_present_result_expr_lists || that_present_result_expr_lists) {
      if (!(this_present_result_expr_lists && that_present_result_expr_lists))
        return false;
      if (!this.result_expr_lists.equals(that.result_expr_lists))
        return false;
    }

    boolean this_present_const_expr_lists = true && this.isSetConst_expr_lists();
    boolean that_present_const_expr_lists = true && that.isSetConst_expr_lists();
    if (this_present_const_expr_lists || that_present_const_expr_lists) {
      if (!(this_present_const_expr_lists && that_present_const_expr_lists))
        return false;
      if (!this.const_expr_lists.equals(that.const_expr_lists))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + tuple_id;

    hashCode = hashCode * 8191 + ((isSetResult_expr_lists()) ? 131071 : 524287);
    if (isSetResult_expr_lists())
      hashCode = hashCode * 8191 + result_expr_lists.hashCode();

    hashCode = hashCode * 8191 + ((isSetConst_expr_lists()) ? 131071 : 524287);
    if (isSetConst_expr_lists())
      hashCode = hashCode * 8191 + const_expr_lists.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TMergeNode other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTuple_id(), other.isSetTuple_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTuple_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tuple_id, other.tuple_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetResult_expr_lists(), other.isSetResult_expr_lists());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult_expr_lists()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result_expr_lists, other.result_expr_lists);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetConst_expr_lists(), other.isSetConst_expr_lists());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConst_expr_lists()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.const_expr_lists, other.const_expr_lists);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TMergeNode(");
    boolean first = true;

    sb.append("tuple_id:");
    sb.append(this.tuple_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("result_expr_lists:");
    if (this.result_expr_lists == null) {
      sb.append("null");
    } else {
      sb.append(this.result_expr_lists);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("const_expr_lists:");
    if (this.const_expr_lists == null) {
      sb.append("null");
    } else {
      sb.append(this.const_expr_lists);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'tuple_id' because it's a primitive and you chose the non-beans generator.
    if (result_expr_lists == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'result_expr_lists' was not present! Struct: " + toString());
    }
    if (const_expr_lists == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'const_expr_lists' was not present! Struct: " + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TMergeNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TMergeNodeStandardScheme getScheme() {
      return new TMergeNodeStandardScheme();
    }
  }

  private static class TMergeNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TMergeNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TMergeNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TUPLE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tuple_id = iprot.readI32();
              struct.setTuple_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RESULT_EXPR_LISTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list642 = iprot.readListBegin();
                struct.result_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>(_list642.size);
                @org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> _elem643;
                for (int _i644 = 0; _i644 < _list642.size; ++_i644)
                {
                  {
                    org.apache.thrift.protocol.TList _list645 = iprot.readListBegin();
                    _elem643 = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list645.size);
                    @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem646;
                    for (int _i647 = 0; _i647 < _list645.size; ++_i647)
                    {
                      _elem646 = new com.starrocks.thrift.TExpr();
                      _elem646.read(iprot);
                      _elem643.add(_elem646);
                    }
                    iprot.readListEnd();
                  }
                  struct.result_expr_lists.add(_elem643);
                }
                iprot.readListEnd();
              }
              struct.setResult_expr_listsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CONST_EXPR_LISTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list648 = iprot.readListBegin();
                struct.const_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>(_list648.size);
                @org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> _elem649;
                for (int _i650 = 0; _i650 < _list648.size; ++_i650)
                {
                  {
                    org.apache.thrift.protocol.TList _list651 = iprot.readListBegin();
                    _elem649 = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list651.size);
                    @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem652;
                    for (int _i653 = 0; _i653 < _list651.size; ++_i653)
                    {
                      _elem652 = new com.starrocks.thrift.TExpr();
                      _elem652.read(iprot);
                      _elem649.add(_elem652);
                    }
                    iprot.readListEnd();
                  }
                  struct.const_expr_lists.add(_elem649);
                }
                iprot.readListEnd();
              }
              struct.setConst_expr_listsIsSet(true);
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
      if (!struct.isSetTuple_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'tuple_id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TMergeNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TUPLE_ID_FIELD_DESC);
      oprot.writeI32(struct.tuple_id);
      oprot.writeFieldEnd();
      if (struct.result_expr_lists != null) {
        oprot.writeFieldBegin(RESULT_EXPR_LISTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.LIST, struct.result_expr_lists.size()));
          for (java.util.List<com.starrocks.thrift.TExpr> _iter654 : struct.result_expr_lists)
          {
            {
              oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter654.size()));
              for (com.starrocks.thrift.TExpr _iter655 : _iter654)
              {
                _iter655.write(oprot);
              }
              oprot.writeListEnd();
            }
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.const_expr_lists != null) {
        oprot.writeFieldBegin(CONST_EXPR_LISTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.LIST, struct.const_expr_lists.size()));
          for (java.util.List<com.starrocks.thrift.TExpr> _iter656 : struct.const_expr_lists)
          {
            {
              oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter656.size()));
              for (com.starrocks.thrift.TExpr _iter657 : _iter656)
              {
                _iter657.write(oprot);
              }
              oprot.writeListEnd();
            }
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TMergeNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TMergeNodeTupleScheme getScheme() {
      return new TMergeNodeTupleScheme();
    }
  }

  private static class TMergeNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TMergeNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TMergeNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.tuple_id);
      {
        oprot.writeI32(struct.result_expr_lists.size());
        for (java.util.List<com.starrocks.thrift.TExpr> _iter658 : struct.result_expr_lists)
        {
          {
            oprot.writeI32(_iter658.size());
            for (com.starrocks.thrift.TExpr _iter659 : _iter658)
            {
              _iter659.write(oprot);
            }
          }
        }
      }
      {
        oprot.writeI32(struct.const_expr_lists.size());
        for (java.util.List<com.starrocks.thrift.TExpr> _iter660 : struct.const_expr_lists)
        {
          {
            oprot.writeI32(_iter660.size());
            for (com.starrocks.thrift.TExpr _iter661 : _iter660)
            {
              _iter661.write(oprot);
            }
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TMergeNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.tuple_id = iprot.readI32();
      struct.setTuple_idIsSet(true);
      {
        org.apache.thrift.protocol.TList _list662 = iprot.readListBegin(org.apache.thrift.protocol.TType.LIST);
        struct.result_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>(_list662.size);
        @org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> _elem663;
        for (int _i664 = 0; _i664 < _list662.size; ++_i664)
        {
          {
            org.apache.thrift.protocol.TList _list665 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
            _elem663 = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list665.size);
            @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem666;
            for (int _i667 = 0; _i667 < _list665.size; ++_i667)
            {
              _elem666 = new com.starrocks.thrift.TExpr();
              _elem666.read(iprot);
              _elem663.add(_elem666);
            }
          }
          struct.result_expr_lists.add(_elem663);
        }
      }
      struct.setResult_expr_listsIsSet(true);
      {
        org.apache.thrift.protocol.TList _list668 = iprot.readListBegin(org.apache.thrift.protocol.TType.LIST);
        struct.const_expr_lists = new java.util.ArrayList<java.util.List<com.starrocks.thrift.TExpr>>(_list668.size);
        @org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> _elem669;
        for (int _i670 = 0; _i670 < _list668.size; ++_i670)
        {
          {
            org.apache.thrift.protocol.TList _list671 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
            _elem669 = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list671.size);
            @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem672;
            for (int _i673 = 0; _i673 < _list671.size; ++_i673)
            {
              _elem672 = new com.starrocks.thrift.TExpr();
              _elem672.read(iprot);
              _elem669.add(_elem672);
            }
          }
          struct.const_expr_lists.add(_elem669);
        }
      }
      struct.setConst_expr_listsIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

