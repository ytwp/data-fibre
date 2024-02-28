// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.IndexPageFooterPB}
 */
public final class IndexPageFooterPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.IndexPageFooterPB)
    IndexPageFooterPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use IndexPageFooterPB.newBuilder() to construct.
  private IndexPageFooterPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private IndexPageFooterPB() {
    type_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new IndexPageFooterPB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.Segment.internal_static_starrocks_IndexPageFooterPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.Segment.internal_static_starrocks_IndexPageFooterPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.IndexPageFooterPB.class, io.datafibre.fibre.proto.IndexPageFooterPB.Builder.class);
  }

  /**
   * Protobuf enum {@code starrocks.IndexPageFooterPB.Type}
   */
  public enum Type
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>UNKNOWN_INDEX_PAGE_TYPE = 0;</code>
     */
    UNKNOWN_INDEX_PAGE_TYPE(0),
    /**
     * <code>LEAF = 1;</code>
     */
    LEAF(1),
    /**
     * <code>INTERNAL = 2;</code>
     */
    INTERNAL(2),
    ;

    /**
     * <code>UNKNOWN_INDEX_PAGE_TYPE = 0;</code>
     */
    public static final int UNKNOWN_INDEX_PAGE_TYPE_VALUE = 0;
    /**
     * <code>LEAF = 1;</code>
     */
    public static final int LEAF_VALUE = 1;
    /**
     * <code>INTERNAL = 2;</code>
     */
    public static final int INTERNAL_VALUE = 2;


    public final int getNumber() {
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Type valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Type forNumber(int value) {
      switch (value) {
        case 0: return UNKNOWN_INDEX_PAGE_TYPE;
        case 1: return LEAF;
        case 2: return INTERNAL;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Type>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Type> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Type>() {
            public Type findValueByNumber(int number) {
              return Type.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.IndexPageFooterPB.getDescriptor().getEnumTypes().get(0);
    }

    private static final Type[] VALUES = values();

    public static Type valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Type(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:starrocks.IndexPageFooterPB.Type)
  }

  private int bitField0_;
  public static final int NUM_ENTRIES_FIELD_NUMBER = 1;
  private int numEntries_;
  /**
   * <pre>
   * required: number of index entries in this page
   * </pre>
   *
   * <code>optional uint32 num_entries = 1;</code>
   * @return Whether the numEntries field is set.
   */
  @java.lang.Override
  public boolean hasNumEntries() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * required: number of index entries in this page
   * </pre>
   *
   * <code>optional uint32 num_entries = 1;</code>
   * @return The numEntries.
   */
  @java.lang.Override
  public int getNumEntries() {
    return numEntries_;
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private int type_;
  /**
   * <pre>
   * required: type of the index page
   * </pre>
   *
   * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
   * @return Whether the type field is set.
   */
  @java.lang.Override public boolean hasType() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <pre>
   * required: type of the index page
   * </pre>
   *
   * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
   * @return The type.
   */
  @java.lang.Override public io.datafibre.fibre.proto.IndexPageFooterPB.Type getType() {
    @SuppressWarnings("deprecation")
    io.datafibre.fibre.proto.IndexPageFooterPB.Type result = io.datafibre.fibre.proto.IndexPageFooterPB.Type.valueOf(type_);
    return result == null ? io.datafibre.fibre.proto.IndexPageFooterPB.Type.UNKNOWN_INDEX_PAGE_TYPE : result;
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
      output.writeUInt32(1, numEntries_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeEnum(2, type_);
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
        .computeUInt32Size(1, numEntries_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, type_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.IndexPageFooterPB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.IndexPageFooterPB other = (io.datafibre.fibre.proto.IndexPageFooterPB) obj;

    if (hasNumEntries() != other.hasNumEntries()) return false;
    if (hasNumEntries()) {
      if (getNumEntries()
          != other.getNumEntries()) return false;
    }
    if (hasType() != other.hasType()) return false;
    if (hasType()) {
      if (type_ != other.type_) return false;
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
    if (hasNumEntries()) {
      hash = (37 * hash) + NUM_ENTRIES_FIELD_NUMBER;
      hash = (53 * hash) + getNumEntries();
    }
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.IndexPageFooterPB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.IndexPageFooterPB prototype) {
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
   * Protobuf type {@code starrocks.IndexPageFooterPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.IndexPageFooterPB)
      io.datafibre.fibre.proto.IndexPageFooterPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_IndexPageFooterPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_IndexPageFooterPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.IndexPageFooterPB.class, io.datafibre.fibre.proto.IndexPageFooterPB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.IndexPageFooterPB.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      numEntries_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.Segment.internal_static_starrocks_IndexPageFooterPB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.IndexPageFooterPB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.IndexPageFooterPB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.IndexPageFooterPB build() {
      io.datafibre.fibre.proto.IndexPageFooterPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.IndexPageFooterPB buildPartial() {
      io.datafibre.fibre.proto.IndexPageFooterPB result = new io.datafibre.fibre.proto.IndexPageFooterPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.numEntries_ = numEntries_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.type_ = type_;
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
      if (other instanceof io.datafibre.fibre.proto.IndexPageFooterPB) {
        return mergeFrom((io.datafibre.fibre.proto.IndexPageFooterPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.IndexPageFooterPB other) {
      if (other == io.datafibre.fibre.proto.IndexPageFooterPB.getDefaultInstance()) return this;
      if (other.hasNumEntries()) {
        setNumEntries(other.getNumEntries());
      }
      if (other.hasType()) {
        setType(other.getType());
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
              numEntries_ = input.readUInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              int tmpRaw = input.readEnum();
              io.datafibre.fibre.proto.IndexPageFooterPB.Type tmpValue =
                  io.datafibre.fibre.proto.IndexPageFooterPB.Type.forNumber(tmpRaw);
              if (tmpValue == null) {
                mergeUnknownVarintField(2, tmpRaw);
              } else {
                type_ = tmpRaw;
                bitField0_ |= 0x00000002;
              }
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

    private int numEntries_ ;
    /**
     * <pre>
     * required: number of index entries in this page
     * </pre>
     *
     * <code>optional uint32 num_entries = 1;</code>
     * @return Whether the numEntries field is set.
     */
    @java.lang.Override
    public boolean hasNumEntries() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * required: number of index entries in this page
     * </pre>
     *
     * <code>optional uint32 num_entries = 1;</code>
     * @return The numEntries.
     */
    @java.lang.Override
    public int getNumEntries() {
      return numEntries_;
    }
    /**
     * <pre>
     * required: number of index entries in this page
     * </pre>
     *
     * <code>optional uint32 num_entries = 1;</code>
     * @param value The numEntries to set.
     * @return This builder for chaining.
     */
    public Builder setNumEntries(int value) {
      bitField0_ |= 0x00000001;
      numEntries_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * required: number of index entries in this page
     * </pre>
     *
     * <code>optional uint32 num_entries = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumEntries() {
      bitField0_ = (bitField0_ & ~0x00000001);
      numEntries_ = 0;
      onChanged();
      return this;
    }

    private int type_ = 0;
    /**
     * <pre>
     * required: type of the index page
     * </pre>
     *
     * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
     * @return Whether the type field is set.
     */
    @java.lang.Override public boolean hasType() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * required: type of the index page
     * </pre>
     *
     * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
     * @return The type.
     */
    @java.lang.Override
    public io.datafibre.fibre.proto.IndexPageFooterPB.Type getType() {
      @SuppressWarnings("deprecation")
      io.datafibre.fibre.proto.IndexPageFooterPB.Type result = io.datafibre.fibre.proto.IndexPageFooterPB.Type.valueOf(type_);
      return result == null ? io.datafibre.fibre.proto.IndexPageFooterPB.Type.UNKNOWN_INDEX_PAGE_TYPE : result;
    }
    /**
     * <pre>
     * required: type of the index page
     * </pre>
     *
     * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(io.datafibre.fibre.proto.IndexPageFooterPB.Type value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * required: type of the index page
     * </pre>
     *
     * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      type_ = 0;
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


    // @@protoc_insertion_point(builder_scope:starrocks.IndexPageFooterPB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.IndexPageFooterPB)
  private static final io.datafibre.fibre.proto.IndexPageFooterPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.IndexPageFooterPB();
  }

  public static io.datafibre.fibre.proto.IndexPageFooterPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<IndexPageFooterPB>
      PARSER = new com.google.protobuf.AbstractParser<IndexPageFooterPB>() {
    @java.lang.Override
    public IndexPageFooterPB parsePartialFrom(
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

  public static com.google.protobuf.Parser<IndexPageFooterPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<IndexPageFooterPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.IndexPageFooterPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

