package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.dao.DaoUserDetail;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.transaction.TransactionManager;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.TransactionUserDetail;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * The Class UserDetailTransactionImpl.
 */
public class UserDetailTransactionImpl implements TransactionUserDetail {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#saveTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean saveTransaction(UserDetail entity) throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) userDetailDao);
            flagResult = userDetailDao.save(entity);
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
    public boolean updateTransaction(UserDetail entity) throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) userDetailDao);
            flagResult = userDetailDao.update(entity);
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
    public boolean deleteTransaction(UserDetail entity) throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) userDetailDao);
            flagResult = userDetailDao.delete(entity);
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
    public UserDetail takeTransaction(long id) throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        UserDetail userDetail;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDetailDao);
            userDetail = userDetailDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeTransaction result:" + userDetail);
        return userDetail;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeAllQuery()
     */
    @Override
    public List<UserDetail> takeAllQuery() throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        List<UserDetail> userDetailList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDetailDao);
            userDetailList = userDetailDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAll result:" + userDetailList);
        return userDetailList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordTransaction()
     */
    @Override
    public int countRecordTransaction() throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDetailDao);
            result = userDetailDao.countRecord();
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
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDetailDao);
            result = userDetailDao.countRecordById(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method v result:" + result);
        return result;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkAllRecordTransaction(int, int)
     */
    @Override
    public List<UserDetail> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        List<UserDetail> userDetailList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDetailDao);
            userDetailList = userDetailDao.checkAllRecord(limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkAllRecordTransaction result:" + userDetailList);
        return userDetailList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkRecordByIdTransaction(long, int, int)
     */
    @Override
    public List<UserDetail> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        List<UserDetail> userDetailList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDetailDao);
            userDetailList = userDetailDao.checkRecordById(id, limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkRecordByIdTransaction result:" + userDetailList);
        return userDetailList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.TransactionUserDetail#checkRecordTransaction(long)
     */
    @Override
    public boolean checkRecordTransaction(long userId) throws ServiceException {
        DaoUserDetail userDetailDao = DaoFactory.getInstance().getUserDetailDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDetailDao);
            flagResult = userDetailDao.checkRecord(userId);
        } catch (DaoException | TransactionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkRecordTransaction result:" + flagResult);
        return flagResult;
    }
}
