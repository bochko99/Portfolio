package tests.exwalltests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.auth;
import static io.restassured.RestAssured.given;

public class KycServiceTest extends ExwalTest {

    @Test
    @DisplayName(EndPoints.kyc_profile + " GET")
    public void testKycProfile() {

        given().pathParam("customerId", "").get(EndPoints.kyc_profile);
    }

    @Test
    @DisplayName(EndPoints.identity_ex + " GET")
    public void testKycIdentity() {

        auth().get(EndPoints.identity_ex);

    }

    //Дописать загрузку документа
    @Test
    @DisplayName(EndPoints.upload_document + " POST")
    public void testUploadDocument() {


        auth().queryParam("docType", "PASSPORT_FRONT").post(EndPoints.upload_document);
    }
}