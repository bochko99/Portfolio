
package com.crypterium.cryptApi.pojos.payout;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PayoutDataRequestModel {

    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PayoutDataRequestModel(String number) {
        this.number = number;
    }

    public PayoutDataRequestModel() {
    }
}
