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
    @DisplayName("POST " + EndPoints.users_login)
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
    @DisplayName("GET " + EndPoints.chat_messages)
    public void testGetChatMessages() {
        auth().get(EndPoints.chat_messages);
    }

    @Test
    @DisplayName("GET " + EndPoints.currencies)
    public void testGetCurrencies() {
        given().get(EndPoints.currencies);
    }

    @Test
    @DisplayName("GET " + EndPoints.favorites_invoices)
    public void testGetFavoritesInvoices() {
        auth().get(EndPoints.favorites_invoices);
    }

    @Test
    @DisplayName("GET " + EndPoints.favorites_quotes)
    public void testGetFavoritesQuotes() {
        auth().get(EndPoints.favorites_quotes);
    }

    @Test
    @DisplayName("GET " + EndPoints.fundswallets)
    public void testGetFundswallets() {
        auth().get(EndPoints.fundswallets);
    }

    @Test
    @DisplayName("GET " + EndPoints.hotels_search)
    public void testGetHotelsSearch() {
        given().get(EndPoints.hotels_search);
    }

    @Test
    @DisplayName("POST " + EndPoints.invoices_bpay)
    public void testPostInvoicesBpay() {
        auth().post(EndPoints.invoices_bpay);
    }

    @Test
    @DisplayName("POST " + EndPoints.invoices_bsb)
    public void testPostInvoicesBsb() {
        auth().post(EndPoints.invoices_bsb);
    }

    @Test
    @DisplayName("POST " + EndPoints.invoices_iban)
    public void testPostInvoicesIban() {
        auth().post(EndPoints.invoices_iban);
    }

    @Test
    @DisplayName("GET " + EndPoints.invoices_iban_rates)
    public void testGetInvoicesIbanRates() {
        given().get(EndPoints.invoices_iban_rates);
    }

    @Test
    @DisplayName("POST " + EndPoints.invoices_mobile)
    public void testPostInvoicesMobile() {
        auth().post(EndPoints.invoices_mobile);
    }

    @Test
    @DisplayName("GET " + EndPoints.invoices_mobile_codes)
    public void testGetInvoicesMobileCodes() {
        given().get(EndPoints.invoices_mobile_codes);
    }

    @Test
    @DisplayName("GET " + EndPoints.invoices_voucher_services)
    public void testGetInvoicesVoucherServices() {
        given().get(EndPoints.invoices_voucher_services);
    }

    @Test
    @DisplayName("GET " + EndPoints.invoices_commissions)
    public void testGetInvoicesCommissions() {
        given().get(EndPoints.invoices_commissions);
    }

    @Test
    @DisplayName("POST " + EndPoints.invoices_withdraw)
    public void testPostInvoicesWithdraw() {
        auth().post(EndPoints.invoices_withdraw);
    }

    @Test
    @DisplayName("POST " + EndPoints.invoices_exchange)
    public void testPostInvoicesExchange() {
        auth().post(EndPoints.invoices_exchange);
    }

    @Test
    @DisplayName("GET " + EndPoints.invoices_exchanges_rates)
    public void testGetInvoicesExchangesRates() {
        given().get(EndPoints.invoices_exchanges_rates);
    }

    @Test
    @DisplayName("GET " + EndPoints.countries)
    public void testGetCountries() {
        given().get(EndPoints.countries);
    }

    @Test
    @DisplayName("GET " + EndPoints.map_points)
    public void testGetMapPoints() {
        given().get(EndPoints.map_points);
    }

    @Test
    @DisplayName("GET " + EndPoints.news)
    public void testGetNews() {
        given().get(EndPoints.news);
    }

    @Test
    @DisplayName("GET " + EndPoints.operations)
    public void testGetOperations() {
        auth().get(EndPoints.operations);
    }

    @Test
    @DisplayName("POST " + EndPoints.operations_read)
    public void testPostOperationsRead() {
        auth().post(EndPoints.operations_read);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings)
    public void testGetSettings() {
        auth().get(EndPoints.settings);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings_operations)
    public void testGetSettingsOperations() {
        auth().get(EndPoints.settings_operations);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings_kyc)
    public void testGetSettingsKyc() {
        auth().get(EndPoints.settings_kyc);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings_receipts)
    public void testGetSettingsReceipts() {
        auth().get(EndPoints.settings_receipts);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings_receipts_countries)
    public void testGetSettingsReceiptsCountries() {
        auth().get(EndPoints.settings_receipts_countries);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings_lending)
    public void testGetSettingsLending() {
        auth().get(EndPoints.settings_lending);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings_deposits)
    public void testGetSettingsDeposits() {
        auth().get(EndPoints.settings_deposits);
    }

    @Test
    @DisplayName("GET " + EndPoints.settings_onboarding)
    public void testGetSettingsOnboarding() {
        given().get(EndPoints.settings_onboarding);
    }

    @Test
    @DisplayName("GET " + EndPoints.transactions_history)
    public void testGetTransactionsHistory() {
        auth().get(EndPoints.transactions_history);
    }

    @Test
    @DisplayName("GET " + EndPoints.transfers_frequent)
    public void testGetTransfersFrequent() {
        auth().get(EndPoints.transfers_frequent);
    }

    @Test
    @DisplayName("GET " + EndPoints.users_profile)
    public void testGetUsersProfile() {
        auth().get(EndPoints.users_profile);
    }

    @Test
    @DisplayName("POST " + EndPoints.users_login)
    public void testPostUsersProfile() {
        given().post(EndPoints.users_profile);
    }

    @Test
    @DisplayName("POST " + EndPoints.users_profile_terms_agree)
    public void testPostUsersProfileTermsAgree() {
        auth().post(EndPoints.users_profile_terms_agree);
    }

    @Test
    @DisplayName("POST " + EndPoints.users_profile_terms_iban_agree)
    public void testPostUsersProfileTermsIbanAgree() {
        auth().post(EndPoints.users_profile_terms_iban_agree);
    }

    @Test
    @DisplayName("GET " + EndPoints.users_profile_loyalty)
    public void testGetUsersProfileLoyalty() {
        auth().get(EndPoints.users_profile_loyalty);
    }

    @Test
    @DisplayName("GET " + EndPoints.users_profile_kyc0)
    public void testGetUsersProfileKyc0() {
        auth().get(EndPoints.users_profile_kyc0);
    }

    @Test
    @DisplayName("GET " + EndPoints.users_profile_kyc1)
    public void testGetUsersProfileKyc1() {
        auth().get(EndPoints.users_profile_kyc1);
    }

    @Test
    @DisplayName("POST " + EndPoints.users_profile_kyc1_verify)
    public void testPostUsersProfileKyc1Verify() {
        auth().post(EndPoints.users_profile_kyc1_verify);
    }

    @Test
    @DisplayName("GET " + EndPoints.users_profile_kyc2)
    public void testGetUsersProfileKyc2() {
        auth().get(EndPoints.users_profile_kyc2);
    }

    @Test
    @DisplayName("POST " + EndPoints.users_profile_kyc2_verify)
    public void testPostUsersProfileKyc2Verify() {
        auth().post(EndPoints.users_profile_kyc2_verify);
    }

}