
package com.crypterium.cryptApi.newback.pojos.customerprofile;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UserProfileModel {

    @Expose
    private String citizenshipCountry;
    @Expose
    private String country;
    @Expose
    private Long customerId;
    @Expose
    private String email;
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phone;
    @Expose
    private String primaryCurrency;

    public String getCitizenshipCountry() {
        return citizenshipCountry;
    }

    public UserProfileModel setCitizenshipCountry(String citizenshipCountry) {
        this.citizenshipCountry = citizenshipCountry;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserProfileModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public UserProfileModel setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserProfileModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserProfileModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserProfileModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public UserProfileModel setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        return this;
    }
}
