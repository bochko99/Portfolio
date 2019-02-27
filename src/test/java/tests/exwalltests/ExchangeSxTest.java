package tests.exwalltests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.auth;
import static io.restassured.RestAssured.given;

public class ExchangeSxTest extends ExwalTest {

    @Test
    @DisplayName(EndPoints.exchange + " POST")
    public void testExchange() {
        auth().post(EndPoints.exchange);
    }


    @Test
    @DisplayName(EndPoints.exchange_rate + " POST")
    public void testExchangeRate() {
        auth().post(EndPoints.exchange_rate);
    }

    @Test
    @DisplayName(EndPoints.rate_transactionid + " POST")
    public void testExchangeRateTranId() {
        auth().post(EndPoints.rate_transactionid);
    }


    @Test
    @DisplayName(EndPoints.rates + " GET")
    public void testCountry() {
        auth().get(EndPoints.rates);
    }
}
