// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.PTabletWithPartition}
 */
public final class PTabletWithPartition extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PTabletWithPartition)
    PTabletWithPartitionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PTabletWithPartition.newBuilder() to construct.
  private PTabletWithPartition(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PTabletWithPartition() {
    replicas_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PTabletWithPartition();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTabletWithPartition_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTabletWithPartition_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PTabletWithPartition.class, io.datafibre.fibre.proto.PTabletWithPartition.Builder.class);
  }

  private int bitField0_;
  public static final int PARTITION_ID_FIELD_NUMBER = 1;
  private long partitionId_;
  /**
   * <code>required int64 partition_id = 1;</code>
   * @return Whether the partitionId field is set.
   */
  @java.lang.Override
  public boolean hasPartitionId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required int64 partition_id = 1;</code>
   * @return The partitionId.
   */
  @java.lang.Override
  public long getPartitionId() {
    return partitionId_;
  }

  public static final int TABLET_ID_FIELD_NUMBER = 2;
  private long tabletId_;
  /**
   * <code>required int64 tablet_id = 2;</code>
   * @return Whether the tabletId field is set.
   */
  @java.lang.Override
  public boolean hasTabletId() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>required int64 tablet_id = 2;</code>
   * @return The tabletId.
   */
  @java.lang.Override
  public long getTabletId() {
    return tabletId_;
  }

  public static final int REPLICAS_FIELD_NUMBER = 3;
  private java.util.List<io.datafibre.fibre.proto.PNetworkAddress> replicas_;
  /**
   * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
   */
  @java.lang.Override
  public java.util.List<io.datafibre.fibre.proto.PNetworkAddress> getReplicasList() {
    return replicas_;
  }
  /**
   * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.datafibre.fibre.proto.PNetworkAddressOrBuilder>
      getReplicasOrBuilderList() {
    return replicas_;
  }
  /**
   * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
   */
  @java.lang.Override
  public int getReplicasCount() {
    return replicas_.size();
  }
  /**
   * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PNetworkAddress getReplicas(int index) {
    return replicas_.get(index);
  }
  /**
   * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PNetworkAddressOrBuilder getReplicasOrBuilder(
      int index) {
    return replicas_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasPartitionId()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasTabletId()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt64(1, partitionId_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt64(2, tabletId_);
    }
    for (int i = 0; i < replicas_.size(); i++) {
      output.writeMessage(3, replicas_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, partitionId_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, tabletId_);
    }
    for (int i = 0; i < replicas_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, replicas_.get(i));
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
    if (!(obj instanceof io.datafibre.fibre.proto.PTabletWithPartition)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PTabletWithPartition other = (io.datafibre.fibre.proto.PTabletWithPartition) obj;

    if (hasPartitionId() != other.hasPartitionId()) return false;
    if (hasPartitionId()) {
      if (getPartitionId()
          != other.getPartitionId()) return false;
    }
    if (hasTabletId() != other.hasTabletId()) return false;
    if (hasTabletId()) {
      if (getTabletId()
          != other.getTabletId()) return false;
    }
    if (!getReplicasList()
        .equals(other.getReplicasList())) return false;
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
    if (hasPartitionId()) {
      hash = (37 * hash) + PARTITION_ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getPartitionId());
    }
    if (hasTabletId()) {
      hash = (37 * hash) + TABLET_ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTabletId());
    }
    if (getReplicasCount() > 0) {
      hash = (37 * hash) + REPLICAS_FIELD_NUMBER;
      hash = (53 * hash) + getReplicasList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PTabletWithPartition parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PTabletWithPartition prototype) {
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
   * Protobuf type {@code starrocks.PTabletWithPartition}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PTabletWithPartition)
      io.datafibre.fibre.proto.PTabletWithPartitionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTabletWithPartition_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTabletWithPartition_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PTabletWithPartition.class, io.datafibre.fibre.proto.PTabletWithPartition.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PTabletWithPartition.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      partitionId_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      tabletId_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      if (replicasBuilder_ == null) {
        replicas_ = java.util.Collections.emptyList();
      } else {
        replicas_ = null;
        replicasBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTabletWithPartition_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PTabletWithPartition getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PTabletWithPartition.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PTabletWithPartition build() {
      io.datafibre.fibre.proto.PTabletWithPartition result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PTabletWithPartition buildPartial() {
      io.datafibre.fibre.proto.PTabletWithPartition result = new io.datafibre.fibre.proto.PTabletWithPartition(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.partitionId_ = partitionId_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.tabletId_ = tabletId_;
        to_bitField0_ |= 0x00000002;
      }
      if (replicasBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          replicas_ = java.util.Collections.unmodifiableList(replicas_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.replicas_ = replicas_;
      } else {
        result.replicas_ = replicasBuilder_.build();
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
      if (other instanceof io.datafibre.fibre.proto.PTabletWithPartition) {
        return mergeFrom((io.datafibre.fibre.proto.PTabletWithPartition)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PTabletWithPartition other) {
      if (other == io.datafibre.fibre.proto.PTabletWithPartition.getDefaultInstance()) return this;
      if (other.hasPartitionId()) {
        setPartitionId(other.getPartitionId());
      }
      if (other.hasTabletId()) {
        setTabletId(other.getTabletId());
      }
      if (replicasBuilder_ == null) {
        if (!other.replicas_.isEmpty()) {
          if (replicas_.isEmpty()) {
            replicas_ = other.replicas_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureReplicasIsMutable();
            replicas_.addAll(other.replicas_);
          }
          onChanged();
        }
      } else {
        if (!other.replicas_.isEmpty()) {
          if (replicasBuilder_.isEmpty()) {
            replicasBuilder_.dispose();
            replicasBuilder_ = null;
            replicas_ = other.replicas_;
            bitField0_ = (bitField0_ & ~0x00000004);
            replicasBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getReplicasFieldBuilder() : null;
          } else {
            replicasBuilder_.addAllMessages(other.replicas_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasPartitionId()) {
        return false;
      }
      if (!hasTabletId()) {
        return false;
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
              partitionId_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              tabletId_ = input.readInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              io.datafibre.fibre.proto.PNetworkAddress m =
                  input.readMessage(
                      io.datafibre.fibre.proto.PNetworkAddress.PARSER,
                      extensionRegistry);
              if (replicasBuilder_ == null) {
                ensureReplicasIsMutable();
                replicas_.add(m);
              } else {
                replicasBuilder_.addMessage(m);
              }
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

    private long partitionId_ ;
    /**
     * <code>required int64 partition_id = 1;</code>
     * @return Whether the partitionId field is set.
     */
    @java.lang.Override
    public boolean hasPartitionId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required int64 partition_id = 1;</code>
     * @return The partitionId.
     */
    @java.lang.Override
    public long getPartitionId() {
      return partitionId_;
    }
    /**
     * <code>required int64 partition_id = 1;</code>
     * @param value The partitionId to set.
     * @return This builder for chaining.
     */
    public Builder setPartitionId(long value) {
      bitField0_ |= 0x00000001;
      partitionId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int64 partition_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPartitionId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      partitionId_ = 0L;
      onChanged();
      return this;
    }

    private long tabletId_ ;
    /**
     * <code>required int64 tablet_id = 2;</code>
     * @return Whether the tabletId field is set.
     */
    @java.lang.Override
    public boolean hasTabletId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required int64 tablet_id = 2;</code>
     * @return The tabletId.
     */
    @java.lang.Override
    public long getTabletId() {
      return tabletId_;
    }
    /**
     * <code>required int64 tablet_id = 2;</code>
     * @param value The tabletId to set.
     * @return This builder for chaining.
     */
    public Builder setTabletId(long value) {
      bitField0_ |= 0x00000002;
      tabletId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int64 tablet_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTabletId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      tabletId_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<io.datafibre.fibre.proto.PNetworkAddress> replicas_ =
      java.util.Collections.emptyList();
    private void ensureReplicasIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        replicas_ = new java.util.ArrayList<io.datafibre.fibre.proto.PNetworkAddress>(replicas_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PNetworkAddress, io.datafibre.fibre.proto.PNetworkAddress.Builder, io.datafibre.fibre.proto.PNetworkAddressOrBuilder> replicasBuilder_;

    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PNetworkAddress> getReplicasList() {
      if (replicasBuilder_ == null) {
        return java.util.Collections.unmodifiableList(replicas_);
      } else {
        return replicasBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public int getReplicasCount() {
      if (replicasBuilder_ == null) {
        return replicas_.size();
      } else {
        return replicasBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public io.datafibre.fibre.proto.PNetworkAddress getReplicas(int index) {
      if (replicasBuilder_ == null) {
        return replicas_.get(index);
      } else {
        return replicasBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder setReplicas(
        int index, io.datafibre.fibre.proto.PNetworkAddress value) {
      if (replicasBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReplicasIsMutable();
        replicas_.set(index, value);
        onChanged();
      } else {
        replicasBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder setReplicas(
        int index, io.datafibre.fibre.proto.PNetworkAddress.Builder builderForValue) {
      if (replicasBuilder_ == null) {
        ensureReplicasIsMutable();
        replicas_.set(index, builderForValue.build());
        onChanged();
      } else {
        replicasBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder addReplicas(io.datafibre.fibre.proto.PNetworkAddress value) {
      if (replicasBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReplicasIsMutable();
        replicas_.add(value);
        onChanged();
      } else {
        replicasBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder addReplicas(
        int index, io.datafibre.fibre.proto.PNetworkAddress value) {
      if (replicasBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReplicasIsMutable();
        replicas_.add(index, value);
        onChanged();
      } else {
        replicasBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder addReplicas(
        io.datafibre.fibre.proto.PNetworkAddress.Builder builderForValue) {
      if (replicasBuilder_ == null) {
        ensureReplicasIsMutable();
        replicas_.add(builderForValue.build());
        onChanged();
      } else {
        replicasBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder addReplicas(
        int index, io.datafibre.fibre.proto.PNetworkAddress.Builder builderForValue) {
      if (replicasBuilder_ == null) {
        ensureReplicasIsMutable();
        replicas_.add(index, builderForValue.build());
        onChanged();
      } else {
        replicasBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder addAllReplicas(
        java.lang.Iterable<? extends io.datafibre.fibre.proto.PNetworkAddress> values) {
      if (replicasBuilder_ == null) {
        ensureReplicasIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, replicas_);
        onChanged();
      } else {
        replicasBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder clearReplicas() {
      if (replicasBuilder_ == null) {
        replicas_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        replicasBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public Builder removeReplicas(int index) {
      if (replicasBuilder_ == null) {
        ensureReplicasIsMutable();
        replicas_.remove(index);
        onChanged();
      } else {
        replicasBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public io.datafibre.fibre.proto.PNetworkAddress.Builder getReplicasBuilder(
        int index) {
      return getReplicasFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public io.datafibre.fibre.proto.PNetworkAddressOrBuilder getReplicasOrBuilder(
        int index) {
      if (replicasBuilder_ == null) {
        return replicas_.get(index);  } else {
        return replicasBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public java.util.List<? extends io.datafibre.fibre.proto.PNetworkAddressOrBuilder>
         getReplicasOrBuilderList() {
      if (replicasBuilder_ != null) {
        return replicasBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(replicas_);
      }
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public io.datafibre.fibre.proto.PNetworkAddress.Builder addReplicasBuilder() {
      return getReplicasFieldBuilder().addBuilder(
          io.datafibre.fibre.proto.PNetworkAddress.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public io.datafibre.fibre.proto.PNetworkAddress.Builder addReplicasBuilder(
        int index) {
      return getReplicasFieldBuilder().addBuilder(
          index, io.datafibre.fibre.proto.PNetworkAddress.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PNetworkAddress replicas = 3;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PNetworkAddress.Builder>
         getReplicasBuilderList() {
      return getReplicasFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PNetworkAddress, io.datafibre.fibre.proto.PNetworkAddress.Builder, io.datafibre.fibre.proto.PNetworkAddressOrBuilder>
        getReplicasFieldBuilder() {
      if (replicasBuilder_ == null) {
        replicasBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.datafibre.fibre.proto.PNetworkAddress, io.datafibre.fibre.proto.PNetworkAddress.Builder, io.datafibre.fibre.proto.PNetworkAddressOrBuilder>(
                replicas_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        replicas_ = null;
      }
      return replicasBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PTabletWithPartition)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PTabletWithPartition)
  private static final io.datafibre.fibre.proto.PTabletWithPartition DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PTabletWithPartition();
  }

  public static io.datafibre.fibre.proto.PTabletWithPartition getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PTabletWithPartition>
      PARSER = new com.google.protobuf.AbstractParser<PTabletWithPartition>() {
    @java.lang.Override
    public PTabletWithPartition parsePartialFrom(
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

  public static com.google.protobuf.Parser<PTabletWithPartition> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PTabletWithPartition> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PTabletWithPartition getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
