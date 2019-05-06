
package com.crypterium.cryptApi.pojos.payout;

import com.crypterium.cryptApi.pojos.wallets.Currency;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PayoutDataResponseModel {

    @Expose
    private Currency fiat;
    @Expose
    private Limits limits;
    @Expose
    private List<Rate> rates;

    public PayoutDataResponseModel() {
    }

    public PayoutDataResponseModel(Currency fiat, Limits limits, List<Rate> rates) {
        this.fiat = fiat;
        this.limits = limits;
        this.rates = rates;
    }

    public Currency getFiat() {
        return fiat;
    }

    public PayoutDataResponseModel setFiat(Currency fiat) {
        this.fiat = fiat;
        return this;
    }

    public Limits getLimits() {
        return limits;
    }

    public PayoutDataResponseModel setLimits(Limits limits) {
        this.limits = limits;
        return this;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public PayoutDataResponseModel setRates(List<Rate> rates) {
        this.rates = rates;
        return this;
    }
}
