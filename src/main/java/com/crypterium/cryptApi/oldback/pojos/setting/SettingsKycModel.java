
package com.crypterium.cryptApi.oldback.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsKycModel {

    @Expose
    private List<SettingsFieldModel> settingsFieldModels;
    @Expose
    private Long level;

    public List<SettingsFieldModel> getSettingsFieldModels() {
        return settingsFieldModels;
    }

    public SettingsKycModel setSettingsFieldModels(List<SettingsFieldModel> settingsFieldModels) {
        this.settingsFieldModels = settingsFieldModels;
        return this;
    }

    public Long getLevel() {
        return level;
    }

    public SettingsKycModel setLevel(Long level) {
        this.level = level;
        return this;
    }
}
