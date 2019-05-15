package tests;

import com.crypterium.cryptApi.pojos.customerprofile.ProfileReq;
import com.crypterium.cryptApi.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.ExwalTest;

import java.io.File;

import static com.crypterium.cryptApi.Auth.service;
import static io.restassured.RestAssured.given;

public class KycServiceTests extends ExwalTest {

    @Test
    @Ignore
    @DisplayName(EndPoints.kyc_customer_profile + " GET")
    public void testKycProfile() {


        UserProfileModel userProfileModel =
                service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class);
        Long customerId = userProfileModel.getCustomerId();
        given().pathParam("customerId", customerId).get(EndPoints.kyc_customer_profile);
    }

    @Test
    @DisplayName(EndPoints.kyc_identity + " GET")
    public void testKycIdentity() {
        service().auth().get(EndPoints.kyc_identity);
    }

    @Test
    @DisplayName(EndPoints.kyc_identity_documents + " GET")
    public void testGetKycIdentityDocuments() {
        service().auth().get(EndPoints.kyc_identity_documents);
    }


    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName(EndPoints.kyc_upload_document + " POST")
    public void testUploadDocument() {
        File document =
                new File(this.getClass().getClassLoader().getResource("photoforkyc/document.jpg").getFile());
        File selfie =
                new File(this.getClass().getClassLoader().getResource("photoforkyc/selfie.jpg").getFile());
        registerNewUser();

        service().auth().body("{\"citizenshipCountry\":\"RU\"}").put(EndPoints.customer_profile);
        service().auth().header("Content-Type", "multipart/jpg")
                .queryParam("docType", "PASSPORT_FRONT")
                .multiPart("image", document)
                .when().post(EndPoints.kyc_upload_document);
        service().auth().header("Content-Type", "multipart/jpg")
                .queryParam("docType", "SELFIE")
                .multiPart("image", selfie)
                .when().post(EndPoints.kyc_upload_document);

        service().auth().get(EndPoints.kyc_identity).then().body("status", Matchers.equalToIgnoringCase("sent_to_provider"));

    }

    @Test
    @Credentials(type = "kyc1")
    @DisplayName("KYC 2")
    public void testKyc2() {
        File document =
                new File(this.getClass().getClassLoader().getResource("photoforkyc/bank_statement.jpg").getFile());

        String kyc1Status = service().auth().get(EndPoints.kyc_identity).jsonPath().getString("status");
        String errMsg = String.format("User has to have KYC 1 APPROVED. Current status - %s", kyc1Status);
        Assert.assertTrue(errMsg, kyc1Status.equalsIgnoreCase("approved"));


        service().auth().body(new ProfileReq()
                .setFirstName("Mary Jane")
                .setLastName("Smith")
                .setResidenceCity("Metro")
                .setResidenceCountry("USA")
                .setResidenceState("IL")
                .setResidenceStreet("100 Pine street")
                .setResidenceZipCode("09371")
        ).put(EndPoints.customer_profile);

        service().auth().header("Content-Type", "multipart/jpg")
                .queryParam("docType", "BANK_STATEMENT")
                .multiPart("image", document)
                .when().post(EndPoints.kyc_upload_document);

        service().auth().get(EndPoints.kyc_residence).then().body("status", Matchers.equalToIgnoringCase("sent_to_provider"));

    }
}