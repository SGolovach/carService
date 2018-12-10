package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class UserDetailDaoService implements DaoService<UserDetail> {
    private final BaseDao<UserDetail> dao =DaoFactory.getInstance().getUserDetailDao();

    @Override
    public boolean save(UserDetail entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(UserDetail entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(UserDetail entity) {
        return dao.delete(entity);
    }

    @Override
    public UserDetail take(long id) {
        return dao.take(id);
    }

    @Override
    public List<UserDetail> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
