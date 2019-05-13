
package com.crypterium.cryptApi.pojos.payout;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PayoutOfferRequestModel {

    @Expose
    private BigDecimal amountFrom;
    @Expose
    private String cardNumber;
    @Expose
    private Currency currencyFrom;

    public PayoutOfferRequestModel() {
    }

    public PayoutOfferRequestModel(BigDecimal amountFrom, String cardNumber, Currency currencyFrom) {
        this.amountFrom = amountFrom;
        this.cardNumber = cardNumber;
        this.currencyFrom = currencyFrom;
    }

    public BigDecimal getAmountFrom() {
        return amountFrom;
    }

    public PayoutOfferRequestModel setAmountFrom(BigDecimal amountFrom) {
        this.amountFrom = amountFrom;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public PayoutOfferRequestModel setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public PayoutOfferRequestModel setCurrencyFrom(Currency currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }
}
