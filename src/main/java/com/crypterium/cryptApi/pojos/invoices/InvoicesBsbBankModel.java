
package com.crypterium.cryptApi.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesBsbBankModel {

    @Expose
    private String code;
    @Expose
    private String name;

    public String getCode() {
        return code;
    }

    public InvoicesBsbBankModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public InvoicesBsbBankModel setName(String name) {
        this.name = name;
        return this;
    }
}
