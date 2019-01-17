package by.htp.carservice.transaction;

import by.htp.carservice.transaction.imlp.*;

/**
 * A factory for creating Transaction objects.
 */
public class TransactionFactory {
    
    /** The car transaction. */
    private final TransactionCar carTransaction = new CarTransactionImpl();
    
    /** The comment transaction. */
    private final TransactionComment commentTransaction = new CommentTransactionImpl();
    
    /** The department transaction. */
    private final TransactionDepartment departmentTransaction = new DepartmentTransactionImpl();
    
    /** The invoice transaction. */
    private final TransactionInvoice invoiceTransaction = new InvoiceTransactionImpl();
    
    /** The order transaction. */
    private final TransactionOrder orderTransaction = new OrderTransactionImpl();
    
    /** The role transaction. */
    private final TransactionRole roleTransaction = new RoleTransactionImpl();
    
    /** The user detail transaction. */
    private final TransactionUserDetail userDetailTransaction = new UserDetailTransactionImpl();
    
    /** The user transaction. */
    private final TransactionUser userTransaction = new UserTransactionImpl();

    /**
     * The Class QueryReceiverFactoryHolder.
     */
    private static class QueryReceiverFactoryHolder {
        
        /** The Constant INSTANCE. */
        private static final TransactionFactory INSTANCE = new TransactionFactory();
    }

    /**
     * Gets the single instance of TransactionFactory.
     *
     * @return single instance of TransactionFactory
     */
    public static TransactionFactory getInstance() {
        return QueryReceiverFactoryHolder.INSTANCE;
    }

    /**
     * Gets the transaction car.
     *
     * @return the transaction car
     */
    public TransactionCar getTransactionCar() {
        return carTransaction;
    }

    /**
     * Gets the transaction comment.
     *
     * @return the transaction comment
     */
    public TransactionComment getTransactionComment() {
        return commentTransaction;
    }

    /**
     * Gets the transaction department.
     *
     * @return the transaction department
     */
    public TransactionDepartment getTransactionDepartment() {
        return departmentTransaction;
    }

    /**
     * Gets the transaction invoice.
     *
     * @return the transaction invoice
     */
    public TransactionInvoice getTransactionInvoice() {
        return invoiceTransaction;
    }

    /**
     * Gets the transaction order.
     *
     * @return the transaction order
     */
    public TransactionOrder getTransactionOrder() {
        return orderTransaction;
    }

    /**
     * Gets the transaction role.
     *
     * @return the transaction role
     */
    public TransactionRole getTransactionRole() {
        return roleTransaction;
    }

    /**
     * Gets the transaction user detail.
     *
     * @return the transaction user detail
     */
    public TransactionUserDetail getTransactionUserDetail() {
        return userDetailTransaction;
    }

    /**
     * Gets the transaction user.
     *
     * @return the transaction user
     */
    public TransactionUser getTransactionUser() {
        return userTransaction;
    }
}
