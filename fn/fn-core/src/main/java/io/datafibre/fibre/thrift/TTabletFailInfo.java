/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TTabletFailInfo implements org.apache.thrift.TBase<TTabletFailInfo, TTabletFailInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TTabletFailInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTabletFailInfo");

  private static final org.apache.thrift.protocol.TField TABLET_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tabletId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField BACKEND_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("backendId", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTabletFailInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTabletFailInfoTupleSchemeFactory();

  public long tabletId; // optional
  public long backendId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLET_ID((short)1, "tabletId"),
    BACKEND_ID((short)2, "backendId");

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
        case 1: // TABLET_ID
          return TABLET_ID;
        case 2: // BACKEND_ID
          return BACKEND_ID;
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
  private static final int __TABLETID_ISSET_ID = 0;
  private static final int __BACKENDID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TABLET_ID,_Fields.BACKEND_ID};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLET_ID, new org.apache.thrift.meta_data.FieldMetaData("tabletId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.BACKEND_ID, new org.apache.thrift.meta_data.FieldMetaData("backendId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTabletFailInfo.class, metaDataMap);
  }

  public TTabletFailInfo() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTabletFailInfo(TTabletFailInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tabletId = other.tabletId;
    this.backendId = other.backendId;
  }

  @Override
  public TTabletFailInfo deepCopy() {
    return new TTabletFailInfo(this);
  }

  @Override
  public void clear() {
    setTabletIdIsSet(false);
    this.tabletId = 0;
    setBackendIdIsSet(false);
    this.backendId = 0;
  }

  public long getTabletId() {
    return this.tabletId;
  }

  public TTabletFailInfo setTabletId(long tabletId) {
    this.tabletId = tabletId;
    setTabletIdIsSet(true);
    return this;
  }

  public void unsetTabletId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TABLETID_ISSET_ID);
  }

  /** Returns true if field tabletId is set (has been assigned a value) and false otherwise */
  public boolean isSetTabletId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TABLETID_ISSET_ID);
  }

  public void setTabletIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TABLETID_ISSET_ID, value);
  }

  public long getBackendId() {
    return this.backendId;
  }

  public TTabletFailInfo setBackendId(long backendId) {
    this.backendId = backendId;
    setBackendIdIsSet(true);
    return this;
  }

  public void unsetBackendId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BACKENDID_ISSET_ID);
  }

  /** Returns true if field backendId is set (has been assigned a value) and false otherwise */
  public boolean isSetBackendId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BACKENDID_ISSET_ID);
  }

  public void setBackendIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BACKENDID_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TABLET_ID:
      if (value == null) {
        unsetTabletId();
      } else {
        setTabletId((java.lang.Long)value);
      }
      break;

    case BACKEND_ID:
      if (value == null) {
        unsetBackendId();
      } else {
        setBackendId((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLET_ID:
      return getTabletId();

    case BACKEND_ID:
      return getBackendId();

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
    case TABLET_ID:
      return isSetTabletId();
    case BACKEND_ID:
      return isSetBackendId();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TTabletFailInfo)
      return this.equals((TTabletFailInfo)that);
    return false;
  }

  public boolean equals(TTabletFailInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tabletId = true && this.isSetTabletId();
    boolean that_present_tabletId = true && that.isSetTabletId();
    if (this_present_tabletId || that_present_tabletId) {
      if (!(this_present_tabletId && that_present_tabletId))
        return false;
      if (this.tabletId != that.tabletId)
        return false;
    }

    boolean this_present_backendId = true && this.isSetBackendId();
    boolean that_present_backendId = true && that.isSetBackendId();
    if (this_present_backendId || that_present_backendId) {
      if (!(this_present_backendId && that_present_backendId))
        return false;
      if (this.backendId != that.backendId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTabletId()) ? 131071 : 524287);
    if (isSetTabletId())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(tabletId);

    hashCode = hashCode * 8191 + ((isSetBackendId()) ? 131071 : 524287);
    if (isSetBackendId())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(backendId);

    return hashCode;
  }

  @Override
  public int compareTo(TTabletFailInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTabletId(), other.isSetTabletId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTabletId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tabletId, other.tabletId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetBackendId(), other.isSetBackendId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBackendId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.backendId, other.backendId);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTabletFailInfo(");
    boolean first = true;

    if (isSetTabletId()) {
      sb.append("tabletId:");
      sb.append(this.tabletId);
      first = false;
    }
    if (isSetBackendId()) {
      if (!first) sb.append(", ");
      sb.append("backendId:");
      sb.append(this.backendId);
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

  private static class TTabletFailInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTabletFailInfoStandardScheme getScheme() {
      return new TTabletFailInfoStandardScheme();
    }
  }

  private static class TTabletFailInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTabletFailInfo> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TTabletFailInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLET_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.tabletId = iprot.readI64();
              struct.setTabletIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BACKEND_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.backendId = iprot.readI64();
              struct.setBackendIdIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TTabletFailInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetTabletId()) {
        oprot.writeFieldBegin(TABLET_ID_FIELD_DESC);
        oprot.writeI64(struct.tabletId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetBackendId()) {
        oprot.writeFieldBegin(BACKEND_ID_FIELD_DESC);
        oprot.writeI64(struct.backendId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTabletFailInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTabletFailInfoTupleScheme getScheme() {
      return new TTabletFailInfoTupleScheme();
    }
  }

  private static class TTabletFailInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTabletFailInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTabletFailInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTabletId()) {
        optionals.set(0);
      }
      if (struct.isSetBackendId()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTabletId()) {
        oprot.writeI64(struct.tabletId);
      }
      if (struct.isSetBackendId()) {
        oprot.writeI64(struct.backendId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTabletFailInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.tabletId = iprot.readI64();
        struct.setTabletIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.backendId = iprot.readI64();
        struct.setBackendIdIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

