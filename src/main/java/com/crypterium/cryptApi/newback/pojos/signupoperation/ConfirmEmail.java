
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ConfirmEmail {

    @Expose
    private String code;

    public String getCode() {
        return code;
    }

    public ConfirmEmail setCode(String code) {
        this.code = code;
        return this;
    }
}
