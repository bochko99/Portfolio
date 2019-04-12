
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ConfirmPhone {

    @Expose
    private String fingerprint;
    @Expose
    private String phone;
    @Expose
    private String smsCode;

    public String getFingerprint() {
        return fingerprint;
    }

    public ConfirmPhone setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ConfirmPhone setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public ConfirmPhone setSmsCode(String smsCode) {
        this.smsCode = smsCode;
        return this;
    }
}
