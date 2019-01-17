package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

/**
 * The Class DepartmentPaginateSelector.
 */
public class DepartmentPaginateSelector implements PaginationDataSelector<Department> {
    
    /** The pagination. */
    private final PaginationData pagination = PaginationDataFactory.getInstance().getDepartmentPagination();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginate(java.util.Map)
     */
    @Override
    public List<Department> paginate(Map<String, String> requestParam) throws SelectorException {
        List<Department> departmentList;
        try {
            departmentList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return departmentList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginateById(java.util.Map, long)
     */
    @Override
    public List<Department> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<Department> departmentList;
        try {
            departmentList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return departmentList;
    }
}
