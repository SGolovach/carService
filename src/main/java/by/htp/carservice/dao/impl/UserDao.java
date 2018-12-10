package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.User;

import java.util.List;

public class UserDao implements BaseDao<User> {
    @Override
    public boolean save(User entity) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public User take(long id) {
        return null;
    }

    @Override
    public List<User> takeAll(String condition) {
        return null;
    }
}
