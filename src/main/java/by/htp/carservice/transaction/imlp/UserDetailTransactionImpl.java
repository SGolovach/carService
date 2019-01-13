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

public class UserDetailTransactionImpl implements TransactionUserDetail {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveTransaction(UserDetail entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveTransaction entity:" + entity);
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
        logger.log(Level.INFO, "Finish method saveTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateTransaction(UserDetail entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateTransaction entity:" + entity);
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
        logger.log(Level.INFO, "Finish method updateTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteTransaction(UserDetail entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteTransaction entity:" + entity);
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
        logger.log(Level.INFO, "Finish method deleteTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public UserDetail takeTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeTransaction entity by id:" + id);
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

    @Override
    public List<UserDetail> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAll");
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

    @Override
    public int countRecordTransaction() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordTransaction");
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

    @Override
    public int countRecordByIdTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordByIdTransaction " + id);
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

    @Override
    public List<UserDetail> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkAllRecordTransaction");
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

    @Override
    public List<UserDetail> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdTransaction");
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

    @Override
    public boolean checkRecordTransaction(long userId) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordTransaction :" + userId);
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
