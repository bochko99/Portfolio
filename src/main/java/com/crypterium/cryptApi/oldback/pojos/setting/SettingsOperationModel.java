
package com.crypterium.cryptApi.oldback.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsOperationModel {

    @Expose
    private String name;
    @Expose
    private String popupStatus;
    @Expose
    private String provider;
    @Expose
    private String status;

    public String getName() {
        return name;
    }

    public SettingsOperationModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPopupStatus() {
        return popupStatus;
    }

    public SettingsOperationModel setPopupStatus(String popupStatus) {
        this.popupStatus = popupStatus;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public SettingsOperationModel setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SettingsOperationModel setStatus(String status) {
        this.status = status;
        return this;
    }
}
