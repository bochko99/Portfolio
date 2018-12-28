package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojos.exchange.ExchangeOfferReqModel;
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

        auth().get(EndPoints.currencyexchange_directions_path);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_offers_path + " POST")
    public void currencyExchangeOffers() {
        ExchangeOfferReqModel model = new ExchangeOfferReqModel()
                .setAmount(0L)
                .setAmountKind("SourceAmount")
                .setSourceCurrencyCode("BTC")
                .setTargetCurrencyCode("ETH");

        auth().body(model).post(EndPoints.currencyexchange_offers_path);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_transfers_path + " POST")
    public void currencyExchangeTransfers() {

        auth().post(EndPoints.currencyexchange_transfers_path);

    }

}
