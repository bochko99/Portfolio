
package pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesWithdrawCheckModel {

    @Expose
    private String blockchainAddress;
    @Expose
    private String currency;
    @Expose
    private String email;
    @Expose
    private Boolean hasTransfer;
    @Expose
    private String mobile;
    @Expose
    private Long personNumber;

    public String getBlockchainAddress() {
        return blockchainAddress;
    }

    public InvoicesWithdrawCheckModel setBlockchainAddress(String blockchainAddress) {
        this.blockchainAddress = blockchainAddress;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public InvoicesWithdrawCheckModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public InvoicesWithdrawCheckModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getHasTransfer() {
        return hasTransfer;
    }

    public InvoicesWithdrawCheckModel setHasTransfer(Boolean hasTransfer) {
        this.hasTransfer = hasTransfer;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public InvoicesWithdrawCheckModel setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Long getPersonNumber() {
        return personNumber;
    }

    public InvoicesWithdrawCheckModel setPersonNumber(Long personNumber) {
        this.personNumber = personNumber;
        return this;
    }
}
