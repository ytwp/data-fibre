/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TBackendMeta implements org.apache.thrift.TBase<TBackendMeta, TBackendMeta._Fields>, java.io.Serializable, Cloneable, Comparable<TBackendMeta> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TBackendMeta");

  private static final org.apache.thrift.protocol.TField BACKEND_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("backend_id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField BE_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("be_port", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField RPC_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("rpc_port", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField HTTP_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("http_port", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField ALIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("alive", org.apache.thrift.protocol.TType.BOOL, (short)6);
  private static final org.apache.thrift.protocol.TField STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("state", org.apache.thrift.protocol.TType.I32, (short)7);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TBackendMetaStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TBackendMetaTupleSchemeFactory();

  public long backend_id; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String host; // optional
  public int be_port; // optional
  public int rpc_port; // optional
  public int http_port; // optional
  public boolean alive; // optional
  public int state; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BACKEND_ID((short)1, "backend_id"),
    HOST((short)2, "host"),
    BE_PORT((short)3, "be_port"),
    RPC_PORT((short)4, "rpc_port"),
    HTTP_PORT((short)5, "http_port"),
    ALIVE((short)6, "alive"),
    STATE((short)7, "state");

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
        case 1: // BACKEND_ID
          return BACKEND_ID;
        case 2: // HOST
          return HOST;
        case 3: // BE_PORT
          return BE_PORT;
        case 4: // RPC_PORT
          return RPC_PORT;
        case 5: // HTTP_PORT
          return HTTP_PORT;
        case 6: // ALIVE
          return ALIVE;
        case 7: // STATE
          return STATE;
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
  private static final int __BACKEND_ID_ISSET_ID = 0;
  private static final int __BE_PORT_ISSET_ID = 1;
  private static final int __RPC_PORT_ISSET_ID = 2;
  private static final int __HTTP_PORT_ISSET_ID = 3;
  private static final int __ALIVE_ISSET_ID = 4;
  private static final int __STATE_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.BACKEND_ID,_Fields.HOST,_Fields.BE_PORT,_Fields.RPC_PORT,_Fields.HTTP_PORT,_Fields.ALIVE,_Fields.STATE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BACKEND_ID, new org.apache.thrift.meta_data.FieldMetaData("backend_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BE_PORT, new org.apache.thrift.meta_data.FieldMetaData("be_port", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.RPC_PORT, new org.apache.thrift.meta_data.FieldMetaData("rpc_port", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.HTTP_PORT, new org.apache.thrift.meta_data.FieldMetaData("http_port", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ALIVE, new org.apache.thrift.meta_data.FieldMetaData("alive", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.STATE, new org.apache.thrift.meta_data.FieldMetaData("state", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TBackendMeta.class, metaDataMap);
  }

  public TBackendMeta() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TBackendMeta(TBackendMeta other) {
    __isset_bitfield = other.__isset_bitfield;
    this.backend_id = other.backend_id;
    if (other.isSetHost()) {
      this.host = other.host;
    }
    this.be_port = other.be_port;
    this.rpc_port = other.rpc_port;
    this.http_port = other.http_port;
    this.alive = other.alive;
    this.state = other.state;
  }

  @Override
  public TBackendMeta deepCopy() {
    return new TBackendMeta(this);
  }

  @Override
  public void clear() {
    setBackend_idIsSet(false);
    this.backend_id = 0;
    this.host = null;
    setBe_portIsSet(false);
    this.be_port = 0;
    setRpc_portIsSet(false);
    this.rpc_port = 0;
    setHttp_portIsSet(false);
    this.http_port = 0;
    setAliveIsSet(false);
    this.alive = false;
    setStateIsSet(false);
    this.state = 0;
  }

  public long getBackend_id() {
    return this.backend_id;
  }

  public TBackendMeta setBackend_id(long backend_id) {
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

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getHost() {
    return this.host;
  }

  public TBackendMeta setHost(@org.apache.thrift.annotation.Nullable java.lang.String host) {
    this.host = host;
    return this;
  }

  public void unsetHost() {
    this.host = null;
  }

  /** Returns true if field host is set (has been assigned a value) and false otherwise */
  public boolean isSetHost() {
    return this.host != null;
  }

  public void setHostIsSet(boolean value) {
    if (!value) {
      this.host = null;
    }
  }

  public int getBe_port() {
    return this.be_port;
  }

  public TBackendMeta setBe_port(int be_port) {
    this.be_port = be_port;
    setBe_portIsSet(true);
    return this;
  }

  public void unsetBe_port() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BE_PORT_ISSET_ID);
  }

  /** Returns true if field be_port is set (has been assigned a value) and false otherwise */
  public boolean isSetBe_port() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BE_PORT_ISSET_ID);
  }

  public void setBe_portIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BE_PORT_ISSET_ID, value);
  }

  public int getRpc_port() {
    return this.rpc_port;
  }

  public TBackendMeta setRpc_port(int rpc_port) {
    this.rpc_port = rpc_port;
    setRpc_portIsSet(true);
    return this;
  }

  public void unsetRpc_port() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RPC_PORT_ISSET_ID);
  }

  /** Returns true if field rpc_port is set (has been assigned a value) and false otherwise */
  public boolean isSetRpc_port() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RPC_PORT_ISSET_ID);
  }

  public void setRpc_portIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RPC_PORT_ISSET_ID, value);
  }

  public int getHttp_port() {
    return this.http_port;
  }

  public TBackendMeta setHttp_port(int http_port) {
    this.http_port = http_port;
    setHttp_portIsSet(true);
    return this;
  }

  public void unsetHttp_port() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __HTTP_PORT_ISSET_ID);
  }

  /** Returns true if field http_port is set (has been assigned a value) and false otherwise */
  public boolean isSetHttp_port() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __HTTP_PORT_ISSET_ID);
  }

  public void setHttp_portIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __HTTP_PORT_ISSET_ID, value);
  }

  public boolean isAlive() {
    return this.alive;
  }

  public TBackendMeta setAlive(boolean alive) {
    this.alive = alive;
    setAliveIsSet(true);
    return this;
  }

  public void unsetAlive() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ALIVE_ISSET_ID);
  }

  /** Returns true if field alive is set (has been assigned a value) and false otherwise */
  public boolean isSetAlive() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ALIVE_ISSET_ID);
  }

  public void setAliveIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ALIVE_ISSET_ID, value);
  }

  public int getState() {
    return this.state;
  }

  public TBackendMeta setState(int state) {
    this.state = state;
    setStateIsSet(true);
    return this;
  }

  public void unsetState() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __STATE_ISSET_ID);
  }

  /** Returns true if field state is set (has been assigned a value) and false otherwise */
  public boolean isSetState() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __STATE_ISSET_ID);
  }

  public void setStateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __STATE_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case BACKEND_ID:
      if (value == null) {
        unsetBackend_id();
      } else {
        setBackend_id((java.lang.Long)value);
      }
      break;

    case HOST:
      if (value == null) {
        unsetHost();
      } else {
        setHost((java.lang.String)value);
      }
      break;

    case BE_PORT:
      if (value == null) {
        unsetBe_port();
      } else {
        setBe_port((java.lang.Integer)value);
      }
      break;

    case RPC_PORT:
      if (value == null) {
        unsetRpc_port();
      } else {
        setRpc_port((java.lang.Integer)value);
      }
      break;

    case HTTP_PORT:
      if (value == null) {
        unsetHttp_port();
      } else {
        setHttp_port((java.lang.Integer)value);
      }
      break;

    case ALIVE:
      if (value == null) {
        unsetAlive();
      } else {
        setAlive((java.lang.Boolean)value);
      }
      break;

    case STATE:
      if (value == null) {
        unsetState();
      } else {
        setState((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case BACKEND_ID:
      return getBackend_id();

    case HOST:
      return getHost();

    case BE_PORT:
      return getBe_port();

    case RPC_PORT:
      return getRpc_port();

    case HTTP_PORT:
      return getHttp_port();

    case ALIVE:
      return isAlive();

    case STATE:
      return getState();

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
    case BACKEND_ID:
      return isSetBackend_id();
    case HOST:
      return isSetHost();
    case BE_PORT:
      return isSetBe_port();
    case RPC_PORT:
      return isSetRpc_port();
    case HTTP_PORT:
      return isSetHttp_port();
    case ALIVE:
      return isSetAlive();
    case STATE:
      return isSetState();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TBackendMeta)
      return this.equals((TBackendMeta)that);
    return false;
  }

  public boolean equals(TBackendMeta that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_backend_id = true && this.isSetBackend_id();
    boolean that_present_backend_id = true && that.isSetBackend_id();
    if (this_present_backend_id || that_present_backend_id) {
      if (!(this_present_backend_id && that_present_backend_id))
        return false;
      if (this.backend_id != that.backend_id)
        return false;
    }

    boolean this_present_host = true && this.isSetHost();
    boolean that_present_host = true && that.isSetHost();
    if (this_present_host || that_present_host) {
      if (!(this_present_host && that_present_host))
        return false;
      if (!this.host.equals(that.host))
        return false;
    }

    boolean this_present_be_port = true && this.isSetBe_port();
    boolean that_present_be_port = true && that.isSetBe_port();
    if (this_present_be_port || that_present_be_port) {
      if (!(this_present_be_port && that_present_be_port))
        return false;
      if (this.be_port != that.be_port)
        return false;
    }

    boolean this_present_rpc_port = true && this.isSetRpc_port();
    boolean that_present_rpc_port = true && that.isSetRpc_port();
    if (this_present_rpc_port || that_present_rpc_port) {
      if (!(this_present_rpc_port && that_present_rpc_port))
        return false;
      if (this.rpc_port != that.rpc_port)
        return false;
    }

    boolean this_present_http_port = true && this.isSetHttp_port();
    boolean that_present_http_port = true && that.isSetHttp_port();
    if (this_present_http_port || that_present_http_port) {
      if (!(this_present_http_port && that_present_http_port))
        return false;
      if (this.http_port != that.http_port)
        return false;
    }

    boolean this_present_alive = true && this.isSetAlive();
    boolean that_present_alive = true && that.isSetAlive();
    if (this_present_alive || that_present_alive) {
      if (!(this_present_alive && that_present_alive))
        return false;
      if (this.alive != that.alive)
        return false;
    }

    boolean this_present_state = true && this.isSetState();
    boolean that_present_state = true && that.isSetState();
    if (this_present_state || that_present_state) {
      if (!(this_present_state && that_present_state))
        return false;
      if (this.state != that.state)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetBackend_id()) ? 131071 : 524287);
    if (isSetBackend_id())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(backend_id);

    hashCode = hashCode * 8191 + ((isSetHost()) ? 131071 : 524287);
    if (isSetHost())
      hashCode = hashCode * 8191 + host.hashCode();

    hashCode = hashCode * 8191 + ((isSetBe_port()) ? 131071 : 524287);
    if (isSetBe_port())
      hashCode = hashCode * 8191 + be_port;

    hashCode = hashCode * 8191 + ((isSetRpc_port()) ? 131071 : 524287);
    if (isSetRpc_port())
      hashCode = hashCode * 8191 + rpc_port;

    hashCode = hashCode * 8191 + ((isSetHttp_port()) ? 131071 : 524287);
    if (isSetHttp_port())
      hashCode = hashCode * 8191 + http_port;

    hashCode = hashCode * 8191 + ((isSetAlive()) ? 131071 : 524287);
    if (isSetAlive())
      hashCode = hashCode * 8191 + ((alive) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((isSetState()) ? 131071 : 524287);
    if (isSetState())
      hashCode = hashCode * 8191 + state;

    return hashCode;
  }

  @Override
  public int compareTo(TBackendMeta other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = java.lang.Boolean.compare(isSetHost(), other.isSetHost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, other.host);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetBe_port(), other.isSetBe_port());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBe_port()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.be_port, other.be_port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetRpc_port(), other.isSetRpc_port());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRpc_port()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rpc_port, other.rpc_port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetHttp_port(), other.isSetHttp_port());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHttp_port()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.http_port, other.http_port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAlive(), other.isSetAlive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAlive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.alive, other.alive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetState(), other.isSetState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.state, other.state);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TBackendMeta(");
    boolean first = true;

    if (isSetBackend_id()) {
      sb.append("backend_id:");
      sb.append(this.backend_id);
      first = false;
    }
    if (isSetHost()) {
      if (!first) sb.append(", ");
      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
    }
    if (isSetBe_port()) {
      if (!first) sb.append(", ");
      sb.append("be_port:");
      sb.append(this.be_port);
      first = false;
    }
    if (isSetRpc_port()) {
      if (!first) sb.append(", ");
      sb.append("rpc_port:");
      sb.append(this.rpc_port);
      first = false;
    }
    if (isSetHttp_port()) {
      if (!first) sb.append(", ");
      sb.append("http_port:");
      sb.append(this.http_port);
      first = false;
    }
    if (isSetAlive()) {
      if (!first) sb.append(", ");
      sb.append("alive:");
      sb.append(this.alive);
      first = false;
    }
    if (isSetState()) {
      if (!first) sb.append(", ");
      sb.append("state:");
      sb.append(this.state);
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

  private static class TBackendMetaStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TBackendMetaStandardScheme getScheme() {
      return new TBackendMetaStandardScheme();
    }
  }

  private static class TBackendMetaStandardScheme extends org.apache.thrift.scheme.StandardScheme<TBackendMeta> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TBackendMeta struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BACKEND_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.backend_id = iprot.readI64();
              struct.setBackend_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HOST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.host = iprot.readString();
              struct.setHostIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BE_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.be_port = iprot.readI32();
              struct.setBe_portIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // RPC_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.rpc_port = iprot.readI32();
              struct.setRpc_portIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // HTTP_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.http_port = iprot.readI32();
              struct.setHttp_portIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ALIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.alive = iprot.readBool();
              struct.setAliveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.state = iprot.readI32();
              struct.setStateIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TBackendMeta struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetBackend_id()) {
        oprot.writeFieldBegin(BACKEND_ID_FIELD_DESC);
        oprot.writeI64(struct.backend_id);
        oprot.writeFieldEnd();
      }
      if (struct.host != null) {
        if (struct.isSetHost()) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetBe_port()) {
        oprot.writeFieldBegin(BE_PORT_FIELD_DESC);
        oprot.writeI32(struct.be_port);
        oprot.writeFieldEnd();
      }
      if (struct.isSetRpc_port()) {
        oprot.writeFieldBegin(RPC_PORT_FIELD_DESC);
        oprot.writeI32(struct.rpc_port);
        oprot.writeFieldEnd();
      }
      if (struct.isSetHttp_port()) {
        oprot.writeFieldBegin(HTTP_PORT_FIELD_DESC);
        oprot.writeI32(struct.http_port);
        oprot.writeFieldEnd();
      }
      if (struct.isSetAlive()) {
        oprot.writeFieldBegin(ALIVE_FIELD_DESC);
        oprot.writeBool(struct.alive);
        oprot.writeFieldEnd();
      }
      if (struct.isSetState()) {
        oprot.writeFieldBegin(STATE_FIELD_DESC);
        oprot.writeI32(struct.state);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TBackendMetaTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TBackendMetaTupleScheme getScheme() {
      return new TBackendMetaTupleScheme();
    }
  }

  private static class TBackendMetaTupleScheme extends org.apache.thrift.scheme.TupleScheme<TBackendMeta> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TBackendMeta struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetBackend_id()) {
        optionals.set(0);
      }
      if (struct.isSetHost()) {
        optionals.set(1);
      }
      if (struct.isSetBe_port()) {
        optionals.set(2);
      }
      if (struct.isSetRpc_port()) {
        optionals.set(3);
      }
      if (struct.isSetHttp_port()) {
        optionals.set(4);
      }
      if (struct.isSetAlive()) {
        optionals.set(5);
      }
      if (struct.isSetState()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetBackend_id()) {
        oprot.writeI64(struct.backend_id);
      }
      if (struct.isSetHost()) {
        oprot.writeString(struct.host);
      }
      if (struct.isSetBe_port()) {
        oprot.writeI32(struct.be_port);
      }
      if (struct.isSetRpc_port()) {
        oprot.writeI32(struct.rpc_port);
      }
      if (struct.isSetHttp_port()) {
        oprot.writeI32(struct.http_port);
      }
      if (struct.isSetAlive()) {
        oprot.writeBool(struct.alive);
      }
      if (struct.isSetState()) {
        oprot.writeI32(struct.state);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TBackendMeta struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.backend_id = iprot.readI64();
        struct.setBackend_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.host = iprot.readString();
        struct.setHostIsSet(true);
      }
      if (incoming.get(2)) {
        struct.be_port = iprot.readI32();
        struct.setBe_portIsSet(true);
      }
      if (incoming.get(3)) {
        struct.rpc_port = iprot.readI32();
        struct.setRpc_portIsSet(true);
      }
      if (incoming.get(4)) {
        struct.http_port = iprot.readI32();
        struct.setHttp_portIsSet(true);
      }
      if (incoming.get(5)) {
        struct.alive = iprot.readBool();
        struct.setAliveIsSet(true);
      }
      if (incoming.get(6)) {
        struct.state = iprot.readI32();
        struct.setStateIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

