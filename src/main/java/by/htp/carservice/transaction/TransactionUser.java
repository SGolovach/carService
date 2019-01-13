package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public interface TransactionUser extends Transaction<User> {
    List<User> checkLoginTransaction(String login, String password) throws ServiceException;

    boolean existLoginTransaction(String login) throws ServiceException;
}
