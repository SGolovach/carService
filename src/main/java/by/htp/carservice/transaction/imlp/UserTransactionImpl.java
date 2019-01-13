package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.dao.DaoUser;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.transaction.TransactionManager;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.TransactionUser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserTransactionImpl implements TransactionUser {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveTransaction(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveTransaction entity:" + entity);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) userDao);
            flagResult = userDao.save(entity);
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
    public boolean updateTransaction(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateTransaction entity:" + entity);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) userDao);
            flagResult = userDao.update(entity);
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
    public boolean deleteTransaction(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteTransaction entity:" + entity);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) userDao);
            flagResult = userDao.delete(entity);
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
    public User takeTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeTransaction entity by id:" + id);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        User user;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            user = userDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeTransaction result:" + user);
        return user;
    }

    @Override
    public List<User> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAll");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            userList = userDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAll result:" + userList);
        return userList;
    }

    @Override
    public int countRecordTransaction() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordTransaction");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            result = userDao.countRecord();
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
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            result = userDao.countRecordById(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method countRecordByIdTransaction result:" + result);
        return result;
    }

    @Override
    public List<User> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkAllRecordTransaction");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            userList = userDao.checkAllRecord(limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkAllRecordTransaction result:" + userList);
        return userList;
    }

    @Override
    public List<User> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdTransaction");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            userList = userDao.checkRecordById(id, limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkRecordByIdTransaction result:" + userList);
        return userList;
    }

    @Override
    public List<User> checkLoginTransaction(String login, String password) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAll");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            userList = userDao.checkLogin(login, password);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAll result:" + userList);
        return userList;
    }

    @Override
    public boolean existLoginTransaction(String login) throws ServiceException {
        logger.log(Level.INFO, "Start method existLoginTransaction login:" + login);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) userDao);
            flagResult = userDao.existLogin(login);
        } catch (DaoException | TransactionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method existLoginTransaction result:" + flagResult);
        return flagResult;
    }
}
