/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TIcebergSchemaField implements org.apache.thrift.TBase<TIcebergSchemaField, TIcebergSchemaField._Fields>, java.io.Serializable, Cloneable, Comparable<TIcebergSchemaField> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TIcebergSchemaField");

  private static final org.apache.thrift.protocol.TField FIELD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("field_id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CHILDREN_FIELD_DESC = new org.apache.thrift.protocol.TField("children", org.apache.thrift.protocol.TType.LIST, (short)100);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TIcebergSchemaFieldStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TIcebergSchemaFieldTupleSchemeFactory();

  public int field_id; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String name; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<TIcebergSchemaField> children; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FIELD_ID((short)1, "field_id"),
    NAME((short)2, "name"),
    CHILDREN((short)100, "children");

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
        case 1: // FIELD_ID
          return FIELD_ID;
        case 2: // NAME
          return NAME;
        case 100: // CHILDREN
          return CHILDREN;
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
  private static final int __FIELD_ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.FIELD_ID,_Fields.NAME,_Fields.CHILDREN};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FIELD_ID, new org.apache.thrift.meta_data.FieldMetaData("field_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHILDREN, new org.apache.thrift.meta_data.FieldMetaData("children", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TIcebergSchemaField.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TIcebergSchemaField.class, metaDataMap);
  }

  public TIcebergSchemaField() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TIcebergSchemaField(TIcebergSchemaField other) {
    __isset_bitfield = other.__isset_bitfield;
    this.field_id = other.field_id;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetChildren()) {
      java.util.List<TIcebergSchemaField> __this__children = new java.util.ArrayList<TIcebergSchemaField>(other.children.size());
      for (TIcebergSchemaField other_element : other.children) {
        __this__children.add(new TIcebergSchemaField(other_element));
      }
      this.children = __this__children;
    }
  }

  @Override
  public TIcebergSchemaField deepCopy() {
    return new TIcebergSchemaField(this);
  }

  @Override
  public void clear() {
    setField_idIsSet(false);
    this.field_id = 0;
    this.name = null;
    this.children = null;
  }

  public int getField_id() {
    return this.field_id;
  }

  public TIcebergSchemaField setField_id(int field_id) {
    this.field_id = field_id;
    setField_idIsSet(true);
    return this;
  }

  public void unsetField_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __FIELD_ID_ISSET_ID);
  }

  /** Returns true if field field_id is set (has been assigned a value) and false otherwise */
  public boolean isSetField_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __FIELD_ID_ISSET_ID);
  }

  public void setField_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __FIELD_ID_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getName() {
    return this.name;
  }

  public TIcebergSchemaField setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public int getChildrenSize() {
    return (this.children == null) ? 0 : this.children.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TIcebergSchemaField> getChildrenIterator() {
    return (this.children == null) ? null : this.children.iterator();
  }

  public void addToChildren(TIcebergSchemaField elem) {
    if (this.children == null) {
      this.children = new java.util.ArrayList<TIcebergSchemaField>();
    }
    this.children.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TIcebergSchemaField> getChildren() {
    return this.children;
  }

  public TIcebergSchemaField setChildren(@org.apache.thrift.annotation.Nullable java.util.List<TIcebergSchemaField> children) {
    this.children = children;
    return this;
  }

  public void unsetChildren() {
    this.children = null;
  }

  /** Returns true if field children is set (has been assigned a value) and false otherwise */
  public boolean isSetChildren() {
    return this.children != null;
  }

  public void setChildrenIsSet(boolean value) {
    if (!value) {
      this.children = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case FIELD_ID:
      if (value == null) {
        unsetField_id();
      } else {
        setField_id((java.lang.Integer)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case CHILDREN:
      if (value == null) {
        unsetChildren();
      } else {
        setChildren((java.util.List<TIcebergSchemaField>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FIELD_ID:
      return getField_id();

    case NAME:
      return getName();

    case CHILDREN:
      return getChildren();

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
    case FIELD_ID:
      return isSetField_id();
    case NAME:
      return isSetName();
    case CHILDREN:
      return isSetChildren();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TIcebergSchemaField)
      return this.equals((TIcebergSchemaField)that);
    return false;
  }

  public boolean equals(TIcebergSchemaField that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_field_id = true && this.isSetField_id();
    boolean that_present_field_id = true && that.isSetField_id();
    if (this_present_field_id || that_present_field_id) {
      if (!(this_present_field_id && that_present_field_id))
        return false;
      if (this.field_id != that.field_id)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_children = true && this.isSetChildren();
    boolean that_present_children = true && that.isSetChildren();
    if (this_present_children || that_present_children) {
      if (!(this_present_children && that_present_children))
        return false;
      if (!this.children.equals(that.children))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetField_id()) ? 131071 : 524287);
    if (isSetField_id())
      hashCode = hashCode * 8191 + field_id;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetChildren()) ? 131071 : 524287);
    if (isSetChildren())
      hashCode = hashCode * 8191 + children.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TIcebergSchemaField other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetField_id(), other.isSetField_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetField_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.field_id, other.field_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetName(), other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetChildren(), other.isSetChildren());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChildren()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.children, other.children);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TIcebergSchemaField(");
    boolean first = true;

    if (isSetField_id()) {
      sb.append("field_id:");
      sb.append(this.field_id);
      first = false;
    }
    if (isSetName()) {
      if (!first) sb.append(", ");
      sb.append("name:");
      if (this.name == null) {
        sb.append("null");
      } else {
        sb.append(this.name);
      }
      first = false;
    }
    if (isSetChildren()) {
      if (!first) sb.append(", ");
      sb.append("children:");
      if (this.children == null) {
        sb.append("null");
      } else {
        sb.append(this.children);
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

  private static class TIcebergSchemaFieldStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TIcebergSchemaFieldStandardScheme getScheme() {
      return new TIcebergSchemaFieldStandardScheme();
    }
  }

  private static class TIcebergSchemaFieldStandardScheme extends org.apache.thrift.scheme.StandardScheme<TIcebergSchemaField> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TIcebergSchemaField struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FIELD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.field_id = iprot.readI32();
              struct.setField_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 100: // CHILDREN
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list276 = iprot.readListBegin();
                struct.children = new java.util.ArrayList<TIcebergSchemaField>(_list276.size);
                @org.apache.thrift.annotation.Nullable TIcebergSchemaField _elem277;
                for (int _i278 = 0; _i278 < _list276.size; ++_i278)
                {
                  _elem277 = new TIcebergSchemaField();
                  _elem277.read(iprot);
                  struct.children.add(_elem277);
                }
                iprot.readListEnd();
              }
              struct.setChildrenIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TIcebergSchemaField struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetField_id()) {
        oprot.writeFieldBegin(FIELD_ID_FIELD_DESC);
        oprot.writeI32(struct.field_id);
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        if (struct.isSetName()) {
          oprot.writeFieldBegin(NAME_FIELD_DESC);
          oprot.writeString(struct.name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.children != null) {
        if (struct.isSetChildren()) {
          oprot.writeFieldBegin(CHILDREN_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.children.size()));
            for (TIcebergSchemaField _iter279 : struct.children)
            {
              _iter279.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TIcebergSchemaFieldTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TIcebergSchemaFieldTupleScheme getScheme() {
      return new TIcebergSchemaFieldTupleScheme();
    }
  }

  private static class TIcebergSchemaFieldTupleScheme extends org.apache.thrift.scheme.TupleScheme<TIcebergSchemaField> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TIcebergSchemaField struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetField_id()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetChildren()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetField_id()) {
        oprot.writeI32(struct.field_id);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetChildren()) {
        {
          oprot.writeI32(struct.children.size());
          for (TIcebergSchemaField _iter280 : struct.children)
          {
            _iter280.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TIcebergSchemaField struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.field_id = iprot.readI32();
        struct.setField_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list281 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.children = new java.util.ArrayList<TIcebergSchemaField>(_list281.size);
          @org.apache.thrift.annotation.Nullable TIcebergSchemaField _elem282;
          for (int _i283 = 0; _i283 < _list281.size; ++_i283)
          {
            _elem282 = new TIcebergSchemaField();
            _elem282.read(iprot);
            struct.children.add(_elem282);
          }
        }
        struct.setChildrenIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
