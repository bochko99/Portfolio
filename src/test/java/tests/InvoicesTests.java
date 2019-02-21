package tests;

import com.crypterium.cryptApi.pojos.UserPojo;
import com.crypterium.cryptApi.pojos.fundsWallet.FundswalletModel;
import com.crypterium.cryptApi.pojos.invoices.InvoiceBodyModel;
import com.crypterium.cryptApi.pojos.invoices.InvoiceFundsWalletModel;
import com.crypterium.cryptApi.pojos.invoices.InvoicesPaymentModel;
import com.crypterium.cryptApi.pojos.users.UsersProfileResponseModel;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import core.annotations.Credentials;
import core.annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.MobileTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static core.Auth.auth;
import static core.Auth.authSingle;
import static core.Currency.*;
import static io.restassured.RestAssured.given;
import static io.restassured.config.DecoderConfig.decoderConfig;
import static org.hamcrest.Matchers.*;

public class InvoicesTests extends MobileTest {

    private UserPojo recipient = new UserPojo()
            .setPhone("70000000091")
            .setPassword("testbeta91");

    public static Pair p(String currency, Float amount) {
        return new Pair(currency, amount);
    }

    @Test
    @Credentials(login = "70000000090", password = "testbeta90")
    public void transfersForEugene() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        String time = sdf.format(new Date());
        InvoiceBodyModel bodyModelCrpt = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.11" + time))
                .setCurrency(CRPT)
                .setCryptoWalletAddress(getWallet(recipient.getPhone(), recipient.getPassword(), CRPT))
                .setCommissionAmount(BigDecimal.ZERO);

        InvoiceBodyModel bodyModelETH = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.0013" + time))
                .setCurrency(ETH)
                .setWithdrawPersonNumber(getUserId(recipient.getPhone(), recipient.getPassword()))
                .setCommissionAmount(BigDecimal.ZERO);

