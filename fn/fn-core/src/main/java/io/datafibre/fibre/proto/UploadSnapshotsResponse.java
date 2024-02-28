// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.lake.UploadSnapshotsResponse}
 */
public final class UploadSnapshotsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.lake.UploadSnapshotsResponse)
    UploadSnapshotsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UploadSnapshotsResponse.newBuilder() to construct.
  private UploadSnapshotsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UploadSnapshotsResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UploadSnapshotsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.UploadSnapshotsResponse.class, io.datafibre.fibre.proto.UploadSnapshotsResponse.Builder.class);
  }

  private int bitField0_;
  public static final int PAD_FIELD_NUMBER = 1;
  private int pad_;
  /**
   * <pre>
   * unused, just for preventing jprotobuf error "no field use annotation &#64;com.baidu.bjf.remoting.protobuf.annotation.Protobuf ..."
   * </pre>
   *
   * <code>optional int32 pad = 1;</code>
   * @return Whether the pad field is set.
   */
  @java.lang.Override
  public boolean hasPad() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * unused, just for preventing jprotobuf error "no field use annotation &#64;com.baidu.bjf.remoting.protobuf.annotation.Protobuf ..."
   * </pre>
   *
   * <code>optional int32 pad = 1;</code>
   * @return The pad.
   */
  @java.lang.Override
  public int getPad() {
    return pad_;
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
      output.writeInt32(1, pad_);
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
        .computeInt32Size(1, pad_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.UploadSnapshotsResponse)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.UploadSnapshotsResponse other = (io.datafibre.fibre.proto.UploadSnapshotsResponse) obj;

    if (hasPad() != other.hasPad()) return false;
    if (hasPad()) {
      if (getPad()
          != other.getPad()) return false;
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
    if (hasPad()) {
      hash = (37 * hash) + PAD_FIELD_NUMBER;
      hash = (53 * hash) + getPad();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsResponse parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.UploadSnapshotsResponse prototype) {
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
   * Protobuf type {@code starrocks.lake.UploadSnapshotsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.lake.UploadSnapshotsResponse)
      io.datafibre.fibre.proto.UploadSnapshotsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.UploadSnapshotsResponse.class, io.datafibre.fibre.proto.UploadSnapshotsResponse.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.UploadSnapshotsResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      pad_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsResponse_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.UploadSnapshotsResponse getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.UploadSnapshotsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.UploadSnapshotsResponse build() {
      io.datafibre.fibre.proto.UploadSnapshotsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.UploadSnapshotsResponse buildPartial() {
      io.datafibre.fibre.proto.UploadSnapshotsResponse result = new io.datafibre.fibre.proto.UploadSnapshotsResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.pad_ = pad_;
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
      if (other instanceof io.datafibre.fibre.proto.UploadSnapshotsResponse) {
        return mergeFrom((io.datafibre.fibre.proto.UploadSnapshotsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.UploadSnapshotsResponse other) {
      if (other == io.datafibre.fibre.proto.UploadSnapshotsResponse.getDefaultInstance()) return this;
      if (other.hasPad()) {
        setPad(other.getPad());
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
              pad_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
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

    private int pad_ ;
    /**
     * <pre>
     * unused, just for preventing jprotobuf error "no field use annotation &#64;com.baidu.bjf.remoting.protobuf.annotation.Protobuf ..."
     * </pre>
     *
     * <code>optional int32 pad = 1;</code>
     * @return Whether the pad field is set.
     */
    @java.lang.Override
    public boolean hasPad() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * unused, just for preventing jprotobuf error "no field use annotation &#64;com.baidu.bjf.remoting.protobuf.annotation.Protobuf ..."
     * </pre>
     *
     * <code>optional int32 pad = 1;</code>
     * @return The pad.
     */
    @java.lang.Override
    public int getPad() {
      return pad_;
    }
    /**
     * <pre>
     * unused, just for preventing jprotobuf error "no field use annotation &#64;com.baidu.bjf.remoting.protobuf.annotation.Protobuf ..."
     * </pre>
     *
     * <code>optional int32 pad = 1;</code>
     * @param value The pad to set.
     * @return This builder for chaining.
     */
    public Builder setPad(int value) {
      bitField0_ |= 0x00000001;
      pad_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * unused, just for preventing jprotobuf error "no field use annotation &#64;com.baidu.bjf.remoting.protobuf.annotation.Protobuf ..."
     * </pre>
     *
     * <code>optional int32 pad = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPad() {
      bitField0_ = (bitField0_ & ~0x00000001);
      pad_ = 0;
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


    // @@protoc_insertion_point(builder_scope:starrocks.lake.UploadSnapshotsResponse)
  }

  // @@protoc_insertion_point(class_scope:starrocks.lake.UploadSnapshotsResponse)
  private static final io.datafibre.fibre.proto.UploadSnapshotsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.UploadSnapshotsResponse();
  }

  public static io.datafibre.fibre.proto.UploadSnapshotsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<UploadSnapshotsResponse>
      PARSER = new com.google.protobuf.AbstractParser<UploadSnapshotsResponse>() {
    @java.lang.Override
    public UploadSnapshotsResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<UploadSnapshotsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UploadSnapshotsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.UploadSnapshotsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

