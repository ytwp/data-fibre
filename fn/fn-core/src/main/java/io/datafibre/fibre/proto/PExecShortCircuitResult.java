// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.PExecShortCircuitResult}
 */
public final class PExecShortCircuitResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PExecShortCircuitResult)
    PExecShortCircuitResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PExecShortCircuitResult.newBuilder() to construct.
  private PExecShortCircuitResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PExecShortCircuitResult() {
    profile_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PExecShortCircuitResult();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PExecShortCircuitResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.InternalService.internal_static_starrocks_PExecShortCircuitResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.PExecShortCircuitResult.class, com.starrocks.proto.PExecShortCircuitResult.Builder.class);
  }

  private int bitField0_;
  public static final int STATUS_FIELD_NUMBER = 1;
  private com.starrocks.proto.StatusPB status_;
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
  public com.starrocks.proto.StatusPB getStatus() {
    return status_ == null ? com.starrocks.proto.StatusPB.getDefaultInstance() : status_;
  }
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.StatusPBOrBuilder getStatusOrBuilder() {
    return status_ == null ? com.starrocks.proto.StatusPB.getDefaultInstance() : status_;
  }

  public static final int AFFECTED_ROWS_FIELD_NUMBER = 2;
  private long affectedRows_;
  /**
   * <code>optional int64 affected_rows = 2;</code>
   * @return Whether the affectedRows field is set.
   */
  @java.lang.Override
  public boolean hasAffectedRows() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional int64 affected_rows = 2;</code>
   * @return The affectedRows.
   */
  @java.lang.Override
  public long getAffectedRows() {
    return affectedRows_;
  }

  public static final int PROFILE_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString profile_;
  /**
   * <code>optional bytes profile = 3;</code>
   * @return Whether the profile field is set.
   */
  @java.lang.Override
  public boolean hasProfile() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional bytes profile = 3;</code>
   * @return The profile.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getProfile() {
    return profile_;
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
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt64(2, affectedRows_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeBytes(3, profile_);
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
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, affectedRows_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, profile_);
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
    if (!(obj instanceof com.starrocks.proto.PExecShortCircuitResult)) {
      return super.equals(obj);
    }
    com.starrocks.proto.PExecShortCircuitResult other = (com.starrocks.proto.PExecShortCircuitResult) obj;

    if (hasStatus() != other.hasStatus()) return false;
    if (hasStatus()) {
      if (!getStatus()
          .equals(other.getStatus())) return false;
    }
    if (hasAffectedRows() != other.hasAffectedRows()) return false;
    if (hasAffectedRows()) {
      if (getAffectedRows()
          != other.getAffectedRows()) return false;
    }
    if (hasProfile() != other.hasProfile()) return false;
    if (hasProfile()) {
      if (!getProfile()
          .equals(other.getProfile())) return false;
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
    if (hasAffectedRows()) {
      hash = (37 * hash) + AFFECTED_ROWS_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getAffectedRows());
    }
    if (hasProfile()) {
      hash = (37 * hash) + PROFILE_FIELD_NUMBER;
      hash = (53 * hash) + getProfile().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.PExecShortCircuitResult parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.PExecShortCircuitResult prototype) {
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
   * Protobuf type {@code starrocks.PExecShortCircuitResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PExecShortCircuitResult)
      com.starrocks.proto.PExecShortCircuitResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PExecShortCircuitResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PExecShortCircuitResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.PExecShortCircuitResult.class, com.starrocks.proto.PExecShortCircuitResult.Builder.class);
    }

    // Construct using com.starrocks.proto.PExecShortCircuitResult.newBuilder()
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
      affectedRows_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      profile_ = com.google.protobuf.ByteString.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.InternalService.internal_static_starrocks_PExecShortCircuitResult_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.PExecShortCircuitResult getDefaultInstanceForType() {
      return com.starrocks.proto.PExecShortCircuitResult.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.PExecShortCircuitResult build() {
      com.starrocks.proto.PExecShortCircuitResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.PExecShortCircuitResult buildPartial() {
      com.starrocks.proto.PExecShortCircuitResult result = new com.starrocks.proto.PExecShortCircuitResult(this);
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
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.affectedRows_ = affectedRows_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        to_bitField0_ |= 0x00000004;
      }
      result.profile_ = profile_;
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
      if (other instanceof com.starrocks.proto.PExecShortCircuitResult) {
        return mergeFrom((com.starrocks.proto.PExecShortCircuitResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.PExecShortCircuitResult other) {
      if (other == com.starrocks.proto.PExecShortCircuitResult.getDefaultInstance()) return this;
      if (other.hasStatus()) {
        mergeStatus(other.getStatus());
      }
      if (other.hasAffectedRows()) {
        setAffectedRows(other.getAffectedRows());
      }
      if (other.hasProfile()) {
        setProfile(other.getProfile());
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
            case 16: {
              affectedRows_ = input.readInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              profile_ = input.readBytes();
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

    private com.starrocks.proto.StatusPB status_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.StatusPB, com.starrocks.proto.StatusPB.Builder, com.starrocks.proto.StatusPBOrBuilder> statusBuilder_;
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
    public com.starrocks.proto.StatusPB getStatus() {
      if (statusBuilder_ == null) {
        return status_ == null ? com.starrocks.proto.StatusPB.getDefaultInstance() : status_;
      } else {
        return statusBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
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
     * <code>optional .starrocks.StatusPB status = 1;</code>
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
     * <code>optional .starrocks.StatusPB status = 1;</code>
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
    public com.starrocks.proto.StatusPB.Builder getStatusBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getStatusFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.StatusPB status = 1;</code>
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
     * <code>optional .starrocks.StatusPB status = 1;</code>
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

    private long affectedRows_ ;
    /**
     * <code>optional int64 affected_rows = 2;</code>
     * @return Whether the affectedRows field is set.
     */
    @java.lang.Override
    public boolean hasAffectedRows() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int64 affected_rows = 2;</code>
     * @return The affectedRows.
     */
    @java.lang.Override
    public long getAffectedRows() {
      return affectedRows_;
    }
    /**
     * <code>optional int64 affected_rows = 2;</code>
     * @param value The affectedRows to set.
     * @return This builder for chaining.
     */
    public Builder setAffectedRows(long value) {
      bitField0_ |= 0x00000002;
      affectedRows_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 affected_rows = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAffectedRows() {
      bitField0_ = (bitField0_ & ~0x00000002);
      affectedRows_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString profile_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>optional bytes profile = 3;</code>
     * @return Whether the profile field is set.
     */
    @java.lang.Override
    public boolean hasProfile() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional bytes profile = 3;</code>
     * @return The profile.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getProfile() {
      return profile_;
    }
    /**
     * <code>optional bytes profile = 3;</code>
     * @param value The profile to set.
     * @return This builder for chaining.
     */
    public Builder setProfile(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      profile_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bytes profile = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearProfile() {
      bitField0_ = (bitField0_ & ~0x00000004);
      profile_ = getDefaultInstance().getProfile();
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


    // @@protoc_insertion_point(builder_scope:starrocks.PExecShortCircuitResult)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PExecShortCircuitResult)
  private static final com.starrocks.proto.PExecShortCircuitResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.PExecShortCircuitResult();
  }

  public static com.starrocks.proto.PExecShortCircuitResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PExecShortCircuitResult>
      PARSER = new com.google.protobuf.AbstractParser<PExecShortCircuitResult>() {
    @java.lang.Override
    public PExecShortCircuitResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<PExecShortCircuitResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PExecShortCircuitResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.PExecShortCircuitResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

