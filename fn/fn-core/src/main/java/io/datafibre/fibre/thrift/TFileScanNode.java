/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TFileScanNode implements org.apache.thrift.TBase<TFileScanNode, TFileScanNode._Fields>, java.io.Serializable, Cloneable, Comparable<TFileScanNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TFileScanNode");

  private static final org.apache.thrift.protocol.TField TUPLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tuple_id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PARTITION_EXPRS_FIELD_DESC = new org.apache.thrift.protocol.TField("partition_exprs", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField PARTITION_INFOS_FIELD_DESC = new org.apache.thrift.protocol.TField("partition_infos", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField ENABLE_PIPELINE_LOAD_FIELD_DESC = new org.apache.thrift.protocol.TField("enable_pipeline_load", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TFileScanNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TFileScanNodeTupleSchemeFactory();

  public int tuple_id; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TExpr> partition_exprs; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TRangePartition> partition_infos; // optional
  public boolean enable_pipeline_load; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TUPLE_ID((short)1, "tuple_id"),
    PARTITION_EXPRS((short)2, "partition_exprs"),
    PARTITION_INFOS((short)3, "partition_infos"),
    ENABLE_PIPELINE_LOAD((short)4, "enable_pipeline_load");

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
        case 2: // PARTITION_EXPRS
          return PARTITION_EXPRS;
        case 3: // PARTITION_INFOS
          return PARTITION_INFOS;
        case 4: // ENABLE_PIPELINE_LOAD
          return ENABLE_PIPELINE_LOAD;
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
  private static final int __ENABLE_PIPELINE_LOAD_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PARTITION_EXPRS,_Fields.PARTITION_INFOS,_Fields.ENABLE_PIPELINE_LOAD};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TUPLE_ID, new org.apache.thrift.meta_data.FieldMetaData("tuple_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "TTupleId")));
    tmpMap.put(_Fields.PARTITION_EXPRS, new org.apache.thrift.meta_data.FieldMetaData("partition_exprs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TExpr.class))));
    tmpMap.put(_Fields.PARTITION_INFOS, new org.apache.thrift.meta_data.FieldMetaData("partition_infos", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TRangePartition.class))));
    tmpMap.put(_Fields.ENABLE_PIPELINE_LOAD, new org.apache.thrift.meta_data.FieldMetaData("enable_pipeline_load", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TFileScanNode.class, metaDataMap);
  }

  public TFileScanNode() {
  }

  public TFileScanNode(
    int tuple_id)
  {
    this();
    this.tuple_id = tuple_id;
    setTuple_idIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TFileScanNode(TFileScanNode other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tuple_id = other.tuple_id;
    if (other.isSetPartition_exprs()) {
      java.util.List<io.datafibre.fibre.thrift.TExpr> __this__partition_exprs = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>(other.partition_exprs.size());
      for (io.datafibre.fibre.thrift.TExpr other_element : other.partition_exprs) {
        __this__partition_exprs.add(new io.datafibre.fibre.thrift.TExpr(other_element));
      }
      this.partition_exprs = __this__partition_exprs;
    }
    if (other.isSetPartition_infos()) {
      java.util.List<io.datafibre.fibre.thrift.TRangePartition> __this__partition_infos = new java.util.ArrayList<io.datafibre.fibre.thrift.TRangePartition>(other.partition_infos.size());
      for (io.datafibre.fibre.thrift.TRangePartition other_element : other.partition_infos) {
        __this__partition_infos.add(new io.datafibre.fibre.thrift.TRangePartition(other_element));
      }
      this.partition_infos = __this__partition_infos;
    }
    this.enable_pipeline_load = other.enable_pipeline_load;
  }

  @Override
  public TFileScanNode deepCopy() {
    return new TFileScanNode(this);
  }

  @Override
  public void clear() {
    setTuple_idIsSet(false);
    this.tuple_id = 0;
    this.partition_exprs = null;
    this.partition_infos = null;
    setEnable_pipeline_loadIsSet(false);
    this.enable_pipeline_load = false;
  }

  public int getTuple_id() {
    return this.tuple_id;
  }

  public TFileScanNode setTuple_id(int tuple_id) {
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

  public int getPartition_exprsSize() {
    return (this.partition_exprs == null) ? 0 : this.partition_exprs.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<io.datafibre.fibre.thrift.TExpr> getPartition_exprsIterator() {
    return (this.partition_exprs == null) ? null : this.partition_exprs.iterator();
  }

  public void addToPartition_exprs(io.datafibre.fibre.thrift.TExpr elem) {
    if (this.partition_exprs == null) {
      this.partition_exprs = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>();
    }
    this.partition_exprs.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<io.datafibre.fibre.thrift.TExpr> getPartition_exprs() {
    return this.partition_exprs;
  }

  public TFileScanNode setPartition_exprs(@org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TExpr> partition_exprs) {
    this.partition_exprs = partition_exprs;
    return this;
  }

  public void unsetPartition_exprs() {
    this.partition_exprs = null;
  }

  /** Returns true if field partition_exprs is set (has been assigned a value) and false otherwise */
  public boolean isSetPartition_exprs() {
    return this.partition_exprs != null;
  }

  public void setPartition_exprsIsSet(boolean value) {
    if (!value) {
      this.partition_exprs = null;
    }
  }

  public int getPartition_infosSize() {
    return (this.partition_infos == null) ? 0 : this.partition_infos.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<io.datafibre.fibre.thrift.TRangePartition> getPartition_infosIterator() {
    return (this.partition_infos == null) ? null : this.partition_infos.iterator();
  }

  public void addToPartition_infos(io.datafibre.fibre.thrift.TRangePartition elem) {
    if (this.partition_infos == null) {
      this.partition_infos = new java.util.ArrayList<io.datafibre.fibre.thrift.TRangePartition>();
    }
    this.partition_infos.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<io.datafibre.fibre.thrift.TRangePartition> getPartition_infos() {
    return this.partition_infos;
  }

  public TFileScanNode setPartition_infos(@org.apache.thrift.annotation.Nullable java.util.List<io.datafibre.fibre.thrift.TRangePartition> partition_infos) {
    this.partition_infos = partition_infos;
    return this;
  }

  public void unsetPartition_infos() {
    this.partition_infos = null;
  }

  /** Returns true if field partition_infos is set (has been assigned a value) and false otherwise */
  public boolean isSetPartition_infos() {
    return this.partition_infos != null;
  }

  public void setPartition_infosIsSet(boolean value) {
    if (!value) {
      this.partition_infos = null;
    }
  }

  public boolean isEnable_pipeline_load() {
    return this.enable_pipeline_load;
  }

  public TFileScanNode setEnable_pipeline_load(boolean enable_pipeline_load) {
    this.enable_pipeline_load = enable_pipeline_load;
    setEnable_pipeline_loadIsSet(true);
    return this;
  }

  public void unsetEnable_pipeline_load() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ENABLE_PIPELINE_LOAD_ISSET_ID);
  }

  /** Returns true if field enable_pipeline_load is set (has been assigned a value) and false otherwise */
  public boolean isSetEnable_pipeline_load() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ENABLE_PIPELINE_LOAD_ISSET_ID);
  }

  public void setEnable_pipeline_loadIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ENABLE_PIPELINE_LOAD_ISSET_ID, value);
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

    case PARTITION_EXPRS:
      if (value == null) {
        unsetPartition_exprs();
      } else {
        setPartition_exprs((java.util.List<io.datafibre.fibre.thrift.TExpr>)value);
      }
      break;

    case PARTITION_INFOS:
      if (value == null) {
        unsetPartition_infos();
      } else {
        setPartition_infos((java.util.List<io.datafibre.fibre.thrift.TRangePartition>)value);
      }
      break;

    case ENABLE_PIPELINE_LOAD:
      if (value == null) {
        unsetEnable_pipeline_load();
      } else {
        setEnable_pipeline_load((java.lang.Boolean)value);
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

    case PARTITION_EXPRS:
      return getPartition_exprs();

    case PARTITION_INFOS:
      return getPartition_infos();

    case ENABLE_PIPELINE_LOAD:
      return isEnable_pipeline_load();

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
    case PARTITION_EXPRS:
      return isSetPartition_exprs();
    case PARTITION_INFOS:
      return isSetPartition_infos();
    case ENABLE_PIPELINE_LOAD:
      return isSetEnable_pipeline_load();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TFileScanNode)
      return this.equals((TFileScanNode)that);
    return false;
  }

  public boolean equals(TFileScanNode that) {
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

    boolean this_present_partition_exprs = true && this.isSetPartition_exprs();
    boolean that_present_partition_exprs = true && that.isSetPartition_exprs();
    if (this_present_partition_exprs || that_present_partition_exprs) {
      if (!(this_present_partition_exprs && that_present_partition_exprs))
        return false;
      if (!this.partition_exprs.equals(that.partition_exprs))
        return false;
    }

    boolean this_present_partition_infos = true && this.isSetPartition_infos();
    boolean that_present_partition_infos = true && that.isSetPartition_infos();
    if (this_present_partition_infos || that_present_partition_infos) {
      if (!(this_present_partition_infos && that_present_partition_infos))
        return false;
      if (!this.partition_infos.equals(that.partition_infos))
        return false;
    }

    boolean this_present_enable_pipeline_load = true && this.isSetEnable_pipeline_load();
    boolean that_present_enable_pipeline_load = true && that.isSetEnable_pipeline_load();
    if (this_present_enable_pipeline_load || that_present_enable_pipeline_load) {
      if (!(this_present_enable_pipeline_load && that_present_enable_pipeline_load))
        return false;
      if (this.enable_pipeline_load != that.enable_pipeline_load)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + tuple_id;

    hashCode = hashCode * 8191 + ((isSetPartition_exprs()) ? 131071 : 524287);
    if (isSetPartition_exprs())
      hashCode = hashCode * 8191 + partition_exprs.hashCode();

    hashCode = hashCode * 8191 + ((isSetPartition_infos()) ? 131071 : 524287);
    if (isSetPartition_infos())
      hashCode = hashCode * 8191 + partition_infos.hashCode();

    hashCode = hashCode * 8191 + ((isSetEnable_pipeline_load()) ? 131071 : 524287);
    if (isSetEnable_pipeline_load())
      hashCode = hashCode * 8191 + ((enable_pipeline_load) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(TFileScanNode other) {
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
    lastComparison = java.lang.Boolean.compare(isSetPartition_exprs(), other.isSetPartition_exprs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartition_exprs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partition_exprs, other.partition_exprs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPartition_infos(), other.isSetPartition_infos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartition_infos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partition_infos, other.partition_infos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEnable_pipeline_load(), other.isSetEnable_pipeline_load());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnable_pipeline_load()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.enable_pipeline_load, other.enable_pipeline_load);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TFileScanNode(");
    boolean first = true;

    sb.append("tuple_id:");
    sb.append(this.tuple_id);
    first = false;
    if (isSetPartition_exprs()) {
      if (!first) sb.append(", ");
      sb.append("partition_exprs:");
      if (this.partition_exprs == null) {
        sb.append("null");
      } else {
        sb.append(this.partition_exprs);
      }
      first = false;
    }
    if (isSetPartition_infos()) {
      if (!first) sb.append(", ");
      sb.append("partition_infos:");
      if (this.partition_infos == null) {
        sb.append("null");
      } else {
        sb.append(this.partition_infos);
      }
      first = false;
    }
    if (isSetEnable_pipeline_load()) {
      if (!first) sb.append(", ");
      sb.append("enable_pipeline_load:");
      sb.append(this.enable_pipeline_load);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'tuple_id' because it's a primitive and you chose the non-beans generator.
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

  private static class TFileScanNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFileScanNodeStandardScheme getScheme() {
      return new TFileScanNodeStandardScheme();
    }
  }

  private static class TFileScanNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TFileScanNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TFileScanNode struct) throws org.apache.thrift.TException {
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
          case 2: // PARTITION_EXPRS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list160 = iprot.readListBegin();
                struct.partition_exprs = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>(_list160.size);
                @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TExpr _elem161;
                for (int _i162 = 0; _i162 < _list160.size; ++_i162)
                {
                  _elem161 = new io.datafibre.fibre.thrift.TExpr();
                  _elem161.read(iprot);
                  struct.partition_exprs.add(_elem161);
                }
                iprot.readListEnd();
              }
              struct.setPartition_exprsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PARTITION_INFOS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list163 = iprot.readListBegin();
                struct.partition_infos = new java.util.ArrayList<io.datafibre.fibre.thrift.TRangePartition>(_list163.size);
                @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TRangePartition _elem164;
                for (int _i165 = 0; _i165 < _list163.size; ++_i165)
                {
                  _elem164 = new io.datafibre.fibre.thrift.TRangePartition();
                  _elem164.read(iprot);
                  struct.partition_infos.add(_elem164);
                }
                iprot.readListEnd();
              }
              struct.setPartition_infosIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ENABLE_PIPELINE_LOAD
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.enable_pipeline_load = iprot.readBool();
              struct.setEnable_pipeline_loadIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TFileScanNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TUPLE_ID_FIELD_DESC);
      oprot.writeI32(struct.tuple_id);
      oprot.writeFieldEnd();
      if (struct.partition_exprs != null) {
        if (struct.isSetPartition_exprs()) {
          oprot.writeFieldBegin(PARTITION_EXPRS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.partition_exprs.size()));
            for (io.datafibre.fibre.thrift.TExpr _iter166 : struct.partition_exprs)
            {
              _iter166.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.partition_infos != null) {
        if (struct.isSetPartition_infos()) {
          oprot.writeFieldBegin(PARTITION_INFOS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.partition_infos.size()));
            for (io.datafibre.fibre.thrift.TRangePartition _iter167 : struct.partition_infos)
            {
              _iter167.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetEnable_pipeline_load()) {
        oprot.writeFieldBegin(ENABLE_PIPELINE_LOAD_FIELD_DESC);
        oprot.writeBool(struct.enable_pipeline_load);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TFileScanNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFileScanNodeTupleScheme getScheme() {
      return new TFileScanNodeTupleScheme();
    }
  }

  private static class TFileScanNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TFileScanNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TFileScanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.tuple_id);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetPartition_exprs()) {
        optionals.set(0);
      }
      if (struct.isSetPartition_infos()) {
        optionals.set(1);
      }
      if (struct.isSetEnable_pipeline_load()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetPartition_exprs()) {
        {
          oprot.writeI32(struct.partition_exprs.size());
          for (io.datafibre.fibre.thrift.TExpr _iter168 : struct.partition_exprs)
          {
            _iter168.write(oprot);
          }
        }
      }
      if (struct.isSetPartition_infos()) {
        {
          oprot.writeI32(struct.partition_infos.size());
          for (io.datafibre.fibre.thrift.TRangePartition _iter169 : struct.partition_infos)
          {
            _iter169.write(oprot);
          }
        }
      }
      if (struct.isSetEnable_pipeline_load()) {
        oprot.writeBool(struct.enable_pipeline_load);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TFileScanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.tuple_id = iprot.readI32();
      struct.setTuple_idIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list170 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.partition_exprs = new java.util.ArrayList<io.datafibre.fibre.thrift.TExpr>(_list170.size);
          @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TExpr _elem171;
          for (int _i172 = 0; _i172 < _list170.size; ++_i172)
          {
            _elem171 = new io.datafibre.fibre.thrift.TExpr();
            _elem171.read(iprot);
            struct.partition_exprs.add(_elem171);
          }
        }
        struct.setPartition_exprsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list173 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.partition_infos = new java.util.ArrayList<io.datafibre.fibre.thrift.TRangePartition>(_list173.size);
          @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TRangePartition _elem174;
          for (int _i175 = 0; _i175 < _list173.size; ++_i175)
          {
            _elem174 = new io.datafibre.fibre.thrift.TRangePartition();
            _elem174.read(iprot);
            struct.partition_infos.add(_elem174);
          }
        }
        struct.setPartition_infosIsSet(true);
      }
      if (incoming.get(2)) {
        struct.enable_pipeline_load = iprot.readBool();
        struct.setEnable_pipeline_loadIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

