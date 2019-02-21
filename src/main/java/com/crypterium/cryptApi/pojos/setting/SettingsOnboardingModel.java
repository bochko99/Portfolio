
package com.crypterium.cryptApi.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsOnboardingModel {

    @Expose
    private String name;
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public SettingsOnboardingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SettingsOnboardingModel setUrl(String url) {
        this.url = url;
        return this;
    }
}
