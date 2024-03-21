/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TCompressedPartitionMap implements org.apache.thrift.TBase<TCompressedPartitionMap, TCompressedPartitionMap._Fields>, java.io.Serializable, Cloneable, Comparable<TCompressedPartitionMap> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TCompressedPartitionMap");

  private static final org.apache.thrift.protocol.TField ORIGINAL_LEN_FIELD_DESC = new org.apache.thrift.protocol.TField("original_len", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COMPRESSED_LEN_FIELD_DESC = new org.apache.thrift.protocol.TField("compressed_len", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField COMPRESSED_SERIALIZED_PARTITIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("compressed_serialized_partitions", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TCompressedPartitionMapStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TCompressedPartitionMapTupleSchemeFactory();

  public int original_len; // optional
  public int compressed_len; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String compressed_serialized_partitions; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ORIGINAL_LEN((short)1, "original_len"),
    COMPRESSED_LEN((short)2, "compressed_len"),
    COMPRESSED_SERIALIZED_PARTITIONS((short)3, "compressed_serialized_partitions");

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
        case 1: // ORIGINAL_LEN
          return ORIGINAL_LEN;
        case 2: // COMPRESSED_LEN
          return COMPRESSED_LEN;
        case 3: // COMPRESSED_SERIALIZED_PARTITIONS
          return COMPRESSED_SERIALIZED_PARTITIONS;
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
  private static final int __ORIGINAL_LEN_ISSET_ID = 0;
  private static final int __COMPRESSED_LEN_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.ORIGINAL_LEN,_Fields.COMPRESSED_LEN,_Fields.COMPRESSED_SERIALIZED_PARTITIONS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ORIGINAL_LEN, new org.apache.thrift.meta_data.FieldMetaData("original_len", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMPRESSED_LEN, new org.apache.thrift.meta_data.FieldMetaData("compressed_len", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMPRESSED_SERIALIZED_PARTITIONS, new org.apache.thrift.meta_data.FieldMetaData("compressed_serialized_partitions", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TCompressedPartitionMap.class, metaDataMap);
  }

  public TCompressedPartitionMap() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TCompressedPartitionMap(TCompressedPartitionMap other) {
    __isset_bitfield = other.__isset_bitfield;
    this.original_len = other.original_len;
    this.compressed_len = other.compressed_len;
    if (other.isSetCompressed_serialized_partitions()) {
      this.compressed_serialized_partitions = other.compressed_serialized_partitions;
    }
  }

  @Override
  public TCompressedPartitionMap deepCopy() {
    return new TCompressedPartitionMap(this);
  }

  @Override
  public void clear() {
    setOriginal_lenIsSet(false);
    this.original_len = 0;
    setCompressed_lenIsSet(false);
    this.compressed_len = 0;
    this.compressed_serialized_partitions = null;
  }

  public int getOriginal_len() {
    return this.original_len;
  }

  public TCompressedPartitionMap setOriginal_len(int original_len) {
    this.original_len = original_len;
    setOriginal_lenIsSet(true);
    return this;
  }

  public void unsetOriginal_len() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ORIGINAL_LEN_ISSET_ID);
  }

  /** Returns true if field original_len is set (has been assigned a value) and false otherwise */
  public boolean isSetOriginal_len() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ORIGINAL_LEN_ISSET_ID);
  }

  public void setOriginal_lenIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ORIGINAL_LEN_ISSET_ID, value);
  }

  public int getCompressed_len() {
    return this.compressed_len;
  }

  public TCompressedPartitionMap setCompressed_len(int compressed_len) {
    this.compressed_len = compressed_len;
    setCompressed_lenIsSet(true);
    return this;
  }

  public void unsetCompressed_len() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __COMPRESSED_LEN_ISSET_ID);
  }

  /** Returns true if field compressed_len is set (has been assigned a value) and false otherwise */
  public boolean isSetCompressed_len() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __COMPRESSED_LEN_ISSET_ID);
  }

  public void setCompressed_lenIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __COMPRESSED_LEN_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCompressed_serialized_partitions() {
    return this.compressed_serialized_partitions;
  }

  public TCompressedPartitionMap setCompressed_serialized_partitions(@org.apache.thrift.annotation.Nullable java.lang.String compressed_serialized_partitions) {
    this.compressed_serialized_partitions = compressed_serialized_partitions;
    return this;
  }

  public void unsetCompressed_serialized_partitions() {
    this.compressed_serialized_partitions = null;
  }

  /** Returns true if field compressed_serialized_partitions is set (has been assigned a value) and false otherwise */
  public boolean isSetCompressed_serialized_partitions() {
    return this.compressed_serialized_partitions != null;
  }

  public void setCompressed_serialized_partitionsIsSet(boolean value) {
    if (!value) {
      this.compressed_serialized_partitions = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ORIGINAL_LEN:
      if (value == null) {
        unsetOriginal_len();
      } else {
        setOriginal_len((java.lang.Integer)value);
      }
      break;

    case COMPRESSED_LEN:
      if (value == null) {
        unsetCompressed_len();
      } else {
        setCompressed_len((java.lang.Integer)value);
      }
      break;

    case COMPRESSED_SERIALIZED_PARTITIONS:
      if (value == null) {
        unsetCompressed_serialized_partitions();
      } else {
        setCompressed_serialized_partitions((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ORIGINAL_LEN:
      return getOriginal_len();

    case COMPRESSED_LEN:
      return getCompressed_len();

    case COMPRESSED_SERIALIZED_PARTITIONS:
      return getCompressed_serialized_partitions();

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
    case ORIGINAL_LEN:
      return isSetOriginal_len();
    case COMPRESSED_LEN:
      return isSetCompressed_len();
    case COMPRESSED_SERIALIZED_PARTITIONS:
      return isSetCompressed_serialized_partitions();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TCompressedPartitionMap)
      return this.equals((TCompressedPartitionMap)that);
    return false;
  }

  public boolean equals(TCompressedPartitionMap that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_original_len = true && this.isSetOriginal_len();
    boolean that_present_original_len = true && that.isSetOriginal_len();
    if (this_present_original_len || that_present_original_len) {
      if (!(this_present_original_len && that_present_original_len))
        return false;
      if (this.original_len != that.original_len)
        return false;
    }

    boolean this_present_compressed_len = true && this.isSetCompressed_len();
    boolean that_present_compressed_len = true && that.isSetCompressed_len();
    if (this_present_compressed_len || that_present_compressed_len) {
      if (!(this_present_compressed_len && that_present_compressed_len))
        return false;
      if (this.compressed_len != that.compressed_len)
        return false;
    }

    boolean this_present_compressed_serialized_partitions = true && this.isSetCompressed_serialized_partitions();
    boolean that_present_compressed_serialized_partitions = true && that.isSetCompressed_serialized_partitions();
    if (this_present_compressed_serialized_partitions || that_present_compressed_serialized_partitions) {
      if (!(this_present_compressed_serialized_partitions && that_present_compressed_serialized_partitions))
        return false;
      if (!this.compressed_serialized_partitions.equals(that.compressed_serialized_partitions))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetOriginal_len()) ? 131071 : 524287);
    if (isSetOriginal_len())
      hashCode = hashCode * 8191 + original_len;

    hashCode = hashCode * 8191 + ((isSetCompressed_len()) ? 131071 : 524287);
    if (isSetCompressed_len())
      hashCode = hashCode * 8191 + compressed_len;

    hashCode = hashCode * 8191 + ((isSetCompressed_serialized_partitions()) ? 131071 : 524287);
    if (isSetCompressed_serialized_partitions())
      hashCode = hashCode * 8191 + compressed_serialized_partitions.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TCompressedPartitionMap other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetOriginal_len(), other.isSetOriginal_len());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOriginal_len()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.original_len, other.original_len);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCompressed_len(), other.isSetCompressed_len());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompressed_len()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.compressed_len, other.compressed_len);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCompressed_serialized_partitions(), other.isSetCompressed_serialized_partitions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompressed_serialized_partitions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.compressed_serialized_partitions, other.compressed_serialized_partitions);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TCompressedPartitionMap(");
    boolean first = true;

    if (isSetOriginal_len()) {
      sb.append("original_len:");
      sb.append(this.original_len);
      first = false;
    }
    if (isSetCompressed_len()) {
      if (!first) sb.append(", ");
      sb.append("compressed_len:");
      sb.append(this.compressed_len);
      first = false;
    }
    if (isSetCompressed_serialized_partitions()) {
      if (!first) sb.append(", ");
      sb.append("compressed_serialized_partitions:");
      if (this.compressed_serialized_partitions == null) {
        sb.append("null");
      } else {
        sb.append(this.compressed_serialized_partitions);
      }
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

  private static class TCompressedPartitionMapStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TCompressedPartitionMapStandardScheme getScheme() {
      return new TCompressedPartitionMapStandardScheme();
    }
  }

  private static class TCompressedPartitionMapStandardScheme extends org.apache.thrift.scheme.StandardScheme<TCompressedPartitionMap> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TCompressedPartitionMap struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ORIGINAL_LEN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.original_len = iprot.readI32();
              struct.setOriginal_lenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMPRESSED_LEN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.compressed_len = iprot.readI32();
              struct.setCompressed_lenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COMPRESSED_SERIALIZED_PARTITIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.compressed_serialized_partitions = iprot.readString();
              struct.setCompressed_serialized_partitionsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TCompressedPartitionMap struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetOriginal_len()) {
        oprot.writeFieldBegin(ORIGINAL_LEN_FIELD_DESC);
        oprot.writeI32(struct.original_len);
        oprot.writeFieldEnd();
      }
      if (struct.isSetCompressed_len()) {
        oprot.writeFieldBegin(COMPRESSED_LEN_FIELD_DESC);
        oprot.writeI32(struct.compressed_len);
        oprot.writeFieldEnd();
      }
      if (struct.compressed_serialized_partitions != null) {
        if (struct.isSetCompressed_serialized_partitions()) {
          oprot.writeFieldBegin(COMPRESSED_SERIALIZED_PARTITIONS_FIELD_DESC);
          oprot.writeString(struct.compressed_serialized_partitions);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TCompressedPartitionMapTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TCompressedPartitionMapTupleScheme getScheme() {
      return new TCompressedPartitionMapTupleScheme();
    }
  }

  private static class TCompressedPartitionMapTupleScheme extends org.apache.thrift.scheme.TupleScheme<TCompressedPartitionMap> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TCompressedPartitionMap struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetOriginal_len()) {
        optionals.set(0);
      }
      if (struct.isSetCompressed_len()) {
        optionals.set(1);
      }
      if (struct.isSetCompressed_serialized_partitions()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetOriginal_len()) {
        oprot.writeI32(struct.original_len);
      }
      if (struct.isSetCompressed_len()) {
        oprot.writeI32(struct.compressed_len);
      }
      if (struct.isSetCompressed_serialized_partitions()) {
        oprot.writeString(struct.compressed_serialized_partitions);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TCompressedPartitionMap struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.original_len = iprot.readI32();
        struct.setOriginal_lenIsSet(true);
      }
      if (incoming.get(1)) {
        struct.compressed_len = iprot.readI32();
        struct.setCompressed_lenIsSet(true);
      }
      if (incoming.get(2)) {
        struct.compressed_serialized_partitions = iprot.readString();
        struct.setCompressed_serialized_partitionsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
