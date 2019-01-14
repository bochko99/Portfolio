
package pojos.users;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileCheckModel {

    @Expose
    private String email;

    public String getEmail() {
        return email;
    }

    public UsersProfileCheckModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
