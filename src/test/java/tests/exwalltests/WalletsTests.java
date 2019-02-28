package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.wallets.GetFee;
import com.crypterium.cryptApi.newback.pojos.wallets.Wallet;
import com.crypterium.cryptApi.newback.pojos.wallets.WalletListResp;
import com.crypterium.cryptApi.newback.pojos.wallets.WalletSendReq;
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

import static com.crypterium.cryptApi.Auth.auth;
import static com.crypterium.cryptApi.Auth.authSingle;

public class WalletsTests extends ExwalTest {

    private CredentialEntry recipient = ApiCommonFunctions.getRecipient();

    @Test
    @DisplayName(EndPoints.wallet_wallet_id + " GET")
    public void testWalletId() {
        WalletListResp response = auth().get(EndPoints.wallet_list).then()
                .body("wallets.size()", Matchers.greaterThan(0))
                .extract().as(WalletListResp.class);
        Long id = response.getWallets().get(0).getId();

        auth().pathParams("walletId", id).get(EndPoints.wallet_wallet_id);
    }

    @Test
    @DisplayName(EndPoints.wallet_address_currency + " GET")
    public void testWalletAddress() {

        auth().pathParams("currency", "BTC")
                .get(EndPoints.wallet_address_currency).as(Wallet.class);

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
    @DisplayName(EndPoints.wallet_mobile_sx_rates + " GET")
    public void testWalletRates() {

        auth().get(EndPoints.wallet_mobile_sx_rates);
    }

    @Test
    @DisplayName(EndPoints.wallet_mobile_sx_rates_currency + " GET")
    public void testWalletRate() {

        auth().pathParam("currency", "EUR").get(EndPoints.wallet_mobile_sx_rates_currency);
    }



    @Test
    @DisplayName(EndPoints.wallet_send_fee_currency + " GET")
    public void testWalletFee() {
        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "BTC")
                .get(EndPoints.wallet_address_currency).as(Wallet.class);
        String address = wallet.getAddress();

        auth().queryParam("address", address)
                .pathParams("currency", "BTC")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
    }

    @Test
    @DisplayName(EndPoints.wallet_transaction_ex + " GET")
    public void testWalletTransac() {

        auth().get(EndPoints.wallet_transaction_ex);
    }

    @Test
    @DisplayName(EndPoints.wallet_verify_currency_address + " GET")
    public void testWalletValidateAddress() {

        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "BTC")
                .get(EndPoints.wallet_address_currency).as(Wallet.class);
        String address = wallet.getAddress();

        auth().pathParam("address", address)
                .pathParams("currency", "BTC")
                .get(EndPoints.wallet_verify_currency_address);
    }
    //SEND CRYPTO

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testLTCbyPhone() {


        GetFee getFee = auth().queryParam("phone", recipient.getLogin())
                .pathParams("currency", "LTC")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setPhone(recipient.getLogin())
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("LTC")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);


    }

    @Test
    @Financial
    @DisplayName("Sendcrypto BTC by phone")
    public void testBTCbyPhone() {

        GetFee getFee = auth().queryParam("phone", recipient.getLogin())
                .pathParams("currency", "BTC")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setPhone(recipient.getLogin())
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("BTC")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto ETH by phone")
    public void testETHbyPhone() {

        GetFee getFee = auth().queryParam("phone", recipient.getLogin())
                .pathParams("currency", "ETH")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setPhone(recipient.getLogin())
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("ETH")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);
    }

    @Test
    @Ignore
    @Financial
    @DisplayName("Sendcrypto CRPT by phone")
    public void testCRPTbyPhone() {
        GetFee getFee = auth().queryParam("phone", recipient.getLogin())
                .pathParams("currency", "CRPT")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setPhone(recipient.getLogin())
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("CRPT")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by address")
    public void testLTCbyAddress() {

        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "LTC")
                .get(EndPoints.wallet_address_currency).as(Wallet.class);
        String address = wallet.getAddress();

        GetFee getFee = auth().queryParam("address", address)
                .pathParams("currency", "LTC")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setAddress(address)
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("LTC")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);


    }

    @Test
    @Financial
    @DisplayName("Sendcrypto BTC by address")
    public void testBTCbyAddres() {

        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "BTC")
                .get(EndPoints.wallet_address_currency).as(Wallet.class);
        String address = wallet.getAddress();

        GetFee getFee = auth().queryParam("address", address)
                .pathParams("currency", "BTC")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setAddress(address)
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("BTC")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);

    }

    @Test
    @Financial
    @DisplayName("Sendcrypto ETH by address")
    public void testETHbyAddress() {

        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "ETH")
                .get(EndPoints.wallet_address_currency).as(Wallet.class);
        String address = wallet.getAddress();

        GetFee getFee = auth().queryParam("address", address)
                .pathParams("currency", "ETH")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setAddress(address)
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("ETH")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);

    }

    @Test
    @Ignore
    @Financial
    @DisplayName("Sendcrypto CRPT by address")
    public void testCRPTbyAddress() {

        Wallet wallet = authSingle(recipient.getLogin(), recipient.getPassword())
                .pathParams("currency", "CRPT")
                .get(EndPoints.wallet_address_currency).as(Wallet.class);
        String address = wallet.getAddress();

        GetFee getFee = auth().queryParam("address", address)
                .pathParams("currency", "CRPT")
                .queryParam("amount", 0.0001).get(EndPoints.wallet_send_fee_currency)
                .as(GetFee.class);
        Long fee = getFee.getFee();

        WalletSendReq walletSendReq = new WalletSendReq()
                .setAddress(address)
                .setAmount(new BigDecimal("0.0001"))
                .setCurrency("CRPT")
                .setFee(fee);

        auth().body(walletSendReq).post(EndPoints.wallet_send);


    }


}
