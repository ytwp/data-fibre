/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TMiniLoadEtlStatusRequest implements org.apache.thrift.TBase<TMiniLoadEtlStatusRequest, TMiniLoadEtlStatusRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TMiniLoadEtlStatusRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TMiniLoadEtlStatusRequest");

  private static final org.apache.thrift.protocol.TField PROTOCOL_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("protocol_version", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MINI_LOAD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("mini_load_id", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TMiniLoadEtlStatusRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TMiniLoadEtlStatusRequestTupleSchemeFactory();

  /**
   * 
   * @see TAgentServiceVersion
   */
  public @org.apache.thrift.annotation.Nullable TAgentServiceVersion protocol_version; // required
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUniqueId mini_load_id; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see TAgentServiceVersion
     */
    PROTOCOL_VERSION((short)1, "protocol_version"),
    MINI_LOAD_ID((short)2, "mini_load_id");

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
        case 1: // PROTOCOL_VERSION
          return PROTOCOL_VERSION;
        case 2: // MINI_LOAD_ID
          return MINI_LOAD_ID;
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
    tmpMap.put(_Fields.PROTOCOL_VERSION, new org.apache.thrift.meta_data.FieldMetaData("protocol_version", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TAgentServiceVersion.class)));
    tmpMap.put(_Fields.MINI_LOAD_ID, new org.apache.thrift.meta_data.FieldMetaData("mini_load_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TUniqueId.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TMiniLoadEtlStatusRequest.class, metaDataMap);
  }

  public TMiniLoadEtlStatusRequest() {
  }

  public TMiniLoadEtlStatusRequest(
    TAgentServiceVersion protocol_version,
    io.datafibre.fibre.thrift.TUniqueId mini_load_id)
  {
    this();
    this.protocol_version = protocol_version;
    this.mini_load_id = mini_load_id;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TMiniLoadEtlStatusRequest(TMiniLoadEtlStatusRequest other) {
    if (other.isSetProtocol_version()) {
      this.protocol_version = other.protocol_version;
    }
    if (other.isSetMini_load_id()) {
      this.mini_load_id = new io.datafibre.fibre.thrift.TUniqueId(other.mini_load_id);
    }
  }

  @Override
  public TMiniLoadEtlStatusRequest deepCopy() {
    return new TMiniLoadEtlStatusRequest(this);
  }

  @Override
  public void clear() {
    this.protocol_version = null;
    this.mini_load_id = null;
  }

  /**
   * 
   * @see TAgentServiceVersion
   */
  @org.apache.thrift.annotation.Nullable
  public TAgentServiceVersion getProtocol_version() {
    return this.protocol_version;
  }

  /**
   * 
   * @see TAgentServiceVersion
   */
  public TMiniLoadEtlStatusRequest setProtocol_version(@org.apache.thrift.annotation.Nullable TAgentServiceVersion protocol_version) {
    this.protocol_version = protocol_version;
    return this;
  }

  public void unsetProtocol_version() {
    this.protocol_version = null;
  }

  /** Returns true if field protocol_version is set (has been assigned a value) and false otherwise */
  public boolean isSetProtocol_version() {
    return this.protocol_version != null;
  }

  public void setProtocol_versionIsSet(boolean value) {
    if (!value) {
      this.protocol_version = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TUniqueId getMini_load_id() {
    return this.mini_load_id;
  }

  public TMiniLoadEtlStatusRequest setMini_load_id(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUniqueId mini_load_id) {
    this.mini_load_id = mini_load_id;
    return this;
  }

  public void unsetMini_load_id() {
    this.mini_load_id = null;
  }

  /** Returns true if field mini_load_id is set (has been assigned a value) and false otherwise */
  public boolean isSetMini_load_id() {
    return this.mini_load_id != null;
  }

  public void setMini_load_idIsSet(boolean value) {
    if (!value) {
      this.mini_load_id = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PROTOCOL_VERSION:
      if (value == null) {
        unsetProtocol_version();
      } else {
        setProtocol_version((TAgentServiceVersion)value);
      }
      break;

    case MINI_LOAD_ID:
      if (value == null) {
        unsetMini_load_id();
      } else {
        setMini_load_id((io.datafibre.fibre.thrift.TUniqueId)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PROTOCOL_VERSION:
      return getProtocol_version();

    case MINI_LOAD_ID:
      return getMini_load_id();

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
    case PROTOCOL_VERSION:
      return isSetProtocol_version();
    case MINI_LOAD_ID:
      return isSetMini_load_id();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TMiniLoadEtlStatusRequest)
      return this.equals((TMiniLoadEtlStatusRequest)that);
    return false;
  }

  public boolean equals(TMiniLoadEtlStatusRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_protocol_version = true && this.isSetProtocol_version();
    boolean that_present_protocol_version = true && that.isSetProtocol_version();
    if (this_present_protocol_version || that_present_protocol_version) {
      if (!(this_present_protocol_version && that_present_protocol_version))
        return false;
      if (!this.protocol_version.equals(that.protocol_version))
        return false;
    }

    boolean this_present_mini_load_id = true && this.isSetMini_load_id();
    boolean that_present_mini_load_id = true && that.isSetMini_load_id();
    if (this_present_mini_load_id || that_present_mini_load_id) {
      if (!(this_present_mini_load_id && that_present_mini_load_id))
        return false;
      if (!this.mini_load_id.equals(that.mini_load_id))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetProtocol_version()) ? 131071 : 524287);
    if (isSetProtocol_version())
      hashCode = hashCode * 8191 + protocol_version.getValue();

    hashCode = hashCode * 8191 + ((isSetMini_load_id()) ? 131071 : 524287);
    if (isSetMini_load_id())
      hashCode = hashCode * 8191 + mini_load_id.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TMiniLoadEtlStatusRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetProtocol_version(), other.isSetProtocol_version());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProtocol_version()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.protocol_version, other.protocol_version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetMini_load_id(), other.isSetMini_load_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMini_load_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mini_load_id, other.mini_load_id);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TMiniLoadEtlStatusRequest(");
    boolean first = true;

    sb.append("protocol_version:");
    if (this.protocol_version == null) {
      sb.append("null");
    } else {
      sb.append(this.protocol_version);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("mini_load_id:");
    if (this.mini_load_id == null) {
      sb.append("null");
    } else {
      sb.append(this.mini_load_id);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (protocol_version == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'protocol_version' was not present! Struct: " + toString());
    }
    if (mini_load_id == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'mini_load_id' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (mini_load_id != null) {
      mini_load_id.validate();
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

  private static class TMiniLoadEtlStatusRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TMiniLoadEtlStatusRequestStandardScheme getScheme() {
      return new TMiniLoadEtlStatusRequestStandardScheme();
    }
  }

  private static class TMiniLoadEtlStatusRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<TMiniLoadEtlStatusRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TMiniLoadEtlStatusRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PROTOCOL_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.protocol_version = io.datafibre.fibre.thrift.TAgentServiceVersion.findByValue(iprot.readI32());
              struct.setProtocol_versionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MINI_LOAD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.mini_load_id = new io.datafibre.fibre.thrift.TUniqueId();
              struct.mini_load_id.read(iprot);
              struct.setMini_load_idIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TMiniLoadEtlStatusRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.protocol_version != null) {
        oprot.writeFieldBegin(PROTOCOL_VERSION_FIELD_DESC);
        oprot.writeI32(struct.protocol_version.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.mini_load_id != null) {
        oprot.writeFieldBegin(MINI_LOAD_ID_FIELD_DESC);
        struct.mini_load_id.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TMiniLoadEtlStatusRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TMiniLoadEtlStatusRequestTupleScheme getScheme() {
      return new TMiniLoadEtlStatusRequestTupleScheme();
    }
  }

  private static class TMiniLoadEtlStatusRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<TMiniLoadEtlStatusRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TMiniLoadEtlStatusRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.protocol_version.getValue());
      struct.mini_load_id.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TMiniLoadEtlStatusRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.protocol_version = io.datafibre.fibre.thrift.TAgentServiceVersion.findByValue(iprot.readI32());
      struct.setProtocol_versionIsSet(true);
      struct.mini_load_id = new io.datafibre.fibre.thrift.TUniqueId();
      struct.mini_load_id.read(iprot);
      struct.setMini_load_idIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

