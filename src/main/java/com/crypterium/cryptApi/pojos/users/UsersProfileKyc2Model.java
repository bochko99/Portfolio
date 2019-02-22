
package com.crypterium.cryptApi.pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileKyc2Model {

    @Expose
    private String registrationCity;
    @Expose
    private String registrationCountry;
    @Expose
    private List<String> registrationDocumentUrls;
    @Expose
    private String registrationStreet;
    @Expose
    private String registrationZip;

    public String getRegistrationCity() {
        return registrationCity;
    }

    public UsersProfileKyc2Model setRegistrationCity(String registrationCity) {
        this.registrationCity = registrationCity;
        return this;
    }

    public String getRegistrationCountry() {
        return registrationCountry;
    }

    public UsersProfileKyc2Model setRegistrationCountry(String registrationCountry) {
        this.registrationCountry = registrationCountry;
        return this;
    }

    public List<String> getRegistrationDocumentUrls() {
        return registrationDocumentUrls;
    }

    public UsersProfileKyc2Model setRegistrationDocumentUrls(List<String> registrationDocumentUrls) {
        this.registrationDocumentUrls = registrationDocumentUrls;
        return this;
    }

    public String getRegistrationStreet() {
        return registrationStreet;
    }

    public UsersProfileKyc2Model setRegistrationStreet(String registrationStreet) {
        this.registrationStreet = registrationStreet;
        return this;
    }

    public String getRegistrationZip() {
        return registrationZip;
    }

    public UsersProfileKyc2Model setRegistrationZip(String registrationZip) {
        this.registrationZip = registrationZip;
        return this;
    }
}
