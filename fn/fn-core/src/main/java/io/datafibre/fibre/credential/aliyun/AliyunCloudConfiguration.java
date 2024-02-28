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

package io.datafibre.fibre.credential.aliyun;

import com.google.common.base.Preconditions;
import com.staros.proto.FileStoreInfo;
import io.datafibre.fibre.credential.CloudConfiguration;
import io.datafibre.fibre.credential.CloudConfigurationConstants;
import io.datafibre.fibre.credential.CloudType;
import io.datafibre.fibre.thrift.TCloudConfiguration;
import io.datafibre.fibre.thrift.TCloudType;
import org.apache.hadoop.conf.Configuration;

import java.util.Map;

public class AliyunCloudConfiguration extends CloudConfiguration {

    private final AliyunCloudCredential aliyunCloudCredential;

    public AliyunCloudConfiguration(AliyunCloudCredential aliyunCloudCredential) {
        Preconditions.checkNotNull(aliyunCloudCredential);
        this.aliyunCloudCredential = aliyunCloudCredential;
    }

    public AliyunCloudCredential getAliyunCloudCredential() {
        return aliyunCloudCredential;
    }

    // reuse aws client logic of BE
    @Override
    public void toThrift(TCloudConfiguration tCloudConfiguration) {
        super.toThrift(tCloudConfiguration);
        tCloudConfiguration.setCloud_type(TCloudType.AWS);
        Map<String, String> properties = tCloudConfiguration.getCloud_properties_v2();
        properties.put(CloudConfigurationConstants.AWS_S3_ENABLE_SSL, String.valueOf(true));
        aliyunCloudCredential.toThrift(properties);
    }

    @Override
    public void applyToConfiguration(Configuration configuration) {
        super.applyToConfiguration(configuration);
        aliyunCloudCredential.applyToConfiguration(configuration);
    }

    @Override
    public CloudType getCloudType() {
        return CloudType.ALIYUN;
    }

    @Override
    public FileStoreInfo toFileStoreInfo() {
        return aliyunCloudCredential.toFileStoreInfo();
    }

    @Override
    public String toConfString() {
        return String.format("AliyunCloudConfiguration{%s, cred=%s}", getCommonFieldsString(),
                aliyunCloudCredential.toCredString());
    }
}
