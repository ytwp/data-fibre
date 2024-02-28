// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: descriptors.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.POlapTableColumnParam}
 */
public final class POlapTableColumnParam extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.POlapTableColumnParam)
    POlapTableColumnParamOrBuilder {
private static final long serialVersionUID = 0L;
  // Use POlapTableColumnParam.newBuilder() to construct.
  private POlapTableColumnParam(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private POlapTableColumnParam() {
    columnsDesc_ = java.util.Collections.emptyList();
    sortKeyUid_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new POlapTableColumnParam();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.Descriptors.internal_static_starrocks_POlapTableColumnParam_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.Descriptors.internal_static_starrocks_POlapTableColumnParam_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.POlapTableColumnParam.class, io.datafibre.fibre.proto.POlapTableColumnParam.Builder.class);
  }

  private int bitField0_;
  public static final int COLUMNS_DESC_FIELD_NUMBER = 1;
  private java.util.List<io.datafibre.fibre.proto.ColumnPB> columnsDesc_;
  /**
   * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.datafibre.fibre.proto.ColumnPB> getColumnsDescList() {
    return columnsDesc_;
  }
  /**
   * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.datafibre.fibre.proto.ColumnPBOrBuilder>
      getColumnsDescOrBuilderList() {
    return columnsDesc_;
  }
  /**
   * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
   */
  @java.lang.Override
  public int getColumnsDescCount() {
    return columnsDesc_.size();
  }
  /**
   * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.ColumnPB getColumnsDesc(int index) {
    return columnsDesc_.get(index);
  }
  /**
   * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.ColumnPBOrBuilder getColumnsDescOrBuilder(
      int index) {
    return columnsDesc_.get(index);
  }

  public static final int SORT_KEY_UID_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.IntList sortKeyUid_;
  /**
   * <code>repeated int32 sort_key_uid = 2;</code>
   * @return A list containing the sortKeyUid.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getSortKeyUidList() {
    return sortKeyUid_;
  }
  /**
   * <code>repeated int32 sort_key_uid = 2;</code>
   * @return The count of sortKeyUid.
   */
  public int getSortKeyUidCount() {
    return sortKeyUid_.size();
  }
  /**
   * <code>repeated int32 sort_key_uid = 2;</code>
   * @param index The index of the element to return.
   * @return The sortKeyUid at the given index.
   */
  public int getSortKeyUid(int index) {
    return sortKeyUid_.getInt(index);
  }

  public static final int SHORT_KEY_COLUMN_COUNT_FIELD_NUMBER = 3;
  private int shortKeyColumnCount_;
  /**
   * <code>required int32 short_key_column_count = 3;</code>
   * @return Whether the shortKeyColumnCount field is set.
   */
  @java.lang.Override
  public boolean hasShortKeyColumnCount() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required int32 short_key_column_count = 3;</code>
   * @return The shortKeyColumnCount.
   */
  @java.lang.Override
  public int getShortKeyColumnCount() {
    return shortKeyColumnCount_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasShortKeyColumnCount()) {
      memoizedIsInitialized = 0;
      return false;
    }
    for (int i = 0; i < getColumnsDescCount(); i++) {
      if (!getColumnsDesc(i).isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < columnsDesc_.size(); i++) {
      output.writeMessage(1, columnsDesc_.get(i));
    }
    for (int i = 0; i < sortKeyUid_.size(); i++) {
      output.writeInt32(2, sortKeyUid_.getInt(i));
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt32(3, shortKeyColumnCount_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < columnsDesc_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, columnsDesc_.get(i));
    }
    {
      int dataSize = 0;
      for (int i = 0; i < sortKeyUid_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(sortKeyUid_.getInt(i));
      }
      size += dataSize;
      size += 1 * getSortKeyUidList().size();
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, shortKeyColumnCount_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.POlapTableColumnParam)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.POlapTableColumnParam other = (io.datafibre.fibre.proto.POlapTableColumnParam) obj;

    if (!getColumnsDescList()
        .equals(other.getColumnsDescList())) return false;
    if (!getSortKeyUidList()
        .equals(other.getSortKeyUidList())) return false;
    if (hasShortKeyColumnCount() != other.hasShortKeyColumnCount()) return false;
    if (hasShortKeyColumnCount()) {
      if (getShortKeyColumnCount()
          != other.getShortKeyColumnCount()) return false;
    }
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
    if (getColumnsDescCount() > 0) {
      hash = (37 * hash) + COLUMNS_DESC_FIELD_NUMBER;
      hash = (53 * hash) + getColumnsDescList().hashCode();
    }
    if (getSortKeyUidCount() > 0) {
      hash = (37 * hash) + SORT_KEY_UID_FIELD_NUMBER;
      hash = (53 * hash) + getSortKeyUidList().hashCode();
    }
    if (hasShortKeyColumnCount()) {
      hash = (37 * hash) + SHORT_KEY_COLUMN_COUNT_FIELD_NUMBER;
      hash = (53 * hash) + getShortKeyColumnCount();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.POlapTableColumnParam parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.POlapTableColumnParam prototype) {
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
   * Protobuf type {@code starrocks.POlapTableColumnParam}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.POlapTableColumnParam)
      io.datafibre.fibre.proto.POlapTableColumnParamOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.Descriptors.internal_static_starrocks_POlapTableColumnParam_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.Descriptors.internal_static_starrocks_POlapTableColumnParam_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.POlapTableColumnParam.class, io.datafibre.fibre.proto.POlapTableColumnParam.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.POlapTableColumnParam.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (columnsDescBuilder_ == null) {
        columnsDesc_ = java.util.Collections.emptyList();
      } else {
        columnsDesc_ = null;
        columnsDescBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      sortKeyUid_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000002);
      shortKeyColumnCount_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.Descriptors.internal_static_starrocks_POlapTableColumnParam_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.POlapTableColumnParam getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.POlapTableColumnParam.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.POlapTableColumnParam build() {
      io.datafibre.fibre.proto.POlapTableColumnParam result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.POlapTableColumnParam buildPartial() {
      io.datafibre.fibre.proto.POlapTableColumnParam result = new io.datafibre.fibre.proto.POlapTableColumnParam(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (columnsDescBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          columnsDesc_ = java.util.Collections.unmodifiableList(columnsDesc_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.columnsDesc_ = columnsDesc_;
      } else {
        result.columnsDesc_ = columnsDescBuilder_.build();
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        sortKeyUid_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.sortKeyUid_ = sortKeyUid_;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.shortKeyColumnCount_ = shortKeyColumnCount_;
        to_bitField0_ |= 0x00000001;
      }
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
      if (other instanceof io.datafibre.fibre.proto.POlapTableColumnParam) {
        return mergeFrom((io.datafibre.fibre.proto.POlapTableColumnParam)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.POlapTableColumnParam other) {
      if (other == io.datafibre.fibre.proto.POlapTableColumnParam.getDefaultInstance()) return this;
      if (columnsDescBuilder_ == null) {
        if (!other.columnsDesc_.isEmpty()) {
          if (columnsDesc_.isEmpty()) {
            columnsDesc_ = other.columnsDesc_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureColumnsDescIsMutable();
            columnsDesc_.addAll(other.columnsDesc_);
          }
          onChanged();
        }
      } else {
        if (!other.columnsDesc_.isEmpty()) {
          if (columnsDescBuilder_.isEmpty()) {
            columnsDescBuilder_.dispose();
            columnsDescBuilder_ = null;
            columnsDesc_ = other.columnsDesc_;
            bitField0_ = (bitField0_ & ~0x00000001);
            columnsDescBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getColumnsDescFieldBuilder() : null;
          } else {
            columnsDescBuilder_.addAllMessages(other.columnsDesc_);
          }
        }
      }
      if (!other.sortKeyUid_.isEmpty()) {
        if (sortKeyUid_.isEmpty()) {
          sortKeyUid_ = other.sortKeyUid_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureSortKeyUidIsMutable();
          sortKeyUid_.addAll(other.sortKeyUid_);
        }
        onChanged();
      }
      if (other.hasShortKeyColumnCount()) {
        setShortKeyColumnCount(other.getShortKeyColumnCount());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasShortKeyColumnCount()) {
        return false;
      }
      for (int i = 0; i < getColumnsDescCount(); i++) {
        if (!getColumnsDesc(i).isInitialized()) {
          return false;
        }
      }
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
              io.datafibre.fibre.proto.ColumnPB m =
                  input.readMessage(
                      io.datafibre.fibre.proto.ColumnPB.PARSER,
                      extensionRegistry);
              if (columnsDescBuilder_ == null) {
                ensureColumnsDescIsMutable();
                columnsDesc_.add(m);
              } else {
                columnsDescBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 16: {
              int v = input.readInt32();
              ensureSortKeyUidIsMutable();
              sortKeyUid_.addInt(v);
              break;
            } // case 16
            case 18: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureSortKeyUidIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                sortKeyUid_.addInt(input.readInt32());
              }
              input.popLimit(limit);
              break;
            } // case 18
            case 24: {
              shortKeyColumnCount_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
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

    private java.util.List<io.datafibre.fibre.proto.ColumnPB> columnsDesc_ =
      java.util.Collections.emptyList();
    private void ensureColumnsDescIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        columnsDesc_ = new java.util.ArrayList<io.datafibre.fibre.proto.ColumnPB>(columnsDesc_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.ColumnPB, io.datafibre.fibre.proto.ColumnPB.Builder, io.datafibre.fibre.proto.ColumnPBOrBuilder> columnsDescBuilder_;

    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.ColumnPB> getColumnsDescList() {
      if (columnsDescBuilder_ == null) {
        return java.util.Collections.unmodifiableList(columnsDesc_);
      } else {
        return columnsDescBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public int getColumnsDescCount() {
      if (columnsDescBuilder_ == null) {
        return columnsDesc_.size();
      } else {
        return columnsDescBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public io.datafibre.fibre.proto.ColumnPB getColumnsDesc(int index) {
      if (columnsDescBuilder_ == null) {
        return columnsDesc_.get(index);
      } else {
        return columnsDescBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder setColumnsDesc(
        int index, io.datafibre.fibre.proto.ColumnPB value) {
      if (columnsDescBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureColumnsDescIsMutable();
        columnsDesc_.set(index, value);
        onChanged();
      } else {
        columnsDescBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder setColumnsDesc(
        int index, io.datafibre.fibre.proto.ColumnPB.Builder builderForValue) {
      if (columnsDescBuilder_ == null) {
        ensureColumnsDescIsMutable();
        columnsDesc_.set(index, builderForValue.build());
        onChanged();
      } else {
        columnsDescBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder addColumnsDesc(io.datafibre.fibre.proto.ColumnPB value) {
      if (columnsDescBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureColumnsDescIsMutable();
        columnsDesc_.add(value);
        onChanged();
      } else {
        columnsDescBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder addColumnsDesc(
        int index, io.datafibre.fibre.proto.ColumnPB value) {
      if (columnsDescBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureColumnsDescIsMutable();
        columnsDesc_.add(index, value);
        onChanged();
      } else {
        columnsDescBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder addColumnsDesc(
        io.datafibre.fibre.proto.ColumnPB.Builder builderForValue) {
      if (columnsDescBuilder_ == null) {
        ensureColumnsDescIsMutable();
        columnsDesc_.add(builderForValue.build());
        onChanged();
      } else {
        columnsDescBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder addColumnsDesc(
        int index, io.datafibre.fibre.proto.ColumnPB.Builder builderForValue) {
      if (columnsDescBuilder_ == null) {
        ensureColumnsDescIsMutable();
        columnsDesc_.add(index, builderForValue.build());
        onChanged();
      } else {
        columnsDescBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder addAllColumnsDesc(
        java.lang.Iterable<? extends io.datafibre.fibre.proto.ColumnPB> values) {
      if (columnsDescBuilder_ == null) {
        ensureColumnsDescIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, columnsDesc_);
        onChanged();
      } else {
        columnsDescBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder clearColumnsDesc() {
      if (columnsDescBuilder_ == null) {
        columnsDesc_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        columnsDescBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public Builder removeColumnsDesc(int index) {
      if (columnsDescBuilder_ == null) {
        ensureColumnsDescIsMutable();
        columnsDesc_.remove(index);
        onChanged();
      } else {
        columnsDescBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public io.datafibre.fibre.proto.ColumnPB.Builder getColumnsDescBuilder(
        int index) {
      return getColumnsDescFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public io.datafibre.fibre.proto.ColumnPBOrBuilder getColumnsDescOrBuilder(
        int index) {
      if (columnsDescBuilder_ == null) {
        return columnsDesc_.get(index);  } else {
        return columnsDescBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public java.util.List<? extends io.datafibre.fibre.proto.ColumnPBOrBuilder>
         getColumnsDescOrBuilderList() {
      if (columnsDescBuilder_ != null) {
        return columnsDescBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(columnsDesc_);
      }
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public io.datafibre.fibre.proto.ColumnPB.Builder addColumnsDescBuilder() {
      return getColumnsDescFieldBuilder().addBuilder(
          io.datafibre.fibre.proto.ColumnPB.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public io.datafibre.fibre.proto.ColumnPB.Builder addColumnsDescBuilder(
        int index) {
      return getColumnsDescFieldBuilder().addBuilder(
          index, io.datafibre.fibre.proto.ColumnPB.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.ColumnPB columns_desc = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.ColumnPB.Builder>
         getColumnsDescBuilderList() {
      return getColumnsDescFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.ColumnPB, io.datafibre.fibre.proto.ColumnPB.Builder, io.datafibre.fibre.proto.ColumnPBOrBuilder>
        getColumnsDescFieldBuilder() {
      if (columnsDescBuilder_ == null) {
        columnsDescBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.datafibre.fibre.proto.ColumnPB, io.datafibre.fibre.proto.ColumnPB.Builder, io.datafibre.fibre.proto.ColumnPBOrBuilder>(
                columnsDesc_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        columnsDesc_ = null;
      }
      return columnsDescBuilder_;
    }

    private com.google.protobuf.Internal.IntList sortKeyUid_ = emptyIntList();
    private void ensureSortKeyUidIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        sortKeyUid_ = mutableCopy(sortKeyUid_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated int32 sort_key_uid = 2;</code>
     * @return A list containing the sortKeyUid.
     */
    public java.util.List<java.lang.Integer>
        getSortKeyUidList() {
      return ((bitField0_ & 0x00000002) != 0) ?
               java.util.Collections.unmodifiableList(sortKeyUid_) : sortKeyUid_;
    }
    /**
     * <code>repeated int32 sort_key_uid = 2;</code>
     * @return The count of sortKeyUid.
     */
    public int getSortKeyUidCount() {
      return sortKeyUid_.size();
    }
    /**
     * <code>repeated int32 sort_key_uid = 2;</code>
     * @param index The index of the element to return.
     * @return The sortKeyUid at the given index.
     */
    public int getSortKeyUid(int index) {
      return sortKeyUid_.getInt(index);
    }
    /**
     * <code>repeated int32 sort_key_uid = 2;</code>
     * @param index The index to set the value at.
     * @param value The sortKeyUid to set.
     * @return This builder for chaining.
     */
    public Builder setSortKeyUid(
        int index, int value) {
      ensureSortKeyUidIsMutable();
      sortKeyUid_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 sort_key_uid = 2;</code>
     * @param value The sortKeyUid to add.
     * @return This builder for chaining.
     */
    public Builder addSortKeyUid(int value) {
      ensureSortKeyUidIsMutable();
      sortKeyUid_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 sort_key_uid = 2;</code>
     * @param values The sortKeyUid to add.
     * @return This builder for chaining.
     */
    public Builder addAllSortKeyUid(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureSortKeyUidIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, sortKeyUid_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 sort_key_uid = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSortKeyUid() {
      sortKeyUid_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }

    private int shortKeyColumnCount_ ;
    /**
     * <code>required int32 short_key_column_count = 3;</code>
     * @return Whether the shortKeyColumnCount field is set.
     */
    @java.lang.Override
    public boolean hasShortKeyColumnCount() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>required int32 short_key_column_count = 3;</code>
     * @return The shortKeyColumnCount.
     */
    @java.lang.Override
    public int getShortKeyColumnCount() {
      return shortKeyColumnCount_;
    }
    /**
     * <code>required int32 short_key_column_count = 3;</code>
     * @param value The shortKeyColumnCount to set.
     * @return This builder for chaining.
     */
    public Builder setShortKeyColumnCount(int value) {
      bitField0_ |= 0x00000004;
      shortKeyColumnCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int32 short_key_column_count = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearShortKeyColumnCount() {
      bitField0_ = (bitField0_ & ~0x00000004);
      shortKeyColumnCount_ = 0;
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


    // @@protoc_insertion_point(builder_scope:starrocks.POlapTableColumnParam)
  }

  // @@protoc_insertion_point(class_scope:starrocks.POlapTableColumnParam)
  private static final io.datafibre.fibre.proto.POlapTableColumnParam DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.POlapTableColumnParam();
  }

  public static io.datafibre.fibre.proto.POlapTableColumnParam getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<POlapTableColumnParam>
      PARSER = new com.google.protobuf.AbstractParser<POlapTableColumnParam>() {
    @java.lang.Override
    public POlapTableColumnParam parsePartialFrom(
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

  public static com.google.protobuf.Parser<POlapTableColumnParam> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<POlapTableColumnParam> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.POlapTableColumnParam getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

