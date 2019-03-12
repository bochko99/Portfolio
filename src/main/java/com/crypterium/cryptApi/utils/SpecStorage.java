package com.crypterium.cryptApi.utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HeaderConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class SpecStorage {

    static {
        RestAssured.requestSpecification = RestAssured.given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .filter(new AllureRestAssured());
    }

    private static final RequestSpecification commonRequestSpec = new RequestSpecBuilder()
            .setConfig(RestAssured.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("User-Agent", "Content-Type")))
            .setAccept("application/json")
            .setContentType("application/json")
            .addHeader("X-PlatformId", "7B5237A5-996B-43BB-B9A5-747E32A3BCA5")
            .addHeader("X-AppId", "7B5237A5-996B-43BB-B9A5-747E32A3BCA5")
            .addHeader("User-Agent", "Crypterium/1.7.0(iPhone;12.1):x86_64")
            .setBaseUri(Environment.BASE_URL)
            .setBasePath(Constants.MOBILE)
            .build();

    private static final ResponseSpecification commonResponseSpec = new ResponseSpecBuilder()
            .expectBody(not(containsString("BadRequest")))
            .expectStatusCode(Matchers.isOneOf(200, 201))
            .build();

    private static final RequestSpecification glRequest = new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .setBaseUri(Environment.GL_URL)
            .setBasePath(Constants.GL_EXTERNAL)
            .addHeader("Authorization", Environment.GL_TOKEN)
            .build();

    private static final RequestSpecification managementRequest = new RequestSpecBuilder()
            .setAccept("application/json")
            .setContentType("application/json")
            .setBaseUri(Environment.MANAGEMENT_URL)
            .setBasePath(Constants.MANAGEMENT)
            .build();

    private static final RequestSpecification exwalRequest = new RequestSpecBuilder()
            .setConfig(RestAssured.config().headerConfig(HeaderConfig.headerConfig()
                    .overwriteHeadersWithName("Authorization", "Content-Type")))
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .addHeader("Authorization", "Basic ZG9jOnNlY3JldA==")
            .setBaseUri(Environment.EXWAL_BASE_URL)
            .setBasePath(Constants.EXWAL_BASE)
            .build();

    private static final RequestSpecification oAuth = new RequestSpecBuilder()
            .addHeader("Authorization", "Basic ZG9jOnNlY3JldA==")
            .setBaseUri(Environment.EXWAL_BASE_URL)
            .setBasePath(Constants.EXWAL_OAUTH)
            .build();

    private static final RequestSpecification banks = new RequestSpecBuilder()
            .setBaseUri(Environment.BANKS_BASE_URL)
            .setBasePath(Constants.BANKS_BASE)
            .build();


    public static RequestSpecification commonRequestSpec() {
        return commonRequestSpec;
    }

    public static ResponseSpecification commonResponseSpec() {
        return commonResponseSpec;
    }

    public static RequestSpecification gl() {
        return RestAssured.given().spec(glRequest);
    }

    public static RequestSpecification management() {
        return RestAssured.given().spec(managementRequest);
    }

    public static RequestSpecification exwal(){return RestAssured.given().spec(exwalRequest);}

    public static RequestSpecification exwalOauth(){return  RestAssured.given().spec(oAuth);}

    public static RequestSpecification banks() {
        return RestAssured.given().spec(banks);
    }
}
