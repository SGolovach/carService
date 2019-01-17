package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorRole;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionRole;

import java.util.List;

/**
 * The Class RoleSelector.
 */
public class RoleSelector implements SelectorRole {
    
    /** The transaction role. */
    private final TransactionRole transactionRole =
            TransactionFactory.getInstance().getTransactionRole();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#save(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#update(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#delete(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#take(long)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#takeAll()
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecord()
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecordById(long)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkAllRecord(int, int)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkRecordById(long, int, int)
     */
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
