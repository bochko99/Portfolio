
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
