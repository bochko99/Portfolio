
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TotalWithdrawal {

    @Expose
    private BigDecimal amount;
    @Expose
    private WithdrawalCurrency currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public TotalWithdrawal setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public WithdrawalCurrency getCurrency() {
        return currency;
    }

    public TotalWithdrawal setCurrency(WithdrawalCurrency currency) {
        this.currency = currency;
        return this;
    }
}
