/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TEsScanNode implements org.apache.thrift.TBase<TEsScanNode, TEsScanNode._Fields>, java.io.Serializable, Cloneable, Comparable<TEsScanNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TEsScanNode");

  private static final org.apache.thrift.protocol.TField TUPLE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tuple_id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PROPERTIES_FIELD_DESC = new org.apache.thrift.protocol.TField("properties", org.apache.thrift.protocol.TType.MAP, (short)2);
  private static final org.apache.thrift.protocol.TField DOCVALUE_CONTEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("docvalue_context", org.apache.thrift.protocol.TType.MAP, (short)3);
  private static final org.apache.thrift.protocol.TField FIELDS_CONTEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("fields_context", org.apache.thrift.protocol.TType.MAP, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TEsScanNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TEsScanNodeTupleSchemeFactory();

  public int tuple_id; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> properties; // optional
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> docvalue_context; // optional
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> fields_context; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TUPLE_ID((short)1, "tuple_id"),
    PROPERTIES((short)2, "properties"),
    DOCVALUE_CONTEXT((short)3, "docvalue_context"),
    FIELDS_CONTEXT((short)4, "fields_context");

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
        case 1: // TUPLE_ID
          return TUPLE_ID;
        case 2: // PROPERTIES
          return PROPERTIES;
        case 3: // DOCVALUE_CONTEXT
          return DOCVALUE_CONTEXT;
        case 4: // FIELDS_CONTEXT
          return FIELDS_CONTEXT;
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
  private static final int __TUPLE_ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PROPERTIES,_Fields.DOCVALUE_CONTEXT,_Fields.FIELDS_CONTEXT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TUPLE_ID, new org.apache.thrift.meta_data.FieldMetaData("tuple_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "TTupleId")));
    tmpMap.put(_Fields.PROPERTIES, new org.apache.thrift.meta_data.FieldMetaData("properties", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.DOCVALUE_CONTEXT, new org.apache.thrift.meta_data.FieldMetaData("docvalue_context", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.FIELDS_CONTEXT, new org.apache.thrift.meta_data.FieldMetaData("fields_context", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TEsScanNode.class, metaDataMap);
  }

  public TEsScanNode() {
  }

  public TEsScanNode(
    int tuple_id)
  {
    this();
    this.tuple_id = tuple_id;
    setTuple_idIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TEsScanNode(TEsScanNode other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tuple_id = other.tuple_id;
    if (other.isSetProperties()) {
      java.util.Map<java.lang.String,java.lang.String> __this__properties = new java.util.HashMap<java.lang.String,java.lang.String>(other.properties);
      this.properties = __this__properties;
    }
    if (other.isSetDocvalue_context()) {
      java.util.Map<java.lang.String,java.lang.String> __this__docvalue_context = new java.util.HashMap<java.lang.String,java.lang.String>(other.docvalue_context);
      this.docvalue_context = __this__docvalue_context;
    }
    if (other.isSetFields_context()) {
      java.util.Map<java.lang.String,java.lang.String> __this__fields_context = new java.util.HashMap<java.lang.String,java.lang.String>(other.fields_context);
      this.fields_context = __this__fields_context;
    }
  }

  @Override
  public TEsScanNode deepCopy() {
    return new TEsScanNode(this);
  }

  @Override
  public void clear() {
    setTuple_idIsSet(false);
    this.tuple_id = 0;
    this.properties = null;
    this.docvalue_context = null;
    this.fields_context = null;
  }

  public int getTuple_id() {
    return this.tuple_id;
  }

  public TEsScanNode setTuple_id(int tuple_id) {
    this.tuple_id = tuple_id;
    setTuple_idIsSet(true);
    return this;
  }

  public void unsetTuple_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TUPLE_ID_ISSET_ID);
  }

  /** Returns true if field tuple_id is set (has been assigned a value) and false otherwise */
  public boolean isSetTuple_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TUPLE_ID_ISSET_ID);
  }

  public void setTuple_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TUPLE_ID_ISSET_ID, value);
  }

  public int getPropertiesSize() {
    return (this.properties == null) ? 0 : this.properties.size();
  }

  public void putToProperties(java.lang.String key, java.lang.String val) {
    if (this.properties == null) {
      this.properties = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.properties.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getProperties() {
    return this.properties;
  }

  public TEsScanNode setProperties(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> properties) {
    this.properties = properties;
    return this;
  }

  public void unsetProperties() {
    this.properties = null;
  }

  /** Returns true if field properties is set (has been assigned a value) and false otherwise */
  public boolean isSetProperties() {
    return this.properties != null;
  }

  public void setPropertiesIsSet(boolean value) {
    if (!value) {
      this.properties = null;
    }
  }

  public int getDocvalue_contextSize() {
    return (this.docvalue_context == null) ? 0 : this.docvalue_context.size();
  }

  public void putToDocvalue_context(java.lang.String key, java.lang.String val) {
    if (this.docvalue_context == null) {
      this.docvalue_context = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.docvalue_context.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getDocvalue_context() {
    return this.docvalue_context;
  }

  public TEsScanNode setDocvalue_context(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> docvalue_context) {
    this.docvalue_context = docvalue_context;
    return this;
  }

  public void unsetDocvalue_context() {
    this.docvalue_context = null;
  }

  /** Returns true if field docvalue_context is set (has been assigned a value) and false otherwise */
  public boolean isSetDocvalue_context() {
    return this.docvalue_context != null;
  }

  public void setDocvalue_contextIsSet(boolean value) {
    if (!value) {
      this.docvalue_context = null;
    }
  }

  public int getFields_contextSize() {
    return (this.fields_context == null) ? 0 : this.fields_context.size();
  }

  public void putToFields_context(java.lang.String key, java.lang.String val) {
    if (this.fields_context == null) {
      this.fields_context = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.fields_context.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getFields_context() {
    return this.fields_context;
  }

  public TEsScanNode setFields_context(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> fields_context) {
    this.fields_context = fields_context;
    return this;
  }

  public void unsetFields_context() {
    this.fields_context = null;
  }

  /** Returns true if field fields_context is set (has been assigned a value) and false otherwise */
  public boolean isSetFields_context() {
    return this.fields_context != null;
  }

  public void setFields_contextIsSet(boolean value) {
    if (!value) {
      this.fields_context = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TUPLE_ID:
      if (value == null) {
        unsetTuple_id();
      } else {
        setTuple_id((java.lang.Integer)value);
      }
      break;

    case PROPERTIES:
      if (value == null) {
        unsetProperties();
      } else {
        setProperties((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    case DOCVALUE_CONTEXT:
      if (value == null) {
        unsetDocvalue_context();
      } else {
        setDocvalue_context((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    case FIELDS_CONTEXT:
      if (value == null) {
        unsetFields_context();
      } else {
        setFields_context((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TUPLE_ID:
      return getTuple_id();

    case PROPERTIES:
      return getProperties();

    case DOCVALUE_CONTEXT:
      return getDocvalue_context();

    case FIELDS_CONTEXT:
      return getFields_context();

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
    case TUPLE_ID:
      return isSetTuple_id();
    case PROPERTIES:
      return isSetProperties();
    case DOCVALUE_CONTEXT:
      return isSetDocvalue_context();
    case FIELDS_CONTEXT:
      return isSetFields_context();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TEsScanNode)
      return this.equals((TEsScanNode)that);
    return false;
  }

  public boolean equals(TEsScanNode that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tuple_id = true;
    boolean that_present_tuple_id = true;
    if (this_present_tuple_id || that_present_tuple_id) {
      if (!(this_present_tuple_id && that_present_tuple_id))
        return false;
      if (this.tuple_id != that.tuple_id)
        return false;
    }

    boolean this_present_properties = true && this.isSetProperties();
    boolean that_present_properties = true && that.isSetProperties();
    if (this_present_properties || that_present_properties) {
      if (!(this_present_properties && that_present_properties))
        return false;
      if (!this.properties.equals(that.properties))
        return false;
    }

    boolean this_present_docvalue_context = true && this.isSetDocvalue_context();
    boolean that_present_docvalue_context = true && that.isSetDocvalue_context();
    if (this_present_docvalue_context || that_present_docvalue_context) {
      if (!(this_present_docvalue_context && that_present_docvalue_context))
        return false;
      if (!this.docvalue_context.equals(that.docvalue_context))
        return false;
    }

    boolean this_present_fields_context = true && this.isSetFields_context();
    boolean that_present_fields_context = true && that.isSetFields_context();
    if (this_present_fields_context || that_present_fields_context) {
      if (!(this_present_fields_context && that_present_fields_context))
        return false;
      if (!this.fields_context.equals(that.fields_context))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + tuple_id;

    hashCode = hashCode * 8191 + ((isSetProperties()) ? 131071 : 524287);
    if (isSetProperties())
      hashCode = hashCode * 8191 + properties.hashCode();

    hashCode = hashCode * 8191 + ((isSetDocvalue_context()) ? 131071 : 524287);
    if (isSetDocvalue_context())
      hashCode = hashCode * 8191 + docvalue_context.hashCode();

    hashCode = hashCode * 8191 + ((isSetFields_context()) ? 131071 : 524287);
    if (isSetFields_context())
      hashCode = hashCode * 8191 + fields_context.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TEsScanNode other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTuple_id(), other.isSetTuple_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTuple_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tuple_id, other.tuple_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetProperties(), other.isSetProperties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProperties()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.properties, other.properties);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDocvalue_context(), other.isSetDocvalue_context());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDocvalue_context()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.docvalue_context, other.docvalue_context);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetFields_context(), other.isSetFields_context());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFields_context()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fields_context, other.fields_context);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TEsScanNode(");
    boolean first = true;

    sb.append("tuple_id:");
    sb.append(this.tuple_id);
    first = false;
    if (isSetProperties()) {
      if (!first) sb.append(", ");
      sb.append("properties:");
      if (this.properties == null) {
        sb.append("null");
      } else {
        sb.append(this.properties);
      }
      first = false;
    }
    if (isSetDocvalue_context()) {
      if (!first) sb.append(", ");
      sb.append("docvalue_context:");
      if (this.docvalue_context == null) {
        sb.append("null");
      } else {
        sb.append(this.docvalue_context);
      }
      first = false;
    }
    if (isSetFields_context()) {
      if (!first) sb.append(", ");
      sb.append("fields_context:");
      if (this.fields_context == null) {
        sb.append("null");
      } else {
        sb.append(this.fields_context);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'tuple_id' because it's a primitive and you chose the non-beans generator.
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

  private static class TEsScanNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TEsScanNodeStandardScheme getScheme() {
      return new TEsScanNodeStandardScheme();
    }
  }

  private static class TEsScanNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TEsScanNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TEsScanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TUPLE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tuple_id = iprot.readI32();
              struct.setTuple_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PROPERTIES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map176 = iprot.readMapBegin();
                struct.properties = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map176.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key177;
                @org.apache.thrift.annotation.Nullable java.lang.String _val178;
                for (int _i179 = 0; _i179 < _map176.size; ++_i179)
                {
                  _key177 = iprot.readString();
                  _val178 = iprot.readString();
                  struct.properties.put(_key177, _val178);
                }
                iprot.readMapEnd();
              }
              struct.setPropertiesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DOCVALUE_CONTEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map180 = iprot.readMapBegin();
                struct.docvalue_context = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map180.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key181;
                @org.apache.thrift.annotation.Nullable java.lang.String _val182;
                for (int _i183 = 0; _i183 < _map180.size; ++_i183)
                {
                  _key181 = iprot.readString();
                  _val182 = iprot.readString();
                  struct.docvalue_context.put(_key181, _val182);
                }
                iprot.readMapEnd();
              }
              struct.setDocvalue_contextIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FIELDS_CONTEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map184 = iprot.readMapBegin();
                struct.fields_context = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map184.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key185;
                @org.apache.thrift.annotation.Nullable java.lang.String _val186;
                for (int _i187 = 0; _i187 < _map184.size; ++_i187)
                {
                  _key185 = iprot.readString();
                  _val186 = iprot.readString();
                  struct.fields_context.put(_key185, _val186);
                }
                iprot.readMapEnd();
              }
              struct.setFields_contextIsSet(true);
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
      if (!struct.isSetTuple_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'tuple_id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TEsScanNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TUPLE_ID_FIELD_DESC);
      oprot.writeI32(struct.tuple_id);
      oprot.writeFieldEnd();
      if (struct.properties != null) {
        if (struct.isSetProperties()) {
          oprot.writeFieldBegin(PROPERTIES_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.properties.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter188 : struct.properties.entrySet())
            {
              oprot.writeString(_iter188.getKey());
              oprot.writeString(_iter188.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.docvalue_context != null) {
        if (struct.isSetDocvalue_context()) {
          oprot.writeFieldBegin(DOCVALUE_CONTEXT_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.docvalue_context.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter189 : struct.docvalue_context.entrySet())
            {
              oprot.writeString(_iter189.getKey());
              oprot.writeString(_iter189.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.fields_context != null) {
        if (struct.isSetFields_context()) {
          oprot.writeFieldBegin(FIELDS_CONTEXT_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.fields_context.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter190 : struct.fields_context.entrySet())
            {
              oprot.writeString(_iter190.getKey());
              oprot.writeString(_iter190.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TEsScanNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TEsScanNodeTupleScheme getScheme() {
      return new TEsScanNodeTupleScheme();
    }
  }

  private static class TEsScanNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TEsScanNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TEsScanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.tuple_id);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetProperties()) {
        optionals.set(0);
      }
      if (struct.isSetDocvalue_context()) {
        optionals.set(1);
      }
      if (struct.isSetFields_context()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetProperties()) {
        {
          oprot.writeI32(struct.properties.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter191 : struct.properties.entrySet())
          {
            oprot.writeString(_iter191.getKey());
            oprot.writeString(_iter191.getValue());
          }
        }
      }
      if (struct.isSetDocvalue_context()) {
        {
          oprot.writeI32(struct.docvalue_context.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter192 : struct.docvalue_context.entrySet())
          {
            oprot.writeString(_iter192.getKey());
            oprot.writeString(_iter192.getValue());
          }
        }
      }
      if (struct.isSetFields_context()) {
        {
          oprot.writeI32(struct.fields_context.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter193 : struct.fields_context.entrySet())
          {
            oprot.writeString(_iter193.getKey());
            oprot.writeString(_iter193.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TEsScanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.tuple_id = iprot.readI32();
      struct.setTuple_idIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map194 = iprot.readMapBegin(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING); 
          struct.properties = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map194.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _key195;
          @org.apache.thrift.annotation.Nullable java.lang.String _val196;
          for (int _i197 = 0; _i197 < _map194.size; ++_i197)
          {
            _key195 = iprot.readString();
            _val196 = iprot.readString();
            struct.properties.put(_key195, _val196);
          }
        }
        struct.setPropertiesIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map198 = iprot.readMapBegin(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING); 
          struct.docvalue_context = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map198.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _key199;
          @org.apache.thrift.annotation.Nullable java.lang.String _val200;
          for (int _i201 = 0; _i201 < _map198.size; ++_i201)
          {
            _key199 = iprot.readString();
            _val200 = iprot.readString();
            struct.docvalue_context.put(_key199, _val200);
          }
        }
        struct.setDocvalue_contextIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map202 = iprot.readMapBegin(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING); 
          struct.fields_context = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map202.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _key203;
          @org.apache.thrift.annotation.Nullable java.lang.String _val204;
          for (int _i205 = 0; _i205 < _map202.size; ++_i205)
          {
            _key203 = iprot.readString();
            _val204 = iprot.readString();
            struct.fields_context.put(_key203, _val204);
          }
        }
        struct.setFields_contextIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

