
package com.crypterium.cryptApi.newback.pojos.wallets;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletSendReq {

    @Expose
    private String address;
    @Expose
    private Long amount;
    @Expose
    private String currency;
    @Expose
    private Long customerId;
    @Expose
    private String description;
    @Expose
    private Long fee;
    @Expose
    private String phone;

    public String getAddress() {
        return address;
    }

    public WalletSendReq setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public WalletSendReq setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public WalletSendReq setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public WalletSendReq setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WalletSendReq setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getFee() {
        return fee;
    }

    public WalletSendReq setFee(Long fee) {
        this.fee = fee;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public WalletSendReq setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
