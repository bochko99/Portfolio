
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
