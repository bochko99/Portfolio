package tests;

import com.crypterium.cryptApi.pojos.exchange.ExchangeOfferReqModel;
import com.crypterium.cryptApi.pojos.exchange.ExchangeOfferResponseModel;
import com.crypterium.cryptApi.pojos.exchange.ExchangePairsResponseModel;
import com.crypterium.cryptApi.pojos.exchange.Pair;
import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.util.List;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.BTC;
import static com.crypterium.cryptApi.pojos.wallets.Currency.CRPT;

public class Exchange extends ExwalTest {

    @Test
    @DisplayName(EndPoints.mobile_exchange_currencies + " GET")
    public void testGetMobileExchangeCurrencies() {
        service().auth().get(EndPoints.mobile_exchange_currencies);
    }

    @Test
    @DisplayName(EndPoints.mobile_exchange_offer + " POST")
    public void testMobileExchangeOffer() {

        Currency currencyFrom = BTC;
        Currency currencyTo = CRPT;
        ExchangeOfferReqModel body = new ExchangeOfferReqModel()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmountTo(BigDecimal.ZERO)
                .setAmountFrom(BigDecimal.ZERO);

        ExchangeOfferResponseModel response = service().auth().body(body).post(EndPoints.mobile_exchange_offer)
            .as(ExchangeOfferResponseModel.class);

        Assert.assertThat(response.getExchangeRate(), Matchers.greaterThan(BigDecimal.ZERO));
        Assert.assertThat(response.getSourceCurrencyAmount().getCurrencyCode(), Matchers.equalTo(currencyFrom));
        Assert.assertThat(response.getSourceCurrencyAmount().getAmount(), Matchers.equalTo(BigDecimal.ZERO));
        Assert.assertThat(response.getTargetCurrencyAmount().getCurrencyCode(), Matchers.equalTo(currencyTo));
        Assert.assertThat(response.getTargetCurrencyAmount().getAmount(), Matchers.equalTo(BigDecimal.ZERO));
    }

    @Test
    @DisplayName("Exchange BTC to ETH")
    public void testExchangeBTCtoETH() {
        List<Pair> pairs = service().auth().get(EndPoints.mobile_exchange_currencies).as(ExchangePairsResponseModel.class).getPairs();
        Pair pair = getPairByCurrencies(pairs, CRPT, BTC);
        BigDecimal amount = pair.getMinAmountFrom();
        ExchangeOfferReqModel body = new ExchangeOfferReqModel()
                .setCurrencyFrom(CRPT)
                .setCurrencyTo(BTC)
                .setAmountFrom(new BigDecimal("3000"));

        ExchangeOfferResponseModel offer = service().auth().body(body)
                .post(EndPoints.mobile_exchange_offer).as(ExchangeOfferResponseModel.class);

        service().auth().pathParam("offerId", offer.getOfferId())
                .put(EndPoints.mobile_exchange_offer_offerId);

    }

    public Pair getPairByCurrencies(List<Pair> pairs, Currency currencyFrom, Currency currencyTo) {
        return pairs.stream().filter(p -> p.getCurrencyFrom().equals(currencyFrom) && p.getCurrencyTo().equals(currencyTo))
                .findFirst().orElse(null);
    }

}