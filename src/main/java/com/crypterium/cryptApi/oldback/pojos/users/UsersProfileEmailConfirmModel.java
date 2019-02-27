
package com.crypterium.cryptApi.oldback.pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileEmailConfirmModel {

    @Expose
    private String code;
    @Expose
    private String email;

    public String getCode() {
        return code;
    }

    public UsersProfileEmailConfirmModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersProfileEmailConfirmModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
