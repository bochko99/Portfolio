
package com.crypterium.cryptApi.pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileLoyaltyModel {

    @Expose
    private String level;

    public String getLevel() {
        return level;
    }

    public UsersProfileLoyaltyModel setLevel(String level) {
        this.level = level;
        return this;
    }
}
