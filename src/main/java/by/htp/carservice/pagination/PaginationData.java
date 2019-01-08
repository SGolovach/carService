package by.htp.carservice.pagination;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface PaginationData<T extends Entity> {

    List<T> paginate(Map<String,String> requestParam) throws ServiceException;

    List<T> paginateById(Map<String,String> requestParam,long id) throws ServiceException;

}
