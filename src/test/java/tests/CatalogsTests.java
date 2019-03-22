package tests;

import com.crypterium.cryptApi.pojos.catalogs.FaqItem;
import com.crypterium.cryptApi.pojos.catalogs.FaqItemCode;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import tests.core.ExwalTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class CatalogsTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.catalog_comissions + " GET")
    public void testComissions() {
        given().get(EndPoints.catalog_comissions);
    }


    @Test
    @DisplayName(EndPoints.catalog_countries + " GET")
    public void testCountry() {
        given().get(EndPoints.catalog_countries);
    }


    @Test
    @DisplayName(EndPoints.catalog_currencies + " GET")
    public void testCurrencies() {
        given().get(EndPoints.catalog_currencies);
    }

    @Test
    @DisplayName(EndPoints.catalog_faq + " GET")
    @Description("Asserts that all codes are present and items size for each code is greater than zero")
    public void testFAQ() {
        Object[] codes = Stream.of(FaqItemCode.values()).map(FaqItemCode::getValue).toArray();
        List<FaqItem> items = Arrays.asList(given().get(EndPoints.catalog_faq).then().body("code", containsInAnyOrder(codes)).extract().as(FaqItem[].class));
        items.forEach(item -> assertThat(item.getFaqQuestionItems().size(), Matchers.greaterThan(0)));
    }

    @Test
    @DisplayName(EndPoints.catalogs_operations + " GET")
    public void testOperations() {
        given().get(EndPoints.catalogs_operations);
    }


}
