package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pojos.fundsWallet.FundswalletModel;
import utils.EndPoints;

import static core.Auth.auth;

public class FundwalletsTests {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

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
                .setCurrency("BTC")
                .setDescription("Best MSC in the world!")
                .setEncryptedKey(address);

        String walletId = auth("70000005332", "1234567")
                .body(model)
                .pathParam("id", uuid)
                .post(EndPoints.fundswallets_id)
                .then().extract().body().jsonPath().getString("id");

    }
}
