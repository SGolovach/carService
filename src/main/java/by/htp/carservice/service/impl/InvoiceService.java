package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryServiceInvoice;
import by.htp.carservice.transaction.QueryFactory;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.QueryInvoice;

import java.util.List;

public class InvoiceService implements QueryServiceInvoice {
    private final QueryInvoice receiver =
            QueryFactory.getInstance().getInvoiceQuery();

    @Override
    public boolean saveQuery(Invoice entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Invoice entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Invoice entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public Invoice takeQuery(long id) throws CommandException {
        Invoice invoice;
        try {
            invoice = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return invoice;
    }

    @Override
    public List<Invoice> takeAllQuery() throws CommandException {
        List<Invoice> listInvoice;
        try {
            listInvoice = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listInvoice;
    }
}
