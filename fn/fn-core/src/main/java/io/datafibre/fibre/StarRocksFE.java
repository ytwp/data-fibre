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

// This file is based on code available under the Apache license here:
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/StarRocksFE.java

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package io.datafibre.fibre;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import io.datafibre.fibre.common.*;
import io.datafibre.fibre.ha.StateChangeExecutor;
import io.datafibre.fibre.http.HttpServer;
import io.datafibre.fibre.journal.Journal;
import io.datafibre.fibre.journal.bdbje.BDBEnvironment;
import io.datafibre.fibre.journal.bdbje.BDBJEJournal;
import io.datafibre.fibre.journal.bdbje.BDBTool;
import io.datafibre.fibre.journal.bdbje.BDBToolOptions;
import io.datafibre.fibre.leader.MetaHelper;
import io.datafibre.fibre.qe.CoordinatorMonitor;
import io.datafibre.fibre.qe.QeService;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.server.RunMode;
import io.datafibre.fibre.service.ExecuteEnv;
import io.datafibre.fibre.service.FeServer;
import io.datafibre.fibre.service.FrontendOptions;
import io.datafibre.fibre.staros.StarMgrServer;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.management.ManagementFactory;
import java.nio.channels.FileLock;

public class StarRocksFE {
    private static final Logger LOG = LogManager.getLogger(StarRocksFE.class);

    public static final String STARROCKS_HOME_DIR = System.getenv("STARROCKS_HOME");
    public static final String PID_DIR = System.getenv("PID_DIR");

    public static volatile boolean stopped = false;

    public static void main(String[] args) {
        start(STARROCKS_HOME_DIR, PID_DIR, args);
    }


