
package com.crypterium.cryptApi.pojos.exchange;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ExchangePairsResponseModel {

    @Expose
    private List<Pair> pairs;

    public List<Pair> getPairs() {
        return pairs;
    }

    public ExchangePairsResponseModel setPairs(List<Pair> pairs) {
        this.pairs = pairs;
        return this;
    }
}
