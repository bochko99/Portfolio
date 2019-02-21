
package com.crypterium.cryptApi.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CustomData {

    @Expose
    private String amountMax;
    @Expose
    private String amountMin;
    @Expose
    private String amountStep;
    @Expose
    private String doSkipProcessing;
    @Expose
    private String paymentMethod;
    @Expose
    private String withdrawCryptoWalletCurrency;
    @Expose
    private String withdrawProfileCurrency;

    public String getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(String amountMax) {
        this.amountMax = amountMax;
    }

    public String getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(String amountMin) {
        this.amountMin = amountMin;
    }

    public String getAmountStep() {
        return amountStep;
    }

    public void setAmountStep(String amountStep) {
        this.amountStep = amountStep;
    }

    public String getDoSkipProcessing() {
        return doSkipProcessing;
    }

    public void setDoSkipProcessing(String doSkipProcessing) {
        this.doSkipProcessing = doSkipProcessing;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getWithdrawCryptoWalletCurrency() {
        return withdrawCryptoWalletCurrency;
    }

    public void setWithdrawCryptoWalletCurrency(String withdrawCryptoWalletCurrency) {
        this.withdrawCryptoWalletCurrency = withdrawCryptoWalletCurrency;
    }

    public String getWithdrawProfileCurrency() {
        return withdrawProfileCurrency;
    }

    public void setWithdrawProfileCurrency(String withdrawProfileCurrency) {
        this.withdrawProfileCurrency = withdrawProfileCurrency;
    }

}
