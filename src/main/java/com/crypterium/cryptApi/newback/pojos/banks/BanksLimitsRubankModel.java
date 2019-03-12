
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BanksLimitsRubankModel {

    @Expose
    private List<WithdrawalCurrency> allowedWithdrawCurrencies;
    @Expose
    private BigDecimal maxAmountEuro;
    @Expose
    private BigDecimal minAmountEuro;

    public List<WithdrawalCurrency> getAllowedWithdrawCurrencies() {
        return allowedWithdrawCurrencies;
    }

    public BanksLimitsRubankModel setAllowedWithdrawCurrencies(List<WithdrawalCurrency> allowedWithdrawCurrencies) {
        this.allowedWithdrawCurrencies = allowedWithdrawCurrencies;
        return this;
    }

    public BigDecimal getMaxAmountEuro() {
        return maxAmountEuro;
    }

    public BanksLimitsRubankModel setMaxAmountEuro(BigDecimal maxAmountEuro) {
        this.maxAmountEuro = maxAmountEuro;
        return this;
    }

    public BigDecimal getMinAmountEuro() {
        return minAmountEuro;
    }

    public BanksLimitsRubankModel setMinAmountEuro(BigDecimal minAmountEuro) {
        this.minAmountEuro = minAmountEuro;
        return this;
    }
}
