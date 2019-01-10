package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.DaoException;

import java.util.List;

/**
 * The Interface DaoCar.
 */
public interface DaoCar extends BaseDao<Car> {

    /**
     * Take all by user id.
     *
     * @param userId the user id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Car> takeAllByUserId(long userId) throws DaoException;
}
