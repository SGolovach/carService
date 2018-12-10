package by.htp.carservice.dao;

import java.util.List;

public interface BaseDao<T> {

    boolean save(T entity);

    boolean update(T entity);

    boolean delete(T entity);

    T take(long id);

    List<T> takeAll(String condition);

}
