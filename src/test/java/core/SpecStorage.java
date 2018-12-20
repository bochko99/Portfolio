package core;

import io.qameta.allure.restassured.AllureRestAssured;
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
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
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

    public static RequestSpecification commonRequestSpec() {
        return commonRequestSpec;
    }

    public static ResponseSpecification commonResponseSpec() {
        return commonResponseSpec;
    }

}
