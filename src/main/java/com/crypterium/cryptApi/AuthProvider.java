package com.crypterium.cryptApi;

import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.Environment;
import io.restassured.specification.RequestSpecification;

public abstract class AuthProvider {
    protected String defaultLogin;
    protected String defaultPassword;

    public AuthProvider() {
        CredentialEntry defaultEntry = Environment.CREDENTIALS.get("default");
        if (defaultEntry != null) {
            defaultLogin = defaultEntry.getLogin();
            defaultPassword = defaultEntry.getPassword();
        }
    }

    public void basic(String login, String password) {
        defaultLogin = login;
        defaultPassword = password;
        System.out.println(String.format("New login: %s ; new password: %s", defaultLogin, defaultPassword));

    }

    public abstract RequestSpecification auth(String role);

    public abstract RequestSpecification auth(String login, String password);

    public abstract RequestSpecification auth();

    public abstract RequestSpecification authAs(String login, String password, String role);

    public abstract RequestSpecification createUser();

    public abstract RequestSpecification authSingle(String login, String password);

    public abstract void flush();

}
