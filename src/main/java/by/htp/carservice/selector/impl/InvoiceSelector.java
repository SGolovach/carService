package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorInvoice;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionInvoice;

import java.util.List;

public class InvoiceSelector implements SelectorInvoice {
    private final TransactionInvoice transactionInvoice =
            TransactionFactory.getInstance().getTransactionInvoice();

    @Override
    public boolean save(Invoice entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionInvoice.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean update(Invoice entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionInvoice.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean delete(Invoice entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionInvoice.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public Invoice take(long id) throws SelectorException {
        Invoice invoice;
        try {
            invoice = transactionInvoice.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return invoice;
    }

    @Override
    public List<Invoice> takeAll() throws SelectorException {
        List<Invoice> listInvoice;
        try {
            listInvoice = transactionInvoice.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listInvoice;
    }

    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionInvoice.countRecordTransaction();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public int countRecordById(long id) throws SelectorException {
        int result;
        try {
            result = transactionInvoice.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public List<Invoice> checkAllRecord(int limit, int offset) throws SelectorException {
        List<Invoice> listInvoice;
        try {
            listInvoice = transactionInvoice.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listInvoice;
    }

    @Override
    public List<Invoice> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<Invoice> listInvoice;
        try {
            listInvoice = transactionInvoice.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listInvoice;
    }
}
