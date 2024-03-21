// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.lake.DeleteDataRequest}
 */
public final class DeleteDataRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.lake.DeleteDataRequest)
    DeleteDataRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeleteDataRequest.newBuilder() to construct.
  private DeleteDataRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeleteDataRequest() {
    tabletIds_ = emptyLongList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DeleteDataRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteDataRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteDataRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.DeleteDataRequest.class, io.datafibre.fibre.proto.DeleteDataRequest.Builder.class);
  }

  private int bitField0_;
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

  public static final int TXN_ID_FIELD_NUMBER = 2;
  private long txnId_;
  /**
   * <code>optional int64 txn_id = 2;</code>
   * @return Whether the txnId field is set.
   */
  @java.lang.Override
  public boolean hasTxnId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional int64 txn_id = 2;</code>
   * @return The txnId.
   */
  @java.lang.Override
  public long getTxnId() {
    return txnId_;
  }

  public static final int DELETE_PREDICATE_FIELD_NUMBER = 3;
  private io.datafibre.fibre.proto.DeletePredicatePB deletePredicate_;
  /**
   * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
   * @return Whether the deletePredicate field is set.
   */
  @java.lang.Override
  public boolean hasDeletePredicate() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
   * @return The deletePredicate.
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.DeletePredicatePB getDeletePredicate() {
    return deletePredicate_ == null ? io.datafibre.fibre.proto.DeletePredicatePB.getDefaultInstance() : deletePredicate_;
  }
  /**
   * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.DeletePredicatePBOrBuilder getDeletePredicateOrBuilder() {
    return deletePredicate_ == null ? io.datafibre.fibre.proto.DeletePredicatePB.getDefaultInstance() : deletePredicate_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (hasDeletePredicate()) {
      if (!getDeletePredicate().isInitialized()) {
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
    for (int i = 0; i < tabletIds_.size(); i++) {
      output.writeInt64(1, tabletIds_.getLong(i));
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt64(2, txnId_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(3, getDeletePredicate());
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
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, txnId_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getDeletePredicate());
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
    if (!(obj instanceof io.datafibre.fibre.proto.DeleteDataRequest)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.DeleteDataRequest other = (io.datafibre.fibre.proto.DeleteDataRequest) obj;

    if (!getTabletIdsList()
        .equals(other.getTabletIdsList())) return false;
    if (hasTxnId() != other.hasTxnId()) return false;
    if (hasTxnId()) {
      if (getTxnId()
          != other.getTxnId()) return false;
    }
    if (hasDeletePredicate() != other.hasDeletePredicate()) return false;
    if (hasDeletePredicate()) {
      if (!getDeletePredicate()
          .equals(other.getDeletePredicate())) return false;
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
    if (getTabletIdsCount() > 0) {
      hash = (37 * hash) + TABLET_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getTabletIdsList().hashCode();
    }
    if (hasTxnId()) {
      hash = (37 * hash) + TXN_ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTxnId());
    }
    if (hasDeletePredicate()) {
      hash = (37 * hash) + DELETE_PREDICATE_FIELD_NUMBER;
      hash = (53 * hash) + getDeletePredicate().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DeleteDataRequest parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.DeleteDataRequest prototype) {
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
   * Protobuf type {@code starrocks.lake.DeleteDataRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.lake.DeleteDataRequest)
      io.datafibre.fibre.proto.DeleteDataRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteDataRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteDataRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.DeleteDataRequest.class, io.datafibre.fibre.proto.DeleteDataRequest.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.DeleteDataRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getDeletePredicateFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      tabletIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      txnId_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      if (deletePredicateBuilder_ == null) {
        deletePredicate_ = null;
      } else {
        deletePredicateBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_DeleteDataRequest_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeleteDataRequest getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.DeleteDataRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeleteDataRequest build() {
      io.datafibre.fibre.proto.DeleteDataRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DeleteDataRequest buildPartial() {
      io.datafibre.fibre.proto.DeleteDataRequest result = new io.datafibre.fibre.proto.DeleteDataRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        tabletIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.tabletIds_ = tabletIds_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.txnId_ = txnId_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        if (deletePredicateBuilder_ == null) {
          result.deletePredicate_ = deletePredicate_;
        } else {
          result.deletePredicate_ = deletePredicateBuilder_.build();
        }
        to_bitField0_ |= 0x00000002;
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
      if (other instanceof io.datafibre.fibre.proto.DeleteDataRequest) {
        return mergeFrom((io.datafibre.fibre.proto.DeleteDataRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.DeleteDataRequest other) {
      if (other == io.datafibre.fibre.proto.DeleteDataRequest.getDefaultInstance()) return this;
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
      if (other.hasTxnId()) {
        setTxnId(other.getTxnId());
      }
      if (other.hasDeletePredicate()) {
        mergeDeletePredicate(other.getDeletePredicate());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (hasDeletePredicate()) {
        if (!getDeletePredicate().isInitialized()) {
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
              txnId_ = input.readInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              input.readMessage(
                  getDeletePredicateFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
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

    private long txnId_ ;
    /**
     * <code>optional int64 txn_id = 2;</code>
     * @return Whether the txnId field is set.
     */
    @java.lang.Override
    public boolean hasTxnId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int64 txn_id = 2;</code>
     * @return The txnId.
     */
    @java.lang.Override
    public long getTxnId() {
      return txnId_;
    }
    /**
     * <code>optional int64 txn_id = 2;</code>
     * @param value The txnId to set.
     * @return This builder for chaining.
     */
    public Builder setTxnId(long value) {
      bitField0_ |= 0x00000002;
      txnId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 txn_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTxnId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      txnId_ = 0L;
      onChanged();
      return this;
    }

    private io.datafibre.fibre.proto.DeletePredicatePB deletePredicate_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.DeletePredicatePB, io.datafibre.fibre.proto.DeletePredicatePB.Builder, io.datafibre.fibre.proto.DeletePredicatePBOrBuilder> deletePredicateBuilder_;
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     * @return Whether the deletePredicate field is set.
     */
    public boolean hasDeletePredicate() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     * @return The deletePredicate.
     */
    public io.datafibre.fibre.proto.DeletePredicatePB getDeletePredicate() {
      if (deletePredicateBuilder_ == null) {
        return deletePredicate_ == null ? io.datafibre.fibre.proto.DeletePredicatePB.getDefaultInstance() : deletePredicate_;
      } else {
        return deletePredicateBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     */
    public Builder setDeletePredicate(io.datafibre.fibre.proto.DeletePredicatePB value) {
      if (deletePredicateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        deletePredicate_ = value;
        onChanged();
      } else {
        deletePredicateBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     */
    public Builder setDeletePredicate(
        io.datafibre.fibre.proto.DeletePredicatePB.Builder builderForValue) {
      if (deletePredicateBuilder_ == null) {
        deletePredicate_ = builderForValue.build();
        onChanged();
      } else {
        deletePredicateBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     */
    public Builder mergeDeletePredicate(io.datafibre.fibre.proto.DeletePredicatePB value) {
      if (deletePredicateBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
            deletePredicate_ != null &&
            deletePredicate_ != io.datafibre.fibre.proto.DeletePredicatePB.getDefaultInstance()) {
          deletePredicate_ =
            io.datafibre.fibre.proto.DeletePredicatePB.newBuilder(deletePredicate_).mergeFrom(value).buildPartial();
        } else {
          deletePredicate_ = value;
        }
        onChanged();
      } else {
        deletePredicateBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     */
    public Builder clearDeletePredicate() {
      if (deletePredicateBuilder_ == null) {
        deletePredicate_ = null;
        onChanged();
      } else {
        deletePredicateBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     */
    public io.datafibre.fibre.proto.DeletePredicatePB.Builder getDeletePredicateBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getDeletePredicateFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     */
    public io.datafibre.fibre.proto.DeletePredicatePBOrBuilder getDeletePredicateOrBuilder() {
      if (deletePredicateBuilder_ != null) {
        return deletePredicateBuilder_.getMessageOrBuilder();
      } else {
        return deletePredicate_ == null ?
            io.datafibre.fibre.proto.DeletePredicatePB.getDefaultInstance() : deletePredicate_;
      }
    }
    /**
     * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.DeletePredicatePB, io.datafibre.fibre.proto.DeletePredicatePB.Builder, io.datafibre.fibre.proto.DeletePredicatePBOrBuilder>
        getDeletePredicateFieldBuilder() {
      if (deletePredicateBuilder_ == null) {
        deletePredicateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.datafibre.fibre.proto.DeletePredicatePB, io.datafibre.fibre.proto.DeletePredicatePB.Builder, io.datafibre.fibre.proto.DeletePredicatePBOrBuilder>(
                getDeletePredicate(),
                getParentForChildren(),
                isClean());
        deletePredicate_ = null;
      }
      return deletePredicateBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.lake.DeleteDataRequest)
  }

  // @@protoc_insertion_point(class_scope:starrocks.lake.DeleteDataRequest)
  private static final io.datafibre.fibre.proto.DeleteDataRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.DeleteDataRequest();
  }

  public static io.datafibre.fibre.proto.DeleteDataRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<DeleteDataRequest>
      PARSER = new com.google.protobuf.AbstractParser<DeleteDataRequest>() {
    @java.lang.Override
    public DeleteDataRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<DeleteDataRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeleteDataRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.DeleteDataRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
