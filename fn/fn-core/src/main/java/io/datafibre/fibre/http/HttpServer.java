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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/http/HttpServer.java

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

package io.datafibre.fibre.http;

import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.Log4jConfig;
import io.datafibre.fibre.http.action.BackendAction;
import io.datafibre.fibre.http.action.HaAction;
import io.datafibre.fibre.http.action.IndexAction;
import io.datafibre.fibre.http.action.LogAction;
import io.datafibre.fibre.http.action.QueryAction;
import io.datafibre.fibre.http.action.QueryProfileAction;
import io.datafibre.fibre.http.action.SessionAction;
import io.datafibre.fibre.http.action.StaticResourceAction;
import io.datafibre.fibre.http.action.SystemAction;
import io.datafibre.fibre.http.action.VariableAction;
import io.datafibre.fibre.http.common.StarRocksHttpPostObjectAggregator;
import io.datafibre.fibre.http.meta.ColocateMetaService;
import io.datafibre.fibre.http.meta.GlobalDictMetaService;
import io.datafibre.fibre.http.meta.MetaService.CheckAction;
import io.datafibre.fibre.http.meta.MetaService.DumpAction;
import io.datafibre.fibre.http.meta.MetaService.DumpStarMgrAction;
import io.datafibre.fibre.http.meta.MetaService.ImageAction;
import io.datafibre.fibre.http.meta.MetaService.InfoAction;
import io.datafibre.fibre.http.meta.MetaService.JournalIdAction;
import io.datafibre.fibre.http.meta.MetaService.PutAction;
import io.datafibre.fibre.http.meta.MetaService.RoleAction;
import io.datafibre.fibre.http.meta.MetaService.VersionAction;
import io.datafibre.fibre.http.rest.BootstrapFinishAction;
import io.datafibre.fibre.http.rest.CancelStreamLoad;
import io.datafibre.fibre.http.rest.CheckDecommissionAction;
import io.datafibre.fibre.http.rest.ConnectionAction;
import io.datafibre.fibre.http.rest.ExecuteSqlAction;
import io.datafibre.fibre.http.rest.FeatureAction;
import io.datafibre.fibre.http.rest.GetDdlStmtAction;
import io.datafibre.fibre.http.rest.GetLoadInfoAction;
import io.datafibre.fibre.http.rest.GetLogFileAction;
import io.datafibre.fibre.http.rest.GetSmallFileAction;
import io.datafibre.fibre.http.rest.GetStreamLoadState;
import io.datafibre.fibre.http.rest.HealthAction;
import io.datafibre.fibre.http.rest.LoadAction;
import io.datafibre.fibre.http.rest.MetaReplayerCheckAction;
import io.datafibre.fibre.http.rest.MetricsAction;
import io.datafibre.fibre.http.rest.MigrationAction;
import io.datafibre.fibre.http.rest.ProfileAction;
import io.datafibre.fibre.http.rest.QueryDetailAction;
import io.datafibre.fibre.http.rest.QueryDumpAction;
import io.datafibre.fibre.http.rest.RowCountAction;
import io.datafibre.fibre.http.rest.SetConfigAction;
import io.datafibre.fibre.http.rest.ShowDataAction;
import io.datafibre.fibre.http.rest.ShowMetaInfoAction;
import io.datafibre.fibre.http.rest.ShowProcAction;
import io.datafibre.fibre.http.rest.ShowRuntimeInfoAction;
import io.datafibre.fibre.http.rest.StopFeAction;
import io.datafibre.fibre.http.rest.StorageTypeCheckAction;
import io.datafibre.fibre.http.rest.SyncCloudTableMetaAction;
import io.datafibre.fibre.http.rest.TableQueryPlanAction;
import io.datafibre.fibre.http.rest.TableRowCountAction;
import io.datafibre.fibre.http.rest.TableSchemaAction;
import io.datafibre.fibre.http.rest.TransactionLoadAction;
import io.datafibre.fibre.http.rest.TriggerAction;
import io.datafibre.fibre.leader.MetaHelper;
import io.datafibre.fibre.metric.GaugeMetric;
import io.datafibre.fibre.metric.GaugeMetricImpl;
import io.datafibre.fibre.metric.Metric;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.EventExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static io.datafibre.fibre.http.HttpMetricRegistry.HTTP_WORKERS_NUM;
import static io.datafibre.fibre.http.HttpMetricRegistry.HTTP_WORKER_PENDING_TASKS_NUM;

