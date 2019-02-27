
package com.crypterium.cryptApi.oldback.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoiceFundsWalletModel {

    @Expose
    private Float amount;
    @Expose
    private String id;

    public Float getAmount() {
        return amount;
    }

    public InvoiceFundsWalletModel setAmount(Float amount) {
        this.amount = amount;
        return this;
    }

    public String getId() {
        return id;
    }

    public InvoiceFundsWalletModel setId(String id) {
        this.id = id;
        return this;
    }
}
