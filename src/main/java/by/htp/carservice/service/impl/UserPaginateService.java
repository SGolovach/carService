package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class UserPaginateService implements PaginationDataService<User> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getUserPagination();

    @Override
    public List<User> paginate(Map<String, String> requestParam) throws CommandException {
        List<User> userList;
        try {
            userList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return userList;
    }

    @Override
    public List<User> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<User> userList;
        try {
            userList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return userList;
    }
}
