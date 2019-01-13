package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public interface TransactionCar extends Transaction<Car> {

    List<Car> takeAllByUserIdTransaction(long userId) throws ServiceException;
}
