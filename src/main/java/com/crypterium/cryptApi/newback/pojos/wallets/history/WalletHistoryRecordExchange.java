
package com.crypterium.cryptApi.newback.pojos.wallets.history;

import com.crypterium.cryptApi.newback.pojos.wallets.CreditAmount;
import com.crypterium.cryptApi.newback.pojos.wallets.DebitAmount;
import com.crypterium.cryptApi.newback.pojos.wallets.ExchangeRate;
import com.crypterium.cryptApi.newback.pojos.wallets.MainAmount;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletHistoryRecordExchange {

    @Expose
    private CreditAmount creditAmount;
    @Expose
    private DebitAmount debitAmount;
    @Expose
    private ExchangeRate exchangeRate;
    @Expose
    private String fromAddress;
    @Expose
    private MainAmount mainAmount;
    @Expose
    private String toAddress;

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

    public MainAmount getMainAmount() {
        return mainAmount;
    }

    public void setMainAmount(MainAmount mainAmount) {
        this.mainAmount = mainAmount;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

}
