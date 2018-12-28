package tests;

import core.Auth;
import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.deposit.*;
import utils.EndPoints;

import static core.Auth.auth;

public class DepositFromCardTest {

  @BeforeClass
  public static void init() {
    RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
    RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
  }

  @Test
  @DisplayName(EndPoints.depositfromcard_limits + " GET")
  public void testDepositFromCard() {
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
  public void testCreateOffer(){
    Order order = new Order()
            .setAmount(1.0)
            .setCurrency("BTC");
    DepositReqOfferModel model = new DepositReqOfferModel()
            .setOrder(order);
    auth("70000000131","1234567").body(model).post(EndPoints.depositfromcard_offers);

  }
  
  @Test
  @DisplayName("Create transfer")
  public void testCreateTransfer(){
    Order order = new Order()
            .setAmount(1.0)
            .setCurrency("BTC");
    DepositReqOfferModel model = new DepositReqOfferModel()
            .setOrder(order);
    DepositRespOfferModel offer = auth("70000000131","1234567").body(model)
            .post(EndPoints.depositfromcard_offers).as(DepositRespOfferModel.class);

    DepositReqTransferModel transfer = new DepositReqTransferModel()
            .setOfferId(offer.getId())
            .setPan("4200000000000000")
            .setHolder("TEST TEST")
            .setExpiredAt("202312")
            .setCvv("369");

    auth().body(transfer).post(EndPoints.depositfromcard_transfers);
    Auth.flush();

  }

  @Test
  @DisplayName("Create redirect")
  public void createRedirect(){

    Order order = new Order()
            .setAmount(1.0)
            .setCurrency("BTC");
    DepositReqOfferModel model = new DepositReqOfferModel()
            .setOrder(order);
    DepositRespOfferModel offer = auth("70000000131","1234567").body(model)
            .post(EndPoints.depositfromcard_offers).as(DepositRespOfferModel.class);

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
    auth().pathParam("id",id).get(EndPoints.depositfromcard_redirect_id);
    Auth.flush();




  }




}
