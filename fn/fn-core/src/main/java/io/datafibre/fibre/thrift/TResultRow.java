/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TResultRow implements org.apache.thrift.TBase<TResultRow, TResultRow._Fields>, java.io.Serializable, Cloneable, Comparable<TResultRow> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TResultRow");

  private static final org.apache.thrift.protocol.TField COL_VALS_FIELD_DESC = new org.apache.thrift.protocol.TField("colVals", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TResultRowStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TResultRowTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<TColumnValue> colVals; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COL_VALS((short)1, "colVals");

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
        case 1: // COL_VALS
          return COL_VALS;
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
    tmpMap.put(_Fields.COL_VALS, new org.apache.thrift.meta_data.FieldMetaData("colVals", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TColumnValue.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TResultRow.class, metaDataMap);
  }

  public TResultRow() {
  }

  public TResultRow(
    java.util.List<TColumnValue> colVals)
  {
    this();
    this.colVals = colVals;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TResultRow(TResultRow other) {
    if (other.isSetColVals()) {
      java.util.List<TColumnValue> __this__colVals = new java.util.ArrayList<TColumnValue>(other.colVals.size());
      for (TColumnValue other_element : other.colVals) {
        __this__colVals.add(new TColumnValue(other_element));
      }
      this.colVals = __this__colVals;
    }
  }

  @Override
  public TResultRow deepCopy() {
    return new TResultRow(this);
  }

  @Override
  public void clear() {
    this.colVals = null;
  }

  public int getColValsSize() {
    return (this.colVals == null) ? 0 : this.colVals.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TColumnValue> getColValsIterator() {
    return (this.colVals == null) ? null : this.colVals.iterator();
  }

  public void addToColVals(TColumnValue elem) {
    if (this.colVals == null) {
      this.colVals = new java.util.ArrayList<TColumnValue>();
    }
    this.colVals.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TColumnValue> getColVals() {
    return this.colVals;
  }

  public TResultRow setColVals(@org.apache.thrift.annotation.Nullable java.util.List<TColumnValue> colVals) {
    this.colVals = colVals;
    return this;
  }

  public void unsetColVals() {
    this.colVals = null;
  }

  /** Returns true if field colVals is set (has been assigned a value) and false otherwise */
  public boolean isSetColVals() {
    return this.colVals != null;
  }

  public void setColValsIsSet(boolean value) {
    if (!value) {
      this.colVals = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case COL_VALS:
      if (value == null) {
        unsetColVals();
      } else {
        setColVals((java.util.List<TColumnValue>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case COL_VALS:
      return getColVals();

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
    case COL_VALS:
      return isSetColVals();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TResultRow)
      return this.equals((TResultRow)that);
    return false;
  }

  public boolean equals(TResultRow that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_colVals = true && this.isSetColVals();
    boolean that_present_colVals = true && that.isSetColVals();
    if (this_present_colVals || that_present_colVals) {
      if (!(this_present_colVals && that_present_colVals))
        return false;
      if (!this.colVals.equals(that.colVals))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetColVals()) ? 131071 : 524287);
    if (isSetColVals())
      hashCode = hashCode * 8191 + colVals.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TResultRow other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetColVals(), other.isSetColVals());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColVals()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.colVals, other.colVals);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TResultRow(");
    boolean first = true;

    sb.append("colVals:");
    if (this.colVals == null) {
      sb.append("null");
    } else {
      sb.append(this.colVals);
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

  private static class TResultRowStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TResultRowStandardScheme getScheme() {
      return new TResultRowStandardScheme();
    }
  }

  private static class TResultRowStandardScheme extends org.apache.thrift.scheme.StandardScheme<TResultRow> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TResultRow struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COL_VALS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.colVals = new java.util.ArrayList<TColumnValue>(_list16.size);
                @org.apache.thrift.annotation.Nullable TColumnValue _elem17;
                for (int _i18 = 0; _i18 < _list16.size; ++_i18)
                {
                  _elem17 = new TColumnValue();
                  _elem17.read(iprot);
                  struct.colVals.add(_elem17);
                }
                iprot.readListEnd();
              }
              struct.setColValsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TResultRow struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.colVals != null) {
        oprot.writeFieldBegin(COL_VALS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.colVals.size()));
          for (TColumnValue _iter19 : struct.colVals)
          {
            _iter19.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TResultRowTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TResultRowTupleScheme getScheme() {
      return new TResultRowTupleScheme();
    }
  }

  private static class TResultRowTupleScheme extends org.apache.thrift.scheme.TupleScheme<TResultRow> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TResultRow struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetColVals()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetColVals()) {
        {
          oprot.writeI32(struct.colVals.size());
          for (TColumnValue _iter20 : struct.colVals)
          {
            _iter20.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TResultRow struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list21 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.colVals = new java.util.ArrayList<TColumnValue>(_list21.size);
          @org.apache.thrift.annotation.Nullable TColumnValue _elem22;
          for (int _i23 = 0; _i23 < _list21.size; ++_i23)
          {
            _elem22 = new TColumnValue();
            _elem22.read(iprot);
            struct.colVals.add(_elem22);
          }
        }
        struct.setColValsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

