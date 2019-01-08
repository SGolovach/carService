package by.htp.carservice.transaction;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public interface Query<T extends Entity> {

    boolean saveQuery(T entity) throws ServiceException;

    boolean updateQuery(T entity) throws ServiceException;

    boolean deleteQuery(T entity) throws ServiceException;

    T takeQuery(long id) throws ServiceException;

    List<T> takeAllQuery() throws ServiceException;

    int countRecordQuery() throws ServiceException;

    int countRecordByIdQuery(long id) throws ServiceException;

    List<T> checkAllRecordQuery(int limit, int offset) throws ServiceException;

    List<T> checkRecordByIdQuery(long id, int limit, int offset) throws ServiceException;
}
