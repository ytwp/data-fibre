// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PCancelPlanFragmentRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PCancelPlanFragmentRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return Whether the finstId field is set.
   */
  boolean hasFinstId();
  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return The finstId.
   */
  com.starrocks.proto.PUniqueId getFinstId();
  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   */
  com.starrocks.proto.PUniqueIdOrBuilder getFinstIdOrBuilder();

  /**
   * <code>optional .starrocks.PPlanFragmentCancelReason cancel_reason = 2;</code>
   * @return Whether the cancelReason field is set.
   */
  boolean hasCancelReason();
  /**
   * <code>optional .starrocks.PPlanFragmentCancelReason cancel_reason = 2;</code>
   * @return The cancelReason.
   */
  com.starrocks.proto.PPlanFragmentCancelReason getCancelReason();

  /**
   * <code>optional bool is_pipeline = 10;</code>
   * @return Whether the isPipeline field is set.
   */
  boolean hasIsPipeline();
  /**
   * <code>optional bool is_pipeline = 10;</code>
   * @return The isPipeline.
   */
  boolean getIsPipeline();

  /**
   * <code>optional .starrocks.PUniqueId query_id = 11;</code>
   * @return Whether the queryId field is set.
   */
  boolean hasQueryId();
  /**
   * <code>optional .starrocks.PUniqueId query_id = 11;</code>
   * @return The queryId.
   */
  com.starrocks.proto.PUniqueId getQueryId();
  /**
   * <code>optional .starrocks.PUniqueId query_id = 11;</code>
   */
  com.starrocks.proto.PUniqueIdOrBuilder getQueryIdOrBuilder();
}
