package by.htp.carservice.selector;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.SelectorException;

import java.util.List;
import java.util.Map;

/**
 * The Interface PaginationDataSelector.
 *
 * @param <T> the generic type
 */
public interface PaginationDataSelector<T extends Entity> {

    /**
     * Paginate.
     *
     * @param requestParam the request param
     * @return the list
     * @throws SelectorException the selector exception
     */
    List<T> paginate(Map<String, String> requestParam) throws SelectorException;

    /**
     * Paginate by id.
     *
     * @param requestParam the request param
     * @param id the id
     * @return the list
     * @throws SelectorException the selector exception
     */
    List<T> paginateById(Map<String, String> requestParam, long id) throws SelectorException;

}
