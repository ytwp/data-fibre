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

package io.datafibre.fibre.common.proc;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import io.datafibre.fibre.alter.SchemaChangeHandler;
import io.datafibre.fibre.analysis.BinaryPredicate;
import io.datafibre.fibre.analysis.BinaryType;
import io.datafibre.fibre.analysis.DateLiteral;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.LimitElement;
import io.datafibre.fibre.analysis.StringLiteral;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.util.ListComparator;
import io.datafibre.fibre.common.util.OrderByPair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class OptimizeProcDir implements ProcDirInterface {
    public static final ImmutableList<String> TITLE_NAMES = new ImmutableList.Builder<String>()
            .add("JobId").add("TableName").add("CreateTime").add("FinishTime")
            .add("Operation")
            .add("TransactionId").add("State").add("Msg").add("Progress").add("Timeout")
            .build();

    private static final Logger LOG = LogManager.getLogger(OptimizeProcDir.class);

    private SchemaChangeHandler schemaChangeHandler;
    private Database db;

    public OptimizeProcDir(SchemaChangeHandler schemaChangeHandler, Database db) {
        this.schemaChangeHandler = schemaChangeHandler;
        this.db = db;
    }

    public List<List<Comparable>> getOptimizeJobInfos() {
        return schemaChangeHandler.getOptimizeJobInfosByDb(db);
    }

    boolean filterResult(String columnName, Comparable element, HashMap<String, Expr> filter) throws AnalysisException {
        if (filter == null) {
            return true;
        }
        Expr subExpr = filter.get(columnName.toLowerCase());
        if (subExpr == null) {
            return true;
        }
        BinaryPredicate binaryPredicate = (BinaryPredicate) subExpr;
        if (subExpr.getChild(1) instanceof StringLiteral && binaryPredicate.getOp() == BinaryType.EQ) {
            return ((StringLiteral) subExpr.getChild(1)).getValue().equals(element);
        }
        if (subExpr.getChild(1) instanceof DateLiteral) {
            Long leftVal = (new DateLiteral((String) element, Type.DATETIME)).getLongValue();
            Long rightVal = ((DateLiteral) subExpr.getChild(1)).getLongValue();
            switch (binaryPredicate.getOp()) {
                case EQ:
                case EQ_FOR_NULL:
                    return leftVal.equals(rightVal);
                case GE:
                    return leftVal >= rightVal;
                case GT:
                    return leftVal > rightVal;
                case LE:
                    return leftVal <= rightVal;
                case LT:
                    return leftVal < rightVal;
                case NE:
                    return !leftVal.equals(rightVal);
                default:
                    Preconditions.checkState(false, "No defined binary operator.");
            }
        }
        return true;
    }

    public ProcResult fetchResultByFilter(HashMap<String, Expr> filter, ArrayList<OrderByPair> orderByPairs,
                                          LimitElement limitElement) throws AnalysisException {
        Preconditions.checkNotNull(db);
        Preconditions.checkNotNull(schemaChangeHandler);

        List<List<Comparable>> schemaChangeJobInfos = getOptimizeJobInfos();

        //where
        List<List<Comparable>> jobInfos;
        if (filter == null || filter.size() == 0) {
            jobInfos = schemaChangeJobInfos;
        } else {
            jobInfos = Lists.newArrayList();
            for (List<Comparable> infoStr : schemaChangeJobInfos) {
                if (infoStr.size() != TITLE_NAMES.size()) {
                    LOG.warn("SchemaChangeJobInfos.size() " + schemaChangeJobInfos.size()
                            + " not equal TITLE_NAMES.size() " + TITLE_NAMES.size());
                    continue;
                }
                boolean isNeed = true;
                for (int i = 0; i < infoStr.size(); i++) {
                    isNeed = filterResult(TITLE_NAMES.get(i), infoStr.get(i), filter);
                    if (!isNeed) {
                        break;
                    }
                }
                if (isNeed) {
                    jobInfos.add(infoStr);
                }
            }
        }

        // order by
        if (orderByPairs != null) {
            ListComparator<List<Comparable>> comparator = null;
            OrderByPair[] orderByPairArr = new OrderByPair[orderByPairs.size()];
            comparator = new ListComparator<List<Comparable>>(orderByPairs.toArray(orderByPairArr));
            Collections.sort(jobInfos, comparator);
        }

        //limit
        if (limitElement != null && limitElement.hasLimit()) {
            int beginIndex = (int) limitElement.getOffset();
            int endIndex = (int) (beginIndex + limitElement.getLimit());
            if (endIndex > jobInfos.size()) {
                endIndex = jobInfos.size();
            }
            jobInfos = jobInfos.subList(beginIndex, endIndex);
        }

        BaseProcResult result = new BaseProcResult();
        result.setNames(TITLE_NAMES);
        for (List<Comparable> jobInfo : jobInfos) {
            List<String> oneResult = new ArrayList<String>(jobInfos.size());
            for (Comparable column : jobInfo) {
                oneResult.add(column.toString());
            }
            result.addRow(oneResult);
        }
        return result;
    }

    @Override
    public ProcResult fetchResult() throws AnalysisException {
        Preconditions.checkNotNull(db);
        Preconditions.checkNotNull(schemaChangeHandler);

        BaseProcResult result = new BaseProcResult();
        result.setNames(TITLE_NAMES);

        List<List<Comparable>> schemaChangeJobInfos = getOptimizeJobInfos();
        for (List<Comparable> infoStr : schemaChangeJobInfos) {
            List<String> oneInfo = new ArrayList<String>(TITLE_NAMES.size());
            for (Comparable element : infoStr) {
                oneInfo.add(element.toString());
            }
            result.addRow(oneInfo);
        }
        return result;
    }

    public static int analyzeColumn(String columnName) throws AnalysisException {
        for (int i = 0; i < TITLE_NAMES.size(); ++i) {
            if (TITLE_NAMES.get(i).equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        throw new AnalysisException("Title name[" + columnName + "] does not exist");
    }

    @Override
    public boolean register(String name, ProcNodeInterface node) {
        return false;
    }

    @Override
    public ProcNodeInterface lookup(String jobIdStr) throws AnalysisException {
        throw new AnalysisException("Not support");
    }
}
