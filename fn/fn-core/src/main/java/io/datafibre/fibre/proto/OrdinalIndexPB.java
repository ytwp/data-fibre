// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.OrdinalIndexPB}
 */
public final class OrdinalIndexPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.OrdinalIndexPB)
    OrdinalIndexPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OrdinalIndexPB.newBuilder() to construct.
  private OrdinalIndexPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OrdinalIndexPB() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new OrdinalIndexPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.Segment.internal_static_starrocks_OrdinalIndexPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.Segment.internal_static_starrocks_OrdinalIndexPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.OrdinalIndexPB.class, com.starrocks.proto.OrdinalIndexPB.Builder.class);
  }

  private int bitField0_;
  public static final int ROOT_PAGE_FIELD_NUMBER = 1;
  private com.starrocks.proto.BTreeMetaPB rootPage_;
  /**
   * <pre>
   * required: the root page can be data page if there is only one data page,
   * or the only index page if there is more than one data pages.
   * </pre>
   *
   * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
   * @return Whether the rootPage field is set.
   */
  @java.lang.Override
  public boolean hasRootPage() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * required: the root page can be data page if there is only one data page,
   * or the only index page if there is more than one data pages.
   * </pre>
   *
   * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
   * @return The rootPage.
   */
  @java.lang.Override
  public com.starrocks.proto.BTreeMetaPB getRootPage() {
    return rootPage_ == null ? com.starrocks.proto.BTreeMetaPB.getDefaultInstance() : rootPage_;
  }
  /**
   * <pre>
   * required: the root page can be data page if there is only one data page,
   * or the only index page if there is more than one data pages.
   * </pre>
   *
   * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
   */
  @java.lang.Override
  public com.starrocks.proto.BTreeMetaPBOrBuilder getRootPageOrBuilder() {
    return rootPage_ == null ? com.starrocks.proto.BTreeMetaPB.getDefaultInstance() : rootPage_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (hasRootPage()) {
      if (!getRootPage().isInitialized()) {
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
      output.writeMessage(1, getRootPage());
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
        .computeMessageSize(1, getRootPage());
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
    if (!(obj instanceof com.starrocks.proto.OrdinalIndexPB)) {
      return super.equals(obj);
    }
    com.starrocks.proto.OrdinalIndexPB other = (com.starrocks.proto.OrdinalIndexPB) obj;

    if (hasRootPage() != other.hasRootPage()) return false;
    if (hasRootPage()) {
      if (!getRootPage()
          .equals(other.getRootPage())) return false;
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
    if (hasRootPage()) {
      hash = (37 * hash) + ROOT_PAGE_FIELD_NUMBER;
      hash = (53 * hash) + getRootPage().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.OrdinalIndexPB parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.OrdinalIndexPB prototype) {
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
   * Protobuf type {@code starrocks.OrdinalIndexPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.OrdinalIndexPB)
      com.starrocks.proto.OrdinalIndexPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.Segment.internal_static_starrocks_OrdinalIndexPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.Segment.internal_static_starrocks_OrdinalIndexPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.OrdinalIndexPB.class, com.starrocks.proto.OrdinalIndexPB.Builder.class);
    }

    // Construct using com.starrocks.proto.OrdinalIndexPB.newBuilder()
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
        getRootPageFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (rootPageBuilder_ == null) {
        rootPage_ = null;
      } else {
        rootPageBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.Segment.internal_static_starrocks_OrdinalIndexPB_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.OrdinalIndexPB getDefaultInstanceForType() {
      return com.starrocks.proto.OrdinalIndexPB.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.OrdinalIndexPB build() {
      com.starrocks.proto.OrdinalIndexPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.OrdinalIndexPB buildPartial() {
      com.starrocks.proto.OrdinalIndexPB result = new com.starrocks.proto.OrdinalIndexPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (rootPageBuilder_ == null) {
          result.rootPage_ = rootPage_;
        } else {
          result.rootPage_ = rootPageBuilder_.build();
        }
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
      if (other instanceof com.starrocks.proto.OrdinalIndexPB) {
        return mergeFrom((com.starrocks.proto.OrdinalIndexPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.OrdinalIndexPB other) {
      if (other == com.starrocks.proto.OrdinalIndexPB.getDefaultInstance()) return this;
      if (other.hasRootPage()) {
        mergeRootPage(other.getRootPage());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (hasRootPage()) {
        if (!getRootPage().isInitialized()) {
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
                  getRootPageFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
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

    private com.starrocks.proto.BTreeMetaPB rootPage_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.BTreeMetaPB, com.starrocks.proto.BTreeMetaPB.Builder, com.starrocks.proto.BTreeMetaPBOrBuilder> rootPageBuilder_;
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     * @return Whether the rootPage field is set.
     */
    public boolean hasRootPage() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     * @return The rootPage.
     */
    public com.starrocks.proto.BTreeMetaPB getRootPage() {
      if (rootPageBuilder_ == null) {
        return rootPage_ == null ? com.starrocks.proto.BTreeMetaPB.getDefaultInstance() : rootPage_;
      } else {
        return rootPageBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     */
    public Builder setRootPage(com.starrocks.proto.BTreeMetaPB value) {
      if (rootPageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        rootPage_ = value;
        onChanged();
      } else {
        rootPageBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     */
    public Builder setRootPage(
        com.starrocks.proto.BTreeMetaPB.Builder builderForValue) {
      if (rootPageBuilder_ == null) {
        rootPage_ = builderForValue.build();
        onChanged();
      } else {
        rootPageBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     */
    public Builder mergeRootPage(com.starrocks.proto.BTreeMetaPB value) {
      if (rootPageBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            rootPage_ != null &&
            rootPage_ != com.starrocks.proto.BTreeMetaPB.getDefaultInstance()) {
          rootPage_ =
            com.starrocks.proto.BTreeMetaPB.newBuilder(rootPage_).mergeFrom(value).buildPartial();
        } else {
          rootPage_ = value;
        }
        onChanged();
      } else {
        rootPageBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     */
    public Builder clearRootPage() {
      if (rootPageBuilder_ == null) {
        rootPage_ = null;
        onChanged();
      } else {
        rootPageBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     */
    public com.starrocks.proto.BTreeMetaPB.Builder getRootPageBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getRootPageFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     */
    public com.starrocks.proto.BTreeMetaPBOrBuilder getRootPageOrBuilder() {
      if (rootPageBuilder_ != null) {
        return rootPageBuilder_.getMessageOrBuilder();
      } else {
        return rootPage_ == null ?
            com.starrocks.proto.BTreeMetaPB.getDefaultInstance() : rootPage_;
      }
    }
    /**
     * <pre>
     * required: the root page can be data page if there is only one data page,
     * or the only index page if there is more than one data pages.
     * </pre>
     *
     * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.starrocks.proto.BTreeMetaPB, com.starrocks.proto.BTreeMetaPB.Builder, com.starrocks.proto.BTreeMetaPBOrBuilder> 
        getRootPageFieldBuilder() {
      if (rootPageBuilder_ == null) {
        rootPageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.starrocks.proto.BTreeMetaPB, com.starrocks.proto.BTreeMetaPB.Builder, com.starrocks.proto.BTreeMetaPBOrBuilder>(
                getRootPage(),
                getParentForChildren(),
                isClean());
        rootPage_ = null;
      }
      return rootPageBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.OrdinalIndexPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.OrdinalIndexPB)
  private static final com.starrocks.proto.OrdinalIndexPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.OrdinalIndexPB();
  }

  public static com.starrocks.proto.OrdinalIndexPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<OrdinalIndexPB>
      PARSER = new com.google.protobuf.AbstractParser<OrdinalIndexPB>() {
    @java.lang.Override
    public OrdinalIndexPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<OrdinalIndexPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OrdinalIndexPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.OrdinalIndexPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

