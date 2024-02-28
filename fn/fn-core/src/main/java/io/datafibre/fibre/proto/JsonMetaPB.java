// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package io.datafibre.fibre.proto;

/**
 * <pre>
 * Metadata for JSON type column
 * </pre>
 *
 * Protobuf type {@code starrocks.JsonMetaPB}
 */
public final class JsonMetaPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.JsonMetaPB)
    JsonMetaPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use JsonMetaPB.newBuilder() to construct.
  private JsonMetaPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private JsonMetaPB() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new JsonMetaPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.Segment.internal_static_starrocks_JsonMetaPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.Segment.internal_static_starrocks_JsonMetaPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.JsonMetaPB.class, io.datafibre.fibre.proto.JsonMetaPB.Builder.class);
  }

  private int bitField0_;
  public static final int FORMAT_VERSION_FIELD_NUMBER = 1;
  private int formatVersion_;
  /**
   * <pre>
   * Format version
   * Version 1: encode each JSON datum individually, as so called row-oriented format
   * Version 2(WIP): columnar encoding for JSON
   * </pre>
   *
   * <code>optional uint32 format_version = 1;</code>
   * @return Whether the formatVersion field is set.
   */
  @java.lang.Override
  public boolean hasFormatVersion() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * Format version
   * Version 1: encode each JSON datum individually, as so called row-oriented format
   * Version 2(WIP): columnar encoding for JSON
   * </pre>
   *
   * <code>optional uint32 format_version = 1;</code>
   * @return The formatVersion.
   */
  @java.lang.Override
  public int getFormatVersion() {
    return formatVersion_;
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
      output.writeUInt32(1, formatVersion_);
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
        .computeUInt32Size(1, formatVersion_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.JsonMetaPB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.JsonMetaPB other = (io.datafibre.fibre.proto.JsonMetaPB) obj;

    if (hasFormatVersion() != other.hasFormatVersion()) return false;
    if (hasFormatVersion()) {
      if (getFormatVersion()
          != other.getFormatVersion()) return false;
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
    if (hasFormatVersion()) {
      hash = (37 * hash) + FORMAT_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getFormatVersion();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.JsonMetaPB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.JsonMetaPB prototype) {
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
   * <pre>
   * Metadata for JSON type column
   * </pre>
   *
   * Protobuf type {@code starrocks.JsonMetaPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.JsonMetaPB)
      io.datafibre.fibre.proto.JsonMetaPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_JsonMetaPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_JsonMetaPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.JsonMetaPB.class, io.datafibre.fibre.proto.JsonMetaPB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.JsonMetaPB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      formatVersion_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_JsonMetaPB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.JsonMetaPB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.JsonMetaPB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.JsonMetaPB build() {
      io.datafibre.fibre.proto.JsonMetaPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.JsonMetaPB buildPartial() {
      io.datafibre.fibre.proto.JsonMetaPB result = new io.datafibre.fibre.proto.JsonMetaPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.formatVersion_ = formatVersion_;
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
      if (other instanceof io.datafibre.fibre.proto.JsonMetaPB) {
        return mergeFrom((io.datafibre.fibre.proto.JsonMetaPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.JsonMetaPB other) {
      if (other == io.datafibre.fibre.proto.JsonMetaPB.getDefaultInstance()) return this;
      if (other.hasFormatVersion()) {
        setFormatVersion(other.getFormatVersion());
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
              formatVersion_ = input.readUInt32();
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

    private int formatVersion_ ;
    /**
     * <pre>
     * Format version
     * Version 1: encode each JSON datum individually, as so called row-oriented format
     * Version 2(WIP): columnar encoding for JSON
     * </pre>
     *
     * <code>optional uint32 format_version = 1;</code>
     * @return Whether the formatVersion field is set.
     */
    @java.lang.Override
    public boolean hasFormatVersion() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * Format version
     * Version 1: encode each JSON datum individually, as so called row-oriented format
     * Version 2(WIP): columnar encoding for JSON
     * </pre>
     *
     * <code>optional uint32 format_version = 1;</code>
     * @return The formatVersion.
     */
    @java.lang.Override
    public int getFormatVersion() {
      return formatVersion_;
    }
    /**
     * <pre>
     * Format version
     * Version 1: encode each JSON datum individually, as so called row-oriented format
     * Version 2(WIP): columnar encoding for JSON
     * </pre>
     *
     * <code>optional uint32 format_version = 1;</code>
     * @param value The formatVersion to set.
     * @return This builder for chaining.
     */
    public Builder setFormatVersion(int value) {
      bitField0_ |= 0x00000001;
      formatVersion_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Format version
     * Version 1: encode each JSON datum individually, as so called row-oriented format
     * Version 2(WIP): columnar encoding for JSON
     * </pre>
     *
     * <code>optional uint32 format_version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFormatVersion() {
      bitField0_ = (bitField0_ & ~0x00000001);
      formatVersion_ = 0;
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


    // @@protoc_insertion_point(builder_scope:starrocks.JsonMetaPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.JsonMetaPB)
  private static final io.datafibre.fibre.proto.JsonMetaPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.JsonMetaPB();
  }

  public static io.datafibre.fibre.proto.JsonMetaPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<JsonMetaPB>
      PARSER = new com.google.protobuf.AbstractParser<JsonMetaPB>() {
    @java.lang.Override
    public JsonMetaPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<JsonMetaPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<JsonMetaPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.JsonMetaPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