public class HttpServer {
    private static final Logger LOG = LogManager.getLogger(HttpServer.class);
    private int port;
    private ActionController controller;

    private Thread serverThread;

    private AtomicBoolean isStarted = new AtomicBoolean(false);

    public HttpServer(int port) {
        this.port = port;
        controller = new ActionController();
    }

    public void setup() throws IllegalArgException {
        registerActions();
    }

    public ActionController getController() {
        return controller;
    }

    private void registerActions() throws IllegalArgException {
        // add rest action
        LoadAction.registerAction(controller);
        TransactionLoadAction.registerAction(controller);
        GetLoadInfoAction.registerAction(controller);
        SetConfigAction.registerAction(controller);
        GetDdlStmtAction.registerAction(controller);
        MigrationAction.registerAction(controller);
        StorageTypeCheckAction.registerAction(controller);
        CancelStreamLoad.registerAction(controller);
        GetStreamLoadState.registerAction(controller);

        // add web action
        IndexAction.registerAction(controller);
        SystemAction.registerAction(controller);
        BackendAction.registerAction(controller);
        LogAction.registerAction(controller);
        QueryAction.registerAction(controller);
        QueryProfileAction.registerAction(controller);
        SessionAction.registerAction(controller);
        VariableAction.registerAction(controller);
        StaticResourceAction.registerAction(controller);
        HaAction.registerAction(controller);

        // rest action
        HealthAction.registerAction(controller);
        FeatureAction.registerAction(controller);
        MetricsAction.registerAction(controller);
        ShowMetaInfoAction.registerAction(controller);
        ShowProcAction.registerAction(controller);
        ShowRuntimeInfoAction.registerAction(controller);
        GetLogFileAction.registerAction(controller);
        TriggerAction.registerAction(controller);
        GetSmallFileAction.registerAction(controller);
        RowCountAction.registerAction(controller);
        CheckDecommissionAction.registerAction(controller);
        MetaReplayerCheckAction.registerAction(controller);
        ColocateMetaService.BucketSeqAction.registerAction(controller);
        ColocateMetaService.ColocateMetaAction.registerAction(controller);
        ColocateMetaService.MarkGroupStableAction.registerAction(controller);
        ColocateMetaService.MarkGroupUnstableAction.registerAction(controller);
        ColocateMetaService.UpdateGroupAction.registerAction(controller);
        GlobalDictMetaService.ForbitTableAction.registerAction(controller);
        ProfileAction.registerAction(controller);
        QueryDetailAction.registerAction(controller);
        ConnectionAction.registerAction(controller);
        ShowDataAction.registerAction(controller);
        QueryDumpAction.registerAction(controller);
        SyncCloudTableMetaAction.registerAction(controller);
        // for stop FE
        StopFeAction.registerAction(controller);
        ExecuteSqlAction.registerAction(controller);

        // meta service action
        File imageDir = MetaHelper.getLeaderImageDir();
        ImageAction.registerAction(controller, imageDir);
        InfoAction.registerAction(controller, imageDir);
        VersionAction.registerAction(controller, imageDir);
        PutAction.registerAction(controller, imageDir);
        JournalIdAction.registerAction(controller, imageDir);
        CheckAction.registerAction(controller, imageDir);
        DumpAction.registerAction(controller, imageDir);
        DumpStarMgrAction.registerAction(controller, imageDir);
        RoleAction.registerAction(controller, imageDir);

        // external usage
        TableRowCountAction.registerAction(controller);
        TableSchemaAction.registerAction(controller);
        TableQueryPlanAction.registerAction(controller);

        BootstrapFinishAction.registerAction(controller);
    }

    public void start() {
        serverThread = new Thread(new HttpServerThread(), "FE Http Server");
        serverThread.start();
    }

