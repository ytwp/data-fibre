/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TClearRemoteFileReq implements org.apache.thrift.TBase<TClearRemoteFileReq, TClearRemoteFileReq._Fields>, java.io.Serializable, Cloneable, Comparable<TClearRemoteFileReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TClearRemoteFileReq");

  private static final org.apache.thrift.protocol.TField REMOTE_FILE_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("remote_file_path", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField REMOTE_SOURCE_PROPERTIES_FIELD_DESC = new org.apache.thrift.protocol.TField("remote_source_properties", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TClearRemoteFileReqStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TClearRemoteFileReqTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String remote_file_path; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> remote_source_properties; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    REMOTE_FILE_PATH((short)1, "remote_file_path"),
    REMOTE_SOURCE_PROPERTIES((short)2, "remote_source_properties");

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
        case 1: // REMOTE_FILE_PATH
          return REMOTE_FILE_PATH;
        case 2: // REMOTE_SOURCE_PROPERTIES
          return REMOTE_SOURCE_PROPERTIES;
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
    tmpMap.put(_Fields.REMOTE_FILE_PATH, new org.apache.thrift.meta_data.FieldMetaData("remote_file_path", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REMOTE_SOURCE_PROPERTIES, new org.apache.thrift.meta_data.FieldMetaData("remote_source_properties", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TClearRemoteFileReq.class, metaDataMap);
  }

  public TClearRemoteFileReq() {
  }

  public TClearRemoteFileReq(
    java.lang.String remote_file_path,
    java.util.Map<java.lang.String,java.lang.String> remote_source_properties)
  {
    this();
    this.remote_file_path = remote_file_path;
    this.remote_source_properties = remote_source_properties;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TClearRemoteFileReq(TClearRemoteFileReq other) {
    if (other.isSetRemote_file_path()) {
      this.remote_file_path = other.remote_file_path;
    }
    if (other.isSetRemote_source_properties()) {
      java.util.Map<java.lang.String,java.lang.String> __this__remote_source_properties = new java.util.HashMap<java.lang.String,java.lang.String>(other.remote_source_properties);
      this.remote_source_properties = __this__remote_source_properties;
    }
  }

  @Override
  public TClearRemoteFileReq deepCopy() {
    return new TClearRemoteFileReq(this);
  }

  @Override
  public void clear() {
    this.remote_file_path = null;
    this.remote_source_properties = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getRemote_file_path() {
    return this.remote_file_path;
  }

  public TClearRemoteFileReq setRemote_file_path(@org.apache.thrift.annotation.Nullable java.lang.String remote_file_path) {
    this.remote_file_path = remote_file_path;
    return this;
  }

  public void unsetRemote_file_path() {
    this.remote_file_path = null;
  }

  /** Returns true if field remote_file_path is set (has been assigned a value) and false otherwise */
  public boolean isSetRemote_file_path() {
    return this.remote_file_path != null;
  }

  public void setRemote_file_pathIsSet(boolean value) {
    if (!value) {
      this.remote_file_path = null;
    }
  }

  public int getRemote_source_propertiesSize() {
    return (this.remote_source_properties == null) ? 0 : this.remote_source_properties.size();
  }

  public void putToRemote_source_properties(java.lang.String key, java.lang.String val) {
    if (this.remote_source_properties == null) {
      this.remote_source_properties = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.remote_source_properties.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getRemote_source_properties() {
    return this.remote_source_properties;
  }

  public TClearRemoteFileReq setRemote_source_properties(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> remote_source_properties) {
    this.remote_source_properties = remote_source_properties;
    return this;
  }

  public void unsetRemote_source_properties() {
    this.remote_source_properties = null;
  }

  /** Returns true if field remote_source_properties is set (has been assigned a value) and false otherwise */
  public boolean isSetRemote_source_properties() {
    return this.remote_source_properties != null;
  }

  public void setRemote_source_propertiesIsSet(boolean value) {
    if (!value) {
      this.remote_source_properties = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case REMOTE_FILE_PATH:
      if (value == null) {
        unsetRemote_file_path();
      } else {
        setRemote_file_path((java.lang.String)value);
      }
      break;

    case REMOTE_SOURCE_PROPERTIES:
      if (value == null) {
        unsetRemote_source_properties();
      } else {
        setRemote_source_properties((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case REMOTE_FILE_PATH:
      return getRemote_file_path();

    case REMOTE_SOURCE_PROPERTIES:
      return getRemote_source_properties();

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
    case REMOTE_FILE_PATH:
      return isSetRemote_file_path();
    case REMOTE_SOURCE_PROPERTIES:
      return isSetRemote_source_properties();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TClearRemoteFileReq)
      return this.equals((TClearRemoteFileReq)that);
    return false;
  }

  public boolean equals(TClearRemoteFileReq that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_remote_file_path = true && this.isSetRemote_file_path();
    boolean that_present_remote_file_path = true && that.isSetRemote_file_path();
    if (this_present_remote_file_path || that_present_remote_file_path) {
      if (!(this_present_remote_file_path && that_present_remote_file_path))
        return false;
      if (!this.remote_file_path.equals(that.remote_file_path))
        return false;
    }

    boolean this_present_remote_source_properties = true && this.isSetRemote_source_properties();
    boolean that_present_remote_source_properties = true && that.isSetRemote_source_properties();
    if (this_present_remote_source_properties || that_present_remote_source_properties) {
      if (!(this_present_remote_source_properties && that_present_remote_source_properties))
        return false;
      if (!this.remote_source_properties.equals(that.remote_source_properties))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetRemote_file_path()) ? 131071 : 524287);
    if (isSetRemote_file_path())
      hashCode = hashCode * 8191 + remote_file_path.hashCode();

    hashCode = hashCode * 8191 + ((isSetRemote_source_properties()) ? 131071 : 524287);
    if (isSetRemote_source_properties())
      hashCode = hashCode * 8191 + remote_source_properties.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TClearRemoteFileReq other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetRemote_file_path(), other.isSetRemote_file_path());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRemote_file_path()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.remote_file_path, other.remote_file_path);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetRemote_source_properties(), other.isSetRemote_source_properties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRemote_source_properties()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.remote_source_properties, other.remote_source_properties);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TClearRemoteFileReq(");
    boolean first = true;

    sb.append("remote_file_path:");
    if (this.remote_file_path == null) {
      sb.append("null");
    } else {
      sb.append(this.remote_file_path);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("remote_source_properties:");
    if (this.remote_source_properties == null) {
      sb.append("null");
    } else {
      sb.append(this.remote_source_properties);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (remote_file_path == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'remote_file_path' was not present! Struct: " + toString());
    }
    if (remote_source_properties == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'remote_source_properties' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TClearRemoteFileReqStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TClearRemoteFileReqStandardScheme getScheme() {
      return new TClearRemoteFileReqStandardScheme();
    }
  }

  private static class TClearRemoteFileReqStandardScheme extends org.apache.thrift.scheme.StandardScheme<TClearRemoteFileReq> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TClearRemoteFileReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // REMOTE_FILE_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.remote_file_path = iprot.readString();
              struct.setRemote_file_pathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REMOTE_SOURCE_PROPERTIES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map162 = iprot.readMapBegin();
                struct.remote_source_properties = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map162.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key163;
                @org.apache.thrift.annotation.Nullable java.lang.String _val164;
                for (int _i165 = 0; _i165 < _map162.size; ++_i165)
                {
                  _key163 = iprot.readString();
                  _val164 = iprot.readString();
                  struct.remote_source_properties.put(_key163, _val164);
                }
                iprot.readMapEnd();
              }
              struct.setRemote_source_propertiesIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TClearRemoteFileReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.remote_file_path != null) {
        oprot.writeFieldBegin(REMOTE_FILE_PATH_FIELD_DESC);
        oprot.writeString(struct.remote_file_path);
        oprot.writeFieldEnd();
      }
      if (struct.remote_source_properties != null) {
        oprot.writeFieldBegin(REMOTE_SOURCE_PROPERTIES_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.remote_source_properties.size()));
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter166 : struct.remote_source_properties.entrySet())
          {
            oprot.writeString(_iter166.getKey());
            oprot.writeString(_iter166.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TClearRemoteFileReqTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TClearRemoteFileReqTupleScheme getScheme() {
      return new TClearRemoteFileReqTupleScheme();
    }
  }

  private static class TClearRemoteFileReqTupleScheme extends org.apache.thrift.scheme.TupleScheme<TClearRemoteFileReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TClearRemoteFileReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.remote_file_path);
      {
        oprot.writeI32(struct.remote_source_properties.size());
        for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter167 : struct.remote_source_properties.entrySet())
        {
          oprot.writeString(_iter167.getKey());
          oprot.writeString(_iter167.getValue());
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TClearRemoteFileReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.remote_file_path = iprot.readString();
      struct.setRemote_file_pathIsSet(true);
      {
        org.apache.thrift.protocol.TMap _map168 = iprot.readMapBegin(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING); 
        struct.remote_source_properties = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map168.size);
        @org.apache.thrift.annotation.Nullable java.lang.String _key169;
        @org.apache.thrift.annotation.Nullable java.lang.String _val170;
        for (int _i171 = 0; _i171 < _map168.size; ++_i171)
        {
          _key169 = iprot.readString();
          _val170 = iprot.readString();
          struct.remote_source_properties.put(_key169, _val170);
        }
      }
      struct.setRemote_source_propertiesIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

