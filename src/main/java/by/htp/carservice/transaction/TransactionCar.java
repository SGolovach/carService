package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

/**
 * The Interface TransactionCar.
 */
public interface TransactionCar extends Transaction<Car> {

    /**
     * Take all by user id transaction.
     *
     * @param userId the user id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Car> takeAllByUserIdTransaction(long userId) throws ServiceException;
}
