package by.htp.carservice.transaction.imlpreceiver;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class InvoiceReceiver implements QueryReceiver<Invoice> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(Invoice entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveQuery entity:" + entity);
        AbstractDao<Invoice> invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(invoiceDao);
            flagResult = invoiceDao.save(entity);
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
    public boolean updateQuery(Invoice entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateQuery entity:" + entity);
        AbstractDao<Invoice> invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(invoiceDao);
            flagResult = invoiceDao.update(entity);
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
    public boolean deleteQuery(Invoice entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteQuery entity:" + entity);
        AbstractDao<Invoice> invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(invoiceDao);
            flagResult = invoiceDao.delete(entity);
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
    public Invoice takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeQuery entity by id:" + id);
        AbstractDao<Invoice> invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        Invoice invoice;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(invoiceDao);
            invoice = invoiceDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeQuery result:" + invoice);
        return invoice;
    }

    @Override
    public List<Invoice> takeAllQuery(String condition) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        AbstractDao<Invoice> invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        List<Invoice> invoiceList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(invoiceDao);
            invoiceList = invoiceDao.takeAll(condition);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + invoiceList);
        return invoiceList;
    }
}
