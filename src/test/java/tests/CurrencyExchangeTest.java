package tests;

import annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pojos.exchange.ExchangeOfferReqModel;
import utils.EndPoints;

import java.math.BigDecimal;

import static core.Auth.auth;
import static core.Currency.*;


public class CurrencyExchangeTest extends BaseTest {

    @Test
    @DisplayName(EndPoints.currencyexchange_directions + " GET")
    public void currencyExchangeDirection() {

        auth().get(EndPoints.currencyexchange_directions);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_offers + " POST")
    public void currencyExchangeOffers() {
        ExchangeOfferReqModel model = new ExchangeOfferReqModel()
                .setAmount(BigDecimal.ZERO)
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
