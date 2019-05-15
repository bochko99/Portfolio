
package com.crypterium.cryptApi.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CurrenciesResponseModel {

    @Expose
    private List<CurrencyResponse> currencies;

    public List<CurrencyResponse> getCurrencies() {
        return currencies;
    }

    public CurrenciesResponseModel setCurrencies(List<CurrencyResponse> currencies) {
        this.currencies = currencies;
        return this;
    }
}
