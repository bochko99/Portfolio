
package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletCreateReq {

    @Expose
    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public WalletCreateReq setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    public WalletCreateReq setCurrencies(Currency... currencies) {
        return setCurrencies(Arrays.asList(currencies));
    }
}
