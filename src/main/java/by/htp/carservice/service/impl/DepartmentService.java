package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryServiceDepartment;
import by.htp.carservice.transaction.QueryDepartment;
import by.htp.carservice.transaction.QueryFactory;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public class DepartmentService implements QueryServiceDepartment {
    private final QueryDepartment receiver =
            QueryFactory.getInstance().getDepartmentQuery();

    @Override
    public boolean saveQuery(Department entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Department entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Department entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public Department takeQuery(long id) throws CommandException {
        Department department;
        try {
            department = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return department;
    }

    @Override
    public List<Department> takeAllQuery() throws CommandException {
        List<Department> listDepartment;
        try {
            listDepartment = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listDepartment;
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
    public List<Department> checkAllRecordQuery(int limit, int offset) throws CommandException {
        List<Department> listDepartment;
        try {
            listDepartment = receiver.checkAllRecordQuery(limit, offset);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listDepartment;
    }

    @Override
    public List<Department> checkRecordByIdQuery(long id, int limit, int offset) throws CommandException {
        List<Department> listDepartment;
        try {
            listDepartment = receiver.checkRecordByIdQuery(id, limit, offset);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listDepartment;
    }
}
