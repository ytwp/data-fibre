// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PCollectQueryStatisticsResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PCollectQueryStatisticsResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .starrocks.PCollectQueryStatistics query_statistics = 1;</code>
   */
  java.util.List<com.starrocks.proto.PCollectQueryStatistics> 
      getQueryStatisticsList();
  /**
   * <code>repeated .starrocks.PCollectQueryStatistics query_statistics = 1;</code>
   */
  com.starrocks.proto.PCollectQueryStatistics getQueryStatistics(int index);
  /**
   * <code>repeated .starrocks.PCollectQueryStatistics query_statistics = 1;</code>
   */
  int getQueryStatisticsCount();
  /**
   * <code>repeated .starrocks.PCollectQueryStatistics query_statistics = 1;</code>
   */
  java.util.List<? extends com.starrocks.proto.PCollectQueryStatisticsOrBuilder> 
      getQueryStatisticsOrBuilderList();
  /**
   * <code>repeated .starrocks.PCollectQueryStatistics query_statistics = 1;</code>
   */
  com.starrocks.proto.PCollectQueryStatisticsOrBuilder getQueryStatisticsOrBuilder(
      int index);
}
