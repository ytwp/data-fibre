// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.datafibre.fibre.credential;

import com.staros.proto.FileStoreInfo;
import io.datafibre.fibre.connector.hadoop.HadoopExt;
import io.datafibre.fibre.thrift.TCloudConfiguration;
import io.datafibre.fibre.thrift.TCloudType;
import org.apache.hadoop.conf.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CloudConfiguration {
    private static final Logger LOG = LogManager.getLogger(CloudConfiguration.class);

    private String configResources;
    private String runtimeJars;
    private String hadoopUsername;

    public void toThrift(TCloudConfiguration tCloudConfiguration) {
        tCloudConfiguration.cloud_type = TCloudType.DEFAULT;
        Map<String, String> properties = new HashMap<>();
        properties.put(HadoopExt.HADOOP_CONFIG_RESOURCES, configResources);
        properties.put(HadoopExt.HADOOP_RUNTIME_JARS, runtimeJars);
        properties.put(HadoopExt.HADOOP_CLOUD_CONFIGURATION_STRING, toConfString());
        properties.put(HadoopExt.HADOOP_USERNAME, hadoopUsername);
        tCloudConfiguration.setCloud_properties_v2(properties);
    }

    public void applyToConfiguration(Configuration configuration) {
        if (configResources != null) {
            configuration.set(HadoopExt.HADOOP_CONFIG_RESOURCES, configResources);
        }
        if (runtimeJars != null) {
            configuration.set(HadoopExt.HADOOP_RUNTIME_JARS, runtimeJars);
        }
        if (hadoopUsername != null) {
            configuration.set(HadoopExt.HADOOP_USERNAME, hadoopUsername);
        }
        configuration.set(HadoopExt.HADOOP_CLOUD_CONFIGURATION_STRING, toConfString());
        HadoopExt.getInstance().rewriteConfiguration(configuration);
    }

    // Hadoop FileSystem has a cache itself, it used request uri as a cache key by default,
    // so it cannot sense the CloudCredential changed.
    // So we need to generate an identifier for different CloudCredential, and used it as cache key.
    // toConfString() Method just like toString()
    public String toConfString() {
        return "CloudConfiguration{" + getCommonFieldsString() + "}";
    }

    public CloudType getCloudType() {
        return CloudType.DEFAULT;
    }

    // Convert to the protobuf used by staros.
    public FileStoreInfo toFileStoreInfo() {
        return null;
    }

    public void loadCommonFields(Map<String, String> properties) {
        configResources = properties.getOrDefault(HadoopExt.HADOOP_CONFIG_RESOURCES, "");
        runtimeJars = properties.getOrDefault(HadoopExt.HADOOP_RUNTIME_JARS, "");
        hadoopUsername = properties.getOrDefault(HadoopExt.HADOOP_USERNAME, "");
    }

    public String getCommonFieldsString() {
        return String.format("resources='%s', jars='%s', hdpuser='%s'", configResources, runtimeJars, hadoopUsername);
    }
}
