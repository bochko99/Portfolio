package manual_tests;

import com.crypterium.cryptApi.newback.pojos.wallets.Wallet;
import com.crypterium.cryptApi.newback.pojos.wallets.WalletListResp;
import com.crypterium.cryptApi.newback.pojos.wallets.WalletSendReq;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.crypterium.cryptApi.Auth.service;
import static org.hamcrest.Matchers.lessThan;

public class EmergencyTransfer {

    CredentialEntry recipient = ApiCommonFunctions.getRecipient();

    @Test
    public void transferALlCrypto() {
        BigDecimal lowerBound = new BigDecimal("0.000001");
        List<Wallet> wallets = service().auth().get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        for (Wallet wallet : wallets) {
            BigDecimal amount = wallet.getBalance();
            if (amount == null || amount.compareTo(lowerBound) < 0) {
                continue;
            }
            WalletSendReq body = new WalletSendReq()
                    .setPhone(recipient.getLogin())
                    .setAmount(amount)
                    .setCurrency(wallet.getCurrency())
                    .setFee(BigDecimal.ZERO);

            service().auth().body(body).post(EndPoints.wallet_send);
        }

        List<Wallet> newWallets = service().auth().get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        newWallets.forEach(w -> Assert.assertThat(w.getBalance(), lessThan(lowerBound)));

    }
}
