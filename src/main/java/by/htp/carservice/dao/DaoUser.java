package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.DaoException;

import java.util.List;

public interface DaoUser extends BaseDao<User> {
    List<User> checkLogin(String login,String password) throws DaoException;
}
