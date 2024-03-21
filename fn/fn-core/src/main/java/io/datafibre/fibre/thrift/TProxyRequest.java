/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TProxyRequest implements org.apache.thrift.TBase<TProxyRequest, TProxyRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TProxyRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TProxyRequest");

  private static final org.apache.thrift.protocol.TField KAFKA_META_REQUEST_FIELD_DESC = new org.apache.thrift.protocol.TField("kafka_meta_request", org.apache.thrift.protocol.TType.STRUCT, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TProxyRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TProxyRequestTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable TKafkaMetaProxyRequest kafka_meta_request; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    KAFKA_META_REQUEST((short)1, "kafka_meta_request");

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
        case 1: // KAFKA_META_REQUEST
          return KAFKA_META_REQUEST;
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
  private static final _Fields optionals[] = {_Fields.KAFKA_META_REQUEST};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.KAFKA_META_REQUEST, new org.apache.thrift.meta_data.FieldMetaData("kafka_meta_request", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TKafkaMetaProxyRequest.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TProxyRequest.class, metaDataMap);
  }

  public TProxyRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TProxyRequest(TProxyRequest other) {
    if (other.isSetKafka_meta_request()) {
      this.kafka_meta_request = new TKafkaMetaProxyRequest(other.kafka_meta_request);
    }
  }

  @Override
  public TProxyRequest deepCopy() {
    return new TProxyRequest(this);
  }

  @Override
  public void clear() {
    this.kafka_meta_request = null;
  }

  @org.apache.thrift.annotation.Nullable
  public TKafkaMetaProxyRequest getKafka_meta_request() {
    return this.kafka_meta_request;
  }

  public TProxyRequest setKafka_meta_request(@org.apache.thrift.annotation.Nullable TKafkaMetaProxyRequest kafka_meta_request) {
    this.kafka_meta_request = kafka_meta_request;
    return this;
  }

  public void unsetKafka_meta_request() {
    this.kafka_meta_request = null;
  }

  /** Returns true if field kafka_meta_request is set (has been assigned a value) and false otherwise */
  public boolean isSetKafka_meta_request() {
    return this.kafka_meta_request != null;
  }

  public void setKafka_meta_requestIsSet(boolean value) {
    if (!value) {
      this.kafka_meta_request = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case KAFKA_META_REQUEST:
      if (value == null) {
        unsetKafka_meta_request();
      } else {
        setKafka_meta_request((TKafkaMetaProxyRequest)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case KAFKA_META_REQUEST:
      return getKafka_meta_request();

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
    case KAFKA_META_REQUEST:
      return isSetKafka_meta_request();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TProxyRequest)
      return this.equals((TProxyRequest)that);
    return false;
  }

  public boolean equals(TProxyRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_kafka_meta_request = true && this.isSetKafka_meta_request();
    boolean that_present_kafka_meta_request = true && that.isSetKafka_meta_request();
    if (this_present_kafka_meta_request || that_present_kafka_meta_request) {
      if (!(this_present_kafka_meta_request && that_present_kafka_meta_request))
        return false;
      if (!this.kafka_meta_request.equals(that.kafka_meta_request))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetKafka_meta_request()) ? 131071 : 524287);
    if (isSetKafka_meta_request())
      hashCode = hashCode * 8191 + kafka_meta_request.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TProxyRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetKafka_meta_request(), other.isSetKafka_meta_request());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKafka_meta_request()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.kafka_meta_request, other.kafka_meta_request);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TProxyRequest(");
    boolean first = true;

    if (isSetKafka_meta_request()) {
      sb.append("kafka_meta_request:");
      if (this.kafka_meta_request == null) {
        sb.append("null");
      } else {
        sb.append(this.kafka_meta_request);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (kafka_meta_request != null) {
      kafka_meta_request.validate();
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

  private static class TProxyRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TProxyRequestStandardScheme getScheme() {
      return new TProxyRequestStandardScheme();
    }
  }

  private static class TProxyRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<TProxyRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TProxyRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // KAFKA_META_REQUEST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.kafka_meta_request = new TKafkaMetaProxyRequest();
              struct.kafka_meta_request.read(iprot);
              struct.setKafka_meta_requestIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TProxyRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.kafka_meta_request != null) {
        if (struct.isSetKafka_meta_request()) {
          oprot.writeFieldBegin(KAFKA_META_REQUEST_FIELD_DESC);
          struct.kafka_meta_request.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TProxyRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TProxyRequestTupleScheme getScheme() {
      return new TProxyRequestTupleScheme();
    }
  }

  private static class TProxyRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<TProxyRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TProxyRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetKafka_meta_request()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetKafka_meta_request()) {
        struct.kafka_meta_request.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TProxyRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.kafka_meta_request = new TKafkaMetaProxyRequest();
        struct.kafka_meta_request.read(iprot);
        struct.setKafka_meta_requestIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
