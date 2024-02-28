/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TAuthenticateParams implements org.apache.thrift.TBase<TAuthenticateParams, TAuthenticateParams._Fields>, java.io.Serializable, Cloneable, Comparable<TAuthenticateParams> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TAuthenticateParams");

  private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PASSWD_FIELD_DESC = new org.apache.thrift.protocol.TField("passwd", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("db_name", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField TABLE_NAMES_FIELD_DESC = new org.apache.thrift.protocol.TField("table_names", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TAuthenticateParamsStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TAuthenticateParamsTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String user; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String passwd; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String host; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String db_name; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> table_names; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER((short)1, "user"),
    PASSWD((short)2, "passwd"),
    HOST((short)3, "host"),
    DB_NAME((short)4, "db_name"),
    TABLE_NAMES((short)5, "table_names");

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
        case 1: // USER
          return USER;
        case 2: // PASSWD
          return PASSWD;
        case 3: // HOST
          return HOST;
        case 4: // DB_NAME
          return DB_NAME;
        case 5: // TABLE_NAMES
          return TABLE_NAMES;
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
  private static final _Fields optionals[] = {_Fields.HOST,_Fields.DB_NAME,_Fields.TABLE_NAMES};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PASSWD, new org.apache.thrift.meta_data.FieldMetaData("passwd", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("db_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLE_NAMES, new org.apache.thrift.meta_data.FieldMetaData("table_names", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TAuthenticateParams.class, metaDataMap);
  }

  public TAuthenticateParams() {
  }

  public TAuthenticateParams(
    java.lang.String user,
    java.lang.String passwd)
  {
    this();
    this.user = user;
    this.passwd = passwd;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TAuthenticateParams(TAuthenticateParams other) {
    if (other.isSetUser()) {
      this.user = other.user;
    }
    if (other.isSetPasswd()) {
      this.passwd = other.passwd;
    }
    if (other.isSetHost()) {
      this.host = other.host;
    }
    if (other.isSetDb_name()) {
      this.db_name = other.db_name;
    }
    if (other.isSetTable_names()) {
      java.util.List<java.lang.String> __this__table_names = new java.util.ArrayList<java.lang.String>(other.table_names);
      this.table_names = __this__table_names;
    }
  }

  @Override
  public TAuthenticateParams deepCopy() {
    return new TAuthenticateParams(this);
  }

  @Override
  public void clear() {
    this.user = null;
    this.passwd = null;
    this.host = null;
    this.db_name = null;
    this.table_names = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getUser() {
    return this.user;
  }

  public TAuthenticateParams setUser(@org.apache.thrift.annotation.Nullable java.lang.String user) {
    this.user = user;
    return this;
  }

  public void unsetUser() {
    this.user = null;
  }

  /** Returns true if field user is set (has been assigned a value) and false otherwise */
  public boolean isSetUser() {
    return this.user != null;
  }

  public void setUserIsSet(boolean value) {
    if (!value) {
      this.user = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPasswd() {
    return this.passwd;
  }

  public TAuthenticateParams setPasswd(@org.apache.thrift.annotation.Nullable java.lang.String passwd) {
    this.passwd = passwd;
    return this;
  }

  public void unsetPasswd() {
    this.passwd = null;
  }

  /** Returns true if field passwd is set (has been assigned a value) and false otherwise */
  public boolean isSetPasswd() {
    return this.passwd != null;
  }

  public void setPasswdIsSet(boolean value) {
    if (!value) {
      this.passwd = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getHost() {
    return this.host;
  }

  public TAuthenticateParams setHost(@org.apache.thrift.annotation.Nullable java.lang.String host) {
    this.host = host;
    return this;
  }

  public void unsetHost() {
    this.host = null;
  }

  /** Returns true if field host is set (has been assigned a value) and false otherwise */
  public boolean isSetHost() {
    return this.host != null;
  }

  public void setHostIsSet(boolean value) {
    if (!value) {
      this.host = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDb_name() {
    return this.db_name;
  }

  public TAuthenticateParams setDb_name(@org.apache.thrift.annotation.Nullable java.lang.String db_name) {
    this.db_name = db_name;
    return this;
  }

  public void unsetDb_name() {
    this.db_name = null;
  }

  /** Returns true if field db_name is set (has been assigned a value) and false otherwise */
  public boolean isSetDb_name() {
    return this.db_name != null;
  }

  public void setDb_nameIsSet(boolean value) {
    if (!value) {
      this.db_name = null;
    }
  }

  public int getTable_namesSize() {
    return (this.table_names == null) ? 0 : this.table_names.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.String> getTable_namesIterator() {
    return (this.table_names == null) ? null : this.table_names.iterator();
  }

  public void addToTable_names(java.lang.String elem) {
    if (this.table_names == null) {
      this.table_names = new java.util.ArrayList<java.lang.String>();
    }
    this.table_names.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.String> getTable_names() {
    return this.table_names;
  }

  public TAuthenticateParams setTable_names(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> table_names) {
    this.table_names = table_names;
    return this;
  }

  public void unsetTable_names() {
    this.table_names = null;
  }

  /** Returns true if field table_names is set (has been assigned a value) and false otherwise */
  public boolean isSetTable_names() {
    return this.table_names != null;
  }

  public void setTable_namesIsSet(boolean value) {
    if (!value) {
      this.table_names = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case USER:
      if (value == null) {
        unsetUser();
      } else {
        setUser((java.lang.String)value);
      }
      break;

    case PASSWD:
      if (value == null) {
        unsetPasswd();
      } else {
        setPasswd((java.lang.String)value);
      }
      break;

    case HOST:
      if (value == null) {
        unsetHost();
      } else {
        setHost((java.lang.String)value);
      }
      break;

    case DB_NAME:
      if (value == null) {
        unsetDb_name();
      } else {
        setDb_name((java.lang.String)value);
      }
      break;

    case TABLE_NAMES:
      if (value == null) {
        unsetTable_names();
      } else {
        setTable_names((java.util.List<java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case USER:
      return getUser();

    case PASSWD:
      return getPasswd();

    case HOST:
      return getHost();

    case DB_NAME:
      return getDb_name();

    case TABLE_NAMES:
      return getTable_names();

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
    case USER:
      return isSetUser();
    case PASSWD:
      return isSetPasswd();
    case HOST:
      return isSetHost();
    case DB_NAME:
      return isSetDb_name();
    case TABLE_NAMES:
      return isSetTable_names();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TAuthenticateParams)
      return this.equals((TAuthenticateParams)that);
    return false;
  }

  public boolean equals(TAuthenticateParams that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_user = true && this.isSetUser();
    boolean that_present_user = true && that.isSetUser();
    if (this_present_user || that_present_user) {
      if (!(this_present_user && that_present_user))
        return false;
      if (!this.user.equals(that.user))
        return false;
    }

    boolean this_present_passwd = true && this.isSetPasswd();
    boolean that_present_passwd = true && that.isSetPasswd();
    if (this_present_passwd || that_present_passwd) {
      if (!(this_present_passwd && that_present_passwd))
        return false;
      if (!this.passwd.equals(that.passwd))
        return false;
    }

    boolean this_present_host = true && this.isSetHost();
    boolean that_present_host = true && that.isSetHost();
    if (this_present_host || that_present_host) {
      if (!(this_present_host && that_present_host))
        return false;
      if (!this.host.equals(that.host))
        return false;
    }

    boolean this_present_db_name = true && this.isSetDb_name();
    boolean that_present_db_name = true && that.isSetDb_name();
    if (this_present_db_name || that_present_db_name) {
      if (!(this_present_db_name && that_present_db_name))
        return false;
      if (!this.db_name.equals(that.db_name))
        return false;
    }

    boolean this_present_table_names = true && this.isSetTable_names();
    boolean that_present_table_names = true && that.isSetTable_names();
    if (this_present_table_names || that_present_table_names) {
      if (!(this_present_table_names && that_present_table_names))
        return false;
      if (!this.table_names.equals(that.table_names))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetUser()) ? 131071 : 524287);
    if (isSetUser())
      hashCode = hashCode * 8191 + user.hashCode();

    hashCode = hashCode * 8191 + ((isSetPasswd()) ? 131071 : 524287);
    if (isSetPasswd())
      hashCode = hashCode * 8191 + passwd.hashCode();

    hashCode = hashCode * 8191 + ((isSetHost()) ? 131071 : 524287);
    if (isSetHost())
      hashCode = hashCode * 8191 + host.hashCode();

    hashCode = hashCode * 8191 + ((isSetDb_name()) ? 131071 : 524287);
    if (isSetDb_name())
      hashCode = hashCode * 8191 + db_name.hashCode();

    hashCode = hashCode * 8191 + ((isSetTable_names()) ? 131071 : 524287);
    if (isSetTable_names())
      hashCode = hashCode * 8191 + table_names.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TAuthenticateParams other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetUser(), other.isSetUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, other.user);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPasswd(), other.isSetPasswd());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPasswd()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.passwd, other.passwd);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetHost(), other.isSetHost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, other.host);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDb_name(), other.isSetDb_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDb_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_name, other.db_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTable_names(), other.isSetTable_names());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable_names()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table_names, other.table_names);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TAuthenticateParams(");
    boolean first = true;

    sb.append("user:");
    if (this.user == null) {
      sb.append("null");
    } else {
      sb.append(this.user);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("passwd:");
    if (this.passwd == null) {
      sb.append("null");
    } else {
      sb.append(this.passwd);
    }
    first = false;
    if (isSetHost()) {
      if (!first) sb.append(", ");
      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
    }
    if (isSetDb_name()) {
      if (!first) sb.append(", ");
      sb.append("db_name:");
      if (this.db_name == null) {
        sb.append("null");
      } else {
        sb.append(this.db_name);
      }
      first = false;
    }
    if (isSetTable_names()) {
      if (!first) sb.append(", ");
      sb.append("table_names:");
      if (this.table_names == null) {
        sb.append("null");
      } else {
        sb.append(this.table_names);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (user == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'user' was not present! Struct: " + toString());
    }
    if (passwd == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'passwd' was not present! Struct: " + toString());
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

  private static class TAuthenticateParamsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TAuthenticateParamsStandardScheme getScheme() {
      return new TAuthenticateParamsStandardScheme();
    }
  }

  private static class TAuthenticateParamsStandardScheme extends org.apache.thrift.scheme.StandardScheme<TAuthenticateParams> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TAuthenticateParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.user = iprot.readString();
              struct.setUserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PASSWD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.passwd = iprot.readString();
              struct.setPasswdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HOST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.host = iprot.readString();
              struct.setHostIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.db_name = iprot.readString();
              struct.setDb_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TABLE_NAMES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.table_names = new java.util.ArrayList<java.lang.String>(_list0.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readString();
                  struct.table_names.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setTable_namesIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TAuthenticateParams struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.user != null) {
        oprot.writeFieldBegin(USER_FIELD_DESC);
        oprot.writeString(struct.user);
        oprot.writeFieldEnd();
      }
      if (struct.passwd != null) {
        oprot.writeFieldBegin(PASSWD_FIELD_DESC);
        oprot.writeString(struct.passwd);
        oprot.writeFieldEnd();
      }
      if (struct.host != null) {
        if (struct.isSetHost()) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
      }
      if (struct.db_name != null) {
        if (struct.isSetDb_name()) {
          oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
          oprot.writeString(struct.db_name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.table_names != null) {
        if (struct.isSetTable_names()) {
          oprot.writeFieldBegin(TABLE_NAMES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.table_names.size()));
            for (java.lang.String _iter3 : struct.table_names)
            {
              oprot.writeString(_iter3);
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

  private static class TAuthenticateParamsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TAuthenticateParamsTupleScheme getScheme() {
      return new TAuthenticateParamsTupleScheme();
    }
  }

  private static class TAuthenticateParamsTupleScheme extends org.apache.thrift.scheme.TupleScheme<TAuthenticateParams> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TAuthenticateParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.user);
      oprot.writeString(struct.passwd);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetHost()) {
        optionals.set(0);
      }
      if (struct.isSetDb_name()) {
        optionals.set(1);
      }
      if (struct.isSetTable_names()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetHost()) {
        oprot.writeString(struct.host);
      }
      if (struct.isSetDb_name()) {
        oprot.writeString(struct.db_name);
      }
      if (struct.isSetTable_names()) {
        {
          oprot.writeI32(struct.table_names.size());
          for (java.lang.String _iter4 : struct.table_names)
          {
            oprot.writeString(_iter4);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TAuthenticateParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.user = iprot.readString();
      struct.setUserIsSet(true);
      struct.passwd = iprot.readString();
      struct.setPasswdIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.host = iprot.readString();
        struct.setHostIsSet(true);
      }
      if (incoming.get(1)) {
        struct.db_name = iprot.readString();
        struct.setDb_nameIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list5 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.table_names = new java.util.ArrayList<java.lang.String>(_list5.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = iprot.readString();
            struct.table_names.add(_elem6);
          }
        }
        struct.setTable_namesIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

