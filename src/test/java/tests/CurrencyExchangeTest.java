package tests;

import com.crypterium.cryptApi.oldback.pojos.exchange.ExchangeOfferReqModel;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.MobileTest;

import java.math.BigDecimal;

import static com.crypterium.cryptApi.Auth.service;
import static core.Currency.BTC;
import static core.Currency.ETH;


public class CurrencyExchangeTest extends MobileTest {

    @Ignore
    @Test
    @DisplayName(EndPoints.currencyexchange_directions + " GET")
    public void currencyExchangeDirection() {

        service().auth().get(EndPoints.currencyexchange_directions);

    }

    @Ignore
    @Test
    @DisplayName(EndPoints.currencyexchange_offers + " POST")
    public void currencyExchangeOffers() {
        ExchangeOfferReqModel model = new ExchangeOfferReqModel()
                .setAmount(new BigDecimal(0.02))
                .setAmountKind("SourceAmount")
                .setSourceCurrencyCode(BTC)
                .setTargetCurrencyCode(ETH);

        service().auth().body(model).post(EndPoints.currencyexchange_offers);

    }

    @Ignore
    @Test
    @DisplayName(EndPoints.currencyexchange_transfers + " POST")
    public void currencyExchangeTransfers() {

        service().auth().post(EndPoints.currencyexchange_transfers);

    }

}
