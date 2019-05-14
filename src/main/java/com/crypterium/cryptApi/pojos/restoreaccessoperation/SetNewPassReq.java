
package com.crypterium.cryptApi.pojos.restoreaccessoperation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class SetNewPassReq {

    @Expose
    private String code;
    @Expose
    private String password;
    @Expose
    private String phone;

    public String getCode() {
        return code;
    }

    public SetNewPassReq setCode(String code) {
        this.code = code;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SetNewPassReq setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SetNewPassReq setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
