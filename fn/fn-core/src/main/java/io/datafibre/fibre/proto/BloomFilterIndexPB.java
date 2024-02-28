// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.BloomFilterIndexPB}
 */
public final class BloomFilterIndexPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.BloomFilterIndexPB)
    BloomFilterIndexPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BloomFilterIndexPB.newBuilder() to construct.
  private BloomFilterIndexPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BloomFilterIndexPB() {
    hashStrategy_ = 0;
    algorithm_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BloomFilterIndexPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.Segment.internal_static_starrocks_BloomFilterIndexPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.Segment.internal_static_starrocks_BloomFilterIndexPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.BloomFilterIndexPB.class, io.datafibre.fibre.proto.BloomFilterIndexPB.Builder.class);
  }

  private int bitField0_;
  public static final int HASH_STRATEGY_FIELD_NUMBER = 1;
  private int hashStrategy_;
  /**
   * <pre>
   * required
   * </pre>
   *
   * <code>optional .starrocks.HashStrategyPB hash_strategy = 1;</code>
   * @return Whether the hashStrategy field is set.
   */
  @java.lang.Override public boolean hasHashStrategy() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * required
   * </pre>
   *
   * <code>optional .starrocks.HashStrategyPB hash_strategy = 1;</code>
   * @return The hashStrategy.
   */
  @java.lang.Override public io.datafibre.fibre.proto.HashStrategyPB getHashStrategy() {
    @SuppressWarnings("deprecation")
    io.datafibre.fibre.proto.HashStrategyPB result = io.datafibre.fibre.proto.HashStrategyPB.valueOf(hashStrategy_);
    return result == null ? io.datafibre.fibre.proto.HashStrategyPB.HASH_MURMUR3_X64_64 : result;
  }

  public static final int ALGORITHM_FIELD_NUMBER = 2;
  private int algorithm_;
  /**
   * <code>optional .starrocks.BloomFilterAlgorithmPB algorithm = 2;</code>
   * @return Whether the algorithm field is set.
   */
  @java.lang.Override public boolean hasAlgorithm() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional .starrocks.BloomFilterAlgorithmPB algorithm = 2;</code>
   * @return The algorithm.
   */
  @java.lang.Override public io.datafibre.fibre.proto.BloomFilterAlgorithmPB getAlgorithm() {
    @SuppressWarnings("deprecation")
    io.datafibre.fibre.proto.BloomFilterAlgorithmPB result = io.datafibre.fibre.proto.BloomFilterAlgorithmPB.valueOf(algorithm_);
    return result == null ? io.datafibre.fibre.proto.BloomFilterAlgorithmPB.BLOCK_BLOOM_FILTER : result;
  }

  public static final int BLOOM_FILTER_FIELD_NUMBER = 3;
  private io.datafibre.fibre.proto.IndexedColumnMetaPB bloomFilter_;
  /**
   * <pre>
   * required: meta for bloom filters
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
   * @return Whether the bloomFilter field is set.
   */
  @java.lang.Override
  public boolean hasBloomFilter() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <pre>
   * required: meta for bloom filters
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
   * @return The bloomFilter.
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.IndexedColumnMetaPB getBloomFilter() {
    return bloomFilter_ == null ? io.datafibre.fibre.proto.IndexedColumnMetaPB.getDefaultInstance() : bloomFilter_;
  }
  /**
   * <pre>
   * required: meta for bloom filters
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.IndexedColumnMetaPBOrBuilder getBloomFilterOrBuilder() {
    return bloomFilter_ == null ? io.datafibre.fibre.proto.IndexedColumnMetaPB.getDefaultInstance() : bloomFilter_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (hasBloomFilter()) {
      if (!getBloomFilter().isInitialized()) {
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
      output.writeEnum(1, hashStrategy_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeEnum(2, algorithm_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeMessage(3, getBloomFilter());
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
        .computeEnumSize(1, hashStrategy_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, algorithm_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getBloomFilter());
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
    if (!(obj instanceof io.datafibre.fibre.proto.BloomFilterIndexPB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.BloomFilterIndexPB other = (io.datafibre.fibre.proto.BloomFilterIndexPB) obj;

    if (hasHashStrategy() != other.hasHashStrategy()) return false;
    if (hasHashStrategy()) {
      if (hashStrategy_ != other.hashStrategy_) return false;
    }
    if (hasAlgorithm() != other.hasAlgorithm()) return false;
    if (hasAlgorithm()) {
      if (algorithm_ != other.algorithm_) return false;
    }
    if (hasBloomFilter() != other.hasBloomFilter()) return false;
    if (hasBloomFilter()) {
      if (!getBloomFilter()
          .equals(other.getBloomFilter())) return false;
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
    if (hasHashStrategy()) {
      hash = (37 * hash) + HASH_STRATEGY_FIELD_NUMBER;
      hash = (53 * hash) + hashStrategy_;
    }
    if (hasAlgorithm()) {
      hash = (37 * hash) + ALGORITHM_FIELD_NUMBER;
      hash = (53 * hash) + algorithm_;
    }
    if (hasBloomFilter()) {
      hash = (37 * hash) + BLOOM_FILTER_FIELD_NUMBER;
      hash = (53 * hash) + getBloomFilter().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.BloomFilterIndexPB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.BloomFilterIndexPB prototype) {
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
   * Protobuf type {@code starrocks.BloomFilterIndexPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.BloomFilterIndexPB)
      io.datafibre.fibre.proto.BloomFilterIndexPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_BloomFilterIndexPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_BloomFilterIndexPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.BloomFilterIndexPB.class, io.datafibre.fibre.proto.BloomFilterIndexPB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.BloomFilterIndexPB.newBuilder()
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
        getBloomFilterFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      hashStrategy_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      algorithm_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      if (bloomFilterBuilder_ == null) {
        bloomFilter_ = null;
      } else {
        bloomFilterBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_BloomFilterIndexPB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.BloomFilterIndexPB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.BloomFilterIndexPB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.BloomFilterIndexPB build() {
      io.datafibre.fibre.proto.BloomFilterIndexPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.BloomFilterIndexPB buildPartial() {
      io.datafibre.fibre.proto.BloomFilterIndexPB result = new io.datafibre.fibre.proto.BloomFilterIndexPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.hashStrategy_ = hashStrategy_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.algorithm_ = algorithm_;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        if (bloomFilterBuilder_ == null) {
          result.bloomFilter_ = bloomFilter_;
        } else {
          result.bloomFilter_ = bloomFilterBuilder_.build();
        }
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
      if (other instanceof io.datafibre.fibre.proto.BloomFilterIndexPB) {
        return mergeFrom((io.datafibre.fibre.proto.BloomFilterIndexPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.BloomFilterIndexPB other) {
      if (other == io.datafibre.fibre.proto.BloomFilterIndexPB.getDefaultInstance()) return this;
      if (other.hasHashStrategy()) {
        setHashStrategy(other.getHashStrategy());
      }
      if (other.hasAlgorithm()) {
        setAlgorithm(other.getAlgorithm());
      }
      if (other.hasBloomFilter()) {
        mergeBloomFilter(other.getBloomFilter());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (hasBloomFilter()) {
        if (!getBloomFilter().isInitialized()) {
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
            case 8: {
              int tmpRaw = input.readEnum();
              io.datafibre.fibre.proto.HashStrategyPB tmpValue =
                  io.datafibre.fibre.proto.HashStrategyPB.forNumber(tmpRaw);
              if (tmpValue == null) {
                mergeUnknownVarintField(1, tmpRaw);
              } else {
                hashStrategy_ = tmpRaw;
                bitField0_ |= 0x00000001;
              }
              break;
            } // case 8
            case 16: {
              int tmpRaw = input.readEnum();
              io.datafibre.fibre.proto.BloomFilterAlgorithmPB tmpValue =
                  io.datafibre.fibre.proto.BloomFilterAlgorithmPB.forNumber(tmpRaw);
              if (tmpValue == null) {
                mergeUnknownVarintField(2, tmpRaw);
              } else {
                algorithm_ = tmpRaw;
                bitField0_ |= 0x00000002;
              }
              break;
            } // case 16
            case 26: {
              input.readMessage(
                  getBloomFilterFieldBuilder().getBuilder(),
                  extensionRegistry);
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

    private int hashStrategy_ = 0;
    /**
     * <pre>
     * required
     * </pre>
     *
     * <code>optional .starrocks.HashStrategyPB hash_strategy = 1;</code>
     * @return Whether the hashStrategy field is set.
     */
    @java.lang.Override public boolean hasHashStrategy() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * required
     * </pre>
     *
     * <code>optional .starrocks.HashStrategyPB hash_strategy = 1;</code>
     * @return The hashStrategy.
     */
    @java.lang.Override
    public io.datafibre.fibre.proto.HashStrategyPB getHashStrategy() {
      @SuppressWarnings("deprecation")
      io.datafibre.fibre.proto.HashStrategyPB result = io.datafibre.fibre.proto.HashStrategyPB.valueOf(hashStrategy_);
      return result == null ? io.datafibre.fibre.proto.HashStrategyPB.HASH_MURMUR3_X64_64 : result;
    }
    /**
     * <pre>
     * required
     * </pre>
     *
     * <code>optional .starrocks.HashStrategyPB hash_strategy = 1;</code>
     * @param value The hashStrategy to set.
     * @return This builder for chaining.
     */
    public Builder setHashStrategy(io.datafibre.fibre.proto.HashStrategyPB value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      hashStrategy_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * required
     * </pre>
     *
     * <code>optional .starrocks.HashStrategyPB hash_strategy = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearHashStrategy() {
      bitField0_ = (bitField0_ & ~0x00000001);
      hashStrategy_ = 0;
      onChanged();
      return this;
    }

    private int algorithm_ = 0;
    /**
     * <code>optional .starrocks.BloomFilterAlgorithmPB algorithm = 2;</code>
     * @return Whether the algorithm field is set.
     */
    @java.lang.Override public boolean hasAlgorithm() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .starrocks.BloomFilterAlgorithmPB algorithm = 2;</code>
     * @return The algorithm.
     */
    @java.lang.Override
    public io.datafibre.fibre.proto.BloomFilterAlgorithmPB getAlgorithm() {
      @SuppressWarnings("deprecation")
      io.datafibre.fibre.proto.BloomFilterAlgorithmPB result = io.datafibre.fibre.proto.BloomFilterAlgorithmPB.valueOf(algorithm_);
      return result == null ? io.datafibre.fibre.proto.BloomFilterAlgorithmPB.BLOCK_BLOOM_FILTER : result;
    }
    /**
     * <code>optional .starrocks.BloomFilterAlgorithmPB algorithm = 2;</code>
     * @param value The algorithm to set.
     * @return This builder for chaining.
     */
    public Builder setAlgorithm(io.datafibre.fibre.proto.BloomFilterAlgorithmPB value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      algorithm_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .starrocks.BloomFilterAlgorithmPB algorithm = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAlgorithm() {
      bitField0_ = (bitField0_ & ~0x00000002);
      algorithm_ = 0;
      onChanged();
      return this;
    }

    private io.datafibre.fibre.proto.IndexedColumnMetaPB bloomFilter_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.IndexedColumnMetaPB, io.datafibre.fibre.proto.IndexedColumnMetaPB.Builder, io.datafibre.fibre.proto.IndexedColumnMetaPBOrBuilder> bloomFilterBuilder_;
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     * @return Whether the bloomFilter field is set.
     */
    public boolean hasBloomFilter() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     * @return The bloomFilter.
     */
    public io.datafibre.fibre.proto.IndexedColumnMetaPB getBloomFilter() {
      if (bloomFilterBuilder_ == null) {
        return bloomFilter_ == null ? io.datafibre.fibre.proto.IndexedColumnMetaPB.getDefaultInstance() : bloomFilter_;
      } else {
        return bloomFilterBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     */
    public Builder setBloomFilter(io.datafibre.fibre.proto.IndexedColumnMetaPB value) {
      if (bloomFilterBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        bloomFilter_ = value;
        onChanged();
      } else {
        bloomFilterBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     */
    public Builder setBloomFilter(
        io.datafibre.fibre.proto.IndexedColumnMetaPB.Builder builderForValue) {
      if (bloomFilterBuilder_ == null) {
        bloomFilter_ = builderForValue.build();
        onChanged();
      } else {
        bloomFilterBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     */
    public Builder mergeBloomFilter(io.datafibre.fibre.proto.IndexedColumnMetaPB value) {
      if (bloomFilterBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
            bloomFilter_ != null &&
            bloomFilter_ != io.datafibre.fibre.proto.IndexedColumnMetaPB.getDefaultInstance()) {
          bloomFilter_ =
            io.datafibre.fibre.proto.IndexedColumnMetaPB.newBuilder(bloomFilter_).mergeFrom(value).buildPartial();
        } else {
          bloomFilter_ = value;
        }
        onChanged();
      } else {
        bloomFilterBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     */
    public Builder clearBloomFilter() {
      if (bloomFilterBuilder_ == null) {
        bloomFilter_ = null;
        onChanged();
      } else {
        bloomFilterBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     */
    public io.datafibre.fibre.proto.IndexedColumnMetaPB.Builder getBloomFilterBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getBloomFilterFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     */
    public io.datafibre.fibre.proto.IndexedColumnMetaPBOrBuilder getBloomFilterOrBuilder() {
      if (bloomFilterBuilder_ != null) {
        return bloomFilterBuilder_.getMessageOrBuilder();
      } else {
        return bloomFilter_ == null ?
            io.datafibre.fibre.proto.IndexedColumnMetaPB.getDefaultInstance() : bloomFilter_;
      }
    }
    /**
     * <pre>
     * required: meta for bloom filters
     * </pre>
     *
     * <code>optional .starrocks.IndexedColumnMetaPB bloom_filter = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.IndexedColumnMetaPB, io.datafibre.fibre.proto.IndexedColumnMetaPB.Builder, io.datafibre.fibre.proto.IndexedColumnMetaPBOrBuilder>
        getBloomFilterFieldBuilder() {
      if (bloomFilterBuilder_ == null) {
        bloomFilterBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.datafibre.fibre.proto.IndexedColumnMetaPB, io.datafibre.fibre.proto.IndexedColumnMetaPB.Builder, io.datafibre.fibre.proto.IndexedColumnMetaPBOrBuilder>(
                getBloomFilter(),
                getParentForChildren(),
                isClean());
        bloomFilter_ = null;
      }
      return bloomFilterBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.BloomFilterIndexPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.BloomFilterIndexPB)
  private static final io.datafibre.fibre.proto.BloomFilterIndexPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.BloomFilterIndexPB();
  }

  public static io.datafibre.fibre.proto.BloomFilterIndexPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<BloomFilterIndexPB>
      PARSER = new com.google.protobuf.AbstractParser<BloomFilterIndexPB>() {
    @java.lang.Override
    public BloomFilterIndexPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<BloomFilterIndexPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BloomFilterIndexPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.BloomFilterIndexPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

