// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.lake.UploadSnapshotsRequest}
 */
public final class UploadSnapshotsRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.lake.UploadSnapshotsRequest)
    UploadSnapshotsRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UploadSnapshotsRequest.newBuilder() to construct.
  private UploadSnapshotsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UploadSnapshotsRequest() {
    broker_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UploadSnapshotsRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsRequest_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetSnapshots();
      case 3:
        return internalGetBrokerProperties();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.UploadSnapshotsRequest.class, io.datafibre.fibre.proto.UploadSnapshotsRequest.Builder.class);
  }

  private int bitField0_;
  public static final int SNAPSHOTS_FIELD_NUMBER = 1;
  private static final class SnapshotsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Long, io.datafibre.fibre.proto.Snapshot> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Long, io.datafibre.fibre.proto.Snapshot>newDefaultInstance(
                io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsRequest_SnapshotsEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.INT64,
                0L,
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                io.datafibre.fibre.proto.Snapshot.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.Long, io.datafibre.fibre.proto.Snapshot> snapshots_;
  private com.google.protobuf.MapField<java.lang.Long, io.datafibre.fibre.proto.Snapshot>
  internalGetSnapshots() {
    if (snapshots_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          SnapshotsDefaultEntryHolder.defaultEntry);
    }
    return snapshots_;
  }

  public int getSnapshotsCount() {
    return internalGetSnapshots().getMap().size();
  }
  /**
   * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
   */

  @java.lang.Override
  public boolean containsSnapshots(
      long key) {
    
    return internalGetSnapshots().getMap().containsKey(key);
  }
  /**
   * Use {@link #getSnapshotsMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> getSnapshots() {
    return getSnapshotsMap();
  }
  /**
   * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
   */
  @java.lang.Override

  public java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> getSnapshotsMap() {
    return internalGetSnapshots().getMap();
  }
  /**
   * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
   */
  @java.lang.Override

  public io.datafibre.fibre.proto.Snapshot getSnapshotsOrDefault(
      long key,
      io.datafibre.fibre.proto.Snapshot defaultValue) {
    
    java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> map =
        internalGetSnapshots().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
   */
  @java.lang.Override

  public io.datafibre.fibre.proto.Snapshot getSnapshotsOrThrow(
      long key) {
    
    java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> map =
        internalGetSnapshots().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int BROKER_FIELD_NUMBER = 2;
  private volatile java.lang.Object broker_;
  /**
   * <code>optional string broker = 2;</code>
   * @return Whether the broker field is set.
   */
  @java.lang.Override
  public boolean hasBroker() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string broker = 2;</code>
   * @return The broker.
   */
  @java.lang.Override
  public java.lang.String getBroker() {
    java.lang.Object ref = broker_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        broker_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string broker = 2;</code>
   * @return The bytes for broker.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getBrokerBytes() {
    java.lang.Object ref = broker_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      broker_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BROKER_PROPERTIES_FIELD_NUMBER = 3;
  private static final class BrokerPropertiesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsRequest_BrokerPropertiesEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.String> brokerProperties_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.String>
  internalGetBrokerProperties() {
    if (brokerProperties_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          BrokerPropertiesDefaultEntryHolder.defaultEntry);
    }
    return brokerProperties_;
  }

  public int getBrokerPropertiesCount() {
    return internalGetBrokerProperties().getMap().size();
  }
  /**
   * <code>map&lt;string, string&gt; broker_properties = 3;</code>
   */

  @java.lang.Override
  public boolean containsBrokerProperties(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    return internalGetBrokerProperties().getMap().containsKey(key);
  }
  /**
   * Use {@link #getBrokerPropertiesMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.String> getBrokerProperties() {
    return getBrokerPropertiesMap();
  }
  /**
   * <code>map&lt;string, string&gt; broker_properties = 3;</code>
   */
  @java.lang.Override

  public java.util.Map<java.lang.String, java.lang.String> getBrokerPropertiesMap() {
    return internalGetBrokerProperties().getMap();
  }
  /**
   * <code>map&lt;string, string&gt; broker_properties = 3;</code>
   */
  @java.lang.Override

  public java.lang.String getBrokerPropertiesOrDefault(
      java.lang.String key,
      java.lang.String defaultValue) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetBrokerProperties().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, string&gt; broker_properties = 3;</code>
   */
  @java.lang.Override

  public java.lang.String getBrokerPropertiesOrThrow(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetBrokerProperties().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    com.google.protobuf.GeneratedMessageV3
      .serializeLongMapTo(
        output,
        internalGetSnapshots(),
        SnapshotsDefaultEntryHolder.defaultEntry,
        1);
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, broker_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetBrokerProperties(),
        BrokerPropertiesDefaultEntryHolder.defaultEntry,
        3);
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.Long, io.datafibre.fibre.proto.Snapshot> entry
         : internalGetSnapshots().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Long, io.datafibre.fibre.proto.Snapshot>
      snapshots__ = SnapshotsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, snapshots__);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, broker_);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetBrokerProperties().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      brokerProperties__ = BrokerPropertiesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, brokerProperties__);
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
    if (!(obj instanceof io.datafibre.fibre.proto.UploadSnapshotsRequest)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.UploadSnapshotsRequest other = (io.datafibre.fibre.proto.UploadSnapshotsRequest) obj;

    if (!internalGetSnapshots().equals(
        other.internalGetSnapshots())) return false;
    if (hasBroker() != other.hasBroker()) return false;
    if (hasBroker()) {
      if (!getBroker()
          .equals(other.getBroker())) return false;
    }
    if (!internalGetBrokerProperties().equals(
        other.internalGetBrokerProperties())) return false;
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
    if (!internalGetSnapshots().getMap().isEmpty()) {
      hash = (37 * hash) + SNAPSHOTS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetSnapshots().hashCode();
    }
    if (hasBroker()) {
      hash = (37 * hash) + BROKER_FIELD_NUMBER;
      hash = (53 * hash) + getBroker().hashCode();
    }
    if (!internalGetBrokerProperties().getMap().isEmpty()) {
      hash = (37 * hash) + BROKER_PROPERTIES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetBrokerProperties().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.UploadSnapshotsRequest parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.UploadSnapshotsRequest prototype) {
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
   * Protobuf type {@code starrocks.lake.UploadSnapshotsRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.lake.UploadSnapshotsRequest)
      io.datafibre.fibre.proto.UploadSnapshotsRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsRequest_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetSnapshots();
        case 3:
          return internalGetBrokerProperties();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableSnapshots();
        case 3:
          return internalGetMutableBrokerProperties();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.UploadSnapshotsRequest.class, io.datafibre.fibre.proto.UploadSnapshotsRequest.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.UploadSnapshotsRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      internalGetMutableSnapshots().clear();
      broker_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      internalGetMutableBrokerProperties().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.LakeServiceOuterClass.internal_static_starrocks_lake_UploadSnapshotsRequest_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.UploadSnapshotsRequest getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.UploadSnapshotsRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.UploadSnapshotsRequest build() {
      io.datafibre.fibre.proto.UploadSnapshotsRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.UploadSnapshotsRequest buildPartial() {
      io.datafibre.fibre.proto.UploadSnapshotsRequest result = new io.datafibre.fibre.proto.UploadSnapshotsRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.snapshots_ = internalGetSnapshots();
      result.snapshots_.makeImmutable();
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.broker_ = broker_;
      result.brokerProperties_ = internalGetBrokerProperties();
      result.brokerProperties_.makeImmutable();
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
      if (other instanceof io.datafibre.fibre.proto.UploadSnapshotsRequest) {
        return mergeFrom((io.datafibre.fibre.proto.UploadSnapshotsRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.UploadSnapshotsRequest other) {
      if (other == io.datafibre.fibre.proto.UploadSnapshotsRequest.getDefaultInstance()) return this;
      internalGetMutableSnapshots().mergeFrom(
          other.internalGetSnapshots());
      if (other.hasBroker()) {
        bitField0_ |= 0x00000002;
        broker_ = other.broker_;
        onChanged();
      }
      internalGetMutableBrokerProperties().mergeFrom(
          other.internalGetBrokerProperties());
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
            case 10: {
              com.google.protobuf.MapEntry<java.lang.Long, io.datafibre.fibre.proto.Snapshot>
              snapshots__ = input.readMessage(
                  SnapshotsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              internalGetMutableSnapshots().getMutableMap().put(
                  snapshots__.getKey(), snapshots__.getValue());
              break;
            } // case 10
            case 18: {
              broker_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              brokerProperties__ = input.readMessage(
                  BrokerPropertiesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              internalGetMutableBrokerProperties().getMutableMap().put(
                  brokerProperties__.getKey(), brokerProperties__.getValue());
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

    private com.google.protobuf.MapField<
        java.lang.Long, io.datafibre.fibre.proto.Snapshot> snapshots_;
    private com.google.protobuf.MapField<java.lang.Long, io.datafibre.fibre.proto.Snapshot>
    internalGetSnapshots() {
      if (snapshots_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            SnapshotsDefaultEntryHolder.defaultEntry);
      }
      return snapshots_;
    }
    private com.google.protobuf.MapField<java.lang.Long, io.datafibre.fibre.proto.Snapshot>
    internalGetMutableSnapshots() {
      onChanged();;
      if (snapshots_ == null) {
        snapshots_ = com.google.protobuf.MapField.newMapField(
            SnapshotsDefaultEntryHolder.defaultEntry);
      }
      if (!snapshots_.isMutable()) {
        snapshots_ = snapshots_.copy();
      }
      return snapshots_;
    }

    public int getSnapshotsCount() {
      return internalGetSnapshots().getMap().size();
    }
    /**
     * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
     */

    @java.lang.Override
    public boolean containsSnapshots(
        long key) {
      
      return internalGetSnapshots().getMap().containsKey(key);
    }
    /**
     * Use {@link #getSnapshotsMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> getSnapshots() {
      return getSnapshotsMap();
    }
    /**
     * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
     */
    @java.lang.Override

    public java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> getSnapshotsMap() {
      return internalGetSnapshots().getMap();
    }
    /**
     * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
     */
    @java.lang.Override

    public io.datafibre.fibre.proto.Snapshot getSnapshotsOrDefault(
        long key,
        io.datafibre.fibre.proto.Snapshot defaultValue) {
      
      java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> map =
          internalGetSnapshots().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
     */
    @java.lang.Override

    public io.datafibre.fibre.proto.Snapshot getSnapshotsOrThrow(
        long key) {
      
      java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> map =
          internalGetSnapshots().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearSnapshots() {
      internalGetMutableSnapshots().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
     */

    public Builder removeSnapshots(
        long key) {
      
      internalGetMutableSnapshots().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot>
    getMutableSnapshots() {
      return internalGetMutableSnapshots().getMutableMap();
    }
    /**
     * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
     */
    public Builder putSnapshots(
        long key,
        io.datafibre.fibre.proto.Snapshot value) {
      
      if (value == null) {
  throw new NullPointerException("map value");
}

      internalGetMutableSnapshots().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;int64, .starrocks.lake.Snapshot&gt; snapshots = 1;</code>
     */

    public Builder putAllSnapshots(
        java.util.Map<java.lang.Long, io.datafibre.fibre.proto.Snapshot> values) {
      internalGetMutableSnapshots().getMutableMap()
          .putAll(values);
      return this;
    }

    private java.lang.Object broker_ = "";
    /**
     * <code>optional string broker = 2;</code>
     * @return Whether the broker field is set.
     */
    public boolean hasBroker() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional string broker = 2;</code>
     * @return The broker.
     */
    public java.lang.String getBroker() {
      java.lang.Object ref = broker_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          broker_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string broker = 2;</code>
     * @return The bytes for broker.
     */
    public com.google.protobuf.ByteString
        getBrokerBytes() {
      java.lang.Object ref = broker_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        broker_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string broker = 2;</code>
     * @param value The broker to set.
     * @return This builder for chaining.
     */
    public Builder setBroker(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      broker_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string broker = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBroker() {
      bitField0_ = (bitField0_ & ~0x00000002);
      broker_ = getDefaultInstance().getBroker();
      onChanged();
      return this;
    }
    /**
     * <code>optional string broker = 2;</code>
     * @param value The bytes for broker to set.
     * @return This builder for chaining.
     */
    public Builder setBrokerBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      broker_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> brokerProperties_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetBrokerProperties() {
      if (brokerProperties_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            BrokerPropertiesDefaultEntryHolder.defaultEntry);
      }
      return brokerProperties_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMutableBrokerProperties() {
      onChanged();;
      if (brokerProperties_ == null) {
        brokerProperties_ = com.google.protobuf.MapField.newMapField(
            BrokerPropertiesDefaultEntryHolder.defaultEntry);
      }
      if (!brokerProperties_.isMutable()) {
        brokerProperties_ = brokerProperties_.copy();
      }
      return brokerProperties_;
    }

    public int getBrokerPropertiesCount() {
      return internalGetBrokerProperties().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; broker_properties = 3;</code>
     */

    @java.lang.Override
    public boolean containsBrokerProperties(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      return internalGetBrokerProperties().getMap().containsKey(key);
    }
    /**
     * Use {@link #getBrokerPropertiesMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getBrokerProperties() {
      return getBrokerPropertiesMap();
    }
    /**
     * <code>map&lt;string, string&gt; broker_properties = 3;</code>
     */
    @java.lang.Override

    public java.util.Map<java.lang.String, java.lang.String> getBrokerPropertiesMap() {
      return internalGetBrokerProperties().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; broker_properties = 3;</code>
     */
    @java.lang.Override

    public java.lang.String getBrokerPropertiesOrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetBrokerProperties().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; broker_properties = 3;</code>
     */
    @java.lang.Override

    public java.lang.String getBrokerPropertiesOrThrow(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetBrokerProperties().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearBrokerProperties() {
      internalGetMutableBrokerProperties().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; broker_properties = 3;</code>
     */

    public Builder removeBrokerProperties(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      internalGetMutableBrokerProperties().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String>
    getMutableBrokerProperties() {
      return internalGetMutableBrokerProperties().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; broker_properties = 3;</code>
     */
    public Builder putBrokerProperties(
        java.lang.String key,
        java.lang.String value) {
      if (key == null) { throw new NullPointerException("map key"); }
      if (value == null) {
  throw new NullPointerException("map value");
}

      internalGetMutableBrokerProperties().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; broker_properties = 3;</code>
     */

    public Builder putAllBrokerProperties(
        java.util.Map<java.lang.String, java.lang.String> values) {
      internalGetMutableBrokerProperties().getMutableMap()
          .putAll(values);
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


    // @@protoc_insertion_point(builder_scope:starrocks.lake.UploadSnapshotsRequest)
  }

  // @@protoc_insertion_point(class_scope:starrocks.lake.UploadSnapshotsRequest)
  private static final io.datafibre.fibre.proto.UploadSnapshotsRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.UploadSnapshotsRequest();
  }

  public static io.datafibre.fibre.proto.UploadSnapshotsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<UploadSnapshotsRequest>
      PARSER = new com.google.protobuf.AbstractParser<UploadSnapshotsRequest>() {
    @java.lang.Override
    public UploadSnapshotsRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<UploadSnapshotsRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UploadSnapshotsRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.UploadSnapshotsRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
