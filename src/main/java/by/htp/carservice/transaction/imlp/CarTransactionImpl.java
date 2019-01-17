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

/**
 * The Class CarTransactionImpl.
 */
public class CarTransactionImpl implements TransactionCar {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#saveTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean saveTransaction(Car entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#updateTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean updateTransaction(Car entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#deleteTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean deleteTransaction(Car entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeTransaction(long)
     */
    @Override
    public Car takeTransaction(long id) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeAllQuery()
     */
    @Override
    public List<Car> takeAllQuery() throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordTransaction()
     */
    @Override
    public int countRecordTransaction() throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordByIdTransaction(long)
     */
    @Override
    public int countRecordByIdTransaction(long id) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkAllRecordTransaction(int, int)
     */
    @Override
    public List<Car> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkRecordByIdTransaction(long, int, int)
     */
    @Override
    public List<Car> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.TransactionCar#takeAllByUserIdTransaction(long)
     */
    @Override
    public List<Car> takeAllByUserIdTransaction(long userId) throws ServiceException {
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
