
package pojos.bankwithdrawal;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TotalWithdrawal {

    @Expose
    private Long amount;
    @Expose
    private String currency;

    public Long getAmount() {
        return amount;
    }

    public TotalWithdrawal setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public TotalWithdrawal setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
