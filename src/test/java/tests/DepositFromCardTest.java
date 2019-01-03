package tests;

import annotations.Financial;
import core.Auth;
import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.*;
import pojos.LoginModel;
import pojos.deposit.DepositReqOfferModel;
import pojos.deposit.DepositReqTransferModel;
import pojos.deposit.DepositRespOfferModel;
import pojos.deposit.Order;
import rules.FinancialAnnotationRule;
import utils.EndPoints;
import utils.Environment;

import java.math.BigDecimal;

import static core.Auth.auth;

import static core.Currency.*;
import static io.restassured.RestAssured.given;

public class DepositFromCardTest {

    @Rule
    public FinancialAnnotationRule annotation = new FinancialAnnotationRule();


    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();

        auth("79854430122", "12re8876");

    }

    @Test
    public void Test(){
        given().body(new LoginModel().setLogin("79854430122").setPassword("12re8876").setCode("33948")).post(EndPoints.users_login_verify);
    }

    @Before
    public void checkSkipNeed() {
        Assume.assumeTrue(annotation.getAnnotation() == null
                || "true".equalsIgnoreCase(Environment.FINANCE_OPERATIONS_ALLOWED));
    }

    @Test
    @DisplayName(EndPoints.depositfromcard_limits + " GET")
    public void testDepositFromCardLimits() {
        auth().get(EndPoints.depositfromcard_limits);
    }

    @Test
    @DisplayName(EndPoints.depositfromcard_success + " GET")
    public void testDepositFromCardSuccess() {
        auth().get(EndPoints.depositfromcard_success);
    }

    @Test
    @DisplayName(EndPoints.depositfromcard_failed + " GET")
    public void testDepositFromCardFailed() {
        auth().get(EndPoints.depositfromcard_failed);
    }

    @Test
    @DisplayName("Create new Offer")
    public void testCreateOffer() {

        createOffer();

    }

    @Test

    @DisplayName("Create transfer")
    public void testCreateTransfer() {

        DepositRespOfferModel offer = createOffer();

        DepositReqTransferModel transfer = new DepositReqTransferModel()
                .setOfferId(offer.getId())
                .setPan("4200000000000000")
                .setHolder("TEST TEST")
                .setExpiredAt("202312")
                .setCvv("369");

        auth().body(transfer).post(EndPoints.depositfromcard_transfers);


    }

    @Test
    @DisplayName("Create redirect")
    public void createRedirect() {
        DepositRespOfferModel offer = createOffer();

        DepositReqTransferModel transfer = new DepositReqTransferModel()
                .setOfferId(offer.getId())
                .setPan("4711100000000000")
                .setHolder("TEST TEST")
                .setExpiredAt("202312")
                .setCvv("369");
        String id = auth().body(transfer).post(EndPoints.depositfromcard_transfers).then()
                .body("status", Matchers.equalTo("Redirect"))
                .extract().body().jsonPath().getString("id");
        //DepositRespTransferModel mod = auth().body(transfer).post(EndPoints.depositfromcard_transfers).as(DepositRespTransferModel.class);
        auth().pathParam("id", id).get(EndPoints.depositfromcard_redirect_id);
//        Auth.flush();


    }
    @AfterClass
    public static void stop(){
        Auth.flush();
    }

    public DepositRespOfferModel createOffer(){

        Order order = new Order()
                .setAmount(new BigDecimal(0.2))
                .setCurrency(LTC);
        DepositReqOfferModel model = new DepositReqOfferModel()
                .setOrder(order);

        return auth().body(model).post(EndPoints.depositfromcard_offers).as(DepositRespOfferModel.class);

    }

}
