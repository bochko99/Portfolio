
package com.crypterium.cryptApi.pojos.payout;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Limits {

    @Expose
    private BigDecimal available;
    @Expose
    private Currency currency;
    @Expose
    private BigDecimal limit;
    @Expose
    private BigDecimal min;

    public Limits() {
    }

    public Limits(BigDecimal available, Currency currency, BigDecimal limit) {
        this.available = available;
        this.currency = currency;
        this.limit = limit;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public Limits setAvailable(BigDecimal available) {
        this.available = available;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Limits setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public Limits setLimit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    public BigDecimal getMin() {
        return min;
    }

    public Limits setMin(BigDecimal min) {
        this.min = min;
        return this;
    }
}
