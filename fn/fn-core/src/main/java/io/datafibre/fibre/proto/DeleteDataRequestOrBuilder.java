// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package com.starrocks.proto;

public interface DeleteDataRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.lake.DeleteDataRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated int64 tablet_ids = 1;</code>
   * @return A list containing the tabletIds.
   */
  java.util.List<java.lang.Long> getTabletIdsList();
  /**
   * <code>repeated int64 tablet_ids = 1;</code>
   * @return The count of tabletIds.
   */
  int getTabletIdsCount();
  /**
   * <code>repeated int64 tablet_ids = 1;</code>
   * @param index The index of the element to return.
   * @return The tabletIds at the given index.
   */
  long getTabletIds(int index);

  /**
   * <code>optional int64 txn_id = 2;</code>
   * @return Whether the txnId field is set.
   */
  boolean hasTxnId();
  /**
   * <code>optional int64 txn_id = 2;</code>
   * @return The txnId.
   */
  long getTxnId();

  /**
   * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
   * @return Whether the deletePredicate field is set.
   */
  boolean hasDeletePredicate();
  /**
   * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
   * @return The deletePredicate.
   */
  com.starrocks.proto.DeletePredicatePB getDeletePredicate();
  /**
   * <code>optional .starrocks.DeletePredicatePB delete_predicate = 3;</code>
   */
  com.starrocks.proto.DeletePredicatePBOrBuilder getDeletePredicateOrBuilder();
}
