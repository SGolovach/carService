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

/**
 * The Class RoleTransactionImpl.
 */
public class RoleTransactionImpl implements TransactionRole {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#saveTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean saveTransaction(Role entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#updateTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean updateTransaction(Role entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#deleteTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean deleteTransaction(Role entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeTransaction(long)
     */
    @Override
    public Role takeTransaction(long id) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeAllQuery()
     */
    @Override
    public List<Role> takeAllQuery() throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordTransaction()
     */
    @Override
    public int countRecordTransaction() throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordByIdTransaction(long)
     */
    @Override
    public int countRecordByIdTransaction(long id) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkAllRecordTransaction(int, int)
     */
    @Override
    public List<Role> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkRecordByIdTransaction(long, int, int)
     */
    @Override
    public List<Role> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
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
