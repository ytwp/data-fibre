/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TLoadTxnCommitResult implements org.apache.thrift.TBase<TLoadTxnCommitResult, TLoadTxnCommitResult._Fields>, java.io.Serializable, Cloneable, Comparable<TLoadTxnCommitResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TLoadTxnCommitResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField RETRY_INTERVAL_MS_FIELD_DESC = new org.apache.thrift.protocol.TField("retry_interval_ms", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TLoadTxnCommitResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TLoadTxnCommitResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TStatus status; // required
  public long retry_interval_ms; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    RETRY_INTERVAL_MS((short)2, "retry_interval_ms");

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
        case 1: // STATUS
          return STATUS;
        case 2: // RETRY_INTERVAL_MS
          return RETRY_INTERVAL_MS;
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
  private static final int __RETRY_INTERVAL_MS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.RETRY_INTERVAL_MS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TStatus.class)));
    tmpMap.put(_Fields.RETRY_INTERVAL_MS, new org.apache.thrift.meta_data.FieldMetaData("retry_interval_ms", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TLoadTxnCommitResult.class, metaDataMap);
  }

  public TLoadTxnCommitResult() {
  }

  public TLoadTxnCommitResult(
    io.datafibre.fibre.thrift.TStatus status)
  {
    this();
    this.status = status;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TLoadTxnCommitResult(TLoadTxnCommitResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStatus()) {
      this.status = new io.datafibre.fibre.thrift.TStatus(other.status);
    }
    this.retry_interval_ms = other.retry_interval_ms;
  }

  @Override
  public TLoadTxnCommitResult deepCopy() {
    return new TLoadTxnCommitResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    setRetry_interval_msIsSet(false);
    this.retry_interval_ms = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TStatus getStatus() {
    return this.status;
  }

  public TLoadTxnCommitResult setStatus(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public long getRetry_interval_ms() {
    return this.retry_interval_ms;
  }

  public TLoadTxnCommitResult setRetry_interval_ms(long retry_interval_ms) {
    this.retry_interval_ms = retry_interval_ms;
    setRetry_interval_msIsSet(true);
    return this;
  }

  public void unsetRetry_interval_ms() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RETRY_INTERVAL_MS_ISSET_ID);
  }

  /** Returns true if field retry_interval_ms is set (has been assigned a value) and false otherwise */
  public boolean isSetRetry_interval_ms() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RETRY_INTERVAL_MS_ISSET_ID);
  }

  public void setRetry_interval_msIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RETRY_INTERVAL_MS_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((io.datafibre.fibre.thrift.TStatus)value);
      }
      break;

    case RETRY_INTERVAL_MS:
      if (value == null) {
        unsetRetry_interval_ms();
      } else {
        setRetry_interval_ms((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case RETRY_INTERVAL_MS:
      return getRetry_interval_ms();

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
    case STATUS:
      return isSetStatus();
    case RETRY_INTERVAL_MS:
      return isSetRetry_interval_ms();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TLoadTxnCommitResult)
      return this.equals((TLoadTxnCommitResult)that);
    return false;
  }

  public boolean equals(TLoadTxnCommitResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_retry_interval_ms = true && this.isSetRetry_interval_ms();
    boolean that_present_retry_interval_ms = true && that.isSetRetry_interval_ms();
    if (this_present_retry_interval_ms || that_present_retry_interval_ms) {
      if (!(this_present_retry_interval_ms && that_present_retry_interval_ms))
        return false;
      if (this.retry_interval_ms != that.retry_interval_ms)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStatus()) ? 131071 : 524287);
    if (isSetStatus())
      hashCode = hashCode * 8191 + status.hashCode();

    hashCode = hashCode * 8191 + ((isSetRetry_interval_ms()) ? 131071 : 524287);
    if (isSetRetry_interval_ms())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(retry_interval_ms);

    return hashCode;
  }

  @Override
  public int compareTo(TLoadTxnCommitResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetStatus(), other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetRetry_interval_ms(), other.isSetRetry_interval_ms());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRetry_interval_ms()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.retry_interval_ms, other.retry_interval_ms);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TLoadTxnCommitResult(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (isSetRetry_interval_ms()) {
      if (!first) sb.append(", ");
      sb.append("retry_interval_ms:");
      sb.append(this.retry_interval_ms);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (status == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (status != null) {
      status.validate();
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TLoadTxnCommitResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TLoadTxnCommitResultStandardScheme getScheme() {
      return new TLoadTxnCommitResultStandardScheme();
    }
  }

  private static class TLoadTxnCommitResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TLoadTxnCommitResult> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TLoadTxnCommitResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.status = new io.datafibre.fibre.thrift.TStatus();
              struct.status.read(iprot);
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RETRY_INTERVAL_MS
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.retry_interval_ms = iprot.readI64();
              struct.setRetry_interval_msIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TLoadTxnCommitResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        struct.status.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.isSetRetry_interval_ms()) {
        oprot.writeFieldBegin(RETRY_INTERVAL_MS_FIELD_DESC);
        oprot.writeI64(struct.retry_interval_ms);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TLoadTxnCommitResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TLoadTxnCommitResultTupleScheme getScheme() {
      return new TLoadTxnCommitResultTupleScheme();
    }
  }

  private static class TLoadTxnCommitResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TLoadTxnCommitResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TLoadTxnCommitResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.status.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetRetry_interval_ms()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetRetry_interval_ms()) {
        oprot.writeI64(struct.retry_interval_ms);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TLoadTxnCommitResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.status = new io.datafibre.fibre.thrift.TStatus();
      struct.status.read(iprot);
      struct.setStatusIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.retry_interval_ms = iprot.readI64();
        struct.setRetry_interval_msIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

