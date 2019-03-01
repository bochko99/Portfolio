package tests;

import com.crypterium.cryptApi.newback.pojos.customerprofile.ProfileReq;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.service;

public class CustomerProfileTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.customer_profile + " GET")
    public void testProfile() {
        service().auth().get(EndPoints.customer_profile);
    }


    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName(EndPoints.customer_profile + " put")
    public void testProfilePUT() {
        registerNewUser();

        String name = String.format("%s",
                RandomStringUtils.randomAlphabetic(5)
        );
        ProfileReq profileReq = new ProfileReq().setFirstName(name);
        service().auth().body(profileReq).put(EndPoints.customer_profile);
    }

    @Test
    @DisplayName(EndPoints.customer_profile_loyality + " GET")
    public void testLoyality() {
        service().auth().get(EndPoints.customer_profile_loyality);
    }
}
