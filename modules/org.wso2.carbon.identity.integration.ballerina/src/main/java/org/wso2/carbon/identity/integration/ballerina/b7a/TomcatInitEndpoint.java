/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.integration.ballerina.b7a;

import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BlockingNativeCallableUnit;
import org.ballerinalang.connector.api.BLangConnectorSPIUtil;
import org.ballerinalang.connector.api.Struct;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.Receiver;
import org.ballerinalang.net.http.HttpConstants;
import org.ballerinalang.net.http.HttpUtil;

@BallerinaFunction(orgName = "wso2",
                   packageName = "identity.tomcat",
                   functionName = "tomcatInitEndpoint",
                   receiver = @Receiver(type = TypeKind.STRUCT,
                                        structType = "WebSocketClient",
                                        structPackage = "ballerina.net.http"),
                   args = { @Argument(name = "epName", type = TypeKind.STRING),
                           @Argument(name = "config",
                                    type = TypeKind.STRUCT,
                                    structType = "ServiceEndpointConfiguration") },
                   isPublic = true)
public class TomcatInitEndpoint extends BlockingNativeCallableUnit {

    @Override
    public void execute(Context context) {

        try {
            Struct serviceEndpoint = BLangConnectorSPIUtil.getConnectorEndpointStruct(context);

            // Creating server connector
            Struct serviceEndpointConfig = serviceEndpoint.getStructField(HttpConstants.SERVICE_ENDPOINT_CONFIG);

            context.setReturnValues((BValue) null);
        } catch (Throwable throwable) {
            BStruct errorStruct = HttpUtil.getHttpConnectorError(context, throwable);
            context.setReturnValues(errorStruct);
        }

    }
}
