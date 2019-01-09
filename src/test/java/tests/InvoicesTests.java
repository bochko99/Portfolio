package tests;

import annotations.Financial;
import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.*;
import pojos.fundsWallet.FundswalletModel;
import pojos.invoices.InvoiceBodyModel;
import pojos.invoices.InvoiceFundsWalletModel;
import pojos.invoices.InvoicesPaymentModel;
import pojos.users.UsersProfileResponseModel;
import rules.FinancialAnnotationRule;
import utils.EndPoints;
import utils.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static core.Auth.auth;
import static core.Currency.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class InvoicesTests {

    @Rule
    public FinancialAnnotationRule annotation = new FinancialAnnotationRule();


    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Before
    public void checkSkipNeed() {
        Assume.assumeTrue(annotation.getAnnotation() == null
                || "true".equalsIgnoreCase(Environment.FINANCE_OPERATIONS_ALLOWED));
    }

    public static Pair p(String currency, Float amount) {
        return new Pair(currency, amount);
    }

    @Test
    @DisplayName(EndPoints.invoices_bpay + " POST")
    public void testPostInvoicesBpay() {
        auth().post(EndPoints.invoices_bpay);
    }

    @Test
    @DisplayName(EndPoints.invoices_bpay_billers_code + " GET")
    public void testGetInvoicesBpayBillersCode() {
        given().pathParam("code", "96479")
                .get(EndPoints.invoices_bpay_billers_code)
                .then().body("name", Matchers.equalTo("Red Balloon"));
    }

    @Test
    @DisplayName(EndPoints.invoices_bsb + " POST")
    public void testPostInvoicesBsb() {
        auth().post(EndPoints.invoices_bsb);
    }

    @Test
    @DisplayName(EndPoints.invoices_bsb_banks_code + " GET")
    public void testGetInvoicesBsbBanksCode() {
        given().pathParam("code", "911001")
                .get(EndPoints.invoices_bsb_banks_code)
                .then().body("name", Matchers.equalTo("Sumitomo Mitsui"));
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
    @DisplayName(EndPoints.invoices_mobile_country_providers + " GET")
    public void testGetInvoicesMobileCountryProviders() {
        given().pathParam("country", "RU")
                .get(EndPoints.invoices_mobile_country_providers)
                .then().body("size()", greaterThan(0));
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
        auth().get(EndPoints.invoices_exchanges_rates).then().body("size()", greaterThan(0));
    }

    @Test
    @DisplayName(EndPoints.invoices_id + " GET")
    public void testGetInvoicesId() {
        String id = auth().post(EndPoints.invoices_exchange).then().extract().body().jsonPath().get("id");
        auth().pathParam("id", id).get(EndPoints.invoices_id);
    }

    @Financial
    @Test
    @DisplayName("Send crypto by phone : BTC")
    public void testSendCryptoByPhoneBtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(BTC)
                .setMobile("70000000040");

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by phone : LTC")
    public void testSendCryptoByPhoneLtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(LTC)
                .setMobile("70000000040");

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(LTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by phone : ETH")
    public void testSendCryptoByPhoneEth() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(ETH)
                .setMobile("70000000040");

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : CRPT")
    public void testSendCryptoByAddressCrpt() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(CRPT)
                .setCryptoWalletAddress(getWallet(CRPT));

        testInvoice(EndPoints.invoices_withdraw, bodyModel, feeInvoiceModelCallback(CRPT, ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : BTC")
    public void testSendCryptoByAddressBtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(BTC)
                .setCryptoWalletAddress(getWallet(BTC));

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : ETH")
    public void testSendCryptoByAddressEth() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(ETH)
                .setCryptoWalletAddress(getWallet(ETH));

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : LTC")
    public void testSendCryptoByAddressLtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(LTC)
                .setCryptoWalletAddress(getWallet(LTC));

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(LTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by userID : CRPT")
    public void testSendCryptoByUserIDCrpt() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(CRPT)
                .setAccountNumber(getUserId());

        testInvoice(EndPoints.invoices_withdraw, bodyModel, feeInvoiceModelCallback(CRPT, ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : BTC")
    public void testSendCryptoByUserIDBtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(BTC)
                .setAccountNumber(getUserId());

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : ETH")
    public void testSendCryptoByUserIDEth() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(ETH)
                .setAccountNumber(getUserId());

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : LTC")
    public void testSendCryptoByUserIDLtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(LTC)
                .setAccountNumber(getUserId());

        testInvoice(EndPoints.invoices_withdraw, bodyModel, commonInvoiceModelCallback(LTC));
    }

    @Ignore
    @Test
    @DisplayName(EndPoints.invoices_id + " PUT")
    public void testPutInvoicesId() {
        String iban = "gb77barc20201530093459";
        String code = given().pathParam("iban", iban).get(EndPoints.invoices_iban_banks_iban).then().extract().body().jsonPath().getString("code");

        String invoiceId = auth().post(EndPoints.invoices_iban).jsonPath().getString("id");

        InvoiceBodyModel model = new InvoiceBodyModel()
                .setIban(iban)
                .setBankCode(code)
                .setReceiverFirstName("Test")
                .setReceiverLastName("LastName")
                .setAmount(3f);

        JsonPath response = auth().body(model).pathParam("id", invoiceId).put(EndPoints.invoices_id).jsonPath();
        Float feeAmount = response.getFloat("fee.customerCommissionAmount");
        Float totalAmount = response.getFloat("totalAmount");
        InvoicesPaymentModel paymentModel = createInvoicesPaymentModel("1111", p(BTC, totalAmount), p(CRPT, feeAmount));

        auth().body(paymentModel).pathParam("id", invoiceId).post(EndPoints.invoices_id_payments);

    }

    @Test
    @Financial
    @DisplayName("Exchange")
    public void testExchange() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(0.00001f)
                .setCurrency(BTC);

        testInvoice(EndPoints.invoices_exchange, bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("BPay")
    public void testBPay() {

    }


    private String getWallet(String currency) {
        FundswalletModel[] wallets = auth().get(EndPoints.fundswallets).as(FundswalletModel[].class);
        return Stream.of(wallets).filter(w -> w.getCurrency().equalsIgnoreCase(currency)).findFirst().get().getDescription();
    }

    private String getUserId() {
        return auth().get(EndPoints.users_profile).as(UsersProfileResponseModel.class).getNumber().toString();
    }

    private void testInvoice(String invoiceEndPoint, InvoiceBodyModel bodyModel, InvoiceModelCallback modelCallback) {
        //create invoice
        String invoiceId = createInvoice(invoiceEndPoint);

        //Put data to invoice
        JsonPath response = auth().body(bodyModel).pathParam("id", invoiceId).put(EndPoints.invoices_id).jsonPath();

        //Post payment
        InvoicesPaymentModel paymentModel = modelCallback.create(response);
        auth().body(paymentModel).pathParam("id", invoiceId).post(EndPoints.invoices_id_payments);

        auth().queryParam("take", 5).get(EndPoints.operations)
                .then().assertThat().body("id", hasItem(invoiceId))
                .body("find { it.id == '" + invoiceId + "'}.status", not("Failed"));

    }

    private String createInvoice(String endpoint) {
        return auth().post(endpoint).jsonPath().getString("id");
    }

    private InvoicesPaymentModel createInvoicesPaymentModel(String pin, Pair... pairs) {
        List<InvoiceFundsWalletModel> walletsData = new ArrayList<>();
        FundswalletModel[] wallets = auth().get(EndPoints.fundswallets).as(FundswalletModel[].class);


        for (Pair p : pairs) {
            FundswalletModel wallet = Stream.of(wallets).filter(w -> w.getCurrency().equalsIgnoreCase(p.getCurrency())).findFirst().orElse(null);
            walletsData.add(new InvoiceFundsWalletModel().setId(wallet.getId()).setAmount(p.getAmount()));
        }

        return new InvoicesPaymentModel().setFundsWallets(walletsData).setPassword(pin);
    }

    private InvoiceModelCallback commonInvoiceModelCallback(String currency) {
        return response -> {
            Float totalAmount = response.getFloat("totalAmount");
            return createInvoicesPaymentModel("1111", p(currency, totalAmount));
        };
    }

    private InvoiceModelCallback feeInvoiceModelCallback(String currencyOrigin, String currencyFee) {
        return response -> {
            Float amount = response.getFloat("amount");
            Float fee = response.getFloat("fee.customerCommissionAmount");
            return createInvoicesPaymentModel("1111", p(currencyOrigin, amount), p(currencyFee, fee));
        };
    }

    @FunctionalInterface
    private interface InvoiceModelCallback {
        InvoicesPaymentModel create(JsonPath response);
    }

    private static class Pair {

        private String currency;
        private Float amount;

        public Pair(String currency, Float amount) {
            this.currency = currency;
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public Pair setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Float getAmount() {
            return amount;
        }

        public Pair setAmount(Float amount) {
            this.amount = amount;
            return this;
        }
    }

}
