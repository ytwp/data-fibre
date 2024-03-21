// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.PrimaryIndexDumpPB}
 */
public final class PrimaryIndexDumpPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PrimaryIndexDumpPB)
    PrimaryIndexDumpPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PrimaryIndexDumpPB.newBuilder() to construct.
  private PrimaryIndexDumpPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PrimaryIndexDumpPB() {
    kvs_ = java.util.Collections.emptyList();
    filename_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PrimaryIndexDumpPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_PrimaryIndexDumpPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_PrimaryIndexDumpPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PrimaryIndexDumpPB.class, io.datafibre.fibre.proto.PrimaryIndexDumpPB.Builder.class);
  }

  private int bitField0_;
  public static final int KVS_FIELD_NUMBER = 1;
  private java.util.List<io.datafibre.fibre.proto.PagePointerPB> kvs_;
  /**
   * <pre>
   * Point to PartialKVs
   * </pre>
   *
   * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.datafibre.fibre.proto.PagePointerPB> getKvsList() {
    return kvs_;
  }
  /**
   * <pre>
   * Point to PartialKVs
   * </pre>
   *
   * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.datafibre.fibre.proto.PagePointerPBOrBuilder>
      getKvsOrBuilderList() {
    return kvs_;
  }
  /**
   * <pre>
   * Point to PartialKVs
   * </pre>
   *
   * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
   */
  @java.lang.Override
  public int getKvsCount() {
    return kvs_.size();
  }
  /**
   * <pre>
   * Point to PartialKVs
   * </pre>
   *
   * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PagePointerPB getKvs(int index) {
    return kvs_.get(index);
  }
  /**
   * <pre>
   * Point to PartialKVs
   * </pre>
   *
   * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PagePointerPBOrBuilder getKvsOrBuilder(
      int index) {
    return kvs_.get(index);
  }

  public static final int FILENAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object filename_;
  /**
   * <pre>
   * filename of persitent index l1 &amp; l2
   * While using memory index or l0, set filename to memory
   * </pre>
   *
   * <code>optional string filename = 2;</code>
   * @return Whether the filename field is set.
   */
  @java.lang.Override
  public boolean hasFilename() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * filename of persitent index l1 &amp; l2
   * While using memory index or l0, set filename to memory
   * </pre>
   *
   * <code>optional string filename = 2;</code>
   * @return The filename.
   */
  @java.lang.Override
  public java.lang.String getFilename() {
    java.lang.Object ref = filename_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        filename_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   * filename of persitent index l1 &amp; l2
   * While using memory index or l0, set filename to memory
   * </pre>
   *
   * <code>optional string filename = 2;</code>
   * @return The bytes for filename.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFilenameBytes() {
    java.lang.Object ref = filename_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      filename_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    for (int i = 0; i < getKvsCount(); i++) {
      if (!getKvs(i).isInitialized()) {
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
    for (int i = 0; i < kvs_.size(); i++) {
      output.writeMessage(1, kvs_.get(i));
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, filename_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < kvs_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, kvs_.get(i));
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, filename_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.PrimaryIndexDumpPB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PrimaryIndexDumpPB other = (io.datafibre.fibre.proto.PrimaryIndexDumpPB) obj;

    if (!getKvsList()
        .equals(other.getKvsList())) return false;
    if (hasFilename() != other.hasFilename()) return false;
    if (hasFilename()) {
      if (!getFilename()
          .equals(other.getFilename())) return false;
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
    if (getKvsCount() > 0) {
      hash = (37 * hash) + KVS_FIELD_NUMBER;
      hash = (53 * hash) + getKvsList().hashCode();
    }
    if (hasFilename()) {
      hash = (37 * hash) + FILENAME_FIELD_NUMBER;
      hash = (53 * hash) + getFilename().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PrimaryIndexDumpPB prototype) {
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
   * Protobuf type {@code starrocks.PrimaryIndexDumpPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PrimaryIndexDumpPB)
      io.datafibre.fibre.proto.PrimaryIndexDumpPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_PrimaryIndexDumpPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_PrimaryIndexDumpPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PrimaryIndexDumpPB.class, io.datafibre.fibre.proto.PrimaryIndexDumpPB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PrimaryIndexDumpPB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (kvsBuilder_ == null) {
        kvs_ = java.util.Collections.emptyList();
      } else {
        kvs_ = null;
        kvsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      filename_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.OlapFile.internal_static_starrocks_PrimaryIndexDumpPB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PrimaryIndexDumpPB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PrimaryIndexDumpPB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PrimaryIndexDumpPB build() {
      io.datafibre.fibre.proto.PrimaryIndexDumpPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PrimaryIndexDumpPB buildPartial() {
      io.datafibre.fibre.proto.PrimaryIndexDumpPB result = new io.datafibre.fibre.proto.PrimaryIndexDumpPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (kvsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          kvs_ = java.util.Collections.unmodifiableList(kvs_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.kvs_ = kvs_;
      } else {
        result.kvs_ = kvsBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.filename_ = filename_;
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
      if (other instanceof io.datafibre.fibre.proto.PrimaryIndexDumpPB) {
        return mergeFrom((io.datafibre.fibre.proto.PrimaryIndexDumpPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PrimaryIndexDumpPB other) {
      if (other == io.datafibre.fibre.proto.PrimaryIndexDumpPB.getDefaultInstance()) return this;
      if (kvsBuilder_ == null) {
        if (!other.kvs_.isEmpty()) {
          if (kvs_.isEmpty()) {
            kvs_ = other.kvs_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureKvsIsMutable();
            kvs_.addAll(other.kvs_);
          }
          onChanged();
        }
      } else {
        if (!other.kvs_.isEmpty()) {
          if (kvsBuilder_.isEmpty()) {
            kvsBuilder_.dispose();
            kvsBuilder_ = null;
            kvs_ = other.kvs_;
            bitField0_ = (bitField0_ & ~0x00000001);
            kvsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getKvsFieldBuilder() : null;
          } else {
            kvsBuilder_.addAllMessages(other.kvs_);
          }
        }
      }
      if (other.hasFilename()) {
        bitField0_ |= 0x00000002;
        filename_ = other.filename_;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      for (int i = 0; i < getKvsCount(); i++) {
        if (!getKvs(i).isInitialized()) {
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
              io.datafibre.fibre.proto.PagePointerPB m =
                  input.readMessage(
                      io.datafibre.fibre.proto.PagePointerPB.PARSER,
                      extensionRegistry);
              if (kvsBuilder_ == null) {
                ensureKvsIsMutable();
                kvs_.add(m);
              } else {
                kvsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 18: {
              filename_ = input.readBytes();
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

    private java.util.List<io.datafibre.fibre.proto.PagePointerPB> kvs_ =
      java.util.Collections.emptyList();
    private void ensureKvsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        kvs_ = new java.util.ArrayList<io.datafibre.fibre.proto.PagePointerPB>(kvs_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PagePointerPB, io.datafibre.fibre.proto.PagePointerPB.Builder, io.datafibre.fibre.proto.PagePointerPBOrBuilder> kvsBuilder_;

    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PagePointerPB> getKvsList() {
      if (kvsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(kvs_);
      } else {
        return kvsBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public int getKvsCount() {
      if (kvsBuilder_ == null) {
        return kvs_.size();
      } else {
        return kvsBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public io.datafibre.fibre.proto.PagePointerPB getKvs(int index) {
      if (kvsBuilder_ == null) {
        return kvs_.get(index);
      } else {
        return kvsBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder setKvs(
        int index, io.datafibre.fibre.proto.PagePointerPB value) {
      if (kvsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureKvsIsMutable();
        kvs_.set(index, value);
        onChanged();
      } else {
        kvsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder setKvs(
        int index, io.datafibre.fibre.proto.PagePointerPB.Builder builderForValue) {
      if (kvsBuilder_ == null) {
        ensureKvsIsMutable();
        kvs_.set(index, builderForValue.build());
        onChanged();
      } else {
        kvsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder addKvs(io.datafibre.fibre.proto.PagePointerPB value) {
      if (kvsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureKvsIsMutable();
        kvs_.add(value);
        onChanged();
      } else {
        kvsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder addKvs(
        int index, io.datafibre.fibre.proto.PagePointerPB value) {
      if (kvsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureKvsIsMutable();
        kvs_.add(index, value);
        onChanged();
      } else {
        kvsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder addKvs(
        io.datafibre.fibre.proto.PagePointerPB.Builder builderForValue) {
      if (kvsBuilder_ == null) {
        ensureKvsIsMutable();
        kvs_.add(builderForValue.build());
        onChanged();
      } else {
        kvsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder addKvs(
        int index, io.datafibre.fibre.proto.PagePointerPB.Builder builderForValue) {
      if (kvsBuilder_ == null) {
        ensureKvsIsMutable();
        kvs_.add(index, builderForValue.build());
        onChanged();
      } else {
        kvsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder addAllKvs(
        java.lang.Iterable<? extends io.datafibre.fibre.proto.PagePointerPB> values) {
      if (kvsBuilder_ == null) {
        ensureKvsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, kvs_);
        onChanged();
      } else {
        kvsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder clearKvs() {
      if (kvsBuilder_ == null) {
        kvs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        kvsBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public Builder removeKvs(int index) {
      if (kvsBuilder_ == null) {
        ensureKvsIsMutable();
        kvs_.remove(index);
        onChanged();
      } else {
        kvsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public io.datafibre.fibre.proto.PagePointerPB.Builder getKvsBuilder(
        int index) {
      return getKvsFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public io.datafibre.fibre.proto.PagePointerPBOrBuilder getKvsOrBuilder(
        int index) {
      if (kvsBuilder_ == null) {
        return kvs_.get(index);  } else {
        return kvsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public java.util.List<? extends io.datafibre.fibre.proto.PagePointerPBOrBuilder>
         getKvsOrBuilderList() {
      if (kvsBuilder_ != null) {
        return kvsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(kvs_);
      }
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public io.datafibre.fibre.proto.PagePointerPB.Builder addKvsBuilder() {
      return getKvsFieldBuilder().addBuilder(
          io.datafibre.fibre.proto.PagePointerPB.getDefaultInstance());
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public io.datafibre.fibre.proto.PagePointerPB.Builder addKvsBuilder(
        int index) {
      return getKvsFieldBuilder().addBuilder(
          index, io.datafibre.fibre.proto.PagePointerPB.getDefaultInstance());
    }
    /**
     * <pre>
     * Point to PartialKVs
     * </pre>
     *
     * <code>repeated .starrocks.PagePointerPB kvs = 1;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PagePointerPB.Builder>
         getKvsBuilderList() {
      return getKvsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PagePointerPB, io.datafibre.fibre.proto.PagePointerPB.Builder, io.datafibre.fibre.proto.PagePointerPBOrBuilder>
        getKvsFieldBuilder() {
      if (kvsBuilder_ == null) {
        kvsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.datafibre.fibre.proto.PagePointerPB, io.datafibre.fibre.proto.PagePointerPB.Builder, io.datafibre.fibre.proto.PagePointerPBOrBuilder>(
                kvs_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        kvs_ = null;
      }
      return kvsBuilder_;
    }

    private java.lang.Object filename_ = "";
    /**
     * <pre>
     * filename of persitent index l1 &amp; l2
     * While using memory index or l0, set filename to memory
     * </pre>
     *
     * <code>optional string filename = 2;</code>
     * @return Whether the filename field is set.
     */
    public boolean hasFilename() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * filename of persitent index l1 &amp; l2
     * While using memory index or l0, set filename to memory
     * </pre>
     *
     * <code>optional string filename = 2;</code>
     * @return The filename.
     */
    public java.lang.String getFilename() {
      java.lang.Object ref = filename_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          filename_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * filename of persitent index l1 &amp; l2
     * While using memory index or l0, set filename to memory
     * </pre>
     *
     * <code>optional string filename = 2;</code>
     * @return The bytes for filename.
     */
    public com.google.protobuf.ByteString
        getFilenameBytes() {
      java.lang.Object ref = filename_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        filename_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * filename of persitent index l1 &amp; l2
     * While using memory index or l0, set filename to memory
     * </pre>
     *
     * <code>optional string filename = 2;</code>
     * @param value The filename to set.
     * @return This builder for chaining.
     */
    public Builder setFilename(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      filename_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * filename of persitent index l1 &amp; l2
     * While using memory index or l0, set filename to memory
     * </pre>
     *
     * <code>optional string filename = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFilename() {
      bitField0_ = (bitField0_ & ~0x00000002);
      filename_ = getDefaultInstance().getFilename();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * filename of persitent index l1 &amp; l2
     * While using memory index or l0, set filename to memory
     * </pre>
     *
     * <code>optional string filename = 2;</code>
     * @param value The bytes for filename to set.
     * @return This builder for chaining.
     */
    public Builder setFilenameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      filename_ = value;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PrimaryIndexDumpPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PrimaryIndexDumpPB)
  private static final io.datafibre.fibre.proto.PrimaryIndexDumpPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PrimaryIndexDumpPB();
  }

  public static io.datafibre.fibre.proto.PrimaryIndexDumpPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PrimaryIndexDumpPB>
      PARSER = new com.google.protobuf.AbstractParser<PrimaryIndexDumpPB>() {
    @java.lang.Override
    public PrimaryIndexDumpPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<PrimaryIndexDumpPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PrimaryIndexDumpPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PrimaryIndexDumpPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
