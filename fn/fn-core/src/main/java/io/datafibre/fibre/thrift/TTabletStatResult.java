/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TTabletStatResult implements org.apache.thrift.TBase<TTabletStatResult, TTabletStatResult._Fields>, java.io.Serializable, Cloneable, Comparable<TTabletStatResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTabletStatResult");

  private static final org.apache.thrift.protocol.TField TABLETS_STATS_FIELD_DESC = new org.apache.thrift.protocol.TField("tablets_stats", org.apache.thrift.protocol.TType.MAP, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTabletStatResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTabletStatResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Long,TTabletStat> tablets_stats; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLETS_STATS((short)1, "tablets_stats");

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
        case 1: // TABLETS_STATS
          return TABLETS_STATS;
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
    tmpMap.put(_Fields.TABLETS_STATS, new org.apache.thrift.meta_data.FieldMetaData("tablets_stats", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TTabletStat.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTabletStatResult.class, metaDataMap);
  }

  public TTabletStatResult() {
  }

  public TTabletStatResult(
    java.util.Map<java.lang.Long,TTabletStat> tablets_stats)
  {
    this();
    this.tablets_stats = tablets_stats;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTabletStatResult(TTabletStatResult other) {
    if (other.isSetTablets_stats()) {
      java.util.Map<java.lang.Long,TTabletStat> __this__tablets_stats = new java.util.HashMap<java.lang.Long,TTabletStat>(other.tablets_stats.size());
      for (java.util.Map.Entry<java.lang.Long, TTabletStat> other_element : other.tablets_stats.entrySet()) {

        java.lang.Long other_element_key = other_element.getKey();
        TTabletStat other_element_value = other_element.getValue();

        java.lang.Long __this__tablets_stats_copy_key = other_element_key;

        TTabletStat __this__tablets_stats_copy_value = new TTabletStat(other_element_value);

        __this__tablets_stats.put(__this__tablets_stats_copy_key, __this__tablets_stats_copy_value);
      }
      this.tablets_stats = __this__tablets_stats;
    }
  }

  @Override
  public TTabletStatResult deepCopy() {
    return new TTabletStatResult(this);
  }

  @Override
  public void clear() {
    this.tablets_stats = null;
  }

  public int getTablets_statsSize() {
    return (this.tablets_stats == null) ? 0 : this.tablets_stats.size();
  }

  public void putToTablets_stats(long key, TTabletStat val) {
    if (this.tablets_stats == null) {
      this.tablets_stats = new java.util.HashMap<java.lang.Long,TTabletStat>();
    }
    this.tablets_stats.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.Long,TTabletStat> getTablets_stats() {
    return this.tablets_stats;
  }

  public TTabletStatResult setTablets_stats(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Long,TTabletStat> tablets_stats) {
    this.tablets_stats = tablets_stats;
    return this;
  }

  public void unsetTablets_stats() {
    this.tablets_stats = null;
  }

  /** Returns true if field tablets_stats is set (has been assigned a value) and false otherwise */
  public boolean isSetTablets_stats() {
    return this.tablets_stats != null;
  }

  public void setTablets_statsIsSet(boolean value) {
    if (!value) {
      this.tablets_stats = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TABLETS_STATS:
      if (value == null) {
        unsetTablets_stats();
      } else {
        setTablets_stats((java.util.Map<java.lang.Long,TTabletStat>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLETS_STATS:
      return getTablets_stats();

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
    case TABLETS_STATS:
      return isSetTablets_stats();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TTabletStatResult)
      return this.equals((TTabletStatResult)that);
    return false;
  }

  public boolean equals(TTabletStatResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tablets_stats = true && this.isSetTablets_stats();
    boolean that_present_tablets_stats = true && that.isSetTablets_stats();
    if (this_present_tablets_stats || that_present_tablets_stats) {
      if (!(this_present_tablets_stats && that_present_tablets_stats))
        return false;
      if (!this.tablets_stats.equals(that.tablets_stats))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTablets_stats()) ? 131071 : 524287);
    if (isSetTablets_stats())
      hashCode = hashCode * 8191 + tablets_stats.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TTabletStatResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTablets_stats(), other.isSetTablets_stats());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTablets_stats()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablets_stats, other.tablets_stats);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTabletStatResult(");
    boolean first = true;

    sb.append("tablets_stats:");
    if (this.tablets_stats == null) {
      sb.append("null");
    } else {
      sb.append(this.tablets_stats);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (tablets_stats == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tablets_stats' was not present! Struct: " + toString());
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

  private static class TTabletStatResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTabletStatResultStandardScheme getScheme() {
      return new TTabletStatResultStandardScheme();
    }
  }

  private static class TTabletStatResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTabletStatResult> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TTabletStatResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLETS_STATS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.tablets_stats = new java.util.HashMap<java.lang.Long,TTabletStat>(2*_map0.size);
                long _key1;
                @org.apache.thrift.annotation.Nullable TTabletStat _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readI64();
                  _val2 = new TTabletStat();
                  _val2.read(iprot);
                  struct.tablets_stats.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setTablets_statsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TTabletStatResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.tablets_stats != null) {
        oprot.writeFieldBegin(TABLETS_STATS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.STRUCT, struct.tablets_stats.size()));
          for (java.util.Map.Entry<java.lang.Long, TTabletStat> _iter4 : struct.tablets_stats.entrySet())
          {
            oprot.writeI64(_iter4.getKey());
            _iter4.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTabletStatResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTabletStatResultTupleScheme getScheme() {
      return new TTabletStatResultTupleScheme();
    }
  }

  private static class TTabletStatResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTabletStatResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTabletStatResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.tablets_stats.size());
        for (java.util.Map.Entry<java.lang.Long, TTabletStat> _iter5 : struct.tablets_stats.entrySet())
        {
          oprot.writeI64(_iter5.getKey());
          _iter5.getValue().write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTabletStatResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TMap _map6 = iprot.readMapBegin(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.STRUCT); 
        struct.tablets_stats = new java.util.HashMap<java.lang.Long,TTabletStat>(2*_map6.size);
        long _key7;
        @org.apache.thrift.annotation.Nullable TTabletStat _val8;
        for (int _i9 = 0; _i9 < _map6.size; ++_i9)
        {
          _key7 = iprot.readI64();
          _val8 = new TTabletStat();
          _val8.read(iprot);
          struct.tablets_stats.put(_key7, _val8);
        }
      }
      struct.setTablets_statsIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
