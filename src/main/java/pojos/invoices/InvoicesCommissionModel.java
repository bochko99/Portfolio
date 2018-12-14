
package pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesCommissionModel {

    @Expose
    private Long amount;
    @Expose
    private Long amountMax;
    @Expose
    private Long amountMin;
    @Expose
    private Long amountScale;
    @Expose
    private String commissionCurrency;
    @Expose
    private Long commissionRate;
    @Expose
    private String commissionType;
    @Expose
    private String cryptoWalletCurrency;
    @Expose
    private Long cryptoWalletRate;
    @Expose
    private String currency;
    @Expose
    private Long operationAmountMax;
    @Expose
    private Long operationAmountMin;
    @Expose
    private String operationType;
    @Expose
    private Long percent;

    public Long getAmount() {
        return amount;
    }

    public InvoicesCommissionModel setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public Long getAmountMax() {
        return amountMax;
    }

    public InvoicesCommissionModel setAmountMax(Long amountMax) {
        this.amountMax = amountMax;
        return this;
    }

    public Long getAmountMin() {
        return amountMin;
    }

    public InvoicesCommissionModel setAmountMin(Long amountMin) {
        this.amountMin = amountMin;
        return this;
    }

    public Long getAmountScale() {
        return amountScale;
    }

    public InvoicesCommissionModel setAmountScale(Long amountScale) {
        this.amountScale = amountScale;
        return this;
    }

    public String getCommissionCurrency() {
        return commissionCurrency;
    }

    public InvoicesCommissionModel setCommissionCurrency(String commissionCurrency) {
        this.commissionCurrency = commissionCurrency;
        return this;
    }

    public Long getCommissionRate() {
        return commissionRate;
    }

    public InvoicesCommissionModel setCommissionRate(Long commissionRate) {
        this.commissionRate = commissionRate;
        return this;
    }

    public String getCommissionType() {
        return commissionType;
    }

    public InvoicesCommissionModel setCommissionType(String commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public String getCryptoWalletCurrency() {
        return cryptoWalletCurrency;
    }

    public InvoicesCommissionModel setCryptoWalletCurrency(String cryptoWalletCurrency) {
        this.cryptoWalletCurrency = cryptoWalletCurrency;
        return this;
    }

    public Long getCryptoWalletRate() {
        return cryptoWalletRate;
    }

    public InvoicesCommissionModel setCryptoWalletRate(Long cryptoWalletRate) {
        this.cryptoWalletRate = cryptoWalletRate;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public InvoicesCommissionModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Long getOperationAmountMax() {
        return operationAmountMax;
    }

    public InvoicesCommissionModel setOperationAmountMax(Long operationAmountMax) {
        this.operationAmountMax = operationAmountMax;
        return this;
    }

    public Long getOperationAmountMin() {
        return operationAmountMin;
    }

    public InvoicesCommissionModel setOperationAmountMin(Long operationAmountMin) {
        this.operationAmountMin = operationAmountMin;
        return this;
    }

    public String getOperationType() {
        return operationType;
    }

    public InvoicesCommissionModel setOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public Long getPercent() {
        return percent;
    }

    public InvoicesCommissionModel setPercent(Long percent) {
        this.percent = percent;
        return this;
    }
}
