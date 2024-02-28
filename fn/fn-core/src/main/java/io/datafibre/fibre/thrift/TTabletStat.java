/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TTabletStat implements org.apache.thrift.TBase<TTabletStat, TTabletStat._Fields>, java.io.Serializable, Cloneable, Comparable<TTabletStat> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTabletStat");

  private static final org.apache.thrift.protocol.TField TABLET_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tablet_id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField DATA_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("data_size", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField ROW_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("row_num", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField VERSION_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("version_count", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTabletStatStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTabletStatTupleSchemeFactory();

  public long tablet_id; // required
  public long data_size; // optional
  public long row_num; // optional
  public long version_count; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLET_ID((short)1, "tablet_id"),
    DATA_SIZE((short)2, "data_size"),
    ROW_NUM((short)3, "row_num"),
    VERSION_COUNT((short)4, "version_count");

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
        case 1: // TABLET_ID
          return TABLET_ID;
        case 2: // DATA_SIZE
          return DATA_SIZE;
        case 3: // ROW_NUM
          return ROW_NUM;
        case 4: // VERSION_COUNT
          return VERSION_COUNT;
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
  private static final int __TABLET_ID_ISSET_ID = 0;
  private static final int __DATA_SIZE_ISSET_ID = 1;
  private static final int __ROW_NUM_ISSET_ID = 2;
  private static final int __VERSION_COUNT_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DATA_SIZE,_Fields.ROW_NUM,_Fields.VERSION_COUNT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLET_ID, new org.apache.thrift.meta_data.FieldMetaData("tablet_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DATA_SIZE, new org.apache.thrift.meta_data.FieldMetaData("data_size", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ROW_NUM, new org.apache.thrift.meta_data.FieldMetaData("row_num", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.VERSION_COUNT, new org.apache.thrift.meta_data.FieldMetaData("version_count", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTabletStat.class, metaDataMap);
  }

  public TTabletStat() {
  }

  public TTabletStat(
    long tablet_id)
  {
    this();
    this.tablet_id = tablet_id;
    setTablet_idIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTabletStat(TTabletStat other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tablet_id = other.tablet_id;
    this.data_size = other.data_size;
    this.row_num = other.row_num;
    this.version_count = other.version_count;
  }

  @Override
  public TTabletStat deepCopy() {
    return new TTabletStat(this);
  }

  @Override
  public void clear() {
    setTablet_idIsSet(false);
    this.tablet_id = 0;
    setData_sizeIsSet(false);
    this.data_size = 0;
    setRow_numIsSet(false);
    this.row_num = 0;
    setVersion_countIsSet(false);
    this.version_count = 0;
  }

  public long getTablet_id() {
    return this.tablet_id;
  }

  public TTabletStat setTablet_id(long tablet_id) {
    this.tablet_id = tablet_id;
    setTablet_idIsSet(true);
    return this;
  }

  public void unsetTablet_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TABLET_ID_ISSET_ID);
  }

  /** Returns true if field tablet_id is set (has been assigned a value) and false otherwise */
  public boolean isSetTablet_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TABLET_ID_ISSET_ID);
  }

  public void setTablet_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TABLET_ID_ISSET_ID, value);
  }

  public long getData_size() {
    return this.data_size;
  }

  public TTabletStat setData_size(long data_size) {
    this.data_size = data_size;
    setData_sizeIsSet(true);
    return this;
  }

  public void unsetData_size() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DATA_SIZE_ISSET_ID);
  }

  /** Returns true if field data_size is set (has been assigned a value) and false otherwise */
  public boolean isSetData_size() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DATA_SIZE_ISSET_ID);
  }

  public void setData_sizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DATA_SIZE_ISSET_ID, value);
  }

  public long getRow_num() {
    return this.row_num;
  }

  public TTabletStat setRow_num(long row_num) {
    this.row_num = row_num;
    setRow_numIsSet(true);
    return this;
  }

  public void unsetRow_num() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ROW_NUM_ISSET_ID);
  }

  /** Returns true if field row_num is set (has been assigned a value) and false otherwise */
  public boolean isSetRow_num() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ROW_NUM_ISSET_ID);
  }

  public void setRow_numIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ROW_NUM_ISSET_ID, value);
  }

  public long getVersion_count() {
    return this.version_count;
  }

  public TTabletStat setVersion_count(long version_count) {
    this.version_count = version_count;
    setVersion_countIsSet(true);
    return this;
  }

  public void unsetVersion_count() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VERSION_COUNT_ISSET_ID);
  }

  /** Returns true if field version_count is set (has been assigned a value) and false otherwise */
  public boolean isSetVersion_count() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VERSION_COUNT_ISSET_ID);
  }

  public void setVersion_countIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VERSION_COUNT_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TABLET_ID:
      if (value == null) {
        unsetTablet_id();
      } else {
        setTablet_id((java.lang.Long)value);
      }
      break;

    case DATA_SIZE:
      if (value == null) {
        unsetData_size();
      } else {
        setData_size((java.lang.Long)value);
      }
      break;

    case ROW_NUM:
      if (value == null) {
        unsetRow_num();
      } else {
        setRow_num((java.lang.Long)value);
      }
      break;

    case VERSION_COUNT:
      if (value == null) {
        unsetVersion_count();
      } else {
        setVersion_count((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLET_ID:
      return getTablet_id();

    case DATA_SIZE:
      return getData_size();

    case ROW_NUM:
      return getRow_num();

    case VERSION_COUNT:
      return getVersion_count();

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
    case TABLET_ID:
      return isSetTablet_id();
    case DATA_SIZE:
      return isSetData_size();
    case ROW_NUM:
      return isSetRow_num();
    case VERSION_COUNT:
      return isSetVersion_count();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TTabletStat)
      return this.equals((TTabletStat)that);
    return false;
  }

  public boolean equals(TTabletStat that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tablet_id = true;
    boolean that_present_tablet_id = true;
    if (this_present_tablet_id || that_present_tablet_id) {
      if (!(this_present_tablet_id && that_present_tablet_id))
        return false;
      if (this.tablet_id != that.tablet_id)
        return false;
    }

    boolean this_present_data_size = true && this.isSetData_size();
    boolean that_present_data_size = true && that.isSetData_size();
    if (this_present_data_size || that_present_data_size) {
      if (!(this_present_data_size && that_present_data_size))
        return false;
      if (this.data_size != that.data_size)
        return false;
    }

    boolean this_present_row_num = true && this.isSetRow_num();
    boolean that_present_row_num = true && that.isSetRow_num();
    if (this_present_row_num || that_present_row_num) {
      if (!(this_present_row_num && that_present_row_num))
        return false;
      if (this.row_num != that.row_num)
        return false;
    }

    boolean this_present_version_count = true && this.isSetVersion_count();
    boolean that_present_version_count = true && that.isSetVersion_count();
    if (this_present_version_count || that_present_version_count) {
      if (!(this_present_version_count && that_present_version_count))
        return false;
      if (this.version_count != that.version_count)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(tablet_id);

    hashCode = hashCode * 8191 + ((isSetData_size()) ? 131071 : 524287);
    if (isSetData_size())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(data_size);

    hashCode = hashCode * 8191 + ((isSetRow_num()) ? 131071 : 524287);
    if (isSetRow_num())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(row_num);

    hashCode = hashCode * 8191 + ((isSetVersion_count()) ? 131071 : 524287);
    if (isSetVersion_count())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(version_count);

    return hashCode;
  }

  @Override
  public int compareTo(TTabletStat other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTablet_id(), other.isSetTablet_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTablet_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablet_id, other.tablet_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetData_size(), other.isSetData_size());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData_size()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data_size, other.data_size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetRow_num(), other.isSetRow_num());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRow_num()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.row_num, other.row_num);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetVersion_count(), other.isSetVersion_count());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVersion_count()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.version_count, other.version_count);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTabletStat(");
    boolean first = true;

    sb.append("tablet_id:");
    sb.append(this.tablet_id);
    first = false;
    if (isSetData_size()) {
      if (!first) sb.append(", ");
      sb.append("data_size:");
      sb.append(this.data_size);
      first = false;
    }
    if (isSetRow_num()) {
      if (!first) sb.append(", ");
      sb.append("row_num:");
      sb.append(this.row_num);
      first = false;
    }
    if (isSetVersion_count()) {
      if (!first) sb.append(", ");
      sb.append("version_count:");
      sb.append(this.version_count);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'tablet_id' because it's a primitive and you chose the non-beans generator.
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

  private static class TTabletStatStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTabletStatStandardScheme getScheme() {
      return new TTabletStatStandardScheme();
    }
  }

  private static class TTabletStatStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTabletStat> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TTabletStat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLET_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.tablet_id = iprot.readI64();
              struct.setTablet_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATA_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.data_size = iprot.readI64();
              struct.setData_sizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ROW_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.row_num = iprot.readI64();
              struct.setRow_numIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // VERSION_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.version_count = iprot.readI64();
              struct.setVersion_countIsSet(true);
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
      if (!struct.isSetTablet_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'tablet_id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TTabletStat struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TABLET_ID_FIELD_DESC);
      oprot.writeI64(struct.tablet_id);
      oprot.writeFieldEnd();
      if (struct.isSetData_size()) {
        oprot.writeFieldBegin(DATA_SIZE_FIELD_DESC);
        oprot.writeI64(struct.data_size);
        oprot.writeFieldEnd();
      }
      if (struct.isSetRow_num()) {
        oprot.writeFieldBegin(ROW_NUM_FIELD_DESC);
        oprot.writeI64(struct.row_num);
        oprot.writeFieldEnd();
      }
      if (struct.isSetVersion_count()) {
        oprot.writeFieldBegin(VERSION_COUNT_FIELD_DESC);
        oprot.writeI64(struct.version_count);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTabletStatTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTabletStatTupleScheme getScheme() {
      return new TTabletStatTupleScheme();
    }
  }

  private static class TTabletStatTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTabletStat> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTabletStat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI64(struct.tablet_id);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetData_size()) {
        optionals.set(0);
      }
      if (struct.isSetRow_num()) {
        optionals.set(1);
      }
      if (struct.isSetVersion_count()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetData_size()) {
        oprot.writeI64(struct.data_size);
      }
      if (struct.isSetRow_num()) {
        oprot.writeI64(struct.row_num);
      }
      if (struct.isSetVersion_count()) {
        oprot.writeI64(struct.version_count);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTabletStat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.tablet_id = iprot.readI64();
      struct.setTablet_idIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.data_size = iprot.readI64();
        struct.setData_sizeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.row_num = iprot.readI64();
        struct.setRow_numIsSet(true);
      }
      if (incoming.get(2)) {
        struct.version_count = iprot.readI64();
        struct.setVersion_countIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

