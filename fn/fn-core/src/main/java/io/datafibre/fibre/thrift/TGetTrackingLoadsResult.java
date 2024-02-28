/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TGetTrackingLoadsResult implements org.apache.thrift.TBase<TGetTrackingLoadsResult, TGetTrackingLoadsResult._Fields>, java.io.Serializable, Cloneable, Comparable<TGetTrackingLoadsResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TGetTrackingLoadsResult");

  private static final org.apache.thrift.protocol.TField TRACKING_LOADS_FIELD_DESC = new org.apache.thrift.protocol.TField("trackingLoads", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TGetTrackingLoadsResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TGetTrackingLoadsResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<TTrackingLoadInfo> trackingLoads; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TRACKING_LOADS((short)1, "trackingLoads");

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
        case 1: // TRACKING_LOADS
          return TRACKING_LOADS;
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
  private static final _Fields optionals[] = {_Fields.TRACKING_LOADS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TRACKING_LOADS, new org.apache.thrift.meta_data.FieldMetaData("trackingLoads", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TTrackingLoadInfo.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TGetTrackingLoadsResult.class, metaDataMap);
  }

  public TGetTrackingLoadsResult() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TGetTrackingLoadsResult(TGetTrackingLoadsResult other) {
    if (other.isSetTrackingLoads()) {
      java.util.List<TTrackingLoadInfo> __this__trackingLoads = new java.util.ArrayList<TTrackingLoadInfo>(other.trackingLoads.size());
      for (TTrackingLoadInfo other_element : other.trackingLoads) {
        __this__trackingLoads.add(new TTrackingLoadInfo(other_element));
      }
      this.trackingLoads = __this__trackingLoads;
    }
  }

  @Override
  public TGetTrackingLoadsResult deepCopy() {
    return new TGetTrackingLoadsResult(this);
  }

  @Override
  public void clear() {
    this.trackingLoads = null;
  }

  public int getTrackingLoadsSize() {
    return (this.trackingLoads == null) ? 0 : this.trackingLoads.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TTrackingLoadInfo> getTrackingLoadsIterator() {
    return (this.trackingLoads == null) ? null : this.trackingLoads.iterator();
  }

  public void addToTrackingLoads(TTrackingLoadInfo elem) {
    if (this.trackingLoads == null) {
      this.trackingLoads = new java.util.ArrayList<TTrackingLoadInfo>();
    }
    this.trackingLoads.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TTrackingLoadInfo> getTrackingLoads() {
    return this.trackingLoads;
  }

  public TGetTrackingLoadsResult setTrackingLoads(@org.apache.thrift.annotation.Nullable java.util.List<TTrackingLoadInfo> trackingLoads) {
    this.trackingLoads = trackingLoads;
    return this;
  }

  public void unsetTrackingLoads() {
    this.trackingLoads = null;
  }

  /** Returns true if field trackingLoads is set (has been assigned a value) and false otherwise */
  public boolean isSetTrackingLoads() {
    return this.trackingLoads != null;
  }

  public void setTrackingLoadsIsSet(boolean value) {
    if (!value) {
      this.trackingLoads = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TRACKING_LOADS:
      if (value == null) {
        unsetTrackingLoads();
      } else {
        setTrackingLoads((java.util.List<TTrackingLoadInfo>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TRACKING_LOADS:
      return getTrackingLoads();

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
    case TRACKING_LOADS:
      return isSetTrackingLoads();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TGetTrackingLoadsResult)
      return this.equals((TGetTrackingLoadsResult)that);
    return false;
  }

  public boolean equals(TGetTrackingLoadsResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_trackingLoads = true && this.isSetTrackingLoads();
    boolean that_present_trackingLoads = true && that.isSetTrackingLoads();
    if (this_present_trackingLoads || that_present_trackingLoads) {
      if (!(this_present_trackingLoads && that_present_trackingLoads))
        return false;
      if (!this.trackingLoads.equals(that.trackingLoads))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTrackingLoads()) ? 131071 : 524287);
    if (isSetTrackingLoads())
      hashCode = hashCode * 8191 + trackingLoads.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TGetTrackingLoadsResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTrackingLoads(), other.isSetTrackingLoads());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTrackingLoads()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.trackingLoads, other.trackingLoads);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TGetTrackingLoadsResult(");
    boolean first = true;

    if (isSetTrackingLoads()) {
      sb.append("trackingLoads:");
      if (this.trackingLoads == null) {
        sb.append("null");
      } else {
        sb.append(this.trackingLoads);
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

  private static class TGetTrackingLoadsResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetTrackingLoadsResultStandardScheme getScheme() {
      return new TGetTrackingLoadsResultStandardScheme();
    }
  }

  private static class TGetTrackingLoadsResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TGetTrackingLoadsResult> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TGetTrackingLoadsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TRACKING_LOADS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list156 = iprot.readListBegin();
                struct.trackingLoads = new java.util.ArrayList<TTrackingLoadInfo>(_list156.size);
                @org.apache.thrift.annotation.Nullable TTrackingLoadInfo _elem157;
                for (int _i158 = 0; _i158 < _list156.size; ++_i158)
                {
                  _elem157 = new TTrackingLoadInfo();
                  _elem157.read(iprot);
                  struct.trackingLoads.add(_elem157);
                }
                iprot.readListEnd();
              }
              struct.setTrackingLoadsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TGetTrackingLoadsResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.trackingLoads != null) {
        if (struct.isSetTrackingLoads()) {
          oprot.writeFieldBegin(TRACKING_LOADS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.trackingLoads.size()));
            for (TTrackingLoadInfo _iter159 : struct.trackingLoads)
            {
              _iter159.write(oprot);
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

  private static class TGetTrackingLoadsResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetTrackingLoadsResultTupleScheme getScheme() {
      return new TGetTrackingLoadsResultTupleScheme();
    }
  }

  private static class TGetTrackingLoadsResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TGetTrackingLoadsResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TGetTrackingLoadsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTrackingLoads()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetTrackingLoads()) {
        {
          oprot.writeI32(struct.trackingLoads.size());
          for (TTrackingLoadInfo _iter160 : struct.trackingLoads)
          {
            _iter160.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TGetTrackingLoadsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list161 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.trackingLoads = new java.util.ArrayList<TTrackingLoadInfo>(_list161.size);
          @org.apache.thrift.annotation.Nullable TTrackingLoadInfo _elem162;
          for (int _i163 = 0; _i163 < _list161.size; ++_i163)
          {
            _elem162 = new TTrackingLoadInfo();
            _elem162.read(iprot);
            struct.trackingLoads.add(_elem162);
          }
        }
        struct.setTrackingLoadsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

