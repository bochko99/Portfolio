
package pojos.fundsWallet;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FundwalletsInvoiceModel {

    @Expose
    private Long amount;
    @Expose
    private Long bankFee;
    @Expose
    private Long bankFeePercent;
    @Expose
    private String bankIban;
    @Expose
    private String bankName;
    @Expose
    private String bankSwift;
    @Expose
    private String companyName;
    @Expose
    private String companyRegistrationAddress;
    @Expose
    private String companyRegistrationNumber;
    @Expose
    private String companyVatNumber;
    @Expose
    private String currency;
    @Expose
    private String customerNumber;
    @Expose
    private String date;
    @Expose
    private String dueDate;
    @Expose
    private String id;
    @Expose
    private String number;
    @Expose
    private Long totalAmount;

    public Long getAmount() {
        return amount;
    }

    public FundwalletsInvoiceModel setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public Long getBankFee() {
        return bankFee;
    }

    public FundwalletsInvoiceModel setBankFee(Long bankFee) {
        this.bankFee = bankFee;
        return this;
    }

    public Long getBankFeePercent() {
        return bankFeePercent;
    }

    public FundwalletsInvoiceModel setBankFeePercent(Long bankFeePercent) {
        this.bankFeePercent = bankFeePercent;
        return this;
    }

    public String getBankIban() {
        return bankIban;
    }

    public FundwalletsInvoiceModel setBankIban(String bankIban) {
        this.bankIban = bankIban;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public FundwalletsInvoiceModel setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankSwift() {
        return bankSwift;
    }

    public FundwalletsInvoiceModel setBankSwift(String bankSwift) {
        this.bankSwift = bankSwift;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public FundwalletsInvoiceModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyRegistrationAddress() {
        return companyRegistrationAddress;
    }

    public FundwalletsInvoiceModel setCompanyRegistrationAddress(String companyRegistrationAddress) {
        this.companyRegistrationAddress = companyRegistrationAddress;
        return this;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public FundwalletsInvoiceModel setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
        return this;
    }

    public String getCompanyVatNumber() {
        return companyVatNumber;
    }

    public FundwalletsInvoiceModel setCompanyVatNumber(String companyVatNumber) {
        this.companyVatNumber = companyVatNumber;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public FundwalletsInvoiceModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public FundwalletsInvoiceModel setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        return this;
    }

    public String getDate() {
        return date;
    }

    public FundwalletsInvoiceModel setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public FundwalletsInvoiceModel setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getId() {
        return id;
    }

    public FundwalletsInvoiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public FundwalletsInvoiceModel setNumber(String number) {
        this.number = number;
        return this;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public FundwalletsInvoiceModel setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }
}
