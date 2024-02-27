/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TMVAbortEpochTask implements org.apache.thrift.TBase<TMVAbortEpochTask, TMVAbortEpochTask._Fields>, java.io.Serializable, Cloneable, Comparable<TMVAbortEpochTask> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TMVAbortEpochTask");

  private static final org.apache.thrift.protocol.TField EPOCH_FIELD_DESC = new org.apache.thrift.protocol.TField("epoch", org.apache.thrift.protocol.TType.STRUCT, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TMVAbortEpochTaskStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TMVAbortEpochTaskTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable TMVEpoch epoch; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EPOCH((short)1, "epoch");

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
        case 1: // EPOCH
          return EPOCH;
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
  private static final _Fields optionals[] = {_Fields.EPOCH};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EPOCH, new org.apache.thrift.meta_data.FieldMetaData("epoch", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TMVEpoch.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TMVAbortEpochTask.class, metaDataMap);
  }

  public TMVAbortEpochTask() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TMVAbortEpochTask(TMVAbortEpochTask other) {
    if (other.isSetEpoch()) {
      this.epoch = new TMVEpoch(other.epoch);
    }
  }

  @Override
  public TMVAbortEpochTask deepCopy() {
    return new TMVAbortEpochTask(this);
  }

  @Override
  public void clear() {
    this.epoch = null;
  }

  @org.apache.thrift.annotation.Nullable
  public TMVEpoch getEpoch() {
    return this.epoch;
  }

  public TMVAbortEpochTask setEpoch(@org.apache.thrift.annotation.Nullable TMVEpoch epoch) {
    this.epoch = epoch;
    return this;
  }

  public void unsetEpoch() {
    this.epoch = null;
  }

  /** Returns true if field epoch is set (has been assigned a value) and false otherwise */
  public boolean isSetEpoch() {
    return this.epoch != null;
  }

  public void setEpochIsSet(boolean value) {
    if (!value) {
      this.epoch = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case EPOCH:
      if (value == null) {
        unsetEpoch();
      } else {
        setEpoch((TMVEpoch)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case EPOCH:
      return getEpoch();

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
    case EPOCH:
      return isSetEpoch();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TMVAbortEpochTask)
      return this.equals((TMVAbortEpochTask)that);
    return false;
  }

  public boolean equals(TMVAbortEpochTask that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_epoch = true && this.isSetEpoch();
    boolean that_present_epoch = true && that.isSetEpoch();
    if (this_present_epoch || that_present_epoch) {
      if (!(this_present_epoch && that_present_epoch))
        return false;
      if (!this.epoch.equals(that.epoch))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetEpoch()) ? 131071 : 524287);
    if (isSetEpoch())
      hashCode = hashCode * 8191 + epoch.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TMVAbortEpochTask other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetEpoch(), other.isSetEpoch());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEpoch()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.epoch, other.epoch);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TMVAbortEpochTask(");
    boolean first = true;

    if (isSetEpoch()) {
      sb.append("epoch:");
      if (this.epoch == null) {
        sb.append("null");
      } else {
        sb.append(this.epoch);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (epoch != null) {
      epoch.validate();
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

  private static class TMVAbortEpochTaskStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TMVAbortEpochTaskStandardScheme getScheme() {
      return new TMVAbortEpochTaskStandardScheme();
    }
  }

  private static class TMVAbortEpochTaskStandardScheme extends org.apache.thrift.scheme.StandardScheme<TMVAbortEpochTask> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TMVAbortEpochTask struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EPOCH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.epoch = new TMVEpoch();
              struct.epoch.read(iprot);
              struct.setEpochIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TMVAbortEpochTask struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.epoch != null) {
        if (struct.isSetEpoch()) {
          oprot.writeFieldBegin(EPOCH_FIELD_DESC);
          struct.epoch.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TMVAbortEpochTaskTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TMVAbortEpochTaskTupleScheme getScheme() {
      return new TMVAbortEpochTaskTupleScheme();
    }
  }

  private static class TMVAbortEpochTaskTupleScheme extends org.apache.thrift.scheme.TupleScheme<TMVAbortEpochTask> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TMVAbortEpochTask struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetEpoch()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetEpoch()) {
        struct.epoch.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TMVAbortEpochTask struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.epoch = new TMVEpoch();
        struct.epoch.read(iprot);
        struct.setEpochIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

