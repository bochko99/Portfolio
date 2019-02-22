
package com.crypterium.cryptApi.pojos;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LoginModel {

    @Expose
    private String code;
    @Expose
    private String login;
    @Expose
    private String password;

    public String getCode() {
        return code;
    }

    public LoginModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public LoginModel setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
