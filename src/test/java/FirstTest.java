import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.LoginModel;
import utils.EndPoints;

import static core.Auth.auth;
import static core.Currency.BTC;
import static io.restassured.RestAssured.given;


public class FirstTest {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }


    @Test
    @DisplayName(EndPoints.users_login + " POST")
    public void testAuth() {
        given().body(new LoginModel()
                .setLogin("70000000040")
                .setPassword("1234567"))
                .when()
                .post(EndPoints.users_login)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName(EndPoints.countries + " GET")
    public void testGetCountries() {
        given().get(EndPoints.countries);
    }

    @Test
    @DisplayName(EndPoints.map_points + " GET")
    public void testGetMapPoints() {
        given().get(EndPoints.map_points);
    }

    @Test
    @DisplayName(EndPoints.news + " GET")
    public void testGetNews() {
        given().get(EndPoints.news);
    }


    @Test
    @DisplayName(EndPoints.quotes + " GET")
    public void testGetQuotes() {
        given().get(EndPoints.quotes);
    }

    @Test
    @DisplayName(EndPoints.quotes_currency + " GET")
    public void testGetQuotesCurrency() {
        given().pathParam("currency", BTC).get(EndPoints.quotes_currency);
    }

    @Test
    @DisplayName(EndPoints.transactions_history + " GET")
    public void testGetTransactionsHistory() {
        auth().get(EndPoints.transactions_history);
    }

    @Test
    @DisplayName(EndPoints.transfers_frequent + " GET")
    public void testGetTransfersFrequent() {
        auth().get(EndPoints.transfers_frequent);
    }



}