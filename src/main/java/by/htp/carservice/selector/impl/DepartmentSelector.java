package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorDepartment;
import by.htp.carservice.transaction.TransactionDepartment;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

/**
 * The Class DepartmentSelector.
 */
public class DepartmentSelector implements SelectorDepartment {
    
    /** The transaction department. */
    private final TransactionDepartment transactionDepartment =
            TransactionFactory.getInstance().getTransactionDepartment();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#save(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean save(Department entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionDepartment.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#update(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean update(Department entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionDepartment.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#delete(by.htp.carservice.entity.Entity)
     */
    @Override
    public boolean delete(Department entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionDepartment.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#take(long)
     */
    @Override
    public Department take(long id) throws SelectorException {
        Department department;
        try {
            department = transactionDepartment.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return department;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#takeAll()
     */
    @Override
    public List<Department> takeAll() throws SelectorException {
        List<Department> listDepartment;
        try {
            listDepartment = transactionDepartment.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listDepartment;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecord()
     */
    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionDepartment.countRecordTransaction();
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
            result = transactionDepartment.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkAllRecord(int, int)
     */
    @Override
    public List<Department> checkAllRecord(int limit, int offset) throws SelectorException {
        List<Department> listDepartment;
        try {
            listDepartment = transactionDepartment.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listDepartment;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkRecordById(long, int, int)
     */
    @Override
    public List<Department> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<Department> listDepartment;
        try {
            listDepartment = transactionDepartment.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listDepartment;
    }
}
