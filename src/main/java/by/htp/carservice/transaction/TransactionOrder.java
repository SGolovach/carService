package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ServiceException;

/**
 * The Interface TransactionOrder.
 */
public interface TransactionOrder extends Transaction<Order> {

    /**
     * Update status transaction.
     *
     * @param orderId the order id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean updateStatusTransaction(long orderId) throws ServiceException;
}
