package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;

public class FavoritesTests {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Test
    @DisplayName(EndPoints.favorites_invoices + " GET")
    public void testGetFavoritesInvoices() {
        auth().get(EndPoints.favorites_invoices);
    }



    @Test
    @DisplayName(EndPoints.favorites_quotes + " GET")
    public void testGetFavoritesQuotes() {
        auth().get(EndPoints.favorites_quotes);
    }


}
