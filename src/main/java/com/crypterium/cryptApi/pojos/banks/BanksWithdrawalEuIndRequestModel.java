
package com.crypterium.cryptApi.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BanksWithdrawalEuIndRequestModel {

    @Expose
    private String offerId;
    @Expose
    private Payer payer;
    @Expose
    private String paymentPurpose;
    @Expose
    private EuRequisites requisites;

    public String getOfferId() {
        return offerId;
    }

    public BanksWithdrawalEuIndRequestModel setOfferId(String offerId) {
        this.offerId = offerId;
        return this;
    }

    public Payer getPayer() {
        return payer;
    }

    public BanksWithdrawalEuIndRequestModel setPayer(Payer payer) {
        this.payer = payer;
        return this;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public BanksWithdrawalEuIndRequestModel setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    public EuRequisites getRequisites() {
        return requisites;
    }

    public BanksWithdrawalEuIndRequestModel setRequisites(EuRequisites requisites) {
        this.requisites = requisites;
        return this;
    }
}
