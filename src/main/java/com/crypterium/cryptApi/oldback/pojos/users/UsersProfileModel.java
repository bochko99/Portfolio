
package com.crypterium.cryptApi.oldback.pojos.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder
public class UsersProfileModel {

    @Expose
    private String citizenshipCountry;
    @Expose
    private String citizenshipState;
    @Expose
    private String dateOfBirth;
    @Expose
    private String email;
    @Expose
    private String firstName;
    @Expose
    private Boolean gender;
    @Expose
    private String identificationDocument;
    @Expose
    private String identificationDocumentDateOfBirth;
    @Expose
    private String identificationDocumentFirstName;
    @Expose
    private Boolean identificationDocumentGender;
    @Expose
    private String identificationDocumentLastName;
    @Expose
    private String identificationDocumentMiddleName;
    @Expose
    private String identificationDocumentNumber;
    @Expose
    private List<String> identificationDocumentSelfieUrls;
    @Expose
    private List<String> identificationDocumentUrls;
    @Expose
    private String invitationCode;
    @Expose
    private Boolean isAgreePrivacyCheck;
    @Expose
    private Boolean isLegalFunds;
    @Expose
    private Boolean isTestMode;
    @Expose
    private String lastName;
    @Expose
    private String login;
    @Expose
    private String mobile;
    @Expose
    private String password;
    @Expose
    private String pin;
    @Expose
    private String primaryCurrency;
    @Expose
    private String registrationAddress;
    @Expose
    private List<String> registrationDocumentUrls;

    public String getCitizenshipCountry() {
        return citizenshipCountry;
    }

    public UsersProfileModel setCitizenshipCountry(String citizenshipCountry) {
        this.citizenshipCountry = citizenshipCountry;
        return this;
    }

    public String getCitizenshipState() {
        return citizenshipState;
    }

    public UsersProfileModel setCitizenshipState(String citizenshipState) {
        this.citizenshipState = citizenshipState;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public UsersProfileModel setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersProfileModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UsersProfileModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Boolean getGender() {
        return gender;
    }

    public UsersProfileModel setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public UsersProfileModel setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
        return this;
    }

    public String getIdentificationDocumentDateOfBirth() {
        return identificationDocumentDateOfBirth;
    }

    public UsersProfileModel setIdentificationDocumentDateOfBirth(String identificationDocumentDateOfBirth) {
        this.identificationDocumentDateOfBirth = identificationDocumentDateOfBirth;
        return this;
    }

    public String getIdentificationDocumentFirstName() {
        return identificationDocumentFirstName;
    }

    public UsersProfileModel setIdentificationDocumentFirstName(String identificationDocumentFirstName) {
        this.identificationDocumentFirstName = identificationDocumentFirstName;
        return this;
    }

    public Boolean getIdentificationDocumentGender() {
        return identificationDocumentGender;
    }

    public UsersProfileModel setIdentificationDocumentGender(Boolean identificationDocumentGender) {
        this.identificationDocumentGender = identificationDocumentGender;
        return this;
    }

    public String getIdentificationDocumentLastName() {
        return identificationDocumentLastName;
    }

    public UsersProfileModel setIdentificationDocumentLastName(String identificationDocumentLastName) {
        this.identificationDocumentLastName = identificationDocumentLastName;
        return this;
    }

    public String getIdentificationDocumentMiddleName() {
        return identificationDocumentMiddleName;
    }

    public UsersProfileModel setIdentificationDocumentMiddleName(String identificationDocumentMiddleName) {
        this.identificationDocumentMiddleName = identificationDocumentMiddleName;
        return this;
    }

    public String getIdentificationDocumentNumber() {
        return identificationDocumentNumber;
    }

    public UsersProfileModel setIdentificationDocumentNumber(String identificationDocumentNumber) {
        this.identificationDocumentNumber = identificationDocumentNumber;
        return this;
    }

    public List<String> getIdentificationDocumentSelfieUrls() {
        return identificationDocumentSelfieUrls;
    }

    public UsersProfileModel setIdentificationDocumentSelfieUrls(List<String> identificationDocumentSelfieUrls) {
        this.identificationDocumentSelfieUrls = identificationDocumentSelfieUrls;
        return this;
    }

    public List<String> getIdentificationDocumentUrls() {
        return identificationDocumentUrls;
    }

    public UsersProfileModel setIdentificationDocumentUrls(List<String> identificationDocumentUrls) {
        this.identificationDocumentUrls = identificationDocumentUrls;
        return this;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public UsersProfileModel setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
        return this;
    }

    public Boolean getIsAgreePrivacyCheck() {
        return isAgreePrivacyCheck;
    }

    public UsersProfileModel setIsAgreePrivacyCheck(Boolean agreePrivacyCheck) {
        isAgreePrivacyCheck = agreePrivacyCheck;
        return this;
    }

    public Boolean getIsLegalFunds() {
        return isLegalFunds;
    }

    public UsersProfileModel setIsLegalFunds(Boolean legalFunds) {
        isLegalFunds = legalFunds;
        return this;
    }

    public Boolean getIsTestMode() {
        return isTestMode;
    }

    public UsersProfileModel setIsTestMode(Boolean testMode) {
        isTestMode = testMode;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UsersProfileModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UsersProfileModel setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UsersProfileModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UsersProfileModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPin() {
        return pin;
    }

    public UsersProfileModel setPin(String pin) {
        this.pin = pin;
        return this;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public UsersProfileModel setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        return this;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public UsersProfileModel setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }

    public List<String> getRegistrationDocumentUrls() {
        return registrationDocumentUrls;
    }

    public UsersProfileModel setRegistrationDocumentUrls(List<String> registrationDocumentUrls) {
        this.registrationDocumentUrls = registrationDocumentUrls;
        return this;
    }
}
