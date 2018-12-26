package by.htp.carservice.transaction.imlpreceiver;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderReceiver implements QueryReceiver<Order> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(Order entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveQuery entity:" + entity);
        AbstractDao<Order> orderDao = DaoFactory.getInstance().getOrderDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(orderDao);
            flagResult = orderDao.save(entity);
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
    public boolean updateQuery(Order entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateQuery entity:" + entity);
        AbstractDao<Order> orderDao = DaoFactory.getInstance().getOrderDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(orderDao);
            flagResult = orderDao.update(entity);
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
    public boolean deleteQuery(Order entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteQuery entity:" + entity);
        AbstractDao<Order> orderDao = DaoFactory.getInstance().getOrderDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(orderDao);
            flagResult = orderDao.delete(entity);
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
    public Order takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeQuery entity by id:" + id);
        AbstractDao<Order> orderDao = DaoFactory.getInstance().getOrderDao();
        Order order;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(orderDao);
            order = orderDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeQuery result:" + order);
        return order;
    }

    @Override
    public List<Order> takeAllQuery(String condition) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        AbstractDao<Order> orderDao = DaoFactory.getInstance().getOrderDao();
        List<Order> orderList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(orderDao);
            orderList = orderDao.takeAll(condition);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + orderList);
        return orderList;
    }
}
