package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.signupoperation.ResendPhone;
import com.crypterium.cryptApi.newback.pojos.wallets.Wallet;
import com.crypterium.cryptApi.newback.pojos.wallets.WalletListResp;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.auth;
import static com.crypterium.cryptApi.Auth.authSingle;
import static io.restassured.RestAssured.given;

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
        Wallet wallet = auth().pathParams("currency", "BTC").get(EndPoints.wallet_address).as(Wallet.class);
        String address = wallet.getAddress();
        Long customerId = wallet.getCustomerId();
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
        Wallet wallet = authSingle(recipient.getLogin(),recipient.getPassword())
                .pathParams("currency", "BTC").get(EndPoints.wallet_address).as(Wallet.class);
        String address = wallet.getAddress();

        auth().queryParam("address","mn2QPvTyZZCTDbjrDA4DSzsbqASx3sJFp5")
                .pathParams("currency", "BTC")
                .queryParam("amount",0.0001).get(EndPoints.wallet_fee);
    }

    @Test
    @DisplayName(EndPoints.wallet_transaction_ex + " GET")
    public void testWalletTransac() {

        auth().get(EndPoints.wallet_transaction_ex);
    }

    @Test
    @DisplayName(EndPoints.wallet_verify + " GET")
    public void testWalletValidateAddress() {

        auth().get(EndPoints.wallet_verify);
    }

}
