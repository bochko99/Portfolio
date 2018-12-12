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
import utils.ConstantHelper;
import utils.Environment;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class SpecStorage {


    public static RequestSpecification commonRequestSpec() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBaseUri(Environment.BASE_URL)
                .setBasePath(ConstantHelper.MOBILE)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }

    public static ResponseSpecification commonResponseSpec() {
        return new ResponseSpecBuilder()
                .expectBody(not(containsString("BadRequest")))
                .expectStatusCode(200)
                .build();
    }

}
