package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.dao.DaoInvoice;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.QueryInvoice;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class InvoiceTransaction implements QueryInvoice {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(Invoice entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveQuery entity:" + entity);
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) invoiceDao);
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
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) invoiceDao);
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
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) invoiceDao);
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
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        Invoice invoice;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) invoiceDao);
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
    public List<Invoice> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        List<Invoice> invoiceList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) invoiceDao);
            invoiceList = invoiceDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + invoiceList);
        return invoiceList;
    }

    @Override
    public int countRecordQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordQuery");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        int result;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) invoiceDao);
            result = invoiceDao.countRecord();
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
        logger.log(Level.INFO, "Start method countRecordByIdQuery by id:" + id);
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        int result;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) invoiceDao);
            result = invoiceDao.countRecordById(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method countRecordByIdQuery result:" + result);
        return result;
    }

    @Override
    public List<Invoice> checkAllRecordQuery(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        List<Invoice> invoiceList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) invoiceDao);
            invoiceList = invoiceDao.checkAllRecord(limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkAllRecordQuery result:" + invoiceList);
        return invoiceList;
    }

    @Override
    public List<Invoice> checkRecordByIdQuery(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdQuery");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        List<Invoice> invoiceList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) invoiceDao);
            invoiceList = invoiceDao.checkRecordById(id, limit, offset);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method checkRecordByIdQuery result:" + invoiceList);
        return invoiceList;
    }
}
