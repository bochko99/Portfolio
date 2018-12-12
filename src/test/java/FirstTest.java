import core.SpecStorage;
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
    public void testChatMessages() {
        auth().get(EndPoints.chat_messages);
    }

    @Test
    public void testCurrencies() {
        given().get(EndPoints.currencies);
    }

    @Test
    public void testFavoritesInvoices() {
        auth().get(EndPoints.favorites_invoices);
    }

    @Test
    public void testFavoritesQuotes() {
        auth().get(EndPoints.favorites_quotes);
    }

    @Test
    public void testFundswallets() {
        auth().get(EndPoints.fundswallets);
    }

    @Test
    public void testHotelsSearch() {
        given().get(EndPoints.hotels_search);
    }

    @Test
    public void testInvoicesBpay() {
        auth().post(EndPoints.invoices_bpay);
    }

    @Test
    public void testInvoicesBsb() {
        auth().post(EndPoints.invoices_bsb);
    }

    @Test
    public void testInvoicesIban() {
        auth().post(EndPoints.invoices_iban);
    }

    @Test
    public void testInvoicesIbanRates() {
        given().get(EndPoints.invoices_iban_rates);
    }

    @Test
    public void testInvoicesMobile() {
        auth().post(EndPoints.invoices_mobile);
    }

    @Test
    public void testInvoicesMobileCodes() {
        given().get(EndPoints.invoices_mobile_codes);
    }

    @Test
    public void testInvoicesVoucherServices() {
        given().get(EndPoints.invoices_voucher_services);
    }

    @Test
    public void testInvoicesCommissions() {
        given().get(EndPoints.invoices_commissions);
    }

    @Test
    public void testInvoicesWithdraw() {
        auth().post(EndPoints.invoices_withdraw);
    }

    @Test
    public void testInvoicesExchange() {
        auth().post(EndPoints.invoices_exchange);
    }

    @Test
    public void testInvoicesExchangesRates() {
        given().get(EndPoints.invoices_exchanges_rates);
    }

    @Test
    public void testCountries() {
        given().get(EndPoints.countries);
    }

    @Test
    public void testMapPoints() {
        given().get(EndPoints.map_points);
    }

    @Test
    public void testNews() {
        given().get(EndPoints.news);
    }

    @Test
    public void testOperations() {
        auth().get(EndPoints.operations);
    }

    @Test
    public void testOperationsRead() {
        auth().post(EndPoints.operations_read);
    }

    @Test
    public void testSettings() {
        auth().get(EndPoints.settings);
    }

    @Test
    public void testSettingsOperations() {
        auth().get(EndPoints.settings_operations);
    }

    @Test
    public void testSettingsKyc() {
        auth().get(EndPoints.settings_kyc);
    }

    @Test
    public void testSettingsReceipts() {
        auth().get(EndPoints.settings_receipts);
    }

    @Test
    public void testSettingsReceiptsCountries() {
        auth().get(EndPoints.settings_receipts_countries);
    }

    @Test
    public void testSettingsLending() {
        auth().get(EndPoints.settings_lending);
    }

    @Test
    public void testSettingsDeposits() {
        auth().get(EndPoints.settings_deposits);
    }

    @Test
    public void testSettingsOnboarding() {
        given().get(EndPoints.settings_onboarding);
    }

    @Test
    public void testTransactionsHistory() {
        auth().get(EndPoints.transactions_history);
    }

    @Test
    public void testTransfersFrequent() {
        auth().get(EndPoints.transfers_frequent);
    }

    @Test
    public void testUsersProfile() {
        auth().get(EndPoints.users_profile);
    }

    @Test
    public void testPostUsersProfile() {
        given().post(EndPoints.users_profile);
    }

    @Test
    public void testUsersProfileTermsAgree() {
        auth().post(EndPoints.users_profile_terms_agree);
    }

    @Test
    public void testUsersProfileTermsIbanAgree() {
        auth().post(EndPoints.users_profile_terms_iban_agree);
    }

    @Test
    public void testUsersProfileLoyalty() {
        auth().get(EndPoints.users_profile_loyalty);
    }

    @Test
    public void testUsersProfileKyc0() {
        auth().get(EndPoints.users_profile_kyc0);
    }

    @Test
    public void testUsersProfileKyc1() {
        auth().get(EndPoints.users_profile_kyc1);
    }

    @Test
    public void testUsersProfileKyc1Verify() {
        auth().post(EndPoints.users_profile_kyc1_verify);
    }

    @Test
    public void testUsersProfileKyc2() {
        auth().get(EndPoints.users_profile_kyc2);
    }

    @Test
    public void testUsersProfileKyc2Verify() {
        auth().post(EndPoints.users_profile_kyc2_verify);
    }

}