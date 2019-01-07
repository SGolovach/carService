package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryServiceUserDetail;
import by.htp.carservice.transaction.QueryFactory;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.QueryUserDetail;

import java.util.List;

public class UserDetailService implements QueryServiceUserDetail {
    private final QueryUserDetail receiver =
            QueryFactory.getInstance().getUserDetailQuery();

    @Override
    public boolean saveQuery(UserDetail entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(UserDetail entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(UserDetail entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public UserDetail takeQuery(long id) throws CommandException {
        UserDetail userDetail;
        try {
            userDetail = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return userDetail;
    }

    @Override
    public List<UserDetail> takeAllQuery() throws CommandException {
        List<UserDetail> listUserDetail;
        try {
            listUserDetail = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listUserDetail;
    }

    @Override
    public boolean checkRecordQuery(long userId) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.checkRecordQuery(userId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }
}
