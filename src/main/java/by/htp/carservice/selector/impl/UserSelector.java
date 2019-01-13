package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorUser;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionUser;

import java.util.List;

public class UserSelector implements SelectorUser {
    private final TransactionUser transactionUser =
            TransactionFactory.getInstance().getTransactionUser();

    @Override
    public boolean save(User entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUser.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean update(User entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUser.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean delete(User entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUser.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public User take(long id) throws SelectorException {
        User user;
        try {
            user = transactionUser.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return user;
    }

    @Override
    public List<User> takeAll() throws SelectorException {
        List<User> listUser;
        try {
            listUser = transactionUser.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listUser;
    }

    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionUser.countRecordTransaction();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public int countRecordById(long id) throws SelectorException {
        int result;
        try {
            result = transactionUser.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public List<User> checkAllRecord(int limit, int offset) throws SelectorException {
        List<User> listUser;
        try {
            listUser = transactionUser.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listUser;
    }

    @Override
    public List<User> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<User> listUser;
        try {
            listUser = transactionUser.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listUser;
    }

    @Override
    public List<User> checkLogin(String login, String password) throws SelectorException {
        List<User> listUser;
        try {
            listUser = transactionUser.checkLoginTransaction(login, password);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listUser;
    }

    @Override
    public boolean existLogin(String login) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUser.existLoginTransaction(login);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }
}
