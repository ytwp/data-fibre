/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TIcebergDeleteFile implements org.apache.thrift.TBase<TIcebergDeleteFile, TIcebergDeleteFile._Fields>, java.io.Serializable, Cloneable, Comparable<TIcebergDeleteFile> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TIcebergDeleteFile");

  private static final org.apache.thrift.protocol.TField FULL_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("full_path", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FILE_FORMAT_FIELD_DESC = new org.apache.thrift.protocol.TField("file_format", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField FILE_CONTENT_FIELD_DESC = new org.apache.thrift.protocol.TField("file_content", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField LENGTH_FIELD_DESC = new org.apache.thrift.protocol.TField("length", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TIcebergDeleteFileStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TIcebergDeleteFileTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String full_path; // optional
  /**
   * 
   * @see com.starrocks.thrift.THdfsFileFormat
   */
  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.THdfsFileFormat file_format; // optional
  /**
   * 
   * @see TIcebergFileContent
   */
  public @org.apache.thrift.annotation.Nullable TIcebergFileContent file_content; // optional
  public long length; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FULL_PATH((short)1, "full_path"),
    /**
     * 
     * @see com.starrocks.thrift.THdfsFileFormat
     */
    FILE_FORMAT((short)2, "file_format"),
    /**
     * 
     * @see TIcebergFileContent
     */
    FILE_CONTENT((short)3, "file_content"),
    LENGTH((short)4, "length");

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
        case 1: // FULL_PATH
          return FULL_PATH;
        case 2: // FILE_FORMAT
          return FILE_FORMAT;
        case 3: // FILE_CONTENT
          return FILE_CONTENT;
        case 4: // LENGTH
          return LENGTH;
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
  private static final int __LENGTH_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.FULL_PATH,_Fields.FILE_FORMAT,_Fields.FILE_CONTENT,_Fields.LENGTH};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FULL_PATH, new org.apache.thrift.meta_data.FieldMetaData("full_path", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FILE_FORMAT, new org.apache.thrift.meta_data.FieldMetaData("file_format", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.starrocks.thrift.THdfsFileFormat.class)));
    tmpMap.put(_Fields.FILE_CONTENT, new org.apache.thrift.meta_data.FieldMetaData("file_content", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TIcebergFileContent.class)));
    tmpMap.put(_Fields.LENGTH, new org.apache.thrift.meta_data.FieldMetaData("length", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TIcebergDeleteFile.class, metaDataMap);
  }

  public TIcebergDeleteFile() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TIcebergDeleteFile(TIcebergDeleteFile other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFull_path()) {
      this.full_path = other.full_path;
    }
    if (other.isSetFile_format()) {
      this.file_format = other.file_format;
    }
    if (other.isSetFile_content()) {
      this.file_content = other.file_content;
    }
    this.length = other.length;
  }

  @Override
  public TIcebergDeleteFile deepCopy() {
    return new TIcebergDeleteFile(this);
  }

  @Override
  public void clear() {
    this.full_path = null;
    this.file_format = null;
    this.file_content = null;
    setLengthIsSet(false);
    this.length = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getFull_path() {
    return this.full_path;
  }

  public TIcebergDeleteFile setFull_path(@org.apache.thrift.annotation.Nullable java.lang.String full_path) {
    this.full_path = full_path;
    return this;
  }

  public void unsetFull_path() {
    this.full_path = null;
  }

  /** Returns true if field full_path is set (has been assigned a value) and false otherwise */
  public boolean isSetFull_path() {
    return this.full_path != null;
  }

  public void setFull_pathIsSet(boolean value) {
    if (!value) {
      this.full_path = null;
    }
  }

  /**
   * 
   * @see com.starrocks.thrift.THdfsFileFormat
   */
  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.THdfsFileFormat getFile_format() {
    return this.file_format;
  }

  /**
   * 
   * @see com.starrocks.thrift.THdfsFileFormat
   */
  public TIcebergDeleteFile setFile_format(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.THdfsFileFormat file_format) {
    this.file_format = file_format;
    return this;
  }

  public void unsetFile_format() {
    this.file_format = null;
  }

  /** Returns true if field file_format is set (has been assigned a value) and false otherwise */
  public boolean isSetFile_format() {
    return this.file_format != null;
  }

  public void setFile_formatIsSet(boolean value) {
    if (!value) {
      this.file_format = null;
    }
  }

  /**
   * 
   * @see TIcebergFileContent
   */
  @org.apache.thrift.annotation.Nullable
  public TIcebergFileContent getFile_content() {
    return this.file_content;
  }

  /**
   * 
   * @see TIcebergFileContent
   */
  public TIcebergDeleteFile setFile_content(@org.apache.thrift.annotation.Nullable TIcebergFileContent file_content) {
    this.file_content = file_content;
    return this;
  }

  public void unsetFile_content() {
    this.file_content = null;
  }

  /** Returns true if field file_content is set (has been assigned a value) and false otherwise */
  public boolean isSetFile_content() {
    return this.file_content != null;
  }

  public void setFile_contentIsSet(boolean value) {
    if (!value) {
      this.file_content = null;
    }
  }

  public long getLength() {
    return this.length;
  }

  public TIcebergDeleteFile setLength(long length) {
    this.length = length;
    setLengthIsSet(true);
    return this;
  }

  public void unsetLength() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LENGTH_ISSET_ID);
  }

  /** Returns true if field length is set (has been assigned a value) and false otherwise */
  public boolean isSetLength() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LENGTH_ISSET_ID);
  }

  public void setLengthIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LENGTH_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case FULL_PATH:
      if (value == null) {
        unsetFull_path();
      } else {
        setFull_path((java.lang.String)value);
      }
      break;

    case FILE_FORMAT:
      if (value == null) {
        unsetFile_format();
      } else {
        setFile_format((com.starrocks.thrift.THdfsFileFormat)value);
      }
      break;

    case FILE_CONTENT:
      if (value == null) {
        unsetFile_content();
      } else {
        setFile_content((TIcebergFileContent)value);
      }
      break;

    case LENGTH:
      if (value == null) {
        unsetLength();
      } else {
        setLength((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FULL_PATH:
      return getFull_path();

    case FILE_FORMAT:
      return getFile_format();

    case FILE_CONTENT:
      return getFile_content();

    case LENGTH:
      return getLength();

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
    case FULL_PATH:
      return isSetFull_path();
    case FILE_FORMAT:
      return isSetFile_format();
    case FILE_CONTENT:
      return isSetFile_content();
    case LENGTH:
      return isSetLength();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TIcebergDeleteFile)
      return this.equals((TIcebergDeleteFile)that);
    return false;
  }

  public boolean equals(TIcebergDeleteFile that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_full_path = true && this.isSetFull_path();
    boolean that_present_full_path = true && that.isSetFull_path();
    if (this_present_full_path || that_present_full_path) {
      if (!(this_present_full_path && that_present_full_path))
        return false;
      if (!this.full_path.equals(that.full_path))
        return false;
    }

    boolean this_present_file_format = true && this.isSetFile_format();
    boolean that_present_file_format = true && that.isSetFile_format();
    if (this_present_file_format || that_present_file_format) {
      if (!(this_present_file_format && that_present_file_format))
        return false;
      if (!this.file_format.equals(that.file_format))
        return false;
    }

    boolean this_present_file_content = true && this.isSetFile_content();
    boolean that_present_file_content = true && that.isSetFile_content();
    if (this_present_file_content || that_present_file_content) {
      if (!(this_present_file_content && that_present_file_content))
        return false;
      if (!this.file_content.equals(that.file_content))
        return false;
    }

    boolean this_present_length = true && this.isSetLength();
    boolean that_present_length = true && that.isSetLength();
    if (this_present_length || that_present_length) {
      if (!(this_present_length && that_present_length))
        return false;
      if (this.length != that.length)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetFull_path()) ? 131071 : 524287);
    if (isSetFull_path())
      hashCode = hashCode * 8191 + full_path.hashCode();

    hashCode = hashCode * 8191 + ((isSetFile_format()) ? 131071 : 524287);
    if (isSetFile_format())
      hashCode = hashCode * 8191 + file_format.getValue();

    hashCode = hashCode * 8191 + ((isSetFile_content()) ? 131071 : 524287);
    if (isSetFile_content())
      hashCode = hashCode * 8191 + file_content.getValue();

    hashCode = hashCode * 8191 + ((isSetLength()) ? 131071 : 524287);
    if (isSetLength())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(length);

    return hashCode;
  }

  @Override
  public int compareTo(TIcebergDeleteFile other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetFull_path(), other.isSetFull_path());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFull_path()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.full_path, other.full_path);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetFile_format(), other.isSetFile_format());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFile_format()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.file_format, other.file_format);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetFile_content(), other.isSetFile_content());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFile_content()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.file_content, other.file_content);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetLength(), other.isSetLength());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLength()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.length, other.length);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TIcebergDeleteFile(");
    boolean first = true;

    if (isSetFull_path()) {
      sb.append("full_path:");
      if (this.full_path == null) {
        sb.append("null");
      } else {
        sb.append(this.full_path);
      }
      first = false;
    }
    if (isSetFile_format()) {
      if (!first) sb.append(", ");
      sb.append("file_format:");
      if (this.file_format == null) {
        sb.append("null");
      } else {
        sb.append(this.file_format);
      }
      first = false;
    }
    if (isSetFile_content()) {
      if (!first) sb.append(", ");
      sb.append("file_content:");
      if (this.file_content == null) {
        sb.append("null");
      } else {
        sb.append(this.file_content);
      }
      first = false;
    }
    if (isSetLength()) {
      if (!first) sb.append(", ");
      sb.append("length:");
      sb.append(this.length);
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

  private static class TIcebergDeleteFileStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TIcebergDeleteFileStandardScheme getScheme() {
      return new TIcebergDeleteFileStandardScheme();
    }
  }

  private static class TIcebergDeleteFileStandardScheme extends org.apache.thrift.scheme.StandardScheme<TIcebergDeleteFile> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TIcebergDeleteFile struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FULL_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.full_path = iprot.readString();
              struct.setFull_pathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FILE_FORMAT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.file_format = com.starrocks.thrift.THdfsFileFormat.findByValue(iprot.readI32());
              struct.setFile_formatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FILE_CONTENT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.file_content = com.starrocks.thrift.TIcebergFileContent.findByValue(iprot.readI32());
              struct.setFile_contentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LENGTH
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.length = iprot.readI64();
              struct.setLengthIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TIcebergDeleteFile struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.full_path != null) {
        if (struct.isSetFull_path()) {
          oprot.writeFieldBegin(FULL_PATH_FIELD_DESC);
          oprot.writeString(struct.full_path);
          oprot.writeFieldEnd();
        }
      }
      if (struct.file_format != null) {
        if (struct.isSetFile_format()) {
          oprot.writeFieldBegin(FILE_FORMAT_FIELD_DESC);
          oprot.writeI32(struct.file_format.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.file_content != null) {
        if (struct.isSetFile_content()) {
          oprot.writeFieldBegin(FILE_CONTENT_FIELD_DESC);
          oprot.writeI32(struct.file_content.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetLength()) {
        oprot.writeFieldBegin(LENGTH_FIELD_DESC);
        oprot.writeI64(struct.length);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TIcebergDeleteFileTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TIcebergDeleteFileTupleScheme getScheme() {
      return new TIcebergDeleteFileTupleScheme();
    }
  }

  private static class TIcebergDeleteFileTupleScheme extends org.apache.thrift.scheme.TupleScheme<TIcebergDeleteFile> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TIcebergDeleteFile struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetFull_path()) {
        optionals.set(0);
      }
      if (struct.isSetFile_format()) {
        optionals.set(1);
      }
      if (struct.isSetFile_content()) {
        optionals.set(2);
      }
      if (struct.isSetLength()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetFull_path()) {
        oprot.writeString(struct.full_path);
      }
      if (struct.isSetFile_format()) {
        oprot.writeI32(struct.file_format.getValue());
      }
      if (struct.isSetFile_content()) {
        oprot.writeI32(struct.file_content.getValue());
      }
      if (struct.isSetLength()) {
        oprot.writeI64(struct.length);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TIcebergDeleteFile struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.full_path = iprot.readString();
        struct.setFull_pathIsSet(true);
      }
      if (incoming.get(1)) {
        struct.file_format = com.starrocks.thrift.THdfsFileFormat.findByValue(iprot.readI32());
        struct.setFile_formatIsSet(true);
      }
      if (incoming.get(2)) {
        struct.file_content = com.starrocks.thrift.TIcebergFileContent.findByValue(iprot.readI32());
        struct.setFile_contentIsSet(true);
      }
      if (incoming.get(3)) {
        struct.length = iprot.readI64();
        struct.setLengthIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

