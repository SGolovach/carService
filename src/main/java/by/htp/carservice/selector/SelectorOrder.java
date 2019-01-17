package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.SelectorException;

/**
 * The Interface SelectorOrder.
 */
public interface SelectorOrder extends Selector<Order> {

    /**
     * Update status.
     *
     * @param orderId the order id
     * @return true, if successful
     * @throws SelectorException the selector exception
     */
    boolean updateStatus(long orderId) throws SelectorException;

}
