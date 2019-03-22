
package com.crypterium.cryptApi.pojos.wallets.history;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class History {

    @Expose
    private String operationDate;
    @Expose
    private String operationStatus;
    @Expose
    private String operationType;
    @Expose
    private WalletHistoryRecordExchange walletHistoryRecordExchange;
    @Expose
    private WalletHistoryRecordFeeCollection walletHistoryRecordFeeCollection;
    @Expose
    private WalletHistoryRecordPayQR walletHistoryRecordPayQR;
    @Expose
    private WalletHistoryRecordPayoutBPay walletHistoryRecordPayoutBPay;
    @Expose
    private WalletHistoryRecordPayoutBSB walletHistoryRecordPayoutBSB;
    @Expose
    private WalletHistoryRecordPayoutBank walletHistoryRecordPayoutBank;
    @Expose
    private WalletHistoryRecordPayoutCard walletHistoryRecordPayoutCard;
    @Expose
    private WalletHistoryRecordPayoutRuBank walletHistoryRecordPayoutRuBank;
    @Expose
    private WalletHistoryRecordPayoutWallet walletHistoryRecordPayoutWallet;
    @Expose
    private WalletHistoryRecordReceiveCard walletHistoryRecordReceiveCard;
    @Expose
    private WalletHistoryRecordReceiveExternal walletHistoryRecordReceiveExternal;
    @Expose
    private WalletHistoryRecordReceiveInternal walletHistoryRecordReceiveInternal;
    @Expose
    private WalletHistoryRecordTopUp walletHistoryRecordTopUp;
    @Expose
    private WalletHistoryRecordTopUpMobile walletHistoryRecordTopUpMobile;
    @Expose
    private WalletHistoryRecordTransferPhone walletHistoryRecordTransferPhone;
    @Expose
    private WalletHistoryRecordTransferWallet walletHistoryRecordTransferWallet;
    @Expose
    private WalletHistoryRecordVoucher walletHistoryRecordVoucher;

    public String getOperationDate() {
        return operationDate;
    }

    public History setOperationDate(String operationDate) {
        this.operationDate = operationDate;
        return this;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public History setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public String getOperationType() {
        return operationType;
    }

    public History setOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public WalletHistoryRecordExchange getWalletHistoryRecordExchange() {
        return walletHistoryRecordExchange;
    }

    public History setWalletHistoryRecordExchange(WalletHistoryRecordExchange walletHistoryRecordExchange) {
        this.walletHistoryRecordExchange = walletHistoryRecordExchange;
        return this;
    }

    public WalletHistoryRecordFeeCollection getWalletHistoryRecordFeeCollection() {
        return walletHistoryRecordFeeCollection;
    }

    public History setWalletHistoryRecordFeeCollection(WalletHistoryRecordFeeCollection walletHistoryRecordFeeCollection) {
        this.walletHistoryRecordFeeCollection = walletHistoryRecordFeeCollection;
        return this;
    }

    public WalletHistoryRecordPayQR getWalletHistoryRecordPayQR() {
        return walletHistoryRecordPayQR;
    }

    public History setWalletHistoryRecordPayQR(WalletHistoryRecordPayQR walletHistoryRecordPayQR) {
        this.walletHistoryRecordPayQR = walletHistoryRecordPayQR;
        return this;
    }

    public WalletHistoryRecordPayoutBPay getWalletHistoryRecordPayoutBPay() {
        return walletHistoryRecordPayoutBPay;
    }

    public History setWalletHistoryRecordPayoutBPay(WalletHistoryRecordPayoutBPay walletHistoryRecordPayoutBPay) {
        this.walletHistoryRecordPayoutBPay = walletHistoryRecordPayoutBPay;
        return this;
    }

    public WalletHistoryRecordPayoutBSB getWalletHistoryRecordPayoutBSB() {
        return walletHistoryRecordPayoutBSB;
    }

    public History setWalletHistoryRecordPayoutBSB(WalletHistoryRecordPayoutBSB walletHistoryRecordPayoutBSB) {
        this.walletHistoryRecordPayoutBSB = walletHistoryRecordPayoutBSB;
        return this;
    }

    public WalletHistoryRecordPayoutBank getWalletHistoryRecordPayoutBank() {
        return walletHistoryRecordPayoutBank;
    }

    public History setWalletHistoryRecordPayoutBank(WalletHistoryRecordPayoutBank walletHistoryRecordPayoutBank) {
        this.walletHistoryRecordPayoutBank = walletHistoryRecordPayoutBank;
        return this;
    }

    public WalletHistoryRecordPayoutCard getWalletHistoryRecordPayoutCard() {
        return walletHistoryRecordPayoutCard;
    }

    public History setWalletHistoryRecordPayoutCard(WalletHistoryRecordPayoutCard walletHistoryRecordPayoutCard) {
        this.walletHistoryRecordPayoutCard = walletHistoryRecordPayoutCard;
        return this;
    }

    public WalletHistoryRecordPayoutRuBank getWalletHistoryRecordPayoutRuBank() {
        return walletHistoryRecordPayoutRuBank;
    }

    public History setWalletHistoryRecordPayoutRuBank(WalletHistoryRecordPayoutRuBank walletHistoryRecordPayoutRuBank) {
        this.walletHistoryRecordPayoutRuBank = walletHistoryRecordPayoutRuBank;
        return this;
    }

    public WalletHistoryRecordPayoutWallet getWalletHistoryRecordPayoutWallet() {
        return walletHistoryRecordPayoutWallet;
    }

    public History setWalletHistoryRecordPayoutWallet(WalletHistoryRecordPayoutWallet walletHistoryRecordPayoutWallet) {
        this.walletHistoryRecordPayoutWallet = walletHistoryRecordPayoutWallet;
        return this;
    }

    public WalletHistoryRecordReceiveCard getWalletHistoryRecordReceiveCard() {
        return walletHistoryRecordReceiveCard;
    }

    public History setWalletHistoryRecordReceiveCard(WalletHistoryRecordReceiveCard walletHistoryRecordReceiveCard) {
        this.walletHistoryRecordReceiveCard = walletHistoryRecordReceiveCard;
        return this;
    }

    public WalletHistoryRecordReceiveExternal getWalletHistoryRecordReceiveExternal() {
        return walletHistoryRecordReceiveExternal;
    }

    public History setWalletHistoryRecordReceiveExternal(WalletHistoryRecordReceiveExternal walletHistoryRecordReceiveExternal) {
        this.walletHistoryRecordReceiveExternal = walletHistoryRecordReceiveExternal;
        return this;
    }

    public WalletHistoryRecordReceiveInternal getWalletHistoryRecordReceiveInternal() {
        return walletHistoryRecordReceiveInternal;
    }

    public History setWalletHistoryRecordReceiveInternal(WalletHistoryRecordReceiveInternal walletHistoryRecordReceiveInternal) {
        this.walletHistoryRecordReceiveInternal = walletHistoryRecordReceiveInternal;
        return this;
    }

    public WalletHistoryRecordTopUp getWalletHistoryRecordTopUp() {
        return walletHistoryRecordTopUp;
    }

    public History setWalletHistoryRecordTopUp(WalletHistoryRecordTopUp walletHistoryRecordTopUp) {
        this.walletHistoryRecordTopUp = walletHistoryRecordTopUp;
        return this;
    }

    public WalletHistoryRecordTopUpMobile getWalletHistoryRecordTopUpMobile() {
        return walletHistoryRecordTopUpMobile;
    }

    public History setWalletHistoryRecordTopUpMobile(WalletHistoryRecordTopUpMobile walletHistoryRecordTopUpMobile) {
        this.walletHistoryRecordTopUpMobile = walletHistoryRecordTopUpMobile;
        return this;
    }

    public WalletHistoryRecordTransferPhone getWalletHistoryRecordTransferPhone() {
        return walletHistoryRecordTransferPhone;
    }

    public History setWalletHistoryRecordTransferPhone(WalletHistoryRecordTransferPhone walletHistoryRecordTransferPhone) {
        this.walletHistoryRecordTransferPhone = walletHistoryRecordTransferPhone;
        return this;
    }

    public WalletHistoryRecordTransferWallet getWalletHistoryRecordTransferWallet() {
        return walletHistoryRecordTransferWallet;
    }

    public History setWalletHistoryRecordTransferWallet(WalletHistoryRecordTransferWallet walletHistoryRecordTransferWallet) {
        this.walletHistoryRecordTransferWallet = walletHistoryRecordTransferWallet;
        return this;
    }

    public WalletHistoryRecordVoucher getWalletHistoryRecordVoucher() {
        return walletHistoryRecordVoucher;
    }

    public History setWalletHistoryRecordVoucher(WalletHistoryRecordVoucher walletHistoryRecordVoucher) {
        this.walletHistoryRecordVoucher = walletHistoryRecordVoucher;
        return this;
    }
}
