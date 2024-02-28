/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TLikePredicate implements org.apache.thrift.TBase<TLikePredicate, TLikePredicate._Fields>, java.io.Serializable, Cloneable, Comparable<TLikePredicate> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TLikePredicate");

  private static final org.apache.thrift.protocol.TField ESCAPE_CHAR_FIELD_DESC = new org.apache.thrift.protocol.TField("escape_char", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TLikePredicateStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TLikePredicateTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String escape_char; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ESCAPE_CHAR((short)1, "escape_char");

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
        case 1: // ESCAPE_CHAR
          return ESCAPE_CHAR;
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
    tmpMap.put(_Fields.ESCAPE_CHAR, new org.apache.thrift.meta_data.FieldMetaData("escape_char", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TLikePredicate.class, metaDataMap);
  }

  public TLikePredicate() {
  }

  public TLikePredicate(
    java.lang.String escape_char)
  {
    this();
    this.escape_char = escape_char;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TLikePredicate(TLikePredicate other) {
    if (other.isSetEscape_char()) {
      this.escape_char = other.escape_char;
    }
  }

  @Override
  public TLikePredicate deepCopy() {
    return new TLikePredicate(this);
  }

  @Override
  public void clear() {
    this.escape_char = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEscape_char() {
    return this.escape_char;
  }

  public TLikePredicate setEscape_char(@org.apache.thrift.annotation.Nullable java.lang.String escape_char) {
    this.escape_char = escape_char;
    return this;
  }

  public void unsetEscape_char() {
    this.escape_char = null;
  }

  /** Returns true if field escape_char is set (has been assigned a value) and false otherwise */
  public boolean isSetEscape_char() {
    return this.escape_char != null;
  }

  public void setEscape_charIsSet(boolean value) {
    if (!value) {
      this.escape_char = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ESCAPE_CHAR:
      if (value == null) {
        unsetEscape_char();
      } else {
        setEscape_char((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ESCAPE_CHAR:
      return getEscape_char();

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
    case ESCAPE_CHAR:
      return isSetEscape_char();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TLikePredicate)
      return this.equals((TLikePredicate)that);
    return false;
  }

  public boolean equals(TLikePredicate that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_escape_char = true && this.isSetEscape_char();
    boolean that_present_escape_char = true && that.isSetEscape_char();
    if (this_present_escape_char || that_present_escape_char) {
      if (!(this_present_escape_char && that_present_escape_char))
        return false;
      if (!this.escape_char.equals(that.escape_char))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetEscape_char()) ? 131071 : 524287);
    if (isSetEscape_char())
      hashCode = hashCode * 8191 + escape_char.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TLikePredicate other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetEscape_char(), other.isSetEscape_char());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEscape_char()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.escape_char, other.escape_char);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TLikePredicate(");
    boolean first = true;

    sb.append("escape_char:");
    if (this.escape_char == null) {
      sb.append("null");
    } else {
      sb.append(this.escape_char);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (escape_char == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'escape_char' was not present! Struct: " + toString());
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

  private static class TLikePredicateStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TLikePredicateStandardScheme getScheme() {
      return new TLikePredicateStandardScheme();
    }
  }

  private static class TLikePredicateStandardScheme extends org.apache.thrift.scheme.StandardScheme<TLikePredicate> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TLikePredicate struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ESCAPE_CHAR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.escape_char = iprot.readString();
              struct.setEscape_charIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TLikePredicate struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.escape_char != null) {
        oprot.writeFieldBegin(ESCAPE_CHAR_FIELD_DESC);
        oprot.writeString(struct.escape_char);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TLikePredicateTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TLikePredicateTupleScheme getScheme() {
      return new TLikePredicateTupleScheme();
    }
  }

  private static class TLikePredicateTupleScheme extends org.apache.thrift.scheme.TupleScheme<TLikePredicate> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TLikePredicate struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.escape_char);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TLikePredicate struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.escape_char = iprot.readString();
      struct.setEscape_charIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

