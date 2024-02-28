// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.PKafkaLoadInfo}
 */
public final class PKafkaLoadInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.PKafkaLoadInfo)
    PKafkaLoadInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PKafkaLoadInfo.newBuilder() to construct.
  private PKafkaLoadInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PKafkaLoadInfo() {
    brokers_ = "";
    topic_ = "";
    properties_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PKafkaLoadInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PKafkaLoadInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PKafkaLoadInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.PKafkaLoadInfo.class, io.datafibre.fibre.proto.PKafkaLoadInfo.Builder.class);
  }

  private int bitField0_;
  public static final int BROKERS_FIELD_NUMBER = 1;
  private volatile java.lang.Object brokers_;
  /**
   * <code>required string brokers = 1;</code>
   * @return Whether the brokers field is set.
   */
  @java.lang.Override
  public boolean hasBrokers() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required string brokers = 1;</code>
   * @return The brokers.
   */
  @java.lang.Override
  public java.lang.String getBrokers() {
    java.lang.Object ref = brokers_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        brokers_ = s;
      }
      return s;
    }
  }
  /**
   * <code>required string brokers = 1;</code>
   * @return The bytes for brokers.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getBrokersBytes() {
    java.lang.Object ref = brokers_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      brokers_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOPIC_FIELD_NUMBER = 2;
  private volatile java.lang.Object topic_;
  /**
   * <code>required string topic = 2;</code>
   * @return Whether the topic field is set.
   */
  @java.lang.Override
  public boolean hasTopic() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>required string topic = 2;</code>
   * @return The topic.
   */
  @java.lang.Override
  public java.lang.String getTopic() {
    java.lang.Object ref = topic_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        topic_ = s;
      }
      return s;
    }
  }
  /**
   * <code>required string topic = 2;</code>
   * @return The bytes for topic.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTopicBytes() {
    java.lang.Object ref = topic_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      topic_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PROPERTIES_FIELD_NUMBER = 3;
  private java.util.List<io.datafibre.fibre.proto.PStringPair> properties_;
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  @java.lang.Override
  public java.util.List<io.datafibre.fibre.proto.PStringPair> getPropertiesList() {
    return properties_;
  }
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.datafibre.fibre.proto.PStringPairOrBuilder>
      getPropertiesOrBuilderList() {
    return properties_;
  }
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  @java.lang.Override
  public int getPropertiesCount() {
    return properties_.size();
  }
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PStringPair getProperties(int index) {
    return properties_.get(index);
  }
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.PStringPairOrBuilder getPropertiesOrBuilder(
      int index) {
    return properties_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasBrokers()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasTopic()) {
      memoizedIsInitialized = 0;
      return false;
    }
    for (int i = 0; i < getPropertiesCount(); i++) {
      if (!getProperties(i).isInitialized()) {
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, brokers_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, topic_);
    }
    for (int i = 0; i < properties_.size(); i++) {
      output.writeMessage(3, properties_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, brokers_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, topic_);
    }
    for (int i = 0; i < properties_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, properties_.get(i));
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
    if (!(obj instanceof io.datafibre.fibre.proto.PKafkaLoadInfo)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.PKafkaLoadInfo other = (io.datafibre.fibre.proto.PKafkaLoadInfo) obj;

    if (hasBrokers() != other.hasBrokers()) return false;
    if (hasBrokers()) {
      if (!getBrokers()
          .equals(other.getBrokers())) return false;
    }
    if (hasTopic() != other.hasTopic()) return false;
    if (hasTopic()) {
      if (!getTopic()
          .equals(other.getTopic())) return false;
    }
    if (!getPropertiesList()
        .equals(other.getPropertiesList())) return false;
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
    if (hasBrokers()) {
      hash = (37 * hash) + BROKERS_FIELD_NUMBER;
      hash = (53 * hash) + getBrokers().hashCode();
    }
    if (hasTopic()) {
      hash = (37 * hash) + TOPIC_FIELD_NUMBER;
      hash = (53 * hash) + getTopic().hashCode();
    }
    if (getPropertiesCount() > 0) {
      hash = (37 * hash) + PROPERTIES_FIELD_NUMBER;
      hash = (53 * hash) + getPropertiesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.PKafkaLoadInfo parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.PKafkaLoadInfo prototype) {
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
   * Protobuf type {@code starrocks.PKafkaLoadInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.PKafkaLoadInfo)
      io.datafibre.fibre.proto.PKafkaLoadInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PKafkaLoadInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PKafkaLoadInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.PKafkaLoadInfo.class, io.datafibre.fibre.proto.PKafkaLoadInfo.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.PKafkaLoadInfo.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      brokers_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      topic_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      if (propertiesBuilder_ == null) {
        properties_ = java.util.Collections.emptyList();
      } else {
        properties_ = null;
        propertiesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.InternalService.internal_static_starrocks_PKafkaLoadInfo_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PKafkaLoadInfo getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.PKafkaLoadInfo.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PKafkaLoadInfo build() {
      io.datafibre.fibre.proto.PKafkaLoadInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.PKafkaLoadInfo buildPartial() {
      io.datafibre.fibre.proto.PKafkaLoadInfo result = new io.datafibre.fibre.proto.PKafkaLoadInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.brokers_ = brokers_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.topic_ = topic_;
      if (propertiesBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          properties_ = java.util.Collections.unmodifiableList(properties_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.properties_ = properties_;
      } else {
        result.properties_ = propertiesBuilder_.build();
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
      if (other instanceof io.datafibre.fibre.proto.PKafkaLoadInfo) {
        return mergeFrom((io.datafibre.fibre.proto.PKafkaLoadInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.PKafkaLoadInfo other) {
      if (other == io.datafibre.fibre.proto.PKafkaLoadInfo.getDefaultInstance()) return this;
      if (other.hasBrokers()) {
        bitField0_ |= 0x00000001;
        brokers_ = other.brokers_;
        onChanged();
      }
      if (other.hasTopic()) {
        bitField0_ |= 0x00000002;
        topic_ = other.topic_;
        onChanged();
      }
      if (propertiesBuilder_ == null) {
        if (!other.properties_.isEmpty()) {
          if (properties_.isEmpty()) {
            properties_ = other.properties_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensurePropertiesIsMutable();
            properties_.addAll(other.properties_);
          }
          onChanged();
        }
      } else {
        if (!other.properties_.isEmpty()) {
          if (propertiesBuilder_.isEmpty()) {
            propertiesBuilder_.dispose();
            propertiesBuilder_ = null;
            properties_ = other.properties_;
            bitField0_ = (bitField0_ & ~0x00000004);
            propertiesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPropertiesFieldBuilder() : null;
          } else {
            propertiesBuilder_.addAllMessages(other.properties_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasBrokers()) {
        return false;
      }
      if (!hasTopic()) {
        return false;
      }
      for (int i = 0; i < getPropertiesCount(); i++) {
        if (!getProperties(i).isInitialized()) {
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
              brokers_ = input.readBytes();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              topic_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              io.datafibre.fibre.proto.PStringPair m =
                  input.readMessage(
                      io.datafibre.fibre.proto.PStringPair.PARSER,
                      extensionRegistry);
              if (propertiesBuilder_ == null) {
                ensurePropertiesIsMutable();
                properties_.add(m);
              } else {
                propertiesBuilder_.addMessage(m);
              }
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

    private java.lang.Object brokers_ = "";
    /**
     * <code>required string brokers = 1;</code>
     * @return Whether the brokers field is set.
     */
    public boolean hasBrokers() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required string brokers = 1;</code>
     * @return The brokers.
     */
    public java.lang.String getBrokers() {
      java.lang.Object ref = brokers_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          brokers_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>required string brokers = 1;</code>
     * @return The bytes for brokers.
     */
    public com.google.protobuf.ByteString
        getBrokersBytes() {
      java.lang.Object ref = brokers_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        brokers_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>required string brokers = 1;</code>
     * @param value The brokers to set.
     * @return This builder for chaining.
     */
    public Builder setBrokers(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      brokers_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required string brokers = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBrokers() {
      bitField0_ = (bitField0_ & ~0x00000001);
      brokers_ = getDefaultInstance().getBrokers();
      onChanged();
      return this;
    }
    /**
     * <code>required string brokers = 1;</code>
     * @param value The bytes for brokers to set.
     * @return This builder for chaining.
     */
    public Builder setBrokersBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      brokers_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object topic_ = "";
    /**
     * <code>required string topic = 2;</code>
     * @return Whether the topic field is set.
     */
    public boolean hasTopic() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required string topic = 2;</code>
     * @return The topic.
     */
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          topic_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>required string topic = 2;</code>
     * @return The bytes for topic.
     */
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>required string topic = 2;</code>
     * @param value The topic to set.
     * @return This builder for chaining.
     */
    public Builder setTopic(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      topic_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required string topic = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTopic() {
      bitField0_ = (bitField0_ & ~0x00000002);
      topic_ = getDefaultInstance().getTopic();
      onChanged();
      return this;
    }
    /**
     * <code>required string topic = 2;</code>
     * @param value The bytes for topic to set.
     * @return This builder for chaining.
     */
    public Builder setTopicBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      topic_ = value;
      onChanged();
      return this;
    }

    private java.util.List<io.datafibre.fibre.proto.PStringPair> properties_ =
      java.util.Collections.emptyList();
    private void ensurePropertiesIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        properties_ = new java.util.ArrayList<io.datafibre.fibre.proto.PStringPair>(properties_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PStringPair, io.datafibre.fibre.proto.PStringPair.Builder, io.datafibre.fibre.proto.PStringPairOrBuilder> propertiesBuilder_;

    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PStringPair> getPropertiesList() {
      if (propertiesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(properties_);
      } else {
        return propertiesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public int getPropertiesCount() {
      if (propertiesBuilder_ == null) {
        return properties_.size();
      } else {
        return propertiesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public io.datafibre.fibre.proto.PStringPair getProperties(int index) {
      if (propertiesBuilder_ == null) {
        return properties_.get(index);
      } else {
        return propertiesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder setProperties(
        int index, io.datafibre.fibre.proto.PStringPair value) {
      if (propertiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        properties_.set(index, value);
        onChanged();
      } else {
        propertiesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder setProperties(
        int index, io.datafibre.fibre.proto.PStringPair.Builder builderForValue) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.set(index, builderForValue.build());
        onChanged();
      } else {
        propertiesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder addProperties(io.datafibre.fibre.proto.PStringPair value) {
      if (propertiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        properties_.add(value);
        onChanged();
      } else {
        propertiesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder addProperties(
        int index, io.datafibre.fibre.proto.PStringPair value) {
      if (propertiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        properties_.add(index, value);
        onChanged();
      } else {
        propertiesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder addProperties(
        io.datafibre.fibre.proto.PStringPair.Builder builderForValue) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.add(builderForValue.build());
        onChanged();
      } else {
        propertiesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder addProperties(
        int index, io.datafibre.fibre.proto.PStringPair.Builder builderForValue) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.add(index, builderForValue.build());
        onChanged();
      } else {
        propertiesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder addAllProperties(
        java.lang.Iterable<? extends io.datafibre.fibre.proto.PStringPair> values) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, properties_);
        onChanged();
      } else {
        propertiesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder clearProperties() {
      if (propertiesBuilder_ == null) {
        properties_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        propertiesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public Builder removeProperties(int index) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.remove(index);
        onChanged();
      } else {
        propertiesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public io.datafibre.fibre.proto.PStringPair.Builder getPropertiesBuilder(
        int index) {
      return getPropertiesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public io.datafibre.fibre.proto.PStringPairOrBuilder getPropertiesOrBuilder(
        int index) {
      if (propertiesBuilder_ == null) {
        return properties_.get(index);  } else {
        return propertiesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public java.util.List<? extends io.datafibre.fibre.proto.PStringPairOrBuilder>
         getPropertiesOrBuilderList() {
      if (propertiesBuilder_ != null) {
        return propertiesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(properties_);
      }
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public io.datafibre.fibre.proto.PStringPair.Builder addPropertiesBuilder() {
      return getPropertiesFieldBuilder().addBuilder(
          io.datafibre.fibre.proto.PStringPair.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public io.datafibre.fibre.proto.PStringPair.Builder addPropertiesBuilder(
        int index) {
      return getPropertiesFieldBuilder().addBuilder(
          index, io.datafibre.fibre.proto.PStringPair.getDefaultInstance());
    }
    /**
     * <code>repeated .starrocks.PStringPair properties = 3;</code>
     */
    public java.util.List<io.datafibre.fibre.proto.PStringPair.Builder>
         getPropertiesBuilderList() {
      return getPropertiesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.datafibre.fibre.proto.PStringPair, io.datafibre.fibre.proto.PStringPair.Builder, io.datafibre.fibre.proto.PStringPairOrBuilder>
        getPropertiesFieldBuilder() {
      if (propertiesBuilder_ == null) {
        propertiesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.datafibre.fibre.proto.PStringPair, io.datafibre.fibre.proto.PStringPair.Builder, io.datafibre.fibre.proto.PStringPairOrBuilder>(
                properties_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        properties_ = null;
      }
      return propertiesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:starrocks.PKafkaLoadInfo)
  }

  // @@protoc_insertion_point(class_scope:starrocks.PKafkaLoadInfo)
  private static final io.datafibre.fibre.proto.PKafkaLoadInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.PKafkaLoadInfo();
  }

  public static io.datafibre.fibre.proto.PKafkaLoadInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<PKafkaLoadInfo>
      PARSER = new com.google.protobuf.AbstractParser<PKafkaLoadInfo>() {
    @java.lang.Override
    public PKafkaLoadInfo parsePartialFrom(
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

  public static com.google.protobuf.Parser<PKafkaLoadInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PKafkaLoadInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.PKafkaLoadInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

