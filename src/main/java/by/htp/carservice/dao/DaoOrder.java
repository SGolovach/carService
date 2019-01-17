package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.DaoException;

/**
 * The Interface DaoOrder.
 */
public interface DaoOrder extends BaseDao<Order> {

    /**
     * Update status.
     *
     * @param orderId the order id
     * @return true, if successful
     * @throws DaoException the dao exception
     */
    boolean updateStatus(long orderId) throws DaoException;

}
