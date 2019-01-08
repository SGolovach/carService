package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryServiceRole;
import by.htp.carservice.transaction.QueryFactory;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.QueryRole;

import java.util.List;

public class RoleService implements QueryServiceRole {
    private final QueryRole receiver =
            QueryFactory.getInstance().getRoleQuery();

    @Override
    public boolean saveQuery(Role entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Role entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Role entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public Role takeQuery(long id) throws CommandException {
        Role role;
        try {
            role = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return role;
    }

    @Override
    public List<Role> takeAllQuery() throws CommandException {
        List<Role> listRole;
        try {
            listRole = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listRole;
    }

    @Override
    public int countRecordQuery() throws CommandException {
        int result;
        try {
            result = receiver.countRecordQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }

    @Override
    public int countRecordByIdQuery(long id) throws CommandException {
        int result;
        try {
            result = receiver.countRecordByIdQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }

    @Override
    public List<Role> checkAllRecordQuery(int limit, int offset) throws CommandException {
        List<Role> listRole;
        try {
            listRole = receiver.checkAllRecordQuery(limit, offset);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listRole;
    }

    @Override
    public List<Role> checkRecordByIdQuery(long id, int limit, int offset) throws CommandException {
        List<Role> listRole;
        try {
            listRole = receiver.checkRecordByIdQuery(id, limit, offset);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listRole;
    }
}
