
package pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UsersProfileKyc1Model {

    @Expose
    private String identificationDocument;
    @Expose
    private String identificationDocumentDateOfBirth;
    @Expose
    private String identificationDocumentFirstName;
    @Expose
    private Boolean identificationDocumentGender;
    @Expose
    private String identificationDocumentIssuedBy;
    @Expose
    private String identificationDocumentIssuedCountry;
    @Expose
    private String identificationDocumentIssuedDate;
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
    private String registrationAddress;
    @Expose
    private List<String> registrationDocumentUrls;
    @Expose
    private String videoSelfieUrl;

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public UsersProfileKyc1Model setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
        return this;
    }

    public String getIdentificationDocumentDateOfBirth() {
        return identificationDocumentDateOfBirth;
    }

    public UsersProfileKyc1Model setIdentificationDocumentDateOfBirth(String identificationDocumentDateOfBirth) {
        this.identificationDocumentDateOfBirth = identificationDocumentDateOfBirth;
        return this;
    }

    public String getIdentificationDocumentFirstName() {
        return identificationDocumentFirstName;
    }

    public UsersProfileKyc1Model setIdentificationDocumentFirstName(String identificationDocumentFirstName) {
        this.identificationDocumentFirstName = identificationDocumentFirstName;
        return this;
    }

    public Boolean getIdentificationDocumentGender() {
        return identificationDocumentGender;
    }

    public UsersProfileKyc1Model setIdentificationDocumentGender(Boolean identificationDocumentGender) {
        this.identificationDocumentGender = identificationDocumentGender;
        return this;
    }

    public String getIdentificationDocumentIssuedBy() {
        return identificationDocumentIssuedBy;
    }

    public UsersProfileKyc1Model setIdentificationDocumentIssuedBy(String identificationDocumentIssuedBy) {
        this.identificationDocumentIssuedBy = identificationDocumentIssuedBy;
        return this;
    }

    public String getIdentificationDocumentIssuedCountry() {
        return identificationDocumentIssuedCountry;
    }

    public UsersProfileKyc1Model setIdentificationDocumentIssuedCountry(String identificationDocumentIssuedCountry) {
        this.identificationDocumentIssuedCountry = identificationDocumentIssuedCountry;
        return this;
    }

    public String getIdentificationDocumentIssuedDate() {
        return identificationDocumentIssuedDate;
    }

    public UsersProfileKyc1Model setIdentificationDocumentIssuedDate(String identificationDocumentIssuedDate) {
        this.identificationDocumentIssuedDate = identificationDocumentIssuedDate;
        return this;
    }

    public String getIdentificationDocumentLastName() {
        return identificationDocumentLastName;
    }

    public UsersProfileKyc1Model setIdentificationDocumentLastName(String identificationDocumentLastName) {
        this.identificationDocumentLastName = identificationDocumentLastName;
        return this;
    }

    public String getIdentificationDocumentMiddleName() {
        return identificationDocumentMiddleName;
    }

    public UsersProfileKyc1Model setIdentificationDocumentMiddleName(String identificationDocumentMiddleName) {
        this.identificationDocumentMiddleName = identificationDocumentMiddleName;
        return this;
    }

    public String getIdentificationDocumentNumber() {
        return identificationDocumentNumber;
    }

    public UsersProfileKyc1Model setIdentificationDocumentNumber(String identificationDocumentNumber) {
        this.identificationDocumentNumber = identificationDocumentNumber;
        return this;
    }

    public List<String> getIdentificationDocumentSelfieUrls() {
        return identificationDocumentSelfieUrls;
    }

    public UsersProfileKyc1Model setIdentificationDocumentSelfieUrls(List<String> identificationDocumentSelfieUrls) {
        this.identificationDocumentSelfieUrls = identificationDocumentSelfieUrls;
        return this;
    }

    public List<String> getIdentificationDocumentUrls() {
        return identificationDocumentUrls;
    }

    public UsersProfileKyc1Model setIdentificationDocumentUrls(List<String> identificationDocumentUrls) {
        this.identificationDocumentUrls = identificationDocumentUrls;
        return this;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public UsersProfileKyc1Model setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }

    public List<String> getRegistrationDocumentUrls() {
        return registrationDocumentUrls;
    }

    public UsersProfileKyc1Model setRegistrationDocumentUrls(List<String> registrationDocumentUrls) {
        this.registrationDocumentUrls = registrationDocumentUrls;
        return this;
    }

    public String getVideoSelfieUrl() {
        return videoSelfieUrl;
    }

    public UsersProfileKyc1Model setVideoSelfieUrl(String videoSelfieUrl) {
        this.videoSelfieUrl = videoSelfieUrl;
        return this;
    }
}
