
package com.crypterium.cryptApi.newback.pojos.wallets.history;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletHistoryResponseModel {

    @Expose
    private String extraFilter;
    @Expose
    private List<History> history;
    @Expose
    private List<String> operationCurrencyFilter;
    @Expose
    private List<String> operationTypeFilter;

    public String getExtraFilter() {
        return extraFilter;
    }

    public WalletHistoryResponseModel setExtraFilter(String extraFilter) {
        this.extraFilter = extraFilter;
        return this;
    }

    public List<History> getHistory() {
        return history;
    }

    public WalletHistoryResponseModel setHistory(List<History> history) {
        this.history = history;
        return this;
    }

    public List<String> getOperationCurrencyFilter() {
        return operationCurrencyFilter;
    }

    public WalletHistoryResponseModel setOperationCurrencyFilter(List<String> operationCurrencyFilter) {
        this.operationCurrencyFilter = operationCurrencyFilter;
        return this;
    }

    public List<String> getOperationTypeFilter() {
        return operationTypeFilter;
    }

    public WalletHistoryResponseModel setOperationTypeFilter(List<String> operationTypeFilter) {
        this.operationTypeFilter = operationTypeFilter;
        return this;
    }
}
