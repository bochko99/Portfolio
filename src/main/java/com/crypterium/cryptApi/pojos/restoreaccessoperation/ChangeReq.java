
package com.crypterium.cryptApi.pojos.restoreaccessoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ChangeReq {

    @Expose
    private String currentPassword;
    @Expose
    private String newPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public ChangeReq setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public ChangeReq setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }
}
