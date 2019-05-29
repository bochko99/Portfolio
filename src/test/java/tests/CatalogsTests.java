package tests;

import com.crypterium.cryptApi.pojos.catalogs.FaqItem;
import com.crypterium.cryptApi.pojos.catalogs.FaqItemCode;
import com.crypterium.cryptApi.utils.EndPoints;
import core.TestScope;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@Epic(TestScope.REGRESS)
@Feature("Catalogs")
public class CatalogsTests extends ExwalTest {


    @Story("Catalog: commissions")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testComissions() {
        given().get(EndPoints.catalog_comissions).then().body("size()", Matchers.greaterThan(0));
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("Catalog: countries")
    @Test
    @DisplayName(EndPoints.catalog_countries + " GET")
    public void testCountry() {
        given().get(EndPoints.catalog_countries).then().body("size()", Matchers.greaterThan(0));
    }


    @Severity(SeverityLevel.BLOCKER)
    @Story("Catalog: currencies")
    @Test
    @DisplayName(EndPoints.catalog_currencies + " GET")
    public void testCurrencies() {
        given().get(EndPoints.catalog_currencies).then().body("size()", Matchers.greaterThan(0));
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Catalog: faq")
    @Test
    @DisplayName(EndPoints.catalog_faq + " GET")
    @Description("Asserts that all codes are present and items size for each code is greater than zero")
    public void testFAQ() {
        Object[] codes = Stream.of(FaqItemCode.values()).map(FaqItemCode::getValue).toArray();
        List<FaqItem> items = Arrays.asList(given().get(EndPoints.catalog_faq).then().body("code", containsInAnyOrder(codes)).extract().as(FaqItem[].class));
        items.forEach(item -> assertThat(item.getFaqQuestionItems().size(), Matchers.greaterThan(0)));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Catalog: operations")
    @Test
    @DisplayName(EndPoints.catalogs_operations + " GET")
    public void testOperations() {
        given().get(EndPoints.catalogs_operations).then().body("size()", Matchers.greaterThan(0));
    }


}
