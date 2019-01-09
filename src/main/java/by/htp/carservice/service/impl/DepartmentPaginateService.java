package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class DepartmentPaginateService implements PaginationDataService<Department> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getDepartmentPagination();

    @Override
    public List<Department> paginate(Map<String, String> requestParam) throws CommandException {
        List<Department> departmentList;
        try {
            departmentList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return departmentList;
    }

    @Override
    public List<Department> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<Department> departmentList;
        try {
            departmentList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return departmentList;
    }
}
