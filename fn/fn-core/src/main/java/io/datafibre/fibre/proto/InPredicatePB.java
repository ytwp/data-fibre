// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: types.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.InPredicatePB}
 */
public final class InPredicatePB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.InPredicatePB)
    InPredicatePBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InPredicatePB.newBuilder() to construct.
  private InPredicatePB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InPredicatePB() {
    columnName_ = "";
    values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new InPredicatePB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.Types.internal_static_starrocks_InPredicatePB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.Types.internal_static_starrocks_InPredicatePB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.InPredicatePB.class, com.starrocks.proto.InPredicatePB.Builder.class);
  }

  private int bitField0_;
  public static final int COLUMN_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object columnName_;
  /**
   * <code>optional string column_name = 1;</code>
   * @return Whether the columnName field is set.
   */
  @java.lang.Override
  public boolean hasColumnName() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string column_name = 1;</code>
   * @return The columnName.
   */
  @java.lang.Override
  public java.lang.String getColumnName() {
    java.lang.Object ref = columnName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        columnName_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string column_name = 1;</code>
   * @return The bytes for columnName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getColumnNameBytes() {
    java.lang.Object ref = columnName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      columnName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int IS_NOT_IN_FIELD_NUMBER = 2;
  private boolean isNotIn_;
  /**
   * <code>optional bool is_not_in = 2;</code>
   * @return Whether the isNotIn field is set.
   */
  @java.lang.Override
  public boolean hasIsNotIn() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional bool is_not_in = 2;</code>
   * @return The isNotIn.
   */
  @java.lang.Override
  public boolean getIsNotIn() {
    return isNotIn_;
  }

  public static final int VALUES_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList values_;
  /**
   * <code>repeated string values = 3;</code>
   * @return A list containing the values.
   */
  public com.google.protobuf.ProtocolStringList
      getValuesList() {
    return values_;
  }
  /**
   * <code>repeated string values = 3;</code>
   * @return The count of values.
   */
  public int getValuesCount() {
    return values_.size();
  }
  /**
   * <code>repeated string values = 3;</code>
   * @param index The index of the element to return.
   * @return The values at the given index.
   */
  public java.lang.String getValues(int index) {
    return values_.get(index);
  }
  /**
   * <code>repeated string values = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the values at the given index.
   */
  public com.google.protobuf.ByteString
      getValuesBytes(int index) {
    return values_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, columnName_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeBool(2, isNotIn_);
    }
    for (int i = 0; i < values_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, values_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, columnName_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, isNotIn_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < values_.size(); i++) {
        dataSize += computeStringSizeNoTag(values_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getValuesList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.starrocks.proto.InPredicatePB)) {
      return super.equals(obj);
    }
    com.starrocks.proto.InPredicatePB other = (com.starrocks.proto.InPredicatePB) obj;

    if (hasColumnName() != other.hasColumnName()) return false;
    if (hasColumnName()) {
      if (!getColumnName()
          .equals(other.getColumnName())) return false;
    }
    if (hasIsNotIn() != other.hasIsNotIn()) return false;
    if (hasIsNotIn()) {
      if (getIsNotIn()
          != other.getIsNotIn()) return false;
    }
    if (!getValuesList()
        .equals(other.getValuesList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasColumnName()) {
      hash = (37 * hash) + COLUMN_NAME_FIELD_NUMBER;
      hash = (53 * hash) + getColumnName().hashCode();
    }
    if (hasIsNotIn()) {
      hash = (37 * hash) + IS_NOT_IN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsNotIn());
    }
    if (getValuesCount() > 0) {
      hash = (37 * hash) + VALUES_FIELD_NUMBER;
      hash = (53 * hash) + getValuesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.InPredicatePB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.InPredicatePB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.InPredicatePB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.InPredicatePB parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.starrocks.proto.InPredicatePB prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code starrocks.InPredicatePB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.InPredicatePB)
      com.starrocks.proto.InPredicatePBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.Types.internal_static_starrocks_InPredicatePB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.Types.internal_static_starrocks_InPredicatePB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.InPredicatePB.class, com.starrocks.proto.InPredicatePB.Builder.class);
    }

    // Construct using com.starrocks.proto.InPredicatePB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      columnName_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      isNotIn_ = false;
      bitField0_ = (bitField0_ & ~0x00000002);
      values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.Types.internal_static_starrocks_InPredicatePB_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.InPredicatePB getDefaultInstanceForType() {
      return com.starrocks.proto.InPredicatePB.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.InPredicatePB build() {
      com.starrocks.proto.InPredicatePB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.InPredicatePB buildPartial() {
      com.starrocks.proto.InPredicatePB result = new com.starrocks.proto.InPredicatePB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.columnName_ = columnName_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.isNotIn_ = isNotIn_;
        to_bitField0_ |= 0x00000002;
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        values_ = values_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.values_ = values_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.starrocks.proto.InPredicatePB) {
        return mergeFrom((com.starrocks.proto.InPredicatePB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.InPredicatePB other) {
      if (other == com.starrocks.proto.InPredicatePB.getDefaultInstance()) return this;
      if (other.hasColumnName()) {
        bitField0_ |= 0x00000001;
        columnName_ = other.columnName_;
        onChanged();
      }
      if (other.hasIsNotIn()) {
        setIsNotIn(other.getIsNotIn());
      }
      if (!other.values_.isEmpty()) {
        if (values_.isEmpty()) {
          values_ = other.values_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensureValuesIsMutable();
          values_.addAll(other.values_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              columnName_ = input.readBytes();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              isNotIn_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              ensureValuesIsMutable();
              values_.add(bs);
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object columnName_ = "";
    /**
     * <code>optional string column_name = 1;</code>
     * @return Whether the columnName field is set.
     */
    public boolean hasColumnName() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional string column_name = 1;</code>
     * @return The columnName.
     */
    public java.lang.String getColumnName() {
      java.lang.Object ref = columnName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          columnName_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string column_name = 1;</code>
     * @return The bytes for columnName.
     */
    public com.google.protobuf.ByteString
        getColumnNameBytes() {
      java.lang.Object ref = columnName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        columnName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string column_name = 1;</code>
     * @param value The columnName to set.
     * @return This builder for chaining.
     */
    public Builder setColumnName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      columnName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string column_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearColumnName() {
      bitField0_ = (bitField0_ & ~0x00000001);
      columnName_ = getDefaultInstance().getColumnName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string column_name = 1;</code>
     * @param value The bytes for columnName to set.
     * @return This builder for chaining.
     */
    public Builder setColumnNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      columnName_ = value;
      onChanged();
      return this;
    }

    private boolean isNotIn_ ;
    /**
     * <code>optional bool is_not_in = 2;</code>
     * @return Whether the isNotIn field is set.
     */
    @java.lang.Override
    public boolean hasIsNotIn() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional bool is_not_in = 2;</code>
     * @return The isNotIn.
     */
    @java.lang.Override
    public boolean getIsNotIn() {
      return isNotIn_;
    }
    /**
     * <code>optional bool is_not_in = 2;</code>
     * @param value The isNotIn to set.
     * @return This builder for chaining.
     */
    public Builder setIsNotIn(boolean value) {
      bitField0_ |= 0x00000002;
      isNotIn_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool is_not_in = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsNotIn() {
      bitField0_ = (bitField0_ & ~0x00000002);
      isNotIn_ = false;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureValuesIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        values_ = new com.google.protobuf.LazyStringArrayList(values_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <code>repeated string values = 3;</code>
     * @return A list containing the values.
     */
    public com.google.protobuf.ProtocolStringList
        getValuesList() {
      return values_.getUnmodifiableView();
    }
    /**
     * <code>repeated string values = 3;</code>
     * @return The count of values.
     */
    public int getValuesCount() {
      return values_.size();
    }
    /**
     * <code>repeated string values = 3;</code>
     * @param index The index of the element to return.
     * @return The values at the given index.
     */
    public java.lang.String getValues(int index) {
      return values_.get(index);
    }
    /**
     * <code>repeated string values = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the values at the given index.
     */
    public com.google.protobuf.ByteString
        getValuesBytes(int index) {
      return values_.getByteString(index);
    }
    /**
     * <code>repeated string values = 3;</code>
     * @param index The index to set the value at.
     * @param value The values to set.
     * @return This builder for chaining.
     */
    public Builder setValues(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureValuesIsMutable();
      values_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 3;</code>
     * @param value The values to add.
     * @return This builder for chaining.
     */
    public Builder addValues(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureValuesIsMutable();
      values_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 3;</code>
     * @param values The values to add.
     * @return This builder for chaining.
     */
    public Builder addAllValues(
        java.lang.Iterable<java.lang.String> values) {
      ensureValuesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, values_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearValues() {
      values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 3;</code>
     * @param value The bytes of the values to add.
     * @return This builder for chaining.
     */
    public Builder addValuesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureValuesIsMutable();
      values_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:starrocks.InPredicatePB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.InPredicatePB)
  private static final com.starrocks.proto.InPredicatePB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.InPredicatePB();
  }

  public static com.starrocks.proto.InPredicatePB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<InPredicatePB>
      PARSER = new com.google.protobuf.AbstractParser<InPredicatePB>() {
    @java.lang.Override
    public InPredicatePB parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<InPredicatePB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InPredicatePB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.InPredicatePB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

