
package com.crypterium.cryptApi.newback.pojos.exchangesx;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
