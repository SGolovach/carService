package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorOrder;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionOrder;

import java.util.List;

/**
 * The Class OrderSelector.
 */
public class OrderSelector implements SelectorOrder {
    
    /** The transaction order. */
    private final TransactionOrder transactionOrder =
            TransactionFactory.getInstance().getTransactionOrder();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#save(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean save(Order entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionOrder.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#update(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean update(Order entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionOrder.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#delete(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean delete(Order entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionOrder.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#take(long)
     */
    @Override
    public Order take(long id) throws SelectorException {
        Order order;
        try {
            order = transactionOrder.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return order;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#takeAll()
     */
    @Override
    public List<Order> takeAll() throws SelectorException {
        List<Order> listOrder;
        try {
            listOrder = transactionOrder.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listOrder;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecord()
     */
    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionOrder.countRecordTransaction();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecordById(long)
     */
    @Override
    public int countRecordById(long id) throws SelectorException {
        int result;
        try {
            result = transactionOrder.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkAllRecord(int, int)
     */
    @Override
    public List<Order> checkAllRecord(int limit, int offset) throws SelectorException {
        List<Order> listOrder;
        try {
            listOrder = transactionOrder.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listOrder;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkRecordById(long, int, int)
     */
    @Override
    public List<Order> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<Order> listOrder;
        try {
            listOrder = transactionOrder.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listOrder;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.SelectorOrder#updateStatus(long)
     */
    @Override
    public boolean updateStatus(long orderId) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionOrder.updateStatusTransaction(orderId);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }
}
