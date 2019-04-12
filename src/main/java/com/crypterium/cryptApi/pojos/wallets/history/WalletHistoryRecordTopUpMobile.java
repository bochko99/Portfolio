
package com.crypterium.cryptApi.pojos.wallets.history;

import com.crypterium.cryptApi.pojos.wallets.CreditAmount;
import com.crypterium.cryptApi.pojos.wallets.DebitAmount;
import com.crypterium.cryptApi.pojos.wallets.ExchangeRate;
import com.crypterium.cryptApi.pojos.wallets.TotalFeeAmount;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletHistoryRecordTopUpMobile {

    @Expose
    private CreditAmount creditAmount;
    @Expose
    private DebitAmount debitAmount;
    @Expose
    private ExchangeRate exchangeRate;
    @Expose
    private String fromAddress;
    @Expose
    private String toPhone;
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

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public TotalFeeAmount getTotalFeeAmount() {
        return totalFeeAmount;
    }

    public void setTotalFeeAmount(TotalFeeAmount totalFeeAmount) {
        this.totalFeeAmount = totalFeeAmount;
    }

}
