/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TSortInfo implements org.apache.thrift.TBase<TSortInfo, TSortInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TSortInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TSortInfo");

  private static final org.apache.thrift.protocol.TField ORDERING_EXPRS_FIELD_DESC = new org.apache.thrift.protocol.TField("ordering_exprs", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField IS_ASC_ORDER_FIELD_DESC = new org.apache.thrift.protocol.TField("is_asc_order", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField NULLS_FIRST_FIELD_DESC = new org.apache.thrift.protocol.TField("nulls_first", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField SORT_TUPLE_SLOT_EXPRS_FIELD_DESC = new org.apache.thrift.protocol.TField("sort_tuple_slot_exprs", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TSortInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TSortInfoTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> ordering_exprs; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Boolean> is_asc_order; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Boolean> nulls_first; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> sort_tuple_slot_exprs; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ORDERING_EXPRS((short)1, "ordering_exprs"),
    IS_ASC_ORDER((short)2, "is_asc_order"),
    NULLS_FIRST((short)3, "nulls_first"),
    SORT_TUPLE_SLOT_EXPRS((short)4, "sort_tuple_slot_exprs");

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
        case 1: // ORDERING_EXPRS
          return ORDERING_EXPRS;
        case 2: // IS_ASC_ORDER
          return IS_ASC_ORDER;
        case 3: // NULLS_FIRST
          return NULLS_FIRST;
        case 4: // SORT_TUPLE_SLOT_EXPRS
          return SORT_TUPLE_SLOT_EXPRS;
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
  private static final _Fields optionals[] = {_Fields.SORT_TUPLE_SLOT_EXPRS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ORDERING_EXPRS, new org.apache.thrift.meta_data.FieldMetaData("ordering_exprs", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TExpr.class))));
    tmpMap.put(_Fields.IS_ASC_ORDER, new org.apache.thrift.meta_data.FieldMetaData("is_asc_order", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL))));
    tmpMap.put(_Fields.NULLS_FIRST, new org.apache.thrift.meta_data.FieldMetaData("nulls_first", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL))));
    tmpMap.put(_Fields.SORT_TUPLE_SLOT_EXPRS, new org.apache.thrift.meta_data.FieldMetaData("sort_tuple_slot_exprs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TExpr.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TSortInfo.class, metaDataMap);
  }

  public TSortInfo() {
  }

  public TSortInfo(
    java.util.List<com.starrocks.thrift.TExpr> ordering_exprs,
    java.util.List<java.lang.Boolean> is_asc_order,
    java.util.List<java.lang.Boolean> nulls_first)
  {
    this();
    this.ordering_exprs = ordering_exprs;
    this.is_asc_order = is_asc_order;
    this.nulls_first = nulls_first;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TSortInfo(TSortInfo other) {
    if (other.isSetOrdering_exprs()) {
      java.util.List<com.starrocks.thrift.TExpr> __this__ordering_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(other.ordering_exprs.size());
      for (com.starrocks.thrift.TExpr other_element : other.ordering_exprs) {
        __this__ordering_exprs.add(new com.starrocks.thrift.TExpr(other_element));
      }
      this.ordering_exprs = __this__ordering_exprs;
    }
    if (other.isSetIs_asc_order()) {
      java.util.List<java.lang.Boolean> __this__is_asc_order = new java.util.ArrayList<java.lang.Boolean>(other.is_asc_order);
      this.is_asc_order = __this__is_asc_order;
    }
    if (other.isSetNulls_first()) {
      java.util.List<java.lang.Boolean> __this__nulls_first = new java.util.ArrayList<java.lang.Boolean>(other.nulls_first);
      this.nulls_first = __this__nulls_first;
    }
    if (other.isSetSort_tuple_slot_exprs()) {
      java.util.List<com.starrocks.thrift.TExpr> __this__sort_tuple_slot_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(other.sort_tuple_slot_exprs.size());
      for (com.starrocks.thrift.TExpr other_element : other.sort_tuple_slot_exprs) {
        __this__sort_tuple_slot_exprs.add(new com.starrocks.thrift.TExpr(other_element));
      }
      this.sort_tuple_slot_exprs = __this__sort_tuple_slot_exprs;
    }
  }

  @Override
  public TSortInfo deepCopy() {
    return new TSortInfo(this);
  }

  @Override
  public void clear() {
    this.ordering_exprs = null;
    this.is_asc_order = null;
    this.nulls_first = null;
    this.sort_tuple_slot_exprs = null;
  }

  public int getOrdering_exprsSize() {
    return (this.ordering_exprs == null) ? 0 : this.ordering_exprs.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<com.starrocks.thrift.TExpr> getOrdering_exprsIterator() {
    return (this.ordering_exprs == null) ? null : this.ordering_exprs.iterator();
  }

  public void addToOrdering_exprs(com.starrocks.thrift.TExpr elem) {
    if (this.ordering_exprs == null) {
      this.ordering_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>();
    }
    this.ordering_exprs.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<com.starrocks.thrift.TExpr> getOrdering_exprs() {
    return this.ordering_exprs;
  }

  public TSortInfo setOrdering_exprs(@org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> ordering_exprs) {
    this.ordering_exprs = ordering_exprs;
    return this;
  }

  public void unsetOrdering_exprs() {
    this.ordering_exprs = null;
  }

  /** Returns true if field ordering_exprs is set (has been assigned a value) and false otherwise */
  public boolean isSetOrdering_exprs() {
    return this.ordering_exprs != null;
  }

  public void setOrdering_exprsIsSet(boolean value) {
    if (!value) {
      this.ordering_exprs = null;
    }
  }

  public int getIs_asc_orderSize() {
    return (this.is_asc_order == null) ? 0 : this.is_asc_order.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Boolean> getIs_asc_orderIterator() {
    return (this.is_asc_order == null) ? null : this.is_asc_order.iterator();
  }

  public void addToIs_asc_order(boolean elem) {
    if (this.is_asc_order == null) {
      this.is_asc_order = new java.util.ArrayList<java.lang.Boolean>();
    }
    this.is_asc_order.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Boolean> getIs_asc_order() {
    return this.is_asc_order;
  }

  public TSortInfo setIs_asc_order(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Boolean> is_asc_order) {
    this.is_asc_order = is_asc_order;
    return this;
  }

  public void unsetIs_asc_order() {
    this.is_asc_order = null;
  }

  /** Returns true if field is_asc_order is set (has been assigned a value) and false otherwise */
  public boolean isSetIs_asc_order() {
    return this.is_asc_order != null;
  }

  public void setIs_asc_orderIsSet(boolean value) {
    if (!value) {
      this.is_asc_order = null;
    }
  }

  public int getNulls_firstSize() {
    return (this.nulls_first == null) ? 0 : this.nulls_first.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Boolean> getNulls_firstIterator() {
    return (this.nulls_first == null) ? null : this.nulls_first.iterator();
  }

  public void addToNulls_first(boolean elem) {
    if (this.nulls_first == null) {
      this.nulls_first = new java.util.ArrayList<java.lang.Boolean>();
    }
    this.nulls_first.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Boolean> getNulls_first() {
    return this.nulls_first;
  }

  public TSortInfo setNulls_first(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Boolean> nulls_first) {
    this.nulls_first = nulls_first;
    return this;
  }

  public void unsetNulls_first() {
    this.nulls_first = null;
  }

  /** Returns true if field nulls_first is set (has been assigned a value) and false otherwise */
  public boolean isSetNulls_first() {
    return this.nulls_first != null;
  }

  public void setNulls_firstIsSet(boolean value) {
    if (!value) {
      this.nulls_first = null;
    }
  }

  public int getSort_tuple_slot_exprsSize() {
    return (this.sort_tuple_slot_exprs == null) ? 0 : this.sort_tuple_slot_exprs.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<com.starrocks.thrift.TExpr> getSort_tuple_slot_exprsIterator() {
    return (this.sort_tuple_slot_exprs == null) ? null : this.sort_tuple_slot_exprs.iterator();
  }

  public void addToSort_tuple_slot_exprs(com.starrocks.thrift.TExpr elem) {
    if (this.sort_tuple_slot_exprs == null) {
      this.sort_tuple_slot_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>();
    }
    this.sort_tuple_slot_exprs.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<com.starrocks.thrift.TExpr> getSort_tuple_slot_exprs() {
    return this.sort_tuple_slot_exprs;
  }

  public TSortInfo setSort_tuple_slot_exprs(@org.apache.thrift.annotation.Nullable java.util.List<com.starrocks.thrift.TExpr> sort_tuple_slot_exprs) {
    this.sort_tuple_slot_exprs = sort_tuple_slot_exprs;
    return this;
  }

  public void unsetSort_tuple_slot_exprs() {
    this.sort_tuple_slot_exprs = null;
  }

  /** Returns true if field sort_tuple_slot_exprs is set (has been assigned a value) and false otherwise */
  public boolean isSetSort_tuple_slot_exprs() {
    return this.sort_tuple_slot_exprs != null;
  }

  public void setSort_tuple_slot_exprsIsSet(boolean value) {
    if (!value) {
      this.sort_tuple_slot_exprs = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ORDERING_EXPRS:
      if (value == null) {
        unsetOrdering_exprs();
      } else {
        setOrdering_exprs((java.util.List<com.starrocks.thrift.TExpr>)value);
      }
      break;

    case IS_ASC_ORDER:
      if (value == null) {
        unsetIs_asc_order();
      } else {
        setIs_asc_order((java.util.List<java.lang.Boolean>)value);
      }
      break;

    case NULLS_FIRST:
      if (value == null) {
        unsetNulls_first();
      } else {
        setNulls_first((java.util.List<java.lang.Boolean>)value);
      }
      break;

    case SORT_TUPLE_SLOT_EXPRS:
      if (value == null) {
        unsetSort_tuple_slot_exprs();
      } else {
        setSort_tuple_slot_exprs((java.util.List<com.starrocks.thrift.TExpr>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ORDERING_EXPRS:
      return getOrdering_exprs();

    case IS_ASC_ORDER:
      return getIs_asc_order();

    case NULLS_FIRST:
      return getNulls_first();

    case SORT_TUPLE_SLOT_EXPRS:
      return getSort_tuple_slot_exprs();

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
    case ORDERING_EXPRS:
      return isSetOrdering_exprs();
    case IS_ASC_ORDER:
      return isSetIs_asc_order();
    case NULLS_FIRST:
      return isSetNulls_first();
    case SORT_TUPLE_SLOT_EXPRS:
      return isSetSort_tuple_slot_exprs();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TSortInfo)
      return this.equals((TSortInfo)that);
    return false;
  }

  public boolean equals(TSortInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_ordering_exprs = true && this.isSetOrdering_exprs();
    boolean that_present_ordering_exprs = true && that.isSetOrdering_exprs();
    if (this_present_ordering_exprs || that_present_ordering_exprs) {
      if (!(this_present_ordering_exprs && that_present_ordering_exprs))
        return false;
      if (!this.ordering_exprs.equals(that.ordering_exprs))
        return false;
    }

    boolean this_present_is_asc_order = true && this.isSetIs_asc_order();
    boolean that_present_is_asc_order = true && that.isSetIs_asc_order();
    if (this_present_is_asc_order || that_present_is_asc_order) {
      if (!(this_present_is_asc_order && that_present_is_asc_order))
        return false;
      if (!this.is_asc_order.equals(that.is_asc_order))
        return false;
    }

    boolean this_present_nulls_first = true && this.isSetNulls_first();
    boolean that_present_nulls_first = true && that.isSetNulls_first();
    if (this_present_nulls_first || that_present_nulls_first) {
      if (!(this_present_nulls_first && that_present_nulls_first))
        return false;
      if (!this.nulls_first.equals(that.nulls_first))
        return false;
    }

    boolean this_present_sort_tuple_slot_exprs = true && this.isSetSort_tuple_slot_exprs();
    boolean that_present_sort_tuple_slot_exprs = true && that.isSetSort_tuple_slot_exprs();
    if (this_present_sort_tuple_slot_exprs || that_present_sort_tuple_slot_exprs) {
      if (!(this_present_sort_tuple_slot_exprs && that_present_sort_tuple_slot_exprs))
        return false;
      if (!this.sort_tuple_slot_exprs.equals(that.sort_tuple_slot_exprs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetOrdering_exprs()) ? 131071 : 524287);
    if (isSetOrdering_exprs())
      hashCode = hashCode * 8191 + ordering_exprs.hashCode();

    hashCode = hashCode * 8191 + ((isSetIs_asc_order()) ? 131071 : 524287);
    if (isSetIs_asc_order())
      hashCode = hashCode * 8191 + is_asc_order.hashCode();

    hashCode = hashCode * 8191 + ((isSetNulls_first()) ? 131071 : 524287);
    if (isSetNulls_first())
      hashCode = hashCode * 8191 + nulls_first.hashCode();

    hashCode = hashCode * 8191 + ((isSetSort_tuple_slot_exprs()) ? 131071 : 524287);
    if (isSetSort_tuple_slot_exprs())
      hashCode = hashCode * 8191 + sort_tuple_slot_exprs.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TSortInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetOrdering_exprs(), other.isSetOrdering_exprs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrdering_exprs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ordering_exprs, other.ordering_exprs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetIs_asc_order(), other.isSetIs_asc_order());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIs_asc_order()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.is_asc_order, other.is_asc_order);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetNulls_first(), other.isSetNulls_first());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNulls_first()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nulls_first, other.nulls_first);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetSort_tuple_slot_exprs(), other.isSetSort_tuple_slot_exprs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSort_tuple_slot_exprs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sort_tuple_slot_exprs, other.sort_tuple_slot_exprs);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TSortInfo(");
    boolean first = true;

    sb.append("ordering_exprs:");
    if (this.ordering_exprs == null) {
      sb.append("null");
    } else {
      sb.append(this.ordering_exprs);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("is_asc_order:");
    if (this.is_asc_order == null) {
      sb.append("null");
    } else {
      sb.append(this.is_asc_order);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("nulls_first:");
    if (this.nulls_first == null) {
      sb.append("null");
    } else {
      sb.append(this.nulls_first);
    }
    first = false;
    if (isSetSort_tuple_slot_exprs()) {
      if (!first) sb.append(", ");
      sb.append("sort_tuple_slot_exprs:");
      if (this.sort_tuple_slot_exprs == null) {
        sb.append("null");
      } else {
        sb.append(this.sort_tuple_slot_exprs);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (ordering_exprs == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'ordering_exprs' was not present! Struct: " + toString());
    }
    if (is_asc_order == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'is_asc_order' was not present! Struct: " + toString());
    }
    if (nulls_first == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'nulls_first' was not present! Struct: " + toString());
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TSortInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TSortInfoStandardScheme getScheme() {
      return new TSortInfoStandardScheme();
    }
  }

  private static class TSortInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<TSortInfo> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TSortInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ORDERING_EXPRS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list530 = iprot.readListBegin();
                struct.ordering_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list530.size);
                @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem531;
                for (int _i532 = 0; _i532 < _list530.size; ++_i532)
                {
                  _elem531 = new com.starrocks.thrift.TExpr();
                  _elem531.read(iprot);
                  struct.ordering_exprs.add(_elem531);
                }
                iprot.readListEnd();
              }
              struct.setOrdering_exprsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IS_ASC_ORDER
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list533 = iprot.readListBegin();
                struct.is_asc_order = new java.util.ArrayList<java.lang.Boolean>(_list533.size);
                boolean _elem534;
                for (int _i535 = 0; _i535 < _list533.size; ++_i535)
                {
                  _elem534 = iprot.readBool();
                  struct.is_asc_order.add(_elem534);
                }
                iprot.readListEnd();
              }
              struct.setIs_asc_orderIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NULLS_FIRST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list536 = iprot.readListBegin();
                struct.nulls_first = new java.util.ArrayList<java.lang.Boolean>(_list536.size);
                boolean _elem537;
                for (int _i538 = 0; _i538 < _list536.size; ++_i538)
                {
                  _elem537 = iprot.readBool();
                  struct.nulls_first.add(_elem537);
                }
                iprot.readListEnd();
              }
              struct.setNulls_firstIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SORT_TUPLE_SLOT_EXPRS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list539 = iprot.readListBegin();
                struct.sort_tuple_slot_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list539.size);
                @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem540;
                for (int _i541 = 0; _i541 < _list539.size; ++_i541)
                {
                  _elem540 = new com.starrocks.thrift.TExpr();
                  _elem540.read(iprot);
                  struct.sort_tuple_slot_exprs.add(_elem540);
                }
                iprot.readListEnd();
              }
              struct.setSort_tuple_slot_exprsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TSortInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ordering_exprs != null) {
        oprot.writeFieldBegin(ORDERING_EXPRS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.ordering_exprs.size()));
          for (com.starrocks.thrift.TExpr _iter542 : struct.ordering_exprs)
          {
            _iter542.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.is_asc_order != null) {
        oprot.writeFieldBegin(IS_ASC_ORDER_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.BOOL, struct.is_asc_order.size()));
          for (boolean _iter543 : struct.is_asc_order)
          {
            oprot.writeBool(_iter543);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.nulls_first != null) {
        oprot.writeFieldBegin(NULLS_FIRST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.BOOL, struct.nulls_first.size()));
          for (boolean _iter544 : struct.nulls_first)
          {
            oprot.writeBool(_iter544);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.sort_tuple_slot_exprs != null) {
        if (struct.isSetSort_tuple_slot_exprs()) {
          oprot.writeFieldBegin(SORT_TUPLE_SLOT_EXPRS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.sort_tuple_slot_exprs.size()));
            for (com.starrocks.thrift.TExpr _iter545 : struct.sort_tuple_slot_exprs)
            {
              _iter545.write(oprot);
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

  private static class TSortInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TSortInfoTupleScheme getScheme() {
      return new TSortInfoTupleScheme();
    }
  }

  private static class TSortInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<TSortInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TSortInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.ordering_exprs.size());
        for (com.starrocks.thrift.TExpr _iter546 : struct.ordering_exprs)
        {
          _iter546.write(oprot);
        }
      }
      {
        oprot.writeI32(struct.is_asc_order.size());
        for (boolean _iter547 : struct.is_asc_order)
        {
          oprot.writeBool(_iter547);
        }
      }
      {
        oprot.writeI32(struct.nulls_first.size());
        for (boolean _iter548 : struct.nulls_first)
        {
          oprot.writeBool(_iter548);
        }
      }
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetSort_tuple_slot_exprs()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetSort_tuple_slot_exprs()) {
        {
          oprot.writeI32(struct.sort_tuple_slot_exprs.size());
          for (com.starrocks.thrift.TExpr _iter549 : struct.sort_tuple_slot_exprs)
          {
            _iter549.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TSortInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list550 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        struct.ordering_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list550.size);
        @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem551;
        for (int _i552 = 0; _i552 < _list550.size; ++_i552)
        {
          _elem551 = new com.starrocks.thrift.TExpr();
          _elem551.read(iprot);
          struct.ordering_exprs.add(_elem551);
        }
      }
      struct.setOrdering_exprsIsSet(true);
      {
        org.apache.thrift.protocol.TList _list553 = iprot.readListBegin(org.apache.thrift.protocol.TType.BOOL);
        struct.is_asc_order = new java.util.ArrayList<java.lang.Boolean>(_list553.size);
        boolean _elem554;
        for (int _i555 = 0; _i555 < _list553.size; ++_i555)
        {
          _elem554 = iprot.readBool();
          struct.is_asc_order.add(_elem554);
        }
      }
      struct.setIs_asc_orderIsSet(true);
      {
        org.apache.thrift.protocol.TList _list556 = iprot.readListBegin(org.apache.thrift.protocol.TType.BOOL);
        struct.nulls_first = new java.util.ArrayList<java.lang.Boolean>(_list556.size);
        boolean _elem557;
        for (int _i558 = 0; _i558 < _list556.size; ++_i558)
        {
          _elem557 = iprot.readBool();
          struct.nulls_first.add(_elem557);
        }
      }
      struct.setNulls_firstIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list559 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.sort_tuple_slot_exprs = new java.util.ArrayList<com.starrocks.thrift.TExpr>(_list559.size);
          @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr _elem560;
          for (int _i561 = 0; _i561 < _list559.size; ++_i561)
          {
            _elem560 = new com.starrocks.thrift.TExpr();
            _elem560.read(iprot);
            struct.sort_tuple_slot_exprs.add(_elem560);
          }
        }
        struct.setSort_tuple_slot_exprsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

