// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_types.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.lake.DelvecCacheKeyPB}
 */
public final class DelvecCacheKeyPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.lake.DelvecCacheKeyPB)
    DelvecCacheKeyPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DelvecCacheKeyPB.newBuilder() to construct.
  private DelvecCacheKeyPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DelvecCacheKeyPB() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DelvecCacheKeyPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.LakeTypes.internal_static_starrocks_lake_DelvecCacheKeyPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.LakeTypes.internal_static_starrocks_lake_DelvecCacheKeyPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.DelvecCacheKeyPB.class, com.starrocks.proto.DelvecCacheKeyPB.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>optional int64 id = 1;</code>
   * @return Whether the id field is set.
   */
  @java.lang.Override
  public boolean hasId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional int64 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public long getId() {
    return id_;
  }

  public static final int DELVEC_PAGE_FIELD_NUMBER = 2;
  private com.starrocks.proto.DelvecPagePB delvecPage_;
  /**
   * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
   * @return Whether the delvecPage field is set.
   */
  @java.lang.Override
  public boolean hasDelvecPage() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
   * @return The delvecPage.
   */
  @java.lang.Override
  public com.starrocks.proto.DelvecPagePB getDelvecPage() {
    return delvecPage_ == null ? com.starrocks.proto.DelvecPagePB.getDefaultInstance() : delvecPage_;
  }
  /**
   * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.DelvecPagePBOrBuilder getDelvecPageOrBuilder() {
    return delvecPage_ == null ? com.starrocks.proto.DelvecPagePB.getDefaultInstance() : delvecPage_;
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
      output.writeInt64(1, id_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getDelvecPage());
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
        .computeInt64Size(1, id_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getDelvecPage());
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
    if (!(obj instanceof com.starrocks.proto.DelvecCacheKeyPB)) {
      return super.equals(obj);
    }
    com.starrocks.proto.DelvecCacheKeyPB other = (com.starrocks.proto.DelvecCacheKeyPB) obj;

    if (hasId() != other.hasId()) return false;
    if (hasId()) {
      if (getId()
          != other.getId()) return false;
    }
    if (hasDelvecPage() != other.hasDelvecPage()) return false;
    if (hasDelvecPage()) {
      if (!getDelvecPage()
          .equals(other.getDelvecPage())) return false;
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
    if (hasId()) {
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getId());
    }
    if (hasDelvecPage()) {
      hash = (37 * hash) + DELVEC_PAGE_FIELD_NUMBER;
      hash = (53 * hash) + getDelvecPage().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.DelvecCacheKeyPB parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.DelvecCacheKeyPB prototype) {
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
   * Protobuf type {@code starrocks.lake.DelvecCacheKeyPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.lake.DelvecCacheKeyPB)
      com.starrocks.proto.DelvecCacheKeyPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.LakeTypes.internal_static_starrocks_lake_DelvecCacheKeyPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.LakeTypes.internal_static_starrocks_lake_DelvecCacheKeyPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.DelvecCacheKeyPB.class, com.starrocks.proto.DelvecCacheKeyPB.Builder.class);
    }

    // Construct using com.starrocks.proto.DelvecCacheKeyPB.newBuilder()
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
        getDelvecPageFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      id_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (delvecPageBuilder_ == null) {
        delvecPage_ = null;
      } else {
        delvecPageBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.LakeTypes.internal_static_starrocks_lake_DelvecCacheKeyPB_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.DelvecCacheKeyPB getDefaultInstanceForType() {
      return com.starrocks.proto.DelvecCacheKeyPB.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.DelvecCacheKeyPB build() {
      com.starrocks.proto.DelvecCacheKeyPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.DelvecCacheKeyPB buildPartial() {
      com.starrocks.proto.DelvecCacheKeyPB result = new com.starrocks.proto.DelvecCacheKeyPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        if (delvecPageBuilder_ == null) {
          result.delvecPage_ = delvecPage_;
        } else {
          result.delvecPage_ = delvecPageBuilder_.build();
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
      if (other instanceof com.starrocks.proto.DelvecCacheKeyPB) {
        return mergeFrom((com.starrocks.proto.DelvecCacheKeyPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.DelvecCacheKeyPB other) {
      if (other == com.starrocks.proto.DelvecCacheKeyPB.getDefaultInstance()) return this;
      if (other.hasId()) {
        setId(other.getId());
      }
      if (other.hasDelvecPage()) {
        mergeDelvecPage(other.getDelvecPage());
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
              id_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              input.readMessage(
                  getDelvecPageFieldBuilder().getBuilder(),
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

    private long id_ ;
    /**
     * <code>optional int64 id = 1;</code>
     * @return Whether the id field is set.
     */
    @java.lang.Override
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional int64 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public long getId() {
      return id_;
    }
    /**
     * <code>optional int64 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {
      bitField0_ |= 0x00000001;
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0L;
      onChanged();
      return this;
    }

    private com.starrocks.proto.DelvecPagePB delvecPage_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.DelvecPagePB, com.starrocks.proto.DelvecPagePB.Builder, com.starrocks.proto.DelvecPagePBOrBuilder> delvecPageBuilder_;
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     * @return Whether the delvecPage field is set.
     */
    public boolean hasDelvecPage() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     * @return The delvecPage.
     */
    public com.starrocks.proto.DelvecPagePB getDelvecPage() {
      if (delvecPageBuilder_ == null) {
        return delvecPage_ == null ? com.starrocks.proto.DelvecPagePB.getDefaultInstance() : delvecPage_;
      } else {
        return delvecPageBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     */
    public Builder setDelvecPage(com.starrocks.proto.DelvecPagePB value) {
      if (delvecPageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        delvecPage_ = value;
        onChanged();
      } else {
        delvecPageBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     */
    public Builder setDelvecPage(
        com.starrocks.proto.DelvecPagePB.Builder builderForValue) {
      if (delvecPageBuilder_ == null) {
        delvecPage_ = builderForValue.build();
        onChanged();
      } else {
        delvecPageBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     */
    public Builder mergeDelvecPage(com.starrocks.proto.DelvecPagePB value) {
      if (delvecPageBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
            delvecPage_ != null &&
            delvecPage_ != com.starrocks.proto.DelvecPagePB.getDefaultInstance()) {
          delvecPage_ =
            com.starrocks.proto.DelvecPagePB.newBuilder(delvecPage_).mergeFrom(value).buildPartial();
        } else {
          delvecPage_ = value;
        }
        onChanged();
      } else {
        delvecPageBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     */
    public Builder clearDelvecPage() {
      if (delvecPageBuilder_ == null) {
        delvecPage_ = null;
        onChanged();
      } else {
        delvecPageBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     */
    public com.starrocks.proto.DelvecPagePB.Builder getDelvecPageBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getDelvecPageFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     */
    public com.starrocks.proto.DelvecPagePBOrBuilder getDelvecPageOrBuilder() {
      if (delvecPageBuilder_ != null) {
        return delvecPageBuilder_.getMessageOrBuilder();
      } else {
        return delvecPage_ == null ?
            com.starrocks.proto.DelvecPagePB.getDefaultInstance() : delvecPage_;
      }
    }
    /**
     * <code>optional .starrocks.lake.DelvecPagePB delvec_page = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.DelvecPagePB, com.starrocks.proto.DelvecPagePB.Builder, com.starrocks.proto.DelvecPagePBOrBuilder> 
        getDelvecPageFieldBuilder() {
      if (delvecPageBuilder_ == null) {
        delvecPageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.starrocks.proto.DelvecPagePB, com.starrocks.proto.DelvecPagePB.Builder, com.starrocks.proto.DelvecPagePBOrBuilder>(
                getDelvecPage(),
                getParentForChildren(),
                isClean());
        delvecPage_ = null;
      }
      return delvecPageBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.lake.DelvecCacheKeyPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.lake.DelvecCacheKeyPB)
  private static final com.starrocks.proto.DelvecCacheKeyPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.DelvecCacheKeyPB();
  }

  public static com.starrocks.proto.DelvecCacheKeyPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<DelvecCacheKeyPB>
      PARSER = new com.google.protobuf.AbstractParser<DelvecCacheKeyPB>() {
    @java.lang.Override
    public DelvecCacheKeyPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<DelvecCacheKeyPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DelvecCacheKeyPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.DelvecCacheKeyPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

