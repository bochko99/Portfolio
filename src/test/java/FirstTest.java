import core.Auth;
import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.LoginModel;
import pojos.bitgo.BitgoReqModel;
import pojos.fundsWallet.FundswalletModel;
import utils.Constants;
import utils.EndPoints;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

import static core.Auth.auth;
import static core.Currency.BTC;
import static io.restassured.RestAssured.given;


public class FirstTest {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Test
    @DisplayName(EndPoints.users_login + " POST")
    public void testAuth() {
        given().body(new LoginModel()
                .setLogin("70000000040")
                .setPassword("1234567"))
                .when()
                .post(EndPoints.users_login)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName(EndPoints.countries + " GET")
    public void testGetCountries() {
        given().get(EndPoints.countries);
    }

    @Test
    @DisplayName(EndPoints.map_points + " GET")
    public void testGetMapPoints() {
        given().get(EndPoints.map_points);
    }

    @Test
    @DisplayName(EndPoints.news + " GET")
    public void testGetNews() {
        given().get(EndPoints.news);
    }


    @Test
    @DisplayName(EndPoints.quotes + " GET")
    public void testGetQuotes() {
        given().get(EndPoints.quotes);
    }

    @Test
    @DisplayName(EndPoints.quotes_currency + " GET")
    public void testGetQuotesCurrency() {
        given().pathParam("currency", BTC).get(EndPoints.quotes_currency);
    }

    @Test
    @DisplayName(EndPoints.transactions_history + " GET")
    public void testGetTransactionsHistory() {
        auth().get(EndPoints.transactions_history);
    }

    @Test
    @DisplayName(EndPoints.transfers_frequent + " GET")
    public void testGetTransfersFrequent() {
        auth().get(EndPoints.transfers_frequent);
    }

    @Test
    @DisplayName(EndPoints.transfers_recent + " GET")
    public void testGetTransfersRecent() {
        auth().get(EndPoints.transfers_recent);
    }

    @Test
    @DisplayName(EndPoints.bitgo + " POST")
    public void testPostBitgo() {
        BigDecimal amount = new BigDecimal(1000);
        FundswalletModel[] wallets = auth("70000026914", "1234567")
                .get(EndPoints.fundswallets).as(FundswalletModel[].class);
        FundswalletModel oldBitGoWallet = Stream.of(wallets)
                .filter(w -> "bitgo".equalsIgnoreCase(w.getType()))
                .findFirst().orElse(null);

        Assert.assertNotNull("Wallet with type bitgo not found", oldBitGoWallet);

        BitgoReqModel model = new BitgoReqModel()
                .setAmount(amount)
                .setCurrency(oldBitGoWallet.getCurrency())
                .setToAddress(oldBitGoWallet.getDescription())
                .setIdempotentId(UUID.randomUUID().toString());

        auth().basePath(Constants.CALLBACK).body(model).post(EndPoints.bitgo);

        FundswalletModel[] newWallets = auth()
                .get(EndPoints.fundswallets).as(FundswalletModel[].class);
        Auth.flush();

        FundswalletModel newBitGoWallet = Stream.of(newWallets)
                .filter(w -> w.getCurrency().equalsIgnoreCase(oldBitGoWallet.getCurrency()))
                .findFirst().orElse(null);

        Assert.assertNotNull("Cannot find wallet after transaction", newBitGoWallet);

        BigDecimal expectedResult = oldBitGoWallet.getAmount().add(amount).stripTrailingZeros();
        Assert.assertEquals("Wallet sum updated incorrectly", expectedResult, newBitGoWallet.getAmount().stripTrailingZeros());

    }


}