/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TTableFunctionTable implements org.apache.thrift.TBase<TTableFunctionTable, TTableFunctionTable._Fields>, java.io.Serializable, Cloneable, Comparable<TTableFunctionTable> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTableFunctionTable");

  private static final org.apache.thrift.protocol.TField PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("path", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("columns", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField FILE_FORMAT_FIELD_DESC = new org.apache.thrift.protocol.TField("file_format", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField COMPRESSION_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("compression_type", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField PARTITION_COLUMN_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("partition_column_ids", org.apache.thrift.protocol.TType.LIST, (short)5);
  private static final org.apache.thrift.protocol.TField WRITE_SINGLE_FILE_FIELD_DESC = new org.apache.thrift.protocol.TField("write_single_file", org.apache.thrift.protocol.TType.BOOL, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTableFunctionTableStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTableFunctionTableTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String path; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<TColumn> columns; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String file_format; // optional
  /**
   * 
   * @see io.datafibre.fibre.thrift.TCompressionType
   */
  public @org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TCompressionType compression_type; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> partition_column_ids; // optional
  public boolean write_single_file; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PATH((short)1, "path"),
    COLUMNS((short)2, "columns"),
    FILE_FORMAT((short)3, "file_format"),
    /**
     * 
     * @see io.datafibre.fibre.thrift.TCompressionType
     */
    COMPRESSION_TYPE((short)4, "compression_type"),
    PARTITION_COLUMN_IDS((short)5, "partition_column_ids"),
    WRITE_SINGLE_FILE((short)6, "write_single_file");

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
        case 1: // PATH
          return PATH;
        case 2: // COLUMNS
          return COLUMNS;
        case 3: // FILE_FORMAT
          return FILE_FORMAT;
        case 4: // COMPRESSION_TYPE
          return COMPRESSION_TYPE;
        case 5: // PARTITION_COLUMN_IDS
          return PARTITION_COLUMN_IDS;
        case 6: // WRITE_SINGLE_FILE
          return WRITE_SINGLE_FILE;
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
  private static final int __WRITE_SINGLE_FILE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PATH,_Fields.COLUMNS,_Fields.FILE_FORMAT,_Fields.COMPRESSION_TYPE,_Fields.PARTITION_COLUMN_IDS,_Fields.WRITE_SINGLE_FILE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PATH, new org.apache.thrift.meta_data.FieldMetaData("path", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("columns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TColumn.class))));
    tmpMap.put(_Fields.FILE_FORMAT, new org.apache.thrift.meta_data.FieldMetaData("file_format", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COMPRESSION_TYPE, new org.apache.thrift.meta_data.FieldMetaData("compression_type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, io.datafibre.fibre.thrift.TCompressionType.class)));
    tmpMap.put(_Fields.PARTITION_COLUMN_IDS, new org.apache.thrift.meta_data.FieldMetaData("partition_column_ids", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.WRITE_SINGLE_FILE, new org.apache.thrift.meta_data.FieldMetaData("write_single_file", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTableFunctionTable.class, metaDataMap);
  }

  public TTableFunctionTable() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTableFunctionTable(TTableFunctionTable other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPath()) {
      this.path = other.path;
    }
    if (other.isSetColumns()) {
      java.util.List<TColumn> __this__columns = new java.util.ArrayList<TColumn>(other.columns.size());
      for (TColumn other_element : other.columns) {
        __this__columns.add(new TColumn(other_element));
      }
      this.columns = __this__columns;
    }
    if (other.isSetFile_format()) {
      this.file_format = other.file_format;
    }
    if (other.isSetCompression_type()) {
      this.compression_type = other.compression_type;
    }
    if (other.isSetPartition_column_ids()) {
      java.util.List<java.lang.Integer> __this__partition_column_ids = new java.util.ArrayList<java.lang.Integer>(other.partition_column_ids);
      this.partition_column_ids = __this__partition_column_ids;
    }
    this.write_single_file = other.write_single_file;
  }

  @Override
  public TTableFunctionTable deepCopy() {
    return new TTableFunctionTable(this);
  }

  @Override
  public void clear() {
    this.path = null;
    this.columns = null;
    this.file_format = null;
    this.compression_type = null;
    this.partition_column_ids = null;
    setWrite_single_fileIsSet(false);
    this.write_single_file = false;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPath() {
    return this.path;
  }

  public TTableFunctionTable setPath(@org.apache.thrift.annotation.Nullable java.lang.String path) {
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

  public int getColumnsSize() {
    return (this.columns == null) ? 0 : this.columns.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TColumn> getColumnsIterator() {
    return (this.columns == null) ? null : this.columns.iterator();
  }

  public void addToColumns(TColumn elem) {
    if (this.columns == null) {
      this.columns = new java.util.ArrayList<TColumn>();
    }
    this.columns.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TColumn> getColumns() {
    return this.columns;
  }

  public TTableFunctionTable setColumns(@org.apache.thrift.annotation.Nullable java.util.List<TColumn> columns) {
    this.columns = columns;
    return this;
  }

  public void unsetColumns() {
    this.columns = null;
  }

  /** Returns true if field columns is set (has been assigned a value) and false otherwise */
  public boolean isSetColumns() {
    return this.columns != null;
  }

  public void setColumnsIsSet(boolean value) {
    if (!value) {
      this.columns = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getFile_format() {
    return this.file_format;
  }

  public TTableFunctionTable setFile_format(@org.apache.thrift.annotation.Nullable java.lang.String file_format) {
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
   * @see io.datafibre.fibre.thrift.TCompressionType
   */
  @org.apache.thrift.annotation.Nullable
  public io.datafibre.fibre.thrift.TCompressionType getCompression_type() {
    return this.compression_type;
  }

  /**
   * 
   * @see io.datafibre.fibre.thrift.TCompressionType
   */
  public TTableFunctionTable setCompression_type(@org.apache.thrift.annotation.Nullable io.datafibre.fibre.thrift.TCompressionType compression_type) {
    this.compression_type = compression_type;
    return this;
  }

  public void unsetCompression_type() {
    this.compression_type = null;
  }

  /** Returns true if field compression_type is set (has been assigned a value) and false otherwise */
  public boolean isSetCompression_type() {
    return this.compression_type != null;
  }

  public void setCompression_typeIsSet(boolean value) {
    if (!value) {
      this.compression_type = null;
    }
  }

  public int getPartition_column_idsSize() {
    return (this.partition_column_ids == null) ? 0 : this.partition_column_ids.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getPartition_column_idsIterator() {
    return (this.partition_column_ids == null) ? null : this.partition_column_ids.iterator();
  }

  public void addToPartition_column_ids(int elem) {
    if (this.partition_column_ids == null) {
      this.partition_column_ids = new java.util.ArrayList<java.lang.Integer>();
    }
    this.partition_column_ids.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getPartition_column_ids() {
    return this.partition_column_ids;
  }

  public TTableFunctionTable setPartition_column_ids(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> partition_column_ids) {
    this.partition_column_ids = partition_column_ids;
    return this;
  }

  public void unsetPartition_column_ids() {
    this.partition_column_ids = null;
  }

  /** Returns true if field partition_column_ids is set (has been assigned a value) and false otherwise */
  public boolean isSetPartition_column_ids() {
    return this.partition_column_ids != null;
  }

  public void setPartition_column_idsIsSet(boolean value) {
    if (!value) {
      this.partition_column_ids = null;
    }
  }

  public boolean isWrite_single_file() {
    return this.write_single_file;
  }

  public TTableFunctionTable setWrite_single_file(boolean write_single_file) {
    this.write_single_file = write_single_file;
    setWrite_single_fileIsSet(true);
    return this;
  }

  public void unsetWrite_single_file() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __WRITE_SINGLE_FILE_ISSET_ID);
  }

  /** Returns true if field write_single_file is set (has been assigned a value) and false otherwise */
  public boolean isSetWrite_single_file() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __WRITE_SINGLE_FILE_ISSET_ID);
  }

  public void setWrite_single_fileIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __WRITE_SINGLE_FILE_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PATH:
      if (value == null) {
        unsetPath();
      } else {
        setPath((java.lang.String)value);
      }
      break;

    case COLUMNS:
      if (value == null) {
        unsetColumns();
      } else {
        setColumns((java.util.List<TColumn>)value);
      }
      break;

    case FILE_FORMAT:
      if (value == null) {
        unsetFile_format();
      } else {
        setFile_format((java.lang.String)value);
      }
      break;

    case COMPRESSION_TYPE:
      if (value == null) {
        unsetCompression_type();
      } else {
        setCompression_type((io.datafibre.fibre.thrift.TCompressionType)value);
      }
      break;

    case PARTITION_COLUMN_IDS:
      if (value == null) {
        unsetPartition_column_ids();
      } else {
        setPartition_column_ids((java.util.List<java.lang.Integer>)value);
      }
      break;

    case WRITE_SINGLE_FILE:
      if (value == null) {
        unsetWrite_single_file();
      } else {
        setWrite_single_file((java.lang.Boolean)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PATH:
      return getPath();

    case COLUMNS:
      return getColumns();

    case FILE_FORMAT:
      return getFile_format();

    case COMPRESSION_TYPE:
      return getCompression_type();

    case PARTITION_COLUMN_IDS:
      return getPartition_column_ids();

    case WRITE_SINGLE_FILE:
      return isWrite_single_file();

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
    case PATH:
      return isSetPath();
    case COLUMNS:
      return isSetColumns();
    case FILE_FORMAT:
      return isSetFile_format();
    case COMPRESSION_TYPE:
      return isSetCompression_type();
    case PARTITION_COLUMN_IDS:
      return isSetPartition_column_ids();
    case WRITE_SINGLE_FILE:
      return isSetWrite_single_file();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TTableFunctionTable)
      return this.equals((TTableFunctionTable)that);
    return false;
  }

  public boolean equals(TTableFunctionTable that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_path = true && this.isSetPath();
    boolean that_present_path = true && that.isSetPath();
    if (this_present_path || that_present_path) {
      if (!(this_present_path && that_present_path))
        return false;
      if (!this.path.equals(that.path))
        return false;
    }

    boolean this_present_columns = true && this.isSetColumns();
    boolean that_present_columns = true && that.isSetColumns();
    if (this_present_columns || that_present_columns) {
      if (!(this_present_columns && that_present_columns))
        return false;
      if (!this.columns.equals(that.columns))
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

    boolean this_present_compression_type = true && this.isSetCompression_type();
    boolean that_present_compression_type = true && that.isSetCompression_type();
    if (this_present_compression_type || that_present_compression_type) {
      if (!(this_present_compression_type && that_present_compression_type))
        return false;
      if (!this.compression_type.equals(that.compression_type))
        return false;
    }

    boolean this_present_partition_column_ids = true && this.isSetPartition_column_ids();
    boolean that_present_partition_column_ids = true && that.isSetPartition_column_ids();
    if (this_present_partition_column_ids || that_present_partition_column_ids) {
      if (!(this_present_partition_column_ids && that_present_partition_column_ids))
        return false;
      if (!this.partition_column_ids.equals(that.partition_column_ids))
        return false;
    }

    boolean this_present_write_single_file = true && this.isSetWrite_single_file();
    boolean that_present_write_single_file = true && that.isSetWrite_single_file();
    if (this_present_write_single_file || that_present_write_single_file) {
      if (!(this_present_write_single_file && that_present_write_single_file))
        return false;
      if (this.write_single_file != that.write_single_file)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetPath()) ? 131071 : 524287);
    if (isSetPath())
      hashCode = hashCode * 8191 + path.hashCode();

    hashCode = hashCode * 8191 + ((isSetColumns()) ? 131071 : 524287);
    if (isSetColumns())
      hashCode = hashCode * 8191 + columns.hashCode();

    hashCode = hashCode * 8191 + ((isSetFile_format()) ? 131071 : 524287);
    if (isSetFile_format())
      hashCode = hashCode * 8191 + file_format.hashCode();

    hashCode = hashCode * 8191 + ((isSetCompression_type()) ? 131071 : 524287);
    if (isSetCompression_type())
      hashCode = hashCode * 8191 + compression_type.getValue();

    hashCode = hashCode * 8191 + ((isSetPartition_column_ids()) ? 131071 : 524287);
    if (isSetPartition_column_ids())
      hashCode = hashCode * 8191 + partition_column_ids.hashCode();

    hashCode = hashCode * 8191 + ((isSetWrite_single_file()) ? 131071 : 524287);
    if (isSetWrite_single_file())
      hashCode = hashCode * 8191 + ((write_single_file) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(TTableFunctionTable other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = java.lang.Boolean.compare(isSetColumns(), other.isSetColumns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columns, other.columns);
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
    lastComparison = java.lang.Boolean.compare(isSetCompression_type(), other.isSetCompression_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompression_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.compression_type, other.compression_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPartition_column_ids(), other.isSetPartition_column_ids());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartition_column_ids()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partition_column_ids, other.partition_column_ids);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetWrite_single_file(), other.isSetWrite_single_file());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWrite_single_file()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.write_single_file, other.write_single_file);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTableFunctionTable(");
    boolean first = true;

    if (isSetPath()) {
      sb.append("path:");
      if (this.path == null) {
        sb.append("null");
      } else {
        sb.append(this.path);
      }
      first = false;
    }
    if (isSetColumns()) {
      if (!first) sb.append(", ");
      sb.append("columns:");
      if (this.columns == null) {
        sb.append("null");
      } else {
        sb.append(this.columns);
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
    if (isSetCompression_type()) {
      if (!first) sb.append(", ");
      sb.append("compression_type:");
      if (this.compression_type == null) {
        sb.append("null");
      } else {
        sb.append(this.compression_type);
      }
      first = false;
    }
    if (isSetPartition_column_ids()) {
      if (!first) sb.append(", ");
      sb.append("partition_column_ids:");
      if (this.partition_column_ids == null) {
        sb.append("null");
      } else {
        sb.append(this.partition_column_ids);
      }
      first = false;
    }
    if (isSetWrite_single_file()) {
      if (!first) sb.append(", ");
      sb.append("write_single_file:");
      sb.append(this.write_single_file);
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

  private static class TTableFunctionTableStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTableFunctionTableStandardScheme getScheme() {
      return new TTableFunctionTableStandardScheme();
    }
  }

  private static class TTableFunctionTableStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTableFunctionTable> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TTableFunctionTable struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.path = iprot.readString();
              struct.setPathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list252 = iprot.readListBegin();
                struct.columns = new java.util.ArrayList<TColumn>(_list252.size);
                @org.apache.thrift.annotation.Nullable TColumn _elem253;
                for (int _i254 = 0; _i254 < _list252.size; ++_i254)
                {
                  _elem253 = new TColumn();
                  _elem253.read(iprot);
                  struct.columns.add(_elem253);
                }
                iprot.readListEnd();
              }
              struct.setColumnsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FILE_FORMAT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.file_format = iprot.readString();
              struct.setFile_formatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // COMPRESSION_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.compression_type = io.datafibre.fibre.thrift.TCompressionType.findByValue(iprot.readI32());
              struct.setCompression_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PARTITION_COLUMN_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list255 = iprot.readListBegin();
                struct.partition_column_ids = new java.util.ArrayList<java.lang.Integer>(_list255.size);
                int _elem256;
                for (int _i257 = 0; _i257 < _list255.size; ++_i257)
                {
                  _elem256 = iprot.readI32();
                  struct.partition_column_ids.add(_elem256);
                }
                iprot.readListEnd();
              }
              struct.setPartition_column_idsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // WRITE_SINGLE_FILE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.write_single_file = iprot.readBool();
              struct.setWrite_single_fileIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TTableFunctionTable struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.path != null) {
        if (struct.isSetPath()) {
          oprot.writeFieldBegin(PATH_FIELD_DESC);
          oprot.writeString(struct.path);
          oprot.writeFieldEnd();
        }
      }
      if (struct.columns != null) {
        if (struct.isSetColumns()) {
          oprot.writeFieldBegin(COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.columns.size()));
            for (TColumn _iter258 : struct.columns)
            {
              _iter258.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.file_format != null) {
        if (struct.isSetFile_format()) {
          oprot.writeFieldBegin(FILE_FORMAT_FIELD_DESC);
          oprot.writeString(struct.file_format);
          oprot.writeFieldEnd();
        }
      }
      if (struct.compression_type != null) {
        if (struct.isSetCompression_type()) {
          oprot.writeFieldBegin(COMPRESSION_TYPE_FIELD_DESC);
          oprot.writeI32(struct.compression_type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.partition_column_ids != null) {
        if (struct.isSetPartition_column_ids()) {
          oprot.writeFieldBegin(PARTITION_COLUMN_IDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.partition_column_ids.size()));
            for (int _iter259 : struct.partition_column_ids)
            {
              oprot.writeI32(_iter259);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetWrite_single_file()) {
        oprot.writeFieldBegin(WRITE_SINGLE_FILE_FIELD_DESC);
        oprot.writeBool(struct.write_single_file);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTableFunctionTableTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TTableFunctionTableTupleScheme getScheme() {
      return new TTableFunctionTableTupleScheme();
    }
  }

  private static class TTableFunctionTableTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTableFunctionTable> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTableFunctionTable struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetPath()) {
        optionals.set(0);
      }
      if (struct.isSetColumns()) {
        optionals.set(1);
      }
      if (struct.isSetFile_format()) {
        optionals.set(2);
      }
      if (struct.isSetCompression_type()) {
        optionals.set(3);
      }
      if (struct.isSetPartition_column_ids()) {
        optionals.set(4);
      }
      if (struct.isSetWrite_single_file()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetPath()) {
        oprot.writeString(struct.path);
      }
      if (struct.isSetColumns()) {
        {
          oprot.writeI32(struct.columns.size());
          for (TColumn _iter260 : struct.columns)
          {
            _iter260.write(oprot);
          }
        }
      }
      if (struct.isSetFile_format()) {
        oprot.writeString(struct.file_format);
      }
      if (struct.isSetCompression_type()) {
        oprot.writeI32(struct.compression_type.getValue());
      }
      if (struct.isSetPartition_column_ids()) {
        {
          oprot.writeI32(struct.partition_column_ids.size());
          for (int _iter261 : struct.partition_column_ids)
          {
            oprot.writeI32(_iter261);
          }
        }
      }
      if (struct.isSetWrite_single_file()) {
        oprot.writeBool(struct.write_single_file);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTableFunctionTable struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.path = iprot.readString();
        struct.setPathIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list262 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.columns = new java.util.ArrayList<TColumn>(_list262.size);
          @org.apache.thrift.annotation.Nullable TColumn _elem263;
          for (int _i264 = 0; _i264 < _list262.size; ++_i264)
          {
            _elem263 = new TColumn();
            _elem263.read(iprot);
            struct.columns.add(_elem263);
          }
        }
        struct.setColumnsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.file_format = iprot.readString();
        struct.setFile_formatIsSet(true);
      }
      if (incoming.get(3)) {
        struct.compression_type = io.datafibre.fibre.thrift.TCompressionType.findByValue(iprot.readI32());
        struct.setCompression_typeIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TList _list265 = iprot.readListBegin(org.apache.thrift.protocol.TType.I32);
          struct.partition_column_ids = new java.util.ArrayList<java.lang.Integer>(_list265.size);
          int _elem266;
          for (int _i267 = 0; _i267 < _list265.size; ++_i267)
          {
            _elem266 = iprot.readI32();
            struct.partition_column_ids.add(_elem266);
          }
        }
        struct.setPartition_column_idsIsSet(true);
      }
      if (incoming.get(5)) {
        struct.write_single_file = iprot.readBool();
        struct.setWrite_single_fileIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
