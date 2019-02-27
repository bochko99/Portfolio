
package com.crypterium.cryptApi.oldback.pojos.exchange;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ExchangeOfferReqModel {

    @Expose
    private BigDecimal amount;
    @Expose
    private String amountKind;
    @Expose
    private String sourceCurrencyCode;
    @Expose
    private String targetCurrencyCode;

    public BigDecimal getAmount() {
        return amount;
    }

    public ExchangeOfferReqModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getAmountKind() {
        return amountKind;
    }

    public ExchangeOfferReqModel setAmountKind(String amountKind) {
        this.amountKind = amountKind;
        return this;
    }

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    public ExchangeOfferReqModel setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
        return this;
    }

    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    public ExchangeOfferReqModel setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
        return this;
    }
}
