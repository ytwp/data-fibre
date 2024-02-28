/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TNormalSortAggregationNode implements org.apache.thrift.TBase<TNormalSortAggregationNode, TNormalSortAggregationNode._Fields>, java.io.Serializable, Cloneable, Comparable<TNormalSortAggregationNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TNormalSortAggregationNode");

  private static final org.apache.thrift.protocol.TField GROUPING_EXPRS_FIELD_DESC = new org.apache.thrift.protocol.TField("grouping_exprs", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField AGGREGATE_FUNCTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("aggregate_functions", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField AGG_FUNC_SET_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("agg_func_set_version", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TNormalSortAggregationNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TNormalSortAggregationNodeTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> grouping_exprs; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> aggregate_functions; // optional
  public int agg_func_set_version; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GROUPING_EXPRS((short)1, "grouping_exprs"),
    AGGREGATE_FUNCTIONS((short)2, "aggregate_functions"),
    AGG_FUNC_SET_VERSION((short)3, "agg_func_set_version");

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
        case 1: // GROUPING_EXPRS
          return GROUPING_EXPRS;
        case 2: // AGGREGATE_FUNCTIONS
          return AGGREGATE_FUNCTIONS;
        case 3: // AGG_FUNC_SET_VERSION
          return AGG_FUNC_SET_VERSION;
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
  private static final int __AGG_FUNC_SET_VERSION_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.GROUPING_EXPRS,_Fields.AGGREGATE_FUNCTIONS,_Fields.AGG_FUNC_SET_VERSION};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GROUPING_EXPRS, new org.apache.thrift.meta_data.FieldMetaData("grouping_exprs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    tmpMap.put(_Fields.AGGREGATE_FUNCTIONS, new org.apache.thrift.meta_data.FieldMetaData("aggregate_functions", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    tmpMap.put(_Fields.AGG_FUNC_SET_VERSION, new org.apache.thrift.meta_data.FieldMetaData("agg_func_set_version", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TNormalSortAggregationNode.class, metaDataMap);
  }

  public TNormalSortAggregationNode() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TNormalSortAggregationNode(TNormalSortAggregationNode other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetGrouping_exprs()) {
      java.util.List<java.nio.ByteBuffer> __this__grouping_exprs = new java.util.ArrayList<java.nio.ByteBuffer>(other.grouping_exprs);
      this.grouping_exprs = __this__grouping_exprs;
    }
    if (other.isSetAggregate_functions()) {
      java.util.List<java.nio.ByteBuffer> __this__aggregate_functions = new java.util.ArrayList<java.nio.ByteBuffer>(other.aggregate_functions);
      this.aggregate_functions = __this__aggregate_functions;
    }
    this.agg_func_set_version = other.agg_func_set_version;
  }

  @Override
  public TNormalSortAggregationNode deepCopy() {
    return new TNormalSortAggregationNode(this);
  }

  @Override
  public void clear() {
    this.grouping_exprs = null;
    this.aggregate_functions = null;
    setAgg_func_set_versionIsSet(false);
    this.agg_func_set_version = 0;
  }

  public int getGrouping_exprsSize() {
    return (this.grouping_exprs == null) ? 0 : this.grouping_exprs.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.nio.ByteBuffer> getGrouping_exprsIterator() {
    return (this.grouping_exprs == null) ? null : this.grouping_exprs.iterator();
  }

  public void addToGrouping_exprs(java.nio.ByteBuffer elem) {
    if (this.grouping_exprs == null) {
      this.grouping_exprs = new java.util.ArrayList<java.nio.ByteBuffer>();
    }
    this.grouping_exprs.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.nio.ByteBuffer> getGrouping_exprs() {
    return this.grouping_exprs;
  }

  public TNormalSortAggregationNode setGrouping_exprs(@org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> grouping_exprs) {
    this.grouping_exprs = grouping_exprs;
    return this;
  }

  public void unsetGrouping_exprs() {
    this.grouping_exprs = null;
  }

  /** Returns true if field grouping_exprs is set (has been assigned a value) and false otherwise */
  public boolean isSetGrouping_exprs() {
    return this.grouping_exprs != null;
  }

  public void setGrouping_exprsIsSet(boolean value) {
    if (!value) {
      this.grouping_exprs = null;
    }
  }

  public int getAggregate_functionsSize() {
    return (this.aggregate_functions == null) ? 0 : this.aggregate_functions.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.nio.ByteBuffer> getAggregate_functionsIterator() {
    return (this.aggregate_functions == null) ? null : this.aggregate_functions.iterator();
  }

  public void addToAggregate_functions(java.nio.ByteBuffer elem) {
    if (this.aggregate_functions == null) {
      this.aggregate_functions = new java.util.ArrayList<java.nio.ByteBuffer>();
    }
    this.aggregate_functions.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.nio.ByteBuffer> getAggregate_functions() {
    return this.aggregate_functions;
  }

  public TNormalSortAggregationNode setAggregate_functions(@org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> aggregate_functions) {
    this.aggregate_functions = aggregate_functions;
    return this;
  }

  public void unsetAggregate_functions() {
    this.aggregate_functions = null;
  }

  /** Returns true if field aggregate_functions is set (has been assigned a value) and false otherwise */
  public boolean isSetAggregate_functions() {
    return this.aggregate_functions != null;
  }

  public void setAggregate_functionsIsSet(boolean value) {
    if (!value) {
      this.aggregate_functions = null;
    }
  }

  public int getAgg_func_set_version() {
    return this.agg_func_set_version;
  }

  public TNormalSortAggregationNode setAgg_func_set_version(int agg_func_set_version) {
    this.agg_func_set_version = agg_func_set_version;
    setAgg_func_set_versionIsSet(true);
    return this;
  }

  public void unsetAgg_func_set_version() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AGG_FUNC_SET_VERSION_ISSET_ID);
  }

  /** Returns true if field agg_func_set_version is set (has been assigned a value) and false otherwise */
  public boolean isSetAgg_func_set_version() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AGG_FUNC_SET_VERSION_ISSET_ID);
  }

  public void setAgg_func_set_versionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AGG_FUNC_SET_VERSION_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case GROUPING_EXPRS:
      if (value == null) {
        unsetGrouping_exprs();
      } else {
        setGrouping_exprs((java.util.List<java.nio.ByteBuffer>)value);
      }
      break;

    case AGGREGATE_FUNCTIONS:
      if (value == null) {
        unsetAggregate_functions();
      } else {
        setAggregate_functions((java.util.List<java.nio.ByteBuffer>)value);
      }
      break;

    case AGG_FUNC_SET_VERSION:
      if (value == null) {
        unsetAgg_func_set_version();
      } else {
        setAgg_func_set_version((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case GROUPING_EXPRS:
      return getGrouping_exprs();

    case AGGREGATE_FUNCTIONS:
      return getAggregate_functions();

    case AGG_FUNC_SET_VERSION:
      return getAgg_func_set_version();

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
    case GROUPING_EXPRS:
      return isSetGrouping_exprs();
    case AGGREGATE_FUNCTIONS:
      return isSetAggregate_functions();
    case AGG_FUNC_SET_VERSION:
      return isSetAgg_func_set_version();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TNormalSortAggregationNode)
      return this.equals((TNormalSortAggregationNode)that);
    return false;
  }

  public boolean equals(TNormalSortAggregationNode that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_grouping_exprs = true && this.isSetGrouping_exprs();
    boolean that_present_grouping_exprs = true && that.isSetGrouping_exprs();
    if (this_present_grouping_exprs || that_present_grouping_exprs) {
      if (!(this_present_grouping_exprs && that_present_grouping_exprs))
        return false;
      if (!this.grouping_exprs.equals(that.grouping_exprs))
        return false;
    }

    boolean this_present_aggregate_functions = true && this.isSetAggregate_functions();
    boolean that_present_aggregate_functions = true && that.isSetAggregate_functions();
    if (this_present_aggregate_functions || that_present_aggregate_functions) {
      if (!(this_present_aggregate_functions && that_present_aggregate_functions))
        return false;
      if (!this.aggregate_functions.equals(that.aggregate_functions))
        return false;
    }

    boolean this_present_agg_func_set_version = true && this.isSetAgg_func_set_version();
    boolean that_present_agg_func_set_version = true && that.isSetAgg_func_set_version();
    if (this_present_agg_func_set_version || that_present_agg_func_set_version) {
      if (!(this_present_agg_func_set_version && that_present_agg_func_set_version))
        return false;
      if (this.agg_func_set_version != that.agg_func_set_version)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetGrouping_exprs()) ? 131071 : 524287);
    if (isSetGrouping_exprs())
      hashCode = hashCode * 8191 + grouping_exprs.hashCode();

    hashCode = hashCode * 8191 + ((isSetAggregate_functions()) ? 131071 : 524287);
    if (isSetAggregate_functions())
      hashCode = hashCode * 8191 + aggregate_functions.hashCode();

    hashCode = hashCode * 8191 + ((isSetAgg_func_set_version()) ? 131071 : 524287);
    if (isSetAgg_func_set_version())
      hashCode = hashCode * 8191 + agg_func_set_version;

    return hashCode;
  }

  @Override
  public int compareTo(TNormalSortAggregationNode other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetGrouping_exprs(), other.isSetGrouping_exprs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGrouping_exprs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grouping_exprs, other.grouping_exprs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAggregate_functions(), other.isSetAggregate_functions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAggregate_functions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.aggregate_functions, other.aggregate_functions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAgg_func_set_version(), other.isSetAgg_func_set_version());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAgg_func_set_version()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.agg_func_set_version, other.agg_func_set_version);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TNormalSortAggregationNode(");
    boolean first = true;

    if (isSetGrouping_exprs()) {
      sb.append("grouping_exprs:");
      if (this.grouping_exprs == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.grouping_exprs, sb);
      }
      first = false;
    }
    if (isSetAggregate_functions()) {
      if (!first) sb.append(", ");
      sb.append("aggregate_functions:");
      if (this.aggregate_functions == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.aggregate_functions, sb);
      }
      first = false;
    }
    if (isSetAgg_func_set_version()) {
      if (!first) sb.append(", ");
      sb.append("agg_func_set_version:");
      sb.append(this.agg_func_set_version);
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

  private static class TNormalSortAggregationNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNormalSortAggregationNodeStandardScheme getScheme() {
      return new TNormalSortAggregationNodeStandardScheme();
    }
  }

  private static class TNormalSortAggregationNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TNormalSortAggregationNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TNormalSortAggregationNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GROUPING_EXPRS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list344 = iprot.readListBegin();
                struct.grouping_exprs = new java.util.ArrayList<java.nio.ByteBuffer>(_list344.size);
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem345;
                for (int _i346 = 0; _i346 < _list344.size; ++_i346)
                {
                  _elem345 = iprot.readBinary();
                  struct.grouping_exprs.add(_elem345);
                }
                iprot.readListEnd();
              }
              struct.setGrouping_exprsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // AGGREGATE_FUNCTIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list347 = iprot.readListBegin();
                struct.aggregate_functions = new java.util.ArrayList<java.nio.ByteBuffer>(_list347.size);
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem348;
                for (int _i349 = 0; _i349 < _list347.size; ++_i349)
                {
                  _elem348 = iprot.readBinary();
                  struct.aggregate_functions.add(_elem348);
                }
                iprot.readListEnd();
              }
              struct.setAggregate_functionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AGG_FUNC_SET_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.agg_func_set_version = iprot.readI32();
              struct.setAgg_func_set_versionIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TNormalSortAggregationNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.grouping_exprs != null) {
        if (struct.isSetGrouping_exprs()) {
          oprot.writeFieldBegin(GROUPING_EXPRS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.grouping_exprs.size()));
            for (java.nio.ByteBuffer _iter350 : struct.grouping_exprs)
            {
              oprot.writeBinary(_iter350);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.aggregate_functions != null) {
        if (struct.isSetAggregate_functions()) {
          oprot.writeFieldBegin(AGGREGATE_FUNCTIONS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.aggregate_functions.size()));
            for (java.nio.ByteBuffer _iter351 : struct.aggregate_functions)
            {
              oprot.writeBinary(_iter351);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetAgg_func_set_version()) {
        oprot.writeFieldBegin(AGG_FUNC_SET_VERSION_FIELD_DESC);
        oprot.writeI32(struct.agg_func_set_version);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TNormalSortAggregationNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNormalSortAggregationNodeTupleScheme getScheme() {
      return new TNormalSortAggregationNodeTupleScheme();
    }
  }

  private static class TNormalSortAggregationNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TNormalSortAggregationNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TNormalSortAggregationNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetGrouping_exprs()) {
        optionals.set(0);
      }
      if (struct.isSetAggregate_functions()) {
        optionals.set(1);
      }
      if (struct.isSetAgg_func_set_version()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetGrouping_exprs()) {
        {
          oprot.writeI32(struct.grouping_exprs.size());
          for (java.nio.ByteBuffer _iter352 : struct.grouping_exprs)
          {
            oprot.writeBinary(_iter352);
          }
        }
      }
      if (struct.isSetAggregate_functions()) {
        {
          oprot.writeI32(struct.aggregate_functions.size());
          for (java.nio.ByteBuffer _iter353 : struct.aggregate_functions)
          {
            oprot.writeBinary(_iter353);
          }
        }
      }
      if (struct.isSetAgg_func_set_version()) {
        oprot.writeI32(struct.agg_func_set_version);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TNormalSortAggregationNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list354 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.grouping_exprs = new java.util.ArrayList<java.nio.ByteBuffer>(_list354.size);
          @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem355;
          for (int _i356 = 0; _i356 < _list354.size; ++_i356)
          {
            _elem355 = iprot.readBinary();
            struct.grouping_exprs.add(_elem355);
          }
        }
        struct.setGrouping_exprsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list357 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.aggregate_functions = new java.util.ArrayList<java.nio.ByteBuffer>(_list357.size);
          @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem358;
          for (int _i359 = 0; _i359 < _list357.size; ++_i359)
          {
            _elem358 = iprot.readBinary();
            struct.aggregate_functions.add(_elem358);
          }
        }
        struct.setAggregate_functionsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.agg_func_set_version = iprot.readI32();
        struct.setAgg_func_set_versionIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

