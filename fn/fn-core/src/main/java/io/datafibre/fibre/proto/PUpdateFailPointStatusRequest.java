// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.PUpdateFailPointStatusRequest}
 */
public final class PUpdateFailPointStatusRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PUpdateFailPointStatusRequest)
    PUpdateFailPointStatusRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PUpdateFailPointStatusRequest.newBuilder() to construct.
  private PUpdateFailPointStatusRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PUpdateFailPointStatusRequest() {
    failPointName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PUpdateFailPointStatusRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PUpdateFailPointStatusRequest.class, io.datafibre.fibre.proto.PUpdateFailPointStatusRequest.Builder.class);
  }

  private int bitField0_;
  public static final int FAIL_POINT_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object failPointName_;
  /**
   * <code>optional string fail_point_name = 1;</code>
   * @return Whether the failPointName field is set.
   */
  @java.lang.Override
  public boolean hasFailPointName() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string fail_point_name = 1;</code>
   * @return The failPointName.
   */
  @java.lang.Override
  public java.lang.String getFailPointName() {
    java.lang.Object ref = failPointName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        failPointName_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string fail_point_name = 1;</code>
   * @return The bytes for failPointName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFailPointNameBytes() {
    java.lang.Object ref = failPointName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      failPointName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TRIGGER_MODE_FIELD_NUMBER = 2;
  private io.datafibre.fibre.proto.PFailPointTriggerMode triggerMode_;
  /**
   * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
   * @return Whether the triggerMode field is set.
   */
  @java.lang.Override
  public boolean hasTriggerMode() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
   * @return The triggerMode.
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PFailPointTriggerMode getTriggerMode() {
    return triggerMode_ == null ? io.datafibre.fibre.proto.PFailPointTriggerMode.getDefaultInstance() : triggerMode_;
  }
  /**
   * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PFailPointTriggerModeOrBuilder getTriggerModeOrBuilder() {
    return triggerMode_ == null ? io.datafibre.fibre.proto.PFailPointTriggerMode.getDefaultInstance() : triggerMode_;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, failPointName_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getTriggerMode());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, failPointName_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getTriggerMode());
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
    if (!(obj instanceof io.datafibre.fibre.proto.PUpdateFailPointStatusRequest)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PUpdateFailPointStatusRequest other = (io.datafibre.fibre.proto.PUpdateFailPointStatusRequest) obj;

    if (hasFailPointName() != other.hasFailPointName()) return false;
    if (hasFailPointName()) {
      if (!getFailPointName()
          .equals(other.getFailPointName())) return false;
    }
    if (hasTriggerMode() != other.hasTriggerMode()) return false;
    if (hasTriggerMode()) {
      if (!getTriggerMode()
          .equals(other.getTriggerMode())) return false;
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
    if (hasFailPointName()) {
      hash = (37 * hash) + FAIL_POINT_NAME_FIELD_NUMBER;
      hash = (53 * hash) + getFailPointName().hashCode();
    }
    if (hasTriggerMode()) {
      hash = (37 * hash) + TRIGGER_MODE_FIELD_NUMBER;
      hash = (53 * hash) + getTriggerMode().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PUpdateFailPointStatusRequest prototype) {
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
   * Protobuf type {@code starrocks.PUpdateFailPointStatusRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PUpdateFailPointStatusRequest)
      io.datafibre.fibre.proto.PUpdateFailPointStatusRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PUpdateFailPointStatusRequest.class, io.datafibre.fibre.proto.PUpdateFailPointStatusRequest.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PUpdateFailPointStatusRequest.newBuilder()
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
        getTriggerModeFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      failPointName_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      if (triggerModeBuilder_ == null) {
        triggerMode_ = null;
      } else {
        triggerModeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PUpdateFailPointStatusRequest_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PUpdateFailPointStatusRequest getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PUpdateFailPointStatusRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PUpdateFailPointStatusRequest build() {
      io.datafibre.fibre.proto.PUpdateFailPointStatusRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PUpdateFailPointStatusRequest buildPartial() {
      io.datafibre.fibre.proto.PUpdateFailPointStatusRequest result = new io.datafibre.fibre.proto.PUpdateFailPointStatusRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.failPointName_ = failPointName_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        if (triggerModeBuilder_ == null) {
          result.triggerMode_ = triggerMode_;
        } else {
          result.triggerMode_ = triggerModeBuilder_.build();
        }
        to_bitField0_ |= 0x00000002;
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
      if (other instanceof io.datafibre.fibre.proto.PUpdateFailPointStatusRequest) {
        return mergeFrom((io.datafibre.fibre.proto.PUpdateFailPointStatusRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PUpdateFailPointStatusRequest other) {
      if (other == io.datafibre.fibre.proto.PUpdateFailPointStatusRequest.getDefaultInstance()) return this;
      if (other.hasFailPointName()) {
        bitField0_ |= 0x00000001;
        failPointName_ = other.failPointName_;
        onChanged();
      }
      if (other.hasTriggerMode()) {
        mergeTriggerMode(other.getTriggerMode());
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
              failPointName_ = input.readBytes();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getTriggerModeFieldBuilder().getBuilder(),
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

    private java.lang.Object failPointName_ = "";
    /**
     * <code>optional string fail_point_name = 1;</code>
     * @return Whether the failPointName field is set.
     */
    public boolean hasFailPointName() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional string fail_point_name = 1;</code>
     * @return The failPointName.
     */
    public java.lang.String getFailPointName() {
      java.lang.Object ref = failPointName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          failPointName_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string fail_point_name = 1;</code>
     * @return The bytes for failPointName.
     */
    public com.google.protobuf.ByteString
        getFailPointNameBytes() {
      java.lang.Object ref = failPointName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        failPointName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string fail_point_name = 1;</code>
     * @param value The failPointName to set.
     * @return This builder for chaining.
     */
    public Builder setFailPointName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      failPointName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string fail_point_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFailPointName() {
      bitField0_ = (bitField0_ & ~0x00000001);
      failPointName_ = getDefaultInstance().getFailPointName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string fail_point_name = 1;</code>
     * @param value The bytes for failPointName to set.
     * @return This builder for chaining.
     */
    public Builder setFailPointNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      failPointName_ = value;
      onChanged();
      return this;
    }

    private io.datafibre.fibre.proto.PFailPointTriggerMode triggerMode_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.PFailPointTriggerMode, io.datafibre.fibre.proto.PFailPointTriggerMode.Builder, io.datafibre.fibre.proto.PFailPointTriggerModeOrBuilder> triggerModeBuilder_;
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     * @return Whether the triggerMode field is set.
     */
    public boolean hasTriggerMode() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     * @return The triggerMode.
     */
    public io.datafibre.fibre.proto.PFailPointTriggerMode getTriggerMode() {
      if (triggerModeBuilder_ == null) {
        return triggerMode_ == null ? io.datafibre.fibre.proto.PFailPointTriggerMode.getDefaultInstance() : triggerMode_;
      } else {
        return triggerModeBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     */
    public Builder setTriggerMode(io.datafibre.fibre.proto.PFailPointTriggerMode value) {
      if (triggerModeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        triggerMode_ = value;
        onChanged();
      } else {
        triggerModeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     */
    public Builder setTriggerMode(
        io.datafibre.fibre.proto.PFailPointTriggerMode.Builder builderForValue) {
      if (triggerModeBuilder_ == null) {
        triggerMode_ = builderForValue.build();
        onChanged();
      } else {
        triggerModeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     */
    public Builder mergeTriggerMode(io.datafibre.fibre.proto.PFailPointTriggerMode value) {
      if (triggerModeBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
            triggerMode_ != null &&
            triggerMode_ != io.datafibre.fibre.proto.PFailPointTriggerMode.getDefaultInstance()) {
          triggerMode_ =
            io.datafibre.fibre.proto.PFailPointTriggerMode.newBuilder(triggerMode_).mergeFrom(value).buildPartial();
        } else {
          triggerMode_ = value;
        }
        onChanged();
      } else {
        triggerModeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     */
    public Builder clearTriggerMode() {
      if (triggerModeBuilder_ == null) {
        triggerMode_ = null;
        onChanged();
      } else {
        triggerModeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     */
    public io.datafibre.fibre.proto.PFailPointTriggerMode.Builder getTriggerModeBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getTriggerModeFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     */
    public io.datafibre.fibre.proto.PFailPointTriggerModeOrBuilder getTriggerModeOrBuilder() {
      if (triggerModeBuilder_ != null) {
        return triggerModeBuilder_.getMessageOrBuilder();
      } else {
        return triggerMode_ == null ?
            io.datafibre.fibre.proto.PFailPointTriggerMode.getDefaultInstance() : triggerMode_;
      }
    }
    /**
     * <code>optional .starrocks.PFailPointTriggerMode trigger_mode = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.PFailPointTriggerMode, io.datafibre.fibre.proto.PFailPointTriggerMode.Builder, io.datafibre.fibre.proto.PFailPointTriggerModeOrBuilder>
        getTriggerModeFieldBuilder() {
      if (triggerModeBuilder_ == null) {
        triggerModeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.datafibre.fibre.proto.PFailPointTriggerMode, io.datafibre.fibre.proto.PFailPointTriggerMode.Builder, io.datafibre.fibre.proto.PFailPointTriggerModeOrBuilder>(
                getTriggerMode(),
                getParentForChildren(),
                isClean());
        triggerMode_ = null;
      }
      return triggerModeBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PUpdateFailPointStatusRequest)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PUpdateFailPointStatusRequest)
  private static final io.datafibre.fibre.proto.PUpdateFailPointStatusRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PUpdateFailPointStatusRequest();
  }

  public static io.datafibre.fibre.proto.PUpdateFailPointStatusRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PUpdateFailPointStatusRequest>
      PARSER = new com.google.protobuf.AbstractParser<PUpdateFailPointStatusRequest>() {
    @java.lang.Override
    public PUpdateFailPointStatusRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<PUpdateFailPointStatusRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PUpdateFailPointStatusRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PUpdateFailPointStatusRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
