// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_types.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.lake.DelvecPagePB}
 */
public final class DelvecPagePB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.lake.DelvecPagePB)
    DelvecPagePBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DelvecPagePB.newBuilder() to construct.
  private DelvecPagePB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DelvecPagePB() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DelvecPagePB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.LakeTypes.internal_static_starrocks_lake_DelvecPagePB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.LakeTypes.internal_static_starrocks_lake_DelvecPagePB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.DelvecPagePB.class, io.datafibre.fibre.proto.DelvecPagePB.Builder.class);
  }

  private int bitField0_;
  public static final int VERSION_FIELD_NUMBER = 1;
  private long version_;
  /**
   * <code>optional int64 version = 1;</code>
   * @return Whether the version field is set.
   */
  @java.lang.Override
  public boolean hasVersion() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional int64 version = 1;</code>
   * @return The version.
   */
  @java.lang.Override
  public long getVersion() {
    return version_;
  }

  public static final int OFFSET_FIELD_NUMBER = 2;
  private long offset_;
  /**
   * <pre>
   * position in file
   * </pre>
   *
   * <code>optional uint64 offset = 2;</code>
   * @return Whether the offset field is set.
   */
  @java.lang.Override
  public boolean hasOffset() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <pre>
   * position in file
   * </pre>
   *
   * <code>optional uint64 offset = 2;</code>
   * @return The offset.
   */
  @java.lang.Override
  public long getOffset() {
    return offset_;
  }

  public static final int SIZE_FIELD_NUMBER = 3;
  private long size_;
  /**
   * <code>optional uint64 size = 3;</code>
   * @return Whether the size field is set.
   */
  @java.lang.Override
  public boolean hasSize() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional uint64 size = 3;</code>
   * @return The size.
   */
  @java.lang.Override
  public long getSize() {
    return size_;
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
      output.writeInt64(1, version_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeUInt64(2, offset_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeUInt64(3, size_);
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
        .computeInt64Size(1, version_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, offset_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, size_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.DelvecPagePB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.DelvecPagePB other = (io.datafibre.fibre.proto.DelvecPagePB) obj;

    if (hasVersion() != other.hasVersion()) return false;
    if (hasVersion()) {
      if (getVersion()
          != other.getVersion()) return false;
    }
    if (hasOffset() != other.hasOffset()) return false;
    if (hasOffset()) {
      if (getOffset()
          != other.getOffset()) return false;
    }
    if (hasSize() != other.hasSize()) return false;
    if (hasSize()) {
      if (getSize()
          != other.getSize()) return false;
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
    if (hasVersion()) {
      hash = (37 * hash) + VERSION_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getVersion());
    }
    if (hasOffset()) {
      hash = (37 * hash) + OFFSET_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getOffset());
    }
    if (hasSize()) {
      hash = (37 * hash) + SIZE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getSize());
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.DelvecPagePB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.DelvecPagePB prototype) {
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
   * Protobuf type {@code starrocks.lake.DelvecPagePB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.lake.DelvecPagePB)
      io.datafibre.fibre.proto.DelvecPagePBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.LakeTypes.internal_static_starrocks_lake_DelvecPagePB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.LakeTypes.internal_static_starrocks_lake_DelvecPagePB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.DelvecPagePB.class, io.datafibre.fibre.proto.DelvecPagePB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.DelvecPagePB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      version_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      offset_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      size_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.LakeTypes.internal_static_starrocks_lake_DelvecPagePB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DelvecPagePB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.DelvecPagePB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DelvecPagePB build() {
      io.datafibre.fibre.proto.DelvecPagePB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.DelvecPagePB buildPartial() {
      io.datafibre.fibre.proto.DelvecPagePB result = new io.datafibre.fibre.proto.DelvecPagePB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.version_ = version_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.offset_ = offset_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.size_ = size_;
        to_bitField0_ |= 0x00000004;
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
      if (other instanceof io.datafibre.fibre.proto.DelvecPagePB) {
        return mergeFrom((io.datafibre.fibre.proto.DelvecPagePB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.DelvecPagePB other) {
      if (other == io.datafibre.fibre.proto.DelvecPagePB.getDefaultInstance()) return this;
      if (other.hasVersion()) {
        setVersion(other.getVersion());
      }
      if (other.hasOffset()) {
        setOffset(other.getOffset());
      }
      if (other.hasSize()) {
        setSize(other.getSize());
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
              version_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              offset_ = input.readUInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              size_ = input.readUInt64();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
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

    private long version_ ;
    /**
     * <code>optional int64 version = 1;</code>
     * @return Whether the version field is set.
     */
    @java.lang.Override
    public boolean hasVersion() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional int64 version = 1;</code>
     * @return The version.
     */
    @java.lang.Override
    public long getVersion() {
      return version_;
    }
    /**
     * <code>optional int64 version = 1;</code>
     * @param value The version to set.
     * @return This builder for chaining.
     */
    public Builder setVersion(long value) {
      bitField0_ |= 0x00000001;
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearVersion() {
      bitField0_ = (bitField0_ & ~0x00000001);
      version_ = 0L;
      onChanged();
      return this;
    }

    private long offset_ ;
    /**
     * <pre>
     * position in file
     * </pre>
     *
     * <code>optional uint64 offset = 2;</code>
     * @return Whether the offset field is set.
     */
    @java.lang.Override
    public boolean hasOffset() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * position in file
     * </pre>
     *
     * <code>optional uint64 offset = 2;</code>
     * @return The offset.
     */
    @java.lang.Override
    public long getOffset() {
      return offset_;
    }
    /**
     * <pre>
     * position in file
     * </pre>
     *
     * <code>optional uint64 offset = 2;</code>
     * @param value The offset to set.
     * @return This builder for chaining.
     */
    public Builder setOffset(long value) {
      bitField0_ |= 0x00000002;
      offset_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * position in file
     * </pre>
     *
     * <code>optional uint64 offset = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearOffset() {
      bitField0_ = (bitField0_ & ~0x00000002);
      offset_ = 0L;
      onChanged();
      return this;
    }

    private long size_ ;
    /**
     * <code>optional uint64 size = 3;</code>
     * @return Whether the size field is set.
     */
    @java.lang.Override
    public boolean hasSize() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional uint64 size = 3;</code>
     * @return The size.
     */
    @java.lang.Override
    public long getSize() {
      return size_;
    }
    /**
     * <code>optional uint64 size = 3;</code>
     * @param value The size to set.
     * @return This builder for chaining.
     */
    public Builder setSize(long value) {
      bitField0_ |= 0x00000004;
      size_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 size = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSize() {
      bitField0_ = (bitField0_ & ~0x00000004);
      size_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:starrocks.lake.DelvecPagePB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.lake.DelvecPagePB)
  private static final io.datafibre.fibre.proto.DelvecPagePB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.DelvecPagePB();
  }

  public static io.datafibre.fibre.proto.DelvecPagePB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<DelvecPagePB>
      PARSER = new com.google.protobuf.AbstractParser<DelvecPagePB>() {
    @java.lang.Override
    public DelvecPagePB parsePartialFrom(
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

  public static com.google.protobuf.Parser<DelvecPagePB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DelvecPagePB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.DelvecPagePB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
