// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_common.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.DeltaColumnGroupPB}
 */
public final class DeltaColumnGroupPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.DeltaColumnGroupPB)
    DeltaColumnGroupPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeltaColumnGroupPB.newBuilder() to construct.
  private DeltaColumnGroupPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeltaColumnGroupPB() {
    columnIds_ = java.util.Collections.emptyList();
    columnFiles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DeltaColumnGroupPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.DeltaColumnGroupPB.class, io.datafibre.fibre.proto.DeltaColumnGroupPB.Builder.class);
  }

  public static final int COLUMN_IDS_FIELD_NUMBER = 1;
  private java.util.List<io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB> columnIds_;
  /**
   * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB> getColumnIdsList() {
    return columnIds_;
  }
  /**
   * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPBOrBuilder>
      getColumnIdsOrBuilderList() {
    return columnIds_;
  }
  /**
   * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
   */
  @java.lang.Override
  public int getColumnIdsCount() {
    return columnIds_.size();
  }
  /**
   * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB getColumnIds(int index) {
    return columnIds_.get(index);
  }
  /**
   * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPBOrBuilder getColumnIdsOrBuilder(
      int index) {
    return columnIds_.get(index);
  }

  public static final int COLUMN_FILES_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList columnFiles_;
  /**
   * <code>repeated string column_files = 2;</code>
   * @return A list containing the columnFiles.
   */
  public com.google.protobuf.ProtocolStringList
      getColumnFilesList() {
    return columnFiles_;
  }
  /**
   * <code>repeated string column_files = 2;</code>
   * @return The count of columnFiles.
   */
  public int getColumnFilesCount() {
    return columnFiles_.size();
  }
  /**
   * <code>repeated string column_files = 2;</code>
   * @param index The index of the element to return.
   * @return The columnFiles at the given index.
   */
  public java.lang.String getColumnFiles(int index) {
    return columnFiles_.get(index);
  }
  /**
   * <code>repeated string column_files = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the columnFiles at the given index.
   */
  public com.google.protobuf.ByteString
      getColumnFilesBytes(int index) {
    return columnFiles_.getByteString(index);
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
    for (int i = 0; i < columnIds_.size(); i++) {
      output.writeMessage(1, columnIds_.get(i));
    }
    for (int i = 0; i < columnFiles_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, columnFiles_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < columnIds_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, columnIds_.get(i));
    }
    {
      int dataSize = 0;
      for (int i = 0; i < columnFiles_.size(); i++) {
        dataSize += computeStringSizeNoTag(columnFiles_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getColumnFilesList().size();
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
    if (!(obj instanceof io.datafibre.fibre.proto.DeltaColumnGroupPB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.DeltaColumnGroupPB other = (io.datafibre.fibre.proto.DeltaColumnGroupPB) obj;

    if (!getColumnIdsList()
        .equals(other.getColumnIdsList())) return false;
    if (!getColumnFilesList()
        .equals(other.getColumnFilesList())) return false;
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
    if (getColumnIdsCount() > 0) {
      hash = (37 * hash) + COLUMN_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getColumnIdsList().hashCode();
    }
    if (getColumnFilesCount() > 0) {
      hash = (37 * hash) + COLUMN_FILES_FIELD_NUMBER;
      hash = (53 * hash) + getColumnFilesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeltaColumnGroupPB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.DeltaColumnGroupPB prototype) {
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
   * Protobuf type {@code starrocks.DeltaColumnGroupPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.DeltaColumnGroupPB)
      io.datafibre.fibre.proto.DeltaColumnGroupPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.DeltaColumnGroupPB.class, io.datafibre.fibre.proto.DeltaColumnGroupPB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.DeltaColumnGroupPB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (columnIdsBuilder_ == null) {
        columnIds_ = java.util.Collections.emptyList();
      } else {
        columnIds_ = null;
        columnIdsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      columnFiles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupPB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeltaColumnGroupPB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.DeltaColumnGroupPB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeltaColumnGroupPB build() {
      io.datafibre.fibre.proto.DeltaColumnGroupPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeltaColumnGroupPB buildPartial() {
      io.datafibre.fibre.proto.DeltaColumnGroupPB result = new io.datafibre.fibre.proto.DeltaColumnGroupPB(this);
      int from_bitField0_ = bitField0_;
      if (columnIdsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          columnIds_ = java.util.Collections.unmodifiableList(columnIds_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.columnIds_ = columnIds_;
      } else {
        result.columnIds_ = columnIdsBuilder_.build();
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        columnFiles_ = columnFiles_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.columnFiles_ = columnFiles_;
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
      if (other instanceof io.datafibre.fibre.proto.DeltaColumnGroupPB) {
        return mergeFrom((io.datafibre.fibre.proto.DeltaColumnGroupPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.DeltaColumnGroupPB other) {
      if (other == io.datafibre.fibre.proto.DeltaColumnGroupPB.getDefaultInstance()) return this;
      if (columnIdsBuilder_ == null) {
        if (!other.columnIds_.isEmpty()) {
          if (columnIds_.isEmpty()) {
            columnIds_ = other.columnIds_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureColumnIdsIsMutable();
            columnIds_.addAll(other.columnIds_);
          }
          onChanged();
        }
      } else {
        if (!other.columnIds_.isEmpty()) {
          if (columnIdsBuilder_.isEmpty()) {
            columnIdsBuilder_.dispose();
            columnIdsBuilder_ = null;
            columnIds_ = other.columnIds_;
            bitField0_ = (bitField0_ & ~0x00000001);
            columnIdsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getColumnIdsFieldBuilder() : null;
          } else {
            columnIdsBuilder_.addAllMessages(other.columnIds_);
          }
        }
      }
      if (!other.columnFiles_.isEmpty()) {
        if (columnFiles_.isEmpty()) {
          columnFiles_ = other.columnFiles_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureColumnFilesIsMutable();
          columnFiles_.addAll(other.columnFiles_);
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
              io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB m =
                  input.readMessage(
                      io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.PARSER,
                      extensionRegistry);
              if (columnIdsBuilder_ == null) {
                ensureColumnIdsIsMutable();
                columnIds_.add(m);
              } else {
                columnIdsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              ensureColumnFilesIsMutable();
              columnFiles_.add(bs);
              break;
            } // case 18
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

    private java.util.List<io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB> columnIds_ =
      java.util.Collections.emptyList();
    private void ensureColumnIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        columnIds_ = new java.util.ArrayList<io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB>(columnIds_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPBOrBuilder> columnIdsBuilder_;

    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB> getColumnIdsList() {
      if (columnIdsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(columnIds_);
      } else {
        return columnIdsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public int getColumnIdsCount() {
      if (columnIdsBuilder_ == null) {
        return columnIds_.size();
      } else {
        return columnIdsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB getColumnIds(int index) {
      if (columnIdsBuilder_ == null) {
        return columnIds_.get(index);
      } else {
        return columnIdsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder setColumnIds(
        int index, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB value) {
      if (columnIdsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureColumnIdsIsMutable();
        columnIds_.set(index, value);
        onChanged();
      } else {
        columnIdsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder setColumnIds(
        int index, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder builderForValue) {
      if (columnIdsBuilder_ == null) {
        ensureColumnIdsIsMutable();
        columnIds_.set(index, builderForValue.build());
        onChanged();
      } else {
        columnIdsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder addColumnIds(io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB value) {
      if (columnIdsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureColumnIdsIsMutable();
        columnIds_.add(value);
        onChanged();
      } else {
        columnIdsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder addColumnIds(
        int index, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB value) {
      if (columnIdsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureColumnIdsIsMutable();
        columnIds_.add(index, value);
        onChanged();
      } else {
        columnIdsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder addColumnIds(
        io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder builderForValue) {
      if (columnIdsBuilder_ == null) {
        ensureColumnIdsIsMutable();
        columnIds_.add(builderForValue.build());
        onChanged();
      } else {
        columnIdsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder addColumnIds(
        int index, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder builderForValue) {
      if (columnIdsBuilder_ == null) {
        ensureColumnIdsIsMutable();
        columnIds_.add(index, builderForValue.build());
        onChanged();
      } else {
        columnIdsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder addAllColumnIds(
        java.lang.Iterable<? extends io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB> values) {
      if (columnIdsBuilder_ == null) {
        ensureColumnIdsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, columnIds_);
        onChanged();
      } else {
        columnIdsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder clearColumnIds() {
      if (columnIdsBuilder_ == null) {
        columnIds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        columnIdsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public Builder removeColumnIds(int index) {
      if (columnIdsBuilder_ == null) {
        ensureColumnIdsIsMutable();
        columnIds_.remove(index);
        onChanged();
      } else {
        columnIdsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder getColumnIdsBuilder(
        int index) {
      return getColumnIdsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPBOrBuilder getColumnIdsOrBuilder(
        int index) {
      if (columnIdsBuilder_ == null) {
        return columnIds_.get(index);  } else {
        return columnIdsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public java.util.List<? extends io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPBOrBuilder>
         getColumnIdsOrBuilderList() {
      if (columnIdsBuilder_ != null) {
        return columnIdsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(columnIds_);
      }
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder addColumnIdsBuilder() {
      return getColumnIdsFieldBuilder().addBuilder(
          io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder addColumnIdsBuilder(
        int index) {
      return getColumnIdsFieldBuilder().addBuilder(
          index, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.DeltaColumnGroupColumnIdsPB column_ids = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder>
         getColumnIdsBuilderList() {
      return getColumnIdsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPBOrBuilder>
        getColumnIdsFieldBuilder() {
      if (columnIdsBuilder_ == null) {
        columnIdsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPB.Builder, io.datafibre.fibre.proto.DeltaColumnGroupColumnIdsPBOrBuilder>(
                columnIds_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        columnIds_ = null;
      }
      return columnIdsBuilder_;
    }

    private com.google.protobuf.LazyStringList columnFiles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureColumnFilesIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        columnFiles_ = new com.google.protobuf.LazyStringArrayList(columnFiles_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @return A list containing the columnFiles.
     */
    public com.google.protobuf.ProtocolStringList
        getColumnFilesList() {
      return columnFiles_.getUnmodifiableView();
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @return The count of columnFiles.
     */
    public int getColumnFilesCount() {
      return columnFiles_.size();
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @param index The index of the element to return.
     * @return The columnFiles at the given index.
     */
    public java.lang.String getColumnFiles(int index) {
      return columnFiles_.get(index);
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the columnFiles at the given index.
     */
    public com.google.protobuf.ByteString
        getColumnFilesBytes(int index) {
      return columnFiles_.getByteString(index);
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @param index The index to set the value at.
     * @param value The columnFiles to set.
     * @return This builder for chaining.
     */
    public Builder setColumnFiles(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureColumnFilesIsMutable();
      columnFiles_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @param value The columnFiles to add.
     * @return This builder for chaining.
     */
    public Builder addColumnFiles(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureColumnFilesIsMutable();
      columnFiles_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @param values The columnFiles to add.
     * @return This builder for chaining.
     */
    public Builder addAllColumnFiles(
        java.lang.Iterable<java.lang.String> values) {
      ensureColumnFilesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, columnFiles_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearColumnFiles() {
      columnFiles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string column_files = 2;</code>
     * @param value The bytes of the columnFiles to add.
     * @return This builder for chaining.
     */
    public Builder addColumnFilesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureColumnFilesIsMutable();
      columnFiles_.add(value);
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


    // @@protoc_insertion_point(builder_scope:starrocks.DeltaColumnGroupPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.DeltaColumnGroupPB)
  private static final io.datafibre.fibre.proto.DeltaColumnGroupPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.DeltaColumnGroupPB();
  }

  public static io.datafibre.fibre.proto.DeltaColumnGroupPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<DeltaColumnGroupPB>
      PARSER = new com.google.protobuf.AbstractParser<DeltaColumnGroupPB>() {
    @java.lang.Override
    public DeltaColumnGroupPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<DeltaColumnGroupPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeltaColumnGroupPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.DeltaColumnGroupPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
