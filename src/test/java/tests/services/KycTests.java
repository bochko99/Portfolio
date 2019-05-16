package tests.services;

import com.crypterium.cryptApi.pojos.services.kyc.KycIdentityRequestModel;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import core.annotations.Credentials;
import core.annotations.ScopeTarget;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.service;

@Ignore
@ScopeTarget(ScopeTarget.Stand.BETA)
public class KycTests extends ExwalTest {

    @Test
    @DisplayName(("KYC 1 Green"))
    @Credentials(creatingNewUser = true)
    public void testKYC1Completion() {
        Long id = registerNewUser().getCustomerId();
        KycIdentityRequestModel model = new KycIdentityRequestModel()
                .setType(KycIdentityRequestModel.Type.PASSPORT)
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
