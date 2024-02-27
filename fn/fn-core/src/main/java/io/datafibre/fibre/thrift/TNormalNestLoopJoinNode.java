/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TNormalNestLoopJoinNode implements org.apache.thrift.TBase<TNormalNestLoopJoinNode, TNormalNestLoopJoinNode._Fields>, java.io.Serializable, Cloneable, Comparable<TNormalNestLoopJoinNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TNormalNestLoopJoinNode");

  private static final org.apache.thrift.protocol.TField JOIN_OP_FIELD_DESC = new org.apache.thrift.protocol.TField("join_op", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField JOIN_CONJUNCTS_FIELD_DESC = new org.apache.thrift.protocol.TField("join_conjuncts", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TNormalNestLoopJoinNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TNormalNestLoopJoinNodeTupleSchemeFactory();

  /**
   * 
   * @see com.starrocks.thrift.TJoinOp
   */
  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TJoinOp join_op; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> join_conjuncts; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see com.starrocks.thrift.TJoinOp
     */
    JOIN_OP((short)1, "join_op"),
    JOIN_CONJUNCTS((short)2, "join_conjuncts");

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
        case 1: // JOIN_OP
          return JOIN_OP;
        case 2: // JOIN_CONJUNCTS
          return JOIN_CONJUNCTS;
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
  private static final _Fields optionals[] = {_Fields.JOIN_OP,_Fields.JOIN_CONJUNCTS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JOIN_OP, new org.apache.thrift.meta_data.FieldMetaData("join_op", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.starrocks.thrift.TJoinOp.class)));
    tmpMap.put(_Fields.JOIN_CONJUNCTS, new org.apache.thrift.meta_data.FieldMetaData("join_conjuncts", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TNormalNestLoopJoinNode.class, metaDataMap);
  }

  public TNormalNestLoopJoinNode() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TNormalNestLoopJoinNode(TNormalNestLoopJoinNode other) {
    if (other.isSetJoin_op()) {
      this.join_op = other.join_op;
    }
    if (other.isSetJoin_conjuncts()) {
      java.util.List<java.nio.ByteBuffer> __this__join_conjuncts = new java.util.ArrayList<java.nio.ByteBuffer>(other.join_conjuncts);
      this.join_conjuncts = __this__join_conjuncts;
    }
  }

  @Override
  public TNormalNestLoopJoinNode deepCopy() {
    return new TNormalNestLoopJoinNode(this);
  }

  @Override
  public void clear() {
    this.join_op = null;
    this.join_conjuncts = null;
  }

  /**
   * 
   * @see com.starrocks.thrift.TJoinOp
   */
  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TJoinOp getJoin_op() {
    return this.join_op;
  }

  /**
   * 
   * @see com.starrocks.thrift.TJoinOp
   */
  public TNormalNestLoopJoinNode setJoin_op(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TJoinOp join_op) {
    this.join_op = join_op;
    return this;
  }

  public void unsetJoin_op() {
    this.join_op = null;
  }

  /** Returns true if field join_op is set (has been assigned a value) and false otherwise */
  public boolean isSetJoin_op() {
    return this.join_op != null;
  }

  public void setJoin_opIsSet(boolean value) {
    if (!value) {
      this.join_op = null;
    }
  }

  public int getJoin_conjunctsSize() {
    return (this.join_conjuncts == null) ? 0 : this.join_conjuncts.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.nio.ByteBuffer> getJoin_conjunctsIterator() {
    return (this.join_conjuncts == null) ? null : this.join_conjuncts.iterator();
  }

  public void addToJoin_conjuncts(java.nio.ByteBuffer elem) {
    if (this.join_conjuncts == null) {
      this.join_conjuncts = new java.util.ArrayList<java.nio.ByteBuffer>();
    }
    this.join_conjuncts.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.nio.ByteBuffer> getJoin_conjuncts() {
    return this.join_conjuncts;
  }

  public TNormalNestLoopJoinNode setJoin_conjuncts(@org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> join_conjuncts) {
    this.join_conjuncts = join_conjuncts;
    return this;
  }

  public void unsetJoin_conjuncts() {
    this.join_conjuncts = null;
  }

  /** Returns true if field join_conjuncts is set (has been assigned a value) and false otherwise */
  public boolean isSetJoin_conjuncts() {
    return this.join_conjuncts != null;
  }

  public void setJoin_conjunctsIsSet(boolean value) {
    if (!value) {
      this.join_conjuncts = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case JOIN_OP:
      if (value == null) {
        unsetJoin_op();
      } else {
        setJoin_op((com.starrocks.thrift.TJoinOp)value);
      }
      break;

    case JOIN_CONJUNCTS:
      if (value == null) {
        unsetJoin_conjuncts();
      } else {
        setJoin_conjuncts((java.util.List<java.nio.ByteBuffer>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case JOIN_OP:
      return getJoin_op();

    case JOIN_CONJUNCTS:
      return getJoin_conjuncts();

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
    case JOIN_OP:
      return isSetJoin_op();
    case JOIN_CONJUNCTS:
      return isSetJoin_conjuncts();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TNormalNestLoopJoinNode)
      return this.equals((TNormalNestLoopJoinNode)that);
    return false;
  }

  public boolean equals(TNormalNestLoopJoinNode that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_join_op = true && this.isSetJoin_op();
    boolean that_present_join_op = true && that.isSetJoin_op();
    if (this_present_join_op || that_present_join_op) {
      if (!(this_present_join_op && that_present_join_op))
        return false;
      if (!this.join_op.equals(that.join_op))
        return false;
    }

    boolean this_present_join_conjuncts = true && this.isSetJoin_conjuncts();
    boolean that_present_join_conjuncts = true && that.isSetJoin_conjuncts();
    if (this_present_join_conjuncts || that_present_join_conjuncts) {
      if (!(this_present_join_conjuncts && that_present_join_conjuncts))
        return false;
      if (!this.join_conjuncts.equals(that.join_conjuncts))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetJoin_op()) ? 131071 : 524287);
    if (isSetJoin_op())
      hashCode = hashCode * 8191 + join_op.getValue();

    hashCode = hashCode * 8191 + ((isSetJoin_conjuncts()) ? 131071 : 524287);
    if (isSetJoin_conjuncts())
      hashCode = hashCode * 8191 + join_conjuncts.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TNormalNestLoopJoinNode other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetJoin_op(), other.isSetJoin_op());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJoin_op()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.join_op, other.join_op);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJoin_conjuncts(), other.isSetJoin_conjuncts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJoin_conjuncts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.join_conjuncts, other.join_conjuncts);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TNormalNestLoopJoinNode(");
    boolean first = true;

    if (isSetJoin_op()) {
      sb.append("join_op:");
      if (this.join_op == null) {
        sb.append("null");
      } else {
        sb.append(this.join_op);
      }
      first = false;
    }
    if (isSetJoin_conjuncts()) {
      if (!first) sb.append(", ");
      sb.append("join_conjuncts:");
      if (this.join_conjuncts == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.join_conjuncts, sb);
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

  private static class TNormalNestLoopJoinNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNormalNestLoopJoinNodeStandardScheme getScheme() {
      return new TNormalNestLoopJoinNodeStandardScheme();
    }
  }

  private static class TNormalNestLoopJoinNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TNormalNestLoopJoinNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TNormalNestLoopJoinNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // JOIN_OP
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.join_op = com.starrocks.thrift.TJoinOp.findByValue(iprot.readI32());
              struct.setJoin_opIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // JOIN_CONJUNCTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list184 = iprot.readListBegin();
                struct.join_conjuncts = new java.util.ArrayList<java.nio.ByteBuffer>(_list184.size);
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem185;
                for (int _i186 = 0; _i186 < _list184.size; ++_i186)
                {
                  _elem185 = iprot.readBinary();
                  struct.join_conjuncts.add(_elem185);
                }
                iprot.readListEnd();
              }
              struct.setJoin_conjunctsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TNormalNestLoopJoinNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.join_op != null) {
        if (struct.isSetJoin_op()) {
          oprot.writeFieldBegin(JOIN_OP_FIELD_DESC);
          oprot.writeI32(struct.join_op.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.join_conjuncts != null) {
        if (struct.isSetJoin_conjuncts()) {
          oprot.writeFieldBegin(JOIN_CONJUNCTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.join_conjuncts.size()));
            for (java.nio.ByteBuffer _iter187 : struct.join_conjuncts)
            {
              oprot.writeBinary(_iter187);
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

  private static class TNormalNestLoopJoinNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNormalNestLoopJoinNodeTupleScheme getScheme() {
      return new TNormalNestLoopJoinNodeTupleScheme();
    }
  }

  private static class TNormalNestLoopJoinNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TNormalNestLoopJoinNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TNormalNestLoopJoinNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetJoin_op()) {
        optionals.set(0);
      }
      if (struct.isSetJoin_conjuncts()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetJoin_op()) {
        oprot.writeI32(struct.join_op.getValue());
      }
      if (struct.isSetJoin_conjuncts()) {
        {
          oprot.writeI32(struct.join_conjuncts.size());
          for (java.nio.ByteBuffer _iter188 : struct.join_conjuncts)
          {
            oprot.writeBinary(_iter188);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TNormalNestLoopJoinNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.join_op = com.starrocks.thrift.TJoinOp.findByValue(iprot.readI32());
        struct.setJoin_opIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list189 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.join_conjuncts = new java.util.ArrayList<java.nio.ByteBuffer>(_list189.size);
          @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem190;
          for (int _i191 = 0; _i191 < _list189.size; ++_i191)
          {
            _elem190 = iprot.readBinary();
            struct.join_conjuncts.add(_elem190);
          }
        }
        struct.setJoin_conjunctsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

