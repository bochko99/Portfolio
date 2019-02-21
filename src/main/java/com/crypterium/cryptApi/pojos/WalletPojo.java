
package com.crypterium.cryptApi.pojos;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletPojo {

    @SerializedName("allowOperations")
    private List<String> mAllowOperations;
    @SerializedName("amount")
    private BigDecimal mAmount;
    @SerializedName("color")
    private String mColor;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("encryptedKey")
    private String mEncryptedKey;
    @SerializedName("id")
    private String mId;
    @SerializedName("isDebit")
    private Boolean mIsDebit;
    @SerializedName("isLiveMode")
    private Boolean mIsLiveMode;
    @SerializedName("kycLevel")
    private Long mKycLevel;
    @SerializedName("logoUrl")
    private String mLogoUrl;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;

    public List<String> getAllowOperations() {
        return mAllowOperations;
    }

    public void setAllowOperations(List<String> allowOperations) {
        mAllowOperations = allowOperations;
    }

    public BigDecimal getAmount() {
        return mAmount;
    }

    public void setAmount(BigDecimal amount) {
        mAmount = amount;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getEncryptedKey() {
        return mEncryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        mEncryptedKey = encryptedKey;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Boolean getIsDebit() {
        return mIsDebit;
    }

    public void setIsDebit(Boolean isDebit) {
        mIsDebit = isDebit;
    }

    public Boolean getIsLiveMode() {
        return mIsLiveMode;
    }

    public void setIsLiveMode(Boolean isLiveMode) {
        mIsLiveMode = isLiveMode;
    }

    public Long getKycLevel() {
        return mKycLevel;
    }

    public void setKycLevel(Long kycLevel) {
        mKycLevel = kycLevel;
    }

    public String getLogoUrl() {
        return mLogoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        mLogoUrl = logoUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
