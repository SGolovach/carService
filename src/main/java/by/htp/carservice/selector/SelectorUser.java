package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;

import java.util.List;

public interface SelectorUser extends Selector<User> {
    List<User> checkLogin(String login, String password) throws SelectorException;

    boolean existLogin(String login) throws SelectorException;
}
