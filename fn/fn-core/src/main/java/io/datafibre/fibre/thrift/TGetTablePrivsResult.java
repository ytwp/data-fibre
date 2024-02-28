/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TGetTablePrivsResult implements org.apache.thrift.TBase<TGetTablePrivsResult, TGetTablePrivsResult._Fields>, java.io.Serializable, Cloneable, Comparable<TGetTablePrivsResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TGetTablePrivsResult");

  private static final org.apache.thrift.protocol.TField TABLE_PRIVS_FIELD_DESC = new org.apache.thrift.protocol.TField("table_privs", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TGetTablePrivsResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TGetTablePrivsResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<TTablePrivDesc> table_privs; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLE_PRIVS((short)1, "table_privs");

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
        case 1: // TABLE_PRIVS
          return TABLE_PRIVS;
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
  private static final _Fields optionals[] = {_Fields.TABLE_PRIVS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLE_PRIVS, new org.apache.thrift.meta_data.FieldMetaData("table_privs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TTablePrivDesc.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TGetTablePrivsResult.class, metaDataMap);
  }

  public TGetTablePrivsResult() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TGetTablePrivsResult(TGetTablePrivsResult other) {
    if (other.isSetTable_privs()) {
      java.util.List<TTablePrivDesc> __this__table_privs = new java.util.ArrayList<TTablePrivDesc>(other.table_privs.size());
      for (TTablePrivDesc other_element : other.table_privs) {
        __this__table_privs.add(new TTablePrivDesc(other_element));
      }
      this.table_privs = __this__table_privs;
    }
  }

  @Override
  public TGetTablePrivsResult deepCopy() {
    return new TGetTablePrivsResult(this);
  }

  @Override
  public void clear() {
    this.table_privs = null;
  }

  public int getTable_privsSize() {
    return (this.table_privs == null) ? 0 : this.table_privs.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TTablePrivDesc> getTable_privsIterator() {
    return (this.table_privs == null) ? null : this.table_privs.iterator();
  }

  public void addToTable_privs(TTablePrivDesc elem) {
    if (this.table_privs == null) {
      this.table_privs = new java.util.ArrayList<TTablePrivDesc>();
    }
    this.table_privs.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TTablePrivDesc> getTable_privs() {
    return this.table_privs;
  }

  public TGetTablePrivsResult setTable_privs(@org.apache.thrift.annotation.Nullable java.util.List<TTablePrivDesc> table_privs) {
    this.table_privs = table_privs;
    return this;
  }

  public void unsetTable_privs() {
    this.table_privs = null;
  }

  /** Returns true if field table_privs is set (has been assigned a value) and false otherwise */
  public boolean isSetTable_privs() {
    return this.table_privs != null;
  }

  public void setTable_privsIsSet(boolean value) {
    if (!value) {
      this.table_privs = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TABLE_PRIVS:
      if (value == null) {
        unsetTable_privs();
      } else {
        setTable_privs((java.util.List<TTablePrivDesc>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLE_PRIVS:
      return getTable_privs();

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
    case TABLE_PRIVS:
      return isSetTable_privs();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TGetTablePrivsResult)
      return this.equals((TGetTablePrivsResult)that);
    return false;
  }

  public boolean equals(TGetTablePrivsResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_table_privs = true && this.isSetTable_privs();
    boolean that_present_table_privs = true && that.isSetTable_privs();
    if (this_present_table_privs || that_present_table_privs) {
      if (!(this_present_table_privs && that_present_table_privs))
        return false;
      if (!this.table_privs.equals(that.table_privs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTable_privs()) ? 131071 : 524287);
    if (isSetTable_privs())
      hashCode = hashCode * 8191 + table_privs.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TGetTablePrivsResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTable_privs(), other.isSetTable_privs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable_privs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table_privs, other.table_privs);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TGetTablePrivsResult(");
    boolean first = true;

    if (isSetTable_privs()) {
      sb.append("table_privs:");
      if (this.table_privs == null) {
        sb.append("null");
      } else {
        sb.append(this.table_privs);
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

  private static class TGetTablePrivsResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetTablePrivsResultStandardScheme getScheme() {
      return new TGetTablePrivsResultStandardScheme();
    }
  }

  private static class TGetTablePrivsResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TGetTablePrivsResult> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TGetTablePrivsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLE_PRIVS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list388 = iprot.readListBegin();
                struct.table_privs = new java.util.ArrayList<TTablePrivDesc>(_list388.size);
                @org.apache.thrift.annotation.Nullable TTablePrivDesc _elem389;
                for (int _i390 = 0; _i390 < _list388.size; ++_i390)
                {
                  _elem389 = new TTablePrivDesc();
                  _elem389.read(iprot);
                  struct.table_privs.add(_elem389);
                }
                iprot.readListEnd();
              }
              struct.setTable_privsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TGetTablePrivsResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.table_privs != null) {
        if (struct.isSetTable_privs()) {
          oprot.writeFieldBegin(TABLE_PRIVS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.table_privs.size()));
            for (TTablePrivDesc _iter391 : struct.table_privs)
            {
              _iter391.write(oprot);
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

  private static class TGetTablePrivsResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetTablePrivsResultTupleScheme getScheme() {
      return new TGetTablePrivsResultTupleScheme();
    }
  }

  private static class TGetTablePrivsResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TGetTablePrivsResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TGetTablePrivsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTable_privs()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetTable_privs()) {
        {
          oprot.writeI32(struct.table_privs.size());
          for (TTablePrivDesc _iter392 : struct.table_privs)
          {
            _iter392.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TGetTablePrivsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list393 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.table_privs = new java.util.ArrayList<TTablePrivDesc>(_list393.size);
          @org.apache.thrift.annotation.Nullable TTablePrivDesc _elem394;
          for (int _i395 = 0; _i395 < _list393.size; ++_i395)
          {
            _elem394 = new TTablePrivDesc();
            _elem394.read(iprot);
            struct.table_privs.add(_elem394);
          }
        }
        struct.setTable_privsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

