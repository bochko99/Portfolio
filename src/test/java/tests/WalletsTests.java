package tests;

import com.crypterium.cryptApi.exceptions.NoSuchWalletException;
import com.crypterium.cryptApi.exceptions.NoWalletsException;
import com.crypterium.cryptApi.pojos.wallets.*;
import com.crypterium.cryptApi.pojos.wallets.history.History;
import com.crypterium.cryptApi.pojos.wallets.history.WalletHistoryResponseModel;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import core.annotations.Financial;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.*;

public class WalletsTests extends ExwalTest {

    private CredentialEntry sender = Environment.CREDENTIAL_DEFAULT;
    private CredentialEntry recipient = ApiCommonFunctions.getRecipient();

    @Test
    @DisplayName(EndPoints.wallet_wallet_id + " GET")
    public void testWalletId() {
        WalletListResp response = service().auth().get(EndPoints.wallet_list).then()
                .body("wallets.size()", Matchers.greaterThan(0))
                .extract().as(WalletListResp.class);
        Long id = response.getWallets().get(0).getId();

        service().auth().pathParams("walletId", id).get(EndPoints.wallet_wallet_id);
    }

    @Test
    @Ignore
    @DisplayName(EndPoints.wallet_address_currency + " GET")
    public void testWalletAddress() {

        service().auth().pathParams("currency", BTC)
                .get(EndPoints.wallet_address_currency).as(Wallet.class);

    }

    @Test
    @DisplayName(EndPoints.wallet_currencies + " GET")
    public void testWalletCurrencies() {

        service().auth().get(EndPoints.wallet_currencies);
    }

    @Test
    @DisplayName(EndPoints.wallet_list + " GET")
    public void testWalletList() {

        service().auth().get(EndPoints.wallet_list);

    }

    @Test
    @DisplayName(EndPoints.wallet_mobile_sx_rates + " GET")
    public void testWalletRates() {

        service().auth().get(EndPoints.wallet_mobile_sx_rates);
    }

    @Test
    @DisplayName(EndPoints.wallet_mobile_sx_rates_currency + " GET")
    public void testWalletRate() {

        service().auth().pathParam("currency", EUR).get(EndPoints.wallet_mobile_sx_rates_currency);
    }


    @Test
    @DisplayName(EndPoints.wallet_send_fee_currency + " GET")
    public void testWalletFee() {
        List<Wallet> wallets = service().auth().get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        Wallet wallet = wallets.stream().filter(e -> e.getBalance().compareTo(new BigDecimal("0.001")) >= 0)
                .findFirst().orElseThrow(() -> new NoSuchWalletException("No wallet with balance >= 0.001 presented"));
        service().auth().queryParam("address", wallet.getAddress())
                .pathParams("currency", wallet.getCurrency())
                .queryParam("amount", "0.0001").get(EndPoints.wallet_send_fee_currency)
                .as(FeeResponse.class);
    }

    @Test
    @DisplayName(EndPoints.wallet_transaction + " GET")
    public void testWalletTransac() {

        service().auth().get(EndPoints.wallet_transaction);
    }

    @Test
    @DisplayName(EndPoints.wallet_verify_currency_address + " GET")
    public void testWalletValidateAddress() {
        List<Wallet> wallets = service().authSingle(recipient.getLogin(), recipient.getPassword())
                .get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        if (wallets.size() == 0) {
            throw new NoWalletsException();
        }
        Wallet wallet = wallets.get(0);
        String address = wallet.getAddress();

        service().auth().pathParam("address", address)
                .pathParams("currency", wallet.getCurrency())
                .get(EndPoints.wallet_verify_currency_address)
                .then().body("verified", Matchers.equalTo(true));
    }

