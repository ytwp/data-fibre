// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package com.starrocks.proto;

public interface OrdinalIndexPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.OrdinalIndexPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * required: the root page can be data page if there is only one data page,
   * or the only index page if there is more than one data pages.
   * </pre>
   *
   * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
   * @return Whether the rootPage field is set.
   */
  boolean hasRootPage();
  /**
   * <pre>
   * required: the root page can be data page if there is only one data page,
   * or the only index page if there is more than one data pages.
   * </pre>
   *
   * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
   * @return The rootPage.
   */
  com.starrocks.proto.BTreeMetaPB getRootPage();
  /**
   * <pre>
   * required: the root page can be data page if there is only one data page,
   * or the only index page if there is more than one data pages.
   * </pre>
   *
   * <code>optional .starrocks.BTreeMetaPB root_page = 1;</code>
   */
  com.starrocks.proto.BTreeMetaPBOrBuilder getRootPageOrBuilder();
}
