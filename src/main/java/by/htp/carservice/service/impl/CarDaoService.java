package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class CarDaoService implements DaoService<Car> {

    private final BaseDao<Car> dao = DaoFactory.getInstance().getCarDao();

    @Override
    public boolean save(Car entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(Car entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(Car entity) {
        return dao.delete(entity);
    }

    @Override
    public Car take(long id) {
        return dao.take(id);
    }

    @Override
    public List<Car> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
