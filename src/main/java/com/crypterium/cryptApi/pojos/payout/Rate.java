
package com.crypterium.cryptApi.pojos.payout;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Rate {

    @Expose
    private BigDecimal commissionFix;
    @Expose
    private BigDecimal commissionPercentage;
    @Expose
    private Currency currency;
    @Expose
    private BigDecimal maxCrypto;
    @Expose
    private BigDecimal minCrypto;
    @Expose
    private BigDecimal rate;

    public Rate() {
    }

    public Rate(BigDecimal commissionFix, BigDecimal commissionPercentage, Currency currency, BigDecimal maxCrypto, BigDecimal minCrypto, BigDecimal rate) {
        this.commissionFix = commissionFix;
        this.commissionPercentage = commissionPercentage;
        this.currency = currency;
        this.maxCrypto = maxCrypto;
        this.minCrypto = minCrypto;
        this.rate = rate;
    }

    public BigDecimal getCommissionFix() {
        return commissionFix;
    }

    public Rate setCommissionFix(BigDecimal commissionFix) {
        this.commissionFix = commissionFix;
        return this;
    }

    public BigDecimal getCommissionPercentage() {
        return commissionPercentage;
    }

    public Rate setCommissionPercentage(BigDecimal commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Rate setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getMaxCrypto() {
        return maxCrypto;
    }

    public Rate setMaxCrypto(BigDecimal maxCrypto) {
        this.maxCrypto = maxCrypto;
        return this;
    }

    public BigDecimal getMinCrypto() {
        return minCrypto;
    }

    public Rate setMinCrypto(BigDecimal minCrypto) {
        this.minCrypto = minCrypto;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Rate setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }
}
