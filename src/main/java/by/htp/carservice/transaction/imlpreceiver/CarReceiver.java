package by.htp.carservice.transaction.imlpreceiver;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoCar;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.QueryReceiverCar;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarReceiver implements QueryReceiverCar {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(Car entity) throws ServiceException {
        logger.log(Level.INFO,"Start method saveQuery entity:" + entity);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao)carDao);
            flagResult = carDao.save(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method saveQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateQuery(Car entity) throws ServiceException {
        logger.log(Level.INFO,"Start method updateQuery entity:" + entity);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao)carDao);
            flagResult = carDao.update(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method updateQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Car entity) throws ServiceException {
        logger.log(Level.INFO,"Start method deleteQuery entity:" + entity);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao)carDao);
            flagResult = carDao.delete(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method deleteQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public Car takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO,"Start method takeQuery entity by id:" + id);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        Car car;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao)carDao);
            car = carDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method takeQuery result:" + car);
        return car;
    }

    @Override
    public List<Car> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO,"Start method takeAllQuery");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        List<Car> carList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao)carDao);
            carList = carDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method takeAllQuery result:" + carList);
        return carList;
    }

    @Override
    public List<Car> takeAllByUserIdQuery(long userId) throws ServiceException {
        logger.log(Level.INFO,"Start method takeAllByUserIdQuery");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        List<Car> carList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao)carDao);
            carList = carDao.takeAllByUserId(userId);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method takeAllByUserIdQuery result:" + carList);
        return carList;
    }
}
