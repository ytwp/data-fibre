/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TReleaseSnapshotRequest implements org.apache.thrift.TBase<TReleaseSnapshotRequest, TReleaseSnapshotRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TReleaseSnapshotRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TReleaseSnapshotRequest");

  private static final org.apache.thrift.protocol.TField SNAPSHOT_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("snapshot_path", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TReleaseSnapshotRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TReleaseSnapshotRequestTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String snapshot_path; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SNAPSHOT_PATH((short)1, "snapshot_path");

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
        case 1: // SNAPSHOT_PATH
          return SNAPSHOT_PATH;
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
    tmpMap.put(_Fields.SNAPSHOT_PATH, new org.apache.thrift.meta_data.FieldMetaData("snapshot_path", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TReleaseSnapshotRequest.class, metaDataMap);
  }

  public TReleaseSnapshotRequest() {
  }

  public TReleaseSnapshotRequest(
    java.lang.String snapshot_path)
  {
    this();
    this.snapshot_path = snapshot_path;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TReleaseSnapshotRequest(TReleaseSnapshotRequest other) {
    if (other.isSetSnapshot_path()) {
      this.snapshot_path = other.snapshot_path;
    }
  }

  @Override
  public TReleaseSnapshotRequest deepCopy() {
    return new TReleaseSnapshotRequest(this);
  }

  @Override
  public void clear() {
    this.snapshot_path = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getSnapshot_path() {
    return this.snapshot_path;
  }

  public TReleaseSnapshotRequest setSnapshot_path(@org.apache.thrift.annotation.Nullable java.lang.String snapshot_path) {
    this.snapshot_path = snapshot_path;
    return this;
  }

  public void unsetSnapshot_path() {
    this.snapshot_path = null;
  }

  /** Returns true if field snapshot_path is set (has been assigned a value) and false otherwise */
  public boolean isSetSnapshot_path() {
    return this.snapshot_path != null;
  }

  public void setSnapshot_pathIsSet(boolean value) {
    if (!value) {
      this.snapshot_path = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case SNAPSHOT_PATH:
      if (value == null) {
        unsetSnapshot_path();
      } else {
        setSnapshot_path((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SNAPSHOT_PATH:
      return getSnapshot_path();

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
    case SNAPSHOT_PATH:
      return isSetSnapshot_path();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TReleaseSnapshotRequest)
      return this.equals((TReleaseSnapshotRequest)that);
    return false;
  }

  public boolean equals(TReleaseSnapshotRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_snapshot_path = true && this.isSetSnapshot_path();
    boolean that_present_snapshot_path = true && that.isSetSnapshot_path();
    if (this_present_snapshot_path || that_present_snapshot_path) {
      if (!(this_present_snapshot_path && that_present_snapshot_path))
        return false;
      if (!this.snapshot_path.equals(that.snapshot_path))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetSnapshot_path()) ? 131071 : 524287);
    if (isSetSnapshot_path())
      hashCode = hashCode * 8191 + snapshot_path.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TReleaseSnapshotRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetSnapshot_path(), other.isSetSnapshot_path());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSnapshot_path()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.snapshot_path, other.snapshot_path);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TReleaseSnapshotRequest(");
    boolean first = true;

    sb.append("snapshot_path:");
    if (this.snapshot_path == null) {
      sb.append("null");
    } else {
      sb.append(this.snapshot_path);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (snapshot_path == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'snapshot_path' was not present! Struct: " + toString());
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

  private static class TReleaseSnapshotRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TReleaseSnapshotRequestStandardScheme getScheme() {
      return new TReleaseSnapshotRequestStandardScheme();
    }
  }

  private static class TReleaseSnapshotRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<TReleaseSnapshotRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TReleaseSnapshotRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SNAPSHOT_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.snapshot_path = iprot.readString();
              struct.setSnapshot_pathIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TReleaseSnapshotRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.snapshot_path != null) {
        oprot.writeFieldBegin(SNAPSHOT_PATH_FIELD_DESC);
        oprot.writeString(struct.snapshot_path);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TReleaseSnapshotRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TReleaseSnapshotRequestTupleScheme getScheme() {
      return new TReleaseSnapshotRequestTupleScheme();
    }
  }

  private static class TReleaseSnapshotRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<TReleaseSnapshotRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TReleaseSnapshotRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.snapshot_path);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TReleaseSnapshotRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.snapshot_path = iprot.readString();
      struct.setSnapshot_pathIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

