
package com.crypterium.cryptApi.oldback.pojos.chat;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ChatMessageModel {

    @Expose
    private String date;
    @Expose
    private String employeeId;
    @Expose
    private String id;
    @Expose
    private String message;
    @Expose
    private String name;
    @Expose
    private String ownerId;
    @Expose
    private String personId;
    @Expose
    private String photoUrl;
    @Expose
    private String sessionId;

    public String getDate() {
        return date;
    }

    public ChatMessageModel setDate(String date) {
        this.date = date;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public ChatMessageModel setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getId() {
        return id;
    }

    public ChatMessageModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ChatMessageModel setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getName() {
        return name;
    }

    public ChatMessageModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public ChatMessageModel setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getPersonId() {
        return personId;
    }

    public ChatMessageModel setPersonId(String personId) {
        this.personId = personId;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public ChatMessageModel setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public ChatMessageModel setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }
}


