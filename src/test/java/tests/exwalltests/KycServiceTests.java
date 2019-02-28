package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.builder.MultiPartSpecBuilder;
import org.junit.Test;
import tests.core.ExwalTest;

import java.io.File;

import static com.crypterium.cryptApi.Auth.auth;
import static io.restassured.RestAssured.given;

public class KycServiceTests extends ExwalTest {

    @Test
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
    @DisplayName(EndPoints.kyc_upload_document + " POST")
    public void testUploadDocument() {

        registerNewUser();
        auth().queryParam("docType", "PASSPORT_FRONT")
                .multiPart(new MultiPartSpecBuilder(new File("/resources/photoforkyc/document.jpg")).build()).
                when().
                post(EndPoints.kyc_upload_document);
//        auth().queryParam("docType", "SELFIE").multiPart(new File("/resources/photofor/kyc/selfie.jpg")).
//                when().
//                post(EndPoints.kyc_upload_document);
    }
}