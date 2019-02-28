
package com.crypterium.cryptApi.newback.pojos.cardorderoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class OrderReq {

    @Expose
    private String country;
    @Expose
    private String email;
    @Expose
    private String name;
    @Expose
    private String phone;

    public String getCountry() {
        return country;
    }

    public OrderReq setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderReq setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderReq setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public OrderReq setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
