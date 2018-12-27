
package pojos.invoices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class InvoiceBodyModel {

    @Expose
    private String accountNumber;
    @Expose
    private Float amount;
    @Expose
    private String bPayBiller;
    @Expose
    private String bPayRef;
    @Expose
    private String bankCode;
    @Expose
    private String bsb;
    @Expose
    private Float commissionAmount;
    @Expose
    private String cryptoWalletAddress;
    @Expose
    private Float cryptoWalletAmount;
    @Expose
    private String cryptoWalletCurrency;
    @Expose
    private String currency;
    @Expose
    private String iban;
    @Expose
    private String linkId;
    @Expose
    private String mobile;
    @Expose
    private String paymentPurpose;
    @Expose
    private String profileCurrency;
    @Expose
    private String provider;
    @Expose
    private String receiverCompanyName;
    @Expose
    private String receiverFirstName;
    @Expose
    private String receiverLastName;
    @Expose
    private String receiverName;
    @Expose
    private Float totalAmount;
    @Expose
    private String txId;
    @Expose
    private String withdrawPersonLogin;
    @Expose
    private Float withdrawPersonNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public InvoiceBodyModel setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Float getAmount() {
        return amount;
    }

    public InvoiceBodyModel setAmount(Float amount) {
        this.amount = amount;
        return this;
    }

    public String getbPayBiller() {
        return bPayBiller;
    }

    public InvoiceBodyModel setbPayBiller(String bPayBiller) {
        this.bPayBiller = bPayBiller;
        return this;
    }

    public String getbPayRef() {
        return bPayRef;
    }

    public InvoiceBodyModel setbPayRef(String bPayRef) {
        this.bPayRef = bPayRef;
        return this;
    }

    public String getBankCode() {
        return bankCode;
    }

    public InvoiceBodyModel setBankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    public String getBsb() {
        return bsb;
    }

    public InvoiceBodyModel setBsb(String bsb) {
        this.bsb = bsb;
        return this;
    }

    public Float getCommissionAmount() {
        return commissionAmount;
    }

    public InvoiceBodyModel setCommissionAmount(Float commissionAmount) {
        this.commissionAmount = commissionAmount;
        return this;
    }

    public String getCryptoWalletAddress() {
        return cryptoWalletAddress;
    }

    public InvoiceBodyModel setCryptoWalletAddress(String cryptoWalletAddress) {
        this.cryptoWalletAddress = cryptoWalletAddress;
        return this;
    }

    public Float getCryptoWalletAmount() {
        return cryptoWalletAmount;
    }

    public InvoiceBodyModel setCryptoWalletAmount(Float cryptoWalletAmount) {
        this.cryptoWalletAmount = cryptoWalletAmount;
        return this;
    }

    public String getCryptoWalletCurrency() {
        return cryptoWalletCurrency;
    }

    public InvoiceBodyModel setCryptoWalletCurrency(String cryptoWalletCurrency) {
        this.cryptoWalletCurrency = cryptoWalletCurrency;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public InvoiceBodyModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getIban() {
        return iban;
    }

    public InvoiceBodyModel setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getLinkId() {
        return linkId;
    }

    public InvoiceBodyModel setLinkId(String linkId) {
        this.linkId = linkId;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public InvoiceBodyModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public InvoiceBodyModel setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    public String getProfileCurrency() {
        return profileCurrency;
    }

    public InvoiceBodyModel setProfileCurrency(String profileCurrency) {
        this.profileCurrency = profileCurrency;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public InvoiceBodyModel setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getReceiverCompanyName() {
        return receiverCompanyName;
    }

    public InvoiceBodyModel setReceiverCompanyName(String receiverCompanyName) {
        this.receiverCompanyName = receiverCompanyName;
        return this;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public InvoiceBodyModel setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
        return this;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public InvoiceBodyModel setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
        return this;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public InvoiceBodyModel setReceiverName(String receiverName) {
        this.receiverName = receiverName;
        return this;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public InvoiceBodyModel setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTxId() {
        return txId;
    }

    public InvoiceBodyModel setTxId(String txId) {
        this.txId = txId;
        return this;
    }

    public String getWithdrawPersonLogin() {
        return withdrawPersonLogin;
    }

    public InvoiceBodyModel setWithdrawPersonLogin(String withdrawPersonLogin) {
        this.withdrawPersonLogin = withdrawPersonLogin;
        return this;
    }

    public Float getWithdrawPersonNumber() {
        return withdrawPersonNumber;
    }

    public InvoiceBodyModel setWithdrawPersonNumber(Float withdrawPersonNumber) {
        this.withdrawPersonNumber = withdrawPersonNumber;
        return this;
    }
}
