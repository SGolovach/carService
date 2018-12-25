package by.htp.carservice.service.impl;

import by.htp.carservice.dao.QueryReceiver;
import by.htp.carservice.dao.QueryReceiverFactory;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class UserReceiverService implements QueryReceiverService<User> {
    private final QueryReceiver<User> receiver =
            QueryReceiverFactory.getInstance().getUserQueryReceiver();

    @Override
    public boolean saveQuery(User entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean updateQuery(User entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean deleteQuery(User entity) throws ProjectException {
        return false;
    }

    @Override
    public User takeQuery(long id) throws ProjectException {
        return null;
    }

    @Override
    public List<User> takeAllQuery() throws ProjectException {
        return null;
    }
}
