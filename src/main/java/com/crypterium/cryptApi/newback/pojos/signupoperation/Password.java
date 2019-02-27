
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
