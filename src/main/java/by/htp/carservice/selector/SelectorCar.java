package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.SelectorException;

import java.util.List;

public interface SelectorCar extends Selector<Car> {
    List<Car> takeAllByUserId(long userId) throws SelectorException;
}
