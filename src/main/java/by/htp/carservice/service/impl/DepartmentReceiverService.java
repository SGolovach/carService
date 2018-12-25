package by.htp.carservice.service.impl;

import by.htp.carservice.dao.QueryReceiver;
import by.htp.carservice.dao.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class DepartmentReceiverService implements QueryReceiverService<Department> {
    private final QueryReceiver<Department> receiver =
            QueryReceiverFactory.getInstance().getDepartmentQueryReceiver();

    @Override
    public boolean saveQuery(Department entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean updateQuery(Department entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean deleteQuery(Department entity) throws ProjectException {
        return false;
    }

    @Override
    public Department takeQuery(long id) throws ProjectException {
        return null;
    }

    @Override
    public List<Department> takeAllQuery() throws ProjectException {
        return null;
    }
}
