package tests;


import annotations.Financial;
import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojos.bankwithdrawal.BankWithdrawalReqOffer;
import pojos.bankwithdrawal.BankWithdrawalReqTransfer;
import pojos.bankwithdrawal.BankWithdrawalRespOffer;
import rules.FinancialAnnotationRule;
import utils.EndPoints;
import utils.Environment;

import java.math.BigDecimal;

import static core.Auth.auth;
import static core.Currency.*;


public class BankWithdrawalTest {

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
    @DisplayName(EndPoints.bankwithdrawals_banks + " GET")
    public void testBanks() {

        auth().queryParam("bic", "044525745").get(EndPoints.bankwithdrawals_banks);

    }

    @Test
    @DisplayName(EndPoints.bankwithdrawals_limits_rubank + " GET")
    public void testBanksLimitsRub() {

        auth().get(EndPoints.bankwithdrawals_limits_rubank);

    }

    @Test
    @DisplayName(EndPoints.bankwithdrawals_limits_countries + " GET")
    public void testBanksLimitsCountries() {

        auth().get(EndPoints.bankwithdrawals_limits_countries);

    }

    @Test
    @DisplayName(EndPoints.bankwithdrawals_rates_rubank + " GET")
    public void testBanksRates() {

        auth().queryParam("currency", BTC).get(EndPoints.bankwithdrawals_rates_rubank);

    }

    @Test
    @Financial
    @DisplayName("Create Bank Offer")
    public void createOffer() {

        BankWithdrawalReqOffer model = new BankWithdrawalReqOffer()
                .setAmount(new BigDecimal(1.0))
                .setCurrency(BTC);
        auth().body(model).post(EndPoints.bankwithdrawals_offers_rubank);

    }

    @Test
    @Financial
    @DisplayName("Create Bank Transfer")
    public void createTransfer() {

        BankWithdrawalReqOffer model = new BankWithdrawalReqOffer()
                .setAmount(new BigDecimal(1.0))
                .setCurrency(BTC);
        BankWithdrawalRespOffer offer = auth().body(model).post(EndPoints.bankwithdrawals_offers_rubank)
                .as(BankWithdrawalRespOffer.class);

        BankWithdrawalReqTransfer transfer = new BankWithdrawalReqTransfer()
                .setOfferId(offer.getId())
                .setTransferToMyself(true)
                .setAccountNumber("40817810123456789012")
                .setBankCorrAccountNumber("30101810345250000745")
                .setBic("044525745")
                .setPayeeFirstName("Тест")
                .setPayeeMiddleName("Тест")
                .setPayeeLastName("Тест");
        auth().body(transfer).post(EndPoints.bankwithdrawals_transfers_rubank);

    }
}
