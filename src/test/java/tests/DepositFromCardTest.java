package tests;

import annotations.Credentials;
import annotations.Financial;
import core.Auth;
import core.SpecStorage;
import core.rules.FinancialAnnotationRule;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.*;
import pojos.LoginModel;
import pojos.deposit.*;
import utils.EndPoints;
import utils.Environment;

import java.math.BigDecimal;

import static core.Auth.auth;
import static core.Currency.*;
import static io.restassured.RestAssured.given;

public class DepositFromCardTest extends BaseTest {


  @AfterClass
  public static void stop() {
    Auth.flush();
  }

  @Before
  public void checkSkipNeed() {
    Assume.assumeTrue(annotation.getAnnotation() == null
            || "true".equalsIgnoreCase(Environment.FINANCE_OPERATIONS_ALLOWED));
  }

  @Test
  @Credentials(type = "au")
  @DisplayName(EndPoints.depositfromcard_limits + " GET")
  public void testDepositFromCardLimits() {
    auth().get(EndPoints.depositfromcard_limits);
  }

  @Test
  @Credentials(type = "au")
  @DisplayName(EndPoints.depositfromcard_success + " GET")
  public void testDepositFromCardSuccess() {
    auth().get(EndPoints.depositfromcard_success);
  }

  @Test
  @Credentials(type = "au")
  @DisplayName(EndPoints.depositfromcard_failed + " GET")
  public void testDepositFromCardFailed() {
    auth().get(EndPoints.depositfromcard_failed);
  }

  @Test
  @Credentials(type = "au")
  @DisplayName("Create new Offer: BTC")
  public void testCreateOfferBTC() {

    createOffer(BTC, new BigDecimal(0.02));

  }

  @Test
  @Credentials(type = "au")
  @DisplayName("Create new Offer: LTC")
  public void testCreateOfferLTC() {

    createOffer(LTC, new BigDecimal(0.253));

  }

  @Test
  @Credentials(type = "au")
  @DisplayName("Create new Offer: ETH")
  public void testCreateOfferETH() {

    createOffer(ETH, new BigDecimal(0.02));

  }

  @Test
  @Credentials(type = "au")
  @DisplayName("Create transfer BTC")
  public void testCreateTransferBTC() {

    createTransfer(BTC, new BigDecimal(0.002));

  }

  @Test
  @Credentials(type = "au")
  @DisplayName("Create transfer LTC")
  public void testCreateTransferLTC() {

    createTransfer(LTC, new BigDecimal(0.26));

  }

  @Test
  @Credentials(type = "au")
  @DisplayName("Create transfer ETH")
  public void testCreateTransferETH() {

    createTransfer(ETH, new BigDecimal(0.02));

  }

  @Test
  @Credentials(type = "au")
  @DisplayName("Create redirect")
  public void createRedirect() {
    DepositRespOfferModel offer = createOffer(BTC, new BigDecimal(0.002));

    DepositReqTransferModel transfer = new DepositReqTransferModel()
            .setOfferId(offer.getId())
            .setPan("4711100000000000")
            .setHolder("TEST TEST")
            .setExpiredAt("202312")
            .setCvv("369");
    String id = auth().body(transfer).post(EndPoints.depositfromcard_transfers).then()
            .body("status", Matchers.equalTo("Redirect"))
            .extract().body().jsonPath().getString("id");

    auth().pathParam("id", id).get(EndPoints.depositfromcard_redirect_id);

  }

  private DepositRespOfferModel createOffer(String currency, BigDecimal amount) {

    Order order = new Order()
            .setAmount(amount)
            .setCurrency(currency);
    DepositReqOfferModel model = new DepositReqOfferModel()
            .setOrder(order);

    return auth().body(model).post(EndPoints.depositfromcard_offers).as(DepositRespOfferModel.class);

  }

  private DepositRespTransferModel createTransfer(String currency, BigDecimal amount){

    DepositRespOfferModel offer = createOffer(currency, amount);

    DepositReqTransferModel transfer = new DepositReqTransferModel()
            .setOfferId(offer.getId())
            .setPan("4200000000000000")
            .setHolder("TEST TEST")
            .setExpiredAt("202312")
            .setCvv("369");

    return auth().body(transfer).post(EndPoints.depositfromcard_transfers).as(DepositRespTransferModel.class);

  }

}
