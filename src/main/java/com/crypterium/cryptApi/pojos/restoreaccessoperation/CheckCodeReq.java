
package com.crypterium.cryptApi.pojos.restoreaccessoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CheckCodeReq {

    @Expose
    private String code;
    @Expose
    private String phone;

    public String getCode() {
        return code;
    }

    public CheckCodeReq setCode(String code) {
        this.code = code;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CheckCodeReq setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
