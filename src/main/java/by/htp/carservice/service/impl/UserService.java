package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryServiceUser;
import by.htp.carservice.transaction.QueryFactory;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.QueryUser;

import java.util.List;

public class UserService implements QueryServiceUser {
    private final QueryUser receiver =
            QueryFactory.getInstance().getUserQuery();

    @Override
    public boolean saveQuery(User entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(User entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(User entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public User takeQuery(long id) throws CommandException {
        User user;
        try {
            user = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return user;
    }

    @Override
    public List<User> takeAllQuery() throws CommandException {
        List<User> listUser;
        try {
            listUser = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listUser;
    }

    @Override
    public List<User> checkLoginQuery(String login,String password) throws CommandException {
        List<User> listUser;
        try {
            listUser = receiver.checkLoginQuery(login,password);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listUser;
    }

    @Override
    public boolean existLoginQuery(String login) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.existLoginQuery(login);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }
}
