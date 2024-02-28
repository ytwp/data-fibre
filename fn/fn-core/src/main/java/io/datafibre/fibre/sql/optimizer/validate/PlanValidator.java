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

package io.datafibre.fibre.sql.optimizer.validate;

import com.google.common.collect.ImmutableList;
import io.datafibre.fibre.common.profile.Timer;
import io.datafibre.fibre.common.profile.Tracers;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.common.ErrorType;
import io.datafibre.fibre.sql.common.StarRocksPlannerException;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.task.TaskContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class PlanValidator {

    private static final Logger LOGGER = LogManager.getLogger(PlanValidator.class);

    private static final PlanValidator INSTANCE = new PlanValidator();

    private final List<Checker> checkerList;

    private PlanValidator() {
        checkerList = ImmutableList.of(
                InputDependenciesChecker.getInstance(),
                TypeChecker.getInstance(),
                CTEUniqueChecker.getInstance(),
                ColumnReuseChecker.getInstance());
    }

    public static PlanValidator getInstance() {
        return INSTANCE;
    }

    public void validatePlan(OptExpression optExpression, TaskContext taskContext) {
        boolean enablePlanValidation = ConnectContext.get().getSessionVariable().getEnablePlanValidation();
        try {
            for (Checker checker : checkerList) {
                try (Timer tracer = Tracers.watchScope(checker.getClass().getSimpleName())) {
                    checker.validate(optExpression, taskContext);
                }
            }
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            if (!message.contains("Invalid plan")) {
                message = "Invalid plan:\n" + optExpression.debugString() + message;
            }
            LOGGER.debug("Failed to validate plan.", e);
            if (enablePlanValidation) {
                throw new StarRocksPlannerException(message, ErrorType.INTERNAL_ERROR);
            }
        } catch (StarRocksPlannerException e) {
            LOGGER.debug("Failed to validate plan.", e);
            if (enablePlanValidation) {
                throw e;
            }
        } catch (Exception e) {
            LOGGER.debug("Failed to validate plan.", e);
            if (enablePlanValidation) {
                throw new StarRocksPlannerException("encounter exception when validate plan.", ErrorType.INTERNAL_ERROR);
            }
        }
    }

    public interface Checker {
        void validate(OptExpression physicalPlan, TaskContext taskContext);
    }
}
