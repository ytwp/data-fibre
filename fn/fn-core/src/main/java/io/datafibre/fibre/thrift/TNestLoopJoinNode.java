/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TNestLoopJoinNode implements org.apache.thrift.TBase<TNestLoopJoinNode, TNestLoopJoinNode._Fields>, java.io.Serializable, Cloneable, Comparable<TNestLoopJoinNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TNestLoopJoinNode");

  private static final org.apache.thrift.protocol.TField JOIN_OP_FIELD_DESC = new org.apache.thrift.protocol.TField("join_op", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField BUILD_RUNTIME_FILTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("build_runtime_filters", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField JOIN_CONJUNCTS_FIELD_DESC = new org.apache.thrift.protocol.TField("join_conjuncts", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField SQL_JOIN_CONJUNCTS_FIELD_DESC = new org.apache.thrift.protocol.TField("sql_join_conjuncts", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TNestLoopJoinNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TNestLoopJoinNodeTupleSchemeFactory();

  /**
   * 
   * @see TJoinOp
   */
  public @org.apache.thrift.annotation.Nullable TJoinOp join_op; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TRuntimeFilterDescription> build_runtime_filters; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TExpr> join_conjuncts; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String sql_join_conjuncts; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see TJoinOp
     */
    JOIN_OP((short)1, "join_op"),
    BUILD_RUNTIME_FILTERS((short)2, "build_runtime_filters"),
    JOIN_CONJUNCTS((short)3, "join_conjuncts"),
    SQL_JOIN_CONJUNCTS((short)4, "sql_join_conjuncts");

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
        case 2: // BUILD_RUNTIME_FILTERS
          return BUILD_RUNTIME_FILTERS;
        case 3: // JOIN_CONJUNCTS
          return JOIN_CONJUNCTS;
        case 4: // SQL_JOIN_CONJUNCTS
          return SQL_JOIN_CONJUNCTS;
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
  private static final _Fields optionals[] = {_Fields.JOIN_OP,_Fields.BUILD_RUNTIME_FILTERS,_Fields.JOIN_CONJUNCTS,_Fields.SQL_JOIN_CONJUNCTS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JOIN_OP, new org.apache.thrift.meta_data.FieldMetaData("join_op", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TJoinOp.class)));
    tmpMap.put(_Fields.BUILD_RUNTIME_FILTERS, new org.apache.thrift.meta_data.FieldMetaData("build_runtime_filters", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TRuntimeFilterDescription.class))));
    tmpMap.put(_Fields.JOIN_CONJUNCTS, new org.apache.thrift.meta_data.FieldMetaData("join_conjuncts", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TExpr.class))));
    tmpMap.put(_Fields.SQL_JOIN_CONJUNCTS, new org.apache.thrift.meta_data.FieldMetaData("sql_join_conjuncts", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TNestLoopJoinNode.class, metaDataMap);
  }

  public TNestLoopJoinNode() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TNestLoopJoinNode(TNestLoopJoinNode other) {
    if (other.isSetJoin_op()) {
      this.join_op = other.join_op;
    }
    if (other.isSetBuild_runtime_filters()) {
      java.util.List<io.datafibre.fibre.thrift.TRuntimeFilterDescription> __this__build_runtime_filters = new java.util.ArrayList<io.datafibre.fibre.thrift.TRuntimeFilterDescription>(other.build_runtime_filters.size());
      for (io.datafibre.fibre.thrift.TRuntimeFilterDescription other_element : other.build_runtime_filters) {
        __this__build_runtime_filters.add(new io.datafibre.fibre.thrift.TRuntimeFilterDescription(other_element));
      }
      this.build_runtime_filters = __this__build_runtime_filters;
    }
    if (other.isSetJoin_conjuncts()) {
      java.util.List<io.datafibre.fibre.thrift.TExpr> __this__join_conjuncts = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>(other.join_conjuncts.size());
      for (io.datafibre.fibre.thrift.TExpr other_element : other.join_conjuncts) {
        __this__join_conjuncts.add(new io.datafibre.fibre.thrift.TExpr(other_element));
      }
      this.join_conjuncts = __this__join_conjuncts;
    }
    if (other.isSetSql_join_conjuncts()) {
      this.sql_join_conjuncts = other.sql_join_conjuncts;
    }
  }

  @Override
  public TNestLoopJoinNode deepCopy() {
    return new TNestLoopJoinNode(this);
  }

  @Override
  public void clear() {
    this.join_op = null;
    this.build_runtime_filters = null;
    this.join_conjuncts = null;
    this.sql_join_conjuncts = null;
  }

  /**
   * 
   * @see TJoinOp
   */
  @org.apache.thrift.annotation.Nullable
  public TJoinOp getJoin_op() {
    return this.join_op;
  }

  /**
   * 
   * @see TJoinOp
   */
  public TNestLoopJoinNode setJoin_op(@org.apache.thrift.annotation.Nullable TJoinOp join_op) {
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

  public int getBuild_runtime_filtersSize() {
    return (this.build_runtime_filters == null) ? 0 : this.build_runtime_filters.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<io.datafibre.fibre.thrift.TRuntimeFilterDescription> getBuild_runtime_filtersIterator() {
    return (this.build_runtime_filters == null) ? null : this.build_runtime_filters.iterator();
  }

  public void addToBuild_runtime_filters(io.datafibre.fibre.thrift.TRuntimeFilterDescription elem) {
    if (this.build_runtime_filters == null) {
      this.build_runtime_filters = new java.util.ArrayList<io.datafibre.fibre.thrift.TRuntimeFilterDescription>();
    }
    this.build_runtime_filters.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<io.datafibre.fibre.thrift.TRuntimeFilterDescription> getBuild_runtime_filters() {
    return this.build_runtime_filters;
  }

  public TNestLoopJoinNode setBuild_runtime_filters(@org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TRuntimeFilterDescription> build_runtime_filters) {
    this.build_runtime_filters = build_runtime_filters;
    return this;
  }

  public void unsetBuild_runtime_filters() {
    this.build_runtime_filters = null;
  }

  /** Returns true if field build_runtime_filters is set (has been assigned a value) and false otherwise */
  public boolean isSetBuild_runtime_filters() {
    return this.build_runtime_filters != null;
  }

  public void setBuild_runtime_filtersIsSet(boolean value) {
    if (!value) {
      this.build_runtime_filters = null;
    }
  }

  public int getJoin_conjunctsSize() {
    return (this.join_conjuncts == null) ? 0 : this.join_conjuncts.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<io.datafibre.fibre.thrift.TExpr> getJoin_conjunctsIterator() {
    return (this.join_conjuncts == null) ? null : this.join_conjuncts.iterator();
  }

  public void addToJoin_conjuncts(io.datafibre.fibre.thrift.TExpr elem) {
    if (this.join_conjuncts == null) {
      this.join_conjuncts = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>();
    }
    this.join_conjuncts.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<io.datafibre.fibre.thrift.TExpr> getJoin_conjuncts() {
    return this.join_conjuncts;
  }

  public TNestLoopJoinNode setJoin_conjuncts(@org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TExpr> join_conjuncts) {
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

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getSql_join_conjuncts() {
    return this.sql_join_conjuncts;
  }

  public TNestLoopJoinNode setSql_join_conjuncts(@org.apache.thrift.annotation.Nullable java.lang.String sql_join_conjuncts) {
    this.sql_join_conjuncts = sql_join_conjuncts;
    return this;
  }

  public void unsetSql_join_conjuncts() {
    this.sql_join_conjuncts = null;
  }

  /** Returns true if field sql_join_conjuncts is set (has been assigned a value) and false otherwise */
  public boolean isSetSql_join_conjuncts() {
    return this.sql_join_conjuncts != null;
  }

  public void setSql_join_conjunctsIsSet(boolean value) {
    if (!value) {
      this.sql_join_conjuncts = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case JOIN_OP:
      if (value == null) {
        unsetJoin_op();
      } else {
        setJoin_op((TJoinOp)value);
      }
      break;

    case BUILD_RUNTIME_FILTERS:
      if (value == null) {
        unsetBuild_runtime_filters();
      } else {
        setBuild_runtime_filters((java.util.List<io.datafibre.fibre.thrift.TRuntimeFilterDescription>)value);
      }
      break;

    case JOIN_CONJUNCTS:
      if (value == null) {
        unsetJoin_conjuncts();
      } else {
        setJoin_conjuncts((java.util.List<io.datafibre.fibre.thrift.TExpr>)value);
      }
      break;

    case SQL_JOIN_CONJUNCTS:
      if (value == null) {
        unsetSql_join_conjuncts();
      } else {
        setSql_join_conjuncts((java.lang.String)value);
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

    case BUILD_RUNTIME_FILTERS:
      return getBuild_runtime_filters();

    case JOIN_CONJUNCTS:
      return getJoin_conjuncts();

    case SQL_JOIN_CONJUNCTS:
      return getSql_join_conjuncts();

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
    case BUILD_RUNTIME_FILTERS:
      return isSetBuild_runtime_filters();
    case JOIN_CONJUNCTS:
      return isSetJoin_conjuncts();
    case SQL_JOIN_CONJUNCTS:
      return isSetSql_join_conjuncts();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TNestLoopJoinNode)
      return this.equals((TNestLoopJoinNode)that);
    return false;
  }

  public boolean equals(TNestLoopJoinNode that) {
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

    boolean this_present_build_runtime_filters = true && this.isSetBuild_runtime_filters();
    boolean that_present_build_runtime_filters = true && that.isSetBuild_runtime_filters();
    if (this_present_build_runtime_filters || that_present_build_runtime_filters) {
      if (!(this_present_build_runtime_filters && that_present_build_runtime_filters))
        return false;
      if (!this.build_runtime_filters.equals(that.build_runtime_filters))
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

    boolean this_present_sql_join_conjuncts = true && this.isSetSql_join_conjuncts();
    boolean that_present_sql_join_conjuncts = true && that.isSetSql_join_conjuncts();
    if (this_present_sql_join_conjuncts || that_present_sql_join_conjuncts) {
      if (!(this_present_sql_join_conjuncts && that_present_sql_join_conjuncts))
        return false;
      if (!this.sql_join_conjuncts.equals(that.sql_join_conjuncts))
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

    hashCode = hashCode * 8191 + ((isSetBuild_runtime_filters()) ? 131071 : 524287);
    if (isSetBuild_runtime_filters())
      hashCode = hashCode * 8191 + build_runtime_filters.hashCode();

    hashCode = hashCode * 8191 + ((isSetJoin_conjuncts()) ? 131071 : 524287);
    if (isSetJoin_conjuncts())
      hashCode = hashCode * 8191 + join_conjuncts.hashCode();

    hashCode = hashCode * 8191 + ((isSetSql_join_conjuncts()) ? 131071 : 524287);
    if (isSetSql_join_conjuncts())
      hashCode = hashCode * 8191 + sql_join_conjuncts.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TNestLoopJoinNode other) {
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
    lastComparison = java.lang.Boolean.compare(isSetBuild_runtime_filters(), other.isSetBuild_runtime_filters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuild_runtime_filters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.build_runtime_filters, other.build_runtime_filters);
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
    lastComparison = java.lang.Boolean.compare(isSetSql_join_conjuncts(), other.isSetSql_join_conjuncts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSql_join_conjuncts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sql_join_conjuncts, other.sql_join_conjuncts);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TNestLoopJoinNode(");
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
    if (isSetBuild_runtime_filters()) {
      if (!first) sb.append(", ");
      sb.append("build_runtime_filters:");
      if (this.build_runtime_filters == null) {
        sb.append("null");
      } else {
        sb.append(this.build_runtime_filters);
      }
      first = false;
    }
    if (isSetJoin_conjuncts()) {
      if (!first) sb.append(", ");
      sb.append("join_conjuncts:");
      if (this.join_conjuncts == null) {
        sb.append("null");
      } else {
        sb.append(this.join_conjuncts);
      }
      first = false;
    }
    if (isSetSql_join_conjuncts()) {
      if (!first) sb.append(", ");
      sb.append("sql_join_conjuncts:");
      if (this.sql_join_conjuncts == null) {
        sb.append("null");
      } else {
        sb.append(this.sql_join_conjuncts);
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

  private static class TNestLoopJoinNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNestLoopJoinNodeStandardScheme getScheme() {
      return new TNestLoopJoinNodeStandardScheme();
    }
  }

  private static class TNestLoopJoinNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TNestLoopJoinNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TNestLoopJoinNode struct) throws org.apache.thrift.TException {
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
              struct.join_op = io.datafibre.fibre.thrift.TJoinOp.findByValue(iprot.readI32());
              struct.setJoin_opIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BUILD_RUNTIME_FILTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list442 = iprot.readListBegin();
                struct.build_runtime_filters = new java.util.ArrayList<io.datafibre.fibre.thrift.TRuntimeFilterDescription>(_list442.size);
                @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TRuntimeFilterDescription _elem443;
                for (int _i444 = 0; _i444 < _list442.size; ++_i444)
                {
                  _elem443 = new io.datafibre.fibre.thrift.TRuntimeFilterDescription();
                  _elem443.read(iprot);
                  struct.build_runtime_filters.add(_elem443);
                }
                iprot.readListEnd();
              }
              struct.setBuild_runtime_filtersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // JOIN_CONJUNCTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list445 = iprot.readListBegin();
                struct.join_conjuncts = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>(_list445.size);
                @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TExpr _elem446;
                for (int _i447 = 0; _i447 < _list445.size; ++_i447)
                {
                  _elem446 = new io.datafibre.fibre.thrift.TExpr();
                  _elem446.read(iprot);
                  struct.join_conjuncts.add(_elem446);
                }
                iprot.readListEnd();
              }
              struct.setJoin_conjunctsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SQL_JOIN_CONJUNCTS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sql_join_conjuncts = iprot.readString();
              struct.setSql_join_conjunctsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TNestLoopJoinNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.join_op != null) {
        if (struct.isSetJoin_op()) {
          oprot.writeFieldBegin(JOIN_OP_FIELD_DESC);
          oprot.writeI32(struct.join_op.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.build_runtime_filters != null) {
        if (struct.isSetBuild_runtime_filters()) {
          oprot.writeFieldBegin(BUILD_RUNTIME_FILTERS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.build_runtime_filters.size()));
            for (io.datafibre.fibre.thrift.TRuntimeFilterDescription _iter448 : struct.build_runtime_filters)
            {
              _iter448.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.join_conjuncts != null) {
        if (struct.isSetJoin_conjuncts()) {
          oprot.writeFieldBegin(JOIN_CONJUNCTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.join_conjuncts.size()));
            for (io.datafibre.fibre.thrift.TExpr _iter449 : struct.join_conjuncts)
            {
              _iter449.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.sql_join_conjuncts != null) {
        if (struct.isSetSql_join_conjuncts()) {
          oprot.writeFieldBegin(SQL_JOIN_CONJUNCTS_FIELD_DESC);
          oprot.writeString(struct.sql_join_conjuncts);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TNestLoopJoinNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNestLoopJoinNodeTupleScheme getScheme() {
      return new TNestLoopJoinNodeTupleScheme();
    }
  }

  private static class TNestLoopJoinNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TNestLoopJoinNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TNestLoopJoinNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetJoin_op()) {
        optionals.set(0);
      }
      if (struct.isSetBuild_runtime_filters()) {
        optionals.set(1);
      }
      if (struct.isSetJoin_conjuncts()) {
        optionals.set(2);
      }
      if (struct.isSetSql_join_conjuncts()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetJoin_op()) {
        oprot.writeI32(struct.join_op.getValue());
      }
      if (struct.isSetBuild_runtime_filters()) {
        {
          oprot.writeI32(struct.build_runtime_filters.size());
          for (io.datafibre.fibre.thrift.TRuntimeFilterDescription _iter450 : struct.build_runtime_filters)
          {
            _iter450.write(oprot);
          }
        }
      }
      if (struct.isSetJoin_conjuncts()) {
        {
          oprot.writeI32(struct.join_conjuncts.size());
          for (io.datafibre.fibre.thrift.TExpr _iter451 : struct.join_conjuncts)
          {
            _iter451.write(oprot);
          }
        }
      }
      if (struct.isSetSql_join_conjuncts()) {
        oprot.writeString(struct.sql_join_conjuncts);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TNestLoopJoinNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.join_op = io.datafibre.fibre.thrift.TJoinOp.findByValue(iprot.readI32());
        struct.setJoin_opIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list452 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.build_runtime_filters = new java.util.ArrayList<io.datafibre.fibre.thrift.TRuntimeFilterDescription>(_list452.size);
          @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TRuntimeFilterDescription _elem453;
          for (int _i454 = 0; _i454 < _list452.size; ++_i454)
          {
            _elem453 = new io.datafibre.fibre.thrift.TRuntimeFilterDescription();
            _elem453.read(iprot);
            struct.build_runtime_filters.add(_elem453);
          }
        }
        struct.setBuild_runtime_filtersIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list455 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.join_conjuncts = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>(_list455.size);
          @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TExpr _elem456;
          for (int _i457 = 0; _i457 < _list455.size; ++_i457)
          {
            _elem456 = new io.datafibre.fibre.thrift.TExpr();
            _elem456.read(iprot);
            struct.join_conjuncts.add(_elem456);
          }
        }
        struct.setJoin_conjunctsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.sql_join_conjuncts = iprot.readString();
        struct.setSql_join_conjunctsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

