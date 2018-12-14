
package pojos.setting;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SettingsUploadFileModel {

    @Expose
    private String accessKey;
    @Expose
    private String bucket;
    @Expose
    private String credentials;
    @Expose
    private String secretKey;
    @Expose
    private String type;

    public String getAccessKey() {
        return accessKey;
    }

    public SettingsUploadFileModel setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public String getBucket() {
        return bucket;
    }

    public SettingsUploadFileModel setBucket(String bucket) {
        this.bucket = bucket;
        return this;
    }

    public String getCredentials() {
        return credentials;
    }

    public SettingsUploadFileModel setCredentials(String credentials) {
        this.credentials = credentials;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public SettingsUploadFileModel setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public String getType() {
        return type;
    }

    public SettingsUploadFileModel setType(String type) {
        this.type = type;
        return this;
    }
}
