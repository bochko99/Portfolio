package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.ChangeReq;
import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.CheckCodeReq;
import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.ResetReq;
import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.SetNewPassReq;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.service;
import static io.restassured.RestAssured.given;

public class RestoreAccessOperTests extends ExwalTest {



    @Test
    @DisplayName(EndPoints.mobile_password_reset + " POST")
    public void testResetPass() {
        ResetReq resetReq = new ResetReq()
                .setPhone("70000005400");
        given().body(resetReq).post(EndPoints.mobile_password_reset);

    }

    @Test
    @DisplayName(EndPoints.mobile_password_reset_confirm_code + " POST")
    public void testConfirmCode() {
        CheckCodeReq checkCodeReq = new CheckCodeReq()
                .setCode("12345")
                .setPhone("70000005400");

        given().body(checkCodeReq).post(EndPoints.mobile_password_reset_confirm_code);
    }

    @Test
    @DisplayName(EndPoints.mobile_password_reset_confirm + " POST")
    public void testSetNewPass() {

        SetNewPassReq setNewPassReq = new SetNewPassReq()
                .setCode("12345")
                .setPassword("123456")
                .setPhone("70000005400");

        given().body(setNewPassReq).post(EndPoints.mobile_password_reset_confirm);

    }

    @Test
    @DisplayName(EndPoints.mobile_password_change + " PUT")
    public void testChangePass() {
        ChangeReq changeReq = new ChangeReq()
                .setCurrentPassword("123456")
                .setNewPassword("123456");
        service().auth().body(changeReq).put(EndPoints.mobile_password_change);
    }


}
