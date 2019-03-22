
package com.crypterium.cryptApi.pojos.exchangesx;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ExchangeResp {

    @Expose
    private Long transactionId;

    public Long getTransactionId() {
        return transactionId;
    }

    public ExchangeResp setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
        return this;
    }
}
