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
    public void testGetChatMessages() {
        auth().get(EndPoints.chat_messages);
    }

    @Test
    public void testGetCurrencies() {
        given().get(EndPoints.currencies);
    }

    @Test
    public void testGetFavoritesInvoices() {
        auth().get(EndPoints.favorites_invoices);
    }

    @Test
    public void testGetFavoritesQuotes() {
        auth().get(EndPoints.favorites_quotes);
    }

    @Test
    public void testGetFundswallets() {
        auth().get(EndPoints.fundswallets);
    }

    @Test
    public void testGetHotelsSearch() {
        given().get(EndPoints.hotels_search);
    }

    @Test
    public void testPostInvoicesBpay() {
        auth().post(EndPoints.invoices_bpay);
    }

    @Test
    public void testPostInvoicesBsb() {
        auth().post(EndPoints.invoices_bsb);
    }

    @Test
    public void testPostInvoicesIban() {
        auth().post(EndPoints.invoices_iban);
    }

    @Test
    public void testGetInvoicesIbanRates() {
        given().get(EndPoints.invoices_iban_rates);
    }

    @Test
    public void testPostInvoicesMobile() {
        auth().post(EndPoints.invoices_mobile);
    }

    @Test
    public void testGetInvoicesMobileCodes() {
        given().get(EndPoints.invoices_mobile_codes);
    }

    @Test
    public void testGetInvoicesVoucherServices() {
        given().get(EndPoints.invoices_voucher_services);
    }

    @Test
    public void testGetInvoicesCommissions() {
        given().get(EndPoints.invoices_commissions);
    }

    @Test
    public void testPostInvoicesWithdraw() {
        auth().post(EndPoints.invoices_withdraw);
    }

    @Test
    public void testPostInvoicesExchange() {
        auth().post(EndPoints.invoices_exchange);
    }

    @Test
    public void testGetInvoicesExchangesRates() {
        given().get(EndPoints.invoices_exchanges_rates);
    }

    @Test
    public void testGetCountries() {
        given().get(EndPoints.countries);
    }

    @Test
    public void testGetMapPoints() {
        given().get(EndPoints.map_points);
    }

    @Test
    public void testGetNews() {
        given().get(EndPoints.news);
    }

    @Test
    public void testGetOperations() {
        auth().get(EndPoints.operations);
    }

    @Test
    public void testPostOperationsRead() {
        auth().post(EndPoints.operations_read);
    }

    @Test
    public void testGetSettings() {
        auth().get(EndPoints.settings);
    }

    @Test
    public void testGetSettingsOperations() {
        auth().get(EndPoints.settings_operations);
    }

    @Test
    public void testGetSettingsKyc() {
        auth().get(EndPoints.settings_kyc);
    }

    @Test
    public void testGetSettingsReceipts() {
        auth().get(EndPoints.settings_receipts);
    }

    @Test
    public void testGetSettingsReceiptsCountries() {
        auth().get(EndPoints.settings_receipts_countries);
    }

    @Test
    public void testGetSettingsLending() {
        auth().get(EndPoints.settings_lending);
    }

    @Test
    public void testGetSettingsDeposits() {
        auth().get(EndPoints.settings_deposits);
    }

    @Test
    public void testGetSettingsOnboarding() {
        given().get(EndPoints.settings_onboarding);
    }

    @Test
    public void testGetTransactionsHistory() {
        auth().get(EndPoints.transactions_history);
    }

    @Test
    public void testGetTransfersFrequent() {
        auth().get(EndPoints.transfers_frequent);
    }

    @Test
    public void testGetUsersProfile() {
        auth().get(EndPoints.users_profile);
    }

    @Test
    public void testPostUsersProfile() {
        given().post(EndPoints.users_profile);
    }

    @Test
    public void testPostUsersProfileTermsAgree() {
        auth().post(EndPoints.users_profile_terms_agree);
    }

    @Test
    public void testPostUsersProfileTermsIbanAgree() {
        auth().post(EndPoints.users_profile_terms_iban_agree);
    }

    @Test
    public void testGetUsersProfileLoyalty() {
        auth().get(EndPoints.users_profile_loyalty);
    }

    @Test
    public void testGetUsersProfileKyc0() {
        auth().get(EndPoints.users_profile_kyc0);
    }

    @Test
    public void testGetUsersProfileKyc1() {
        auth().get(EndPoints.users_profile_kyc1);
    }

    @Test
    public void testPostUsersProfileKyc1Verify() {
        auth().post(EndPoints.users_profile_kyc1_verify);
    }

    @Test
    public void testGetUsersProfileKyc2() {
        auth().get(EndPoints.users_profile_kyc2);
    }

    @Test
    public void testPostUsersProfileKyc2Verify() {
        auth().post(EndPoints.users_profile_kyc2_verify);
    }

}