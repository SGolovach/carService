package by.htp.carservice.service;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;

import java.util.List;

public interface QueryServiceUser extends QueryService<User> {
    List<User> checkLoginQuery(String login, String password) throws CommandException;

    boolean existLoginQuery(String login) throws CommandException;
}
