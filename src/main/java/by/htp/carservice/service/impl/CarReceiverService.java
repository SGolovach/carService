package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryReceiverServiceCar;
import by.htp.carservice.transaction.QueryReceiverCar;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public class CarReceiverService implements QueryReceiverServiceCar {
    private final QueryReceiverCar receiver =
            QueryReceiverFactory.getInstance().getCarQueryReceiver();

    @Override
    public boolean saveQuery(Car entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Car entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Car entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public Car takeQuery(long id) throws CommandException {
        Car car;
        try {
            car = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return car;
    }

    @Override
    public List<Car> takeAllQuery() throws CommandException {
        List<Car> listCar;
        try {
            listCar = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listCar;
    }

    @Override
    public List<Car> takeAllByUserIdQuery(long userId) throws CommandException {
        List<Car> listCar;
        try {
            listCar = receiver.takeAllByUserIdQuery(userId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listCar;
    }
}
