
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileMobileconfirmModel {

    @Expose
    private String code;
    @Expose
    private String mobile;

    public String getCode() {
        return code;
    }

    public UsersProfileMobileconfirmModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UsersProfileMobileconfirmModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
