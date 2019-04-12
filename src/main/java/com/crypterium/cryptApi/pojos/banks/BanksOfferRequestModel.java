
package com.crypterium.cryptApi.pojos.banks;

import com.crypterium.cryptApi.utils.Constants;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BanksOfferRequestModel {

    @Expose
    private BigDecimal amount;
    @Expose
    private AmountKind amountKind;
    @Expose
    private Long personId;
    @Expose
    private String tenantId;
    @Expose
    private WithdrawalCurrency withdrawCurrency;

    public BanksOfferRequestModel() {
        this.tenantId = Constants.TENANT_ID_CRYPTERIUM;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BanksOfferRequestModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public AmountKind getAmountKind() {
        return amountKind;
    }

    public BanksOfferRequestModel setAmountKind(AmountKind amountKind) {
        this.amountKind = amountKind;
        return this;
    }

    public Long getPersonId() {
        return personId;
    }

    public BanksOfferRequestModel setPersonId(Long personId) {
        this.personId = personId;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public BanksOfferRequestModel setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public WithdrawalCurrency getWithdrawCurrency() {
        return withdrawCurrency;
    }

    public BanksOfferRequestModel setWithdrawCurrency(WithdrawalCurrency withdrawCurrency) {
        this.withdrawCurrency = withdrawCurrency;
        return this;
    }
}
