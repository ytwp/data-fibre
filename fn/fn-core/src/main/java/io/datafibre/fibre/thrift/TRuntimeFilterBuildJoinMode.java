/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TRuntimeFilterBuildJoinMode implements org.apache.thrift.TEnum {
  NONE(0),
  BORADCAST(1),
  PARTITIONED(2),
  LOCAL_HASH_BUCKET(3),
  COLOCATE(4),
  SHUFFLE_HASH_BUCKET(5),
  REPLICATED(6);

  private final int value;

  private TRuntimeFilterBuildJoinMode(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static TRuntimeFilterBuildJoinMode findByValue(int value) { 
    switch (value) {
      case 0:
        return NONE;
      case 1:
        return BORADCAST;
      case 2:
        return PARTITIONED;
      case 3:
        return LOCAL_HASH_BUCKET;
      case 4:
        return COLOCATE;
      case 5:
        return SHUFFLE_HASH_BUCKET;
      case 6:
        return REPLICATED;
      default:
        return null;
    }
  }
}
