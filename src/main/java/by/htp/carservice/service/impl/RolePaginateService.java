package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class RolePaginateService implements PaginationDataService<Role> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getRolePagination();

    @Override
    public List<Role> paginate(Map<String, String> requestParam) throws CommandException {
        List<Role> roleList;
        try {
            roleList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return roleList;
    }

    @Override
    public List<Role> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<Role> roleList;
        try {
            roleList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return roleList;
    }
}
