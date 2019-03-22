
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class VerifyEmail {

    @Expose
    private String email;

    public String getEmail() {
        return email;
    }

    public VerifyEmail setEmail(String email) {
        this.email = email;
        return this;
    }
}
