
package com.crypterium.cryptApi.pojos.favorite;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FavoritesQuoteModel {

    @Expose
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public FavoritesQuoteModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
