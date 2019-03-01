
package com.crypterium.cryptApi.newback.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class GetFee {

    @Expose
    private Long fee;
    @Expose
    private String sourceCurrency;

    public Long getFee() {
        return fee;
    }

    public GetFee setFee(Long fee) {
        this.fee = fee;
        return this;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public GetFee setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
        return this;
    }
}
