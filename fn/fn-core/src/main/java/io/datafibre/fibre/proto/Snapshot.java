// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: snapshot.proto

package com.starrocks.proto;

public final class Snapshot {
  private Snapshot() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_SnapshotMetaFooterPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_SnapshotMetaFooterPB_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016snapshot.proto\022\tstarrocks\"\244\002\n\024Snapshot" +
      "MetaFooterPB\022\026\n\016format_version\030\001 \001(\005\0220\n\r" +
      "snapshot_type\030\002 \001(\0162\031.starrocks.Snapshot" +
      "TypePB\022\030\n\020snapshot_version\030\003 \001(\003\022\033\n\023rows" +
      "et_meta_offsets\030\004 \003(\003\022\025\n\rdelvec_segids\030\005" +
      " \003(\003\022\026\n\016delvec_offsets\030\006 \003(\003\022\027\n\017delvec_v" +
      "ersions\030\007 \003(\003\022\032\n\022tablet_meta_offset\030\010 \001(" +
      "\003\022\022\n\ndcg_segids\030\t \003(\003\022\023\n\013dcg_offsets\030\n \003" +
      "(\003*b\n\016SnapshotTypePB\022\031\n\025SNAPSHOT_TYPE_UN" +
      "KNOWN\020\000\022\035\n\031SNAPSHOT_TYPE_INCREMENTAL\020\001\022\026" +
      "\n\022SNAPSHOT_TYPE_FULL\020\002B\027\n\023com.starrocks." +
      "protoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_starrocks_SnapshotMetaFooterPB_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_starrocks_SnapshotMetaFooterPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_SnapshotMetaFooterPB_descriptor,
        new java.lang.String[] { "FormatVersion", "SnapshotType", "SnapshotVersion", "RowsetMetaOffsets", "DelvecSegids", "DelvecOffsets", "DelvecVersions", "TabletMetaOffset", "DcgSegids", "DcgOffsets", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
