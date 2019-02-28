
package com.crypterium.cryptApi.newback.pojos.wallets;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
