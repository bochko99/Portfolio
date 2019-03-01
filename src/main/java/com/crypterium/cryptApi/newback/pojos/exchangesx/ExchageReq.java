
package com.crypterium.cryptApi.newback.pojos.exchangesx;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ExchageReq {

    @Expose
    private Long transactionId;
    @Expose
    private Long volume;
    @Expose
    private Long walletFrom;
    @Expose
    private Long walletTo;

    public Long getTransactionId() {
        return transactionId;
    }

    public ExchageReq setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Long getVolume() {
        return volume;
    }

    public ExchageReq setVolume(Long volume) {
        this.volume = volume;
        return this;
    }

    public Long getWalletFrom() {
        return walletFrom;
    }

    public ExchageReq setWalletFrom(Long walletFrom) {
        this.walletFrom = walletFrom;
        return this;
    }

    public Long getWalletTo() {
        return walletTo;
    }

    public ExchageReq setWalletTo(Long walletTo) {
        this.walletTo = walletTo;
        return this;
    }
}
