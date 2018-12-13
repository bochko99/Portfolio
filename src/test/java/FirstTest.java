import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.LoginModel;
import utils.EndPoints;

import static core.Auth.auth;
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
    @DisplayName(EndPoints.chat_messages + " GET")
    public void testGetChatMessages() {
        auth().get(EndPoints.chat_messages);
    }

    @Test
    @DisplayName(EndPoints.currencies + " GET")
    public void testGetCurrencies() {
        given().get(EndPoints.currencies);
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

    @Test
    @DisplayName(EndPoints.fundswallets + " GET")
    public void testGetFundswallets() {
        auth().get(EndPoints.fundswallets);
    }

    @Test
    @DisplayName(EndPoints.hotels_search + " GET")
    public void testGetHotelsSearch() {
        given().get(EndPoints.hotels_search);
    }

    @Test
    @DisplayName(EndPoints.invoices_bpay + " POST")
    public void testPostInvoicesBpay() {
        auth().post(EndPoints.invoices_bpay);
    }

    @Test
    @DisplayName(EndPoints.invoices_bsb + " POST")
    public void testPostInvoicesBsb() {
        auth().post(EndPoints.invoices_bsb);
    }

    @Test
    @DisplayName(EndPoints.invoices_iban + " POST")
    public void testPostInvoicesIban() {
        auth().post(EndPoints.invoices_iban);
    }

    @Test
    @DisplayName(EndPoints.invoices_iban_rates + " GET")
    public void testGetInvoicesIbanRates() {
        given().get(EndPoints.invoices_iban_rates);
    }

    @Test
    @DisplayName(EndPoints.invoices_mobile + " POST")
    public void testPostInvoicesMobile() {
        auth().post(EndPoints.invoices_mobile);
    }

    @Test
    @DisplayName(EndPoints.invoices_mobile_codes + " GET")
    public void testGetInvoicesMobileCodes() {
        given().get(EndPoints.invoices_mobile_codes);
    }

    @Test
    @DisplayName(EndPoints.invoices_voucher_services + " GET")
    public void testGetInvoicesVoucherServices() {
        given().get(EndPoints.invoices_voucher_services);
    }

    @Test
    @DisplayName(EndPoints.invoices_commissions + " GET")
    public void testGetInvoicesCommissions() {
        given().get(EndPoints.invoices_commissions);
    }

    @Test
    @DisplayName(EndPoints.invoices_withdraw + " POST")
    public void testPostInvoicesWithdraw() {
        auth().post(EndPoints.invoices_withdraw);
    }

    @Test
    @DisplayName(EndPoints.invoices_exchange + " POST")
    public void testPostInvoicesExchange() {
        auth().post(EndPoints.invoices_exchange);
    }

    @Test
    @DisplayName(EndPoints.invoices_exchanges_rates + " GET")
    public void testGetInvoicesExchangesRates() {
        given().get(EndPoints.invoices_exchanges_rates);
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
    @DisplayName(EndPoints.operations + " GET")
    public void testGetOperations() {
        auth().get(EndPoints.operations);
    }

    @Test
    @DisplayName(EndPoints.operations_read + " POST")
    public void testPostOperationsRead() {
        auth().post(EndPoints.operations_read);
    }

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

    @Test
    @DisplayName(EndPoints.users_profile + " GET")
    public void testGetUsersProfile() {
        auth().get(EndPoints.users_profile);
    }

    @Test
    @DisplayName(EndPoints.users_login + " POST")
    public void testPostUsersProfile() {
        given().post(EndPoints.users_profile);
    }

    @Test
    @DisplayName(EndPoints.users_profile_terms_agree + " POST")
    public void testPostUsersProfileTermsAgree() {
        auth().post(EndPoints.users_profile_terms_agree);
    }

    @Test
    @DisplayName(EndPoints.users_profile_terms_iban_agree + " POST")
    public void testPostUsersProfileTermsIbanAgree() {
        auth().post(EndPoints.users_profile_terms_iban_agree);
    }

    @Test
    @DisplayName(EndPoints.users_profile_loyalty + " GET")
    public void testGetUsersProfileLoyalty() {
        auth().get(EndPoints.users_profile_loyalty);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc0 + " GET")
    public void testGetUsersProfileKyc0() {
        auth().get(EndPoints.users_profile_kyc0);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc1 + " GET")
    public void testGetUsersProfileKyc1() {
        auth().get(EndPoints.users_profile_kyc1);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc1_verify + " POST")
    public void testPostUsersProfileKyc1Verify() {
        auth().post(EndPoints.users_profile_kyc1_verify);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc2 + " GET")
    public void testGetUsersProfileKyc2() {
        auth().get(EndPoints.users_profile_kyc2);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc2_verify + " POST")
    public void testPostUsersProfileKyc2Verify() {
        auth().post(EndPoints.users_profile_kyc2_verify);
    }

}