/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TCloudType implements org.apache.thrift.TEnum {
  DEFAULT(0),
  AWS(1),
  AZURE(2),
  GCP(3),
  ALIYUN(4),
  HDFS(5);

  private final int value;

  private TCloudType(int value) {
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
  public static TCloudType findByValue(int value) { 
    switch (value) {
      case 0:
        return DEFAULT;
      case 1:
        return AWS;
      case 2:
        return AZURE;
      case 3:
        return GCP;
      case 4:
        return ALIYUN;
      case 5:
        return HDFS;
      default:
        return null;
    }
  }
}