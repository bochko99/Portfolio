
package com.crypterium.cryptApi.oldback.pojos.users;

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
    private String frontside;
    private String backside;
    private String selfie;

    public Type getType() {
        return type;
    }

    public UsersProfileKyc1Model setType(Type type) {
        this.type = type;
        return this;
    }

    public String getFrontside() {
        return frontside;
    }

    public UsersProfileKyc1Model setFrontside(String frontside) {
        this.frontside = frontside;
        return this;
    }

    public String getBackside() {
        return backside;
    }

    public UsersProfileKyc1Model setBackside(String backside) {
        this.backside = backside;
        return this;
    }

    public String getSelfie() {
        return selfie;
    }

    public UsersProfileKyc1Model setSelfie(String selfie) {
        this.selfie = selfie;
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
