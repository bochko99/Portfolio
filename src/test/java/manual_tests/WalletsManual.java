package manual_tests;

import com.crypterium.cryptApi.exceptions.NoSuchWalletException;
import com.crypterium.cryptApi.exceptions.NoWalletsException;
import com.crypterium.cryptApi.pojos.wallets.*;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import tests.WalletsTests;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.crypterium.cryptApi.Auth.exauth;
import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.*;

public class WalletsManual extends ExwalTest {

    private CredentialEntry recipient = ApiCommonFunctions.getRecipient();

    @Test
    @Financial
//    @DisplayName("Send crypto LTC by phone")
    public void testLTCbyPhone() {
        testSendCrypto(commonBodyForPhone(LTC, "0.001"));
    }

    @Test
    @DisplayName(EndPoints.wallet_list + " GET")
    public void testWalletList() {
        service().auth().get(EndPoints.wallet_list);
    }

    private void testSendCrypto(BodyCreator bodyCreator) {
        testInvoice(bodyCreator, EndPoints.wallet_send);
    }

    private void testInvoice(BodyCreator bodyCreator, String endpoint) {
        WalletSendResponseModel responseModel = service().auth().body(bodyCreator.create()).post(endpoint).as(WalletSendResponseModel.class);
    }

    //Taken from the WalletsTests
    private BodyCreator commonBodyForPhone(Currency currency, String amount) {
        return () -> {
            FeeResponse feeResponse = service().auth().queryParam("phone", recipient.getLogin())
                    .pathParams("currency", currency)
                    .queryParam("amount", amount).get(EndPoints.wallet_send_fee_currency)
                    .as(FeeResponse.class);
            BigDecimal fee = feeResponse.getFee();

            return new WalletSendReq()
                    .setPhone(recipient.getLogin())
                    .setAmount(new BigDecimal(amount))
                    .setCurrency(currency)
                    .setFee(fee);
        };
    }

    @FunctionalInterface
    private interface BodyCreator {
        WalletSendReq create();
    }
}
