
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DeviceHandleModel {

    @Expose
    private String platformCode;
    @Expose
    private String token;

    public String getPlatformCode() {
        return platformCode;
    }

    public DeviceHandleModel setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
        return this;
    }

    public String getToken() {
        return token;
    }

    public DeviceHandleModel setToken(String token) {
        this.token = token;
        return this;
    }
}
