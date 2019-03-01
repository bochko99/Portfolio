
package com.crypterium.cryptApi.newback.pojos.catalogs;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Region {

    @Expose
    private String code;
    @Expose
    private Boolean hasCryptoRestrictions;
    @Expose
    private String name;

    public String getCode() {
        return code;
    }

    public Region setCode(String code) {
        this.code = code;
        return this;
    }

    public Boolean getHasCryptoRestrictions() {
        return hasCryptoRestrictions;
    }

    public Region setHasCryptoRestrictions(Boolean hasCryptoRestrictions) {
        this.hasCryptoRestrictions = hasCryptoRestrictions;
        return this;
    }

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }
}
