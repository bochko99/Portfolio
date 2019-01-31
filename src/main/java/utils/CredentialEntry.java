package utils;

public class CredentialEntry {

    private String login;
    private String password;
    private String type;

    public CredentialEntry() {
    }

    public CredentialEntry(String login, String password, String type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    CredentialEntry setLogin(String login) {
        this.login = login;
        return this;
    }

    CredentialEntry setPassword(String password) {
        this.password = password;
        return this;
    }

    CredentialEntry setType(String type) {
        this.type = type;
        return this;
    }
}
