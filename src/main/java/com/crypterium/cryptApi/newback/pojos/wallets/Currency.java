package com.crypterium.cryptApi.newback.pojos.wallets;

public enum Currency {

    BTC("BTC"),
    ETH("ETH"),
    LTC("LTC"),
    CRPT("CRPT"),
    EUR("EUR");

    private String value;

    Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
