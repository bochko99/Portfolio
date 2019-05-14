
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SignUpReq {
    @Expose
    private String phone;
    @Expose
    private String referralCode;
    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public SignUpReq setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SignUpReq setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public SignUpReq setReferralCode(String referralCode) {
        this.referralCode = referralCode;
        return this;
    }
}
