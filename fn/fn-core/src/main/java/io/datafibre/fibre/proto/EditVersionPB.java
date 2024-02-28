// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_common.proto

package io.datafibre.fibre.proto;

/**
 * <pre>
 * An internal version for primary key tablet
 * Each commit will increase this version
 *   FE's publish will increase major by 1
 *   internal compaction will increase minor by 1
 * </pre>
 *
 * Protobuf type {@code starrocks.EditVersionPB}
 */
public final class EditVersionPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.EditVersionPB)
    EditVersionPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EditVersionPB.newBuilder() to construct.
  private EditVersionPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EditVersionPB() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EditVersionPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_EditVersionPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_EditVersionPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.EditVersionPB.class, io.datafibre.fibre.proto.EditVersionPB.Builder.class);
  }

  private int bitField0_;
  public static final int MAJOR_NUMBER_FIELD_NUMBER = 1;
  private long majorNumber_;
  /**
   * <code>optional int64 major_number = 1;</code>
   * @return Whether the majorNumber field is set.
   */
  @java.lang.Override
  public boolean hasMajorNumber() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional int64 major_number = 1;</code>
   * @return The majorNumber.
   */
  @java.lang.Override
  public long getMajorNumber() {
    return majorNumber_;
  }

  public static final int MINOR_NUMBER_FIELD_NUMBER = 2;
  private long minorNumber_;
  /**
   * <code>optional int64 minor_number = 2;</code>
   * @return Whether the minorNumber field is set.
   */
  @java.lang.Override
  public boolean hasMinorNumber() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional int64 minor_number = 2;</code>
   * @return The minorNumber.
   */
  @java.lang.Override
  public long getMinorNumber() {
    return minorNumber_;
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
      output.writeInt64(1, majorNumber_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt64(2, minorNumber_);
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
        .computeInt64Size(1, majorNumber_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, minorNumber_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.EditVersionPB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.EditVersionPB other = (io.datafibre.fibre.proto.EditVersionPB) obj;

    if (hasMajorNumber() != other.hasMajorNumber()) return false;
    if (hasMajorNumber()) {
      if (getMajorNumber()
          != other.getMajorNumber()) return false;
    }
    if (hasMinorNumber() != other.hasMinorNumber()) return false;
    if (hasMinorNumber()) {
      if (getMinorNumber()
          != other.getMinorNumber()) return false;
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
    if (hasMajorNumber()) {
      hash = (37 * hash) + MAJOR_NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMajorNumber());
    }
    if (hasMinorNumber()) {
      hash = (37 * hash) + MINOR_NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMinorNumber());
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.EditVersionPB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.EditVersionPB prototype) {
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
   * An internal version for primary key tablet
   * Each commit will increase this version
   *   FE's publish will increase major by 1
   *   internal compaction will increase minor by 1
   * </pre>
   *
   * Protobuf type {@code starrocks.EditVersionPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.EditVersionPB)
      io.datafibre.fibre.proto.EditVersionPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_EditVersionPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_EditVersionPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.EditVersionPB.class, io.datafibre.fibre.proto.EditVersionPB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.EditVersionPB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      majorNumber_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      minorNumber_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.OlapCommon.internal_static_starrocks_EditVersionPB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.EditVersionPB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.EditVersionPB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.EditVersionPB build() {
      io.datafibre.fibre.proto.EditVersionPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.EditVersionPB buildPartial() {
      io.datafibre.fibre.proto.EditVersionPB result = new io.datafibre.fibre.proto.EditVersionPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.majorNumber_ = majorNumber_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.minorNumber_ = minorNumber_;
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
      if (other instanceof io.datafibre.fibre.proto.EditVersionPB) {
        return mergeFrom((io.datafibre.fibre.proto.EditVersionPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.EditVersionPB other) {
      if (other == io.datafibre.fibre.proto.EditVersionPB.getDefaultInstance()) return this;
      if (other.hasMajorNumber()) {
        setMajorNumber(other.getMajorNumber());
      }
      if (other.hasMinorNumber()) {
        setMinorNumber(other.getMinorNumber());
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
              majorNumber_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              minorNumber_ = input.readInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
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

    private long majorNumber_ ;
    /**
     * <code>optional int64 major_number = 1;</code>
     * @return Whether the majorNumber field is set.
     */
    @java.lang.Override
    public boolean hasMajorNumber() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional int64 major_number = 1;</code>
     * @return The majorNumber.
     */
    @java.lang.Override
    public long getMajorNumber() {
      return majorNumber_;
    }
    /**
     * <code>optional int64 major_number = 1;</code>
     * @param value The majorNumber to set.
     * @return This builder for chaining.
     */
    public Builder setMajorNumber(long value) {
      bitField0_ |= 0x00000001;
      majorNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 major_number = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMajorNumber() {
      bitField0_ = (bitField0_ & ~0x00000001);
      majorNumber_ = 0L;
      onChanged();
      return this;
    }

    private long minorNumber_ ;
    /**
     * <code>optional int64 minor_number = 2;</code>
     * @return Whether the minorNumber field is set.
     */
    @java.lang.Override
    public boolean hasMinorNumber() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int64 minor_number = 2;</code>
     * @return The minorNumber.
     */
    @java.lang.Override
    public long getMinorNumber() {
      return minorNumber_;
    }
    /**
     * <code>optional int64 minor_number = 2;</code>
     * @param value The minorNumber to set.
     * @return This builder for chaining.
     */
    public Builder setMinorNumber(long value) {
      bitField0_ |= 0x00000002;
      minorNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 minor_number = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMinorNumber() {
      bitField0_ = (bitField0_ & ~0x00000002);
      minorNumber_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:starrocks.EditVersionPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.EditVersionPB)
  private static final io.datafibre.fibre.proto.EditVersionPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.EditVersionPB();
  }

  public static io.datafibre.fibre.proto.EditVersionPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<EditVersionPB>
      PARSER = new com.google.protobuf.AbstractParser<EditVersionPB>() {
    @java.lang.Override
    public EditVersionPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<EditVersionPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EditVersionPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.EditVersionPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

