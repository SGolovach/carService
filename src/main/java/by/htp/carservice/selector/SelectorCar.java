package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.SelectorException;

import java.util.List;

/**
 * The Interface SelectorCar.
 */
public interface SelectorCar extends Selector<Car> {
    
    /**
     * Take all by user id.
     *
     * @param userId the user id
     * @return the list
     * @throws SelectorException the selector exception
     */
    List<Car> takeAllByUserId(long userId) throws SelectorException;
}
