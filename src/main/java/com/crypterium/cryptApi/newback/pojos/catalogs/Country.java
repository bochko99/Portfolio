
package com.crypterium.cryptApi.newback.pojos.catalogs;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Country {

    @Expose
    private String code;
    @Expose
    private Boolean hasCryptoRestrictions;
    @Expose
    private String imageUrl;
    @Expose
    private List<String> mobilePrefixes;
    @Expose
    private String name;
    @Expose
    private List<Region> regions;

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }

    public Boolean getHasCryptoRestrictions() {
        return hasCryptoRestrictions;
    }

    public Country setHasCryptoRestrictions(Boolean hasCryptoRestrictions) {
        this.hasCryptoRestrictions = hasCryptoRestrictions;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Country setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<String> getMobilePrefixes() {
        return mobilePrefixes;
    }

    public Country setMobilePrefixes(List<String> mobilePrefixes) {
        this.mobilePrefixes = mobilePrefixes;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public Country setRegions(List<Region> regions) {
        this.regions = regions;
        return this;
    }
}
