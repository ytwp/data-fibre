// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PCollectQueryStatisticsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PCollectQueryStatisticsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .starrocks.PUniqueId query_ids = 1;</code>
   */
  java.util.List<io.datafibre.fibre.proto.PUniqueId>
      getQueryIdsList();
  /**
   * <code>repeated .starrocks.PUniqueId query_ids = 1;</code>
   */
  io.datafibre.fibre.proto.PUniqueId getQueryIds(int index);
  /**
   * <code>repeated .starrocks.PUniqueId query_ids = 1;</code>
   */
  int getQueryIdsCount();
  /**
   * <code>repeated .starrocks.PUniqueId query_ids = 1;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.PUniqueIdOrBuilder>
      getQueryIdsOrBuilderList();
  /**
   * <code>repeated .starrocks.PUniqueId query_ids = 1;</code>
   */
  io.datafibre.fibre.proto.PUniqueIdOrBuilder getQueryIdsOrBuilder(
      int index);
}