package manual_tests;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.crypterium.cryptApi.pojos.wallets.FeeResponse;
import com.crypterium.cryptApi.pojos.wallets.WalletSendReq;
import com.crypterium.cryptApi.pojos.wallets.WalletSendResponseModel;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Financial;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalTest;

import java.math.BigDecimal;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.LTC;

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
