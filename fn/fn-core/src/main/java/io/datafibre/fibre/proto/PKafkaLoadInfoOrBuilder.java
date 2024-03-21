// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PKafkaLoadInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PKafkaLoadInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required string brokers = 1;</code>
   * @return Whether the brokers field is set.
   */
  boolean hasBrokers();
  /**
   * <code>required string brokers = 1;</code>
   * @return The brokers.
   */
  java.lang.String getBrokers();
  /**
   * <code>required string brokers = 1;</code>
   * @return The bytes for brokers.
   */
  com.google.protobuf.ByteString
      getBrokersBytes();

  /**
   * <code>required string topic = 2;</code>
   * @return Whether the topic field is set.
   */
  boolean hasTopic();
  /**
   * <code>required string topic = 2;</code>
   * @return The topic.
   */
  java.lang.String getTopic();
  /**
   * <code>required string topic = 2;</code>
   * @return The bytes for topic.
   */
  com.google.protobuf.ByteString
      getTopicBytes();

  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  java.util.List<io.datafibre.fibre.proto.PStringPair>
      getPropertiesList();
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  io.datafibre.fibre.proto.PStringPair getProperties(int index);
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  int getPropertiesCount();
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.PStringPairOrBuilder>
      getPropertiesOrBuilderList();
  /**
   * <code>repeated .starrocks.PStringPair properties = 3;</code>
   */
  io.datafibre.fibre.proto.PStringPairOrBuilder getPropertiesOrBuilder(
      int index);
}