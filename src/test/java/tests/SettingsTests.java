package tests;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.Test;
import tests.core.MobileTest;
import utils.EndPoints;

import static core.Auth.auth;
import static io.restassured.RestAssured.given;

public class SettingsTests extends MobileTest {

    @Test
    @DisplayName(EndPoints.settings + " GET")
    public void testGetSettings() {
        auth().get(EndPoints.settings);
    }

    @Test
    @DisplayName(EndPoints.settings_operations + " GET")
    public void testGetSettingsOperations() {
        auth().get(EndPoints.settings_operations);
    }

    @Test
    @DisplayName(EndPoints.settings_receipts_countries + " GET")
    public void testGetSettingsReceiptsCountries() {
        auth().get(EndPoints.settings_receipts_countries);
    }

    @Test
    @DisplayName(EndPoints.settings_lending + " GET")
    public void testGetSettingsLending() {
        auth().get(EndPoints.settings_lending);
    }

    @Test
    @DisplayName(EndPoints.settings_version + " GET")
    public void testGetSettingsVersion406() {
        given()
                .header("User-Agent", "Crypterium/1.5 (Android; 26): samsung SM-A530F")
                .expect().statusCode(406).when()
                .get(EndPoints.settings_version);

    }

    @Test
    @DisplayName(EndPoints.settings_version + " GET")
    public void testGetSettingsVersion200() {

        given()
                .header("User-Agent", "Crypterium/1.6.5 (Android; 26): samsung SM-A530F")
                .get(EndPoints.settings_version);

    }


    @Test
    @DisplayName(EndPoints.settings_deposits + " GET")
    public void testGetSettingsDeposits() {
        auth().get(EndPoints.settings_deposits);
    }

    @Test
    @DisplayName(EndPoints.settings_onboarding + " GET")
    public void testGetSettingsOnboarding() {
        given().get(EndPoints.settings_onboarding);
    }

}
