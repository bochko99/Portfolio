
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfilePasswordVerifyModel {

    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public UsersProfilePasswordVerifyModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
