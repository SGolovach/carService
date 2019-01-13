package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorUserDetail;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionUserDetail;

import java.util.List;

public class UserDetailSelector implements SelectorUserDetail {
    private final TransactionUserDetail transactionUserDetail =
            TransactionFactory.getInstance().getTransactionUserDetail();

    @Override
    public boolean save(UserDetail entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUserDetail.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean update(UserDetail entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUserDetail.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean delete(UserDetail entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUserDetail.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public UserDetail take(long id) throws SelectorException {
        UserDetail userDetail;
        try {
            userDetail = transactionUserDetail.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return userDetail;
    }

    @Override
    public List<UserDetail> takeAll() throws SelectorException {
        List<UserDetail> listUserDetail;
        try {
            listUserDetail = transactionUserDetail.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listUserDetail;
    }

    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionUserDetail.countRecordTransaction();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public int countRecordById(long id) throws SelectorException {
        int result;
        try {
            result = transactionUserDetail.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public List<UserDetail> checkAllRecord(int limit, int offset) throws SelectorException {
        List<UserDetail> listUserDetail;
        try {
            listUserDetail = transactionUserDetail.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listUserDetail;
    }

    @Override
    public List<UserDetail> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<UserDetail> listUserDetail;
        try {
            listUserDetail = transactionUserDetail.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listUserDetail;
    }

    @Override
    public boolean checkRecord(long userId) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionUserDetail.checkRecordTransaction(userId);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }
}
