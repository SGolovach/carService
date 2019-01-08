package by.htp.carservice.service;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.CommandException;

import java.util.List;

public interface QueryService<T extends Entity> {

    boolean saveQuery(T entity) throws CommandException;

    boolean updateQuery(T entity) throws CommandException;

    boolean deleteQuery(T entity) throws CommandException;

    T takeQuery(long id) throws CommandException;

    List<T> takeAllQuery() throws CommandException;

    int countRecordQuery() throws CommandException;

    int countRecordByIdQuery(long id) throws CommandException;

    List<T> checkAllRecordQuery(int limit, int offset) throws CommandException;

    List<T> checkRecordByIdQuery(long id, int limit, int offset) throws CommandException;
}
