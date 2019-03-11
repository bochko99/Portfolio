package tests;

import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import tests.core.ExwalTest;

import static io.restassured.RestAssured.given;

public class BanksWithdrawalsTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.banks_ru + " GET")
    public void testbanksRu() {
        SpecStorage.banks().queryParam("bic", "044525225").get(EndPoints.banks_ru).then()
                .body("fullName", Matchers.equalTo("ПАО СБЕРБАНК"));
    }

    @Test
    @DisplayName(EndPoints.banks_eu + " GET")
    public void testbanksEu() {
        SpecStorage.banks().get(EndPoints.banks_eu);
    }

    @Test
    @DisplayName(EndPoints.limits_countries + " GET")
    public void testlimitsCountries() {
        SpecStorage.banks().get(EndPoints.limits_countries);
    }

    @Test
    @DisplayName(EndPoints.limits_iban + " GET")
    public void testLimitsIban() {
        SpecStorage.banks().get(EndPoints.limits_iban);
    }

    @Test
    @DisplayName(EndPoints.limits_rubank + " GET")
    public void testLimitsRubank() {
        SpecStorage.banks().get(EndPoints.limits_rubank);
    }

    @Test
    @DisplayName(EndPoints.rates_from_to_to + " GET")
    public void testRatesFromToTo() {
        SpecStorage.banks().get(EndPoints.rates_from_to_to);
    }


}
