// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: status.proto

package io.datafibre.fibre.proto;

public final class Status {
  private Status() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_starrocks_StatusPB_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_starrocks_StatusPB_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014status.proto\022\tstarrocks\"3\n\010StatusPB\022\023\n" +
      "\013status_code\030\001 \002(\005\022\022\n\nerror_msgs\030\002 \003(\tB\027" +
      "\n\023io.datafibre.fibre.protoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_starrocks_StatusPB_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_starrocks_StatusPB_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_starrocks_StatusPB_descriptor,
        new java.lang.String[] { "StatusCode", "ErrorMsgs", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
