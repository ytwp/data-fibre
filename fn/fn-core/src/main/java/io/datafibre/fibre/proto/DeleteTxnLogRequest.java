// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.lake.DeleteTxnLogRequest}
 */
public final class DeleteTxnLogRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.lake.DeleteTxnLogRequest)
    DeleteTxnLogRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeleteTxnLogRequest.newBuilder() to construct.
  private DeleteTxnLogRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeleteTxnLogRequest() {
    tabletIds_ = emptyLongList();
    txnIds_ = emptyLongList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DeleteTxnLogRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteTxnLogRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteTxnLogRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.DeleteTxnLogRequest.class, io.datafibre.fibre.proto.DeleteTxnLogRequest.Builder.class);
  }

  public static final int TABLET_IDS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.LongList tabletIds_;
  /**
   * <code>repeated int64 tablet_ids = 1;</code>
   * @return A list containing the tabletIds.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getTabletIdsList() {
    return tabletIds_;
  }
  /**
   * <code>repeated int64 tablet_ids = 1;</code>
   * @return The count of tabletIds.
   */
  public int getTabletIdsCount() {
    return tabletIds_.size();
  }
  /**
   * <code>repeated int64 tablet_ids = 1;</code>
   * @param index The index of the element to return.
   * @return The tabletIds at the given index.
   */
  public long getTabletIds(int index) {
    return tabletIds_.getLong(index);
  }

  public static final int TXN_IDS_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.LongList txnIds_;
  /**
   * <code>repeated int64 txn_ids = 2;</code>
   * @return A list containing the txnIds.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getTxnIdsList() {
    return txnIds_;
  }
  /**
   * <code>repeated int64 txn_ids = 2;</code>
   * @return The count of txnIds.
   */
  public int getTxnIdsCount() {
    return txnIds_.size();
  }
  /**
   * <code>repeated int64 txn_ids = 2;</code>
   * @param index The index of the element to return.
   * @return The txnIds at the given index.
   */
  public long getTxnIds(int index) {
    return txnIds_.getLong(index);
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
    for (int i = 0; i < tabletIds_.size(); i++) {
      output.writeInt64(1, tabletIds_.getLong(i));
    }
    for (int i = 0; i < txnIds_.size(); i++) {
      output.writeInt64(2, txnIds_.getLong(i));
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
      for (int i = 0; i < tabletIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(tabletIds_.getLong(i));
      }
      size += dataSize;
      size += 1 * getTabletIdsList().size();
    }
    {
      int dataSize = 0;
      for (int i = 0; i < txnIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(txnIds_.getLong(i));
      }
      size += dataSize;
      size += 1 * getTxnIdsList().size();
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
    if (!(obj instanceof io.datafibre.fibre.proto.DeleteTxnLogRequest)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.DeleteTxnLogRequest other = (io.datafibre.fibre.proto.DeleteTxnLogRequest) obj;

    if (!getTabletIdsList()
        .equals(other.getTabletIdsList())) return false;
    if (!getTxnIdsList()
        .equals(other.getTxnIdsList())) return false;
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
    if (getTabletIdsCount() > 0) {
      hash = (37 * hash) + TABLET_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getTabletIdsList().hashCode();
    }
    if (getTxnIdsCount() > 0) {
      hash = (37 * hash) + TXN_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getTxnIdsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeleteTxnLogRequest parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.DeleteTxnLogRequest prototype) {
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
   * Protobuf type {@code starrocks.lake.DeleteTxnLogRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.lake.DeleteTxnLogRequest)
      io.datafibre.fibre.proto.DeleteTxnLogRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteTxnLogRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteTxnLogRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.DeleteTxnLogRequest.class, io.datafibre.fibre.proto.DeleteTxnLogRequest.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.DeleteTxnLogRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      tabletIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      txnIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteTxnLogRequest_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeleteTxnLogRequest getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.DeleteTxnLogRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeleteTxnLogRequest build() {
      io.datafibre.fibre.proto.DeleteTxnLogRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeleteTxnLogRequest buildPartial() {
      io.datafibre.fibre.proto.DeleteTxnLogRequest result = new io.datafibre.fibre.proto.DeleteTxnLogRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        tabletIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.tabletIds_ = tabletIds_;
      if (((bitField0_ & 0x00000002) != 0)) {
        txnIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.txnIds_ = txnIds_;
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
      if (other instanceof io.datafibre.fibre.proto.DeleteTxnLogRequest) {
        return mergeFrom((io.datafibre.fibre.proto.DeleteTxnLogRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.DeleteTxnLogRequest other) {
      if (other == io.datafibre.fibre.proto.DeleteTxnLogRequest.getDefaultInstance()) return this;
      if (!other.tabletIds_.isEmpty()) {
        if (tabletIds_.isEmpty()) {
          tabletIds_ = other.tabletIds_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureTabletIdsIsMutable();
          tabletIds_.addAll(other.tabletIds_);
        }
        onChanged();
      }
      if (!other.txnIds_.isEmpty()) {
        if (txnIds_.isEmpty()) {
          txnIds_ = other.txnIds_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureTxnIdsIsMutable();
          txnIds_.addAll(other.txnIds_);
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
              long v = input.readInt64();
              ensureTabletIdsIsMutable();
              tabletIds_.addLong(v);
              break;
            } // case 8
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureTabletIdsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                tabletIds_.addLong(input.readInt64());
              }
              input.popLimit(limit);
              break;
            } // case 10
            case 16: {
              long v = input.readInt64();
              ensureTxnIdsIsMutable();
              txnIds_.addLong(v);
              break;
            } // case 16
            case 18: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureTxnIdsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                txnIds_.addLong(input.readInt64());
              }
              input.popLimit(limit);
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

    private com.google.protobuf.Internal.LongList tabletIds_ = emptyLongList();
    private void ensureTabletIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        tabletIds_ = mutableCopy(tabletIds_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int64 tablet_ids = 1;</code>
     * @return A list containing the tabletIds.
     */
    public java.util.List<java.lang.Long>
        getTabletIdsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(tabletIds_) : tabletIds_;
    }
    /**
     * <code>repeated int64 tablet_ids = 1;</code>
     * @return The count of tabletIds.
     */
    public int getTabletIdsCount() {
      return tabletIds_.size();
    }
    /**
     * <code>repeated int64 tablet_ids = 1;</code>
     * @param index The index of the element to return.
     * @return The tabletIds at the given index.
     */
    public long getTabletIds(int index) {
      return tabletIds_.getLong(index);
    }
    /**
     * <code>repeated int64 tablet_ids = 1;</code>
     * @param index The index to set the value at.
     * @param value The tabletIds to set.
     * @return This builder for chaining.
     */
    public Builder setTabletIds(
        int index, long value) {
      ensureTabletIdsIsMutable();
      tabletIds_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 tablet_ids = 1;</code>
     * @param value The tabletIds to add.
     * @return This builder for chaining.
     */
    public Builder addTabletIds(long value) {
      ensureTabletIdsIsMutable();
      tabletIds_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 tablet_ids = 1;</code>
     * @param values The tabletIds to add.
     * @return This builder for chaining.
     */
    public Builder addAllTabletIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureTabletIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, tabletIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 tablet_ids = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTabletIds() {
      tabletIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private com.google.protobuf.Internal.LongList txnIds_ = emptyLongList();
    private void ensureTxnIdsIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        txnIds_ = mutableCopy(txnIds_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated int64 txn_ids = 2;</code>
     * @return A list containing the txnIds.
     */
    public java.util.List<java.lang.Long>
        getTxnIdsList() {
      return ((bitField0_ & 0x00000002) != 0) ?
               java.util.Collections.unmodifiableList(txnIds_) : txnIds_;
    }
    /**
     * <code>repeated int64 txn_ids = 2;</code>
     * @return The count of txnIds.
     */
    public int getTxnIdsCount() {
      return txnIds_.size();
    }
    /**
     * <code>repeated int64 txn_ids = 2;</code>
     * @param index The index of the element to return.
     * @return The txnIds at the given index.
     */
    public long getTxnIds(int index) {
      return txnIds_.getLong(index);
    }
    /**
     * <code>repeated int64 txn_ids = 2;</code>
     * @param index The index to set the value at.
     * @param value The txnIds to set.
     * @return This builder for chaining.
     */
    public Builder setTxnIds(
        int index, long value) {
      ensureTxnIdsIsMutable();
      txnIds_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 txn_ids = 2;</code>
     * @param value The txnIds to add.
     * @return This builder for chaining.
     */
    public Builder addTxnIds(long value) {
      ensureTxnIdsIsMutable();
      txnIds_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 txn_ids = 2;</code>
     * @param values The txnIds to add.
     * @return This builder for chaining.
     */
    public Builder addAllTxnIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureTxnIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, txnIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 txn_ids = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTxnIds() {
      txnIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000002);
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


    // @@protoc_insertion_point(builder_scope:starrocks.lake.DeleteTxnLogRequest)
  }

  // @@protoc_insertion_point(class_scope:starrocks.lake.DeleteTxnLogRequest)
  private static final io.datafibre.fibre.proto.DeleteTxnLogRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.DeleteTxnLogRequest();
  }

  public static io.datafibre.fibre.proto.DeleteTxnLogRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<DeleteTxnLogRequest>
      PARSER = new com.google.protobuf.AbstractParser<DeleteTxnLogRequest>() {
    @java.lang.Override
    public DeleteTxnLogRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<DeleteTxnLogRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeleteTxnLogRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.DeleteTxnLogRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

