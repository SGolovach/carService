package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorCar;
import by.htp.carservice.transaction.TransactionCar;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public class CarSelector implements SelectorCar {
    private final TransactionCar transactionCar =
            TransactionFactory.getInstance().getTransactionCar();

    @Override
    public boolean save(Car entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionCar.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean update(Car entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionCar.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean delete(Car entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionCar.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public Car take(long id) throws SelectorException {
        Car car;
        try {
            car = transactionCar.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return car;
    }

    @Override
    public List<Car> takeAll() throws SelectorException {
        List<Car> listCar;
        try {
            listCar = transactionCar.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listCar;
    }

    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionCar.countRecordTransaction();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public int countRecordById(long id) throws SelectorException {
        int result;
        try {
            result = transactionCar.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public List<Car> checkAllRecord(int limit, int offset) throws SelectorException {
        List<Car> listCar;
        try {
            listCar = transactionCar.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listCar;
    }

    @Override
    public List<Car> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<Car> listCar;
        try {
            listCar = transactionCar.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listCar;
    }

    @Override
    public List<Car> takeAllByUserId(long userId) throws SelectorException {
        List<Car> listCar;
        try {
            listCar = transactionCar.takeAllByUserIdTransaction(userId);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listCar;
    }
}
