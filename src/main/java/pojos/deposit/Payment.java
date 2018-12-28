
package pojos.deposit;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Payment {

    @Expose
    private Double amount;
    @Expose
    private String currency;

    public Double getAmount() {
        return amount;
    }

    public Payment setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Payment setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
