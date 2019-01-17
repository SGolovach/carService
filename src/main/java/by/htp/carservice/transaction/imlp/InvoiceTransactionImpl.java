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

/**
 * The Class InvoiceTransactionImpl.
 */
public class InvoiceTransactionImpl implements TransactionInvoice {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#saveTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean saveTransaction(Invoice entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#updateTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean updateTransaction(Invoice entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#deleteTransaction(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean deleteTransaction(Invoice entity) throws ServiceException {
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
        logger.log(Level.INFO, "Result:" + flagResult);
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeTransaction(long)
     */
    @Override
    public Invoice takeTransaction(long id) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#takeAllQuery()
     */
    @Override
    public List<Invoice> takeAllQuery() throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordTransaction()
     */
    @Override
    public int countRecordTransaction() throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#countRecordByIdTransaction(long)
     */
    @Override
    public int countRecordByIdTransaction(long id) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkAllRecordTransaction(int, int)
     */
    @Override
    public List<Invoice> checkAllRecordTransaction(int limit, int offset) throws ServiceException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.transaction.Transaction#checkRecordByIdTransaction(long, int, int)
     */
    @Override
    public List<Invoice> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException {
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
