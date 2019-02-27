
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResendEmail {

    @SerializedName("email")
    private String email;

    public String getmEmail() {
        return email;
    }

    public ResendEmail setmEmail(String email) {
        this.email = email;
        return this;
    }
}
