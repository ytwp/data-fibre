/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TSpillToRemoteStorageOptions implements org.apache.thrift.TBase<TSpillToRemoteStorageOptions, TSpillToRemoteStorageOptions._Fields>, java.io.Serializable, Cloneable, Comparable<TSpillToRemoteStorageOptions> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TSpillToRemoteStorageOptions");

  private static final org.apache.thrift.protocol.TField REMOTE_STORAGE_PATHS_FIELD_DESC = new org.apache.thrift.protocol.TField("remote_storage_paths", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField REMOTE_STORAGE_CONF_FIELD_DESC = new org.apache.thrift.protocol.TField("remote_storage_conf", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField DISABLE_SPILL_TO_LOCAL_DISK_FIELD_DESC = new org.apache.thrift.protocol.TField("disable_spill_to_local_disk", org.apache.thrift.protocol.TType.BOOL, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TSpillToRemoteStorageOptionsStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TSpillToRemoteStorageOptionsTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> remote_storage_paths; // optional
  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TCloudConfiguration remote_storage_conf; // optional
  public boolean disable_spill_to_local_disk; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    REMOTE_STORAGE_PATHS((short)1, "remote_storage_paths"),
    REMOTE_STORAGE_CONF((short)2, "remote_storage_conf"),
    DISABLE_SPILL_TO_LOCAL_DISK((short)3, "disable_spill_to_local_disk");

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
        case 1: // REMOTE_STORAGE_PATHS
          return REMOTE_STORAGE_PATHS;
        case 2: // REMOTE_STORAGE_CONF
          return REMOTE_STORAGE_CONF;
        case 3: // DISABLE_SPILL_TO_LOCAL_DISK
          return DISABLE_SPILL_TO_LOCAL_DISK;
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
  private static final int __DISABLE_SPILL_TO_LOCAL_DISK_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.REMOTE_STORAGE_PATHS,_Fields.REMOTE_STORAGE_CONF,_Fields.DISABLE_SPILL_TO_LOCAL_DISK};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.REMOTE_STORAGE_PATHS, new org.apache.thrift.meta_data.FieldMetaData("remote_storage_paths", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.REMOTE_STORAGE_CONF, new org.apache.thrift.meta_data.FieldMetaData("remote_storage_conf", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TCloudConfiguration.class)));
    tmpMap.put(_Fields.DISABLE_SPILL_TO_LOCAL_DISK, new org.apache.thrift.meta_data.FieldMetaData("disable_spill_to_local_disk", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TSpillToRemoteStorageOptions.class, metaDataMap);
  }

  public TSpillToRemoteStorageOptions() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TSpillToRemoteStorageOptions(TSpillToRemoteStorageOptions other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetRemote_storage_paths()) {
      java.util.List<java.lang.String> __this__remote_storage_paths = new java.util.ArrayList<java.lang.String>(other.remote_storage_paths);
      this.remote_storage_paths = __this__remote_storage_paths;
    }
    if (other.isSetRemote_storage_conf()) {
      this.remote_storage_conf = new com.starrocks.thrift.TCloudConfiguration(other.remote_storage_conf);
    }
    this.disable_spill_to_local_disk = other.disable_spill_to_local_disk;
  }

  @Override
  public TSpillToRemoteStorageOptions deepCopy() {
    return new TSpillToRemoteStorageOptions(this);
  }

  @Override
  public void clear() {
    this.remote_storage_paths = null;
    this.remote_storage_conf = null;
    setDisable_spill_to_local_diskIsSet(false);
    this.disable_spill_to_local_disk = false;
  }

  public int getRemote_storage_pathsSize() {
    return (this.remote_storage_paths == null) ? 0 : this.remote_storage_paths.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.String> getRemote_storage_pathsIterator() {
    return (this.remote_storage_paths == null) ? null : this.remote_storage_paths.iterator();
  }

  public void addToRemote_storage_paths(java.lang.String elem) {
    if (this.remote_storage_paths == null) {
      this.remote_storage_paths = new java.util.ArrayList<java.lang.String>();
    }
    this.remote_storage_paths.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.String> getRemote_storage_paths() {
    return this.remote_storage_paths;
  }

  public TSpillToRemoteStorageOptions setRemote_storage_paths(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> remote_storage_paths) {
    this.remote_storage_paths = remote_storage_paths;
    return this;
  }

  public void unsetRemote_storage_paths() {
    this.remote_storage_paths = null;
  }

  /** Returns true if field remote_storage_paths is set (has been assigned a value) and false otherwise */
  public boolean isSetRemote_storage_paths() {
    return this.remote_storage_paths != null;
  }

  public void setRemote_storage_pathsIsSet(boolean value) {
    if (!value) {
      this.remote_storage_paths = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TCloudConfiguration getRemote_storage_conf() {
    return this.remote_storage_conf;
  }

  public TSpillToRemoteStorageOptions setRemote_storage_conf(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TCloudConfiguration remote_storage_conf) {
    this.remote_storage_conf = remote_storage_conf;
    return this;
  }

  public void unsetRemote_storage_conf() {
    this.remote_storage_conf = null;
  }

  /** Returns true if field remote_storage_conf is set (has been assigned a value) and false otherwise */
  public boolean isSetRemote_storage_conf() {
    return this.remote_storage_conf != null;
  }

  public void setRemote_storage_confIsSet(boolean value) {
    if (!value) {
      this.remote_storage_conf = null;
    }
  }

  public boolean isDisable_spill_to_local_disk() {
    return this.disable_spill_to_local_disk;
  }

  public TSpillToRemoteStorageOptions setDisable_spill_to_local_disk(boolean disable_spill_to_local_disk) {
    this.disable_spill_to_local_disk = disable_spill_to_local_disk;
    setDisable_spill_to_local_diskIsSet(true);
    return this;
  }

  public void unsetDisable_spill_to_local_disk() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DISABLE_SPILL_TO_LOCAL_DISK_ISSET_ID);
  }

  /** Returns true if field disable_spill_to_local_disk is set (has been assigned a value) and false otherwise */
  public boolean isSetDisable_spill_to_local_disk() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DISABLE_SPILL_TO_LOCAL_DISK_ISSET_ID);
  }

  public void setDisable_spill_to_local_diskIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DISABLE_SPILL_TO_LOCAL_DISK_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case REMOTE_STORAGE_PATHS:
      if (value == null) {
        unsetRemote_storage_paths();
      } else {
        setRemote_storage_paths((java.util.List<java.lang.String>)value);
      }
      break;

    case REMOTE_STORAGE_CONF:
      if (value == null) {
        unsetRemote_storage_conf();
      } else {
        setRemote_storage_conf((com.starrocks.thrift.TCloudConfiguration)value);
      }
      break;

    case DISABLE_SPILL_TO_LOCAL_DISK:
      if (value == null) {
        unsetDisable_spill_to_local_disk();
      } else {
        setDisable_spill_to_local_disk((java.lang.Boolean)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case REMOTE_STORAGE_PATHS:
      return getRemote_storage_paths();

    case REMOTE_STORAGE_CONF:
      return getRemote_storage_conf();

    case DISABLE_SPILL_TO_LOCAL_DISK:
      return isDisable_spill_to_local_disk();

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
    case REMOTE_STORAGE_PATHS:
      return isSetRemote_storage_paths();
    case REMOTE_STORAGE_CONF:
      return isSetRemote_storage_conf();
    case DISABLE_SPILL_TO_LOCAL_DISK:
      return isSetDisable_spill_to_local_disk();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TSpillToRemoteStorageOptions)
      return this.equals((TSpillToRemoteStorageOptions)that);
    return false;
  }

  public boolean equals(TSpillToRemoteStorageOptions that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_remote_storage_paths = true && this.isSetRemote_storage_paths();
    boolean that_present_remote_storage_paths = true && that.isSetRemote_storage_paths();
    if (this_present_remote_storage_paths || that_present_remote_storage_paths) {
      if (!(this_present_remote_storage_paths && that_present_remote_storage_paths))
        return false;
      if (!this.remote_storage_paths.equals(that.remote_storage_paths))
        return false;
    }

    boolean this_present_remote_storage_conf = true && this.isSetRemote_storage_conf();
    boolean that_present_remote_storage_conf = true && that.isSetRemote_storage_conf();
    if (this_present_remote_storage_conf || that_present_remote_storage_conf) {
      if (!(this_present_remote_storage_conf && that_present_remote_storage_conf))
        return false;
      if (!this.remote_storage_conf.equals(that.remote_storage_conf))
        return false;
    }

    boolean this_present_disable_spill_to_local_disk = true && this.isSetDisable_spill_to_local_disk();
    boolean that_present_disable_spill_to_local_disk = true && that.isSetDisable_spill_to_local_disk();
    if (this_present_disable_spill_to_local_disk || that_present_disable_spill_to_local_disk) {
      if (!(this_present_disable_spill_to_local_disk && that_present_disable_spill_to_local_disk))
        return false;
      if (this.disable_spill_to_local_disk != that.disable_spill_to_local_disk)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetRemote_storage_paths()) ? 131071 : 524287);
    if (isSetRemote_storage_paths())
      hashCode = hashCode * 8191 + remote_storage_paths.hashCode();

    hashCode = hashCode * 8191 + ((isSetRemote_storage_conf()) ? 131071 : 524287);
    if (isSetRemote_storage_conf())
      hashCode = hashCode * 8191 + remote_storage_conf.hashCode();

    hashCode = hashCode * 8191 + ((isSetDisable_spill_to_local_disk()) ? 131071 : 524287);
    if (isSetDisable_spill_to_local_disk())
      hashCode = hashCode * 8191 + ((disable_spill_to_local_disk) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(TSpillToRemoteStorageOptions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetRemote_storage_paths(), other.isSetRemote_storage_paths());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRemote_storage_paths()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.remote_storage_paths, other.remote_storage_paths);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetRemote_storage_conf(), other.isSetRemote_storage_conf());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRemote_storage_conf()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.remote_storage_conf, other.remote_storage_conf);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDisable_spill_to_local_disk(), other.isSetDisable_spill_to_local_disk());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDisable_spill_to_local_disk()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.disable_spill_to_local_disk, other.disable_spill_to_local_disk);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TSpillToRemoteStorageOptions(");
    boolean first = true;

    if (isSetRemote_storage_paths()) {
      sb.append("remote_storage_paths:");
      if (this.remote_storage_paths == null) {
        sb.append("null");
      } else {
        sb.append(this.remote_storage_paths);
      }
      first = false;
    }
    if (isSetRemote_storage_conf()) {
      if (!first) sb.append(", ");
      sb.append("remote_storage_conf:");
      if (this.remote_storage_conf == null) {
        sb.append("null");
      } else {
        sb.append(this.remote_storage_conf);
      }
      first = false;
    }
    if (isSetDisable_spill_to_local_disk()) {
      if (!first) sb.append(", ");
      sb.append("disable_spill_to_local_disk:");
      sb.append(this.disable_spill_to_local_disk);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (remote_storage_conf != null) {
      remote_storage_conf.validate();
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

  private static class TSpillToRemoteStorageOptionsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TSpillToRemoteStorageOptionsStandardScheme getScheme() {
      return new TSpillToRemoteStorageOptionsStandardScheme();
    }
  }

  private static class TSpillToRemoteStorageOptionsStandardScheme extends org.apache.thrift.scheme.StandardScheme<TSpillToRemoteStorageOptions> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TSpillToRemoteStorageOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // REMOTE_STORAGE_PATHS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list10 = iprot.readListBegin();
                struct.remote_storage_paths = new java.util.ArrayList<java.lang.String>(_list10.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _elem11;
                for (int _i12 = 0; _i12 < _list10.size; ++_i12)
                {
                  _elem11 = iprot.readString();
                  struct.remote_storage_paths.add(_elem11);
                }
                iprot.readListEnd();
              }
              struct.setRemote_storage_pathsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REMOTE_STORAGE_CONF
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.remote_storage_conf = new com.starrocks.thrift.TCloudConfiguration();
              struct.remote_storage_conf.read(iprot);
              struct.setRemote_storage_confIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DISABLE_SPILL_TO_LOCAL_DISK
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.disable_spill_to_local_disk = iprot.readBool();
              struct.setDisable_spill_to_local_diskIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TSpillToRemoteStorageOptions struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.remote_storage_paths != null) {
        if (struct.isSetRemote_storage_paths()) {
          oprot.writeFieldBegin(REMOTE_STORAGE_PATHS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.remote_storage_paths.size()));
            for (java.lang.String _iter13 : struct.remote_storage_paths)
            {
              oprot.writeString(_iter13);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.remote_storage_conf != null) {
        if (struct.isSetRemote_storage_conf()) {
          oprot.writeFieldBegin(REMOTE_STORAGE_CONF_FIELD_DESC);
          struct.remote_storage_conf.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetDisable_spill_to_local_disk()) {
        oprot.writeFieldBegin(DISABLE_SPILL_TO_LOCAL_DISK_FIELD_DESC);
        oprot.writeBool(struct.disable_spill_to_local_disk);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TSpillToRemoteStorageOptionsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TSpillToRemoteStorageOptionsTupleScheme getScheme() {
      return new TSpillToRemoteStorageOptionsTupleScheme();
    }
  }

  private static class TSpillToRemoteStorageOptionsTupleScheme extends org.apache.thrift.scheme.TupleScheme<TSpillToRemoteStorageOptions> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TSpillToRemoteStorageOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetRemote_storage_paths()) {
        optionals.set(0);
      }
      if (struct.isSetRemote_storage_conf()) {
        optionals.set(1);
      }
      if (struct.isSetDisable_spill_to_local_disk()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetRemote_storage_paths()) {
        {
          oprot.writeI32(struct.remote_storage_paths.size());
          for (java.lang.String _iter14 : struct.remote_storage_paths)
          {
            oprot.writeString(_iter14);
          }
        }
      }
      if (struct.isSetRemote_storage_conf()) {
        struct.remote_storage_conf.write(oprot);
      }
      if (struct.isSetDisable_spill_to_local_disk()) {
        oprot.writeBool(struct.disable_spill_to_local_disk);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TSpillToRemoteStorageOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list15 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.remote_storage_paths = new java.util.ArrayList<java.lang.String>(_list15.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _elem16;
          for (int _i17 = 0; _i17 < _list15.size; ++_i17)
          {
            _elem16 = iprot.readString();
            struct.remote_storage_paths.add(_elem16);
          }
        }
        struct.setRemote_storage_pathsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.remote_storage_conf = new com.starrocks.thrift.TCloudConfiguration();
        struct.remote_storage_conf.read(iprot);
        struct.setRemote_storage_confIsSet(true);
      }
      if (incoming.get(2)) {
        struct.disable_spill_to_local_disk = iprot.readBool();
        struct.setDisable_spill_to_local_diskIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

