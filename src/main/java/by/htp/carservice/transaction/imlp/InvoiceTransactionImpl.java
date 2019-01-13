package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.dao.DaoInvoice;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.transaction.TransactionManager;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.TransactionInvoice;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class InvoiceTransactionImpl implements TransactionInvoice {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveTransaction(Invoice entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveTransaction entity:" + entity);
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method saveTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateTransaction(Invoice entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateTransaction entity:" + entity);
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method updateTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteTransaction(Invoice entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteTransaction entity:" + entity);
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        boolean flagResult;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method deleteTransaction result:" + flagResult);
        return flagResult;
    }

    @Override
    public Invoice takeTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeTransaction entity by id:" + id);
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        Invoice invoice;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method takeTransaction result:" + invoice);
        return invoice;
    }

    @Override
    public List<Invoice> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAll");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        List<Invoice> invoiceList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method takeAll result:" + invoiceList);
        return invoiceList;
    }

    @Override
    public int countRecordTransaction() throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordTransaction");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method countRecordTransaction result:" + result);
        return result;
    }

    @Override
    public int countRecordByIdTransaction(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method countRecordByIdTransaction by id:" + id);
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        int result;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method countRecordByIdTransaction result:" + result);
        return result;
    }

    @Override
    public List<Invoice> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method takeAll");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        List<Invoice> invoiceList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method checkAllRecordTransaction result:" + invoiceList);
        return invoiceList;
    }

    @Override
    public List<Invoice> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
        logger.log(Level.INFO, "Start method checkRecordByIdTransaction");
        DaoInvoice invoiceDao = DaoFactory.getInstance().getInvoiceDao();
        List<Invoice> invoiceList;
        TransactionManager transaction;
        try {
            transaction = new TransactionManager();
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
        logger.log(Level.INFO, "Finish method checkRecordByIdTransaction result:" + invoiceList);
        return invoiceList;
    }
}
