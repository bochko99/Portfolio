package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletSendReq {

    @Expose
    private String address;
    @Expose
    private BigDecimal amount;
    @Expose
    private Currency currency;
    @Expose
    private Long customerId;
    @Expose
    private String description;
    @Expose
    private BigDecimal fee;
    @Expose
    private String phone;

    public String getAddress() {
        return address;
    }

    public WalletSendReq setAddress(String address) {
        this.address = address;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public WalletSendReq setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public WalletSendReq setCurrency(Currency currency) {
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

    public BigDecimal getFee() {
        return fee;
    }

    public WalletSendReq setFee(BigDecimal fee) {
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
