/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TObjectStoreType implements org.apache.thrift.TEnum {
  HDFS(0),
  S3(1),
  KS3(2),
  OSS(3),
  COS(4),
  OBS(5),
  TOS(6),
  UNIVERSAL_FS(7);

  private final int value;

  private TObjectStoreType(int value) {
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
  public static TObjectStoreType findByValue(int value) { 
    switch (value) {
      case 0:
        return HDFS;
      case 1:
        return S3;
      case 2:
        return KS3;
      case 3:
        return OSS;
      case 4:
        return COS;
      case 5:
        return OBS;
      case 6:
        return TOS;
      case 7:
        return UNIVERSAL_FS;
      default:
        return null;
    }
  }
}
