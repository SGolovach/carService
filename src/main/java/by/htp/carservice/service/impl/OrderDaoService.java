package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class OrderDaoService implements DaoService<Order> {
    private final BaseDao<Order> dao =DaoFactory.getInstance().getOrderDao();

    @Override
    public boolean save(Order entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(Order entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(Order entity) {
        return dao.delete(entity);
    }

    @Override
    public Order take(long id) {
        return dao.take(id);
    }

    @Override
    public List<Order> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
