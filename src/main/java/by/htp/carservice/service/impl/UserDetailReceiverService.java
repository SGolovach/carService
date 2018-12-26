package by.htp.carservice.service.impl;

import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class UserDetailReceiverService implements QueryReceiverService<UserDetail> {
    private final QueryReceiver<UserDetail> receiver =
            QueryReceiverFactory.getInstance().getUserDetailQueryReceiver();

    @Override
    public boolean saveQuery(UserDetail entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(UserDetail entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(UserDetail entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public UserDetail takeQuery(long id) throws ProjectException {
        UserDetail userDetail;
        try {
            userDetail = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return userDetail;
    }

    @Override
    public List<UserDetail> takeAllQuery(String condition) throws ProjectException {
        List<UserDetail> listUserDetail;
        try {
            listUserDetail = receiver.takeAllQuery(condition);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return listUserDetail;
    }
}
