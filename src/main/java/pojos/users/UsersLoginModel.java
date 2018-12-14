
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersLoginModel {

    @Expose
    private String login;
    @Expose
    private String password;

    public String getLogin() {
        return login;
    }

    public UsersLoginModel setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UsersLoginModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
