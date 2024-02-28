// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package io.datafibre.fibre.proto;

public final class Data {
  private Data() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PQueryStatistics_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PQueryStatistics_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_QueryStatisticsItemPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_QueryStatisticsItemPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PRowBatch_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PRowBatch_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_ChunkExtraColumnsMetaPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_ChunkExtraColumnsMetaPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_ChunkPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_ChunkPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_SegmentPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_SegmentPB_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ndata.proto\022\tstarrocks\032\013types.proto\"\311\001\n" +
      "\020PQueryStatistics\022\021\n\tscan_rows\030\001 \001(\003\022\022\n\n" +
      "scan_bytes\030\002 \001(\003\022\025\n\rreturned_rows\030\003 \001(\003\022" +
      "\023\n\013cpu_cost_ns\030\004 \001(\003\022\026\n\016mem_cost_bytes\030\005" +
      " \001(\003\022\023\n\013spill_bytes\030\006 \001(\003\0225\n\013stats_items" +
      "\030\n \003(\0132 .starrocks.QueryStatisticsItemPB" +
      "\"P\n\025QueryStatisticsItemPB\022\021\n\tscan_rows\030\001" +
      " \001(\003\022\022\n\nscan_bytes\030\002 \001(\003\022\020\n\010table_id\030\003 \001" +
      "(\003\"s\n\tPRowBatch\022\020\n\010num_rows\030\001 \002(\005\022\022\n\nrow" +
      "_tuples\030\002 \003(\005\022\025\n\rtuple_offsets\030\003 \003(\005\022\022\n\n" +
      "tuple_data\030\004 \002(\014\022\025\n\ris_compressed\030\005 \002(\010\"" +
      "e\n\027ChunkExtraColumnsMetaPB\022\'\n\ttype_desc\030" +
      "\001 \001(\0132\024.starrocks.PTypeDesc\022\017\n\007is_null\030\002" +
      " \001(\010\022\020\n\010is_const\030\003 \001(\010\"\267\002\n\007ChunkPB\022\014\n\004da" +
      "ta\030\001 \001(\014\0223\n\rcompress_type\030\002 \001(\0162\034.starro" +
      "cks.CompressionTypePB\022\031\n\021uncompressed_si" +
      "ze\030\003 \001(\003\022\023\n\013slot_id_map\030\004 \003(\005\022\020\n\010is_null" +
      "s\030\005 \003(\010\022\021\n\tis_consts\030\006 \003(\010\022\024\n\014tuple_id_m" +
      "ap\030\007 \003(\005\022\021\n\tdata_size\030\010 \001(\003\022\027\n\017serialize" +
      "d_size\030\t \001(\003\022\024\n\014encode_level\030\n \003(\005\022<\n\020ex" +
      "tra_data_metas\030\013 \003(\0132\".starrocks.ChunkEx" +
      "traColumnsMetaPB\"\223\003\n\tSegmentPB\022\022\n\nsegmen" +
      "t_id\030\001 \001(\003\022\014\n\004data\030\002 \001(\014\022\021\n\tdata_size\030\003 " +
      "\001(\003\022\022\n\nindex_size\030\004 \001(\003\022\020\n\010num_rows\030\005 \001(" +
      "\003\022\020\n\010row_size\030\006 \001(\003\022\014\n\004path\030\007 \001(\t\022\021\n\tdel" +
      "ete_id\030\010 \001(\003\022\030\n\020delete_data_size\030\t \001(\003\022\027" +
      "\n\017delete_num_rows\030\n \001(\003\022\023\n\013delete_path\030\013" +
      " \001(\t\022\037\n\027partial_footer_position\030\014 \001(\003\022\033\n" +
      "\023partial_footer_size\030\r \001(\003\022\021\n\tupdate_id\030" +
      "\016 \001(\003\022\030\n\020update_data_size\030\017 \001(\003\022\027\n\017updat" +
      "e_num_rows\030\020 \001(\003\022\023\n\013update_path\030\021 \001(\t\022\027\n" +
      "\017update_row_size\030\022 \001(\003B\027\n\023io.datafibre.fibre." +
      "protoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.datafibre.fibre.proto.Types.getDescriptor(),
        });
    internal_static_starrocks_PQueryStatistics_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_starrocks_PQueryStatistics_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PQueryStatistics_descriptor,
        new java.lang.String[] { "ScanRows", "ScanBytes", "ReturnedRows", "CpuCostNs", "MemCostBytes", "SpillBytes", "StatsItems", });
    internal_static_starrocks_QueryStatisticsItemPB_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_starrocks_QueryStatisticsItemPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_QueryStatisticsItemPB_descriptor,
        new java.lang.String[] { "ScanRows", "ScanBytes", "TableId", });
    internal_static_starrocks_PRowBatch_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_starrocks_PRowBatch_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PRowBatch_descriptor,
        new java.lang.String[] { "NumRows", "RowTuples", "TupleOffsets", "TupleData", "IsCompressed", });
    internal_static_starrocks_ChunkExtraColumnsMetaPB_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_starrocks_ChunkExtraColumnsMetaPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_ChunkExtraColumnsMetaPB_descriptor,
        new java.lang.String[] { "TypeDesc", "IsNull", "IsConst", });
    internal_static_starrocks_ChunkPB_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_starrocks_ChunkPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_ChunkPB_descriptor,
        new java.lang.String[] { "Data", "CompressType", "UncompressedSize", "SlotIdMap", "IsNulls", "IsConsts", "TupleIdMap", "DataSize", "SerializedSize_", "EncodeLevel", "ExtraDataMetas", });
    internal_static_starrocks_SegmentPB_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_starrocks_SegmentPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_SegmentPB_descriptor,
        new java.lang.String[] { "SegmentId", "Data", "DataSize", "IndexSize", "NumRows", "RowSize", "Path", "DeleteId", "DeleteDataSize", "DeleteNumRows", "DeletePath", "PartialFooterPosition", "PartialFooterSize", "UpdateId", "UpdateDataSize", "UpdateNumRows", "UpdatePath", "UpdateRowSize", });
    io.datafibre.fibre.proto.Types.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
