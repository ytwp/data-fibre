// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.PTriggerProfileReportRequest}
 */
public final class PTriggerProfileReportRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PTriggerProfileReportRequest)
    PTriggerProfileReportRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PTriggerProfileReportRequest.newBuilder() to construct.
  private PTriggerProfileReportRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PTriggerProfileReportRequest() {
    instanceIds_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PTriggerProfileReportRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTriggerProfileReportRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTriggerProfileReportRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PTriggerProfileReportRequest.class, io.datafibre.fibre.proto.PTriggerProfileReportRequest.Builder.class);
  }

  private int bitField0_;
  public static final int INSTANCE_IDS_FIELD_NUMBER = 1;
  private java.util.List<io.datafibre.fibre.proto.PUniqueId> instanceIds_;
  /**
   * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.datafibre.fibre.proto.PUniqueId> getInstanceIdsList() {
    return instanceIds_;
  }
  /**
   * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.datafibre.fibre.proto.PUniqueIdOrBuilder>
      getInstanceIdsOrBuilderList() {
    return instanceIds_;
  }
  /**
   * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
   */
  @java.lang.Override
  public int getInstanceIdsCount() {
    return instanceIds_.size();
  }
  /**
   * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PUniqueId getInstanceIds(int index) {
    return instanceIds_.get(index);
  }
  /**
   * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PUniqueIdOrBuilder getInstanceIdsOrBuilder(
      int index) {
    return instanceIds_.get(index);
  }

  public static final int QUERY_ID_FIELD_NUMBER = 2;
  private io.datafibre.fibre.proto.PUniqueId queryId_;
  /**
   * <code>optional .starrocks.PUniqueId query_id = 2;</code>
   * @return Whether the queryId field is set.
   */
  @java.lang.Override
  public boolean hasQueryId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .starrocks.PUniqueId query_id = 2;</code>
   * @return The queryId.
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PUniqueId getQueryId() {
    return queryId_ == null ? io.datafibre.fibre.proto.PUniqueId.getDefaultInstance() : queryId_;
  }
  /**
   * <code>optional .starrocks.PUniqueId query_id = 2;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PUniqueIdOrBuilder getQueryIdOrBuilder() {
    return queryId_ == null ? io.datafibre.fibre.proto.PUniqueId.getDefaultInstance() : queryId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    for (int i = 0; i < getInstanceIdsCount(); i++) {
      if (!getInstanceIds(i).isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    if (hasQueryId()) {
      if (!getQueryId().isInitialized()) {
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
    for (int i = 0; i < instanceIds_.size(); i++) {
      output.writeMessage(1, instanceIds_.get(i));
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getQueryId());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < instanceIds_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, instanceIds_.get(i));
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getQueryId());
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
    if (!(obj instanceof io.datafibre.fibre.proto.PTriggerProfileReportRequest)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PTriggerProfileReportRequest other = (io.datafibre.fibre.proto.PTriggerProfileReportRequest) obj;

    if (!getInstanceIdsList()
        .equals(other.getInstanceIdsList())) return false;
    if (hasQueryId() != other.hasQueryId()) return false;
    if (hasQueryId()) {
      if (!getQueryId()
          .equals(other.getQueryId())) return false;
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
    if (getInstanceIdsCount() > 0) {
      hash = (37 * hash) + INSTANCE_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getInstanceIdsList().hashCode();
    }
    if (hasQueryId()) {
      hash = (37 * hash) + QUERY_ID_FIELD_NUMBER;
      hash = (53 * hash) + getQueryId().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PTriggerProfileReportRequest prototype) {
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
   * Protobuf type {@code starrocks.PTriggerProfileReportRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PTriggerProfileReportRequest)
      io.datafibre.fibre.proto.PTriggerProfileReportRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTriggerProfileReportRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTriggerProfileReportRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PTriggerProfileReportRequest.class, io.datafibre.fibre.proto.PTriggerProfileReportRequest.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PTriggerProfileReportRequest.newBuilder()
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
        getInstanceIdsFieldBuilder();
        getQueryIdFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (instanceIdsBuilder_ == null) {
        instanceIds_ = java.util.Collections.emptyList();
      } else {
        instanceIds_ = null;
        instanceIdsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      if (queryIdBuilder_ == null) {
        queryId_ = null;
      } else {
        queryIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PTriggerProfileReportRequest_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PTriggerProfileReportRequest getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PTriggerProfileReportRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PTriggerProfileReportRequest build() {
      io.datafibre.fibre.proto.PTriggerProfileReportRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PTriggerProfileReportRequest buildPartial() {
      io.datafibre.fibre.proto.PTriggerProfileReportRequest result = new io.datafibre.fibre.proto.PTriggerProfileReportRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (instanceIdsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          instanceIds_ = java.util.Collections.unmodifiableList(instanceIds_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.instanceIds_ = instanceIds_;
      } else {
        result.instanceIds_ = instanceIdsBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        if (queryIdBuilder_ == null) {
          result.queryId_ = queryId_;
        } else {
          result.queryId_ = queryIdBuilder_.build();
        }
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
      if (other instanceof io.datafibre.fibre.proto.PTriggerProfileReportRequest) {
        return mergeFrom((io.datafibre.fibre.proto.PTriggerProfileReportRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PTriggerProfileReportRequest other) {
      if (other == io.datafibre.fibre.proto.PTriggerProfileReportRequest.getDefaultInstance()) return this;
      if (instanceIdsBuilder_ == null) {
        if (!other.instanceIds_.isEmpty()) {
          if (instanceIds_.isEmpty()) {
            instanceIds_ = other.instanceIds_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureInstanceIdsIsMutable();
            instanceIds_.addAll(other.instanceIds_);
          }
          onChanged();
        }
      } else {
        if (!other.instanceIds_.isEmpty()) {
          if (instanceIdsBuilder_.isEmpty()) {
            instanceIdsBuilder_.dispose();
            instanceIdsBuilder_ = null;
            instanceIds_ = other.instanceIds_;
            bitField0_ = (bitField0_ & ~0x00000001);
            instanceIdsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getInstanceIdsFieldBuilder() : null;
          } else {
            instanceIdsBuilder_.addAllMessages(other.instanceIds_);
          }
        }
      }
      if (other.hasQueryId()) {
        mergeQueryId(other.getQueryId());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      for (int i = 0; i < getInstanceIdsCount(); i++) {
        if (!getInstanceIds(i).isInitialized()) {
          return false;
        }
      }
      if (hasQueryId()) {
        if (!getQueryId().isInitialized()) {
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
              io.datafibre.fibre.proto.PUniqueId m =
                  input.readMessage(
                      io.datafibre.fibre.proto.PUniqueId.PARSER,
                      extensionRegistry);
              if (instanceIdsBuilder_ == null) {
                ensureInstanceIdsIsMutable();
                instanceIds_.add(m);
              } else {
                instanceIdsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getQueryIdFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
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

    private java.util.List<io.datafibre.fibre.proto.PUniqueId> instanceIds_ =
      java.util.Collections.emptyList();
    private void ensureInstanceIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        instanceIds_ = new java.util.ArrayList<io.datafibre.fibre.proto.PUniqueId>(instanceIds_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PUniqueId, io.datafibre.fibre.proto.PUniqueId.Builder, io.datafibre.fibre.proto.PUniqueIdOrBuilder> instanceIdsBuilder_;

    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PUniqueId> getInstanceIdsList() {
      if (instanceIdsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(instanceIds_);
      } else {
        return instanceIdsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public int getInstanceIdsCount() {
      if (instanceIdsBuilder_ == null) {
        return instanceIds_.size();
      } else {
        return instanceIdsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.PUniqueId getInstanceIds(int index) {
      if (instanceIdsBuilder_ == null) {
        return instanceIds_.get(index);
      } else {
        return instanceIdsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder setInstanceIds(
        int index, io.datafibre.fibre.proto.PUniqueId value) {
      if (instanceIdsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInstanceIdsIsMutable();
        instanceIds_.set(index, value);
        onChanged();
      } else {
        instanceIdsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder setInstanceIds(
        int index, io.datafibre.fibre.proto.PUniqueId.Builder builderForValue) {
      if (instanceIdsBuilder_ == null) {
        ensureInstanceIdsIsMutable();
        instanceIds_.set(index, builderForValue.build());
        onChanged();
      } else {
        instanceIdsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder addInstanceIds(io.datafibre.fibre.proto.PUniqueId value) {
      if (instanceIdsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInstanceIdsIsMutable();
        instanceIds_.add(value);
        onChanged();
      } else {
        instanceIdsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder addInstanceIds(
        int index, io.datafibre.fibre.proto.PUniqueId value) {
      if (instanceIdsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInstanceIdsIsMutable();
        instanceIds_.add(index, value);
        onChanged();
      } else {
        instanceIdsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder addInstanceIds(
        io.datafibre.fibre.proto.PUniqueId.Builder builderForValue) {
      if (instanceIdsBuilder_ == null) {
        ensureInstanceIdsIsMutable();
        instanceIds_.add(builderForValue.build());
        onChanged();
      } else {
        instanceIdsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder addInstanceIds(
        int index, io.datafibre.fibre.proto.PUniqueId.Builder builderForValue) {
      if (instanceIdsBuilder_ == null) {
        ensureInstanceIdsIsMutable();
        instanceIds_.add(index, builderForValue.build());
        onChanged();
      } else {
        instanceIdsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder addAllInstanceIds(
        java.lang.Iterable<? extends io.datafibre.fibre.proto.PUniqueId> values) {
      if (instanceIdsBuilder_ == null) {
        ensureInstanceIdsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, instanceIds_);
        onChanged();
      } else {
        instanceIdsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder clearInstanceIds() {
      if (instanceIdsBuilder_ == null) {
        instanceIds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        instanceIdsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public Builder removeInstanceIds(int index) {
      if (instanceIdsBuilder_ == null) {
        ensureInstanceIdsIsMutable();
        instanceIds_.remove(index);
        onChanged();
      } else {
        instanceIdsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.PUniqueId.Builder getInstanceIdsBuilder(
        int index) {
      return getInstanceIdsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.PUniqueIdOrBuilder getInstanceIdsOrBuilder(
        int index) {
      if (instanceIdsBuilder_ == null) {
        return instanceIds_.get(index);  } else {
        return instanceIdsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public java.util.List<? extends io.datafibre.fibre.proto.PUniqueIdOrBuilder>
         getInstanceIdsOrBuilderList() {
      if (instanceIdsBuilder_ != null) {
        return instanceIdsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(instanceIds_);
      }
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.PUniqueId.Builder addInstanceIdsBuilder() {
      return getInstanceIdsFieldBuilder().addBuilder(
          io.datafibre.fibre.proto.PUniqueId.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public io.datafibre.fibre.proto.PUniqueId.Builder addInstanceIdsBuilder(
        int index) {
      return getInstanceIdsFieldBuilder().addBuilder(
          index, io.datafibre.fibre.proto.PUniqueId.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PUniqueId instance_ids = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PUniqueId.Builder>
         getInstanceIdsBuilderList() {
      return getInstanceIdsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PUniqueId, io.datafibre.fibre.proto.PUniqueId.Builder, io.datafibre.fibre.proto.PUniqueIdOrBuilder>
        getInstanceIdsFieldBuilder() {
      if (instanceIdsBuilder_ == null) {
        instanceIdsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.datafibre.fibre.proto.PUniqueId, io.datafibre.fibre.proto.PUniqueId.Builder, io.datafibre.fibre.proto.PUniqueIdOrBuilder>(
                instanceIds_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        instanceIds_ = null;
      }
      return instanceIdsBuilder_;
    }

    private io.datafibre.fibre.proto.PUniqueId queryId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.PUniqueId, io.datafibre.fibre.proto.PUniqueId.Builder, io.datafibre.fibre.proto.PUniqueIdOrBuilder> queryIdBuilder_;
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     * @return Whether the queryId field is set.
     */
    public boolean hasQueryId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     * @return The queryId.
     */
    public io.datafibre.fibre.proto.PUniqueId getQueryId() {
      if (queryIdBuilder_ == null) {
        return queryId_ == null ? io.datafibre.fibre.proto.PUniqueId.getDefaultInstance() : queryId_;
      } else {
        return queryIdBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     */
    public Builder setQueryId(io.datafibre.fibre.proto.PUniqueId value) {
      if (queryIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        queryId_ = value;
        onChanged();
      } else {
        queryIdBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     */
    public Builder setQueryId(
        io.datafibre.fibre.proto.PUniqueId.Builder builderForValue) {
      if (queryIdBuilder_ == null) {
        queryId_ = builderForValue.build();
        onChanged();
      } else {
        queryIdBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     */
    public Builder mergeQueryId(io.datafibre.fibre.proto.PUniqueId value) {
      if (queryIdBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
            queryId_ != null &&
            queryId_ != io.datafibre.fibre.proto.PUniqueId.getDefaultInstance()) {
          queryId_ =
            io.datafibre.fibre.proto.PUniqueId.newBuilder(queryId_).mergeFrom(value).buildPartial();
        } else {
          queryId_ = value;
        }
        onChanged();
      } else {
        queryIdBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     */
    public Builder clearQueryId() {
      if (queryIdBuilder_ == null) {
        queryId_ = null;
        onChanged();
      } else {
        queryIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     */
    public io.datafibre.fibre.proto.PUniqueId.Builder getQueryIdBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getQueryIdFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     */
    public io.datafibre.fibre.proto.PUniqueIdOrBuilder getQueryIdOrBuilder() {
      if (queryIdBuilder_ != null) {
        return queryIdBuilder_.getMessageOrBuilder();
      } else {
        return queryId_ == null ?
            io.datafibre.fibre.proto.PUniqueId.getDefaultInstance() : queryId_;
      }
    }
    /**
     * <code>optional .starrocks.PUniqueId query_id = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.PUniqueId, io.datafibre.fibre.proto.PUniqueId.Builder, io.datafibre.fibre.proto.PUniqueIdOrBuilder>
        getQueryIdFieldBuilder() {
      if (queryIdBuilder_ == null) {
        queryIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.datafibre.fibre.proto.PUniqueId, io.datafibre.fibre.proto.PUniqueId.Builder, io.datafibre.fibre.proto.PUniqueIdOrBuilder>(
                getQueryId(),
                getParentForChildren(),
                isClean());
        queryId_ = null;
      }
      return queryIdBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PTriggerProfileReportRequest)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PTriggerProfileReportRequest)
  private static final io.datafibre.fibre.proto.PTriggerProfileReportRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PTriggerProfileReportRequest();
  }

  public static io.datafibre.fibre.proto.PTriggerProfileReportRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PTriggerProfileReportRequest>
      PARSER = new com.google.protobuf.AbstractParser<PTriggerProfileReportRequest>() {
    @java.lang.Override
    public PTriggerProfileReportRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<PTriggerProfileReportRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PTriggerProfileReportRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PTriggerProfileReportRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

