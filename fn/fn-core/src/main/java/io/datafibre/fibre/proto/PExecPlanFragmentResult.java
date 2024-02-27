// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.PExecPlanFragmentResult}
 */
public final class PExecPlanFragmentResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PExecPlanFragmentResult)
    PExecPlanFragmentResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PExecPlanFragmentResult.newBuilder() to construct.
  private PExecPlanFragmentResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PExecPlanFragmentResult() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PExecPlanFragmentResult();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PExecPlanFragmentResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PExecPlanFragmentResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.PExecPlanFragmentResult.class, com.starrocks.proto.PExecPlanFragmentResult.Builder.class);
  }

  private int bitField0_;
  public static final int STATUS_FIELD_NUMBER = 1;
  private com.starrocks.proto.StatusPB status_;
  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   * @return Whether the status field is set.
   */
  @java.lang.Override
  public boolean hasStatus() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   * @return The status.
   */
  @java.lang.Override
  public com.starrocks.proto.StatusPB getStatus() {
    return status_ == null ? com.starrocks.proto.StatusPB.getDefaultInstance() : status_;
  }
  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.StatusPBOrBuilder getStatusOrBuilder() {
    return status_ == null ? com.starrocks.proto.StatusPB.getDefaultInstance() : status_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasStatus()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getStatus().isInitialized()) {
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
    if (!(obj instanceof com.starrocks.proto.PExecPlanFragmentResult)) {
      return super.equals(obj);
    }
    com.starrocks.proto.PExecPlanFragmentResult other = (com.starrocks.proto.PExecPlanFragmentResult) obj;

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

  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PExecPlanFragmentResult parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.PExecPlanFragmentResult prototype) {
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
   * Protobuf type {@code starrocks.PExecPlanFragmentResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PExecPlanFragmentResult)
      com.starrocks.proto.PExecPlanFragmentResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PExecPlanFragmentResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PExecPlanFragmentResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.PExecPlanFragmentResult.class, com.starrocks.proto.PExecPlanFragmentResult.Builder.class);
    }

    // Construct using com.starrocks.proto.PExecPlanFragmentResult.newBuilder()
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
      return com.starrocks.proto.InternalService.internal_static_starrocks_PExecPlanFragmentResult_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.PExecPlanFragmentResult getDefaultInstanceForType() {
      return com.starrocks.proto.PExecPlanFragmentResult.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.PExecPlanFragmentResult build() {
      com.starrocks.proto.PExecPlanFragmentResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.PExecPlanFragmentResult buildPartial() {
      com.starrocks.proto.PExecPlanFragmentResult result = new com.starrocks.proto.PExecPlanFragmentResult(this);
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
      if (other instanceof com.starrocks.proto.PExecPlanFragmentResult) {
        return mergeFrom((com.starrocks.proto.PExecPlanFragmentResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.PExecPlanFragmentResult other) {
      if (other == com.starrocks.proto.PExecPlanFragmentResult.getDefaultInstance()) return this;
      if (other.hasStatus()) {
        mergeStatus(other.getStatus());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasStatus()) {
        return false;
      }
      if (!getStatus().isInitialized()) {
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

    private com.starrocks.proto.StatusPB status_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.StatusPB, com.starrocks.proto.StatusPB.Builder, com.starrocks.proto.StatusPBOrBuilder> statusBuilder_;
    /**
     * <code>required .starrocks.StatusPB status = 1;</code>
     * @return Whether the status field is set.
     */
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required .starrocks.StatusPB status = 1;</code>
     * @return The status.
     */
    public com.starrocks.proto.StatusPB getStatus() {
      if (statusBuilder_ == null) {
        return status_ == null ? com.starrocks.proto.StatusPB.getDefaultInstance() : status_;
      } else {
        return statusBuilder_.getMessage();
      }
    }
    /**
     * <code>required .starrocks.StatusPB status = 1;</code>
     */
    public Builder setStatus(com.starrocks.proto.StatusPB value) {
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
     * <code>required .starrocks.StatusPB status = 1;</code>
     */
    public Builder setStatus(
        com.starrocks.proto.StatusPB.Builder builderForValue) {
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
     * <code>required .starrocks.StatusPB status = 1;</code>
     */
    public Builder mergeStatus(com.starrocks.proto.StatusPB value) {
      if (statusBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            status_ != null &&
            status_ != com.starrocks.proto.StatusPB.getDefaultInstance()) {
          status_ =
            com.starrocks.proto.StatusPB.newBuilder(status_).mergeFrom(value).buildPartial();
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
     * <code>required .starrocks.StatusPB status = 1;</code>
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
     * <code>required .starrocks.StatusPB status = 1;</code>
     */
    public com.starrocks.proto.StatusPB.Builder getStatusBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getStatusFieldBuilder().getBuilder();
    }
    /**
     * <code>required .starrocks.StatusPB status = 1;</code>
     */
    public com.starrocks.proto.StatusPBOrBuilder getStatusOrBuilder() {
      if (statusBuilder_ != null) {
        return statusBuilder_.getMessageOrBuilder();
      } else {
        return status_ == null ?
            com.starrocks.proto.StatusPB.getDefaultInstance() : status_;
      }
    }
    /**
     * <code>required .starrocks.StatusPB status = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.StatusPB, com.starrocks.proto.StatusPB.Builder, com.starrocks.proto.StatusPBOrBuilder> 
        getStatusFieldBuilder() {
      if (statusBuilder_ == null) {
        statusBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.starrocks.proto.StatusPB, com.starrocks.proto.StatusPB.Builder, com.starrocks.proto.StatusPBOrBuilder>(
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


    // @@protoc_insertion_point(builder_scope:starrocks.PExecPlanFragmentResult)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PExecPlanFragmentResult)
  private static final com.starrocks.proto.PExecPlanFragmentResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.PExecPlanFragmentResult();
  }

  public static com.starrocks.proto.PExecPlanFragmentResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PExecPlanFragmentResult>
      PARSER = new com.google.protobuf.AbstractParser<PExecPlanFragmentResult>() {
    @java.lang.Override
    public PExecPlanFragmentResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<PExecPlanFragmentResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PExecPlanFragmentResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.PExecPlanFragmentResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

