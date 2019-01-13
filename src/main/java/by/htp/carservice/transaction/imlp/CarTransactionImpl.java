package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoCar;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.transaction.TransactionManager;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.TransactionCar;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarTransactionImpl implements TransactionCar {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveTransaction(Car entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveTransaction entity:" + entity);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) carDao);
            flagResult = carDao.save(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method saveTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateTransaction(Car entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateTransaction entity:" + entity);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) carDao);
            flagResult = carDao.update(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method updateTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteTransaction(Car entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteTransaction entity:" + entity);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) carDao);
            flagResult = carDao.delete(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method deleteTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public Car takeTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeTransaction entity by id:" + id);
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        Car car;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) carDao);
            car = carDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeTransaction result:" + car);
        return car;
    }

    @Override
    public List<Car> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAll");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        List<Car> carList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) carDao);
            carList = carDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAll result:" + carList);
        return carList;
    }

    @Override
    public int countRecordTransaction() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordTransaction");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) carDao);
            result = carDao.countRecord();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method countRecordTransaction result:" + result);
        return result;
    }

    @Override
    public int countRecordByIdTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordByIdTransaction");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) carDao);
            result = carDao.countRecordById(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method countRecordByIdTransaction result:" + result);
        return result;
    }

    @Override
    public List<Car> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkAllRecordTransaction");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        List<Car> carList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) carDao);
            carList = carDao.checkAllRecord(limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkAllRecordTransaction result:" + carList);
        return carList;
    }

    @Override
    public List<Car> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdTransaction");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        List<Car> carList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) carDao);
            carList = carDao.checkRecordById(id, limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkRecordByIdTransaction result:" + carList);
        return carList;
    }

    @Override
    public List<Car> takeAllByUserIdTransaction(long userId) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllByUserIdTransaction");
        DaoCar carDao = DaoFactory.getInstance().getCarDao();
        List<Car> carList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) carDao);
            carList = carDao.takeAllByUserId(userId);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAllByUserIdTransaction result:" + carList);
        return carList;
    }
}
