// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.PFetchDataRequest}
 */
public final class PFetchDataRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PFetchDataRequest)
    PFetchDataRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PFetchDataRequest.newBuilder() to construct.
  private PFetchDataRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PFetchDataRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PFetchDataRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PFetchDataRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PFetchDataRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.PFetchDataRequest.class, com.starrocks.proto.PFetchDataRequest.Builder.class);
  }

  private int bitField0_;
  public static final int FINST_ID_FIELD_NUMBER = 1;
  private com.starrocks.proto.PUniqueId finstId_;
  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return Whether the finstId field is set.
   */
  @java.lang.Override
  public boolean hasFinstId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return The finstId.
   */
  @java.lang.Override
  public com.starrocks.proto.PUniqueId getFinstId() {
    return finstId_ == null ? com.starrocks.proto.PUniqueId.getDefaultInstance() : finstId_;
  }
  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.PUniqueIdOrBuilder getFinstIdOrBuilder() {
    return finstId_ == null ? com.starrocks.proto.PUniqueId.getDefaultInstance() : finstId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasFinstId()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getFinstId().isInitialized()) {
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
      output.writeMessage(1, getFinstId());
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
        .computeMessageSize(1, getFinstId());
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
    if (!(obj instanceof com.starrocks.proto.PFetchDataRequest)) {
      return super.equals(obj);
    }
    com.starrocks.proto.PFetchDataRequest other = (com.starrocks.proto.PFetchDataRequest) obj;

    if (hasFinstId() != other.hasFinstId()) return false;
    if (hasFinstId()) {
      if (!getFinstId()
          .equals(other.getFinstId())) return false;
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
    if (hasFinstId()) {
      hash = (37 * hash) + FINST_ID_FIELD_NUMBER;
      hash = (53 * hash) + getFinstId().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.PFetchDataRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PFetchDataRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PFetchDataRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PFetchDataRequest parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.PFetchDataRequest prototype) {
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
   * Protobuf type {@code starrocks.PFetchDataRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PFetchDataRequest)
      com.starrocks.proto.PFetchDataRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PFetchDataRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PFetchDataRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.PFetchDataRequest.class, com.starrocks.proto.PFetchDataRequest.Builder.class);
    }

    // Construct using com.starrocks.proto.PFetchDataRequest.newBuilder()
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
        getFinstIdFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (finstIdBuilder_ == null) {
        finstId_ = null;
      } else {
        finstIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PFetchDataRequest_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.PFetchDataRequest getDefaultInstanceForType() {
      return com.starrocks.proto.PFetchDataRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.PFetchDataRequest build() {
      com.starrocks.proto.PFetchDataRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.PFetchDataRequest buildPartial() {
      com.starrocks.proto.PFetchDataRequest result = new com.starrocks.proto.PFetchDataRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (finstIdBuilder_ == null) {
          result.finstId_ = finstId_;
        } else {
          result.finstId_ = finstIdBuilder_.build();
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
      if (other instanceof com.starrocks.proto.PFetchDataRequest) {
        return mergeFrom((com.starrocks.proto.PFetchDataRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.PFetchDataRequest other) {
      if (other == com.starrocks.proto.PFetchDataRequest.getDefaultInstance()) return this;
      if (other.hasFinstId()) {
        mergeFinstId(other.getFinstId());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasFinstId()) {
        return false;
      }
      if (!getFinstId().isInitialized()) {
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
                  getFinstIdFieldBuilder().getBuilder(),
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

    private com.starrocks.proto.PUniqueId finstId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.PUniqueId, com.starrocks.proto.PUniqueId.Builder, com.starrocks.proto.PUniqueIdOrBuilder> finstIdBuilder_;
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     * @return Whether the finstId field is set.
     */
    public boolean hasFinstId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     * @return The finstId.
     */
    public com.starrocks.proto.PUniqueId getFinstId() {
      if (finstIdBuilder_ == null) {
        return finstId_ == null ? com.starrocks.proto.PUniqueId.getDefaultInstance() : finstId_;
      } else {
        return finstIdBuilder_.getMessage();
      }
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     */
    public Builder setFinstId(com.starrocks.proto.PUniqueId value) {
      if (finstIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        finstId_ = value;
        onChanged();
      } else {
        finstIdBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     */
    public Builder setFinstId(
        com.starrocks.proto.PUniqueId.Builder builderForValue) {
      if (finstIdBuilder_ == null) {
        finstId_ = builderForValue.build();
        onChanged();
      } else {
        finstIdBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     */
    public Builder mergeFinstId(com.starrocks.proto.PUniqueId value) {
      if (finstIdBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            finstId_ != null &&
            finstId_ != com.starrocks.proto.PUniqueId.getDefaultInstance()) {
          finstId_ =
            com.starrocks.proto.PUniqueId.newBuilder(finstId_).mergeFrom(value).buildPartial();
        } else {
          finstId_ = value;
        }
        onChanged();
      } else {
        finstIdBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     */
    public Builder clearFinstId() {
      if (finstIdBuilder_ == null) {
        finstId_ = null;
        onChanged();
      } else {
        finstIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     */
    public com.starrocks.proto.PUniqueId.Builder getFinstIdBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getFinstIdFieldBuilder().getBuilder();
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     */
    public com.starrocks.proto.PUniqueIdOrBuilder getFinstIdOrBuilder() {
      if (finstIdBuilder_ != null) {
        return finstIdBuilder_.getMessageOrBuilder();
      } else {
        return finstId_ == null ?
            com.starrocks.proto.PUniqueId.getDefaultInstance() : finstId_;
      }
    }
    /**
     * <code>required .starrocks.PUniqueId finst_id = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.PUniqueId, com.starrocks.proto.PUniqueId.Builder, com.starrocks.proto.PUniqueIdOrBuilder> 
        getFinstIdFieldBuilder() {
      if (finstIdBuilder_ == null) {
        finstIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.starrocks.proto.PUniqueId, com.starrocks.proto.PUniqueId.Builder, com.starrocks.proto.PUniqueIdOrBuilder>(
                getFinstId(),
                getParentForChildren(),
                isClean());
        finstId_ = null;
      }
      return finstIdBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PFetchDataRequest)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PFetchDataRequest)
  private static final com.starrocks.proto.PFetchDataRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.PFetchDataRequest();
  }

  public static com.starrocks.proto.PFetchDataRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PFetchDataRequest>
      PARSER = new com.google.protobuf.AbstractParser<PFetchDataRequest>() {
    @java.lang.Override
    public PFetchDataRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<PFetchDataRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PFetchDataRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.PFetchDataRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