    //SEND CRYPTO

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by phone")
    public void testLTCbyPhone() {
        testSendCrypto(commonBodyForPhone(LTC, "0.001"), new TransferPhoneHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto BTC by phone")
    public void testBTCbyPhone() {
        testSendCrypto(commonBodyForPhone(BTC, "0.00001"), new TransferPhoneHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto ETH by phone")
    public void testETHbyPhone() {
        testSendCrypto(commonBodyForPhone(ETH, "0.0001"), new TransferPhoneHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto CRPT by phone")
    public void testCRPTbyPhone() {
        testSendCrypto(commonBodyForPhone(CRPT, "0.001"), new TransferPhoneHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto LTC by address")
    public void testLTCbyAddress() {
        testSendCrypto(commonBodyForAddress(LTC, "0.001"), new TransferWalletHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto BTC by address")
    public void testBTCbyAddres() {
        testSendCrypto(commonBodyForAddress(BTC, "0.001"), new TransferWalletHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto ETH by address")
    public void testETHbyAddress() {
        testSendCrypto(commonBodyForAddress(ETH, "0.0001"), new TransferWalletHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Sendcrypto CRPT by address")
    public void testCRPTbyAddress() {
        testSendCrypto(commonBodyForAddress(CRPT, "0.001"), new TransferWalletHistoryProcessor());
    }

    @Test
    @Financial
    @DisplayName("Send BTC to external wallet")
    public void testBtcExternalAddress() {
        service().auth()
                .body(new WalletSendReq()
                        .setAddress("1A8d5vvsbfvh8Vx3FhDi7aX5C3aBhhoSHG")
                        .setCurrency(BTC)
                        .setAmount(new BigDecimal("0.001"))
                        .setFee(new BigDecimal("0.00005")))
                .post(EndPoints.wallet_send);
    }

    private void testSendCrypto(BodyCreator bodyCreator, HistoryProcessor historyProcessor) {
        testInvoice(bodyCreator, EndPoints.wallet_send, historyProcessor);
    }

    private void testInvoice(BodyCreator bodyCreator, String endpoint, HistoryProcessor historyProcessor) {
        WalletSendReq body = bodyCreator.create();

        BigDecimal recipientAmountBefore = getWalletByCurrency(recipient, body.getCurrency())
                .orElseThrow(() -> new NoSuchWalletException(body.getCurrency(), recipient.getLogin()))
                .getBalance();
        BigDecimal senderAmountBefore = getWalletByCurrency(sender, body.getCurrency())
                .orElseThrow(() -> new NoSuchWalletException(body.getCurrency(), sender.getLogin()))
                .getBalance();

        service().auth().body(body).post(endpoint).as(WalletSendResponseModel.class);

        int limit = 12;
        History transaction = null;
        for (int i = 0; i <= limit; i++) {
            WalletHistoryResponseModel transactions = service().auth().queryParam("size", 10).get(EndPoints.wallet_transaction).as(WalletHistoryResponseModel.class);
            historyProcessor.setTransactions(transactions.getHistory());
            transaction = historyProcessor.findTransactoinByAmount(body.getAmount(), body.getCurrency());
            if (transaction.getOperationStatus() == History.OperationStatus.COMPLETED) {
                break;
            }
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!transaction.getOperationStatus().equals(History.OperationStatus.COMPLETED)) {
            throw new RuntimeException("Operation didn't complete in 60 seconds");
        }
        BigDecimal expectedSenderBalance = senderAmountBefore.subtract(
                historyProcessor.getAmount(transaction).add(historyProcessor.getFee(transaction)));
        BigDecimal expectedRecipientBalance = recipientAmountBefore.add(historyProcessor.getAmount(transaction));

        BigDecimal recipientBalanceAfter = getWalletByCurrency(recipient, body.getCurrency())
                .orElseThrow(() -> new NoSuchWalletException(body.getCurrency(), recipient.getLogin()))
                .getBalance();
        BigDecimal senderBalanceAfter = getWalletByCurrency(sender, body.getCurrency())
                .orElseThrow(() -> new NoSuchWalletException(body.getCurrency(), sender.getLogin()))
                .getBalance();

        Assert.assertThat(senderBalanceAfter, Matchers.equalTo(expectedSenderBalance));
        Assert.assertThat(recipientBalanceAfter, Matchers.equalTo(expectedRecipientBalance));
    }

    private BodyCreator commonBodyForAddress(Currency currency, String amount) {
        return () -> {

            String errorMessage = String.format("No wallet found for currency %s for user %s", currency, recipient.getLogin());
            Wallet wallet = getWalletByCurrency(recipient, currency).orElseThrow(() ->
                    new NoSuchWalletException(errorMessage));
            String address = wallet.getAddress();

            String amountWithTimeStamp = amount + "0" + new SimpleDateFormat("yyMMddHHmmSS").format(new Date());
            FeeResponse feeResponse = service().auth().queryParam("address", address)
                    .pathParams("currency", currency)
                    .queryParam("amount", amountWithTimeStamp).get(EndPoints.wallet_send_fee_currency)
                    .as(FeeResponse.class);
            BigDecimal fee = feeResponse.getFee();

            return new WalletSendReq()
                    .setAddress(address)
                    .setAmount(new BigDecimal(amountWithTimeStamp))
                    .setCurrency(currency)
                    .setFee(fee);
        };
    }

    private BodyCreator commonBodyForPhone(Currency currency, String amount) {
        return () -> {
            String amountWithTimeStamp = amount + "0" + new SimpleDateFormat("yyMMddHHmmSS").format(new Date());
            FeeResponse feeResponse = service().auth().queryParam("phone", recipient.getLogin())
                    .pathParams("currency", currency)
                    .queryParam("amount", amountWithTimeStamp).get(EndPoints.wallet_send_fee_currency)
                    .as(FeeResponse.class);
            BigDecimal fee = feeResponse.getFee();

            return new WalletSendReq()
                    .setPhone(recipient.getLogin())
                    .setAmount(new BigDecimal(amountWithTimeStamp))
                    .setCurrency(currency)
                    .setFee(fee);
        };
    }

    private Optional<Wallet> getWalletByCurrency(CredentialEntry user, Currency currency) {

        List<Wallet> wallets = service().authSingle(user.getLogin(), user.getPassword())
                .get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();

        return wallets.stream().filter(e -> e.getCurrency().equals(currency)).findFirst();
    }

    @FunctionalInterface
    private interface BodyCreator {
        WalletSendReq create();
    }

    private static abstract class HistoryProcessor {

        List<History> transactions;

        public HistoryProcessor setTransactions(List<History> transactions) {
            this.transactions = transactions;
            return this;
        }

        abstract History findTransactoinByAmount(BigDecimal amount, Currency currency);

        abstract BigDecimal getAmount(History history);

        abstract BigDecimal getFee(History history);
    }

    private static class TransferPhoneHistoryProcessor extends HistoryProcessor {

        @Override
        History findTransactoinByAmount(BigDecimal amount, Currency currency) {
            return this.transactions.stream().filter(t -> t.getOperationType() == History.OperationType.TRANSFER_PHONE)
                    .filter(t ->
                            t.getWalletHistoryRecordTransferPhone().getCreditAmount().getValue().compareTo(amount) == 0
                                    && t.getWalletHistoryRecordTransferPhone().getCreditAmount().getCurrency() == currency
                    ).findFirst().orElse(null);
        }

        @Override
        BigDecimal getAmount(History history) {
            return history.getWalletHistoryRecordTransferPhone().getCreditAmount().getValue();
        }

        @Override
        BigDecimal getFee(History history) {
            return BigDecimal.ZERO;
        }
    }

    private static class TransferWalletHistoryProcessor extends HistoryProcessor {

        @Override
        History findTransactoinByAmount(BigDecimal amount, Currency currency) {
            return this.transactions.stream().filter(t -> t.getOperationType() == History.OperationType.TRANSFER_WALLET)
                    .filter(t ->
                            t.getWalletHistoryRecordTransferWallet().getCreditAmount().getValue().compareTo(amount) == 0
                                    && t.getWalletHistoryRecordTransferWallet().getCreditAmount().getCurrency() == currency
                    ).findFirst().orElse(null);
        }

        @Override
        BigDecimal getAmount(History history) {
            return history.getWalletHistoryRecordTransferWallet().getCreditAmount().getValue();
        }

        @Override
        BigDecimal getFee(History history) {
            return BigDecimal.ZERO;
        }
    }
}
