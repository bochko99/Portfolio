
package com.crypterium.cryptApi.oldback.pojos.bankwithdrawal;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Gas {

    @Expose
    private Long amount;
    @Expose
    private String currency;

    public Long getAmount() {
        return amount;
    }

    public Gas setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Gas setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}