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

import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.qe.scheduler.Coordinator;
import io.datafibre.fibre.thrift.TBatchReportExecStatusParams;
import io.datafibre.fibre.thrift.TBatchReportExecStatusResult;
import io.datafibre.fibre.thrift.TNetworkAddress;
import io.datafibre.fibre.thrift.TReportAuditStatisticsParams;
import io.datafibre.fibre.thrift.TReportAuditStatisticsResult;
import io.datafibre.fibre.thrift.TReportExecStatusParams;
import io.datafibre.fibre.thrift.TReportExecStatusResult;
import io.datafibre.fibre.thrift.TUniqueId;

import java.util.List;
import java.util.Map;

public interface QeProcessor {

    TReportExecStatusResult reportExecStatus(TReportExecStatusParams params, TNetworkAddress beAddr);

    TReportAuditStatisticsResult reportAuditStatistics(TReportAuditStatisticsParams params, TNetworkAddress beAddr);

    TBatchReportExecStatusResult batchReportExecStatus(TBatchReportExecStatusParams params, TNetworkAddress beAddr);

    void registerQuery(TUniqueId queryId, Coordinator coord) throws UserException;

    void registerQuery(TUniqueId queryId, QeProcessorImpl.QueryInfo info) throws UserException;

    void unregisterQuery(TUniqueId queryId);

    void monitorQuery(TUniqueId queryId, long expireTime);

    void unMonitorQuery(TUniqueId queryId);

    Map<String, QueryStatisticsItem> getQueryStatistics();

    Coordinator getCoordinator(TUniqueId queryId);

    List<Coordinator> getCoordinators();

    long getCoordinatorCount();
}