    protected class StarrocksHttpServerInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new HttpServerCodec(
                            Config.http_max_initial_line_length,
                            Config.http_max_header_size,
                            Config.http_max_chunk_size))
                    .addLast(new StarRocksHttpPostObjectAggregator(100 * 65536))
                    .addLast(new ChunkedWriteHandler())
                    // add content compressor
                    .addLast(new CustomHttpContentCompressor())
                    .addLast(new HttpServerHandler(controller));
        }
    }

    private class CustomHttpContentCompressor extends HttpContentCompressor {
        private boolean compressResponse = false;

        @Override
        protected void decode(ChannelHandlerContext ctx, HttpRequest msg, List<Object> out) throws Exception {
            if (msg.uri().startsWith(MetricsAction.API_PATH)) {
                // only `/metrics` api got compressed right now
                compressResponse = true;
            }
            super.decode(ctx, msg, out);
        }

        @Override
        protected Result beginEncode(HttpResponse headers, String acceptEncoding) throws Exception {
            if (!compressResponse) {
                return null;
            }
            return super.beginEncode(headers, acceptEncoding);
        }
    }

    ServerBootstrap serverBootstrap;

    private class HttpServerThread implements Runnable {
        @Override
        public void run() {
            // Configure the server.
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            int numWorkerThreads = Math.max(0, Config.http_worker_threads_num);
            NioEventLoopGroup workerGroup = new NioEventLoopGroup(numWorkerThreads);
            try {
                serverBootstrap = new ServerBootstrap();
                serverBootstrap.option(ChannelOption.SO_BACKLOG, Config.http_backlog_num);
                // reused address and port to avoid bind already exception
                serverBootstrap.option(ChannelOption.SO_REUSEADDR, true);
                serverBootstrap.childOption(ChannelOption.SO_REUSEADDR, true);
                serverBootstrap.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new StarrocksHttpServerInitializer());
                Channel ch = serverBootstrap.bind(port).sync().channel();

                isStarted.set(true);
                registerMetrics(workerGroup);
                LOG.info("HttpServer started with port {}", port);
                // block until server is closed
                ch.closeFuture().sync();
            } catch (Exception e) {
                LOG.error("Fail to start FE query http server[port: " + port + "] ", e);
                System.exit(-1);
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        }
    }

    private void registerMetrics(NioEventLoopGroup workerGroup) {
        HttpMetricRegistry httpMetricRegistry = HttpMetricRegistry.getInstance();

        GaugeMetricImpl<Long> httpWorkersNum = new GaugeMetricImpl<>(
                HTTP_WORKERS_NUM, Metric.MetricUnit.NOUNIT, "the number of http workers");
        httpWorkersNum.setValue(0L);
        httpMetricRegistry.registerGauge(httpWorkersNum);

        GaugeMetric<Long> pendingTasks = new GaugeMetric<>(HTTP_WORKER_PENDING_TASKS_NUM, Metric.MetricUnit.NOUNIT,
                "the number of tasks that are pending for processing in the queues of http workers") {
            @Override
            public Long getValue() {
                if (!Config.enable_http_detail_metrics) {
                    return 0L;
                }
                long pendingTasks = 0;
                for (EventExecutor executor : workerGroup) {
                    if (executor instanceof NioEventLoop) {
                        pendingTasks += ((NioEventLoop) executor).pendingTasks();
                    }
                }
                return pendingTasks;
            }
        };
        httpMetricRegistry.registerGauge(pendingTasks);
    }

    // used for test, release bound port
    public void shutDown() {
        if (serverBootstrap != null) {
            Future future =
                    serverBootstrap.config().group().shutdownGracefully(0, 1, TimeUnit.SECONDS).syncUninterruptibly();
            try {
                future.get();
                isStarted.set(false);
                LOG.info("HttpServer was closed completely");
            } catch (Throwable e) {
                LOG.warn("Exception happened when close HttpServer", e);
            }
            serverBootstrap = null;
        }
    }

    public boolean isStarted() {
        return isStarted.get();
    }

    public static void main(String[] args) throws Exception {
        Log4jConfig.initLogging();
        HttpServer httpServer = new HttpServer(8080);
        httpServer.setup();
        System.out.println("before start http server.");
        httpServer.start();
        System.out.println("after start http server.");

        while (true) {
            Thread.sleep(2000);
        }
    }
}
