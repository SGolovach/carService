package by.htp.carservice.service.impl;

import by.htp.carservice.dao.QueryReceiver;
import by.htp.carservice.dao.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class OrderReceiverService implements QueryReceiverService<Order> {
    private final QueryReceiver<Order> receiver =
            QueryReceiverFactory.getInstance().getOrderQueryReceiver();

    @Override
    public boolean saveQuery(Order entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean updateQuery(Order entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean deleteQuery(Order entity) throws ProjectException {
        return false;
    }

    @Override
    public Order takeQuery(long id) throws ProjectException {
        return null;
    }

    @Override
    public List<Order> takeAllQuery() throws ProjectException {
        return null;
    }
}
