package by.htp.carservice.transaction;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public interface Transaction<T extends Entity> {

    boolean saveTransaction(T entity) throws ServiceException;

    boolean updateTransaction(T entity) throws ServiceException;

    boolean deleteTransaction(T entity) throws ServiceException;

    T takeTransaction(long id) throws ServiceException;

    List<T> takeAllQuery() throws ServiceException;

    int countRecordTransaction() throws ServiceException;

    int countRecordByIdTransaction(long id) throws ServiceException;

    List<T> checkAllRecordTransaction(int limit, int offset) throws ServiceException;

    List<T> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException;
}
