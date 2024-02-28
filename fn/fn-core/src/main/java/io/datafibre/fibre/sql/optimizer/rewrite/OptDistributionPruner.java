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


package io.datafibre.fibre.sql.optimizer.rewrite;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.datafibre.fibre.catalog.DistributionInfo;
import io.datafibre.fibre.catalog.HashDistributionInfo;
import io.datafibre.fibre.catalog.MaterializedIndex;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Partition;
import io.datafibre.fibre.catalog.PhysicalPartition;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.planner.DistributionPruner;
import io.datafibre.fibre.planner.HashDistributionPruner;
import io.datafibre.fibre.planner.PartitionColumnFilter;
import io.datafibre.fibre.sql.optimizer.operator.ColumnFilterConverter;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalOlapScanOperator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OptDistributionPruner {
    private static final Logger LOG = LogManager.getLogger(OptDistributionPruner.class);

    public static List<Long> pruneTabletIds(LogicalOlapScanOperator olapScanOperator,
                                            List<Long> selectedPartitionIds) {
        OlapTable olapTable = (OlapTable) olapScanOperator.getTable();

        List<Long> result = Lists.newArrayList();
        for (Long partitionId : selectedPartitionIds) {
            Partition partition = olapTable.getPartition(partitionId);
            for (PhysicalPartition physicalPartition : partition.getSubPartitions()) {
                MaterializedIndex table = physicalPartition.getIndex(olapScanOperator.getSelectedIndexId());
                Collection<Long> tabletIds = distributionPrune(table, partition.getDistributionInfo(), olapScanOperator);
                result.addAll(tabletIds);
            }
        }
        return result;
    }

    private static Collection<Long> distributionPrune(MaterializedIndex index, DistributionInfo distributionInfo,
                                                      LogicalOlapScanOperator operator) {
        try {
            DistributionPruner distributionPruner;
            if (distributionInfo.getType() == DistributionInfo.DistributionInfoType.HASH) {
                HashDistributionInfo info = (HashDistributionInfo) distributionInfo;
                Map<String, PartitionColumnFilter> filters = Maps.newHashMap();
                Table table = operator.getTable();
                if (table.isExprPartitionTable()) {
                    // Bucketing needs to use the original predicate for hashing
                    ColumnFilterConverter.convertColumnFilterWithoutExpr(operator.getPredicate(), filters, table);
                } else {
                    filters = operator.getColumnFilters();
                }
                distributionPruner = new HashDistributionPruner(index.getTabletIdsInOrder(),
                        info.getDistributionColumns(),
                        filters,
                        info.getBucketNum());
                return distributionPruner.prune();
            }
        } catch (AnalysisException e) {
            LOG.warn("distribution prune failed. ", e);
        }

        return index.getTabletIdsInOrder();
    }
}
