// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.UpdatePB}
 */
public final class UpdatePB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.UpdatePB)
    UpdatePBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdatePB.newBuilder() to construct.
  private UpdatePB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdatePB() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdatePB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.Binlog.internal_static_starrocks_UpdatePB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.Binlog.internal_static_starrocks_UpdatePB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.UpdatePB.class, com.starrocks.proto.UpdatePB.Builder.class);
  }

  private int bitField0_;
  public static final int BEFORE_FILE_ID_FIELD_NUMBER = 1;
  private com.starrocks.proto.FileIdPB beforeFileId_;
  /**
   * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
   * @return Whether the beforeFileId field is set.
   */
  @java.lang.Override
  public boolean hasBeforeFileId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
   * @return The beforeFileId.
   */
  @java.lang.Override
  public com.starrocks.proto.FileIdPB getBeforeFileId() {
    return beforeFileId_ == null ? com.starrocks.proto.FileIdPB.getDefaultInstance() : beforeFileId_;
  }
  /**
   * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.FileIdPBOrBuilder getBeforeFileIdOrBuilder() {
    return beforeFileId_ == null ? com.starrocks.proto.FileIdPB.getDefaultInstance() : beforeFileId_;
  }

  public static final int BEFORE_ROW_ID_FIELD_NUMBER = 2;
  private int beforeRowId_;
  /**
   * <code>optional int32 before_row_id = 2;</code>
   * @return Whether the beforeRowId field is set.
   */
  @java.lang.Override
  public boolean hasBeforeRowId() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional int32 before_row_id = 2;</code>
   * @return The beforeRowId.
   */
  @java.lang.Override
  public int getBeforeRowId() {
    return beforeRowId_;
  }

  public static final int AFTER_FILE_ID_FIELD_NUMBER = 3;
  private com.starrocks.proto.FileIdPB afterFileId_;
  /**
   * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
   * @return Whether the afterFileId field is set.
   */
  @java.lang.Override
  public boolean hasAfterFileId() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
   * @return The afterFileId.
   */
  @java.lang.Override
  public com.starrocks.proto.FileIdPB getAfterFileId() {
    return afterFileId_ == null ? com.starrocks.proto.FileIdPB.getDefaultInstance() : afterFileId_;
  }
  /**
   * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.FileIdPBOrBuilder getAfterFileIdOrBuilder() {
    return afterFileId_ == null ? com.starrocks.proto.FileIdPB.getDefaultInstance() : afterFileId_;
  }

  public static final int AFTER_ROW_ID_FIELD_NUMBER = 4;
  private int afterRowId_;
  /**
   * <code>optional int32 after_row_id = 4;</code>
   * @return Whether the afterRowId field is set.
   */
  @java.lang.Override
  public boolean hasAfterRowId() {
    return ((bitField0_ & 0x00000008) != 0);
  }
  /**
   * <code>optional int32 after_row_id = 4;</code>
   * @return The afterRowId.
   */
  @java.lang.Override
  public int getAfterRowId() {
    return afterRowId_;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getBeforeFileId());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt32(2, beforeRowId_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeMessage(3, getAfterFileId());
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      output.writeInt32(4, afterRowId_);
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
        .computeMessageSize(1, getBeforeFileId());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, beforeRowId_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getAfterFileId());
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, afterRowId_);
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
    if (!(obj instanceof com.starrocks.proto.UpdatePB)) {
      return super.equals(obj);
    }
    com.starrocks.proto.UpdatePB other = (com.starrocks.proto.UpdatePB) obj;

    if (hasBeforeFileId() != other.hasBeforeFileId()) return false;
    if (hasBeforeFileId()) {
      if (!getBeforeFileId()
          .equals(other.getBeforeFileId())) return false;
    }
    if (hasBeforeRowId() != other.hasBeforeRowId()) return false;
    if (hasBeforeRowId()) {
      if (getBeforeRowId()
          != other.getBeforeRowId()) return false;
    }
    if (hasAfterFileId() != other.hasAfterFileId()) return false;
    if (hasAfterFileId()) {
      if (!getAfterFileId()
          .equals(other.getAfterFileId())) return false;
    }
    if (hasAfterRowId() != other.hasAfterRowId()) return false;
    if (hasAfterRowId()) {
      if (getAfterRowId()
          != other.getAfterRowId()) return false;
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
    if (hasBeforeFileId()) {
      hash = (37 * hash) + BEFORE_FILE_ID_FIELD_NUMBER;
      hash = (53 * hash) + getBeforeFileId().hashCode();
    }
    if (hasBeforeRowId()) {
      hash = (37 * hash) + BEFORE_ROW_ID_FIELD_NUMBER;
      hash = (53 * hash) + getBeforeRowId();
    }
    if (hasAfterFileId()) {
      hash = (37 * hash) + AFTER_FILE_ID_FIELD_NUMBER;
      hash = (53 * hash) + getAfterFileId().hashCode();
    }
    if (hasAfterRowId()) {
      hash = (37 * hash) + AFTER_ROW_ID_FIELD_NUMBER;
      hash = (53 * hash) + getAfterRowId();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.UpdatePB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.UpdatePB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.UpdatePB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.UpdatePB parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.UpdatePB prototype) {
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
   * Protobuf type {@code starrocks.UpdatePB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.UpdatePB)
      com.starrocks.proto.UpdatePBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.Binlog.internal_static_starrocks_UpdatePB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.Binlog.internal_static_starrocks_UpdatePB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.UpdatePB.class, com.starrocks.proto.UpdatePB.Builder.class);
    }

    // Construct using com.starrocks.proto.UpdatePB.newBuilder()
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
        getBeforeFileIdFieldBuilder();
        getAfterFileIdFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (beforeFileIdBuilder_ == null) {
        beforeFileId_ = null;
      } else {
        beforeFileIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      beforeRowId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      if (afterFileIdBuilder_ == null) {
        afterFileId_ = null;
      } else {
        afterFileIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      afterRowId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.Binlog.internal_static_starrocks_UpdatePB_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.UpdatePB getDefaultInstanceForType() {
      return com.starrocks.proto.UpdatePB.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.UpdatePB build() {
      com.starrocks.proto.UpdatePB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.UpdatePB buildPartial() {
      com.starrocks.proto.UpdatePB result = new com.starrocks.proto.UpdatePB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (beforeFileIdBuilder_ == null) {
          result.beforeFileId_ = beforeFileId_;
        } else {
          result.beforeFileId_ = beforeFileIdBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.beforeRowId_ = beforeRowId_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        if (afterFileIdBuilder_ == null) {
          result.afterFileId_ = afterFileId_;
        } else {
          result.afterFileId_ = afterFileIdBuilder_.build();
        }
        to_bitField0_ |= 0x00000004;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.afterRowId_ = afterRowId_;
        to_bitField0_ |= 0x00000008;
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
      if (other instanceof com.starrocks.proto.UpdatePB) {
        return mergeFrom((com.starrocks.proto.UpdatePB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.UpdatePB other) {
      if (other == com.starrocks.proto.UpdatePB.getDefaultInstance()) return this;
      if (other.hasBeforeFileId()) {
        mergeBeforeFileId(other.getBeforeFileId());
      }
      if (other.hasBeforeRowId()) {
        setBeforeRowId(other.getBeforeRowId());
      }
      if (other.hasAfterFileId()) {
        mergeAfterFileId(other.getAfterFileId());
      }
      if (other.hasAfterRowId()) {
        setAfterRowId(other.getAfterRowId());
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
            case 10: {
              input.readMessage(
                  getBeforeFileIdFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              beforeRowId_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              input.readMessage(
                  getAfterFileIdFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              afterRowId_ = input.readInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
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

    private com.starrocks.proto.FileIdPB beforeFileId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.FileIdPB, com.starrocks.proto.FileIdPB.Builder, com.starrocks.proto.FileIdPBOrBuilder> beforeFileIdBuilder_;
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     * @return Whether the beforeFileId field is set.
     */
    public boolean hasBeforeFileId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     * @return The beforeFileId.
     */
    public com.starrocks.proto.FileIdPB getBeforeFileId() {
      if (beforeFileIdBuilder_ == null) {
        return beforeFileId_ == null ? com.starrocks.proto.FileIdPB.getDefaultInstance() : beforeFileId_;
      } else {
        return beforeFileIdBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     */
    public Builder setBeforeFileId(com.starrocks.proto.FileIdPB value) {
      if (beforeFileIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        beforeFileId_ = value;
        onChanged();
      } else {
        beforeFileIdBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     */
    public Builder setBeforeFileId(
        com.starrocks.proto.FileIdPB.Builder builderForValue) {
      if (beforeFileIdBuilder_ == null) {
        beforeFileId_ = builderForValue.build();
        onChanged();
      } else {
        beforeFileIdBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     */
    public Builder mergeBeforeFileId(com.starrocks.proto.FileIdPB value) {
      if (beforeFileIdBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            beforeFileId_ != null &&
            beforeFileId_ != com.starrocks.proto.FileIdPB.getDefaultInstance()) {
          beforeFileId_ =
            com.starrocks.proto.FileIdPB.newBuilder(beforeFileId_).mergeFrom(value).buildPartial();
        } else {
          beforeFileId_ = value;
        }
        onChanged();
      } else {
        beforeFileIdBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     */
    public Builder clearBeforeFileId() {
      if (beforeFileIdBuilder_ == null) {
        beforeFileId_ = null;
        onChanged();
      } else {
        beforeFileIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     */
    public com.starrocks.proto.FileIdPB.Builder getBeforeFileIdBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getBeforeFileIdFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     */
    public com.starrocks.proto.FileIdPBOrBuilder getBeforeFileIdOrBuilder() {
      if (beforeFileIdBuilder_ != null) {
        return beforeFileIdBuilder_.getMessageOrBuilder();
      } else {
        return beforeFileId_ == null ?
            com.starrocks.proto.FileIdPB.getDefaultInstance() : beforeFileId_;
      }
    }
    /**
     * <code>optional .starrocks.FileIdPB before_file_id = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.FileIdPB, com.starrocks.proto.FileIdPB.Builder, com.starrocks.proto.FileIdPBOrBuilder> 
        getBeforeFileIdFieldBuilder() {
      if (beforeFileIdBuilder_ == null) {
        beforeFileIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.starrocks.proto.FileIdPB, com.starrocks.proto.FileIdPB.Builder, com.starrocks.proto.FileIdPBOrBuilder>(
                getBeforeFileId(),
                getParentForChildren(),
                isClean());
        beforeFileId_ = null;
      }
      return beforeFileIdBuilder_;
    }

    private int beforeRowId_ ;
    /**
     * <code>optional int32 before_row_id = 2;</code>
     * @return Whether the beforeRowId field is set.
     */
    @java.lang.Override
    public boolean hasBeforeRowId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int32 before_row_id = 2;</code>
     * @return The beforeRowId.
     */
    @java.lang.Override
    public int getBeforeRowId() {
      return beforeRowId_;
    }
    /**
     * <code>optional int32 before_row_id = 2;</code>
     * @param value The beforeRowId to set.
     * @return This builder for chaining.
     */
    public Builder setBeforeRowId(int value) {
      bitField0_ |= 0x00000002;
      beforeRowId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 before_row_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBeforeRowId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      beforeRowId_ = 0;
      onChanged();
      return this;
    }

    private com.starrocks.proto.FileIdPB afterFileId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.FileIdPB, com.starrocks.proto.FileIdPB.Builder, com.starrocks.proto.FileIdPBOrBuilder> afterFileIdBuilder_;
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     * @return Whether the afterFileId field is set.
     */
    public boolean hasAfterFileId() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     * @return The afterFileId.
     */
    public com.starrocks.proto.FileIdPB getAfterFileId() {
      if (afterFileIdBuilder_ == null) {
        return afterFileId_ == null ? com.starrocks.proto.FileIdPB.getDefaultInstance() : afterFileId_;
      } else {
        return afterFileIdBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     */
    public Builder setAfterFileId(com.starrocks.proto.FileIdPB value) {
      if (afterFileIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        afterFileId_ = value;
        onChanged();
      } else {
        afterFileIdBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     */
    public Builder setAfterFileId(
        com.starrocks.proto.FileIdPB.Builder builderForValue) {
      if (afterFileIdBuilder_ == null) {
        afterFileId_ = builderForValue.build();
        onChanged();
      } else {
        afterFileIdBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     */
    public Builder mergeAfterFileId(com.starrocks.proto.FileIdPB value) {
      if (afterFileIdBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
            afterFileId_ != null &&
            afterFileId_ != com.starrocks.proto.FileIdPB.getDefaultInstance()) {
          afterFileId_ =
            com.starrocks.proto.FileIdPB.newBuilder(afterFileId_).mergeFrom(value).buildPartial();
        } else {
          afterFileId_ = value;
        }
        onChanged();
      } else {
        afterFileIdBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     */
    public Builder clearAfterFileId() {
      if (afterFileIdBuilder_ == null) {
        afterFileId_ = null;
        onChanged();
      } else {
        afterFileIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     */
    public com.starrocks.proto.FileIdPB.Builder getAfterFileIdBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getAfterFileIdFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     */
    public com.starrocks.proto.FileIdPBOrBuilder getAfterFileIdOrBuilder() {
      if (afterFileIdBuilder_ != null) {
        return afterFileIdBuilder_.getMessageOrBuilder();
      } else {
        return afterFileId_ == null ?
            com.starrocks.proto.FileIdPB.getDefaultInstance() : afterFileId_;
      }
    }
    /**
     * <code>optional .starrocks.FileIdPB after_file_id = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.FileIdPB, com.starrocks.proto.FileIdPB.Builder, com.starrocks.proto.FileIdPBOrBuilder> 
        getAfterFileIdFieldBuilder() {
      if (afterFileIdBuilder_ == null) {
        afterFileIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.starrocks.proto.FileIdPB, com.starrocks.proto.FileIdPB.Builder, com.starrocks.proto.FileIdPBOrBuilder>(
                getAfterFileId(),
                getParentForChildren(),
                isClean());
        afterFileId_ = null;
      }
      return afterFileIdBuilder_;
    }

    private int afterRowId_ ;
    /**
     * <code>optional int32 after_row_id = 4;</code>
     * @return Whether the afterRowId field is set.
     */
    @java.lang.Override
    public boolean hasAfterRowId() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>optional int32 after_row_id = 4;</code>
     * @return The afterRowId.
     */
    @java.lang.Override
    public int getAfterRowId() {
      return afterRowId_;
    }
    /**
     * <code>optional int32 after_row_id = 4;</code>
     * @param value The afterRowId to set.
     * @return This builder for chaining.
     */
    public Builder setAfterRowId(int value) {
      bitField0_ |= 0x00000008;
      afterRowId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 after_row_id = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearAfterRowId() {
      bitField0_ = (bitField0_ & ~0x00000008);
      afterRowId_ = 0;
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


    // @@protoc_insertion_point(builder_scope:starrocks.UpdatePB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.UpdatePB)
  private static final com.starrocks.proto.UpdatePB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.UpdatePB();
  }

  public static com.starrocks.proto.UpdatePB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<UpdatePB>
      PARSER = new com.google.protobuf.AbstractParser<UpdatePB>() {
    @java.lang.Override
    public UpdatePB parsePartialFrom(
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

  public static com.google.protobuf.Parser<UpdatePB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdatePB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.UpdatePB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

