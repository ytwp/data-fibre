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

package io.datafibre.fibre.qe.scheduler.slot;

import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.Status;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.common.util.DebugUtil;
import io.datafibre.fibre.ha.LeaderInfo;
import io.datafibre.fibre.qe.scheduler.RecoverableException;
import io.datafibre.fibre.rpc.FrontendServiceProxy;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.thrift.TNetworkAddress;
import io.datafibre.fibre.thrift.TReleaseSlotRequest;
import io.datafibre.fibre.thrift.TReleaseSlotResponse;
import io.datafibre.fibre.thrift.TRequireSlotRequest;
import io.datafibre.fibre.thrift.TStatusCode;
import io.datafibre.fibre.thrift.TUniqueId;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TApplicationException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * The slot manager view in the follower FEs. It receives the slot operations from {@link io.datafibre.fibre.qe.scheduler.Coordinator}
 * and sends it to {@link SlotManager} via RPC.
 *
 * @see SlotManager
 */
public class SlotProvider {
    private static final Logger LOG = LogManager.getLogger(SlotProvider.class);

    private final ConcurrentMap<TUniqueId, PendingSlotRequest> pendingSlots = new ConcurrentHashMap<>();

    public CompletableFuture<LogicalSlot> requireSlot(LogicalSlot slot) {
        TNetworkAddress leaderEndpoint = GlobalStateMgr.getCurrentState().getNodeMgr().getLeaderRpcEndpoint();
        PendingSlotRequest slotRequest = new PendingSlotRequest(slot, leaderEndpoint);
        slotRequest.onRequire();

        pendingSlots.put(slot.getSlotId(), slotRequest);

        // The leader may be changed between getting leaderEndpoint and putting request to pendingSlots,
        // so check whether leader changed after putting request to pendingSlots.
        TNetworkAddress newLeaderEndpoint = GlobalStateMgr.getCurrentState().getNodeMgr().getLeaderRpcEndpoint();
        if (!newLeaderEndpoint.equals(leaderEndpoint)) {
            failSlotRequestByLeaderChange(slotRequest);
            return slotRequest.getSlotFuture();
        }

        try {
            requireSlotFromSlotManager(slotRequest);
        } catch (Exception e) {
            LOG.warn("[Slot] failed to require slot [slot={}]", slot, e);
            pendingSlots.remove(slot.getSlotId());
            slotRequest.onFailed(e);
        }

        return slotRequest.getSlotFuture();
    }

    public Status finishSlotRequirement(TUniqueId slotId, int pipelineDop, Status status) {
        PendingSlotRequest slotRequest = pendingSlots.remove(slotId);
        if (slotRequest == null) {
            LOG.warn("[Slot] finishSlotRequirement receives a response with non-exist slotId [slotId={}] [status={}]",
                    DebugUtil.printId(slotId), status);
            return Status.internalError("the slotId does not exist");
        }

        if (status.ok()) {
            slotRequest.onFinished(pipelineDop);
        } else {
            LOG.warn("[Slot] finishSlotRequirement receives a failed response [slot={}] [status={}]", slotRequest, status);
            slotRequest.onFailed(new UserException(status.getErrorMsg()));
        }

        return new Status();
    }

    public void cancelSlotRequirement(LogicalSlot slot) {
        if (slot == null) {
            return;
        }

        PendingSlotRequest slotRequest = pendingSlots.remove(slot.getSlotId());
        if (slotRequest == null) {
            return;
        }

        slotRequest.onCancel();
        releaseSlotToSlotManager(slot);
    }

    public void releaseSlot(LogicalSlot slot) {
        if (slot == null || slot.getState() != LogicalSlot.State.ALLOCATED) {
            return;
        }

        slot.onRelease();
        releaseSlotToSlotManager(slot);
    }

    public void leaderChangeListener(LeaderInfo leaderInfo) {
        pendingSlots.values().stream()
                .filter(slot -> !slot.getLeaderEndpoint().getHostname().equals(leaderInfo.getIp()))
                .collect(Collectors.toList())
                .forEach(this::failSlotRequestByLeaderChange);
    }

    private void failSlotRequestByLeaderChange(PendingSlotRequest slotRequest) {
        pendingSlots.remove(slotRequest.getSlot().getSlotId());
        slotRequest.onRetry(new RecoverableException("leader is changed and need require slot again"));
    }

    private void requireSlotFromSlotManager(PendingSlotRequest slotRequest) throws Exception {
        TRequireSlotRequest request = new TRequireSlotRequest();
        request.setSlot(slotRequest.getSlot().toThrift());

        FrontendServiceProxy.call(slotRequest.getLeaderEndpoint(),
                Config.thrift_rpc_timeout_ms,
                Config.thrift_rpc_retry_times,
                client -> {
                    try {
                        return client.requireSlotAsync(request);
                    } catch (TApplicationException e) {
                        if (e.getType() == TApplicationException.UNKNOWN_METHOD) {
                            LOG.warn("[Slot] leader doesn't have the RPC method [requireSlotAsync]. " +
                                            "It is grayscale upgrading, so admit this query without requiring slots. [slot={}]",
                                    slotRequest);
                            pendingSlots.remove(slotRequest.getSlot().getSlotId());
                            slotRequest.onFinished(0);
                            slotRequest.getSlot().onRelease(); // Avoid sending releaseSlot RPC.
                            return null;
                        } else {
                            throw e;
                        }
                    }
                });

    }

    private void releaseSlotToSlotManager(LogicalSlot slot) {
        TNetworkAddress leaderEndpoint = GlobalStateMgr.getCurrentState().getNodeMgr().getLeaderRpcEndpoint();
        TReleaseSlotRequest slotRequest = new TReleaseSlotRequest();
        slotRequest.setSlot_id(slot.getSlotId());

        try {
            TReleaseSlotResponse res = FrontendServiceProxy.call(
                    leaderEndpoint,
                    Config.thrift_rpc_timeout_ms,
                    Config.thrift_rpc_retry_times,
                    client -> client.releaseSlot(slotRequest));
            if (res.getStatus().getStatus_code() != TStatusCode.OK) {
                String errMsg = "";
                if (!CollectionUtils.isEmpty(res.getStatus().getError_msgs())) {
                    errMsg = res.getStatus().getError_msgs().get(0);
                }
                LOG.warn("[Slot] failed to release slot [slot={}] [errMsg={}]", slot, errMsg);
            }
        } catch (Exception e) {
            LOG.warn("[Slot] failed to release slot [slot={}]", slot, e);
        }
    }
}
