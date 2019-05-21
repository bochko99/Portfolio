package tests;

import com.crypterium.cryptApi.pojos.restoreaccessoperation.ChangeReq;
import com.crypterium.cryptApi.pojos.restoreaccessoperation.CheckCodeReq;
import com.crypterium.cryptApi.pojos.restoreaccessoperation.ResetReq;
import com.crypterium.cryptApi.pojos.restoreaccessoperation.SetNewPassReq;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.service;
import static io.restassured.RestAssured.given;

public class RestoreAccessOperTests extends ExwalTest {

    @Test
    @Ignore
    @DisplayName("Mobile password reset")
    public void testResetPass() {
        CredentialEntry user = Environment.CREDENTIAL_DEFAULT;
        String password = user.getPassword();
        String newPassword = RandomStringUtils.randomAlphabetic(10) + "1";
        ResetReq resetReq = new ResetReq()
                .setPhone(user.getLogin());

        given().body(resetReq).post(EndPoints.mobile_password_reset);

        String code = ApiCommonFunctions.getSmsCode(user.getLogin(), "PASSWORD_RESTORE");
        CheckCodeReq checkCodeReq = new CheckCodeReq()
                .setCode(code)
                .setPhone(user.getLogin());
        given().body(checkCodeReq).post(EndPoints.mobile_password_reset_confirm_code);

        try {
            SetNewPassReq setNewPassReq = new SetNewPassReq()
                    .setPhone(user.getLogin())
                    .setCode(code)
                    .setPassword(newPassword);
            given().body(setNewPassReq).post(EndPoints.mobile_password_reset_confirm).then().body("access_token", Matchers.notNullValue());
        } finally {
            ChangeReq changeReq = new ChangeReq()
                    .setCurrentPassword(newPassword)
                    .setNewPassword(password);

            service().authSingle(user.getLogin(), newPassword).body(changeReq).put(EndPoints.mobile_password_change);
        }


    }

    @Test
    @DisplayName(EndPoints.mobile_password_change + " PUT")
    public void testChangePass() {
        CredentialEntry user = Environment.CREDENTIALS.get("default");
        ChangeReq changeReq = new ChangeReq()
                .setCurrentPassword(user.getPassword())
                .setNewPassword(user.getPassword());
        service().auth().body(changeReq).put(EndPoints.mobile_password_change);
    }


}
