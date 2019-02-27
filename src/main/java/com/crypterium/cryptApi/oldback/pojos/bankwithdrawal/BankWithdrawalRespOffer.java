
package com.crypterium.cryptApi.oldback.pojos.bankwithdrawal;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BankWithdrawalRespOffer {

    @Expose
    private String createdDate;
    @Expose
    private Deposit deposit;
    @Expose
    private String expirationDate;
    @Expose
    private Fee fee;
    @Expose
    private Gas gas;
    @Expose
    private String id;
    @Expose
    private Long rate;
    @Expose
    private TotalWithdrawal totalWithdrawal;
    @Expose
    private Withdrawal withdrawal;

    public String getCreatedDate() {
        return createdDate;
    }

    public BankWithdrawalRespOffer setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public BankWithdrawalRespOffer setDeposit(Deposit deposit) {
        this.deposit = deposit;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public BankWithdrawalRespOffer setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Fee getFee() {
        return fee;
    }

    public BankWithdrawalRespOffer setFee(Fee fee) {
        this.fee = fee;
        return this;
    }

    public Gas getGas() {
        return gas;
    }

    public BankWithdrawalRespOffer setGas(Gas gas) {
        this.gas = gas;
        return this;
    }

    public String getId() {
        return id;
    }

    public BankWithdrawalRespOffer setId(String id) {
        this.id = id;
        return this;
    }

    public Long getRate() {
        return rate;
    }

    public BankWithdrawalRespOffer setRate(Long rate) {
        this.rate = rate;
        return this;
    }

    public TotalWithdrawal getTotalWithdrawal() {
        return totalWithdrawal;
    }

    public BankWithdrawalRespOffer setTotalWithdrawal(TotalWithdrawal totalWithdrawal) {
        this.totalWithdrawal = totalWithdrawal;
        return this;
    }

    public Withdrawal getWithdrawal() {
        return withdrawal;
    }

    public BankWithdrawalRespOffer setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
        return this;
    }
}
