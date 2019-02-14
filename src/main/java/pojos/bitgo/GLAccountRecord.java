
package pojos.bitgo;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.UUID;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class GLAccountRecord {

    @Expose
    private String accountNumber;
    @Expose
    private String accountTypeCode;
    @Expose
    private Long accountTypeId;
    @Expose
    private String accountTypeName;
    @Expose
    private String attributes;
    @Expose
    private BigDecimal availableBalance;
    @Expose
    private String currencyCode;
    @Expose
    private Long currencyId;
    @Expose
    private String currencyName;
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private BigDecimal ownBalance;
    @Expose
    private UUID ownerCode;
    @Expose
    private UUID ownerExternalId;
    @Expose
    private Long ownerId;
    @Expose
    private String parentAccountAccountNumber;
    @Expose
    private Long parentAccountId;

    public String getAccountNumber() {
        return accountNumber;
    }

    public GLAccountRecord setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public GLAccountRecord setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
        return this;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public GLAccountRecord setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
        return this;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public GLAccountRecord setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
        return this;
    }

    public String getAttributes() {
        return attributes;
    }

    public GLAccountRecord setAttributes(String attributes) {
        this.attributes = attributes;
        return this;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public GLAccountRecord setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public GLAccountRecord setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public GLAccountRecord setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public GLAccountRecord setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public GLAccountRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GLAccountRecord setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getOwnBalance() {
        return ownBalance;
    }

    public GLAccountRecord setOwnBalance(BigDecimal ownBalance) {
        this.ownBalance = ownBalance;
        return this;
    }

    public UUID getOwnerCode() {
        return ownerCode;
    }

    public GLAccountRecord setOwnerCode(UUID ownerCode) {
        this.ownerCode = ownerCode;
        return this;
    }

    public UUID getOwnerExternalId() {
        return ownerExternalId;
    }

    public GLAccountRecord setOwnerExternalId(UUID ownerExternalId) {
        this.ownerExternalId = ownerExternalId;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public GLAccountRecord setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getParentAccountAccountNumber() {
        return parentAccountAccountNumber;
    }

    public GLAccountRecord setParentAccountAccountNumber(String parentAccountAccountNumber) {
        this.parentAccountAccountNumber = parentAccountAccountNumber;
        return this;
    }

    public Long getParentAccountId() {
        return parentAccountId;
    }

    public GLAccountRecord setParentAccountId(Long parentAccountId) {
        this.parentAccountId = parentAccountId;
        return this;
    }
}
