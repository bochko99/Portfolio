package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import rules.FinancialAnnotationRule;
import utils.EndPoints;
import utils.Environment;

import static core.Auth.auth;

public class CurrencyExchangeTest {

    @Rule
    public FinancialAnnotationRule annotation = new FinancialAnnotationRule();


    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Before
    public void checkSkipNeed() {
        Assume.assumeTrue(annotation.getAnnotation() == null
                || "true".equalsIgnoreCase(Environment.FINANCE_OPERATIONS_ALLOWED));
    }

    @Test
    @DisplayName(EndPoints.currencyexchange_directions_path + " GET")
    public void currencyExchangeDirection() {

        auth().pathParam("path", "").get(EndPoints.currencyexchange_directions_path);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_offers_path + " POST")
    public void currencyExchangeOffers() {

        auth().pathParam("path", "").post(EndPoints.currencyexchange_offers_path);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_transfers_path + " POST")
    public void currencyExchangeTransfers() {

        auth().pathParam("path", "").post(EndPoints.currencyexchange_transfers_path);

    }

}
