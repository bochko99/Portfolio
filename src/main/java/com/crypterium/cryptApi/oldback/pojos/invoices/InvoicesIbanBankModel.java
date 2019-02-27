
package com.crypterium.cryptApi.oldback.pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesIbanBankModel {

    @Expose
    private String code;
    @Expose
    private String name;

    public String getCode() {
        return code;
    }

    public InvoicesIbanBankModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public InvoicesIbanBankModel setName(String name) {
        this.name = name;
        return this;
    }
}
