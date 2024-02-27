// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_common.proto

package com.starrocks.proto;

/**
 * <pre>
 * used in partial update for primary key tablet
 * </pre>
 *
 * Protobuf type {@code starrocks.DeltaColumnGroupColumnIdsPB}
 */
public final class DeltaColumnGroupColumnIdsPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.DeltaColumnGroupColumnIdsPB)
    DeltaColumnGroupColumnIdsPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeltaColumnGroupColumnIdsPB.newBuilder() to construct.
  private DeltaColumnGroupColumnIdsPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeltaColumnGroupColumnIdsPB() {
    columnIds_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DeltaColumnGroupColumnIdsPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupColumnIdsPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupColumnIdsPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.DeltaColumnGroupColumnIdsPB.class, com.starrocks.proto.DeltaColumnGroupColumnIdsPB.Builder.class);
  }

  public static final int COLUMN_IDS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.IntList columnIds_;
  /**
   * <code>repeated uint32 column_ids = 1;</code>
   * @return A list containing the columnIds.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getColumnIdsList() {
    return columnIds_;
  }
  /**
   * <code>repeated uint32 column_ids = 1;</code>
   * @return The count of columnIds.
   */
  public int getColumnIdsCount() {
    return columnIds_.size();
  }
  /**
   * <code>repeated uint32 column_ids = 1;</code>
   * @param index The index of the element to return.
   * @return The columnIds at the given index.
   */
  public int getColumnIds(int index) {
    return columnIds_.getInt(index);
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
      output.writeUInt32(1, columnIds_.getInt(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < columnIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt32SizeNoTag(columnIds_.getInt(i));
      }
      size += dataSize;
      size += 1 * getColumnIdsList().size();
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
    if (!(obj instanceof com.starrocks.proto.DeltaColumnGroupColumnIdsPB)) {
      return super.equals(obj);
    }
    com.starrocks.proto.DeltaColumnGroupColumnIdsPB other = (com.starrocks.proto.DeltaColumnGroupColumnIdsPB) obj;

    if (!getColumnIdsList()
        .equals(other.getColumnIdsList())) return false;
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
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.DeltaColumnGroupColumnIdsPB prototype) {
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
   * <pre>
   * used in partial update for primary key tablet
   * </pre>
   *
   * Protobuf type {@code starrocks.DeltaColumnGroupColumnIdsPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.DeltaColumnGroupColumnIdsPB)
      com.starrocks.proto.DeltaColumnGroupColumnIdsPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupColumnIdsPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupColumnIdsPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.DeltaColumnGroupColumnIdsPB.class, com.starrocks.proto.DeltaColumnGroupColumnIdsPB.Builder.class);
    }

    // Construct using com.starrocks.proto.DeltaColumnGroupColumnIdsPB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      columnIds_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.OlapCommon.internal_static_starrocks_DeltaColumnGroupColumnIdsPB_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.DeltaColumnGroupColumnIdsPB getDefaultInstanceForType() {
      return com.starrocks.proto.DeltaColumnGroupColumnIdsPB.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.DeltaColumnGroupColumnIdsPB build() {
      com.starrocks.proto.DeltaColumnGroupColumnIdsPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.DeltaColumnGroupColumnIdsPB buildPartial() {
      com.starrocks.proto.DeltaColumnGroupColumnIdsPB result = new com.starrocks.proto.DeltaColumnGroupColumnIdsPB(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        columnIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.columnIds_ = columnIds_;
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
      if (other instanceof com.starrocks.proto.DeltaColumnGroupColumnIdsPB) {
        return mergeFrom((com.starrocks.proto.DeltaColumnGroupColumnIdsPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.DeltaColumnGroupColumnIdsPB other) {
      if (other == com.starrocks.proto.DeltaColumnGroupColumnIdsPB.getDefaultInstance()) return this;
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
            case 8: {
              int v = input.readUInt32();
              ensureColumnIdsIsMutable();
              columnIds_.addInt(v);
              break;
            } // case 8
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureColumnIdsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                columnIds_.addInt(input.readUInt32());
              }
              input.popLimit(limit);
              break;
            } // case 10
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

    private com.google.protobuf.Internal.IntList columnIds_ = emptyIntList();
    private void ensureColumnIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        columnIds_ = mutableCopy(columnIds_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated uint32 column_ids = 1;</code>
     * @return A list containing the columnIds.
     */
    public java.util.List<java.lang.Integer>
        getColumnIdsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(columnIds_) : columnIds_;
    }
    /**
     * <code>repeated uint32 column_ids = 1;</code>
     * @return The count of columnIds.
     */
    public int getColumnIdsCount() {
      return columnIds_.size();
    }
    /**
     * <code>repeated uint32 column_ids = 1;</code>
     * @param index The index of the element to return.
     * @return The columnIds at the given index.
     */
    public int getColumnIds(int index) {
      return columnIds_.getInt(index);
    }
    /**
     * <code>repeated uint32 column_ids = 1;</code>
     * @param index The index to set the value at.
     * @param value The columnIds to set.
     * @return This builder for chaining.
     */
    public Builder setColumnIds(
        int index, int value) {
      ensureColumnIdsIsMutable();
      columnIds_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint32 column_ids = 1;</code>
     * @param value The columnIds to add.
     * @return This builder for chaining.
     */
    public Builder addColumnIds(int value) {
      ensureColumnIdsIsMutable();
      columnIds_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint32 column_ids = 1;</code>
     * @param values The columnIds to add.
     * @return This builder for chaining.
     */
    public Builder addAllColumnIds(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureColumnIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, columnIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint32 column_ids = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearColumnIds() {
      columnIds_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:starrocks.DeltaColumnGroupColumnIdsPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.DeltaColumnGroupColumnIdsPB)
  private static final com.starrocks.proto.DeltaColumnGroupColumnIdsPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.DeltaColumnGroupColumnIdsPB();
  }

  public static com.starrocks.proto.DeltaColumnGroupColumnIdsPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<DeltaColumnGroupColumnIdsPB>
      PARSER = new com.google.protobuf.AbstractParser<DeltaColumnGroupColumnIdsPB>() {
    @java.lang.Override
    public DeltaColumnGroupColumnIdsPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<DeltaColumnGroupColumnIdsPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeltaColumnGroupColumnIdsPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.DeltaColumnGroupColumnIdsPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

