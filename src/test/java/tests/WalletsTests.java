package tests;

import com.crypterium.cryptApi.cryptowallets.BtcWallet;
import com.crypterium.cryptApi.exceptions.NoSuchWalletException;
import com.crypterium.cryptApi.exceptions.NoWalletsException;
import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.crypterium.cryptApi.pojos.wallets.*;
import com.crypterium.cryptApi.pojos.wallets.history.History;
import com.crypterium.cryptApi.pojos.wallets.history.History.OperationType;
import com.crypterium.cryptApi.pojos.wallets.history.WalletHistoryResponseModel;
import com.crypterium.cryptApi.utils.*;
import core.annotations.Financial;
import core.annotations.ScopeTarget;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import tests.core.ExwalTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.crypterium.cryptApi.Auth.service;
import static com.crypterium.cryptApi.pojos.wallets.Currency.*;
import static com.crypterium.cryptApi.pojos.wallets.history.History.OperationType.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class WalletsTests extends ExwalTest {

    private CredentialEntry sender = Environment.CREDENTIAL_DEFAULT;
    private CredentialEntry recipient = ApiCommonFunctions.getRecipient();

    @Test
    @Ignore
    public void multithreadingTest() throws ExecutionException, InterruptedException {

        Set<String> users = new HashSet<>(Arrays.asList("79997714662", "70000000090", "70000027545"));
        Map<String, String> map = new HashMap<>();
        map.put("79997714662", "123456");

        ConcurrentLinkedQueue<String> concurrentUsersQueue = new ConcurrentLinkedQueue<>(users);

        users.forEach(login -> service().authAs(login, map.getOrDefault(login, "12345a"), login));
        FeeResponse feeResponse = service().auth().queryParam("address", "MEYnzZkpqTE5G6ShyRj7hwnLcGK9zXxhED")
                .pathParams("currency", LTC)
                .queryParam("amount", "0.001").get(EndPoints.wallet_send_fee_currency)
                .as(FeeResponse.class);

        BigDecimal fee = feeResponse.getFee();

        Callable<Integer> task = () -> {
            String login = concurrentUsersQueue.peek();
            WalletSendReq req = new WalletSendReq()
                    .setAddress("MEYnzZkpqTE5G6ShyRj7hwnLcGK9zXxhED")
                    .setAmount(new BigDecimal("0.001"))
                    .setCurrency(LTC)
                    .setFee(fee);
            service().auth().body(req).post(EndPoints.wallet_send).statusCode();
            concurrentUsersQueue.add(login);
            return 0;
        };

        ExecutorService service = Executors.newFixedThreadPool(concurrentUsersQueue.size());
        List<Future<Integer>> l = new ArrayList<>();
        for (int i = 0; i < concurrentUsersQueue.size(); i++) {
            l.add(service.submit(task));
        }
        for (Future<Integer> integerFuture : l) {
            integerFuture.get();
        }
        service.shutdown();
    }

    @Ignore
    @Test
    public void firstExternal() {
        BigDecimal amount = new BigDecimal("0.0001");
        String address = getWalletByCurrency(sender, BTC).orElseThrow(() -> new NoSuchWalletException(BTC, sender.getLogin())).getAddress();

        new BtcWallet().sendTransaction(address, amount);
    }

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
        Wallet wallet = wallets.stream().filter(e -> e.getBalance().compareTo(e.getCurrency().getMinValueToSendPhone()) >= 0)
                .findFirst().orElseThrow(() -> new NoSuchWalletException("No wallet with balance >= 0.001 presented"));
        service().auth().queryParam("address", wallet.getAddress())
                .pathParams("currency", wallet.getCurrency())
                .queryParam("amount", "0.0001").get(EndPoints.wallet_send_fee_currency)
                .as(FeeResponse.class);
    }

    @Test
    @DisplayName(EndPoints.wallet_transaction + " GET")
    public void testWalletTransactions() {

        List<OperationType> transferWalletTypes = Collections.singletonList(TRANSFER_WALLET);
        List<OperationType> transferPhoneTypes = Collections.singletonList(TRANSFER_PHONE);
        List<OperationType> receiveTypes = Arrays.asList(RECEIVE_WALLET_EXTERNAL, RECEIVE_CARD, RECEIVE_WALLET_INTERNAL);
        List<OperationType> payoutTypes = Arrays.asList(PAYOUT_CARD_PAYNETEASY, PAYOUT_WALLET, PAYOUT_BANK, PAYOUT_BPAY, PAYOUT_BSB, PAYOUT_CARD, PAYOUT_RUBANK);
        List<OperationType> paymentsTypes = Arrays.asList(TOPUP_MOBILE, TOPUP, VOUCHER, PAYQR);
        List<OperationType> exchangeTypes = Arrays.asList(EXCHANGE, EXCHANGE_TO_CUSTOMER);

        List<History> transactions = service().auth()
                .queryParam("size", 9999)
                .get(EndPoints.wallet_transaction).as(WalletHistoryResponseModel.class).getHistory();

        checkTransactionList(transferWalletTypes, transactions, "TRANSFER_WALLET");
        checkTransactionList(transferPhoneTypes, transactions, "TRANSFER_PHONE");
        checkTransactionList(receiveTypes, transactions, "RECEIVE");
        checkTransactionList(payoutTypes, transactions, "PAYOUT");
        checkTransactionList(paymentsTypes, transactions, "PAYMENTS");
        checkTransactionList(exchangeTypes, transactions, "EXCHANGE");
        checkTransactionList(join(transferWalletTypes, transferPhoneTypes), transactions,
                "TRANSFER_WALLET", "TRANSFER_PHONE");
        checkTransactionList(join(transferWalletTypes, transferPhoneTypes, receiveTypes), transactions,
                "TRANSFER_WALLET", "TRANSFER_PHONE", "RECEIVE");
        checkTransactionList(join(transferWalletTypes, transferPhoneTypes, receiveTypes, payoutTypes), transactions,
                "TRANSFER_WALLET", "TRANSFER_PHONE", "RECEIVE", "PAYOUT");
        checkTransactionList(join(transferWalletTypes, transferPhoneTypes, receiveTypes, payoutTypes, exchangeTypes), transactions,
                "TRANSFER_WALLET", "TRANSFER_PHONE", "RECEIVE", "PAYOUT", "EXCHANGE");
        checkTransactionList(join(transferWalletTypes, transferPhoneTypes, receiveTypes, payoutTypes, exchangeTypes, paymentsTypes), transactions,
                "TRANSFER_WALLET", "TRANSFER_PHONE", "RECEIVE", "PAYOUT", "PAYMENTS", "EXCHANGE");
    }

    @SafeVarargs
    private final <S> List<S> join(Collection<S> first, Collection<S> second, Collection<S>... others) {
        Stream<S> stream = Stream.concat(first.stream(), second.stream());
        for (Collection<S> array : others) {
            stream = Stream.concat(stream, array.stream());
        }
        return stream.collect(Collectors.toList());
    }

    private void checkTransactionList(List<OperationType> types, List<History> transactions, String... filters) {

        List<History> filteredTransactions = service().auth()
                .queryParam("offset", 0)
                .queryParam("size", 9999)
                .queryParam("typeFilter", Arrays.asList(filters))
                .get(EndPoints.wallet_transaction).as(WalletHistoryResponseModel.class).getHistory();
        Set<OperationType> transferActualTypes = filteredTransactions.stream()
                .map(History::getOperationType).collect(Collectors.toSet());
        String errMessage = String.format("Error in filter %s", String.join(",", filters));

        transferActualTypes.forEach(type -> Assert.assertTrue(String.format("Wrong type %s found for filter %s", type, String.join(",", filters)), types.contains(type)));
        Assert.assertEquals(errMessage, filteredTransactions.size(), transactions.stream()
                .filter(t -> types.contains(t.getOperationType())).count());
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

    @TestFactory
    @DisplayName("Sendcrypto")
    public Collection<DynamicNode> testSendCrypto() {
        List<Wallet> wallets = service().auth().get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();
        return wallets.stream().map(w -> dynamicContainer(w.getCurrency().getCurrency(), Stream.of(
                dynamicTest("Sendcrypto. " + w.getCurrency() + " by address", () -> {
                    BigDecimal amount = w.getCurrency().getMinValueToSendPhone();
                    Assume.assumeTrue(w.getBalance().compareTo(amount) >= 0);
                    testSendCrypto(commonBodyForAddress(w.getCurrency(), amount.toPlainString()), new TransferWalletHistoryProcessor());
                }),
                dynamicTest("Sendcrypto. " + w.getCurrency() + " by phone", () -> {
                    BigDecimal amount = w.getCurrency().getMinValueToSendPhone();
                    Assume.assumeTrue(w.getBalance().compareTo(amount) >= 0);
                    testSendCrypto(commonBodyForPhone(w.getCurrency(), amount.toPlainString()), new TransferPhoneHistoryProcessor());
                })
        ))).collect(Collectors.toList());
    }

    @Ignore
    @Test
    @Financial
    @ScopeTarget({ScopeTarget.Stand.STAGE, ScopeTarget.Stand.PROD})
    @DisplayName("Send crypto external CRPT")
    public void testExternalCrpt() {
        testExternalInvoice(commonBodyForExternalAddress(CRPT, "0.01", "0x862120895A71D43A30FB5993685D6a6AC1B5bCee"));
    }

    @Ignore
    @Test
    @Financial
    @ScopeTarget({ScopeTarget.Stand.STAGE, ScopeTarget.Stand.PROD})
    @DisplayName("Send crypto external ETH")
    public void testExternalEth() {
        testExternalInvoice(commonBodyForExternalAddress(ETH, "0.0001", "0x862120895A71D43A30FB5993685D6a6AC1B5bCee"));
    }

    @Ignore
    @Test
    @Financial
    @ScopeTarget({ScopeTarget.Stand.STAGE, ScopeTarget.Stand.PROD})
    @DisplayName("Send crypto external BTC")
    public void testExternalBtc() {
        testExternalInvoice(commonBodyForExternalAddress(BTC, "0.001", "1Zj3f8X3APaq8NiD4x1jjRYSJH5eLesfr"));
    }

    @Ignore
    @Test
    @Financial
    @ScopeTarget({ScopeTarget.Stand.STAGE, ScopeTarget.Stand.PROD})
    @DisplayName("Send crypto external LTC")
    public void testExternalLtc() {
        testExternalInvoice(commonBodyForExternalAddress(LTC, "0.01", "MFWKvvwPxkhSwiEjEssRkDSFqoKtw8gjhf"));
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
            if (transaction != null && transaction.getOperationStatus() == History.OperationStatus.COMPLETED) {
                break;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (transaction == null || !transaction.getOperationStatus().equals(History.OperationStatus.COMPLETED)) {
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

        Assert.assertTrue(BalanceAssertManager.equal(senderBalanceAfter, expectedSenderBalance));
        Assert.assertTrue(BalanceAssertManager.equal(recipientBalanceAfter, expectedRecipientBalance));
    }

    //TODO: Написать добавить класс AfterChecks или что то подобное
    private void testExternalInvoice(BodyCreator bodyCreator) {
        WalletSendReq body = bodyCreator.create();

        BigDecimal senderAmountBefore = getWalletByCurrency(sender, body.getCurrency())
                .orElseThrow(() -> new NoSuchWalletException(body.getCurrency(), sender.getLogin()))
                .getBalance();

        service().auth().body(body).post(EndPoints.wallet_send).as(WalletSendResponseModel.class);

        BigDecimal expectedSenderBalance = senderAmountBefore.subtract(
                body.getAmount().add(body.getFee()));

        BigDecimal senderBalanceAfter = getWalletByCurrency(sender, body.getCurrency())
                .orElseThrow(() -> new NoSuchWalletException(body.getCurrency(), sender.getLogin()))
                .getBalance();

        Assert.assertTrue(BalanceAssertManager.equal(senderBalanceAfter, expectedSenderBalance));
    }

    private BodyCreator commonBodyForAddress(Currency currency, String amount) {
        return () -> {

            String errorMessage = String.format("No wallet found for currency %s for user %s", currency, recipient.getLogin());
            Wallet wallet = getWalletByCurrency(recipient, currency).orElseThrow(() ->
                    new NoSuchWalletException(errorMessage));
            String address = wallet.getAddress();

            String separator = amount.contains(".") ? "0" : ".0";
            String amountWithTimeStamp = amount + separator + new SimpleDateFormat("ddSSmmHH").format(new Date());
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

    private BodyCreator commonBodyForExternalAddress(Currency currency, String amount, String address) {
        return () -> {
            String amountWithTimeStamp = amount;
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
            String separator = amount.contains(".") ? "0" : ".0";
            String amountWithTimeStamp = amount + separator + new SimpleDateFormat("ddSSmmHH").format(new Date());
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

        List<Wallet> wallets = service().authAs(user.getLogin(), user.getPassword(), user.getLogin())
                .get(EndPoints.wallet_list).as(WalletListResp.class).getWallets();

        return wallets.stream().filter(e -> e.getCurrency().equals(currency)).filter(w -> w.getId() != -1).findFirst();
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
            System.out.println(String.format("Looking for %s", amount.toString()));
            return this.transactions.stream().filter(t -> t.getOperationType() == TRANSFER_PHONE)
                    .filter(t ->
                            BalanceAssertManager.equal(t.getWalletHistoryRecordTransferPhone().getCreditAmount().getValue(), amount)
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
            System.out.println(String.format("Looking for %s", amount.toString()));
            return this.transactions.stream().filter(t -> t.getOperationType() == TRANSFER_WALLET)
                    .filter(t ->
                            BalanceAssertManager.equal(t.getWalletHistoryRecordTransferWallet().getCreditAmount().getValue(), amount)
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
