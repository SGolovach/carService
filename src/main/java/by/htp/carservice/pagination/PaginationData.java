package by.htp.carservice.pagination;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * The Interface PaginationData.
 *
 * @param <T> the generic type
 */
public interface PaginationData<T extends Entity> {

    /**
     * Paginate.
     *
     * @param requestParam the request param
     * @return the list
     * @throws ServiceException the service exception
     */
    List<T> paginate(Map<String,String> requestParam) throws ServiceException;

    /**
     * Paginate by id.
     *
     * @param requestParam the request param
     * @param id the id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<T> paginateById(Map<String,String> requestParam,long id) throws ServiceException;

}
