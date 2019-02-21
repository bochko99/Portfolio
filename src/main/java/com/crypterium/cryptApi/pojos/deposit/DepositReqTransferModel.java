
package com.crypterium.cryptApi.pojos.deposit;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DepositReqTransferModel {

    @Expose
    private String cvv;
    @Expose
    private String expiredAt;
    @Expose
    private String holder;
    @Expose
    private String offerId;
    @Expose
    private String pan;

    public String getCvv() {
        return cvv;
    }

    public DepositReqTransferModel setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public DepositReqTransferModel setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    public String getHolder() {
        return holder;
    }

    public DepositReqTransferModel setHolder(String holder) {
        this.holder = holder;
        return this;
    }

    public String getOfferId() {
        return offerId;
    }

    public DepositReqTransferModel setOfferId(String offerId) {
        this.offerId = offerId;
        return this;
    }

    public String getPan() {
        return pan;
    }

    public DepositReqTransferModel setPan(String pan) {
        this.pan = pan;
        return this;
    }
}
