
package com.crypterium.cryptApi.pojos.deposit;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DepositRespTransferModel {

    @Expose
    private String failedUrl;
    @Expose
    private String id;
    @Expose
    private String redirectUrl;
    @Expose
    private String status;
    @Expose
    private String successUrl;

    public String getFailedUrl() {
        return failedUrl;
    }

    public DepositRespTransferModel setFailedUrl(String failedUrl) {
        this.failedUrl = failedUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public DepositRespTransferModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public DepositRespTransferModel setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public DepositRespTransferModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public DepositRespTransferModel setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
        return this;
    }
}
