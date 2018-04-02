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

package org.wso2.identity.test.bal;

import org.ballerinalang.launcher.LauncherUtils;
import org.ballerinalang.launcher.util.BCompileUtil;
import org.ballerinalang.launcher.util.BRunUtil;
import org.ballerinalang.launcher.util.CompileResult;
import org.ballerinalang.model.values.BStringArray;
import org.ballerinalang.model.values.BValue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class BallerinaLauncher {

    public static void main2(String[] args) {

        CompileResult compileResult = BCompileUtil
                .compile("/Users/ruwan/Dev/wso2/product-is/5.6.0/bal-include/src/main/resources/hello-world.bal");

        BStringArray bArgs = new BStringArray();
        BRunUtil.invoke(compileResult, "main", new BValue[]{bArgs});

    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.manager", "org.ballerinalang.logging.BLogManager");
        Path sourceRootPath = Paths.get("/Users/ruwan/Dev/wso2/product-is/5.6.0/bal-include/modules/com.wso2.carbon.wso2identity.integration.ballerina/src/main/resources");
        Path helloServicePath = Paths
                .get("/Users/ruwan/Dev/wso2/product-is/5.6.0/bal-include/modules/com.wso2.carbon.wso2identity.integration.ballerina/src/main/resources/hello-service.bal");
        Map<String, String> runtimeParams = new HashMap<String, String>();
        Path configFilePath = Paths
                .get("/Users/ruwan/Dev/wso2/product-is/5.6.0/bal-include/modules/com.wso2.carbon.wso2identity.integration.ballerina/src/main/resources/config.yml");
        boolean offline = true;

//        LauncherUtils
//                .runProgram(sourceRootPath, helloWorldPath, false, runtimeParams, configFilePath.toString(), new String[0],
//                        offline);
        LauncherUtils
                .runProgram(sourceRootPath, helloServicePath, true, runtimeParams, configFilePath.toString(), new String[0],
                        offline);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
