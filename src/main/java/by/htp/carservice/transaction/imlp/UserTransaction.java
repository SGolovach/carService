package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.dao.DaoUser;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.QueryUser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserTransaction implements QueryUser {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveQuery entity:" + entity);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method saveQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateQuery(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateQuery entity:" + entity);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method updateQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteQuery(User entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteQuery entity:" + entity);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method deleteQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public User takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeQuery entity by id:" + id);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        User user;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method takeQuery result:" + user);
        return user;
    }

    @Override
    public List<User> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + userList);
        return userList;
    }

    @Override
    public int countRecordQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordQuery");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        int result;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method countRecordQuery result:" + result);
        return result;
    }

    @Override
    public int countRecordByIdQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordByIdQuery " + id);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        int result;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method countRecordByIdQuery result:" + result);
        return result;
    }

    @Override
    public List<User> checkAllRecordQuery(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkAllRecordQuery");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method checkAllRecordQuery result:" + userList);
        return userList;
    }

    @Override
    public List<User> checkRecordByIdQuery(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdQuery");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method checkRecordByIdQuery result:" + userList);
        return userList;
    }

    @Override
    public List<User> checkLoginQuery(String login, String password) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        List<User> userList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + userList);
        return userList;
    }

    @Override
    public boolean existLoginQuery(String login) throws ServiceException {
        logger.log(Level.INFO, "Start method existLoginQuery login:" + login);
        DaoUser userDao = DaoFactory.getInstance().getUserDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method existLoginQuery result:" + flagResult);
        return flagResult;
    }
}
