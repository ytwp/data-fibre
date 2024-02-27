// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.PGetFileSchemaResult}
 */
public final class PGetFileSchemaResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PGetFileSchemaResult)
    PGetFileSchemaResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PGetFileSchemaResult.newBuilder() to construct.
  private PGetFileSchemaResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PGetFileSchemaResult() {
    schema_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PGetFileSchemaResult();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PGetFileSchemaResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PGetFileSchemaResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.PGetFileSchemaResult.class, com.starrocks.proto.PGetFileSchemaResult.Builder.class);
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

  public static final int SCHEMA_FIELD_NUMBER = 2;
  private java.util.List<com.starrocks.proto.PSlotDescriptor> schema_;
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  @java.lang.Override
  public java.util.List<com.starrocks.proto.PSlotDescriptor> getSchemaList() {
    return schema_;
  }
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.starrocks.proto.PSlotDescriptorOrBuilder> 
      getSchemaOrBuilderList() {
    return schema_;
  }
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  @java.lang.Override
  public int getSchemaCount() {
    return schema_.size();
  }
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.PSlotDescriptor getSchema(int index) {
    return schema_.get(index);
  }
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.PSlotDescriptorOrBuilder getSchemaOrBuilder(
      int index) {
    return schema_.get(index);
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
    for (int i = 0; i < getSchemaCount(); i++) {
      if (!getSchema(i).isInitialized()) {
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
    for (int i = 0; i < schema_.size(); i++) {
      output.writeMessage(2, schema_.get(i));
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
    for (int i = 0; i < schema_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, schema_.get(i));
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
    if (!(obj instanceof com.starrocks.proto.PGetFileSchemaResult)) {
      return super.equals(obj);
    }
    com.starrocks.proto.PGetFileSchemaResult other = (com.starrocks.proto.PGetFileSchemaResult) obj;

    if (hasStatus() != other.hasStatus()) return false;
    if (hasStatus()) {
      if (!getStatus()
          .equals(other.getStatus())) return false;
    }
    if (!getSchemaList()
        .equals(other.getSchemaList())) return false;
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
    if (getSchemaCount() > 0) {
      hash = (37 * hash) + SCHEMA_FIELD_NUMBER;
      hash = (53 * hash) + getSchemaList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PGetFileSchemaResult parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.PGetFileSchemaResult prototype) {
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
   * Protobuf type {@code starrocks.PGetFileSchemaResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PGetFileSchemaResult)
      com.starrocks.proto.PGetFileSchemaResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PGetFileSchemaResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PGetFileSchemaResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.PGetFileSchemaResult.class, com.starrocks.proto.PGetFileSchemaResult.Builder.class);
    }

    // Construct using com.starrocks.proto.PGetFileSchemaResult.newBuilder()
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
        getSchemaFieldBuilder();
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
      if (schemaBuilder_ == null) {
        schema_ = java.util.Collections.emptyList();
      } else {
        schema_ = null;
        schemaBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PGetFileSchemaResult_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.PGetFileSchemaResult getDefaultInstanceForType() {
      return com.starrocks.proto.PGetFileSchemaResult.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.PGetFileSchemaResult build() {
      com.starrocks.proto.PGetFileSchemaResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.PGetFileSchemaResult buildPartial() {
      com.starrocks.proto.PGetFileSchemaResult result = new com.starrocks.proto.PGetFileSchemaResult(this);
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
      if (schemaBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          schema_ = java.util.Collections.unmodifiableList(schema_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.schema_ = schema_;
      } else {
        result.schema_ = schemaBuilder_.build();
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
      if (other instanceof com.starrocks.proto.PGetFileSchemaResult) {
        return mergeFrom((com.starrocks.proto.PGetFileSchemaResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.PGetFileSchemaResult other) {
      if (other == com.starrocks.proto.PGetFileSchemaResult.getDefaultInstance()) return this;
      if (other.hasStatus()) {
        mergeStatus(other.getStatus());
      }
      if (schemaBuilder_ == null) {
        if (!other.schema_.isEmpty()) {
          if (schema_.isEmpty()) {
            schema_ = other.schema_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureSchemaIsMutable();
            schema_.addAll(other.schema_);
          }
          onChanged();
        }
      } else {
        if (!other.schema_.isEmpty()) {
          if (schemaBuilder_.isEmpty()) {
            schemaBuilder_.dispose();
            schemaBuilder_ = null;
            schema_ = other.schema_;
            bitField0_ = (bitField0_ & ~0x00000002);
            schemaBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getSchemaFieldBuilder() : null;
          } else {
            schemaBuilder_.addAllMessages(other.schema_);
          }
        }
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
      for (int i = 0; i < getSchemaCount(); i++) {
        if (!getSchema(i).isInitialized()) {
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
            case 18: {
              com.starrocks.proto.PSlotDescriptor m =
                  input.readMessage(
                      com.starrocks.proto.PSlotDescriptor.PARSER,
                      extensionRegistry);
              if (schemaBuilder_ == null) {
                ensureSchemaIsMutable();
                schema_.add(m);
              } else {
                schemaBuilder_.addMessage(m);
              }
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

    private java.util.List<com.starrocks.proto.PSlotDescriptor> schema_ =
      java.util.Collections.emptyList();
    private void ensureSchemaIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        schema_ = new java.util.ArrayList<com.starrocks.proto.PSlotDescriptor>(schema_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.starrocks.proto.PSlotDescriptor, com.starrocks.proto.PSlotDescriptor.Builder, com.starrocks.proto.PSlotDescriptorOrBuilder> schemaBuilder_;

    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public java.util.List<com.starrocks.proto.PSlotDescriptor> getSchemaList() {
      if (schemaBuilder_ == null) {
        return java.util.Collections.unmodifiableList(schema_);
      } else {
        return schemaBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public int getSchemaCount() {
      if (schemaBuilder_ == null) {
        return schema_.size();
      } else {
        return schemaBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public com.starrocks.proto.PSlotDescriptor getSchema(int index) {
      if (schemaBuilder_ == null) {
        return schema_.get(index);
      } else {
        return schemaBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder setSchema(
        int index, com.starrocks.proto.PSlotDescriptor value) {
      if (schemaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSchemaIsMutable();
        schema_.set(index, value);
        onChanged();
      } else {
        schemaBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder setSchema(
        int index, com.starrocks.proto.PSlotDescriptor.Builder builderForValue) {
      if (schemaBuilder_ == null) {
        ensureSchemaIsMutable();
        schema_.set(index, builderForValue.build());
        onChanged();
      } else {
        schemaBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder addSchema(com.starrocks.proto.PSlotDescriptor value) {
      if (schemaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSchemaIsMutable();
        schema_.add(value);
        onChanged();
      } else {
        schemaBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder addSchema(
        int index, com.starrocks.proto.PSlotDescriptor value) {
      if (schemaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSchemaIsMutable();
        schema_.add(index, value);
        onChanged();
      } else {
        schemaBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder addSchema(
        com.starrocks.proto.PSlotDescriptor.Builder builderForValue) {
      if (schemaBuilder_ == null) {
        ensureSchemaIsMutable();
        schema_.add(builderForValue.build());
        onChanged();
      } else {
        schemaBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder addSchema(
        int index, com.starrocks.proto.PSlotDescriptor.Builder builderForValue) {
      if (schemaBuilder_ == null) {
        ensureSchemaIsMutable();
        schema_.add(index, builderForValue.build());
        onChanged();
      } else {
        schemaBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder addAllSchema(
        java.lang.Iterable<? extends com.starrocks.proto.PSlotDescriptor> values) {
      if (schemaBuilder_ == null) {
        ensureSchemaIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, schema_);
        onChanged();
      } else {
        schemaBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder clearSchema() {
      if (schemaBuilder_ == null) {
        schema_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        schemaBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public Builder removeSchema(int index) {
      if (schemaBuilder_ == null) {
        ensureSchemaIsMutable();
        schema_.remove(index);
        onChanged();
      } else {
        schemaBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public com.starrocks.proto.PSlotDescriptor.Builder getSchemaBuilder(
        int index) {
      return getSchemaFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public com.starrocks.proto.PSlotDescriptorOrBuilder getSchemaOrBuilder(
        int index) {
      if (schemaBuilder_ == null) {
        return schema_.get(index);  } else {
        return schemaBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public java.util.List<? extends com.starrocks.proto.PSlotDescriptorOrBuilder> 
         getSchemaOrBuilderList() {
      if (schemaBuilder_ != null) {
        return schemaBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(schema_);
      }
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public com.starrocks.proto.PSlotDescriptor.Builder addSchemaBuilder() {
      return getSchemaFieldBuilder().addBuilder(
          com.starrocks.proto.PSlotDescriptor.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public com.starrocks.proto.PSlotDescriptor.Builder addSchemaBuilder(
        int index) {
      return getSchemaFieldBuilder().addBuilder(
          index, com.starrocks.proto.PSlotDescriptor.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
     */
    public java.util.List<com.starrocks.proto.PSlotDescriptor.Builder> 
         getSchemaBuilderList() {
      return getSchemaFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.starrocks.proto.PSlotDescriptor, com.starrocks.proto.PSlotDescriptor.Builder, com.starrocks.proto.PSlotDescriptorOrBuilder> 
        getSchemaFieldBuilder() {
      if (schemaBuilder_ == null) {
        schemaBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.starrocks.proto.PSlotDescriptor, com.starrocks.proto.PSlotDescriptor.Builder, com.starrocks.proto.PSlotDescriptorOrBuilder>(
                schema_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        schema_ = null;
      }
      return schemaBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PGetFileSchemaResult)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PGetFileSchemaResult)
  private static final com.starrocks.proto.PGetFileSchemaResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.PGetFileSchemaResult();
  }

  public static com.starrocks.proto.PGetFileSchemaResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PGetFileSchemaResult>
      PARSER = new com.google.protobuf.AbstractParser<PGetFileSchemaResult>() {
    @java.lang.Override
    public PGetFileSchemaResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<PGetFileSchemaResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PGetFileSchemaResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.PGetFileSchemaResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

