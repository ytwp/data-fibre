/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
public class DescriptorsConstants {

  public static final java.util.Map<java.lang.String,THdfsCompression> COMPRESSION_MAP = new java.util.HashMap<java.lang.String,THdfsCompression>();
  static {
    COMPRESSION_MAP.put("", io.datafibre.fibre.thrift.THdfsCompression.NONE);
    COMPRESSION_MAP.put("bzip2", io.datafibre.fibre.thrift.THdfsCompression.BZIP2);
    COMPRESSION_MAP.put("deflate", io.datafibre.fibre.thrift.THdfsCompression.DEFAULT);
    COMPRESSION_MAP.put("gzip", io.datafibre.fibre.thrift.THdfsCompression.GZIP);
    COMPRESSION_MAP.put("none", io.datafibre.fibre.thrift.THdfsCompression.NONE);
    COMPRESSION_MAP.put("snappy", io.datafibre.fibre.thrift.THdfsCompression.SNAPPY);
  }

}