// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: types.proto

package com.starrocks.proto;

public final class Types {
  private Types() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PScalarType_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PScalarType_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PStructField_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PStructField_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PTypeNode_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PTypeNode_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PTypeDesc_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PTypeDesc_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_PUniqueId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_PUniqueId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_ReplicationTxnMetaPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_ReplicationTxnMetaPB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_TxnFinishStatePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_TxnFinishStatePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_DeletePredicatePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_DeletePredicatePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_InPredicatePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_InPredicatePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_BinaryPredicatePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_BinaryPredicatePB_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_IsNullPredicatePB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_IsNullPredicatePB_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013types.proto\022\tstarrocks\"J\n\013PScalarType\022" +
      "\014\n\004type\030\001 \002(\005\022\013\n\003len\030\002 \001(\005\022\021\n\tprecision\030" +
      "\003 \001(\005\022\r\n\005scale\030\004 \001(\005\"-\n\014PStructField\022\014\n\004" +
      "name\030\001 \002(\t\022\017\n\007comment\030\002 \001(\t\"v\n\tPTypeNode" +
      "\022\014\n\004type\030\001 \002(\005\022+\n\013scalar_type\030\002 \001(\0132\026.st" +
      "arrocks.PScalarType\022.\n\rstruct_fields\030\003 \003" +
      "(\0132\027.starrocks.PStructField\"0\n\tPTypeDesc" +
      "\022#\n\005types\030\001 \003(\0132\024.starrocks.PTypeNode\"#\n" +
      "\tPUniqueId\022\n\n\002hi\030\001 \002(\003\022\n\n\002lo\030\002 \002(\003\"\216\002\n\024R" +
      "eplicationTxnMetaPB\022\016\n\006txn_id\030\001 \001(\003\0223\n\tt" +
      "xn_state\030\002 \001(\0162 .starrocks.ReplicationTx" +
      "nStatePB\022\021\n\ttablet_id\030\003 \001(\003\022\027\n\017visible_v" +
      "ersion\030\004 \001(\003\022\030\n\020src_backend_host\030\005 \001(\t\022\030" +
      "\n\020src_backend_port\030\006 \001(\005\022\031\n\021src_snapshot" +
      "_path\030\007 \001(\t\022\030\n\020snapshot_version\030\010 \001(\003\022\034\n" +
      "\024incremental_snapshot\030\t \001(\010\"S\n\020TxnFinish" +
      "StatePB\022\027\n\017normal_replicas\030\001 \003(\003\022&\n\036abno" +
      "rmal_replicas_with_version\030\002 \003(\003\"\340\001\n\021Del" +
      "etePredicatePB\022\017\n\007version\030\001 \002(\005\022\026\n\016sub_p" +
      "redicates\030\002 \003(\t\022/\n\rin_predicates\030\003 \003(\0132\030" +
      ".starrocks.InPredicatePB\0227\n\021binary_predi" +
      "cates\030\004 \003(\0132\034.starrocks.BinaryPredicateP" +
      "B\0228\n\022is_null_predicates\030\005 \003(\0132\034.starrock" +
      "s.IsNullPredicatePB\"G\n\rInPredicatePB\022\023\n\013" +
      "column_name\030\001 \001(\t\022\021\n\tis_not_in\030\002 \001(\010\022\016\n\006" +
      "values\030\003 \003(\t\"C\n\021BinaryPredicatePB\022\023\n\013col" +
      "umn_name\030\001 \001(\t\022\n\n\002op\030\002 \001(\t\022\r\n\005value\030\003 \001(" +
      "\t\"=\n\021IsNullPredicatePB\022\023\n\013column_name\030\001 " +
      "\001(\t\022\023\n\013is_not_null\030\002 \001(\010*\330\001\n\021Compression" +
      "TypePB\022\027\n\023UNKNOWN_COMPRESSION\020\000\022\027\n\023DEFAU" +
      "LT_COMPRESSION\020\001\022\022\n\016NO_COMPRESSION\020\002\022\n\n\006" +
      "SNAPPY\020\003\022\007\n\003LZ4\020\004\022\r\n\tLZ4_FRAME\020\005\022\010\n\004ZLIB" +
      "\020\006\022\010\n\004ZSTD\020\007\022\010\n\004GZIP\020\010\022\013\n\007DEFLATE\020\t\022\t\n\005B" +
      "ZIP2\020\n\022\007\n\003LZO\020\013\022\n\n\006BROTLI\020\014\022\016\n\nLZ4_HADOO" +
      "P\020\r*3\n\021WriteQuorumTypePB\022\007\n\003ONE\020\000\022\014\n\010MAJ" +
      "ORITY\020\001\022\007\n\003ALL\020\002*0\n\tTxnTypePB\022\016\n\nTXN_NOR" +
      "MAL\020\000\022\023\n\017TXN_REPLICATION\020\001*d\n\025Replicatio" +
      "nTxnStatePB\022\020\n\014TXN_PREPARED\020\000\022\022\n\016TXN_SNA" +
      "PSHOTED\020\001\022\022\n\016TXN_REPLICATED\020\002\022\021\n\rTXN_PUB" +
      "LISHED\020\003B\027\n\023com.starrocks.protoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_starrocks_PScalarType_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_starrocks_PScalarType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PScalarType_descriptor,
        new java.lang.String[] { "Type", "Len", "Precision", "Scale", });
    internal_static_starrocks_PStructField_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_starrocks_PStructField_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PStructField_descriptor,
        new java.lang.String[] { "Name", "Comment", });
    internal_static_starrocks_PTypeNode_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_starrocks_PTypeNode_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PTypeNode_descriptor,
        new java.lang.String[] { "Type", "ScalarType", "StructFields", });
    internal_static_starrocks_PTypeDesc_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_starrocks_PTypeDesc_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PTypeDesc_descriptor,
        new java.lang.String[] { "Types", });
    internal_static_starrocks_PUniqueId_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_starrocks_PUniqueId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_PUniqueId_descriptor,
        new java.lang.String[] { "Hi", "Lo", });
    internal_static_starrocks_ReplicationTxnMetaPB_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_starrocks_ReplicationTxnMetaPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_ReplicationTxnMetaPB_descriptor,
        new java.lang.String[] { "TxnId", "TxnState", "TabletId", "VisibleVersion", "SrcBackendHost", "SrcBackendPort", "SrcSnapshotPath", "SnapshotVersion", "IncrementalSnapshot", });
    internal_static_starrocks_TxnFinishStatePB_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_starrocks_TxnFinishStatePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_TxnFinishStatePB_descriptor,
        new java.lang.String[] { "NormalReplicas", "AbnormalReplicasWithVersion", });
    internal_static_starrocks_DeletePredicatePB_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_starrocks_DeletePredicatePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_DeletePredicatePB_descriptor,
        new java.lang.String[] { "Version", "SubPredicates", "InPredicates", "BinaryPredicates", "IsNullPredicates", });
    internal_static_starrocks_InPredicatePB_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_starrocks_InPredicatePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_InPredicatePB_descriptor,
        new java.lang.String[] { "ColumnName", "IsNotIn", "Values", });
    internal_static_starrocks_BinaryPredicatePB_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_starrocks_BinaryPredicatePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_BinaryPredicatePB_descriptor,
        new java.lang.String[] { "ColumnName", "Op", "Value", });
    internal_static_starrocks_IsNullPredicatePB_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_starrocks_IsNullPredicatePB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_IsNullPredicatePB_descriptor,
        new java.lang.String[] { "ColumnName", "IsNotNull", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
