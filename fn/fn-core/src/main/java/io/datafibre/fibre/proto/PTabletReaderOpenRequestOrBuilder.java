// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PTabletReaderOpenRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTabletReaderOpenRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.PUniqueId id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>optional .starrocks.PUniqueId id = 1;</code>
   * @return The id.
   */
  io.datafibre.fibre.proto.PUniqueId getId();
  /**
   * <code>optional .starrocks.PUniqueId id = 1;</code>
   */
  io.datafibre.fibre.proto.PUniqueIdOrBuilder getIdOrBuilder();

  /**
   * <code>optional int64 tablet_id = 2;</code>
   * @return Whether the tabletId field is set.
   */
  boolean hasTabletId();
  /**
   * <code>optional int64 tablet_id = 2;</code>
   * @return The tabletId.
   */
  long getTabletId();

  /**
   * <code>optional int64 version = 3;</code>
   * @return Whether the version field is set.
   */
  boolean hasVersion();
  /**
   * <code>optional int64 version = 3;</code>
   * @return The version.
   */
  long getVersion();
}