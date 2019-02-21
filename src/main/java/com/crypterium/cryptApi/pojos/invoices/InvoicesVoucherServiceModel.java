
package com.crypterium.cryptApi.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesVoucherServiceModel {

    @Expose
    private String code;
    @Expose
    private String currency;
    @Expose
    private String logoUrl;
    @Expose
    private String name;

    public String getCode() {
        return code;
    }

    public InvoicesVoucherServiceModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public InvoicesVoucherServiceModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public InvoicesVoucherServiceModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public InvoicesVoucherServiceModel setName(String name) {
        this.name = name;
        return this;
    }
}
