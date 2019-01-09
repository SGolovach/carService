package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class OrderPaginateService implements PaginationDataService<Order> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getOrderPagination();

    @Override
    public List<Order> paginate(Map<String, String> requestParam) throws CommandException {
        List<Order> orderList;
        try {
            orderList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return orderList;
    }

    @Override
    public List<Order> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<Order> orderList;
        try {
            orderList = pagination.paginateById(requestParam,id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return orderList;
    }
}
