/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TReleaseSlotRequest implements org.apache.thrift.TBase<TReleaseSlotRequest, TReleaseSlotRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TReleaseSlotRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TReleaseSlotRequest");

  private static final org.apache.thrift.protocol.TField SLOT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("slot_id", org.apache.thrift.protocol.TType.STRUCT, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TReleaseSlotRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TReleaseSlotRequestTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TUniqueId slot_id; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLOT_ID((short)1, "slot_id");

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
        case 1: // SLOT_ID
          return SLOT_ID;
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
  private static final _Fields optionals[] = {_Fields.SLOT_ID};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLOT_ID, new org.apache.thrift.meta_data.FieldMetaData("slot_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TUniqueId.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TReleaseSlotRequest.class, metaDataMap);
  }

  public TReleaseSlotRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TReleaseSlotRequest(TReleaseSlotRequest other) {
    if (other.isSetSlot_id()) {
      this.slot_id = new com.starrocks.thrift.TUniqueId(other.slot_id);
    }
  }

  @Override
  public TReleaseSlotRequest deepCopy() {
    return new TReleaseSlotRequest(this);
  }

  @Override
  public void clear() {
    this.slot_id = null;
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TUniqueId getSlot_id() {
    return this.slot_id;
  }

  public TReleaseSlotRequest setSlot_id(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TUniqueId slot_id) {
    this.slot_id = slot_id;
    return this;
  }

  public void unsetSlot_id() {
    this.slot_id = null;
  }

  /** Returns true if field slot_id is set (has been assigned a value) and false otherwise */
  public boolean isSetSlot_id() {
    return this.slot_id != null;
  }

  public void setSlot_idIsSet(boolean value) {
    if (!value) {
      this.slot_id = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case SLOT_ID:
      if (value == null) {
        unsetSlot_id();
      } else {
        setSlot_id((com.starrocks.thrift.TUniqueId)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SLOT_ID:
      return getSlot_id();

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
    case SLOT_ID:
      return isSetSlot_id();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TReleaseSlotRequest)
      return this.equals((TReleaseSlotRequest)that);
    return false;
  }

  public boolean equals(TReleaseSlotRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_slot_id = true && this.isSetSlot_id();
    boolean that_present_slot_id = true && that.isSetSlot_id();
    if (this_present_slot_id || that_present_slot_id) {
      if (!(this_present_slot_id && that_present_slot_id))
        return false;
      if (!this.slot_id.equals(that.slot_id))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetSlot_id()) ? 131071 : 524287);
    if (isSetSlot_id())
      hashCode = hashCode * 8191 + slot_id.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TReleaseSlotRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetSlot_id(), other.isSetSlot_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSlot_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.slot_id, other.slot_id);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TReleaseSlotRequest(");
    boolean first = true;

    if (isSetSlot_id()) {
      sb.append("slot_id:");
      if (this.slot_id == null) {
        sb.append("null");
      } else {
        sb.append(this.slot_id);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (slot_id != null) {
      slot_id.validate();
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

  private static class TReleaseSlotRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TReleaseSlotRequestStandardScheme getScheme() {
      return new TReleaseSlotRequestStandardScheme();
    }
  }

  private static class TReleaseSlotRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<TReleaseSlotRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TReleaseSlotRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLOT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.slot_id = new com.starrocks.thrift.TUniqueId();
              struct.slot_id.read(iprot);
              struct.setSlot_idIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TReleaseSlotRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.slot_id != null) {
        if (struct.isSetSlot_id()) {
          oprot.writeFieldBegin(SLOT_ID_FIELD_DESC);
          struct.slot_id.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TReleaseSlotRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TReleaseSlotRequestTupleScheme getScheme() {
      return new TReleaseSlotRequestTupleScheme();
    }
  }

  private static class TReleaseSlotRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<TReleaseSlotRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TReleaseSlotRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetSlot_id()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetSlot_id()) {
        struct.slot_id.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TReleaseSlotRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.slot_id = new com.starrocks.thrift.TUniqueId();
        struct.slot_id.read(iprot);
        struct.setSlot_idIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

