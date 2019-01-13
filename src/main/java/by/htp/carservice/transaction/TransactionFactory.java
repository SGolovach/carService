package by.htp.carservice.transaction;

import by.htp.carservice.transaction.imlp.*;

public class TransactionFactory {
    private final TransactionCar carTransaction = new CarTransactionImpl();
    private final TransactionComment commentTransaction = new CommentTransactionImpl();
    private final TransactionDepartment departmentTransaction = new DepartmentTransactionImpl();
    private final TransactionInvoice invoiceTransaction = new InvoiceTransactionImpl();
    private final TransactionOrder orderTransaction = new OrderTransactionImpl();
    private final TransactionRole roleTransaction = new RoleTransactionImpl();
    private final TransactionUserDetail userDetailTransaction = new UserDetailTransactionImpl();
    private final TransactionUser userTransaction = new UserTransactionImpl();

    private static class QueryReceiverFactoryHolder {
        private static final TransactionFactory INSTANCE = new TransactionFactory();
    }

    public static TransactionFactory getInstance() {
        return QueryReceiverFactoryHolder.INSTANCE;
    }

    public TransactionCar getTransactionCar() {
        return carTransaction;
    }

    public TransactionComment getTransactionComment() {
        return commentTransaction;
    }

    public TransactionDepartment getTransactionDepartment() {
        return departmentTransaction;
    }

    public TransactionInvoice getTransactionInvoice() {
        return invoiceTransaction;
    }

    public TransactionOrder getTransactionOrder() {
        return orderTransaction;
    }

    public TransactionRole getTransactionRole() {
        return roleTransaction;
    }

    public TransactionUserDetail getTransactionUserDetail() {
        return userDetailTransaction;
    }

    public TransactionUser getTransactionUser() {
        return userTransaction;
    }
}
