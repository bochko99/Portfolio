
package com.crypterium.cryptApi.pojos.exchange;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Pair {

    @Expose
    private BigDecimal amountScaleFrom;
    @Expose
    private BigDecimal amountScaleTo;
    @Expose
    private Currency currencyFrom;
    @Expose
    private Currency currencyTo;
    @Expose
    private BigDecimal maxAmountFrom;
    @Expose
    private BigDecimal maxAmountTo;
    @Expose
    private BigDecimal minAmountFrom;
    @Expose
    private BigDecimal minAmountTo;
    @Expose
    private BigDecimal rate;

    public BigDecimal getAmountScaleFrom() {
        return amountScaleFrom;
    }

    public Pair setAmountScaleFrom(BigDecimal amountScaleFrom) {
        this.amountScaleFrom = amountScaleFrom;
        return this;
    }

    public BigDecimal getAmountScaleTo() {
        return amountScaleTo;
    }

    public Pair setAmountScaleTo(BigDecimal amountScaleTo) {
        this.amountScaleTo = amountScaleTo;
        return this;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Pair setCurrencyFrom(Currency currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public Pair setCurrencyTo(Currency currencyTo) {
        this.currencyTo = currencyTo;
        return this;
    }

    public BigDecimal getMaxAmountFrom() {
        return maxAmountFrom;
    }

    public Pair setMaxAmountFrom(BigDecimal maxAmountFrom) {
        this.maxAmountFrom = maxAmountFrom;
        return this;
    }

    public BigDecimal getMaxAmountTo() {
        return maxAmountTo;
    }

    public Pair setMaxAmountTo(BigDecimal maxAmountTo) {
        this.maxAmountTo = maxAmountTo;
        return this;
    }

    public BigDecimal getMinAmountFrom() {
        return minAmountFrom;
    }

    public Pair setMinAmountFrom(BigDecimal minAmountFrom) {
        this.minAmountFrom = minAmountFrom;
        return this;
    }

    public BigDecimal getMinAmountTo() {
        return minAmountTo;
    }

    public Pair setMinAmountTo(BigDecimal minAmountTo) {
        this.minAmountTo = minAmountTo;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Pair setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }
}
