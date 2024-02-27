/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TBrokerErrorHubInfo implements org.apache.thrift.TBase<TBrokerErrorHubInfo, TBrokerErrorHubInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TBrokerErrorHubInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TBrokerErrorHubInfo");

  private static final org.apache.thrift.protocol.TField BROKER_ADDR_FIELD_DESC = new org.apache.thrift.protocol.TField("broker_addr", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("path", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PROP_FIELD_DESC = new org.apache.thrift.protocol.TField("prop", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TBrokerErrorHubInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TBrokerErrorHubInfoTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TNetworkAddress broker_addr; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String path; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> prop; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BROKER_ADDR((short)1, "broker_addr"),
    PATH((short)2, "path"),
    PROP((short)3, "prop");

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
        case 1: // BROKER_ADDR
          return BROKER_ADDR;
        case 2: // PATH
          return PATH;
        case 3: // PROP
          return PROP;
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
    tmpMap.put(_Fields.BROKER_ADDR, new org.apache.thrift.meta_data.FieldMetaData("broker_addr", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TNetworkAddress.class)));
    tmpMap.put(_Fields.PATH, new org.apache.thrift.meta_data.FieldMetaData("path", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROP, new org.apache.thrift.meta_data.FieldMetaData("prop", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TBrokerErrorHubInfo.class, metaDataMap);
  }

  public TBrokerErrorHubInfo() {
  }

  public TBrokerErrorHubInfo(
    com.starrocks.thrift.TNetworkAddress broker_addr,
    java.lang.String path,
    java.util.Map<java.lang.String,java.lang.String> prop)
  {
    this();
    this.broker_addr = broker_addr;
    this.path = path;
    this.prop = prop;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TBrokerErrorHubInfo(TBrokerErrorHubInfo other) {
    if (other.isSetBroker_addr()) {
      this.broker_addr = new com.starrocks.thrift.TNetworkAddress(other.broker_addr);
    }
    if (other.isSetPath()) {
      this.path = other.path;
    }
    if (other.isSetProp()) {
      java.util.Map<java.lang.String,java.lang.String> __this__prop = new java.util.HashMap<java.lang.String,java.lang.String>(other.prop);
      this.prop = __this__prop;
    }
  }

  @Override
  public TBrokerErrorHubInfo deepCopy() {
    return new TBrokerErrorHubInfo(this);
  }

  @Override
  public void clear() {
    this.broker_addr = null;
    this.path = null;
    this.prop = null;
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TNetworkAddress getBroker_addr() {
    return this.broker_addr;
  }

  public TBrokerErrorHubInfo setBroker_addr(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TNetworkAddress broker_addr) {
    this.broker_addr = broker_addr;
    return this;
  }

  public void unsetBroker_addr() {
    this.broker_addr = null;
  }

  /** Returns true if field broker_addr is set (has been assigned a value) and false otherwise */
  public boolean isSetBroker_addr() {
    return this.broker_addr != null;
  }

  public void setBroker_addrIsSet(boolean value) {
    if (!value) {
      this.broker_addr = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPath() {
    return this.path;
  }

  public TBrokerErrorHubInfo setPath(@org.apache.thrift.annotation.Nullable java.lang.String path) {
    this.path = path;
    return this;
  }

  public void unsetPath() {
    this.path = null;
  }

  /** Returns true if field path is set (has been assigned a value) and false otherwise */
  public boolean isSetPath() {
    return this.path != null;
  }

  public void setPathIsSet(boolean value) {
    if (!value) {
      this.path = null;
    }
  }

  public int getPropSize() {
    return (this.prop == null) ? 0 : this.prop.size();
  }

  public void putToProp(java.lang.String key, java.lang.String val) {
    if (this.prop == null) {
      this.prop = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.prop.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getProp() {
    return this.prop;
  }

  public TBrokerErrorHubInfo setProp(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> prop) {
    this.prop = prop;
    return this;
  }

  public void unsetProp() {
    this.prop = null;
  }

  /** Returns true if field prop is set (has been assigned a value) and false otherwise */
  public boolean isSetProp() {
    return this.prop != null;
  }

  public void setPropIsSet(boolean value) {
    if (!value) {
      this.prop = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case BROKER_ADDR:
      if (value == null) {
        unsetBroker_addr();
      } else {
        setBroker_addr((com.starrocks.thrift.TNetworkAddress)value);
      }
      break;

    case PATH:
      if (value == null) {
        unsetPath();
      } else {
        setPath((java.lang.String)value);
      }
      break;

    case PROP:
      if (value == null) {
        unsetProp();
      } else {
        setProp((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case BROKER_ADDR:
      return getBroker_addr();

    case PATH:
      return getPath();

    case PROP:
      return getProp();

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
    case BROKER_ADDR:
      return isSetBroker_addr();
    case PATH:
      return isSetPath();
    case PROP:
      return isSetProp();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TBrokerErrorHubInfo)
      return this.equals((TBrokerErrorHubInfo)that);
    return false;
  }

  public boolean equals(TBrokerErrorHubInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_broker_addr = true && this.isSetBroker_addr();
    boolean that_present_broker_addr = true && that.isSetBroker_addr();
    if (this_present_broker_addr || that_present_broker_addr) {
      if (!(this_present_broker_addr && that_present_broker_addr))
        return false;
      if (!this.broker_addr.equals(that.broker_addr))
        return false;
    }

    boolean this_present_path = true && this.isSetPath();
    boolean that_present_path = true && that.isSetPath();
    if (this_present_path || that_present_path) {
      if (!(this_present_path && that_present_path))
        return false;
      if (!this.path.equals(that.path))
        return false;
    }

    boolean this_present_prop = true && this.isSetProp();
    boolean that_present_prop = true && that.isSetProp();
    if (this_present_prop || that_present_prop) {
      if (!(this_present_prop && that_present_prop))
        return false;
      if (!this.prop.equals(that.prop))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetBroker_addr()) ? 131071 : 524287);
    if (isSetBroker_addr())
      hashCode = hashCode * 8191 + broker_addr.hashCode();

    hashCode = hashCode * 8191 + ((isSetPath()) ? 131071 : 524287);
    if (isSetPath())
      hashCode = hashCode * 8191 + path.hashCode();

    hashCode = hashCode * 8191 + ((isSetProp()) ? 131071 : 524287);
    if (isSetProp())
      hashCode = hashCode * 8191 + prop.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TBrokerErrorHubInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetBroker_addr(), other.isSetBroker_addr());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBroker_addr()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.broker_addr, other.broker_addr);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPath(), other.isSetPath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.path, other.path);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetProp(), other.isSetProp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.prop, other.prop);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TBrokerErrorHubInfo(");
    boolean first = true;

    sb.append("broker_addr:");
    if (this.broker_addr == null) {
      sb.append("null");
    } else {
      sb.append(this.broker_addr);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("path:");
    if (this.path == null) {
      sb.append("null");
    } else {
      sb.append(this.path);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("prop:");
    if (this.prop == null) {
      sb.append("null");
    } else {
      sb.append(this.prop);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (broker_addr == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'broker_addr' was not present! Struct: " + toString());
    }
    if (path == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'path' was not present! Struct: " + toString());
    }
    if (prop == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'prop' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (broker_addr != null) {
      broker_addr.validate();
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

  private static class TBrokerErrorHubInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TBrokerErrorHubInfoStandardScheme getScheme() {
      return new TBrokerErrorHubInfoStandardScheme();
    }
  }

  private static class TBrokerErrorHubInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<TBrokerErrorHubInfo> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TBrokerErrorHubInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BROKER_ADDR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.broker_addr = new com.starrocks.thrift.TNetworkAddress();
              struct.broker_addr.read(iprot);
              struct.setBroker_addrIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.path = iprot.readString();
              struct.setPathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PROP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.prop = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map0.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key1;
                @org.apache.thrift.annotation.Nullable java.lang.String _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readString();
                  _val2 = iprot.readString();
                  struct.prop.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setPropIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TBrokerErrorHubInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.broker_addr != null) {
        oprot.writeFieldBegin(BROKER_ADDR_FIELD_DESC);
        struct.broker_addr.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.path != null) {
        oprot.writeFieldBegin(PATH_FIELD_DESC);
        oprot.writeString(struct.path);
        oprot.writeFieldEnd();
      }
      if (struct.prop != null) {
        oprot.writeFieldBegin(PROP_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.prop.size()));
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter4 : struct.prop.entrySet())
          {
            oprot.writeString(_iter4.getKey());
            oprot.writeString(_iter4.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TBrokerErrorHubInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TBrokerErrorHubInfoTupleScheme getScheme() {
      return new TBrokerErrorHubInfoTupleScheme();
    }
  }

  private static class TBrokerErrorHubInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<TBrokerErrorHubInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TBrokerErrorHubInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.broker_addr.write(oprot);
      oprot.writeString(struct.path);
      {
        oprot.writeI32(struct.prop.size());
        for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter5 : struct.prop.entrySet())
        {
          oprot.writeString(_iter5.getKey());
          oprot.writeString(_iter5.getValue());
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TBrokerErrorHubInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.broker_addr = new com.starrocks.thrift.TNetworkAddress();
      struct.broker_addr.read(iprot);
      struct.setBroker_addrIsSet(true);
      struct.path = iprot.readString();
      struct.setPathIsSet(true);
      {
        org.apache.thrift.protocol.TMap _map6 = iprot.readMapBegin(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING); 
        struct.prop = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map6.size);
        @org.apache.thrift.annotation.Nullable java.lang.String _key7;
        @org.apache.thrift.annotation.Nullable java.lang.String _val8;
        for (int _i9 = 0; _i9 < _map6.size; ++_i9)
        {
          _key7 = iprot.readString();
          _val8 = iprot.readString();
          struct.prop.put(_key7, _val8);
        }
      }
      struct.setPropIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

