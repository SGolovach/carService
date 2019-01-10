package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.DaoException;

import java.util.List;

/**
 * The Interface DaoUser.
 */
public interface DaoUser extends BaseDao<User> {

    /**
     * Check login.
     *
     * @param login the login
     * @param password the password
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> checkLogin(String login,String password) throws DaoException;

    /**
     * Exist login.
     *
     * @param login the login
     * @return true, if successful
     * @throws DaoException the dao exception
     */
    boolean existLogin(String login) throws DaoException;

}
