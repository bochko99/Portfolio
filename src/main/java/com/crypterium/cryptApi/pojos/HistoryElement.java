
package com.crypterium.cryptApi.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HistoryElement {

    @SerializedName("accountNumber")
    private String mAccountNumber;
    @SerializedName("amount")
    private String mAmount;
    @SerializedName("amountCommission")
    private Object mAmountCommission;
    @SerializedName("bpayBiller")
    private String mBpayBiller;
    @SerializedName("bPayRef")
    private String mBPayRef;
    @SerializedName("bankCardShortPan")
    private String mBankCardShortPan;
    @SerializedName("bsb")
    private String mBsb;
    @SerializedName("comment")
    private String mComment;
    @SerializedName("commissionCurrency")
    private String mCommissionCurrency;
    @SerializedName("cryptoAddressFrom")
    private String mCryptoAddressFrom;
    @SerializedName("cryptoAddressTo")
    private String mCryptoAddressTo;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("date")
    private Date mDate;
    @SerializedName("exchangeCommission")
    private Object mExchangeCommission;
    @SerializedName("exchangeCurrency")
    private String mExchangeCurrency;
    @SerializedName("exchangeRate")
    private Object mExchangeRate;
    @SerializedName("iban")
    private String mIban;
    @SerializedName("id")
    private String mId;
    @SerializedName("isRead")
    private Boolean mIsRead;
    @SerializedName("merchantName")
    private String mMerchantName;
    @SerializedName("mobile")
    private String mMobile;
    @SerializedName("needVerify")
    private Object mNeedVerify;
    @SerializedName("number")
    private Long mNumber;
    @SerializedName("paymentPurpose")
    private String mPaymentPurpose;
    @SerializedName("profileCommissionRate")
    private Double mProfileCommissionRate;
    @SerializedName("profileCurrency")
    private String mProfileCurrency;
    @SerializedName("profileRate")
    private Double mProfileRate;
    @SerializedName("receiverName")
    private String mReceiverName;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("totalAmount")
    private Double mTotalAmount;
    @SerializedName("transferPerson")
    private String mTransferPerson;
    @SerializedName("txId")
    private String mTxId;
    @SerializedName("typeName")
    private String mTypeName;
    @SerializedName("walletCurrency")
    private String mWalletCurrency;
    @SerializedName("withdrawPersonNumber")
    private Object mWithdrawPersonNumber;

    public String getAccountNumber() {
        return mAccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        mAccountNumber = accountNumber;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }

    public Object getAmountCommission() {
        return mAmountCommission;
    }

    public void setAmountCommission(Object amountCommission) {
        mAmountCommission = amountCommission;
    }

    public String getBpayBiller() {
        return mBpayBiller;
    }

    public void setBpayBiller(String bPayBiller) {
        mBpayBiller = bPayBiller;
    }

    public String getBpayRef() {
        return mBPayRef;
    }

    public void setBpayRef(String bPayRef) {
        mBPayRef = bPayRef;
    }

    public String getBankCardShortPan() {
        return mBankCardShortPan;
    }

    public void setBankCardShortPan(String bankCardShortPan) {
        mBankCardShortPan = bankCardShortPan;
    }

    public String getBsb() {
        return mBsb;
    }

    public void setBsb(String bsb) {
        mBsb = bsb;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public String getCommissionCurrency() {
        return mCommissionCurrency;
    }

    public void setCommissionCurrency(String commissionCurrency) {
        mCommissionCurrency = commissionCurrency;
    }

    public String getCryptoAddressFrom() {
        return mCryptoAddressFrom;
    }

    public void setCryptoAddressFrom(String cryptoAddressFrom) {
        mCryptoAddressFrom = cryptoAddressFrom;
    }

    public String getCryptoAddressTo() {
        return mCryptoAddressTo;
    }

    public void setCryptoAddressTo(String cryptoAddressTo) {
        mCryptoAddressTo = cryptoAddressTo;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Object getExchangeCommission() {
        return mExchangeCommission;
    }

    public void setExchangeCommission(Object exchangeCommission) {
        mExchangeCommission = exchangeCommission;
    }

    public String getExchangeCurrency() {
        return mExchangeCurrency;
    }

    public void setExchangeCurrency(String exchangeCurrency) {
        mExchangeCurrency = exchangeCurrency;
    }

    public Object getExchangeRate() {
        return mExchangeRate;
    }

    public void setExchangeRate(Object exchangeRate) {
        mExchangeRate = exchangeRate;
    }

    public String getIban() {
        return mIban;
    }

    public void setIban(String iban) {
        mIban = iban;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Boolean getIsRead() {
        return mIsRead;
    }

    public void setIsRead(Boolean isRead) {
        mIsRead = isRead;
    }

    public String getMerchantName() {
        return mMerchantName;
    }

    public void setMerchantName(String merchantName) {
        mMerchantName = merchantName;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public Object getNeedVerify() {
        return mNeedVerify;
    }

    public void setNeedVerify(Object needVerify) {
        mNeedVerify = needVerify;
    }

    public Long getNumber() {
        return mNumber;
    }

    public void setNumber(Long number) {
        mNumber = number;
    }

    public String getPaymentPurpose() {
        return mPaymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        mPaymentPurpose = paymentPurpose;
    }

    public Double getProfileCommissionRate() {
        return mProfileCommissionRate;
    }

    public void setProfileCommissionRate(Double profileCommissionRate) {
        mProfileCommissionRate = profileCommissionRate;
    }

    public String getProfileCurrency() {
        return mProfileCurrency;
    }

    public void setProfileCurrency(String profileCurrency) {
        mProfileCurrency = profileCurrency;
    }

    public Double getProfileRate() {
        return mProfileRate;
    }

    public void setProfileRate(Double profileRate) {
        mProfileRate = profileRate;
    }

    public String getReceiverName() {
        return mReceiverName;
    }

    public void setReceiverName(String receiverName) {
        mReceiverName = receiverName;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Double getTotalAmount() {
        return mTotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        mTotalAmount = totalAmount;
    }

    public String getTransferPerson() {
        return mTransferPerson;
    }

    public void setTransferPerson(String transferPerson) {
        mTransferPerson = transferPerson;
    }

    public String getTxId() {
        return mTxId;
    }

    public void setTxId(String txId) {
        mTxId = txId;
    }

    public String getTypeName() {
        return mTypeName;
    }

    public void setTypeName(String typeName) {
        mTypeName = typeName;
    }

    public String getWalletCurrency() {
        return mWalletCurrency;
    }

    public void setWalletCurrency(String walletCurrency) {
        mWalletCurrency = walletCurrency;
    }

    public Object getWithdrawPersonNumber() {
        return mWithdrawPersonNumber;
    }

    public void setWithdrawPersonNumber(Object withdrawPersonNumber) {
        mWithdrawPersonNumber = withdrawPersonNumber;
    }

}
