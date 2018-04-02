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

package org.wso2.carbon.identity.integration.c4b7a.is;

import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BlockingNativeCallableUnit;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BStringArray;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;
import org.wso2.carbon.identity.application.common.model.IdentityProvider;
import org.wso2.carbon.idp.mgt.IdentityProviderManagementException;
import org.wso2.carbon.idp.mgt.IdentityProviderManager;

import java.util.ArrayList;
import java.util.List;

@BallerinaFunction(orgName = "wso2",
                   packageName = "wso2identity.idp",
                   functionName = "idpList",
                   args = { @Argument(name = "tenantName", type = TypeKind.STRING) },
                   returnType = { @ReturnType(type = TypeKind.ARRAY, elementType = TypeKind.STRING) },
                   isPublic = true)
public class IdpListFn extends BlockingNativeCallableUnit {

    public void execute(Context ctx) {

        String tenantName = ctx.getStringArgument(0);
        ctx.setReturnValues(new BStringArray(getIdpNames(tenantName).toArray(new String[0])));
    }

    private List<String> getIdpNames(String tenantName) {

        List<String> result = new ArrayList<>();
        List<IdentityProvider> identityProviders = null;
        try {
            identityProviders = IdentityProviderManager.getInstance().getIdPs(tenantName);
        } catch (IdentityProviderManagementException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < identityProviders.size(); i++) {
            String providerName = identityProviders.get(i).getIdentityProviderName();
            result.add(providerName);
        }
        return result;
    }
}