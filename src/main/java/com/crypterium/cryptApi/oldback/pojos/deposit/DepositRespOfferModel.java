
package com.crypterium.cryptApi.oldback.pojos.deposit;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DepositRespOfferModel {

    @Expose
    private String id;
    @Expose
    private Order order;
    @Expose
    private Payment payment;
    @Expose
    private String rate;
    @Expose
    private String validUntilUtc;

    public String getId() {
        return id;
    }

    public DepositRespOfferModel setId(String id) {
        this.id = id;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public DepositRespOfferModel setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public DepositRespOfferModel setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

    public String getRate() {
        return rate;
    }

    public DepositRespOfferModel setRate(String rate) {
        this.rate = rate;
        return this;
    }

    public String getValidUntilUtc() {
        return validUntilUtc;
    }

    public DepositRespOfferModel setValidUntilUtc(String validUntilUtc) {
        this.validUntilUtc = validUntilUtc;
        return this;
    }
}
