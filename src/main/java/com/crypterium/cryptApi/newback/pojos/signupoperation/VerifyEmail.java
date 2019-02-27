
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
