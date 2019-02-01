package pojos.kyc;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class IdentityModel {

    @Expose
    private List<String> images;
    @Expose
    private String issuedBy;
    @Expose
    private String issuedCountry;
    @Expose
    private Date issuedDate;
    @Expose
    private String number;
    @Expose
    private Reason reason;
    @Expose
    private List<String> selfies;
    @Expose
    private Status status;
    @Expose
    private String type;
    @Expose
    private UUID userId;

    public List<String> getImages() {
        return images;
    }

    public IdentityModel setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public IdentityModel setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
        return this;
    }

    public String getIssuedCountry() {
        return issuedCountry;
    }

    public IdentityModel setIssuedCountry(String issuedCountry) {
        this.issuedCountry = issuedCountry;
        return this;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public IdentityModel setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public IdentityModel setNumber(String number) {
        this.number = number;
        return this;
    }

    public Reason getReason() {
        return reason;
    }

    public IdentityModel setReason(Reason reason) {
        this.reason = reason;
        return this;
    }

    public List<String> getSelfies() {
        return selfies;
    }

    public IdentityModel setSelfies(List<String> selfies) {
        this.selfies = selfies;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public IdentityModel setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getType() {
        return type;
    }

    public IdentityModel setType(String type) {
        this.type = type;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public IdentityModel setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public enum Status {

        UNDEFINED("UNDEFINED"),
        INCOMPLETE("INCOMPLETE"),
        READY_FOR_SUBMIT("READY_FOR_SUBMIT"),
        SENT_TO_PROVIDER("SENT_TO_PROVIDER"),
        APPROVED("APPROVED"),
        DENIED("DENIED"),
        REJECTED("REJECTED");

        private String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Reason {

        UNDEFINED("UNDEFINED"),
        VERIFIED("VERIFIED"),
        FRAUD("FRAUD"),
        UNSUPPORTED_TYPE("UNSUPPORTED_TYPE"),
        UNSUPPORTED_COUNTRY("UNSUPPORTED_COUNTRY"),
        NOT_READABLE("NOT_READABLE"),
        NOT_UPLOADED("NOT_UPLOADED"),
        ISSUED_COUNTRY_MISMATCH("ISSUED_COUNTRY_MISMATCH"),
        PROVIDER_JUMIO("PROVIDER_JUMIO"),
        PROVIDER_SUMSUB("PROVIDER_SUMSUB"),
        POLITICALLY_EXPOSED_PERSON("POLITICALLY_EXPOSED_PERSON"),
        SELFIE_NOT_MATCH("SELFIE_NOT_MATCH"),
        SELFIE_CROPPED("SELFIE_CROPPED"),
        ENTIRE_ID_USED_AS_SELFIE("ENTIRE_ID_USED_AS_SELFIE"),
        MULTIPLE_PEOPLE("MULTIPLE_PEOPLE"),
        SELFIE_IS_SCREEN_PAPER_VIDEO("SELFIE_IS_SCREEN_PAPER_VIDEO"),
        SELFIE_MANIPULATED("SELFIE_MANIPULATED"),
        AGE_DIFFERENCE_TOO_BIG("AGE_DIFFERENCE_TOO_BIG"),
        NO_FACE_PRESENT("NO_FACE_PRESENT"),
        FACE_NOT_FULLY_VISIBLE("FACE_NOT_FULLY_VISIBLE"),
        BAD_QUALITY("BAD_QUALITY"),
        BLACK_AND_WHITE("BLACK_AND_WHITE"),
        SIMILARITY_UNDEFINED("SIMILARITY_UNDEFINED"),
        FIRSTNAME_MISMATCH("FIRSTNAME_MISMATCH"),
        LASTNAME_MISMATCH("LASTNAME_MISMATCH");

        private String value;

        Reason(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
