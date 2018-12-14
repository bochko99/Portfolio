
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersLoginVerifyModel {

    @Expose
    private String code;
    @Expose
    private String login;
    @Expose
    private String password;

    public String getCode() {
        return code;
    }

    public UsersLoginVerifyModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UsersLoginVerifyModel setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UsersLoginVerifyModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
