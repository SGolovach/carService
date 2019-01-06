package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.DaoException;

import java.util.List;

public interface DaoCar extends BaseDao<Car> {

    List<Car> takeAllByUserId(long userId) throws DaoException;
}
