/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TScanRangeLocation implements org.apache.thrift.TBase<TScanRangeLocation, TScanRangeLocation._Fields>, java.io.Serializable, Cloneable, Comparable<TScanRangeLocation> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TScanRangeLocation");

  private static final org.apache.thrift.protocol.TField SERVER_FIELD_DESC = new org.apache.thrift.protocol.TField("server", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField VOLUME_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("volume_id", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField BACKEND_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("backend_id", org.apache.thrift.protocol.TType.I64, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TScanRangeLocationStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TScanRangeLocationTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TNetworkAddress server; // required
  public int volume_id; // optional
  public long backend_id; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SERVER((short)1, "server"),
    VOLUME_ID((short)2, "volume_id"),
    BACKEND_ID((short)3, "backend_id");

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
        case 1: // SERVER
          return SERVER;
        case 2: // VOLUME_ID
          return VOLUME_ID;
        case 3: // BACKEND_ID
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
  private static final int __VOLUME_ID_ISSET_ID = 0;
  private static final int __BACKEND_ID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.VOLUME_ID,_Fields.BACKEND_ID};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SERVER, new org.apache.thrift.meta_data.FieldMetaData("server", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TNetworkAddress.class)));
    tmpMap.put(_Fields.VOLUME_ID, new org.apache.thrift.meta_data.FieldMetaData("volume_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BACKEND_ID, new org.apache.thrift.meta_data.FieldMetaData("backend_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TScanRangeLocation.class, metaDataMap);
  }

  public TScanRangeLocation() {
    this.volume_id = -1;

  }

  public TScanRangeLocation(
    io.datafibre.fibre.thrift.TNetworkAddress server)
  {
    this();
    this.server = server;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TScanRangeLocation(TScanRangeLocation other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetServer()) {
      this.server = new io.datafibre.fibre.thrift.TNetworkAddress(other.server);
    }
    this.volume_id = other.volume_id;
    this.backend_id = other.backend_id;
  }

  @Override
  public TScanRangeLocation deepCopy() {
    return new TScanRangeLocation(this);
  }

  @Override
  public void clear() {
    this.server = null;
    this.volume_id = -1;

    setBackend_idIsSet(false);
    this.backend_id = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TNetworkAddress getServer() {
    return this.server;
  }

  public TScanRangeLocation setServer(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TNetworkAddress server) {
    this.server = server;
    return this;
  }

  public void unsetServer() {
    this.server = null;
  }

  /** Returns true if field server is set (has been assigned a value) and false otherwise */
  public boolean isSetServer() {
    return this.server != null;
  }

  public void setServerIsSet(boolean value) {
    if (!value) {
      this.server = null;
    }
  }

  public int getVolume_id() {
    return this.volume_id;
  }

  public TScanRangeLocation setVolume_id(int volume_id) {
    this.volume_id = volume_id;
    setVolume_idIsSet(true);
    return this;
  }

  public void unsetVolume_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VOLUME_ID_ISSET_ID);
  }

  /** Returns true if field volume_id is set (has been assigned a value) and false otherwise */
  public boolean isSetVolume_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VOLUME_ID_ISSET_ID);
  }

  public void setVolume_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VOLUME_ID_ISSET_ID, value);
  }

  public long getBackend_id() {
    return this.backend_id;
  }

  public TScanRangeLocation setBackend_id(long backend_id) {
    this.backend_id = backend_id;
    setBackend_idIsSet(true);
    return this;
  }

  public void unsetBackend_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BACKEND_ID_ISSET_ID);
  }

  /** Returns true if field backend_id is set (has been assigned a value) and false otherwise */
  public boolean isSetBackend_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BACKEND_ID_ISSET_ID);
  }

  public void setBackend_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BACKEND_ID_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case SERVER:
      if (value == null) {
        unsetServer();
      } else {
        setServer((io.datafibre.fibre.thrift.TNetworkAddress)value);
      }
      break;

    case VOLUME_ID:
      if (value == null) {
        unsetVolume_id();
      } else {
        setVolume_id((java.lang.Integer)value);
      }
      break;

    case BACKEND_ID:
      if (value == null) {
        unsetBackend_id();
      } else {
        setBackend_id((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SERVER:
      return getServer();

    case VOLUME_ID:
      return getVolume_id();

    case BACKEND_ID:
      return getBackend_id();

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
    case SERVER:
      return isSetServer();
    case VOLUME_ID:
      return isSetVolume_id();
    case BACKEND_ID:
      return isSetBackend_id();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TScanRangeLocation)
      return this.equals((TScanRangeLocation)that);
    return false;
  }

  public boolean equals(TScanRangeLocation that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_server = true && this.isSetServer();
    boolean that_present_server = true && that.isSetServer();
    if (this_present_server || that_present_server) {
      if (!(this_present_server && that_present_server))
        return false;
      if (!this.server.equals(that.server))
        return false;
    }

    boolean this_present_volume_id = true && this.isSetVolume_id();
    boolean that_present_volume_id = true && that.isSetVolume_id();
    if (this_present_volume_id || that_present_volume_id) {
      if (!(this_present_volume_id && that_present_volume_id))
        return false;
      if (this.volume_id != that.volume_id)
        return false;
    }

    boolean this_present_backend_id = true && this.isSetBackend_id();
    boolean that_present_backend_id = true && that.isSetBackend_id();
    if (this_present_backend_id || that_present_backend_id) {
      if (!(this_present_backend_id && that_present_backend_id))
        return false;
      if (this.backend_id != that.backend_id)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetServer()) ? 131071 : 524287);
    if (isSetServer())
      hashCode = hashCode * 8191 + server.hashCode();

    hashCode = hashCode * 8191 + ((isSetVolume_id()) ? 131071 : 524287);
    if (isSetVolume_id())
      hashCode = hashCode * 8191 + volume_id;

    hashCode = hashCode * 8191 + ((isSetBackend_id()) ? 131071 : 524287);
    if (isSetBackend_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(backend_id);

    return hashCode;
  }

  @Override
  public int compareTo(TScanRangeLocation other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetServer(), other.isSetServer());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServer()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.server, other.server);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetVolume_id(), other.isSetVolume_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVolume_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.volume_id, other.volume_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetBackend_id(), other.isSetBackend_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBackend_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.backend_id, other.backend_id);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TScanRangeLocation(");
    boolean first = true;

    sb.append("server:");
    if (this.server == null) {
      sb.append("null");
    } else {
      sb.append(this.server);
    }
    first = false;
    if (isSetVolume_id()) {
      if (!first) sb.append(", ");
      sb.append("volume_id:");
      sb.append(this.volume_id);
      first = false;
    }
    if (isSetBackend_id()) {
      if (!first) sb.append(", ");
      sb.append("backend_id:");
      sb.append(this.backend_id);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (server == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'server' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (server != null) {
      server.validate();
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

  private static class TScanRangeLocationStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TScanRangeLocationStandardScheme getScheme() {
      return new TScanRangeLocationStandardScheme();
    }
  }

  private static class TScanRangeLocationStandardScheme extends org.apache.thrift.scheme.StandardScheme<TScanRangeLocation> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TScanRangeLocation struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SERVER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.server = new io.datafibre.fibre.thrift.TNetworkAddress();
              struct.server.read(iprot);
              struct.setServerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VOLUME_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.volume_id = iprot.readI32();
              struct.setVolume_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BACKEND_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.backend_id = iprot.readI64();
              struct.setBackend_idIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TScanRangeLocation struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.server != null) {
        oprot.writeFieldBegin(SERVER_FIELD_DESC);
        struct.server.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.isSetVolume_id()) {
        oprot.writeFieldBegin(VOLUME_ID_FIELD_DESC);
        oprot.writeI32(struct.volume_id);
        oprot.writeFieldEnd();
      }
      if (struct.isSetBackend_id()) {
        oprot.writeFieldBegin(BACKEND_ID_FIELD_DESC);
        oprot.writeI64(struct.backend_id);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TScanRangeLocationTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TScanRangeLocationTupleScheme getScheme() {
      return new TScanRangeLocationTupleScheme();
    }
  }

  private static class TScanRangeLocationTupleScheme extends org.apache.thrift.scheme.TupleScheme<TScanRangeLocation> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TScanRangeLocation struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.server.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetVolume_id()) {
        optionals.set(0);
      }
      if (struct.isSetBackend_id()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetVolume_id()) {
        oprot.writeI32(struct.volume_id);
      }
      if (struct.isSetBackend_id()) {
        oprot.writeI64(struct.backend_id);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TScanRangeLocation struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.server = new io.datafibre.fibre.thrift.TNetworkAddress();
      struct.server.read(iprot);
      struct.setServerIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.volume_id = iprot.readI32();
        struct.setVolume_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.backend_id = iprot.readI64();
        struct.setBackend_idIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

