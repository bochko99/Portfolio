
package com.crypterium.cryptApi.pojos.invoices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoicesPaymentModel {

    @Expose
    private List<InvoiceFundsWalletModel> fundsWallets;
    @Expose
    private String password;

    public List<InvoiceFundsWalletModel> getFundsWallets() {
        return fundsWallets;
    }

    public InvoicesPaymentModel setFundsWallets(List<InvoiceFundsWalletModel> fundsWallets) {
        this.fundsWallets = fundsWallets;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public InvoicesPaymentModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
