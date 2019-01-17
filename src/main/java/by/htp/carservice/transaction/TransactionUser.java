package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

/**
 * The Interface TransactionUser.
 */
public interface TransactionUser extends Transaction<User> {
    
    /**
     * Check login transaction.
     *
     * @param login the login
     * @param password the password
     * @return the list
     * @throws ServiceException the service exception
     */
    List<User> checkLoginTransaction(String login, String password) throws ServiceException;

    /**
     * Exist login transaction.
     *
     * @param login the login
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean existLoginTransaction(String login) throws ServiceException;
}
