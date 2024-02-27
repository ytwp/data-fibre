/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TLoadTxnBeginResult implements org.apache.thrift.TBase<TLoadTxnBeginResult, TLoadTxnBeginResult._Fields>, java.io.Serializable, Cloneable, Comparable<TLoadTxnBeginResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TLoadTxnBeginResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TXN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("txnId", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField JOB_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("job_status", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TIMEOUT_FIELD_DESC = new org.apache.thrift.protocol.TField("timeout", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TLoadTxnBeginResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TLoadTxnBeginResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStatus status; // required
  public long txnId; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String job_status; // optional
  public long timeout; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    TXN_ID((short)2, "txnId"),
    JOB_STATUS((short)3, "job_status"),
    TIMEOUT((short)4, "timeout");

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
        case 2: // TXN_ID
          return TXN_ID;
        case 3: // JOB_STATUS
          return JOB_STATUS;
        case 4: // TIMEOUT
          return TIMEOUT;
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
  private static final int __TXNID_ISSET_ID = 0;
  private static final int __TIMEOUT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TXN_ID,_Fields.JOB_STATUS,_Fields.TIMEOUT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TStatus.class)));
    tmpMap.put(_Fields.TXN_ID, new org.apache.thrift.meta_data.FieldMetaData("txnId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.JOB_STATUS, new org.apache.thrift.meta_data.FieldMetaData("job_status", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TIMEOUT, new org.apache.thrift.meta_data.FieldMetaData("timeout", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TLoadTxnBeginResult.class, metaDataMap);
  }

  public TLoadTxnBeginResult() {
  }

  public TLoadTxnBeginResult(
    com.starrocks.thrift.TStatus status)
  {
    this();
    this.status = status;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TLoadTxnBeginResult(TLoadTxnBeginResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStatus()) {
      this.status = new com.starrocks.thrift.TStatus(other.status);
    }
    this.txnId = other.txnId;
    if (other.isSetJob_status()) {
      this.job_status = other.job_status;
    }
    this.timeout = other.timeout;
  }

  @Override
  public TLoadTxnBeginResult deepCopy() {
    return new TLoadTxnBeginResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    setTxnIdIsSet(false);
    this.txnId = 0;
    this.job_status = null;
    setTimeoutIsSet(false);
    this.timeout = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TStatus getStatus() {
    return this.status;
  }

  public TLoadTxnBeginResult setStatus(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStatus status) {
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

  public long getTxnId() {
    return this.txnId;
  }

  public TLoadTxnBeginResult setTxnId(long txnId) {
    this.txnId = txnId;
    setTxnIdIsSet(true);
    return this;
  }

  public void unsetTxnId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TXNID_ISSET_ID);
  }

  /** Returns true if field txnId is set (has been assigned a value) and false otherwise */
  public boolean isSetTxnId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TXNID_ISSET_ID);
  }

  public void setTxnIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TXNID_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJob_status() {
    return this.job_status;
  }

  public TLoadTxnBeginResult setJob_status(@org.apache.thrift.annotation.Nullable java.lang.String job_status) {
    this.job_status = job_status;
    return this;
  }

  public void unsetJob_status() {
    this.job_status = null;
  }

  /** Returns true if field job_status is set (has been assigned a value) and false otherwise */
  public boolean isSetJob_status() {
    return this.job_status != null;
  }

  public void setJob_statusIsSet(boolean value) {
    if (!value) {
      this.job_status = null;
    }
  }

  public long getTimeout() {
    return this.timeout;
  }

  public TLoadTxnBeginResult setTimeout(long timeout) {
    this.timeout = timeout;
    setTimeoutIsSet(true);
    return this;
  }

  public void unsetTimeout() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TIMEOUT_ISSET_ID);
  }

  /** Returns true if field timeout is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeout() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TIMEOUT_ISSET_ID);
  }

  public void setTimeoutIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TIMEOUT_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((com.starrocks.thrift.TStatus)value);
      }
      break;

    case TXN_ID:
      if (value == null) {
        unsetTxnId();
      } else {
        setTxnId((java.lang.Long)value);
      }
      break;

    case JOB_STATUS:
      if (value == null) {
        unsetJob_status();
      } else {
        setJob_status((java.lang.String)value);
      }
      break;

    case TIMEOUT:
      if (value == null) {
        unsetTimeout();
      } else {
        setTimeout((java.lang.Long)value);
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

    case TXN_ID:
      return getTxnId();

    case JOB_STATUS:
      return getJob_status();

    case TIMEOUT:
      return getTimeout();

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
    case TXN_ID:
      return isSetTxnId();
    case JOB_STATUS:
      return isSetJob_status();
    case TIMEOUT:
      return isSetTimeout();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TLoadTxnBeginResult)
      return this.equals((TLoadTxnBeginResult)that);
    return false;
  }

  public boolean equals(TLoadTxnBeginResult that) {
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

    boolean this_present_txnId = true && this.isSetTxnId();
    boolean that_present_txnId = true && that.isSetTxnId();
    if (this_present_txnId || that_present_txnId) {
      if (!(this_present_txnId && that_present_txnId))
        return false;
      if (this.txnId != that.txnId)
        return false;
    }

    boolean this_present_job_status = true && this.isSetJob_status();
    boolean that_present_job_status = true && that.isSetJob_status();
    if (this_present_job_status || that_present_job_status) {
      if (!(this_present_job_status && that_present_job_status))
        return false;
      if (!this.job_status.equals(that.job_status))
        return false;
    }

    boolean this_present_timeout = true && this.isSetTimeout();
    boolean that_present_timeout = true && that.isSetTimeout();
    if (this_present_timeout || that_present_timeout) {
      if (!(this_present_timeout && that_present_timeout))
        return false;
      if (this.timeout != that.timeout)
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

    hashCode = hashCode * 8191 + ((isSetTxnId()) ? 131071 : 524287);
    if (isSetTxnId())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(txnId);

    hashCode = hashCode * 8191 + ((isSetJob_status()) ? 131071 : 524287);
    if (isSetJob_status())
      hashCode = hashCode * 8191 + job_status.hashCode();

    hashCode = hashCode * 8191 + ((isSetTimeout()) ? 131071 : 524287);
    if (isSetTimeout())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(timeout);

    return hashCode;
  }

  @Override
  public int compareTo(TLoadTxnBeginResult other) {
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
    lastComparison = java.lang.Boolean.compare(isSetTxnId(), other.isSetTxnId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTxnId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.txnId, other.txnId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJob_status(), other.isSetJob_status());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJob_status()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.job_status, other.job_status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTimeout(), other.isSetTimeout());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeout()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeout, other.timeout);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TLoadTxnBeginResult(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (isSetTxnId()) {
      if (!first) sb.append(", ");
      sb.append("txnId:");
      sb.append(this.txnId);
      first = false;
    }
    if (isSetJob_status()) {
      if (!first) sb.append(", ");
      sb.append("job_status:");
      if (this.job_status == null) {
        sb.append("null");
      } else {
        sb.append(this.job_status);
      }
      first = false;
    }
    if (isSetTimeout()) {
      if (!first) sb.append(", ");
      sb.append("timeout:");
      sb.append(this.timeout);
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

  private static class TLoadTxnBeginResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TLoadTxnBeginResultStandardScheme getScheme() {
      return new TLoadTxnBeginResultStandardScheme();
    }
  }

  private static class TLoadTxnBeginResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TLoadTxnBeginResult> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TLoadTxnBeginResult struct) throws org.apache.thrift.TException {
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
              struct.status = new com.starrocks.thrift.TStatus();
              struct.status.read(iprot);
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TXN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.txnId = iprot.readI64();
              struct.setTxnIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // JOB_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.job_status = iprot.readString();
              struct.setJob_statusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TIMEOUT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeout = iprot.readI64();
              struct.setTimeoutIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TLoadTxnBeginResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        struct.status.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTxnId()) {
        oprot.writeFieldBegin(TXN_ID_FIELD_DESC);
        oprot.writeI64(struct.txnId);
        oprot.writeFieldEnd();
      }
      if (struct.job_status != null) {
        if (struct.isSetJob_status()) {
          oprot.writeFieldBegin(JOB_STATUS_FIELD_DESC);
          oprot.writeString(struct.job_status);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetTimeout()) {
        oprot.writeFieldBegin(TIMEOUT_FIELD_DESC);
        oprot.writeI64(struct.timeout);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TLoadTxnBeginResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TLoadTxnBeginResultTupleScheme getScheme() {
      return new TLoadTxnBeginResultTupleScheme();
    }
  }

  private static class TLoadTxnBeginResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TLoadTxnBeginResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TLoadTxnBeginResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.status.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTxnId()) {
        optionals.set(0);
      }
      if (struct.isSetJob_status()) {
        optionals.set(1);
      }
      if (struct.isSetTimeout()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetTxnId()) {
        oprot.writeI64(struct.txnId);
      }
      if (struct.isSetJob_status()) {
        oprot.writeString(struct.job_status);
      }
      if (struct.isSetTimeout()) {
        oprot.writeI64(struct.timeout);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TLoadTxnBeginResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.status = new com.starrocks.thrift.TStatus();
      struct.status.read(iprot);
      struct.setStatusIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.txnId = iprot.readI64();
        struct.setTxnIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.job_status = iprot.readString();
        struct.setJob_statusIsSet(true);
      }
      if (incoming.get(2)) {
        struct.timeout = iprot.readI64();
        struct.setTimeoutIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

