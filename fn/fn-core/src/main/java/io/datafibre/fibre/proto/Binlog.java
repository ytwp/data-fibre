// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package com.starrocks.proto;

public final class Binlog {
  private Binlog() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_FileIdPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_FileIdPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_InsertRangePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_InsertRangePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_UpdatePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_UpdatePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_DeletePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_DeletePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_LogEntryPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_LogEntryPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PageContentPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PageContentPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PageHeaderPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PageHeaderPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_BinlogFileHeaderPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_BinlogFileHeaderPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_BinlogFileMetaPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_BinlogFileMetaPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_BinlogLsnPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_BinlogLsnPB_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014binlog.proto\022\tstarrocks\032\013types.proto\"4" +
      "\n\010FileIdPB\022\021\n\trowset_id\030\001 \001(\003\022\025\n\rsegment" +
      "_index\030\002 \001(\005\"]\n\rInsertRangePB\022$\n\007file_id" +
      "\030\001 \001(\0132\023.starrocks.FileIdPB\022\024\n\014start_row" +
      "_id\030\002 \001(\005\022\020\n\010num_rows\030\003 \001(\005\"\220\001\n\010UpdatePB" +
      "\022+\n\016before_file_id\030\001 \001(\0132\023.starrocks.Fil" +
      "eIdPB\022\025\n\rbefore_row_id\030\002 \001(\005\022*\n\rafter_fi" +
      "le_id\030\003 \001(\0132\023.starrocks.FileIdPB\022\024\n\014afte" +
      "r_row_id\030\004 \001(\005\"@\n\010DeletePB\022$\n\007file_id\030\001 " +
      "\001(\0132\023.starrocks.FileIdPB\022\016\n\006row_id\030\002 \001(\005" +
      "\"\304\001\n\nLogEntryPB\022-\n\nentry_type\030\001 \001(\0162\031.st" +
      "arrocks.LogEntryTypePB\0223\n\021insert_range_d" +
      "ata\030\002 \001(\0132\030.starrocks.InsertRangePB\022(\n\013u" +
      "pdate_data\030\003 \001(\0132\023.starrocks.UpdatePB\022(\n" +
      "\013delete_data\030\004 \001(\0132\023.starrocks.DeletePB\"" +
      "7\n\rPageContentPB\022&\n\007entries\030\001 \003(\0132\025.star" +
      "rocks.LogEntryPB\"\322\002\n\014PageHeaderPB\022&\n\tpag" +
      "e_type\030\001 \001(\0162\023.starrocks.PageType\0223\n\rcom" +
      "press_type\030\002 \001(\0162\034.starrocks.Compression" +
      "TypePB\022\031\n\021uncompressed_size\030\003 \001(\005\022\027\n\017com" +
      "pressed_size\030\004 \001(\005\022\033\n\023compressed_page_cr" +
      "c\030\005 \001(\005\022\017\n\007version\030\006 \001(\003\022\027\n\017num_log_entr" +
      "ies\030\007 \001(\005\022\024\n\014start_seq_id\030\010 \001(\003\022\022\n\nend_s" +
      "eq_id\030\t \001(\003\022\027\n\017timestamp_in_us\030\n \001(\003\022\026\n\016" +
      "end_of_version\030\013 \001(\010\022\017\n\007rowsets\030\014 \003(\003\",\n" +
      "\022BinlogFileHeaderPB\022\026\n\016format_version\030\001 " +
      "\001(\005\"\374\001\n\020BinlogFileMetaPB\022\n\n\002id\030\001 \001(\003\022\025\n\r" +
      "start_version\030\002 \001(\003\022\024\n\014start_seq_id\030\003 \001(" +
      "\003\022\035\n\025start_timestamp_in_us\030\004 \001(\003\022\023\n\013end_" +
      "version\030\005 \001(\003\022\022\n\nend_seq_id\030\006 \001(\003\022\033\n\023end" +
      "_timestamp_in_us\030\007 \001(\003\022\023\n\013version_eof\030\010 " +
      "\001(\010\022\021\n\tnum_pages\030\t \001(\003\022\021\n\tfile_size\030\n \001(" +
      "\003\022\017\n\007rowsets\030\013 \003(\003\".\n\013BinlogLsnPB\022\017\n\007ver" +
      "sion\030\001 \001(\003\022\016\n\006seq_id\030\002 \001(\003*Q\n\016LogEntryTy" +
      "pePB\022\023\n\017INSERT_RANGE_PB\020\000\022\r\n\tUPDATE_PB\020\001" +
      "\022\r\n\tDELETE_PB\020\002\022\014\n\010EMPTY_PB\020\003*\026\n\010PageTyp" +
      "e\022\n\n\006NORMAL\020\000B\027\n\023com.starrocks.protoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.starrocks.proto.Types.getDescriptor(),
        });
    internal_static_starrocks_FileIdPB_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_starrocks_FileIdPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_FileIdPB_descriptor,
        new java.lang.String[] { "RowsetId", "SegmentIndex", });
    internal_static_starrocks_InsertRangePB_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_starrocks_InsertRangePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_InsertRangePB_descriptor,
        new java.lang.String[] { "FileId", "StartRowId", "NumRows", });
    internal_static_starrocks_UpdatePB_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_starrocks_UpdatePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_UpdatePB_descriptor,
        new java.lang.String[] { "BeforeFileId", "BeforeRowId", "AfterFileId", "AfterRowId", });
    internal_static_starrocks_DeletePB_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_starrocks_DeletePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_DeletePB_descriptor,
        new java.lang.String[] { "FileId", "RowId", });
    internal_static_starrocks_LogEntryPB_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_starrocks_LogEntryPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_LogEntryPB_descriptor,
        new java.lang.String[] { "EntryType", "InsertRangeData", "UpdateData", "DeleteData", });
    internal_static_starrocks_PageContentPB_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_starrocks_PageContentPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PageContentPB_descriptor,
        new java.lang.String[] { "Entries", });
    internal_static_starrocks_PageHeaderPB_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_starrocks_PageHeaderPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PageHeaderPB_descriptor,
        new java.lang.String[] { "PageType", "CompressType", "UncompressedSize", "CompressedSize", "CompressedPageCrc", "Version", "NumLogEntries", "StartSeqId", "EndSeqId", "TimestampInUs", "EndOfVersion", "Rowsets", });
    internal_static_starrocks_BinlogFileHeaderPB_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_starrocks_BinlogFileHeaderPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_BinlogFileHeaderPB_descriptor,
        new java.lang.String[] { "FormatVersion", });
    internal_static_starrocks_BinlogFileMetaPB_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_starrocks_BinlogFileMetaPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_BinlogFileMetaPB_descriptor,
        new java.lang.String[] { "Id", "StartVersion", "StartSeqId", "StartTimestampInUs", "EndVersion", "EndSeqId", "EndTimestampInUs", "VersionEof", "NumPages", "FileSize", "Rowsets", });
    internal_static_starrocks_BinlogLsnPB_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_starrocks_BinlogLsnPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_BinlogLsnPB_descriptor,
        new java.lang.String[] { "Version", "SeqId", });
    com.starrocks.proto.Types.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
