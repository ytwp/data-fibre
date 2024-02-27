/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TJDBCTable implements org.apache.thrift.TBase<TJDBCTable, TJDBCTable._Fields>, java.io.Serializable, Cloneable, Comparable<TJDBCTable> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TJDBCTable");

  private static final org.apache.thrift.protocol.TField JDBC_DRIVER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_driver_name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField JDBC_DRIVER_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_driver_url", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField JDBC_DRIVER_CHECKSUM_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_driver_checksum", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField JDBC_DRIVER_CLASS_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_driver_class", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField JDBC_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_url", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField JDBC_TABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_table", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField JDBC_USER_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_user", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField JDBC_PASSWD_FIELD_DESC = new org.apache.thrift.protocol.TField("jdbc_passwd", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TJDBCTableStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TJDBCTableTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_name; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_url; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_checksum; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_class; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_url; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_table; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_user; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String jdbc_passwd; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    JDBC_DRIVER_NAME((short)1, "jdbc_driver_name"),
    JDBC_DRIVER_URL((short)2, "jdbc_driver_url"),
    JDBC_DRIVER_CHECKSUM((short)3, "jdbc_driver_checksum"),
    JDBC_DRIVER_CLASS((short)4, "jdbc_driver_class"),
    JDBC_URL((short)5, "jdbc_url"),
    JDBC_TABLE((short)6, "jdbc_table"),
    JDBC_USER((short)7, "jdbc_user"),
    JDBC_PASSWD((short)8, "jdbc_passwd");

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
        case 1: // JDBC_DRIVER_NAME
          return JDBC_DRIVER_NAME;
        case 2: // JDBC_DRIVER_URL
          return JDBC_DRIVER_URL;
        case 3: // JDBC_DRIVER_CHECKSUM
          return JDBC_DRIVER_CHECKSUM;
        case 4: // JDBC_DRIVER_CLASS
          return JDBC_DRIVER_CLASS;
        case 5: // JDBC_URL
          return JDBC_URL;
        case 6: // JDBC_TABLE
          return JDBC_TABLE;
        case 7: // JDBC_USER
          return JDBC_USER;
        case 8: // JDBC_PASSWD
          return JDBC_PASSWD;
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
  private static final _Fields optionals[] = {_Fields.JDBC_DRIVER_NAME,_Fields.JDBC_DRIVER_URL,_Fields.JDBC_DRIVER_CHECKSUM,_Fields.JDBC_DRIVER_CLASS,_Fields.JDBC_URL,_Fields.JDBC_TABLE,_Fields.JDBC_USER,_Fields.JDBC_PASSWD};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JDBC_DRIVER_NAME, new org.apache.thrift.meta_data.FieldMetaData("jdbc_driver_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.JDBC_DRIVER_URL, new org.apache.thrift.meta_data.FieldMetaData("jdbc_driver_url", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.JDBC_DRIVER_CHECKSUM, new org.apache.thrift.meta_data.FieldMetaData("jdbc_driver_checksum", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.JDBC_DRIVER_CLASS, new org.apache.thrift.meta_data.FieldMetaData("jdbc_driver_class", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.JDBC_URL, new org.apache.thrift.meta_data.FieldMetaData("jdbc_url", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.JDBC_TABLE, new org.apache.thrift.meta_data.FieldMetaData("jdbc_table", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.JDBC_USER, new org.apache.thrift.meta_data.FieldMetaData("jdbc_user", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.JDBC_PASSWD, new org.apache.thrift.meta_data.FieldMetaData("jdbc_passwd", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TJDBCTable.class, metaDataMap);
  }

  public TJDBCTable() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TJDBCTable(TJDBCTable other) {
    if (other.isSetJdbc_driver_name()) {
      this.jdbc_driver_name = other.jdbc_driver_name;
    }
    if (other.isSetJdbc_driver_url()) {
      this.jdbc_driver_url = other.jdbc_driver_url;
    }
    if (other.isSetJdbc_driver_checksum()) {
      this.jdbc_driver_checksum = other.jdbc_driver_checksum;
    }
    if (other.isSetJdbc_driver_class()) {
      this.jdbc_driver_class = other.jdbc_driver_class;
    }
    if (other.isSetJdbc_url()) {
      this.jdbc_url = other.jdbc_url;
    }
    if (other.isSetJdbc_table()) {
      this.jdbc_table = other.jdbc_table;
    }
    if (other.isSetJdbc_user()) {
      this.jdbc_user = other.jdbc_user;
    }
    if (other.isSetJdbc_passwd()) {
      this.jdbc_passwd = other.jdbc_passwd;
    }
  }

  @Override
  public TJDBCTable deepCopy() {
    return new TJDBCTable(this);
  }

  @Override
  public void clear() {
    this.jdbc_driver_name = null;
    this.jdbc_driver_url = null;
    this.jdbc_driver_checksum = null;
    this.jdbc_driver_class = null;
    this.jdbc_url = null;
    this.jdbc_table = null;
    this.jdbc_user = null;
    this.jdbc_passwd = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_driver_name() {
    return this.jdbc_driver_name;
  }

  public TJDBCTable setJdbc_driver_name(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_name) {
    this.jdbc_driver_name = jdbc_driver_name;
    return this;
  }

  public void unsetJdbc_driver_name() {
    this.jdbc_driver_name = null;
  }

  /** Returns true if field jdbc_driver_name is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_driver_name() {
    return this.jdbc_driver_name != null;
  }

  public void setJdbc_driver_nameIsSet(boolean value) {
    if (!value) {
      this.jdbc_driver_name = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_driver_url() {
    return this.jdbc_driver_url;
  }

  public TJDBCTable setJdbc_driver_url(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_url) {
    this.jdbc_driver_url = jdbc_driver_url;
    return this;
  }

  public void unsetJdbc_driver_url() {
    this.jdbc_driver_url = null;
  }

  /** Returns true if field jdbc_driver_url is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_driver_url() {
    return this.jdbc_driver_url != null;
  }

  public void setJdbc_driver_urlIsSet(boolean value) {
    if (!value) {
      this.jdbc_driver_url = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_driver_checksum() {
    return this.jdbc_driver_checksum;
  }

  public TJDBCTable setJdbc_driver_checksum(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_checksum) {
    this.jdbc_driver_checksum = jdbc_driver_checksum;
    return this;
  }

  public void unsetJdbc_driver_checksum() {
    this.jdbc_driver_checksum = null;
  }

  /** Returns true if field jdbc_driver_checksum is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_driver_checksum() {
    return this.jdbc_driver_checksum != null;
  }

  public void setJdbc_driver_checksumIsSet(boolean value) {
    if (!value) {
      this.jdbc_driver_checksum = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_driver_class() {
    return this.jdbc_driver_class;
  }

  public TJDBCTable setJdbc_driver_class(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_driver_class) {
    this.jdbc_driver_class = jdbc_driver_class;
    return this;
  }

  public void unsetJdbc_driver_class() {
    this.jdbc_driver_class = null;
  }

  /** Returns true if field jdbc_driver_class is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_driver_class() {
    return this.jdbc_driver_class != null;
  }

  public void setJdbc_driver_classIsSet(boolean value) {
    if (!value) {
      this.jdbc_driver_class = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_url() {
    return this.jdbc_url;
  }

  public TJDBCTable setJdbc_url(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_url) {
    this.jdbc_url = jdbc_url;
    return this;
  }

  public void unsetJdbc_url() {
    this.jdbc_url = null;
  }

  /** Returns true if field jdbc_url is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_url() {
    return this.jdbc_url != null;
  }

  public void setJdbc_urlIsSet(boolean value) {
    if (!value) {
      this.jdbc_url = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_table() {
    return this.jdbc_table;
  }

  public TJDBCTable setJdbc_table(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_table) {
    this.jdbc_table = jdbc_table;
    return this;
  }

  public void unsetJdbc_table() {
    this.jdbc_table = null;
  }

  /** Returns true if field jdbc_table is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_table() {
    return this.jdbc_table != null;
  }

  public void setJdbc_tableIsSet(boolean value) {
    if (!value) {
      this.jdbc_table = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_user() {
    return this.jdbc_user;
  }

  public TJDBCTable setJdbc_user(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_user) {
    this.jdbc_user = jdbc_user;
    return this;
  }

  public void unsetJdbc_user() {
    this.jdbc_user = null;
  }

  /** Returns true if field jdbc_user is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_user() {
    return this.jdbc_user != null;
  }

  public void setJdbc_userIsSet(boolean value) {
    if (!value) {
      this.jdbc_user = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJdbc_passwd() {
    return this.jdbc_passwd;
  }

  public TJDBCTable setJdbc_passwd(@org.apache.thrift.annotation.Nullable java.lang.String jdbc_passwd) {
    this.jdbc_passwd = jdbc_passwd;
    return this;
  }

  public void unsetJdbc_passwd() {
    this.jdbc_passwd = null;
  }

  /** Returns true if field jdbc_passwd is set (has been assigned a value) and false otherwise */
  public boolean isSetJdbc_passwd() {
    return this.jdbc_passwd != null;
  }

  public void setJdbc_passwdIsSet(boolean value) {
    if (!value) {
      this.jdbc_passwd = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case JDBC_DRIVER_NAME:
      if (value == null) {
        unsetJdbc_driver_name();
      } else {
        setJdbc_driver_name((java.lang.String)value);
      }
      break;

    case JDBC_DRIVER_URL:
      if (value == null) {
        unsetJdbc_driver_url();
      } else {
        setJdbc_driver_url((java.lang.String)value);
      }
      break;

    case JDBC_DRIVER_CHECKSUM:
      if (value == null) {
        unsetJdbc_driver_checksum();
      } else {
        setJdbc_driver_checksum((java.lang.String)value);
      }
      break;

    case JDBC_DRIVER_CLASS:
      if (value == null) {
        unsetJdbc_driver_class();
      } else {
        setJdbc_driver_class((java.lang.String)value);
      }
      break;

    case JDBC_URL:
      if (value == null) {
        unsetJdbc_url();
      } else {
        setJdbc_url((java.lang.String)value);
      }
      break;

    case JDBC_TABLE:
      if (value == null) {
        unsetJdbc_table();
      } else {
        setJdbc_table((java.lang.String)value);
      }
      break;

    case JDBC_USER:
      if (value == null) {
        unsetJdbc_user();
      } else {
        setJdbc_user((java.lang.String)value);
      }
      break;

    case JDBC_PASSWD:
      if (value == null) {
        unsetJdbc_passwd();
      } else {
        setJdbc_passwd((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case JDBC_DRIVER_NAME:
      return getJdbc_driver_name();

    case JDBC_DRIVER_URL:
      return getJdbc_driver_url();

    case JDBC_DRIVER_CHECKSUM:
      return getJdbc_driver_checksum();

    case JDBC_DRIVER_CLASS:
      return getJdbc_driver_class();

    case JDBC_URL:
      return getJdbc_url();

    case JDBC_TABLE:
      return getJdbc_table();

    case JDBC_USER:
      return getJdbc_user();

    case JDBC_PASSWD:
      return getJdbc_passwd();

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
    case JDBC_DRIVER_NAME:
      return isSetJdbc_driver_name();
    case JDBC_DRIVER_URL:
      return isSetJdbc_driver_url();
    case JDBC_DRIVER_CHECKSUM:
      return isSetJdbc_driver_checksum();
    case JDBC_DRIVER_CLASS:
      return isSetJdbc_driver_class();
    case JDBC_URL:
      return isSetJdbc_url();
    case JDBC_TABLE:
      return isSetJdbc_table();
    case JDBC_USER:
      return isSetJdbc_user();
    case JDBC_PASSWD:
      return isSetJdbc_passwd();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TJDBCTable)
      return this.equals((TJDBCTable)that);
    return false;
  }

  public boolean equals(TJDBCTable that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_jdbc_driver_name = true && this.isSetJdbc_driver_name();
    boolean that_present_jdbc_driver_name = true && that.isSetJdbc_driver_name();
    if (this_present_jdbc_driver_name || that_present_jdbc_driver_name) {
      if (!(this_present_jdbc_driver_name && that_present_jdbc_driver_name))
        return false;
      if (!this.jdbc_driver_name.equals(that.jdbc_driver_name))
        return false;
    }

    boolean this_present_jdbc_driver_url = true && this.isSetJdbc_driver_url();
    boolean that_present_jdbc_driver_url = true && that.isSetJdbc_driver_url();
    if (this_present_jdbc_driver_url || that_present_jdbc_driver_url) {
      if (!(this_present_jdbc_driver_url && that_present_jdbc_driver_url))
        return false;
      if (!this.jdbc_driver_url.equals(that.jdbc_driver_url))
        return false;
    }

    boolean this_present_jdbc_driver_checksum = true && this.isSetJdbc_driver_checksum();
    boolean that_present_jdbc_driver_checksum = true && that.isSetJdbc_driver_checksum();
    if (this_present_jdbc_driver_checksum || that_present_jdbc_driver_checksum) {
      if (!(this_present_jdbc_driver_checksum && that_present_jdbc_driver_checksum))
        return false;
      if (!this.jdbc_driver_checksum.equals(that.jdbc_driver_checksum))
        return false;
    }

    boolean this_present_jdbc_driver_class = true && this.isSetJdbc_driver_class();
    boolean that_present_jdbc_driver_class = true && that.isSetJdbc_driver_class();
    if (this_present_jdbc_driver_class || that_present_jdbc_driver_class) {
      if (!(this_present_jdbc_driver_class && that_present_jdbc_driver_class))
        return false;
      if (!this.jdbc_driver_class.equals(that.jdbc_driver_class))
        return false;
    }

    boolean this_present_jdbc_url = true && this.isSetJdbc_url();
    boolean that_present_jdbc_url = true && that.isSetJdbc_url();
    if (this_present_jdbc_url || that_present_jdbc_url) {
      if (!(this_present_jdbc_url && that_present_jdbc_url))
        return false;
      if (!this.jdbc_url.equals(that.jdbc_url))
        return false;
    }

    boolean this_present_jdbc_table = true && this.isSetJdbc_table();
    boolean that_present_jdbc_table = true && that.isSetJdbc_table();
    if (this_present_jdbc_table || that_present_jdbc_table) {
      if (!(this_present_jdbc_table && that_present_jdbc_table))
        return false;
      if (!this.jdbc_table.equals(that.jdbc_table))
        return false;
    }

    boolean this_present_jdbc_user = true && this.isSetJdbc_user();
    boolean that_present_jdbc_user = true && that.isSetJdbc_user();
    if (this_present_jdbc_user || that_present_jdbc_user) {
      if (!(this_present_jdbc_user && that_present_jdbc_user))
        return false;
      if (!this.jdbc_user.equals(that.jdbc_user))
        return false;
    }

    boolean this_present_jdbc_passwd = true && this.isSetJdbc_passwd();
    boolean that_present_jdbc_passwd = true && that.isSetJdbc_passwd();
    if (this_present_jdbc_passwd || that_present_jdbc_passwd) {
      if (!(this_present_jdbc_passwd && that_present_jdbc_passwd))
        return false;
      if (!this.jdbc_passwd.equals(that.jdbc_passwd))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetJdbc_driver_name()) ? 131071 : 524287);
    if (isSetJdbc_driver_name())
      hashCode = hashCode * 8191 + jdbc_driver_name.hashCode();

    hashCode = hashCode * 8191 + ((isSetJdbc_driver_url()) ? 131071 : 524287);
    if (isSetJdbc_driver_url())
      hashCode = hashCode * 8191 + jdbc_driver_url.hashCode();

    hashCode = hashCode * 8191 + ((isSetJdbc_driver_checksum()) ? 131071 : 524287);
    if (isSetJdbc_driver_checksum())
      hashCode = hashCode * 8191 + jdbc_driver_checksum.hashCode();

    hashCode = hashCode * 8191 + ((isSetJdbc_driver_class()) ? 131071 : 524287);
    if (isSetJdbc_driver_class())
      hashCode = hashCode * 8191 + jdbc_driver_class.hashCode();

    hashCode = hashCode * 8191 + ((isSetJdbc_url()) ? 131071 : 524287);
    if (isSetJdbc_url())
      hashCode = hashCode * 8191 + jdbc_url.hashCode();

    hashCode = hashCode * 8191 + ((isSetJdbc_table()) ? 131071 : 524287);
    if (isSetJdbc_table())
      hashCode = hashCode * 8191 + jdbc_table.hashCode();

    hashCode = hashCode * 8191 + ((isSetJdbc_user()) ? 131071 : 524287);
    if (isSetJdbc_user())
      hashCode = hashCode * 8191 + jdbc_user.hashCode();

    hashCode = hashCode * 8191 + ((isSetJdbc_passwd()) ? 131071 : 524287);
    if (isSetJdbc_passwd())
      hashCode = hashCode * 8191 + jdbc_passwd.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TJDBCTable other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetJdbc_driver_name(), other.isSetJdbc_driver_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_driver_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_driver_name, other.jdbc_driver_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJdbc_driver_url(), other.isSetJdbc_driver_url());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_driver_url()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_driver_url, other.jdbc_driver_url);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJdbc_driver_checksum(), other.isSetJdbc_driver_checksum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_driver_checksum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_driver_checksum, other.jdbc_driver_checksum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJdbc_driver_class(), other.isSetJdbc_driver_class());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_driver_class()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_driver_class, other.jdbc_driver_class);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJdbc_url(), other.isSetJdbc_url());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_url()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_url, other.jdbc_url);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJdbc_table(), other.isSetJdbc_table());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_table()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_table, other.jdbc_table);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJdbc_user(), other.isSetJdbc_user());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_user()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_user, other.jdbc_user);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJdbc_passwd(), other.isSetJdbc_passwd());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJdbc_passwd()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jdbc_passwd, other.jdbc_passwd);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TJDBCTable(");
    boolean first = true;

    if (isSetJdbc_driver_name()) {
      sb.append("jdbc_driver_name:");
      if (this.jdbc_driver_name == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_driver_name);
      }
      first = false;
    }
    if (isSetJdbc_driver_url()) {
      if (!first) sb.append(", ");
      sb.append("jdbc_driver_url:");
      if (this.jdbc_driver_url == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_driver_url);
      }
      first = false;
    }
    if (isSetJdbc_driver_checksum()) {
      if (!first) sb.append(", ");
      sb.append("jdbc_driver_checksum:");
      if (this.jdbc_driver_checksum == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_driver_checksum);
      }
      first = false;
    }
    if (isSetJdbc_driver_class()) {
      if (!first) sb.append(", ");
      sb.append("jdbc_driver_class:");
      if (this.jdbc_driver_class == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_driver_class);
      }
      first = false;
    }
    if (isSetJdbc_url()) {
      if (!first) sb.append(", ");
      sb.append("jdbc_url:");
      if (this.jdbc_url == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_url);
      }
      first = false;
    }
    if (isSetJdbc_table()) {
      if (!first) sb.append(", ");
      sb.append("jdbc_table:");
      if (this.jdbc_table == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_table);
      }
      first = false;
    }
    if (isSetJdbc_user()) {
      if (!first) sb.append(", ");
      sb.append("jdbc_user:");
      if (this.jdbc_user == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_user);
      }
      first = false;
    }
    if (isSetJdbc_passwd()) {
      if (!first) sb.append(", ");
      sb.append("jdbc_passwd:");
      if (this.jdbc_passwd == null) {
        sb.append("null");
      } else {
        sb.append(this.jdbc_passwd);
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

  private static class TJDBCTableStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TJDBCTableStandardScheme getScheme() {
      return new TJDBCTableStandardScheme();
    }
  }

  private static class TJDBCTableStandardScheme extends org.apache.thrift.scheme.StandardScheme<TJDBCTable> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TJDBCTable struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // JDBC_DRIVER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_driver_name = iprot.readString();
              struct.setJdbc_driver_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // JDBC_DRIVER_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_driver_url = iprot.readString();
              struct.setJdbc_driver_urlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // JDBC_DRIVER_CHECKSUM
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_driver_checksum = iprot.readString();
              struct.setJdbc_driver_checksumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // JDBC_DRIVER_CLASS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_driver_class = iprot.readString();
              struct.setJdbc_driver_classIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // JDBC_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_url = iprot.readString();
              struct.setJdbc_urlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // JDBC_TABLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_table = iprot.readString();
              struct.setJdbc_tableIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // JDBC_USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_user = iprot.readString();
              struct.setJdbc_userIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // JDBC_PASSWD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jdbc_passwd = iprot.readString();
              struct.setJdbc_passwdIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TJDBCTable struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.jdbc_driver_name != null) {
        if (struct.isSetJdbc_driver_name()) {
          oprot.writeFieldBegin(JDBC_DRIVER_NAME_FIELD_DESC);
          oprot.writeString(struct.jdbc_driver_name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jdbc_driver_url != null) {
        if (struct.isSetJdbc_driver_url()) {
          oprot.writeFieldBegin(JDBC_DRIVER_URL_FIELD_DESC);
          oprot.writeString(struct.jdbc_driver_url);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jdbc_driver_checksum != null) {
        if (struct.isSetJdbc_driver_checksum()) {
          oprot.writeFieldBegin(JDBC_DRIVER_CHECKSUM_FIELD_DESC);
          oprot.writeString(struct.jdbc_driver_checksum);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jdbc_driver_class != null) {
        if (struct.isSetJdbc_driver_class()) {
          oprot.writeFieldBegin(JDBC_DRIVER_CLASS_FIELD_DESC);
          oprot.writeString(struct.jdbc_driver_class);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jdbc_url != null) {
        if (struct.isSetJdbc_url()) {
          oprot.writeFieldBegin(JDBC_URL_FIELD_DESC);
          oprot.writeString(struct.jdbc_url);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jdbc_table != null) {
        if (struct.isSetJdbc_table()) {
          oprot.writeFieldBegin(JDBC_TABLE_FIELD_DESC);
          oprot.writeString(struct.jdbc_table);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jdbc_user != null) {
        if (struct.isSetJdbc_user()) {
          oprot.writeFieldBegin(JDBC_USER_FIELD_DESC);
          oprot.writeString(struct.jdbc_user);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jdbc_passwd != null) {
        if (struct.isSetJdbc_passwd()) {
          oprot.writeFieldBegin(JDBC_PASSWD_FIELD_DESC);
          oprot.writeString(struct.jdbc_passwd);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TJDBCTableTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TJDBCTableTupleScheme getScheme() {
      return new TJDBCTableTupleScheme();
    }
  }

  private static class TJDBCTableTupleScheme extends org.apache.thrift.scheme.TupleScheme<TJDBCTable> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TJDBCTable struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetJdbc_driver_name()) {
        optionals.set(0);
      }
      if (struct.isSetJdbc_driver_url()) {
        optionals.set(1);
      }
      if (struct.isSetJdbc_driver_checksum()) {
        optionals.set(2);
      }
      if (struct.isSetJdbc_driver_class()) {
        optionals.set(3);
      }
      if (struct.isSetJdbc_url()) {
        optionals.set(4);
      }
      if (struct.isSetJdbc_table()) {
        optionals.set(5);
      }
      if (struct.isSetJdbc_user()) {
        optionals.set(6);
      }
      if (struct.isSetJdbc_passwd()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetJdbc_driver_name()) {
        oprot.writeString(struct.jdbc_driver_name);
      }
      if (struct.isSetJdbc_driver_url()) {
        oprot.writeString(struct.jdbc_driver_url);
      }
      if (struct.isSetJdbc_driver_checksum()) {
        oprot.writeString(struct.jdbc_driver_checksum);
      }
      if (struct.isSetJdbc_driver_class()) {
        oprot.writeString(struct.jdbc_driver_class);
      }
      if (struct.isSetJdbc_url()) {
        oprot.writeString(struct.jdbc_url);
      }
      if (struct.isSetJdbc_table()) {
        oprot.writeString(struct.jdbc_table);
      }
      if (struct.isSetJdbc_user()) {
        oprot.writeString(struct.jdbc_user);
      }
      if (struct.isSetJdbc_passwd()) {
        oprot.writeString(struct.jdbc_passwd);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TJDBCTable struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.jdbc_driver_name = iprot.readString();
        struct.setJdbc_driver_nameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.jdbc_driver_url = iprot.readString();
        struct.setJdbc_driver_urlIsSet(true);
      }
      if (incoming.get(2)) {
        struct.jdbc_driver_checksum = iprot.readString();
        struct.setJdbc_driver_checksumIsSet(true);
      }
      if (incoming.get(3)) {
        struct.jdbc_driver_class = iprot.readString();
        struct.setJdbc_driver_classIsSet(true);
      }
      if (incoming.get(4)) {
        struct.jdbc_url = iprot.readString();
        struct.setJdbc_urlIsSet(true);
      }
      if (incoming.get(5)) {
        struct.jdbc_table = iprot.readString();
        struct.setJdbc_tableIsSet(true);
      }
      if (incoming.get(6)) {
        struct.jdbc_user = iprot.readString();
        struct.setJdbc_userIsSet(true);
      }
      if (incoming.get(7)) {
        struct.jdbc_passwd = iprot.readString();
        struct.setJdbc_passwdIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

