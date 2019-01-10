package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;
import static io.restassured.RestAssured.given;

public class SettingsTests extends BaseTest {

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
    @DisplayName(EndPoints.settings_kyc + " GET")
    public void testGetSettingsKyc() {
        auth().get(EndPoints.settings_kyc);
    }

    @Test
    @DisplayName(EndPoints.settings_receipts + " GET")
    public void testGetSettingsReceipts() {
        auth().get(EndPoints.settings_receipts);
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
