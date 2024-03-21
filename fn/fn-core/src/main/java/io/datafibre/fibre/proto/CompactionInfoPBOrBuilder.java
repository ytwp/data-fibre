// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package io.datafibre.fibre.proto;

public interface CompactionInfoPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.CompactionInfoPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.EditVersionPB start_version = 1;</code>
   * @return Whether the startVersion field is set.
   */
  boolean hasStartVersion();
  /**
   * <code>optional .starrocks.EditVersionPB start_version = 1;</code>
   * @return The startVersion.
   */
  io.datafibre.fibre.proto.EditVersionPB getStartVersion();
  /**
   * <code>optional .starrocks.EditVersionPB start_version = 1;</code>
   */
  io.datafibre.fibre.proto.EditVersionPBOrBuilder getStartVersionOrBuilder();

  /**
   * <code>repeated uint32 inputs = 2;</code>
   * @return A list containing the inputs.
   */
  java.util.List<java.lang.Integer> getInputsList();
  /**
   * <code>repeated uint32 inputs = 2;</code>
   * @return The count of inputs.
   */
  int getInputsCount();
  /**
   * <code>repeated uint32 inputs = 2;</code>
   * @param index The index of the element to return.
   * @return The inputs at the given index.
   */
  int getInputs(int index);

  /**
   * <pre>
   * may support multiple output rowsets in future
   * </pre>
   *
   * <code>repeated uint32 outputs = 3;</code>
   * @return A list containing the outputs.
   */
  java.util.List<java.lang.Integer> getOutputsList();
  /**
   * <pre>
   * may support multiple output rowsets in future
   * </pre>
   *
   * <code>repeated uint32 outputs = 3;</code>
   * @return The count of outputs.
   */
  int getOutputsCount();
  /**
   * <pre>
   * may support multiple output rowsets in future
   * </pre>
   *
   * <code>repeated uint32 outputs = 3;</code>
   * @param index The index of the element to return.
   * @return The outputs at the given index.
   */
  int getOutputs(int index);
}