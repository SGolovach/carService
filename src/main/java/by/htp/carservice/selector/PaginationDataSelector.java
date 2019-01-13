package by.htp.carservice.selector;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.SelectorException;

import java.util.List;
import java.util.Map;

public interface PaginationDataSelector<T extends Entity> {

    List<T> paginate(Map<String, String> requestParam) throws SelectorException;

    List<T> paginateById(Map<String, String> requestParam, long id) throws SelectorException;

}
