// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_types.proto

package io.datafibre.fibre.proto;

public final class LakeTypes {
  private LakeTypes() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_DelvecDataPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_DelvecDataPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_DelvecPagePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_DelvecPagePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_DelvecCacheKeyPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_DelvecCacheKeyPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_FileMetaPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_FileMetaPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_DelvecMetadataPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_DelvecMetadataPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_DelvecMetadataPB_VersionToFileEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_DelvecMetadataPB_VersionToFileEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_DelvecMetadataPB_DelvecsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_DelvecMetadataPB_DelvecsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_RowsetMetadataPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_RowsetMetadataPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TabletMetadataPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TabletMetadataPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_MetadataUpdateInfoPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_MetadataUpdateInfoPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TxnLogPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TxnLogPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TxnLogPB_OpWrite_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TxnLogPB_OpWrite_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TxnLogPB_OpCompaction_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TxnLogPB_OpCompaction_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TxnLogPB_OpSchemaChange_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TxnLogPB_OpSchemaChange_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TxnLogPB_OpAlterMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TxnLogPB_OpAlterMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TxnLogPB_OpReplication_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TxnLogPB_OpReplication_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TxnLogPB_OpReplication_DelvecsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TxnLogPB_OpReplication_DelvecsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_lake_TabletMetadataLockPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_lake_TabletMetadataLockPB_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020lake_types.proto\022\016starrocks.lake\032\013type" +
      "s.proto\032\023tablet_schema.proto\032\017olap_file." +
      "proto\"-\n\014DelvecDataPB\022\017\n\007version\030\001 \001(\003\022\014" +
      "\n\004data\030\002 \001(\014\"=\n\014DelvecPagePB\022\017\n\007version\030" +
      "\001 \001(\003\022\016\n\006offset\030\002 \001(\004\022\014\n\004size\030\003 \001(\004\"Q\n\020D" +
      "elvecCacheKeyPB\022\n\n\002id\030\001 \001(\003\0221\n\013delvec_pa" +
      "ge\030\002 \001(\0132\034.starrocks.lake.DelvecPagePB\"(" +
      "\n\nFileMetaPB\022\014\n\004name\030\001 \001(\t\022\014\n\004size\030\002 \001(\003" +
      "\"\300\002\n\020DelvecMetadataPB\022L\n\017version_to_file" +
      "\030\001 \003(\01323.starrocks.lake.DelvecMetadataPB" +
      ".VersionToFileEntry\022>\n\007delvecs\030\002 \003(\0132-.s" +
      "tarrocks.lake.DelvecMetadataPB.DelvecsEn" +
      "try\032P\n\022VersionToFileEntry\022\013\n\003key\030\001 \001(\003\022)" +
      "\n\005value\030\002 \001(\0132\032.starrocks.lake.FileMetaP" +
      "B:\0028\001\032L\n\014DelvecsEntry\022\013\n\003key\030\001 \001(\r\022+\n\005va" +
      "lue\030\002 \001(\0132\034.starrocks.lake.DelvecPagePB:" +
      "\0028\001\"\362\001\n\020RowsetMetadataPB\022\n\n\002id\030\001 \001(\r\022\022\n\n" +
      "overlapped\030\002 \001(\010\022\020\n\010segments\030\003 \003(\t\022\020\n\010nu" +
      "m_rows\030\004 \001(\003\022\021\n\tdata_size\030\005 \001(\003\0226\n\020delet" +
      "e_predicate\030\006 \001(\0132\034.starrocks.DeletePred" +
      "icatePB\022\020\n\010num_dels\030\007 \001(\003\022\030\n\014segment_siz" +
      "e\030\010 \003(\004B\002\020\001\022#\n\033max_compact_input_rowset_" +
      "id\030\t \001(\r\"\261\004\n\020TabletMetadataPB\022\n\n\002id\030\001 \001(" +
      "\003\022\017\n\007version\030\002 \001(\003\022)\n\006schema\030\003 \001(\0132\031.sta" +
      "rrocks.TabletSchemaPB\0221\n\007rowsets\030\004 \003(\0132 " +
      ".starrocks.lake.RowsetMetadataPB\022\026\n\016next" +
      "_rowset_id\030\005 \001(\r\022\030\n\020cumulative_point\030\006 \001" +
      "(\r\0225\n\013delvec_meta\030\007 \001(\0132 .starrocks.lake" +
      ".DelvecMetadataPB\022;\n\021compaction_inputs\030\010" +
      " \003(\0132 .starrocks.lake.RowsetMetadataPB\022\034" +
      "\n\024prev_garbage_version\030\t \001(\003\0220\n\014orphan_f" +
      "iles\030\n \003(\0132\032.starrocks.lake.FileMetaPB\022\037" +
      "\n\027enable_persistent_index\030\013 \001(\010\022D\n\025persi" +
      "stent_index_type\030\014 \001(\0162%.starrocks.lake." +
      "PersistentIndexTypePB\022\023\n\013commit_time\030\r \001" +
      "(\003\0220\n\rsource_schema\030\016 \001(\0132\031.starrocks.Ta" +
      "bletSchemaPB\"7\n\024MetadataUpdateInfoPB\022\037\n\027" +
      "enable_persistent_index\030\001 \001(\010\"\237\t\n\010TxnLog" +
      "PB\022\021\n\ttablet_id\030\001 \001(\003\022\016\n\006txn_id\030\002 \001(\003\0222\n" +
      "\010op_write\030\003 \001(\0132 .starrocks.lake.TxnLogP" +
      "B.OpWrite\022<\n\rop_compaction\030\004 \001(\0132%.starr" +
      "ocks.lake.TxnLogPB.OpCompaction\022A\n\020op_sc" +
      "hema_change\030\005 \001(\0132\'.starrocks.lake.TxnLo" +
      "gPB.OpSchemaChange\022C\n\021op_alter_metadata\030" +
      "\006 \001(\0132(.starrocks.lake.TxnLogPB.OpAlterM" +
      "etadata\022>\n\016op_replication\030\007 \001(\0132&.starro" +
      "cks.lake.TxnLogPB.OpReplication\032\221\001\n\007OpWr" +
      "ite\0220\n\006rowset\030\001 \001(\0132 .starrocks.lake.Row" +
      "setMetadataPB\022,\n\010txn_meta\030\002 \001(\0132\032.starro" +
      "cks.RowsetTxnMetaPB\022\014\n\004dels\030\003 \003(\t\022\030\n\020rew" +
      "rite_segments\030\004 \003(\t\032^\n\014OpCompaction\022\025\n\ri" +
      "nput_rowsets\030\001 \003(\r\0227\n\routput_rowset\030\002 \001(" +
      "\0132 .starrocks.lake.RowsetMetadataPB\032\251\001\n\016" +
      "OpSchemaChange\0221\n\007rowsets\030\001 \003(\0132 .starro" +
      "cks.lake.RowsetMetadataPB\022\026\n\016linked_segm" +
      "ent\030\002 \001(\010\022\025\n\ralter_version\030\003 \001(\003\0225\n\013delv" +
      "ec_meta\030\004 \001(\0132 .starrocks.lake.DelvecMet" +
      "adataPB\032V\n\017OpAlterMetadata\022C\n\025metadata_u" +
      "pdate_infos\030\001 \003(\0132$.starrocks.lake.Metad" +
      "ataUpdateInfoPB\032\275\002\n\rOpReplication\0221\n\010txn" +
      "_meta\030\001 \001(\0132\037.starrocks.ReplicationTxnMe" +
      "taPB\0223\n\top_writes\030\002 \003(\0132 .starrocks.lake" +
      ".TxnLogPB.OpWrite\022D\n\007delvecs\030\003 \003(\01323.sta" +
      "rrocks.lake.TxnLogPB.OpReplication.Delve" +
      "csEntry\0220\n\rsource_schema\030\004 \001(\0132\031.starroc" +
      "ks.TabletSchemaPB\032L\n\014DelvecsEntry\022\013\n\003key" +
      "\030\001 \001(\r\022+\n\005value\030\002 \001(\0132\034.starrocks.lake.D" +
      "elvecDataPB:\0028\001\"\026\n\024TabletMetadataLockPB*" +
      "4\n\025PersistentIndexTypePB\022\t\n\005LOCAL\020\000\022\020\n\014C" +
      "LOUD_NATIVE\020\001B\027\n\023io.datafibre.fibre.protoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.datafibre.fibre.proto.Types.getDescriptor(),
          io.datafibre.fibre.proto.TabletSchema.getDescriptor(),
          io.datafibre.fibre.proto.OlapFile.getDescriptor(),
        });
    internal_static_starrocks_lake_DelvecDataPB_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_starrocks_lake_DelvecDataPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_DelvecDataPB_descriptor,
        new java.lang.String[] { "Version", "Data", });
    internal_static_starrocks_lake_DelvecPagePB_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_starrocks_lake_DelvecPagePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_DelvecPagePB_descriptor,
        new java.lang.String[] { "Version", "Offset", "Size", });
    internal_static_starrocks_lake_DelvecCacheKeyPB_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_starrocks_lake_DelvecCacheKeyPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_DelvecCacheKeyPB_descriptor,
        new java.lang.String[] { "Id", "DelvecPage", });
    internal_static_starrocks_lake_FileMetaPB_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_starrocks_lake_FileMetaPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_FileMetaPB_descriptor,
        new java.lang.String[] { "Name", "Size", });
    internal_static_starrocks_lake_DelvecMetadataPB_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_starrocks_lake_DelvecMetadataPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_DelvecMetadataPB_descriptor,
        new java.lang.String[] { "VersionToFile", "Delvecs", });
    internal_static_starrocks_lake_DelvecMetadataPB_VersionToFileEntry_descriptor =
      internal_static_starrocks_lake_DelvecMetadataPB_descriptor.getNestedTypes().get(0);
    internal_static_starrocks_lake_DelvecMetadataPB_VersionToFileEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_DelvecMetadataPB_VersionToFileEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_starrocks_lake_DelvecMetadataPB_DelvecsEntry_descriptor =
      internal_static_starrocks_lake_DelvecMetadataPB_descriptor.getNestedTypes().get(1);
    internal_static_starrocks_lake_DelvecMetadataPB_DelvecsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_DelvecMetadataPB_DelvecsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_starrocks_lake_RowsetMetadataPB_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_starrocks_lake_RowsetMetadataPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_RowsetMetadataPB_descriptor,
        new java.lang.String[] { "Id", "Overlapped", "Segments", "NumRows", "DataSize", "DeletePredicate", "NumDels", "SegmentSize", "MaxCompactInputRowsetId", });
    internal_static_starrocks_lake_TabletMetadataPB_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_starrocks_lake_TabletMetadataPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TabletMetadataPB_descriptor,
        new java.lang.String[] { "Id", "Version", "Schema", "Rowsets", "NextRowsetId", "CumulativePoint", "DelvecMeta", "CompactionInputs", "PrevGarbageVersion", "OrphanFiles", "EnablePersistentIndex", "PersistentIndexType", "CommitTime", "SourceSchema", });
    internal_static_starrocks_lake_MetadataUpdateInfoPB_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_starrocks_lake_MetadataUpdateInfoPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_MetadataUpdateInfoPB_descriptor,
        new java.lang.String[] { "EnablePersistentIndex", });
    internal_static_starrocks_lake_TxnLogPB_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_starrocks_lake_TxnLogPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TxnLogPB_descriptor,
        new java.lang.String[] { "TabletId", "TxnId", "OpWrite", "OpCompaction", "OpSchemaChange", "OpAlterMetadata", "OpReplication", });
    internal_static_starrocks_lake_TxnLogPB_OpWrite_descriptor =
      internal_static_starrocks_lake_TxnLogPB_descriptor.getNestedTypes().get(0);
    internal_static_starrocks_lake_TxnLogPB_OpWrite_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TxnLogPB_OpWrite_descriptor,
        new java.lang.String[] { "Rowset", "TxnMeta", "Dels", "RewriteSegments", });
    internal_static_starrocks_lake_TxnLogPB_OpCompaction_descriptor =
      internal_static_starrocks_lake_TxnLogPB_descriptor.getNestedTypes().get(1);
    internal_static_starrocks_lake_TxnLogPB_OpCompaction_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TxnLogPB_OpCompaction_descriptor,
        new java.lang.String[] { "InputRowsets", "OutputRowset", });
    internal_static_starrocks_lake_TxnLogPB_OpSchemaChange_descriptor =
      internal_static_starrocks_lake_TxnLogPB_descriptor.getNestedTypes().get(2);
    internal_static_starrocks_lake_TxnLogPB_OpSchemaChange_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TxnLogPB_OpSchemaChange_descriptor,
        new java.lang.String[] { "Rowsets", "LinkedSegment", "AlterVersion", "DelvecMeta", });
    internal_static_starrocks_lake_TxnLogPB_OpAlterMetadata_descriptor =
      internal_static_starrocks_lake_TxnLogPB_descriptor.getNestedTypes().get(3);
    internal_static_starrocks_lake_TxnLogPB_OpAlterMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TxnLogPB_OpAlterMetadata_descriptor,
        new java.lang.String[] { "MetadataUpdateInfos", });
    internal_static_starrocks_lake_TxnLogPB_OpReplication_descriptor =
      internal_static_starrocks_lake_TxnLogPB_descriptor.getNestedTypes().get(4);
    internal_static_starrocks_lake_TxnLogPB_OpReplication_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TxnLogPB_OpReplication_descriptor,
        new java.lang.String[] { "TxnMeta", "OpWrites", "Delvecs", "SourceSchema", });
    internal_static_starrocks_lake_TxnLogPB_OpReplication_DelvecsEntry_descriptor =
      internal_static_starrocks_lake_TxnLogPB_OpReplication_descriptor.getNestedTypes().get(0);
    internal_static_starrocks_lake_TxnLogPB_OpReplication_DelvecsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TxnLogPB_OpReplication_DelvecsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_starrocks_lake_TabletMetadataLockPB_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_starrocks_lake_TabletMetadataLockPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_lake_TabletMetadataLockPB_descriptor,
        new java.lang.String[] { });
    io.datafibre.fibre.proto.Types.getDescriptor();
    io.datafibre.fibre.proto.TabletSchema.getDescriptor();
    io.datafibre.fibre.proto.OlapFile.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
