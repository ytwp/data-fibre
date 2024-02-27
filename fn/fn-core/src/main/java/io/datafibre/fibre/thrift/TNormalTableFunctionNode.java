/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public class TNormalTableFunctionNode implements org.apache.thrift.TBase<TNormalTableFunctionNode, TNormalTableFunctionNode._Fields>, java.io.Serializable, Cloneable, Comparable<TNormalTableFunctionNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TNormalTableFunctionNode");

  private static final org.apache.thrift.protocol.TField TABLE_FUNCTION_FIELD_DESC = new org.apache.thrift.protocol.TField("table_function", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PARAM_COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("param_columns", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField OUTER_COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("outer_columns", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField FN_RESULT_COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("fn_result_columns", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TNormalTableFunctionNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TNormalTableFunctionNodeTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.starrocks.thrift.TFunction table_function; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> param_columns; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> outer_columns; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> fn_result_columns; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLE_FUNCTION((short)1, "table_function"),
    PARAM_COLUMNS((short)2, "param_columns"),
    OUTER_COLUMNS((short)3, "outer_columns"),
    FN_RESULT_COLUMNS((short)4, "fn_result_columns");

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
        case 1: // TABLE_FUNCTION
          return TABLE_FUNCTION;
        case 2: // PARAM_COLUMNS
          return PARAM_COLUMNS;
        case 3: // OUTER_COLUMNS
          return OUTER_COLUMNS;
        case 4: // FN_RESULT_COLUMNS
          return FN_RESULT_COLUMNS;
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
  private static final _Fields optionals[] = {_Fields.TABLE_FUNCTION,_Fields.PARAM_COLUMNS,_Fields.OUTER_COLUMNS,_Fields.FN_RESULT_COLUMNS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLE_FUNCTION, new org.apache.thrift.meta_data.FieldMetaData("table_function", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.starrocks.thrift.TFunction.class)));
    tmpMap.put(_Fields.PARAM_COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("param_columns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32            , "TSlotId"))));
    tmpMap.put(_Fields.OUTER_COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("outer_columns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32            , "TSlotId"))));
    tmpMap.put(_Fields.FN_RESULT_COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("fn_result_columns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32            , "TSlotId"))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TNormalTableFunctionNode.class, metaDataMap);
  }

  public TNormalTableFunctionNode() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TNormalTableFunctionNode(TNormalTableFunctionNode other) {
    if (other.isSetTable_function()) {
      this.table_function = new com.starrocks.thrift.TFunction(other.table_function);
    }
    if (other.isSetParam_columns()) {
      java.util.List<java.lang.Integer> __this__param_columns = new java.util.ArrayList<java.lang.Integer>(other.param_columns.size());
      for (java.lang.Integer other_element : other.param_columns) {
        __this__param_columns.add(other_element);
      }
      this.param_columns = __this__param_columns;
    }
    if (other.isSetOuter_columns()) {
      java.util.List<java.lang.Integer> __this__outer_columns = new java.util.ArrayList<java.lang.Integer>(other.outer_columns.size());
      for (java.lang.Integer other_element : other.outer_columns) {
        __this__outer_columns.add(other_element);
      }
      this.outer_columns = __this__outer_columns;
    }
    if (other.isSetFn_result_columns()) {
      java.util.List<java.lang.Integer> __this__fn_result_columns = new java.util.ArrayList<java.lang.Integer>(other.fn_result_columns.size());
      for (java.lang.Integer other_element : other.fn_result_columns) {
        __this__fn_result_columns.add(other_element);
      }
      this.fn_result_columns = __this__fn_result_columns;
    }
  }

  @Override
  public TNormalTableFunctionNode deepCopy() {
    return new TNormalTableFunctionNode(this);
  }

  @Override
  public void clear() {
    this.table_function = null;
    this.param_columns = null;
    this.outer_columns = null;
    this.fn_result_columns = null;
  }

  @org.apache.thrift.annotation.Nullable
  public com.starrocks.thrift.TFunction getTable_function() {
    return this.table_function;
  }

  public TNormalTableFunctionNode setTable_function(@org.apache.thrift.annotation.Nullable com.starrocks.thrift.TFunction table_function) {
    this.table_function = table_function;
    return this;
  }

  public void unsetTable_function() {
    this.table_function = null;
  }

  /** Returns true if field table_function is set (has been assigned a value) and false otherwise */
  public boolean isSetTable_function() {
    return this.table_function != null;
  }

  public void setTable_functionIsSet(boolean value) {
    if (!value) {
      this.table_function = null;
    }
  }

  public int getParam_columnsSize() {
    return (this.param_columns == null) ? 0 : this.param_columns.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getParam_columnsIterator() {
    return (this.param_columns == null) ? null : this.param_columns.iterator();
  }

  public void addToParam_columns(int elem) {
    if (this.param_columns == null) {
      this.param_columns = new java.util.ArrayList<java.lang.Integer>();
    }
    this.param_columns.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getParam_columns() {
    return this.param_columns;
  }

  public TNormalTableFunctionNode setParam_columns(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> param_columns) {
    this.param_columns = param_columns;
    return this;
  }

  public void unsetParam_columns() {
    this.param_columns = null;
  }

  /** Returns true if field param_columns is set (has been assigned a value) and false otherwise */
  public boolean isSetParam_columns() {
    return this.param_columns != null;
  }

  public void setParam_columnsIsSet(boolean value) {
    if (!value) {
      this.param_columns = null;
    }
  }

  public int getOuter_columnsSize() {
    return (this.outer_columns == null) ? 0 : this.outer_columns.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getOuter_columnsIterator() {
    return (this.outer_columns == null) ? null : this.outer_columns.iterator();
  }

  public void addToOuter_columns(int elem) {
    if (this.outer_columns == null) {
      this.outer_columns = new java.util.ArrayList<java.lang.Integer>();
    }
    this.outer_columns.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getOuter_columns() {
    return this.outer_columns;
  }

  public TNormalTableFunctionNode setOuter_columns(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> outer_columns) {
    this.outer_columns = outer_columns;
    return this;
  }

  public void unsetOuter_columns() {
    this.outer_columns = null;
  }

  /** Returns true if field outer_columns is set (has been assigned a value) and false otherwise */
  public boolean isSetOuter_columns() {
    return this.outer_columns != null;
  }

  public void setOuter_columnsIsSet(boolean value) {
    if (!value) {
      this.outer_columns = null;
    }
  }

  public int getFn_result_columnsSize() {
    return (this.fn_result_columns == null) ? 0 : this.fn_result_columns.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getFn_result_columnsIterator() {
    return (this.fn_result_columns == null) ? null : this.fn_result_columns.iterator();
  }

  public void addToFn_result_columns(int elem) {
    if (this.fn_result_columns == null) {
      this.fn_result_columns = new java.util.ArrayList<java.lang.Integer>();
    }
    this.fn_result_columns.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getFn_result_columns() {
    return this.fn_result_columns;
  }

  public TNormalTableFunctionNode setFn_result_columns(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> fn_result_columns) {
    this.fn_result_columns = fn_result_columns;
    return this;
  }

  public void unsetFn_result_columns() {
    this.fn_result_columns = null;
  }

  /** Returns true if field fn_result_columns is set (has been assigned a value) and false otherwise */
  public boolean isSetFn_result_columns() {
    return this.fn_result_columns != null;
  }

  public void setFn_result_columnsIsSet(boolean value) {
    if (!value) {
      this.fn_result_columns = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TABLE_FUNCTION:
      if (value == null) {
        unsetTable_function();
      } else {
        setTable_function((com.starrocks.thrift.TFunction)value);
      }
      break;

    case PARAM_COLUMNS:
      if (value == null) {
        unsetParam_columns();
      } else {
        setParam_columns((java.util.List<java.lang.Integer>)value);
      }
      break;

    case OUTER_COLUMNS:
      if (value == null) {
        unsetOuter_columns();
      } else {
        setOuter_columns((java.util.List<java.lang.Integer>)value);
      }
      break;

    case FN_RESULT_COLUMNS:
      if (value == null) {
        unsetFn_result_columns();
      } else {
        setFn_result_columns((java.util.List<java.lang.Integer>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLE_FUNCTION:
      return getTable_function();

    case PARAM_COLUMNS:
      return getParam_columns();

    case OUTER_COLUMNS:
      return getOuter_columns();

    case FN_RESULT_COLUMNS:
      return getFn_result_columns();

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
    case TABLE_FUNCTION:
      return isSetTable_function();
    case PARAM_COLUMNS:
      return isSetParam_columns();
    case OUTER_COLUMNS:
      return isSetOuter_columns();
    case FN_RESULT_COLUMNS:
      return isSetFn_result_columns();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TNormalTableFunctionNode)
      return this.equals((TNormalTableFunctionNode)that);
    return false;
  }

  public boolean equals(TNormalTableFunctionNode that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_table_function = true && this.isSetTable_function();
    boolean that_present_table_function = true && that.isSetTable_function();
    if (this_present_table_function || that_present_table_function) {
      if (!(this_present_table_function && that_present_table_function))
        return false;
      if (!this.table_function.equals(that.table_function))
        return false;
    }

    boolean this_present_param_columns = true && this.isSetParam_columns();
    boolean that_present_param_columns = true && that.isSetParam_columns();
    if (this_present_param_columns || that_present_param_columns) {
      if (!(this_present_param_columns && that_present_param_columns))
        return false;
      if (!this.param_columns.equals(that.param_columns))
        return false;
    }

    boolean this_present_outer_columns = true && this.isSetOuter_columns();
    boolean that_present_outer_columns = true && that.isSetOuter_columns();
    if (this_present_outer_columns || that_present_outer_columns) {
      if (!(this_present_outer_columns && that_present_outer_columns))
        return false;
      if (!this.outer_columns.equals(that.outer_columns))
        return false;
    }

    boolean this_present_fn_result_columns = true && this.isSetFn_result_columns();
    boolean that_present_fn_result_columns = true && that.isSetFn_result_columns();
    if (this_present_fn_result_columns || that_present_fn_result_columns) {
      if (!(this_present_fn_result_columns && that_present_fn_result_columns))
        return false;
      if (!this.fn_result_columns.equals(that.fn_result_columns))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTable_function()) ? 131071 : 524287);
    if (isSetTable_function())
      hashCode = hashCode * 8191 + table_function.hashCode();

    hashCode = hashCode * 8191 + ((isSetParam_columns()) ? 131071 : 524287);
    if (isSetParam_columns())
      hashCode = hashCode * 8191 + param_columns.hashCode();

    hashCode = hashCode * 8191 + ((isSetOuter_columns()) ? 131071 : 524287);
    if (isSetOuter_columns())
      hashCode = hashCode * 8191 + outer_columns.hashCode();

    hashCode = hashCode * 8191 + ((isSetFn_result_columns()) ? 131071 : 524287);
    if (isSetFn_result_columns())
      hashCode = hashCode * 8191 + fn_result_columns.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TNormalTableFunctionNode other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTable_function(), other.isSetTable_function());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable_function()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table_function, other.table_function);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetParam_columns(), other.isSetParam_columns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParam_columns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.param_columns, other.param_columns);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetOuter_columns(), other.isSetOuter_columns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOuter_columns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.outer_columns, other.outer_columns);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetFn_result_columns(), other.isSetFn_result_columns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFn_result_columns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fn_result_columns, other.fn_result_columns);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TNormalTableFunctionNode(");
    boolean first = true;

    if (isSetTable_function()) {
      sb.append("table_function:");
      if (this.table_function == null) {
        sb.append("null");
      } else {
        sb.append(this.table_function);
      }
      first = false;
    }
    if (isSetParam_columns()) {
      if (!first) sb.append(", ");
      sb.append("param_columns:");
      if (this.param_columns == null) {
        sb.append("null");
      } else {
        sb.append(this.param_columns);
      }
      first = false;
    }
    if (isSetOuter_columns()) {
      if (!first) sb.append(", ");
      sb.append("outer_columns:");
      if (this.outer_columns == null) {
        sb.append("null");
      } else {
        sb.append(this.outer_columns);
      }
      first = false;
    }
    if (isSetFn_result_columns()) {
      if (!first) sb.append(", ");
      sb.append("fn_result_columns:");
      if (this.fn_result_columns == null) {
        sb.append("null");
      } else {
        sb.append(this.fn_result_columns);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (table_function != null) {
      table_function.validate();
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

  private static class TNormalTableFunctionNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNormalTableFunctionNodeStandardScheme getScheme() {
      return new TNormalTableFunctionNodeStandardScheme();
    }
  }

  private static class TNormalTableFunctionNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<TNormalTableFunctionNode> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TNormalTableFunctionNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLE_FUNCTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.table_function = new com.starrocks.thrift.TFunction();
              struct.table_function.read(iprot);
              struct.setTable_functionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARAM_COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list192 = iprot.readListBegin();
                struct.param_columns = new java.util.ArrayList<java.lang.Integer>(_list192.size);
                int _elem193;
                for (int _i194 = 0; _i194 < _list192.size; ++_i194)
                {
                  _elem193 = iprot.readI32();
                  struct.param_columns.add(_elem193);
                }
                iprot.readListEnd();
              }
              struct.setParam_columnsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // OUTER_COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list195 = iprot.readListBegin();
                struct.outer_columns = new java.util.ArrayList<java.lang.Integer>(_list195.size);
                int _elem196;
                for (int _i197 = 0; _i197 < _list195.size; ++_i197)
                {
                  _elem196 = iprot.readI32();
                  struct.outer_columns.add(_elem196);
                }
                iprot.readListEnd();
              }
              struct.setOuter_columnsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FN_RESULT_COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list198 = iprot.readListBegin();
                struct.fn_result_columns = new java.util.ArrayList<java.lang.Integer>(_list198.size);
                int _elem199;
                for (int _i200 = 0; _i200 < _list198.size; ++_i200)
                {
                  _elem199 = iprot.readI32();
                  struct.fn_result_columns.add(_elem199);
                }
                iprot.readListEnd();
              }
              struct.setFn_result_columnsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, TNormalTableFunctionNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.table_function != null) {
        if (struct.isSetTable_function()) {
          oprot.writeFieldBegin(TABLE_FUNCTION_FIELD_DESC);
          struct.table_function.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.param_columns != null) {
        if (struct.isSetParam_columns()) {
          oprot.writeFieldBegin(PARAM_COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.param_columns.size()));
            for (int _iter201 : struct.param_columns)
            {
              oprot.writeI32(_iter201);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.outer_columns != null) {
        if (struct.isSetOuter_columns()) {
          oprot.writeFieldBegin(OUTER_COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.outer_columns.size()));
            for (int _iter202 : struct.outer_columns)
            {
              oprot.writeI32(_iter202);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.fn_result_columns != null) {
        if (struct.isSetFn_result_columns()) {
          oprot.writeFieldBegin(FN_RESULT_COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.fn_result_columns.size()));
            for (int _iter203 : struct.fn_result_columns)
            {
              oprot.writeI32(_iter203);
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

  private static class TNormalTableFunctionNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TNormalTableFunctionNodeTupleScheme getScheme() {
      return new TNormalTableFunctionNodeTupleScheme();
    }
  }

  private static class TNormalTableFunctionNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<TNormalTableFunctionNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TNormalTableFunctionNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTable_function()) {
        optionals.set(0);
      }
      if (struct.isSetParam_columns()) {
        optionals.set(1);
      }
      if (struct.isSetOuter_columns()) {
        optionals.set(2);
      }
      if (struct.isSetFn_result_columns()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTable_function()) {
        struct.table_function.write(oprot);
      }
      if (struct.isSetParam_columns()) {
        {
          oprot.writeI32(struct.param_columns.size());
          for (int _iter204 : struct.param_columns)
          {
            oprot.writeI32(_iter204);
          }
        }
      }
      if (struct.isSetOuter_columns()) {
        {
          oprot.writeI32(struct.outer_columns.size());
          for (int _iter205 : struct.outer_columns)
          {
            oprot.writeI32(_iter205);
          }
        }
      }
      if (struct.isSetFn_result_columns()) {
        {
          oprot.writeI32(struct.fn_result_columns.size());
          for (int _iter206 : struct.fn_result_columns)
          {
            oprot.writeI32(_iter206);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TNormalTableFunctionNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.table_function = new com.starrocks.thrift.TFunction();
        struct.table_function.read(iprot);
        struct.setTable_functionIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list207 = iprot.readListBegin(org.apache.thrift.protocol.TType.I32);
          struct.param_columns = new java.util.ArrayList<java.lang.Integer>(_list207.size);
          int _elem208;
          for (int _i209 = 0; _i209 < _list207.size; ++_i209)
          {
            _elem208 = iprot.readI32();
            struct.param_columns.add(_elem208);
          }
        }
        struct.setParam_columnsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list210 = iprot.readListBegin(org.apache.thrift.protocol.TType.I32);
          struct.outer_columns = new java.util.ArrayList<java.lang.Integer>(_list210.size);
          int _elem211;
          for (int _i212 = 0; _i212 < _list210.size; ++_i212)
          {
            _elem211 = iprot.readI32();
            struct.outer_columns.add(_elem211);
          }
        }
        struct.setOuter_columnsIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list213 = iprot.readListBegin(org.apache.thrift.protocol.TType.I32);
          struct.fn_result_columns = new java.util.ArrayList<java.lang.Integer>(_list213.size);
          int _elem214;
          for (int _i215 = 0; _i215 < _list213.size; ++_i215)
          {
            _elem214 = iprot.readI32();
            struct.fn_result_columns.add(_elem214);
          }
        }
        struct.setFn_result_columnsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

