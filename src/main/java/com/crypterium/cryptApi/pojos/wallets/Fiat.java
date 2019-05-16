
package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Fiat {

    @Expose
    private BigDecimal amount;
    @Expose
    private BigDecimal change;
    @Expose
    private BigDecimal changePercent;
    @Expose
    private String customerCurrency;
    @Expose
    private BigDecimal rate;

    public BigDecimal getAmount() {
        return amount;
    }

    public Fiat setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getChange() {
        return change;
    }

    public Fiat setChange(BigDecimal change) {
        this.change = change;
        return this;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public Fiat setChangePercent(BigDecimal changePercent) {
        this.changePercent = changePercent;
        return this;
    }

    public String getCustomerCurrency() {
        return customerCurrency;
    }

    public Fiat setCustomerCurrency(String customerCurrency) {
        this.customerCurrency = customerCurrency;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Fiat setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }
}
