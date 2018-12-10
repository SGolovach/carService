package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.Order;

import java.util.List;

public class OrderDao implements BaseDao<Order> {
    @Override
    public boolean save(Order entity) {
        return false;
    }

    @Override
    public boolean update(Order entity) {
        return false;
    }

    @Override
    public boolean delete(Order entity) {
        return false;
    }

    @Override
    public Order take(long id) {
        return null;
    }

    @Override
    public List<Order> takeAll(String condition) {
        return null;
    }
}
