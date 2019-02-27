
package com.crypterium.cryptApi.oldback.pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfilePinVerifyModel {

    @Expose
    private String pin;

    public String getPin() {
        return pin;
    }

    public UsersProfilePinVerifyModel setPin(String pin) {
        this.pin = pin;
        return this;
    }
}
