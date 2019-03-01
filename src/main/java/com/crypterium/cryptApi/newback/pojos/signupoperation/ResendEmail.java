
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResendEmail {

    @Expose
    private String email;

    public String getEmail() {
        return email;
    }

    public ResendEmail setEmail(String email) {
        this.email = email;
        return this;
    }
}
