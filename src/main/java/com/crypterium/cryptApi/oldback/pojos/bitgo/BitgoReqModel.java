
package com.crypterium.cryptApi.oldback.pojos.bitgo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class BitgoReqModel {

    @Expose
    private BigDecimal amount;
    @Expose
    private Long confirmationCount;
    @Expose
    private String currency;
    @Expose
    private String fromAddress;
    @Expose
    private String idempotentId;
    @Expose
    private String toAddress;
    @Expose
    private String txHash;

    public BigDecimal getAmount() {
        return amount;
    }

    public BitgoReqModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Long getConfirmationCount() {
        return confirmationCount;
    }

    public BitgoReqModel setConfirmationCount(Long confirmationCount) {
        this.confirmationCount = confirmationCount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BitgoReqModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public BitgoReqModel setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
        return this;
    }

    public String getIdempotentId() {
        return idempotentId;
    }

    public BitgoReqModel setIdempotentId(String idempotentId) {
        this.idempotentId = idempotentId;
        return this;
    }

    public String getToAddress() {
        return toAddress;
    }

    public BitgoReqModel setToAddress(String toAddress) {
        this.toAddress = toAddress;
        return this;
    }

    public String getTxHash() {
        return txHash;
    }

    public BitgoReqModel setTxHash(String txHash) {
        this.txHash = txHash;
        return this;
    }
}
