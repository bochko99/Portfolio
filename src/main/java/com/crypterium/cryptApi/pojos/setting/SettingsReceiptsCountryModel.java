
package com.crypterium.cryptApi.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsReceiptsCountryModel {

    @Expose
    private String country;
    @Expose
    private String logoUrl;

    public String getCountry() {
        return country;
    }

    public SettingsReceiptsCountryModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public SettingsReceiptsCountryModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }
}
