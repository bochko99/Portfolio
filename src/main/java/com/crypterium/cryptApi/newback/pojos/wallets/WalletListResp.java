
package com.crypterium.cryptApi.newback.pojos.wallets;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WalletListResp {

    @Expose
    private Fiat fiat;
    @Expose
    private Long offset;
    @Expose
    private Long size;
    @Expose
    private Long total;
    @Expose
    private List<Wallet> wallets;

    public Fiat getFiat() {
        return fiat;
    }

    public WalletListResp setFiat(Fiat fiat) {
        this.fiat = fiat;
        return this;
    }

    public Long getOffset() {
        return offset;
    }

    public WalletListResp setOffset(Long offset) {
        this.offset = offset;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public WalletListResp setSize(Long size) {
        this.size = size;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public WalletListResp setTotal(Long total) {
        this.total = total;
        return this;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public WalletListResp setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
        return this;
    }
}
