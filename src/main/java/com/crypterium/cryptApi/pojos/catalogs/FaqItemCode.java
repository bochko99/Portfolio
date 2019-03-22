package com.crypterium.cryptApi.pojos.catalogs;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FaqItemCode {

    @JsonProperty("Wallet")
    WALLET("Wallet"),
    @JsonProperty("SendCrypto")
    SEND_CRYPTO("SendCrypto"),
    @JsonProperty("TransferByMobile")
    TRANSFER_BY_MOBILE("TransferByMobile"),
    @JsonProperty("Exchange")
    EXCHANGE("Exchange"),
    @JsonProperty("Iban")
    IBAN("Iban"),
    @JsonProperty("TopUp")
    TOP_UP("TopUp"),
    @JsonProperty("Vouchers")
    VOUCHERS("Vouchers"),
    @JsonProperty("BPay")
    BPAY("BPay"),
    @JsonProperty("BuyCrpt")
    BUY_CRPT("BuyCrpt");

    private String value;

    FaqItemCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return value;
    }

}
