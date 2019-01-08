package by.htp.carservice.service;

import by.htp.carservice.entity.Entity;
import by.htp.carservice.exception.CommandException;

import java.util.List;
import java.util.Map;

public interface PaginationDataService<T extends Entity> {

    List<T> paginate(Map<String, String> requestParam) throws CommandException;

    List<T> paginateById(Map<String, String> requestParam, long id) throws CommandException;

}
