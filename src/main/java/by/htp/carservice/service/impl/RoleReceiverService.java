package by.htp.carservice.service.impl;

import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class RoleReceiverService implements QueryReceiverService<Role> {
    private final QueryReceiver<Role> receiver =
            QueryReceiverFactory.getInstance().getRoleQueryReceiver();

    @Override
    public boolean saveQuery(Role entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Role entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Role entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public Role takeQuery(long id) throws ProjectException {
        Role role;
        try {
            role = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return role;
    }

    @Override
    public List<Role> takeAllQuery(String condition) throws ProjectException {
        List<Role> listRole;
        try {
            listRole = receiver.takeAllQuery(condition);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return listRole;
    }
}
