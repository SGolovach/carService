package by.htp.carservice.selector;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.SelectorException;

import java.util.List;

/**
 * The Interface Selector.
 *
 * @param <T> the generic type
 */
public interface Selector<T extends Entity> {

    /**
     * Save.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws SelectorException the selector exception
     */
    boolean save(T entity) throws SelectorException;

    /**
     * Update.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws SelectorException the selector exception
     */
    boolean update(T entity) throws SelectorException;

    /**
     * Delete.
     *
     * @param entity the entity
     * @return true, if successful
     * @throws SelectorException the selector exception
     */
    boolean delete(T entity) throws SelectorException;

    /**
     * Take.
     *
     * @param id the id
     * @return the t
     * @throws SelectorException the selector exception
     */
    T take(long id) throws SelectorException;

    /**
     * Take all.
     *
     * @return the list
     * @throws SelectorException the selector exception
     */
    List<T> takeAll() throws SelectorException;

    /**
     * Count record.
     *
     * @return the int
     * @throws SelectorException the selector exception
     */
    int countRecord() throws SelectorException;

    /**
     * Count record by id.
     *
     * @param id the id
     * @return the int
     * @throws SelectorException the selector exception
     */
    int countRecordById(long id) throws SelectorException;

    /**
     * Check all record.
     *
     * @param limit the limit
     * @param offset the offset
     * @return the list
     * @throws SelectorException the selector exception
     */
    List<T> checkAllRecord(int limit, int offset) throws SelectorException;

    /**
     * Check record by id.
     *
     * @param id the id
     * @param limit the limit
     * @param offset the offset
     * @return the list
     * @throws SelectorException the selector exception
     */
    List<T> checkRecordById(long id, int limit, int offset) throws SelectorException;
}
