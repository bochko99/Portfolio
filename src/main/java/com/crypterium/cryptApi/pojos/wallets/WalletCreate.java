
package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletCreate {

    @Expose
    private List<String> currencies;

    public List<String> getCurrencies() {
        return currencies;
    }

    public WalletCreate setCurrencies(List<String> currencies) {
        this.currencies = currencies;
        return this;
    }
}
