
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Password {

    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public Password setPassword(String password) {
        this.password = password;
        return this;
    }
}
