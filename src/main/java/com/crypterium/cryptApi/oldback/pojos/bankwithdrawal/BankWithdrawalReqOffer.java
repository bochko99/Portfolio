
package com.crypterium.cryptApi.oldback.pojos.bankwithdrawal;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BankWithdrawalReqOffer {

    @Expose
    private static BigDecimal amount;
    @Expose
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public BankWithdrawalReqOffer setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BankWithdrawalReqOffer setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
