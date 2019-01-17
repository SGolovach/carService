package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorUser;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionUser;

import java.util.List;

/**
 * The Class UserSelector.
 */
public class UserSelector implements SelectorUser {
    
    /** The transaction user. */
    private final TransactionUser transactionUser =
            TransactionFactory.getInstance().getTransactionUser();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#save(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#update(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#delete(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#take(long)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#takeAll()
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecord()
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecordById(long)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkAllRecord(int, int)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkRecordById(long, int, int)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.SelectorUser#checkLogin(java.lang.String, java.lang.String)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.SelectorUser#existLogin(java.lang.String)
     */
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
