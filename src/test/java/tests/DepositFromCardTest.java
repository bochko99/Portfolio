package tests;

import annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import pojos.deposit.*;
import utils.EndPoints;

import java.math.BigDecimal;

import static core.Auth.auth;
import static core.Currency.*;

public class DepositFromCardTest extends BaseTest {

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

    private DepositRespTransferModel createTransfer(String currency, BigDecimal amount) {

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
