package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public interface QueryCar extends Query<Car> {

    List<Car> takeAllByUserIdQuery(long userId) throws ServiceException;
}
