package tests;

import com.crypterium.cryptApi.pojos.customerprofile.ProfileReq;
import com.crypterium.cryptApi.utils.EndPoints;
import core.TestScope;
import core.annotations.Credentials;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.service;

@Epic(TestScope.REGRESS)
@Feature("Customer profile")
public class CustomerProfileTests extends ExwalTest {

    @Story("User profile getting")
    @Description("User gets his profile info")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testProfile() {
        service().auth().get(EndPoints.customer_profile);
    }


    @Story("User profile changing")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Credentials(creatingNewUser = true)
    public void testProfilePUT() {
        registerNewUser();

        String name = RandomStringUtils.randomAlphabetic(5);
        ProfileReq profileReq = new ProfileReq().setFirstName(name);
        service().auth().body(profileReq).put(EndPoints.customer_profile).then().body("firstName", Matchers.equalToIgnoringCase(name));
    }

    @Story("Loyalty level getting")
    @Severity(SeverityLevel.MINOR)
    @Test
    @DisplayName(EndPoints.customer_profile_loyality + " GET")
    public void testLoyality() {
        service().auth().get(EndPoints.customer_profile_loyality);
    }
}
