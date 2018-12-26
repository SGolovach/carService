package by.htp.carservice.transaction.imlpreceiver;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarReceiver implements QueryReceiver<Car> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(Car entity) throws ServiceException {
        logger.log(Level.INFO,"Start method saveQuery entity:" + entity);
        AbstractDao<Car> carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(carDao);
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
        AbstractDao<Car> carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(carDao);
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
        AbstractDao<Car> carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(carDao);
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
        AbstractDao<Car> carDao = DaoFactory.getInstance().getCarDao();
        Car car;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(carDao);
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
    public List<Car> takeAllQuery(String condition) throws ServiceException {
        logger.log(Level.INFO,"Start method takeAllQuery");
        AbstractDao<Car> carDao = DaoFactory.getInstance().getCarDao();
        List<Car> carList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(carDao);
            carList = carDao.takeAll(condition);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method takeAllQuery result:" + carList);
        return carList;
    }
}
