package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

public class InvoicePaginateSelector implements PaginationDataSelector<Invoice> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getInvoicePagination();

    @Override
    public List<Invoice> paginate(Map<String, String> requestParam) throws SelectorException {
        List<Invoice> invoiceList;
        try {
            invoiceList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return invoiceList;
    }

    @Override
    public List<Invoice> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<Invoice> invoiceList;
        try {
            invoiceList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return invoiceList;
    }
}
