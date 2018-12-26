package by.htp.carservice.service.impl;

import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class UserReceiverService implements QueryReceiverService<User> {
    private final QueryReceiver<User> receiver =
            QueryReceiverFactory.getInstance().getUserQueryReceiver();

    @Override
    public boolean saveQuery(User entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(User entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(User entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public User takeQuery(long id) throws ProjectException {
        User user;
        try {
            user = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return user;
    }

    @Override
    public List<User> takeAllQuery(String condition) throws ProjectException {
        List<User> listUser;
        try {
            listUser = receiver.takeAllQuery(condition);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return listUser;
    }
}
