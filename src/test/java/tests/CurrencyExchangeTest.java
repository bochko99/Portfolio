package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojos.exchange.ExchangeOfferReqModel;
import rules.FinancialAnnotationRule;
import utils.EndPoints;
import utils.Environment;

import java.math.BigDecimal;

import static core.Auth.auth;
import static core.Currency.*;


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
    @DisplayName(EndPoints.currencyexchange_directions + " GET")
    public void currencyExchangeDirection() {

        auth().get(EndPoints.currencyexchange_directions);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_offers + " POST")
    public void currencyExchangeOffers() {
        ExchangeOfferReqModel model = new ExchangeOfferReqModel()
                .setAmount(new BigDecimal(0.0))
                .setAmountKind("SourceAmount")
                .setSourceCurrencyCode(ETH)
                .setTargetCurrencyCode(BTC);

        auth().body(model).post(EndPoints.currencyexchange_offers);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_transfers + " POST")
    public void currencyExchangeTransfers() {

        auth().post(EndPoints.currencyexchange_transfers);

    }

}
