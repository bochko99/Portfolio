
package com.crypterium.cryptApi.newback.pojos.catalogs;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
