
package com.crypterium.cryptApi.newback.pojos.restoreaccessoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResetReq {

    @Expose
    private String phone;

    public String getPhone() {
        return phone;
    }

    public ResetReq setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
