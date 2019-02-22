
package com.crypterium.cryptApi.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsDepositModel {

    @Expose
    private Long amountMax;
    @Expose
    private Long amountMin;
    @Expose
    private List<String> currencies;
    @Expose
    private Long feePercent;
    @Expose
    private String paymentCurrency;
    @Expose
    private String type;

    public Long getAmountMax() {
        return amountMax;
    }

    public SettingsDepositModel setAmountMax(Long amountMax) {
        this.amountMax = amountMax;
        return this;
    }

    public Long getAmountMin() {
        return amountMin;
    }

    public SettingsDepositModel setAmountMin(Long amountMin) {
        this.amountMin = amountMin;
        return this;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public SettingsDepositModel setCurrencies(List<String> currencies) {
        this.currencies = currencies;
        return this;
    }

    public Long getFeePercent() {
        return feePercent;
    }

    public SettingsDepositModel setFeePercent(Long feePercent) {
        this.feePercent = feePercent;
        return this;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public SettingsDepositModel setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
        return this;
    }

    public String getType() {
        return type;
    }

    public SettingsDepositModel setType(String type) {
        this.type = type;
        return this;
    }
}
