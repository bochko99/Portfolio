package tests;

import com.crypterium.cryptApi.newback.pojos.banks.*;
import com.crypterium.cryptApi.newback.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.utils.Constants;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.newback.pojos.banks.WithdrawalCurrency.BTC;
import static com.crypterium.cryptApi.newback.pojos.banks.WithdrawalCurrency.EUR;

public class BanksWithdrawalsTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.banks_ru + " GET")
    public void testbanksRu() {
        SpecStorage.banks().queryParam("bic", "044525225").get(EndPoints.banks_ru).then()
                .body("fullName", Matchers.equalTo("ПАО СБЕРБАНК"));
    }

    @Test
    @DisplayName(EndPoints.banks_eu + " GET")
    public void testbanksEu() {
        SpecStorage.banks().get(EndPoints.banks_eu);
    }

    @Test
    @DisplayName(EndPoints.limits_countries + " GET")
    public void testlimitsCountries() {
        SpecStorage.banks().get(EndPoints.limits_countries);
    }

    @Test
    @DisplayName(EndPoints.limits_iban + " GET")
    public void testLimitsIban() {
        SpecStorage.banks().get(EndPoints.limits_iban);
    }

    @Test
    @DisplayName(EndPoints.limits_rubank + " GET")
    public void testLimitsRubank() {
        SpecStorage.banks().get(EndPoints.limits_rubank);
    }

    @Test
    @DisplayName(EndPoints.rates_from_to_to + " GET")
    public void testRatesFromToTo() {
        SpecStorage.banks().get(EndPoints.rates_from_to_to);
    }

    @Test
    @DisplayName(EndPoints.offers_rubank + ": DepositAmount")
    public void testPostOffersRubankDepositAmount() {

        BanksLimitsRubankModel limits = SpecStorage.banks().queryParam("tenantId", Constants.TENANT_ID_CRYPTERIUM)
                .get(EndPoints.limits_rubank)
                .as(BanksLimitsRubankModel.class);
        Assert.assertTrue("No currencies available for rubank withdrawal", limits.getAllowedWithdrawCurrencies().size() > 0);
        BigDecimal amountInEuro = limits.getMinAmountEuro();

        BigDecimal rate = new BigDecimal(SpecStorage.banks().queryParam("sourceAmount", amountInEuro)
                .pathParam("from", EUR)
                .pathParam("to", WithdrawalCurrency.RUB)
                .get(EndPoints.rates_from_to_to)
                .then().extract().body().jsonPath().getString("value"));

        BigDecimal amount = amountInEuro.multiply(rate).setScale(0, RoundingMode.CEILING);

        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        WithdrawalCurrency currency = limits.getAllowedWithdrawCurrencies().get(0);
        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.DEPOSIT_AMOUNT)
                .setWithdrawCurrency(currency);

        BanksOfferResponseModel response = SpecStorage.banks().body(model).post(EndPoints.offers_rubank)
                .then()
                .body("id", Matchers.notNullValue())
                .body("rate", Matchers.notNullValue())
                .body("withdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("totalWithdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("deposit.currency", Matchers.equalTo("RUB"))
                .body("deposit.amount", Matchers.equalTo(amount.floatValue()))
                .extract().as(BanksOfferResponseModel.class);

        BigDecimal withdrawalAmount = response.getWithdrawal().getAmount();
        BigDecimal feeAmount = response.getFee().getAmount();
        BigDecimal depositAmount = response.getDeposit().getAmount();

        Assert.assertThat(response.getTotalWithdrawal().getAmount(), Matchers.equalTo(withdrawalAmount.add(feeAmount)));
        Assert.assertThat(withdrawalAmount, Matchers.equalTo(depositAmount.divide(response.getRate(), 6, RoundingMode.CEILING)));

    }

    @Test
    @DisplayName(EndPoints.offers_rubank + ": WithdrawAmount")
    public void testPostOffersRubankWithdrawAmount() {

        BanksLimitsRubankModel limits = SpecStorage.banks().queryParam("tenantId", Constants.TENANT_ID_CRYPTERIUM)
                .get(EndPoints.limits_rubank)
                .as(BanksLimitsRubankModel.class);
        Assert.assertTrue("No currencies available for rubank withdrawal", limits.getAllowedWithdrawCurrencies().size() > 0);
        BigDecimal amountInEuro = limits.getMinAmountEuro();

        BigDecimal rate = new BigDecimal(SpecStorage.banks()
                .pathParam("from", BTC)
                .pathParam("to", EUR)
                .get(EndPoints.rates_from_to_to)
                .then().extract().body().jsonPath().getString("value"));

        BigDecimal amount = amountInEuro.divide(rate, 6, RoundingMode.CEILING);

        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        WithdrawalCurrency currency = limits.getAllowedWithdrawCurrencies().get(0);
        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.WITHDRAW_AMOUNT)
                .setWithdrawCurrency(currency);

        BanksOfferResponseModel response = SpecStorage.banks().body(model).post(EndPoints.offers_rubank)
                .then()
                .body("id", Matchers.notNullValue())
                .body("rate", Matchers.notNullValue())
                .body("withdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("totalWithdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("deposit.currency", Matchers.equalTo("RUB"))
                .body("withdrawal.amount", Matchers.equalTo(amount.floatValue()))
                .extract().as(BanksOfferResponseModel.class);

        BigDecimal withdrawalAmount = response.getWithdrawal().getAmount();
        BigDecimal feeAmount = response.getFee().getAmount();
        BigDecimal depositAmount = response.getDeposit().getAmount();

        Assert.assertThat(response.getTotalWithdrawal().getAmount(), Matchers.equalTo(withdrawalAmount.add(feeAmount)));
        Assert.assertThat(depositAmount, Matchers.equalTo(withdrawalAmount.multiply(response.getRate()).setScale(2, RoundingMode.CEILING)));

    }

    @Test
    @DisplayName(EndPoints.offers_iban + " DepositAmount")
    public void testPostOffersIbanDepositAmount() {
        BanksLimitsRubankModel limits = SpecStorage.banks().queryParam("tenantId", Constants.TENANT_ID_CRYPTERIUM)
                .get(EndPoints.limits_iban)
                .as(BanksLimitsRubankModel.class);
        Assert.assertTrue("No currencies available for iban withdrawal", limits.getAllowedWithdrawCurrencies().size() > 0);
        BigDecimal amount = limits.getMinAmountEuro();

        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        WithdrawalCurrency currency = limits.getAllowedWithdrawCurrencies().get(0);
        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.DEPOSIT_AMOUNT)
                .setWithdrawCurrency(currency);

        BanksOfferResponseModel response = SpecStorage.banks().body(model).post(EndPoints.offers_iban)
                .then()
                .body("id", Matchers.notNullValue())
                .body("rate", Matchers.notNullValue())
                .body("withdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("totalWithdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("deposit.currency", Matchers.equalTo(EUR.toString()))
                .body("deposit.amount", Matchers.equalTo(amount.floatValue()))
                .extract().as(BanksOfferResponseModel.class);

        BigDecimal withdrawalAmount = response.getWithdrawal().getAmount();
        BigDecimal feeAmount = response.getFee().getAmount();
        BigDecimal depositAmount = response.getDeposit().getAmount();

        Assert.assertThat(response.getTotalWithdrawal().getAmount(), Matchers.equalTo(withdrawalAmount.add(feeAmount)));
        Assert.assertThat(withdrawalAmount, Matchers.equalTo(depositAmount.divide(response.getRate(), 6, RoundingMode.CEILING)));

    }

    @Test
    @DisplayName(EndPoints.offers_iban + " WithdrawAmount")
    public void testPostOffersIbanWithdrawAmount() {
        BanksLimitsRubankModel limits = SpecStorage.banks().queryParam("tenantId", Constants.TENANT_ID_CRYPTERIUM)
                .get(EndPoints.limits_iban)
                .as(BanksLimitsRubankModel.class);
        Assert.assertTrue("No currencies available for iban withdrawal", limits.getAllowedWithdrawCurrencies().size() > 0);

        BigDecimal amountInEuro = limits.getMinAmountEuro();

        BigDecimal rate = new BigDecimal(SpecStorage.banks()
                .pathParam("from", BTC)
                .pathParam("to", EUR)
                .get(EndPoints.rates_from_to_to)
                .then().extract().body().jsonPath().getString("value"));

        BigDecimal amount = amountInEuro.divide(rate, 6, RoundingMode.CEILING);

        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        WithdrawalCurrency currency = limits.getAllowedWithdrawCurrencies().get(0);
        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.WITHDRAW_AMOUNT)
                .setWithdrawCurrency(currency);

        BanksOfferResponseModel response = SpecStorage.banks().body(model).post(EndPoints.offers_iban)
                .then()
                .body("id", Matchers.notNullValue())
                .body("rate", Matchers.notNullValue())
                .body("withdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("totalWithdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("deposit.currency", Matchers.equalTo(EUR.toString()))
                .body("withdrawal.amount", Matchers.equalTo(amount.floatValue()))
                .extract().as(BanksOfferResponseModel.class);

        BigDecimal withdrawalAmount = response.getWithdrawal().getAmount();
        BigDecimal feeAmount = response.getFee().getAmount();
        BigDecimal depositAmount = response.getDeposit().getAmount();

        Assert.assertThat(response.getTotalWithdrawal().getAmount(), Matchers.equalTo(withdrawalAmount.add(feeAmount)));
        Assert.assertThat(depositAmount, Matchers.equalTo(withdrawalAmount.multiply(response.getRate()).setScale(2, RoundingMode.CEILING)));

    }

    @Test
    @DisplayName(EndPoints.offers_id + " GET: WithdrawAmount")
    public void testGetOffersIdWithdrawAmount() {
        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        WithdrawalCurrency currency = BTC;
        BigDecimal amount = new BigDecimal("1");


        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.WITHDRAW_AMOUNT)
                .setWithdrawCurrency(currency);
        String id = SpecStorage.banks().body(model).post(EndPoints.offers_iban).jsonPath().getString("id");

        SpecStorage.banks()
                .pathParam("id", id).get(EndPoints.offers_id)
                .then()
                .body("id", Matchers.equalTo(id))
                .body("withdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("withdrawal.amount", Matchers.equalTo(amount.floatValue()));
    }

    @Test
    @DisplayName(EndPoints.offers_id + " GET: DepositAmount")
    public void testAsdOffersIdDepositAmount() {
        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        WithdrawalCurrency currency = BTC;
        BigDecimal amount = new BigDecimal("50");


        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.DEPOSIT_AMOUNT)
                .setWithdrawCurrency(currency);

        String id = SpecStorage.banks().body(model).post(EndPoints.offers_iban).jsonPath().getString("id");

        SpecStorage.banks()
                .pathParam("id", id).get(EndPoints.offers_id)
                .then()
                .body("id", Matchers.equalTo(id))
                .body("withdrawal.currency", Matchers.equalTo(currency.toString()))
                .body("deposit.amount", Matchers.equalTo(amount.floatValue()));
    }

    @Test
    @DisplayName(EndPoints.withdrawals_ru_individual + " POST: 5 EUR")
    public void testPostWithdrawalsRuIndividual() throws InterruptedException {

        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        BigDecimal rate = new BigDecimal(SpecStorage.banks()
                .pathParam("from", EUR)
                .pathParam("to", WithdrawalCurrency.RUB)
                .get(EndPoints.rates_from_to_to)
                .then().extract().body().jsonPath().getString("value"));

        BigDecimal amount = new BigDecimal("5").multiply(rate).setScale(0, RoundingMode.CEILING);

        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.DEPOSIT_AMOUNT)
                .setWithdrawCurrency(BTC);
        String id = SpecStorage.banks().body(model).post(EndPoints.offers_rubank).jsonPath().getString("id");

        Payer payer = new Payer()
                .setPersonId(customerId)
                .setTenantId(Constants.TENANT_ID_CRYPTERIUM)
                .setFirstName("Test")
                .setLastName("Testov")
                .setCountry("RU")
                .setZip("Not have one")
                .setCity("Москва")
                .setStreet("Тестовская ул., д. 6, кв. 666")
                .setDocumentType("Passport")
                .setDocumentNumber("0000000000")
                .setDocumentIssuedCountryCode("RU")
                .setDocumentIssuedBy("УФМС по Тестовскому району")
                .setDocumentIssuedDate("1999-01-01")
                .setKycLevel(2L)
                .setKycStatus("green");

        RuRequisites requisites = new RuRequisites()
                .setBankBic("044525225")
                .setBankAccountNumber("40817810438176000000")
                .setBankCorrAccountNumber("30101810400000000225")
                .setPayeeFirstName("Другой")
                .setPayeeLastName("Пользователь")
                .setPayeeMiddleName("Тестович");

        BanksWithdrawalRuIndRequestModel request = new BanksWithdrawalRuIndRequestModel()
                .setOfferId(id)
                .setPayer(payer)
                .setRequisites(requisites)
                .setPaymentPurpose("Перевод собственных средств");

        String withdrawalId = SpecStorage.banks().body(request).post(EndPoints.withdrawals_ru_individual).jsonPath().getString("id");

        String status;
        int count = 0;
        int limit = 10;

        do {
            Thread.sleep(60000);
            status = SpecStorage.banks().pathParam("withdrawalId", withdrawalId)
                    .get(EndPoints.withdrawals_withdrawalId).jsonPath().getString("status");
            count++;

            String errMsg = String.format("Status hasn't change from %s for %s minutes", status, limit);
            Assert.assertTrue(errMsg, count <= limit);
        } while (!status.equalsIgnoreCase("Completed"));

    }

    @Test
    @DisplayName(EndPoints.withdrawals_eu_individual + " POST: 5 EUR")
    public void testPostWithdrawalsEuIndividual() throws InterruptedException {
        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        BigDecimal amount = new BigDecimal("5.0");

        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.DEPOSIT_AMOUNT)
                .setWithdrawCurrency(BTC);
        String id = SpecStorage.banks().body(model).post(EndPoints.offers_iban).jsonPath().getString("id");

        Payer payer = new Payer()
                .setPersonId(customerId)
                .setTenantId(Constants.TENANT_ID_CRYPTERIUM)
                .setFirstName("Test")
                .setLastName("Testov")
                .setCountry("GB")
                .setDocumentType("Passport")
                .setDocumentNumber("0000000000")
                .setDocumentIssuedCountryCode("GB")
                .setDocumentIssuedBy("Some authority")
                .setDocumentIssuedDate("1999-01-01")
                .setKycLevel(2L)
                .setKycStatus("green");

        EuRequisites requisites = new EuRequisites()
                .setPayeeFirstName("Другой")
                .setPayeeLastName("Пользователь")
                .setIban("GB64NAIA07009300123456");

        BanksWithdrawalEuIndRequestModel request = new BanksWithdrawalEuIndRequestModel()
                .setOfferId(id)
                .setPayer(payer)
                .setRequisites(requisites)
                .setPaymentPurpose("Transfer");

        String withdrawalId = SpecStorage.banks().body(request).post(EndPoints.withdrawals_eu_individual).jsonPath().getString("id");

        String status;
        int count = 0;
        int limit = 10;

        do {
            Thread.sleep(60000);
            status = SpecStorage.banks().pathParam("withdrawalId", withdrawalId)
                    .get(EndPoints.withdrawals_withdrawalId).jsonPath().getString("status");
            count++;

            String errMsg = String.format("Status hasn't change from %s for %s minutes", status, limit);
            Assert.assertTrue(errMsg, count <= limit);
        } while (!status.equalsIgnoreCase("Completed"));
    }

    @Test
    @DisplayName(EndPoints.withdrawals_eu_corporate + " POST: 5 EUR")
    public void testPostWithdrawalsEuCorporate() throws InterruptedException {
        Long customerId = service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class).getCustomerId();
        BigDecimal amount = new BigDecimal("5.0");

        BanksOfferRequestModel model = new BanksOfferRequestModel()
                .setPersonId(customerId)
                .setAmount(amount)
                .setAmountKind(AmountKind.DEPOSIT_AMOUNT)
                .setWithdrawCurrency(BTC);
        String id = SpecStorage.banks().body(model).post(EndPoints.offers_iban).jsonPath().getString("id");

        Payer payer = new Payer()
                .setPersonId(customerId)
                .setTenantId(Constants.TENANT_ID_CRYPTERIUM)
                .setFirstName("Test")
                .setLastName("Testov")
                .setCountry("GB")
                .setDocumentType("Passport")
                .setDocumentNumber("0000000000")
                .setDocumentIssuedCountryCode("GB")
                .setDocumentIssuedBy("Some authority")
                .setDocumentIssuedDate("1999-01-01")
                .setKycLevel(2L)
                .setKycStatus("green");

        EuCorpRequisites requisites = new EuCorpRequisites()
                .setPayeeCorporateName("Test IO")
                .setIban("GB64NAIA07009300123456");

        BanksWithdrawalEuCorpRequestModel request = new BanksWithdrawalEuCorpRequestModel()
                .setOfferId(id)
                .setPayer(payer)
                .setRequisites(requisites)
                .setPaymentPurpose("Transfer");

        String withdrawalId = SpecStorage.banks().body(request).post(EndPoints.withdrawals_eu_corporate).jsonPath().getString("id");

        String status;
        int count = 0;
        int limit = 10;

        do {
            Thread.sleep(60000);
            status = SpecStorage.banks().pathParam("withdrawalId", withdrawalId)
                    .get(EndPoints.withdrawals_withdrawalId).jsonPath().getString("status");
            count++;

            String errMsg = String.format("Status hasn't change from %s for %s minutes", status, limit);
            Assert.assertTrue(errMsg, count <= limit);
        } while (!status.equalsIgnoreCase("Completed"));
    }

}
