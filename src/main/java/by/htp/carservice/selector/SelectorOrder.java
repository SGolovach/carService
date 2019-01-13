package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.SelectorException;

public interface SelectorOrder extends Selector<Order> {

    boolean updateStatus(long orderId) throws SelectorException;

}
