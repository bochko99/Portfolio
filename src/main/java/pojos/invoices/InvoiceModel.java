
package pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoiceModel {

    @Expose
    private String accountNumber;
    @Expose
    private Long amount;
    @Expose
    private String bPayBiller;
    @Expose
    private String bPayRef;
    @Expose
    private String bankCode;
    @Expose
    private String bsb;
    @Expose
    private Long commissionAmount;
    @Expose
    private String cryptoWalletAddress;
    @Expose
    private Long cryptoWalletAmount;
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
    private Long totalAmount;
    @Expose
    private String txId;
    @Expose
    private String withdrawPersonLogin;
    @Expose
    private Long withdrawPersonNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public InvoiceModel setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public InvoiceModel setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getbPayBiller() {
        return bPayBiller;
    }

    public InvoiceModel setbPayBiller(String bPayBiller) {
        this.bPayBiller = bPayBiller;
        return this;
    }

    public String getbPayRef() {
        return bPayRef;
    }

    public InvoiceModel setbPayRef(String bPayRef) {
        this.bPayRef = bPayRef;
        return this;
    }

    public String getBankCode() {
        return bankCode;
    }

    public InvoiceModel setBankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    public String getBsb() {
        return bsb;
    }

    public InvoiceModel setBsb(String bsb) {
        this.bsb = bsb;
        return this;
    }

    public Long getCommissionAmount() {
        return commissionAmount;
    }

    public InvoiceModel setCommissionAmount(Long commissionAmount) {
        this.commissionAmount = commissionAmount;
        return this;
    }

    public String getCryptoWalletAddress() {
        return cryptoWalletAddress;
    }

    public InvoiceModel setCryptoWalletAddress(String cryptoWalletAddress) {
        this.cryptoWalletAddress = cryptoWalletAddress;
        return this;
    }

    public Long getCryptoWalletAmount() {
        return cryptoWalletAmount;
    }

    public InvoiceModel setCryptoWalletAmount(Long cryptoWalletAmount) {
        this.cryptoWalletAmount = cryptoWalletAmount;
        return this;
    }

    public String getCryptoWalletCurrency() {
        return cryptoWalletCurrency;
    }

    public InvoiceModel setCryptoWalletCurrency(String cryptoWalletCurrency) {
        this.cryptoWalletCurrency = cryptoWalletCurrency;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public InvoiceModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getIban() {
        return iban;
    }

    public InvoiceModel setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getLinkId() {
        return linkId;
    }

    public InvoiceModel setLinkId(String linkId) {
        this.linkId = linkId;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public InvoiceModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public InvoiceModel setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    public String getProfileCurrency() {
        return profileCurrency;
    }

    public InvoiceModel setProfileCurrency(String profileCurrency) {
        this.profileCurrency = profileCurrency;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public InvoiceModel setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getReceiverCompanyName() {
        return receiverCompanyName;
    }

    public InvoiceModel setReceiverCompanyName(String receiverCompanyName) {
        this.receiverCompanyName = receiverCompanyName;
        return this;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public InvoiceModel setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
        return this;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public InvoiceModel setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
        return this;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public InvoiceModel setReceiverName(String receiverName) {
        this.receiverName = receiverName;
        return this;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public InvoiceModel setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTxId() {
        return txId;
    }

    public InvoiceModel setTxId(String txId) {
        this.txId = txId;
        return this;
    }

    public String getWithdrawPersonLogin() {
        return withdrawPersonLogin;
    }

    public InvoiceModel setWithdrawPersonLogin(String withdrawPersonLogin) {
        this.withdrawPersonLogin = withdrawPersonLogin;
        return this;
    }

    public Long getWithdrawPersonNumber() {
        return withdrawPersonNumber;
    }

    public InvoiceModel setWithdrawPersonNumber(Long withdrawPersonNumber) {
        this.withdrawPersonNumber = withdrawPersonNumber;
        return this;
    }
}
