
package pojos.favorite;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FavoritesInvoiceResponseModel {

    @Expose
    private String invoiceId;
    @Expose
    private String name;

    public String getInvoiceId() {
        return invoiceId;
    }

    public FavoritesInvoiceResponseModel setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    public String getName() {
        return name;
    }

    public FavoritesInvoiceResponseModel setName(String name) {
        this.name = name;
        return this;
    }
}
