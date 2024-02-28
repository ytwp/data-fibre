/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TGetDbsResult implements org.apache.thrift.TBase<TGetDbsResult, TGetDbsResult._Fields>, java.io.Serializable, Cloneable, Comparable<TGetDbsResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TGetDbsResult");

  private static final org.apache.thrift.protocol.TField DBS_FIELD_DESC = new org.apache.thrift.protocol.TField("dbs", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TGetDbsResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TGetDbsResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> dbs; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DBS((short)1, "dbs");

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
        case 1: // DBS
          return DBS;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DBS, new org.apache.thrift.meta_data.FieldMetaData("dbs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TGetDbsResult.class, metaDataMap);
  }

  public TGetDbsResult() {
  }

  public TGetDbsResult(
    java.util.List<java.lang.String> dbs)
  {
    this();
    this.dbs = dbs;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TGetDbsResult(TGetDbsResult other) {
    if (other.isSetDbs()) {
      java.util.List<java.lang.String> __this__dbs = new java.util.ArrayList<java.lang.String>(other.dbs);
      this.dbs = __this__dbs;
    }
  }

  @Override
  public TGetDbsResult deepCopy() {
    return new TGetDbsResult(this);
  }

  @Override
  public void clear() {
    this.dbs = null;
  }

  public int getDbsSize() {
    return (this.dbs == null) ? 0 : this.dbs.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.String> getDbsIterator() {
    return (this.dbs == null) ? null : this.dbs.iterator();
  }

  public void addToDbs(java.lang.String elem) {
    if (this.dbs == null) {
      this.dbs = new java.util.ArrayList<java.lang.String>();
    }
    this.dbs.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.String> getDbs() {
    return this.dbs;
  }

  public TGetDbsResult setDbs(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> dbs) {
    this.dbs = dbs;
    return this;
  }

  public void unsetDbs() {
    this.dbs = null;
  }

  /** Returns true if field dbs is set (has been assigned a value) and false otherwise */
  public boolean isSetDbs() {
    return this.dbs != null;
  }

  public void setDbsIsSet(boolean value) {
    if (!value) {
      this.dbs = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DBS:
      if (value == null) {
        unsetDbs();
      } else {
        setDbs((java.util.List<java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DBS:
      return getDbs();

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
    case DBS:
      return isSetDbs();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TGetDbsResult)
      return this.equals((TGetDbsResult)that);
    return false;
  }

  public boolean equals(TGetDbsResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_dbs = true && this.isSetDbs();
    boolean that_present_dbs = true && that.isSetDbs();
    if (this_present_dbs || that_present_dbs) {
      if (!(this_present_dbs && that_present_dbs))
        return false;
      if (!this.dbs.equals(that.dbs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDbs()) ? 131071 : 524287);
    if (isSetDbs())
      hashCode = hashCode * 8191 + dbs.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TGetDbsResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDbs(), other.isSetDbs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbs, other.dbs);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TGetDbsResult(");
    boolean first = true;

    sb.append("dbs:");
    if (this.dbs == null) {
      sb.append("null");
    } else {
      sb.append(this.dbs);
    }
    first = false;
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

  private static class TGetDbsResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetDbsResultStandardScheme getScheme() {
      return new TGetDbsResultStandardScheme();
    }
  }

  private static class TGetDbsResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TGetDbsResult> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TGetDbsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DBS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list92 = iprot.readListBegin();
                struct.dbs = new java.util.ArrayList<java.lang.String>(_list92.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _elem93;
                for (int _i94 = 0; _i94 < _list92.size; ++_i94)
                {
                  _elem93 = iprot.readString();
                  struct.dbs.add(_elem93);
                }
                iprot.readListEnd();
              }
              struct.setDbsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TGetDbsResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.dbs != null) {
        oprot.writeFieldBegin(DBS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.dbs.size()));
          for (java.lang.String _iter95 : struct.dbs)
          {
            oprot.writeString(_iter95);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TGetDbsResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetDbsResultTupleScheme getScheme() {
      return new TGetDbsResultTupleScheme();
    }
  }

  private static class TGetDbsResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TGetDbsResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TGetDbsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDbs()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetDbs()) {
        {
          oprot.writeI32(struct.dbs.size());
          for (java.lang.String _iter96 : struct.dbs)
          {
            oprot.writeString(_iter96);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TGetDbsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list97 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.dbs = new java.util.ArrayList<java.lang.String>(_list97.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _elem98;
          for (int _i99 = 0; _i99 < _list97.size; ++_i99)
          {
            _elem98 = iprot.readString();
            struct.dbs.add(_elem98);
          }
        }
        struct.setDbsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

