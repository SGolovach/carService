package by.htp.carservice.dao;

import by.htp.carservice.exception.DaoException;

import java.util.List;

/**
 * The Interface BaseDao.
 *
 * @param <T> the generic type
 */
public interface BaseDao<T> {

    /**
     * Save.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws DaoException the dao exception
     */
    boolean save(T entity) throws DaoException;

    /**
     * Update.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws DaoException the dao exception
     */
    boolean update(T entity) throws DaoException;

    /**
     * Delete.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws DaoException the dao exception
     */
    boolean delete(T entity) throws DaoException;

    /**
     * Take.
     *
     * @param id the id
     * @return the t
     * @throws DaoException the dao exception
     */
    T take(long id) throws DaoException;

    /**
     * Take all.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> takeAll() throws DaoException;

    /**
     * Count record.
     *
     * @return the int
     * @throws DaoException the dao exception
     */
    int countRecord() throws DaoException;

    /**
     * Count record by id.
     *
     * @param id the id
     * @return the int
     * @throws DaoException the dao exception
     */
    int countRecordById(long id) throws DaoException;

    /**
     * Check all record.
     *
     * @param limit the limit
     * @param offset the offset
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> checkAllRecord(int limit, int offset) throws DaoException;

    /**
     * Check record by id.
     *
     * @param id the id
     * @param limit the limit
     * @param offset the offset
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> checkRecordById(long id, int limit, int offset) throws DaoException;

}
