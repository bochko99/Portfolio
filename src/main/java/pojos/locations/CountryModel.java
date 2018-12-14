
package pojos.locations;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CountryModel {

    @Expose
    private String code;
    @Expose
    private Boolean hasCryptoRestrictions;
    @Expose
    private String imageUrl;
    @Expose
    private List<String> mobilePrefixes;
    @Expose
    private String name;
    @Expose
    private List<CountriesRegionModel> countriesRegionModels;

    public String getCode() {
        return code;
    }

    public CountryModel setCode(String code) {
        this.code = code;
        return this;
    }

    public Boolean getHasCryptoRestrictions() {
        return hasCryptoRestrictions;
    }

    public CountryModel setHasCryptoRestrictions(Boolean hasCryptoRestrictions) {
        this.hasCryptoRestrictions = hasCryptoRestrictions;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CountryModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<String> getMobilePrefixes() {
        return mobilePrefixes;
    }

    public CountryModel setMobilePrefixes(List<String> mobilePrefixes) {
        this.mobilePrefixes = mobilePrefixes;
        return this;
    }

    public String getName() {
        return name;
    }

    public CountryModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<CountriesRegionModel> getCountriesRegionModels() {
        return countriesRegionModels;
    }

    public CountryModel setCountriesRegionModels(List<CountriesRegionModel> countriesRegionModels) {
        this.countriesRegionModels = countriesRegionModels;
        return this;
    }
}
