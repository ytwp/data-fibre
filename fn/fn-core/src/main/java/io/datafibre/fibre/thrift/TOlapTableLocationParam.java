/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TOlapTableLocationParam implements org.apache.thrift.TBase<TOlapTableLocationParam, TOlapTableLocationParam._Fields>, java.io.Serializable, Cloneable, Comparable<TOlapTableLocationParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TOlapTableLocationParam");

  private static final org.apache.thrift.protocol.TField DB_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("db_id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TABLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("table_id", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("version", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField TABLETS_FIELD_DESC = new org.apache.thrift.protocol.TField("tablets", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TOlapTableLocationParamStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TOlapTableLocationParamTupleSchemeFactory();

  public long db_id; // required
  public long table_id; // required
  public long version; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<TTabletLocation> tablets; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DB_ID((short)1, "db_id"),
    TABLE_ID((short)2, "table_id"),
    VERSION((short)3, "version"),
    TABLETS((short)4, "tablets");

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
        case 1: // DB_ID
          return DB_ID;
        case 2: // TABLE_ID
          return TABLE_ID;
        case 3: // VERSION
          return VERSION;
        case 4: // TABLETS
          return TABLETS;
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
  private static final int __DB_ID_ISSET_ID = 0;
  private static final int __TABLE_ID_ISSET_ID = 1;
  private static final int __VERSION_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DB_ID, new org.apache.thrift.meta_data.FieldMetaData("db_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TABLE_ID, new org.apache.thrift.meta_data.FieldMetaData("table_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.VERSION, new org.apache.thrift.meta_data.FieldMetaData("version", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TABLETS, new org.apache.thrift.meta_data.FieldMetaData("tablets", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TTabletLocation.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TOlapTableLocationParam.class, metaDataMap);
  }

  public TOlapTableLocationParam() {
  }

  public TOlapTableLocationParam(
    long db_id,
    long table_id,
    long version,
    java.util.List<TTabletLocation> tablets)
  {
    this();
    this.db_id = db_id;
    setDb_idIsSet(true);
    this.table_id = table_id;
    setTable_idIsSet(true);
    this.version = version;
    setVersionIsSet(true);
    this.tablets = tablets;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TOlapTableLocationParam(TOlapTableLocationParam other) {
    __isset_bitfield = other.__isset_bitfield;
    this.db_id = other.db_id;
    this.table_id = other.table_id;
    this.version = other.version;
    if (other.isSetTablets()) {
      java.util.List<TTabletLocation> __this__tablets = new java.util.ArrayList<TTabletLocation>(other.tablets.size());
      for (TTabletLocation other_element : other.tablets) {
        __this__tablets.add(new TTabletLocation(other_element));
      }
      this.tablets = __this__tablets;
    }
  }

  @Override
  public TOlapTableLocationParam deepCopy() {
    return new TOlapTableLocationParam(this);
  }

  @Override
  public void clear() {
    setDb_idIsSet(false);
    this.db_id = 0;
    setTable_idIsSet(false);
    this.table_id = 0;
    setVersionIsSet(false);
    this.version = 0;
    this.tablets = null;
  }

  public long getDb_id() {
    return this.db_id;
  }

  public TOlapTableLocationParam setDb_id(long db_id) {
    this.db_id = db_id;
    setDb_idIsSet(true);
    return this;
  }

  public void unsetDb_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DB_ID_ISSET_ID);
  }

  /** Returns true if field db_id is set (has been assigned a value) and false otherwise */
  public boolean isSetDb_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DB_ID_ISSET_ID);
  }

  public void setDb_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DB_ID_ISSET_ID, value);
  }

  public long getTable_id() {
    return this.table_id;
  }

  public TOlapTableLocationParam setTable_id(long table_id) {
    this.table_id = table_id;
    setTable_idIsSet(true);
    return this;
  }

  public void unsetTable_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TABLE_ID_ISSET_ID);
  }

  /** Returns true if field table_id is set (has been assigned a value) and false otherwise */
  public boolean isSetTable_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TABLE_ID_ISSET_ID);
  }

  public void setTable_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TABLE_ID_ISSET_ID, value);
  }

  public long getVersion() {
    return this.version;
  }

  public TOlapTableLocationParam setVersion(long version) {
    this.version = version;
    setVersionIsSet(true);
    return this;
  }

  public void unsetVersion() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VERSION_ISSET_ID);
  }

  /** Returns true if field version is set (has been assigned a value) and false otherwise */
  public boolean isSetVersion() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VERSION_ISSET_ID);
  }

  public void setVersionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VERSION_ISSET_ID, value);
  }

  public int getTabletsSize() {
    return (this.tablets == null) ? 0 : this.tablets.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TTabletLocation> getTabletsIterator() {
    return (this.tablets == null) ? null : this.tablets.iterator();
  }

  public void addToTablets(TTabletLocation elem) {
    if (this.tablets == null) {
      this.tablets = new java.util.ArrayList<TTabletLocation>();
    }
    this.tablets.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TTabletLocation> getTablets() {
    return this.tablets;
  }

  public TOlapTableLocationParam setTablets(@org.apache.thrift.annotation.Nullable java.util.List<TTabletLocation> tablets) {
    this.tablets = tablets;
    return this;
  }

  public void unsetTablets() {
    this.tablets = null;
  }

  /** Returns true if field tablets is set (has been assigned a value) and false otherwise */
  public boolean isSetTablets() {
    return this.tablets != null;
  }

  public void setTabletsIsSet(boolean value) {
    if (!value) {
      this.tablets = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DB_ID:
      if (value == null) {
        unsetDb_id();
      } else {
        setDb_id((java.lang.Long)value);
      }
      break;

    case TABLE_ID:
      if (value == null) {
        unsetTable_id();
      } else {
        setTable_id((java.lang.Long)value);
      }
      break;

    case VERSION:
      if (value == null) {
        unsetVersion();
      } else {
        setVersion((java.lang.Long)value);
      }
      break;

    case TABLETS:
      if (value == null) {
        unsetTablets();
      } else {
        setTablets((java.util.List<TTabletLocation>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DB_ID:
      return getDb_id();

    case TABLE_ID:
      return getTable_id();

    case VERSION:
      return getVersion();

    case TABLETS:
      return getTablets();

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
    case DB_ID:
      return isSetDb_id();
    case TABLE_ID:
      return isSetTable_id();
    case VERSION:
      return isSetVersion();
    case TABLETS:
      return isSetTablets();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TOlapTableLocationParam)
      return this.equals((TOlapTableLocationParam)that);
    return false;
  }

  public boolean equals(TOlapTableLocationParam that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_db_id = true;
    boolean that_present_db_id = true;
    if (this_present_db_id || that_present_db_id) {
      if (!(this_present_db_id && that_present_db_id))
        return false;
      if (this.db_id != that.db_id)
        return false;
    }

    boolean this_present_table_id = true;
    boolean that_present_table_id = true;
    if (this_present_table_id || that_present_table_id) {
      if (!(this_present_table_id && that_present_table_id))
        return false;
      if (this.table_id != that.table_id)
        return false;
    }

    boolean this_present_version = true;
    boolean that_present_version = true;
    if (this_present_version || that_present_version) {
      if (!(this_present_version && that_present_version))
        return false;
      if (this.version != that.version)
        return false;
    }

    boolean this_present_tablets = true && this.isSetTablets();
    boolean that_present_tablets = true && that.isSetTablets();
    if (this_present_tablets || that_present_tablets) {
      if (!(this_present_tablets && that_present_tablets))
        return false;
      if (!this.tablets.equals(that.tablets))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(db_id);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(table_id);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(version);

    hashCode = hashCode * 8191 + ((isSetTablets()) ? 131071 : 524287);
    if (isSetTablets())
      hashCode = hashCode * 8191 + tablets.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TOlapTableLocationParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDb_id(), other.isSetDb_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDb_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_id, other.db_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTable_id(), other.isSetTable_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table_id, other.table_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetVersion(), other.isSetVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.version, other.version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTablets(), other.isSetTablets());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTablets()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablets, other.tablets);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TOlapTableLocationParam(");
    boolean first = true;

    sb.append("db_id:");
    sb.append(this.db_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("table_id:");
    sb.append(this.table_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("version:");
    sb.append(this.version);
    first = false;
    if (!first) sb.append(", ");
    sb.append("tablets:");
    if (this.tablets == null) {
      sb.append("null");
    } else {
      sb.append(this.tablets);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'db_id' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'table_id' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'version' because it's a primitive and you chose the non-beans generator.
    if (tablets == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tablets' was not present! Struct: " + toString());
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

  private static class TOlapTableLocationParamStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TOlapTableLocationParamStandardScheme getScheme() {
      return new TOlapTableLocationParamStandardScheme();
    }
  }

  private static class TOlapTableLocationParamStandardScheme extends org.apache.thrift.scheme.StandardScheme<TOlapTableLocationParam> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TOlapTableLocationParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DB_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.db_id = iprot.readI64();
              struct.setDb_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TABLE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.table_id = iprot.readI64();
              struct.setTable_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.version = iprot.readI64();
              struct.setVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TABLETS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list176 = iprot.readListBegin();
                struct.tablets = new java.util.ArrayList<TTabletLocation>(_list176.size);
                @org.apache.thrift.annotation.Nullable TTabletLocation _elem177;
                for (int _i178 = 0; _i178 < _list176.size; ++_i178)
                {
                  _elem177 = new TTabletLocation();
                  _elem177.read(iprot);
                  struct.tablets.add(_elem177);
                }
                iprot.readListEnd();
              }
              struct.setTabletsIsSet(true);
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
      if (!struct.isSetDb_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'db_id' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetTable_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'table_id' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetVersion()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'version' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TOlapTableLocationParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(DB_ID_FIELD_DESC);
      oprot.writeI64(struct.db_id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TABLE_ID_FIELD_DESC);
      oprot.writeI64(struct.table_id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(VERSION_FIELD_DESC);
      oprot.writeI64(struct.version);
      oprot.writeFieldEnd();
      if (struct.tablets != null) {
        oprot.writeFieldBegin(TABLETS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.tablets.size()));
          for (TTabletLocation _iter179 : struct.tablets)
          {
            _iter179.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TOlapTableLocationParamTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TOlapTableLocationParamTupleScheme getScheme() {
      return new TOlapTableLocationParamTupleScheme();
    }
  }

  private static class TOlapTableLocationParamTupleScheme extends org.apache.thrift.scheme.TupleScheme<TOlapTableLocationParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TOlapTableLocationParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI64(struct.db_id);
      oprot.writeI64(struct.table_id);
      oprot.writeI64(struct.version);
      {
        oprot.writeI32(struct.tablets.size());
        for (TTabletLocation _iter180 : struct.tablets)
        {
          _iter180.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TOlapTableLocationParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.db_id = iprot.readI64();
      struct.setDb_idIsSet(true);
      struct.table_id = iprot.readI64();
      struct.setTable_idIsSet(true);
      struct.version = iprot.readI64();
      struct.setVersionIsSet(true);
      {
        org.apache.thrift.protocol.TList _list181 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        struct.tablets = new java.util.ArrayList<TTabletLocation>(_list181.size);
        @org.apache.thrift.annotation.Nullable TTabletLocation _elem182;
        for (int _i183 = 0; _i183 < _list181.size; ++_i183)
        {
          _elem182 = new TTabletLocation();
          _elem182.read(iprot);
          struct.tablets.add(_elem182);
        }
      }
      struct.setTabletsIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

