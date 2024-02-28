// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.PPulsarBacklogProxyRequest}
 */
public final class PPulsarBacklogProxyRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PPulsarBacklogProxyRequest)
    PPulsarBacklogProxyRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PPulsarBacklogProxyRequest.newBuilder() to construct.
  private PPulsarBacklogProxyRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PPulsarBacklogProxyRequest() {
    partitions_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PPulsarBacklogProxyRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PPulsarBacklogProxyRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PPulsarBacklogProxyRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PPulsarBacklogProxyRequest.class, io.datafibre.fibre.proto.PPulsarBacklogProxyRequest.Builder.class);
  }

  private int bitField0_;
  public static final int PULSAR_INFO_FIELD_NUMBER = 1;
  private io.datafibre.fibre.proto.PPulsarLoadInfo pulsarInfo_;
  /**
   * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
   * @return Whether the pulsarInfo field is set.
   */
  @java.lang.Override
  public boolean hasPulsarInfo() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
   * @return The pulsarInfo.
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PPulsarLoadInfo getPulsarInfo() {
    return pulsarInfo_ == null ? io.datafibre.fibre.proto.PPulsarLoadInfo.getDefaultInstance() : pulsarInfo_;
  }
  /**
   * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PPulsarLoadInfoOrBuilder getPulsarInfoOrBuilder() {
    return pulsarInfo_ == null ? io.datafibre.fibre.proto.PPulsarLoadInfo.getDefaultInstance() : pulsarInfo_;
  }

  public static final int PARTITIONS_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList partitions_;
  /**
   * <code>repeated string partitions = 2;</code>
   * @return A list containing the partitions.
   */
  public com.google.protobuf.ProtocolStringList
      getPartitionsList() {
    return partitions_;
  }
  /**
   * <code>repeated string partitions = 2;</code>
   * @return The count of partitions.
   */
  public int getPartitionsCount() {
    return partitions_.size();
  }
  /**
   * <code>repeated string partitions = 2;</code>
   * @param index The index of the element to return.
   * @return The partitions at the given index.
   */
  public java.lang.String getPartitions(int index) {
    return partitions_.get(index);
  }
  /**
   * <code>repeated string partitions = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the partitions at the given index.
   */
  public com.google.protobuf.ByteString
      getPartitionsBytes(int index) {
    return partitions_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (hasPulsarInfo()) {
      if (!getPulsarInfo().isInitialized()) {
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getPulsarInfo());
    }
    for (int i = 0; i < partitions_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, partitions_.getRaw(i));
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
        .computeMessageSize(1, getPulsarInfo());
    }
    {
      int dataSize = 0;
      for (int i = 0; i < partitions_.size(); i++) {
        dataSize += computeStringSizeNoTag(partitions_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getPartitionsList().size();
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
    if (!(obj instanceof io.datafibre.fibre.proto.PPulsarBacklogProxyRequest)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PPulsarBacklogProxyRequest other = (io.datafibre.fibre.proto.PPulsarBacklogProxyRequest) obj;

    if (hasPulsarInfo() != other.hasPulsarInfo()) return false;
    if (hasPulsarInfo()) {
      if (!getPulsarInfo()
          .equals(other.getPulsarInfo())) return false;
    }
    if (!getPartitionsList()
        .equals(other.getPartitionsList())) return false;
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
    if (hasPulsarInfo()) {
      hash = (37 * hash) + PULSAR_INFO_FIELD_NUMBER;
      hash = (53 * hash) + getPulsarInfo().hashCode();
    }
    if (getPartitionsCount() > 0) {
      hash = (37 * hash) + PARTITIONS_FIELD_NUMBER;
      hash = (53 * hash) + getPartitionsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PPulsarBacklogProxyRequest prototype) {
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
   * Protobuf type {@code starrocks.PPulsarBacklogProxyRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PPulsarBacklogProxyRequest)
      io.datafibre.fibre.proto.PPulsarBacklogProxyRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PPulsarBacklogProxyRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PPulsarBacklogProxyRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PPulsarBacklogProxyRequest.class, io.datafibre.fibre.proto.PPulsarBacklogProxyRequest.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PPulsarBacklogProxyRequest.newBuilder()
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
        getPulsarInfoFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (pulsarInfoBuilder_ == null) {
        pulsarInfo_ = null;
      } else {
        pulsarInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      partitions_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PPulsarBacklogProxyRequest_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PPulsarBacklogProxyRequest getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PPulsarBacklogProxyRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PPulsarBacklogProxyRequest build() {
      io.datafibre.fibre.proto.PPulsarBacklogProxyRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PPulsarBacklogProxyRequest buildPartial() {
      io.datafibre.fibre.proto.PPulsarBacklogProxyRequest result = new io.datafibre.fibre.proto.PPulsarBacklogProxyRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (pulsarInfoBuilder_ == null) {
          result.pulsarInfo_ = pulsarInfo_;
        } else {
          result.pulsarInfo_ = pulsarInfoBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        partitions_ = partitions_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.partitions_ = partitions_;
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
      if (other instanceof io.datafibre.fibre.proto.PPulsarBacklogProxyRequest) {
        return mergeFrom((io.datafibre.fibre.proto.PPulsarBacklogProxyRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PPulsarBacklogProxyRequest other) {
      if (other == io.datafibre.fibre.proto.PPulsarBacklogProxyRequest.getDefaultInstance()) return this;
      if (other.hasPulsarInfo()) {
        mergePulsarInfo(other.getPulsarInfo());
      }
      if (!other.partitions_.isEmpty()) {
        if (partitions_.isEmpty()) {
          partitions_ = other.partitions_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensurePartitionsIsMutable();
          partitions_.addAll(other.partitions_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (hasPulsarInfo()) {
        if (!getPulsarInfo().isInitialized()) {
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
              input.readMessage(
                  getPulsarInfoFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              ensurePartitionsIsMutable();
              partitions_.add(bs);
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

    private io.datafibre.fibre.proto.PPulsarLoadInfo pulsarInfo_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.PPulsarLoadInfo, io.datafibre.fibre.proto.PPulsarLoadInfo.Builder, io.datafibre.fibre.proto.PPulsarLoadInfoOrBuilder> pulsarInfoBuilder_;
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     * @return Whether the pulsarInfo field is set.
     */
    public boolean hasPulsarInfo() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     * @return The pulsarInfo.
     */
    public io.datafibre.fibre.proto.PPulsarLoadInfo getPulsarInfo() {
      if (pulsarInfoBuilder_ == null) {
        return pulsarInfo_ == null ? io.datafibre.fibre.proto.PPulsarLoadInfo.getDefaultInstance() : pulsarInfo_;
      } else {
        return pulsarInfoBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     */
    public Builder setPulsarInfo(io.datafibre.fibre.proto.PPulsarLoadInfo value) {
      if (pulsarInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        pulsarInfo_ = value;
        onChanged();
      } else {
        pulsarInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     */
    public Builder setPulsarInfo(
        io.datafibre.fibre.proto.PPulsarLoadInfo.Builder builderForValue) {
      if (pulsarInfoBuilder_ == null) {
        pulsarInfo_ = builderForValue.build();
        onChanged();
      } else {
        pulsarInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     */
    public Builder mergePulsarInfo(io.datafibre.fibre.proto.PPulsarLoadInfo value) {
      if (pulsarInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            pulsarInfo_ != null &&
            pulsarInfo_ != io.datafibre.fibre.proto.PPulsarLoadInfo.getDefaultInstance()) {
          pulsarInfo_ =
            io.datafibre.fibre.proto.PPulsarLoadInfo.newBuilder(pulsarInfo_).mergeFrom(value).buildPartial();
        } else {
          pulsarInfo_ = value;
        }
        onChanged();
      } else {
        pulsarInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     */
    public Builder clearPulsarInfo() {
      if (pulsarInfoBuilder_ == null) {
        pulsarInfo_ = null;
        onChanged();
      } else {
        pulsarInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     */
    public io.datafibre.fibre.proto.PPulsarLoadInfo.Builder getPulsarInfoBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getPulsarInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     */
    public io.datafibre.fibre.proto.PPulsarLoadInfoOrBuilder getPulsarInfoOrBuilder() {
      if (pulsarInfoBuilder_ != null) {
        return pulsarInfoBuilder_.getMessageOrBuilder();
      } else {
        return pulsarInfo_ == null ?
            io.datafibre.fibre.proto.PPulsarLoadInfo.getDefaultInstance() : pulsarInfo_;
      }
    }
    /**
     * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.PPulsarLoadInfo, io.datafibre.fibre.proto.PPulsarLoadInfo.Builder, io.datafibre.fibre.proto.PPulsarLoadInfoOrBuilder>
        getPulsarInfoFieldBuilder() {
      if (pulsarInfoBuilder_ == null) {
        pulsarInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.datafibre.fibre.proto.PPulsarLoadInfo, io.datafibre.fibre.proto.PPulsarLoadInfo.Builder, io.datafibre.fibre.proto.PPulsarLoadInfoOrBuilder>(
                getPulsarInfo(),
                getParentForChildren(),
                isClean());
        pulsarInfo_ = null;
      }
      return pulsarInfoBuilder_;
    }

    private com.google.protobuf.LazyStringList partitions_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensurePartitionsIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        partitions_ = new com.google.protobuf.LazyStringArrayList(partitions_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @return A list containing the partitions.
     */
    public com.google.protobuf.ProtocolStringList
        getPartitionsList() {
      return partitions_.getUnmodifiableView();
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @return The count of partitions.
     */
    public int getPartitionsCount() {
      return partitions_.size();
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @param index The index of the element to return.
     * @return The partitions at the given index.
     */
    public java.lang.String getPartitions(int index) {
      return partitions_.get(index);
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the partitions at the given index.
     */
    public com.google.protobuf.ByteString
        getPartitionsBytes(int index) {
      return partitions_.getByteString(index);
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @param index The index to set the value at.
     * @param value The partitions to set.
     * @return This builder for chaining.
     */
    public Builder setPartitions(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePartitionsIsMutable();
      partitions_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @param value The partitions to add.
     * @return This builder for chaining.
     */
    public Builder addPartitions(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePartitionsIsMutable();
      partitions_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @param values The partitions to add.
     * @return This builder for chaining.
     */
    public Builder addAllPartitions(
        java.lang.Iterable<java.lang.String> values) {
      ensurePartitionsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, partitions_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPartitions() {
      partitions_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string partitions = 2;</code>
     * @param value The bytes of the partitions to add.
     * @return This builder for chaining.
     */
    public Builder addPartitionsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePartitionsIsMutable();
      partitions_.add(value);
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


    // @@protoc_insertion_point(builder_scope:starrocks.PPulsarBacklogProxyRequest)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PPulsarBacklogProxyRequest)
  private static final io.datafibre.fibre.proto.PPulsarBacklogProxyRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PPulsarBacklogProxyRequest();
  }

  public static io.datafibre.fibre.proto.PPulsarBacklogProxyRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PPulsarBacklogProxyRequest>
      PARSER = new com.google.protobuf.AbstractParser<PPulsarBacklogProxyRequest>() {
    @java.lang.Override
    public PPulsarBacklogProxyRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<PPulsarBacklogProxyRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PPulsarBacklogProxyRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PPulsarBacklogProxyRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

