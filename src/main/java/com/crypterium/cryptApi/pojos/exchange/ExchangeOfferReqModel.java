
package com.crypterium.cryptApi.pojos.exchange;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class ExchangeOfferReqModel {


    @Expose
    private BigDecimal amountFrom;
    @Expose
    private BigDecimal amountTo;
    @Expose
    private Currency currencyFrom;
    @Expose
    private Currency currencyTo;
    @Expose
    private Long offerId;

    public BigDecimal getAmountFrom() {
        return amountFrom;
    }

    public ExchangeOfferReqModel setAmountFrom(BigDecimal amountFrom) {
        this.amountFrom = amountFrom;
        return this;
    }

    public BigDecimal getAmountTo() {
        return amountTo;
    }

    public ExchangeOfferReqModel setAmountTo(BigDecimal amountTo) {
        this.amountTo = amountTo;
        return this;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public ExchangeOfferReqModel setCurrencyFrom(Currency currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public ExchangeOfferReqModel setCurrencyTo(Currency currencyTo) {
        this.currencyTo = currencyTo;
        return this;
    }

    public Long getOfferId() {
        return offerId;
    }

    public ExchangeOfferReqModel setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }
}
