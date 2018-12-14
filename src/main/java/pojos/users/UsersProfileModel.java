
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileModel {

    @Expose
    private String email;
    @Expose
    private String id;
    @Expose
    private String mobile;
    @Expose
    private String modifiedDate;
    @Expose
    private String nextTrySpan;
    @Expose
    private String status;
    @Expose
    private String token;

    public String getEmail() {
        return email;
    }

    public UsersProfileModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getId() {
        return id;
    }

    public UsersProfileModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UsersProfileModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public UsersProfileModel setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public String getNextTrySpan() {
        return nextTrySpan;
    }

    public UsersProfileModel setNextTrySpan(String nextTrySpan) {
        this.nextTrySpan = nextTrySpan;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UsersProfileModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UsersProfileModel setToken(String token) {
        this.token = token;
        return this;
    }
}
