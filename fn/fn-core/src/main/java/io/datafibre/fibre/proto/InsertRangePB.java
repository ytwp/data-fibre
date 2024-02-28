// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf type {@code starrocks.InsertRangePB}
 */
public final class InsertRangePB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:starrocks.InsertRangePB)
    InsertRangePBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InsertRangePB.newBuilder() to construct.
  private InsertRangePB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InsertRangePB() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new InsertRangePB();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.datafibre.fibre.proto.Binlog.internal_static_starrocks_InsertRangePB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.datafibre.fibre.proto.Binlog.internal_static_starrocks_InsertRangePB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.datafibre.fibre.proto.InsertRangePB.class, io.datafibre.fibre.proto.InsertRangePB.Builder.class);
  }

  private int bitField0_;
  public static final int FILE_ID_FIELD_NUMBER = 1;
  private io.datafibre.fibre.proto.FileIdPB fileId_;
  /**
   * <code>optional .starrocks.FileIdPB file_id = 1;</code>
   * @return Whether the fileId field is set.
   */
  @java.lang.Override
  public boolean hasFileId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .starrocks.FileIdPB file_id = 1;</code>
   * @return The fileId.
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.FileIdPB getFileId() {
    return fileId_ == null ? io.datafibre.fibre.proto.FileIdPB.getDefaultInstance() : fileId_;
  }
  /**
   * <code>optional .starrocks.FileIdPB file_id = 1;</code>
   */
  @java.lang.Override
  public io.datafibre.fibre.proto.FileIdPBOrBuilder getFileIdOrBuilder() {
    return fileId_ == null ? io.datafibre.fibre.proto.FileIdPB.getDefaultInstance() : fileId_;
  }

  public static final int START_ROW_ID_FIELD_NUMBER = 2;
  private int startRowId_;
  /**
   * <code>optional int32 start_row_id = 2;</code>
   * @return Whether the startRowId field is set.
   */
  @java.lang.Override
  public boolean hasStartRowId() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional int32 start_row_id = 2;</code>
   * @return The startRowId.
   */
  @java.lang.Override
  public int getStartRowId() {
    return startRowId_;
  }

  public static final int NUM_ROWS_FIELD_NUMBER = 3;
  private int numRows_;
  /**
   * <code>optional int32 num_rows = 3;</code>
   * @return Whether the numRows field is set.
   */
  @java.lang.Override
  public boolean hasNumRows() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional int32 num_rows = 3;</code>
   * @return The numRows.
   */
  @java.lang.Override
  public int getNumRows() {
    return numRows_;
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
      output.writeMessage(1, getFileId());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt32(2, startRowId_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeInt32(3, numRows_);
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
        .computeMessageSize(1, getFileId());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, startRowId_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, numRows_);
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
    if (!(obj instanceof io.datafibre.fibre.proto.InsertRangePB)) {
      return super.equals(obj);
    }
    io.datafibre.fibre.proto.InsertRangePB other = (io.datafibre.fibre.proto.InsertRangePB) obj;

    if (hasFileId() != other.hasFileId()) return false;
    if (hasFileId()) {
      if (!getFileId()
          .equals(other.getFileId())) return false;
    }
    if (hasStartRowId() != other.hasStartRowId()) return false;
    if (hasStartRowId()) {
      if (getStartRowId()
          != other.getStartRowId()) return false;
    }
    if (hasNumRows() != other.hasNumRows()) return false;
    if (hasNumRows()) {
      if (getNumRows()
          != other.getNumRows()) return false;
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
    if (hasFileId()) {
      hash = (37 * hash) + FILE_ID_FIELD_NUMBER;
      hash = (53 * hash) + getFileId().hashCode();
    }
    if (hasStartRowId()) {
      hash = (37 * hash) + START_ROW_ID_FIELD_NUMBER;
      hash = (53 * hash) + getStartRowId();
    }
    if (hasNumRows()) {
      hash = (37 * hash) + NUM_ROWS_FIELD_NUMBER;
      hash = (53 * hash) + getNumRows();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.datafibre.fibre.proto.InsertRangePB parseFrom(
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
  public static Builder newBuilder(io.datafibre.fibre.proto.InsertRangePB prototype) {
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
   * Protobuf type {@code starrocks.InsertRangePB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:starrocks.InsertRangePB)
      io.datafibre.fibre.proto.InsertRangePBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.datafibre.fibre.proto.Binlog.internal_static_starrocks_InsertRangePB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.datafibre.fibre.proto.Binlog.internal_static_starrocks_InsertRangePB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.datafibre.fibre.proto.InsertRangePB.class, io.datafibre.fibre.proto.InsertRangePB.Builder.class);
    }

    // Construct using io.datafibre.fibre.proto.InsertRangePB.newBuilder()
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
        getFileIdFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (fileIdBuilder_ == null) {
        fileId_ = null;
      } else {
        fileIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      startRowId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      numRows_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.datafibre.fibre.proto.Binlog.internal_static_starrocks_InsertRangePB_descriptor;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.InsertRangePB getDefaultInstanceForType() {
      return io.datafibre.fibre.proto.InsertRangePB.getDefaultInstance();
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.InsertRangePB build() {
      io.datafibre.fibre.proto.InsertRangePB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.datafibre.fibre.proto.InsertRangePB buildPartial() {
      io.datafibre.fibre.proto.InsertRangePB result = new io.datafibre.fibre.proto.InsertRangePB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (fileIdBuilder_ == null) {
          result.fileId_ = fileId_;
        } else {
          result.fileId_ = fileIdBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.startRowId_ = startRowId_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.numRows_ = numRows_;
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
      if (other instanceof io.datafibre.fibre.proto.InsertRangePB) {
        return mergeFrom((io.datafibre.fibre.proto.InsertRangePB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.datafibre.fibre.proto.InsertRangePB other) {
      if (other == io.datafibre.fibre.proto.InsertRangePB.getDefaultInstance()) return this;
      if (other.hasFileId()) {
        mergeFileId(other.getFileId());
      }
      if (other.hasStartRowId()) {
        setStartRowId(other.getStartRowId());
      }
      if (other.hasNumRows()) {
        setNumRows(other.getNumRows());
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
            case 10: {
              input.readMessage(
                  getFileIdFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              startRowId_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              numRows_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
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

    private io.datafibre.fibre.proto.FileIdPB fileId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.FileIdPB, io.datafibre.fibre.proto.FileIdPB.Builder, io.datafibre.fibre.proto.FileIdPBOrBuilder> fileIdBuilder_;
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     * @return Whether the fileId field is set.
     */
    public boolean hasFileId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     * @return The fileId.
     */
    public io.datafibre.fibre.proto.FileIdPB getFileId() {
      if (fileIdBuilder_ == null) {
        return fileId_ == null ? io.datafibre.fibre.proto.FileIdPB.getDefaultInstance() : fileId_;
      } else {
        return fileIdBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     */
    public Builder setFileId(io.datafibre.fibre.proto.FileIdPB value) {
      if (fileIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        fileId_ = value;
        onChanged();
      } else {
        fileIdBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     */
    public Builder setFileId(
        io.datafibre.fibre.proto.FileIdPB.Builder builderForValue) {
      if (fileIdBuilder_ == null) {
        fileId_ = builderForValue.build();
        onChanged();
      } else {
        fileIdBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     */
    public Builder mergeFileId(io.datafibre.fibre.proto.FileIdPB value) {
      if (fileIdBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            fileId_ != null &&
            fileId_ != io.datafibre.fibre.proto.FileIdPB.getDefaultInstance()) {
          fileId_ =
            io.datafibre.fibre.proto.FileIdPB.newBuilder(fileId_).mergeFrom(value).buildPartial();
        } else {
          fileId_ = value;
        }
        onChanged();
      } else {
        fileIdBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     */
    public Builder clearFileId() {
      if (fileIdBuilder_ == null) {
        fileId_ = null;
        onChanged();
      } else {
        fileIdBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     */
    public io.datafibre.fibre.proto.FileIdPB.Builder getFileIdBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getFileIdFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     */
    public io.datafibre.fibre.proto.FileIdPBOrBuilder getFileIdOrBuilder() {
      if (fileIdBuilder_ != null) {
        return fileIdBuilder_.getMessageOrBuilder();
      } else {
        return fileId_ == null ?
            io.datafibre.fibre.proto.FileIdPB.getDefaultInstance() : fileId_;
      }
    }
    /**
     * <code>optional .starrocks.FileIdPB file_id = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.datafibre.fibre.proto.FileIdPB, io.datafibre.fibre.proto.FileIdPB.Builder, io.datafibre.fibre.proto.FileIdPBOrBuilder>
        getFileIdFieldBuilder() {
      if (fileIdBuilder_ == null) {
        fileIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.datafibre.fibre.proto.FileIdPB, io.datafibre.fibre.proto.FileIdPB.Builder, io.datafibre.fibre.proto.FileIdPBOrBuilder>(
                getFileId(),
                getParentForChildren(),
                isClean());
        fileId_ = null;
      }
      return fileIdBuilder_;
    }

    private int startRowId_ ;
    /**
     * <code>optional int32 start_row_id = 2;</code>
     * @return Whether the startRowId field is set.
     */
    @java.lang.Override
    public boolean hasStartRowId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int32 start_row_id = 2;</code>
     * @return The startRowId.
     */
    @java.lang.Override
    public int getStartRowId() {
      return startRowId_;
    }
    /**
     * <code>optional int32 start_row_id = 2;</code>
     * @param value The startRowId to set.
     * @return This builder for chaining.
     */
    public Builder setStartRowId(int value) {
      bitField0_ |= 0x00000002;
      startRowId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 start_row_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearStartRowId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      startRowId_ = 0;
      onChanged();
      return this;
    }

    private int numRows_ ;
    /**
     * <code>optional int32 num_rows = 3;</code>
     * @return Whether the numRows field is set.
     */
    @java.lang.Override
    public boolean hasNumRows() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional int32 num_rows = 3;</code>
     * @return The numRows.
     */
    @java.lang.Override
    public int getNumRows() {
      return numRows_;
    }
    /**
     * <code>optional int32 num_rows = 3;</code>
     * @param value The numRows to set.
     * @return This builder for chaining.
     */
    public Builder setNumRows(int value) {
      bitField0_ |= 0x00000004;
      numRows_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 num_rows = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumRows() {
      bitField0_ = (bitField0_ & ~0x00000004);
      numRows_ = 0;
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


    // @@protoc_insertion_point(builder_scope:starrocks.InsertRangePB)
  }

  // @@protoc_insertion_point(class_scope:starrocks.InsertRangePB)
  private static final io.datafibre.fibre.proto.InsertRangePB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.datafibre.fibre.proto.InsertRangePB();
  }

  public static io.datafibre.fibre.proto.InsertRangePB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<InsertRangePB>
      PARSER = new com.google.protobuf.AbstractParser<InsertRangePB>() {
    @java.lang.Override
    public InsertRangePB parsePartialFrom(
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

  public static com.google.protobuf.Parser<InsertRangePB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InsertRangePB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.datafibre.fibre.proto.InsertRangePB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

