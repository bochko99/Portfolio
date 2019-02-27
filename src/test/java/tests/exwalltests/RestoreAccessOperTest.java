package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.ChangeReq;
import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.CheckCodeReq;
import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.ResetReq;
import com.crypterium.cryptApi.newback.pojos.restoreaccessoperation.SetNewPassReq;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.auth;

public class RestoreAccessOperTest extends ExwalTest {

    @Test
    @DisplayName(EndPoints.password_change + " PUT")
    public void testChangePass() {
        ChangeReq changeReq = new ChangeReq()
                .setCurrentPassword("1234567")
                .setNewPassword("123456");
        auth().body(changeReq).put(EndPoints.password_change);
    }

    @Test
    @DisplayName(EndPoints.password_reset + " POST")
    public void testResetPass() {
        ResetReq resetReq = new ResetReq()
                .setPhone("70000005400");
        auth().body(resetReq).post(EndPoints.password_reset);

    }

    @Test
    @DisplayName(EndPoints.code_reset_pass + " POST")
    public void testConfirmCode() {
        CheckCodeReq checkCodeReq = new CheckCodeReq()
                .setCode("12345")
                .setPhone("70000005400");

        auth().body(checkCodeReq).post(EndPoints.code_reset_pass);
    }

    @Test
    @DisplayName(EndPoints.set_new_password + " POST")
    public void testSetNewPass() {

        SetNewPassReq setNewPassReq = new SetNewPassReq()
                .setCode("12345")
                .setPassword("123456")
                .setPhone("70000005400");

        auth().body(setNewPassReq).get(EndPoints.set_new_password);

    }


}
