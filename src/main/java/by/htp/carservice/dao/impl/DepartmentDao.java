package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.Department;

import java.util.List;

public class DepartmentDao implements BaseDao<Department> {
    @Override
    public boolean save(Department entity) {
        return false;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean delete(Department entity) {
        return false;
    }

    @Override
    public Department take(long id) {
        return null;
    }

    @Override
    public List<Department> takeAll(String condition) {
        return null;
    }
}
