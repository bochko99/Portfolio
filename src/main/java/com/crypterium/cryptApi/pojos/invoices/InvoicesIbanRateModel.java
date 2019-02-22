
package com.crypterium.cryptApi.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesIbanRateModel {

    @Expose
    private Long amountMax;
    @Expose
    private Long amountMin;
    @Expose
    private Long commissionAmountScale;
    @Expose
    private String commissionCurrency;
    @Expose
    private Long commissionPercent;
    @Expose
    private Long commissionRate;
    @Expose
    private Long marginRate;
    @Expose
    private Long payingAmountScale;
    @Expose
    private String payingCurrency;
    @Expose
    private Long payingFee;
    @Expose
    private Long rate;
    @Expose
    private Long transferingAmountScale;
    @Expose
    private String transferingCurrency;
    @Expose
    private Long transferingFee;

    public Long getAmountMax() {
        return amountMax;
    }

    public InvoicesIbanRateModel setAmountMax(Long amountMax) {
        this.amountMax = amountMax;
        return this;
    }

    public Long getAmountMin() {
        return amountMin;
    }

    public InvoicesIbanRateModel setAmountMin(Long amountMin) {
        this.amountMin = amountMin;
        return this;
    }

    public Long getCommissionAmountScale() {
        return commissionAmountScale;
    }

    public InvoicesIbanRateModel setCommissionAmountScale(Long commissionAmountScale) {
        this.commissionAmountScale = commissionAmountScale;
        return this;
    }

    public String getCommissionCurrency() {
        return commissionCurrency;
    }

    public InvoicesIbanRateModel setCommissionCurrency(String commissionCurrency) {
        this.commissionCurrency = commissionCurrency;
        return this;
    }

    public Long getCommissionPercent() {
        return commissionPercent;
    }

    public InvoicesIbanRateModel setCommissionPercent(Long commissionPercent) {
        this.commissionPercent = commissionPercent;
        return this;
    }

    public Long getCommissionRate() {
        return commissionRate;
    }

    public InvoicesIbanRateModel setCommissionRate(Long commissionRate) {
        this.commissionRate = commissionRate;
        return this;
    }

    public Long getMarginRate() {
        return marginRate;
    }

    public InvoicesIbanRateModel setMarginRate(Long marginRate) {
        this.marginRate = marginRate;
        return this;
    }

    public Long getPayingAmountScale() {
        return payingAmountScale;
    }

    public InvoicesIbanRateModel setPayingAmountScale(Long payingAmountScale) {
        this.payingAmountScale = payingAmountScale;
        return this;
    }

    public String getPayingCurrency() {
        return payingCurrency;
    }

    public InvoicesIbanRateModel setPayingCurrency(String payingCurrency) {
        this.payingCurrency = payingCurrency;
        return this;
    }

    public Long getPayingFee() {
        return payingFee;
    }

    public InvoicesIbanRateModel setPayingFee(Long payingFee) {
        this.payingFee = payingFee;
        return this;
    }

    public Long getRate() {
        return rate;
    }

    public InvoicesIbanRateModel setRate(Long rate) {
        this.rate = rate;
        return this;
    }

    public Long getTransferingAmountScale() {
        return transferingAmountScale;
    }

    public InvoicesIbanRateModel setTransferingAmountScale(Long transferingAmountScale) {
        this.transferingAmountScale = transferingAmountScale;
        return this;
    }

    public String getTransferingCurrency() {
        return transferingCurrency;
    }

    public InvoicesIbanRateModel setTransferingCurrency(String transferingCurrency) {
        this.transferingCurrency = transferingCurrency;
        return this;
    }

    public Long getTransferingFee() {
        return transferingFee;
    }

    public InvoicesIbanRateModel setTransferingFee(Long transferingFee) {
        this.transferingFee = transferingFee;
        return this;
    }
}
