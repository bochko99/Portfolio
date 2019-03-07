
package com.crypterium.cryptApi.newback.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Wallet {

    @Expose
    private String address;
    @Expose
    private List<String> allowOperations;
    @Expose
    private BigDecimal avaliableBalance;
    @Expose
    private BigDecimal balance;
    @Expose
    private String color;
    @Expose
    private String createdAt;
    @Expose
    private Currency currency;
    @Expose
    private Long customerId;
    @Expose
    private Boolean debit;
    @Expose
    private String externalId;
    @Expose
    private Fiat fiat;
    @Expose
    private Long id;

    public String getAddress() {
        return address;
    }

    public Wallet setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<String> getAllowOperations() {
        return allowOperations;
    }

    public Wallet setAllowOperations(List<String> allowOperations) {
        this.allowOperations = allowOperations;
        return this;
    }

    public BigDecimal getAvaliableBalance() {
        return avaliableBalance;
    }

    public Wallet setAvaliableBalance(BigDecimal avaliableBalance) {
        this.avaliableBalance = avaliableBalance;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Wallet setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Wallet setColor(String color) {
        this.color = color;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Wallet setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Wallet setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Wallet setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Boolean getDebit() {
        return debit;
    }

    public Wallet setDebit(Boolean debit) {
        this.debit = debit;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public Wallet setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public Fiat getFiat() {
        return fiat;
    }

    public Wallet setFiat(Fiat fiat) {
        this.fiat = fiat;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Wallet setId(Long id) {
        this.id = id;
        return this;
    }
}
