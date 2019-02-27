
package com.crypterium.cryptApi.newback.pojos.customerprofile;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ProfileReq {

    @Expose
    private String citizenshipCountry;
    @Expose
    private String citizenshipState;
    @Expose
    private String dateOfBirth;
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
    private String primaryCurrency;
    @Expose
    private String registrationAddress;

    public String getCitizenshipCountry() {
        return citizenshipCountry;
    }

    public ProfileReq setCitizenshipCountry(String citizenshipCountry) {
        this.citizenshipCountry = citizenshipCountry;
        return this;
    }

    public String getCitizenshipState() {
        return citizenshipState;
    }

    public ProfileReq setCitizenshipState(String citizenshipState) {
        this.citizenshipState = citizenshipState;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public ProfileReq setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProfileReq setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Boolean getGender() {
        return gender;
    }

    public ProfileReq setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public ProfileReq setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
        return this;
    }

    public String getIdentificationDocumentDateOfBirth() {
        return identificationDocumentDateOfBirth;
    }

    public ProfileReq setIdentificationDocumentDateOfBirth(String identificationDocumentDateOfBirth) {
        this.identificationDocumentDateOfBirth = identificationDocumentDateOfBirth;
        return this;
    }

    public String getIdentificationDocumentFirstName() {
        return identificationDocumentFirstName;
    }

    public ProfileReq setIdentificationDocumentFirstName(String identificationDocumentFirstName) {
        this.identificationDocumentFirstName = identificationDocumentFirstName;
        return this;
    }

    public Boolean getIdentificationDocumentGender() {
        return identificationDocumentGender;
    }

    public ProfileReq setIdentificationDocumentGender(Boolean identificationDocumentGender) {
        this.identificationDocumentGender = identificationDocumentGender;
        return this;
    }

    public String getIdentificationDocumentLastName() {
        return identificationDocumentLastName;
    }

    public ProfileReq setIdentificationDocumentLastName(String identificationDocumentLastName) {
        this.identificationDocumentLastName = identificationDocumentLastName;
        return this;
    }

    public String getIdentificationDocumentMiddleName() {
        return identificationDocumentMiddleName;
    }

    public ProfileReq setIdentificationDocumentMiddleName(String identificationDocumentMiddleName) {
        this.identificationDocumentMiddleName = identificationDocumentMiddleName;
        return this;
    }

    public String getIdentificationDocumentNumber() {
        return identificationDocumentNumber;
    }

    public ProfileReq setIdentificationDocumentNumber(String identificationDocumentNumber) {
        this.identificationDocumentNumber = identificationDocumentNumber;
        return this;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public ProfileReq setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
        return this;
    }

    public Boolean getAgreePrivacyCheck() {
        return isAgreePrivacyCheck;
    }

    public ProfileReq setAgreePrivacyCheck(Boolean agreePrivacyCheck) {
        isAgreePrivacyCheck = agreePrivacyCheck;
        return this;
    }

    public Boolean getLegalFunds() {
        return isLegalFunds;
    }

    public ProfileReq setLegalFunds(Boolean legalFunds) {
        isLegalFunds = legalFunds;
        return this;
    }

    public Boolean getTestMode() {
        return isTestMode;
    }

    public ProfileReq setTestMode(Boolean testMode) {
        isTestMode = testMode;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfileReq setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public ProfileReq setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        return this;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public ProfileReq setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }
}
