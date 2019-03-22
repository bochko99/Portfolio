package tests;

import com.crypterium.cryptApi.pojos.restoreaccessoperation.ChangeReq;
import com.crypterium.cryptApi.pojos.restoreaccessoperation.CheckCodeReq;
import com.crypterium.cryptApi.pojos.restoreaccessoperation.ResetReq;
import com.crypterium.cryptApi.pojos.restoreaccessoperation.SetNewPassReq;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.exauth;
import static com.crypterium.cryptApi.Auth.service;
import static io.restassured.RestAssured.given;

public class RestoreAccessOperTests extends ExwalTest {


    @Test
    @DisplayName("Mobile password reset")
    public void testResetPass() {
        CredentialEntry user = Environment.CREDENTIALS.get("default");
        ResetReq resetReq = new ResetReq()
                .setPhone(user.getLogin());
        given().body(resetReq).post(EndPoints.mobile_password_reset);
        String code = exauth().admin().queryParam("phone", user.getLogin())
                .queryParam("event", "PASSWORD_RESTORE")
                .get(EndPoints.admin_sms_code).then().extract().body().jsonPath().getString("code");

        CheckCodeReq checkCodeReq = new CheckCodeReq()
                .setCode(code)
                .setPhone(user.getLogin());
        given().body(checkCodeReq).post(EndPoints.mobile_password_reset_confirm_code);

        SetNewPassReq setNewPassReq = new SetNewPassReq()
                .setCode(code)
                .setPassword(user.getPassword())
                .setPhone(user.getLogin());

        given().body(setNewPassReq).post(EndPoints.mobile_password_reset_confirm).then().body("access_token", Matchers.notNullValue());

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
