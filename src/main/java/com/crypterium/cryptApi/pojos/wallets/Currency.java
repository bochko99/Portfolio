package com.crypterium.cryptApi.pojos.wallets;

import java.math.BigDecimal;

public enum Currency {

    BTC("BTC", true, "0.0001"),
    ETH("ETH", true, "0.0001"),
    LTC("LTC", true, "0.001"),
    CRPT("CRPT", true, "0.01"),
    USDC("USDC", true, "0.01"),
    EUR("EUR", false, "0");

    private String value;
    private Boolean isCrypto;
    private BigDecimal minValueToSendPhone;

    Currency(String value, Boolean isCrypto, String minValueToSendPhone) {
        this.value = value;
        this.isCrypto = isCrypto;
        this.minValueToSendPhone = new BigDecimal(minValueToSendPhone);
    }

    public String getValue() {
        return value;
    }

    public Boolean getCrypto() {
        return isCrypto;
    }

    public BigDecimal getMinValueToSendPhone() {
        return minValueToSendPhone;
    }
}
