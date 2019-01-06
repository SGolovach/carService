package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public interface QueryReceiverUser extends QueryReceiver<User> {
    List<User> checkLoginQuery(String login, String password) throws ServiceException;

    boolean existLoginQuery(String login) throws ServiceException;
}
