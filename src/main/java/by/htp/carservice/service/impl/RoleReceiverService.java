package by.htp.carservice.service.impl;

import by.htp.carservice.dao.QueryReceiver;
import by.htp.carservice.dao.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class RoleReceiverService implements QueryReceiverService<Role> {
    private final QueryReceiver<Role> receiver =
            QueryReceiverFactory.getInstance().getRoleQueryReceiver();

    @Override
    public boolean saveQuery(Role entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean updateQuery(Role entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean deleteQuery(Role entity) throws ProjectException {
        return false;
    }

    @Override
    public Role takeQuery(long id) throws ProjectException {
        return null;
    }

    @Override
    public List<Role> takeAllQuery() throws ProjectException {
        return null;
    }
}
