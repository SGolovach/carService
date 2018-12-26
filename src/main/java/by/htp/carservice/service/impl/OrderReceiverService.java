package by.htp.carservice.service.impl;

import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class OrderReceiverService implements QueryReceiverService<Order> {
    private final QueryReceiver<Order> receiver =
            QueryReceiverFactory.getInstance().getOrderQueryReceiver();

    @Override
    public boolean saveQuery(Order entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Order entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Order entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public Order takeQuery(long id) throws ProjectException {
        Order order;
        try {
            order = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return order;
    }

    @Override
    public List<Order> takeAllQuery(String condition) throws ProjectException {
        List<Order> listOrder;
        try {
            listOrder = receiver.takeAllQuery(condition);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return listOrder;
    }
}
