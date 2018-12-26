package by.htp.carservice.transaction.imlpreceiver;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserReceiver implements QueryReceiver<User> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveQuery entity:" + entity);
        AbstractDao<User> userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(userDao);
            flagResult = userDao.save(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method saveQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateQuery(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateQuery entity:" + entity);
        AbstractDao<User> userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(userDao);
            flagResult = userDao.update(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method updateQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteQuery(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteQuery entity:" + entity);
        AbstractDao<User> userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(userDao);
            flagResult = userDao.delete(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method deleteQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public User takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeQuery entity by id:" + id);
        AbstractDao<User> userDao = DaoFactory.getInstance().getUserDao();
        User user;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(userDao);
            user = userDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeQuery result:" + user);
        return user;
    }

    @Override
    public List<User> takeAllQuery(String condition) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        AbstractDao<User> userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(userDao);
            userList = userDao.takeAll(condition);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + userList);
        return userList;
    }
}
