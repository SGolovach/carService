package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryReceiverServiceUserDetail;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.QueryReceiverUserDetail;

import java.util.List;

public class UserDetailReceiverService implements QueryReceiverServiceUserDetail {
    private final QueryReceiverUserDetail receiver =
            QueryReceiverFactory.getInstance().getUserDetailQueryReceiver();

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
}
