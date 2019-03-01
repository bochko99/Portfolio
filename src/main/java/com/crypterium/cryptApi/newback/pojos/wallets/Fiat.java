
package com.crypterium.cryptApi.newback.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Fiat {

    @Expose
    private BigDecimal amount;
    @Expose
    private Long change;
    @Expose
    private Long changePercent;
    @Expose
    private String customerCurrency;
    @Expose
    private Long rate;

    public BigDecimal getAmount() {
        return amount;
    }

    public Fiat setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Long getChange() {
        return change;
    }

    public Fiat setChange(Long change) {
        this.change = change;
        return this;
    }

    public Long getChangePercent() {
        return changePercent;
    }

    public Fiat setChangePercent(Long changePercent) {
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

    public Long getRate() {
        return rate;
    }

    public Fiat setRate(Long rate) {
        this.rate = rate;
        return this;
    }
}
