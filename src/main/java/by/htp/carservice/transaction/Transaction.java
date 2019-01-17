package by.htp.carservice.transaction;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

/**
 * The Interface Transaction.
 *
 * @param <T> the generic type
 */
public interface Transaction<T extends Entity> {

    /**
     * Save transaction.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean saveTransaction(T entity) throws ServiceException;

    /**
     * Update transaction.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean updateTransaction(T entity) throws ServiceException;

    /**
     * Delete transaction.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean deleteTransaction(T entity) throws ServiceException;

    /**
     * Take transaction.
     *
     * @param id the id
     * @return the t
     * @throws ServiceException the service exception
     */
    T takeTransaction(long id) throws ServiceException;

    /**
     * Take all query.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<T> takeAllQuery() throws ServiceException;

    /**
     * Count record transaction.
     *
     * @return the int
     * @throws ServiceException the service exception
     */
    int countRecordTransaction() throws ServiceException;

    /**
     * Count record by id transaction.
     *
     * @param id the id
     * @return the int
     * @throws ServiceException the service exception
     */
    int countRecordByIdTransaction(long id) throws ServiceException;

    /**
     * Check all record transaction.
     *
     * @param limit the limit
     * @param offset the offset
     * @return the list
     * @throws ServiceException the service exception
     */
    List<T> checkAllRecordTransaction(int limit, int offset) throws ServiceException;

    /**
     * Check record by id transaction.
     *
     * @param id the id
     * @param limit the limit
     * @param offset the offset
     * @return the list
     * @throws ServiceException the service exception
     */
    List<T> checkRecordByIdTransaction(long id, int limit, int offset) throws ServiceException;
}
