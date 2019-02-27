
package com.crypterium.cryptApi.newback.pojos.wallets;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
