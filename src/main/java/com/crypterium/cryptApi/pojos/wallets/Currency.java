package com.crypterium.cryptApi.pojos.wallets;

public enum Currency {

    USDC("USDC", true),
    BTC("BTC", true),
    ETH("ETH", true),
    LTC("LTC", true),
    CRPT("CRPT", true),
    EUR("EUR", false);

    private String value;
    private Boolean isCrypto;

    Currency(String value, Boolean isCrypto) {
        this.value = value;
        this.isCrypto = isCrypto;
    }

    public String getValue() {
        return value;
    }

    public Boolean getCrypto() {
        return isCrypto;
    }
}
