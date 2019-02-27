
package com.crypterium.cryptApi.oldback.pojos.quotes;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Quote {

    @Expose
    private Long capitalization;
    @Expose
    private String currency;
    @Expose
    private Long deviationPercent;
    @Expose
    private String imageUrl;
    @Expose
    private Long index;
    @Expose
    private String modifiedDate;
    @Expose
    private String name;
    @Expose
    private Long rate;
    @Expose
    private List<Rate> rates;

    public Long getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(Long capitalization) {
        this.capitalization = capitalization;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getDeviationPercent() {
        return deviationPercent;
    }

    public void setDeviationPercent(Long deviationPercent) {
        this.deviationPercent = deviationPercent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

}