    // entrance for starrocks frontend
    public static void start(String starRocksDir, String pidDir, String[] args) {
        // 检验
        if (Strings.isNullOrEmpty(starRocksDir)) {
            System.err.println("env STARROCKS_HOME is not set.");
            return;
        }
        if (Strings.isNullOrEmpty(pidDir)) {
            System.err.println("env PID_DIR is not set.");
            return;
        }

        // 解析参数
        CommandLineOptions cmdLineOpts = parseArgs(args);

        try {
            // pid file
            if (!createAndLockPidFile(pidDir + "/fe.pid")) {
                throw new IOException("pid file is already locked.");
            }

            // init config
            new Config().init(starRocksDir + "/conf/fe.conf");

            // 初始化log配置和启动
            Log4jConfig.initLogging();

            // set dns cache ttl
            // 这行代码设置了Java安全性属性，将网络地址缓存的生存时间（TTL）设置为60秒。
            // 这可以影响Java应用程序中对网络地址的缓存时间，使其在60秒后过期并重新获取最新的网络地址信息。
            // 网络地址缓存的默认生存时间（TTL）是-1，表示缓存永不过期。
            java.security.Security.setProperty("networkaddress.cache.ttl", "60");

            // Need to put if before `GlobalStateMgr.getCurrentState().waitForReady()`, because it may access aws service
            // 将AWS HTTP客户端设置（默认）为UrlConnectionHttpClient
            setAWSHttpClient();

            // check command line options
            // 运行 Berkeley DB debug模式 or 打印版本号
            checkCommandLineOptions(cmdLineOpts);

            // check meta dir
            // 检查新旧元数据目录或用户设置元数据目录
            // 同时，还会检查数据目录磁盘空间是否足够
            // 检测目前是否有元数据，已经是否需要从备份恢复元数据
            MetaHelper.checkMetaDir();

            LOG.info("StarRocks FE starting, version: {}-{}", Version.STARROCKS_VERSION, Version.STARROCKS_COMMIT_HASH);
            // 主要初始化IP
            FrontendOptions.init(args);
            // 初始化 连接数配置 和 检查连接是否超时的线程池
            ExecuteEnv.setup();

            // init globalStateMgr
            // 创建 全局状态 和 创建 节点管理器
            // 然后初始化
            GlobalStateMgr.getCurrentState().initialize(args);

            StateChangeExecutor.getInstance().setMetaContext(
                    GlobalStateMgr.getCurrentState().getMetaContext());

            if (RunMode.isSharedDataMode()) {
                Journal journal = GlobalStateMgr.getCurrentState().getJournal();
                if (journal instanceof BDBJEJournal) {
                    BDBEnvironment bdbEnvironment = ((BDBJEJournal) journal).getBdbEnvironment();
                    StarMgrServer.getCurrentState().initialize(bdbEnvironment,
                            GlobalStateMgr.getCurrentState().getImageDir());
                } else {
                    LOG.error("journal type should be BDBJE for star mgr!");
                    System.exit(-1);
                }

                StateChangeExecutor.getInstance().registerStateChangeExecution(
                        StarMgrServer.getCurrentState().getStateChangeExecution());
            }

            StateChangeExecutor.getInstance().registerStateChangeExecution(
                    GlobalStateMgr.getCurrentState().getStateChangeExecution());
            // start state change executor
            StateChangeExecutor.getInstance().start();

            // wait globalStateMgr to be ready
            GlobalStateMgr.getCurrentState().waitForReady();

            FrontendOptions.saveStartType();

            CoordinatorMonitor.getInstance().start();

            // init and start:
            // 1. QeService for MySQL Server
            // 2. FeServer for Thrift Server
            // 3. HttpServer for HTTP Server
            QeService qeService = new QeService(Config.query_port, Config.mysql_service_nio_enabled,
                    ExecuteEnv.getInstance().getScheduler());
            FeServer feServer = new FeServer(Config.rpc_port);
            HttpServer httpServer = new HttpServer(Config.http_port);
            httpServer.setup();

            feServer.start();
            httpServer.start();
            qeService.start();

            ThreadPoolManager.registerAllThreadPoolMetric();

            addShutdownHook();

            LOG.info("FE started successfully");

            while (!stopped) {
                Thread.sleep(2000);
            }

        } catch (Throwable e) {
            LOG.error("StarRocksFE start failed", e);
            System.exit(-1);
        }

        System.exit(0);
    }

    /*
     * -v --version
     *      Print the version of StarRocks Frontend
     * -h --helper
     *      Specify the helper node when joining a bdb je replication group
     * -b --bdb
     *      Run bdbje debug tools
     *
     *      -l --listdb
     *          List all database names in bdbje
     *      -d --db
     *          Specify a database in bdbje
     *
     *          -s --stat
     *              Print statistic of a database, including count, first key, last key
     *          -f --from
     *              Specify the start scan key
     *          -t --to
     *              Specify the end scan key
     *          -m --metaversion
     *              Specify the meta version to decode log value, separated by ',', first
     *              is community meta version, second is StarRocks meta version
     *
     */

