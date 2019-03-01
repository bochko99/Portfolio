package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.ExwalTest;

import java.io.File;

import static com.crypterium.cryptApi.Auth.auth;
import static io.restassured.RestAssured.given;

public class KycServiceTests extends ExwalTest {

    @Test
    @Ignore
    @DisplayName(EndPoints.kyc_customer_profile + " GET")
    public void testKycProfile() {


        UserProfileModel userProfileModel =
                auth().get(EndPoints.customer_profile).as(UserProfileModel.class);
        Long customerId = userProfileModel.getCustomerId();
        given().pathParam("customerId", customerId).get(EndPoints.kyc_customer_profile);
    }

    @Test
    @DisplayName(EndPoints.kyc_identity_ex + " GET")
    public void testKycIdentity() {

        auth().get(EndPoints.kyc_identity_ex);

    }

    //Дописать загрузку документаnew File("/resources/photofor/kyc/document.jpg")
    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName(EndPoints.kyc_upload_document + " POST")
    public void testUploadDocument() {
        File document =
                new File(this.getClass().getClassLoader().getResource("photoforkyc/document.jpg").getFile());
        File selfie =
                new File(this.getClass().getClassLoader().getResource("photoforkyc/selfie.jpg").getFile());

        registerNewUser();
        auth().header("Content-Type", "multipart/jpg")
                .queryParam("docType", "PASSPORT_FRONT")
                .multiPart("image", document)
                .when().post(EndPoints.kyc_upload_document);
        auth().header("Content-Type", "multipart/jpg")
                .queryParam("docType", "SELFIE")
                .multiPart("image", selfie)
                .when().post(EndPoints.kyc_upload_document);
        auth().get(EndPoints.kyc_identity_ex).then().body("status", Matchers.equalToIgnoringCase("sent_to_provider"));

    }
}