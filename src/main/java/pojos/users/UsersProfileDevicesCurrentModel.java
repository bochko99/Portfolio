
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileDevicesCurrentModel {

    @Expose
    private String pushToken;

    public String getPushToken() {
        return pushToken;
    }

    public UsersProfileDevicesCurrentModel setPushToken(String pushToken) {
        this.pushToken = pushToken;
        return this;
    }
}
