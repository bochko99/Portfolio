package com.crypterium.cryptApi.newback.pojos.customerprofile;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

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
    private Boolean gender;
    @Expose
    private String identificationDocument;
    @Expose
    private String identificationDocumentFirstName;
    @Expose
    private Boolean identificationDocumentGender;
    @Expose
    private String identificationDocumentLastName;
    @Expose
    private String identificationDocumentNumber;
    @Expose
    private Boolean isAgreePrivacyCheck;
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

    public Boolean getGender() {
        return gender;
    }

    public UserProfileModel setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public UserProfileModel setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
        return this;
    }

    public String getIdentificationDocumentFirstName() {
        return identificationDocumentFirstName;
    }

    public UserProfileModel setIdentificationDocumentFirstName(String identificationDocumentFirstName) {
        this.identificationDocumentFirstName = identificationDocumentFirstName;
        return this;
    }

    public Boolean getIdentificationDocumentGender() {
        return identificationDocumentGender;
    }

    public UserProfileModel setIdentificationDocumentGender(Boolean identificationDocumentGender) {
        this.identificationDocumentGender = identificationDocumentGender;
        return this;
    }

    public String getIdentificationDocumentLastName() {
        return identificationDocumentLastName;
    }

    public UserProfileModel setIdentificationDocumentLastName(String identificationDocumentLastName) {
        this.identificationDocumentLastName = identificationDocumentLastName;
        return this;
    }

    public String getIdentificationDocumentNumber() {
        return identificationDocumentNumber;
    }

    public UserProfileModel setIdentificationDocumentNumber(String identificationDocumentNumber) {
        this.identificationDocumentNumber = identificationDocumentNumber;
        return this;
    }

    public Boolean getIsAgreePrivacyCheck() {
        return isAgreePrivacyCheck;
    }

    public UserProfileModel setIsAgreePrivacyCheck(Boolean agreePrivacyCheck) {
        isAgreePrivacyCheck = agreePrivacyCheck;
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
