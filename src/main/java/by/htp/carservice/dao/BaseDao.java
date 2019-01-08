package by.htp.carservice.dao;

import by.htp.carservice.exception.DaoException;

import java.util.List;

public interface BaseDao<T> {

    boolean save(T entity) throws DaoException;

    boolean update(T entity) throws DaoException;

    boolean delete(T entity) throws DaoException;

    T take(long id) throws DaoException;

    List<T> takeAll() throws DaoException;

    int countRecord() throws DaoException;

    int countRecordById(long id) throws DaoException;

    List<T> checkAllRecord(int limit, int offset) throws DaoException;

    List<T> checkRecordById(long id, int limit, int offset) throws DaoException;

}
