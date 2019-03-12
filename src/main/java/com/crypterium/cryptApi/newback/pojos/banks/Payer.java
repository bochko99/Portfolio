
package com.crypterium.cryptApi.newback.pojos.banks;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Payer {

    @Expose
    private String birthDate;
    @Expose
    private String city;
    @Expose
    private String country;
    @Expose
    private String documentIssuedBy;
    @Expose
    private String documentIssuedCountryCode;
    @Expose
    private String documentIssuedDate;
    @Expose
    private String documentNumber;
    @Expose
    private String documentType;
    @Expose
    private String firstName;
    @Expose
    private Long kycLevel;
    @Expose
    private String kycStatus;
    @Expose
    private String lastName;
    @Expose
    private Long personId;
    @Expose
    private String street;
    @Expose
    private String tenantId;
    @Expose
    private String zip;

    public String getBirthDate() {
        return birthDate;
    }

    public Payer setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Payer setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Payer setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getDocumentIssuedBy() {
        return documentIssuedBy;
    }

    public Payer setDocumentIssuedBy(String documentIssuedBy) {
        this.documentIssuedBy = documentIssuedBy;
        return this;
    }

    public String getDocumentIssuedCountryCode() {
        return documentIssuedCountryCode;
    }

    public Payer setDocumentIssuedCountryCode(String documentIssuedCountryCode) {
        this.documentIssuedCountryCode = documentIssuedCountryCode;
        return this;
    }

    public String getDocumentIssuedDate() {
        return documentIssuedDate;
    }

    public Payer setDocumentIssuedDate(String documentIssuedDate) {
        this.documentIssuedDate = documentIssuedDate;
        return this;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Payer setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Payer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Long getKycLevel() {
        return kycLevel;
    }

    public Payer setKycLevel(Long kycLevel) {
        this.kycLevel = kycLevel;
        return this;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public Payer setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Payer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Long getPersonId() {
        return personId;
    }

    public Payer setPersonId(Long personId) {
        this.personId = personId;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Payer setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public Payer setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Payer setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Payer setDocumentType(String documentType) {
        this.documentType = documentType;
        return this;
    }
}
