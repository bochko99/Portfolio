package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pojos.exchange.ExchangeOfferReqModel;
import tests.core.MobileTest;
import utils.EndPoints;

import java.math.BigDecimal;

import static core.Auth.auth;
import static core.Currency.BTC;
import static core.Currency.ETH;


public class CurrencyExchangeTest extends MobileTest {

    @Test
    @DisplayName(EndPoints.currencyexchange_directions + " GET")
    public void currencyExchangeDirection() {

        auth().get(EndPoints.currencyexchange_directions);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_offers + " POST")
    public void currencyExchangeOffers() {
        ExchangeOfferReqModel model = new ExchangeOfferReqModel()
                .setAmount(new BigDecimal(0.02))
                .setAmountKind("SourceAmount")
                .setSourceCurrencyCode(BTC)
                .setTargetCurrencyCode(ETH);

        auth().body(model).post(EndPoints.currencyexchange_offers);

    }

    @Test
    @DisplayName(EndPoints.currencyexchange_transfers + " POST")
    public void currencyExchangeTransfers() {

        auth().post(EndPoints.currencyexchange_transfers);

    }

}
