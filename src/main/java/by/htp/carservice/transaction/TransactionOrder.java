package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ServiceException;

public interface TransactionOrder extends Transaction<Order> {

    boolean updateStatusTransaction(long orderId) throws ServiceException;
}
