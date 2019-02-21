
package com.crypterium.cryptApi.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Fee {

    @Expose
    private List<Case> cases;
    @Expose
    private String currency;
    @Expose
    private Double customerCommissionAmount;
    @Expose
    private Double customerCommissionPercent;
    @Expose
    private Double customerCommissionTotalAmount;

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCustomerCommissionAmount() {
        return customerCommissionAmount;
    }

    public void setCustomerCommissionAmount(Double customerCommissionAmount) {
        this.customerCommissionAmount = customerCommissionAmount;
    }

    public Double getCustomerCommissionPercent() {
        return customerCommissionPercent;
    }

    public void setCustomerCommissionPercent(Double customerCommissionPercent) {
        this.customerCommissionPercent = customerCommissionPercent;
    }

    public Double getCustomerCommissionTotalAmount() {
        return customerCommissionTotalAmount;
    }

    public void setCustomerCommissionTotalAmount(Double customerCommissionTotalAmount) {
        this.customerCommissionTotalAmount = customerCommissionTotalAmount;
    }

}
