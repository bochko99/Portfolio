
package com.crypterium.cryptApi.oldback.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsLendingModel {

    @Expose
    private Long amountMax;
    @Expose
    private Long amountMin;
    @Expose
    private List<String> currencies;
    @Expose
    private Long interestAnnualPercent;
    @Expose
    private Long monthesMax;
    @Expose
    private Long monthesMin;
    @Expose
    private List<String> pledgeCurrencies;
    @Expose
    private Long pledgePercent;

    public Long getAmountMax() {
        return amountMax;
    }

    public SettingsLendingModel setAmountMax(Long amountMax) {
        this.amountMax = amountMax;
        return this;
    }

    public Long getAmountMin() {
        return amountMin;
    }

    public SettingsLendingModel setAmountMin(Long amountMin) {
        this.amountMin = amountMin;
        return this;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public SettingsLendingModel setCurrencies(List<String> currencies) {
        this.currencies = currencies;
        return this;
    }

    public Long getInterestAnnualPercent() {
        return interestAnnualPercent;
    }

    public SettingsLendingModel setInterestAnnualPercent(Long interestAnnualPercent) {
        this.interestAnnualPercent = interestAnnualPercent;
        return this;
    }

    public Long getMonthesMax() {
        return monthesMax;
    }

    public SettingsLendingModel setMonthesMax(Long monthesMax) {
        this.monthesMax = monthesMax;
        return this;
    }

    public Long getMonthesMin() {
        return monthesMin;
    }

    public SettingsLendingModel setMonthesMin(Long monthesMin) {
        this.monthesMin = monthesMin;
        return this;
    }

    public List<String> getPledgeCurrencies() {
        return pledgeCurrencies;
    }

    public SettingsLendingModel setPledgeCurrencies(List<String> pledgeCurrencies) {
        this.pledgeCurrencies = pledgeCurrencies;
        return this;
    }

    public Long getPledgePercent() {
        return pledgePercent;
    }

    public SettingsLendingModel setPledgePercent(Long pledgePercent) {
        this.pledgePercent = pledgePercent;
        return this;
    }
}
