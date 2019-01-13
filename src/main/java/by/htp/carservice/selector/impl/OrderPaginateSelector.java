package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

public class OrderPaginateSelector implements PaginationDataSelector<Order> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getOrderPagination();

    @Override
    public List<Order> paginate(Map<String, String> requestParam) throws SelectorException {
        List<Order> orderList;
        try {
            orderList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return orderList;
    }

    @Override
    public List<Order> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<Order> orderList;
        try {
            orderList = pagination.paginateById(requestParam,id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return orderList;
    }
}
