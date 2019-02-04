
package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryItem {

    @SerializedName("code")
    private String code;
    @SerializedName("hasCryptoRestrictions")
    private Boolean hasCryptoRestrictions;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("mobilePrefixes")
    private List<String> mobilePrefixes;
    @SerializedName("name")
    private String name;
    @SerializedName("regions")
    private List<Object> regions;

    public String getCode() {
        return code;
    }

    public CountryItem setCode(String code) {
        this.code = code;
        return this;
    }

    public Boolean getHasCryptoRestrictions() {
        return hasCryptoRestrictions;
    }

    public CountryItem setHasCryptoRestrictions(Boolean hasCryptoRestrictions) {
        this.hasCryptoRestrictions = hasCryptoRestrictions;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CountryItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<String> getMobilePrefixes() {
        return mobilePrefixes;
    }

    public CountryItem setMobilePrefixes(List<String> mobilePrefixes) {
        this.mobilePrefixes = mobilePrefixes;
        return this;
    }

    public String getName() {
        return name;
    }

    public CountryItem setName(String name) {
        this.name = name;
        return this;
    }

    public List<Object> getRegions() {
        return regions;
    }

    public CountryItem setRegions(List<Object> regions) {
        this.regions = regions;
        return this;
    }
}
