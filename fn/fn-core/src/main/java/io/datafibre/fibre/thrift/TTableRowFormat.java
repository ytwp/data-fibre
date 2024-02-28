/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TTableRowFormat implements org.apache.thrift.TBase<TTableRowFormat, TTableRowFormat._Fields>, java.io.Serializable, Cloneable, Comparable<TTableRowFormat> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTableRowFormat");

  private static final org.apache.thrift.protocol.TField FIELD_TERMINATOR_FIELD_DESC = new org.apache.thrift.protocol.TField("field_terminator", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField LINE_TERMINATOR_FIELD_DESC = new org.apache.thrift.protocol.TField("line_terminator", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ESCAPED_BY_FIELD_DESC = new org.apache.thrift.protocol.TField("escaped_by", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTableRowFormatStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTableRowFormatTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String field_terminator; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String line_terminator; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String escaped_by; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FIELD_TERMINATOR((short)1, "field_terminator"),
    LINE_TERMINATOR((short)2, "line_terminator"),
    ESCAPED_BY((short)3, "escaped_by");

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
        case 1: // FIELD_TERMINATOR
          return FIELD_TERMINATOR;
        case 2: // LINE_TERMINATOR
          return LINE_TERMINATOR;
        case 3: // ESCAPED_BY
          return ESCAPED_BY;
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
  private static final _Fields optionals[] = {_Fields.FIELD_TERMINATOR,_Fields.LINE_TERMINATOR,_Fields.ESCAPED_BY};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FIELD_TERMINATOR, new org.apache.thrift.meta_data.FieldMetaData("field_terminator", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LINE_TERMINATOR, new org.apache.thrift.meta_data.FieldMetaData("line_terminator", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ESCAPED_BY, new org.apache.thrift.meta_data.FieldMetaData("escaped_by", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTableRowFormat.class, metaDataMap);
  }

  public TTableRowFormat() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTableRowFormat(TTableRowFormat other) {
    if (other.isSetField_terminator()) {
      this.field_terminator = other.field_terminator;
    }
    if (other.isSetLine_terminator()) {
      this.line_terminator = other.line_terminator;
    }
    if (other.isSetEscaped_by()) {
      this.escaped_by = other.escaped_by;
    }
  }

  @Override
  public TTableRowFormat deepCopy() {
    return new TTableRowFormat(this);
  }

  @Override
  public void clear() {
    this.field_terminator = null;
    this.line_terminator = null;
    this.escaped_by = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getField_terminator() {
    return this.field_terminator;
  }

  public TTableRowFormat setField_terminator(@org.apache.thrift.annotation.Nullable java.lang.String field_terminator) {
    this.field_terminator = field_terminator;
    return this;
  }

  public void unsetField_terminator() {
    this.field_terminator = null;
  }

  /** Returns true if field field_terminator is set (has been assigned a value) and false otherwise */
  public boolean isSetField_terminator() {
    return this.field_terminator != null;
  }

  public void setField_terminatorIsSet(boolean value) {
    if (!value) {
      this.field_terminator = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getLine_terminator() {
    return this.line_terminator;
  }

  public TTableRowFormat setLine_terminator(@org.apache.thrift.annotation.Nullable java.lang.String line_terminator) {
    this.line_terminator = line_terminator;
    return this;
  }

  public void unsetLine_terminator() {
    this.line_terminator = null;
  }

  /** Returns true if field line_terminator is set (has been assigned a value) and false otherwise */
  public boolean isSetLine_terminator() {
    return this.line_terminator != null;
  }

  public void setLine_terminatorIsSet(boolean value) {
    if (!value) {
      this.line_terminator = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEscaped_by() {
    return this.escaped_by;
  }

  public TTableRowFormat setEscaped_by(@org.apache.thrift.annotation.Nullable java.lang.String escaped_by) {
    this.escaped_by = escaped_by;
    return this;
  }

  public void unsetEscaped_by() {
    this.escaped_by = null;
  }

  /** Returns true if field escaped_by is set (has been assigned a value) and false otherwise */
  public boolean isSetEscaped_by() {
    return this.escaped_by != null;
  }

  public void setEscaped_byIsSet(boolean value) {
    if (!value) {
      this.escaped_by = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case FIELD_TERMINATOR:
      if (value == null) {
        unsetField_terminator();
      } else {
        setField_terminator((java.lang.String)value);
      }
      break;

    case LINE_TERMINATOR:
      if (value == null) {
        unsetLine_terminator();
      } else {
        setLine_terminator((java.lang.String)value);
      }
      break;

    case ESCAPED_BY:
      if (value == null) {
        unsetEscaped_by();
      } else {
        setEscaped_by((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FIELD_TERMINATOR:
      return getField_terminator();

    case LINE_TERMINATOR:
      return getLine_terminator();

    case ESCAPED_BY:
      return getEscaped_by();

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
    case FIELD_TERMINATOR:
      return isSetField_terminator();
    case LINE_TERMINATOR:
      return isSetLine_terminator();
    case ESCAPED_BY:
      return isSetEscaped_by();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TTableRowFormat)
      return this.equals((TTableRowFormat)that);
    return false;
  }

  public boolean equals(TTableRowFormat that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_field_terminator = true && this.isSetField_terminator();
    boolean that_present_field_terminator = true && that.isSetField_terminator();
    if (this_present_field_terminator || that_present_field_terminator) {
      if (!(this_present_field_terminator && that_present_field_terminator))
        return false;
      if (!this.field_terminator.equals(that.field_terminator))
        return false;
    }

    boolean this_present_line_terminator = true && this.isSetLine_terminator();
    boolean that_present_line_terminator = true && that.isSetLine_terminator();
    if (this_present_line_terminator || that_present_line_terminator) {
      if (!(this_present_line_terminator && that_present_line_terminator))
        return false;
      if (!this.line_terminator.equals(that.line_terminator))
        return false;
    }

    boolean this_present_escaped_by = true && this.isSetEscaped_by();
    boolean that_present_escaped_by = true && that.isSetEscaped_by();
    if (this_present_escaped_by || that_present_escaped_by) {
      if (!(this_present_escaped_by && that_present_escaped_by))
        return false;
      if (!this.escaped_by.equals(that.escaped_by))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetField_terminator()) ? 131071 : 524287);
    if (isSetField_terminator())
      hashCode = hashCode * 8191 + field_terminator.hashCode();

    hashCode = hashCode * 8191 + ((isSetLine_terminator()) ? 131071 : 524287);
    if (isSetLine_terminator())
      hashCode = hashCode * 8191 + line_terminator.hashCode();

    hashCode = hashCode * 8191 + ((isSetEscaped_by()) ? 131071 : 524287);
    if (isSetEscaped_by())
      hashCode = hashCode * 8191 + escaped_by.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TTableRowFormat other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetField_terminator(), other.isSetField_terminator());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetField_terminator()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.field_terminator, other.field_terminator);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetLine_terminator(), other.isSetLine_terminator());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLine_terminator()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.line_terminator, other.line_terminator);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEscaped_by(), other.isSetEscaped_by());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEscaped_by()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.escaped_by, other.escaped_by);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTableRowFormat(");
    boolean first = true;

    if (isSetField_terminator()) {
      sb.append("field_terminator:");
      if (this.field_terminator == null) {
        sb.append("null");
      } else {
        sb.append(this.field_terminator);
      }
      first = false;
    }
    if (isSetLine_terminator()) {
      if (!first) sb.append(", ");
      sb.append("line_terminator:");
      if (this.line_terminator == null) {
        sb.append("null");
      } else {
        sb.append(this.line_terminator);
      }
      first = false;
    }
    if (isSetEscaped_by()) {
      if (!first) sb.append(", ");
      sb.append("escaped_by:");
      if (this.escaped_by == null) {
        sb.append("null");
      } else {
        sb.append(this.escaped_by);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TTableRowFormatStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTableRowFormatStandardScheme getScheme() {
      return new TTableRowFormatStandardScheme();
    }
  }

  private static class TTableRowFormatStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTableRowFormat> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TTableRowFormat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FIELD_TERMINATOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.field_terminator = iprot.readString();
              struct.setField_terminatorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LINE_TERMINATOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.line_terminator = iprot.readString();
              struct.setLine_terminatorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ESCAPED_BY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.escaped_by = iprot.readString();
              struct.setEscaped_byIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TTableRowFormat struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.field_terminator != null) {
        if (struct.isSetField_terminator()) {
          oprot.writeFieldBegin(FIELD_TERMINATOR_FIELD_DESC);
          oprot.writeString(struct.field_terminator);
          oprot.writeFieldEnd();
        }
      }
      if (struct.line_terminator != null) {
        if (struct.isSetLine_terminator()) {
          oprot.writeFieldBegin(LINE_TERMINATOR_FIELD_DESC);
          oprot.writeString(struct.line_terminator);
          oprot.writeFieldEnd();
        }
      }
      if (struct.escaped_by != null) {
        if (struct.isSetEscaped_by()) {
          oprot.writeFieldBegin(ESCAPED_BY_FIELD_DESC);
          oprot.writeString(struct.escaped_by);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTableRowFormatTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTableRowFormatTupleScheme getScheme() {
      return new TTableRowFormatTupleScheme();
    }
  }

  private static class TTableRowFormatTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTableRowFormat> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTableRowFormat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetField_terminator()) {
        optionals.set(0);
      }
      if (struct.isSetLine_terminator()) {
        optionals.set(1);
      }
      if (struct.isSetEscaped_by()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetField_terminator()) {
        oprot.writeString(struct.field_terminator);
      }
      if (struct.isSetLine_terminator()) {
        oprot.writeString(struct.line_terminator);
      }
      if (struct.isSetEscaped_by()) {
        oprot.writeString(struct.escaped_by);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTableRowFormat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.field_terminator = iprot.readString();
        struct.setField_terminatorIsSet(true);
      }
      if (incoming.get(1)) {
        struct.line_terminator = iprot.readString();
        struct.setLine_terminatorIsSet(true);
      }
      if (incoming.get(2)) {
        struct.escaped_by = iprot.readString();
        struct.setEscaped_byIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

