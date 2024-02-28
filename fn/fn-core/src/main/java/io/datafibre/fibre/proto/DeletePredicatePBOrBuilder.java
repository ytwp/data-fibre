// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: types.proto

package io.datafibre.fibre.proto;

public interface DeletePredicatePBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.DeletePredicatePB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required int32 version = 1;</code>
   * @return Whether the version field is set.
   */
  boolean hasVersion();
  /**
   * <code>required int32 version = 1;</code>
   * @return The version.
   */
  int getVersion();

  /**
   * <code>repeated string sub_predicates = 2;</code>
   * @return A list containing the subPredicates.
   */
  java.util.List<java.lang.String>
      getSubPredicatesList();
  /**
   * <code>repeated string sub_predicates = 2;</code>
   * @return The count of subPredicates.
   */
  int getSubPredicatesCount();
  /**
   * <code>repeated string sub_predicates = 2;</code>
   * @param index The index of the element to return.
   * @return The subPredicates at the given index.
   */
  java.lang.String getSubPredicates(int index);
  /**
   * <code>repeated string sub_predicates = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the subPredicates at the given index.
   */
  com.google.protobuf.ByteString
      getSubPredicatesBytes(int index);

  /**
   * <code>repeated .starrocks.InPredicatePB in_predicates = 3;</code>
   */
  java.util.List<io.datafibre.fibre.proto.InPredicatePB>
      getInPredicatesList();
  /**
   * <code>repeated .starrocks.InPredicatePB in_predicates = 3;</code>
   */
  io.datafibre.fibre.proto.InPredicatePB getInPredicates(int index);
  /**
   * <code>repeated .starrocks.InPredicatePB in_predicates = 3;</code>
   */
  int getInPredicatesCount();
  /**
   * <code>repeated .starrocks.InPredicatePB in_predicates = 3;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.InPredicatePBOrBuilder>
      getInPredicatesOrBuilderList();
  /**
   * <code>repeated .starrocks.InPredicatePB in_predicates = 3;</code>
   */
  io.datafibre.fibre.proto.InPredicatePBOrBuilder getInPredicatesOrBuilder(
      int index);

  /**
   * <pre>
   * binary_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.BinaryPredicatePB binary_predicates = 4;</code>
   */
  java.util.List<io.datafibre.fibre.proto.BinaryPredicatePB>
      getBinaryPredicatesList();
  /**
   * <pre>
   * binary_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.BinaryPredicatePB binary_predicates = 4;</code>
   */
  io.datafibre.fibre.proto.BinaryPredicatePB getBinaryPredicates(int index);
  /**
   * <pre>
   * binary_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.BinaryPredicatePB binary_predicates = 4;</code>
   */
  int getBinaryPredicatesCount();
  /**
   * <pre>
   * binary_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.BinaryPredicatePB binary_predicates = 4;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.BinaryPredicatePBOrBuilder>
      getBinaryPredicatesOrBuilderList();
  /**
   * <pre>
   * binary_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.BinaryPredicatePB binary_predicates = 4;</code>
   */
  io.datafibre.fibre.proto.BinaryPredicatePBOrBuilder getBinaryPredicatesOrBuilder(
      int index);

  /**
   * <pre>
   * is_null_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.IsNullPredicatePB is_null_predicates = 5;</code>
   */
  java.util.List<io.datafibre.fibre.proto.IsNullPredicatePB>
      getIsNullPredicatesList();
  /**
   * <pre>
   * is_null_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.IsNullPredicatePB is_null_predicates = 5;</code>
   */
  io.datafibre.fibre.proto.IsNullPredicatePB getIsNullPredicates(int index);
  /**
   * <pre>
   * is_null_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.IsNullPredicatePB is_null_predicates = 5;</code>
   */
  int getIsNullPredicatesCount();
  /**
   * <pre>
   * is_null_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.IsNullPredicatePB is_null_predicates = 5;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.IsNullPredicatePBOrBuilder>
      getIsNullPredicatesOrBuilderList();
  /**
   * <pre>
   * is_null_predicates only set and used by a lake table now.
   * </pre>
   *
   * <code>repeated .starrocks.IsNullPredicatePB is_null_predicates = 5;</code>
   */
  io.datafibre.fibre.proto.IsNullPredicatePBOrBuilder getIsNullPredicatesOrBuilder(
      int index);
}
