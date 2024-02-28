/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TOlapTableIndexTablets implements org.apache.thrift.TBase<TOlapTableIndexTablets, TOlapTableIndexTablets._Fields>, java.io.Serializable, Cloneable, Comparable<TOlapTableIndexTablets> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TOlapTableIndexTablets");

  private static final org.apache.thrift.protocol.TField INDEX_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("index_id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TABLETS_FIELD_DESC = new org.apache.thrift.protocol.TField("tablets", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TOlapTableIndexTabletsStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TOlapTableIndexTabletsTupleSchemeFactory();

  public long index_id; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Long> tablets; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INDEX_ID((short)1, "index_id"),
    TABLETS((short)2, "tablets");

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
        case 1: // INDEX_ID
          return INDEX_ID;
        case 2: // TABLETS
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
  private static final int __INDEX_ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INDEX_ID, new org.apache.thrift.meta_data.FieldMetaData("index_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TABLETS, new org.apache.thrift.meta_data.FieldMetaData("tablets", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TOlapTableIndexTablets.class, metaDataMap);
  }

  public TOlapTableIndexTablets() {
  }

  public TOlapTableIndexTablets(
    long index_id,
    java.util.List<java.lang.Long> tablets)
  {
    this();
    this.index_id = index_id;
    setIndex_idIsSet(true);
    this.tablets = tablets;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TOlapTableIndexTablets(TOlapTableIndexTablets other) {
    __isset_bitfield = other.__isset_bitfield;
    this.index_id = other.index_id;
    if (other.isSetTablets()) {
      java.util.List<java.lang.Long> __this__tablets = new java.util.ArrayList<java.lang.Long>(other.tablets);
      this.tablets = __this__tablets;
    }
  }

  @Override
  public TOlapTableIndexTablets deepCopy() {
    return new TOlapTableIndexTablets(this);
  }

  @Override
  public void clear() {
    setIndex_idIsSet(false);
    this.index_id = 0;
    this.tablets = null;
  }

  public long getIndex_id() {
    return this.index_id;
  }

  public TOlapTableIndexTablets setIndex_id(long index_id) {
    this.index_id = index_id;
    setIndex_idIsSet(true);
    return this;
  }

  public void unsetIndex_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __INDEX_ID_ISSET_ID);
  }

  /** Returns true if field index_id is set (has been assigned a value) and false otherwise */
  public boolean isSetIndex_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __INDEX_ID_ISSET_ID);
  }

  public void setIndex_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __INDEX_ID_ISSET_ID, value);
  }

  public int getTabletsSize() {
    return (this.tablets == null) ? 0 : this.tablets.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Long> getTabletsIterator() {
    return (this.tablets == null) ? null : this.tablets.iterator();
  }

  public void addToTablets(long elem) {
    if (this.tablets == null) {
      this.tablets = new java.util.ArrayList<java.lang.Long>();
    }
    this.tablets.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Long> getTablets() {
    return this.tablets;
  }

  public TOlapTableIndexTablets setTablets(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Long> tablets) {
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
    case INDEX_ID:
      if (value == null) {
        unsetIndex_id();
      } else {
        setIndex_id((java.lang.Long)value);
      }
      break;

    case TABLETS:
      if (value == null) {
        unsetTablets();
      } else {
        setTablets((java.util.List<java.lang.Long>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case INDEX_ID:
      return getIndex_id();

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
    case INDEX_ID:
      return isSetIndex_id();
    case TABLETS:
      return isSetTablets();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TOlapTableIndexTablets)
      return this.equals((TOlapTableIndexTablets)that);
    return false;
  }

  public boolean equals(TOlapTableIndexTablets that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_index_id = true;
    boolean that_present_index_id = true;
    if (this_present_index_id || that_present_index_id) {
      if (!(this_present_index_id && that_present_index_id))
        return false;
      if (this.index_id != that.index_id)
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

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(index_id);

    hashCode = hashCode * 8191 + ((isSetTablets()) ? 131071 : 524287);
    if (isSetTablets())
      hashCode = hashCode * 8191 + tablets.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TOlapTableIndexTablets other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetIndex_id(), other.isSetIndex_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIndex_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.index_id, other.index_id);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TOlapTableIndexTablets(");
    boolean first = true;

    sb.append("index_id:");
    sb.append(this.index_id);
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
    // alas, we cannot check 'index_id' because it's a primitive and you chose the non-beans generator.
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

  private static class TOlapTableIndexTabletsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TOlapTableIndexTabletsStandardScheme getScheme() {
      return new TOlapTableIndexTabletsStandardScheme();
    }
  }

  private static class TOlapTableIndexTabletsStandardScheme extends org.apache.thrift.scheme.StandardScheme<TOlapTableIndexTablets> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TOlapTableIndexTablets struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // INDEX_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.index_id = iprot.readI64();
              struct.setIndex_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TABLETS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.tablets = new java.util.ArrayList<java.lang.Long>(_list0.size);
                long _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readI64();
                  struct.tablets.add(_elem1);
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
      if (!struct.isSetIndex_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'index_id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TOlapTableIndexTablets struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(INDEX_ID_FIELD_DESC);
      oprot.writeI64(struct.index_id);
      oprot.writeFieldEnd();
      if (struct.tablets != null) {
        oprot.writeFieldBegin(TABLETS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.tablets.size()));
          for (long _iter3 : struct.tablets)
          {
            oprot.writeI64(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TOlapTableIndexTabletsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TOlapTableIndexTabletsTupleScheme getScheme() {
      return new TOlapTableIndexTabletsTupleScheme();
    }
  }

  private static class TOlapTableIndexTabletsTupleScheme extends org.apache.thrift.scheme.TupleScheme<TOlapTableIndexTablets> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TOlapTableIndexTablets struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI64(struct.index_id);
      {
        oprot.writeI32(struct.tablets.size());
        for (long _iter4 : struct.tablets)
        {
          oprot.writeI64(_iter4);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TOlapTableIndexTablets struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.index_id = iprot.readI64();
      struct.setIndex_idIsSet(true);
      {
        org.apache.thrift.protocol.TList _list5 = iprot.readListBegin(org.apache.thrift.protocol.TType.I64);
        struct.tablets = new java.util.ArrayList<java.lang.Long>(_list5.size);
        long _elem6;
        for (int _i7 = 0; _i7 < _list5.size; ++_i7)
        {
          _elem6 = iprot.readI64();
          struct.tablets.add(_elem6);
        }
      }
      struct.setTabletsIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

