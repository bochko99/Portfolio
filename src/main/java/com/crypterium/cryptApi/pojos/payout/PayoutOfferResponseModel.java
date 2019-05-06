
package com.crypterium.cryptApi.pojos.payout;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.Date;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PayoutOfferResponseModel {

    @Expose
    private Date expirationTime;
    @Expose
    private Currency fiat;
    @Expose
    private Long offerId;
    @Expose
    private Rate ratesAndCommissions;

    public Date getExpirationTime() {
        return expirationTime;
    }

    public PayoutOfferResponseModel setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }

    public Currency getFiat() {
        return fiat;
    }

    public PayoutOfferResponseModel setFiat(Currency fiat) {
        this.fiat = fiat;
        return this;
    }

    public Long getOfferId() {
        return offerId;
    }

    public PayoutOfferResponseModel setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }

    public Rate getRatesAndCommissions() {
        return ratesAndCommissions;
    }

    public PayoutOfferResponseModel setRatesAndCommissions(Rate ratesAndCommissions) {
        this.ratesAndCommissions = ratesAndCommissions;
        return this;
    }
}
