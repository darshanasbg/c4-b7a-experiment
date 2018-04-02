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

package org.wso2.carbon.identity.integration.c4b7a.internal;

import org.ballerinalang.annotation.JavaSPIService;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.natives.NativeElementRepository;
import org.ballerinalang.spi.NativeElementProvider;

@JavaSPIService("org.ballerinalang.spi.NativeElementProvider")
public class OsgiSpiNativeElementProvider implements NativeElementProvider {

    @Override
    public void populateNatives(NativeElementRepository repo) {

        repo.registerNativeFunction(new NativeElementRepository.NativeFunctionDef("wso2", "identity.probe2", "echo",
                new TypeKind[] { TypeKind.STRING }, new TypeKind[] { TypeKind.STRING },
                "org.wso2.carbon.identity.integration.c4b7a.internal.Echo"));
        repo.registerNativeFunction(new NativeElementRepository.NativeFunctionDef("wso2", "identity.probe", "echo",
                new TypeKind[] { TypeKind.STRING }, new TypeKind[] { TypeKind.STRING },
                "org.wso2.carbon.identity.integration.c4b7a.internal.Echo"));

        for (NativeElementRepository.NativeFunctionDef def : BallerinaFunctionRegistrationImpl.getInstance()
                .listRegistrations()) {
            repo.registerNativeFunction(def);
        }
    }
}
