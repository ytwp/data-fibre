// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.OLAPIndexHeaderMessage}
 */
public final class OLAPIndexHeaderMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.OLAPIndexHeaderMessage)
    OLAPIndexHeaderMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OLAPIndexHeaderMessage.newBuilder() to construct.
  private OLAPIndexHeaderMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OLAPIndexHeaderMessage() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new OLAPIndexHeaderMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_OLAPIndexHeaderMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_OLAPIndexHeaderMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.OLAPIndexHeaderMessage.class, io.datafibre.fibre.proto.OLAPIndexHeaderMessage.Builder.class);
  }

  private int bitField0_;
  public static final int START_VERSION_FIELD_NUMBER = 1;
  private int startVersion_;
  /**
   * <code>required int32 start_version = 1;</code>
   * @return Whether the startVersion field is set.
   */
  @java.lang.Override
  public boolean hasStartVersion() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required int32 start_version = 1;</code>
   * @return The startVersion.
   */
  @java.lang.Override
  public int getStartVersion() {
    return startVersion_;
  }

  public static final int END_VERSION_FIELD_NUMBER = 2;
  private int endVersion_;
  /**
   * <code>required int32 end_version = 2;</code>
   * @return Whether the endVersion field is set.
   */
  @java.lang.Override
  public boolean hasEndVersion() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>required int32 end_version = 2;</code>
   * @return The endVersion.
   */
  @java.lang.Override
  public int getEndVersion() {
    return endVersion_;
  }

  public static final int CUMULATIVE_VERSION_HASH_FIELD_NUMBER = 3;
  private long cumulativeVersionHash_;
  /**
   * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
   * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
   *     See olap_file.proto;l=303
   * @return Whether the cumulativeVersionHash field is set.
   */
  @java.lang.Override
  @java.lang.Deprecated public boolean hasCumulativeVersionHash() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
   * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
   *     See olap_file.proto;l=303
   * @return The cumulativeVersionHash.
   */
  @java.lang.Override
  @java.lang.Deprecated public long getCumulativeVersionHash() {
    return cumulativeVersionHash_;
  }

  public static final int SEGMENT_FIELD_NUMBER = 4;
  private int segment_;
  /**
   * <code>required uint32 segment = 4;</code>
   * @return Whether the segment field is set.
   */
  @java.lang.Override
  public boolean hasSegment() {
    return ((bitField0_ & 0x00000008) != 0);
  }
  /**
   * <code>required uint32 segment = 4;</code>
   * @return The segment.
   */
  @java.lang.Override
  public int getSegment() {
    return segment_;
  }

  public static final int NUM_ROWS_PER_BLOCK_FIELD_NUMBER = 5;
  private int numRowsPerBlock_;
  /**
   * <code>required uint32 num_rows_per_block = 5;</code>
   * @return Whether the numRowsPerBlock field is set.
   */
  @java.lang.Override
  public boolean hasNumRowsPerBlock() {
    return ((bitField0_ & 0x00000010) != 0);
  }
  /**
   * <code>required uint32 num_rows_per_block = 5;</code>
   * @return The numRowsPerBlock.
   */
  @java.lang.Override
  public int getNumRowsPerBlock() {
    return numRowsPerBlock_;
  }

  public static final int NULL_SUPPORTED_FIELD_NUMBER = 6;
  private boolean nullSupported_;
  /**
   * <code>optional bool null_supported = 6;</code>
   * @return Whether the nullSupported field is set.
   */
  @java.lang.Override
  public boolean hasNullSupported() {
    return ((bitField0_ & 0x00000020) != 0);
  }
  /**
   * <code>optional bool null_supported = 6;</code>
   * @return The nullSupported.
   */
  @java.lang.Override
  public boolean getNullSupported() {
    return nullSupported_;
  }

  public static final int DELETE_FLAG_FIELD_NUMBER = 7;
  private boolean deleteFlag_;
  /**
   * <code>optional bool delete_flag = 7;</code>
   * @return Whether the deleteFlag field is set.
   */
  @java.lang.Override
  public boolean hasDeleteFlag() {
    return ((bitField0_ & 0x00000040) != 0);
  }
  /**
   * <code>optional bool delete_flag = 7;</code>
   * @return The deleteFlag.
   */
  @java.lang.Override
  public boolean getDeleteFlag() {
    return deleteFlag_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasStartVersion()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasEndVersion()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasCumulativeVersionHash()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasSegment()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasNumRowsPerBlock()) {
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
      output.writeInt32(1, startVersion_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt32(2, endVersion_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeInt64(3, cumulativeVersionHash_);
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      output.writeUInt32(4, segment_);
    }
    if (((bitField0_ & 0x00000010) != 0)) {
      output.writeUInt32(5, numRowsPerBlock_);
    }
    if (((bitField0_ & 0x00000020) != 0)) {
      output.writeBool(6, nullSupported_);
    }
    if (((bitField0_ & 0x00000040) != 0)) {
      output.writeBool(7, deleteFlag_);
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
        .computeInt32Size(1, startVersion_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, endVersion_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, cumulativeVersionHash_);
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, segment_);
    }
    if (((bitField0_ & 0x00000010) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(5, numRowsPerBlock_);
    }
    if (((bitField0_ & 0x00000020) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(6, nullSupported_);
    }
    if (((bitField0_ & 0x00000040) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(7, deleteFlag_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.OLAPIndexHeaderMessage)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.OLAPIndexHeaderMessage other = (io.datafibre.fibre.proto.OLAPIndexHeaderMessage) obj;

    if (hasStartVersion() != other.hasStartVersion()) return false;
    if (hasStartVersion()) {
      if (getStartVersion()
          != other.getStartVersion()) return false;
    }
    if (hasEndVersion() != other.hasEndVersion()) return false;
    if (hasEndVersion()) {
      if (getEndVersion()
          != other.getEndVersion()) return false;
    }
    if (hasCumulativeVersionHash() != other.hasCumulativeVersionHash()) return false;
    if (hasCumulativeVersionHash()) {
      if (getCumulativeVersionHash()
          != other.getCumulativeVersionHash()) return false;
    }
    if (hasSegment() != other.hasSegment()) return false;
    if (hasSegment()) {
      if (getSegment()
          != other.getSegment()) return false;
    }
    if (hasNumRowsPerBlock() != other.hasNumRowsPerBlock()) return false;
    if (hasNumRowsPerBlock()) {
      if (getNumRowsPerBlock()
          != other.getNumRowsPerBlock()) return false;
    }
    if (hasNullSupported() != other.hasNullSupported()) return false;
    if (hasNullSupported()) {
      if (getNullSupported()
          != other.getNullSupported()) return false;
    }
    if (hasDeleteFlag() != other.hasDeleteFlag()) return false;
    if (hasDeleteFlag()) {
      if (getDeleteFlag()
          != other.getDeleteFlag()) return false;
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
    if (hasStartVersion()) {
      hash = (37 * hash) + START_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getStartVersion();
    }
    if (hasEndVersion()) {
      hash = (37 * hash) + END_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getEndVersion();
    }
    if (hasCumulativeVersionHash()) {
      hash = (37 * hash) + CUMULATIVE_VERSION_HASH_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getCumulativeVersionHash());
    }
    if (hasSegment()) {
      hash = (37 * hash) + SEGMENT_FIELD_NUMBER;
      hash = (53 * hash) + getSegment();
    }
    if (hasNumRowsPerBlock()) {
      hash = (37 * hash) + NUM_ROWS_PER_BLOCK_FIELD_NUMBER;
      hash = (53 * hash) + getNumRowsPerBlock();
    }
    if (hasNullSupported()) {
      hash = (37 * hash) + NULL_SUPPORTED_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getNullSupported());
    }
    if (hasDeleteFlag()) {
      hash = (37 * hash) + DELETE_FLAG_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getDeleteFlag());
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.OLAPIndexHeaderMessage prototype) {
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
   * Protobuf type {@code starrocks.OLAPIndexHeaderMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.OLAPIndexHeaderMessage)
      io.datafibre.fibre.proto.OLAPIndexHeaderMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_OLAPIndexHeaderMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_OLAPIndexHeaderMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.OLAPIndexHeaderMessage.class, io.datafibre.fibre.proto.OLAPIndexHeaderMessage.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.OLAPIndexHeaderMessage.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      startVersion_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      endVersion_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      cumulativeVersionHash_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000004);
      segment_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      numRowsPerBlock_ = 0;
      bitField0_ = (bitField0_ & ~0x00000010);
      nullSupported_ = false;
      bitField0_ = (bitField0_ & ~0x00000020);
      deleteFlag_ = false;
      bitField0_ = (bitField0_ & ~0x00000040);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_OLAPIndexHeaderMessage_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.OLAPIndexHeaderMessage getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.OLAPIndexHeaderMessage.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.OLAPIndexHeaderMessage build() {
      io.datafibre.fibre.proto.OLAPIndexHeaderMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.OLAPIndexHeaderMessage buildPartial() {
      io.datafibre.fibre.proto.OLAPIndexHeaderMessage result = new io.datafibre.fibre.proto.OLAPIndexHeaderMessage(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.startVersion_ = startVersion_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.endVersion_ = endVersion_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.cumulativeVersionHash_ = cumulativeVersionHash_;
        to_bitField0_ |= 0x00000004;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.segment_ = segment_;
        to_bitField0_ |= 0x00000008;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.numRowsPerBlock_ = numRowsPerBlock_;
        to_bitField0_ |= 0x00000010;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.nullSupported_ = nullSupported_;
        to_bitField0_ |= 0x00000020;
      }
      if (((from_bitField0_ & 0x00000040) != 0)) {
        result.deleteFlag_ = deleteFlag_;
        to_bitField0_ |= 0x00000040;
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
      if (other instanceof io.datafibre.fibre.proto.OLAPIndexHeaderMessage) {
        return mergeFrom((io.datafibre.fibre.proto.OLAPIndexHeaderMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.OLAPIndexHeaderMessage other) {
      if (other == io.datafibre.fibre.proto.OLAPIndexHeaderMessage.getDefaultInstance()) return this;
      if (other.hasStartVersion()) {
        setStartVersion(other.getStartVersion());
      }
      if (other.hasEndVersion()) {
        setEndVersion(other.getEndVersion());
      }
      if (other.hasCumulativeVersionHash()) {
        setCumulativeVersionHash(other.getCumulativeVersionHash());
      }
      if (other.hasSegment()) {
        setSegment(other.getSegment());
      }
      if (other.hasNumRowsPerBlock()) {
        setNumRowsPerBlock(other.getNumRowsPerBlock());
      }
      if (other.hasNullSupported()) {
        setNullSupported(other.getNullSupported());
      }
      if (other.hasDeleteFlag()) {
        setDeleteFlag(other.getDeleteFlag());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasStartVersion()) {
        return false;
      }
      if (!hasEndVersion()) {
        return false;
      }
      if (!hasCumulativeVersionHash()) {
        return false;
      }
      if (!hasSegment()) {
        return false;
      }
      if (!hasNumRowsPerBlock()) {
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
            case 8: {
              startVersion_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              endVersion_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              cumulativeVersionHash_ = input.readInt64();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 32: {
              segment_ = input.readUInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            case 40: {
              numRowsPerBlock_ = input.readUInt32();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            case 48: {
              nullSupported_ = input.readBool();
              bitField0_ |= 0x00000020;
              break;
            } // case 48
            case 56: {
              deleteFlag_ = input.readBool();
              bitField0_ |= 0x00000040;
              break;
            } // case 56
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

    private int startVersion_ ;
    /**
     * <code>required int32 start_version = 1;</code>
     * @return Whether the startVersion field is set.
     */
    @java.lang.Override
    public boolean hasStartVersion() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required int32 start_version = 1;</code>
     * @return The startVersion.
     */
    @java.lang.Override
    public int getStartVersion() {
      return startVersion_;
    }
    /**
     * <code>required int32 start_version = 1;</code>
     * @param value The startVersion to set.
     * @return This builder for chaining.
     */
    public Builder setStartVersion(int value) {
      bitField0_ |= 0x00000001;
      startVersion_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int32 start_version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStartVersion() {
      bitField0_ = (bitField0_ & ~0x00000001);
      startVersion_ = 0;
      onChanged();
      return this;
    }

    private int endVersion_ ;
    /**
     * <code>required int32 end_version = 2;</code>
     * @return Whether the endVersion field is set.
     */
    @java.lang.Override
    public boolean hasEndVersion() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required int32 end_version = 2;</code>
     * @return The endVersion.
     */
    @java.lang.Override
    public int getEndVersion() {
      return endVersion_;
    }
    /**
     * <code>required int32 end_version = 2;</code>
     * @param value The endVersion to set.
     * @return This builder for chaining.
     */
    public Builder setEndVersion(int value) {
      bitField0_ |= 0x00000002;
      endVersion_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int32 end_version = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearEndVersion() {
      bitField0_ = (bitField0_ & ~0x00000002);
      endVersion_ = 0;
      onChanged();
      return this;
    }

    private long cumulativeVersionHash_ ;
    /**
     * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
     * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
     *     See olap_file.proto;l=303
     * @return Whether the cumulativeVersionHash field is set.
     */
    @java.lang.Override
    @java.lang.Deprecated public boolean hasCumulativeVersionHash() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
     * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
     *     See olap_file.proto;l=303
     * @return The cumulativeVersionHash.
     */
    @java.lang.Override
    @java.lang.Deprecated public long getCumulativeVersionHash() {
      return cumulativeVersionHash_;
    }
    /**
     * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
     * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
     *     See olap_file.proto;l=303
     * @param value The cumulativeVersionHash to set.
     * @return This builder for chaining.
     */
    @java.lang.Deprecated public Builder setCumulativeVersionHash(long value) {
      bitField0_ |= 0x00000004;
      cumulativeVersionHash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
     * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
     *     See olap_file.proto;l=303
     * @return This builder for chaining.
     */
    @java.lang.Deprecated public Builder clearCumulativeVersionHash() {
      bitField0_ = (bitField0_ & ~0x00000004);
      cumulativeVersionHash_ = 0L;
      onChanged();
      return this;
    }

    private int segment_ ;
    /**
     * <code>required uint32 segment = 4;</code>
     * @return Whether the segment field is set.
     */
    @java.lang.Override
    public boolean hasSegment() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>required uint32 segment = 4;</code>
     * @return The segment.
     */
    @java.lang.Override
    public int getSegment() {
      return segment_;
    }
    /**
     * <code>required uint32 segment = 4;</code>
     * @param value The segment to set.
     * @return This builder for chaining.
     */
    public Builder setSegment(int value) {
      bitField0_ |= 0x00000008;
      segment_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 segment = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearSegment() {
      bitField0_ = (bitField0_ & ~0x00000008);
      segment_ = 0;
      onChanged();
      return this;
    }

    private int numRowsPerBlock_ ;
    /**
     * <code>required uint32 num_rows_per_block = 5;</code>
     * @return Whether the numRowsPerBlock field is set.
     */
    @java.lang.Override
    public boolean hasNumRowsPerBlock() {
      return ((bitField0_ & 0x00000010) != 0);
    }
    /**
     * <code>required uint32 num_rows_per_block = 5;</code>
     * @return The numRowsPerBlock.
     */
    @java.lang.Override
    public int getNumRowsPerBlock() {
      return numRowsPerBlock_;
    }
    /**
     * <code>required uint32 num_rows_per_block = 5;</code>
     * @param value The numRowsPerBlock to set.
     * @return This builder for chaining.
     */
    public Builder setNumRowsPerBlock(int value) {
      bitField0_ |= 0x00000010;
      numRowsPerBlock_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 num_rows_per_block = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumRowsPerBlock() {
      bitField0_ = (bitField0_ & ~0x00000010);
      numRowsPerBlock_ = 0;
      onChanged();
      return this;
    }

    private boolean nullSupported_ ;
    /**
     * <code>optional bool null_supported = 6;</code>
     * @return Whether the nullSupported field is set.
     */
    @java.lang.Override
    public boolean hasNullSupported() {
      return ((bitField0_ & 0x00000020) != 0);
    }
    /**
     * <code>optional bool null_supported = 6;</code>
     * @return The nullSupported.
     */
    @java.lang.Override
    public boolean getNullSupported() {
      return nullSupported_;
    }
    /**
     * <code>optional bool null_supported = 6;</code>
     * @param value The nullSupported to set.
     * @return This builder for chaining.
     */
    public Builder setNullSupported(boolean value) {
      bitField0_ |= 0x00000020;
      nullSupported_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool null_supported = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearNullSupported() {
      bitField0_ = (bitField0_ & ~0x00000020);
      nullSupported_ = false;
      onChanged();
      return this;
    }

    private boolean deleteFlag_ ;
    /**
     * <code>optional bool delete_flag = 7;</code>
     * @return Whether the deleteFlag field is set.
     */
    @java.lang.Override
    public boolean hasDeleteFlag() {
      return ((bitField0_ & 0x00000040) != 0);
    }
    /**
     * <code>optional bool delete_flag = 7;</code>
     * @return The deleteFlag.
     */
    @java.lang.Override
    public boolean getDeleteFlag() {
      return deleteFlag_;
    }
    /**
     * <code>optional bool delete_flag = 7;</code>
     * @param value The deleteFlag to set.
     * @return This builder for chaining.
     */
    public Builder setDeleteFlag(boolean value) {
      bitField0_ |= 0x00000040;
      deleteFlag_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool delete_flag = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearDeleteFlag() {
      bitField0_ = (bitField0_ & ~0x00000040);
      deleteFlag_ = false;
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


    // @@protoc_insertion_point(builder_scope:starrocks.OLAPIndexHeaderMessage)
  }

  // @@protoc_insertion_point(class_scope:starrocks.OLAPIndexHeaderMessage)
  private static final io.datafibre.fibre.proto.OLAPIndexHeaderMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.OLAPIndexHeaderMessage();
  }

  public static io.datafibre.fibre.proto.OLAPIndexHeaderMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<OLAPIndexHeaderMessage>
      PARSER = new com.google.protobuf.AbstractParser<OLAPIndexHeaderMessage>() {
    @java.lang.Override
    public OLAPIndexHeaderMessage parsePartialFrom(
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

  public static com.google.protobuf.Parser<OLAPIndexHeaderMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OLAPIndexHeaderMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.OLAPIndexHeaderMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

