
package pojos.deposit;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DepositReqOfferModel {

    @Expose
    private Order order;


    public Order getOrder() {
        return order;
    }

    public DepositReqOfferModel setOrder(Order order) {
        this.order = order;
        return this;
    }
}