    /**
     * 解析参数
     */
    private static CommandLineOptions parseArgs(String[] args) {
        CommandLineParser commandLineParser = new BasicParser();
        Options options = new Options();
        options.addOption("ht", "host_type", false, "Specify fe start use ip or fqdn");
        options.addOption("v", "version", false, "Print the version of StarRocks Frontend");
        options.addOption("h", "helper", true, "Specify the helper node when joining a bdb je replication group");
        options.addOption("b", "bdb", false, "Run bdbje debug tools");
        options.addOption("l", "listdb", false, "Print the list of databases in bdbje");
        options.addOption("d", "db", true, "Specify a database in bdbje");
        options.addOption("s", "stat", false, "Print statistic of a database, including count, first key, last key");
        options.addOption("f", "from", true, "Specify the start scan key");
        options.addOption("t", "to", true, "Specify the end scan key");
        options.addOption("m", "metaversion", true,
                "Specify the meta version to decode log value, separated by ',', first is community meta" +
                " version, second is StarRocks meta version");

        CommandLine cmd = null;
        try {
            cmd = commandLineParser.parse(options, args);
        } catch (final ParseException e) {
            LOG.error(e);
            System.err.println("Failed to parse command line. exit now");
            System.exit(-1);
        }

        // version
        if (cmd.hasOption('v') || cmd.hasOption("version")) {
            return new CommandLineOptions(true, null);
        } else if (cmd.hasOption('b') || cmd.hasOption("bdb")) {
            // 运行 Berkeley DB debug
            // Berkeley DB = bdb
            if (cmd.hasOption('l') || cmd.hasOption("listdb")) {
                // list bdb je databases
                // 打印bdb je中的数据库列表
                BDBToolOptions bdbOpts = new BDBToolOptions(true, "", false, "", "", 0, 0);
                return new CommandLineOptions(false, bdbOpts);
            } else if (cmd.hasOption('d') || cmd.hasOption("db")) {
                // specify a database
                // 打印bdb je中的指定数据库
                String dbName = cmd.getOptionValue("db");
                if (Strings.isNullOrEmpty(dbName)) {
                    System.err.println("BDBJE database name is missing");
                    System.exit(-1);
                }

                if (cmd.hasOption('s') || cmd.hasOption("stat")) {
                    BDBToolOptions bdbOpts = new BDBToolOptions(false, dbName, true, "", "", 0, 0);
                    return new CommandLineOptions(false, bdbOpts);
                } else {
                    String fromKey = "";
                    String endKey = "";
                    int metaVersion = 0;
                    int starrocksMetaVersion = 0;
                    if (cmd.hasOption('f') || cmd.hasOption("from")) {
                        fromKey = cmd.getOptionValue("from");
                        if (Strings.isNullOrEmpty(fromKey)) {
                            System.err.println("from key is missing");
                            System.exit(-1);
                        }
                    }
                    if (cmd.hasOption('t') || cmd.hasOption("to")) {
                        endKey = cmd.getOptionValue("to");
                        if (Strings.isNullOrEmpty(endKey)) {
                            System.err.println("end key is missing");
                            System.exit(-1);
                        }
                    }
                    if (cmd.hasOption('m') || cmd.hasOption("metaversion")) {
                        try {
                            String version = cmd.getOptionValue("metaversion");
                            String[] vs = version.split(",");
                            if (vs.length != 2) {
                                System.err.println("invalid meta version format");
                                System.exit(-1);
                            }
                            metaVersion = Integer.parseInt(vs[0]);
                            starrocksMetaVersion = Integer.parseInt(vs[1]);
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid meta version format");
                            System.exit(-1);
                        }
                    }

                    BDBToolOptions bdbOpts =
                            new BDBToolOptions(false, dbName, false, fromKey, endKey, metaVersion,
                                    starrocksMetaVersion);
                    return new CommandLineOptions(false, bdbOpts);
                }
            } else {
                System.err.println("Invalid options when running bdb je tools");
                System.exit(-1);
            }
        } else if (cmd.hasOption('h') || cmd.hasOption("helper")) {
            String helperNode = cmd.getOptionValue("helper");
            if (Strings.isNullOrEmpty(helperNode)) {
                System.err.println("Missing helper node");
                System.exit(-1);
            }
        }

        // helper node is null, means no helper node is specified
        return new CommandLineOptions(false, null);
    }

