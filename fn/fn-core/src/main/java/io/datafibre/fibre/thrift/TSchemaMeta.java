/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TSchemaMeta implements org.apache.thrift.TBase<TSchemaMeta, TSchemaMeta._Fields>, java.io.Serializable, Cloneable, Comparable<TSchemaMeta> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TSchemaMeta");

  private static final org.apache.thrift.protocol.TField COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("columns", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField SCHEMA_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("schema_version", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SCHEMA_HASH_FIELD_DESC = new org.apache.thrift.protocol.TField("schema_hash", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField SHORT_KEY_COL_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("short_key_col_count", org.apache.thrift.protocol.TType.I16, (short)4);
  private static final org.apache.thrift.protocol.TField STORAGE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("storage_type", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField KEYS_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("keys_type", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TSchemaMetaStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TSchemaMetaTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<TColumnMeta> columns; // optional
  public int schema_version; // optional
  public int schema_hash; // optional
  public short short_key_col_count; // optional
  /**
   * 
   * @see com.starrocks.thrift.TStorageType
   */
  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStorageType storage_type; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String keys_type; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COLUMNS((short)1, "columns"),
    SCHEMA_VERSION((short)2, "schema_version"),
    SCHEMA_HASH((short)3, "schema_hash"),
    SHORT_KEY_COL_COUNT((short)4, "short_key_col_count"),
    /**
     * 
     * @see com.starrocks.thrift.TStorageType
     */
    STORAGE_TYPE((short)5, "storage_type"),
    KEYS_TYPE((short)6, "keys_type");

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
        case 1: // COLUMNS
          return COLUMNS;
        case 2: // SCHEMA_VERSION
          return SCHEMA_VERSION;
        case 3: // SCHEMA_HASH
          return SCHEMA_HASH;
        case 4: // SHORT_KEY_COL_COUNT
          return SHORT_KEY_COL_COUNT;
        case 5: // STORAGE_TYPE
          return STORAGE_TYPE;
        case 6: // KEYS_TYPE
          return KEYS_TYPE;
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
  private static final int __SCHEMA_VERSION_ISSET_ID = 0;
  private static final int __SCHEMA_HASH_ISSET_ID = 1;
  private static final int __SHORT_KEY_COL_COUNT_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.COLUMNS,_Fields.SCHEMA_VERSION,_Fields.SCHEMA_HASH,_Fields.SHORT_KEY_COL_COUNT,_Fields.STORAGE_TYPE,_Fields.KEYS_TYPE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("columns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TColumnMeta.class))));
    tmpMap.put(_Fields.SCHEMA_VERSION, new org.apache.thrift.meta_data.FieldMetaData("schema_version", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SCHEMA_HASH, new org.apache.thrift.meta_data.FieldMetaData("schema_hash", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SHORT_KEY_COL_COUNT, new org.apache.thrift.meta_data.FieldMetaData("short_key_col_count", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.STORAGE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("storage_type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.starrocks.thrift.TStorageType.class)));
    tmpMap.put(_Fields.KEYS_TYPE, new org.apache.thrift.meta_data.FieldMetaData("keys_type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TSchemaMeta.class, metaDataMap);
  }

  public TSchemaMeta() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TSchemaMeta(TSchemaMeta other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetColumns()) {
      java.util.List<TColumnMeta> __this__columns = new java.util.ArrayList<TColumnMeta>(other.columns.size());
      for (TColumnMeta other_element : other.columns) {
        __this__columns.add(new TColumnMeta(other_element));
      }
      this.columns = __this__columns;
    }
    this.schema_version = other.schema_version;
    this.schema_hash = other.schema_hash;
    this.short_key_col_count = other.short_key_col_count;
    if (other.isSetStorage_type()) {
      this.storage_type = other.storage_type;
    }
    if (other.isSetKeys_type()) {
      this.keys_type = other.keys_type;
    }
  }

  @Override
  public TSchemaMeta deepCopy() {
    return new TSchemaMeta(this);
  }

  @Override
  public void clear() {
    this.columns = null;
    setSchema_versionIsSet(false);
    this.schema_version = 0;
    setSchema_hashIsSet(false);
    this.schema_hash = 0;
    setShort_key_col_countIsSet(false);
    this.short_key_col_count = 0;
    this.storage_type = null;
    this.keys_type = null;
  }

  public int getColumnsSize() {
    return (this.columns == null) ? 0 : this.columns.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TColumnMeta> getColumnsIterator() {
    return (this.columns == null) ? null : this.columns.iterator();
  }

  public void addToColumns(TColumnMeta elem) {
    if (this.columns == null) {
      this.columns = new java.util.ArrayList<TColumnMeta>();
    }
    this.columns.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TColumnMeta> getColumns() {
    return this.columns;
  }

  public TSchemaMeta setColumns(@org.apache.thrift.annotation.Nullable java.util.List<TColumnMeta> columns) {
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

  public int getSchema_version() {
    return this.schema_version;
  }

  public TSchemaMeta setSchema_version(int schema_version) {
    this.schema_version = schema_version;
    setSchema_versionIsSet(true);
    return this;
  }

  public void unsetSchema_version() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SCHEMA_VERSION_ISSET_ID);
  }

  /** Returns true if field schema_version is set (has been assigned a value) and false otherwise */
  public boolean isSetSchema_version() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SCHEMA_VERSION_ISSET_ID);
  }

  public void setSchema_versionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SCHEMA_VERSION_ISSET_ID, value);
  }

  public int getSchema_hash() {
    return this.schema_hash;
  }

  public TSchemaMeta setSchema_hash(int schema_hash) {
    this.schema_hash = schema_hash;
    setSchema_hashIsSet(true);
    return this;
  }

  public void unsetSchema_hash() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SCHEMA_HASH_ISSET_ID);
  }

  /** Returns true if field schema_hash is set (has been assigned a value) and false otherwise */
  public boolean isSetSchema_hash() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SCHEMA_HASH_ISSET_ID);
  }

  public void setSchema_hashIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SCHEMA_HASH_ISSET_ID, value);
  }

  public short getShort_key_col_count() {
    return this.short_key_col_count;
  }

  public TSchemaMeta setShort_key_col_count(short short_key_col_count) {
    this.short_key_col_count = short_key_col_count;
    setShort_key_col_countIsSet(true);
    return this;
  }

  public void unsetShort_key_col_count() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SHORT_KEY_COL_COUNT_ISSET_ID);
  }

  /** Returns true if field short_key_col_count is set (has been assigned a value) and false otherwise */
  public boolean isSetShort_key_col_count() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SHORT_KEY_COL_COUNT_ISSET_ID);
  }

  public void setShort_key_col_countIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SHORT_KEY_COL_COUNT_ISSET_ID, value);
  }

  /**
   * 
   * @see com.starrocks.thrift.TStorageType
   */
  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TStorageType getStorage_type() {
    return this.storage_type;
  }

  /**
   * 
   * @see com.starrocks.thrift.TStorageType
   */
  public TSchemaMeta setStorage_type(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStorageType storage_type) {
    this.storage_type = storage_type;
    return this;
  }

  public void unsetStorage_type() {
    this.storage_type = null;
  }

  /** Returns true if field storage_type is set (has been assigned a value) and false otherwise */
  public boolean isSetStorage_type() {
    return this.storage_type != null;
  }

  public void setStorage_typeIsSet(boolean value) {
    if (!value) {
      this.storage_type = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getKeys_type() {
    return this.keys_type;
  }

  public TSchemaMeta setKeys_type(@org.apache.thrift.annotation.Nullable java.lang.String keys_type) {
    this.keys_type = keys_type;
    return this;
  }

  public void unsetKeys_type() {
    this.keys_type = null;
  }

  /** Returns true if field keys_type is set (has been assigned a value) and false otherwise */
  public boolean isSetKeys_type() {
    return this.keys_type != null;
  }

  public void setKeys_typeIsSet(boolean value) {
    if (!value) {
      this.keys_type = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case COLUMNS:
      if (value == null) {
        unsetColumns();
      } else {
        setColumns((java.util.List<TColumnMeta>)value);
      }
      break;

    case SCHEMA_VERSION:
      if (value == null) {
        unsetSchema_version();
      } else {
        setSchema_version((java.lang.Integer)value);
      }
      break;

    case SCHEMA_HASH:
      if (value == null) {
        unsetSchema_hash();
      } else {
        setSchema_hash((java.lang.Integer)value);
      }
      break;

    case SHORT_KEY_COL_COUNT:
      if (value == null) {
        unsetShort_key_col_count();
      } else {
        setShort_key_col_count((java.lang.Short)value);
      }
      break;

    case STORAGE_TYPE:
      if (value == null) {
        unsetStorage_type();
      } else {
        setStorage_type((com.starrocks.thrift.TStorageType)value);
      }
      break;

    case KEYS_TYPE:
      if (value == null) {
        unsetKeys_type();
      } else {
        setKeys_type((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case COLUMNS:
      return getColumns();

    case SCHEMA_VERSION:
      return getSchema_version();

    case SCHEMA_HASH:
      return getSchema_hash();

    case SHORT_KEY_COL_COUNT:
      return getShort_key_col_count();

    case STORAGE_TYPE:
      return getStorage_type();

    case KEYS_TYPE:
      return getKeys_type();

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
    case COLUMNS:
      return isSetColumns();
    case SCHEMA_VERSION:
      return isSetSchema_version();
    case SCHEMA_HASH:
      return isSetSchema_hash();
    case SHORT_KEY_COL_COUNT:
      return isSetShort_key_col_count();
    case STORAGE_TYPE:
      return isSetStorage_type();
    case KEYS_TYPE:
      return isSetKeys_type();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TSchemaMeta)
      return this.equals((TSchemaMeta)that);
    return false;
  }

  public boolean equals(TSchemaMeta that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_columns = true && this.isSetColumns();
    boolean that_present_columns = true && that.isSetColumns();
    if (this_present_columns || that_present_columns) {
      if (!(this_present_columns && that_present_columns))
        return false;
      if (!this.columns.equals(that.columns))
        return false;
    }

    boolean this_present_schema_version = true && this.isSetSchema_version();
    boolean that_present_schema_version = true && that.isSetSchema_version();
    if (this_present_schema_version || that_present_schema_version) {
      if (!(this_present_schema_version && that_present_schema_version))
        return false;
      if (this.schema_version != that.schema_version)
        return false;
    }

    boolean this_present_schema_hash = true && this.isSetSchema_hash();
    boolean that_present_schema_hash = true && that.isSetSchema_hash();
    if (this_present_schema_hash || that_present_schema_hash) {
      if (!(this_present_schema_hash && that_present_schema_hash))
        return false;
      if (this.schema_hash != that.schema_hash)
        return false;
    }

    boolean this_present_short_key_col_count = true && this.isSetShort_key_col_count();
    boolean that_present_short_key_col_count = true && that.isSetShort_key_col_count();
    if (this_present_short_key_col_count || that_present_short_key_col_count) {
      if (!(this_present_short_key_col_count && that_present_short_key_col_count))
        return false;
      if (this.short_key_col_count != that.short_key_col_count)
        return false;
    }

    boolean this_present_storage_type = true && this.isSetStorage_type();
    boolean that_present_storage_type = true && that.isSetStorage_type();
    if (this_present_storage_type || that_present_storage_type) {
      if (!(this_present_storage_type && that_present_storage_type))
        return false;
      if (!this.storage_type.equals(that.storage_type))
        return false;
    }

    boolean this_present_keys_type = true && this.isSetKeys_type();
    boolean that_present_keys_type = true && that.isSetKeys_type();
    if (this_present_keys_type || that_present_keys_type) {
      if (!(this_present_keys_type && that_present_keys_type))
        return false;
      if (!this.keys_type.equals(that.keys_type))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetColumns()) ? 131071 : 524287);
    if (isSetColumns())
      hashCode = hashCode * 8191 + columns.hashCode();

    hashCode = hashCode * 8191 + ((isSetSchema_version()) ? 131071 : 524287);
    if (isSetSchema_version())
      hashCode = hashCode * 8191 + schema_version;

    hashCode = hashCode * 8191 + ((isSetSchema_hash()) ? 131071 : 524287);
    if (isSetSchema_hash())
      hashCode = hashCode * 8191 + schema_hash;

    hashCode = hashCode * 8191 + ((isSetShort_key_col_count()) ? 131071 : 524287);
    if (isSetShort_key_col_count())
      hashCode = hashCode * 8191 + short_key_col_count;

    hashCode = hashCode * 8191 + ((isSetStorage_type()) ? 131071 : 524287);
    if (isSetStorage_type())
      hashCode = hashCode * 8191 + storage_type.getValue();

    hashCode = hashCode * 8191 + ((isSetKeys_type()) ? 131071 : 524287);
    if (isSetKeys_type())
      hashCode = hashCode * 8191 + keys_type.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TSchemaMeta other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = java.lang.Boolean.compare(isSetSchema_version(), other.isSetSchema_version());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSchema_version()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.schema_version, other.schema_version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetSchema_hash(), other.isSetSchema_hash());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSchema_hash()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.schema_hash, other.schema_hash);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetShort_key_col_count(), other.isSetShort_key_col_count());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetShort_key_col_count()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.short_key_col_count, other.short_key_col_count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetStorage_type(), other.isSetStorage_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStorage_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.storage_type, other.storage_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetKeys_type(), other.isSetKeys_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKeys_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keys_type, other.keys_type);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TSchemaMeta(");
    boolean first = true;

    if (isSetColumns()) {
      sb.append("columns:");
      if (this.columns == null) {
        sb.append("null");
      } else {
        sb.append(this.columns);
      }
      first = false;
    }
    if (isSetSchema_version()) {
      if (!first) sb.append(", ");
      sb.append("schema_version:");
      sb.append(this.schema_version);
      first = false;
    }
    if (isSetSchema_hash()) {
      if (!first) sb.append(", ");
      sb.append("schema_hash:");
      sb.append(this.schema_hash);
      first = false;
    }
    if (isSetShort_key_col_count()) {
      if (!first) sb.append(", ");
      sb.append("short_key_col_count:");
      sb.append(this.short_key_col_count);
      first = false;
    }
    if (isSetStorage_type()) {
      if (!first) sb.append(", ");
      sb.append("storage_type:");
      if (this.storage_type == null) {
        sb.append("null");
      } else {
        sb.append(this.storage_type);
      }
      first = false;
    }
    if (isSetKeys_type()) {
      if (!first) sb.append(", ");
      sb.append("keys_type:");
      if (this.keys_type == null) {
        sb.append("null");
      } else {
        sb.append(this.keys_type);
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

  private static class TSchemaMetaStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TSchemaMetaStandardScheme getScheme() {
      return new TSchemaMetaStandardScheme();
    }
  }

  private static class TSchemaMetaStandardScheme extends org.apache.thrift.scheme.StandardScheme<TSchemaMeta> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TSchemaMeta struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list420 = iprot.readListBegin();
                struct.columns = new java.util.ArrayList<TColumnMeta>(_list420.size);
                @org.apache.thrift.annotation.Nullable TColumnMeta _elem421;
                for (int _i422 = 0; _i422 < _list420.size; ++_i422)
                {
                  _elem421 = new TColumnMeta();
                  _elem421.read(iprot);
                  struct.columns.add(_elem421);
                }
                iprot.readListEnd();
              }
              struct.setColumnsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SCHEMA_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.schema_version = iprot.readI32();
              struct.setSchema_versionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SCHEMA_HASH
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.schema_hash = iprot.readI32();
              struct.setSchema_hashIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SHORT_KEY_COL_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.short_key_col_count = iprot.readI16();
              struct.setShort_key_col_countIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // STORAGE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.storage_type = com.starrocks.thrift.TStorageType.findByValue(iprot.readI32());
              struct.setStorage_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // KEYS_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.keys_type = iprot.readString();
              struct.setKeys_typeIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TSchemaMeta struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.columns != null) {
        if (struct.isSetColumns()) {
          oprot.writeFieldBegin(COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.columns.size()));
            for (TColumnMeta _iter423 : struct.columns)
            {
              _iter423.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetSchema_version()) {
        oprot.writeFieldBegin(SCHEMA_VERSION_FIELD_DESC);
        oprot.writeI32(struct.schema_version);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSchema_hash()) {
        oprot.writeFieldBegin(SCHEMA_HASH_FIELD_DESC);
        oprot.writeI32(struct.schema_hash);
        oprot.writeFieldEnd();
      }
      if (struct.isSetShort_key_col_count()) {
        oprot.writeFieldBegin(SHORT_KEY_COL_COUNT_FIELD_DESC);
        oprot.writeI16(struct.short_key_col_count);
        oprot.writeFieldEnd();
      }
      if (struct.storage_type != null) {
        if (struct.isSetStorage_type()) {
          oprot.writeFieldBegin(STORAGE_TYPE_FIELD_DESC);
          oprot.writeI32(struct.storage_type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.keys_type != null) {
        if (struct.isSetKeys_type()) {
          oprot.writeFieldBegin(KEYS_TYPE_FIELD_DESC);
          oprot.writeString(struct.keys_type);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TSchemaMetaTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TSchemaMetaTupleScheme getScheme() {
      return new TSchemaMetaTupleScheme();
    }
  }

  private static class TSchemaMetaTupleScheme extends org.apache.thrift.scheme.TupleScheme<TSchemaMeta> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TSchemaMeta struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetColumns()) {
        optionals.set(0);
      }
      if (struct.isSetSchema_version()) {
        optionals.set(1);
      }
      if (struct.isSetSchema_hash()) {
        optionals.set(2);
      }
      if (struct.isSetShort_key_col_count()) {
        optionals.set(3);
      }
      if (struct.isSetStorage_type()) {
        optionals.set(4);
      }
      if (struct.isSetKeys_type()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetColumns()) {
        {
          oprot.writeI32(struct.columns.size());
          for (TColumnMeta _iter424 : struct.columns)
          {
            _iter424.write(oprot);
          }
        }
      }
      if (struct.isSetSchema_version()) {
        oprot.writeI32(struct.schema_version);
      }
      if (struct.isSetSchema_hash()) {
        oprot.writeI32(struct.schema_hash);
      }
      if (struct.isSetShort_key_col_count()) {
        oprot.writeI16(struct.short_key_col_count);
      }
      if (struct.isSetStorage_type()) {
        oprot.writeI32(struct.storage_type.getValue());
      }
      if (struct.isSetKeys_type()) {
        oprot.writeString(struct.keys_type);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TSchemaMeta struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list425 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.columns = new java.util.ArrayList<TColumnMeta>(_list425.size);
          @org.apache.thrift.annotation.Nullable TColumnMeta _elem426;
          for (int _i427 = 0; _i427 < _list425.size; ++_i427)
          {
            _elem426 = new TColumnMeta();
            _elem426.read(iprot);
            struct.columns.add(_elem426);
          }
        }
        struct.setColumnsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.schema_version = iprot.readI32();
        struct.setSchema_versionIsSet(true);
      }
      if (incoming.get(2)) {
        struct.schema_hash = iprot.readI32();
        struct.setSchema_hashIsSet(true);
      }
      if (incoming.get(3)) {
        struct.short_key_col_count = iprot.readI16();
        struct.setShort_key_col_countIsSet(true);
      }
      if (incoming.get(4)) {
        struct.storage_type = com.starrocks.thrift.TStorageType.findByValue(iprot.readI32());
        struct.setStorage_typeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.keys_type = iprot.readString();
        struct.setKeys_typeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

