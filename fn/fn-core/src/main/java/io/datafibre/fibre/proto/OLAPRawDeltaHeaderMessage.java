// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package com.starrocks.proto;

/**
 * Protobuf type {@code starrocks.OLAPRawDeltaHeaderMessage}
 */
public final class OLAPRawDeltaHeaderMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.OLAPRawDeltaHeaderMessage)
    OLAPRawDeltaHeaderMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OLAPRawDeltaHeaderMessage.newBuilder() to construct.
  private OLAPRawDeltaHeaderMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OLAPRawDeltaHeaderMessage() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new OLAPRawDeltaHeaderMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.starrocks.proto.OlapFile.internal_static_starrocks_OLAPRawDeltaHeaderMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.starrocks.proto.OlapFile.internal_static_starrocks_OLAPRawDeltaHeaderMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.starrocks.proto.OLAPRawDeltaHeaderMessage.class, com.starrocks.proto.OLAPRawDeltaHeaderMessage.Builder.class);
  }

  private int bitField0_;
  public static final int SCHEMA_HASH_FIELD_NUMBER = 2;
  private int schemaHash_;
  /**
   * <code>required int32 schema_hash = 2;</code>
   * @return Whether the schemaHash field is set.
   */
  @java.lang.Override
  public boolean hasSchemaHash() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required int32 schema_hash = 2;</code>
   * @return The schemaHash.
   */
  @java.lang.Override
  public int getSchemaHash() {
    return schemaHash_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasSchemaHash()) {
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
      output.writeInt32(2, schemaHash_);
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
        .computeInt32Size(2, schemaHash_);
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
    if (!(obj instanceof com.starrocks.proto.OLAPRawDeltaHeaderMessage)) {
      return super.equals(obj);
    }
    com.starrocks.proto.OLAPRawDeltaHeaderMessage other = (com.starrocks.proto.OLAPRawDeltaHeaderMessage) obj;

    if (hasSchemaHash() != other.hasSchemaHash()) return false;
    if (hasSchemaHash()) {
      if (getSchemaHash()
          != other.getSchemaHash()) return false;
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
    if (hasSchemaHash()) {
      hash = (37 * hash) + SCHEMA_HASH_FIELD_NUMBER;
      hash = (53 * hash) + getSchemaHash();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage parseFrom(
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
  public static Builder newBuilder(com.starrocks.proto.OLAPRawDeltaHeaderMessage prototype) {
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
   * Protobuf type {@code starrocks.OLAPRawDeltaHeaderMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.OLAPRawDeltaHeaderMessage)
      com.starrocks.proto.OLAPRawDeltaHeaderMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.starrocks.proto.OlapFile.internal_static_starrocks_OLAPRawDeltaHeaderMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.starrocks.proto.OlapFile.internal_static_starrocks_OLAPRawDeltaHeaderMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.starrocks.proto.OLAPRawDeltaHeaderMessage.class, com.starrocks.proto.OLAPRawDeltaHeaderMessage.Builder.class);
    }

    // Construct using com.starrocks.proto.OLAPRawDeltaHeaderMessage.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      schemaHash_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.starrocks.proto.OlapFile.internal_static_starrocks_OLAPRawDeltaHeaderMessage_descriptor;
    }

    @java.lang.Override
    public com.starrocks.proto.OLAPRawDeltaHeaderMessage getDefaultInstanceForType() {
      return com.starrocks.proto.OLAPRawDeltaHeaderMessage.getDefaultInstance();
    }

    @java.lang.Override
    public com.starrocks.proto.OLAPRawDeltaHeaderMessage build() {
      com.starrocks.proto.OLAPRawDeltaHeaderMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.starrocks.proto.OLAPRawDeltaHeaderMessage buildPartial() {
      com.starrocks.proto.OLAPRawDeltaHeaderMessage result = new com.starrocks.proto.OLAPRawDeltaHeaderMessage(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.schemaHash_ = schemaHash_;
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
      if (other instanceof com.starrocks.proto.OLAPRawDeltaHeaderMessage) {
        return mergeFrom((com.starrocks.proto.OLAPRawDeltaHeaderMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.starrocks.proto.OLAPRawDeltaHeaderMessage other) {
      if (other == com.starrocks.proto.OLAPRawDeltaHeaderMessage.getDefaultInstance()) return this;
      if (other.hasSchemaHash()) {
        setSchemaHash(other.getSchemaHash());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasSchemaHash()) {
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
            case 16: {
              schemaHash_ = input.readInt32();
              bitField0_ |= 0x00000001;
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

    private int schemaHash_ ;
    /**
     * <code>required int32 schema_hash = 2;</code>
     * @return Whether the schemaHash field is set.
     */
    @java.lang.Override
    public boolean hasSchemaHash() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required int32 schema_hash = 2;</code>
     * @return The schemaHash.
     */
    @java.lang.Override
    public int getSchemaHash() {
      return schemaHash_;
    }
    /**
     * <code>required int32 schema_hash = 2;</code>
     * @param value The schemaHash to set.
     * @return This builder for chaining.
     */
    public Builder setSchemaHash(int value) {
      bitField0_ |= 0x00000001;
      schemaHash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int32 schema_hash = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSchemaHash() {
      bitField0_ = (bitField0_ & ~0x00000001);
      schemaHash_ = 0;
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


    // @@protoc_insertion_point(builder_scope:starrocks.OLAPRawDeltaHeaderMessage)
  }

  // @@protoc_insertion_point(class_scope:starrocks.OLAPRawDeltaHeaderMessage)
  private static final com.starrocks.proto.OLAPRawDeltaHeaderMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.starrocks.proto.OLAPRawDeltaHeaderMessage();
  }

  public static com.starrocks.proto.OLAPRawDeltaHeaderMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<OLAPRawDeltaHeaderMessage>
      PARSER = new com.google.protobuf.AbstractParser<OLAPRawDeltaHeaderMessage>() {
    @java.lang.Override
    public OLAPRawDeltaHeaderMessage parsePartialFrom(
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

  public static com.google.protobuf.Parser<OLAPRawDeltaHeaderMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OLAPRawDeltaHeaderMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.starrocks.proto.OLAPRawDeltaHeaderMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