    // To resolve: "Multiple HTTP implementations were found on the classpath. To avoid non-deterministic
    // loading implementations, please explicitly provide an HTTP client via the client builders, set
    // the software.amazon.awssdk.http.service.impl system property with the FQCN of the HTTP service to
    // use as the default, or remove all but one HTTP implementation from the classpath"
    // Currently, there are 2 implements of HTTP client: ApacheHttpClient and UrlConnectionHttpClient
    // The UrlConnectionHttpClient is introduced by #16602, and it causes the exception.
    // So we set the default HTTP client to UrlConnectionHttpClient.
    // TODO: remove this after we remove ApacheHttpClient
    // 代码的作用是解决在类路径上发现多个HTTP实现时可能导致的问题。
    // 为了避免加载不确定的HTTP实现，需要明确指定要使用的AWS HTTP客户端。
    // 在这里，通过设置系统属性，将默认的AWS HTTP客户端设置为UrlConnectionHttpClient，以解决冲突并确保使用指定的HTTP客户端实现。
    private static void setAWSHttpClient() {
        System.setProperty("software.amazon.awssdk.http.service.impl",
                "software.amazon.awssdk.http.urlconnection.UrlConnectionSdkHttpService");
    }

    private static void checkCommandLineOptions(CommandLineOptions cmdLineOpts) {
        if (cmdLineOpts.isVersion()) {
            //指定了 -v 就是打印版本号退出
            System.out.println("Build version: " + Version.STARROCKS_VERSION);
            System.out.println("Commit hash: " + Version.STARROCKS_COMMIT_HASH);
            System.out.println("Build type: " + Version.STARROCKS_BUILD_TYPE);
            System.out.println("Build time: " + Version.STARROCKS_BUILD_TIME);
            System.out.println("Build user: " + Version.STARROCKS_BUILD_USER + "@" + Version.STARROCKS_BUILD_HOST);
            System.out.println("Java compile version: " + Version.STARROCKS_JAVA_COMPILE_VERSION);
            System.exit(0);
        } else if (cmdLineOpts.runBdbTools()) {
            // 运行 Berkeley DB debug模式
            BDBTool bdbTool = new BDBTool(BDBEnvironment.getBdbDir(), cmdLineOpts.getBdbToolOpts());
            if (bdbTool.run()) {
                System.exit(0);
            } else {
                System.exit(-1);
            }
        }

        // go on
    }

    private static boolean createAndLockPidFile(String pidFilePath) {
        File pid = new File(pidFilePath);
        for (int i = 0; i < 3; i++) {
            try (RandomAccessFile file = new RandomAccessFile(pid, "rws")) {
                if (i > 0) {
                    Thread.sleep(10000);
                }
                FileLock lock = file.getChannel().tryLock();
                if (lock == null) {
                    throw new Exception("get pid file lock failed, lock is null");
                }

                pid.deleteOnExit();

                String name = ManagementFactory.getRuntimeMXBean().getName();
                file.setLength(0);
                file.write(name.split("@")[0].getBytes(Charsets.UTF_8));

                return true;
            } catch (Throwable t) {
                LOG.warn("get pid file lock failed, retried: {}", i, t);
            }
        }

        return false;
    }

    // NOTE: To avoid dead lock
    //      1. never call System.exit in shutdownHook
    //      2. shutdownHook cannot have lock conflict with the function calling System.exit
    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOG.info("start to execute shutdown hook");
            try {
                Thread t = new Thread(() -> {
                    try {
                        Journal journal = GlobalStateMgr.getCurrentState().getJournal();
                        if (journal instanceof BDBJEJournal) {
                            BDBEnvironment bdbEnvironment = ((BDBJEJournal) journal).getBdbEnvironment();
                            if (bdbEnvironment != null) {
                                bdbEnvironment.flushVLSNMapping();
                            }
                        }
                    } catch (Throwable e) {
                        LOG.warn("flush vlsn mapping failed", e);
                    }
                });

                t.start();

                // it is necessary to set shutdown timeout,
                // because in addition to kill by user, System.exit(-1) will trigger the shutdown hook too,
                // if no timeout and shutdown hook blocked indefinitely, Fe will fall into a catastrophic state.
                t.join(30000);
            } catch (Throwable e) {
                LOG.warn("shut down hook failed", e);
            }
            LOG.info("shutdown hook end");
        }));
    }
}