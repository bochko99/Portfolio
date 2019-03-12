
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BanksWithdrawalRuIndRequestModel {

    @Expose
    private String offerId;
    @Expose
    private Payer payer;
    @Expose
    private String paymentPurpose;
    @Expose
    private RuRequisites requisites;

    public String getOfferId() {
        return offerId;
    }

    public BanksWithdrawalRuIndRequestModel setOfferId(String offerId) {
        this.offerId = offerId;
        return this;
    }

    public Payer getPayer() {
        return payer;
    }

    public BanksWithdrawalRuIndRequestModel setPayer(Payer payer) {
        this.payer = payer;
        return this;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public BanksWithdrawalRuIndRequestModel setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    public RuRequisites getRequisites() {
        return requisites;
    }

    public BanksWithdrawalRuIndRequestModel setRequisites(RuRequisites requisites) {
        this.requisites = requisites;
        return this;
    }
}
