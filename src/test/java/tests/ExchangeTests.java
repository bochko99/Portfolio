package tests;

import com.crypterium.cryptApi.exceptions.NoSuchPairException;
import com.crypterium.cryptApi.exceptions.NoSuchWalletException;
import com.crypterium.cryptApi.pojos.exchange.ExchangeOfferReqModel;
import com.crypterium.cryptApi.pojos.exchange.ExchangeOfferResponseModel;
import com.crypterium.cryptApi.pojos.exchange.ExchangePairsResponseModel;
import com.crypterium.cryptApi.pojos.exchange.Pair;
import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.crypterium.cryptApi.pojos.wallets.Wallet;
import com.crypterium.cryptApi.pojos.wallets.WalletListResp;
import com.crypterium.cryptApi.utils.BalanceAssertManager;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import core.annotations.Financial;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.BTC;
import static com.crypterium.cryptApi.pojos.wallets.Currency.CRPT;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ExchangeTests extends ExwalTest {

    private CredentialEntry sender = Environment.CREDENTIAL_DEFAULT;

    @TestFactory
    @DisplayName(EndPoints.mobile_exchange_currencies + " GET")
    public Collection<DynamicTest> testGetMobileExchangeCurrencies() {
        List<Pair> pairs = service().auth().get(EndPoints.mobile_exchange_currencies).as(ExchangePairsResponseModel.class).getPairs();
        return pairs.stream().map(pair -> dynamicTest(String.format("Pair min/max amount check. %s -> %s", pair.getCurrencyFrom(), pair.getCurrencyTo()), () -> {
            BigDecimal expectedMin = pair.getMinAmountFrom().multiply(pair.getRate());
            BigDecimal expectedMax = pair.getMaxAmountFrom().multiply(pair.getRate());

            String msgMin = String.format("Expected: %s, Actual: %s", expectedMin, pair.getMinAmountTo());
            String msgMax = String.format("Expected: %s, Actual: %s", expectedMax, pair.getMaxAmountTo());

            Assert.assertTrue(msgMin, BalanceAssertManager.equal(expectedMin, pair.getMinAmountTo()));
            Assert.assertTrue(msgMax, BalanceAssertManager.equal(expectedMax, pair.getMaxAmountTo()));
        })).collect(Collectors.toList());
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
    @DisplayName(EndPoints.mobile_exchange_offer + ": Rate differentiation")
    public void testPostMobileExchangeOfferRateDifferentiation() {
        Currency currencyFrom = BTC;
        Currency currencyTo = CRPT;

        List<Pair> pairs = service().auth().get(EndPoints.mobile_exchange_currencies).as(ExchangePairsResponseModel.class).getPairs();
        Pair pair = getPairByCurrencies(pairs, currencyFrom, currencyTo);

        ExchangeOfferReqModel body = new ExchangeOfferReqModel()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmountTo(BigDecimal.ZERO)
                .setAmountFrom(BigDecimal.ZERO);

        ExchangeOfferResponseModel offer = service().auth().body(body)
                .post(EndPoints.mobile_exchange_offer).as(ExchangeOfferResponseModel.class);

        BigDecimal differentiationPercent = (pair.getRate().subtract(offer.getExchangeRate()))
                .divide(pair.getRate(), 6, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));

        System.out.println(pair.getRate());
        System.out.println(offer.getExchangeRate());
        System.out.println(differentiationPercent.toString());

        Assert.assertThat(differentiationPercent.abs(), Matchers.lessThan(new BigDecimal("5")));
    }

    @TestFactory
    @Financial
    @DisplayName("Exchange")
    public Collection<DynamicTest> testExchange() {
        List<Pair> pairs = service().auth().get(EndPoints.mobile_exchange_currencies).as(ExchangePairsResponseModel.class).getPairs();
        return pairs.stream().map(pair -> dynamicTest(String.format("Exchange test. %s -> %s", pair.getCurrencyFrom(), pair.getCurrencyTo()), () ->
                testExchangeByMinimalValue(pair.getCurrencyFrom(), pair.getCurrencyTo()))).collect(Collectors.toList());
    }

    public void testExchangeByMinimalValue(Currency currencyFrom, Currency currencyTo) {
        List<Pair> pairs = service().auth().get(EndPoints.mobile_exchange_currencies).as(ExchangePairsResponseModel.class).getPairs();
        Pair pair = getPairByCurrencies(pairs, currencyFrom, currencyTo);
        //Волшебное число 0.95 - это 95% от минимального объема, который первоначально был увеличен на 20%.
        //Таким образом получается число, равное 1.14 от минимального но меньше чем возвращенное из currencies.
        BigDecimal amount = pair.getMinAmountFrom().multiply(new BigDecimal("0.95"));
        List<Wallet> wallets = getWallets(sender);
        BigDecimal sourceAmountBefore = getWalletByCurrency(wallets, currencyFrom)
                .getBalance();
        BigDecimal targetAmountBefore = getWalletByCurrency(wallets, currencyTo)
                .getBalance();

        ExchangeOfferReqModel body = new ExchangeOfferReqModel()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmountFrom(amount);
        ExchangeOfferResponseModel offer = service().auth().body(body)
                .post(EndPoints.mobile_exchange_offer).as(ExchangeOfferResponseModel.class);

        service().auth().pathParam("offerId", offer.getOfferId())
                .put(EndPoints.mobile_exchange_offer_offerId);

        BigDecimal expectedSourceAmount = sourceAmountBefore.subtract(offer.getSourceCurrencyAmount().getAmount());
        BigDecimal expectedTargetAmount = targetAmountBefore.add(offer.getTargetCurrencyAmount().getAmount());

        wallets = getWallets(sender);
        BigDecimal sourceAmountAfter = getWalletByCurrency(wallets, currencyFrom).getBalance();
        BigDecimal targetAmountAfter = getWalletByCurrency(wallets, currencyTo).getBalance();

        String msgTemplate = "Expected %1$s balance: %2$s; Current %1$s balance: %3$s";

        Assert.assertTrue(String.format(msgTemplate, "source", expectedSourceAmount, sourceAmountAfter),
                BalanceAssertManager.equal(expectedSourceAmount, sourceAmountAfter));
        Assert.assertTrue(String.format(msgTemplate, "target", expectedTargetAmount, targetAmountAfter),
                BalanceAssertManager.equal(expectedTargetAmount, targetAmountAfter));
    }

    public Pair getPairByCurrencies(List<Pair> pairs, Currency currencyFrom, Currency currencyTo) {
        return pairs.stream().filter(p -> p.getCurrencyFrom().equals(currencyFrom) && p.getCurrencyTo().equals(currencyTo))
                .findFirst().orElseThrow(() -> new NoSuchPairException(currencyFrom, currencyTo));
    }

    private List<Wallet> getWallets(CredentialEntry user) {
        return service().authAs(user.getLogin(), user.getPassword(), user.getLogin())
                .get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
    }

    private Wallet getWalletByCurrency(List<Wallet> wallets, Currency currency) {
        return wallets.stream().filter(e -> e.getCurrency().equals(currency)).filter(w -> w.getId() != -1).findFirst()
                .orElseThrow(() -> new NoSuchWalletException(currency));
    }

}