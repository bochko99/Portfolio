package core;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import utils.Constants;
import utils.Environment;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class SpecStorage {

    private static final RequestSpecification commonRequestSpec = new RequestSpecBuilder()
            .setAccept("application/json")
            .setContentType("application/json")
            .addHeader("X-PlatformId", "7B5237A5-996B-43BB-B9A5-747E32A3BCA5")
            .addHeader("X-AppId", "7B5237A5-996B-43BB-B9A5-747E32A3BCA5")
            .addHeader("User-Agent", "Crypterium/1.7.0(iPhone;12.1):x86_64")
            .setBaseUri(Environment.BASE_URL)
            .setBasePath(Constants.MOBILE)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .addFilter(new AllureRestAssured())
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
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .addFilter(new AllureRestAssured())
            .build();

    private static final RequestSpecification managementRequest = new RequestSpecBuilder()
            .setAccept("application/json")
            .setContentType("application/json")
            .setBaseUri(Environment.MANAGEMENT_URL)
            .setBasePath(Constants.MANAGEMENT)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .addFilter(new AllureRestAssured())
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
}
