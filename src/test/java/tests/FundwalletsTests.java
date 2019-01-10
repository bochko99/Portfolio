package tests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import pojos.fundsWallet.FundswalletModel;
import utils.EndPoints;

import static core.Auth.auth;
import static core.Currency.BTC;

public class FundwalletsTests extends BaseTest {

    @Test
    @DisplayName(EndPoints.fundswallets + " GET")
    public void testGetFundswallets() {
        auth().get(EndPoints.fundswallets);
    }

    @Test
    @Ignore
    @DisplayName(EndPoints.fundswallets_id + " POST")
    public void testPost() {

        String uuid = java.util.UUID.randomUUID().toString();
        String address = "0x" + RandomStringUtils.randomAlphanumeric(30);
        FundswalletModel model = new FundswalletModel()
                .setCurrency(BTC)
                .setDescription("Best MSC in the world!")
                .setEncryptedKey(address);

        String walletId = auth("70000005332", "1234567")
                .body(model)
                .pathParam("id", uuid)
                .post(EndPoints.fundswallets_id)
                .then().extract().body().jsonPath().getString("id");

    }
}
