package tests;

import com.crypterium.cryptApi.pojos.signupoperation.ResendEmail;
import com.crypterium.cryptApi.pojos.signupoperation.ResendPhone;
import com.crypterium.cryptApi.pojos.signupoperation.SignUpReq;
import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.crypterium.cryptApi.pojos.wallets.Wallet;
import com.crypterium.cryptApi.pojos.wallets.WalletCreateReq;
import com.crypterium.cryptApi.pojos.wallets.WalletListResp;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Credentials;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;
import tests.core.ExwalTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SignUpTests extends ExwalTest {

    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName("Register new user")
    public void testRegisterNewUser() {
        registerNewUser();
    }

    @TestFactory
    @Credentials(creatingNewUser = true)
    @DisplayName("ETH/CRPT/USDC Wallet creation")
    public Collection<DynamicNode> testNewUserWalletCreation() {
        registerNewUser();
        List<Wallet> wallets = service().auth().body(new WalletCreateReq().setCurrencies(ETH)).post(EndPoints.wallet_create).as(WalletListResp.class).getWallets();
        List<Wallet> totalWallets = service().auth().get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        return Arrays.asList(
                testListOfWallets("Create list", wallets),
                testListOfWallets("Wallet list", totalWallets)
        );
    }

    private DynamicNode testListOfWallets(String name, List<Wallet> wallets) {
        return DynamicContainer.dynamicContainer(name, Stream.of(
                dynamicTest("not empty", () -> Assert.assertThat(wallets.size(), Matchers.greaterThan(0))),
                dynamicTest("no duplicates", () -> {
                    List<Currency> currencies = wallets.stream().map(Wallet::getCurrency).collect(Collectors.toList());
                    Set<Currency> distinctCurrencies = new HashSet<>(currencies);
                    Assertions.assertAll(
                            () -> Assert.assertThat(currencies.size(), Matchers.equalTo(distinctCurrencies.size())),
                            () -> Assert.assertThat(currencies, Matchers.hasItems(ETH, CRPT, USDC))
                    );
                })
        ));
    }


    @Test
    @DisplayName(EndPoints.mobile_phone_resend + " POST")
    public void testResendPhone() {
        String phoneNumber = "";
        int statusCode;
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            SignUpReq signup = new SignUpReq()
                    .setPassword("12345a")
                    .setPhone(phoneNumber);
            statusCode = given().body(signup).post(EndPoints.mobile_signup).statusCode();
            if (statusCode == 200) {
                break;
            }
        }
        ResendPhone resend = new ResendPhone()
                .setPhone(phoneNumber);
        given().body(resend).post(EndPoints.mobile_phone_resend);
    }

    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName(EndPoints.mobile_email_resend + " POST")
    public void testResendEmailCode() {
        service().createUser();
        String email = ApiCommonFunctions.generateFreeEmail();
        ResendEmail resendEmail = new ResendEmail()
                .setEmail(email);

        service().auth().body(resendEmail).post(EndPoints.mobile_email_resend);
    }


}