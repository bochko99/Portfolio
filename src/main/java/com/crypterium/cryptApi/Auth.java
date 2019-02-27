package com.crypterium.cryptApi;

import com.crypterium.cryptApi.newback.ExwalAuth;
import com.crypterium.cryptApi.oldback.CAuth;
import io.restassured.specification.RequestSpecification;

public class Auth {


    private static AuthProvider provider = new ExwalAuth();


    public Auth() {
    }

    public static Auth basic(String defaultLogin, String defaultPassword) {
        provider.basic(defaultLogin, defaultPassword);
        return new Auth();
    }


    public static RequestSpecification auth(String login, String password) {
        return provider.auth(login, password);
    }

    public static RequestSpecification auth() {
        return provider.auth();
    }

    public static RequestSpecification createUser() {
        return provider.createUser();
    }

    public static RequestSpecification authSingle(String login, String password) {
        return provider.authSingle(login, password);
    }

    public static void flush() {
        provider.flush();
    }

}
