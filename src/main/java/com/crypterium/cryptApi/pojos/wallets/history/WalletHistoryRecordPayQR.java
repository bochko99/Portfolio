
package com.crypterium.cryptApi.pojos.wallets.history;

import com.crypterium.cryptApi.pojos.wallets.CreditAmount;
import com.crypterium.cryptApi.pojos.wallets.DebitAmount;
import com.crypterium.cryptApi.pojos.wallets.TotalFeeAmount;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletHistoryRecordPayQR {

    @Expose
    private CreditAmount creditAmount;
    @Expose
    private DebitAmount debitAmount;
    @Expose
    private String fromAddress;
    @Expose
    private String orderNumber;
    @Expose
    private String partnerWebsite;
    @Expose
    private String toName;
    @Expose
    private TotalFeeAmount totalFeeAmount;

    public CreditAmount getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(CreditAmount creditAmount) {
        this.creditAmount = creditAmount;
    }

    public DebitAmount getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(DebitAmount debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPartnerWebsite() {
        return partnerWebsite;
    }

    public void setPartnerWebsite(String partnerWebsite) {
        this.partnerWebsite = partnerWebsite;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public TotalFeeAmount getTotalFeeAmount() {
        return totalFeeAmount;
    }

    public void setTotalFeeAmount(TotalFeeAmount totalFeeAmount) {
        this.totalFeeAmount = totalFeeAmount;
    }

}
