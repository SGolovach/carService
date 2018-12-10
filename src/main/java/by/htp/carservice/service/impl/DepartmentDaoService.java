package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class DepartmentDaoService implements DaoService<Department> {
    private final BaseDao<Department> dao =DaoFactory.getInstance().getDepartmentDao();

    @Override
    public boolean save(Department entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(Department entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(Department entity) {
        return dao.delete(entity);
    }

    @Override
    public Department take(long id) {
        return dao.take(id);
    }

    @Override
    public List<Department> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
