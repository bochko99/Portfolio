
package pojos.bankwithdrawal;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BankWithdrawalReqTransfer {

    @Expose
    private String accountNumber;
    @Expose
    private String bankCorrAccountNumber;
    @Expose
    private String bic;
    @Expose
    private String offerId;
    @Expose
    private String payeeFirstName;
    @Expose
    private String payeeLastName;
    @Expose
    private String payeeMiddleName;
    @Expose
    private Boolean transferToMyself;

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankWithdrawalReqTransfer setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getBankCorrAccountNumber() {
        return bankCorrAccountNumber;
    }

    public BankWithdrawalReqTransfer setBankCorrAccountNumber(String bankCorrAccountNumber) {
        this.bankCorrAccountNumber = bankCorrAccountNumber;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public BankWithdrawalReqTransfer setBic(String bic) {
        this.bic = bic;
        return this;
    }

    public String getOfferId() {
        return offerId;
    }

    public BankWithdrawalReqTransfer setOfferId(String offerId) {
        this.offerId = offerId;
        return this;
    }

    public String getPayeeFirstName() {
        return payeeFirstName;
    }

    public BankWithdrawalReqTransfer setPayeeFirstName(String payeeFirstName) {
        this.payeeFirstName = payeeFirstName;
        return this;
    }

    public String getPayeeLastName() {
        return payeeLastName;
    }

    public BankWithdrawalReqTransfer setPayeeLastName(String payeeLastName) {
        this.payeeLastName = payeeLastName;
        return this;
    }

    public String getPayeeMiddleName() {
        return payeeMiddleName;
    }

    public BankWithdrawalReqTransfer setPayeeMiddleName(String payeeMiddleName) {
        this.payeeMiddleName = payeeMiddleName;
        return this;
    }

    public Boolean getTransferToMyself() {
        return transferToMyself;
    }

    public BankWithdrawalReqTransfer setTransferToMyself(Boolean transferToMyself) {
        this.transferToMyself = transferToMyself;
        return this;
    }
}
