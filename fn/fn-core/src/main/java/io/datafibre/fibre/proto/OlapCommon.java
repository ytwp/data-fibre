// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_common.proto

package com.starrocks.proto;

public final class OlapCommon {
  private OlapCommon() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_EditVersionPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_EditVersionPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_DeltaColumnGroupColumnIdsPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_DeltaColumnGroupColumnIdsPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_OldDeltaColumnGroupPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_OldDeltaColumnGroupPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_DeltaColumnGroupPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_DeltaColumnGroupPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_DeltaColumnGroupListPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_DeltaColumnGroupListPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_DeltaColumnGroupSnapshotPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_DeltaColumnGroupSnapshotPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PagePointerPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PagePointerPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PNetworkAddress_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PNetworkAddress_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021olap_common.proto\022\tstarrocks\";\n\rEditVe" +
      "rsionPB\022\024\n\014major_number\030\001 \001(\003\022\024\n\014minor_n" +
      "umber\030\002 \001(\003\"1\n\033DeltaColumnGroupColumnIds" +
      "PB\022\022\n\ncolumn_ids\030\001 \003(\r\"@\n\025OldDeltaColumn" +
      "GroupPB\022\022\n\ncolumn_ids\030\001 \003(\r\022\023\n\013column_fi" +
      "le\030\002 \001(\t\"f\n\022DeltaColumnGroupPB\022:\n\ncolumn" +
      "_ids\030\001 \003(\0132&.starrocks.DeltaColumnGroupC" +
      "olumnIdsPB\022\024\n\014column_files\030\002 \003(\t\"W\n\026Delt" +
      "aColumnGroupListPB\022+\n\004dcgs\030\001 \003(\0132\035.starr" +
      "ocks.DeltaColumnGroupPB\022\020\n\010versions\030\002 \003(" +
      "\003\"\214\001\n\032DeltaColumnGroupSnapshotPB\022\021\n\ttabl" +
      "et_id\030\001 \003(\003\022\021\n\trowset_id\030\002 \003(\t\022\022\n\nsegmen" +
      "t_id\030\003 \003(\r\0224\n\tdcg_lists\030\004 \003(\0132!.starrock" +
      "s.DeltaColumnGroupListPB\"-\n\rPagePointerP" +
      "B\022\016\n\006offset\030\001 \002(\004\022\014\n\004size\030\002 \002(\r\">\n\017PNetw" +
      "orkAddress\022\014\n\004host\030\001 \001(\t\022\014\n\004port\030\002 \001(\005\022\017" +
      "\n\007node_id\030\003 \001(\003B\027\n\023com.starrocks.protoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_starrocks_EditVersionPB_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_starrocks_EditVersionPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_EditVersionPB_descriptor,
        new java.lang.String[] { "MajorNumber", "MinorNumber", });
    internal_static_starrocks_DeltaColumnGroupColumnIdsPB_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_starrocks_DeltaColumnGroupColumnIdsPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_DeltaColumnGroupColumnIdsPB_descriptor,
        new java.lang.String[] { "ColumnIds", });
    internal_static_starrocks_OldDeltaColumnGroupPB_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_starrocks_OldDeltaColumnGroupPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_OldDeltaColumnGroupPB_descriptor,
        new java.lang.String[] { "ColumnIds", "ColumnFile", });
    internal_static_starrocks_DeltaColumnGroupPB_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_starrocks_DeltaColumnGroupPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_DeltaColumnGroupPB_descriptor,
        new java.lang.String[] { "ColumnIds", "ColumnFiles", });
    internal_static_starrocks_DeltaColumnGroupListPB_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_starrocks_DeltaColumnGroupListPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_DeltaColumnGroupListPB_descriptor,
        new java.lang.String[] { "Dcgs", "Versions", });
    internal_static_starrocks_DeltaColumnGroupSnapshotPB_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_starrocks_DeltaColumnGroupSnapshotPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_DeltaColumnGroupSnapshotPB_descriptor,
        new java.lang.String[] { "TabletId", "RowsetId", "SegmentId", "DcgLists", });
    internal_static_starrocks_PagePointerPB_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_starrocks_PagePointerPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PagePointerPB_descriptor,
        new java.lang.String[] { "Offset", "Size", });
    internal_static_starrocks_PNetworkAddress_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_starrocks_PNetworkAddress_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PNetworkAddress_descriptor,
        new java.lang.String[] { "Host", "Port", "NodeId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
