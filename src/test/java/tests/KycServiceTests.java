package tests;

import com.crypterium.cryptApi.pojos.customerprofile.ProfileReq;
import com.crypterium.cryptApi.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.utils.EndPoints;
import core.TestScope;
import core.annotations.Credentials;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.ExwalTest;

import java.io.File;

import static com.crypterium.cryptApi.Auth.service;
import static io.restassured.RestAssured.given;

@Epic(TestScope.REGRESS)
public class KycServiceTests extends ExwalTest {

    @Test
    @Ignore
    public void testKycProfile() {


        UserProfileModel userProfileModel =
                service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class);
        Long customerId = userProfileModel.getCustomerId();
        given().pathParam("customerId", customerId).get(EndPoints.kyc_customer_profile);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("Getting KYC identity status")
    @Test
    public void testKycIdentity() {
        service().auth().get(EndPoints.kyc_identity);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("Getting KYC identity documents")
    @Test
    public void testGetKycIdentityDocuments() {
        service().auth().get(EndPoints.kyc_identity_documents);
    }


    @Severity(SeverityLevel.BLOCKER)
    @Story("KYC completion")
    @Description("User passing KYC from app (Country = RU, Images are incorrect)")
    @Test
    @Credentials(creatingNewUser = true)
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

    @Severity(SeverityLevel.NORMAL)
    @Story("KYC 2 completion")
    @Description("User with KYC 1 passed passing KYC 2")
    @Test
    @Credentials(type = "kyc1")
    public void testKyc2() {
        File document =
                new File(this.getClass().getClassLoader().getResource("photoforkyc/bank_statement.jpg").getFile());

        String kyc1Status = service().auth().get(EndPoints.kyc_identity).jsonPath().getString("status");
        String errMsg = String.format("User has to have KYC 1 APPROVED. Current status - %s", kyc1Status);
        Assume.assumeTrue(errMsg, kyc1Status.equalsIgnoreCase("approved"));


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