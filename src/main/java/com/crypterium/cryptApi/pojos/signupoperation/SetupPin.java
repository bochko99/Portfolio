
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SetupPin {

    @Expose
    private String fingerprint;
    @Expose
    private String pin;

    public String getFingerprint() {
        return fingerprint;
    }

    public SetupPin setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    public String getPin() {
        return pin;
    }

    public SetupPin setPin(String pin) {
        this.pin = pin;
        return this;
    }
}
