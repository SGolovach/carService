package by.htp.carservice.service;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.ProjectException;

import java.util.List;

public interface QueryReceiverService<T extends Entity> {

    boolean saveQuery(T entity) throws ProjectException;

    boolean updateQuery(T entity) throws ProjectException;

    boolean deleteQuery(T entity) throws ProjectException;

    T takeQuery(long id) throws ProjectException;

    List<T> takeAllQuery() throws ProjectException;
}
