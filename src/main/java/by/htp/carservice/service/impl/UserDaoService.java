package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class UserDaoService implements DaoService<User> {
    private final BaseDao<User> dao =DaoFactory.getInstance().getUserDao();

    @Override
    public boolean save(User entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(User entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(User entity) {
        return dao.delete(entity);
    }

    @Override
    public User take(long id) {
        return dao.take(id);
    }

    @Override
    public List<User> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
