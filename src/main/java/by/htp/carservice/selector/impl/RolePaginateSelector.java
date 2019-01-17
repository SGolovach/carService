package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

/**
 * The Class RolePaginateSelector.
 */
public class RolePaginateSelector implements PaginationDataSelector<Role> {
    
    /** The pagination. */
    private final PaginationData pagination = PaginationDataFactory.getInstance().getRolePagination();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginate(java.util.Map)
     */
    @Override
    public List<Role> paginate(Map<String, String> requestParam) throws SelectorException {
        List<Role> roleList;
        try {
            roleList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return roleList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginateById(java.util.Map, long)
     */
    @Override
    public List<Role> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<Role> roleList;
        try {
            roleList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return roleList;
    }
}
