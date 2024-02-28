/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TPluginInfo implements org.apache.thrift.TBase<TPluginInfo, TPluginInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TPluginInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TPluginInfo");

  private static final org.apache.thrift.protocol.TField PLUGIN_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("plugin_name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TPluginInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TPluginInfoTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String plugin_name; // required
  public int type; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PLUGIN_NAME((short)1, "plugin_name"),
    TYPE((short)2, "type");

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
        case 1: // PLUGIN_NAME
          return PLUGIN_NAME;
        case 2: // TYPE
          return TYPE;
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
  private static final int __TYPE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PLUGIN_NAME, new org.apache.thrift.meta_data.FieldMetaData("plugin_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TPluginInfo.class, metaDataMap);
  }

  public TPluginInfo() {
  }

  public TPluginInfo(
    java.lang.String plugin_name,
    int type)
  {
    this();
    this.plugin_name = plugin_name;
    this.type = type;
    setTypeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TPluginInfo(TPluginInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPlugin_name()) {
      this.plugin_name = other.plugin_name;
    }
    this.type = other.type;
  }

  @Override
  public TPluginInfo deepCopy() {
    return new TPluginInfo(this);
  }

  @Override
  public void clear() {
    this.plugin_name = null;
    setTypeIsSet(false);
    this.type = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPlugin_name() {
    return this.plugin_name;
  }

  public TPluginInfo setPlugin_name(@org.apache.thrift.annotation.Nullable java.lang.String plugin_name) {
    this.plugin_name = plugin_name;
    return this;
  }

  public void unsetPlugin_name() {
    this.plugin_name = null;
  }

  /** Returns true if field plugin_name is set (has been assigned a value) and false otherwise */
  public boolean isSetPlugin_name() {
    return this.plugin_name != null;
  }

  public void setPlugin_nameIsSet(boolean value) {
    if (!value) {
      this.plugin_name = null;
    }
  }

  public int getType() {
    return this.type;
  }

  public TPluginInfo setType(int type) {
    this.type = type;
    setTypeIsSet(true);
    return this;
  }

  public void unsetType() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  public void setTypeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TYPE_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PLUGIN_NAME:
      if (value == null) {
        unsetPlugin_name();
      } else {
        setPlugin_name((java.lang.String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PLUGIN_NAME:
      return getPlugin_name();

    case TYPE:
      return getType();

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
    case PLUGIN_NAME:
      return isSetPlugin_name();
    case TYPE:
      return isSetType();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TPluginInfo)
      return this.equals((TPluginInfo)that);
    return false;
  }

  public boolean equals(TPluginInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_plugin_name = true && this.isSetPlugin_name();
    boolean that_present_plugin_name = true && that.isSetPlugin_name();
    if (this_present_plugin_name || that_present_plugin_name) {
      if (!(this_present_plugin_name && that_present_plugin_name))
        return false;
      if (!this.plugin_name.equals(that.plugin_name))
        return false;
    }

    boolean this_present_type = true;
    boolean that_present_type = true;
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (this.type != that.type)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetPlugin_name()) ? 131071 : 524287);
    if (isSetPlugin_name())
      hashCode = hashCode * 8191 + plugin_name.hashCode();

    hashCode = hashCode * 8191 + type;

    return hashCode;
  }

  @Override
  public int compareTo(TPluginInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetPlugin_name(), other.isSetPlugin_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlugin_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.plugin_name, other.plugin_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetType(), other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TPluginInfo(");
    boolean first = true;

    sb.append("plugin_name:");
    if (this.plugin_name == null) {
      sb.append("null");
    } else {
      sb.append(this.plugin_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    sb.append(this.type);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (plugin_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'plugin_name' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'type' because it's a primitive and you chose the non-beans generator.
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

  private static class TPluginInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TPluginInfoStandardScheme getScheme() {
      return new TPluginInfoStandardScheme();
    }
  }

  private static class TPluginInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<TPluginInfo> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TPluginInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PLUGIN_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.plugin_name = iprot.readString();
              struct.setPlugin_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = iprot.readI32();
              struct.setTypeIsSet(true);
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
      if (!struct.isSetType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'type' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TPluginInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.plugin_name != null) {
        oprot.writeFieldBegin(PLUGIN_NAME_FIELD_DESC);
        oprot.writeString(struct.plugin_name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TYPE_FIELD_DESC);
      oprot.writeI32(struct.type);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TPluginInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TPluginInfoTupleScheme getScheme() {
      return new TPluginInfoTupleScheme();
    }
  }

  private static class TPluginInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<TPluginInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TPluginInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.plugin_name);
      oprot.writeI32(struct.type);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TPluginInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.plugin_name = iprot.readString();
      struct.setPlugin_nameIsSet(true);
      struct.type = iprot.readI32();
      struct.setTypeIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

