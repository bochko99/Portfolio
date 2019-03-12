
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Fee {

    @Expose
    private BigDecimal amount;
    @Expose
    private WithdrawalCurrency currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public Fee setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public WithdrawalCurrency getCurrency() {
        return currency;
    }

    public Fee setCurrency(WithdrawalCurrency currency) {
        this.currency = currency;
        return this;
    }
}
