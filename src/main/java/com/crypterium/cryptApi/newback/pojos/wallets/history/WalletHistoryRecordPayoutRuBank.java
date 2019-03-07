
package com.crypterium.cryptApi.newback.pojos.wallets.history;

import com.crypterium.cryptApi.newback.pojos.wallets.CreditAmount;
import com.crypterium.cryptApi.newback.pojos.wallets.DebitAmount;
import com.crypterium.cryptApi.newback.pojos.wallets.ExchangeRate;
import com.crypterium.cryptApi.newback.pojos.wallets.TotalFeeAmount;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletHistoryRecordPayoutRuBank {

    @Expose
    private CreditAmount creditAmount;
    @Expose
    private DebitAmount debitAmount;
    @Expose
    private ExchangeRate exchangeRate;
    @Expose
    private String fromAddress;
    @Expose
    private String referenceNumber;
    @Expose
    private String toBAN;
    @Expose
    private String toBIC;
    @Expose
    private String toBankName;
    @Expose
    private String toCBAN;
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

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getToBAN() {
        return toBAN;
    }

    public void setToBAN(String toBAN) {
        this.toBAN = toBAN;
    }

    public String getToBIC() {
        return toBIC;
    }

    public void setToBIC(String toBIC) {
        this.toBIC = toBIC;
    }

    public String getToBankName() {
        return toBankName;
    }

    public void setToBankName(String toBankName) {
        this.toBankName = toBankName;
    }

    public String getToCBAN() {
        return toCBAN;
    }

    public void setToCBAN(String toCBAN) {
        this.toCBAN = toCBAN;
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
