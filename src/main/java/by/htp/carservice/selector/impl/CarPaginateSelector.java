package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

/**
 * The Class CarPaginateSelector.
 */
public class CarPaginateSelector implements PaginationDataSelector<Car> {
    
    /** The pagination. */
    private final PaginationData pagination = PaginationDataFactory.getInstance().getCarPagination();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginate(java.util.Map)
     */
    @Override
    public List<Car> paginate(Map<String, String> requestParam) throws SelectorException {
        List<Car> carList;
        try {
            carList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return carList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.PaginationDataSelector#paginateById(java.util.Map, long)
     */
    @Override
    public List<Car> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<Car> carList;
        try {
            carList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return carList;
    }
}
