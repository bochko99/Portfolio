package tests;


import com.crypterium.cryptApi.Auth;
import com.crypterium.cryptApi.oldback.pojos.bankwithdrawal.BankWithdrawalReqOffer;
import com.crypterium.cryptApi.oldback.pojos.bankwithdrawal.BankWithdrawalReqTransfer;
import com.crypterium.cryptApi.oldback.pojos.bankwithdrawal.BankWithdrawalRespOffer;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.MobileTest;

import java.math.BigDecimal;

import static core.Currency.BTC;


public class BankWithdrawalTest extends MobileTest {

    @Ignore
    @Test
    @DisplayName(EndPoints.bankwithdrawals_banks + " GET")
    public void testBanks() {

        Auth.service().auth().queryParam("bic", "044525745").get(EndPoints.bankwithdrawals_banks);

    }

    @Ignore
    @Test
    @DisplayName(EndPoints.bankwithdrawals_limits_rubank + " GET")
    public void testBanksLimitsRub() {

        Auth.service().auth().get(EndPoints.bankwithdrawals_limits_rubank);

    }

    @Ignore
    @Test
    @DisplayName(EndPoints.bankwithdrawals_limits_countries + " GET")
    public void testBanksLimitsCountries() {

        Auth.service().auth().get(EndPoints.bankwithdrawals_limits_countries);

    }

    @Ignore
    @Test
    @DisplayName(EndPoints.bankwithdrawals_rates_rubank + " GET")
    public void testBanksRates() {

        Auth.service().auth().queryParam("currency", BTC).get(EndPoints.bankwithdrawals_rates_rubank);

    }

    @Ignore
    @Test
    @Financial
    @DisplayName("Create Bank Offer")
    public void createOfferTest() {

        createOffer();

    }

    @Ignore
    @Test
    @Financial
    @DisplayName("Create Bank Transfer")
    public void createTransferTest() {

        BankWithdrawalReqOffer model = new BankWithdrawalReqOffer()
                .setAmount(new BigDecimal(1.0))
                .setCurrency(BTC);
        BankWithdrawalRespOffer offer = Auth.service().auth().body(model).post(EndPoints.bankwithdrawals_offers_rubank)
                .as(BankWithdrawalRespOffer.class);

        BankWithdrawalReqTransfer transfer = new BankWithdrawalReqTransfer()
                .setOfferId(offer.getId())
                .setTransferToMyself(true)
                .setAccountNumber("40817810123456789012")
                .setBankCorrAccountNumber("30101810345250000745")
                .setBic("044525745")
                .setPayeeFirstName("Тест")
                .setPayeeMiddleName("Тест")
                .setPayeeLastName("Тест");
        Auth.service().auth().body(transfer).post(EndPoints.bankwithdrawals_transfers_rubank);

    }

    public BankWithdrawalRespOffer createOffer() {

        BankWithdrawalReqOffer model = new BankWithdrawalReqOffer()
                .setAmount(new BigDecimal(0.002))
                .setCurrency(BTC);
        return Auth.service().auth().body(model).post(EndPoints.bankwithdrawals_offers_rubank)
                .as(BankWithdrawalRespOffer.class);


    }


}
