// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.lake.PublishLogVersionResponse}
 */
public final class PublishLogVersionResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.lake.PublishLogVersionResponse)
    PublishLogVersionResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PublishLogVersionResponse.newBuilder() to construct.
  private PublishLogVersionResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PublishLogVersionResponse() {
    failedTablets_ = emptyLongList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PublishLogVersionResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_PublishLogVersionResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_PublishLogVersionResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PublishLogVersionResponse.class, io.datafibre.fibre.proto.PublishLogVersionResponse.Builder.class);
  }

  public static final int FAILED_TABLETS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.LongList failedTablets_;
  /**
   * <code>repeated int64 failed_tablets = 1;</code>
   * @return A list containing the failedTablets.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getFailedTabletsList() {
    return failedTablets_;
  }
  /**
   * <code>repeated int64 failed_tablets = 1;</code>
   * @return The count of failedTablets.
   */
  public int getFailedTabletsCount() {
    return failedTablets_.size();
  }
  /**
   * <code>repeated int64 failed_tablets = 1;</code>
   * @param index The index of the element to return.
   * @return The failedTablets at the given index.
   */
  public long getFailedTablets(int index) {
    return failedTablets_.getLong(index);
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
    for (int i = 0; i < failedTablets_.size(); i++) {
      output.writeInt64(1, failedTablets_.getLong(i));
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
      for (int i = 0; i < failedTablets_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(failedTablets_.getLong(i));
      }
      size += dataSize;
      size += 1 * getFailedTabletsList().size();
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
    if (!(obj instanceof io.datafibre.fibre.proto.PublishLogVersionResponse)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PublishLogVersionResponse other = (io.datafibre.fibre.proto.PublishLogVersionResponse) obj;

    if (!getFailedTabletsList()
        .equals(other.getFailedTabletsList())) return false;
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
    if (getFailedTabletsCount() > 0) {
      hash = (37 * hash) + FAILED_TABLETS_FIELD_NUMBER;
      hash = (53 * hash) + getFailedTabletsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PublishLogVersionResponse parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PublishLogVersionResponse prototype) {
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
   * Protobuf type {@code starrocks.lake.PublishLogVersionResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.lake.PublishLogVersionResponse)
      io.datafibre.fibre.proto.PublishLogVersionResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_PublishLogVersionResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_PublishLogVersionResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PublishLogVersionResponse.class, io.datafibre.fibre.proto.PublishLogVersionResponse.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PublishLogVersionResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      failedTablets_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_PublishLogVersionResponse_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PublishLogVersionResponse getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PublishLogVersionResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PublishLogVersionResponse build() {
      io.datafibre.fibre.proto.PublishLogVersionResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PublishLogVersionResponse buildPartial() {
      io.datafibre.fibre.proto.PublishLogVersionResponse result = new io.datafibre.fibre.proto.PublishLogVersionResponse(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        failedTablets_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.failedTablets_ = failedTablets_;
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
      if (other instanceof io.datafibre.fibre.proto.PublishLogVersionResponse) {
        return mergeFrom((io.datafibre.fibre.proto.PublishLogVersionResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PublishLogVersionResponse other) {
      if (other == io.datafibre.fibre.proto.PublishLogVersionResponse.getDefaultInstance()) return this;
      if (!other.failedTablets_.isEmpty()) {
        if (failedTablets_.isEmpty()) {
          failedTablets_ = other.failedTablets_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureFailedTabletsIsMutable();
          failedTablets_.addAll(other.failedTablets_);
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
              ensureFailedTabletsIsMutable();
              failedTablets_.addLong(v);
              break;
            } // case 8
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureFailedTabletsIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                failedTablets_.addLong(input.readInt64());
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

    private com.google.protobuf.Internal.LongList failedTablets_ = emptyLongList();
    private void ensureFailedTabletsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        failedTablets_ = mutableCopy(failedTablets_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int64 failed_tablets = 1;</code>
     * @return A list containing the failedTablets.
     */
    public java.util.List<java.lang.Long>
        getFailedTabletsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(failedTablets_) : failedTablets_;
    }
    /**
     * <code>repeated int64 failed_tablets = 1;</code>
     * @return The count of failedTablets.
     */
    public int getFailedTabletsCount() {
      return failedTablets_.size();
    }
    /**
     * <code>repeated int64 failed_tablets = 1;</code>
     * @param index The index of the element to return.
     * @return The failedTablets at the given index.
     */
    public long getFailedTablets(int index) {
      return failedTablets_.getLong(index);
    }
    /**
     * <code>repeated int64 failed_tablets = 1;</code>
     * @param index The index to set the value at.
     * @param value The failedTablets to set.
     * @return This builder for chaining.
     */
    public Builder setFailedTablets(
        int index, long value) {
      ensureFailedTabletsIsMutable();
      failedTablets_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 failed_tablets = 1;</code>
     * @param value The failedTablets to add.
     * @return This builder for chaining.
     */
    public Builder addFailedTablets(long value) {
      ensureFailedTabletsIsMutable();
      failedTablets_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 failed_tablets = 1;</code>
     * @param values The failedTablets to add.
     * @return This builder for chaining.
     */
    public Builder addAllFailedTablets(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureFailedTabletsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, failedTablets_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 failed_tablets = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFailedTablets() {
      failedTablets_ = emptyLongList();
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


    // @@protoc_insertion_point(builder_scope:starrocks.lake.PublishLogVersionResponse)
  }

  // @@protoc_insertion_point(class_scope:starrocks.lake.PublishLogVersionResponse)
  private static final io.datafibre.fibre.proto.PublishLogVersionResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PublishLogVersionResponse();
  }

  public static io.datafibre.fibre.proto.PublishLogVersionResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PublishLogVersionResponse>
      PARSER = new com.google.protobuf.AbstractParser<PublishLogVersionResponse>() {
    @java.lang.Override
    public PublishLogVersionResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<PublishLogVersionResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PublishLogVersionResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PublishLogVersionResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
