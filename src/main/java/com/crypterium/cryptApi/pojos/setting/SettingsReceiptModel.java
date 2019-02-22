
package com.crypterium.cryptApi.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsReceiptModel {

    @Expose
    private List<String> countries;
    @Expose
    private List<String> currencies;
    @Expose
    private String inActiveReason;
    @Expose
    private Boolean isActive;
    @Expose
    private Long kycLevel;
    @Expose
    private String operationName;

    public List<String> getCountries() {
        return countries;
    }

    public SettingsReceiptModel setCountries(List<String> countries) {
        this.countries = countries;
        return this;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public SettingsReceiptModel setCurrencies(List<String> currencies) {
        this.currencies = currencies;
        return this;
    }

    public String getInActiveReason() {
        return inActiveReason;
    }

    public SettingsReceiptModel setInActiveReason(String inActiveReason) {
        this.inActiveReason = inActiveReason;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public SettingsReceiptModel setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Long getKycLevel() {
        return kycLevel;
    }

    public SettingsReceiptModel setKycLevel(Long kycLevel) {
        this.kycLevel = kycLevel;
        return this;
    }

    public String getOperationName() {
        return operationName;
    }

    public SettingsReceiptModel setOperationName(String operationName) {
        this.operationName = operationName;
        return this;
    }
}
