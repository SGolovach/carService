package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.DaoException;

/**
 * The Interface DaoOrder.
 */
public interface DaoOrder extends BaseDao<Order> {

    boolean updateStatus(long orderId) throws DaoException;

}
