
package com.crypterium.cryptApi.oldback.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesExchangesRateModel {

    @Expose
    private Long amountMax;
    @Expose
    private Long amountMin;
    @Expose
    private Long amountScaleFrom;
    @Expose
    private Long amountScaleTo;
    @Expose
    private String currencyFrom;
    @Expose
    private String currencyTo;
    @Expose
    private Long feeFrom;
    @Expose
    private Long feeTo;
    @Expose
    private Long rate;

    public Long getAmountMax() {
        return amountMax;
    }

    public InvoicesExchangesRateModel setAmountMax(Long amountMax) {
        this.amountMax = amountMax;
        return this;
    }

    public Long getAmountMin() {
        return amountMin;
    }

    public InvoicesExchangesRateModel setAmountMin(Long amountMin) {
        this.amountMin = amountMin;
        return this;
    }

    public Long getAmountScaleFrom() {
        return amountScaleFrom;
    }

    public InvoicesExchangesRateModel setAmountScaleFrom(Long amountScaleFrom) {
        this.amountScaleFrom = amountScaleFrom;
        return this;
    }

    public Long getAmountScaleTo() {
        return amountScaleTo;
    }

    public InvoicesExchangesRateModel setAmountScaleTo(Long amountScaleTo) {
        this.amountScaleTo = amountScaleTo;
        return this;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public InvoicesExchangesRateModel setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public InvoicesExchangesRateModel setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
        return this;
    }

    public Long getFeeFrom() {
        return feeFrom;
    }

    public InvoicesExchangesRateModel setFeeFrom(Long feeFrom) {
        this.feeFrom = feeFrom;
        return this;
    }

    public Long getFeeTo() {
        return feeTo;
    }

    public InvoicesExchangesRateModel setFeeTo(Long feeTo) {
        this.feeTo = feeTo;
        return this;
    }

    public Long getRate() {
        return rate;
    }

    public InvoicesExchangesRateModel setRate(Long rate) {
        this.rate = rate;
        return this;
    }
}
