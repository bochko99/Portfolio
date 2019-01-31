
package pojos.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersProfileKyc1Model {

    @Expose
    private Type type;

    @Expose
    private String frontsideUrl;
    private String backsideUrl;
    private String selfieUrl;

    public Type getType() {
        return type;
    }

    public UsersProfileKyc1Model setType(Type type) {
        this.type = type;
        return this;
    }

    public String getFrontsideUrl() {
        return frontsideUrl;
    }

    public UsersProfileKyc1Model setFrontsideUrl(String frontsideUrl) {
        this.frontsideUrl = frontsideUrl;
        return this;
    }

    public String getBacksideUrl() {
        return backsideUrl;
    }

    public UsersProfileKyc1Model setBacksideUrl(String backsideUrl) {
        this.backsideUrl = backsideUrl;
        return this;
    }

    public String getSelfieUrl() {
        return selfieUrl;
    }

    public UsersProfileKyc1Model setSelfieUrl(String selfieUrl) {
        this.selfieUrl = selfieUrl;
        return this;
    }

    public enum Type {
        UNDEFINED("UNDEFINED"),
        ID_CARD("ID_CARD"),
        PASSPORT("PASSPORT"),
        DRIVER_LICENSE("DRIVER_LICENSE");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }


}
