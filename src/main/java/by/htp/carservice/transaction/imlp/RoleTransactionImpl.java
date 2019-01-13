package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.dao.DaoRole;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.transaction.TransactionManager;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.TransactionRole;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RoleTransactionImpl implements TransactionRole {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveTransaction(Role entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveTransaction entity:" + entity);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) roleDao);
            flagResult = roleDao.save(entity);
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
    public boolean updateTransaction(Role entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateTransaction entity:" + entity);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) roleDao);
            flagResult = roleDao.update(entity);
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
    public boolean deleteTransaction(Role entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteTransaction entity:" + entity);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) roleDao);
            flagResult = roleDao.delete(entity);
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
    public Role takeTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeTransaction entity by id:" + id);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        Role role;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) roleDao);
            role = roleDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeTransaction result:" + role);
        return role;
    }

    @Override
    public List<Role> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAll");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        List<Role> roleList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) roleDao);
            roleList = roleDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAll result:" + roleList);
        return roleList;
    }

    @Override
    public int countRecordTransaction() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordTransaction");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) roleDao);
            result = roleDao.countRecord();
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
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) roleDao);
            result = roleDao.countRecordById(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method countRecordByIdTransaction result:" + result);
        return result;
    }

    @Override
    public List<Role> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkAllRecordTransaction");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        List<Role> roleList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) roleDao);
            roleList = roleDao.checkAllRecord(limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkAllRecordTransaction result:" + roleList);
        return roleList;
    }

    @Override
    public List<Role> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdTransaction");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        List<Role> roleList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) roleDao);
            roleList = roleDao.checkRecordById(id, limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkRecordByIdTransaction result:" + roleList);
        return roleList;
    }
}
