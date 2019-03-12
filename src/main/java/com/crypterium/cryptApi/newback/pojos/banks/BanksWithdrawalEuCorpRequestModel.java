
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BanksWithdrawalEuCorpRequestModel {

    @Expose
    private String offerId;
    @Expose
    private Payer payer;
    @Expose
    private String paymentPurpose;
    @Expose
    private EuCorpRequisites requisites;

    public String getOfferId() {
        return offerId;
    }

    public BanksWithdrawalEuCorpRequestModel setOfferId(String offerId) {
        this.offerId = offerId;
        return this;
    }

    public Payer getPayer() {
        return payer;
    }

    public BanksWithdrawalEuCorpRequestModel setPayer(Payer payer) {
        this.payer = payer;
        return this;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public BanksWithdrawalEuCorpRequestModel setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    public EuCorpRequisites getRequisites() {
        return requisites;
    }

    public BanksWithdrawalEuCorpRequestModel setRequisites(EuCorpRequisites requisites) {
        this.requisites = requisites;
        return this;
    }
}
