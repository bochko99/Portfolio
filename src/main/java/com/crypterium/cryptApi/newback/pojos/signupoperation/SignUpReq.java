
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SignUpReq {

    @Expose
    private String country;
    @Expose
    private String phone;
    @Expose
    private String region;

    public String getCountry() {
        return country;
    }

    public SignUpReq setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SignUpReq setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public SignUpReq setRegion(String region) {
        this.region = region;
        return this;
    }
}