// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doris_internal_service.proto

package io.datafibre.fibre.proto;

public final class DorisInternalService {
  private DorisInternalService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034doris_internal_service.proto\022\005doris\032\026i" +
      "nternal_service.proto2\277\027\n\017PBackendServic" +
      "e\022O\n\rtransmit_data\022\036.starrocks.PTransmit" +
      "DataParams\032\036.starrocks.PTransmitDataResu" +
      "lt\022]\n\022exec_plan_fragment\022#.starrocks.PEx" +
      "ecPlanFragmentRequest\032\".starrocks.PExecP" +
      "lanFragmentResult\022p\n\031exec_batch_plan_fra" +
      "gments\022).starrocks.PExecBatchPlanFragmen" +
      "tsRequest\032(.starrocks.PExecBatchPlanFrag" +
      "mentsResult\022c\n\024cancel_plan_fragment\022%.st" +
      "arrocks.PCancelPlanFragmentRequest\032$.sta" +
      "rrocks.PCancelPlanFragmentResult\022G\n\nfetc" +
      "h_data\022\034.starrocks.PFetchDataRequest\032\033.s" +
      "tarrocks.PFetchDataResult\022]\n\022tablet_writ" +
      "er_open\022#.starrocks.PTabletWriterOpenReq" +
      "uest\032\".starrocks.PTabletWriterOpenResult" +
      "\022j\n\027tablet_writer_add_batch\022\'.starrocks." +
      "PTabletWriterAddBatchRequest\032&.starrocks" +
      ".PTabletWriterAddBatchResult\022c\n\024tablet_w" +
      "riter_cancel\022%.starrocks.PTabletWriterCa" +
      "ncelRequest\032$.starrocks.PTabletWriterCan" +
      "celResult\022i\n\026trigger_profile_report\022\'.st" +
      "arrocks.PTriggerProfileReportRequest\032&.s" +
      "tarrocks.PTriggerProfileReportResult\022o\n\030" +
      "collect_query_statistics\022).starrocks.PCo" +
      "llectQueryStatisticsRequest\032(.starrocks." +
      "PCollectQueryStatisticsResult\022=\n\010get_inf" +
      "o\022\030.starrocks.PProxyRequest\032\027.starrocks." +
      "PProxyResult\022P\n\017get_pulsar_info\022\036.starro" +
      "cks.PPulsarProxyRequest\032\035.starrocks.PPul" +
      "sarProxyResult\022T\n\017get_file_schema\022 .star" +
      "rocks.PGetFileSchemaRequest\032\037.starrocks." +
      "PGetFileSchemaResult\022]\n\022exec_short_circu" +
      "it\022#.starrocks.PExecShortCircuitRequest\032" +
      "\".starrocks.PExecShortCircuitResult\022R\n\016t" +
      "ransmit_chunk\022\037.starrocks.PTransmitChunk" +
      "Params\032\037.starrocks.PTransmitChunkResult\022" +
      "S\n\027transmit_chunk_via_http\022\027.starrocks.P" +
      "HttpRequest\032\037.starrocks.PTransmitChunkRe" +
      "sult\022j\n\027tablet_writer_add_chunk\022\'.starro" +
      "cks.PTabletWriterAddChunkRequest\032&.starr" +
      "ocks.PTabletWriterAddBatchResult\022l\n\030tabl" +
      "et_writer_add_chunks\022(.starrocks.PTablet" +
      "WriterAddChunksRequest\032&.starrocks.PTabl" +
      "etWriterAddBatchResult\022p\n\031tablet_writer_" +
      "add_segment\022).starrocks.PTabletWriterAdd" +
      "SegmentRequest\032(.starrocks.PTabletWriter" +
      "AddSegmentResult\022k\n\027transmit_runtime_fil" +
      "ter\022\'.starrocks.PTransmitRuntimeFilterPa" +
      "rams\032\'.starrocks.PTransmitRuntimeFilterR" +
      "esult\022g\n\032submit_mv_maintenance_task\022$.st" +
      "arrocks.PMVMaintenanceTaskRequest\032#.star" +
      "rocks.PMVMaintenanceTaskResult\022c\n\030local_" +
      "tablet_reader_open\022#.starrocks.PTabletRe" +
      "aderOpenRequest\032\".starrocks.PTabletReade" +
      "rOpenResult\022f\n\031local_tablet_reader_close" +
      "\022$.starrocks.PTabletReaderCloseRequest\032#" +
      ".starrocks.PTabletReaderCloseResult\022p\n\035l" +
      "ocal_tablet_reader_multi_get\022\'.starrocks" +
      ".PTabletReaderMultiGetRequest\032&.starrock" +
      "s.PTabletReaderMultiGetResult\022p\n\035local_t" +
      "ablet_reader_scan_open\022\'.starrocks.PTabl" +
      "etReaderScanOpenRequest\032&.starrocks.PTab" +
      "letReaderScanOpenResult\022z\n!local_tablet_" +
      "reader_scan_get_next\022*.starrocks.PTablet" +
      "ReaderScanGetNextRequest\032).starrocks.PTa" +
      "bletReaderScanGetNextResult\022X\n\017execute_c" +
      "ommand\022\".starrocks.ExecuteCommandRequest" +
      "PB\032!.starrocks.ExecuteCommandResultPB\022o\n" +
      "\030update_fail_point_status\022(.starrocks.PU" +
      "pdateFailPointStatusRequest\032).starrocks." +
      "PUpdateFailPointStatusResponse\022V\n\017list_f" +
      "ail_point\022 .starrocks.PListFailPointRequ" +
      "est\032!.starrocks.PListFailPointResponse\022o" +
      "\n\030process_dictionary_cache\022).starrocks.P" +
      "ProcessDictionaryCacheRequest\032(.starrock" +
      "s.PProcessDictionaryCacheResultB\032\n\023com.s" +
      "tarrocks.protoP\001\200\001\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.datafibre.fibre.proto.InternalService.getDescriptor(),
        });
    io.datafibre.fibre.proto.InternalService.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}