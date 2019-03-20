package tests.services;

import com.crypterium.cryptApi.oldback.pojos.users.UsersProfileKyc1Model;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import core.annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.service;

public class KycTests extends ExwalTest {

    @Test
    @DisplayName(("KYC 1 Green"))
    @Credentials(creatingNewUser = true)
    public void testKYC1Completion() {
        Long id = registerNewUser().getCustomerId();
        UsersProfileKyc1Model model = new UsersProfileKyc1Model()
                .setType(UsersProfileKyc1Model.Type.PASSPORT)
                .setFrontside("https://cdn.pbrd.co/images/HZ0L695.jpg")
                .setSelfie("https://cdn.pbrd.co/images/HZ0LiNH.jpg");

        SpecStorage.kyc()
                .body(model)
                .header("X-UserId", id)
                .post(EndPoints.identity)
                .then()
                .body("success", Matchers.equalTo(true));

        service().flush();
    }

}
