package by.htp.carservice.selector;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.SelectorException;

import java.util.List;

public interface Selector<T extends Entity> {

    boolean save(T entity) throws SelectorException;

    boolean update(T entity) throws SelectorException;

    boolean delete(T entity) throws SelectorException;

    T take(long id) throws SelectorException;

    List<T> takeAll() throws SelectorException;

    int countRecord() throws SelectorException;

    int countRecordById(long id) throws SelectorException;

    List<T> checkAllRecord(int limit, int offset) throws SelectorException;

    List<T> checkRecordById(long id, int limit, int offset) throws SelectorException;
}
