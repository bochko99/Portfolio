
package com.crypterium.cryptApi.pojos.wallets.history;

import com.crypterium.cryptApi.pojos.wallets.CreditAmount;
import com.crypterium.cryptApi.pojos.wallets.DebitAmount;
import com.crypterium.cryptApi.pojos.wallets.ExchangeRate;
import com.crypterium.cryptApi.pojos.wallets.TotalFeeAmount;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletHistoryRecordPayoutBSB {

    @Expose
    private CreditAmount creditAmount;
    @Expose
    private DebitAmount debitAmount;
    @Expose
    private String description;
    @Expose
    private ExchangeRate exchangeRate;
    @Expose
    private String fromAddress;
    @Expose
    private String toBAN;
    @Expose
    private String toBSB;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getToBAN() {
        return toBAN;
    }

    public void setToBAN(String toBAN) {
        this.toBAN = toBAN;
    }

    public String getToBSB() {
        return toBSB;
    }

    public void setToBSB(String toBSB) {
        this.toBSB = toBSB;
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
