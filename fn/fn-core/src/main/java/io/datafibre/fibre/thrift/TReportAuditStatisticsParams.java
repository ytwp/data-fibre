/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TReportAuditStatisticsParams implements org.apache.thrift.TBase<TReportAuditStatisticsParams, TReportAuditStatisticsParams._Fields>, java.io.Serializable, Cloneable, Comparable<TReportAuditStatisticsParams> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TReportAuditStatisticsParams");

  private static final org.apache.thrift.protocol.TField QUERY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("query_id", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField FRAGMENT_INSTANCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("fragment_instance_id", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField AUDIT_STATISTICS_FIELD_DESC = new org.apache.thrift.protocol.TField("audit_statistics", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TReportAuditStatisticsParamsStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TReportAuditStatisticsParamsTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUniqueId query_id; // optional
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUniqueId fragment_instance_id; // optional
  public @org.apache.thrift.annotation.Nullable TAuditStatistics audit_statistics; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    QUERY_ID((short)1, "query_id"),
    FRAGMENT_INSTANCE_ID((short)2, "fragment_instance_id"),
    AUDIT_STATISTICS((short)3, "audit_statistics");

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
        case 1: // QUERY_ID
          return QUERY_ID;
        case 2: // FRAGMENT_INSTANCE_ID
          return FRAGMENT_INSTANCE_ID;
        case 3: // AUDIT_STATISTICS
          return AUDIT_STATISTICS;
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
  private static final _Fields optionals[] = {_Fields.QUERY_ID,_Fields.FRAGMENT_INSTANCE_ID,_Fields.AUDIT_STATISTICS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUERY_ID, new org.apache.thrift.meta_data.FieldMetaData("query_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TUniqueId.class)));
    tmpMap.put(_Fields.FRAGMENT_INSTANCE_ID, new org.apache.thrift.meta_data.FieldMetaData("fragment_instance_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, io.datafibre.fibre.thrift.TUniqueId.class)));
    tmpMap.put(_Fields.AUDIT_STATISTICS, new org.apache.thrift.meta_data.FieldMetaData("audit_statistics", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TAuditStatistics.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TReportAuditStatisticsParams.class, metaDataMap);
  }

  public TReportAuditStatisticsParams() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TReportAuditStatisticsParams(TReportAuditStatisticsParams other) {
    if (other.isSetQuery_id()) {
      this.query_id = new io.datafibre.fibre.thrift.TUniqueId(other.query_id);
    }
    if (other.isSetFragment_instance_id()) {
      this.fragment_instance_id = new io.datafibre.fibre.thrift.TUniqueId(other.fragment_instance_id);
    }
    if (other.isSetAudit_statistics()) {
      this.audit_statistics = new TAuditStatistics(other.audit_statistics);
    }
  }

  @Override
  public TReportAuditStatisticsParams deepCopy() {
    return new TReportAuditStatisticsParams(this);
  }

  @Override
  public void clear() {
    this.query_id = null;
    this.fragment_instance_id = null;
    this.audit_statistics = null;
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TUniqueId getQuery_id() {
    return this.query_id;
  }

  public TReportAuditStatisticsParams setQuery_id(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUniqueId query_id) {
    this.query_id = query_id;
    return this;
  }

  public void unsetQuery_id() {
    this.query_id = null;
  }

  /** Returns true if field query_id is set (has been assigned a value) and false otherwise */
  public boolean isSetQuery_id() {
    return this.query_id != null;
  }

  public void setQuery_idIsSet(boolean value) {
    if (!value) {
      this.query_id = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TUniqueId getFragment_instance_id() {
    return this.fragment_instance_id;
  }

  public TReportAuditStatisticsParams setFragment_instance_id(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TUniqueId fragment_instance_id) {
    this.fragment_instance_id = fragment_instance_id;
    return this;
  }

  public void unsetFragment_instance_id() {
    this.fragment_instance_id = null;
  }

  /** Returns true if field fragment_instance_id is set (has been assigned a value) and false otherwise */
  public boolean isSetFragment_instance_id() {
    return this.fragment_instance_id != null;
  }

  public void setFragment_instance_idIsSet(boolean value) {
    if (!value) {
      this.fragment_instance_id = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public TAuditStatistics getAudit_statistics() {
    return this.audit_statistics;
  }

  public TReportAuditStatisticsParams setAudit_statistics(@org.apache.thrift.annotation.Nullable TAuditStatistics audit_statistics) {
    this.audit_statistics = audit_statistics;
    return this;
  }

  public void unsetAudit_statistics() {
    this.audit_statistics = null;
  }

  /** Returns true if field audit_statistics is set (has been assigned a value) and false otherwise */
  public boolean isSetAudit_statistics() {
    return this.audit_statistics != null;
  }

  public void setAudit_statisticsIsSet(boolean value) {
    if (!value) {
      this.audit_statistics = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case QUERY_ID:
      if (value == null) {
        unsetQuery_id();
      } else {
        setQuery_id((io.datafibre.fibre.thrift.TUniqueId)value);
      }
      break;

    case FRAGMENT_INSTANCE_ID:
      if (value == null) {
        unsetFragment_instance_id();
      } else {
        setFragment_instance_id((io.datafibre.fibre.thrift.TUniqueId)value);
      }
      break;

    case AUDIT_STATISTICS:
      if (value == null) {
        unsetAudit_statistics();
      } else {
        setAudit_statistics((TAuditStatistics)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case QUERY_ID:
      return getQuery_id();

    case FRAGMENT_INSTANCE_ID:
      return getFragment_instance_id();

    case AUDIT_STATISTICS:
      return getAudit_statistics();

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
    case QUERY_ID:
      return isSetQuery_id();
    case FRAGMENT_INSTANCE_ID:
      return isSetFragment_instance_id();
    case AUDIT_STATISTICS:
      return isSetAudit_statistics();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TReportAuditStatisticsParams)
      return this.equals((TReportAuditStatisticsParams)that);
    return false;
  }

  public boolean equals(TReportAuditStatisticsParams that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_query_id = true && this.isSetQuery_id();
    boolean that_present_query_id = true && that.isSetQuery_id();
    if (this_present_query_id || that_present_query_id) {
      if (!(this_present_query_id && that_present_query_id))
        return false;
      if (!this.query_id.equals(that.query_id))
        return false;
    }

    boolean this_present_fragment_instance_id = true && this.isSetFragment_instance_id();
    boolean that_present_fragment_instance_id = true && that.isSetFragment_instance_id();
    if (this_present_fragment_instance_id || that_present_fragment_instance_id) {
      if (!(this_present_fragment_instance_id && that_present_fragment_instance_id))
        return false;
      if (!this.fragment_instance_id.equals(that.fragment_instance_id))
        return false;
    }

    boolean this_present_audit_statistics = true && this.isSetAudit_statistics();
    boolean that_present_audit_statistics = true && that.isSetAudit_statistics();
    if (this_present_audit_statistics || that_present_audit_statistics) {
      if (!(this_present_audit_statistics && that_present_audit_statistics))
        return false;
      if (!this.audit_statistics.equals(that.audit_statistics))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetQuery_id()) ? 131071 : 524287);
    if (isSetQuery_id())
      hashCode = hashCode * 8191 + query_id.hashCode();

    hashCode = hashCode * 8191 + ((isSetFragment_instance_id()) ? 131071 : 524287);
    if (isSetFragment_instance_id())
      hashCode = hashCode * 8191 + fragment_instance_id.hashCode();

    hashCode = hashCode * 8191 + ((isSetAudit_statistics()) ? 131071 : 524287);
    if (isSetAudit_statistics())
      hashCode = hashCode * 8191 + audit_statistics.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TReportAuditStatisticsParams other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetQuery_id(), other.isSetQuery_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.query_id, other.query_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetFragment_instance_id(), other.isSetFragment_instance_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFragment_instance_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fragment_instance_id, other.fragment_instance_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAudit_statistics(), other.isSetAudit_statistics());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAudit_statistics()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.audit_statistics, other.audit_statistics);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TReportAuditStatisticsParams(");
    boolean first = true;

    if (isSetQuery_id()) {
      sb.append("query_id:");
      if (this.query_id == null) {
        sb.append("null");
      } else {
        sb.append(this.query_id);
      }
      first = false;
    }
    if (isSetFragment_instance_id()) {
      if (!first) sb.append(", ");
      sb.append("fragment_instance_id:");
      if (this.fragment_instance_id == null) {
        sb.append("null");
      } else {
        sb.append(this.fragment_instance_id);
      }
      first = false;
    }
    if (isSetAudit_statistics()) {
      if (!first) sb.append(", ");
      sb.append("audit_statistics:");
      if (this.audit_statistics == null) {
        sb.append("null");
      } else {
        sb.append(this.audit_statistics);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (query_id != null) {
      query_id.validate();
    }
    if (fragment_instance_id != null) {
      fragment_instance_id.validate();
    }
    if (audit_statistics != null) {
      audit_statistics.validate();
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

  private static class TReportAuditStatisticsParamsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TReportAuditStatisticsParamsStandardScheme getScheme() {
      return new TReportAuditStatisticsParamsStandardScheme();
    }
  }

  private static class TReportAuditStatisticsParamsStandardScheme extends org.apache.thrift.scheme.StandardScheme<TReportAuditStatisticsParams> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TReportAuditStatisticsParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUERY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.query_id = new io.datafibre.fibre.thrift.TUniqueId();
              struct.query_id.read(iprot);
              struct.setQuery_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FRAGMENT_INSTANCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.fragment_instance_id = new io.datafibre.fibre.thrift.TUniqueId();
              struct.fragment_instance_id.read(iprot);
              struct.setFragment_instance_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUDIT_STATISTICS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.audit_statistics = new TAuditStatistics();
              struct.audit_statistics.read(iprot);
              struct.setAudit_statisticsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TReportAuditStatisticsParams struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.query_id != null) {
        if (struct.isSetQuery_id()) {
          oprot.writeFieldBegin(QUERY_ID_FIELD_DESC);
          struct.query_id.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.fragment_instance_id != null) {
        if (struct.isSetFragment_instance_id()) {
          oprot.writeFieldBegin(FRAGMENT_INSTANCE_ID_FIELD_DESC);
          struct.fragment_instance_id.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.audit_statistics != null) {
        if (struct.isSetAudit_statistics()) {
          oprot.writeFieldBegin(AUDIT_STATISTICS_FIELD_DESC);
          struct.audit_statistics.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TReportAuditStatisticsParamsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TReportAuditStatisticsParamsTupleScheme getScheme() {
      return new TReportAuditStatisticsParamsTupleScheme();
    }
  }

  private static class TReportAuditStatisticsParamsTupleScheme extends org.apache.thrift.scheme.TupleScheme<TReportAuditStatisticsParams> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TReportAuditStatisticsParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetQuery_id()) {
        optionals.set(0);
      }
      if (struct.isSetFragment_instance_id()) {
        optionals.set(1);
      }
      if (struct.isSetAudit_statistics()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetQuery_id()) {
        struct.query_id.write(oprot);
      }
      if (struct.isSetFragment_instance_id()) {
        struct.fragment_instance_id.write(oprot);
      }
      if (struct.isSetAudit_statistics()) {
        struct.audit_statistics.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TReportAuditStatisticsParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.query_id = new io.datafibre.fibre.thrift.TUniqueId();
        struct.query_id.read(iprot);
        struct.setQuery_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.fragment_instance_id = new io.datafibre.fibre.thrift.TUniqueId();
        struct.fragment_instance_id.read(iprot);
        struct.setFragment_instance_idIsSet(true);
      }
      if (incoming.get(2)) {
        struct.audit_statistics = new TAuditStatistics();
        struct.audit_statistics.read(iprot);
        struct.setAudit_statisticsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
