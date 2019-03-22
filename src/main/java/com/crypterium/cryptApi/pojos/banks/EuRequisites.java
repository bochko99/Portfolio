
package com.crypterium.cryptApi.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class EuRequisites {

    @Expose
    private String iban;
    @Expose
    private String payeeFirstName;
    @Expose
    private String payeeLastName;

    public String getIban() {
        return iban;
    }

    public EuRequisites setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getPayeeFirstName() {
        return payeeFirstName;
    }

    public EuRequisites setPayeeFirstName(String payeeFirstName) {
        this.payeeFirstName = payeeFirstName;
        return this;
    }

    public String getPayeeLastName() {
        return payeeLastName;
    }

    public EuRequisites setPayeeLastName(String payeeLastName) {
        this.payeeLastName = payeeLastName;
        return this;
    }
}
