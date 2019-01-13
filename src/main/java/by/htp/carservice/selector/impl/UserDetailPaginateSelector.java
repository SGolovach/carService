package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

public class UserDetailPaginateSelector implements PaginationDataSelector<UserDetail> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getUserDetailPagination();

    @Override
    public List<UserDetail> paginate(Map<String, String> requestParam) throws SelectorException {
        List<UserDetail> userDetailList;
        try {
            userDetailList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return userDetailList;
    }

    @Override
    public List<UserDetail> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<UserDetail> userDetailList;
        try {
            userDetailList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return userDetailList;
    }
}
