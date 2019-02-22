package com.crypterium.cryptApi.pojos.deposit;

import java.math.BigDecimal;

public class MinAmountModel {

    private BigDecimal amount;
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public MinAmountModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public MinAmountModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
