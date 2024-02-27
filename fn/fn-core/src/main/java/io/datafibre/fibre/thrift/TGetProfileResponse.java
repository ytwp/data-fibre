/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TGetProfileResponse implements org.apache.thrift.TBase<TGetProfileResponse, TGetProfileResponse._Fields>, java.io.Serializable, Cloneable, Comparable<TGetProfileResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TGetProfileResponse");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField QUERY_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("query_result", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TGetProfileResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TGetProfileResponseTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStatus status; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> query_result; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    QUERY_RESULT((short)2, "query_result");

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
        case 1: // STATUS
          return STATUS;
        case 2: // QUERY_RESULT
          return QUERY_RESULT;
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
  private static final _Fields optionals[] = {_Fields.STATUS,_Fields.QUERY_RESULT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TStatus.class)));
    tmpMap.put(_Fields.QUERY_RESULT, new org.apache.thrift.meta_data.FieldMetaData("query_result", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TGetProfileResponse.class, metaDataMap);
  }

  public TGetProfileResponse() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TGetProfileResponse(TGetProfileResponse other) {
    if (other.isSetStatus()) {
      this.status = new com.starrocks.thrift.TStatus(other.status);
    }
    if (other.isSetQuery_result()) {
      java.util.List<java.lang.String> __this__query_result = new java.util.ArrayList<java.lang.String>(other.query_result);
      this.query_result = __this__query_result;
    }
  }

  @Override
  public TGetProfileResponse deepCopy() {
    return new TGetProfileResponse(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.query_result = null;
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TStatus getStatus() {
    return this.status;
  }

  public TGetProfileResponse setStatus(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public int getQuery_resultSize() {
    return (this.query_result == null) ? 0 : this.query_result.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.String> getQuery_resultIterator() {
    return (this.query_result == null) ? null : this.query_result.iterator();
  }

  public void addToQuery_result(java.lang.String elem) {
    if (this.query_result == null) {
      this.query_result = new java.util.ArrayList<java.lang.String>();
    }
    this.query_result.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.String> getQuery_result() {
    return this.query_result;
  }

  public TGetProfileResponse setQuery_result(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> query_result) {
    this.query_result = query_result;
    return this;
  }

  public void unsetQuery_result() {
    this.query_result = null;
  }

  /** Returns true if field query_result is set (has been assigned a value) and false otherwise */
  public boolean isSetQuery_result() {
    return this.query_result != null;
  }

  public void setQuery_resultIsSet(boolean value) {
    if (!value) {
      this.query_result = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((com.starrocks.thrift.TStatus)value);
      }
      break;

    case QUERY_RESULT:
      if (value == null) {
        unsetQuery_result();
      } else {
        setQuery_result((java.util.List<java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case QUERY_RESULT:
      return getQuery_result();

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
    case STATUS:
      return isSetStatus();
    case QUERY_RESULT:
      return isSetQuery_result();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TGetProfileResponse)
      return this.equals((TGetProfileResponse)that);
    return false;
  }

  public boolean equals(TGetProfileResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_query_result = true && this.isSetQuery_result();
    boolean that_present_query_result = true && that.isSetQuery_result();
    if (this_present_query_result || that_present_query_result) {
      if (!(this_present_query_result && that_present_query_result))
        return false;
      if (!this.query_result.equals(that.query_result))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStatus()) ? 131071 : 524287);
    if (isSetStatus())
      hashCode = hashCode * 8191 + status.hashCode();

    hashCode = hashCode * 8191 + ((isSetQuery_result()) ? 131071 : 524287);
    if (isSetQuery_result())
      hashCode = hashCode * 8191 + query_result.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TGetProfileResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetStatus(), other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetQuery_result(), other.isSetQuery_result());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery_result()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.query_result, other.query_result);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TGetProfileResponse(");
    boolean first = true;

    if (isSetStatus()) {
      sb.append("status:");
      if (this.status == null) {
        sb.append("null");
      } else {
        sb.append(this.status);
      }
      first = false;
    }
    if (isSetQuery_result()) {
      if (!first) sb.append(", ");
      sb.append("query_result:");
      if (this.query_result == null) {
        sb.append("null");
      } else {
        sb.append(this.query_result);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (status != null) {
      status.validate();
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

  private static class TGetProfileResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetProfileResponseStandardScheme getScheme() {
      return new TGetProfileResponseStandardScheme();
    }
  }

  private static class TGetProfileResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<TGetProfileResponse> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TGetProfileResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.status = new com.starrocks.thrift.TStatus();
              struct.status.read(iprot);
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // QUERY_RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list758 = iprot.readListBegin();
                struct.query_result = new java.util.ArrayList<java.lang.String>(_list758.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _elem759;
                for (int _i760 = 0; _i760 < _list758.size; ++_i760)
                {
                  _elem759 = iprot.readString();
                  struct.query_result.add(_elem759);
                }
                iprot.readListEnd();
              }
              struct.setQuery_resultIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TGetProfileResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        if (struct.isSetStatus()) {
          oprot.writeFieldBegin(STATUS_FIELD_DESC);
          struct.status.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.query_result != null) {
        if (struct.isSetQuery_result()) {
          oprot.writeFieldBegin(QUERY_RESULT_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.query_result.size()));
            for (java.lang.String _iter761 : struct.query_result)
            {
              oprot.writeString(_iter761);
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

  private static class TGetProfileResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TGetProfileResponseTupleScheme getScheme() {
      return new TGetProfileResponseTupleScheme();
    }
  }

  private static class TGetProfileResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<TGetProfileResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TGetProfileResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      if (struct.isSetQuery_result()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetStatus()) {
        struct.status.write(oprot);
      }
      if (struct.isSetQuery_result()) {
        {
          oprot.writeI32(struct.query_result.size());
          for (java.lang.String _iter762 : struct.query_result)
          {
            oprot.writeString(_iter762);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TGetProfileResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.status = new com.starrocks.thrift.TStatus();
        struct.status.read(iprot);
        struct.setStatusIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list763 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
          struct.query_result = new java.util.ArrayList<java.lang.String>(_list763.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _elem764;
          for (int _i765 = 0; _i765 < _list763.size; ++_i765)
          {
            _elem764 = iprot.readString();
            struct.query_result.add(_elem764);
          }
        }
        struct.setQuery_resultIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

