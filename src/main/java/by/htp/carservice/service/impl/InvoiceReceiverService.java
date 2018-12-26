package by.htp.carservice.service.impl;

import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class InvoiceReceiverService implements QueryReceiverService<Invoice> {
    private final QueryReceiver<Invoice> receiver =
            QueryReceiverFactory.getInstance().getInvoiceQueryReceiver();

    @Override
    public boolean saveQuery(Invoice entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Invoice entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Invoice entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public Invoice takeQuery(long id) throws ProjectException {
        Invoice invoice;
        try {
            invoice = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return invoice;
    }

    @Override
    public List<Invoice> takeAllQuery(String condition) throws ProjectException {
        List<Invoice> listInvoice;
        try {
            listInvoice = receiver.takeAllQuery(condition);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return listInvoice;
    }
}
