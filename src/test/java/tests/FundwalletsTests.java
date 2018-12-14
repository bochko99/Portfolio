package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;

public class FundwalletsTests {

    @Test
    @DisplayName(EndPoints.fundswallets + " GET")
    public void testGetFundswallets() {
        auth().get(EndPoints.fundswallets);
    }

}
