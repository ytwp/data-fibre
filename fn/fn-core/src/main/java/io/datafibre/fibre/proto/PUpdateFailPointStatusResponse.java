// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.PUpdateFailPointStatusResponse}
 */
public final class PUpdateFailPointStatusResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PUpdateFailPointStatusResponse)
    PUpdateFailPointStatusResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PUpdateFailPointStatusResponse.newBuilder() to construct.
  private PUpdateFailPointStatusResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PUpdateFailPointStatusResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PUpdateFailPointStatusResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PUpdateFailPointStatusResponse.class, io.datafibre.fibre.proto.PUpdateFailPointStatusResponse.Builder.class);
  }

  private int bitField0_;
  public static final int STATUS_FIELD_NUMBER = 1;
  private io.datafibre.fibre.proto.StatusPB status_;
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return Whether the status field is set.
   */
  @java.lang.Override
  public boolean hasStatus() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return The status.
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.StatusPB getStatus() {
    return status_ == null ? io.datafibre.fibre.proto.StatusPB.getDefaultInstance() : status_;
  }
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.StatusPBOrBuilder getStatusOrBuilder() {
    return status_ == null ? io.datafibre.fibre.proto.StatusPB.getDefaultInstance() : status_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (hasStatus()) {
      if (!getStatus().isInitialized()) {
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
      output.writeMessage(1, getStatus());
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
        .computeMessageSize(1, getStatus());
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
    if (!(obj instanceof io.datafibre.fibre.proto.PUpdateFailPointStatusResponse)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PUpdateFailPointStatusResponse other = (io.datafibre.fibre.proto.PUpdateFailPointStatusResponse) obj;

    if (hasStatus() != other.hasStatus()) return false;
    if (hasStatus()) {
      if (!getStatus()
          .equals(other.getStatus())) return false;
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
    if (hasStatus()) {
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatus().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PUpdateFailPointStatusResponse prototype) {
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
   * Protobuf type {@code starrocks.PUpdateFailPointStatusResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PUpdateFailPointStatusResponse)
      io.datafibre.fibre.proto.PUpdateFailPointStatusResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PUpdateFailPointStatusResponse.class, io.datafibre.fibre.proto.PUpdateFailPointStatusResponse.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PUpdateFailPointStatusResponse.newBuilder()
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
        getStatusFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (statusBuilder_ == null) {
        status_ = null;
      } else {
        statusBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusResponse_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PUpdateFailPointStatusResponse getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PUpdateFailPointStatusResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PUpdateFailPointStatusResponse build() {
      io.datafibre.fibre.proto.PUpdateFailPointStatusResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PUpdateFailPointStatusResponse buildPartial() {
      io.datafibre.fibre.proto.PUpdateFailPointStatusResponse result = new io.datafibre.fibre.proto.PUpdateFailPointStatusResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (statusBuilder_ == null) {
          result.status_ = status_;
        } else {
          result.status_ = statusBuilder_.build();
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
      if (other instanceof io.datafibre.fibre.proto.PUpdateFailPointStatusResponse) {
        return mergeFrom((io.datafibre.fibre.proto.PUpdateFailPointStatusResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PUpdateFailPointStatusResponse other) {
      if (other == io.datafibre.fibre.proto.PUpdateFailPointStatusResponse.getDefaultInstance()) return this;
      if (other.hasStatus()) {
        mergeStatus(other.getStatus());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (hasStatus()) {
        if (!getStatus().isInitialized()) {
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
                  getStatusFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
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

    private io.datafibre.fibre.proto.StatusPB status_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.StatusPB, io.datafibre.fibre.proto.StatusPB.Builder, io.datafibre.fibre.proto.StatusPBOrBuilder> statusBuilder_;
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     * @return Whether the status field is set.
     */
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     * @return The status.
     */
    public io.datafibre.fibre.proto.StatusPB getStatus() {
      if (statusBuilder_ == null) {
        return status_ == null ? io.datafibre.fibre.proto.StatusPB.getDefaultInstance() : status_;
      } else {
        return statusBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     */
    public Builder setStatus(io.datafibre.fibre.proto.StatusPB value) {
      if (statusBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        status_ = value;
        onChanged();
      } else {
        statusBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     */
    public Builder setStatus(
        io.datafibre.fibre.proto.StatusPB.Builder builderForValue) {
      if (statusBuilder_ == null) {
        status_ = builderForValue.build();
        onChanged();
      } else {
        statusBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     */
    public Builder mergeStatus(io.datafibre.fibre.proto.StatusPB value) {
      if (statusBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            status_ != null &&
            status_ != io.datafibre.fibre.proto.StatusPB.getDefaultInstance()) {
          status_ =
            io.datafibre.fibre.proto.StatusPB.newBuilder(status_).mergeFrom(value).buildPartial();
        } else {
          status_ = value;
        }
        onChanged();
      } else {
        statusBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     */
    public Builder clearStatus() {
      if (statusBuilder_ == null) {
        status_ = null;
        onChanged();
      } else {
        statusBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     */
    public io.datafibre.fibre.proto.StatusPB.Builder getStatusBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getStatusFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     */
    public io.datafibre.fibre.proto.StatusPBOrBuilder getStatusOrBuilder() {
      if (statusBuilder_ != null) {
        return statusBuilder_.getMessageOrBuilder();
      } else {
        return status_ == null ?
            io.datafibre.fibre.proto.StatusPB.getDefaultInstance() : status_;
      }
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.StatusPB, io.datafibre.fibre.proto.StatusPB.Builder, io.datafibre.fibre.proto.StatusPBOrBuilder>
        getStatusFieldBuilder() {
      if (statusBuilder_ == null) {
        statusBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.datafibre.fibre.proto.StatusPB, io.datafibre.fibre.proto.StatusPB.Builder, io.datafibre.fibre.proto.StatusPBOrBuilder>(
                getStatus(),
                getParentForChildren(),
                isClean());
        status_ = null;
      }
      return statusBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PUpdateFailPointStatusResponse)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PUpdateFailPointStatusResponse)
  private static final io.datafibre.fibre.proto.PUpdateFailPointStatusResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PUpdateFailPointStatusResponse();
  }

  public static io.datafibre.fibre.proto.PUpdateFailPointStatusResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PUpdateFailPointStatusResponse>
      PARSER = new com.google.protobuf.AbstractParser<PUpdateFailPointStatusResponse>() {
    @java.lang.Override
    public PUpdateFailPointStatusResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<PUpdateFailPointStatusResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PUpdateFailPointStatusResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PUpdateFailPointStatusResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

