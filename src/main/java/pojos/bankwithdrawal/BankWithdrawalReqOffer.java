
package pojos.bankwithdrawal;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BankWithdrawalReqOffer {

    @Expose
    private static BigDecimal amount;
    @Expose
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public BankWithdrawalReqOffer setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BankWithdrawalReqOffer setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}