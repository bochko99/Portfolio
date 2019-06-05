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
import core.TestScope;
import core.annotations.Credentials;
import core.annotations.ScopeTarget;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import tests.core.ExwalTest;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

@Epic(TestScope.REGRESS)
@Feature("Sign up")
public class SignUpTests extends ExwalTest {

    @Story("User registration")
    @Description("User registers from latest app")
    @Test
    @Credentials(creatingNewUser = true)
    public void testRegisterNewUser() {
        registerNewUser();

    }

    @Story("SMS on prod validation")
    @Description("Test checks that confirmation code on prod-like stands is not 1234")
    @Test
    @ScopeTarget({ScopeTarget.Stand.PROD, ScopeTarget.Stand.STAGE})
    @Credentials(creatingNewUser = true)
    public void testSmsVerification() {
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
        String smsCode = ApiCommonFunctions.getSmsCode(phoneNumber, "MOBILE_SIGN_UP");
        assertThat(smsCode, not(equalTo("1234")));
    }

    @Story("User creates his ETH wallets after signing up")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Credentials(creatingNewUser = true)
    public void testNewUserWalletCreation() {
        registerNewUser();
        List<Wallet> wallets = service().auth().body(new WalletCreateReq().setCurrencies(ETH)).post(EndPoints.wallet_create).as(WalletListResp.class).getWallets();
        List<Wallet> totalWallets = service().auth().get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        List<Currency> currencies = wallets.stream().map(Wallet::getCurrency).collect(Collectors.toList());
        Set<Currency> distinctCurrencies = new HashSet<>(currencies);
        List<Currency> totalCurrencies = totalWallets.stream().map(Wallet::getCurrency).collect(Collectors.toList());
        Set<Currency> distinctTotalCurrencies = new HashSet<>(totalCurrencies);
        Assertions.assertAll(
                () -> assertThat(currencies.size(), equalTo(distinctCurrencies.size())),
                () -> assertThat(currencies, Matchers.hasItems(ETH, CRPT, USDC)),
                () -> assertThat(totalCurrencies.size(), equalTo(distinctTotalCurrencies.size())),
                () -> assertThat(totalCurrencies, Matchers.hasItems(ETH, CRPT, USDC))
        );
    }


    @Story("Phone code confirmation resend")
    @Description("User tries to resend phone confirmation code")
    @Severity(SeverityLevel.CRITICAL)
    @Test
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

    @Story("Email code confirmation resend")
    @Description("User tries to resend phone confirmation code")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Credentials(creatingNewUser = true)
    public void testResendEmailCode() {
        service().createUser();
        String email = ApiCommonFunctions.generateFreeEmail();
        ResendEmail resendEmail = new ResendEmail()
                .setEmail(email);

        service().auth().body(resendEmail).post(EndPoints.mobile_email_resend);
    }


}