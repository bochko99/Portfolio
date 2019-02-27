
package com.crypterium.cryptApi.oldback.pojos.chat;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ChatCreateMessageModel {


    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public ChatCreateMessageModel setMessage(String message) {
        this.message = message;
        return this;
    }
}


