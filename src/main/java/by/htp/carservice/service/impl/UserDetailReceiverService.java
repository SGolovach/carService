package by.htp.carservice.service.impl;

import by.htp.carservice.dao.QueryReceiver;
import by.htp.carservice.dao.QueryReceiverFactory;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class UserDetailReceiverService implements QueryReceiverService<UserDetail> {
    private final QueryReceiver<UserDetail> receiver =
            QueryReceiverFactory.getInstance().getUserDetailQueryReceiver();

    @Override
    public boolean saveQuery(UserDetail entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean updateQuery(UserDetail entity) throws ProjectException {
        return false;
    }

    @Override
    public boolean deleteQuery(UserDetail entity) throws ProjectException {
        return false;
    }

    @Override
    public UserDetail takeQuery(long id) throws ProjectException {
        return null;
    }

    @Override
    public List<UserDetail> takeAllQuery() throws ProjectException {
        return null;
    }
}
