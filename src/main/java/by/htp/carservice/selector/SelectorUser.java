package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;

import java.util.List;

/**
 * The Interface SelectorUser.
 */
public interface SelectorUser extends Selector<User> {
    
    /**
     * Check login.
     *
     * @param login the login
     * @param password the password
     * @return the list
     * @throws SelectorException the selector exception
     */
    List<User> checkLogin(String login, String password) throws SelectorException;

    /**
     * Exist login.
     *
     * @param login the login
     * @return true, if successful
     * @throws SelectorException the selector exception
     */
    boolean existLogin(String login) throws SelectorException;
}
