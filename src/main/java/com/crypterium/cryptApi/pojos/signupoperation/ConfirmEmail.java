
package com.crypterium.cryptApi.pojos.signupoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

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
