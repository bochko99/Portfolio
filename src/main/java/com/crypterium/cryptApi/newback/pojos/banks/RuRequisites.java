
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RuRequisites {

    @Expose
    private String bankAccountNumber;
    @Expose
    private String bankBic;
    @Expose
    private String bankCorrAccountNumber;
    @Expose
    private String payeeFirstName;
    @Expose
    private String payeeLastName;
    @Expose
    private String payeeMiddleName;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public RuRequisites setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public String getBankBic() {
        return bankBic;
    }

    public RuRequisites setBankBic(String bankBic) {
        this.bankBic = bankBic;
        return this;
    }

    public String getBankCorrAccountNumber() {
        return bankCorrAccountNumber;
    }

    public RuRequisites setBankCorrAccountNumber(String bankCorrAccountNumber) {
        this.bankCorrAccountNumber = bankCorrAccountNumber;
        return this;
    }

    public String getPayeeFirstName() {
        return payeeFirstName;
    }

    public RuRequisites setPayeeFirstName(String payeeFirstName) {
        this.payeeFirstName = payeeFirstName;
        return this;
    }

    public String getPayeeLastName() {
        return payeeLastName;
    }

    public RuRequisites setPayeeLastName(String payeeLastName) {
        this.payeeLastName = payeeLastName;
        return this;
    }

    public String getPayeeMiddleName() {
        return payeeMiddleName;
    }

    public RuRequisites setPayeeMiddleName(String payeeMiddleName) {
        this.payeeMiddleName = payeeMiddleName;
        return this;
    }
}
