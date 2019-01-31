package tests;

import core.Auth;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Test;
import pojos.deposit.DepositReqOfferModel;
import pojos.deposit.DepositReqTransferModel;
import pojos.deposit.DepositRespOfferModel;
import pojos.deposit.Order;
import utils.EndPoints;

import java.math.BigDecimal;

import static core.Auth.auth;

public class DepositFromCardTest extends BaseTest {

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
