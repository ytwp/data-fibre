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

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.util.Util;
import io.datafibre.fibre.connector.CachingRemoteFileConf;
import io.datafibre.fibre.connector.CachingRemoteFileIO;
import io.datafibre.fibre.connector.HdfsEnvironment;
import io.datafibre.fibre.connector.MetastoreType;
import io.datafibre.fibre.connector.ReentrantExecutor;
import io.datafibre.fibre.connector.RemoteFileIO;
import io.datafibre.fibre.connector.hive.CachingHiveMetastore;
import io.datafibre.fibre.connector.hive.CachingHiveMetastoreConf;
import io.datafibre.fibre.connector.hive.HiveMetaClient;
import io.datafibre.fibre.connector.hive.HiveMetastore;
import io.datafibre.fibre.connector.hive.IHiveMetastore;
import io.datafibre.fibre.sql.analyzer.SemanticException;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static io.datafibre.fibre.connector.hive.HiveConnector.HIVE_METASTORE_TYPE;
import static io.datafibre.fibre.connector.hive.HiveConnector.HIVE_METASTORE_URIS;
import static io.datafibre.fibre.connector.hudi.HudiConnector.SUPPORTED_METASTORE_TYPE;

public class HudiConnectorInternalMgr {
    private final String catalogName;
    private final Map<String, String> properties;
    private final HdfsEnvironment hdfsEnvironment;
    private final boolean enableMetastoreCache;
    private CachingHiveMetastoreConf hmsConf;

    private final boolean enableRemoteFileCache;
    private CachingRemoteFileConf remoteFileConf;

    private ExecutorService refreshHiveMetastoreExecutor;
    private ExecutorService refreshRemoteFileExecutor;
    private ExecutorService pullRemoteFileExecutor;

    private final boolean isRecursive;
    private final int loadRemoteFileMetadataThreadNum;

    private final boolean enableBackgroundRefreshHudiMetadata;

    private final MetastoreType metastoreType;

    public HudiConnectorInternalMgr(String catalogName, Map<String, String> properties, HdfsEnvironment hdfsEnvironment) {
        this.catalogName = catalogName;
        this.properties = properties;
        this.hdfsEnvironment = hdfsEnvironment;
        this.enableMetastoreCache = Boolean.parseBoolean(properties.getOrDefault("enable_metastore_cache", "true"));
        this.hmsConf = new CachingHiveMetastoreConf(properties, "hudi");

        this.enableRemoteFileCache = Boolean.parseBoolean(properties.getOrDefault("enable_remote_file_cache", "true"));
        this.remoteFileConf = new CachingRemoteFileConf(properties);

        this.isRecursive = Boolean.parseBoolean(properties.getOrDefault("enable_recursive_listing", "true"));
        this.loadRemoteFileMetadataThreadNum = Integer.parseInt(properties.getOrDefault("remote_file_load_thread_num",
                String.valueOf(Config.remote_file_metadata_load_concurrency)));

        this.enableBackgroundRefreshHudiMetadata = Boolean.parseBoolean(properties.getOrDefault(
                "enable_background_refresh_connector_metadata", "true"));

        String hiveMetastoreType = properties.getOrDefault(HIVE_METASTORE_TYPE, "hive").toLowerCase();
        if (!SUPPORTED_METASTORE_TYPE.contains(hiveMetastoreType)) {
            throw new SemanticException("hive metastore type [%s] is not supported", hiveMetastoreType);
        }

        if (hiveMetastoreType.equals("hive")) {
            String hiveMetastoreUris = Preconditions.checkNotNull(properties.get(HIVE_METASTORE_URIS),
                    "%s must be set in properties when creating hive catalog", HIVE_METASTORE_URIS);
            Util.validateMetastoreUris(hiveMetastoreUris);
        }
        this.metastoreType = MetastoreType.get(hiveMetastoreType);
    }

    public void shutdown() {
        if (enableMetastoreCache && refreshHiveMetastoreExecutor != null) {
            refreshHiveMetastoreExecutor.shutdown();
        }
        if (enableRemoteFileCache && refreshRemoteFileExecutor != null) {
            refreshRemoteFileExecutor.shutdown();
        }
        if (pullRemoteFileExecutor != null) {
            pullRemoteFileExecutor.shutdown();
        }
    }

    public IHiveMetastore createHiveMetastore() {
        // TODO(stephen): Abstract the creator class to construct hive meta client
        HiveMetaClient metaClient = HiveMetaClient.createHiveMetaClient(hdfsEnvironment, properties);
        IHiveMetastore hiveMetastore = new HiveMetastore(metaClient, catalogName, metastoreType);
        IHiveMetastore baseHiveMetastore;
        if (!enableMetastoreCache) {
            baseHiveMetastore = hiveMetastore;
        } else {
            refreshHiveMetastoreExecutor = Executors.newCachedThreadPool(
                    new ThreadFactoryBuilder().setNameFormat("hive-metastore-refresh-%d").build());
            baseHiveMetastore = CachingHiveMetastore.createCatalogLevelInstance(
                    hiveMetastore,
                    new ReentrantExecutor(refreshHiveMetastoreExecutor, hmsConf.getCacheRefreshThreadMaxNum()),
                    hmsConf.getCacheTtlSec(),
                    hmsConf.getCacheRefreshIntervalSec(),
                    hmsConf.getCacheMaxNum(),
                    hmsConf.enableListNamesCache());
        }

        return baseHiveMetastore;
    }

    public RemoteFileIO createRemoteFileIO() {
        // TODO(stephen): Abstract the creator class to construct RemoteFiloIO
        RemoteFileIO remoteFileIO = new HudiRemoteFileIO(hdfsEnvironment.getConfiguration());

        RemoteFileIO baseRemoteFileIO;
        if (!enableRemoteFileCache) {
            baseRemoteFileIO = remoteFileIO;
        } else {
            refreshRemoteFileExecutor = Executors.newCachedThreadPool(
                    new ThreadFactoryBuilder().setNameFormat("hudi-remote-files-refresh-%d").build());
            baseRemoteFileIO = CachingRemoteFileIO.createCatalogLevelInstance(
                    remoteFileIO,
                    new ReentrantExecutor(refreshRemoteFileExecutor, remoteFileConf.getRefreshMaxThreadNum()),
                    remoteFileConf.getCacheTtlSec(),
                    remoteFileConf.getCacheRefreshIntervalSec(),
                    remoteFileConf.getCacheMaxSize());
        }

        return baseRemoteFileIO;
    }

    public ExecutorService getPullRemoteFileExecutor() {
        if (pullRemoteFileExecutor == null) {
            pullRemoteFileExecutor = Executors.newFixedThreadPool(loadRemoteFileMetadataThreadNum,
                    new ThreadFactoryBuilder().setNameFormat("pull-hudi-remote-files-%d").build());
        }

        return pullRemoteFileExecutor;
    }

    public boolean isSearchRecursive() {
        return isRecursive;
    }

    public CachingHiveMetastoreConf getHiveMetastoreConf() {
        return hmsConf;
    }

    public CachingRemoteFileConf getRemoteFileConf() {
        return remoteFileConf;
    }

    public boolean isEnableBackgroundRefreshHudiMetadata() {
        return enableBackgroundRefreshHudiMetadata;
    }

    public MetastoreType getMetastoreType() {
        return metastoreType;
    }
}
