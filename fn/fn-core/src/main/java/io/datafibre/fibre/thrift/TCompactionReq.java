/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TCompactionReq implements org.apache.thrift.TBase<TCompactionReq, TCompactionReq._Fields>, java.io.Serializable, Cloneable, Comparable<TCompactionReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TCompactionReq");

  private static final org.apache.thrift.protocol.TField TABLET_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("tablet_ids", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField IS_BASE_COMPACTION_FIELD_DESC = new org.apache.thrift.protocol.TField("is_base_compaction", org.apache.thrift.protocol.TType.BOOL, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TCompactionReqStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TCompactionReqTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Long> tablet_ids; // optional
  public boolean is_base_compaction; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLET_IDS((short)1, "tablet_ids"),
    IS_BASE_COMPACTION((short)2, "is_base_compaction");

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
        case 1: // TABLET_IDS
          return TABLET_IDS;
        case 2: // IS_BASE_COMPACTION
          return IS_BASE_COMPACTION;
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
  private static final int __IS_BASE_COMPACTION_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TABLET_IDS,_Fields.IS_BASE_COMPACTION};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLET_IDS, new org.apache.thrift.meta_data.FieldMetaData("tablet_ids", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64            , "TTableId"))));
    tmpMap.put(_Fields.IS_BASE_COMPACTION, new org.apache.thrift.meta_data.FieldMetaData("is_base_compaction", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TCompactionReq.class, metaDataMap);
  }

  public TCompactionReq() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TCompactionReq(TCompactionReq other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetTablet_ids()) {
      java.util.List<java.lang.Long> __this__tablet_ids = new java.util.ArrayList<java.lang.Long>(other.tablet_ids.size());
      for (java.lang.Long other_element : other.tablet_ids) {
        __this__tablet_ids.add(other_element);
      }
      this.tablet_ids = __this__tablet_ids;
    }
    this.is_base_compaction = other.is_base_compaction;
  }

  @Override
  public TCompactionReq deepCopy() {
    return new TCompactionReq(this);
  }

  @Override
  public void clear() {
    this.tablet_ids = null;
    setIs_base_compactionIsSet(false);
    this.is_base_compaction = false;
  }

  public int getTablet_idsSize() {
    return (this.tablet_ids == null) ? 0 : this.tablet_ids.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Long> getTablet_idsIterator() {
    return (this.tablet_ids == null) ? null : this.tablet_ids.iterator();
  }

  public void addToTablet_ids(long elem) {
    if (this.tablet_ids == null) {
      this.tablet_ids = new java.util.ArrayList<java.lang.Long>();
    }
    this.tablet_ids.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Long> getTablet_ids() {
    return this.tablet_ids;
  }

  public TCompactionReq setTablet_ids(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Long> tablet_ids) {
    this.tablet_ids = tablet_ids;
    return this;
  }

  public void unsetTablet_ids() {
    this.tablet_ids = null;
  }

  /** Returns true if field tablet_ids is set (has been assigned a value) and false otherwise */
  public boolean isSetTablet_ids() {
    return this.tablet_ids != null;
  }

  public void setTablet_idsIsSet(boolean value) {
    if (!value) {
      this.tablet_ids = null;
    }
  }

  public boolean isIs_base_compaction() {
    return this.is_base_compaction;
  }

  public TCompactionReq setIs_base_compaction(boolean is_base_compaction) {
    this.is_base_compaction = is_base_compaction;
    setIs_base_compactionIsSet(true);
    return this;
  }

  public void unsetIs_base_compaction() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __IS_BASE_COMPACTION_ISSET_ID);
  }

  /** Returns true if field is_base_compaction is set (has been assigned a value) and false otherwise */
  public boolean isSetIs_base_compaction() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __IS_BASE_COMPACTION_ISSET_ID);
  }

  public void setIs_base_compactionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __IS_BASE_COMPACTION_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TABLET_IDS:
      if (value == null) {
        unsetTablet_ids();
      } else {
        setTablet_ids((java.util.List<java.lang.Long>)value);
      }
      break;

    case IS_BASE_COMPACTION:
      if (value == null) {
        unsetIs_base_compaction();
      } else {
        setIs_base_compaction((java.lang.Boolean)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLET_IDS:
      return getTablet_ids();

    case IS_BASE_COMPACTION:
      return isIs_base_compaction();

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
    case TABLET_IDS:
      return isSetTablet_ids();
    case IS_BASE_COMPACTION:
      return isSetIs_base_compaction();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TCompactionReq)
      return this.equals((TCompactionReq)that);
    return false;
  }

  public boolean equals(TCompactionReq that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tablet_ids = true && this.isSetTablet_ids();
    boolean that_present_tablet_ids = true && that.isSetTablet_ids();
    if (this_present_tablet_ids || that_present_tablet_ids) {
      if (!(this_present_tablet_ids && that_present_tablet_ids))
        return false;
      if (!this.tablet_ids.equals(that.tablet_ids))
        return false;
    }

    boolean this_present_is_base_compaction = true && this.isSetIs_base_compaction();
    boolean that_present_is_base_compaction = true && that.isSetIs_base_compaction();
    if (this_present_is_base_compaction || that_present_is_base_compaction) {
      if (!(this_present_is_base_compaction && that_present_is_base_compaction))
        return false;
      if (this.is_base_compaction != that.is_base_compaction)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTablet_ids()) ? 131071 : 524287);
    if (isSetTablet_ids())
      hashCode = hashCode * 8191 + tablet_ids.hashCode();

    hashCode = hashCode * 8191 + ((isSetIs_base_compaction()) ? 131071 : 524287);
    if (isSetIs_base_compaction())
      hashCode = hashCode * 8191 + ((is_base_compaction) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(TCompactionReq other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTablet_ids(), other.isSetTablet_ids());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTablet_ids()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablet_ids, other.tablet_ids);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetIs_base_compaction(), other.isSetIs_base_compaction());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIs_base_compaction()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.is_base_compaction, other.is_base_compaction);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TCompactionReq(");
    boolean first = true;

    if (isSetTablet_ids()) {
      sb.append("tablet_ids:");
      if (this.tablet_ids == null) {
        sb.append("null");
      } else {
        sb.append(this.tablet_ids);
      }
      first = false;
    }
    if (isSetIs_base_compaction()) {
      if (!first) sb.append(", ");
      sb.append("is_base_compaction:");
      sb.append(this.is_base_compaction);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TCompactionReqStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TCompactionReqStandardScheme getScheme() {
      return new TCompactionReqStandardScheme();
    }
  }

  private static class TCompactionReqStandardScheme extends org.apache.thrift.scheme.StandardScheme<TCompactionReq> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TCompactionReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLET_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list90 = iprot.readListBegin();
                struct.tablet_ids = new java.util.ArrayList<java.lang.Long>(_list90.size);
                long _elem91;
                for (int _i92 = 0; _i92 < _list90.size; ++_i92)
                {
                  _elem91 = iprot.readI64();
                  struct.tablet_ids.add(_elem91);
                }
                iprot.readListEnd();
              }
              struct.setTablet_idsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IS_BASE_COMPACTION
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.is_base_compaction = iprot.readBool();
              struct.setIs_base_compactionIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TCompactionReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.tablet_ids != null) {
        if (struct.isSetTablet_ids()) {
          oprot.writeFieldBegin(TABLET_IDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.tablet_ids.size()));
            for (long _iter93 : struct.tablet_ids)
            {
              oprot.writeI64(_iter93);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetIs_base_compaction()) {
        oprot.writeFieldBegin(IS_BASE_COMPACTION_FIELD_DESC);
        oprot.writeBool(struct.is_base_compaction);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TCompactionReqTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TCompactionReqTupleScheme getScheme() {
      return new TCompactionReqTupleScheme();
    }
  }

  private static class TCompactionReqTupleScheme extends org.apache.thrift.scheme.TupleScheme<TCompactionReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TCompactionReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTablet_ids()) {
        optionals.set(0);
      }
      if (struct.isSetIs_base_compaction()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTablet_ids()) {
        {
          oprot.writeI32(struct.tablet_ids.size());
          for (long _iter94 : struct.tablet_ids)
          {
            oprot.writeI64(_iter94);
          }
        }
      }
      if (struct.isSetIs_base_compaction()) {
        oprot.writeBool(struct.is_base_compaction);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TCompactionReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list95 = iprot.readListBegin(org.apache.thrift.protocol.TType.I64);
          struct.tablet_ids = new java.util.ArrayList<java.lang.Long>(_list95.size);
          long _elem96;
          for (int _i97 = 0; _i97 < _list95.size; ++_i97)
          {
            _elem96 = iprot.readI64();
            struct.tablet_ids.add(_elem96);
          }
        }
        struct.setTablet_idsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.is_base_compaction = iprot.readBool();
        struct.setIs_base_compactionIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
