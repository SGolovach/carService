package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorOrder;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionOrder;

import java.util.List;

public class OrderSelector implements SelectorOrder {
    private final TransactionOrder transactionOrder =
            TransactionFactory.getInstance().getTransactionOrder();

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
}
