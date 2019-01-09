package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class UserDetailPaginateService implements PaginationDataService<UserDetail> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getUserDetailPagination();

    @Override
    public List<UserDetail> paginate(Map<String, String> requestParam) throws CommandException {
        List<UserDetail> userDetailList;
        try {
            userDetailList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return userDetailList;
    }

    @Override
    public List<UserDetail> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<UserDetail> userDetailList;
        try {
            userDetailList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return userDetailList;
    }
}
