// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

public interface TabletStatResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.lake.TabletStatResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .starrocks.lake.TabletStatResponse.TabletStat tablet_stats = 1;</code>
   */
  java.util.List<io.datafibre.fibre.proto.TabletStatResponse.TabletStat>
      getTabletStatsList();
  /**
   * <code>repeated .starrocks.lake.TabletStatResponse.TabletStat tablet_stats = 1;</code>
   */
  io.datafibre.fibre.proto.TabletStatResponse.TabletStat getTabletStats(int index);
  /**
   * <code>repeated .starrocks.lake.TabletStatResponse.TabletStat tablet_stats = 1;</code>
   */
  int getTabletStatsCount();
  /**
   * <code>repeated .starrocks.lake.TabletStatResponse.TabletStat tablet_stats = 1;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.TabletStatResponse.TabletStatOrBuilder>
      getTabletStatsOrBuilderList();
  /**
   * <code>repeated .starrocks.lake.TabletStatResponse.TabletStat tablet_stats = 1;</code>
   */
  io.datafibre.fibre.proto.TabletStatResponse.TabletStatOrBuilder getTabletStatsOrBuilder(
      int index);
}
