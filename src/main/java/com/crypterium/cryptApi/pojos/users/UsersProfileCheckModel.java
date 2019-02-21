
package com.crypterium.cryptApi.pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileCheckModel {

    @Expose
    private String email;

    public String getEmail() {
        return email;
    }

    public UsersProfileCheckModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
