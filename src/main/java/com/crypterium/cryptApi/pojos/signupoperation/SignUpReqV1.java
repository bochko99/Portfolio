
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SignUpReqV1 {
    @Expose
    private String phone;
    @Expose
    private String referralCode;
    @Expose
    private String country;
    @Expose
    private String region;

    public String getPhone() {
        return phone;
    }

    public SignUpReqV1 setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public SignUpReqV1 setReferralCode(String referralCode) {
        this.referralCode = referralCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public SignUpReqV1 setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public SignUpReqV1 setRegion(String region) {
        this.region = region;
        return this;
    }
}
