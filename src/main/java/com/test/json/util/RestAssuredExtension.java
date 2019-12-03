package com.test.json.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

/**
 * TODO: Javadoc
 */
public final class RestAssuredExtension {

    public static RequestSpecification Request;

    public RestAssuredExtension() {
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        
        //Enable Test to run in Dev/Test environment
        String testEnv = System.getProperty("testEnv", "test");
        switch (testEnv.toLowerCase()) {
            case "test":
            case "default":
                builder.setBaseUri("https://jsonplaceholder.typicode.com/");
                break;

        }
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();

        try {
            RestAssured.useRelaxedHTTPSValidation();
            RestAssured.config().getSSLConfig().with().keyStore("classpath:keystore.p12", "password");


        } catch (Exception ex) {
            System.out.println("Error while loading keystore >>>>>>>>>");
            ex.printStackTrace();
        }
        
        Request = RestAssured.given().spec(requestSpec);

    }
    

    public static ResponseOptions<Response> PUTOpsWithBodyAndPathParams(String url, Map<String,String> body, Map<String,String> pathParams) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.put(url);
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body)  {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> PostOpsWithBody(String url,Object body)  {
        Request.body(body).log().all();
        return Request.post(url);
    }

    public static ResponseOptions<Response> GetWithQueryParams(String url, String queryParameters)  {
        Request.queryParam(queryParameters);
        return Request.get(url);
    }
    public static ResponseOptions<Response> GetWithPathParams(String url,Map<String, String> pathParams)  {
        Request.pathParams(pathParams).log().all();
        
        return Request.get(url);
    }

    public static ResponseOptions<Response> getOperation(String url )  {
        Request.log().all();

        return Request.get(url);
    }

 
}