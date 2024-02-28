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

package io.datafibre.fibre.connector.hudi;

import com.google.common.collect.Lists;
import io.datafibre.fibre.connector.Connector;
import io.datafibre.fibre.connector.ConnectorContext;
import io.datafibre.fibre.connector.ConnectorMetadata;
import io.datafibre.fibre.connector.HdfsEnvironment;
import io.datafibre.fibre.connector.RemoteFileIO;
import io.datafibre.fibre.connector.hive.IHiveMetastore;
import io.datafibre.fibre.credential.CloudConfiguration;
import io.datafibre.fibre.credential.CloudConfigurationFactory;
import io.datafibre.fibre.server.GlobalStateMgr;

import java.util.List;
import java.util.Map;

public class HudiConnector implements Connector {
    public static final String HIVE_METASTORE_URIS = "hive.metastore.uris";
    public static final List<String> SUPPORTED_METASTORE_TYPE = Lists.newArrayList("hive", "glue", "dlf");
    private final String catalogName;
    private final HudiConnectorInternalMgr internalMgr;
    private final HudiMetadataFactory metadataFactory;

    public HudiConnector(ConnectorContext context) {
        Map<String, String> properties = context.getProperties();
        CloudConfiguration cloudConfiguration = CloudConfigurationFactory.buildCloudConfigurationForStorage(properties);
        HdfsEnvironment hdfsEnvironment = new HdfsEnvironment(cloudConfiguration);
        this.catalogName = context.getCatalogName();
        this.internalMgr = new HudiConnectorInternalMgr(catalogName, properties, hdfsEnvironment);
        this.metadataFactory = createMetadataFactory(hdfsEnvironment);
        onCreate();
    }

    @Override
    public ConnectorMetadata getMetadata() {
        return metadataFactory.create();
    }

    private HudiMetadataFactory createMetadataFactory(HdfsEnvironment hdfsEnvironment) {
        IHiveMetastore metastore = internalMgr.createHiveMetastore();
        RemoteFileIO remoteFileIO = internalMgr.createRemoteFileIO();
        return new HudiMetadataFactory(
                catalogName,
                metastore,
                remoteFileIO,
                internalMgr.getHiveMetastoreConf(),
                internalMgr.getRemoteFileConf(),
                internalMgr.getPullRemoteFileExecutor(),
                internalMgr.isSearchRecursive(),
                hdfsEnvironment,
                internalMgr.getMetastoreType()
        );
    }

    public void onCreate() {
    }

    @Override
    public void shutdown() {
        internalMgr.shutdown();
        GlobalStateMgr.getCurrentState().getConnectorTableMetadataProcessor().unRegisterCacheUpdateProcessor(catalogName);
    }
}