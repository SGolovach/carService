package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.UserDetail;

import java.util.List;

public class UserDetailDao implements BaseDao<UserDetail> {
    @Override
    public boolean save(UserDetail entity) {
        return false;
    }

    @Override
    public boolean update(UserDetail entity) {
        return false;
    }

    @Override
    public boolean delete(UserDetail entity) {
        return false;
    }

    @Override
    public UserDetail take(long id) {
        return null;
    }

    @Override
    public List<UserDetail> takeAll(String condition) {
        return null;
    }
}
