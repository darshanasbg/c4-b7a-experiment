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

package org.wso2.carbon.identity.integration.ballerina.rt;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BallerinaServiceHostTest {

    @BeforeClass
    public void setup() {

        System.setProperty("java.util.logging.manager", "org.ballerinalang.logging.BLogManager");
    }

    public static void main(String[] args) throws Exception {

        BallerinaServiceHostTest test = new BallerinaServiceHostTest();
        test.testStart();
    }

    @Test
    public void testStart() throws Exception {

        Path path = Paths
                .get("/Users/ruwan/Dev/wso2/product-is/5.6.0/bal-include/modules/org.wso2.carbon.identity.integration.ballerina/src/test/resources/ballerina");
        BallerinaServiceHost ballerinaServiceHost = new BallerinaServiceHost(path);

        ballerinaServiceHost.start();

        Thread.sleep(10000);
    }

    @Test
    public void testStop() throws Exception {

    }

    @Test
    public void testLoadPrograms() throws Exception {

    }

    @Test
    public void testStartBallerinaRuntime() throws Exception {

    }
}