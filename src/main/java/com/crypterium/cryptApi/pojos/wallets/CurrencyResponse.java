
package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CurrencyResponse {

    @Expose
    private Currency currency;
    @Expose
    private Boolean exists;

    public Currency getCurrency() {
        return currency;
    }

    public CurrencyResponse setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Boolean getExists() {
        return exists;
    }

    public CurrencyResponse setExists(Boolean exists) {
        this.exists = exists;
        return this;
    }
}
