
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BanksOfferResponseModel {

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
    private BigDecimal rate;
    @Expose
    private TotalWithdrawal totalWithdrawal;
    @Expose
    private Withdrawal withdrawal;

    public String getCreatedDate() {
        return createdDate;
    }

    public BanksOfferResponseModel setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public BanksOfferResponseModel setDeposit(Deposit deposit) {
        this.deposit = deposit;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public BanksOfferResponseModel setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Fee getFee() {
        return fee;
    }

    public BanksOfferResponseModel setFee(Fee fee) {
        this.fee = fee;
        return this;
    }

    public Gas getGas() {
        return gas;
    }

    public BanksOfferResponseModel setGas(Gas gas) {
        this.gas = gas;
        return this;
    }

    public String getId() {
        return id;
    }

    public BanksOfferResponseModel setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BanksOfferResponseModel setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    public TotalWithdrawal getTotalWithdrawal() {
        return totalWithdrawal;
    }

    public BanksOfferResponseModel setTotalWithdrawal(TotalWithdrawal totalWithdrawal) {
        this.totalWithdrawal = totalWithdrawal;
        return this;
    }

    public Withdrawal getWithdrawal() {
        return withdrawal;
    }

    public BanksOfferResponseModel setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
        return this;
    }
}
