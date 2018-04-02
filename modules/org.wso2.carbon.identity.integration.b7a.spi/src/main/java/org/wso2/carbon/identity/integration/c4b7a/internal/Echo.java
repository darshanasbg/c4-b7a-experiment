package org.wso2.carbon.identity.integration.c4b7a.internal;

import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BlockingNativeCallableUnit;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

@BallerinaFunction(orgName = "wso2",
                   packageName = "identity.probe",
                   functionName = "echo",
                   args = { @Argument(name = "echo", type = TypeKind.STRING) },
                   returnType = { @ReturnType(type = TypeKind.STRING) },
                   isPublic = true)
public class Echo extends BlockingNativeCallableUnit {

    public void execute(Context ctx) {

        String inString = ctx.getStringArgument(0);
        ctx.setReturnValues(new BString("Echo >>> " + inString + "\n"));
    }
}