package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ExchangeRate {

    @Expose
    private Float multiplier;
    @Expose
    private Float rate;
    @Expose
    private Currency sourceCurrency;
    @Expose
    private Currency targetCurrency;

    public Float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Float multiplier) {
        this.multiplier = multiplier;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

}
