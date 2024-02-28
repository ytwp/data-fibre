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

import com.google.common.collect.ImmutableList;
import io.datafibre.fibre.credential.aliyun.AliyunCloudConfigurationProvider;
import io.datafibre.fibre.credential.aws.AWSCloudConfigurationProvider;
import io.datafibre.fibre.credential.aws.AWSCloudCredential;
import io.datafibre.fibre.credential.azure.AzureCloudConfigurationProvider;
import io.datafibre.fibre.credential.gcp.GCPCloudConfigurationProvoder;
import io.datafibre.fibre.credential.hdfs.HDFSCloudConfigurationProvider;
import io.datafibre.fibre.credential.hdfs.StrictHDFSCloudConfigurationProvider;
import io.datafibre.fibre.credential.tencent.TencentCloudConfigurationProvider;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.iceberg.aws.AwsClientProperties;
import org.apache.iceberg.aws.s3.S3FileIOProperties;

import java.util.HashMap;
import java.util.Map;

public class CloudConfigurationFactory {

    static ImmutableList<CloudConfigurationProvider> cloudConfigurationFactoryChain = ImmutableList.of(
            new AWSCloudConfigurationProvider(),
            new AzureCloudConfigurationProvider(),
            new GCPCloudConfigurationProvoder(),
            new AliyunCloudConfigurationProvider(),
            new TencentCloudConfigurationProvider(),
            new HDFSCloudConfigurationProvider(),
            (Map<String, String> properties) -> new CloudConfiguration());

    static ImmutableList<CloudConfigurationProvider> strictCloudConfigurationFactoryChain = ImmutableList.of(
            new AWSCloudConfigurationProvider(),
            new AzureCloudConfigurationProvider(),
            new GCPCloudConfigurationProvoder(),
            new AliyunCloudConfigurationProvider(),
            new TencentCloudConfigurationProvider(),
            new HDFSCloudConfigurationProvider(),
            new StrictHDFSCloudConfigurationProvider(),
            (Map<String, String> properties) -> new CloudConfiguration());

    public static CloudConfiguration buildCloudConfigurationForStorage(Map<String, String> properties) {
        return buildCloudConfigurationForStorage(properties, false);
    }

    public static CloudConfiguration buildCloudConfigurationForStorage(Map<String, String> properties, boolean strictMode) {
        ImmutableList<CloudConfigurationProvider> factories = cloudConfigurationFactoryChain;
        if (strictMode) {
            factories = strictCloudConfigurationFactoryChain;
        }
        for (CloudConfigurationProvider factory : factories) {
            CloudConfiguration cloudConfiguration = factory.build(properties);
            if (cloudConfiguration != null) {
                cloudConfiguration.loadCommonFields(properties);
                return cloudConfiguration;
            }
        }
        // Should never reach here.
        return null;
    }

    public static AWSCloudCredential buildGlueCloudCredential(HiveConf hiveConf) {
        for (CloudConfigurationProvider factory : cloudConfigurationFactoryChain) {
            if (factory instanceof AWSCloudConfigurationProvider) {
                AWSCloudConfigurationProvider provider = ((AWSCloudConfigurationProvider) factory);
                return provider.buildGlueCloudCredential(hiveConf);
            }
        }
        // Should never reach here.
        return null;
    }

    public static CloudConfiguration buildCloudConfigurationForTabular(Map<String, String> properties) {
        Map<String, String> copiedProperties = new HashMap<>();
        String sessionAk = properties.getOrDefault(S3FileIOProperties.ACCESS_KEY_ID, null);
        String sessionSk = properties.getOrDefault(S3FileIOProperties.SECRET_ACCESS_KEY, null);
        String sessionToken = properties.getOrDefault(S3FileIOProperties.SESSION_TOKEN, null);
        String region = properties.getOrDefault(AwsClientProperties.CLIENT_REGION, null);
        if (sessionAk != null && sessionSk != null && sessionToken != null && region != null) {
            copiedProperties.put(CloudConfigurationConstants.AWS_S3_ACCESS_KEY, sessionAk);
            copiedProperties.put(CloudConfigurationConstants.AWS_S3_SECRET_KEY, sessionSk);
            copiedProperties.put(CloudConfigurationConstants.AWS_S3_SESSION_TOKEN, sessionToken);
            copiedProperties.put(CloudConfigurationConstants.AWS_S3_REGION, region);
        }
        return buildCloudConfigurationForStorage(copiedProperties);
    }
}