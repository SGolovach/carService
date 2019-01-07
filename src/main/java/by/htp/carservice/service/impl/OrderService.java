package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryServiceOrder;
import by.htp.carservice.transaction.QueryFactory;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.QueryOrder;

import java.util.List;

public class OrderService implements QueryServiceOrder {
    private final QueryOrder receiver =
            QueryFactory.getInstance().getOrderQuery();

    @Override
    public boolean saveQuery(Order entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Order entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Order entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public Order takeQuery(long id) throws CommandException {
        Order order;
        try {
            order = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return order;
    }

    @Override
    public List<Order> takeAllQuery() throws CommandException {
        List<Order> listOrder;
        try {
            listOrder = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listOrder;
    }
}