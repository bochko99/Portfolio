
package pojos.invoices;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvoicesPaymentModel {

    @Expose
    private List<InvoiceFundsWalletModel> invoiceFundsWalletModels;
    @Expose
    private String password;

    public List<InvoiceFundsWalletModel> getInvoiceFundsWalletModels() {
        return invoiceFundsWalletModels;
    }

    public InvoicesPaymentModel setInvoiceFundsWalletModels(List<InvoiceFundsWalletModel> invoiceFundsWalletModels) {
        this.invoiceFundsWalletModels = invoiceFundsWalletModels;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public InvoicesPaymentModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
