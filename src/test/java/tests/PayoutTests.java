package tests;

import com.crypterium.cryptApi.exceptions.NoSuchRateException;
import com.crypterium.cryptApi.pojos.payout.*;
import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.crypterium.cryptApi.utils.EndPoints;
import core.TestScope;
import core.annotations.Financial;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.BTC;
import static com.crypterium.cryptApi.pojos.wallets.Currency.LTC;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.greaterThan;

@Epic(TestScope.REGRESS)
@Feature("Payout")
public class PayoutTests extends ExwalTest {

//    public static final String CARD_NUMBER = "5555555555555557";
    public static final String CARD_NUMBER = "5582266007550595";
//    public static final String CARD_NUMBER = "5105105105105100";
//    public static final String CARD_NUMBER = "5593450818370545";

    @Severity(SeverityLevel.BLOCKER)
    @Story("Payout data")
    @Description("User gets payout data based on his card limit")
    @Test
    public void testPostPayoutPayneteasyData() {
        PayoutDataRequestModel model = new PayoutDataRequestModel(CARD_NUMBER);
        PayoutDataResponseModel responseModel = service().auth().body(model).post(EndPoints.payout_data).as(PayoutDataResponseModel.class);

        responseModel.getRates().forEach(rate -> {
            Assert.assertThat(responseModel.getLimits().getAvailable().setScale(4, RoundingMode.HALF_UP),
                    closeTo(rate.getRate().multiply(rate.getMaxCrypto()).setScale(4, RoundingMode.HALF_UP), new BigDecimal("0.0001")));
            Assert.assertTrue(rate.getMinCrypto().compareTo(rate.getMaxCrypto()) <= 0);
            Assert.assertThat(rate.getRate(), greaterThan(BigDecimal.ZERO));
        });
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("Payout offer")
    @Description("User creates payout offer")
    @Test
    public void testPostPayoutPayneteasyOffer() {

        Currency currency = LTC;
        List<Rate> rates = service().auth().body(new PayoutDataRequestModel(CARD_NUMBER))
                .post(EndPoints.payout_data).as(PayoutDataResponseModel.class).getRates();
        BigDecimal minAmount = getRateByCurrency(rates, currency).getMinCrypto();

        PayoutOfferRequestModel model = new PayoutOfferRequestModel(minAmount, CARD_NUMBER, currency);

        PayoutOfferResponseModel responseModel = service().auth().body(model).post(EndPoints.payout_offer).as(PayoutOfferResponseModel.class);
        Assert.assertThat(responseModel.getOfferId(), Matchers.notNullValue());

    }

    @Ignore
    @Test
    @Financial
    @DisplayName(EndPoints.payout_pay + " POST")
    public void testPostPayoutPayneteasyPay() {

        Currency currency = BTC;
        List<Rate> rates = service().auth().body(new PayoutDataRequestModel(CARD_NUMBER))
                .post(EndPoints.payout_data).as(PayoutDataResponseModel.class).getRates();
        BigDecimal minAmount = getRateByCurrency(rates, currency).getMinCrypto();

        PayoutOfferRequestModel model = new PayoutOfferRequestModel(minAmount, CARD_NUMBER, currency);

        Integer offerId = service().auth().body(model).post(EndPoints.payout_offer).jsonPath().get("offerId");

        PayoutPayRequestModel payModel = new PayoutPayRequestModel(CARD_NUMBER, offerId.longValue());
        service().auth().body(payModel).post(EndPoints.payout_pay);
    }


    private Rate getRateByCurrency(List<Rate> rates, Currency currency) {
        return rates.stream().filter(r -> r.getCurrency().equals(currency)).findFirst().orElseThrow(
                () -> new NoSuchRateException(currency)
        );
    }
}
