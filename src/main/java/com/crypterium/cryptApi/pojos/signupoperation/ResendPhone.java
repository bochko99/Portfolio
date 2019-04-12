
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResendPhone {

    @Expose
    private String phone;

    public String getPhone() {
        return phone;
    }

    public ResendPhone setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
