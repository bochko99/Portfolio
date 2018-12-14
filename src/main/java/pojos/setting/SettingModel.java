
package pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingModel {

    @Expose
    private SettingsUploadFileModel settingsUploadFileModel;

    public SettingsUploadFileModel getSettingsUploadFileModel() {
        return settingsUploadFileModel;
    }

    public SettingModel setSettingsUploadFileModel(SettingsUploadFileModel settingsUploadFileModel) {
        this.settingsUploadFileModel = settingsUploadFileModel;
        return this;
    }
}
