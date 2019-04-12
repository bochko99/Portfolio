
package com.crypterium.cryptApi.pojos.catalogs;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CountriesModel {

    @Expose
    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public CountriesModel setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }
}
