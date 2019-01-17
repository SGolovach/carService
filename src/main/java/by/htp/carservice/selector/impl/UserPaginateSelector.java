package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

/**
 * The Class UserPaginateSelector.
 */
public class UserPaginateSelector implements PaginationDataSelector<User> {
    
    /** The pagination. */
    private final PaginationData pagination = PaginationDataFactory.getInstance().getUserPagination();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginate(java.util.Map)
     */
    @Override
    public List<User> paginate(Map<String, String> requestParam) throws SelectorException {
        List<User> userList;
        try {
            userList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return userList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginateById(java.util.Map, long)
     */
    @Override
    public List<User> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<User> userList;
        try {
            userList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return userList;
    }
}
