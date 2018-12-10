package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.Car;

import java.util.List;

public class CarDao implements BaseDao<Car> {
    @Override
    public boolean save(Car entity) {
        return false;
    }

    @Override
    public boolean update(Car entity) {
        return false;
    }

    @Override
    public boolean delete(Car entity) {
        return false;
    }

    @Override
    public Car take(long id) {
        return null;
    }

    @Override
    public List<Car> takeAll(String condition) {
        return null;
    }
}
