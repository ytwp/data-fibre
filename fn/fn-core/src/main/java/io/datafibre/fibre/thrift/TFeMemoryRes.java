/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TFeMemoryRes implements org.apache.thrift.TBase<TFeMemoryRes, TFeMemoryRes._Fields>, java.io.Serializable, Cloneable, Comparable<TFeMemoryRes> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TFeMemoryRes");

  private static final org.apache.thrift.protocol.TField ITEMS_FIELD_DESC = new org.apache.thrift.protocol.TField("items", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TFeMemoryResStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TFeMemoryResTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<TFeMemoryItem> items; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ITEMS((short)1, "items");

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
        case 1: // ITEMS
          return ITEMS;
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
  private static final _Fields optionals[] = {_Fields.ITEMS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ITEMS, new org.apache.thrift.meta_data.FieldMetaData("items", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TFeMemoryItem.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TFeMemoryRes.class, metaDataMap);
  }

  public TFeMemoryRes() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TFeMemoryRes(TFeMemoryRes other) {
    if (other.isSetItems()) {
      java.util.List<TFeMemoryItem> __this__items = new java.util.ArrayList<TFeMemoryItem>(other.items.size());
      for (TFeMemoryItem other_element : other.items) {
        __this__items.add(new TFeMemoryItem(other_element));
      }
      this.items = __this__items;
    }
  }

  @Override
  public TFeMemoryRes deepCopy() {
    return new TFeMemoryRes(this);
  }

  @Override
  public void clear() {
    this.items = null;
  }

  public int getItemsSize() {
    return (this.items == null) ? 0 : this.items.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TFeMemoryItem> getItemsIterator() {
    return (this.items == null) ? null : this.items.iterator();
  }

  public void addToItems(TFeMemoryItem elem) {
    if (this.items == null) {
      this.items = new java.util.ArrayList<TFeMemoryItem>();
    }
    this.items.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TFeMemoryItem> getItems() {
    return this.items;
  }

  public TFeMemoryRes setItems(@org.apache.thrift.annotation.Nullable java.util.List<TFeMemoryItem> items) {
    this.items = items;
    return this;
  }

  public void unsetItems() {
    this.items = null;
  }

  /** Returns true if field items is set (has been assigned a value) and false otherwise */
  public boolean isSetItems() {
    return this.items != null;
  }

  public void setItemsIsSet(boolean value) {
    if (!value) {
      this.items = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ITEMS:
      if (value == null) {
        unsetItems();
      } else {
        setItems((java.util.List<TFeMemoryItem>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ITEMS:
      return getItems();

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
    case ITEMS:
      return isSetItems();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TFeMemoryRes)
      return this.equals((TFeMemoryRes)that);
    return false;
  }

  public boolean equals(TFeMemoryRes that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_items = true && this.isSetItems();
    boolean that_present_items = true && that.isSetItems();
    if (this_present_items || that_present_items) {
      if (!(this_present_items && that_present_items))
        return false;
      if (!this.items.equals(that.items))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetItems()) ? 131071 : 524287);
    if (isSetItems())
      hashCode = hashCode * 8191 + items.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TFeMemoryRes other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetItems(), other.isSetItems());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItems()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.items, other.items);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TFeMemoryRes(");
    boolean first = true;

    if (isSetItems()) {
      sb.append("items:");
      if (this.items == null) {
        sb.append("null");
      } else {
        sb.append(this.items);
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

  private static class TFeMemoryResStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFeMemoryResStandardScheme getScheme() {
      return new TFeMemoryResStandardScheme();
    }
  }

  private static class TFeMemoryResStandardScheme extends org.apache.thrift.scheme.StandardScheme<TFeMemoryRes> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TFeMemoryRes struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ITEMS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list734 = iprot.readListBegin();
                struct.items = new java.util.ArrayList<TFeMemoryItem>(_list734.size);
                @org.apache.thrift.annotation.Nullable TFeMemoryItem _elem735;
                for (int _i736 = 0; _i736 < _list734.size; ++_i736)
                {
                  _elem735 = new TFeMemoryItem();
                  _elem735.read(iprot);
                  struct.items.add(_elem735);
                }
                iprot.readListEnd();
              }
              struct.setItemsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TFeMemoryRes struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.items != null) {
        if (struct.isSetItems()) {
          oprot.writeFieldBegin(ITEMS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.items.size()));
            for (TFeMemoryItem _iter737 : struct.items)
            {
              _iter737.write(oprot);
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

  private static class TFeMemoryResTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TFeMemoryResTupleScheme getScheme() {
      return new TFeMemoryResTupleScheme();
    }
  }

  private static class TFeMemoryResTupleScheme extends org.apache.thrift.scheme.TupleScheme<TFeMemoryRes> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TFeMemoryRes struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetItems()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetItems()) {
        {
          oprot.writeI32(struct.items.size());
          for (TFeMemoryItem _iter738 : struct.items)
          {
            _iter738.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TFeMemoryRes struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list739 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.items = new java.util.ArrayList<TFeMemoryItem>(_list739.size);
          @org.apache.thrift.annotation.Nullable TFeMemoryItem _elem740;
          for (int _i741 = 0; _i741 < _list739.size; ++_i741)
          {
            _elem740 = new TFeMemoryItem();
            _elem740.read(iprot);
            struct.items.add(_elem740);
          }
        }
        struct.setItemsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
