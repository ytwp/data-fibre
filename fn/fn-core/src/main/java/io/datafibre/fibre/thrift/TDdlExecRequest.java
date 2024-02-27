/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TDdlExecRequest implements org.apache.thrift.TBase<TDdlExecRequest, TDdlExecRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TDdlExecRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDdlExecRequest");

  private static final org.apache.thrift.protocol.TField DDL_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("ddl_type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USE_DB_PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("use_db_params", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField DESCRIBE_TABLE_PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("describe_table_params", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField EXPLAIN_PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("explain_params", org.apache.thrift.protocol.TType.STRUCT, (short)10);
  private static final org.apache.thrift.protocol.TField SET_PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("set_params", org.apache.thrift.protocol.TType.STRUCT, (short)11);
  private static final org.apache.thrift.protocol.TField KILL_PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("kill_params", org.apache.thrift.protocol.TType.STRUCT, (short)12);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TDdlExecRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TDdlExecRequestTupleSchemeFactory();

  /**
   * 
   * @see TDdlType
   */
  public @org.apache.thrift.annotation.Nullable TDdlType ddl_type; // required
  public @org.apache.thrift.annotation.Nullable TUseDbParams use_db_params; // optional
  public @org.apache.thrift.annotation.Nullable TDescribeTableParams describe_table_params; // optional
  public @org.apache.thrift.annotation.Nullable TExplainParams explain_params; // optional
  public @org.apache.thrift.annotation.Nullable TSetParams set_params; // optional
  public @org.apache.thrift.annotation.Nullable TKillParams kill_params; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see TDdlType
     */
    DDL_TYPE((short)1, "ddl_type"),
    USE_DB_PARAMS((short)2, "use_db_params"),
    DESCRIBE_TABLE_PARAMS((short)3, "describe_table_params"),
    EXPLAIN_PARAMS((short)10, "explain_params"),
    SET_PARAMS((short)11, "set_params"),
    KILL_PARAMS((short)12, "kill_params");

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
        case 1: // DDL_TYPE
          return DDL_TYPE;
        case 2: // USE_DB_PARAMS
          return USE_DB_PARAMS;
        case 3: // DESCRIBE_TABLE_PARAMS
          return DESCRIBE_TABLE_PARAMS;
        case 10: // EXPLAIN_PARAMS
          return EXPLAIN_PARAMS;
        case 11: // SET_PARAMS
          return SET_PARAMS;
        case 12: // KILL_PARAMS
          return KILL_PARAMS;
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
  private static final _Fields optionals[] = {_Fields.USE_DB_PARAMS,_Fields.DESCRIBE_TABLE_PARAMS,_Fields.EXPLAIN_PARAMS,_Fields.SET_PARAMS,_Fields.KILL_PARAMS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DDL_TYPE, new org.apache.thrift.meta_data.FieldMetaData("ddl_type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TDdlType.class)));
    tmpMap.put(_Fields.USE_DB_PARAMS, new org.apache.thrift.meta_data.FieldMetaData("use_db_params", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TUseDbParams.class)));
    tmpMap.put(_Fields.DESCRIBE_TABLE_PARAMS, new org.apache.thrift.meta_data.FieldMetaData("describe_table_params", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TDescribeTableParams.class)));
    tmpMap.put(_Fields.EXPLAIN_PARAMS, new org.apache.thrift.meta_data.FieldMetaData("explain_params", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TExplainParams.class)));
    tmpMap.put(_Fields.SET_PARAMS, new org.apache.thrift.meta_data.FieldMetaData("set_params", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSetParams.class)));
    tmpMap.put(_Fields.KILL_PARAMS, new org.apache.thrift.meta_data.FieldMetaData("kill_params", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TKillParams.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDdlExecRequest.class, metaDataMap);
  }

  public TDdlExecRequest() {
  }

  public TDdlExecRequest(
    TDdlType ddl_type)
  {
    this();
    this.ddl_type = ddl_type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDdlExecRequest(TDdlExecRequest other) {
    if (other.isSetDdl_type()) {
      this.ddl_type = other.ddl_type;
    }
    if (other.isSetUse_db_params()) {
      this.use_db_params = new TUseDbParams(other.use_db_params);
    }
    if (other.isSetDescribe_table_params()) {
      this.describe_table_params = new TDescribeTableParams(other.describe_table_params);
    }
    if (other.isSetExplain_params()) {
      this.explain_params = new TExplainParams(other.explain_params);
    }
    if (other.isSetSet_params()) {
      this.set_params = new TSetParams(other.set_params);
    }
    if (other.isSetKill_params()) {
      this.kill_params = new TKillParams(other.kill_params);
    }
  }

  @Override
  public TDdlExecRequest deepCopy() {
    return new TDdlExecRequest(this);
  }

  @Override
  public void clear() {
    this.ddl_type = null;
    this.use_db_params = null;
    this.describe_table_params = null;
    this.explain_params = null;
    this.set_params = null;
    this.kill_params = null;
  }

  /**
   * 
   * @see TDdlType
   */
  @org.apache.thrift.annotation.Nullable
  public TDdlType getDdl_type() {
    return this.ddl_type;
  }

  /**
   * 
   * @see TDdlType
   */
  public TDdlExecRequest setDdl_type(@org.apache.thrift.annotation.Nullable TDdlType ddl_type) {
    this.ddl_type = ddl_type;
    return this;
  }

  public void unsetDdl_type() {
    this.ddl_type = null;
  }

  /** Returns true if field ddl_type is set (has been assigned a value) and false otherwise */
  public boolean isSetDdl_type() {
    return this.ddl_type != null;
  }

  public void setDdl_typeIsSet(boolean value) {
    if (!value) {
      this.ddl_type = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TUseDbParams getUse_db_params() {
    return this.use_db_params;
  }

  public TDdlExecRequest setUse_db_params(@org.apache.thrift.annotation.Nullable TUseDbParams use_db_params) {
    this.use_db_params = use_db_params;
    return this;
  }

  public void unsetUse_db_params() {
    this.use_db_params = null;
  }

  /** Returns true if field use_db_params is set (has been assigned a value) and false otherwise */
  public boolean isSetUse_db_params() {
    return this.use_db_params != null;
  }

  public void setUse_db_paramsIsSet(boolean value) {
    if (!value) {
      this.use_db_params = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TDescribeTableParams getDescribe_table_params() {
    return this.describe_table_params;
  }

  public TDdlExecRequest setDescribe_table_params(@org.apache.thrift.annotation.Nullable TDescribeTableParams describe_table_params) {
    this.describe_table_params = describe_table_params;
    return this;
  }

  public void unsetDescribe_table_params() {
    this.describe_table_params = null;
  }

  /** Returns true if field describe_table_params is set (has been assigned a value) and false otherwise */
  public boolean isSetDescribe_table_params() {
    return this.describe_table_params != null;
  }

  public void setDescribe_table_paramsIsSet(boolean value) {
    if (!value) {
      this.describe_table_params = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TExplainParams getExplain_params() {
    return this.explain_params;
  }

  public TDdlExecRequest setExplain_params(@org.apache.thrift.annotation.Nullable TExplainParams explain_params) {
    this.explain_params = explain_params;
    return this;
  }

  public void unsetExplain_params() {
    this.explain_params = null;
  }

  /** Returns true if field explain_params is set (has been assigned a value) and false otherwise */
  public boolean isSetExplain_params() {
    return this.explain_params != null;
  }

  public void setExplain_paramsIsSet(boolean value) {
    if (!value) {
      this.explain_params = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TSetParams getSet_params() {
    return this.set_params;
  }

  public TDdlExecRequest setSet_params(@org.apache.thrift.annotation.Nullable TSetParams set_params) {
    this.set_params = set_params;
    return this;
  }

  public void unsetSet_params() {
    this.set_params = null;
  }

  /** Returns true if field set_params is set (has been assigned a value) and false otherwise */
  public boolean isSetSet_params() {
    return this.set_params != null;
  }

  public void setSet_paramsIsSet(boolean value) {
    if (!value) {
      this.set_params = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TKillParams getKill_params() {
    return this.kill_params;
  }

  public TDdlExecRequest setKill_params(@org.apache.thrift.annotation.Nullable TKillParams kill_params) {
    this.kill_params = kill_params;
    return this;
  }

  public void unsetKill_params() {
    this.kill_params = null;
  }

  /** Returns true if field kill_params is set (has been assigned a value) and false otherwise */
  public boolean isSetKill_params() {
    return this.kill_params != null;
  }

  public void setKill_paramsIsSet(boolean value) {
    if (!value) {
      this.kill_params = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DDL_TYPE:
      if (value == null) {
        unsetDdl_type();
      } else {
        setDdl_type((TDdlType)value);
      }
      break;

    case USE_DB_PARAMS:
      if (value == null) {
        unsetUse_db_params();
      } else {
        setUse_db_params((TUseDbParams)value);
      }
      break;

    case DESCRIBE_TABLE_PARAMS:
      if (value == null) {
        unsetDescribe_table_params();
      } else {
        setDescribe_table_params((TDescribeTableParams)value);
      }
      break;

    case EXPLAIN_PARAMS:
      if (value == null) {
        unsetExplain_params();
      } else {
        setExplain_params((TExplainParams)value);
      }
      break;

    case SET_PARAMS:
      if (value == null) {
        unsetSet_params();
      } else {
        setSet_params((TSetParams)value);
      }
      break;

    case KILL_PARAMS:
      if (value == null) {
        unsetKill_params();
      } else {
        setKill_params((TKillParams)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DDL_TYPE:
      return getDdl_type();

    case USE_DB_PARAMS:
      return getUse_db_params();

    case DESCRIBE_TABLE_PARAMS:
      return getDescribe_table_params();

    case EXPLAIN_PARAMS:
      return getExplain_params();

    case SET_PARAMS:
      return getSet_params();

    case KILL_PARAMS:
      return getKill_params();

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
    case DDL_TYPE:
      return isSetDdl_type();
    case USE_DB_PARAMS:
      return isSetUse_db_params();
    case DESCRIBE_TABLE_PARAMS:
      return isSetDescribe_table_params();
    case EXPLAIN_PARAMS:
      return isSetExplain_params();
    case SET_PARAMS:
      return isSetSet_params();
    case KILL_PARAMS:
      return isSetKill_params();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TDdlExecRequest)
      return this.equals((TDdlExecRequest)that);
    return false;
  }

  public boolean equals(TDdlExecRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_ddl_type = true && this.isSetDdl_type();
    boolean that_present_ddl_type = true && that.isSetDdl_type();
    if (this_present_ddl_type || that_present_ddl_type) {
      if (!(this_present_ddl_type && that_present_ddl_type))
        return false;
      if (!this.ddl_type.equals(that.ddl_type))
        return false;
    }

    boolean this_present_use_db_params = true && this.isSetUse_db_params();
    boolean that_present_use_db_params = true && that.isSetUse_db_params();
    if (this_present_use_db_params || that_present_use_db_params) {
      if (!(this_present_use_db_params && that_present_use_db_params))
        return false;
      if (!this.use_db_params.equals(that.use_db_params))
        return false;
    }

    boolean this_present_describe_table_params = true && this.isSetDescribe_table_params();
    boolean that_present_describe_table_params = true && that.isSetDescribe_table_params();
    if (this_present_describe_table_params || that_present_describe_table_params) {
      if (!(this_present_describe_table_params && that_present_describe_table_params))
        return false;
      if (!this.describe_table_params.equals(that.describe_table_params))
        return false;
    }

    boolean this_present_explain_params = true && this.isSetExplain_params();
    boolean that_present_explain_params = true && that.isSetExplain_params();
    if (this_present_explain_params || that_present_explain_params) {
      if (!(this_present_explain_params && that_present_explain_params))
        return false;
      if (!this.explain_params.equals(that.explain_params))
        return false;
    }

    boolean this_present_set_params = true && this.isSetSet_params();
    boolean that_present_set_params = true && that.isSetSet_params();
    if (this_present_set_params || that_present_set_params) {
      if (!(this_present_set_params && that_present_set_params))
        return false;
      if (!this.set_params.equals(that.set_params))
        return false;
    }

    boolean this_present_kill_params = true && this.isSetKill_params();
    boolean that_present_kill_params = true && that.isSetKill_params();
    if (this_present_kill_params || that_present_kill_params) {
      if (!(this_present_kill_params && that_present_kill_params))
        return false;
      if (!this.kill_params.equals(that.kill_params))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDdl_type()) ? 131071 : 524287);
    if (isSetDdl_type())
      hashCode = hashCode * 8191 + ddl_type.getValue();

    hashCode = hashCode * 8191 + ((isSetUse_db_params()) ? 131071 : 524287);
    if (isSetUse_db_params())
      hashCode = hashCode * 8191 + use_db_params.hashCode();

    hashCode = hashCode * 8191 + ((isSetDescribe_table_params()) ? 131071 : 524287);
    if (isSetDescribe_table_params())
      hashCode = hashCode * 8191 + describe_table_params.hashCode();

    hashCode = hashCode * 8191 + ((isSetExplain_params()) ? 131071 : 524287);
    if (isSetExplain_params())
      hashCode = hashCode * 8191 + explain_params.hashCode();

    hashCode = hashCode * 8191 + ((isSetSet_params()) ? 131071 : 524287);
    if (isSetSet_params())
      hashCode = hashCode * 8191 + set_params.hashCode();

    hashCode = hashCode * 8191 + ((isSetKill_params()) ? 131071 : 524287);
    if (isSetKill_params())
      hashCode = hashCode * 8191 + kill_params.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TDdlExecRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDdl_type(), other.isSetDdl_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDdl_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ddl_type, other.ddl_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetUse_db_params(), other.isSetUse_db_params());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUse_db_params()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.use_db_params, other.use_db_params);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDescribe_table_params(), other.isSetDescribe_table_params());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescribe_table_params()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.describe_table_params, other.describe_table_params);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetExplain_params(), other.isSetExplain_params());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExplain_params()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.explain_params, other.explain_params);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetSet_params(), other.isSetSet_params());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSet_params()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.set_params, other.set_params);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetKill_params(), other.isSetKill_params());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKill_params()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.kill_params, other.kill_params);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TDdlExecRequest(");
    boolean first = true;

    sb.append("ddl_type:");
    if (this.ddl_type == null) {
      sb.append("null");
    } else {
      sb.append(this.ddl_type);
    }
    first = false;
    if (isSetUse_db_params()) {
      if (!first) sb.append(", ");
      sb.append("use_db_params:");
      if (this.use_db_params == null) {
        sb.append("null");
      } else {
        sb.append(this.use_db_params);
      }
      first = false;
    }
    if (isSetDescribe_table_params()) {
      if (!first) sb.append(", ");
      sb.append("describe_table_params:");
      if (this.describe_table_params == null) {
        sb.append("null");
      } else {
        sb.append(this.describe_table_params);
      }
      first = false;
    }
    if (isSetExplain_params()) {
      if (!first) sb.append(", ");
      sb.append("explain_params:");
      if (this.explain_params == null) {
        sb.append("null");
      } else {
        sb.append(this.explain_params);
      }
      first = false;
    }
    if (isSetSet_params()) {
      if (!first) sb.append(", ");
      sb.append("set_params:");
      if (this.set_params == null) {
        sb.append("null");
      } else {
        sb.append(this.set_params);
      }
      first = false;
    }
    if (isSetKill_params()) {
      if (!first) sb.append(", ");
      sb.append("kill_params:");
      if (this.kill_params == null) {
        sb.append("null");
      } else {
        sb.append(this.kill_params);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (ddl_type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'ddl_type' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (use_db_params != null) {
      use_db_params.validate();
    }
    if (describe_table_params != null) {
      describe_table_params.validate();
    }
    if (explain_params != null) {
      explain_params.validate();
    }
    if (set_params != null) {
      set_params.validate();
    }
    if (kill_params != null) {
      kill_params.validate();
    }
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

  private static class TDdlExecRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TDdlExecRequestStandardScheme getScheme() {
      return new TDdlExecRequestStandardScheme();
    }
  }

  private static class TDdlExecRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<TDdlExecRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TDdlExecRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DDL_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ddl_type = com.starrocks.thrift.TDdlType.findByValue(iprot.readI32());
              struct.setDdl_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USE_DB_PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.use_db_params = new TUseDbParams();
              struct.use_db_params.read(iprot);
              struct.setUse_db_paramsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DESCRIBE_TABLE_PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.describe_table_params = new TDescribeTableParams();
              struct.describe_table_params.read(iprot);
              struct.setDescribe_table_paramsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 10: // EXPLAIN_PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.explain_params = new TExplainParams();
              struct.explain_params.read(iprot);
              struct.setExplain_paramsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 11: // SET_PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.set_params = new TSetParams();
              struct.set_params.read(iprot);
              struct.setSet_paramsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 12: // KILL_PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.kill_params = new TKillParams();
              struct.kill_params.read(iprot);
              struct.setKill_paramsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TDdlExecRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ddl_type != null) {
        oprot.writeFieldBegin(DDL_TYPE_FIELD_DESC);
        oprot.writeI32(struct.ddl_type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.use_db_params != null) {
        if (struct.isSetUse_db_params()) {
          oprot.writeFieldBegin(USE_DB_PARAMS_FIELD_DESC);
          struct.use_db_params.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.describe_table_params != null) {
        if (struct.isSetDescribe_table_params()) {
          oprot.writeFieldBegin(DESCRIBE_TABLE_PARAMS_FIELD_DESC);
          struct.describe_table_params.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.explain_params != null) {
        if (struct.isSetExplain_params()) {
          oprot.writeFieldBegin(EXPLAIN_PARAMS_FIELD_DESC);
          struct.explain_params.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.set_params != null) {
        if (struct.isSetSet_params()) {
          oprot.writeFieldBegin(SET_PARAMS_FIELD_DESC);
          struct.set_params.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.kill_params != null) {
        if (struct.isSetKill_params()) {
          oprot.writeFieldBegin(KILL_PARAMS_FIELD_DESC);
          struct.kill_params.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDdlExecRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TDdlExecRequestTupleScheme getScheme() {
      return new TDdlExecRequestTupleScheme();
    }
  }

  private static class TDdlExecRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<TDdlExecRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDdlExecRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.ddl_type.getValue());
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetUse_db_params()) {
        optionals.set(0);
      }
      if (struct.isSetDescribe_table_params()) {
        optionals.set(1);
      }
      if (struct.isSetExplain_params()) {
        optionals.set(2);
      }
      if (struct.isSetSet_params()) {
        optionals.set(3);
      }
      if (struct.isSetKill_params()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetUse_db_params()) {
        struct.use_db_params.write(oprot);
      }
      if (struct.isSetDescribe_table_params()) {
        struct.describe_table_params.write(oprot);
      }
      if (struct.isSetExplain_params()) {
        struct.explain_params.write(oprot);
      }
      if (struct.isSetSet_params()) {
        struct.set_params.write(oprot);
      }
      if (struct.isSetKill_params()) {
        struct.kill_params.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDdlExecRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.ddl_type = com.starrocks.thrift.TDdlType.findByValue(iprot.readI32());
      struct.setDdl_typeIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.use_db_params = new TUseDbParams();
        struct.use_db_params.read(iprot);
        struct.setUse_db_paramsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.describe_table_params = new TDescribeTableParams();
        struct.describe_table_params.read(iprot);
        struct.setDescribe_table_paramsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.explain_params = new TExplainParams();
        struct.explain_params.read(iprot);
        struct.setExplain_paramsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.set_params = new TSetParams();
        struct.set_params.read(iprot);
        struct.setSet_paramsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.kill_params = new TKillParams();
        struct.kill_params.read(iprot);
        struct.setKill_paramsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

