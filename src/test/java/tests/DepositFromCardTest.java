package tests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import pojos.deposit.*;
import tests.core.MobileTest;
import utils.EndPoints;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static core.Auth.auth;
import static core.Currency.*;

public class DepositFromCardTest extends MobileTest {

    @Test
    @DisplayName(EndPoints.depositfromcard_limits + " GET")
    public void testDepositFromCardLimits() {
        auth().get(EndPoints.depositfromcard_limits);
    }

    @Ignore
    @Test
    @DisplayName(EndPoints.depositfromcard_success + " GET")
    public void testDepositFromCardSuccess() {
        auth().get(EndPoints.depositfromcard_success);
    }

    @Ignore
    @Test
    @DisplayName(EndPoints.depositfromcard_failed + " GET")
    public void testDepositFromCardFailed() {
        auth().get(EndPoints.depositfromcard_failed);
    }

    @Ignore
    @Test
    @DisplayName("Create new Offer: BTC")
    public void testCreateOfferBTC() {

        createOffer(BTC);

    }

    @Ignore
    @Test
    @DisplayName("Create new Offer: LTC")
    public void testCreateOfferLTC() {

        createOffer(LTC);

    }

    @Ignore
    @Test
    @DisplayName("Create new Offer: ETH")
    public void testCreateOfferETH() {

        createOffer(ETH);

    }

    @Ignore
    @Test
    @DisplayName("Create transfer BTC")
    public void testCreateTransferBTC() {

        createTransfer(BTC);

    }

    @Ignore
    @Test
    @DisplayName("Create transfer LTC")
    public void testCreateTransferLTC() {

        createTransfer(LTC);

    }

    @Ignore
    @Test
    @DisplayName("Create transfer ETH")
    public void testCreateTransferETH() {

        createTransfer(ETH);

    }

    @Ignore
    @Test
    @DisplayName("Create redirect")
    public void createRedirect() {
        DepositRespOfferModel offer = createOffer(BTC);

        DepositReqTransferModel transfer = new DepositReqTransferModel()
                .setOfferId(offer.getId())
                .setPan("4711100000000000")
                .setHolder("TEST TEST")
                .setExpiredAt("202312")
                .setCvv("369");
        String id = auth().body(transfer).post(EndPoints.depositfromcard_transfers).then()
                .body("status", Matchers.equalTo("Verified"))
                .extract().body().jsonPath().getString("id");

        auth().pathParam("id", id).get(EndPoints.depositfromcard_redirect_id);

    }

    private DepositRespOfferModel createOffer(String currency) {

        BigDecimal amount = getMinAmountForCurrency(currency);

        Order order = new Order()
                .setAmount(amount)
                .setCurrency(currency);
        DepositReqOfferModel model = new DepositReqOfferModel()
                .setOrder(order);

        return auth().body(model).post(EndPoints.depositfromcard_offers).as(DepositRespOfferModel.class);

    }

    private DepositRespTransferModel createTransfer(String currency) {

        DepositRespOfferModel offer = createOffer(currency);

        DepositReqTransferModel transfer = new DepositReqTransferModel()
                .setOfferId(offer.getId())
                .setPan("4200000000000000")
                .setHolder("TEST TEST")
                .setExpiredAt("202312")
                .setCvv("369");

        return auth().body(transfer).post(EndPoints.depositfromcard_transfers).as(DepositRespTransferModel.class);

    }

    private BigDecimal getMinAmountForCurrency(String currency) {

        List<MinAmountModel> limits = auth().get(EndPoints.depositfromcard_limits)
                .then().extract().body().jsonPath().getList("cryptoLimits.minAmount", MinAmountModel.class);

        Optional<MinAmountModel> model = limits.stream().filter(m -> m.getCurrency().equalsIgnoreCase(currency)).findFirst();

        return model.isPresent() ? model.get().getAmount().add(new BigDecimal("0.0001")) : new BigDecimal("0.01");
    }

}
