package tests;

import com.crypterium.cryptApi.exceptions.NoSuchWalletException;
import com.crypterium.cryptApi.exceptions.NoWalletsException;
import com.crypterium.cryptApi.newback.pojos.wallets.*;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.newback.pojos.wallets.Currency.*;

public class WalletsTests extends ExwalTest {

    private CredentialEntry recipient = ApiCommonFunctions.getRecipient();

    @Test
    @DisplayName(EndPoints.wallet_wallet_id + " GET")
    public void testWalletId() {
        WalletListResp response = service().auth().get(EndPoints.wallet_list).then()
                .body("wallets.size()", Matchers.greaterThan(0))
                .extract().as(WalletListResp.class);
        Long id = response.getWallets().get(0).getId();

        service().auth().pathParams("walletId", id).get(EndPoints.wallet_wallet_id);
    }

    @Test
    @Ignore
    @DisplayName(EndPoints.wallet_address_currency + " GET")
    public void testWalletAddress() {

        service().auth().pathParams("currency", BTC)
                .get(EndPoints.wallet_address_currency).as(Wallet.class);

    }

    @Test
    @DisplayName(EndPoints.wallet_currencies_ex + " GET")
    public void testWalletCurrencies() {

        service().auth().get(EndPoints.wallet_currencies_ex);
    }

    @Test
    @DisplayName(EndPoints.wallet_list + " GET")
    public void testWalletList() {

        service().auth().get(EndPoints.wallet_list);

    }

    @Test
    @DisplayName(EndPoints.wallet_mobile_sx_rates + " GET")
    public void testWalletRates() {

        service().auth().get(EndPoints.wallet_mobile_sx_rates);
    }

    @Test
    @DisplayName(EndPoints.wallet_mobile_sx_rates_currency + " GET")
    public void testWalletRate() {

        service().auth().pathParam("currency", EUR).get(EndPoints.wallet_mobile_sx_rates_currency);
    }


    @Test
    @DisplayName(EndPoints.wallet_send_fee_currency + " GET")
    public void testWalletFee() {
        List<Wallet> wallets = service().auth().get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        Wallet wallet = wallets.stream().filter(e -> e.getBalance().compareTo(new BigDecimal("0.001")) >= 0)
                .findFirst().orElseThrow(() -> new NoSuchWalletException("No wallet with balance >= 0.001 presented"));
        service().auth().queryParam("address", wallet.getAddress())
                .pathParams("currency", wallet.getCurrency())
                .queryParam("amount", "0.0001").get(EndPoints.wallet_send_fee_currency)
                .as(FeeResponse.class);
    }

    @Test
    @DisplayName(EndPoints.wallet_transaction_ex + " GET")
    public void testWalletTransac() {

        service().auth().get(EndPoints.wallet_transaction_ex);
    }

    @Test
    @DisplayName(EndPoints.wallet_verify_currency_address + " GET")
    public void testWalletValidateAddress() {
        List<Wallet> wallets = service().authSingle(recipient.getLogin(), recipient.getPassword())
                .get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        if (wallets.size() == 0) {
            throw new NoWalletsException();
        }
        Wallet wallet = wallets.get(0);
        String address = wallet.getAddress();

        service().auth().pathParam("address", address)
                .pathParams("currency", wallet.getCurrency())
                .get(EndPoints.wallet_verify_currency_address)
                .then().body("verified", Matchers.equalTo(true));
    }

    //SEND CRYPTO

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testLTCbyPhone() {
        testSendCrypto(commonBodyForPhone(LTC, "0.001"));
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto BTC by phone")
    public void testBTCbyPhone() {
        testSendCrypto(commonBodyForPhone(BTC, "0.00001"));
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto ETH by phone")
    public void testETHbyPhone() {
        testSendCrypto(commonBodyForPhone(ETH, "0.0001"));
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto CRPT by phone")
    public void testCRPTbyPhone() {
        testSendCrypto(commonBodyForPhone(CRPT, "0.001"));
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by address")
    public void testLTCbyAddress() {
        testSendCrypto(commonBodyForAddress(LTC, "0.001"));
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto BTC by address")
    public void testBTCbyAddres() {
        testSendCrypto(commonBodyForAddress(BTC, "0.001"));
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto ETH by address")
    public void testETHbyAddress() {
        testSendCrypto(commonBodyForAddress(ETH, "0.0001"));
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto CRPT by address")
    public void testCRPTbyAddress() {
        testSendCrypto(commonBodyForAddress(CRPT, "0.001"));
    }

    private void testSendCrypto(BodyCreator bodyCreator) {
        testInvoice(bodyCreator, EndPoints.wallet_send);
    }

    private void testInvoice(BodyCreator bodyCreator, String endpoint) {
        WalletSendResponseModel responseModel = service().auth().body(bodyCreator.create()).post(endpoint).as(WalletSendResponseModel.class);
    }

    private BodyCreator commonBodyForAddress(Currency currency, String amount) {
        return () -> {
            String errorMessage = String.format("No wallet found for currency %s for user %s", currency, recipient.getLogin());
            Wallet wallet = getWalletByCurrency(recipient, currency).orElseThrow(() ->
                    new NoSuchWalletException(errorMessage));
            String address = wallet.getAddress();

            FeeResponse feeResponse = service().auth().queryParam("address", address)
                    .pathParams("currency", currency)
                    .queryParam("amount", amount).get(EndPoints.wallet_send_fee_currency)
                    .as(FeeResponse.class);
            BigDecimal fee = feeResponse.getFee();

            return new WalletSendReq()
                    .setAddress(address)
                    .setAmount(new BigDecimal(amount))
                    .setCurrency(currency)
                    .setFee(fee);
        };
    }

    private BodyCreator commonBodyForPhone(Currency currency, String amount) {
        return () -> {
            FeeResponse feeResponse = service().auth().queryParam("phone", recipient.getLogin())
                    .pathParams("currency", currency)
                    .queryParam("amount", amount).get(EndPoints.wallet_send_fee_currency)
                    .as(FeeResponse.class);
            BigDecimal fee = feeResponse.getFee();

            return new WalletSendReq()
                    .setPhone(recipient.getLogin())
                    .setAmount(new BigDecimal(amount))
                    .setCurrency(currency)
                    .setFee(fee);
        };
    }

    private Optional<Wallet> getWalletByCurrency(CredentialEntry user, Currency currency) {

        List<Wallet> wallets = service().authSingle(user.getLogin(), user.getPassword())
                .get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();

        return wallets.stream().filter(e -> e.getCurrency().equals(currency)).findFirst();
    }

    @FunctionalInterface
    private interface BodyCreator {
        WalletSendReq create();
    }
}
