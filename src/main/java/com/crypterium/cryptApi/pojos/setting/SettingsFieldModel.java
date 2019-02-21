
package com.crypterium.cryptApi.pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsFieldModel {

    @Expose
    private Boolean isRequired;
    @Expose
    private String name;
    @Expose
    private List<String> values;

    public Boolean getRequired() {
        return isRequired;
    }

    public SettingsFieldModel setRequired(Boolean required) {
        isRequired = required;
        return this;
    }

    public String getName() {
        return name;
    }

    public SettingsFieldModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getValues() {
        return values;
    }

    public SettingsFieldModel setValues(List<String> values) {
        this.values = values;
        return this;
    }
}
