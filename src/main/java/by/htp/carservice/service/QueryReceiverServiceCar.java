package by.htp.carservice.service;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.CommandException;

import java.util.List;

public interface QueryReceiverServiceCar extends QueryReceiverService<Car> {
    List<Car> takeAllByUserIdQuery(long userId) throws CommandException;
}
