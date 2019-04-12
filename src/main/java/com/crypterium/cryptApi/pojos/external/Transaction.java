
package com.crypterium.cryptApi.pojos.external;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Transaction {

    @SerializedName("amount_sent")
    private String amountSent;
    @SerializedName("amount_withdrawn")
    private String amountWithdrawn;
    @SerializedName("blockio_fee")
    private String blockioFee;
    @Expose
    private String network;
    @SerializedName("network_fee")
    private String networkFee;
    @Expose
    private String txid;

    public String getAmountSent() {
        return amountSent;
    }

    public Transaction setAmountSent(String amountSent) {
        this.amountSent = amountSent;
        return this;
    }

    public String getAmountWithdrawn() {
        return amountWithdrawn;
    }

    public Transaction setAmountWithdrawn(String amountWithdrawn) {
        this.amountWithdrawn = amountWithdrawn;
        return this;
    }

    public String getBlockioFee() {
        return blockioFee;
    }

    public Transaction setBlockioFee(String blockioFee) {
        this.blockioFee = blockioFee;
        return this;
    }

    public String getNetwork() {
        return network;
    }

    public Transaction setNetwork(String network) {
        this.network = network;
        return this;
    }

    public String getNetworkFee() {
        return networkFee;
    }

    public Transaction setNetworkFee(String networkFee) {
        this.networkFee = networkFee;
        return this;
    }

    public String getTxid() {
        return txid;
    }

    public Transaction setTxid(String txid) {
        this.txid = txid;
        return this;
    }
}
