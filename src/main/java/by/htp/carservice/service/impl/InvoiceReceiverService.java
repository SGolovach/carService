package by.htp.carservice.service.impl;

import by.htp.carservice.dao.QueryReceiver;
import by.htp.carservice.dao.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class InvoiceReceiverService implements QueryReceiverService<Invoice> {
    private final QueryReceiver<Invoice> receiver =
            QueryReceiverFactory.getInstance().getInvoiceQueryReceiver();

    @Override
    public boolean saveQuery(Invoice entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean updateQuery(Invoice entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean deleteQuery(Invoice entity) throws ProjectException {
        return false;
    }

    @Override
    public Invoice takeQuery(long id) throws ProjectException {
        return null;
    }

    @Override
    public List<Invoice> takeAllQuery() throws ProjectException {
        return null;
    }
}
