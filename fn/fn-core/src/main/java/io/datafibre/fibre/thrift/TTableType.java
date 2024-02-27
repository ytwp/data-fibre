/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TTableType implements org.apache.thrift.TEnum {
  MYSQL_TABLE(0),
  OLAP_TABLE(1),
  SCHEMA_TABLE(2),
  KUDU_TABLE(3),
  BROKER_TABLE(4),
  ES_TABLE(5),
  HDFS_TABLE(6),
  ICEBERG_TABLE(7),
  HUDI_TABLE(8),
  JDBC_TABLE(9),
  PAIMON_TABLE(10),
  VIEW(20),
  MATERIALIZED_VIEW(21),
  FILE_TABLE(22),
  DELTALAKE_TABLE(23),
  TABLE_FUNCTION_TABLE(24),
  ODPS_TABLE(25);

  private final int value;

  private TTableType(int value) {
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
  public static TTableType findByValue(int value) { 
    switch (value) {
      case 0:
        return MYSQL_TABLE;
      case 1:
        return OLAP_TABLE;
      case 2:
        return SCHEMA_TABLE;
      case 3:
        return KUDU_TABLE;
      case 4:
        return BROKER_TABLE;
      case 5:
        return ES_TABLE;
      case 6:
        return HDFS_TABLE;
      case 7:
        return ICEBERG_TABLE;
      case 8:
        return HUDI_TABLE;
      case 9:
        return JDBC_TABLE;
      case 10:
        return PAIMON_TABLE;
      case 20:
        return VIEW;
      case 21:
        return MATERIALIZED_VIEW;
      case 22:
        return FILE_TABLE;
      case 23:
        return DELTALAKE_TABLE;
      case 24:
        return TABLE_FUNCTION_TABLE;
      case 25:
        return ODPS_TABLE;
      default:
        return null;
    }
  }
}
