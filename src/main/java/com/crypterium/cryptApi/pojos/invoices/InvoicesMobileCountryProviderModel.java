
package com.crypterium.cryptApi.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesMobileCountryProviderModel {

    @Expose
    private String code;
    @Expose
    private String logoUrl;
    @Expose
    private String name;

    public String getCode() {
        return code;
    }

    public InvoicesMobileCountryProviderModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public InvoicesMobileCountryProviderModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public InvoicesMobileCountryProviderModel setName(String name) {
        this.name = name;
        return this;
    }
}
