/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TJDBCScanNode implements org.apache.thrift.TBase<TJDBCScanNode, TJDBCScanNode._Fields>, java.io.Serializable, Cloneable, Comparable<TJDBCScanNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TJDBCScanNode");

  private static final org.apache.thrift.protocol.TField TUPLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tuple_id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("table_name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("columns", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField FILTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("filters", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField LIMIT_FIELD_DESC = new org.apache.thrift.protocol.TField("limit", org.apache.thrift.protocol.TType.I64, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TJDBCScanNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TJDBCScanNodeTupleSchemeFactory();

  public int tuple_id; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String table_name; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> columns; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> filters; // optional
  public long limit; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TUPLE_ID((short)1, "tuple_id"),
    TABLE_NAME((short)2, "table_name"),
    COLUMNS((short)3, "columns"),
    FILTERS((short)4, "filters"),
    LIMIT((short)5, "limit");

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
        case 2: // TABLE_NAME
          return TABLE_NAME;
        case 3: // COLUMNS
          return COLUMNS;
        case 4: // FILTERS
          return FILTERS;
        case 5: // LIMIT
          return LIMIT;
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
  private static final int __LIMIT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TUPLE_ID,_Fields.TABLE_NAME,_Fields.COLUMNS,_Fields.FILTERS,_Fields.LIMIT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TUPLE_ID, new org.apache.thrift.meta_data.FieldMetaData("tuple_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "TTupleId")));
    tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("table_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("columns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.FILTERS, new org.apache.thrift.meta_data.FieldMetaData("filters", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.LIMIT, new org.apache.thrift.meta_data.FieldMetaData("limit", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TJDBCScanNode.class, metaDataMap);
  }

  public TJDBCScanNode() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TJDBCScanNode(TJDBCScanNode other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tuple_id = other.tuple_id;
    if (other.isSetTable_name()) {
      this.table_name = other.table_name;
    }
    if (other.isSetColumns()) {
      java.util.List<java.lang.String> __this__columns = new java.util.ArrayList<java.lang.String>(other.columns);
      this.columns = __this__columns;
    }
    if (other.isSetFilters()) {
      java.util.List<java.lang.String> __this__filters = new java.util.ArrayList<java.lang.String>(other.filters);
      this.filters = __this__filters;
    }
    this.limit = other.limit;
  }

  @Override
  public TJDBCScanNode deepCopy() {
    return new TJDBCScanNode(this);
  }

  @Override
  public void clear() {
    setTuple_idIsSet(false);
    this.tuple_id = 0;
    this.table_name = null;
    this.columns = null;
    this.filters = null;
    setLimitIsSet(false);
    this.limit = 0;
  }

  public int getTuple_id() {
    return this.tuple_id;
  }

  public TJDBCScanNode setTuple_id(int tuple_id) {
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

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getTable_name() {
    return this.table_name;
  }

  public TJDBCScanNode setTable_name(@org.apache.thrift.annotation.Nullable java.lang.String table_name) {
    this.table_name = table_name;
    return this;
  }

  public void unsetTable_name() {
    this.table_name = null;
  }

  /** Returns true if field table_name is set (has been assigned a value) and false otherwise */
  public boolean isSetTable_name() {
    return this.table_name != null;
  }

  public void setTable_nameIsSet(boolean value) {
    if (!value) {
      this.table_name = null;
    }
  }

  public int getColumnsSize() {
    return (this.columns == null) ? 0 : this.columns.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.String> getColumnsIterator() {
    return (this.columns == null) ? null : this.columns.iterator();
  }

  public void addToColumns(java.lang.String elem) {
    if (this.columns == null) {
      this.columns = new java.util.ArrayList<java.lang.String>();
    }
    this.columns.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.String> getColumns() {
    return this.columns;
  }

  public TJDBCScanNode setColumns(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> columns) {
    this.columns = columns;
    return this;
  }

  public void unsetColumns() {
    this.columns = null;
  }

  /** Returns true if field columns is set (has been assigned a value) and false otherwise */
  public boolean isSetColumns() {
    return this.columns != null;
  }

  public void setColumnsIsSet(boolean value) {
    if (!value) {
      this.columns = null;
    }
  }

  public int getFiltersSize() {
    return (this.filters == null) ? 0 : this.filters.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.String> getFiltersIterator() {
    return (this.filters == null) ? null : this.filters.iterator();
  }

  public void addToFilters(java.lang.String elem) {
    if (this.filters == null) {
      this.filters = new java.util.ArrayList<java.lang.String>();
    }
    this.filters.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.String> getFilters() {
    return this.filters;
  }

  public TJDBCScanNode setFilters(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> filters) {
    this.filters = filters;
    return this;
  }

  public void unsetFilters() {
    this.filters = null;
  }

  /** Returns true if field filters is set (has been assigned a value) and false otherwise */
  public boolean isSetFilters() {
    return this.filters != null;
  }

  public void setFiltersIsSet(boolean value) {
    if (!value) {
      this.filters = null;
    }
  }

  public long getLimit() {
    return this.limit;
  }

  public TJDBCScanNode setLimit(long limit) {
    this.limit = limit;
    setLimitIsSet(true);
    return this;
  }

  public void unsetLimit() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LIMIT_ISSET_ID);
  }

  /** Returns true if field limit is set (has been assigned a value) and false otherwise */
  public boolean isSetLimit() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LIMIT_ISSET_ID);
  }

  public void setLimitIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LIMIT_ISSET_ID, value);
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

    case TABLE_NAME:
      if (value == null) {
        unsetTable_name();
      } else {
        setTable_name((java.lang.String)value);
      }
      break;

    case COLUMNS:
      if (value == null) {
        unsetColumns();
      } else {
        setColumns((java.util.List<java.lang.String>)value);
      }
      break;

    case FILTERS:
      if (value == null) {
        unsetFilters();
      } else {
        setFilters((java.util.List<java.lang.String>)value);
      }
      break;

    case LIMIT:
      if (value == null) {
        unsetLimit();
      } else {
        setLimit((java.lang.Long)value);
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

    case TABLE_NAME:
      return getTable_name();

    case COLUMNS:
      return getColumns();

    case FILTERS:
      return getFilters();

    case LIMIT:
      return getLimit();

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
    case TABLE_NAME:
      return isSetTable_name();
    case COLUMNS:
      return isSetColumns();
    case FILTERS:
      return isSetFilters();
    case LIMIT:
      return isSetLimit();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TJDBCScanNode)
      return this.equals((TJDBCScanNode)that);
    return false;
  }

  public boolean equals(TJDBCScanNode that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tuple_id = true && this.isSetTuple_id();
    boolean that_present_tuple_id = true && that.isSetTuple_id();
    if (this_present_tuple_id || that_present_tuple_id) {
      if (!(this_present_tuple_id && that_present_tuple_id))
        return false;
      if (this.tuple_id != that.tuple_id)
        return false;
    }

    boolean this_present_table_name = true && this.isSetTable_name();
    boolean that_present_table_name = true && that.isSetTable_name();
    if (this_present_table_name || that_present_table_name) {
      if (!(this_present_table_name && that_present_table_name))
        return false;
      if (!this.table_name.equals(that.table_name))
        return false;
    }

    boolean this_present_columns = true && this.isSetColumns();
    boolean that_present_columns = true && that.isSetColumns();
    if (this_present_columns || that_present_columns) {
      if (!(this_present_columns && that_present_columns))
        return false;
      if (!this.columns.equals(that.columns))
        return false;
    }

    boolean this_present_filters = true && this.isSetFilters();
    boolean that_present_filters = true && that.isSetFilters();
    if (this_present_filters || that_present_filters) {
      if (!(this_present_filters && that_present_filters))
        return false;
      if (!this.filters.equals(that.filters))
        return false;
    }

    boolean this_present_limit = true && this.isSetLimit();
    boolean that_present_limit = true && that.isSetLimit();
    if (this_present_limit || that_present_limit) {
      if (!(this_present_limit && that_present_limit))
        return false;
      if (this.limit != that.limit)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTuple_id()) ? 131071 : 524287);
    if (isSetTuple_id())
      hashCode = hashCode * 8191 + tuple_id;

    hashCode = hashCode * 8191 + ((isSetTable_name()) ? 131071 : 524287);
    if (isSetTable_name())
      hashCode = hashCode * 8191 + table_name.hashCode();

    hashCode = hashCode * 8191 + ((isSetColumns()) ? 131071 : 524287);
    if (isSetColumns())
      hashCode = hashCode * 8191 + columns.hashCode();

    hashCode = hashCode * 8191 + ((isSetFilters()) ? 131071 : 524287);
    if (isSetFilters())
      hashCode = hashCode * 8191 + filters.hashCode();

    hashCode = hashCode * 8191 + ((isSetLimit()) ? 131071 : 524287);
    if (isSetLimit())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(limit);

    return hashCode;
  }

  @Override
  public int compareTo(TJDBCScanNode other) {
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
    lastComparison = java.lang.Boolean.compare(isSetTable_name(), other.isSetTable_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table_name, other.table_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetColumns(), other.isSetColumns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columns, other.columns);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetFilters(), other.isSetFilters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filters, other.filters);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetLimit(), other.isSetLimit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLimit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.limit, other.limit);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TJDBCScanNode(");
    boolean first = true;

    if (isSetTuple_id()) {
      sb.append("tuple_id:");
      sb.append(this.tuple_id);
      first = false;
    }
    if (isSetTable_name()) {
      if (!first) sb.append(", ");
      sb.append("table_name:");
      if (this.table_name == null) {
        sb.append("null");
      } else {
        sb.append(this.table_name);
      }
      first = false;
    }
    if (isSetColumns()) {
      if (!first) sb.append(", ");
      sb.append("columns:");
      if (this.columns == null) {
        sb.append("null");
      } else {
        sb.append(this.columns);
      }
      first = false;
    }
    if (isSetFilters()) {
      if (!first) sb.append(", ");
      sb.append("filters:");
      if (this.filters == null) {
        sb.append("null");
      } else {
        sb.append(this.filters);
      }
      first = false;
    }
    if (isSetLimit()) {
      if (!first) sb.append(", ");
      sb.append("limit:");
      sb.append(this.limit);
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

  private static class TJDBCScanNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TJDBCScanNodeStandardScheme getScheme() {
      return new TJDBCScanNodeStandardScheme();
    }
  }

  private static class TJDBCScanNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TJDBCScanNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TJDBCScanNode struct) throws org.apache.thrift.TException {
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
          case 2: // TABLE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.table_name = iprot.readString();
              struct.setTable_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list288 = iprot.readListBegin();
                struct.columns = new java.util.ArrayList<java.lang.String>(_list288.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _elem289;
                for (int _i290 = 0; _i290 < _list288.size; ++_i290)
                {
                  _elem289 = iprot.readString();
                  struct.columns.add(_elem289);
                }
                iprot.readListEnd();
              }
              struct.setColumnsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FILTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list291 = iprot.readListBegin();
                struct.filters = new java.util.ArrayList<java.lang.String>(_list291.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _elem292;
                for (int _i293 = 0; _i293 < _list291.size; ++_i293)
                {
                  _elem292 = iprot.readString();
                  struct.filters.add(_elem292);
                }
                iprot.readListEnd();
              }
              struct.setFiltersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LIMIT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.limit = iprot.readI64();
              struct.setLimitIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TJDBCScanNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetTuple_id()) {
        oprot.writeFieldBegin(TUPLE_ID_FIELD_DESC);
        oprot.writeI32(struct.tuple_id);
        oprot.writeFieldEnd();
      }
      if (struct.table_name != null) {
        if (struct.isSetTable_name()) {
          oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.table_name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.columns != null) {
        if (struct.isSetColumns()) {
          oprot.writeFieldBegin(COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.columns.size()));
            for (java.lang.String _iter294 : struct.columns)
            {
              oprot.writeString(_iter294);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.filters != null) {
        if (struct.isSetFilters()) {
          oprot.writeFieldBegin(FILTERS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.filters.size()));
            for (java.lang.String _iter295 : struct.filters)
            {
              oprot.writeString(_iter295);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetLimit()) {
        oprot.writeFieldBegin(LIMIT_FIELD_DESC);
        oprot.writeI64(struct.limit);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TJDBCScanNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TJDBCScanNodeTupleScheme getScheme() {
      return new TJDBCScanNodeTupleScheme();
    }
  }

  private static class TJDBCScanNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TJDBCScanNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TJDBCScanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTuple_id()) {
        optionals.set(0);
      }
      if (struct.isSetTable_name()) {
        optionals.set(1);
      }
      if (struct.isSetColumns()) {
        optionals.set(2);
      }
      if (struct.isSetFilters()) {
        optionals.set(3);
      }
      if (struct.isSetLimit()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetTuple_id()) {
        oprot.writeI32(struct.tuple_id);
      }
      if (struct.isSetTable_name()) {
        oprot.writeString(struct.table_name);
      }
      if (struct.isSetColumns()) {
        {
          oprot.writeI32(struct.columns.size());
          for (java.lang.String _iter296 : struct.columns)
          {
            oprot.writeString(_iter296);
          }
        }
      }
      if (struct.isSetFilters()) {
        {
          oprot.writeI32(struct.filters.size());
          for (java.lang.String _iter297 : struct.filters)
          {
            oprot.writeString(_iter297);
          }
        }
      }
      if (struct.isSetLimit()) {
        oprot.writeI64(struct.limit);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TJDBCScanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.tuple_id = iprot.readI32();
        struct.setTuple_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.table_name = iprot.readString();
        struct.setTable_nameIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list298 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.columns = new java.util.ArrayList<java.lang.String>(_list298.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _elem299;
          for (int _i300 = 0; _i300 < _list298.size; ++_i300)
          {
            _elem299 = iprot.readString();
            struct.columns.add(_elem299);
          }
        }
        struct.setColumnsIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list301 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.filters = new java.util.ArrayList<java.lang.String>(_list301.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _elem302;
          for (int _i303 = 0; _i303 < _list301.size; ++_i303)
          {
            _elem302 = iprot.readString();
            struct.filters.add(_elem302);
          }
        }
        struct.setFiltersIsSet(true);
      }
      if (incoming.get(4)) {
        struct.limit = iprot.readI64();
        struct.setLimitIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

