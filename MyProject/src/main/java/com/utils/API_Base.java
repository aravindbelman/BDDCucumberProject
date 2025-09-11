package com.utils;

import io.restassured.*;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.core.util.JsonUtils;
import io.restassured.http.*;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;

public class API_Base {

    public String token = "";
    public JsonUtils jsn = new JsonUtils();
    //public Commons co = new Commons();

    public String getAccessToken(String env) throws IOException {
        Header h1 = new Header("Content-Type", "application/x-www-form-urlencoded");
        Header h2 = new Header("User-Agent", "PostmanRuntime/7.28.4");
        Header h3 = new Header("Accept", "*/*");
        Header h4 = new Header("Accept-Encoding", "gzip, deflate, br");
        Header h5 = new Header("Connection", "keep-alive");

        RestAssured.config = RestAssured.config()
                .sslConfig(new SSLConfig().with()
                        .keyStore("./Resources/certificates/payments.npd.combiz.cba.pfx",
                                 "X-SSL-Client-Cert")
                        .keystoreType("pcks12")
                        .trustStore("./Resources/certificates/truststore.jks", "changeit")
                        .trustStoreType("jks"));
        String url = "baseurl";

        RequestSpecification req = given().header(h1).header(h2).header(h3).header(h4).header(h5).contentType("application/xwww.-form-urlencoded")
                .formParam("client_id", "provideclientid")
                .formParam("client_secret", "provideclientsecret")
                .formParam("scope", "providescope")
                .formParam("client_assertion_type", "provideclientassertiontype")
                .formParam("client_assertion", "provideclientassertion")
                .formParam("grant_type", "providegranttype");
        Response response = req.post(url);
        int status_code = response.getStatusCode();
        String res = response.asString();
        String b = response.getBody().asString();
        token = response.jsonPath().getString("access_token");
        System.out.println("Status code for JWT posting: " + status_code);
        System.out.println("Access token: " + token);
        return token;
    }

    public String clientAssertion(String env) {
        String token = "";
        try (FileInputStream fileInputStream = new FileInputStream("./Resources/API/preRequestScript.js");
             BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("graal.js");

            byte[] bytes = Files.readAllBytes(Paths.get("./Resources/API/jsrsassign.txt"));
            String src;
            src = new String(bytes);
            engine.eval(reader);
            Invocable invocableEngine = (Invocable) engine;
            String clientId = "provideclient_id";
            String privateKey = "provideprivateKey";

            System.out.println("privateKey : " + privateKey);
            Object object = invocableEngine.invokeFunction("myfn", src, clientId, privateKey);
            token = object.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Creating Client Assertion");
        }

        System.out.println("Client assertion token: " + token);
        if (token.isEmpty())
            return "Unable to Generate";
        else
            return token;
    }

    public Response postRequest(String jsonfilepath, String post_url) throws IOException, ParseException {
        System.out.println("starting postrequest method");
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().with().keyStore("./Resources/Certificates/payment.jks", "pkcs12")
                .trustStore("./Resources/Certificates/truststore.jks", "Password01")
                .trustStoreType("jks"));

        Header h10 = new Header("Authorization", "Bearer " + token);
        Header h11 = new Header("Content-Type", "application/json");
        Header h12 = new Header("Accept", "*/*");

        Response res = given().config(RestAssured.config()).header(h10).header(h11).header(h12)
                .body("provideJsonBody").when().post(post_url);

        int status_code = res.getStatusCode();
        System.out.println("Post Status Code from ROM : " + status_code);
        return res;
    }
    public String getRequest_withoutAuthentication(String url) throws IOException, ParseException {
        Header h11 = new Header("Content-Type", "application/json");
        Header h12 = new Header("Accept", "*/*");

        Response res = given().relaxedHTTPSValidation().when().get(url);
        io.restassured.path.json.JsonPath jsPath = res.jsonPath();

        int status_code = res.getStatusCode();
        System.out.println("get Status Code for request : " + status_code);

        return res.prettyPrint();
    }
    public String getTagValue_fromJson(String uri, String tag) throws IOException, ParseException {
        Header h11 = new Header("Content-Type", "application/json");
        Header h12 = new Header("Accept", "*/*");

        Response res = given().relaxedHTTPSValidation().when().get(uri);
        io.restassured.path.json.JsonPath jsonPath = res.jsonPath();
        String tag_value = jsonPath.getString(tag);

        return tag_value;
    }

    public void get_Response_from_json(String uri, String json_response_path) throws IOException, ParseException {
        Header h11 = new Header("Content-Type", "application/json");
        Header h12 = new Header("Accept", "*/*");

        Response res = given().relaxedHTTPSValidation().when().get(uri);
        //js.writeJson(json_response_path, res.prettyPrint().toString());
    }

}

