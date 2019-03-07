package com.crypterium.cryptApi.newback.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FeeResponse {

    @Expose
    private BigDecimal fee;
    @Expose
    private Currency sourceCurrency;

    public BigDecimal getFee() {
        return fee;
    }

    public FeeResponse setFee(BigDecimal fee) {
        this.fee = fee;
        return this;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public FeeResponse setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
        return this;
    }
}
