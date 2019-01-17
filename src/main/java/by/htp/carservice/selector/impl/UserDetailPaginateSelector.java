package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

/**
 * The Class UserDetailPaginateSelector.
 */
public class UserDetailPaginateSelector implements PaginationDataSelector<UserDetail> {
    
    /** The pagination. */
    private final PaginationData pagination = PaginationDataFactory.getInstance().getUserDetailPagination();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginate(java.util.Map)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginateById(java.util.Map, long)
     */
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
