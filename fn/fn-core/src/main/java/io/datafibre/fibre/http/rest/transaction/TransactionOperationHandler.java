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

package io.datafibre.fibre.http.rest.transaction;

import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.http.BaseRequest;
import io.datafibre.fibre.http.BaseResponse;
import io.datafibre.fibre.http.rest.TransactionResult;
import io.datafibre.fibre.thrift.TNetworkAddress;

/**
 * Transaction management request handler.
 */
public interface TransactionOperationHandler {

    /**
     * Handle transaction management request.
     */
    ResultWrapper handle(BaseRequest request, BaseResponse response) throws UserException;

    class ResultWrapper {

        private final TransactionResult result;

        private final TNetworkAddress redirectAddress;

        public ResultWrapper(TransactionResult result) {
            this(result, null);
        }

        public ResultWrapper(TNetworkAddress redirectAddress) {
            this(null, redirectAddress);
        }

        public ResultWrapper(TransactionResult result, TNetworkAddress redirectAddress) {
            this.result = result;
            this.redirectAddress = redirectAddress;
        }

        public TransactionResult getResult() {
            return result;
        }

        public TNetworkAddress getRedirectAddress() {
            return redirectAddress;
        }
    }

}
