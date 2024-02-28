/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TColumnDefinition implements org.apache.thrift.TBase<TColumnDefinition, TColumnDefinition._Fields>, java.io.Serializable, Cloneable, Comparable<TColumnDefinition> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TColumnDefinition");

  private static final org.apache.thrift.protocol.TField COLUMN_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("columnName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COLUMN_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("columnType", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField AGG_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("aggType", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField DEFAULT_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("defaultValue", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TColumnDefinitionStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TColumnDefinitionTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String columnName; // required
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TColumnType columnType; // required
  /**
   * 
   * @see io.datafibre.fibre.thrift.TAggregationType
   */
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TAggregationType aggType; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String defaultValue; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COLUMN_NAME((short)1, "columnName"),
    COLUMN_TYPE((short)2, "columnType"),
    /**
     * 
     * @see io.datafibre.fibre.thrift.TAggregationType
     */
    AGG_TYPE((short)3, "aggType"),
    DEFAULT_VALUE((short)4, "defaultValue");

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
        case 1: // COLUMN_NAME
          return COLUMN_NAME;
        case 2: // COLUMN_TYPE
          return COLUMN_TYPE;
        case 3: // AGG_TYPE
          return AGG_TYPE;
        case 4: // DEFAULT_VALUE
          return DEFAULT_VALUE;
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
  private static final _Fields optionals[] = {_Fields.AGG_TYPE,_Fields.DEFAULT_VALUE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COLUMN_NAME, new org.apache.thrift.meta_data.FieldMetaData("columnName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COLUMN_TYPE, new org.apache.thrift.meta_data.FieldMetaData("columnType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TColumnType.class)));
    tmpMap.put(_Fields.AGG_TYPE, new org.apache.thrift.meta_data.FieldMetaData("aggType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, io.datafibre.fibre.thrift.TAggregationType.class)));
    tmpMap.put(_Fields.DEFAULT_VALUE, new org.apache.thrift.meta_data.FieldMetaData("defaultValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TColumnDefinition.class, metaDataMap);
  }

  public TColumnDefinition() {
  }

  public TColumnDefinition(
    java.lang.String columnName,
    io.datafibre.fibre.thrift.TColumnType columnType)
  {
    this();
    this.columnName = columnName;
    this.columnType = columnType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TColumnDefinition(TColumnDefinition other) {
    if (other.isSetColumnName()) {
      this.columnName = other.columnName;
    }
    if (other.isSetColumnType()) {
      this.columnType = new io.datafibre.fibre.thrift.TColumnType(other.columnType);
    }
    if (other.isSetAggType()) {
      this.aggType = other.aggType;
    }
    if (other.isSetDefaultValue()) {
      this.defaultValue = other.defaultValue;
    }
  }

  @Override
  public TColumnDefinition deepCopy() {
    return new TColumnDefinition(this);
  }

  @Override
  public void clear() {
    this.columnName = null;
    this.columnType = null;
    this.aggType = null;
    this.defaultValue = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getColumnName() {
    return this.columnName;
  }

  public TColumnDefinition setColumnName(@org.apache.thrift.annotation.Nullable java.lang.String columnName) {
    this.columnName = columnName;
    return this;
  }

  public void unsetColumnName() {
    this.columnName = null;
  }

  /** Returns true if field columnName is set (has been assigned a value) and false otherwise */
  public boolean isSetColumnName() {
    return this.columnName != null;
  }

  public void setColumnNameIsSet(boolean value) {
    if (!value) {
      this.columnName = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TColumnType getColumnType() {
    return this.columnType;
  }

  public TColumnDefinition setColumnType(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TColumnType columnType) {
    this.columnType = columnType;
    return this;
  }

  public void unsetColumnType() {
    this.columnType = null;
  }

  /** Returns true if field columnType is set (has been assigned a value) and false otherwise */
  public boolean isSetColumnType() {
    return this.columnType != null;
  }

  public void setColumnTypeIsSet(boolean value) {
    if (!value) {
      this.columnType = null;
    }
  }

  /**
   * 
   * @see io.datafibre.fibre.thrift.TAggregationType
   */
  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TAggregationType getAggType() {
    return this.aggType;
  }

  /**
   * 
   * @see io.datafibre.fibre.thrift.TAggregationType
   */
  public TColumnDefinition setAggType(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TAggregationType aggType) {
    this.aggType = aggType;
    return this;
  }

  public void unsetAggType() {
    this.aggType = null;
  }

  /** Returns true if field aggType is set (has been assigned a value) and false otherwise */
  public boolean isSetAggType() {
    return this.aggType != null;
  }

  public void setAggTypeIsSet(boolean value) {
    if (!value) {
      this.aggType = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDefaultValue() {
    return this.defaultValue;
  }

  public TColumnDefinition setDefaultValue(@org.apache.thrift.annotation.Nullable java.lang.String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  public void unsetDefaultValue() {
    this.defaultValue = null;
  }

  /** Returns true if field defaultValue is set (has been assigned a value) and false otherwise */
  public boolean isSetDefaultValue() {
    return this.defaultValue != null;
  }

  public void setDefaultValueIsSet(boolean value) {
    if (!value) {
      this.defaultValue = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case COLUMN_NAME:
      if (value == null) {
        unsetColumnName();
      } else {
        setColumnName((java.lang.String)value);
      }
      break;

    case COLUMN_TYPE:
      if (value == null) {
        unsetColumnType();
      } else {
        setColumnType((io.datafibre.fibre.thrift.TColumnType)value);
      }
      break;

    case AGG_TYPE:
      if (value == null) {
        unsetAggType();
      } else {
        setAggType((io.datafibre.fibre.thrift.TAggregationType)value);
      }
      break;

    case DEFAULT_VALUE:
      if (value == null) {
        unsetDefaultValue();
      } else {
        setDefaultValue((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case COLUMN_NAME:
      return getColumnName();

    case COLUMN_TYPE:
      return getColumnType();

    case AGG_TYPE:
      return getAggType();

    case DEFAULT_VALUE:
      return getDefaultValue();

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
    case COLUMN_NAME:
      return isSetColumnName();
    case COLUMN_TYPE:
      return isSetColumnType();
    case AGG_TYPE:
      return isSetAggType();
    case DEFAULT_VALUE:
      return isSetDefaultValue();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TColumnDefinition)
      return this.equals((TColumnDefinition)that);
    return false;
  }

  public boolean equals(TColumnDefinition that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_columnName = true && this.isSetColumnName();
    boolean that_present_columnName = true && that.isSetColumnName();
    if (this_present_columnName || that_present_columnName) {
      if (!(this_present_columnName && that_present_columnName))
        return false;
      if (!this.columnName.equals(that.columnName))
        return false;
    }

    boolean this_present_columnType = true && this.isSetColumnType();
    boolean that_present_columnType = true && that.isSetColumnType();
    if (this_present_columnType || that_present_columnType) {
      if (!(this_present_columnType && that_present_columnType))
        return false;
      if (!this.columnType.equals(that.columnType))
        return false;
    }

    boolean this_present_aggType = true && this.isSetAggType();
    boolean that_present_aggType = true && that.isSetAggType();
    if (this_present_aggType || that_present_aggType) {
      if (!(this_present_aggType && that_present_aggType))
        return false;
      if (!this.aggType.equals(that.aggType))
        return false;
    }

    boolean this_present_defaultValue = true && this.isSetDefaultValue();
    boolean that_present_defaultValue = true && that.isSetDefaultValue();
    if (this_present_defaultValue || that_present_defaultValue) {
      if (!(this_present_defaultValue && that_present_defaultValue))
        return false;
      if (!this.defaultValue.equals(that.defaultValue))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetColumnName()) ? 131071 : 524287);
    if (isSetColumnName())
      hashCode = hashCode * 8191 + columnName.hashCode();

    hashCode = hashCode * 8191 + ((isSetColumnType()) ? 131071 : 524287);
    if (isSetColumnType())
      hashCode = hashCode * 8191 + columnType.hashCode();

    hashCode = hashCode * 8191 + ((isSetAggType()) ? 131071 : 524287);
    if (isSetAggType())
      hashCode = hashCode * 8191 + aggType.getValue();

    hashCode = hashCode * 8191 + ((isSetDefaultValue()) ? 131071 : 524287);
    if (isSetDefaultValue())
      hashCode = hashCode * 8191 + defaultValue.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TColumnDefinition other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetColumnName(), other.isSetColumnName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumnName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columnName, other.columnName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetColumnType(), other.isSetColumnType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumnType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columnType, other.columnType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAggType(), other.isSetAggType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAggType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.aggType, other.aggType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDefaultValue(), other.isSetDefaultValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDefaultValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.defaultValue, other.defaultValue);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TColumnDefinition(");
    boolean first = true;

    sb.append("columnName:");
    if (this.columnName == null) {
      sb.append("null");
    } else {
      sb.append(this.columnName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("columnType:");
    if (this.columnType == null) {
      sb.append("null");
    } else {
      sb.append(this.columnType);
    }
    first = false;
    if (isSetAggType()) {
      if (!first) sb.append(", ");
      sb.append("aggType:");
      if (this.aggType == null) {
        sb.append("null");
      } else {
        sb.append(this.aggType);
      }
      first = false;
    }
    if (isSetDefaultValue()) {
      if (!first) sb.append(", ");
      sb.append("defaultValue:");
      if (this.defaultValue == null) {
        sb.append("null");
      } else {
        sb.append(this.defaultValue);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (columnName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'columnName' was not present! Struct: " + toString());
    }
    if (columnType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'columnType' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (columnType != null) {
      columnType.validate();
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

  private static class TColumnDefinitionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TColumnDefinitionStandardScheme getScheme() {
      return new TColumnDefinitionStandardScheme();
    }
  }

  private static class TColumnDefinitionStandardScheme extends org.apache.thrift.scheme.StandardScheme<TColumnDefinition> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TColumnDefinition struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COLUMN_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.columnName = iprot.readString();
              struct.setColumnNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COLUMN_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.columnType = new io.datafibre.fibre.thrift.TColumnType();
              struct.columnType.read(iprot);
              struct.setColumnTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AGG_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.aggType = io.datafibre.fibre.thrift.TAggregationType.findByValue(iprot.readI32());
              struct.setAggTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DEFAULT_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.defaultValue = iprot.readString();
              struct.setDefaultValueIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TColumnDefinition struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.columnName != null) {
        oprot.writeFieldBegin(COLUMN_NAME_FIELD_DESC);
        oprot.writeString(struct.columnName);
        oprot.writeFieldEnd();
      }
      if (struct.columnType != null) {
        oprot.writeFieldBegin(COLUMN_TYPE_FIELD_DESC);
        struct.columnType.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.aggType != null) {
        if (struct.isSetAggType()) {
          oprot.writeFieldBegin(AGG_TYPE_FIELD_DESC);
          oprot.writeI32(struct.aggType.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.defaultValue != null) {
        if (struct.isSetDefaultValue()) {
          oprot.writeFieldBegin(DEFAULT_VALUE_FIELD_DESC);
          oprot.writeString(struct.defaultValue);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TColumnDefinitionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TColumnDefinitionTupleScheme getScheme() {
      return new TColumnDefinitionTupleScheme();
    }
  }

  private static class TColumnDefinitionTupleScheme extends org.apache.thrift.scheme.TupleScheme<TColumnDefinition> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TColumnDefinition struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.columnName);
      struct.columnType.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAggType()) {
        optionals.set(0);
      }
      if (struct.isSetDefaultValue()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetAggType()) {
        oprot.writeI32(struct.aggType.getValue());
      }
      if (struct.isSetDefaultValue()) {
        oprot.writeString(struct.defaultValue);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TColumnDefinition struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.columnName = iprot.readString();
      struct.setColumnNameIsSet(true);
      struct.columnType = new io.datafibre.fibre.thrift.TColumnType();
      struct.columnType.read(iprot);
      struct.setColumnTypeIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.aggType = io.datafibre.fibre.thrift.TAggregationType.findByValue(iprot.readI32());
        struct.setAggTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.defaultValue = iprot.readString();
        struct.setDefaultValueIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

