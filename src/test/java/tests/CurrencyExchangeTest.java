package tests;

import annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pojos.exchange.ExchangeOfferReqModel;
import utils.EndPoints;

import static core.Auth.auth;

public class CurrencyExchangeTest extends BaseTest {

    @Test
    @DisplayName(EndPoints.currencyexchange_directions_path + " GET")
    public void currencyExchangeDirection() {

        auth().get(EndPoints.currencyexchange_directions_path);

    }

    @Test
    @Financial
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
    @Financial
    @DisplayName(EndPoints.currencyexchange_transfers_path + " POST")
    public void currencyExchangeTransfers() {

        auth().post(EndPoints.currencyexchange_transfers_path);

    }

}
