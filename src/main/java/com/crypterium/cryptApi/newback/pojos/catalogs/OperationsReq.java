
package com.crypterium.cryptApi.newback.pojos.catalogs;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class OperationsReq {

    @Expose
    private String constraint;
    @Expose
    private Boolean enabled;
    @Expose
    private Boolean isBeta;
    @Expose
    private String name;
    @Expose
    private String provider;

    public String getConstraint() {
        return constraint;
    }

    public OperationsReq setConstraint(String constraint) {
        this.constraint = constraint;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public OperationsReq setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getBeta() {
        return isBeta;
    }

    public OperationsReq setBeta(Boolean beta) {
        isBeta = beta;
        return this;
    }

    public String getName() {
        return name;
    }

    public OperationsReq setName(String name) {
        this.name = name;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public OperationsReq setProvider(String provider) {
        this.provider = provider;
        return this;
    }
}
