package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.dao.DaoRole;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.QueryRole;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RoleTransaction implements QueryRole {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(Role entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveQuery entity:" + entity);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method saveQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateQuery(Role entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateQuery entity:" + entity);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method updateQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Role entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteQuery entity:" + entity);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method deleteQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public Role takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeQuery entity by id:" + id);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        Role role;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method takeQuery result:" + role);
        return role;
    }

    @Override
    public List<Role> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        List<Role> roleList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + roleList);
        return roleList;
    }

    @Override
    public int countRecordQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordQuery");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        int result;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method countRecordQuery result:" + result);
        return result;
    }

    @Override
    public int countRecordByIdQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordByIdQuery " + id);
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        int result;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method countRecordByIdQuery result:" + result);
        return result;
    }

    @Override
    public List<Role> checkAllRecordQuery(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkAllRecordQuery");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        List<Role> roleList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method checkAllRecordQuery result:" + roleList);
        return roleList;
    }

    @Override
    public List<Role> checkRecordByIdQuery(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdQuery");
        DaoRole roleDao = DaoFactory.getInstance().getRoleDao();
        List<Role> roleList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
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
        logger.log(Level.INFO, "Finish method checkRecordByIdQuery result:" + roleList);
        return roleList;
    }
}
