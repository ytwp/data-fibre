/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TAlterTabletMaterializedColumnReq implements org.apache.thrift.TBase<TAlterTabletMaterializedColumnReq, TAlterTabletMaterializedColumnReq._Fields>, java.io.Serializable, Cloneable, Comparable<TAlterTabletMaterializedColumnReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TAlterTabletMaterializedColumnReq");

  private static final org.apache.thrift.protocol.TField QUERY_GLOBALS_FIELD_DESC = new org.apache.thrift.protocol.TField("query_globals", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField QUERY_OPTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("query_options", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField MC_EXPRS_FIELD_DESC = new org.apache.thrift.protocol.TField("mc_exprs", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TAlterTabletMaterializedColumnReqStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TAlterTabletMaterializedColumnReqTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TQueryGlobals query_globals; // optional
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TQueryOptions query_options; // optional
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,io.datafibre.fibre.thrift.TExpr> mc_exprs; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    QUERY_GLOBALS((short)1, "query_globals"),
    QUERY_OPTIONS((short)2, "query_options"),
    MC_EXPRS((short)3, "mc_exprs");

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
        case 1: // QUERY_GLOBALS
          return QUERY_GLOBALS;
        case 2: // QUERY_OPTIONS
          return QUERY_OPTIONS;
        case 3: // MC_EXPRS
          return MC_EXPRS;
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
  private static final _Fields optionals[] = {_Fields.QUERY_GLOBALS,_Fields.QUERY_OPTIONS,_Fields.MC_EXPRS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUERY_GLOBALS, new org.apache.thrift.meta_data.FieldMetaData("query_globals", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TQueryGlobals.class)));
    tmpMap.put(_Fields.QUERY_OPTIONS, new org.apache.thrift.meta_data.FieldMetaData("query_options", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TQueryOptions.class)));
    tmpMap.put(_Fields.MC_EXPRS, new org.apache.thrift.meta_data.FieldMetaData("mc_exprs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TExpr.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TAlterTabletMaterializedColumnReq.class, metaDataMap);
  }

  public TAlterTabletMaterializedColumnReq() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TAlterTabletMaterializedColumnReq(TAlterTabletMaterializedColumnReq other) {
    if (other.isSetQuery_globals()) {
      this.query_globals = new io.datafibre.fibre.thrift.TQueryGlobals(other.query_globals);
    }
    if (other.isSetQuery_options()) {
      this.query_options = new io.datafibre.fibre.thrift.TQueryOptions(other.query_options);
    }
    if (other.isSetMc_exprs()) {
      java.util.Map<java.lang.Integer,io.datafibre.fibre.thrift.TExpr> __this__mc_exprs = new java.util.HashMap<java.lang.Integer,io.datafibre.fibre.thrift.TExpr>(other.mc_exprs.size());
      for (java.util.Map.Entry<java.lang.Integer, io.datafibre.fibre.thrift.TExpr> other_element : other.mc_exprs.entrySet()) {

        java.lang.Integer other_element_key = other_element.getKey();
        io.datafibre.fibre.thrift.TExpr other_element_value = other_element.getValue();

        java.lang.Integer __this__mc_exprs_copy_key = other_element_key;

        io.datafibre.fibre.thrift.TExpr __this__mc_exprs_copy_value = new io.datafibre.fibre.thrift.TExpr(other_element_value);

        __this__mc_exprs.put(__this__mc_exprs_copy_key, __this__mc_exprs_copy_value);
      }
      this.mc_exprs = __this__mc_exprs;
    }
  }

  @Override
  public TAlterTabletMaterializedColumnReq deepCopy() {
    return new TAlterTabletMaterializedColumnReq(this);
  }

  @Override
  public void clear() {
    this.query_globals = null;
    this.query_options = null;
    this.mc_exprs = null;
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TQueryGlobals getQuery_globals() {
    return this.query_globals;
  }

  public TAlterTabletMaterializedColumnReq setQuery_globals(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TQueryGlobals query_globals) {
    this.query_globals = query_globals;
    return this;
  }

  public void unsetQuery_globals() {
    this.query_globals = null;
  }

  /** Returns true if field query_globals is set (has been assigned a value) and false otherwise */
  public boolean isSetQuery_globals() {
    return this.query_globals != null;
  }

  public void setQuery_globalsIsSet(boolean value) {
    if (!value) {
      this.query_globals = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TQueryOptions getQuery_options() {
    return this.query_options;
  }

  public TAlterTabletMaterializedColumnReq setQuery_options(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TQueryOptions query_options) {
    this.query_options = query_options;
    return this;
  }

  public void unsetQuery_options() {
    this.query_options = null;
  }

  /** Returns true if field query_options is set (has been assigned a value) and false otherwise */
  public boolean isSetQuery_options() {
    return this.query_options != null;
  }

  public void setQuery_optionsIsSet(boolean value) {
    if (!value) {
      this.query_options = null;
    }
  }

  public int getMc_exprsSize() {
    return (this.mc_exprs == null) ? 0 : this.mc_exprs.size();
  }

  public void putToMc_exprs(int key, io.datafibre.fibre.thrift.TExpr val) {
    if (this.mc_exprs == null) {
      this.mc_exprs = new java.util.HashMap<java.lang.Integer,io.datafibre.fibre.thrift.TExpr>();
    }
    this.mc_exprs.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.Integer,io.datafibre.fibre.thrift.TExpr> getMc_exprs() {
    return this.mc_exprs;
  }

  public TAlterTabletMaterializedColumnReq setMc_exprs(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,io.datafibre.fibre.thrift.TExpr> mc_exprs) {
    this.mc_exprs = mc_exprs;
    return this;
  }

  public void unsetMc_exprs() {
    this.mc_exprs = null;
  }

  /** Returns true if field mc_exprs is set (has been assigned a value) and false otherwise */
  public boolean isSetMc_exprs() {
    return this.mc_exprs != null;
  }

  public void setMc_exprsIsSet(boolean value) {
    if (!value) {
      this.mc_exprs = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case QUERY_GLOBALS:
      if (value == null) {
        unsetQuery_globals();
      } else {
        setQuery_globals((io.datafibre.fibre.thrift.TQueryGlobals)value);
      }
      break;

    case QUERY_OPTIONS:
      if (value == null) {
        unsetQuery_options();
      } else {
        setQuery_options((io.datafibre.fibre.thrift.TQueryOptions)value);
      }
      break;

    case MC_EXPRS:
      if (value == null) {
        unsetMc_exprs();
      } else {
        setMc_exprs((java.util.Map<java.lang.Integer,io.datafibre.fibre.thrift.TExpr>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case QUERY_GLOBALS:
      return getQuery_globals();

    case QUERY_OPTIONS:
      return getQuery_options();

    case MC_EXPRS:
      return getMc_exprs();

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
    case QUERY_GLOBALS:
      return isSetQuery_globals();
    case QUERY_OPTIONS:
      return isSetQuery_options();
    case MC_EXPRS:
      return isSetMc_exprs();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TAlterTabletMaterializedColumnReq)
      return this.equals((TAlterTabletMaterializedColumnReq)that);
    return false;
  }

  public boolean equals(TAlterTabletMaterializedColumnReq that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_query_globals = true && this.isSetQuery_globals();
    boolean that_present_query_globals = true && that.isSetQuery_globals();
    if (this_present_query_globals || that_present_query_globals) {
      if (!(this_present_query_globals && that_present_query_globals))
        return false;
      if (!this.query_globals.equals(that.query_globals))
        return false;
    }

    boolean this_present_query_options = true && this.isSetQuery_options();
    boolean that_present_query_options = true && that.isSetQuery_options();
    if (this_present_query_options || that_present_query_options) {
      if (!(this_present_query_options && that_present_query_options))
        return false;
      if (!this.query_options.equals(that.query_options))
        return false;
    }

    boolean this_present_mc_exprs = true && this.isSetMc_exprs();
    boolean that_present_mc_exprs = true && that.isSetMc_exprs();
    if (this_present_mc_exprs || that_present_mc_exprs) {
      if (!(this_present_mc_exprs && that_present_mc_exprs))
        return false;
      if (!this.mc_exprs.equals(that.mc_exprs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetQuery_globals()) ? 131071 : 524287);
    if (isSetQuery_globals())
      hashCode = hashCode * 8191 + query_globals.hashCode();

    hashCode = hashCode * 8191 + ((isSetQuery_options()) ? 131071 : 524287);
    if (isSetQuery_options())
      hashCode = hashCode * 8191 + query_options.hashCode();

    hashCode = hashCode * 8191 + ((isSetMc_exprs()) ? 131071 : 524287);
    if (isSetMc_exprs())
      hashCode = hashCode * 8191 + mc_exprs.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TAlterTabletMaterializedColumnReq other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetQuery_globals(), other.isSetQuery_globals());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery_globals()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.query_globals, other.query_globals);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetQuery_options(), other.isSetQuery_options());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery_options()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.query_options, other.query_options);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetMc_exprs(), other.isSetMc_exprs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMc_exprs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mc_exprs, other.mc_exprs);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TAlterTabletMaterializedColumnReq(");
    boolean first = true;

    if (isSetQuery_globals()) {
      sb.append("query_globals:");
      if (this.query_globals == null) {
        sb.append("null");
      } else {
        sb.append(this.query_globals);
      }
      first = false;
    }
    if (isSetQuery_options()) {
      if (!first) sb.append(", ");
      sb.append("query_options:");
      if (this.query_options == null) {
        sb.append("null");
      } else {
        sb.append(this.query_options);
      }
      first = false;
    }
    if (isSetMc_exprs()) {
      if (!first) sb.append(", ");
      sb.append("mc_exprs:");
      if (this.mc_exprs == null) {
        sb.append("null");
      } else {
        sb.append(this.mc_exprs);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (query_globals != null) {
      query_globals.validate();
    }
    if (query_options != null) {
      query_options.validate();
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

  private static class TAlterTabletMaterializedColumnReqStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TAlterTabletMaterializedColumnReqStandardScheme getScheme() {
      return new TAlterTabletMaterializedColumnReqStandardScheme();
    }
  }

  private static class TAlterTabletMaterializedColumnReqStandardScheme extends org.apache.thrift.scheme.StandardScheme<TAlterTabletMaterializedColumnReq> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TAlterTabletMaterializedColumnReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUERY_GLOBALS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.query_globals = new io.datafibre.fibre.thrift.TQueryGlobals();
              struct.query_globals.read(iprot);
              struct.setQuery_globalsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // QUERY_OPTIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.query_options = new io.datafibre.fibre.thrift.TQueryOptions();
              struct.query_options.read(iprot);
              struct.setQuery_optionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MC_EXPRS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map32 = iprot.readMapBegin();
                struct.mc_exprs = new java.util.HashMap<java.lang.Integer,io.datafibre.fibre.thrift.TExpr>(2*_map32.size);
                int _key33;
                @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TExpr _val34;
                for (int _i35 = 0; _i35 < _map32.size; ++_i35)
                {
                  _key33 = iprot.readI32();
                  _val34 = new io.datafibre.fibre.thrift.TExpr();
                  _val34.read(iprot);
                  struct.mc_exprs.put(_key33, _val34);
                }
                iprot.readMapEnd();
              }
              struct.setMc_exprsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TAlterTabletMaterializedColumnReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.query_globals != null) {
        if (struct.isSetQuery_globals()) {
          oprot.writeFieldBegin(QUERY_GLOBALS_FIELD_DESC);
          struct.query_globals.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.query_options != null) {
        if (struct.isSetQuery_options()) {
          oprot.writeFieldBegin(QUERY_OPTIONS_FIELD_DESC);
          struct.query_options.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.mc_exprs != null) {
        if (struct.isSetMc_exprs()) {
          oprot.writeFieldBegin(MC_EXPRS_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT, struct.mc_exprs.size()));
            for (java.util.Map.Entry<java.lang.Integer, io.datafibre.fibre.thrift.TExpr> _iter36 : struct.mc_exprs.entrySet())
            {
              oprot.writeI32(_iter36.getKey());
              _iter36.getValue().write(oprot);
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TAlterTabletMaterializedColumnReqTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TAlterTabletMaterializedColumnReqTupleScheme getScheme() {
      return new TAlterTabletMaterializedColumnReqTupleScheme();
    }
  }

  private static class TAlterTabletMaterializedColumnReqTupleScheme extends org.apache.thrift.scheme.TupleScheme<TAlterTabletMaterializedColumnReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TAlterTabletMaterializedColumnReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetQuery_globals()) {
        optionals.set(0);
      }
      if (struct.isSetQuery_options()) {
        optionals.set(1);
      }
      if (struct.isSetMc_exprs()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetQuery_globals()) {
        struct.query_globals.write(oprot);
      }
      if (struct.isSetQuery_options()) {
        struct.query_options.write(oprot);
      }
      if (struct.isSetMc_exprs()) {
        {
          oprot.writeI32(struct.mc_exprs.size());
          for (java.util.Map.Entry<java.lang.Integer, io.datafibre.fibre.thrift.TExpr> _iter37 : struct.mc_exprs.entrySet())
          {
            oprot.writeI32(_iter37.getKey());
            _iter37.getValue().write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TAlterTabletMaterializedColumnReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.query_globals = new io.datafibre.fibre.thrift.TQueryGlobals();
        struct.query_globals.read(iprot);
        struct.setQuery_globalsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.query_options = new io.datafibre.fibre.thrift.TQueryOptions();
        struct.query_options.read(iprot);
        struct.setQuery_optionsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map38 = iprot.readMapBegin(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT); 
          struct.mc_exprs = new java.util.HashMap<java.lang.Integer,io.datafibre.fibre.thrift.TExpr>(2*_map38.size);
          int _key39;
          @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TExpr _val40;
          for (int _i41 = 0; _i41 < _map38.size; ++_i41)
          {
            _key39 = iprot.readI32();
            _val40 = new io.datafibre.fibre.thrift.TExpr();
            _val40.read(iprot);
            struct.mc_exprs.put(_key39, _val40);
          }
        }
        struct.setMc_exprsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
