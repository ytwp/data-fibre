// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PTransmitChunkResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTransmitChunkResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return Whether the status field is set.
   */
  boolean hasStatus();
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return The status.
   */
  com.starrocks.proto.StatusPB getStatus();
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   */
  com.starrocks.proto.StatusPBOrBuilder getStatusOrBuilder();

  /**
   * <pre>
   * Deprecated
   * </pre>
   *
   * <code>optional int64 receive_timestamp = 2;</code>
   * @return Whether the receiveTimestamp field is set.
   */
  boolean hasReceiveTimestamp();
  /**
   * <pre>
   * Deprecated
   * </pre>
   *
   * <code>optional int64 receive_timestamp = 2;</code>
   * @return The receiveTimestamp.
   */
  long getReceiveTimestamp();

  /**
   * <code>optional int64 receiver_post_process_time = 3;</code>
   * @return Whether the receiverPostProcessTime field is set.
   */
  boolean hasReceiverPostProcessTime();
  /**
   * <code>optional int64 receiver_post_process_time = 3;</code>
   * @return The receiverPostProcessTime.
   */
  long getReceiverPostProcessTime();
}
