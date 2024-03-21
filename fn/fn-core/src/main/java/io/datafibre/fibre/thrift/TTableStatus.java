/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TTableStatus implements org.apache.thrift.TBase<TTableStatus, TTableStatus._Fields>, java.io.Serializable, Cloneable, Comparable<TTableStatus> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTableStatus");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField COMMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("comment", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ENGINE_FIELD_DESC = new org.apache.thrift.protocol.TField("engine", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField LAST_CHECK_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("last_check_time", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("create_time", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField DDL_SQL_FIELD_DESC = new org.apache.thrift.protocol.TField("ddl_sql", org.apache.thrift.protocol.TType.STRING, (short)20);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTableStatusStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTableStatusTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String name; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String type; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String comment; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String engine; // optional
  public long last_check_time; // optional
  public long create_time; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String ddl_sql; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    TYPE((short)2, "type"),
    COMMENT((short)3, "comment"),
    ENGINE((short)4, "engine"),
    LAST_CHECK_TIME((short)5, "last_check_time"),
    CREATE_TIME((short)6, "create_time"),
    DDL_SQL((short)20, "ddl_sql");

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
        case 1: // NAME
          return NAME;
        case 2: // TYPE
          return TYPE;
        case 3: // COMMENT
          return COMMENT;
        case 4: // ENGINE
          return ENGINE;
        case 5: // LAST_CHECK_TIME
          return LAST_CHECK_TIME;
        case 6: // CREATE_TIME
          return CREATE_TIME;
        case 20: // DDL_SQL
          return DDL_SQL;
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
  private static final int __LAST_CHECK_TIME_ISSET_ID = 0;
  private static final int __CREATE_TIME_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.ENGINE,_Fields.LAST_CHECK_TIME,_Fields.CREATE_TIME,_Fields.DDL_SQL};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COMMENT, new org.apache.thrift.meta_data.FieldMetaData("comment", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ENGINE, new org.apache.thrift.meta_data.FieldMetaData("engine", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LAST_CHECK_TIME, new org.apache.thrift.meta_data.FieldMetaData("last_check_time", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.CREATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("create_time", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DDL_SQL, new org.apache.thrift.meta_data.FieldMetaData("ddl_sql", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTableStatus.class, metaDataMap);
  }

  public TTableStatus() {
  }

  public TTableStatus(
    java.lang.String name,
    java.lang.String type,
    java.lang.String comment)
  {
    this();
    this.name = name;
    this.type = type;
    this.comment = comment;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTableStatus(TTableStatus other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetComment()) {
      this.comment = other.comment;
    }
    if (other.isSetEngine()) {
      this.engine = other.engine;
    }
    this.last_check_time = other.last_check_time;
    this.create_time = other.create_time;
    if (other.isSetDdl_sql()) {
      this.ddl_sql = other.ddl_sql;
    }
  }

  @Override
  public TTableStatus deepCopy() {
    return new TTableStatus(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.type = null;
    this.comment = null;
    this.engine = null;
    setLast_check_timeIsSet(false);
    this.last_check_time = 0;
    setCreate_timeIsSet(false);
    this.create_time = 0;
    this.ddl_sql = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getName() {
    return this.name;
  }

  public TTableStatus setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getType() {
    return this.type;
  }

  public TTableStatus setType(@org.apache.thrift.annotation.Nullable java.lang.String type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getComment() {
    return this.comment;
  }

  public TTableStatus setComment(@org.apache.thrift.annotation.Nullable java.lang.String comment) {
    this.comment = comment;
    return this;
  }

  public void unsetComment() {
    this.comment = null;
  }

  /** Returns true if field comment is set (has been assigned a value) and false otherwise */
  public boolean isSetComment() {
    return this.comment != null;
  }

  public void setCommentIsSet(boolean value) {
    if (!value) {
      this.comment = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEngine() {
    return this.engine;
  }

  public TTableStatus setEngine(@org.apache.thrift.annotation.Nullable java.lang.String engine) {
    this.engine = engine;
    return this;
  }

  public void unsetEngine() {
    this.engine = null;
  }

  /** Returns true if field engine is set (has been assigned a value) and false otherwise */
  public boolean isSetEngine() {
    return this.engine != null;
  }

  public void setEngineIsSet(boolean value) {
    if (!value) {
      this.engine = null;
    }
  }

  public long getLast_check_time() {
    return this.last_check_time;
  }

  public TTableStatus setLast_check_time(long last_check_time) {
    this.last_check_time = last_check_time;
    setLast_check_timeIsSet(true);
    return this;
  }

  public void unsetLast_check_time() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LAST_CHECK_TIME_ISSET_ID);
  }

  /** Returns true if field last_check_time is set (has been assigned a value) and false otherwise */
  public boolean isSetLast_check_time() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LAST_CHECK_TIME_ISSET_ID);
  }

  public void setLast_check_timeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LAST_CHECK_TIME_ISSET_ID, value);
  }

  public long getCreate_time() {
    return this.create_time;
  }

  public TTableStatus setCreate_time(long create_time) {
    this.create_time = create_time;
    setCreate_timeIsSet(true);
    return this;
  }

  public void unsetCreate_time() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CREATE_TIME_ISSET_ID);
  }

  /** Returns true if field create_time is set (has been assigned a value) and false otherwise */
  public boolean isSetCreate_time() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CREATE_TIME_ISSET_ID);
  }

  public void setCreate_timeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CREATE_TIME_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDdl_sql() {
    return this.ddl_sql;
  }

  public TTableStatus setDdl_sql(@org.apache.thrift.annotation.Nullable java.lang.String ddl_sql) {
    this.ddl_sql = ddl_sql;
    return this;
  }

  public void unsetDdl_sql() {
    this.ddl_sql = null;
  }

  /** Returns true if field ddl_sql is set (has been assigned a value) and false otherwise */
  public boolean isSetDdl_sql() {
    return this.ddl_sql != null;
  }

  public void setDdl_sqlIsSet(boolean value) {
    if (!value) {
      this.ddl_sql = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((java.lang.String)value);
      }
      break;

    case COMMENT:
      if (value == null) {
        unsetComment();
      } else {
        setComment((java.lang.String)value);
      }
      break;

    case ENGINE:
      if (value == null) {
        unsetEngine();
      } else {
        setEngine((java.lang.String)value);
      }
      break;

    case LAST_CHECK_TIME:
      if (value == null) {
        unsetLast_check_time();
      } else {
        setLast_check_time((java.lang.Long)value);
      }
      break;

    case CREATE_TIME:
      if (value == null) {
        unsetCreate_time();
      } else {
        setCreate_time((java.lang.Long)value);
      }
      break;

    case DDL_SQL:
      if (value == null) {
        unsetDdl_sql();
      } else {
        setDdl_sql((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case TYPE:
      return getType();

    case COMMENT:
      return getComment();

    case ENGINE:
      return getEngine();

    case LAST_CHECK_TIME:
      return getLast_check_time();

    case CREATE_TIME:
      return getCreate_time();

    case DDL_SQL:
      return getDdl_sql();

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
    case NAME:
      return isSetName();
    case TYPE:
      return isSetType();
    case COMMENT:
      return isSetComment();
    case ENGINE:
      return isSetEngine();
    case LAST_CHECK_TIME:
      return isSetLast_check_time();
    case CREATE_TIME:
      return isSetCreate_time();
    case DDL_SQL:
      return isSetDdl_sql();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TTableStatus)
      return this.equals((TTableStatus)that);
    return false;
  }

  public boolean equals(TTableStatus that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_comment = true && this.isSetComment();
    boolean that_present_comment = true && that.isSetComment();
    if (this_present_comment || that_present_comment) {
      if (!(this_present_comment && that_present_comment))
        return false;
      if (!this.comment.equals(that.comment))
        return false;
    }

    boolean this_present_engine = true && this.isSetEngine();
    boolean that_present_engine = true && that.isSetEngine();
    if (this_present_engine || that_present_engine) {
      if (!(this_present_engine && that_present_engine))
        return false;
      if (!this.engine.equals(that.engine))
        return false;
    }

    boolean this_present_last_check_time = true && this.isSetLast_check_time();
    boolean that_present_last_check_time = true && that.isSetLast_check_time();
    if (this_present_last_check_time || that_present_last_check_time) {
      if (!(this_present_last_check_time && that_present_last_check_time))
        return false;
      if (this.last_check_time != that.last_check_time)
        return false;
    }

    boolean this_present_create_time = true && this.isSetCreate_time();
    boolean that_present_create_time = true && that.isSetCreate_time();
    if (this_present_create_time || that_present_create_time) {
      if (!(this_present_create_time && that_present_create_time))
        return false;
      if (this.create_time != that.create_time)
        return false;
    }

    boolean this_present_ddl_sql = true && this.isSetDdl_sql();
    boolean that_present_ddl_sql = true && that.isSetDdl_sql();
    if (this_present_ddl_sql || that_present_ddl_sql) {
      if (!(this_present_ddl_sql && that_present_ddl_sql))
        return false;
      if (!this.ddl_sql.equals(that.ddl_sql))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.hashCode();

    hashCode = hashCode * 8191 + ((isSetComment()) ? 131071 : 524287);
    if (isSetComment())
      hashCode = hashCode * 8191 + comment.hashCode();

    hashCode = hashCode * 8191 + ((isSetEngine()) ? 131071 : 524287);
    if (isSetEngine())
      hashCode = hashCode * 8191 + engine.hashCode();

    hashCode = hashCode * 8191 + ((isSetLast_check_time()) ? 131071 : 524287);
    if (isSetLast_check_time())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(last_check_time);

    hashCode = hashCode * 8191 + ((isSetCreate_time()) ? 131071 : 524287);
    if (isSetCreate_time())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(create_time);

    hashCode = hashCode * 8191 + ((isSetDdl_sql()) ? 131071 : 524287);
    if (isSetDdl_sql())
      hashCode = hashCode * 8191 + ddl_sql.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TTableStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetName(), other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetType(), other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetComment(), other.isSetComment());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComment()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.comment, other.comment);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEngine(), other.isSetEngine());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEngine()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.engine, other.engine);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetLast_check_time(), other.isSetLast_check_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLast_check_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.last_check_time, other.last_check_time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCreate_time(), other.isSetCreate_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreate_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.create_time, other.create_time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDdl_sql(), other.isSetDdl_sql());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDdl_sql()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ddl_sql, other.ddl_sql);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTableStatus(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("comment:");
    if (this.comment == null) {
      sb.append("null");
    } else {
      sb.append(this.comment);
    }
    first = false;
    if (isSetEngine()) {
      if (!first) sb.append(", ");
      sb.append("engine:");
      if (this.engine == null) {
        sb.append("null");
      } else {
        sb.append(this.engine);
      }
      first = false;
    }
    if (isSetLast_check_time()) {
      if (!first) sb.append(", ");
      sb.append("last_check_time:");
      sb.append(this.last_check_time);
      first = false;
    }
    if (isSetCreate_time()) {
      if (!first) sb.append(", ");
      sb.append("create_time:");
      sb.append(this.create_time);
      first = false;
    }
    if (isSetDdl_sql()) {
      if (!first) sb.append(", ");
      sb.append("ddl_sql:");
      if (this.ddl_sql == null) {
        sb.append("null");
      } else {
        sb.append(this.ddl_sql);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'name' was not present! Struct: " + toString());
    }
    if (type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'type' was not present! Struct: " + toString());
    }
    if (comment == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'comment' was not present! Struct: " + toString());
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

  private static class TTableStatusStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTableStatusStandardScheme getScheme() {
      return new TTableStatusStandardScheme();
    }
  }

  private static class TTableStatusStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTableStatus> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TTableStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.type = iprot.readString();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COMMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.comment = iprot.readString();
              struct.setCommentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ENGINE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.engine = iprot.readString();
              struct.setEngineIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LAST_CHECK_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.last_check_time = iprot.readI64();
              struct.setLast_check_timeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // CREATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.create_time = iprot.readI64();
              struct.setCreate_timeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 20: // DDL_SQL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ddl_sql = iprot.readString();
              struct.setDdl_sqlIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TTableStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeString(struct.type);
        oprot.writeFieldEnd();
      }
      if (struct.comment != null) {
        oprot.writeFieldBegin(COMMENT_FIELD_DESC);
        oprot.writeString(struct.comment);
        oprot.writeFieldEnd();
      }
      if (struct.engine != null) {
        if (struct.isSetEngine()) {
          oprot.writeFieldBegin(ENGINE_FIELD_DESC);
          oprot.writeString(struct.engine);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetLast_check_time()) {
        oprot.writeFieldBegin(LAST_CHECK_TIME_FIELD_DESC);
        oprot.writeI64(struct.last_check_time);
        oprot.writeFieldEnd();
      }
      if (struct.isSetCreate_time()) {
        oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
        oprot.writeI64(struct.create_time);
        oprot.writeFieldEnd();
      }
      if (struct.ddl_sql != null) {
        if (struct.isSetDdl_sql()) {
          oprot.writeFieldBegin(DDL_SQL_FIELD_DESC);
          oprot.writeString(struct.ddl_sql);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTableStatusTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTableStatusTupleScheme getScheme() {
      return new TTableStatusTupleScheme();
    }
  }

  private static class TTableStatusTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTableStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTableStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.name);
      oprot.writeString(struct.type);
      oprot.writeString(struct.comment);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetEngine()) {
        optionals.set(0);
      }
      if (struct.isSetLast_check_time()) {
        optionals.set(1);
      }
      if (struct.isSetCreate_time()) {
        optionals.set(2);
      }
      if (struct.isSetDdl_sql()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetEngine()) {
        oprot.writeString(struct.engine);
      }
      if (struct.isSetLast_check_time()) {
        oprot.writeI64(struct.last_check_time);
      }
      if (struct.isSetCreate_time()) {
        oprot.writeI64(struct.create_time);
      }
      if (struct.isSetDdl_sql()) {
        oprot.writeString(struct.ddl_sql);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTableStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.name = iprot.readString();
      struct.setNameIsSet(true);
      struct.type = iprot.readString();
      struct.setTypeIsSet(true);
      struct.comment = iprot.readString();
      struct.setCommentIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.engine = iprot.readString();
        struct.setEngineIsSet(true);
      }
      if (incoming.get(1)) {
        struct.last_check_time = iprot.readI64();
        struct.setLast_check_timeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.create_time = iprot.readI64();
        struct.setCreate_timeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ddl_sql = iprot.readString();
        struct.setDdl_sqlIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
