
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileResponseModel {

    @Expose
    private List<String> allowOperations;
    @Expose
    private String citizenshipCountry;
    @Expose
    private String citizenshipState;
    @Expose
    private String createdDate;
    @Expose
    private String dateOfBirth;
    @Expose
    private String deletedDate;
    @Expose
    private String email;
    @Expose
    private String firstName;
    @Expose
    private Boolean gender;
    @Expose
    private Boolean hasTestMode;
    @Expose
    private String id;
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
    private String invitationCodeRequired;
    @Expose
    private Boolean isAgreePrivacyCheck;
    @Expose
    private Boolean isIbanTermsAgreed;
    @Expose
    private Boolean isLegalFunds;
    @Expose
    private Boolean isTermsAgreed;
    @Expose
    private Boolean isTestMode;
    @Expose
    private String kyc0LevelStatus;
    @Expose
    private String kyc1LevelStatus;
    @Expose
    private String kyc2LevelStatus;
    @Expose
    private Long kycLevel;
    @Expose
    private String lastName;
    @Expose
    private String mobile;
    @Expose
    private String modifiedDate;
    @Expose
    private Long number;
    @Expose
    private String primaryCurrency;
    @Expose
    private String registrationAddress;
    @Expose
    private List<String> registrationDocumentUrls;
    @Expose
    private String status;

    public List<String> getAllowOperations() {
        return allowOperations;
    }

    public UsersProfileResponseModel setAllowOperations(List<String> allowOperations) {
        this.allowOperations = allowOperations;
        return this;
    }

    public String getCitizenshipCountry() {
        return citizenshipCountry;
    }

    public UsersProfileResponseModel setCitizenshipCountry(String citizenshipCountry) {
        this.citizenshipCountry = citizenshipCountry;
        return this;
    }

    public String getCitizenshipState() {
        return citizenshipState;
    }

    public UsersProfileResponseModel setCitizenshipState(String citizenshipState) {
        this.citizenshipState = citizenshipState;
        return this;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public UsersProfileResponseModel setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public UsersProfileResponseModel setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public UsersProfileResponseModel setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersProfileResponseModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UsersProfileResponseModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Boolean getGender() {
        return gender;
    }

    public UsersProfileResponseModel setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public Boolean getHasTestMode() {
        return hasTestMode;
    }

    public UsersProfileResponseModel setHasTestMode(Boolean hasTestMode) {
        this.hasTestMode = hasTestMode;
        return this;
    }

    public String getId() {
        return id;
    }

    public UsersProfileResponseModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public UsersProfileResponseModel setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
        return this;
    }

    public String getIdentificationDocumentDateOfBirth() {
        return identificationDocumentDateOfBirth;
    }

    public UsersProfileResponseModel setIdentificationDocumentDateOfBirth(String identificationDocumentDateOfBirth) {
        this.identificationDocumentDateOfBirth = identificationDocumentDateOfBirth;
        return this;
    }

    public String getIdentificationDocumentFirstName() {
        return identificationDocumentFirstName;
    }

    public UsersProfileResponseModel setIdentificationDocumentFirstName(String identificationDocumentFirstName) {
        this.identificationDocumentFirstName = identificationDocumentFirstName;
        return this;
    }

    public Boolean getIdentificationDocumentGender() {
        return identificationDocumentGender;
    }

    public UsersProfileResponseModel setIdentificationDocumentGender(Boolean identificationDocumentGender) {
        this.identificationDocumentGender = identificationDocumentGender;
        return this;
    }

    public String getIdentificationDocumentLastName() {
        return identificationDocumentLastName;
    }

    public UsersProfileResponseModel setIdentificationDocumentLastName(String identificationDocumentLastName) {
        this.identificationDocumentLastName = identificationDocumentLastName;
        return this;
    }

    public String getIdentificationDocumentMiddleName() {
        return identificationDocumentMiddleName;
    }

    public UsersProfileResponseModel setIdentificationDocumentMiddleName(String identificationDocumentMiddleName) {
        this.identificationDocumentMiddleName = identificationDocumentMiddleName;
        return this;
    }

    public String getIdentificationDocumentNumber() {
        return identificationDocumentNumber;
    }

    public UsersProfileResponseModel setIdentificationDocumentNumber(String identificationDocumentNumber) {
        this.identificationDocumentNumber = identificationDocumentNumber;
        return this;
    }

    public List<String> getIdentificationDocumentSelfieUrls() {
        return identificationDocumentSelfieUrls;
    }

    public UsersProfileResponseModel setIdentificationDocumentSelfieUrls(List<String> identificationDocumentSelfieUrls) {
        this.identificationDocumentSelfieUrls = identificationDocumentSelfieUrls;
        return this;
    }

    public List<String> getIdentificationDocumentUrls() {
        return identificationDocumentUrls;
    }

    public UsersProfileResponseModel setIdentificationDocumentUrls(List<String> identificationDocumentUrls) {
        this.identificationDocumentUrls = identificationDocumentUrls;
        return this;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public UsersProfileResponseModel setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
        return this;
    }

    public String getInvitationCodeRequired() {
        return invitationCodeRequired;
    }

    public UsersProfileResponseModel setInvitationCodeRequired(String invitationCodeRequired) {
        this.invitationCodeRequired = invitationCodeRequired;
        return this;
    }

    public Boolean getIsAgreePrivacyCheck() {
        return isAgreePrivacyCheck;
    }

    public UsersProfileResponseModel setIsAgreePrivacyCheck(Boolean agreePrivacyCheck) {
        isAgreePrivacyCheck = agreePrivacyCheck;
        return this;
    }

    public Boolean getIsIbanTermsAgreed() {
        return isIbanTermsAgreed;
    }

    public UsersProfileResponseModel setIsIbanTermsAgreed(Boolean ibanTermsAgreed) {
        isIbanTermsAgreed = ibanTermsAgreed;
        return this;
    }

    public Boolean getIsLegalFunds() {
        return isLegalFunds;
    }

    public UsersProfileResponseModel setIsLegalFunds(Boolean legalFunds) {
        isLegalFunds = legalFunds;
        return this;
    }

    public Boolean getIsTermsAgreed() {
        return isTermsAgreed;
    }

    public UsersProfileResponseModel setIsTermsAgreed(Boolean termsAgreed) {
        isTermsAgreed = termsAgreed;
        return this;
    }

    public Boolean getIsTestMode() {
        return isTestMode;
    }

    public UsersProfileResponseModel setIsTestMode(Boolean testMode) {
        isTestMode = testMode;
        return this;
    }

    public String getKyc0LevelStatus() {
        return kyc0LevelStatus;
    }

    public UsersProfileResponseModel setKyc0LevelStatus(String kyc0LevelStatus) {
        this.kyc0LevelStatus = kyc0LevelStatus;
        return this;
    }

    public String getKyc1LevelStatus() {
        return kyc1LevelStatus;
    }

    public UsersProfileResponseModel setKyc1LevelStatus(String kyc1LevelStatus) {
        this.kyc1LevelStatus = kyc1LevelStatus;
        return this;
    }

    public String getKyc2LevelStatus() {
        return kyc2LevelStatus;
    }

    public UsersProfileResponseModel setKyc2LevelStatus(String kyc2LevelStatus) {
        this.kyc2LevelStatus = kyc2LevelStatus;
        return this;
    }

    public Long getKycLevel() {
        return kycLevel;
    }

    public UsersProfileResponseModel setKycLevel(Long kycLevel) {
        this.kycLevel = kycLevel;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UsersProfileResponseModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UsersProfileResponseModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public UsersProfileResponseModel setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public UsersProfileResponseModel setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public UsersProfileResponseModel setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        return this;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public UsersProfileResponseModel setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }

    public List<String> getRegistrationDocumentUrls() {
        return registrationDocumentUrls;
    }

    public UsersProfileResponseModel setRegistrationDocumentUrls(List<String> registrationDocumentUrls) {
        this.registrationDocumentUrls = registrationDocumentUrls;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UsersProfileResponseModel setStatus(String status) {
        this.status = status;
        return this;
    }
}
