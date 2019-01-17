package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoDepartment;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.transaction.TransactionManager;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.TransactionDepartment;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * The Class DepartmentTransactionImpl.
 */
public class DepartmentTransactionImpl implements TransactionDepartment {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#saveTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean saveTransaction(Department entity) throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) departmentDao);
            flagResult = departmentDao.save(entity);
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
    public boolean updateTransaction(Department entity) throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) departmentDao);
            flagResult = departmentDao.update(entity);
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
    public boolean deleteTransaction(Department entity) throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) departmentDao);
            flagResult = departmentDao.delete(entity);
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
    public Department takeTransaction(long id) throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        Department department;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) departmentDao);
            department = departmentDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Result:" + department);
        return department;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeAllQuery()
     */
    @Override
    public List<Department> takeAllQuery() throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        List<Department> departmentList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) departmentDao);
            departmentList = departmentDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAll result:" + departmentList);
        return departmentList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordTransaction()
     */
    @Override
    public int countRecordTransaction() throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) departmentDao);
            result = departmentDao.countRecord();
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
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) departmentDao);
            result = departmentDao.countRecordById(id);
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
    public List<Department> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        List<Department> departmentList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) departmentDao);
            departmentList = departmentDao.checkAllRecord(limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkAllRecordTransaction result:" + departmentList);
        return departmentList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkRecordByIdTransaction(long, int, int)
     */
    @Override
    public List<Department> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
        DaoDepartment departmentDao = DaoFactory.getInstance().getDepartmentDao();
        List<Department> departmentList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) departmentDao);
            departmentList = departmentDao.checkRecordById(id, limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkRecordByIdTransaction result:" + departmentList);
        return departmentList;
    }
}
