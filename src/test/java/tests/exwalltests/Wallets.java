package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.wallets.Wallet;
import com.crypterium.cryptApi.newback.pojos.wallets.WalletListResp;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.auth;
import static com.crypterium.cryptApi.Auth.authSingle;

public class Wallets extends ExwalTest {

    private CredentialEntry recipient = ApiCommonFunctions.getRecipient();

    @Test
    @DisplayName(EndPoints.wallet_id + " GET")
    public void testWalletId() {
        WalletListResp response = auth().get(EndPoints.wallet_list).then()
                .body("wallets.size()", Matchers.greaterThan(0))
                .extract().as(WalletListResp.class);
        Long id = response.getWallets().get(0).getId();

        auth().pathParams("walletId", id).get(EndPoints.wallet_id);
    }

    @Test
    @DisplayName(EndPoints.wallet_address + " GET")
    public void testWalletAddress() {

        auth().pathParams("currency", "BTC")
                .get(EndPoints.wallet_address).as(Wallet.class);

    }

    @Test
    @DisplayName(EndPoints.wallet_currencies_ex + " GET")
    public void testWalletCurrencies() {

        auth().get(EndPoints.wallet_currencies_ex);
    }

    @Test
    @DisplayName(EndPoints.wallet_list + " GET")
    public void testWalletList() {

        auth().get(EndPoints.wallet_list);

    }

    @Test
    @DisplayName(EndPoints.wallet_rates + " GET")
    public void testWalletRates() {

        auth().get(EndPoints.wallet_rates);
    }

    @Test
    @DisplayName(EndPoints.wallet_rates_currencies + " GET")
    public void testWalletRate() {

        auth().pathParam("currency", "EUR").get(EndPoints.wallet_rates_currencies);
    }

    @Test
    @DisplayName(EndPoints.wallet_send + " POST")
    public void testSend() {

        auth().post(EndPoints.wallet_send);
    }

    @Test
    @DisplayName(EndPoints.wallet_fee + " GET")
    public void testWalletFee() {
        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "BTC")
                .get(EndPoints.wallet_address).as(Wallet.class);
        String address = wallet.getAddress();

        auth().queryParam("address", address)
                .pathParams("currency", "BTC")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_fee);
    }

    @Test
    @DisplayName(EndPoints.wallet_transaction_ex + " GET")
    public void testWalletTransac() {

        auth().get(EndPoints.wallet_transaction_ex);
    }

    @Test
    @DisplayName(EndPoints.wallet_verify + " GET")
    public void testWalletValidateAddress() {

        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "BTC").get(EndPoints.wallet_address).as(Wallet.class);
        String address = wallet.getAddress();

        auth().pathParam("address", address)
                .pathParams("currency", "BTC")
                .get(EndPoints.wallet_verify);
    }
    //SEND CRYPTO

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testLTCbyPhone() {
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testBTCbyPhone() {
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testETHbyPhone() {
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testCRPTbyPhone() {
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testLTCbyAddress() {
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testBTCbyAddres() {
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testETHbyAddress() {
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testCRPTbyAddress() {
    }


}
