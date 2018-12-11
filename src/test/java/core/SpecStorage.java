package core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
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
                .build();
    }

    public static ResponseSpecification commonResponseSpec() {
        return new ResponseSpecBuilder()
                .expectBody(not(containsString("Bad request")))
                .expectStatusCode(200)
                .build();
    }

}
