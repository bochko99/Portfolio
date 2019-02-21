
package com.crypterium.cryptApi.pojos.deposit;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DepositReqOfferModel {

    @Expose
    private Order order;


    public Order getOrder() {
        return order;
    }

    public DepositReqOfferModel setOrder(Order order) {
        this.order = order;
        return this;
    }
}
