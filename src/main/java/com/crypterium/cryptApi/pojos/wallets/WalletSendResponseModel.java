
package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletSendResponseModel {

    @Expose
    private String txId;
    @Expose
    private Long fee;
    @Expose
    private Boolean internal;
    @Expose
    private String sequenceId;

    public WalletSendResponseModel() {
    }

    public WalletSendResponseModel(String txId, Long fee, Boolean internal, String sequenceId) {
        this.txId = txId;
        this.fee = fee;
        this.internal = internal;
        this.sequenceId = sequenceId;
    }

    public Long getFee() {
        return fee;
    }

    public WalletSendResponseModel setFee(Long fee) {
        this.fee = fee;
        return this;
    }

    public Boolean getInternal() {
        return internal;
    }

    public WalletSendResponseModel setInternal(Boolean internal) {
        this.internal = internal;
        return this;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public WalletSendResponseModel setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
        return this;
    }

    public String getTxId() {
        return txId;
    }

    public WalletSendResponseModel setTxId(String txId) {
        this.txId = txId;
        return this;
    }
}
