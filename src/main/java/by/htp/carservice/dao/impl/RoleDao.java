package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.Role;

import java.util.List;

public class RoleDao implements BaseDao<Role> {
    @Override
    public boolean save(Role entity) {
        return false;
    }

    @Override
    public boolean update(Role entity) {
        return false;
    }

    @Override
    public boolean delete(Role entity) {
        return false;
    }

    @Override
    public Role take(long id) {
        return null;
    }

    @Override
    public List<Role> takeAll(String condition) {
        return null;
    }
}
