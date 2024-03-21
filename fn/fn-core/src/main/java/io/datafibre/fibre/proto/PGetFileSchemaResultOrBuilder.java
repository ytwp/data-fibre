// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PGetFileSchemaResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PGetFileSchemaResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   * @return Whether the status field is set.
   */
  boolean hasStatus();
  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   * @return The status.
   */
  io.datafibre.fibre.proto.StatusPB getStatus();
  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   */
  io.datafibre.fibre.proto.StatusPBOrBuilder getStatusOrBuilder();

  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  java.util.List<io.datafibre.fibre.proto.PSlotDescriptor>
      getSchemaList();
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  io.datafibre.fibre.proto.PSlotDescriptor getSchema(int index);
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  int getSchemaCount();
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.PSlotDescriptorOrBuilder>
      getSchemaOrBuilderList();
  /**
   * <code>repeated .starrocks.PSlotDescriptor schema = 2;</code>
   */
  io.datafibre.fibre.proto.PSlotDescriptorOrBuilder getSchemaOrBuilder(
      int index);
}