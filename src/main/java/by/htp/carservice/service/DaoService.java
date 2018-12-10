package by.htp.carservice.service;

import java.util.List;

public interface DaoService<T> {
    boolean save(T entity);

    boolean update(T entity);

    boolean delete(T entity);

    T take(long id);

    List<T> takeAll(String condition);
}
