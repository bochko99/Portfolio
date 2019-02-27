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

    void basic(String login, String password) {
        defaultLogin = defaultLogin;
        defaultPassword = defaultPassword;
        System.out.println(String.format("New login: %s ; new password: %s", defaultLogin, defaultPassword));

    }

    protected abstract RequestSpecification auth(String login, String password);

    protected abstract RequestSpecification auth();

    protected abstract RequestSpecification createUser();

    protected abstract RequestSpecification authSingle(String login, String password);

    protected abstract void flush();

}
