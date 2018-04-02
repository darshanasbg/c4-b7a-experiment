package wso2identity;

import ballerina/mime;
import ballerina/net.http;
import wso2/identity.probe;



@http:ServiceConfig {basePath:"/idp"}
service<http:Service> idpMgt bind idpMgtEP {

    @http:ResourceConfig {
        methods:["GET"],
        path:"/list"
    }
    list (endpoint conn, http:Request req) {
        http:Response res = {};
        string result = probe:echo("Helooo");
        res.setStringPayload("I received "+result);
        _ = conn -> respond(res);
    }
}