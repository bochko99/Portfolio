
package com.crypterium.cryptApi.pojos.payout;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PayoutPayRequestModel {

    @Expose
    private String cardNumber;
    @Expose
    private Long offerId;

    public PayoutPayRequestModel() {
    }

    public PayoutPayRequestModel(String cardNumber, Long offerId) {
        this.cardNumber = cardNumber;
        this.offerId = offerId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public PayoutPayRequestModel setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public Long getOfferId() {
        return offerId;
    }

    public PayoutPayRequestModel setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }
}
