package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;
import static io.restassured.RestAssured.given;

public class InvoicesTests {

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

}
