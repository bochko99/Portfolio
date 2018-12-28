
package pojos.deposit;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Order {

    @Expose
    private Double amount;
    @Expose
    private String currency;

    public Double getAmount() {
        return amount;
    }

    public Order setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Order setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
