
package pojos.fundsWallet;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FundswalletModel {

    @Expose
    private List<String> allowOperations;
    @Expose
    private Long amount;
    @Expose
    private String color;
    @Expose
    private String currency;
    @Expose
    private String description;
    @Expose
    private String encryptedKey;
    @Expose
    private String id;
    @Expose
    private Boolean isDebit;
    @Expose
    private Boolean isLiveMode;
    @Expose
    private Long kycLevel;
    @Expose
    private String logoUrl;
    @Expose
    private String name;
    @Expose
    private String type;

    public List<String> getAllowOperations() {
        return allowOperations;
    }

    public FundswalletModel setAllowOperations(List<String> allowOperations) {
        this.allowOperations = allowOperations;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public FundswalletModel setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getColor() {
        return color;
    }

    public FundswalletModel setColor(String color) {
        this.color = color;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public FundswalletModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FundswalletModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public FundswalletModel setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
        return this;
    }

    public String getId() {
        return id;
    }

    public FundswalletModel setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getDebit() {
        return isDebit;
    }

    public FundswalletModel setDebit(Boolean debit) {
        isDebit = debit;
        return this;
    }

    public Boolean getLiveMode() {
        return isLiveMode;
    }

    public FundswalletModel setLiveMode(Boolean liveMode) {
        isLiveMode = liveMode;
        return this;
    }

    public Long getKycLevel() {
        return kycLevel;
    }

    public FundswalletModel setKycLevel(Long kycLevel) {
        this.kycLevel = kycLevel;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public FundswalletModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public FundswalletModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public FundswalletModel setType(String type) {
        this.type = type;
        return this;
    }
}
