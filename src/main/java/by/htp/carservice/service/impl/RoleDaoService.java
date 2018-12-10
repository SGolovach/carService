package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class RoleDaoService implements DaoService<Role> {
    private final BaseDao<Role> dao =DaoFactory.getInstance().getRoleDao();

    @Override
    public boolean save(Role entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(Role entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(Role entity) {
        return dao.delete(entity);
    }

    @Override
    public Role take(long id) {
        return dao.take(id);
    }

    @Override
    public List<Role> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
