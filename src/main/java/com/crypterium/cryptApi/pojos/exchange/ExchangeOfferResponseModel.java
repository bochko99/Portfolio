
package com.crypterium.cryptApi.pojos.exchange;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.Date;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ExchangeOfferResponseModel {

    @Expose
    private BigDecimal exchangeRate;
    @Expose
    private Date expirationDateTime;
    @Expose
    private SourceCurrencyAmount sourceCurrencyAmount;
    @Expose
    private TargetCurrencyAmount targetCurrencyAmount;
    @Expose
    private Long offerId;

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public ExchangeOfferResponseModel setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    public Date getExpirationDateTime() {
        return expirationDateTime;
    }

    public ExchangeOfferResponseModel setExpirationDateTime(Date expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
        return this;
    }

    public SourceCurrencyAmount getSourceCurrencyAmount() {
        return sourceCurrencyAmount;
    }

    public ExchangeOfferResponseModel setSourceCurrencyAmount(SourceCurrencyAmount sourceCurrencyAmount) {
        this.sourceCurrencyAmount = sourceCurrencyAmount;
        return this;
    }

    public TargetCurrencyAmount getTargetCurrencyAmount() {
        return targetCurrencyAmount;
    }

    public ExchangeOfferResponseModel setTargetCurrencyAmount(TargetCurrencyAmount targetCurrencyAmount) {
        this.targetCurrencyAmount = targetCurrencyAmount;
        return this;
    }

    public Long getOfferId() {
        return offerId;
    }

    public ExchangeOfferResponseModel setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }
}
