package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class InvoicePaginateService implements PaginationDataService<Invoice> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getInvoicePagination();

    @Override
    public List<Invoice> paginate(Map<String, String> requestParam) throws CommandException {
        List<Invoice> invoiceList;
        try {
            invoiceList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return invoiceList;
    }

    @Override
    public List<Invoice> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<Invoice> invoiceList;
        try {
            invoiceList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return invoiceList;
    }
}
