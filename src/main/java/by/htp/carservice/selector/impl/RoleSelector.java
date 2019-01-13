package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorRole;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionRole;

import java.util.List;

public class RoleSelector implements SelectorRole {
    private final TransactionRole transactionRole =
            TransactionFactory.getInstance().getTransactionRole();

    @Override
    public boolean save(Role entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionRole.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean update(Role entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionRole.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean delete(Role entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionRole.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public Role take(long id) throws SelectorException {
        Role role;
        try {
            role = transactionRole.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return role;
    }

    @Override
    public List<Role> takeAll() throws SelectorException {
        List<Role> listRole;
        try {
            listRole = transactionRole.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listRole;
    }

    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionRole.countRecordTransaction();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public int countRecordById(long id) throws SelectorException {
        int result;
        try {
            result = transactionRole.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public List<Role> checkAllRecord(int limit, int offset) throws SelectorException {
        List<Role> listRole;
        try {
            listRole = transactionRole.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listRole;
    }

    @Override
    public List<Role> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<Role> listRole;
        try {
            listRole = transactionRole.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listRole;
    }
}
