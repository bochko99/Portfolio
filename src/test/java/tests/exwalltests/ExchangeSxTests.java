package tests.exwalltests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.service;

public class ExchangeSxTests extends ExwalTest {

    @Test
    @Ignore
    @DisplayName(EndPoints.mobile_sx_exchange + " POST")
    public void testExchange() {
        service().auth().post(EndPoints.mobile_sx_exchange);
    }


    @Test
    @Ignore
    @DisplayName(EndPoints.mobile_sx_exchange_rate + " POST")
    public void testExchangeRate() {
        service().auth().post(EndPoints.mobile_sx_exchange_rate);
    }

    @Test
    @Ignore
    @DisplayName(EndPoints.mobile_sx_exchange_rate_transactionid + " POST")
    public void testExchangeRateTranId() {
        service().auth().post(EndPoints.mobile_sx_exchange_rate_transactionid);
    }


    @Test
    @Ignore
    @DisplayName(EndPoints.mobile_sx_rates + " GET")
    public void testCountry() {
        service().auth().get(EndPoints.mobile_sx_rates);
    }
}
