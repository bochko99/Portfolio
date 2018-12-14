
package pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesMobileCodeModel {

    @Expose
    private String country;
    @Expose
    private Boolean isDefault;
    @Expose
    private List<String> mobilePrefixes;

    public String getCountry() {
        return country;
    }

    public InvoicesMobileCodeModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public InvoicesMobileCodeModel setDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public List<String> getMobilePrefixes() {
        return mobilePrefixes;
    }

    public InvoicesMobileCodeModel setMobilePrefixes(List<String> mobilePrefixes) {
        this.mobilePrefixes = mobilePrefixes;
        return this;
    }
}
