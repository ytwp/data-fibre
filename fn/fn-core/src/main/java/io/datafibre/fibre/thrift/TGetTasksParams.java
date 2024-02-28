/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TGetTasksParams implements org.apache.thrift.TBase<TGetTasksParams, TGetTasksParams._Fields>, java.io.Serializable, Cloneable, Comparable<TGetTasksParams> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TGetTasksParams");

  private static final org.apache.thrift.protocol.TField DB_FIELD_DESC = new org.apache.thrift.protocol.TField("db", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CURRENT_USER_IDENT_FIELD_DESC = new org.apache.thrift.protocol.TField("current_user_ident", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TGetTasksParamsStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TGetTasksParamsTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String db; // optional
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUserIdentity current_user_ident; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DB((short)1, "db"),
    CURRENT_USER_IDENT((short)2, "current_user_ident");

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
        case 1: // DB
          return DB;
        case 2: // CURRENT_USER_IDENT
          return CURRENT_USER_IDENT;
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
  private static final _Fields optionals[] = {_Fields.DB,_Fields.CURRENT_USER_IDENT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DB, new org.apache.thrift.meta_data.FieldMetaData("db", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CURRENT_USER_IDENT, new org.apache.thrift.meta_data.FieldMetaData("current_user_ident", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TUserIdentity.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TGetTasksParams.class, metaDataMap);
  }

  public TGetTasksParams() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TGetTasksParams(TGetTasksParams other) {
    if (other.isSetDb()) {
      this.db = other.db;
    }
    if (other.isSetCurrent_user_ident()) {
      this.current_user_ident = new io.datafibre.fibre.thrift.TUserIdentity(other.current_user_ident);
    }
  }

  @Override
  public TGetTasksParams deepCopy() {
    return new TGetTasksParams(this);
  }

  @Override
  public void clear() {
    this.db = null;
    this.current_user_ident = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDb() {
    return this.db;
  }

  public TGetTasksParams setDb(@org.apache.thrift.annotation.Nullable java.lang.String db) {
    this.db = db;
    return this;
  }

  public void unsetDb() {
    this.db = null;
  }

  /** Returns true if field db is set (has been assigned a value) and false otherwise */
  public boolean isSetDb() {
    return this.db != null;
  }

  public void setDbIsSet(boolean value) {
    if (!value) {
      this.db = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TUserIdentity getCurrent_user_ident() {
    return this.current_user_ident;
  }

  public TGetTasksParams setCurrent_user_ident(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUserIdentity current_user_ident) {
    this.current_user_ident = current_user_ident;
    return this;
  }

  public void unsetCurrent_user_ident() {
    this.current_user_ident = null;
  }

  /** Returns true if field current_user_ident is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrent_user_ident() {
    return this.current_user_ident != null;
  }

  public void setCurrent_user_identIsSet(boolean value) {
    if (!value) {
      this.current_user_ident = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DB:
      if (value == null) {
        unsetDb();
      } else {
        setDb((java.lang.String)value);
      }
      break;

    case CURRENT_USER_IDENT:
      if (value == null) {
        unsetCurrent_user_ident();
      } else {
        setCurrent_user_ident((io.datafibre.fibre.thrift.TUserIdentity)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DB:
      return getDb();

    case CURRENT_USER_IDENT:
      return getCurrent_user_ident();

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
    case DB:
      return isSetDb();
    case CURRENT_USER_IDENT:
      return isSetCurrent_user_ident();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TGetTasksParams)
      return this.equals((TGetTasksParams)that);
    return false;
  }

  public boolean equals(TGetTasksParams that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_db = true && this.isSetDb();
    boolean that_present_db = true && that.isSetDb();
    if (this_present_db || that_present_db) {
      if (!(this_present_db && that_present_db))
        return false;
      if (!this.db.equals(that.db))
        return false;
    }

    boolean this_present_current_user_ident = true && this.isSetCurrent_user_ident();
    boolean that_present_current_user_ident = true && that.isSetCurrent_user_ident();
    if (this_present_current_user_ident || that_present_current_user_ident) {
      if (!(this_present_current_user_ident && that_present_current_user_ident))
        return false;
      if (!this.current_user_ident.equals(that.current_user_ident))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDb()) ? 131071 : 524287);
    if (isSetDb())
      hashCode = hashCode * 8191 + db.hashCode();

    hashCode = hashCode * 8191 + ((isSetCurrent_user_ident()) ? 131071 : 524287);
    if (isSetCurrent_user_ident())
      hashCode = hashCode * 8191 + current_user_ident.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TGetTasksParams other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDb(), other.isSetDb());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDb()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db, other.db);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCurrent_user_ident(), other.isSetCurrent_user_ident());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrent_user_ident()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.current_user_ident, other.current_user_ident);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TGetTasksParams(");
    boolean first = true;

    if (isSetDb()) {
      sb.append("db:");
      if (this.db == null) {
        sb.append("null");
      } else {
        sb.append(this.db);
      }
      first = false;
    }
    if (isSetCurrent_user_ident()) {
      if (!first) sb.append(", ");
      sb.append("current_user_ident:");
      if (this.current_user_ident == null) {
        sb.append("null");
      } else {
        sb.append(this.current_user_ident);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (current_user_ident != null) {
      current_user_ident.validate();
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

  private static class TGetTasksParamsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetTasksParamsStandardScheme getScheme() {
      return new TGetTasksParamsStandardScheme();
    }
  }

  private static class TGetTasksParamsStandardScheme extends org.apache.thrift.scheme.StandardScheme<TGetTasksParams> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TGetTasksParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DB
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.db = iprot.readString();
              struct.setDbIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CURRENT_USER_IDENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.current_user_ident = new io.datafibre.fibre.thrift.TUserIdentity();
              struct.current_user_ident.read(iprot);
              struct.setCurrent_user_identIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TGetTasksParams struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.db != null) {
        if (struct.isSetDb()) {
          oprot.writeFieldBegin(DB_FIELD_DESC);
          oprot.writeString(struct.db);
          oprot.writeFieldEnd();
        }
      }
      if (struct.current_user_ident != null) {
        if (struct.isSetCurrent_user_ident()) {
          oprot.writeFieldBegin(CURRENT_USER_IDENT_FIELD_DESC);
          struct.current_user_ident.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TGetTasksParamsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetTasksParamsTupleScheme getScheme() {
      return new TGetTasksParamsTupleScheme();
    }
  }

  private static class TGetTasksParamsTupleScheme extends org.apache.thrift.scheme.TupleScheme<TGetTasksParams> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TGetTasksParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDb()) {
        optionals.set(0);
      }
      if (struct.isSetCurrent_user_ident()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetDb()) {
        oprot.writeString(struct.db);
      }
      if (struct.isSetCurrent_user_ident()) {
        struct.current_user_ident.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TGetTasksParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.db = iprot.readString();
        struct.setDbIsSet(true);
      }
      if (incoming.get(1)) {
        struct.current_user_ident = new io.datafibre.fibre.thrift.TUserIdentity();
        struct.current_user_ident.read(iprot);
        struct.setCurrent_user_identIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

