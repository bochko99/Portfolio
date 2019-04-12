
package com.crypterium.cryptApi.pojos.exchange;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TargetCurrencyAmount {

    @Expose
    private BigDecimal amount;
    @Expose
    private Currency currencyCode;

    public BigDecimal getAmount() {
        return amount;
    }

    public TargetCurrencyAmount setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Currency getCurrencyCode() {
        return currencyCode;
    }

    public TargetCurrencyAmount setCurrencyCode(Currency currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }
}
