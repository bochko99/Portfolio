
package com.crypterium.cryptApi.newback.pojos.restoreaccessoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
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
