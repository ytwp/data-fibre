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

package io.datafibre.fibre.qe;

import com.google.common.base.Objects;
import com.google.common.base.Stopwatch;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.SetMultimap;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.LiteralExpr;
import io.datafibre.fibre.common.util.RuntimeProfile;
import io.datafibre.fibre.metric.MetricRepo;
import io.datafibre.fibre.planner.OlapScanNode;
import io.datafibre.fibre.planner.PlanFragment;
import io.datafibre.fibre.planner.PlanNode;
import io.datafibre.fibre.planner.ProjectNode;
import io.datafibre.fibre.proto.PExecShortCircuitResult;
import io.datafibre.fibre.rpc.BrpcProxy;
import io.datafibre.fibre.rpc.PBackendService;
import io.datafibre.fibre.rpc.PExecShortCircuitRequest;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.system.Backend;
import io.datafibre.fibre.thrift.TDescriptorTable;
import io.datafibre.fibre.thrift.TExecShortCircuitParams;
import io.datafibre.fibre.thrift.TInternalScanRange;
import io.datafibre.fibre.thrift.TKeyLiteralExpr;
import io.datafibre.fibre.thrift.TNetworkAddress;
import io.datafibre.fibre.thrift.TResultBatch;
import io.datafibre.fibre.thrift.TRuntimeProfileTree;
import io.datafibre.fibre.thrift.TScanRangeLocations;
import io.datafibre.fibre.thrift.TStatusCode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.thrift.TDeserializer;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ShortCircuitHybridExecutor extends ShortCircuitExecutor {

    private static final Logger LOG = LogManager.getLogger(ShortCircuitHybridExecutor.class);

    public ShortCircuitHybridExecutor(ConnectContext context, PlanFragment planFragment,
                                      List<TScanRangeLocations> scanRangeLocations, TDescriptorTable tDescriptorTable,
                                      boolean isBinaryRow, boolean enableProfile) {
        super(context, planFragment, scanRangeLocations, tDescriptorTable, isBinaryRow, enableProfile);
    }

    @Override
    public void exec() {
        if (result != null) {
            return;
        }
        Stopwatch watch = Stopwatch.createUnstarted();
        SetMultimap<TNetworkAddress, TExecShortCircuitParams> be2ShortCircuitRequests = createRequests();
        Queue<RowBatch> rowBatchQueue = new LinkedList<>();
        AtomicReference<RuntimeProfile> runtimeProfile = new AtomicReference<>();
        AtomicLong affectedRows = new AtomicLong();

        // all data will be pruned by fe
        if (be2ShortCircuitRequests.keys().size() == 0) {
            rowBatchQueue.offer(new RowBatch());
            result = new ShortCircuitResult(rowBatchQueue, affectedRows.get(), runtimeProfile.get());
            return;
        }

        AtomicInteger i = new AtomicInteger();
        MetricRepo.COUNTER_SHORTCIRCUIT_QUERY.increase(1L);
        MetricRepo.COUNTER_SHORTCIRCUIT_RPC.increase((long) be2ShortCircuitRequests.size());
        be2ShortCircuitRequests.forEach((beAddress, tRequest) -> {
            PBackendService service = BrpcProxy.getBackendService(beAddress);
            try {
                PExecShortCircuitRequest pRequest = new PExecShortCircuitRequest();
                pRequest.setRequest(tRequest);
                watch.start();
                Future<PExecShortCircuitResult> future = service.execShortCircuit(pRequest);
                PExecShortCircuitResult shortCircuitResult = future.get(
                        context.getSessionVariable().getQueryTimeoutS(), TimeUnit.SECONDS);
                watch.stop();
                long t = watch.elapsed().toMillis();
                MetricRepo.HISTO_SHORTCIRCUIT_RPC_LATENCY.update(t);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("exec short circuit time: " + t + "ms.");
                }

                TStatusCode code = TStatusCode.findByValue(shortCircuitResult.status.statusCode);
                if (shortCircuitResult.status.errorMsgs != null && !shortCircuitResult.status.errorMsgs.isEmpty()) {
                    throw new RuntimeException(shortCircuitResult.status.errorMsgs.get(0) + "code: " + code +
                            " backend: " + beAddress.getHostname() + ", port:" + beAddress.getPort());
                }

                if (null != shortCircuitResult.affectedRows) {
                    affectedRows.getAndAdd(shortCircuitResult.affectedRows);
                }

                byte[] serialResult = pRequest.getSerializedResult();
                RowBatch rowBatch = new RowBatch();
                rowBatch.setEos(i.incrementAndGet() == be2ShortCircuitRequests.keys().size());
                if (serialResult != null && serialResult.length > 0) {
                    TDeserializer deserializer = new TDeserializer();
                    TResultBatch resultBatch = new TResultBatch();
                    deserializer.deserialize(resultBatch, serialResult);
                    rowBatch.setBatch(resultBatch);
                }
                rowBatchQueue.offer(rowBatch);

                if (shortCircuitResult.profile != null) {
                    TDeserializer deserializer = new TDeserializer();
                    TRuntimeProfileTree runtimeProfileTree = new TRuntimeProfileTree();
                    deserializer.deserialize(runtimeProfileTree, shortCircuitResult.profile);
                    runtimeProfile.set(new RuntimeProfile());
                    runtimeProfile.get().update(runtimeProfileTree);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable e) {
                throw new RuntimeException("Execute short circuit failed, reason: "
                        + e.getMessage() + " backend: " + beAddress.getHostname() + ", port:" + beAddress.getPort(), e);
            }

        });

        result = new ShortCircuitResult(rowBatchQueue, affectedRows.get(), runtimeProfile.get());
    }

    public class TabletWithVersion {
        final long tabletId;
        final String version;

        public TabletWithVersion(long tabletId, String version) {
            this.tabletId = tabletId;
            this.version = version;
        }

        public long getTabletId() {
            return tabletId;
        }

        public String getVersion() {
            return version;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TabletWithVersion that = (TabletWithVersion) o;
            return tabletId == that.tabletId && Objects.equal(version, that.version);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(tabletId, version);
        }
    }

    /**
     * compute all tablets per be
     *
     * @return
     */
    private SetMultimap<TNetworkAddress, TabletWithVersion> assignTablet2Backends() {
        SetMultimap<TNetworkAddress, TabletWithVersion> backend2Tablets = HashMultimap.create();
        scanRangeLocations.forEach(range -> {
            ImmutableMap<Long, Backend> idToBackend =
                    GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().getIdToBackend();

            TInternalScanRange internalScanRange = range.getScan_range().getInternal_scan_range();
            TabletWithVersion tabletWithVersion = new TabletWithVersion(internalScanRange.getTablet_id(),
                    internalScanRange.getVersion());

            TNetworkAddress be = pick(internalScanRange.getHosts());
            idToBackend.forEach((id, backend) -> {
                if (backend.getHost().equals(be.getHostname()) && (backend.getBePort() == be.getPort())) {
                    backend2Tablets.put(new TNetworkAddress(be.getHostname(), backend.getBrpcPort()), tabletWithVersion);
                }
            });
        });
        return backend2Tablets;
    }

    private SetMultimap<TNetworkAddress, TExecShortCircuitParams> createRequests() {
        SetMultimap<TNetworkAddress, TExecShortCircuitParams> toSendRequests = HashMultimap.create();
        getOlapScanNode().ifPresent(rootNode -> {
            OlapScanNode olapScanNode = (OlapScanNode) rootNode;
            // set literal exprs
            List<List<LiteralExpr>> keyTuples = olapScanNode.getRowStoreKeyLiterals();
            List<TKeyLiteralExpr> keyLiteralExprs = keyTuples.stream().map(keyTuple -> {
                TKeyLiteralExpr keyLiteralExpr = new TKeyLiteralExpr();
                keyLiteralExpr.setLiteral_exprs(keyTuple.stream()
                        .map(Expr::treeToThrift)
                        .collect(Collectors.toList()));
                return keyLiteralExpr;
            }).collect(Collectors.toList());

            // fill tablet id and version , then bind be network
            SetMultimap<TNetworkAddress, TabletWithVersion> be2Tablets = assignTablet2Backends();
            olapScanNode.clearScanNodeForThriftBuild();
            be2Tablets.forEach((addr, tableVersion) -> {
                TExecShortCircuitParams commonRequest = new TExecShortCircuitParams();
                commonRequest.setDesc_tbl(tDescriptorTable);
                commonRequest.setOutput_exprs(planFragment.getOutputExprs().stream()
                        .map(Expr::treeToThrift).collect(Collectors.toList()));
                commonRequest.setIs_binary_row(isBinaryRow);
                commonRequest.setEnable_profile(enableProfile);
                if (planFragment.getSink() != null) {
                    commonRequest.setData_sink(planFragment.sinkToThrift());
                }
                commonRequest.setKey_literal_exprs(keyLiteralExprs);

                List<Long> tabletIds = be2Tablets.get(addr).stream().map(TabletWithVersion::getTabletId)
                        .collect(Collectors.toList());
                commonRequest.setTablet_ids(tabletIds);
                List<String> versions = be2Tablets.get(addr).stream().map(TabletWithVersion::getVersion)
                        .collect(Collectors.toList());
                commonRequest.setVersions(versions);
                commonRequest.setPlan(planFragment.getPlanRoot().treeToThrift());
                toSendRequests.put(addr, commonRequest);
            });
        });

        return toSendRequests;
    }

    private Optional<PlanNode> getOlapScanNode() {
        return Optional.ofNullable(planFragment.getPlanRoot()).map(rootNode -> {
            if (rootNode instanceof OlapScanNode) {
                return rootNode;
            } else if (rootNode instanceof ProjectNode && rootNode.getChildren().size() == 1 &&
                    rootNode.getChild(0) instanceof OlapScanNode) {
                return rootNode.getChild(0);
            } else {
                return null;
            }
        });
    }

}