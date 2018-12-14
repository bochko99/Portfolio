
package pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoiceFundsWalletModel {

    @Expose
    private Long amount;
    @Expose
    private String id;

    public Long getAmount() {
        return amount;
    }

    public InvoiceFundsWalletModel setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getId() {
        return id;
    }

    public InvoiceFundsWalletModel setId(String id) {
        this.id = id;
        return this;
    }
}
