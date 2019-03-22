
package com.crypterium.cryptApi.pojos.restoreaccessoperation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResetResp {

    @Expose
    private String result;

    public String getResult() {
        return result;
    }

    public ResetResp setResult(String result) {
        this.result = result;
        return this;
    }
}
