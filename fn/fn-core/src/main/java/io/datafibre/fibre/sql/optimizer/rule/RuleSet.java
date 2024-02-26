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

package io.datafibre.fibre.sql.optimizer.rule;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.datafibre.fibre.sql.optimizer.rule.implementation.AssertOneRowImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.CTEAnchorImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.CTEAnchorToNoCTEImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.CTEConsumeInlineImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.CTEConsumerReuseImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.CTEProduceImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.DeltaLakeScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.EsScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.ExceptImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.FileScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.FilterImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.HashAggImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.HashJoinImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.HiveScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.HudiScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.IcebergScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.IntersectImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.JDBCScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.LimitImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.MergeJoinImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.MetaScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.MysqlScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.NestLoopJoinImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.OdpsScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.OlapScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.PaimonScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.ProjectImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.RepeatImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.SchemaScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.TableFunctionImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.TableFunctionTableScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.TopNImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.UnionImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.ValuesImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.WindowImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.stream.StreamAggregateImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.stream.StreamJoinImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.implementation.stream.StreamScanImplementationRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.CastToEmptyRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.CollectCTEConsumeRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.CollectCTEProduceRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.DistributionPruneRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.EliminateLimitZeroRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.ExistentialApply2JoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.ExistentialApply2OuterJoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.ExternalScanPartitionPruneRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.GroupByCountDistinctDataSkewEliminateRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.InlineOneCTEConsumeRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.IntersectAddDistinctRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.JoinAssociativityRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.JoinCommutativityRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.JoinCommutativityWithoutInnerRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.JoinLeftAsscomRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.LimitPruneTabletsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.MergeApplyWithTableFunction;
import io.datafibre.fibre.sql.optimizer.rule.transformation.MergeLimitDirectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.MergeLimitWithLimitRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.MergeLimitWithSortRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.MergeTwoFiltersRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.MergeTwoProjectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PartitionPruneRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneAggregateColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneAssertOneRowRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneCTEConsumeColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneCTEProduceRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneEmptyDirectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneEmptyExceptRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneEmptyIntersectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneEmptyJoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneEmptyScanRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneEmptyUnionRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneEmptyWindowRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneExceptColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneFilterColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneGroupByKeysRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneHDFSScanColumnRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneIntersectColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneJoinColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneProjectColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneProjectEmptyRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneProjectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneRepeatColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneScanColumnRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneTableFunctionColumnRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneTopNColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneTrueFilterRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneUnionColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneValuesColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PruneWindowColumnsRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownApplyAggFilterRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownApplyAggProjectFilterRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownApplyFilterRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownApplyLeftProjectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownApplyLeftRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownApplyProjectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownJoinOnClauseRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownLimitCTEAnchor;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownLimitDirectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownLimitJoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownLimitUnionRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateAggRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateCTEAnchor;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateCTEConsumeRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateExceptRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateIntersectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateJoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateProjectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateRepeatRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateScanRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateTableFunctionRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateToExternalTableScanRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateUnionRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownPredicateWindowRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownProjectLimitRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.PushDownProjectToCTEAnchorRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.QuantifiedApply2JoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.QuantifiedApply2OuterJoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.ReorderIntersectRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.RewriteBitmapCountDistinctRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.RewriteCountIfFunction;
import io.datafibre.fibre.sql.optimizer.rule.transformation.RewriteDuplicateAggregateFnRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.RewriteHllCountDistinctRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.RewriteSimpleAggToMetaScanRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.RewriteSumByAssociativeRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.ScalarApply2AnalyticRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.ScalarApply2JoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.SplitLimitRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.SplitMultiPhaseAggRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.SplitTopNRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.SplitTwoPhaseAggRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.rule.AggregateJoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.rule.AggregateScanRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.rule.OnlyJoinRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.rule.OnlyScanRule;
import io.datafibre.fibre.sql.optimizer.rule.transformation.pruner.CboTablePruneRule;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RuleSet {
    private static final Map<RuleSetType, List<Rule>> REWRITE_RULES = Maps.newHashMap();

    private static final List<Rule> ALL_IMPLEMENT_RULES = ImmutableList.of(
            new OlapScanImplementationRule(),
            new HiveScanImplementationRule(),
            new FileScanImplementationRule(),
            new IcebergScanImplementationRule(),
            new HudiScanImplementationRule(),
            new DeltaLakeScanImplementationRule(),
            new PaimonScanImplementationRule(),
            new OdpsScanImplementationRule(),
            new SchemaScanImplementationRule(),
            new MysqlScanImplementationRule(),
            new EsScanImplementationRule(),
            new MetaScanImplementationRule(),
            new JDBCScanImplementationRule(),
            new TableFunctionTableScanImplementationRule(),
            new HashAggImplementationRule(),
            new ProjectImplementationRule(),
            new TopNImplementationRule(),
            new AssertOneRowImplementationRule(),
            new WindowImplementationRule(),
            new UnionImplementationRule(),
            new ExceptImplementationRule(),
            new IntersectImplementationRule(),
            new ValuesImplementationRule(),
            new RepeatImplementationRule(),
            new FilterImplementationRule(),
            new TableFunctionImplementationRule(),
            new LimitImplementationRule(),
            new CTEAnchorImplementationRule(),
            new CTEAnchorToNoCTEImplementationRule(),
            new CTEConsumerReuseImplementationRule(),
            new CTEConsumeInlineImplementationRule(),
            new CTEProduceImplementationRule()
    );

    private static final ImmutableList<Rule> MV_IMPLEMENT_RULES = ImmutableList.of(
            StreamJoinImplementationRule.getInstance(),
            StreamAggregateImplementationRule.getInstance()
    );

    private final List<Rule> implementRules = Lists.newArrayList(ALL_IMPLEMENT_RULES);

    private final List<Rule> transformRules = Lists.newArrayList();

    static {
        REWRITE_RULES.put(RuleSetType.MERGE_LIMIT, ImmutableList.of(
                new PushDownProjectLimitRule(),
                new EliminateLimitZeroRule(), // should before MergeLimitWithSortRule
                new MergeLimitWithSortRule(),
                new SplitLimitRule(),
                new PushDownLimitJoinRule(),
                new PushDownLimitCTEAnchor(),
                new PushDownLimitUnionRule(),
                new MergeLimitWithLimitRule(),
                PushDownLimitDirectRule.PROJECT,
                PushDownLimitDirectRule.ASSERT_ONE_ROW,
                PushDownLimitDirectRule.CTE_CONSUME,
                MergeLimitDirectRule.AGGREGATE,
                MergeLimitDirectRule.OLAP_SCAN,
                MergeLimitDirectRule.VIEW_SCAN,
                MergeLimitDirectRule.HIVE_SCAN,
                MergeLimitDirectRule.ICEBERG_SCAN,
                MergeLimitDirectRule.HUDI_SCAN,
                MergeLimitDirectRule.DELTALAKE_SCAN,
                MergeLimitDirectRule.FILE_SCAN,
                MergeLimitDirectRule.PAIMON_SCAN,
                MergeLimitDirectRule.ODPS_SCAN,
                MergeLimitDirectRule.SCHEMA_SCAN,
                MergeLimitDirectRule.MYSQL_SCAN,
                MergeLimitDirectRule.ES_SCAN,
                MergeLimitDirectRule.JDBC_SCAN,
                MergeLimitDirectRule.WINDOW,
                MergeLimitDirectRule.INTERSECT,
                MergeLimitDirectRule.EXCEPT,
                MergeLimitDirectRule.VALUES,
                MergeLimitDirectRule.FILTER,
                MergeLimitDirectRule.TABLE_FUNCTION,
                MergeLimitDirectRule.TABLE_FUNCTION_TABLE_SCAN
        ));

        REWRITE_RULES.put(RuleSetType.PARTITION_PRUNE, ImmutableList.of(
                new PartitionPruneRule(),
                new DistributionPruneRule(),
                ExternalScanPartitionPruneRule.HIVE_SCAN,
                ExternalScanPartitionPruneRule.HUDI_SCAN,
                ExternalScanPartitionPruneRule.ICEBERG_SCAN,
                ExternalScanPartitionPruneRule.DELTALAKE_SCAN,
                ExternalScanPartitionPruneRule.FILE_SCAN,
                ExternalScanPartitionPruneRule.ES_SCAN,
                ExternalScanPartitionPruneRule.PAIMON_SCAN,
                ExternalScanPartitionPruneRule.ODPS_SCAN,
                new LimitPruneTabletsRule()
        ));

        REWRITE_RULES.put(RuleSetType.PRUNE_COLUMNS, ImmutableList.of(
                PruneScanColumnRule.OLAP_SCAN,
                PruneScanColumnRule.SCHEMA_SCAN,
                PruneScanColumnRule.MYSQL_SCAN,
                PruneScanColumnRule.ES_SCAN,
                PruneHDFSScanColumnRule.HIVE_SCAN,
                PruneHDFSScanColumnRule.ICEBERG_SCAN,
                PruneHDFSScanColumnRule.DELTALAKE_SCAN,
                PruneHDFSScanColumnRule.FILE_SCAN,
                PruneHDFSScanColumnRule.HUDI_SCAN,
                PruneHDFSScanColumnRule.TABLE_FUNCTION_TABLE_SCAN,
                PruneHDFSScanColumnRule.PAIMON_SCAN,
                PruneHDFSScanColumnRule.ODPS_SCAN,
                PruneScanColumnRule.JDBC_SCAN,
                PruneScanColumnRule.BINLOG_SCAN,
                new PruneProjectColumnsRule(),
                new PruneFilterColumnsRule(),
                new PruneAggregateColumnsRule(),
                new PruneGroupByKeysRule(),
                new PruneTopNColumnsRule(),
                new PruneJoinColumnsRule(),
                new PruneWindowColumnsRule(),
                new PruneUnionColumnsRule(),
                new PruneIntersectColumnsRule(),
                new PruneExceptColumnsRule(),
                new PruneRepeatColumnsRule(),
                new PruneValuesColumnsRule(),
                new PruneTableFunctionColumnRule(),
                new PruneCTEConsumeColumnsRule()
        ));

        REWRITE_RULES.put(RuleSetType.PUSH_DOWN_PREDICATE, ImmutableList.of(
                new CastToEmptyRule(),
                new PruneTrueFilterRule(),
                new PushDownPredicateCTEAnchor(),
                PushDownPredicateScanRule.OLAP_SCAN,
                PushDownPredicateScanRule.HIVE_SCAN,
                PushDownPredicateScanRule.ICEBERG_SCAN,
                PushDownPredicateScanRule.HUDI_SCAN,
                PushDownPredicateScanRule.DELTALAKE_SCAN,
                PushDownPredicateScanRule.FILE_SCAN,
                PushDownPredicateScanRule.PAIMON_SCAN,
                PushDownPredicateScanRule.SCHEMA_SCAN,
                PushDownPredicateScanRule.ES_SCAN,
                PushDownPredicateScanRule.META_SCAN,
                PushDownPredicateScanRule.BINLOG_SCAN,
                PushDownPredicateScanRule.TABLE_FUNCTION_TABLE_SCAN,
                PushDownPredicateScanRule.VIEW_SCAN,
                new PushDownPredicateAggRule(),
                new PushDownPredicateWindowRule(),
                new PushDownPredicateJoinRule(),
                new PushDownJoinOnClauseRule(),
                new PushDownPredicateProjectRule(),
                new PushDownPredicateUnionRule(),
                new PushDownPredicateExceptRule(),
                new PushDownPredicateIntersectRule(),
                new PushDownPredicateTableFunctionRule(),
                new PushDownPredicateRepeatRule(),

                PushDownPredicateToExternalTableScanRule.MYSQL_SCAN,
                PushDownPredicateToExternalTableScanRule.JDBC_SCAN,
                PushDownPredicateToExternalTableScanRule.ODPS_SCAN,
                new MergeTwoFiltersRule(),
                new PushDownPredicateCTEConsumeRule()
        ));

        REWRITE_RULES.put(RuleSetType.PUSH_DOWN_SUBQUERY, ImmutableList.of(
                new MergeApplyWithTableFunction(),
                new PushDownApplyLeftProjectRule(),
                new PushDownApplyLeftRule()
        ));

        REWRITE_RULES.put(RuleSetType.SUBQUERY_REWRITE_COMMON, ImmutableList.of(
                new PushDownApplyProjectRule(),
                new PushDownApplyFilterRule(),
                new PushDownApplyAggFilterRule(),
                new PushDownApplyAggProjectFilterRule()
        ));

        REWRITE_RULES.put(RuleSetType.SUBQUERY_REWRITE_TO_WINDOW, ImmutableList.of(
                new ScalarApply2AnalyticRule()
        ));

        REWRITE_RULES.put(RuleSetType.SUBQUERY_REWRITE_TO_JOIN, ImmutableList.of(
                new QuantifiedApply2JoinRule(),
                new ExistentialApply2JoinRule(),
                new ScalarApply2JoinRule(),
                new ExistentialApply2OuterJoinRule(),
                new QuantifiedApply2OuterJoinRule()
        ));

        REWRITE_RULES.put(RuleSetType.PRUNE_ASSERT_ROW, ImmutableList.of(
                new PruneAssertOneRowRule()
        ));

        REWRITE_RULES.put(RuleSetType.AGGREGATE_REWRITE, ImmutableList.of(
                new RewriteBitmapCountDistinctRule(),
                new RewriteHllCountDistinctRule(),
                new RewriteDuplicateAggregateFnRule(),
                new RewriteSimpleAggToMetaScanRule(),
                new RewriteSumByAssociativeRule(),
                new RewriteCountIfFunction()
        ));

        REWRITE_RULES.put(RuleSetType.PRUNE_PROJECT, ImmutableList.of(
                new PruneProjectRule(),
                new PruneProjectEmptyRule(),
                new MergeTwoProjectRule(),
                new PushDownProjectToCTEAnchorRule()
        ));

        REWRITE_RULES.put(RuleSetType.COLLECT_CTE, ImmutableList.of(
                new CollectCTEProduceRule(),
                new CollectCTEConsumeRule()
        ));

        REWRITE_RULES.put(RuleSetType.INLINE_CTE, ImmutableList.of(
                new InlineOneCTEConsumeRule(),
                new PruneCTEProduceRule()
        ));

        REWRITE_RULES.put(RuleSetType.INTERSECT_REWRITE, ImmutableList.of(
                new IntersectAddDistinctRule(),
                new ReorderIntersectRule()
        ));

        REWRITE_RULES.put(RuleSetType.SINGLE_TABLE_MV_REWRITE, ImmutableList.of(
                AggregateScanRule.getInstance(),
                OnlyScanRule.getInstance()
        ));

        REWRITE_RULES.put(RuleSetType.MULTI_TABLE_MV_REWRITE, ImmutableList.of(
                AggregateJoinRule.getInstance(),
                OnlyJoinRule.getInstance()
        ));

        REWRITE_RULES.put(RuleSetType.ALL_MV_REWRITE, Stream.concat(
                REWRITE_RULES.get(RuleSetType.MULTI_TABLE_MV_REWRITE).stream(),
                REWRITE_RULES.get(RuleSetType.SINGLE_TABLE_MV_REWRITE).stream())
                        .collect(Collectors.toList()));

        REWRITE_RULES.put(RuleSetType.PRUNE_EMPTY_OPERATOR, ImmutableList.of(
                PruneEmptyScanRule.OLAP_SCAN,
                PruneEmptyScanRule.HIVE_SCAN,
                PruneEmptyScanRule.HUDI_SCAN,
                PruneEmptyScanRule.ICEBERG_SCAN,
                PruneEmptyScanRule.PAIMON_SCAN,
                PruneEmptyScanRule.ODPS_SCAN,
                PruneEmptyJoinRule.JOIN_LEFT_EMPTY,
                PruneEmptyJoinRule.JOIN_RIGHT_EMPTY,
                new PruneEmptyDirectRule(),
                new PruneEmptyUnionRule(),
                new PruneEmptyIntersectRule(),
                new PruneEmptyExceptRule(),
                new PruneEmptyWindowRule()
        ));

        REWRITE_RULES.put(RuleSetType.SHORT_CIRCUIT_SET, ImmutableList.of(
                new PruneTrueFilterRule(),
                new PushDownPredicateProjectRule(),
                PushDownPredicateScanRule.OLAP_SCAN,
                new CastToEmptyRule(),
                new PruneProjectColumnsRule(),
                PruneScanColumnRule.OLAP_SCAN,
                new PruneProjectEmptyRule(),
                new MergeTwoProjectRule(),
                new PruneProjectRule(),
                new PartitionPruneRule(),
                new DistributionPruneRule()));
    }

    public RuleSet() {
        // Add common transform rule
        transformRules.add(SplitMultiPhaseAggRule.getInstance());
        transformRules.add(SplitTwoPhaseAggRule.getInstance());
        transformRules.add(GroupByCountDistinctDataSkewEliminateRule.getInstance());
        transformRules.add(SplitTopNRule.getInstance());
    }

    public void addJoinTransformationRules() {
        transformRules.add(JoinCommutativityRule.getInstance());
        transformRules.add(JoinAssociativityRule.INNER_JOIN_ASSOCIATIVITY_RULE);
    }

    public void addOuterJoinTransformationRules() {
        transformRules.add(JoinAssociativityRule.OUTER_JOIN_ASSOCIATIVITY_RULE);
        transformRules.add(JoinLeftAsscomRule.OUTER_JOIN_LEFT_ASSCOM_RULE);
    }

    public void addJoinCommutativityWithoutInnerRule() {
        transformRules.add(JoinCommutativityWithoutInnerRule.getInstance());
    }

    public void addCboTablePruneRule() {
        transformRules.add(CboTablePruneRule.getInstance());
    }

    public void addMultiTableMvRewriteRule() {
        transformRules.addAll(REWRITE_RULES.get(RuleSetType.MULTI_TABLE_MV_REWRITE));
    }

    public List<Rule> getTransformRules() {
        return transformRules;
    }

    public List<Rule> getImplementRules() {
        return implementRules;
    }

    public static List<Rule> getRewriteRulesByType(RuleSetType type) {
        return REWRITE_RULES.get(type);
    }

    public static List<Rule> getRewriteRulesByType(List<RuleSetType> types) {
        List<Rule> allRules = Lists.newArrayList();
        for (RuleSetType ruleSetType : types) {
            allRules.addAll(REWRITE_RULES.get(ruleSetType));
        }
        return allRules;
    }

    public void addRealtimeMVRules() {
        this.implementRules.add(StreamJoinImplementationRule.getInstance());
        this.implementRules.add(StreamAggregateImplementationRule.getInstance());
        this.implementRules.add(StreamScanImplementationRule.getInstance());
    }

    public void addHashJoinImplementationRule() {
        this.implementRules.add(HashJoinImplementationRule.getInstance());
    }

    public void addMergeJoinImplementationRule() {
        this.implementRules.add(MergeJoinImplementationRule.getInstance());
    }

    public void addNestLoopJoinImplementationRule() {
        this.implementRules.add(NestLoopJoinImplementationRule.getInstance());
    }

    public void addAutoJoinImplementationRule() {
        this.implementRules.add(HashJoinImplementationRule.getInstance());
        // TODO: implement merge join
        // this.implementRules.add(MergeJoinImplementationRule.getInstance());
        this.implementRules.add(NestLoopJoinImplementationRule.getInstance());
    }

    public void addSingleTableMvRewriteRule() {
        transformRules.addAll(getRewriteRulesByType(RuleSetType.SINGLE_TABLE_MV_REWRITE));
    }

}