        InvoiceBodyModel bodyModelBTC = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00014" + time))
                .setCurrency(BTC)
                .setWithdrawPersonLogin(recipient.getPhone())
                .setCommissionAmount(BigDecimal.ZERO);

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModelCrpt, commonInvoiceModelCallback(CRPT));
        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModelETH, commonInvoiceModelCallback(ETH));
        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModelBTC, commonInvoiceModelCallback(BTC));

    }

    @Test
    @Credentials(type = "au")
    @DisplayName(EndPoints.invoices_bpay + " POST")
    public void testPostInvoicesBpay() {
        auth().post(EndPoints.invoices_bpay);
    }

    @Test
    @Credentials(type = "au")
    @DisplayName(EndPoints.invoices_bpay_billers_code + " GET")
    public void testGetInvoicesBpayBillersCode() {
        given().pathParam("code", "96479")
                .get(EndPoints.invoices_bpay_billers_code)
                .then().body("name", Matchers.equalTo("Red Balloon"));
    }

    @Test
    @Credentials(type = "au")
    @DisplayName(EndPoints.invoices_bsb + " POST")
    public void testPostInvoicesBsb() {
        auth().post(EndPoints.invoices_bsb);
    }

    @Test
    @Credentials(type = "au")
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
        auth().config(RestAssured.config().decoderConfig(decoderConfig().noContentDecoders())).post(EndPoints.invoices_mobile);
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
        auth().get(EndPoints.invoices_commissions);
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
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(BTC)
                .setWithdrawPersonLogin(recipient.getPhone());

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by phone : LTC")
    public void testSendCryptoByPhoneLtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(LTC)
                .setWithdrawPersonLogin(recipient.getPhone());

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(LTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by phone : ETH")
    public void testSendCryptoByPhoneEth() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(ETH)
                .setWithdrawPersonLogin(recipient.getPhone());

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : CRPT")
    public void testSendCryptoByAddressCrpt() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(CRPT)
                .setCryptoWalletAddress((getWallet(recipient.getPhone(), recipient.getPassword(), CRPT)));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, feeInvoiceModelCallback(CRPT, ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : BTC")
    public void testSendCryptoByAddressBtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(BTC)
                .setCryptoWalletAddress((getWallet(recipient.getPhone(), recipient.getPassword(), BTC)));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : ETH")
    public void testSendCryptoByAddressEth() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(ETH)
                .setCryptoWalletAddress((getWallet(recipient.getPhone(), recipient.getPassword(), ETH)));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by address : LTC")
    public void testSendCryptoByAddressLtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(LTC)
                .setCryptoWalletAddress((getWallet(recipient.getPhone(), recipient.getPassword(), LTC)));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(LTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by userID : CRPT")
    public void testSendCryptoByUserIDCrpt() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(CRPT)
                .setWithdrawPersonNumber(getUserId(recipient.getPhone(), recipient.getPassword()));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, feeInvoiceModelCallback(CRPT, ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by userID : BTC")
    public void testSendCryptoByUserIDBtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(BTC)
                .setWithdrawPersonNumber(getUserId(recipient.getPhone(), recipient.getPassword()));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by userID : ETH")
    public void testSendCryptoByUserIDEth() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(ETH)
                .setWithdrawPersonNumber(getUserId(recipient.getPhone(), recipient.getPassword()));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(ETH));
    }

    @Financial
    @Test
    @DisplayName("Send crypto by userID : LTC")
    public void testSendCryptoByUserIDLtc() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(LTC)
                .setWithdrawPersonNumber(getUserId(recipient.getPhone(), recipient.getPassword()));

        testInvoice(commonInvoiceCreator(EndPoints.invoices_withdraw), bodyModel, commonInvoiceModelCallback(LTC));
    }

    @Ignore
    @Test
    @DisplayName("Bank transfer: IBAN")
    //TODO
    public void testPutInvoicesId() {
        String iban = "gb77barc20201530093459";
        String code = given().pathParam("iban", iban).get(EndPoints.invoices_iban_banks_iban)
                .then().extract().body().jsonPath().getString("code");

        String invoiceId = auth().post(EndPoints.invoices_iban).jsonPath().getString("id");

        InvoiceBodyModel model = new InvoiceBodyModel()
                .setIban(iban)
                .setBankCode(code)
                .setReceiverFirstName("Test")
                .setReceiverLastName("LastName")
                .setAmount(new BigDecimal("3"));

        JsonPath response = auth().body(model).pathParam("id", invoiceId).put(EndPoints.invoices_id).jsonPath();
        Float feeAmount = response.getFloat("fee.customerCommissionAmount");
        Float totalAmount = response.getFloat("totalAmount");
        InvoicesPaymentModel paymentModel = createInvoicesPaymentModel("1111", p(BTC, totalAmount), p(CRPT, feeAmount));

        auth().body(paymentModel).pathParam("id", invoiceId).post(EndPoints.invoices_id_payments);

    }

    @Ignore
    @Test
    @Financial
    @DisplayName("Exchange")
    public void testExchange() {

        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(BTC);

        testInvoice(commonInvoiceCreator(EndPoints.invoices_exchange), bodyModel, commonInvoiceModelCallback(BTC));
    }

    @Financial
    @Test
    @DisplayName("BPay")
    @Credentials(type = "au")
    public void testBPay() {

        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setBPayBiller("96479")
                .setBPayRef("000")
                .setMobile(Environment.CREDENTIALS.get("au").getLogin())
                .setAmount(new BigDecimal("30"))
                .setCurrency("AUD");

        testInvoice(commonInvoiceCreator(EndPoints.invoices_bpay), bodyModel, australianCallback());

    }


    @Financial
    @Test
    @DisplayName("BSB")
    @Credentials(type = "au")
    public void testBSB() {

        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setBsb("124001")
                .setAccountNumber("000000")
                .setReceiverFirstName("TEST")
                .setPaymentPurpose("TEST")
                .setMobile(Environment.CREDENTIALS.get("au").getLogin())
                .setAmount(new BigDecimal("30"))
                .setCurrency("AUD");
        testInvoice(commonInvoiceCreator(EndPoints.invoices_bsb), bodyModel, australianCallback());

    }

    @Financial
    @Test
    @DisplayName("Mobile")
    public void testMobile() {
        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setMobile("79163164205")
                .setAmount(new BigDecimal("10"));
        testInvoice(commonInvoiceCreator(EndPoints.invoices_mobile), bodyModel, feeTopUpMobileCallback());


    }


    @Financial
    @Test
    @DisplayName("Voucher")
    public void testVoucher() {

        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setMobile(Environment.CREDENTIALS.get("default").getLogin())
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(BTC);
        InvoiceCreator voucherCreator = () -> auth().pathParam("service", "Viber")
                .post(EndPoints.invoices_voucher_service).jsonPath().getString("id");
        testInvoice(voucherCreator, bodyModel, feeInvoiceModelCallback(BTC, CRPT));

    }

    @Financial
    @Test
    @DisplayName("Bank Transfer")
    public void testBankTransfer() {

        InvoiceBodyModel bodyModel = new InvoiceBodyModel()
                .setReceiverFirstName("TEST")
                .setReceiverLastName("TEST")
                .setBankCode("REVOGB21")
                .setIban("gb77barc20201530093459")
                .setMobile(Environment.CREDENTIALS.get("default").getLogin())
                .setAmount(new BigDecimal("0.00001"))
                .setCurrency(BTC);
        testInvoice(commonInvoiceCreator(EndPoints.invoices_iban), bodyModel, feeInvoiceModelCallback(BTC, CRPT));

    }

    private String getWallet(String login, String password, String currency) {
        FundswalletModel[] wallets = authSingle(login, password).get(EndPoints.fundswallets).as(FundswalletModel[].class);
        return Stream.of(wallets).filter(w -> w.getCurrency().equalsIgnoreCase(currency)).findFirst().get().getDescription();
    }

    private String getWallet(String currency) {
        FundswalletModel[] wallets = auth().get(EndPoints.fundswallets).as(FundswalletModel[].class);
        return Stream.of(wallets).filter(w -> w.getCurrency().equalsIgnoreCase(currency)).findFirst().get().getDescription();
    }

    private String getUserId(String login, String password) {
        return authSingle(login, password).get(EndPoints.users_profile).as(UsersProfileResponseModel.class).getNumber().toString();
    }

    private String getUserId() {
        return auth().get(EndPoints.users_profile).as(UsersProfileResponseModel.class).getNumber().toString();
    }

    private void testInvoice(InvoiceCreator invoiceCreator, InvoiceBodyModel bodyModel, InvoiceModelCallback modelCallback) {
        //create invoice
        String invoiceId = invoiceCreator.create();

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

    private InvoiceModelCallback australianCallback() {
        return response -> {
            Float amount = response.getFloat("customData.cryptoWalletAmount");
            Float fee = response.getFloat("fee.customerCommissionAmount");
            return createInvoicesPaymentModel("1111", p(BTC, amount), p(CRPT, fee));
        };
    }

    private InvoiceModelCallback feeTopUpMobileCallback() {
        return response -> {
            Float amount = response.getFloat("totalAmount");
            Float fee = response.getFloat("fee.customerCommissionAmount");
            return createInvoicesPaymentModel("1111", p(BTC, amount), p(CRPT, fee));
        };
    }

    private InvoiceCreator commonInvoiceCreator(String endpoint) {

        return () -> createInvoice(endpoint);

    }

    @FunctionalInterface
    private interface InvoiceModelCallback {
        InvoicesPaymentModel create(JsonPath response);
    }

    @FunctionalInterface
    private interface InvoiceCreator {
        String create();
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
