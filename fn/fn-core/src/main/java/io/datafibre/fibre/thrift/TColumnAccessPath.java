/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TColumnAccessPath implements org.apache.thrift.TBase<TColumnAccessPath, TColumnAccessPath._Fields>, java.io.Serializable, Cloneable, Comparable<TColumnAccessPath> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TColumnAccessPath");

  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("path", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField CHILDREN_FIELD_DESC = new org.apache.thrift.protocol.TField("children", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField FROM_PREDICATE_FIELD_DESC = new org.apache.thrift.protocol.TField("from_predicate", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TColumnAccessPathStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TColumnAccessPathTupleSchemeFactory();

  /**
   * 
   * @see TAccessPathType
   */
  public @org.apache.thrift.annotation.Nullable TAccessPathType type; // optional
  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr path; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<TColumnAccessPath> children; // optional
  public boolean from_predicate; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see TAccessPathType
     */
    TYPE((short)1, "type"),
    PATH((short)2, "path"),
    CHILDREN((short)3, "children"),
    FROM_PREDICATE((short)4, "from_predicate");

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
        case 1: // TYPE
          return TYPE;
        case 2: // PATH
          return PATH;
        case 3: // CHILDREN
          return CHILDREN;
        case 4: // FROM_PREDICATE
          return FROM_PREDICATE;
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
  private static final int __FROM_PREDICATE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TYPE,_Fields.PATH,_Fields.CHILDREN,_Fields.FROM_PREDICATE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TAccessPathType.class)));
    tmpMap.put(_Fields.PATH, new org.apache.thrift.meta_data.FieldMetaData("path", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TExpr.class)));
    tmpMap.put(_Fields.CHILDREN, new org.apache.thrift.meta_data.FieldMetaData("children", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TColumnAccessPath.class))));
    tmpMap.put(_Fields.FROM_PREDICATE, new org.apache.thrift.meta_data.FieldMetaData("from_predicate", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TColumnAccessPath.class, metaDataMap);
  }

  public TColumnAccessPath() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TColumnAccessPath(TColumnAccessPath other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetPath()) {
      this.path = new com.starrocks.thrift.TExpr(other.path);
    }
    if (other.isSetChildren()) {
      java.util.List<TColumnAccessPath> __this__children = new java.util.ArrayList<TColumnAccessPath>(other.children.size());
      for (TColumnAccessPath other_element : other.children) {
        __this__children.add(new TColumnAccessPath(other_element));
      }
      this.children = __this__children;
    }
    this.from_predicate = other.from_predicate;
  }

  @Override
  public TColumnAccessPath deepCopy() {
    return new TColumnAccessPath(this);
  }

  @Override
  public void clear() {
    this.type = null;
    this.path = null;
    this.children = null;
    setFrom_predicateIsSet(false);
    this.from_predicate = false;
  }

  /**
   * 
   * @see TAccessPathType
   */
  @org.apache.thrift.annotation.Nullable
  public TAccessPathType getType() {
    return this.type;
  }

  /**
   * 
   * @see TAccessPathType
   */
  public TColumnAccessPath setType(@org.apache.thrift.annotation.Nullable TAccessPathType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TExpr getPath() {
    return this.path;
  }

  public TColumnAccessPath setPath(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TExpr path) {
    this.path = path;
    return this;
  }

  public void unsetPath() {
    this.path = null;
  }

  /** Returns true if field path is set (has been assigned a value) and false otherwise */
  public boolean isSetPath() {
    return this.path != null;
  }

  public void setPathIsSet(boolean value) {
    if (!value) {
      this.path = null;
    }
  }

  public int getChildrenSize() {
    return (this.children == null) ? 0 : this.children.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TColumnAccessPath> getChildrenIterator() {
    return (this.children == null) ? null : this.children.iterator();
  }

  public void addToChildren(TColumnAccessPath elem) {
    if (this.children == null) {
      this.children = new java.util.ArrayList<TColumnAccessPath>();
    }
    this.children.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TColumnAccessPath> getChildren() {
    return this.children;
  }

  public TColumnAccessPath setChildren(@org.apache.thrift.annotation.Nullable java.util.List<TColumnAccessPath> children) {
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

  public boolean isFrom_predicate() {
    return this.from_predicate;
  }

  public TColumnAccessPath setFrom_predicate(boolean from_predicate) {
    this.from_predicate = from_predicate;
    setFrom_predicateIsSet(true);
    return this;
  }

  public void unsetFrom_predicate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __FROM_PREDICATE_ISSET_ID);
  }

  /** Returns true if field from_predicate is set (has been assigned a value) and false otherwise */
  public boolean isSetFrom_predicate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __FROM_PREDICATE_ISSET_ID);
  }

  public void setFrom_predicateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __FROM_PREDICATE_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((TAccessPathType)value);
      }
      break;

    case PATH:
      if (value == null) {
        unsetPath();
      } else {
        setPath((com.starrocks.thrift.TExpr)value);
      }
      break;

    case CHILDREN:
      if (value == null) {
        unsetChildren();
      } else {
        setChildren((java.util.List<TColumnAccessPath>)value);
      }
      break;

    case FROM_PREDICATE:
      if (value == null) {
        unsetFrom_predicate();
      } else {
        setFrom_predicate((java.lang.Boolean)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE:
      return getType();

    case PATH:
      return getPath();

    case CHILDREN:
      return getChildren();

    case FROM_PREDICATE:
      return isFrom_predicate();

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
    case TYPE:
      return isSetType();
    case PATH:
      return isSetPath();
    case CHILDREN:
      return isSetChildren();
    case FROM_PREDICATE:
      return isSetFrom_predicate();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TColumnAccessPath)
      return this.equals((TColumnAccessPath)that);
    return false;
  }

  public boolean equals(TColumnAccessPath that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_path = true && this.isSetPath();
    boolean that_present_path = true && that.isSetPath();
    if (this_present_path || that_present_path) {
      if (!(this_present_path && that_present_path))
        return false;
      if (!this.path.equals(that.path))
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

    boolean this_present_from_predicate = true && this.isSetFrom_predicate();
    boolean that_present_from_predicate = true && that.isSetFrom_predicate();
    if (this_present_from_predicate || that_present_from_predicate) {
      if (!(this_present_from_predicate && that_present_from_predicate))
        return false;
      if (this.from_predicate != that.from_predicate)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.getValue();

    hashCode = hashCode * 8191 + ((isSetPath()) ? 131071 : 524287);
    if (isSetPath())
      hashCode = hashCode * 8191 + path.hashCode();

    hashCode = hashCode * 8191 + ((isSetChildren()) ? 131071 : 524287);
    if (isSetChildren())
      hashCode = hashCode * 8191 + children.hashCode();

    hashCode = hashCode * 8191 + ((isSetFrom_predicate()) ? 131071 : 524287);
    if (isSetFrom_predicate())
      hashCode = hashCode * 8191 + ((from_predicate) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(TColumnAccessPath other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = java.lang.Boolean.compare(isSetPath(), other.isSetPath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.path, other.path);
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
    lastComparison = java.lang.Boolean.compare(isSetFrom_predicate(), other.isSetFrom_predicate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFrom_predicate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.from_predicate, other.from_predicate);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TColumnAccessPath(");
    boolean first = true;

    if (isSetType()) {
      sb.append("type:");
      if (this.type == null) {
        sb.append("null");
      } else {
        sb.append(this.type);
      }
      first = false;
    }
    if (isSetPath()) {
      if (!first) sb.append(", ");
      sb.append("path:");
      if (this.path == null) {
        sb.append("null");
      } else {
        sb.append(this.path);
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
    if (isSetFrom_predicate()) {
      if (!first) sb.append(", ");
      sb.append("from_predicate:");
      sb.append(this.from_predicate);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (path != null) {
      path.validate();
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

  private static class TColumnAccessPathStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TColumnAccessPathStandardScheme getScheme() {
      return new TColumnAccessPathStandardScheme();
    }
  }

  private static class TColumnAccessPathStandardScheme extends org.apache.thrift.scheme.StandardScheme<TColumnAccessPath> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TColumnAccessPath struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = com.starrocks.thrift.TAccessPathType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.path = new com.starrocks.thrift.TExpr();
              struct.path.read(iprot);
              struct.setPathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHILDREN
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list214 = iprot.readListBegin();
                struct.children = new java.util.ArrayList<TColumnAccessPath>(_list214.size);
                @org.apache.thrift.annotation.Nullable TColumnAccessPath _elem215;
                for (int _i216 = 0; _i216 < _list214.size; ++_i216)
                {
                  _elem215 = new TColumnAccessPath();
                  _elem215.read(iprot);
                  struct.children.add(_elem215);
                }
                iprot.readListEnd();
              }
              struct.setChildrenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FROM_PREDICATE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.from_predicate = iprot.readBool();
              struct.setFrom_predicateIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TColumnAccessPath struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.type != null) {
        if (struct.isSetType()) {
          oprot.writeFieldBegin(TYPE_FIELD_DESC);
          oprot.writeI32(struct.type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.path != null) {
        if (struct.isSetPath()) {
          oprot.writeFieldBegin(PATH_FIELD_DESC);
          struct.path.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.children != null) {
        if (struct.isSetChildren()) {
          oprot.writeFieldBegin(CHILDREN_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.children.size()));
            for (TColumnAccessPath _iter217 : struct.children)
            {
              _iter217.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetFrom_predicate()) {
        oprot.writeFieldBegin(FROM_PREDICATE_FIELD_DESC);
        oprot.writeBool(struct.from_predicate);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TColumnAccessPathTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TColumnAccessPathTupleScheme getScheme() {
      return new TColumnAccessPathTupleScheme();
    }
  }

  private static class TColumnAccessPathTupleScheme extends org.apache.thrift.scheme.TupleScheme<TColumnAccessPath> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TColumnAccessPath struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetType()) {
        optionals.set(0);
      }
      if (struct.isSetPath()) {
        optionals.set(1);
      }
      if (struct.isSetChildren()) {
        optionals.set(2);
      }
      if (struct.isSetFrom_predicate()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetPath()) {
        struct.path.write(oprot);
      }
      if (struct.isSetChildren()) {
        {
          oprot.writeI32(struct.children.size());
          for (TColumnAccessPath _iter218 : struct.children)
          {
            _iter218.write(oprot);
          }
        }
      }
      if (struct.isSetFrom_predicate()) {
        oprot.writeBool(struct.from_predicate);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TColumnAccessPath struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.type = com.starrocks.thrift.TAccessPathType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.path = new com.starrocks.thrift.TExpr();
        struct.path.read(iprot);
        struct.setPathIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list219 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.children = new java.util.ArrayList<TColumnAccessPath>(_list219.size);
          @org.apache.thrift.annotation.Nullable TColumnAccessPath _elem220;
          for (int _i221 = 0; _i221 < _list219.size; ++_i221)
          {
            _elem220 = new TColumnAccessPath();
            _elem220.read(iprot);
            struct.children.add(_elem220);
          }
        }
        struct.setChildrenIsSet(true);
      }
      if (incoming.get(3)) {
        struct.from_predicate = iprot.readBool();
        struct.setFrom_predicateIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

