
package com.crypterium.cryptApi.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class EuCorpRequisites {

    @Expose
    private String iban;
    @Expose
    private String payeeCorporateName;

    public String getIban() {
        return iban;
    }

    public EuCorpRequisites setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getPayeeCorporateName() {
        return payeeCorporateName;
    }

    public EuCorpRequisites setPayeeCorporateName(String payeeCorporateName) {
        this.payeeCorporateName = payeeCorporateName;
        return this;
    }
}
